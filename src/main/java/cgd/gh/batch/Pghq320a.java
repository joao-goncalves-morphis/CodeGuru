package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
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
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtw0011 ;
import cgd.ho.structures.work.Bhow0013 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.gh.structures.work.Bghr3201 ;
import cgd.ht.routines.Mhtq111a ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE OUTPUT
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq320a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011", record="statusFht011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk00101
     */
    @Handler(name="FWK001", record="regFwk001Pghq320a")
    @Data
    protected abstract Fwk00101 ficheiroFwk001() ;
    
    /**
     * @return instancia da classe Fgh320
     */
    @Handler(name="FGH320", record="regFgh320110")
    @Data
    protected abstract Fgh320 ficheiroFgh320() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq111a
     */
    @Data
    protected abstract Mhtq111a hrMhtq111a() ;
    
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtw0011
     */
    @Data
    protected abstract Bhtw0011 bhtw0011() ;
    
    /**
     * @return instancia da classe Bhow0013
     */
    @Data
    protected abstract Bhow0013 bhow0013() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bghr3201
     */
    @Data
    protected abstract Bghr3201 bghr3201() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHQ320A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_FGH320 = "FGH320" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ320A" ;
    
    protected static final String CON_PROGRAM_DESC = "MOVIMENTOS DE CREDITO DE VENCIMENTO" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_I_DBCR_CREDITO = "C" ;
    
    /**
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsSwitches
     */
    @Data
    protected abstract WsSwitches wsSwitches() ;
    
    
    
    /**
     * 
     * 
     */
    protected void bhtp0030DisplayErro() {
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "*       INFORMACAO SOBRE O ERRO OCORRIDO       *");
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "NOME PROGRAMA:", bhtw0030().dadosEntrada().nmPrograma());
        log(TraceLevel.Trace, "NOME PROGRAMA:", bhtw0030().dadosEntrada().nmPrograma());
        log(TraceLevel.Trace, "DATA INICIO:", bhtw0030().dadosEntrada().zInicExePrg());
        log(TraceLevel.Trace, "DATA FIM:", bhtw0030().dadosEntrada().zErro());
        log(TraceLevel.Trace, "HORA INICIO:", bhtw0030().dadosEntrada().hInicExePrg());
        log(TraceLevel.Trace, "HORA FIM:", bhtw0030().dadosEntrada().hErro());
        log(TraceLevel.Trace, "OBSERVACOES:", bhtw0030().dadosEntrada().xSugRtnoSwal());
        log(TraceLevel.Trace, "TIPO ERRO:", bhtw0030().dadosEntrada().cTipoErroBbn());
        if (bhtw0030().dadosEntrada().abendDb2().isTrue()) {
            log(TraceLevel.Trace, "SQLCODE:", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Trace, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Trace, "NOME TABELA:", bhtw0030().dadosEntrada().nmTabela());
            log(TraceLevel.Trace, "ACESSO TABELA:", bhtw0030().dadosEntrada().xCteuChavTab());
        } else if (bhtw0030().dadosEntrada().abend().isTrue()) {
            log(TraceLevel.Trace, "NOME ROTINA:", bhtw0030().dadosEntrada().nmPrgChmd());
            log(TraceLevel.Trace, "CODIGO RETORNO ROTINA:", bhtw0030().dadosEntrada().cTipoErrPrgChmd());
            log(TraceLevel.Trace, "AREA INPUT ROTINA:", bhtw0030().dadosEntrada().xCteuAlig());
            log(TraceLevel.Trace, "SQLCODE:", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Trace, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Trace, "NOME TABELA:", bhtw0030().dadosEntrada().nmTabela());
            log(TraceLevel.Trace, "ACESSO TABELA:", bhtw0030().dadosEntrada().xCteuChavTab());
        } else if (bhtw0030().dadosEntrada().abendFicheiro().isTrue()) {
            log(TraceLevel.Trace, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Trace, "NOME FICHEIRO:", bhtw0030().dadosEntrada().nmFicheiro());
            log(TraceLevel.Trace, "FILE STATUS:", bhtw0030().dadosEntrada().cFsttCobl());
        } else if (bhtw0030().dadosEntrada().cFsttCobl().isNumeric()) {
            log(TraceLevel.Error, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Error, "NOME FICHEIRO:", bhtw0030().dadosEntrada().nmFicheiro());
            log(TraceLevel.Error, "FILE STATUS:", bhtw0030().dadosEntrada().cFsttCobl());
        } else {
            log(TraceLevel.Error, "NOME ROTINA:", bhtw0030().dadosEntrada().nmPrgChmd());
            log(TraceLevel.Error, "CODIGO RETORNO ROTINA:", bhtw0030().dadosEntrada().cTipoErrPrgChmd());
            log(TraceLevel.Error, "AREA INPUT ROTINA:", bhtw0030().dadosEntrada().xCteuAlig());
            log(TraceLevel.Error, "SQLCODE:", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Error, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Error, "NOME TABELA:", bhtw0030().dadosEntrada().nmTabela());
            log(TraceLevel.Error, "ACESSO TABELA:", bhtw0030().dadosEntrada().xCteuChavTab());
        }
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "*    FIM DA INFORMACAO SOBRE O ERRO OCORRIDO   *");
        log(TraceLevel.Trace, "************************************************");
    }
    
    /**
     * 
     * BHTP0011
     * DADOS DEFAULT PARA PROCESSAMENTO BATCH
     * 
     */
    protected void bhtp0011ObtemDados() {
    }
    
    /**
     * 
     * ABRE FICHEIRO
     * 
     */
    protected void bhtp0011AbreFicheiro() {
        ficheiroFht011().open() ;
    }
    
    /**
     * 
     * FECHA FICHEIRO
     * 
     */
    protected void bhtp0011FechaFicheiro() {
        ficheiroFht011().close() ;
    }
    
    /**
     * 
     * AREA COMUM
     * 
     */
    protected void bhtp0011Comum() {
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhtw0030().dadosEntrada().nmFicheiro().set("FHT011");
        bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
    }
    
    /**
     * 
     * BHTP0011-ABEND
     * 
     */
    protected void bhtp0011Abend() {
        log(TraceLevel.Trace, "VAI AH ROTINA MHTQ111A FAZER ROLLBACK");
        bhtw0011().erro().setTrue() ;
        setReturnCode(bhtw0011().returnCode()) ;
        exit() ;
    }
    
    /**
     * 
     * CONTAS
     * PROCEDURE: BHOP0013.
     * -CONTEM CODIGO NECESSARIO PARA GESTAO DE INFORMACAO A
     * ESCREVER NO FICH. DE ESTAT. BATCH.
     * 
     */
    protected void bhop0013InicioEstat() {
        bhow0013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhow0013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhow0013().dadosAuxiliares().dataAux().dataAuxAno());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhow0013().dadosAuxiliares().dataAux().dataAuxMes());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhow0013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zInicPrct().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0033().dadosGerais().nmPrograma().set(bhow0013().dadosInput().nmPrograma());
        bhtw0033().dadosGerais().dFunlPrg().set(bhow0013().dadosInput().dFunlPrg());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2H().set(bhow0013().dadosAuxiliares().horaAux().horaAuxH());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2M().set(bhow0013().dadosAuxiliares().horaAux().horaAuxM());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2S().set(bhow0013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hInicPrct().set(bhow0013().dadosAuxiliares().horaAux2());
        bhow0013().dadosAuxiliares().qAces().set(1);
    }
    
    /**
     * 
     * BHOP0013-FORMATA-ACESSO
     * 
     */
    protected void bhop0013FormataAcesso() {
        bhow0013().dadosAuxiliares().tiAcesso().resetIndex() ;
        while (bhow0013().dadosAuxiliares().tiAcesso().index().isLessOrEqual(99)) {
            if ((bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_FICHEIRO) && 
                bhow0013().dadosInput().dadosFicheiro().nmFicheiro().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro()) && 
                bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich()) && 
                bhow0013().dadosInput().dadosFicheiro().cFsttCobl().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl())) || 
                (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_TABELA) && 
                bhow0013().dadosInput().dadosTabela().nmTabela().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela()) && 
                bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2()) && 
                bhow0013().dadosInput().dadosTabela().cSqlcode().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode())) || 
                (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_ROTINA) && 
                bhow0013().dadosInput().dadosRotinas().nmRotina().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina()) && 
                bhow0013().dadosInput().dadosRotinas().iOperacao().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao()) && 
                bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn()) && 
                bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal()) && 
                bhow0013().dadosInput().dadosRotinas().aAplErr().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr()))) {
                bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().add(bhow0013().dadosAuxiliares().qAces());
                break;
            }
            if (bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEmpty()) {
                break;
            }
            bhow0013().dadosAuxiliares().tiAcesso().incIndex() ;
        }
    }
    
    /**
     * 
     * BHOP0013-CRIA-REGISTO
     * 
     */
    protected void bhop0013CriaRegisto() {
        bhow0013().dadosAuxiliares().tiAcesso().getCurrent().initialize() ;
        bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().set(bhow0013().dadosAuxiliares().qAces());
    }
    
    /**
     * 
     * BHOP0013-FIM-ESTATISTICA
     * 
     */
    protected void bhop0013FimEstatistica() {
        bhow0013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhow0013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhow0013().dadosAuxiliares().dataAux().dataAuxAno());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhow0013().dadosAuxiliares().dataAux().dataAuxMes());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhow0013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zFimPrct().set(bhow0013().dadosAuxiliares().dataAux2());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2H().set(bhow0013().dadosAuxiliares().horaAux().horaAuxH());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2M().set(bhow0013().dadosAuxiliares().horaAux().horaAuxM());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2S().set(bhow0013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hFimPrct().set(bhow0013().dadosAuxiliares().horaAux2());
        bhow0013().dadosAuxiliares().tiAcesso().resetIndex() ;
    }
    
    /**
     * 
     * BHOP0013-DETALHE-ESTAT
     * 
     */
    protected void bhop0013DetalheEstat() {
        bhow0013().dadosAuxiliares().tiAcesso().incIndex() ;
    }
    
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
        m1400ObtemDataApl() ;
        m1500OpenFicheiros() ;
        m1600ReadFwk001() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        bghr3201().registo().initialize() ;
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
     * 1400-OBTEM-DATA-APL
     * 
     */
    protected void m1400ObtemDataApl() {
        log(TraceLevel.Debug, "1400-OBTEM-DATA-APL");
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO PARAGRAFO 1400-OBTEM-DATA-APL");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500OpenFicheiros() {
        log(TraceLevel.Debug, "1500-OPEN-FICHEIROS");
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
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
        ficheiroFgh320().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH320);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh320().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh320().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH320);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh320().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FWK001
     * 
     */
    protected void m1600ReadFwk001() {
        log(TraceLevel.Debug, "1600-READ-FWK001");
        ficheiroFwk001().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk001().getStatusOk() && !ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FWK001");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        m2100ObtemDadTgh02() ;
        if (hv00201Movhst().movhst().iDbcr().isEqual(CON_I_DBCR_CREDITO)) {
            m2200EscreveOutput() ;
        }
        m1600ReadFwk001() ;
    }
    
    /**
     * 
     * 2100-OBTEM-DAD-TGH02
     * 
     */
    protected void m2100ObtemDadTgh02() {
        log(TraceLevel.Debug, "2100-OBTEM-DAD-TGH02");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFwk001().regFwk001Pghq320a().fwk001CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFwk001().regFwk001Pghq320a().fwk001CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFwk001().regFwk001Pghq320a().fwk001COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(ficheiroFwk001().regFwk001Pghq320a().fwk001NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(ficheiroFwk001().regFwk001Pghq320a().fwk001VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(ficheiroFwk001().regFwk001Pghq320a().fwk001CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFwk001().regFwk001Pghq320a().fwk001CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFwk001().regFwk001Pghq320a().fwk001NsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(ficheiroFwk001().regFwk001Pghq320a().fwk001TsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(ficheiroFwk001().regFwk001Pghq320a().fwk001NsMovimento());
        log(TraceLevel.Debug, "C-PAIS-ISOA-CONT: ", hv00201Movhst().movhst().cPaisIsoaCont());
        log(TraceLevel.Debug, "C-BANC-CONT     : ", hv00201Movhst().movhst().cBancCont());
        log(TraceLevel.Debug, "C-OE-EGC-CONT   : ", hv00201Movhst().movhst().cOeEgcCont());
        log(TraceLevel.Debug, "NS-RDCL-CONT    : ", hv00201Movhst().movhst().nsRdclCont());
        log(TraceLevel.Debug, "V-CHKD-CONT     : ", hv00201Movhst().movhst().vChkdCont());
        log(TraceLevel.Debug, "C-TIPO-CONT     : ", hv00201Movhst().movhst().cTipoCont());
        log(TraceLevel.Debug, "C-MOED-ISO-SCTA : ", hv00201Movhst().movhst().cMoedIsoScta());
        log(TraceLevel.Debug, "NS-DEPOSITO     : ", hv00201Movhst().movhst().nsDeposito());
        log(TraceLevel.Debug, "TS-MOVIMENTO    : ", hv00201Movhst().movhst().tsMovimento());
        log(TraceLevel.Debug, "NS-MOVIMENTO    : ", hv00201Movhst().movhst().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq320a489() ;
        wsSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!wsSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-OBTEM-DAD-TGH02");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2200-ESCREVE-OUTPUT
     * 
     */
    protected void m2200EscreveOutput() {
        log(TraceLevel.Debug, "2200-ESCREVE-OUTPUT");
        hv10201Movhstcpl().movhstcpl().cOpeBbn().set(ficheiroFwk001().regFwk001Pghq320a().fwk001COpeBbn());
        hv10201Movhstcpl().movhstcpl().cEvenOpel().set(ficheiroFwk001().regFwk001Pghq320a().fwk001CEvenOpel());
        hv10201Movhstcpl().movhstcpl().mCmrgLim().set(ficheiroFwk001().regFwk001Pghq320a().fwk001MCmrgLim());
        bghr3201().registo().cPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        bghr3201().registo().cBancCont().set(hv00201Movhst().movhst().cBancCont());
        bghr3201().registo().cOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        bghr3201().registo().nsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        bghr3201().registo().vChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        bghr3201().registo().cTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        bghr3201().registo().cMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        bghr3201().registo().nsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        bghr3201().registo().nsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        bghr3201().registo().zMovLocl().set(hv00201Movhst().movhst().zMovLocl());
        bghr3201().registo().mCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
        bghr3201().registo().mMovimento().set(hv00201Movhst().movhst().mMovimento());
        bghr3201().registo().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        bghr3201().registo().cEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        bghr3201().registo().zExtracao().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        ficheiroFgh320().write(ficheiroFgh320().regFgh320110) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH320);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh320().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh320().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH320);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh320().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-ESCREVE-OUTPUT");
            m9900Abend() ;
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
        m3110CloseFicheiros() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FICHEIROS
     * 
     */
    protected void m3110CloseFicheiros() {
        log(TraceLevel.Debug, "3110-CLOSE-FICHEIROS");
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
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FICHEIROS");
            m9900Abend() ;
        }
        ficheiroFgh320().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH320);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh320().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh320().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH320);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh320().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FICHEIROS");
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
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFwk001().close() ;
        ficheiroFgh320().close() ;
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
        ICondition fwk001Ok() ;
        @Data
        @Condition("10")
        ICondition fwk001Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh320() ;
        @Data
        @Condition("00")
        ICondition swFgh320Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh320Eof() ;
        
        
    }
    public interface WsSwitches extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
    }
    
}
