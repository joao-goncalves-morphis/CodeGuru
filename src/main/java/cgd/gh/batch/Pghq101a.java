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
import cgd.gn.structures.link.Bgnl105a ;
import cgd.gh.structures.work.Bghr0551 ;
import cgd.gh.structures.work.Bghr0521 ;
import cgd.gh.structures.work.Bghr0531 ;
import cgd.gh.structures.work.Bghr0541 ;
import cgd.gh.structures.work.Bghr0561 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ht.structures.work.Bhtw7000 ;
import cgd.gn.routines.Mgnj105a ;
import cgd.ht.routines.Mhtq200a ;
import cgd.zy.batch.Pzya710a ;


/**
 * 
 * DEFINICAO De ficheiros - - - - - - - - - - - - - - - - - - -
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH055
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH052
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH053
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH054
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH056
 * DEFINICAO De AREAS DE LIGAÇÃO - - - - - - - - - - - - - - -
 * DECLARACAO DE CURSORES
 * CURSOR CRS_VGH01001
 * CURSOR CRS_VGH00201  -> VGH00201/VGH10201
 * CURSOR CRS_VGH02301  -> VGH02301/VGH12301
 * CURSOR CRS_VGH02401  -> VGH02401/VGH12401
 * CURSOR CRS_VGH02501  -> VGH02501/VGH12501
 * CURSOR CRS_VGH02601  -> VGH02601/VGH12601
 * CURSOR CRS_VGH02701  -> VGH02701/VGH12701
 * CURSOR CRS_VGH02801  -> VGH02801/VGH12801
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq101a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
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
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    /**
     * @return instancia da classe Vwsdghps12301Movhstcp3
     */
    @Data
    protected abstract Vwsdghps12301Movhstcp3 hv12301Movhstcp3() ;
    
    /**
     * @return instancia da classe Vwsdghps02401Movhist4
     */
    @Data
    protected abstract Vwsdghps02401Movhist4 hv02401Movhist4() ;
    
    /**
     * @return instancia da classe Vwsdghps12401Movhstcp4
     */
    @Data
    protected abstract Vwsdghps12401Movhstcp4 hv12401Movhstcp4() ;
    
    /**
     * @return instancia da classe Vwsdghps02501Movhist5
     */
    @Data
    protected abstract Vwsdghps02501Movhist5 hv02501Movhist5() ;
    
    /**
     * @return instancia da classe Vwsdghps12501Movhstcp5
     */
    @Data
    protected abstract Vwsdghps12501Movhstcp5 hv12501Movhstcp5() ;
    
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    /**
     * @return instancia da classe Vwsdghps12601Movhstcp6
     */
    @Data
    protected abstract Vwsdghps12601Movhstcp6 hv12601Movhstcp6() ;
    
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    /**
     * @return instancia da classe Vwsdghps12701Movhstcp7
     */
    @Data
    protected abstract Vwsdghps12701Movhstcp7 hv12701Movhstcp7() ;
    
    /**
     * @return instancia da classe Vwsdghps02801Movhist8
     */
    @Data
    protected abstract Vwsdghps02801Movhist8 hv02801Movhist8() ;
    
    /**
     * @return instancia da classe Vwsdghps12801Movhstcp8
     */
    @Data
    protected abstract Vwsdghps12801Movhstcp8 hv12801Movhstcp8() ;
    
    
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
     * @return instancia da classe Fgh055
     */
    @Handler(name="FGH055", record="statusFgh055")
    @Data
    protected abstract Fgh055 ficheiroFgh055() ;
    
    /**
     * @return instancia da classe Fgh052
     */
    @Handler(name="FGH052", record="regFgh05280")
    @Data
    protected abstract Fgh052 ficheiroFgh052() ;
    
    /**
     * @return instancia da classe Fgh053
     */
    @Handler(name="FGH053", record="regFgh05380")
    @Data
    protected abstract Fgh053 ficheiroFgh053() ;
    
    /**
     * @return instancia da classe Fgh054
     */
    @Handler(name="FGH054", record="regFgh054108")
    @Data
    protected abstract Fgh054 ficheiroFgh054() ;
    
    /**
     * @return instancia da classe Fgh056
     */
    @Handler(name="FGH056", record="regFgh05680")
    @Data
    protected abstract Fgh056 ficheiroFgh056() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mgnj105a
     */
    @Data
    protected abstract Mgnj105a hrMgnj105a() ;
    
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    /**
     * @return instancia da classe Pzya710a
     */
    @Data
    protected abstract Pzya710a hbPzya710a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bgnl105a
     */
    @Data
    protected abstract Bgnl105a bgnl105a() ;
    
    /**
     * @return instancia da classe Bghr0551
     */
    @Data
    protected abstract Bghr0551 bghr0551() ;
    
    /**
     * @return instancia da classe Bghr0521
     */
    @Data
    protected abstract Bghr0521 bghr0521() ;
    
    /**
     * @return instancia da classe Bghr0531
     */
    @Data
    protected abstract Bghr0531 bghr0531() ;
    
    /**
     * @return instancia da classe Bghr0541
     */
    @Data
    protected abstract Bghr0541 bghr0541() ;
    
    /**
     * @return instancia da classe Bghr0561
     */
    @Data
    protected abstract Bghr0561 bghr0561() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
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
     * @return instancia da classe Bhtw7000
     */
    @Data
    protected abstract Bhtw7000 bhtw7000() ;
    
    /**
     * ****    CONSTANTES UTILIZADAS PARA FORMATACAO DIVERSAS    ****
     */
    protected static final String CON_NOME_PROGRAMA = "PGHQ101A" ;
    
    protected static final String CON_ZEROS = "0000000000" ;
    
    protected static final String CON_FGH055 = "FGH055" ;
    
    protected static final String CON_FGH052 = "FGH052" ;
    
    protected static final String CON_FGH053 = "FGH053" ;
    
    protected static final String CON_FGH054 = "FGH054" ;
    
    protected static final String CON_FGH056 = "FGH056" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH01001 = "VGH01001" ;
    
    protected static final String CON_VGH02301 = "VGH02301" ;
    
    protected static final String CON_VGH02401 = "VGH02401" ;
    
    protected static final String CON_VGH02501 = "VGH02501" ;
    
    protected static final String CON_VGH02601 = "VGH02601" ;
    
    protected static final String CON_VGH02701 = "VGH02701" ;
    
    protected static final String CON_VGH02801 = "VGH02801" ;
    
    protected static final String CON_DESC_OPEN_FICH = "ERRO ABERTURA FICHEIRO" ;
    
    protected static final String CON_DESC_READ_FICH = "ERRO LEITURA FICHEIRO " ;
    
    protected static final String CON_DESC_WRITE_FICH = "ERRO ESCRITA FICHEIRO " ;
    
    protected static final String CON_DESC_CLOSE_FICH = "ERRO FECHO FICHEIRO   " ;
    
    protected static final int CON_ABEND_GRAVE = 16 ;
    
    protected static final String CON_DESCRICAO = "OBTENÇÃO DE INFORMAÇÃO SOBRE EXTRATOS DE TPA      " ;
    
    protected static final String CON_003_1990 = "PGBBANC.FGH003.HA1990V2.G0001V00" ;
    
    protected static final String CON_003_1991 = "PGBBANC.FGH003.HA1991V2.G0001V00" ;
    
    protected static final String CON_003_1992 = "PGBBANC.FGH003.HA1992V2.G0001V00" ;
    
    protected static final String CON_003_1993 = "PGBBANC.FGH003.HA1993V2.G0001V00" ;
    
    protected static final String CON_003_1994 = "PGBBANC.FGH003.HA1994V2.G0001V00" ;
    
    protected static final String CON_003_1995 = "PGBBANC.FGH003.HA1995V2.G0002V00" ;
    
    protected static final String CON_003_1996 = "PGBBANC.FGH003.HA1996V2.G0002V00" ;
    
    protected static final String CON_003_1997 = "PGBBANC.FGH003.HA1997V2.G0002V00" ;
    
    protected static final String CON_003_1998 = "PGBBANC.FGH003.HA1998V2.G0002V00" ;
    
    protected static final String CON_003_1999 = "PGBBANC.FGH003.HA1999V2.G0002V00" ;
    
    protected static final String CON_003_2000 = "PGBBANC.FGH003.HA2000V2.G0002V00" ;
    
    protected static final String CON_003_2001 = "PGBBANC.FGH003.HA2001V2.G0001V00" ;
    
    protected static final String CON_003_2002 = "PGBBANC.FGH003.HA2002V2.G0001V00" ;
    
    protected static final String CON_003_2003 = "PGBBANC.FGH003.HA2003V2.G0001V00" ;
    
    protected static final String CON_003_2004 = "PGBBANC.FGH003.HA2004V2.G0001V00" ;
    
    protected static final String CON_003_2005 = "PGBBANC.FGH003.HA2005V2.G0001V00" ;
    
    protected static final String CON_003_2006 = "PGBBANC.FGH003.HA2006V2.G0001V00" ;
    
    protected static final String CON_003_2007 = "PGBBANC.FGH003.HA2007V2.G0001V00" ;
    
    protected static final String CON_003_2008 = "PGBBANC.FGH003.HA2008V2.G0001V00" ;
    
    protected static final String CON_003_2009 = "PGBBANC.FGH003.HA2009V2.G0001V00" ;
    
    protected static final String CON_103_1990 = "PGBBANC.FGH103.HA1990V2.G0001V00" ;
    
    protected static final String CON_103_1991 = "PGBBANC.FGH103.HA1991V2.G0001V00" ;
    
    protected static final String CON_103_1992 = "PGBBANC.FGH103.HA1992V2.G0001V00" ;
    
    protected static final String CON_103_1993 = "PGBBANC.FGH103.HA1993V2.G0001V00" ;
    
    protected static final String CON_103_1994 = "PGBBANC.FGH103.HA1994V2.G0001V00" ;
    
    protected static final String CON_103_1995 = "PGBBANC.FGH103.HA1995V2.G0001V00" ;
    
    protected static final String CON_103_1996 = "PGBBANC.FGH103.HA1996V2.G0001V00" ;
    
    protected static final String CON_103_1997 = "PGBBANC.FGH103.HA1997V2.G0001V00" ;
    
    protected static final String CON_103_1998 = "PGBBANC.FGH103.HA1998V2.G0001V00" ;
    
    protected static final String CON_103_1999 = "PGBBANC.FGH103.HA1999V2.G0001V00" ;
    
    protected static final String CON_103_2000 = "PGBBANC.FGH103.HA2000V2.G0001V00" ;
    
    protected static final String CON_103_2001 = "PGBBANC.FGH103.HA2001V2.G0001V00" ;
    
    protected static final String CON_103_2002 = "PGBBANC.FGH103.HA2002V2.G0001V00" ;
    
    protected static final String CON_103_2003 = "PGBBANC.FGH103.HA2003V2.G0001V00" ;
    
    protected static final String CON_103_2004 = "PGBBANC.FGH103.HA2004V2.G0001V00" ;
    
    protected static final String CON_103_2005 = "PGBBANC.FGH103.HA2005V2.G0001V00" ;
    
    protected static final String CON_103_2006 = "PGBBANC.FGH103.HA2006V2.G0001V00" ;
    
    protected static final String CON_103_2007 = "PGBBANC.FGH103.HA2007V2.G0001V00" ;
    
    protected static final String CON_103_2008 = "PGBBANC.FGH103.HA2008V2.G0001V00" ;
    
    protected static final String CON_103_2009 = "PGBBANC.FGH103.HA2009V2.G0001V00" ;
    
    protected static final String CON_4009 = "4009" ;
    
    protected static final String CON_4052 = "4052" ;
    
    protected static final String CON_4023 = "4023" ;
    
    protected static final String CON_4037 = "4037" ;
    
    protected static final String CON_SEPARADOR = ";" ;
    
    protected static final String CON_SINAL = "." ;
    
    protected static final String CON_SX = "SX" ;
    
    protected static final String CON_GN = "GN" ;
    
    protected static final String CON_GP = "GP" ;
    
    protected static final String CON_GHSA = "GHSA" ;
    
    /**
     * 05 CON-FIC-PR                  PIC X(02) VALUE 'PR'.
     * 05 CON-FIC-CQ                  PIC X(02) VALUE 'CQ'.
     */
    protected static final String CON_MSG_1 = "TERMINAL TEM DE ESTAR PREENCHIDO" ;
    
    protected static final String CON_MSG_2 = "ANO TEM DE ESTAR PREENCHIDO     " ;
    
    protected static final String CON_MSG_3 = "CONTA NAO ENCONTRADA     " ;
    
    protected static final String CON_SORTIN = "SORTIN" ;
    
    /**
     * 05 CON-SORT-OGHSO001           PIC X(08) VALUE 'OGHSO001'.
     */
    @Data(size=4, value="0")
    protected IInt conAnoFic ;
    @Data
    @Condition("1990")
    protected ICondition conAno1990 ;
    @Data
    @Condition("1991")
    protected ICondition conAno1991 ;
    @Data
    @Condition("1992")
    protected ICondition conAno1992 ;
    @Data
    @Condition("1993")
    protected ICondition conAno1993 ;
    @Data
    @Condition("1994")
    protected ICondition conAno1994 ;
    @Data
    @Condition("1995")
    protected ICondition conAno1995 ;
    @Data
    @Condition("1996")
    protected ICondition conAno1996 ;
    @Data
    @Condition("1997")
    protected ICondition conAno1997 ;
    @Data
    @Condition("1998")
    protected ICondition conAno1998 ;
    @Data
    @Condition("1999")
    protected ICondition conAno1999 ;
    @Data
    @Condition("2000")
    protected ICondition conAno2000 ;
    @Data
    @Condition("2001")
    protected ICondition conAno2001 ;
    @Data
    @Condition("2002")
    protected ICondition conAno2002 ;
    @Data
    @Condition("2003")
    protected ICondition conAno2003 ;
    @Data
    @Condition("2004")
    protected ICondition conAno2004 ;
    @Data
    @Condition("2005")
    protected ICondition conAno2005 ;
    @Data
    @Condition("2006")
    protected ICondition conAno2006 ;
    @Data
    @Condition("2007")
    protected ICondition conAno2007 ;
    @Data
    @Condition("2008")
    protected ICondition conAno2008 ;
    @Data
    @Condition("2009")
    protected ICondition conAno2009 ;
    
    
    /**
     * VARIAVEIS
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVarErros
     */
    @Data
    protected abstract WsVarErros wsVarErros() ;
    
    @Data(size=1, value="N")
    protected IString wsFimCursor ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * LINHAS JCL
     * @return instancia da classe local WsLayoutEscrita
     */
    @Data
    protected abstract WsLayoutEscrita wsLayoutEscrita() ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * BGNP0105-COPYBOOK PROCEDURE DA ROTINA MGNJ105A
     * 
     */
    protected void bgnp0105AcedeMgnj105a() {
        hrMgnj105a().run() ;
    }
    
    /**
     * 
     * BHTP0010
     * ACESSO A ROTINA DE OBTENCAO DE DATAS POR APLICACAO
     * MHTQ200A
     * 
     */
    protected void bhtp0010CaplicDatas() {
        hrMhtq200a().run() ;
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
     * 
     */
    protected void m0000Mainline() {
        m1000Inicio() ;
        while (ficheiroFgh055().getStatusOk()) {
            m2000Processamento() ;
        }
        m3000Final() ;
    }
    
    /**
     * 
     * 1000-INICIO
     * 
     */
    protected void m1000Inicio() {
        log(TraceLevel.Debug, "1000-INICIO");
        m1100Inicializacoes() ;
        bhtp0011ObtemDados() ;
        m1400IniciaEstatisticas() ;
        m1500ObtemDataApl() ;
        m1600AbreFicheiro() ;
        m1700LeFichFgh055() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, " 1100-INICIALIZACOES");
        /**
         * INICIALIZAR TODAS AS AREAS DE TRABALHO DO PROGRAMA, INCLUSIVE
         * AREAS DE LIGACAO A ROTINAS.
         */
        hv00201Movhst().movhst().initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        hv02301Movhist3().movhist3().initialize() ;
        hv02401Movhist4().movhist4().initialize() ;
        hv02501Movhist5().movhist5().initialize() ;
        hv02601Movhist6().movhist6().initialize() ;
        hv02701Movhist7().movhist7().initialize() ;
        hv02801Movhist8().movhist8().initialize() ;
        wsVariaveis().initialize() ;
        wsLayoutEscrita().initialize() ;
        bghr0551().registo().initialize() ;
        bghr0521().registo().initialize() ;
        bghr0531().registo().initialize() ;
        bghr0541().registo().initialize() ;
        bghr0561().registo().initialize() ;
    }
    
    /**
     * 
     * 1300-OBTEM-JOBNAME
     * *1300-OBTEM-JOBNAME.
     * IF SW-DEBUG-SIM
     * MOVE ' 1300-OBTEM-JOBNAME'    TO WS-MSG-PAR
     * DISPLAY WS-MSG
     * END-IF.
     * SET BHTW7000-JOBNAME             TO TRUE.
     * PERFORM BHTP7000-DADOS-SISTEMA
     * THRU BHTP7000-DADOS-SISTEMA-EXIT.
     * IF BHTW7000-SEM-ERROS
     * MOVE BHTW7000-AREA8           TO WS-NOME-JOB
     * ELSE
     * MOVE BHTW7000-C-TIPO-ERRO-BBN
     * TO
     * BHTW0030-C-TIPO-ERR-PRG-CHMD
     * MOVE SPACES                   TO
     * BHTW0030-C-TIPO-OPE-OBJ-DB2
     * MOVE ZEROES                   TO BHTW0030-C-SQLCODE
     * MOVE BHTW7000-MOD-ORIGEM-ERRO TO BHTW0030-NM-PRG-CHMD
     * MOVE BHTW7000-CH-ACESSO       TO BHTW0030-X-CTEU-ALIG
     * MOVE SPACES                   TO BHTW0030-NM-TABELA
     * SET BHTW0030-ABEND            TO TRUE
     * PERFORM 9900-ABEND
     * THRU 9900-ABEND-EXIT
     * *1300-OBTEM-JOBNAME-EXIT.
     * EXIT.
     * 1400-INICIA-ESTATISTICAS
     * 
     */
    protected void m1400IniciaEstatisticas() {
        log(TraceLevel.Debug, "1400-INICIA-ESTATISTICAS");
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1500-OBTEM-DATA-APL
     * 
     */
    protected void m1500ObtemDataApl() {
        log(TraceLevel.Debug, "1500-OBTEM-DATA-APL");
        bhtl200a().commarea().initialize() ;
        bhtl200a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl200a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0010CaplicDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl200a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl200a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl200a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl200a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl200a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl200a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl200a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO PARAGRAFO 1500-OBTEM-DATA-APL");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-ABRE-FICHEIRO
     * 
     */
    protected void m1600AbreFicheiro() {
        log(TraceLevel.Debug, " 1600-ABRE-FICHEIRO");
        /**
         * ABRE FICHEIRO FGH055
         */
        ficheiroFgh055().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH055);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh055().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh055().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_OPEN_FICH);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FGH052
         */
        ficheiroFgh052().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH052);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh052().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh052().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_OPEN_FICH);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FGH053
         */
        ficheiroFgh053().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH053);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh053().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh053().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_OPEN_FICH);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FGH054
         */
        ficheiroFgh054().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH054);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh054().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh054().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_OPEN_FICH);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FGH056
         */
        ficheiroFgh056().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH056);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh056().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh056().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_OPEN_FICH);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1700-LE-FICH-FGH055
     * 
     */
    protected void m1700LeFichFgh055() {
        log(TraceLevel.Debug, " 1700-LE-FICH-FGH055");
        bghr0551().registo().initialize() ;
        ficheiroFgh055().read(bghr0551().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH055);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh055().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh055().getStatusOk()) {
            if (!ficheiroFgh055().getStatusOk()) {
                bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
                bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
                bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_READ_FICH);
                bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
                m9900Abend() ;
            }
        } else {
            log(TraceLevel.Debug, "BGHR0551-C-TERM-SIBS  : ", bghr0551().registo().cTermSibs());
            log(TraceLevel.Debug, "BGHR0551-ANO       : ", bghr0551().registo().ano());
        }
    }
    
    /**
     * 
     * 1800-VALIDACOES
     * 
     */
    protected void m1800Validacoes() {
        log(TraceLevel.Debug, " 1800-VALIDACOES");
        bghr0541().registo().initialize() ;
        swSwitches().swValidaSim().setTrue() ;
        if (bghr0551().registo().cTermSibs().isEmpty() || 
            bghr0551().registo().cTermSibs().isEqual(CON_ZEROS)) {
            bghr0541().msgErro().set(CON_MSG_1);
            swSwitches().swValidaNao().setTrue() ;
            m2954WriteFgh054() ;
        } else if (bghr0551().registo().ano().isEqual(0) || 
            !bghr0551().registo().ano().isNumeric()) {
            bghr0541().msgErro().set(CON_MSG_2);
            swSwitches().swValidaNao().setTrue() ;
            m2954WriteFgh054() ;
        }
    }
    
    /**
     * 
     * 1900-OBTEM-JOBNAME
     * *1900-OBTEM-JOBNAME.
     * IF SW-DEBUG-SIM
     * MOVE ' 1900-OBTEM-JOBNAME'    TO WS-MSG-PAR
     * DISPLAY WS-MSG
     * END-IF.
     * SET BHTW7000-JOBNAME             TO TRUE.
     * PERFORM BHTP7000-DADOS-SISTEMA
     * THRU BHTP7000-DADOS-SISTEMA-EXIT.
     * IF NOT BHTW7000-SEM-ERROS
     * MOVE BHTW7000-C-TIPO-ERRO-BBN
     * TO
     * BHTW0030-C-TIPO-ERR-PRG-CHMD
     * MOVE SPACES                   TO
     * BHTW0030-C-TIPO-OPE-OBJ-DB2
     * MOVE ZEROES                   TO BHTW0030-C-SQLCODE
     * MOVE BHTW7000-MOD-ORIGEM-ERRO TO BHTW0030-NM-PRG-CHMD
     * MOVE BHTW7000-CH-ACESSO       TO BHTW0030-X-CTEU-ALIG
     * MOVE SPACES                   TO BHTW0030-NM-TABELA
     * SET BHTW0030-ABEND            TO TRUE
     * PERFORM 9900-ABEND
     * THRU 9900-ABEND-EXIT
     * ELSE
     * IF BHTW7000-AREA8(1:1) = 'E'
     * MOVE CON-FIC-PR           TO WS-AMB-FIC
     * END-IF
     * IF BHTW7000-AREA8(1:1) = 'T'
     * MOVE CON-FIC-CQ           TO WS-AMB-FIC
     * IF BHTW7000-AREA8(1:1) = 'G'
     * IF BHTW7000-AREA8(1:1) = 'D'
     * *1900-OBTEM-JOBNAME-EXIT.
     * EXIT.
     * 2000-PROCESSAMENTO
     * 
     */
    protected void m2000Processamento() {
        log(TraceLevel.Debug, "2000-PROCESSAMENTO");
        m1800Validacoes() ;
        log(TraceLevel.Debug, "BGHR0541-MSG-ERRO    ", bghr0541().msgErro());
        if (swSwitches().swValidaSim().isTrue()) {
            m2100ContaTpaAssociada() ;
            m2200MovContaDo() ;
        }
        m1700LeFichFgh055() ;
    }
    
    /**
     * 
     * 2100-CONTA-TPA-ASSOCIADA
     * 
     */
    protected void m2100ContaTpaAssociada() {
        log(TraceLevel.Debug, "2100-CONTA-TPA-ASSOCIADA");
        bgnl105a().commarea().initialize() ;
        bgnl105a().commarea().dadosEntrada().cTermSibs().set(bghr0551().registo().cTermSibs());
        bgnl105a().commarea().dadosEntrada().ano().set(bghr0551().registo().ano());
        log(TraceLevel.Debug, "BGHR0551-C-TERM-SIBS               ", bghr0551().registo().cTermSibs());
        log(TraceLevel.Debug, "BGHR0551-ANO                       ", bghr0551().registo().ano());
        bgnp0105AcedeMgnj105a() ;
        if (!bgnl105a().commarea().erros().semErros().isTrue()) {
            log(TraceLevel.Debug, "BGNL105A-MSG-ERROB               ", bgnl105a().commarea().erros().msgErrob());
            log(TraceLevel.Debug, "BHTW0030-C-TIPO-ERR-PRG-CHMD     ", bhtw0030().dadosEntrada().cTipoErrPrgChmd());
            log(TraceLevel.Debug, "BHTW0030-C-TIPO-OPE-OBJ-DB2      ", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Debug, "BHTW0030-C-SQLCODE               ", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Debug, "BHTW0030-NM-PRG-CHMD             ", bhtw0030().dadosEntrada().nmPrgChmd());
            log(TraceLevel.Debug, "BHTW0030-X-CTEU-ALIG             ", bhtw0030().dadosEntrada().xCteuAlig());
            log(TraceLevel.Debug, "BHTW0030-NM-TABELA               ", bhtw0030().dadosEntrada().nmTabela());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bgnl105a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bgnl105a().commarea().erros().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cSqlcode().set(bgnl105a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bgnl105a().commarea().erros().modOrigemErro());
            bhtw0030().dadosEntrada().xCteuAlig().set(bgnl105a().commarea().erros().chAcesso());
            bhtw0030().dadosEntrada().nmTabela().set(bgnl105a().commarea().erros().nmTabela());
            if (bgnl105a().commarea().erros().abendDb2().isTrue() && 
                bgnl105a().commarea().erros().cSqlcode().isEqual(100)) {
                bghr0541().msgErro().set(CON_MSG_3);
                swSwitches().swValidaNao().setTrue() ;
                m2954WriteFgh054() ;
            } else {
                bhtw0030().dadosEntrada().abend().setTrue() ;
                m9900Abend() ;
            }
        } else {
            wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont().set(bgnl105a().commarea().dadosSaida().cPaisIsoaCont());
            wsVariaveis().wsCsrTabelas().wsCBancCont().set(bgnl105a().commarea().dadosSaida().cBancCont());
            wsVariaveis().wsCsrTabelas().wsCOeCont().set(bgnl105a().commarea().dadosSaida().cOeEgcCont());
            wsLayoutEscrita().linhaParm04().wsP4COeCont().set(bgnl105a().commarea().dadosSaida().cOeEgcCont());
            wsVariaveis().wsCsrTabelas().wsNsRdclCont().set(bgnl105a().commarea().dadosSaida().nsRdclCont());
            wsLayoutEscrita().linhaParm05().wsP5NsRdclCont().set(bgnl105a().commarea().dadosSaida().nsRdclCont());
            wsVariaveis().wsCsrTabelas().wsVChkdCont().set(bgnl105a().commarea().dadosSaida().vChkdCont());
            wsLayoutEscrita().linhaParm06().wsP6VChkdCont().set(bgnl105a().commarea().dadosSaida().vChkdCont());
            wsVariaveis().wsCsrTabelas().wsCTipoCont().set(bgnl105a().commarea().dadosSaida().cTipoCont());
            wsLayoutEscrita().linhaParm07().wsP7CTipoCont().set(bgnl105a().commarea().dadosSaida().cTipoCont());
        }
    }
    
    /**
     * 
     * 2200-MOV-CONTA-DO
     * 
     */
    protected void m2200MovContaDo() {
        log(TraceLevel.Debug, "2200-MOV-CONTA-DO");
        m2210OpenCrsVgh01001() ;
        m2220FetchCrsVgh01001() ;
        while (swSwitches().swVgh01001Ok().isTrue()) {
            m2230TrataCrsVgh01001() ;
        }
        m2240CloseCrsVgh01001() ;
    }
    
    /**
     * 
     * 2210-OPEN-CRS-VGH01001
     * 
     */
    protected void m2210OpenCrsVgh01001() {
        log(TraceLevel.Debug, "2210-OPEN-CRS-VGH01001");
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        hv01001Contiphst().contiphst().zaInicio().set(bghr0551().registo().ano());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH01001
         */
        hv01001Contiphst().openPghq101a1450() ;
        swSwitches().swSqlcodeVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swOpenCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH01001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        log(TraceLevel.Trace, "CHAVE DE ACESSO TABELA VGH01001 ", wsVariaveis().wsCsrTabelas(), "-", bghr0551().registo().ano());
        if (!swSwitches().swVgh01001Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2210-OPEN-CRS-VGH01001");
            bhtw0030().dadosEntrada().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH01001);
            bhtw0030().dadosEntrada().xCteuChavTab().set(concat(wsVariaveis().wsCsrTabelas(), " ", bghr0551().registo().ano()));
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2220-FETCH-CRS-VGH01001
     * 
     */
    protected void m2220FetchCrsVgh01001() {
        log(TraceLevel.Debug, "2220-FETCH-CRS-VGH01001");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH01001
         */
        hv01001Contiphst().fetchPghq101a1494() ;
        swSwitches().swSqlcodeVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH01001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh01001Ok().isTrue() && !swSwitches().swVgh01001Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2220-FETCH-CRS-VGH01001");
            bhtw0030().dadosEntrada().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH01001);
            bhtw0030().dadosEntrada().xCteuChavTab().set(concat(wsVariaveis().wsCsrTabelas(), " ", bghr0551().registo().ano()));
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2230-TRATA-CRS-VGH01001
     * 
     */
    protected void m2230TrataCrsVgh01001() {
        log(TraceLevel.Debug, "2230-TRATA-CRS-VGH01001");
        log(TraceLevel.Trace, "VGH01001-NM-RECURSO(01:04)     ", hv01001Contiphst().contiphst().nmRecurso());
        if (hv01001Contiphst().contiphst().nmRecurso().get(1, 4).isEqual(CON_GHSA)) {
            m2852TrataFgh052() ;
            m2853TrataFgh053() ;
            m2856TrataFgh056() ;
        } else {
            switch (hv01001Contiphst().contiphst().nmRecurso().get()) {
                case CON_VGH00201:
                    m2300TrataVgh00201() ;
                    break;
                case CON_VGH02301:
                    m2400TrataVgh02301() ;
                    break;
                case CON_VGH02401:
                    m2500TrataVgh02401() ;
                    break;
                case CON_VGH02501:
                    m2600TrataVgh02501() ;
                    break;
                case CON_VGH02601:
                    m2700TrataVgh02601() ;
                    break;
                case CON_VGH02701:
                    m2800TrataVgh02701() ;
                    break;
                case CON_VGH02801:
                    m2900TrataVgh02801() ;
                    break;
                default :
                    break ;
            }
        }
        m2220FetchCrsVgh01001() ;
    }
    
    /**
     * 
     * 2240-CLOSE-CRS-VGH01001
     * 
     */
    protected void m2240CloseCrsVgh01001() {
        log(TraceLevel.Debug, "2240-CLOSE-CRS-VGH01001");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH01001
         */
        hv01001Contiphst().closePghq101a1600() ;
        swSwitches().swSqlcodeVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH01001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh01001Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2240-CLOSE-CRS-VGH01001");
            bhtw0030().dadosEntrada().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH01001);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-TRATA-VGH00201
     * 
     */
    protected void m2300TrataVgh00201() {
        log(TraceLevel.Debug, " 2300-TRATA-VGH00201");
        m2310OpenCrsVgh00201() ;
        m2320FetchCrsVgh00201() ;
        while (swSwitches().swVgh00201Ok().isTrue()) {
            m2330TrataCrsVgh00201() ;
        }
        m2340CloseCrsVgh00201() ;
    }
    
    /**
     * 
     * 2310-OPEN-CRS-VGH00201
     * 
     */
    protected void m2310OpenCrsVgh00201() {
        log(TraceLevel.Debug, " 2310-OPEN-CRS-VGH00201");
        hv00201Movhst().movhst().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv00201Movhst().movhst().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH00201
         */
        hv00201Movhst().openPghq101a1674(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2310-OPEN-CRS-VGH00201");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00201);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2320-FETCH-CRS-VGH00201
     * 
     */
    protected void m2320FetchCrsVgh00201() {
        log(TraceLevel.Debug, "2320-FETCH-CRS-VGH00201");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH00201
         */
        hv00201Movhst().fetchPghq101a1714(hv10201Movhstcpl().movhstcpl().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue() && !swSwitches().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-FETCH-CRS-VGH00201");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00201);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2330-TRATA-CRS-VGH00201
     * 
     */
    protected void m2330TrataCrsVgh00201() {
        log(TraceLevel.Debug, "2330-TRATA-CRS-VGH00201");
        wsVariaveis().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv00201Movhst().movhst().iDbcr());
        wsVariaveis().wsMMovimento().set(hv00201Movhst().movhst().mMovimento());
        wsVariaveis().wsXRefMov().set(hv00201Movhst().movhst().xRefMov());
        wsVariaveis().wsZValMov().set(hv00201Movhst().movhst().zValMov());
        wsVariaveis().wsZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2320FetchCrsVgh00201() ;
    }
    
    /**
     * 
     * 2340-CLOSE-CRS-VGH00201
     * 
     */
    protected void m2340CloseCrsVgh00201() {
        log(TraceLevel.Debug, "2340-CLOSE-CRS-VGH00201");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH00201
         */
        hv00201Movhst().closePghq101a1794() ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2340-CLOSE-CRS-VGH00201");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00201);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2400-TRATA-VGH02301
     * 
     */
    protected void m2400TrataVgh02301() {
        log(TraceLevel.Debug, " 2400-TRATA-VGH02301");
        m2410OpenCrsVgh02301() ;
        m2420FetchCrsVgh02301() ;
        while (swSwitches().swVgh02301Ok().isTrue()) {
            m2430TrataCrsVgh02301() ;
        }
        m2440CloseCrsVgh02301() ;
    }
    
    /**
     * 
     * 2410-OPEN-CRS-VGH02301
     * 
     */
    protected void m2410OpenCrsVgh02301() {
        log(TraceLevel.Debug, " 2410-OPEN-CRS-VGH02301");
        hv02301Movhist3().movhist3().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv02301Movhist3().movhist3().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv02301Movhist3().movhist3().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv02301Movhist3().movhist3().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv02301Movhist3().movhist3().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv02301Movhist3().movhist3().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH02301
         */
        hv02301Movhist3().openPghq101a1869(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02301);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2410-OPEN-CRS-VGH02301");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02301);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2420-FETCH-CRS-VGH02301
     * 
     */
    protected void m2420FetchCrsVgh02301() {
        log(TraceLevel.Debug, "2420-FETCH-CRS-VGH02301");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH02301
         */
        hv02301Movhist3().fetchPghq101a1909(hv12301Movhstcp3().movhstcp3().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02301);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue() && !swSwitches().swVgh02301Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2420-FETCH-CRS-VGH02301");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02301);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2430-TRATA-CRS-VGH02301
     * 
     */
    protected void m2430TrataCrsVgh02301() {
        log(TraceLevel.Debug, "2430-TRATA-CRS-VGH02301");
        wsVariaveis().wsNsDeposito().set(hv02301Movhist3().movhist3().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv02301Movhist3().movhist3().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv02301Movhist3().movhist3().iDbcr());
        wsVariaveis().wsMMovimento().set(hv02301Movhist3().movhist3().mMovimento());
        wsVariaveis().wsXRefMov().set(hv02301Movhist3().movhist3().xRefMov());
        wsVariaveis().wsZValMov().set(hv02301Movhist3().movhist3().zValMov());
        wsVariaveis().wsZMovLocl().set(hv02301Movhist3().movhist3().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv12301Movhstcp3().movhstcp3().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2420FetchCrsVgh02301() ;
    }
    
    /**
     * 
     * 2440-CLOSE-CRS-VGH02301
     * 
     */
    protected void m2440CloseCrsVgh02301() {
        log(TraceLevel.Debug, "2440-CLOSE-CRS-VGH02301");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH02301
         */
        hv02301Movhist3().closePghq101a1989() ;
        swSwitches().swSqlcodeVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02301);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2440-CLOSE-CRS-VGH02301");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02301);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2500-TRATA-VGH02401
     * 
     */
    protected void m2500TrataVgh02401() {
        log(TraceLevel.Debug, " 2500-TRATA-VGH02401");
        m2510OpenCrsVgh02401() ;
        m2520FetchCrsVgh02401() ;
        while (swSwitches().swVgh02401Ok().isTrue()) {
            m2530TrataCrsVgh02401() ;
        }
        m2540CloseCrsVgh02401() ;
    }
    
    /**
     * 
     * 2510-OPEN-CRS-VGH02401
     * 
     */
    protected void m2510OpenCrsVgh02401() {
        log(TraceLevel.Debug, " 2510-OPEN-CRS-VGH02401");
        hv02401Movhist4().movhist4().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv02401Movhist4().movhist4().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv02401Movhist4().movhist4().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv02401Movhist4().movhist4().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv02401Movhist4().movhist4().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv02401Movhist4().movhist4().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH02401
         */
        hv02401Movhist4().openPghq101a2064(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh02401().set(hv02401Movhist4().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02401);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02401Movhist4().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02401Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2510-OPEN-CRS-VGH02401");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02401Movhist4().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02401);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2520-FETCH-CRS-VGH02401
     * 
     */
    protected void m2520FetchCrsVgh02401() {
        log(TraceLevel.Debug, "2520-FETCH-CRS-VGH02401");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH02401
         */
        hv02401Movhist4().fetchPghq101a2104(hv12401Movhstcp4().movhstcp4().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh02401().set(hv02401Movhist4().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02401);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02401Movhist4().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02401Ok().isTrue() && !swSwitches().swVgh02401Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2520-FETCH-CRS-VGH02401");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02401Movhist4().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02401);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2530-TRATA-CRS-VGH02401
     * 
     */
    protected void m2530TrataCrsVgh02401() {
        log(TraceLevel.Debug, "2530-TRATA-CRS-VGH02401");
        wsVariaveis().wsNsDeposito().set(hv02401Movhist4().movhist4().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv02401Movhist4().movhist4().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv02401Movhist4().movhist4().iDbcr());
        wsVariaveis().wsMMovimento().set(hv02401Movhist4().movhist4().mMovimento());
        wsVariaveis().wsXRefMov().set(hv02401Movhist4().movhist4().xRefMov());
        wsVariaveis().wsZValMov().set(hv02401Movhist4().movhist4().zValMov());
        wsVariaveis().wsZMovLocl().set(hv02401Movhist4().movhist4().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv12401Movhstcp4().movhstcp4().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2520FetchCrsVgh02401() ;
    }
    
    /**
     * 
     * 2540-CLOSE-CRS-VGH02401
     * 
     */
    protected void m2540CloseCrsVgh02401() {
        log(TraceLevel.Debug, "2540-CLOSE-CRS-VGH02401");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH02401
         */
        hv02401Movhist4().closePghq101a2184() ;
        swSwitches().swSqlcodeVgh02401().set(hv02401Movhist4().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02401);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02401Movhist4().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02401Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2540-CLOSE-CRS-VGH02401");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02401Movhist4().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02401);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2600-TRATA-VGH02501
     * 
     */
    protected void m2600TrataVgh02501() {
        log(TraceLevel.Debug, " 2600-TRATA-VGH02501");
        m2610OpenCrsVgh02501() ;
        m2620FetchCrsVgh02501() ;
        while (swSwitches().swVgh02501Ok().isTrue()) {
            m2630TrataCrsVgh02501() ;
        }
        m2640CloseCrsVgh02501() ;
    }
    
    /**
     * 
     * 2610-OPEN-CRS-VGH02501
     * 
     */
    protected void m2610OpenCrsVgh02501() {
        log(TraceLevel.Debug, " 2610-OPEN-CRS-VGH02501");
        hv02501Movhist5().movhist5().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv02501Movhist5().movhist5().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv02501Movhist5().movhist5().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv02501Movhist5().movhist5().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv02501Movhist5().movhist5().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv02501Movhist5().movhist5().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH02501
         */
        hv02501Movhist5().openPghq101a2258(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh02501().set(hv02501Movhist5().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02501);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02501Movhist5().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02501Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2610-OPEN-CRS-VGH02501");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02501Movhist5().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02501);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2620-FETCH-CRS-VGH02501
     * 
     */
    protected void m2620FetchCrsVgh02501() {
        log(TraceLevel.Debug, "2620-FETCH-CRS-VGH02501");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH02501
         */
        hv02501Movhist5().fetchPghq101a2298(hv12501Movhstcp5().movhstcp5().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh02501().set(hv02501Movhist5().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02501);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02501Movhist5().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02501Ok().isTrue() && !swSwitches().swVgh02501Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2620-FETCH-CRS-VGH02501");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02501Movhist5().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02501);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2630-TRATA-CRS-VGH02501
     * 
     */
    protected void m2630TrataCrsVgh02501() {
        log(TraceLevel.Debug, "2630-TRATA-CRS-VGH02501");
        wsVariaveis().wsNsDeposito().set(hv02501Movhist5().movhist5().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv02501Movhist5().movhist5().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv02501Movhist5().movhist5().iDbcr());
        wsVariaveis().wsMMovimento().set(hv02501Movhist5().movhist5().mMovimento());
        wsVariaveis().wsXRefMov().set(hv02501Movhist5().movhist5().xRefMov());
        wsVariaveis().wsZValMov().set(hv02501Movhist5().movhist5().zValMov());
        wsVariaveis().wsZMovLocl().set(hv02501Movhist5().movhist5().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv12501Movhstcp5().movhstcp5().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2620FetchCrsVgh02501() ;
    }
    
    /**
     * 
     * 2640-CLOSE-CRS-VGH02501
     * 
     */
    protected void m2640CloseCrsVgh02501() {
        log(TraceLevel.Debug, "2640-CLOSE-CRS-VGH02501");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH02501
         */
        hv02501Movhist5().closePghq101a2378() ;
        swSwitches().swSqlcodeVgh02501().set(hv02501Movhist5().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02501);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02501Movhist5().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02501Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2640-CLOSE-CRS-VGH02501");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02501Movhist5().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02501);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2700-TRATA-VGH02601
     * 
     */
    protected void m2700TrataVgh02601() {
        log(TraceLevel.Debug, " 2700-TRATA-VGH02601");
        m2710OpenCrsVgh02601() ;
        m2720FetchCrsVgh02601() ;
        while (swSwitches().swVgh02601Ok().isTrue()) {
            m2730TrataCrsVgh02601() ;
        }
        m2740CloseCrsVgh02601() ;
    }
    
    /**
     * 
     * 2710-OPEN-CRS-VGH02601
     * 
     */
    protected void m2710OpenCrsVgh02601() {
        log(TraceLevel.Debug, " 2710-OPEN-CRS-VGH02601");
        hv02601Movhist6().movhist6().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv02601Movhist6().movhist6().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv02601Movhist6().movhist6().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv02601Movhist6().movhist6().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv02601Movhist6().movhist6().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv02601Movhist6().movhist6().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH02601
         */
        hv02601Movhist6().openPghq101a2452(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02601);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2710-OPEN-CRS-VGH02601");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02601);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2720-FETCH-CRS-VGH02601
     * 
     */
    protected void m2720FetchCrsVgh02601() {
        log(TraceLevel.Debug, "2720-FETCH-CRS-VGH02601");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH02601
         */
        hv02601Movhist6().fetchPghq101a2492(hv12601Movhstcp6().movhstcp6().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02601);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue() && !swSwitches().swVgh02601Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2720-FETCH-CRS-VGH02601");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02601);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2730-TRATA-CRS-VGH02601
     * 
     */
    protected void m2730TrataCrsVgh02601() {
        log(TraceLevel.Debug, "2730-TRATA-CRS-VGH02601");
        wsVariaveis().wsNsDeposito().set(hv02601Movhist6().movhist6().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv02601Movhist6().movhist6().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv02601Movhist6().movhist6().iDbcr());
        wsVariaveis().wsMMovimento().set(hv02601Movhist6().movhist6().mMovimento());
        wsVariaveis().wsXRefMov().set(hv02601Movhist6().movhist6().xRefMov());
        wsVariaveis().wsZValMov().set(hv02601Movhist6().movhist6().zValMov());
        wsVariaveis().wsZMovLocl().set(hv02601Movhist6().movhist6().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv12601Movhstcp6().movhstcp6().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2720FetchCrsVgh02601() ;
    }
    
    /**
     * 
     * 2740-CLOSE-CRS-VGH02601
     * 
     */
    protected void m2740CloseCrsVgh02601() {
        log(TraceLevel.Debug, "2740-CLOSE-CRS-VGH02601");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH02601
         */
        hv02601Movhist6().closePghq101a2572() ;
        swSwitches().swSqlcodeVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02601);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2740-CLOSE-CRS-VGH02601");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02601);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2800-TRATA-VGH02701
     * 
     */
    protected void m2800TrataVgh02701() {
        log(TraceLevel.Debug, " 2800-TRATA-VGH02701");
        m2810OpenCrsVgh02701() ;
        m2820FetchCrsVgh02701() ;
        while (swSwitches().swVgh02701Ok().isTrue()) {
            m2830TrataCrsVgh02701() ;
        }
        m2840CloseCrsVgh02701() ;
    }
    
    /**
     * 
     * 2810-OPEN-CRS-VGH02701
     * 
     */
    protected void m2810OpenCrsVgh02701() {
        log(TraceLevel.Debug, " 2810-OPEN-CRS-VGH02701");
        hv02701Movhist7().movhist7().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv02701Movhist7().movhist7().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv02801Movhist8().movhist8().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv02701Movhist7().movhist7().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv02701Movhist7().movhist7().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv02701Movhist7().movhist7().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH02701
         */
        hv02701Movhist7().openPghq101a2646(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02701);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2810-OPEN-CRS-VGH02701");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02701);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2820-FETCH-CRS-VGH02701
     * 
     */
    protected void m2820FetchCrsVgh02701() {
        log(TraceLevel.Debug, "2820-FETCH-CRS-VGH02701");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH02701
         */
        hv02701Movhist7().fetchPghq101a2686(hv12701Movhstcp7().movhstcp7().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02701);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue() && !swSwitches().swVgh02701Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2820-FETCH-CRS-VGH02701");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02701);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2830-TRATA-CRS-VGH02701
     * 
     */
    protected void m2830TrataCrsVgh02701() {
        log(TraceLevel.Debug, "2830-TRATA-CRS-VGH02701");
        wsVariaveis().wsNsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        wsVariaveis().wsMMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        wsVariaveis().wsXRefMov().set(hv02701Movhist7().movhist7().xRefMov());
        wsVariaveis().wsZValMov().set(hv02701Movhist7().movhist7().zValMov());
        wsVariaveis().wsZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv12701Movhstcp7().movhstcp7().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2820FetchCrsVgh02701() ;
    }
    
    /**
     * 
     * 2840-CLOSE-CRS-VGH02701
     * 
     */
    protected void m2840CloseCrsVgh02701() {
        log(TraceLevel.Debug, "2840-CLOSE-CRS-VGH02701");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH02701
         */
        hv02701Movhist7().closePghq101a2766() ;
        swSwitches().swSqlcodeVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02701);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2840-CLOSE-CRS-VGH02701");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02701);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2900-TRATA-VGH02801
     * 
     */
    protected void m2900TrataVgh02801() {
        log(TraceLevel.Debug, " 2900-TRATA-VGH02801");
        m2910OpenCrsVgh02801() ;
        m2920FetchCrsVgh02801() ;
        while (swSwitches().swVgh02801Ok().isTrue()) {
            m2930TrataCrsVgh02801() ;
        }
        m2940CloseCrsVgh02801() ;
    }
    
    /**
     * 
     * 2910-OPEN-CRS-VGH02801
     * 
     */
    protected void m2910OpenCrsVgh02801() {
        log(TraceLevel.Debug, " 2910-OPEN-CRS-VGH02801");
        hv02801Movhist8().movhist8().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        hv02801Movhist8().movhist8().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        hv02801Movhist8().movhist8().cOeEgcCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        hv02801Movhist8().movhist8().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        hv02801Movhist8().movhist8().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        hv02801Movhist8().movhist8().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_VGH02801
         */
        hv02801Movhist8().openPghq101a2841(CON_4052, CON_4009, CON_4023, CON_4037, CON_SX, CON_GN, CON_GP) ;
        swSwitches().swSqlcodeVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2910-OPEN-CRS-VGH02801");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02801);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2920-FETCH-CRS-VGH02801
     * 
     */
    protected void m2920FetchCrsVgh02801() {
        log(TraceLevel.Debug, "2920-FETCH-CRS-VGH02801");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_VGH02801
         */
        hv02801Movhist8().fetchPghq101a2881(hv12801Movhstcp8().movhstcp8().cEvenOpel()) ;
        swSwitches().swSqlcodeVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue() && !swSwitches().swVgh02801Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2920-FETCH-CRS-VGH02801");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02801);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2930-TRATA-CRS-VGH02801
     * 
     */
    protected void m2930TrataCrsVgh02801() {
        log(TraceLevel.Debug, "2930-TRATA-CRS-VGH02801");
        wsVariaveis().wsNsDeposito().set(hv02801Movhist8().movhist8().nsDeposito());
        wsVariaveis().wsNsMovimento().set(hv02801Movhist8().movhist8().nsMovimento());
        wsVariaveis().wsIDbcr().set(hv02801Movhist8().movhist8().iDbcr());
        wsVariaveis().wsMMovimento().set(hv02801Movhist8().movhist8().mMovimento());
        wsVariaveis().wsXRefMov().set(hv02801Movhist8().movhist8().xRefMov());
        wsVariaveis().wsZValMov().set(hv02801Movhist8().movhist8().zValMov());
        wsVariaveis().wsZMovLocl().set(hv02801Movhist8().movhist8().zMovLocl());
        wsVariaveis().wsCEvenOpel().set(hv12801Movhstcp8().movhstcp8().cEvenOpel());
        m2854TrataFgh054() ;
        m2954WriteFgh054() ;
        m2920FetchCrsVgh02801() ;
    }
    
    /**
     * 
     * 2940-CLOSE-CRS-VGH02801
     * 
     */
    protected void m2940CloseCrsVgh02801() {
        log(TraceLevel.Debug, "2940-CLOSE-CRS-VGH02801");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_VGH02801
         */
        hv02801Movhist8().closePghq101a2961() ;
        swSwitches().swSqlcodeVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH02801);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2940-CLOSE-CRS-VGH02801");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH02801);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsCsrTabelas());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2852-TRATA-FGH052
     * 
     */
    protected void m2852TrataFgh052() {
        log(TraceLevel.Debug, "2852-TRATA-FGH052");
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab01());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab02());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab03());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab04());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab05());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab06());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab07());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaCab08());
        m2952WriteFgh052() ;
        bghr0521().registo().initialize() ;
        wsLayoutEscrita().linhaSortin01().wsSortin().set(CON_SORTIN);
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaSortin01());
        m2952WriteFgh052() ;
        m2890TrataAnoFicheiro() ;
        wsLayoutEscrita().linhaSortin02().wsFicheiro().initialize() ;
        wsLayoutEscrita().linhaSortin02().wsFicheiro().set(wsVariaveis().wsFicheiroFgh052());
        bghr0521().registo().initialize() ;
        bghr0521().registo().campoLivre().set(wsLayoutEscrita().linhaSortin02());
        m2952WriteFgh052() ;
    }
    
    /**
     * 
     * 2853-TRATA-FGH053
     * 
     */
    protected void m2853TrataFgh053() {
        log(TraceLevel.Debug, "2853-TRATA-FGH053");
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab01());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab02());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab03());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab04());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab05());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab06());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab07());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaCab08());
        m2953WriteFgh053() ;
        bghr0531().registo().campoLivre().initialize() ;
        wsLayoutEscrita().linhaSortin01().wsSortin().set(CON_SORTIN);
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaSortin01());
        m2953WriteFgh053() ;
        m2890TrataAnoFicheiro() ;
        wsLayoutEscrita().linhaSortin02().wsFicheiro().initialize() ;
        wsLayoutEscrita().linhaSortin02().wsFicheiro().set(wsVariaveis().wsFicheiroFgh053());
        bghr0531().registo().campoLivre().initialize() ;
        bghr0531().registo().campoLivre().set(wsLayoutEscrita().linhaSortin02());
        m2953WriteFgh053() ;
    }
    
    /**
     * 
     * 2854-TRATA-FGH054
     * 
     */
    protected void m2854TrataFgh054() {
        log(TraceLevel.Debug, "2854-TRATA-FGH054");
        bghr0541().registo().initialize() ;
        bghr0541().movDo().cPaisIsoaCont().set(wsVariaveis().wsCsrTabelas().wsCPaisIsoaCont());
        bghr0541().movDo().cBancCont().set(wsVariaveis().wsCsrTabelas().wsCBancCont());
        bghr0541().movDo().cOeCont().set(wsVariaveis().wsCsrTabelas().wsCOeCont());
        bghr0541().movDo().nsRdclCont().set(wsVariaveis().wsCsrTabelas().wsNsRdclCont());
        bghr0541().movDo().vChkdCont().set(wsVariaveis().wsCsrTabelas().wsVChkdCont());
        bghr0541().movDo().cTipoCont().set(wsVariaveis().wsCsrTabelas().wsCTipoCont());
        bghr0541().movDo().separador1().set(CON_SEPARADOR);
        bghr0541().movDo().nsDeposito().set(wsVariaveis().wsNsDeposito());
        bghr0541().movDo().separador2().set(CON_SEPARADOR);
        bghr0541().movDo().nsMovimento().set(wsVariaveis().wsNsMovimento());
        bghr0541().movDo().separador3().set(CON_SEPARADOR);
        bghr0541().movDo().iDbcr().set(wsVariaveis().wsIDbcr());
        bghr0541().movDo().separador4().set(CON_SEPARADOR);
        bghr0541().movDo().mMovimento().mMovimento1().set(wsVariaveis().wsMMovimento().get(1, 15));
        bghr0541().movDo().mMovimento().sinal().set(CON_SINAL);
        bghr0541().movDo().mMovimento().mMovimento2().set(wsVariaveis().wsMMovimento().get(16, 2));
        bghr0541().movDo().separador5().set(CON_SEPARADOR);
        bghr0541().movDo().xRefMov().set(wsVariaveis().wsXRefMov());
        bghr0541().movDo().separador6().set(CON_SEPARADOR);
        bghr0541().movDo().zValMov().set(wsVariaveis().wsZValMov());
        bghr0541().movDo().separador7().set(CON_SEPARADOR);
        bghr0541().movDo().zMovLocl().set(wsVariaveis().wsZMovLocl());
    }
    
    /**
     * 
     * 2856-TRATA-FGH056
     * 
     */
    protected void m2856TrataFgh056() {
        log(TraceLevel.Debug, "2856-TRATA-FGH056");
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm01());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm02());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm03());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm04());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm05());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm06());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm07());
        m2956WriteFgh056() ;
        bghr0561().registo().campoLivre().initialize() ;
        bghr0561().registo().campoLivre().set(wsLayoutEscrita().linhaParm08());
        m2956WriteFgh056() ;
    }
    
    /**
     * 
     * 2890-TRATA-ANO-FICHEIRO
     * 
     */
    protected void m2890TrataAnoFicheiro() {
        log(TraceLevel.Debug, "2890-TRATA-ANO-FICHEIRO");
        conAnoFic.initialize() ;
        wsVariaveis().wsFicheiroFgh052().initialize() ;
        wsVariaveis().wsFicheiroFgh053().initialize() ;
        conAnoFic.set(hv01001Contiphst().contiphst().zaInicio());
        if (conAno1990.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1990);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1990);
        } else if (conAno1991.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1991);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1991);
        } else if (conAno1992.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1992);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1992);
        } else if (conAno1993.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1993);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1993);
        } else if (conAno1994.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1994);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1994);
        } else if (conAno1995.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1995);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1995);
        } else if (conAno1996.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1996);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1996);
        } else if (conAno1997.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1997);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1997);
        } else if (conAno1997.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1998);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1998);
        } else if (conAno1999.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_1999);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_1999);
        } else if (conAno2000.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2000);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2000);
        } else if (conAno2001.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2001);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2001);
        } else if (conAno2002.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2002);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2002);
        } else if (conAno2003.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2003);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2003);
        } else if (conAno2004.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2004);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2004);
        } else if (conAno2005.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2005);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2005);
        } else if (conAno2006.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2006);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2006);
        } else if (conAno2007.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2007);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2007);
        } else if (conAno2008.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2008);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2008);
        } else if (conAno2009.isTrue()) {
            wsVariaveis().wsFicheiroFgh052().set(CON_003_2009);
            wsVariaveis().wsFicheiroFgh053().set(CON_103_2009);
        } else {
            wsVariaveis().wsFicheiroFgh052().set(" ");
            wsVariaveis().wsFicheiroFgh053().set(" ");
        }
    }
    
    /**
     * 
     * 2952-WRITE-FGH052
     * 
     */
    protected void m2952WriteFgh052() {
        log(TraceLevel.Debug, "2952-WRITE-FGH052");
        ficheiroFgh052().write(ficheiroFgh052().regFgh05280) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH052);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh052().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh052().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH052);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh052().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_WRITE_FICH);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2953-WRITE-FGH053
     * 
     */
    protected void m2953WriteFgh053() {
        log(TraceLevel.Debug, "2953-WRITE-FGH053");
        ficheiroFgh053().write(ficheiroFgh053().regFgh05380) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH053);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh053().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh053().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH053);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh053().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_WRITE_FICH);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2954-WRITE-FGH054
     * 
     */
    protected void m2954WriteFgh054() {
        log(TraceLevel.Debug, "2954-WRITE-FGH054");
        ficheiroFgh054().write(ficheiroFgh054().regFgh054108) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH054);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh054().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh054().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH054);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh054().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_WRITE_FICH);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2956-WRITE-FGH056
     * 
     */
    protected void m2956WriteFgh056() {
        log(TraceLevel.Debug, "2956-WRITE-FGH056");
        ficheiroFgh056().write(ficheiroFgh056().regFgh05680) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH056);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh056().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh056().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH056);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh056().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_WRITE_FICH);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3000-FINAL
     * 
     */
    protected void m3000Final() {
        log(TraceLevel.Debug, "3000-FINAL");
        m3100CloseFicheiros() ;
    }
    
    /**
     * 
     * 3100-CLOSE-FICHEIROS
     * 
     */
    protected void m3100CloseFicheiros() {
        /**
         * *---------------CLOSE FGH055
         */
        ficheiroFgh055().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH055);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh055().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh055().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH055);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh055().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_CLOSE_FICH);
            m9900Abend() ;
        }
        /**
         * *---------------CLOSE FGH052
         */
        ficheiroFgh052().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH052);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh052().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh052().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH052);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh052().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_CLOSE_FICH);
            m9900Abend() ;
        }
        /**
         * *---------------CLOSE FGH053
         */
        ficheiroFgh053().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH053);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh053().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh052().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH053);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh053().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_CLOSE_FICH);
            m9900Abend() ;
        }
        /**
         * *---------------CLOSE FGH054
         */
        ficheiroFgh054().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH054);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh054().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh054().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH054);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh054().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_CLOSE_FICH);
            m9900Abend() ;
        }
        /**
         * *---------------CLOSE FGH056
         */
        ficheiroFgh056().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH056);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh056().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh056().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH056);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh056().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_DESC_CLOSE_FICH);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFgh055().close() ;
        ficheiroFgh052().close() ;
        ficheiroFgh053().close() ;
        ficheiroFgh054().close() ;
        ficheiroFgh056().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
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
    public interface WsVarErros extends IDataStruct {
        
        /**
         * @return instancia da classe local WsMsgErroRotina
         */
        @Data
        WsMsgErroRotina wsMsgErroRotina() ;
        
        
        public interface WsMsgErroRotina extends IDataStruct {
            
            @Data(size=8, value=" ", lpadding=8, lpaddingValue="MODULO: ")
            IString wsNmRotina() ;
            
            @Data(size=3, signed=true, value="0", lpadding=8, lpaddingValue="ERRO -  ")
            IInt wsCRtnoEvenSwal() ;
            
            @Data(size=2, value=" ", lpadding=1, rpadding=17, lpaddingValue="/", rpaddingValue="/")
            IString wsCTipoErroBbn() ;
            
        }
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        /**
         * @return instancia da classe local WsCsrTabelas
         */
        @Data
        WsCsrTabelas wsCsrTabelas() ;
        
        @Data(size=3, value=" ")
        IString wsPaisIsoaCont() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=15, signed=true, value="0", compression=COMP3)
        ILong wsNsMovimento() ;
        
        @Data(size=1, value=" ")
        IString wsIDbcr() ;
        
        @Data(size=17, decimal=2, value="0")
        IDecimal wsMMovimento() ;
        
        @Data(size=21, value=" ")
        IString wsXRefMov() ;
        
        @Data(size=10, value=" ")
        IString wsZValMov() ;
        
        @Data(size=10, value=" ")
        IString wsZMovLocl() ;
        
        @Data(size=4, value=" ")
        IString wsCEvenOpel() ;
        
        /**
         * 05 WS-AMB-FIC                  PIC X(02) VALUE SPACES.
         */
        @Data(size=80, value=" ")
        IString wsString() ;
        
        @Data(size=32, value=" ")
        IString wsFicheiroFgh052() ;
        
        @Data(size=32, value=" ")
        IString wsFicheiroFgh053() ;
        
        
        public interface WsCsrTabelas extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaCont() ;
            
            @Data(size=4, value="0")
            IInt wsCBancCont() ;
            
            @Data(size=4, value="0")
            IInt wsCOeCont() ;
            
            @Data(size=6, value="0")
            IInt wsNsRdclCont() ;
            
            @Data(size=1, value="0")
            IInt wsVChkdCont() ;
            
            @Data(size=2, value="0")
            IInt wsCTipoCont() ;
            
        }
    }
    
    /**
     * 
     * LINHAS JCL
     * 
     * @version 2.0
     * 
     */
    public interface WsLayoutEscrita extends IDataStruct {
        
        /**
         * @return instancia da classe local LinhaCab01
         */
        @Data
        LinhaCab01 linhaCab01() ;
        
        /**
         * @return instancia da classe local LinhaCab02
         */
        @Data
        LinhaCab02 linhaCab02() ;
        
        /**
         * @return instancia da classe local LinhaCab03
         */
        @Data
        LinhaCab03 linhaCab03() ;
        
        /**
         * @return instancia da classe local LinhaCab04
         */
        @Data
        LinhaCab04 linhaCab04() ;
        
        /**
         * @return instancia da classe local LinhaCab05
         */
        @Data
        LinhaCab05 linhaCab05() ;
        
        /**
         * @return instancia da classe local LinhaCab06
         */
        @Data
        LinhaCab06 linhaCab06() ;
        
        /**
         * @return instancia da classe local LinhaCab07
         */
        @Data
        LinhaCab07 linhaCab07() ;
        
        /**
         * @return instancia da classe local LinhaCab08
         */
        @Data
        LinhaCab08 linhaCab08() ;
        
        /**
         * @return instancia da classe local LinhaSortin01
         */
        @Data
        LinhaSortin01 linhaSortin01() ;
        
        /**
         * @return instancia da classe local LinhaSortin02
         */
        @Data
        LinhaSortin02 linhaSortin02() ;
        
        /**
         * @return instancia da classe local LinhaParm01
         */
        @Data
        LinhaParm01 linhaParm01() ;
        
        /**
         * @return instancia da classe local LinhaParm02
         */
        @Data
        LinhaParm02 linhaParm02() ;
        
        /**
         * @return instancia da classe local LinhaParm03
         */
        @Data
        LinhaParm03 linhaParm03() ;
        
        /**
         * @return instancia da classe local LinhaParm04
         */
        @Data
        LinhaParm04 linhaParm04() ;
        
        /**
         * @return instancia da classe local LinhaParm05
         */
        @Data
        LinhaParm05 linhaParm05() ;
        
        /**
         * @return instancia da classe local LinhaParm06
         */
        @Data
        LinhaParm06 linhaParm06() ;
        
        /**
         * @return instancia da classe local LinhaParm07
         */
        @Data
        LinhaParm07 linhaParm07() ;
        
        /**
         * @return instancia da classe local LinhaParm08
         */
        @Data
        LinhaParm08 linhaParm08() ;
        
        
        public interface LinhaCab01 extends IDataStruct {
            
            @Data(size=3, value="//*")
            IString filler001() ;
            
            @Data(size=1, value="+")
            IString filler002() ;
            
            @Data(size=75, value="---------------------------------------------------------------------------")
            IString filler003() ;
            
            @Data(size=1, value="+")
            IString filler004() ;
            
        }
        
        public interface LinhaCab02 extends IDataStruct {
            
            @Data(size=3, value="//*")
            IString filler001() ;
            
            @Data(size=1, value="|")
            IString filler002() ;
            
            @Data(size=50, value="     SORT01 - MERGE DE FICHEIROS                  ")
            IString filler003() ;
            
            @Data(size=25, value=" ")
            IString filler004() ;
            
            @Data(size=1, value="|")
            IString filler005() ;
            
        }
        
        public interface LinhaCab03 extends IDataStruct {
            
            @Data(size=3, value="//*")
            IString filler001() ;
            
            @Data(size=1, value="+")
            IString filler002() ;
            
            @Data(size=75, value="---------------------------------------------------------------------------")
            IString filler003() ;
            
            @Data(size=1, value="+")
            IString filler004() ;
            
        }
        
        public interface LinhaCab04 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="SORT01 EXEC PGM=ICEMAN,COND=(0,NE)                ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab05 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="SYSPRINT DD  SYSOUT=*              ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab06 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="SYSOUT   DD  SYSOUT=*                             ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab07 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="TOOLMSG  DD  SYSOUT=*                            ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab08 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="DFSMSG   DD  SYSOUT=*                             ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaSortin01 extends IDataStruct {
            
            @Data(size=6, value=" ", lpadding=2, lpaddingValue="//")
            IString wsSortin() ;
            
            @Data(size=16, value="   DD  DISP=SHR,")
            IString filler001() ;
            
            @Data(size=56, value=" ")
            IString filler002() ;
            
        }
        
        public interface LinhaSortin02 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=9, value=" ")
            IString filler002() ;
            
            @Data(size=4, value="DSN=")
            IString filler003() ;
            
            @Data(size=32, value=" ", rpadding=33, rpaddingValue="")
            IString wsFicheiro() ;
            
        }
        
        public interface LinhaParm01 extends IDataStruct {
            
            @Data(size=6, value=" ")
            IString filler001() ;
            
            @Data(size=46, value="SORT FIELDS=(20,03,PD,A,23,26,CH,A,49,08,PD,A)")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaParm02 extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString filler001() ;
            
            @Data(size=13, value="INCLUDE COND=")
            IString filler002() ;
            
            @Data(size=1, value="(")
            IString filler003() ;
            
            @Data(size=13, value="01,03,CH,EQ,C")
            IString filler004() ;
            
            @Data(size=4, value="PT")
            IString filler005() ;
            
            @Data(size=5, value=",AND,")
            IString filler006() ;
            
            @Data(size=36, value=" ")
            IString filler007() ;
            
        }
        
        public interface LinhaParm03 extends IDataStruct {
            
            @Data(size=22, value=" ")
            IString filler001() ;
            
            @Data(size=21, value="04,03,PD,EQ,0035,AND,")
            IString filler002() ;
            
            @Data(size=37, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaParm04 extends IDataStruct {
            
            @Data(size=22, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="07,03,PD,EQ,")
            IString filler002() ;
            
            @Data(size=4, value=" ")
            IString wsP4COeCont() ;
            
            @Data(size=5, value=",AND,")
            IString filler003() ;
            
            @Data(size=37, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm05 extends IDataStruct {
            
            @Data(size=22, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="10,04,PD,EQ,")
            IString filler002() ;
            
            @Data(size=7, value=" ")
            IString wsP5NsRdclCont() ;
            
            @Data(size=5, value=",AND,")
            IString filler003() ;
            
            @Data(size=34, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm06 extends IDataStruct {
            
            @Data(size=22, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="14,01,PD,EQ,")
            IString filler002() ;
            
            @Data(size=1, value=" ")
            IString wsP6VChkdCont() ;
            
            @Data(size=5, value=",AND,")
            IString filler003() ;
            
            @Data(size=40, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm07 extends IDataStruct {
            
            @Data(size=22, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="15,02,PD,EQ,")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString wsP7CTipoCont() ;
            
            @Data(size=1, value=")")
            IString filler003() ;
            
            @Data(size=42, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm08 extends IDataStruct {
            
            @Data(size=6, value=" ")
            IString filler001() ;
            
            @Data(size=13, value="OPTION EQUALS")
            IString filler002() ;
            
            @Data(size=61, value=" ")
            IString filler003() ;
            
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
        
        @Data(size=1, value="S")
        IString swErroValida() ;
        @Data
        @Condition("S")
        ICondition swValidaSim() ;
        @Data
        @Condition("N")
        ICondition swValidaNao() ;
        
        
        /**
         * ----- FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFgh055() ;
        @Data
        @Condition("00")
        ICondition swFgh055Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh055Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh052() ;
        @Data
        @Condition("00")
        ICondition swFgh052Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh052Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh053() ;
        @Data
        @Condition("00")
        ICondition swFgh053Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh053Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh054() ;
        @Data
        @Condition("00")
        ICondition swFgh054Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh054Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh056() ;
        @Data
        @Condition("00")
        ICondition swFgh056Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh056Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        /**
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh01001() ;
        @Data
        @Condition("0")
        ICondition swVgh01001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh01001Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02301() ;
        @Data
        @Condition("0")
        ICondition swVgh02301Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02301Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02401() ;
        @Data
        @Condition("0")
        ICondition swVgh02401Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02401Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02501() ;
        @Data
        @Condition("0")
        ICondition swVgh02501Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02501Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02601() ;
        @Data
        @Condition("0")
        ICondition swVgh02601Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02601Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02701() ;
        @Data
        @Condition("0")
        ICondition swVgh02701Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02701Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02801() ;
        @Data
        @Condition("0")
        ICondition swVgh02801Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02801Notfnd() ;
        
        
    }
    
}
