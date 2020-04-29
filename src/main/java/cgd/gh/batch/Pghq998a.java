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
import cgd.ht.structures.work.Bhtr0112 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.hj.common.constants.Bhjk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr4371 ;
import cgd.gh.structures.work.Bghr4391 ;
import cgd.gh.structures.work.Bghr4381 ;
import cgd.gh.structures.work.Bghr1231 ;
import cgd.ht.structures.work.Bhtw7000 ;
import cgd.ht.routines.Mhtq250a ;
import cgd.zy.batch.Pzya710a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE INPUT
 * CLAUSULAS DE FILE DEFINITION DOS FICHEIROS DE OUTPUT
 * WORKING STORAGE SECTION
 * COPYBOOK DE REGISTO DOS FICHEIROS DE OUTPUT
 * DECLARACAO DE CURSORES
 * *-- CURSOR DA THJ08/12
 * *-- CURSOR DA THJ08
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq998a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhjps00801Relcon
     */
    @Data
    protected abstract Vwsdhjps00801Relcon hv00801Relcon() ;
    
    /**
     * @return instancia da classe Vwsdhjps01201Bloqueios
     */
    @Data
    protected abstract Vwsdhjps01201Bloqueios hv01201Bloqueios() ;
    
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    /**
     * @return instancia da classe Vwsdghps02401Movhist4
     */
    @Data
    protected abstract Vwsdghps02401Movhist4 hv02401Movhist4() ;
    
    /**
     * @return instancia da classe Vwsdghps02501Movhist5
     */
    @Data
    protected abstract Vwsdghps02501Movhist5 hv02501Movhist5() ;
    
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    /**
     * @return instancia da classe Vwsdghps02801Movhist8
     */
    @Data
    protected abstract Vwsdghps02801Movhist8 hv02801Movhist8() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh437
     */
    @Handler(name="FGH437", record="statusFgh437")
    @Data
    protected abstract Fgh437 ficheiroFgh437() ;
    
    /**
     * @return instancia da classe Fgh439
     */
    @Handler(name="FGH439", record="regFgh43980")
    @Data
    protected abstract Fgh439 ficheiroFgh439() ;
    
    /**
     * @return instancia da classe Fgh438
     */
    @Handler(name="FGH438", record="regFgh43886")
    @Data
    protected abstract Fgh438 ficheiroFgh438() ;
    
    /**
     * @return instancia da classe Fgh123
     */
    @Handler(name="FGH123", record="regFgh12380")
    @Data
    protected abstract Fgh123 ficheiroFgh123() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Pzya710a
     */
    @Data
    protected abstract Pzya710a hbPzya710a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0112
     */
    @Data
    protected abstract Bhtr0112 bhtr0112() ;
    
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
     * @return instancia da classe Bhjk0002
     */
    @Data
    protected abstract Bhjk0002 bhjk0002() ;
    
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
     * @return instancia da classe Bghr4371
     */
    @Data
    protected abstract Bghr4371 bghr4371() ;
    
    /**
     * @return instancia da classe Bghr4391
     */
    @Data
    protected abstract Bghr4391 bghr4391() ;
    
    /**
     * @return instancia da classe Bghr4381
     */
    @Data
    protected abstract Bghr4381 bghr4381() ;
    
    /**
     * @return instancia da classe Bghr1231
     */
    @Data
    protected abstract Bghr1231 bghr1231() ;
    
    /**
     * @return instancia da classe Bhtw7000
     */
    @Data
    protected abstract Bhtw7000 bhtw7000() ;
    
    /**
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    protected static final String CON_PROGRAM_DESC = "OBTENCAO DE SALDOS DE CLIENTE EM HISTORICO" ;
    
    protected static final String CON_FHT011 = "FHT011" ;
    
    protected static final String CON_FGH437 = "FGH437" ;
    
    protected static final String CON_FGH439 = "FGH439" ;
    
    protected static final String CON_FGH438 = "FGH438" ;
    
    protected static final String CON_FGH123 = "FGH123" ;
    
    protected static final String CON_MHYQ250A = "MHYQ250A" ;
    
    protected static final String CON_BHTP7000 = "BHTP7000" ;
    
    protected static final String CON_VHJ00801 = "VHJ00801" ;
    
    protected static final String CON_VHJ01201 = "VHJ01201" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH01001 = "VGH01001" ;
    
    protected static final String CON_VGH02301 = "VGH02301" ;
    
    protected static final String CON_VGH02401 = "VGH02401" ;
    
    protected static final String CON_VGH02501 = "VGH02501" ;
    
    protected static final String CON_VGH02601 = "VGH02601" ;
    
    protected static final String CON_VGH02701 = "VGH02701" ;
    
    protected static final String CON_VGH02801 = "VGH02801" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ998A" ;
    
    protected static final String CON_E = "E" ;
    
    protected static final String CON_T = "T" ;
    
    protected static final String CON_G = "G" ;
    
    protected static final String CON_D = "D" ;
    
    protected static final int CON_ZERO = 0 ;
    
    protected static final int CON_UM = 1 ;
    
    protected static final int CON_DOIS = 2 ;
    
    protected static final String CON_SEIS = "006" ;
    
    protected static final String CON_SEPARADOR = ";" ;
    
    protected static final String CON_FIC_PR = "PR" ;
    
    protected static final String CON_FIC_CQ = "CQ" ;
    
    protected static final String CON_GHSA = "GHSA" ;
    
    protected static final String CON_SINAL = "." ;
    
    protected static final int CON_TITULAR = 101 ;
    
    protected static final String CON_DATA_INICIO = "1990-01-01" ;
    
    /**
     * 05 CON-ANO-1990                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1990V2.G0001V00'.
     * 05 CON-ANO-1991                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1991V2.G0001V00'.
     * 05 CON-ANO-1992                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1992V2.G0001V00'.
     * 05 CON-ANO-1993                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1993V2.G0001V00'.
     * 05 CON-ANO-1994                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1994V2.G0001V00'.
     * 05 CON-ANO-1995                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1995V2.G0002V00'.
     * 05 CON-ANO-1996                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1996V2.G0002V00'.
     * 05 CON-ANO-1997                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1997V2.G0002V00'.
     * 05 CON-ANO-1998                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1998V2.G0002V00'.
     * 05 CON-ANO-1999                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA1999V2.G0002V00'.
     * 05 CON-ANO-2000                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2000V2.G0002V00'.
     * 05 CON-ANO-2001                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2001V2.G0001V00'.
     * 05 CON-ANO-2002                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2002V2.G0001V00'.
     * 05 CON-ANO-2003                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2003V2.G0001V00'.
     * 05 CON-ANO-2004                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2004V2.G0001V00'.
     * 05 CON-ANO-2005                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2005V2.G0001V00'.
     * 05 CON-ANO-2006                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2006V2.G0001V00'.
     * 05 CON-ANO-2007                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2007V2.G0001V00'.
     * 05 CON-ANO-2008                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2008V2.G0001V00'.
     * 05 CON-ANO-2009                PIC  X(32) VALUE
     * 'PGBBANC.FGH003.HA2009V2.G0001V00'.
     */
    protected static final String CON_GDG_1 = "PGBBANC.FGH003.HA" ;
    
    protected static final String CON_GDG_2 = "V2.G0001V00" ;
    
    protected static final String CON_MSG_1 = "INDICADOR DE OBITO TEM DE SER PREENCHIDO" ;
    
    protected static final String CON_MSG_2 = "SO O CLIENTE OU SO A CONTA PODE ESTAR PREENCHIDO" ;
    
    protected static final String CON_MSG_3 = "NECESSARIO PREENCHER CLIENTE OU CONTA" ;
    
    protected static final String CON_MSG_4 = "NECESSARIO PREENCHER DATA" ;
    
    protected static final String CON_MSG_5 = "NAO EXISTEM REGISTOS PARA A DATA INDICADA" ;
    
    protected static final String CON_MSG_6 = "DADOS INVALIDOS" ;
    
    protected static final String CON_MSG_7 = "SE INDICADOR OBITO A S NAO PREENCHER DATA" ;
    
    protected static final String CON_SORTIN = "SORTIN" ;
    
    protected static final String CON_SORT_OGHSO001 = "OGHSO001" ;
    
    /**
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsMsg
     */
    @Data
    protected abstract WsMsg wsMsg() ;
    
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
        hbPzya710a().run() ;
        if (returnCode == 0) {
            log(TraceLevel.Error, "NOME DO SISTEMA...=  ", bhtw7000().parmarea().area8());
        } else {
            bhtw7000().indicadoresErro().msgErrob().set("ERRO AO OBTER NOME DO SYS");
            bhtp7000TrataErros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemJobname() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
        hbPzya710a().run() ;
        if (returnCode == 0) {
            log(TraceLevel.Error, "NOME DO JOB........= ", bhtw7000().parmarea().area8());
        } else {
            bhtw7000().indicadoresErro().msgErrob().set("ERRO AO OBTER NOME DO JOB");
            bhtp7000TrataErros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemJobid() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
        hbPzya710a().run() ;
        if (returnCode == 0) {
            log(TraceLevel.Error, "ID DO JOB..........= ", bhtw7000().parmarea().area8());
        } else {
            bhtw7000().indicadoresErro().msgErrob().set("ERRO AO OBTER JOBID   ");
            bhtp7000TrataErros() ;
        }
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
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "*********** - INICIO - *************");
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        m2000ProcPrograma() ;
        m3000FinalPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        wsMsg().wsMsgPar().set("1000-INICIO-PROGRAMA");
        log(TraceLevel.Debug, wsMsg());
        m1100Inicializacoes() ;
        m1200ObterDadosBatch() ;
        m1300ObtemJobname() ;
        m1400TrataEstatIni() ;
        m1500ObterDatas() ;
        m1600AbreFicheiros() ;
        m1700LeFgh437() ;
        m1800Validacoes() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        wsMsg().wsMsgPar().set("1100-INICIALIZACOES");
        log(TraceLevel.Debug, wsMsg());
        wsVariaveis().initialize() ;
        hv00801Relcon().relcon().initialize() ;
        hv01201Bloqueios().bloqueios().initialize() ;
        hv00201Movhst().movhst().initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        hv02301Movhist3().movhist3().initialize() ;
        hv02401Movhist4().movhist4().initialize() ;
        hv02501Movhist5().movhist5().initialize() ;
        hv02601Movhist6().movhist6().initialize() ;
        hv02701Movhist7().movhist7().initialize() ;
        hv02801Movhist8().movhist8().initialize() ;
        bghr4371().fgh437Registo().initialize() ;
        bghr4381().fgh438Registo().initialize() ;
        bghr4391().fgh439Registo().initialize() ;
        bghr1231().fgh123Registo().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        wsVariaveis().wsContador().initialize() ;
        wsVariaveis().wsAnoGdg().initialize() ;
        wsVariaveis().wsGdg().initialize() ;
        bghr4391().wsLayoutEscrita().initialize() ;
        bhtl250a().commarea().initialize() ;
        bhtw7000().indicadoresErro().initialize() ;
    }
    
    /**
     * 
     * 1200-OBTER-DADOS-BATCH
     * 
     */
    protected void m1200ObterDadosBatch() {
        wsMsg().wsMsgPar().set("1200-OBTER-DADOS-BATCH");
        log(TraceLevel.Debug, wsMsg());
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FHT011);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
        bhop0013FormataAcesso() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FHT011);
            bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1300-OBTEM-JOBNAME
     * 
     */
    protected void m1300ObtemJobname() {
        wsMsg().wsMsgPar().set("1300-OBTEM-JOBNAME");
        log(TraceLevel.Debug, wsMsg());
        bhtw7000().indicadoresErro().initialize() ;
        bhtw7000().jobname().setTrue() ;
        bhtp7000DadosSistema() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_BHTP7000);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtw7000().indicadoresErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtw7000().indicadoresErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtw7000().indicadoresErro().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhtw7000().indicadoresErro().semErros().isTrue()) {
            if (bhtw7000().parmarea().area8().get(1, 1).isEqual(CON_E)) {
                wsVariaveis().wsAmbFic().set(CON_FIC_PR);
            }
            if (bhtw7000().parmarea().area8().get(1, 1).isEqual(CON_T)) {
                wsVariaveis().wsAmbFic().set(CON_FIC_CQ);
            }
            if (bhtw7000().parmarea().area8().get(1, 1).isEqual(CON_G)) {
                wsVariaveis().wsAmbFic().set(CON_FIC_CQ);
            }
            if (bhtw7000().parmarea().area8().get(1, 1).isEqual(CON_D)) {
                wsVariaveis().wsAmbFic().set(CON_FIC_CQ);
            }
        } else {
            if (!bhtw7000().indicadoresErro().semErros().isTrue()) {
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
                bhtw0030().dadosEntrada().nmPrgChmd().set(CON_BHTP7000);
                bhtw0030().dadosEntrada().xCteuAlig().set(bhtw7000().indicadoresErro().chAcesso());
                bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtw7000().indicadoresErro().cTipoErroBbn());
                bhtw0030().dadosEntrada().abend().setTrue() ;
            }
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1400-TRATA-ESTAT-INI
     * 
     */
    protected void m1400TrataEstatIni() {
        wsMsg().wsMsgPar().set("1400-TRATA-ESTAT-INI");
        log(TraceLevel.Debug, wsMsg());
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_PROGRAM_DESC);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1500-OBTER-DATAS
     * 
     */
    protected void m1500ObterDatas() {
        wsMsg().wsMsgPar().set("1500-OBTER-DATAS");
        log(TraceLevel.Debug, wsMsg());
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MHYQ250A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MHYQ250A);
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
     * 1600-ABRE-FICHEIROS
     * 
     */
    protected void m1600AbreFicheiros() {
        wsMsg().wsMsgPar().set("1600-ABRE-FICHEIROS");
        log(TraceLevel.Debug, wsMsg());
        /**
         * *--  ABRE FICHEIRO DE INPUT - FGH437
         */
        ficheiroFgh437().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH437);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh437().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh437().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH437);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh437().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
        /**
         * *--  ABRE FICHEIRO DE OUTPUT - FGH438
         */
        ficheiroFgh438().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH438);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh438().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh438().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH438);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh438().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
        /**
         * *--  ABRE FICHEIRO DE OUTPUT - FGH439
         */
        ficheiroFgh439().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH439);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh439().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh439().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH439);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh439().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
        /**
         * *--  ABRE FICHEIRO DE OUTPUT - FGH123
         */
        ficheiroFgh123().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH123);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh123().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh123().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH123);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh123().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1700-LE-FGH437
     * 
     */
    protected void m1700LeFgh437() {
        wsMsg().wsMsgPar().set("1700-LE-FGH437");
        log(TraceLevel.Debug, wsMsg());
        bghr4371().fgh437Registo().initialize() ;
        bghr4381().fgh438Registo().initialize() ;
        ficheiroFgh437().read(bghr4371().fgh437Registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH437);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh437().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh437().getStatusOk() && !ficheiroFgh437().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH437);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh437().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1800-VALIDACOES
     * 
     */
    protected void m1800Validacoes() {
        wsMsg().wsMsgPar().set("1800-VALIDACOES");
        log(TraceLevel.Debug, wsMsg());
        if (ficheiroFgh437().getStatusOk()) {
            if (bghr4371().fgh437Registo().fgh437IndicadorObito().isEmpty()) {
                bghr4381().fgh438MsgErro().set(CON_MSG_1);
                log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                m2900EscreveFgh438() ;
                swSwitches().swErroValNotok().setTrue() ;
            } else {
                swSwitches().swIndicadorObito().set(bghr4371().fgh437Registo().fgh437IndicadorObito());
            }
            if (swSwitches().swIndicadorObitoS().isTrue() && 
                !bghr4371().fgh437Registo().fgh437DataSaldo().isEmpty()) {
                bghr4381().fgh438MsgErro().set(CON_MSG_7);
                log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                m2900EscreveFgh438() ;
                swSwitches().swErroValNotok().setTrue() ;
            }
            if (bghr4371().fgh437Registo().fgh437NCliente().isNumeric() && bghr4371().fgh437Registo().fgh437CBancCont().isNumeric() && 
                bghr4371().fgh437Registo().fgh437COeEgcCont().isNumeric() && 
                bghr4371().fgh437Registo().fgh437NsRdclCont().isNumeric() && 
                bghr4371().fgh437Registo().fgh437VChkdCont().isNumeric() && 
                bghr4371().fgh437Registo().fgh437CTipoCont().isNumeric()) {
                if (!bghr4371().fgh437Registo().fgh437NCliente().isEqual(0) && 
                    !bghr4371().fgh437Registo().fgh437CPaisIsoaCont().isEmpty() && 
                    !bghr4371().fgh437Registo().fgh437CBancCont().isEqual(0) && 
                    !bghr4371().fgh437Registo().fgh437COeEgcCont().isEqual(0) && 
                    !bghr4371().fgh437Registo().fgh437NsRdclCont().isEqual(0)) {
                    bghr4381().fgh438MsgErro().set(CON_MSG_2);
                    log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                    m2900EscreveFgh438() ;
                    swSwitches().swErroValNotok().setTrue() ;
                } else if (bghr4371().fgh437Registo().fgh437NCliente().isEqual(0) && 
                    bghr4371().fgh437Registo().fgh437CPaisIsoaCont().isEmpty() && 
                    bghr4371().fgh437Registo().fgh437CBancCont().isEqual(0) && 
                    bghr4371().fgh437Registo().fgh437COeEgcCont().isEqual(0) && 
                    bghr4371().fgh437Registo().fgh437NsRdclCont().isEqual(0)) {
                    bghr4381().fgh438MsgErro().set(CON_MSG_3);
                    log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                    m2900EscreveFgh438() ;
                    swSwitches().swErroValNotok().setTrue() ;
                }
            } else {
                bghr4381().fgh438MsgErro().set(CON_MSG_6);
                log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                log(TraceLevel.Debug, "FGH437-REGISTO: ", bghr4371().fgh437Registo());
                m2900EscreveFgh438() ;
                swSwitches().swErroValNotok().setTrue() ;
            }
            if (swSwitches().swIndicadorObitoN().isTrue() && 
                bghr4371().fgh437Registo().fgh437DataSaldo().isEmpty()) {
                bghr4381().fgh438MsgErro().set(CON_MSG_4);
                log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                m2900EscreveFgh438() ;
                swSwitches().swErroValNotok().setTrue() ;
            }
            if (bghr4371().fgh437Registo().fgh437DataSaldo().isLess(CON_DATA_INICIO) && 
                !bghr4371().fgh437Registo().fgh437DataSaldo().isEmpty()) {
                bghr4381().fgh438MsgErro().set(CON_MSG_5);
                log(TraceLevel.Debug, "FGH438-MSG-ERRO: ", bghr4381().fgh438MsgErro());
                m2900EscreveFgh438() ;
                swSwitches().swErroValNotok().setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        wsMsg().wsMsgPar().set("2000-PROC-PROGRAMA");
        log(TraceLevel.Debug, wsMsg());
        log(TraceLevel.Debug, "STATUS-ERRO-VAL: ", swSwitches().statusErroVal());
        if (swSwitches().swErroValOk().isTrue() && ficheiroFgh437().getStatusOk()) {
            log(TraceLevel.Debug, "FGH437-C-PAIS-ISOA-CONT: ", bghr4371().fgh437Registo().fgh437CPaisIsoaCont());
            log(TraceLevel.Debug, "FGH437-C-BANC-CONT: ", bghr4371().fgh437Registo().fgh437CBancCont());
            log(TraceLevel.Debug, "FGH437-C-OE-EGC-CONT: ", bghr4371().fgh437Registo().fgh437COeEgcCont());
            log(TraceLevel.Debug, "FGH437-NS-RDCL-CONT: ", bghr4371().fgh437Registo().fgh437NsRdclCont());
            log(TraceLevel.Debug, "FGH437-V-CHKD-CONT: ", bghr4371().fgh437Registo().fgh437VChkdCont());
            log(TraceLevel.Debug, "FGH437-C-TIPO-CONT: ", bghr4371().fgh437Registo().fgh437CTipoCont());
            log(TraceLevel.Debug, "SW-INDICADOR-OBITO: ", swSwitches().swIndicadorObito());
            log(TraceLevel.Debug, "FGH437-N-CLIENTE: ", bghr4371().fgh437Registo().fgh437NCliente());
            log(TraceLevel.Debug, "FGH437-DATA-SALDO: ", bghr4371().fgh437Registo().fgh437DataSaldo());
            if (!bghr4371().fgh437Registo().fgh437CPaisIsoaCont().isEmpty() && 
                !bghr4371().fgh437Registo().fgh437CBancCont().isEqual(0) && 
                !bghr4371().fgh437Registo().fgh437COeEgcCont().isEqual(0) && 
                !bghr4371().fgh437Registo().fgh437NsRdclCont().isEqual(0) && 
                swSwitches().swIndicadorObitoS().isTrue()) {
                swSwitches().swFgh123DataVar().setTrue() ;
                wsVariaveis().wsCPaisIsoaCont().set(bghr4371().fgh437Registo().fgh437CPaisIsoaCont());
                wsVariaveis().wsCBancCont().set(bghr4371().fgh437Registo().fgh437CBancCont());
                wsVariaveis().wsCOeEgcCont().set(bghr4371().fgh437Registo().fgh437COeEgcCont());
                wsVariaveis().wsNsRdclCont().set(bghr4371().fgh437Registo().fgh437NsRdclCont());
                wsVariaveis().wsVChkdCont().set(bghr4371().fgh437Registo().fgh437VChkdCont());
                wsVariaveis().wsCTipoCont().set(bghr4371().fgh437Registo().fgh437CTipoCont());
                m2100AbreCrsThj0812() ;
                m2120FetchCrsThj0812() ;
                while (!swSwitches().swVhj00801Notfnd().isTrue()) {
                    m2140TrataCrsThj0812() ;
                }
                if (swSwitches().swVhj00801Notfnd().isTrue() && 
                    !wsVariaveis().wsContador().isEqual(CON_ZERO)) {
                    if (wsVariaveis().wsContador().isEqual(CON_UM)) {
                        m2946FormataFgh1236() ;
                    } else {
                        m2949FormataFgh1239() ;
                    }
                }
                m2160FechaCrsThj0812() ;
            } else if (!bghr4371().fgh437Registo().fgh437NCliente().isEqual(0) && 
                swSwitches().swIndicadorObitoS().isTrue()) {
                swSwitches().swFgh123ContVar().setTrue() ;
                wsVariaveis().wsNCliente().set(bghr4371().fgh437Registo().fgh437NCliente());
                m2300AcedeThj12() ;
                m2400AcedeThj08() ;
            }
            if (!bghr4371().fgh437Registo().fgh437NCliente().isEqual(0) && 
                !bghr4371().fgh437Registo().fgh437DataSaldo().isEmpty()) {
                swSwitches().swFgh123ContVar().setTrue() ;
                wsVariaveis().wsNCliente().set(bghr4371().fgh437Registo().fgh437NCliente());
                wsVariaveis().wsDataSaldo().set(bghr4371().fgh437Registo().fgh437DataSaldo());
                m2400AcedeThj08() ;
            }
            if (!bghr4371().fgh437Registo().fgh437CPaisIsoaCont().isEmpty() && 
                !bghr4371().fgh437Registo().fgh437CBancCont().isEqual(0) && 
                !bghr4371().fgh437Registo().fgh437COeEgcCont().isEqual(0) && 
                !bghr4371().fgh437Registo().fgh437NsRdclCont().isEqual(0) && 
                !bghr4371().fgh437Registo().fgh437DataSaldo().isEmpty()) {
                wsVariaveis().wsDataSaldo().set(bghr4371().fgh437Registo().fgh437DataSaldo());
                wsVariaveis().wsCPaisIsoaCont().set(bghr4371().fgh437Registo().fgh437CPaisIsoaCont());
                wsVariaveis().wsCBancCont().set(bghr4371().fgh437Registo().fgh437CBancCont());
                wsVariaveis().wsCOeEgcCont().set(bghr4371().fgh437Registo().fgh437COeEgcCont());
                wsVariaveis().wsNsRdclCont().set(bghr4371().fgh437Registo().fgh437NsRdclCont());
                wsVariaveis().wsVChkdCont().set(bghr4371().fgh437Registo().fgh437VChkdCont());
                wsVariaveis().wsCTipoCont().set(bghr4371().fgh437Registo().fgh437CTipoCont());
                m2200AcedeTgh10() ;
                m2250TrataTgh10() ;
            }
        }
    }
    
    /**
     * 
     * 2100-ABRE-CRS-THJ08-12
     * 
     */
    protected void m2100AbreCrsThj0812() {
        wsMsg().wsMsgPar().set("2100-ABRE-CURSOR-THJ08-12");
        log(TraceLevel.Debug, wsMsg());
        hv00801Relcon().relcon().initialize() ;
        hv01201Bloqueios().bloqueios().initialize() ;
        hv00801Relcon().relcon().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv00801Relcon().relcon().cBancCont().set(wsVariaveis().wsCBancCont());
        hv00801Relcon().relcon().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv00801Relcon().relcon().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv00801Relcon().relcon().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv00801Relcon().relcon().cTipoCont().set(wsVariaveis().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_THJ08_12
         */
        hv00801Relcon().openPghq998a1175(CON_TITULAR, bhjk0002().BHJK0002_BLOQUEIO_OBITO, CON_SEIS) ;
        swSwitches().statusVhj00801().set(hv00801Relcon().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swOpenCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ00801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj00801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj00801Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2120-FETCH-CRS-THJ08-12
     * 
     */
    protected void m2120FetchCrsThj0812() {
        wsMsg().wsMsgPar().set("2120-FETCH-CRS-THJ08-12");
        log(TraceLevel.Debug, wsMsg());
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_THJ08_12
         */
        hv00801Relcon().fetchPghq998a1215(hv01201Bloqueios().bloqueios().zInicio()) ;
        swSwitches().statusVhj00801().set(hv00801Relcon().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ00801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj00801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj00801Ok().isTrue() && !swSwitches().swVhj00801Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVhj00801Ok().isTrue()) {
            wsVariaveis().wsNCliente().set(hv00801Relcon().relcon().nCliente());
            wsVariaveis().wsDataSaldo().set(hv01201Bloqueios().bloqueios().zInicio());
            log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        }
    }
    
    /**
     * 
     * 2140-TRATA-CRS-THJ08-12
     * 
     */
    protected void m2140TrataCrsThj0812() {
        wsMsg().wsMsgPar().set("2140-TRATA-CRS-THJ08-12");
        log(TraceLevel.Debug, wsMsg());
        m2200AcedeTgh10() ;
        m2250TrataTgh10() ;
        m2120FetchCrsThj0812() ;
    }
    
    /**
     * 
     * 2160-FECHA-CRS-THJ08-12
     * 
     */
    protected void m2160FechaCrsThj0812() {
        wsMsg().wsMsgPar().set("2160-FECHA-CRS-THJ08-12");
        log(TraceLevel.Debug, wsMsg());
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_THJ08_12
         */
        hv00801Relcon().closePghq998a1290() ;
        swSwitches().statusVhj00801().set(hv00801Relcon().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ00801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj00801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj00801Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2200-ACEDE-TGH10
     * 
     */
    protected void m2200AcedeTgh10() {
        wsMsg().wsMsgPar().set("2200-ACEDE-TGH10");
        log(TraceLevel.Debug, wsMsg());
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(wsVariaveis().wsCBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(wsVariaveis().wsCTipoCont());
        hv01001Contiphst().contiphst().zaInicio().set(wsVariaveis().wsDataSaldo().get(1, 4));
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().selectPghq998a1342() ;
        swSwitches().statusVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH01001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh01001());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh01001Ok().isTrue() && !swSwitches().swVgh01001Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2250-TRATA-TGH10
     * 
     */
    protected void m2250TrataTgh10() {
        wsMsg().wsMsgPar().set("2250-TRATA-TGH10");
        log(TraceLevel.Debug, wsMsg());
        log(TraceLevel.Debug, "VGH01001-NM-RECURSO: ", hv01001Contiphst().contiphst().nmRecurso());
        if (hv01001Contiphst().contiphst().nmRecurso().get(1, 4).isEqual(CON_GHSA)) {
            /**
             * PERFORM 2950-CRIA-FICH-PARAM
             * THRU 2950-CRIA-FICH-PARAM-EXIT
             */
            wsVariaveis().wsAnoGdg().initialize() ;
            wsVariaveis().wsAnoGdg().set(hv01001Contiphst().contiphst().nmRecurso().get(5, 4));
            m2940ConsultaHistorico() ;
        } else {
            switch (hv01001Contiphst().contiphst().nmRecurso().get()) {
                case CON_VGH00201:
                    m2500AcedeTgh02() ;
                    break;
                case CON_VGH02301:
                    m2550AcedeTgh23() ;
                    break;
                case CON_VGH02401:
                    m2600AcedeTgh24() ;
                    break;
                case CON_VGH02501:
                    m2650AcedeTgh25() ;
                    break;
                case CON_VGH02601:
                    m2700AcedeTgh26() ;
                    break;
                case CON_VGH02701:
                    m2750AcedeTgh27() ;
                    break;
                case CON_VGH02801:
                    m2800AcedeTgh28() ;
                    break;
                default :
                    break ;
            }
            m2850FormataFgh438() ;
            m2900EscreveFgh438() ;
        }
    }
    
    /**
     * 
     * 2300-ACEDE-THJ12
     * 
     */
    protected void m2300AcedeThj12() {
        wsMsg().wsMsgPar().set("2300-ACEDE-THJ12");
        log(TraceLevel.Debug, wsMsg());
        hv01201Bloqueios().bloqueios().initialize() ;
        hv01201Bloqueios().bloqueios().nCliente().set(wsVariaveis().wsNCliente());
        log(TraceLevel.Debug, "VHJ01201-N-CLIENTE: ", hv01201Bloqueios().bloqueios().nCliente());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHJ01201_BLOQUEIOS
         */
        hv01201Bloqueios().selectPghq998a1480(bhjk0002().BHJK0002_BLOQUEIO_OBITO, CON_SEIS) ;
        swSwitches().statusVhj01201().set(hv01201Bloqueios().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ01201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj01201());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj01201Ok().isTrue() && !swSwitches().swVhj01201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVhj01201Ok().isTrue()) {
            wsVariaveis().wsDataSaldo().set(hv01201Bloqueios().bloqueios().zInicio());
            log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        }
    }
    
    /**
     * 
     * 2400-ACEDE-THJ08
     * 
     */
    protected void m2400AcedeThj08() {
        wsMsg().wsMsgPar().set("2400-ACEDE-THJ08");
        log(TraceLevel.Debug, wsMsg());
        m2410AbreCrsThj08() ;
        m2420FetchCrsThj08() ;
        while (!swSwitches().swVhj00801Notfnd().isTrue()) {
            m2430TrataCrsThj08() ;
        }
        if (swSwitches().swVhj00801Notfnd().isTrue() && 
            !wsVariaveis().wsContador().isEqual(CON_ZERO)) {
            if (wsVariaveis().wsContador().isEqual(CON_UM)) {
                m2942FormataFgh1232() ;
            } else {
                m2945FormataFgh1235() ;
            }
        }
        m2440FechaCrsThj08() ;
    }
    
    /**
     * 
     * 2410-ABRE-CRS-THJ08
     * 
     */
    protected void m2410AbreCrsThj08() {
        wsMsg().wsMsgPar().set("2410-ABRE-CRS-THJ08");
        log(TraceLevel.Debug, wsMsg());
        hv00801Relcon().relcon().initialize() ;
        hv00801Relcon().relcon().nCliente().set(wsVariaveis().wsNCliente());
        log(TraceLevel.Debug, "VHJ00801-N-CLIENTE: ", hv00801Relcon().relcon().nCliente());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_THJ08
         */
        hv00801Relcon().openPghq998a1582(wsVariaveis().wsDataSaldo(), CON_TITULAR) ;
        swSwitches().statusVhj00801().set(hv00801Relcon().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swOpenCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ00801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj00801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj00801Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2420-FETCH-CRS-THJ08
     * 
     */
    protected void m2420FetchCrsThj08() {
        wsMsg().wsMsgPar().set("2420-FETCH-CRS-THJ08");
        log(TraceLevel.Debug, wsMsg());
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_THJ08
         */
        hv00801Relcon().fetchPghq998a1622() ;
        swSwitches().statusVhj00801().set(hv00801Relcon().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ00801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj00801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj00801Ok().isTrue() && !swSwitches().swVhj00801Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVhj00801Ok().isTrue()) {
            wsVariaveis().wsCPaisIsoaCont().set(hv00801Relcon().relcon().cPaisIsoaCont());
            wsVariaveis().wsCBancCont().set(hv00801Relcon().relcon().cBancCont());
            wsVariaveis().wsCOeEgcCont().set(hv00801Relcon().relcon().cOeEgcCont());
            wsVariaveis().wsNsRdclCont().set(hv00801Relcon().relcon().nsRdclCont());
            wsVariaveis().wsVChkdCont().set(hv00801Relcon().relcon().vChkdCont());
            wsVariaveis().wsCTipoCont().set(hv00801Relcon().relcon().cTipoCont());
            log(TraceLevel.Debug, "WS-C-PAIS-ISOA-CONT: ", wsVariaveis().wsCPaisIsoaCont());
            log(TraceLevel.Debug, "WS-C-BANC-CONT: ", wsVariaveis().wsCBancCont());
            log(TraceLevel.Debug, "WS-C-OE-EGC-CONT: ", wsVariaveis().wsCOeEgcCont());
            log(TraceLevel.Debug, "WS-NS-RDCL-CONT: ", wsVariaveis().wsNsRdclCont());
            log(TraceLevel.Debug, "WS-V-CHKD-CONT: ", wsVariaveis().wsVChkdCont());
            log(TraceLevel.Debug, "WS-C-TIPO-CONT: ", wsVariaveis().wsCTipoCont());
        }
    }
    
    /**
     * 
     * 2430-TRATA-CRS-THJ08
     * 
     */
    protected void m2430TrataCrsThj08() {
        wsMsg().wsMsgPar().set("2430-TRATA-CRS-THJ08");
        log(TraceLevel.Debug, wsMsg());
        m2200AcedeTgh10() ;
        m2250TrataTgh10() ;
        m2420FetchCrsThj08() ;
    }
    
    /**
     * 
     * 2440-FECHA-CRS-THJ08
     * 
     */
    protected void m2440FechaCrsThj08() {
        wsMsg().wsMsgPar().set("2440-FECHA-CRS-THJ08");
        log(TraceLevel.Debug, wsMsg());
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_THJ08
         */
        hv00801Relcon().closePghq998a1719() ;
        swSwitches().statusVhj00801().set(hv00801Relcon().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VHJ00801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVhj00801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVhj00801Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2500-ACEDE-TGH02
     * 
     */
    protected void m2500AcedeTgh02() {
        wsMsg().wsMsgPar().set("2500-ACEDE-TGH02");
        log(TraceLevel.Debug, wsMsg());
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(wsVariaveis().wsCBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH00201-C-PAIS-ISOA-CONT: ", hv00201Movhst().movhst().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH00201-C-BANC-CONT: ", hv00201Movhst().movhst().cBancCont());
        log(TraceLevel.Debug, "VGH00201-C-OE-EGC-CONT: ", hv00201Movhst().movhst().cOeEgcCont());
        log(TraceLevel.Debug, "VGH00201-NS-RDCL-CONT: ", hv00201Movhst().movhst().nsRdclCont());
        log(TraceLevel.Debug, "VGH00201-V-CHKD-CONT: ", hv00201Movhst().movhst().vChkdCont());
        log(TraceLevel.Debug, "VGH00201-C-TIPO-CONT: ", hv00201Movhst().movhst().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq998a1788(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh00201());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue() && !swSwitches().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh00201Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2550-ACEDE-TGH23
     * 
     */
    protected void m2550AcedeTgh23() {
        wsMsg().wsMsgPar().set("2550-ACEDE-TGH23");
        log(TraceLevel.Debug, wsMsg());
        hv02301Movhist3().movhist3().initialize() ;
        hv02301Movhist3().movhist3().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv02301Movhist3().movhist3().cBancCont().set(wsVariaveis().wsCBancCont());
        hv02301Movhist3().movhist3().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv02301Movhist3().movhist3().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv02301Movhist3().movhist3().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv02301Movhist3().movhist3().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH02301-C-PAIS-ISOA-CONT: ", hv02301Movhist3().movhist3().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH02301-C-BANC-CONT: ", hv02301Movhist3().movhist3().cBancCont());
        log(TraceLevel.Debug, "VGH02301-C-OE-EGC-CONT: ", hv02301Movhist3().movhist3().cOeEgcCont());
        log(TraceLevel.Debug, "VGH02301-NS-RDCL-CONT: ", hv02301Movhist3().movhist3().nsRdclCont());
        log(TraceLevel.Debug, "VGH02301-V-CHKD-CONT: ", hv02301Movhist3().movhist3().vChkdCont());
        log(TraceLevel.Debug, "VGH02301-C-TIPO-CONT: ", hv02301Movhist3().movhist3().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02301_MOVHIST3
         */
        hv02301Movhist3().selectPghq998a1891(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02301);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh02301());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue() && !swSwitches().swVgh02301Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh02301Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv02301Movhist3().movhist3().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv02301Movhist3().movhist3().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv02301Movhist3().movhist3().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2600-ACEDE-TGH24
     * 
     */
    protected void m2600AcedeTgh24() {
        wsMsg().wsMsgPar().set("2600-ACEDE-TGH24");
        log(TraceLevel.Debug, wsMsg());
        hv02401Movhist4().movhist4().initialize() ;
        hv02401Movhist4().movhist4().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv02401Movhist4().movhist4().cBancCont().set(wsVariaveis().wsCBancCont());
        hv02401Movhist4().movhist4().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv02401Movhist4().movhist4().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv02401Movhist4().movhist4().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv02401Movhist4().movhist4().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH02401-C-PAIS-ISOA-CONT: ", hv02401Movhist4().movhist4().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH02401-C-BANC-CONT: ", hv02401Movhist4().movhist4().cBancCont());
        log(TraceLevel.Debug, "VGH02401-C-OE-EGC-CONT: ", hv02401Movhist4().movhist4().cOeEgcCont());
        log(TraceLevel.Debug, "VGH02401-NS-RDCL-CONT: ", hv02401Movhist4().movhist4().nsRdclCont());
        log(TraceLevel.Debug, "VGH02401-V-CHKD-CONT: ", hv02401Movhist4().movhist4().vChkdCont());
        log(TraceLevel.Debug, "VGH02401-C-TIPO-CONT: ", hv02401Movhist4().movhist4().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02401_MOVHIST4
         */
        hv02401Movhist4().selectPghq998a1994(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh02401().set(hv02401Movhist4().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02401);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh02401());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02401Ok().isTrue() && !swSwitches().swVgh02401Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh02401Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv02401Movhist4().movhist4().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv02401Movhist4().movhist4().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv02401Movhist4().movhist4().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2650-ACEDE-TGH25
     * 
     */
    protected void m2650AcedeTgh25() {
        wsMsg().wsMsgPar().set("2650-ACEDE-TGH25");
        log(TraceLevel.Debug, wsMsg());
        hv02501Movhist5().movhist5().initialize() ;
        hv02501Movhist5().movhist5().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv02501Movhist5().movhist5().cBancCont().set(wsVariaveis().wsCBancCont());
        hv02501Movhist5().movhist5().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv02501Movhist5().movhist5().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv02501Movhist5().movhist5().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv02501Movhist5().movhist5().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH02501-C-PAIS-ISOA-CONT: ", hv02501Movhist5().movhist5().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH02501-C-BANC-CONT: ", hv02501Movhist5().movhist5().cBancCont());
        log(TraceLevel.Debug, "VGH02501-C-OE-EGC-CONT: ", hv02501Movhist5().movhist5().cOeEgcCont());
        log(TraceLevel.Debug, "VGH02501-NS-RDCL-CONT: ", hv02501Movhist5().movhist5().nsRdclCont());
        log(TraceLevel.Debug, "VGH02501-V-CHKD-CONT: ", hv02501Movhist5().movhist5().vChkdCont());
        log(TraceLevel.Debug, "VGH02501-C-TIPO-CONT: ", hv02501Movhist5().movhist5().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02501_MOVHIST5
         */
        hv02501Movhist5().selectPghq998a2097(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh02501().set(hv02501Movhist5().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02501);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh02501());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02501Ok().isTrue() && !swSwitches().swVgh02501Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh02501Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv02501Movhist5().movhist5().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv02501Movhist5().movhist5().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv02501Movhist5().movhist5().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2700-ACEDE-TGH26
     * 
     */
    protected void m2700AcedeTgh26() {
        wsMsg().wsMsgPar().set("2700-ACEDE-TGH26");
        log(TraceLevel.Debug, wsMsg());
        hv02601Movhist6().movhist6().initialize() ;
        hv02601Movhist6().movhist6().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv02601Movhist6().movhist6().cBancCont().set(wsVariaveis().wsCBancCont());
        hv02601Movhist6().movhist6().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv02601Movhist6().movhist6().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv02601Movhist6().movhist6().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv02601Movhist6().movhist6().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH02601-C-PAIS-ISOA-CONT: ", hv02601Movhist6().movhist6().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH02601-C-BANC-CONT: ", hv02601Movhist6().movhist6().cBancCont());
        log(TraceLevel.Debug, "VGH02601-C-OE-EGC-CONT: ", hv02601Movhist6().movhist6().cOeEgcCont());
        log(TraceLevel.Debug, "VGH02601-NS-RDCL-CONT: ", hv02601Movhist6().movhist6().nsRdclCont());
        log(TraceLevel.Debug, "VGH02601-V-CHKD-CONT: ", hv02601Movhist6().movhist6().vChkdCont());
        log(TraceLevel.Debug, "VGH02601-C-TIPO-CONT: ", hv02601Movhist6().movhist6().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02601_MOVHIST6
         */
        hv02601Movhist6().selectPghq998a2200(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02601);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh02601());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue() && !swSwitches().swVgh02601Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh02601Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv02601Movhist6().movhist6().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv02601Movhist6().movhist6().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv02601Movhist6().movhist6().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2750-ACEDE-TGH27
     * 
     */
    protected void m2750AcedeTgh27() {
        wsMsg().wsMsgPar().set("2750-ACEDE-TGH27");
        log(TraceLevel.Debug, wsMsg());
        hv02701Movhist7().movhist7().initialize() ;
        hv02701Movhist7().movhist7().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv02701Movhist7().movhist7().cBancCont().set(wsVariaveis().wsCBancCont());
        hv02701Movhist7().movhist7().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv02701Movhist7().movhist7().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv02701Movhist7().movhist7().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv02701Movhist7().movhist7().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH02701-C-PAIS-ISOA-CONT: ", hv02701Movhist7().movhist7().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH02701-C-BANC-CONT: ", hv02701Movhist7().movhist7().cBancCont());
        log(TraceLevel.Debug, "VGH02701-C-OE-EGC-CONT: ", hv02701Movhist7().movhist7().cOeEgcCont());
        log(TraceLevel.Debug, "VGH02701-NS-RDCL-CONT: ", hv02701Movhist7().movhist7().nsRdclCont());
        log(TraceLevel.Debug, "VGH02701-V-CHKD-CONT: ", hv02701Movhist7().movhist7().vChkdCont());
        log(TraceLevel.Debug, "VGH02701-C-TIPO-CONT: ", hv02701Movhist7().movhist7().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02701_MOVHIST7
         */
        hv02701Movhist7().selectPghq998a2303(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02701);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh02701());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue() && !swSwitches().swVgh02701Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh02701Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2800-ACEDE-TGH28
     * 
     */
    protected void m2800AcedeTgh28() {
        wsMsg().wsMsgPar().set("2800-ACEDE-TGH28");
        log(TraceLevel.Debug, wsMsg());
        hv02801Movhist8().movhist8().initialize() ;
        hv02801Movhist8().movhist8().cPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        hv02801Movhist8().movhist8().cBancCont().set(wsVariaveis().wsCBancCont());
        hv02801Movhist8().movhist8().cOeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        hv02801Movhist8().movhist8().nsRdclCont().set(wsVariaveis().wsNsRdclCont());
        hv02801Movhist8().movhist8().vChkdCont().set(wsVariaveis().wsVChkdCont());
        hv02801Movhist8().movhist8().cTipoCont().set(wsVariaveis().wsCTipoCont());
        log(TraceLevel.Debug, "VGH02801-C-PAIS-ISOA-CONT: ", hv02801Movhist8().movhist8().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH02801-C-BANC-CONT: ", hv02801Movhist8().movhist8().cBancCont());
        log(TraceLevel.Debug, "VGH02801-C-OE-EGC-CONT: ", hv02801Movhist8().movhist8().cOeEgcCont());
        log(TraceLevel.Debug, "VGH02801-NS-RDCL-CONT: ", hv02801Movhist8().movhist8().nsRdclCont());
        log(TraceLevel.Debug, "VGH02801-V-CHKD-CONT: ", hv02801Movhist8().movhist8().vChkdCont());
        log(TraceLevel.Debug, "VGH02801-C-TIPO-CONT: ", hv02801Movhist8().movhist8().cTipoCont());
        log(TraceLevel.Debug, "WS-DATA-SALDO: ", wsVariaveis().wsDataSaldo());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02801_MOVHIST8
         */
        hv02801Movhist8().selectPghq998a2406(wsVariaveis().wsDataSaldo()) ;
        swSwitches().statusVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().statusVgh02801());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue() && !swSwitches().swVgh02801Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        } else if (swSwitches().swVgh02801Ok().isTrue()) {
            wsVariaveis().wsMSldoCbloApos().set(hv02801Movhist8().movhist8().mSldoCbloApos());
            wsVariaveis().wsMSldoDplnApos().set(hv02801Movhist8().movhist8().mSldoDpnlApos());
            wsVariaveis().wsCMoedIsoOriMov().set(hv02801Movhist8().movhist8().cMoedIsoOriMov());
            log(TraceLevel.Debug, "WS-M-SLDO-CBLO-APOS: ", wsVariaveis().wsMSldoCbloApos());
            log(TraceLevel.Debug, "WS-M-SLDO-DPLN-APOS: ", wsVariaveis().wsMSldoDplnApos());
            log(TraceLevel.Debug, "WS-C-MOED-ISO-ORI-MOV: ", wsVariaveis().wsCMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2850-FORMATA-FGH438
     * 
     */
    protected void m2850FormataFgh438() {
        wsMsg().wsMsgPar().set("2850-FORMATA-FGH438");
        log(TraceLevel.Debug, wsMsg());
        bghr4381().fgh438Registo().initialize() ;
        /**
         * MOVE WS-M-SLDO-CBLO-APOS        TO FGH438-SLDO-CBLO-APOS.
         */
        bghr4381().fgh438DadosSaldo().fgh438SldoCbloApos().fgh438SaldoCblo1().set(wsVariaveis().wsMSldoCbloApos().get(1, 15));
        bghr4381().fgh438DadosSaldo().fgh438SldoCbloApos().fgh438Sinal1().set(CON_SINAL);
        bghr4381().fgh438DadosSaldo().fgh438SldoCbloApos().fgh438SaldoCblo2().set(wsVariaveis().wsMSldoCbloApos().get(16, 2));
        /**
         * MOVE WS-M-SLDO-DPLN-APOS        TO FGH438-SLDO-DPNL-APOS.
         */
        bghr4381().fgh438DadosSaldo().fgh438SldoDpnlApos().fgh438SaldoDpnl1().set(wsVariaveis().wsMSldoDplnApos().get(1, 15));
        bghr4381().fgh438DadosSaldo().fgh438SldoDpnlApos().fgh438Sinal2().set(CON_SINAL);
        bghr4381().fgh438DadosSaldo().fgh438SldoDpnlApos().fgh438SaldoDpnl2().set(wsVariaveis().wsMSldoDplnApos().get(16, 2));
        bghr4381().fgh438DadosSaldo().fgh438CPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        bghr4381().fgh438DadosSaldo().fgh438CBancCont().set(wsVariaveis().wsCBancCont());
        bghr4381().fgh438DadosSaldo().fgh438COeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        bghr4381().fgh438DadosSaldo().fgh438NsRdclCont().set(wsVariaveis().wsNsRdclCont());
        bghr4381().fgh438DadosSaldo().fgh438VChkdCont().set(wsVariaveis().wsVChkdCont());
        bghr4381().fgh438DadosSaldo().fgh438CTipoCont().set(wsVariaveis().wsCTipoCont());
        bghr4381().fgh438DadosSaldo().fgh438DataSaldo().set(wsVariaveis().wsDataSaldo());
        bghr4381().fgh438DadosSaldo().fgh438NCliente().set(wsVariaveis().wsNCliente());
        bghr4381().fgh438DadosSaldo().fgh438Moeda().set(wsVariaveis().wsCMoedIsoOriMov());
        bghr4381().fgh438DadosSaldo().fgh438Separador1().set(CON_SEPARADOR);
        bghr4381().fgh438DadosSaldo().fgh438Separador2().set(CON_SEPARADOR);
        bghr4381().fgh438DadosSaldo().fgh438Separador3().set(CON_SEPARADOR);
        bghr4381().fgh438DadosSaldo().fgh438Separador4().set(CON_SEPARADOR);
        bghr4381().fgh438DadosSaldo().fgh438Separador5().set(CON_SEPARADOR);
    }
    
    /**
     * 
     * 2900-ESCREVE-FGH438
     * 
     */
    protected void m2900EscreveFgh438() {
        wsMsg().wsMsgPar().set("2900-ESCREVE-FGH438");
        log(TraceLevel.Debug, wsMsg());
        ficheiroFgh438().write(ficheiroFgh438().regFgh43886) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH438);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh438().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh438().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH438);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh438().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2940-CONSULTA-HISTORICO
     * 
     */
    protected void m2940ConsultaHistorico() {
        wsMsg().wsMsgPar().set("2940-CONSULTA-HISTORICO");
        log(TraceLevel.Debug, wsMsg());
        if (swSwitches().swFgh123ContVar().isTrue()) {
            wsVariaveis().wsContador().add(1);
            log(TraceLevel.Error, "WS-CONTADOR: ", wsVariaveis().wsContador());
            if (wsVariaveis().wsContador().isEqual(CON_UM)) {
                wsVariaveis().wsCPaisIsoaCont1().set(wsVariaveis().wsCPaisIsoaCont());
                wsVariaveis().wsCBancCont1().set(wsVariaveis().wsCBancCont());
                wsVariaveis().wsCOeEgcCont1().set(wsVariaveis().wsCOeEgcCont());
                wsVariaveis().wsNsRdclCont1().set(wsVariaveis().wsNsRdclCont());
                wsVariaveis().wsVChkdCont1().set(wsVariaveis().wsVChkdCont());
                wsVariaveis().wsCTipoCont1().set(wsVariaveis().wsCTipoCont());
                m2950CriaFichParam1() ;
            } else if (wsVariaveis().wsContador().isEqual(CON_DOIS)) {
                m2943FormataFgh1233() ;
                m2951CriaFichParam2() ;
                wsVariaveis().wsCPaisIsoaCont1().set(wsVariaveis().wsCPaisIsoaCont());
                wsVariaveis().wsCBancCont1().set(wsVariaveis().wsCBancCont());
                wsVariaveis().wsCOeEgcCont1().set(wsVariaveis().wsCOeEgcCont());
                wsVariaveis().wsNsRdclCont1().set(wsVariaveis().wsNsRdclCont());
                wsVariaveis().wsVChkdCont1().set(wsVariaveis().wsVChkdCont());
                wsVariaveis().wsCTipoCont1().set(wsVariaveis().wsCTipoCont());
            } else {
                m2944FormataFgh1234() ;
                m2951CriaFichParam2() ;
                wsVariaveis().wsCPaisIsoaCont1().set(wsVariaveis().wsCPaisIsoaCont());
                wsVariaveis().wsCBancCont1().set(wsVariaveis().wsCBancCont());
                wsVariaveis().wsCOeEgcCont1().set(wsVariaveis().wsCOeEgcCont());
                wsVariaveis().wsNsRdclCont1().set(wsVariaveis().wsNsRdclCont());
                wsVariaveis().wsVChkdCont1().set(wsVariaveis().wsVChkdCont());
                wsVariaveis().wsCTipoCont1().set(wsVariaveis().wsCTipoCont());
            }
        }
        if (swSwitches().swFgh123DataVar().isTrue()) {
            wsVariaveis().wsContador().add(1);
            log(TraceLevel.Error, "WS-CONTADOR: ", wsVariaveis().wsContador());
            if (wsVariaveis().wsContador().isEqual(CON_UM)) {
                wsVariaveis().wsDataSaldo1().set(wsVariaveis().wsDataSaldo());
                m2950CriaFichParam1() ;
            } else if (wsVariaveis().wsContador().isEqual(CON_DOIS)) {
                m2951CriaFichParam2() ;
                m2947FormataFgh1237() ;
                wsVariaveis().wsDataSaldo1().set(wsVariaveis().wsDataSaldo());
            } else {
                m2951CriaFichParam2() ;
                m2948FormataFgh1238() ;
                wsVariaveis().wsDataSaldo1().set(wsVariaveis().wsDataSaldo());
            }
        }
        if (swSwitches().swFgh1231Reg().isTrue()) {
            m2950CriaFichParam1() ;
            m2941FormataFgh1231() ;
        }
    }
    
    /**
     * 
     * 2941-FORMATA-FGH123-1
     * 
     */
    protected void m2941FormataFgh1231() {
        wsMsg().wsMsgPar().set("2941-FORMATA-FGH123-1");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm01());
        log(TraceLevel.Debug, "LINHA-PARM01: ", bghr1231().wsLayoutEscrita2().linhaParm01());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm02().wsData1().set(wsVariaveis().wsDataSaldo());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm02());
        log(TraceLevel.Debug, "LINHA-PARM02: ", bghr1231().wsLayoutEscrita2().linhaParm02());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm03().wsData2().set(wsVariaveis().wsDataSaldo());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm03());
        log(TraceLevel.Debug, "LINHA-PARM03: ", bghr1231().wsLayoutEscrita2().linhaParm03());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm04());
        log(TraceLevel.Debug, "LINHA-PARM04: ", bghr1231().wsLayoutEscrita2().linhaParm04());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm09().wsCTipo1().set(wsVariaveis().wsCTipoCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm09());
        log(TraceLevel.Debug, "LINHA-PARM09: ", bghr1231().wsLayoutEscrita2().linhaParm09());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2942-FORMATA-FGH123-2
     * 
     */
    protected void m2942FormataFgh1232() {
        wsMsg().wsMsgPar().set("2942-FORMATA-FGH123-2");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm01());
        log(TraceLevel.Debug, "LINHA-PARM01: ", bghr1231().wsLayoutEscrita2().linhaParm01());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm02().wsData1().set(wsVariaveis().wsDataSaldo());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm02());
        log(TraceLevel.Debug, "LINHA-PARM02: ", bghr1231().wsLayoutEscrita2().linhaParm02());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm03().wsData2().set(wsVariaveis().wsDataSaldo());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm03());
        log(TraceLevel.Debug, "LINHA-PARM03: ", bghr1231().wsLayoutEscrita2().linhaParm03());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm04());
        log(TraceLevel.Debug, "LINHA-PARM04: ", bghr1231().wsLayoutEscrita2().linhaParm04());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm09().wsCTipo1().set(wsVariaveis().wsCTipoCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm09());
        log(TraceLevel.Debug, "LINHA-PARM09: ", bghr1231().wsLayoutEscrita2().linhaParm09());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2943-FORMATA-FGH123-3
     * 
     */
    protected void m2943FormataFgh1233() {
        wsMsg().wsMsgPar().set("2943-FORMATA-FGH123-3");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm01());
        log(TraceLevel.Debug, "LINHA-PARM01: ", bghr1231().wsLayoutEscrita2().linhaParm01());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm02().wsData1().set(wsVariaveis().wsDataSaldo());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm02());
        log(TraceLevel.Debug, "LINHA-PARM02: ", bghr1231().wsLayoutEscrita2().linhaParm02());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm03().wsData2().set(wsVariaveis().wsDataSaldo());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm03());
        log(TraceLevel.Debug, "LINHA-PARM03: ", bghr1231().wsLayoutEscrita2().linhaParm03());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm10());
        log(TraceLevel.Debug, "LINHA-PARM10: ", bghr1231().wsLayoutEscrita2().linhaParm10());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm11().wsCTipo2().set(wsVariaveis().wsCTipoCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm11());
        log(TraceLevel.Debug, "LINHA-PARM11: ", bghr1231().wsLayoutEscrita2().linhaParm11());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2944-FORMATA-FGH123-4
     * 
     */
    protected void m2944FormataFgh1234() {
        wsMsg().wsMsgPar().set("2944-FORMATA-FGH123-4");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm04());
        log(TraceLevel.Debug, "LINHA-PARM04: ", bghr1231().wsLayoutEscrita2().linhaParm04());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm11().wsCTipo2().set(wsVariaveis().wsCTipoCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm11());
        log(TraceLevel.Debug, "LINHA-PARM11: ", bghr1231().wsLayoutEscrita2().linhaParm11());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2945-FORMATA-FGH123-5
     * 
     */
    protected void m2945FormataFgh1235() {
        wsMsg().wsMsgPar().set("2945-FORMATA-FGH123-5");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm04());
        log(TraceLevel.Debug, "LINHA-PARM04: ", bghr1231().wsLayoutEscrita2().linhaParm04());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm12().wsCTipo3().set(wsVariaveis().wsCTipoCont1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm12());
        log(TraceLevel.Debug, "LINHA-PARM12: ", bghr1231().wsLayoutEscrita2().linhaParm12());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2946-FORMATA-FGH123-6
     * 
     */
    protected void m2946FormataFgh1236() {
        wsMsg().wsMsgPar().set("2946-FORMATA-FGH123-6");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm01());
        log(TraceLevel.Debug, "LINHA-PARM01: ", bghr1231().wsLayoutEscrita2().linhaParm01());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm02().wsData1().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm02());
        log(TraceLevel.Debug, "LINHA-PARM02: ", bghr1231().wsLayoutEscrita2().linhaParm02());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm03().wsData2().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm03());
        log(TraceLevel.Debug, "LINHA-PARM03: ", bghr1231().wsLayoutEscrita2().linhaParm03());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm04());
        log(TraceLevel.Debug, "LINHA-PARM04: ", bghr1231().wsLayoutEscrita2().linhaParm04());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm09().wsCTipo1().set(wsVariaveis().wsCTipoCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm09());
        log(TraceLevel.Debug, "LINHA-PARM09: ", bghr1231().wsLayoutEscrita2().linhaParm09());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2947-FORMATA-FGH123-7
     * 
     */
    protected void m2947FormataFgh1237() {
        wsMsg().wsMsgPar().set("2947-FORMATA-FGH123-7");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm01());
        log(TraceLevel.Debug, "LINHA-PARM01: ", bghr1231().wsLayoutEscrita2().linhaParm01());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm13().wsData3().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm13());
        log(TraceLevel.Debug, "LINHA-PARM13: ", bghr1231().wsLayoutEscrita2().linhaParm13());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm15().wsData5().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm15());
        log(TraceLevel.Debug, "LINHA-PARM15: ", bghr1231().wsLayoutEscrita2().linhaParm15());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2948-FORMATA-FGH123-8
     * 
     */
    protected void m2948FormataFgh1238() {
        wsMsg().wsMsgPar().set("2948-FORMATA-FGH123-8");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm14().wsData4().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm14());
        log(TraceLevel.Debug, "LINHA-PARM14: ", bghr1231().wsLayoutEscrita2().linhaParm14());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm15().wsData5().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm15());
        log(TraceLevel.Debug, "LINHA-PARM15: ", bghr1231().wsLayoutEscrita2().linhaParm15());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2949-FORMATA-FGH123-9
     * 
     */
    protected void m2949FormataFgh1239() {
        wsMsg().wsMsgPar().set("2949-FORMATA-FGH123-9");
        log(TraceLevel.Debug, wsMsg());
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm14().wsData4().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm14());
        log(TraceLevel.Debug, "LINHA-PARM14: ", bghr1231().wsLayoutEscrita2().linhaParm14());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm16().wsData6().set(wsVariaveis().wsDataSaldo1());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm16());
        log(TraceLevel.Debug, "LINHA-PARM16: ", bghr1231().wsLayoutEscrita2().linhaParm16());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm04());
        log(TraceLevel.Debug, "LINHA-PARM04: ", bghr1231().wsLayoutEscrita2().linhaParm04());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm05());
        log(TraceLevel.Debug, "LINHA-PARM05: ", bghr1231().wsLayoutEscrita2().linhaParm05());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm06().wsOe1().set(wsVariaveis().wsCOeEgcCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm06());
        log(TraceLevel.Debug, "LINHA-PARM06: ", bghr1231().wsLayoutEscrita2().linhaParm06());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm07().wsNsRdcl1().set(wsVariaveis().wsNsRdclCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm07());
        log(TraceLevel.Debug, "LINHA-PARM07: ", bghr1231().wsLayoutEscrita2().linhaParm07());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm08().wsVChkd1().set(wsVariaveis().wsVChkdCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm08());
        log(TraceLevel.Debug, "LINHA-PARM08: ", bghr1231().wsLayoutEscrita2().linhaParm08());
        m2980EscreveFgh123() ;
        bghr1231().fgh123Registo().fgh123CampoLivre().initialize() ;
        bghr1231().wsLayoutEscrita2().linhaParm09().wsCTipo1().set(wsVariaveis().wsCTipoCont());
        bghr1231().fgh123Registo().fgh123CampoLivre().set(bghr1231().wsLayoutEscrita2().linhaParm09());
        log(TraceLevel.Debug, "LINHA-PARM09: ", bghr1231().wsLayoutEscrita2().linhaParm09());
        m2980EscreveFgh123() ;
    }
    
    /**
     * 
     * 2950-CRIA-FICH-PARAM-1
     * 
     */
    protected void m2950CriaFichParam1() {
        wsMsg().wsMsgPar().set("2950-CRIA-FICH-PARAM-1");
        log(TraceLevel.Debug, wsMsg());
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().wsLayoutEscrita().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab01());
        log(TraceLevel.Debug, "LINHA-CAB01: ", bghr4391().wsLayoutEscrita().linhaCab01());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab02());
        log(TraceLevel.Debug, "LINHA-CAB02: ", bghr4391().wsLayoutEscrita().linhaCab02());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab03());
        log(TraceLevel.Debug, "LINHA-CAB03: ", bghr4391().wsLayoutEscrita().linhaCab03());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab04());
        log(TraceLevel.Debug, "LINHA-CAB04: ", bghr4391().wsLayoutEscrita().linhaCab04());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab05());
        log(TraceLevel.Debug, "LINHA-CAB05: ", bghr4391().wsLayoutEscrita().linhaCab05());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab06());
        log(TraceLevel.Debug, "LINHA-CAB06: ", bghr4391().wsLayoutEscrita().linhaCab06());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab07());
        log(TraceLevel.Debug, "LINHA-CAB07: ", bghr4391().wsLayoutEscrita().linhaCab07());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaCab08());
        log(TraceLevel.Debug, "LINHA-CAB08: ", bghr4391().wsLayoutEscrita().linhaCab08());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().wsLayoutEscrita().linhaSortin01().wsSortin().set(CON_SORTIN);
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaSortin01());
        log(TraceLevel.Debug, "WS-SORTIN: ", bghr4391().wsLayoutEscrita().linhaSortin01().wsSortin());
        log(TraceLevel.Debug, "LINHA-SORTIN01: ", bghr4391().wsLayoutEscrita().linhaSortin01());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro().get(1, 17).set(CON_GDG_1) ;
        bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro().get(18, 4).set(wsVariaveis().wsAnoGdg()) ;
        bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro().get(22, 11).set(CON_GDG_2) ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaSortin02());
        log(TraceLevel.Debug, "WS-FICHEIRO: ", bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro());
        log(TraceLevel.Debug, "LINHA-SORTIN02: ", bghr4391().wsLayoutEscrita().linhaSortin02());
        m2975EscreveFgh439() ;
    }
    
    /**
     * 
     * 2951-CRIA-FICH-PARAM-2
     * 
     */
    protected void m2951CriaFichParam2() {
        wsMsg().wsMsgPar().set("2951-CRIA-FICH-PARAM-2");
        log(TraceLevel.Debug, wsMsg());
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().wsLayoutEscrita().initialize() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaSortin03());
        log(TraceLevel.Debug, "LINHA-SORTIN03: ", bghr4391().wsLayoutEscrita().linhaSortin03());
        m2975EscreveFgh439() ;
        bghr4391().fgh439Registo().fgh439CampoLivre().initialize() ;
        bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro().get(1, 17).set(CON_GDG_1) ;
        bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro().get(18, 4).set(wsVariaveis().wsAnoGdg()) ;
        bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro().get(22, 11).set(CON_GDG_2) ;
        bghr4391().fgh439Registo().fgh439CampoLivre().set(bghr4391().wsLayoutEscrita().linhaSortin02());
        log(TraceLevel.Debug, "WS-FICHEIRO: ", bghr4391().wsLayoutEscrita().linhaSortin02().wsFicheiro());
        log(TraceLevel.Debug, "LINHA-SORTIN02: ", bghr4391().wsLayoutEscrita().linhaSortin02());
        m2975EscreveFgh439() ;
    }
    
    /**
     * 
     * 2975-ESCREVE-FGH439
     * 
     */
    protected void m2975EscreveFgh439() {
        wsMsg().wsMsgPar().set("2975-ESCREVE-FGH439");
        log(TraceLevel.Debug, wsMsg());
        ficheiroFgh439().write(ficheiroFgh439().regFgh43980) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH439);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh439().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh439().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH439);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh439().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2980-ESCREVE-FGH123
     * 
     */
    protected void m2980EscreveFgh123() {
        wsMsg().wsMsgPar().set("2980-ESCREVE-FGH123");
        log(TraceLevel.Debug, wsMsg());
        ficheiroFgh123().write(ficheiroFgh123().regFgh12380) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH123);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh123().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh123().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH123);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh123().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
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
        wsMsg().wsMsgPar().set("3100-FECHAR-FICHEIROS");
        log(TraceLevel.Debug, wsMsg());
        ficheiroFgh437().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH437);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh437().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh437().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH437);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh437().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
        ficheiroFgh438().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH438);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh438().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh438().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH438);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh438().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
        ficheiroFgh439().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH439);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh439().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh439().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH439);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh439().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
        ficheiroFgh123().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH123);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh123().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh123().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH123);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh123().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsMsg());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3200-ESCREVE-ESTAT
     * 
     */
    protected void m3200EscreveEstat() {
        wsMsg().wsMsgPar().set("3200-ESCREVE-ESTAT");
        log(TraceLevel.Debug, wsMsg());
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
        wsMsg().wsMsgPar().set("9900-ABEND");
        log(TraceLevel.Debug, wsMsg());
        ficheiroFgh437().close() ;
        ficheiroFgh438().close() ;
        ficheiroFgh439().close() ;
        ficheiroFgh123().close() ;
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
    public interface SwSwitches extends IDataStruct {
        
        /**
         * *-- INDICADOR
         */
        @Data(size=1, value="N")
        IString swIndicadorObito() ;
        @Data
        @Condition("S")
        ICondition swIndicadorObitoS() ;
        @Data
        @Condition("N")
        ICondition swIndicadorObitoN() ;
        
        
        /**
         * *-- INDICADOR FORMATO FGH123
         */
        @Data(size=2, value="01")
        IString swFormatoFgh123() ;
        @Data
        @Condition("01")
        ICondition swFgh1231Reg() ;
        @Data
        @Condition("02")
        ICondition swFgh123ContVar() ;
        @Data
        @Condition("03")
        ICondition swFgh123DataVar() ;
        
        
        /**
         * *-- FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition fhy003Ok() ;
        @Data
        @Condition("10")
        ICondition fhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh437() ;
        @Data
        @Condition("00")
        ICondition swFgh437Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh437Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh439() ;
        @Data
        @Condition("00")
        ICondition swFgh439Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh439Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh438() ;
        @Data
        @Condition("00")
        ICondition swFgh438Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh438Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh123() ;
        @Data
        @Condition("00")
        ICondition swFgh123Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh123Eof() ;
        
        
        /**
         * *-- ERRO VALIDACOES
         */
        @Data(size=2, value="00")
        IString statusErroVal() ;
        @Data
        @Condition("00")
        ICondition swErroValOk() ;
        @Data
        @Condition("10")
        ICondition swErroValNotok() ;
        
        
        /**
         * -- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt statusVhj00801() ;
        @Data
        @Condition("0")
        ICondition swVhj00801Ok() ;
        @Data
        @Condition("100")
        ICondition swVhj00801Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVhj01201() ;
        @Data
        @Condition("0")
        ICondition swVhj01201Ok() ;
        @Data
        @Condition("100")
        ICondition swVhj01201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh01001() ;
        @Data
        @Condition("0")
        ICondition swVgh01001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh01001Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh02301() ;
        @Data
        @Condition("0")
        ICondition swVgh02301Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02301Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh02401() ;
        @Data
        @Condition("0")
        ICondition swVgh02401Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02401Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh02501() ;
        @Data
        @Condition("0")
        ICondition swVgh02501Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02501Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh02601() ;
        @Data
        @Condition("0")
        ICondition swVgh02601Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02601Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh02701() ;
        @Data
        @Condition("0")
        ICondition swVgh02701Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02701Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt statusVgh02801() ;
        @Data
        @Condition("0")
        ICondition swVgh02801Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02801Notfnd() ;
        
        
    }
    public interface WsMsg extends IDataStruct {
        
        @Data(size=10, value="PGHQ998A: ")
        IString wsMsgPgm() ;
        
        @Data(size=30, value=" ")
        IString wsMsgPar() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=10, signed=true, value="0", compression=COMP3)
        ILong wsNCliente() ;
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, value="0", compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, value="0", compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, value="0", compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaCont1() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCBancCont1() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCOeEgcCont1() ;
        
        @Data(size=7, signed=true, value="0", compression=COMP3)
        IInt wsNsRdclCont1() ;
        
        @Data(size=1, signed=true, value="0", compression=COMP3)
        IInt wsVChkdCont1() ;
        
        @Data(size=3, signed=true, value="0", compression=COMP3)
        IInt wsCTipoCont1() ;
        
        @Data(size=4, value=" ")
        IString wsAnoGdg() ;
        
        @Data(size=10, value=" ")
        IString wsDataSaldo1() ;
        
        @Data(size=10, value=" ")
        IString wsDataSaldo() ;
        
        @Data(size=2, signed=true, value="0", compression=COMP3)
        IInt wsContador() ;
        
        @Data(size=32, value=" ")
        IString wsGdg() ;
        
        @Data(size=2, value=" ")
        IString wsAmbFic() ;
        
        @Data(size=80, value=" ")
        IString wsString() ;
        
        /**
         * 05 WS-M-SLDO-CBLO-APOS         PIC  S9(15)V9(2) COMP-3
         * VALUE ZEROS.
         * 05 WS-M-SLDO-DPLN-APOS         PIC  S9(15)V9(2) COMP-3
         */
        @Data(size=17, decimal=2, value="0")
        IDecimal wsMSldoCbloApos() ;
        
        @Data(size=17, decimal=2, value="0")
        IDecimal wsMSldoDplnApos() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoOriMov() ;
        
        /**
         * @return instancia da classe local WsXCteuMhtq250a
         */
        @Data
        WsXCteuMhtq250a wsXCteuMhtq250a() ;
        
        
        public interface WsXCteuMhtq250a extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString wsCPaisIsoMhyq250a() ;
            
            @Data(size=8, value=" ", lpadding=3, rpadding=79, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsAAplSgccMhyq250a() ;
            
        }
    }
    
}
