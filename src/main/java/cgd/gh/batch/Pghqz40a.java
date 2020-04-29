package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
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
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hs.common.constants.Bhsk0002 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.hg.structures.link.Bhgl030a ;
import cgd.hg.structures.link.Bhgl004a ;
import cgd.hg.structures.link.Bhgl007a ;
import cgd.hs.structures.link.Bhsl110a ;
import cgd.ho.structures.work.Bhow0023 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr0271 ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.ht.routines.Mhtq200a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hs.routines.Mhsj110a ;
import cgd.hg.routines.Mhgj004a ;
import cgd.hg.routines.Mhgj007a ;
import cgd.hy.routines.Mhyj230a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * ************ INPUT
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE INPUT
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE OUTPUT
 * WORKING-STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghqz40a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdhops00201Subcontas
     */
    @Data
    protected abstract Vwsdhops00201Subcontas hv00201Subcontas() ;
    
    
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
     * @return instancia da classe Fwk026
     */
    @Handler(name="FWK026", record="regFwk026")
    @Data
    protected abstract Fwk026 ficheiroFwk026() ;
    
    /**
     * @return instancia da classe Fgh027
     */
    @Handler(name="FGH027", record="regFgh027500")
    @Data
    protected abstract Fgh027 ficheiroFgh027() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Mhsj110a
     */
    @Data
    protected abstract Mhsj110a hrMhsj110a() ;
    
    /**
     * @return instancia da classe Mhgj004a
     */
    @Data
    protected abstract Mhgj004a hrMhgj004a() ;
    
    /**
     * @return instancia da classe Mhgj007a
     */
    @Data
    protected abstract Mhgj007a hrMhgj007a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhsk0002
     */
    @Data
    protected abstract Bhsk0002 bhsk0002() ;
    
    /**
     * @return instancia da classe Bhtl200a
     */
    @Data
    protected abstract Bhtl200a bhtl200a() ;
    
    /**
     * @return instancia da classe Bhgl030a
     */
    @Data
    protected abstract Bhgl030a bhgl030a() ;
    
    /**
     * @return instancia da classe Bhgl004a
     */
    @Data
    protected abstract Bhgl004a bhgl004a() ;
    
    /**
     * @return instancia da classe Bhgl007a
     */
    @Data
    protected abstract Bhgl007a bhgl007a() ;
    
    /**
     * @return instancia da classe Bhsl110a
     */
    @Data
    protected abstract Bhsl110a bhsl110a() ;
    
    /**
     * @return instancia da classe Bhow0023
     */
    @Data
    protected abstract Bhow0023 bhow0023() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghr0271
     */
    @Data
    protected abstract Bghr0271 bghr0271() ;
    
    /**
     * @return instancia da classe Bhok0001
     */
    @Data
    protected abstract Bhok0001 bhok0001() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe local Bhok0005Pghqz40a
     */
    @Data
    protected abstract Bhok0005Pghqz40a bhok0005() ;
    
    /**
     * - DB2
     */
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_INSERT = "IN" ;
    
    protected static final String CON_UPDATE = "UP" ;
    
    protected static final String CON_DELETE = "DL" ;
    
    /**
     * - FICHEIROS
     */
    protected static final String CON_OPEN_INPUT = "OI" ;
    
    protected static final String CON_OPEN_OUTPUT = "OO" ;
    
    protected static final String CON_READ = "RE" ;
    
    protected static final String CON_WRITE = "WR" ;
    
    protected static final String CON_CLOSE_FI = "CF" ;
    
    protected static final String CON_FWK026 = "FWK026" ;
    
    protected static final String CON_FGH027 = "FGH027" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_C_FAMI_PROD_400 = "400" ;
    
    protected static final String CON_C_PROD_DFLT_032 = "032" ;
    
    protected static final String CON_C_PROD_DFLT_038 = "038" ;
    
    protected static final String CON_SALDO = "S" ;
    
    protected static final String CON_ERRO_FWK026 = "ERRO FIC. FWK026" ;
    
    protected static final String CON_ERRO_FGH027 = "ERRO FIC. FGH027" ;
    
    /**
     * CONSTANTES CABECALHOS MAPAS EXCEL
     */
    protected static final String CON_VIRG = ";" ;
    
    protected static final String CON_D_MAPA_MHO943 = "MAPA MHO943 - CAIXAORDENADO E MESADA CERTA              " ;
    
    /**
     * - ROTINAS
     */
    protected static final String CON_ROTINA = "RO" ;
    
    protected static final String CON_MHZJ460A = "MHZJ460A" ;
    
    protected static final String CON_MHGJ007A = "MHGJ007A" ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_PROGRAMA = "PGHQZ40A" ;
    
    protected static final String CON_DESCRICAO = "LEGAL_REPORTE OPERAÇÕES LDN E MESADA CERTA        " ;
    
    /**
     * *HO25509-INICIO.
     */
    protected static final String CON_409 = "409" ;
    
    protected static final String CON_001 = "001" ;
    
    protected static final String CON_003 = "003" ;
    
    protected static final String CON_004 = "004" ;
    
    protected static final String CON_167 = "167" ;
    
    protected static final String CON_N = "N" ;
    
    protected static final int CON_C_REGIAO = 22 ;
    
    /**
     * *HO25509-FIM.
     */
    protected static final String CON_DEVEDOR = "DV" ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_1N = 1 ;
    
    /**
     * CONSTANTES PERIODO
     * DEFINICAO DE PERIODOS
     * @return instancia da classe local WsTabelaPeriodo
     */
    @Data
    protected abstract WsTabelaPeriodo wsTabelaPeriodo() ;
    
    /**
     * VARIAVEIS
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * VARIAVEIS PARA CONVERSAO EBCDIC
     */
    @Data(size=8, value="642", compression=COMP)
    protected ILong nbytes ;
    
    @Data(size=644)
    protected IString inputEbcdic ;
    
    /**
     * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
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
     * TABELA GERAIS - ACESSO A TABELAS GERAIS
     * 
     */
    protected void bhgp0030AcessoTabela() {
    }
    
    /**
     * 
     * ACESSO A ROTINA QUE VALIDA A RESTRICAO
     * DE ACESSO A CONTAS: MHSS110A
     * 
     */
    protected void bhsp0110ValRestAcesCt() {
        hrMhsj110a().run() ;
    }
    
    /**
     * 
     * BHOP0023
     * COPY PARA OBTENCAO DE DADOS DE BALCAO
     * 
     */
    protected void bhop0023ObtemBalcao() {
        bhow0023().areaComum().dadosOutput().initialize() ;
        bhow0023().areaComum().dadosInternos().tabelaBalcoes().resetIndex() ;
        while (bhow0023().areaComum().dadosInternos().tabelaBalcoes().index().isLessOrEqual(999)) {
            if (bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().pais().isEqual(bhow0023().areaComum().dadosInput().cPaisIsoAlfn()) && 
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().mnem().isEqual(bhow0023().areaComum().dadosInput().cMnemEmpGcx()) && 
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().oe().isEqual(bhow0023().areaComum().dadosInput().cOeEgc())) {
                bhow0023().areaComum().dadosOutput().nmOe().set(bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().balcao());
                bhow0023().areaComum().dadosOutput().nmOeAbvd().set(bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().balcaoAbvd());
                bhow0023().areaComum().dadosOutput().cIdioIso().set(bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().idioma());
                break;
            }
            if (bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().pais().isEmpty()) {
                bhop0023ObtemDados() ;
                break;
            }
            bhow0023().areaComum().dadosInternos().tabelaBalcoes().incIndex() ;
        }
        if (bhow0023().areaComum().dadosInternos().tabelaBalcoes().atEnd()) {
            bhop0023ObtemDados() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhop0023ObtemDados() {
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(bhow0023().areaComum().dadosInput().cMnemEmpGcx());
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(bhow0023().areaComum().dadosInput().cPaisIsoAlfn());
        bhgl004a().commarea().dadosInput().cOeEgc().set(bhow0023().areaComum().dadosInput().cOeEgc());
        bhgp0004RotDadosOe() ;
        if (!bhgl004a().commarea().dadosOutput().semErros().isTrue() && !bhgl004a().commarea().dadosOutput().erroFuncao().isTrue()) {
            bhow0023().areaComum().dadosOutput().cTipoErroBbn().set(bhgl004a().commarea().dadosOutput().cTipoErroBbn());
            bhow0023().areaComum().dadosOutput().cSqlcode().set(bhgl004a().commarea().dadosOutput().sqlca().cSqlcode());
            bhow0023().areaComum().dadosOutput().modOrigemErro().set(bhgk0002().rotDadosOe());
            bhow0023().areaComum().dadosOutput().chAcesso().set(bhgl004a().commarea().dadosInput());
            bhow0023().areaComum().dadosOutput().cRtnoEvenSwal().set(bhgl004a().commarea().dadosOutput().cRtnoEvenSwal());
            bhow0023().areaComum().dadosOutput().nmTabela().set(bhgl004a().commarea().dadosOutput().nmTabela());
            bhow0023().areaComum().dadosOutput().aAplErr().set(bhgl004a().commarea().dadosOutput().aAplErr());
        } else {
            if (bhgl004a().commarea().dadosOutput().erroFuncao().isTrue()) {
                bhgl004a().commarea().dadosOutput().nmOe().set(" ");
                bhgl004a().commarea().dadosOutput().nmOeAbvd().set(" ");
            }
            if (bhow0023().areaComum().dadosInternos().tabelaBalcoes().index().isLessOrEqual(999)) {
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().pais().set(bhow0023().areaComum().dadosInput().cPaisIsoAlfn());
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().mnem().set(bhow0023().areaComum().dadosInput().cMnemEmpGcx());
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().oe().set(bhow0023().areaComum().dadosInput().cOeEgc());
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().balcao().set(bhgl004a().commarea().dadosOutput().nmOe());
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().balcaoAbvd().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
                bhow0023().areaComum().dadosInternos().tabelaBalcoes().getCurrent().idioma().set(bhgl004a().commarea().dadosOutput().cIdioIso());
            }
            bhow0023().areaComum().dadosOutput().nmOe().set(bhgl004a().commarea().dadosOutput().nmOe());
            bhow0023().areaComum().dadosOutput().nmOeAbvd().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
            bhow0023().areaComum().dadosOutput().cIdioIso().set(bhgl004a().commarea().dadosOutput().cIdioIso());
        }
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DO ORGAO DE ESTRUTURA
     * MHGJ004A
     * 
     */
    protected void bhgp0004RotDadosOe() {
    }
    
    /**
     * 
     * BHGP0007-ACESSO A ROTINA DE CONSULTA EM LISTA QUE DEVOLVE
     * OS OE'S FILHOS DE UM OE PAI INDICADO
     * (MHGJ007A)
     * 
     */
    protected void bhgp0007AcedeMhgj007a() {
        hrMhgj007a().run() ;
    }
    
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
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (ficheiroFwk026().getStatusOk()) {
            m2000ProcessoPrograma() ;
        }
        m3000ExitPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100IniciaVariaveis() ;
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        m8000DataHoraIni() ;
        bhop0013InicioEstat() ;
        bhtp0011ObtemDados() ;
        m1200AbreFicheiros() ;
        m1300ObtemDatasApli() ;
        m1400LeFichFwk026() ;
    }
    
    /**
     * 
     * 1100-INICIA-VARIAVEIS
     * LIMPA E INICIALIZA AREAS INICIAIS DESTE PROCESSAMENTO
     * 
     */
    protected void m1100IniciaVariaveis() {
        log(TraceLevel.Debug, "1100-INICIA-VARIAVEIS");
        wsVariaveis().initialize() ;
        bhtl200a().commarea().initialize() ;
        bghr0271().registo().initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
    }
    
    /**
     * 
     * ABERTURA DOS FICHEIROS
     * 
     */
    protected void m1200AbreFicheiros() {
        log(TraceLevel.Debug, "1200-ABRE-FICHEIROS");
        ficheiroFwk026().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK026);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk026().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk026().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
        /**
         * FICHEIRO OUTPUT
         */
        ficheiroFgh027().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH027);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh027().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh027().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
    }
    
    /**
     * 
     * 1300-OBTEM-DATAS-APLI
     * 
     */
    protected void m1300ObtemDatasApli() {
        log(TraceLevel.Debug, "1250-OBTEM-DATA-APLIC");
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
     * 1400-LE-FICH-FWK026
     * 
     */
    protected void m1400LeFichFwk026() {
        log(TraceLevel.Debug, "1400-LE-FICH-FWK026");
        ficheiroFwk026().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK026);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk026().getStatus());
        bhop0013FormataAcesso() ;
        /**
         * FORMATA REGISTO ENCONTRADO
         */
        if (!ficheiroFwk026().getStatusOk()) {
            if (!ficheiroFwk026().getStatusOk()) {
                m9700ErroFicheiro() ;
            }
        }
    }
    
    /**
     * 
     * 1700-ESCREVE-FGH027
     * 
     */
    protected void m1700EscreveFgh027() {
        log(TraceLevel.Debug, "1700-ESCREVE-FGH027");
        ficheiroFgh027().write(ficheiroFgh027().regFgh027500) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH027);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh027().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh027().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "BGHW8026-CONTA:", ficheiroFwk026().regFwk026().conta());
        /**
         * SET IND-PER                     TO 1.
         * MOVE 1                          TO WS-IND-PER.
         */
        if (swSwitches().swSysin().swPeriodo().isEqual(0)) {
            bhtw0030().dadosEntrada().rotErroFuncao().setTrue() ;
            bhtw0030().dadosEntrada().xCteuAlig().set(swSwitches().swSysin());
            bhtw0030().dadosEntrada().nmTabela().set("SYSIN");
            m9000TrataErroRotina() ;
        } else {
            /**
             * SET IND-PER                  TO SW-PERIODO
             */
            wsVariaveis().wsIndPer().set(swSwitches().swSysin().swPeriodo());
            swSwitches().swSysin().swDataIni().set(swSwitches().swSysin().swDataIni());
            swSwitches().swSysin().swDataFim().set(swSwitches().swSysin().swDataFim());
        }
        /**
         * IF BGHW8026-Z-FIM-VLDE-CMRG >= WS-DATA-INI-TAB(IND-PER) AND
         * VARYING IND-PER FROM WS-IND-PER BY 1
         * UNTIL IND-PER > SW-PERIODO
         */
        if (ficheiroFwk026().regFwk026().zFimVldeCmrg().isGreaterOrEqual(swSwitches().swSysin().swDataIni()) && 
            ficheiroFwk026().regFwk026().cFamiProdCmrg().isEqual("409") && 
            (ficheiroFwk026().regFwk026().cProdCmrg().isEqual("001") || 
            ficheiroFwk026().regFwk026().cProdCmrg().isEqual("003") || 
            ficheiroFwk026().regFwk026().cProdCmrg().isEqual("004"))) {
            m2050TrataPeriodos() ;
        }
        /**
         * PASSIVAS 4461 - INI
         */
        if (ficheiroFwk026().getStatusOk()) {
            /**
             * PASSIVAS 4461 - FIM
             */
            m1400LeFichFwk026() ;
        }
    }
    
    /**
     * 
     * 2050-TRATA-PERIODOS
     * 
     */
    protected void m2050TrataPeriodos() {
        log(TraceLevel.Debug, "2050-TRATA-PERIODOS");
        log(TraceLevel.Debug, "BGHW8026-CONTA:", ficheiroFwk026().regFwk026().conta());
        log(TraceLevel.Debug, "WS-CONTA-ANT:", wsVariaveis().wsContaAnt());
        log(TraceLevel.Debug, "WS-M-CMRG-LIM:", wsVariaveis().wsMCmrgLim());
        wsVariaveis().wsMCmrgLim().initialize() ;
        wsVariaveis().wsContaAnt().set(ficheiroFwk026().regFwk026().conta());
        wsVariaveis().wsAntCMoedIsoScta().set(ficheiroFwk026().regFwk026().cMoedIsoScta());
        wsVariaveis().wsAntNsDeposito().set(ficheiroFwk026().regFwk026().nsDeposito());
        while (ficheiroFwk026().regFwk026().conta().isEqual(wsVariaveis().wsContaAnt()) && ficheiroFwk026().getStatusOk()) {
            m2300TrataLdn() ;
        }
        /**
         * IF BGHW8026-CONTA NOT EQUAL WS-CONTA-ANT
         */
        bghr0271().registo().initialize() ;
        m2100ObtUltMov() ;
        m2250TrataDo() ;
    }
    
    /**
     * 
     * 2100-OBT-ULT-MOV
     * 
     */
    protected void m2100ObtUltMov() {
        log(TraceLevel.Debug, "2100-OBT-ULT-MOV");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(wsVariaveis().wsContaAnt().wsAntCPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(wsVariaveis().wsContaAnt().wsAntCBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(wsVariaveis().wsContaAnt().wsAntCOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(wsVariaveis().wsContaAnt().wsAntNsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(wsVariaveis().wsContaAnt().wsAntVChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(wsVariaveis().wsContaAnt().wsAntCTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(wsVariaveis().wsAntCMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(wsVariaveis().wsAntNsDeposito());
        /**
         * MOVE WS-DATA-INI-TAB(IND-PER)   TO WS-DATA-INI
         * MOVE WS-DATA-FIM-TAB(IND-PER)   TO WS-DATA-FIM
         */
        wsVariaveis().wsDataIni().set(swSwitches().swSysin().swDataIni());
        wsVariaveis().wsDataFim().set(swSwitches().swSysin().swDataFim());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghqz40a740(wsVariaveis().wsDataIni(), wsVariaveis().wsDataFim()) ;
        swSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("VGH10201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
        bhop0013FormataAcesso() ;
        if (swSwitches().swVgh10201Ok().isTrue()) {
            m2200ObtMontUtil() ;
        } else if (swSwitches().swVgh10201Null().isTrue() || swSwitches().swVgh10201Notfnd().isTrue()) {
            m2150ObtUltMov() ;
        } else {
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            bhtw0030().dadosEntrada().nmTabela().set("VGH10201");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_SELECT);
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2150-OBT-ULT-MOV
     * 
     */
    protected void m2150ObtUltMov() {
        log(TraceLevel.Debug, "2150-OBT-ULT-MOV");
        log(TraceLevel.Debug, "2150-BGHW8026-CONTA:", ficheiroFwk026().regFwk026().conta());
        /**
         * PASSIVAS 3568 - FIM
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(wsVariaveis().wsContaAnt().wsAntCPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(wsVariaveis().wsContaAnt().wsAntCBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(wsVariaveis().wsContaAnt().wsAntCOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(wsVariaveis().wsContaAnt().wsAntNsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(wsVariaveis().wsContaAnt().wsAntVChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(wsVariaveis().wsContaAnt().wsAntCTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(wsVariaveis().wsAntCMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(wsVariaveis().wsAntNsDeposito());
        wsVariaveis().wsDataIni().set(swSwitches().swSysin().swDataIni());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghqz40a811(wsVariaveis().wsDataIni()) ;
        swSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("VGH10201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
        bhop0013FormataAcesso() ;
        if (swSwitches().swVgh10201Ok().isTrue()) {
            m2200ObtMontUtil() ;
        } else if (swSwitches().swVgh10201Null().isTrue() || swSwitches().swVgh10201Notfnd().isTrue()) {
            m2170ObtTho002() ;
        } else {
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            bhtw0030().dadosEntrada().nmTabela().set("VGH10201");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_SELECT);
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2170-OBT-THO002
     * 
     */
    protected void m2170ObtTho002() {
        log(TraceLevel.Debug, "2170-OBT-THO002");
        log(TraceLevel.Debug, "2170-BGHW8026-CONTA:", ficheiroFwk026().regFwk026().conta());
        /**
         * PASSIVAS 3568 - FIM
         */
        hv00201Subcontas().subcontas().initialize() ;
        hv00201Subcontas().subcontas().cPaisIsoaCont().set(wsVariaveis().wsContaAnt().wsAntCPaisIsoaCont());
        hv00201Subcontas().subcontas().cBancCont().set(wsVariaveis().wsContaAnt().wsAntCBancCont());
        hv00201Subcontas().subcontas().cOeEgcCont().set(wsVariaveis().wsContaAnt().wsAntCOeEgcCont());
        hv00201Subcontas().subcontas().nsRdclCont().set(wsVariaveis().wsContaAnt().wsAntNsRdclCont());
        hv00201Subcontas().subcontas().vChkdCont().set(wsVariaveis().wsContaAnt().wsAntVChkdCont());
        hv00201Subcontas().subcontas().cTipoCont().set(wsVariaveis().wsContaAnt().wsAntCTipoCont());
        hv00201Subcontas().subcontas().cMoedIsoScta().set(wsVariaveis().wsAntCMoedIsoScta());
        hv00201Subcontas().subcontas().nsDeposito().set(wsVariaveis().wsAntNsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO00201_SUBCONTAS
         */
        hv00201Subcontas().selectPghqz40a884() ;
        swSwitches().swSqlcodeVho00201().set(hv00201Subcontas().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhok0002().nomeTabelas().vho10201());
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().swSqlcodeVho00201());
        bhop0013FormataAcesso() ;
        if (swSwitches().swVho00201Ok().isTrue()) {
            /**
             * MOVE VHO00201-M-CMRG-LIM   TO BGHR0271-1-M-CMRG-LIM
             */
            bghr0271().registo().reg1().x1MUtilizado().set(hv00201Subcontas().subcontas().mCmrgUtid());
        } else {
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVho00201());
            bhtw0030().dadosEntrada().nmTabela().set(bhok0002().nomeTabelas().vho00201());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_SELECT);
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2150-OBT-ULT-MOV
     * 
     */
    protected void m2200ObtMontUtil() {
        log(TraceLevel.Debug, "2200-OBT-MONT-UTIL");
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(wsVariaveis().wsContaAnt().wsAntCPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(wsVariaveis().wsContaAnt().wsAntCBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(wsVariaveis().wsContaAnt().wsAntCOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(wsVariaveis().wsContaAnt().wsAntNsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(wsVariaveis().wsContaAnt().wsAntVChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(wsVariaveis().wsContaAnt().wsAntCTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(wsVariaveis().wsAntCMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(wsVariaveis().wsAntNsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghqz40a940() ;
        swSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("VGH10201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().swSqlcodeVho00201());
        bhop0013FormataAcesso() ;
        if (swSwitches().swVgh10201Ok().isTrue()) {
            /**
             * MOVE VGH10201-M-CMRG-LIM   TO BGHR0271-1-M-CMRG-LIM
             */
            bghr0271().registo().reg1().x1MUtilizado().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
        } else {
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            bhtw0030().dadosEntrada().nmTabela().set("VGH10201");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_SELECT);
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2250-TRATA-DO
     * 
     */
    protected void m2250TrataDo() {
        log(TraceLevel.Debug, "2250-TRATA-DO");
        bghr0271().registo().reg1().x1CTipoRegisto().set("DO");
        /**
         * MOVE WS-N-PERIOD-TAB(IND-PER) TO BGHR0271-1-C-PERIODO
         * MOVE WS-DATA-INI-TAB(IND-PER) TO BGHR0271-1-Z-PER-INI
         * MOVE WS-DATA-FIM-TAB(IND-PER) TO BGHR0271-1-Z-PER-FIM
         */
        bghr0271().registo().reg1().x1CPeriodo().set(swSwitches().swSysin().swPeriodo());
        bghr0271().registo().reg1().x1ZPerIni().set(swSwitches().swSysin().swDataIni());
        bghr0271().registo().reg1().x1ZPerFim().set(swSwitches().swSysin().swDataFim());
        bghr0271().registo().reg1().x1CPaisIsoa().set(wsVariaveis().wsContaAnt().wsAntCPaisIsoaCont());
        bghr0271().registo().reg1().x1CBanc().set(wsVariaveis().wsContaAnt().wsAntCBancCont());
        bghr0271().registo().reg1().x1COeEgc().set(wsVariaveis().wsContaAnt().wsAntCOeEgcCont());
        bghr0271().registo().reg1().x1CPaisIsoaCont().set(wsVariaveis().wsContaAnt().wsAntCPaisIsoaCont());
        bghr0271().registo().reg1().x1CBancCont().set(wsVariaveis().wsContaAnt().wsAntCBancCont());
        bghr0271().registo().reg1().x1COeEgcCont().set(wsVariaveis().wsContaAnt().wsAntCOeEgcCont());
        bghr0271().registo().reg1().x1NsRdclCont().set(wsVariaveis().wsContaAnt().wsAntNsRdclCont());
        bghr0271().registo().reg1().x1VChkdCont().set(wsVariaveis().wsContaAnt().wsAntVChkdCont());
        bghr0271().registo().reg1().x1CTipoCont().set(wsVariaveis().wsContaAnt().wsAntCTipoCont());
        bghr0271().registo().reg1().x1MCmrgLim().set(wsVariaveis().wsMCmrgLim());
        log(TraceLevel.Debug, "SW-PERIODO :", swSwitches().swSysin().swPeriodo());
        log(TraceLevel.Debug, "SW-DATA-INI:", swSwitches().swSysin().swDataIni());
        log(TraceLevel.Debug, "SW-DATA-FIM:", swSwitches().swSysin().swDataFim());
        bghr0271().registo().reg1().x1Filler().set(" ");
        bghr0271().registo().reg1().x1V11().set(CON_VIRG);
        bghr0271().registo().reg1().x1V12().set(CON_VIRG);
        bghr0271().registo().reg1().x1V13().set(CON_VIRG);
        bghr0271().registo().reg1().x1V14().set(CON_VIRG);
        bghr0271().registo().reg1().x1V15().set(CON_VIRG);
        bghr0271().registo().reg1().x1V16().set(CON_VIRG);
        bghr0271().registo().reg1().x1V17().set(CON_VIRG);
        if (wsVariaveis().wsMCmrgLim().isGreater(0)) {
            m1700EscreveFgh027() ;
        }
        wsVariaveis().wsContadorDo().add(1);
    }
    
    /**
     * 
     * 2300-TRATA-LDN
     * 
     */
    protected void m2300TrataLdn() {
        log(TraceLevel.Debug, "2300-TRATA-LDN");
        bghr0271().registo().initialize() ;
        /**
         * CLASSIFICA ESTADO DO LDN
         * LDN ABERTO PERIODO-01 (VER DATA DATA DEFINIDA)
         * IF BGHW8026-Z-ABRA-CMRG >= WS-DATA-INI-TAB(IND-PER) AND
         * BGHW8026-Z-ABRA-CMRG <= WS-DATA-FIM-TAB(IND-PER)
         */
        if (ficheiroFwk026().regFwk026().zAbraCmrg().isGreaterOrEqual(swSwitches().swSysin().swDataIni()) && 
            ficheiroFwk026().regFwk026().zAbraCmrg().isLessOrEqual(swSwitches().swSysin().swDataFim())) {
            bghr0271().registo().reg2().x2CEstado().set("A");
        }
        /**
         * LDN FECHADO MES-01 (VER DATA DATA DEFINIDA)
         * IF BGHW8026-Z-FIM-VLDE-CMRG >= WS-DATA-INI-TAB(IND-PER) AND
         * BGHW8026-Z-FIM-VLDE-CMRG <= WS-DATA-FIM-TAB(IND-PER)
         */
        if (ficheiroFwk026().regFwk026().zFimVldeCmrg().isGreaterOrEqual(swSwitches().swSysin().swDataIni()) && 
            ficheiroFwk026().regFwk026().zFimVldeCmrg().isLessOrEqual(swSwitches().swSysin().swDataFim())) {
            bghr0271().registo().reg2().x2CEstado().set("F");
        }
        /**
         * LDN EM CURSO MES-01 (VER DATA DATA DEFINIDA)
         * IF BGHW8026-Z-ABRA-CMRG     < WS-DATA-INI-TAB(IND-PER) AND
         * BGHW8026-Z-FIM-VLDE-CMRG > WS-DATA-FIM-TAB(IND-PER)
         */
        if (ficheiroFwk026().regFwk026().zAbraCmrg().isLess(swSwitches().swSysin().swDataIni()) && 
            ficheiroFwk026().regFwk026().zFimVldeCmrg().isGreater(swSwitches().swSysin().swDataFim())) {
            bghr0271().registo().reg2().x2CEstado().set("C");
        }
        bghr0271().registo().reg2().x2CTipoRegisto().set("LN");
        /**
         * MOVE WS-N-PERIOD-TAB(IND-PER) TO BGHR0271-2-C-PERIODO
         * MOVE WS-DATA-INI-TAB(IND-PER) TO BGHR0271-2-Z-PER-INI
         * MOVE WS-DATA-FIM-TAB(IND-PER) TO BGHR0271-2-Z-PER-FIM
         */
        bghr0271().registo().reg2().x2CPeriodo().set(swSwitches().swSysin().swPeriodo());
        bghr0271().registo().reg2().x2ZPerIni().set(swSwitches().swSysin().swDataIni());
        bghr0271().registo().reg2().x2ZPerFim().set(swSwitches().swSysin().swDataFim());
        bghr0271().registo().reg2().x2CPaisIsoa().set(ficheiroFwk026().regFwk026().conta().cPaisIsoaCont());
        bghr0271().registo().reg2().x2CBanc().set(ficheiroFwk026().regFwk026().conta().cBancCont());
        bghr0271().registo().reg2().x2COeEgc().set(ficheiroFwk026().regFwk026().conta().cOeEgcCont());
        bghr0271().registo().reg2().x2CPaisIsoaCont().set(ficheiroFwk026().regFwk026().conta().cPaisIsoaCont());
        bghr0271().registo().reg2().x2CBancCont().set(ficheiroFwk026().regFwk026().conta().cBancCont());
        bghr0271().registo().reg2().x2COeEgcCont().set(ficheiroFwk026().regFwk026().conta().cOeEgcCont());
        bghr0271().registo().reg2().x2NsRdclCont().set(ficheiroFwk026().regFwk026().conta().nsRdclCont());
        bghr0271().registo().reg2().x2VChkdCont().set(ficheiroFwk026().regFwk026().conta().vChkdCont());
        bghr0271().registo().reg2().x2CTipoCont().set(ficheiroFwk026().regFwk026().conta().cTipoCont());
        bghr0271().registo().reg2().x2NsCmrg().set(ficheiroFwk026().regFwk026().nsCmrg());
        bghr0271().registo().reg2().x2ZAbraCmrg().set(ficheiroFwk026().regFwk026().zAbraCmrg());
        bghr0271().registo().reg2().x2ZFimVldeCmrg().set(ficheiroFwk026().regFwk026().zFimVldeCmrg());
        log(TraceLevel.Debug, "SW-PERIODO :", swSwitches().swSysin().swPeriodo());
        log(TraceLevel.Debug, "SW-DATA-INI:", swSwitches().swSysin().swDataIni());
        log(TraceLevel.Debug, "SW-DATA-FIM:", swSwitches().swSysin().swDataFim());
        log(TraceLevel.Debug, "WS-M-CMRG-LIM:", wsVariaveis().wsMCmrgLim());
        bghr0271().registo().reg2().x2Filler().set(" ");
        bghr0271().registo().reg2().x2V21().set(CON_VIRG);
        bghr0271().registo().reg2().x2V22().set(CON_VIRG);
        bghr0271().registo().reg2().x2V23().set(CON_VIRG);
        bghr0271().registo().reg2().x2V24().set(CON_VIRG);
        bghr0271().registo().reg2().x2V25().set(CON_VIRG);
        bghr0271().registo().reg2().x2V26().set(CON_VIRG);
        bghr0271().registo().reg2().x2V27().set(CON_VIRG);
        bghr0271().registo().reg2().x2V28().set(CON_VIRG);
        bghr0271().registo().reg2().x2V29().set(CON_VIRG);
        /**
         * IF BGHW8026-CONTA EQUAL WS-CONTA-ANT
         */
        wsVariaveis().wsMCmrgLim().set(add(wsVariaveis().wsMCmrgLim(), ficheiroFwk026().regFwk026().mCmrgLim()));
        /**
         * ELSE
         * MOVE BGHW8026-M-CMRG-LIM     TO WS-M-CMRG-LIM
         * END-IF
         */
        if (!bghr0271().registo().reg2().x2CEstado().isEmpty()) {
            m1700EscreveFgh027() ;
            wsVariaveis().wsContadorLdn().add(1);
        }
        m1400LeFichFwk026() ;
    }
    
    /**
     * 
     * 3000-EXIT-PROGRAMA
     * 
     */
    protected void m3000ExitPrograma() {
        log(TraceLevel.Debug, "3000-EXIT-PROGRAMA");
        log(TraceLevel.Debug, "WS-CONTADOR-DO :", wsVariaveis().wsContadorDo());
        log(TraceLevel.Debug, "WS-CONTADOR-LDN:", wsVariaveis().wsContadorLdn());
        /**
         * PASSIVAS 3568 - FIM
         */
        m3100FechaFicheiros() ;
        bhop0013FimEstatistica() ;
    }
    
    /**
     * 
     * FECHA FICHEIROS DE TRABALHO E ACTUALIZA ACESSOS
     * 
     */
    protected void m3100FechaFicheiros() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIROS");
        ficheiroFwk026().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK026);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk026().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk026().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
        ficheiroFgh027().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH027);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh027().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh027().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
    }
    
    /**
     * 
     * PARAGRAFOS PADROES
     * 8000-DATA-HORA-INI
     * 
     */
    protected void m8000DataHoraIni() {
        log(TraceLevel.Debug, "8000-DATA-HORA-INI");
        wsVariaveis().wsDataIni().set( getDBDate() ) ;
        wsVariaveis().wsHoraIni().set( getDBTime() ) ;
        wsVariaveis().wsTimestamp().set( getDBTimestamp() ) ;
    }
    
    /**
     * 
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        log(TraceLevel.Debug, "8100-DATA-HORA-FIM");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
    }
    
    /**
     * 
     * 9000-TRATA-ERRO-ROTINA
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
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_ROTINA);
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
        bhtw0030().dadosEntrada().abendDb2().setTrue() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9700-ERRO FICHEIRO
     * 
     */
    protected void m9700ErroFicheiro() {
        log(TraceLevel.Debug, "9700-ERRO-FICHEIRO");
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
        bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
        bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        ficheiroFwk026().close() ;
        ficheiroFgh027().close() ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
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
     * BHOK0005
     * COPY DE EVENTOS
     * HO E HV
     * 
     * @version 2.0
     * 
     */
    public interface Bhok0005Pghqz40a extends Bhok0005 {
        
        @Data(size=4, value="AA10")
        IString montantesTaeg() ;
        
    }
    
    /**
     * 
     * CONSTANTES PERIODO
     * DEFINICAO DE PERIODOS
     * 
     * @version 2.0
     * 
     */
    public interface WsTabelaPeriodo extends IDataStruct {
        
        @Data(size=22, value="012017-08-012017-08-31")
        IString filler001() ;
        
        @Data(size=22, value="022017-09-012017-09-30")
        IString filler002() ;
        
        @Data(size=22, value="032017-10-012017-10-31")
        IString filler003() ;
        
        @Data(size=22, value="042017-11-012017-11-30")
        IString filler004() ;
        
        @Data(size=22, value="052017-12-012017-12-31")
        IString filler005() ;
        
        @Data(size=22, value="062018-01-012018-01-31")
        IString filler006() ;
        
        @Data(size=22, value="072018-02-012018-02-28")
        IString filler007() ;
        
        @Data(size=22, value="082018-03-012018-03-31")
        IString filler008() ;
        
        @Data(size=22, value="092018-04-012018-04-30")
        IString filler009() ;
        
        @Data(size=22, value="102018-05-012018-05-31")
        IString filler010() ;
        
        @Data(size=22, value="112018-06-012018-06-30")
        IString filler011() ;
        
        @Data(size=22, value="122018-07-012018-07-31")
        IString filler012() ;
        
        @Data(size=22, value="132018-08-012018-08-31")
        IString filler013() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=30)
        IString wsDescFine() ;
        
        @Data(size=2)
        IInt wsIndPer() ;
        
        @Data(size=5)
        IInt wsContadorDo() ;
        
        @Data(size=5)
        IInt wsContadorLdn() ;
        
        /**
         * ****                  DATA E HORA              ****
         * @return instancia da classe local WsXCteuMhgj030a
         */
        @Data
        WsXCteuMhgj030a wsXCteuMhgj030a() ;
        
        @Data(size=30)
        IString wsDescProd() ;
        
        @Data(size=30)
        IString wsDescGart() ;
        
        @Data(size=40, value=" ")
        IString wsDescOe() ;
        
        @Data(size=40, value=" ")
        IString wsDRegiao() ;
        
        @Data(size=4)
        IInt wsCOeEgc() ;
        
        @Data(size=4)
        IInt wsCOeEgcOper() ;
        
        @Data(size=4)
        IInt wsCOeEgcDirzRgnl() ;
        
        @Data(size=4)
        IInt wsCOeEgcDirzCmrl() ;
        
        @Data(size=11, decimal=1, signed=true, value="0")
        IDecimal wsTTaeAux() ;
        
        @Data(size=17, decimal=2, signed=true, value="0")
        IDecimal wsMCmrgLim() ;
        
        @Data(size=10, decimal=7, signed=true)
        IDecimal wsTTae() ;
        
        @Data(size=4, decimal=1, signed=true, value="0")
        IDecimal wsTTaeRound() ;
        
        /**
         * @return instancia da classe local WsContaAnt
         */
        @Data
        WsContaAnt wsContaAnt() ;
        
        @Data(size=3)
        IString wsAntCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsAntNsDeposito() ;
        
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
        
        @Data(size=10, value=" ")
        IString wsZIniProc() ;
        
        @Data(size=10, value=" ")
        IString wsZFimProc() ;
        
        @Data(size=10, value=" ")
        IString wsZProcessamento() ;
        
        @Data(size=4, value=" ")
        IString wsAnoIni() ;
        
        @Data(size=2, value=" ")
        IString wsMesIni() ;
        
        @Data(size=2, value=" ")
        IString wsDiaIni() ;
        
        @Data(size=4, value=" ")
        IString wsAnoFim() ;
        
        @Data(size=2, value=" ")
        IString wsMesFim() ;
        
        @Data(size=2, value=" ")
        IString wsDiaFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataTratar10() ;
        
        
        
        /**
         * 
         * ****                  DATA E HORA              ****
         * 
         * @version 2.0
         * 
         */
        public interface WsXCteuMhgj030a extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCTabBbnMhgj030a() ;
            
            @Data(size=20, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsCCodigoMhgj030a() ;
            
            @Data(size=1, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsIAccaoTabMhgj030a() ;
            
            @Data(size=1, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsIDadosObtrMhgj030a() ;
            
            @Data(size=3, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsCPaisIsoMhgj030a() ;
            
            @Data(size=3, value=" ", lpadding=3, rpadding=1, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsCMnemEmpGcxMhgj030a() ;
            
        }
        
        public interface WsContaAnt extends IDataStruct {
            
            @Data(size=3)
            IString wsAntCPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsAntCBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsAntCOeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsAntNsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsAntVChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsAntCTipoCont() ;
            
        }
    }
    
    /**
     * 
     * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        /**
         * - FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Exit() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk026() ;
        @Data
        @Condition("00")
        ICondition swFwk026Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk026Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh027() ;
        @Data
        @Condition("00")
        ICondition swFgh027Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh027Eof() ;
        
        
        /**
         * @return instancia da classe local SwSysin
         */
        @Data
        SwSysin swSysin() ;
        
        /**
         * - DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVho00201() ;
        @Data
        @Condition("0")
        ICondition swVho00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVho00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVho00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVho00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh10201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh10201Null() ;
        
        
        
        public interface SwSysin extends IDataStruct {
            
            @Data(size=2)
            IInt swPeriodo() ;
            
            @Data(size=10)
            IString swDataIni() ;
            
            @Data(size=10)
            IString swDataFim() ;
            
        }
    }
    
}
