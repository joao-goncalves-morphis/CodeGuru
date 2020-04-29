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
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtr0112 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hg.structures.link.Bhgl911a ;
import cgd.hy.structures.link.Bhyl009a ;
import cgd.ho.structures.work.Bhor1771 ;
import cgd.gh.structures.work.Bghr1701 ;
import cgd.ho.structures.link.Bhol708a ;
import cgd.ht.routines.Mhtq250a ;
import cgd.hg.routines.Mhgj011a ;
import cgd.hy.routines.Mhyj009a ;
import cgd.ho.routines.Mhoj708a ;


/**
 * 
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq170a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops01301Indisp
     */
    @Data
    protected abstract Vwsdhops01301Indisp hv01301Indisp() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011", record="statusFht011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk00102
     */
    @Handler(name="FWK001", record="statusFwk001")
    @Data
    protected abstract Fwk00102 ficheiroFwk001() ;
    
    /**
     * @return instancia da classe Fwk002
     */
    @Handler(name="FWK002", record="regFwk002400")
    @Data
    protected abstract Fwk002 ficheiroFwk002() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mhgj011a
     */
    @Data
    protected abstract Mhgj011a hrMhgj011a() ;
    
    /**
     * @return instancia da classe Mhyj009a
     */
    @Data
    protected abstract Mhyj009a hrMhyj009a() ;
    
    /**
     * @return instancia da classe Mhoj708a
     */
    @Data
    protected abstract Mhoj708a hrMhoj708a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0112
     */
    @Data
    protected abstract Bhtr0112 bhtr0112() ;
    
    /**
     * @return instancia da classe Bhtl200a
     */
    @Data
    protected abstract Bhtl200a bhtl200a() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
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
     * @return instancia da classe Bhok0003
     */
    @Data
    protected abstract Bhok0003 bhok0003() ;
    
    /**
     * @return instancia da classe Bhok0005
     */
    @Data
    protected abstract Bhok0005 bhok0005() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhgl911a
     */
    @Data
    protected abstract Bhgl911a bhgl911a() ;
    
    /**
     * @return instancia da classe Bhyl009a
     */
    @Data
    protected abstract Bhyl009a bhyl009a() ;
    
    /**
     * @return instancia da classe Bhor1771
     */
    @Data
    protected abstract Bhor1771 bhor1771() ;
    
    /**
     * @return instancia da classe Bghr1701
     */
    @Data
    protected abstract Bghr1701 bghr1701() ;
    
    /**
     * @return instancia da classe Bhol708a
     */
    @Data
    protected abstract Bhol708a bhol708a() ;
    
    /**
     * AREA DE LIGACAO AH ROTINA MHGJ011A
     * AREA DE LIGACAO AH ROTINA MHYJ009A
     * COPYBOOK DE ESTRUTURA DO FICHEIRO DE INPUT
     * COPYBOOK DE FORMATACAO DO FICHEIRO DE OUTPUT
     * COPYBOOK DE LIGACAO AH ROTINA MHOJ708A - VALIDACAO DE CONTA
     * DEFINICAO DE TABELAS DB2
     * DEFINICAO DA SQL COMMUNICATION AREA
     * STATUS
     * INICIO WORKING-STORAGE PGHQ170A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_FWK002 = "FWK002" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ170A" ;
    
    protected static final String CON_MHGJ011A = "MHGJ011A" ;
    
    protected static final String CON_MHYJ009A = "MHYJ009A" ;
    
    protected static final String CON_FILE_V11 = "FGH172" ;
    
    protected static final String CON_FILE_V12 = "FGH173" ;
    
    protected static final String CON_FILE_V17 = "FGH174" ;
    
    protected static final String CON_FILE_V13 = "FGH175" ;
    
    protected static final String CON_FILE_V15 = "FGH176" ;
    
    protected static final String CON_FILE_V112 = "FGH179" ;
    
    protected static final String CON_PROGRAM_DESC = "ATRIBUI A RELACAO MOVIMENTO FICHEIRO " ;
    
    protected static final String CON_ERR_ACES_MHOL708A = "MHOJ708A - ERRO DE ACESSO ROTINA DE CONTAS]       " ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    /**
     * ****              TABELA GERAL
     */
    protected static final String CON_G61 = "G61" ;
    
    /**
     * ****              CONSTANTES NUMERICAS                    ****
     */
    protected static final int CON_N1 = 1 ;
    
    protected static final int CON_N_012 = 12 ;
    
    protected static final int CON_TAM_TAB_MOV_FICH = 9999 ;
    
    /**
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * ACESSO A ROTINA QUE OBTEM AS DATAS D POR APLICACAO
     * MHTQ250A
     * 
     */
    protected void bhtp0250DatasDAplic() {
    }
    
    /**
     * 
     * ACESSO A ROTINA DE CONSULTA EM LISTA COM SELECCAO POR CHAVE
     * PARCIAL OU POR CONTEUDO DE QUALQUER UM DOS ATRIBUTOS
     * 
     */
    protected void bhgp0911ConsListaSelec() {
        hrMhgj011a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA MHYJ009A - DADOS DE MAPAS
     * 
     */
    protected void bhyp0009RotMapas() {
        hrMhyj009a().run() ;
    }
    
    /**
     * 
     * BHOP0708 - COPY PROCEDURE DE CHAMADA A ROTINA DE VALIDACAO DE
     * CONTA E SITUACAO CONTRA ACCAO
     * 
     */
    protected void bhop0708ValConta() {
        hrMhoj708a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "*********** - INICIO - *************");
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFwk001().getStatusOk()) {
            m2000ProcPrograma() ;
        }
        m3000FinalPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100InicializaVar() ;
        m1200TrataEstatIni() ;
        m1300ObterDadosBatch() ;
        m1400ObterDatas() ;
        m1500TrataFicheiros() ;
        m1600IniciaTabsInternas() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        wsVariaveis().initialize() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_PROGRAM_DESC);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OBTER-DADOS-BATCH
     * 
     */
    protected void m1300ObterDadosBatch() {
        log(TraceLevel.Debug, "1300-OBTER-DADOS-BATCH");
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set("FHT011");
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
        bhop0013FormataAcesso() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1300-OBTER-DADOS-BATCH");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set("FHT011");
            bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1400-OBTER-DATAS
     * 
     */
    protected void m1400ObterDatas() {
        log(TraceLevel.Debug, "1400-OBTER-DATAS");
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("MHYQ250A");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OBTER-DATAS");
            bhtw0030().dadosEntrada().nmPrgChmd().set("MHTQ250A");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(wsVariaveis().wsXCteuMhtq250a());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500TrataFicheiros() {
        log(TraceLevel.Debug, "1500-TRATA-FICHEIROS");
        m1510OpenFwk001() ;
        m1520OpenFwk002() ;
        m1540ReadFwk001() ;
    }
    
    /**
     * 
     * 1510-OPEN-FWK001
     * 
     */
    protected void m1510OpenFwk001() {
        log(TraceLevel.Debug, "1510-OPEN-FWK001");
        /**
         * \* ABRE FICHEIRO DE INPUT - FWK001
         */
        ficheiroFwk001().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-OPEN-FWK001");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-OPEN-FWK002
     * 
     */
    protected void m1520OpenFwk002() {
        log(TraceLevel.Debug, "1520-OPEN-FWK002");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK002
         */
        ficheiroFwk002().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK002);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk002().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk002().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk002().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FWK002");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1540-READ-FWK001
     * 
     */
    protected void m1540ReadFwk001() {
        log(TraceLevel.Debug, "1540-READ-FWK001");
        ficheiroFwk001().read(bhor1771().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFwk001().getStatusOk()) {
            wsVariaveis().wsLidosFwk001().add(CON_N1);
            wsVariaveis().wsChvAct().initialize() ;
            wsVariaveis().wsChvCtaAct().initialize() ;
            /**
             * FORMATA CHAVE ACTUAL
             */
            wsVariaveis().wsChvAct().wsCMnemEgcOpexAct().set(bhor1771().registo().cMnemEgcOpex());
            wsVariaveis().wsChvAct().wsCPaisIsoaOeOpxAct().set(bhor1771().registo().cPaisIsoaOeOpx());
            wsVariaveis().wsChvAct().wsAAplicacaoAct().set(bhor1771().registo().aAplicacao());
            wsVariaveis().wsChvAct().wsCEvenOpelAct().set(bhor1771().registo().cEvenOpel());
            wsVariaveis().wsChvAct().wsCOpeBbnAct().set(bhor1771().registo().cOpeBbn());
            /**
             * FORMATA CHAVE CONTA ACTUAL
             */
            wsVariaveis().wsChvCtaAct().wsCPaisIsoaContAct().set(bhor1771().registo().subconta().cPaisIsoaCont());
            wsVariaveis().wsChvCtaAct().wsCBancContAct().set(bhor1771().registo().subconta().cBancCont());
            wsVariaveis().wsChvCtaAct().wsCOeEgcContAct().set(bhor1771().registo().subconta().cOeEgcCont());
            wsVariaveis().wsChvCtaAct().wsNsRdclContAct().set(bhor1771().registo().subconta().nsRdclCont());
            wsVariaveis().wsChvCtaAct().wsVChkdContAct().set(bhor1771().registo().subconta().vChkdCont());
            wsVariaveis().wsChvCtaAct().wsCTipoContAct().set(bhor1771().registo().subconta().cTipoCont());
        } else if (!ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1540-READ-FWK001");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-INICIA-TABS-INTERNAS
     * 
     */
    protected void m1600IniciaTabsInternas() {
        log(TraceLevel.Debug, "1600-INICIA-TABS-INTERNAS");
        for (wsVariaveis().tabMovFich().setIndex(1); wsVariaveis().tabMovFich().index().isLessOrEqual(9999); wsVariaveis().tabMovFich().incIndex()) {
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsAAplicacao().set(" ");
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsCEvenOpel().set(" ");
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsCOpeBbn().set(" ");
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro().set(" ");
        }
        /**
         * INICIALIZA INDICES
         */
        wsVariaveis().tabMovFich().setIndex(CON_N1);
        wsVariaveis().wsIndTabMax().set(0);
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        log(TraceLevel.Debug, "WS-CHV-ACT     : ", wsVariaveis().wsChvAct());
        log(TraceLevel.Debug, "WS-CHV-ANT     : ", wsVariaveis().wsChvAnt());
        log(TraceLevel.Debug, "WS-CHV-CTA-ACT : ", wsVariaveis().wsChvCtaAct());
        log(TraceLevel.Debug, "WS-CHV-CTA-ANT : ", wsVariaveis().wsChvCtaAnt());
        /**
         * SO VAMOS VALIDAR NA TABELA GERAL G61 OS MOVIMENTOS QUE
         * TENHAM A CHAVE DIFERENTE DA ANTERIOR E CUJO PAIS/MNEMONICA
         * SEJAM IGUAIS AOS DO CONTEXTO
         */
        if (bhor1771().registo().cPaisIsoaOeOpx().isEqual(bhtr0112().fht011Registo().fht011CPaisContxt()) && 
            bhor1771().registo().cMnemEgcOpex().isEqual(bhtr0112().fht011Registo().fht011CMnemContxt())) {
            if (!wsVariaveis().wsChvAct().isEqual(wsVariaveis().wsChvAnt())) {
                bhgl911a().commarea().dadosErro().semErros().setTrue() ;
                m1600IniciaTabsInternas() ;
                m2100FormataAcesso() ;
                while (!bhgl911a().commarea().dadosErro().erroFuncao().isTrue() && !bhgl911a().commarea().dadosErro().fimConsulta().isTrue()) {
                    m2200ProcuraFich() ;
                }
            }
            if (bhgl911a().commarea().dadosErro().fimConsulta().isTrue() && 
                wsVariaveis().wsIndTabMax().isGreaterOrEqual(CON_N1)) {
                wsVariaveis().tabMovFich().setIndex(CON_N1);
                while (wsVariaveis().tabMovFich().index().isLessOrEqual(wsVariaveis().wsIndTabMax())) {
                    m2300DescrrgTabMovFich() ;
                }
            }
        }
        /**
         * FORMATA CHAVE ANTERIOR
         */
        wsVariaveis().wsChvAnt().initialize() ;
        wsVariaveis().wsChvAnt().set(wsVariaveis().wsChvAct());
        wsVariaveis().wsChvCtaAnt().set(wsVariaveis().wsChvCtaAct());
        m1540ReadFwk001() ;
    }
    
    /**
     * 
     * 2100-FORMATA-ACESSO
     * DESC: FORMATA ACESSO AH ROTINA MHGJ011A
     * 
     */
    protected void m2100FormataAcesso() {
        log(TraceLevel.Debug, "2100-FORMATA-ACESSO");
        bhgl911a().commarea().dadosInput().initialize() ;
        bhgl911a().commarea().dadosInput().cTabBbn().set(CON_G61);
        bhgl911a().commarea().dadosInput().cIdioIso().set(bhtr0112().fht011Registo().fht011CIdioContxt());
        /**
         * FORMATAR AS 1AS POSICOES DO CODIGO DE INPUT COM
         * APLICACAO / C EVENTO / C OPERACAO
         */
        bhgl911a().commarea().dadosInput().cCodigo().get(1, 2).set(wsVariaveis().wsChvAct().wsAAplicacaoAct()) ;
        bhgl911a().commarea().dadosInput().cCodigo().get(3, 4).set(wsVariaveis().wsChvAct().wsCEvenOpelAct()) ;
        bhgl911a().commarea().dadosInput().cCodigo().get(7, 5).set(wsVariaveis().wsChvAct().wsCOpeBbnAct()) ;
        bhgl911a().commarea().dadosInput().cCodigo().get(12, 8).set(" ") ;
        bhgl911a().commarea().dadosInput().iIndicBusca().chaveParcial().setTrue() ;
        bhgl911a().commarea().dadosInput().iIndicBusca().semPesqAtr().setTrue() ;
        log(TraceLevel.Debug, "#######################");
        log(TraceLevel.Debug, "#BHGL911A-DADOS-INTPUT#");
        log(TraceLevel.Debug, "#######################");
        log(TraceLevel.Debug, "BHGL911A-C-TAB-BBN   ", bhgl911a().commarea().dadosInput().cTabBbn());
        log(TraceLevel.Debug, "BHGL911A-C-IDIO-ISO  ", bhgl911a().commarea().dadosInput().cIdioIso());
        log(TraceLevel.Debug, "BHGL911A-C-CODIGO    ", bhgl911a().commarea().dadosInput().cCodigo());
    }
    
    /**
     * 
     * 2200-PROCURA-FICH
     * DESC: PESQUISA NA TABELA GERAL PRETENDIDA TODOS OS FICHEIROS
     * ONDE O MOVIMENTO DEVERA SEGUIR E GUARDA ESSES FICHEIROS
     * NUMA TABELA INTERNA
     * 
     */
    protected void m2200ProcuraFich() {
        log(TraceLevel.Debug, "2200-PROCURA-FICH");
        bhgl911a().commarea().dadosOutput().initialize() ;
        bhgl911a().commarea().dadosErro().initialize() ;
        bhgp0911ConsListaSelec() ;
        log(TraceLevel.Debug, "BHGL911A-C-TIPO-ERRO-BBN  ", bhgl911a().commarea().dadosErro().cTipoErroBbn());
        log(TraceLevel.Debug, "BHGL911A-C-RTNO-EVEN-SWAL  ", bhgl911a().commarea().dadosErro().cRtnoEvenSwal());
        log(TraceLevel.Debug, "BHGL911A-A-APL-ERR  ", bhgl911a().commarea().dadosErro().aAplErr());
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MHGJ011A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhgl911a().commarea().dadosErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhgl911a().commarea().dadosErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhgl911a().commarea().dadosErro().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhgl911a().commarea().dadosErro().semErros().isTrue() || bhgl911a().commarea().dadosErro().fimConsulta().isTrue()) {
            log(TraceLevel.Debug, "BHGL911A-INDICE  ", bhgl911a().commarea().dadosOutput().indice());
            log(TraceLevel.Debug, "BHGL911A-C-CODIGO-OUT(BHGL911A-INDICE)  ", bhgl911a().commarea().dadosOutput().logicaFisica().get(bhgl911a().commarea().dadosOutput().indice()).componenteLogica().cCodigoOut());
            bhgl911a().commarea().dadosInput().chaveContinuacao().cCodigoL().set(bhgl911a().commarea().dadosOutput().logicaFisica().get(bhgl911a().commarea().dadosOutput().indice()).componenteLogica().cCodigoOut());
            bhgl911a().commarea().dadosInput().chaveContinuacao().cIdioIsoL().set(bhgl911a().commarea().dadosOutput().logicaFisica().get(bhgl911a().commarea().dadosOutput().indice()).componenteLogica().cIdioIsoOut());
            wsVariaveis().wsIndice().set(CON_N1);
            while (wsVariaveis().wsIndice().isLessOrEqual(bhgl911a().commarea().dadosOutput().indice())) {
                m2210CarregaTabMovFich() ;
            }
        } else if (!bhgl911a().commarea().dadosErro().semErros().isTrue() && !bhgl911a().commarea().dadosErro().fimConsulta().isTrue() && 
            !bhgl911a().commarea().dadosErro().erroFuncao().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhgl911a().commarea().dadosErro().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhgl911a().commarea().dadosErro().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MHGJ011A);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhgl911a().commarea().dadosErro().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhgl911a().commarea().dadosInput());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhgl911a().commarea().dadosErro().cRtnoEvenSwal());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2210-CARREGA-TAB-MOV-FICH
     * STEP DE CARREGAMENTO DA TABELA INTERNA
     * 
     */
    protected void m2210CarregaTabMovFich() {
        log(TraceLevel.Debug, "2210-CARREGA-TAB-MOV-FICH");
        /**
         * ANTES DE CARREGAR O CODIGO NA TABELA INTERNA VAMOS TER QUE
         * VALIDAR SE O FICHEIRO ESTA VALIDO NO CONTEXTO PRETENDIDO
         */
        m2220ValidaContexto() ;
        if (bhyl009a().commarea().dadosErro().semErros().isTrue()) {
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().set(bhgl911a().commarea().dadosOutput().logicaFisica().get(wsVariaveis().wsIndice()).componenteLogica().cCodigoOut());
            log(TraceLevel.Debug, "WS-INDICE  ", wsVariaveis().wsIndice());
            log(TraceLevel.Debug, "BHGL911A-C-CODIGO-OUT(WS-INDICE): ", bhgl911a().commarea().dadosOutput().logicaFisica().get(wsVariaveis().wsIndice()).componenteLogica().cCodigoOut());
            wsVariaveis().wsIndTabMax().set(wsVariaveis().tabMovFich().index());
            wsVariaveis().tabMovFich().incIndex() ;
            /**
             * *---    SALVAGUARDA ULTRAPASSAGEM DO LIMITE DA TABELA INTERNA     
             */
            if (wsVariaveis().wsIndTabMax().isGreater(CON_TAM_TAB_MOV_FICH)) {
                log(TraceLevel.Error, "WS-IND-TAB-MAX      : ", wsVariaveis().wsIndTabMax());
                log(TraceLevel.Error, "CON-TAM-TAB-MOV-FICH: ", CON_TAM_TAB_MOV_FICH);
                bhtw0030().dadosEntrada().xSugRtnoSwal().set("2210-CARREGA-TAB-MOV-FICH");
                bhtw0030().dadosEntrada().nmTabela().set("TAM-TAB-MOV-FICH");
                bhtw0030().dadosEntrada().abendDb2().setTrue() ;
                m9900Abend() ;
            }
        } else if (!bhyl009a().commarea().dadosErro().semErros().isTrue() || bhyl009a().commarea().dadosErro().fimConsulta().isTrue()) {
            log(TraceLevel.Debug, "C-MAPA NAO VALIDO NO CONTEXTO");
            log(TraceLevel.Debug, "-----------------------------");
            log(TraceLevel.Debug, "C-MAPA :", bhgl911a().commarea().dadosOutput().logicaFisica().get(wsVariaveis().wsIndice()).componenteLogica().cCodigoOut());
        }
        /**
         * SO PODEMOS INCREMENTAR O INDICE DA LISTA DEPOIS DE PREENCHER
         * A TABELA INTERNA
         */
        wsVariaveis().wsIndice().add(CON_N1);
    }
    
    /**
     * 
     * 2220-VALIDA-CONTEXTO
     * STEP DE VALIDACAO DA EXISTENCIA DO C-MAPA PARA O PAIS/EMPRESA
     * EM QUESTAO
     * 
     */
    protected void m2220ValidaContexto() {
        log(TraceLevel.Debug, "2220-VALIDA-CONTEXTO");
        bhyl009a().commarea().dadosInput().initialize() ;
        bhyl009a().commarea().dadosOutput().initialize() ;
        bhyl009a().commarea().dadosErro().initialize() ;
        /**
         * FORMATA CODIGO DO MAPA OBTIDO DA TABELA GERAL G61
         * E O MODO DE ACESSO
         */
        bhyl009a().commarea().dadosInput().cMapa().set(bhgl911a().commarea().dadosOutput().logicaFisica().get(wsVariaveis().wsIndice()).componenteLogica().cCodigoOut().get(12, 6));
        bhyl009a().commarea().dadosInput().cPaisIsoAlfn().set(bhtr0112().fht011Registo().fht011CPaisContxt());
        bhyl009a().commarea().dadosInput().cMnemEmpGcx().set(bhtr0112().fht011Registo().fht011CMnemContxt());
        bhyl009a().commarea().dadosInput().cBanco().set(bhtr0112().fht011Registo().fht011CBancContxt());
        bhyl009a().commarea().dadosInput().cOeEgc().set(0);
        bhyl009a().commarea().dadosInput().cIdioIso().set(bhtr0112().fht011Registo().fht011CIdioContxt());
        bhyl009a().commarea().dadosInput().iModAcesPais().setTrue() ;
        log(TraceLevel.Debug, "BHYL009A-C-MAPA          : ", bhyl009a().commarea().dadosInput().cMapa());
        log(TraceLevel.Debug, "BHYL009A-C-PAIS-ISO-ALFN : ", bhyl009a().commarea().dadosInput().cPaisIsoAlfn());
        log(TraceLevel.Debug, "BHYL009A-C-MNEM-EMP-GCX  : ", bhyl009a().commarea().dadosInput().cMnemEmpGcx());
        log(TraceLevel.Debug, "BHYL009A-C-BANCO         : ", bhyl009a().commarea().dadosInput().cBanco());
        log(TraceLevel.Debug, "BHYL009A-C-OE-EGC        : ", bhyl009a().commarea().dadosInput().cOeEgc());
        log(TraceLevel.Debug, "BHYL009A-C-IDIO-ISO      : ", bhyl009a().commarea().dadosInput().cIdioIso());
        log(TraceLevel.Debug, "BHYL009A-I-MOD-ACESSO    : ", bhyl009a().commarea().dadosInput().iModAcesso());
        bhyp0009RotMapas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MHYJ009A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhyl009a().commarea().dadosErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhyl009a().commarea().dadosErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhyl009a().commarea().dadosErro().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhyl009a().commarea().dadosErro().semErros().isTrue() && !bhyl009a().commarea().dadosErro().fimConsulta().isTrue() && 
            !bhyl009a().commarea().dadosErro().erroFuncao().isTrue() && 
            !bhyl009a().commarea().dadosErro().abend().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhyl009a().commarea().dadosErro().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhyl009a().commarea().dadosErro().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MHYJ009A);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhyl009a().commarea().dadosErro().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhyl009a().commarea().dadosInput());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhyl009a().commarea().dadosErro().cRtnoEvenSwal());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-DESCARREGA-TAB-MOV-FICH
     * STEP DE DESDOBRAMENTO DO FICHEIRO DE INPUT DE ACORDO COM OS
     * FICHEIROS OBTIDOS NA CONSULTA AH TABELA GERAL
     * 
     */
    protected void m2300DescrrgTabMovFich() {
        log(TraceLevel.Debug, "2300-DESCRRG-TAB-MOV-FICH");
        log(TraceLevel.Debug, "WS-IND-TAB-MAX: ", wsVariaveis().wsIndTabMax());
        wsVariaveis().wsIGrazCoe().set("N");
        if (!wsVariaveis().wsChvCtaAct().isEqual(wsVariaveis().wsChvCtaAnt()) && 
            (wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro().isEqual(CON_FILE_V11) || 
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro().isEqual(CON_FILE_V12) || 
            wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro().isEqual(CON_FILE_V112))) {
            m2400VerificaCtaCoe() ;
        }
        m2310FormataOutput() ;
        if (wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro().isEqual(CON_FILE_V17)) {
            if (bghr1701().registo().cEvenOpel().isEqual("HVA4")) {
                m2320AcedeTho13() ;
                if (swStatus().swVho01301Ok().isTrue()) {
                    m2320EscreveOutput() ;
                }
            } else if (bghr1701().registo().cEvenOpel().isEqual("HVA2")) {
                if (!bghr1701().registo().nCheque().isEqual(0)) {
                    m2320EscreveOutput() ;
                }
            } else {
                m2320EscreveOutput() ;
            }
        } else if (wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro().isEqual(CON_FILE_V11)) {
            if (!bghr1701().registo().cFamiProd().isEqual("410") && 
                !bghr1701().registo().cFamiProd().isEqual("411") && 
                !bghr1701().registo().cFamiProd().isEqual("352")) {
                m2320EscreveOutput() ;
            }
        } else {
            m2320EscreveOutput() ;
        }
        wsVariaveis().tabMovFich().incIndex() ;
    }
    
    /**
     * 
     * 2310-FORMATA-OUTPUT
     * DESC: FORMATAR OS CAMPOS DO OUTPUT + O FICHEIRO ONDE O
     * RESPECTIVO MOVIMENTO SEGUE
     * 
     */
    protected void m2310FormataOutput() {
        log(TraceLevel.Debug, "2310-FORMATA-OUTPUT");
        bghr1701().registo().subconta().set(bhor1771().registo().subconta());
        bghr1701().registo().nsMovimento().set(bhor1771().registo().nsMovimento());
        bghr1701().registo().zContabilizacao().set(bhor1771().registo().zContabilizacao());
        bghr1701().registo().zMovimento().set(bhor1771().registo().zMovimento());
        bghr1701().registo().zValor().set(bhor1771().registo().zValor());
        bghr1701().registo().iDbcr().set(bhor1771().registo().iDbcr());
        bghr1701().registo().mMovimento().set(bhor1771().registo().mMovimento());
        bghr1701().registo().mSldoCblo().set(bhor1771().registo().mSldoCblo());
        bghr1701().registo().mSldoDpnl().set(bhor1771().registo().mSldoDpnl());
        bghr1701().registo().cMoedIsoOriMov().set(bhor1771().registo().cMoedIsoOriMov());
        bghr1701().registo().mMovMoeOrigMov().set(bhor1771().registo().mMovMoeOrigMov());
        bghr1701().registo().tCambio().set(bhor1771().registo().tCambio());
        bghr1701().registo().cOpeBbn().set(bhor1771().registo().cOpeBbn());
        bghr1701().registo().xRefMov().set(bhor1771().registo().xRefMov());
        bghr1701().registo().nCheque().set(bhor1771().registo().nCheque());
        bghr1701().registo().iEstorno().set(bhor1771().registo().iEstorno());
        bghr1701().registo().nsMovEtnd().set(bhor1771().registo().nsMovEtnd());
        bghr1701().registo().iTrnzEfcdOnln().set(bhor1771().registo().iTrnzEfcdOnln());
        bghr1701().registo().iTipoOrigTrnz().set(bhor1771().registo().iTipoOrigTrnz());
        bghr1701().registo().iExiAtzJourBbn().set(bhor1771().registo().iExiAtzJourBbn());
        bghr1701().registo().cTipoCanlAces().set(bhor1771().registo().cTipoCanlAces());
        bghr1701().registo().aAplicacao().set(bhor1771().registo().aAplicacao());
        bghr1701().registo().cOpczMenu().set(bhor1771().registo().cOpczMenu());
        bghr1701().registo().cFamiProd().set(bhor1771().registo().cFamiProd());
        bghr1701().registo().cProduto().set(bhor1771().registo().cProduto());
        bghr1701().registo().cSectIttlBpor().set(bhor1771().registo().cSectIttlBpor());
        bghr1701().registo().cPaisIsoaGerx().set(bhor1771().registo().cPaisIsoaGerx());
        bghr1701().registo().cBancGcxGerx().set(bhor1771().registo().cBancGcxGerx());
        bghr1701().registo().cOeEgcGerx().set(bhor1771().registo().cOeEgcGerx());
        bghr1701().registo().iMovActzVsld().set(bhor1771().registo().iMovActzVsld());
        bghr1701().registo().zProcessamento().set(bhor1771().registo().zProcessamento());
        bghr1701().registo().cMnemEgcOpex().set(bhor1771().registo().cMnemEgcOpex());
        bghr1701().registo().cPaisIsoaOeOpx().set(bhor1771().registo().cPaisIsoaOeOpx());
        bghr1701().registo().cOeEgcOpex().set(bhor1771().registo().cOeEgcOpex());
        bghr1701().registo().cUserid().set(bhor1771().registo().cUserid());
        bghr1701().registo().nJourBbn().set(bhor1771().registo().nJourBbn());
        bghr1701().registo().nsJourBbn().set(bhor1771().registo().nsJourBbn());
        bghr1701().registo().nsJourBbnDtlh().set(bhor1771().registo().nsJourBbnDtlh());
        bghr1701().registo().mSldoRetd().set(bhor1771().registo().mSldoRetd());
        bghr1701().registo().mSldoVcob().set(bhor1771().registo().mSldoVcob());
        bghr1701().registo().mSldoVcobUtid().set(bhor1771().registo().mSldoVcobUtid());
        bghr1701().registo().mDcboNgcdAtrd().set(bhor1771().registo().mDcboNgcdAtrd());
        bghr1701().registo().mDcboNgcdUtid().set(bhor1771().registo().mDcboNgcdUtid());
        bghr1701().registo().mCmrgLim().set(bhor1771().registo().mCmrgLim());
        bghr1701().registo().mCmrgUtid().set(bhor1771().registo().mCmrgUtid());
        bghr1701().registo().qDiaCalcJuro().set(bhor1771().registo().qDiaCalcJuro());
        bghr1701().registo().cTipoJuro().set(bhor1771().registo().cTipoJuro());
        bghr1701().registo().iTipoCalcJuro().set(bhor1771().registo().iTipoCalcJuro());
        bghr1701().registo().iPenalizacao().set(bhor1771().registo().iPenalizacao());
        bghr1701().registo().qRenovacao().set(bhor1771().registo().qRenovacao());
        bghr1701().registo().nsUtizCmrg().set(bhor1771().registo().nsUtizCmrg());
        bghr1701().registo().cEvenOpel().set(bhor1771().registo().cEvenOpel());
        bghr1701().registo().tsActzUlt().set(bhor1771().registo().tsActzUlt());
        bghr1701().registo().cUsidActzUlt().set(bhor1771().registo().cUsidActzUlt());
        bghr1701().registo().nmFicheiro().set(wsVariaveis().tabMovFich().getCurrent().wsMovFich().wsNmFicheiro());
        log(TraceLevel.Debug, "::WS-I-GRAZ-COE...: ", wsVariaveis().wsIGrazCoe());
        bghr1701().registo().iGrazCoe().set(wsVariaveis().wsIGrazCoe());
        bghr1701().registo().filler().set(" ");
    }
    
    /**
     * 
     * 2320-ACEDE-THO13
     * 
     */
    protected void m2320AcedeTho13() {
        log(TraceLevel.Debug, "2320-ACEDE-THO13");
        hv01301Indisp().indisp().zProcessamento().set(bghr1701().registo().zProcessamento());
        hv01301Indisp().indisp().cMnemEgcOpex().set(bghr1701().registo().cMnemEgcOpex());
        hv01301Indisp().indisp().cPaisIsoaOeOpx().set(bghr1701().registo().cPaisIsoaOeOpx());
        hv01301Indisp().indisp().cOeEgcOpex().set(bghr1701().registo().cOeEgcOpex());
        hv01301Indisp().indisp().cUserid().set(bghr1701().registo().cUserid());
        hv01301Indisp().indisp().nJourBbn().set(bghr1701().registo().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO01301_INDISP
         */
        hv01301Indisp().selectPghq170a1109() ;
        swStatus().statusVho01301().set(hv01301Indisp().getPersistenceCode());
        if (!swStatus().swVho01301Ok().isTrue() && !swStatus().swVho01301Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(hv01301Indisp().getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set("VHO01301");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set("SE");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-ACEDE-THO13");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2320-ESCREVE-OUTPUT
     * 
     */
    protected void m2320EscreveOutput() {
        log(TraceLevel.Debug, "2320-ESCREVE-OUTPUT");
        ficheiroFwk002().write(ficheiroFwk002().regFwk002400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK002);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk002().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk002().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk002().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-WRITE-FICH-PRD");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk002().add(1);
        }
    }
    
    /**
     * 
     * 2400-VERIFICA-CTA-COE
     * 
     */
    protected void m2400VerificaCtaCoe() {
        log(TraceLevel.Debug, "2400-VERIFICA-CTA-COE");
        bhol708a().commarea().initialize() ;
        bhol708a().commarea().dadosInput().conta().cPaisIsoaCont().set(bhor1771().registo().subconta().cPaisIsoaCont());
        bhol708a().commarea().dadosInput().conta().cBancCont().set(bhor1771().registo().subconta().cBancCont());
        bhol708a().commarea().dadosInput().conta().cOeEgcCont().set(bhor1771().registo().subconta().cOeEgcCont());
        bhol708a().commarea().dadosInput().conta().nsRdclCont().set(bhor1771().registo().subconta().nsRdclCont());
        bhol708a().commarea().dadosInput().conta().vChkdCont().set(bhor1771().registo().subconta().vChkdCont());
        bhol708a().commarea().dadosInput().conta().cTipoCont().set(bhor1771().registo().subconta().cTipoCont());
        bhol708a().commarea().dadosInput().consulta().setTrue() ;
        bhop0708ValConta() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhol708a().conMhoj708a());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhol708a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhol708a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhol708a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhol708a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().nmPrograma().set(bhol708a().conMhoj708a());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhol708a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhol708a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhol708a().commarea().dadosInput());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_NOME_PROGRAMA);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhol708a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERR_ACES_MHOL708A);
        } else {
            wsVariaveis().wsIGrazCoe().set(bhol708a().commarea().dadosOutput().vho00101().iGrazCoe());
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        m3100FecharFicheiros() ;
        m3200EscreveEstat() ;
    }
    
    /**
     * 
     * 3100-FECHAR-FICHEIROS
     * 
     */
    protected void m3100FecharFicheiros() {
        log(TraceLevel.Debug, " --3100-FECHAR-FICHEIROS");
        m3110CloseFwk001() ;
        m3120CloseFwk002() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FWK001
     * 
     */
    protected void m3110CloseFwk001() {
        log(TraceLevel.Debug, "3110-CLOSE-FWK001");
        ficheiroFwk001().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FWK001");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-CLOSE-FWK002
     * 
     */
    protected void m3120CloseFwk002() {
        log(TraceLevel.Debug, "3120-CLOSE-FWK002");
        ficheiroFwk002().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK002);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk002().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk002().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk002().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FWK002");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3200-ESCREVE-ESTAT
     * 
     */
    protected void m3200EscreveEstat() {
        log(TraceLevel.Debug, "3200-ESCREVE-ESTAT");
        bhop0013FimEstatistica() ;
        log(TraceLevel.Trace, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Trace, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFwk001().close() ;
        ficheiroFwk002().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
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
     * AREA DE LIGACAO AH ROTINA MHGJ011A
     * AREA DE LIGACAO AH ROTINA MHYJ009A
     * COPYBOOK DE ESTRUTURA DO FICHEIRO DE INPUT
     * COPYBOOK DE FORMATACAO DO FICHEIRO DE OUTPUT
     * COPYBOOK DE LIGACAO AH ROTINA MHOJ708A - VALIDACAO DE CONTA
     * DEFINICAO DE TABELAS DB2
     * DEFINICAO DA SQL COMMUNICATION AREA
     * STATUS
     * 
     * @version 2.0
     * 
     */
    public interface SwStatus extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition fhy003Ok() ;
        @Data
        @Condition("10")
        ICondition fhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk001() ;
        @Data
        @Condition("00")
        ICondition swFwk001Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk001Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk002() ;
        @Data
        @Condition("00")
        ICondition swFwk002Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk002Eof() ;
        
        
        /**
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt statusVho01301() ;
        @Data
        @Condition("0")
        ICondition swVho01301Ok() ;
        @Data
        @Condition("100")
        ICondition swVho01301Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVho01301Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVho01301Null() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString wsSysin() ;
        
        @Data(size=15, value="0")
        ILong wsLidosFwk001() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk002() ;
        
        @Data(size=1, value=" ")
        IString wsIGrazCoe() ;
        
        /**
         * @return instancia da classe local WsXCteuMhtq250a
         */
        @Data
        WsXCteuMhtq250a wsXCteuMhtq250a() ;
        
        /**
         * ****          CHAVE ACTUAL
         * @return instancia da classe local WsChvAct
         */
        @Data
        WsChvAct wsChvAct() ;
        
        /**
         * ****          CHAVE ANTERIOR
         * @return instancia da classe local WsChvAnt
         */
        @Data
        WsChvAnt wsChvAnt() ;
        
        /**
         * ****          CHAVE DE CONTA ANTERIOR
         * @return instancia da classe local WsChvCtaAnt
         */
        @Data
        WsChvCtaAnt wsChvCtaAnt() ;
        
        /**
         * ****          CHAVE DE CONTA ACTUAL
         * @return instancia da classe local WsChvCtaAct
         */
        @Data
        WsChvCtaAct wsChvCtaAct() ;
        
        /**
         * ****          TABELA INTERNA
         */
        @Data(size=4, value="0")
        IInt wsIndice() ;
        
        @Data(size=5, value="0")
        IInt wsIndTabMax() ;
        
        /**
         * @return instancia da classe local TabMovFich
         */
        @Data(length=9999)
        IArray<TabMovFich> tabMovFich() ;
        
        
        public interface WsXCteuMhtq250a extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString wsCPaisIsoMhyq250a() ;
            
            @Data(size=8, value=" ", lpadding=3, rpadding=79, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsAAplSgccMhyq250a() ;
            
        }
        
        
        /**
         * 
         * ****          CHAVE ACTUAL
         * 
         * @version 2.0
         * 
         */
        public interface WsChvAct extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCMnemEgcOpexAct() ;
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaOeOpxAct() ;
            
            @Data(size=2, value=" ")
            IString wsAAplicacaoAct() ;
            
            @Data(size=4, value=" ")
            IString wsCEvenOpelAct() ;
            
            @Data(size=5, value=" ")
            IString wsCOpeBbnAct() ;
            
        }
        
        
        /**
         * 
         * ****          CHAVE ANTERIOR
         * 
         * @version 2.0
         * 
         */
        public interface WsChvAnt extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCMnemEgcOpexAnt() ;
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaOeOpxAnt() ;
            
            @Data(size=2, value=" ")
            IString wsAAplicacaoAnt() ;
            
            @Data(size=4, value=" ")
            IString wsCEvenOpelAnt() ;
            
            @Data(size=5, value=" ")
            IString wsCOpeBbnAnt() ;
            
        }
        
        
        /**
         * 
         * ****          CHAVE DE CONTA ANTERIOR
         * 
         * @version 2.0
         * 
         */
        public interface WsChvCtaAnt extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaContAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancContAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCOeEgcContAnt() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRdclContAnt() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsVChkdContAnt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsCTipoContAnt() ;
            
        }
        
        
        /**
         * 
         * ****          CHAVE DE CONTA ACTUAL
         * 
         * @version 2.0
         * 
         */
        public interface WsChvCtaAct extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaContAct() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancContAct() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCOeEgcContAct() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRdclContAct() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsVChkdContAct() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsCTipoContAct() ;
            
        }
        
        public interface TabMovFich extends IDataStruct {
            
            
            /**
             * @return instancia da classe local WsMovFich
             */
            @Data
            WsMovFich wsMovFich() ;
            
            
            public interface WsMovFich extends IDataStruct {
                
                @Data(size=2)
                IString wsAAplicacao() ;
                
                @Data(size=4)
                IString wsCEvenOpel() ;
                
                @Data(size=5)
                IString wsCOpeBbn() ;
                
                @Data(size=6)
                IString wsNmFicheiro() ;
                
            }
        }
    }
    
}
