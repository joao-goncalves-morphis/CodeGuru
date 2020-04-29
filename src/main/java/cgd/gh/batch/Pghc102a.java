package cgd.gh.batch;

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
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.work.Bhtw7000 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr0121 ;
import cgd.gh.structures.work.Bghr0221 ;
import cgd.gh.structures.work.Bghr0321 ;
import cgd.ht.routines.Mhtq250a ;
import cgd.zy.batch.Pzya710a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DO REGISTO DO FICHEIRO FGH012
 * DEFINICAO DO REGISTO DO FICHEIRO FGH022
 * DEFINICAO DO REGISTO DO FICHEIRO FGH032
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc102a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fgh012
     */
    @Handler(name="FGH012", record="statusFgh012")
    @Data
    protected abstract Fgh012 ficheiroFgh012() ;
    
    /**
     * @return instancia da classe Fgh022
     */
    @Handler(name="FGH022", record="statusFgh022")
    @Data
    protected abstract Fgh022 ficheiroFgh022() ;
    
    /**
     * @return instancia da classe Fgh032
     */
    @Handler(name="FGH032", record="regFgh032108")
    @Data
    protected abstract Fgh032 ficheiroFgh032() ;
    
    
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
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
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
     * @return instancia da classe Bhtw7000
     */
    @Data
    protected abstract Bhtw7000 bhtw7000() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhtk0001
     */
    @Data
    protected abstract Bhtk0001 bhtk0001() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghr0121
     */
    @Data
    protected abstract Bghr0121 bghr0121() ;
    
    /**
     * @return instancia da classe Bghr0221
     */
    @Data
    protected abstract Bghr0221 bghr0221() ;
    
    /**
     * @return instancia da classe Bghr0321
     */
    @Data
    protected abstract Bghr0321 bghr0321() ;
    
    /**
     * AREA DE DEFINICAO DO FICHEIRO DE INPUT E OUTPUT
     * LAYOUT DO FICHEIRO DE INPUT
     * COPY DE DEFINICAO DO REGISTO DO FGH012
     * COPY DE DEFINICAO DO REGISTO DO FGH022
     * LAYOUT DO FICHEIRO DE OUTPUT
     * COPY DE DEFINICAO DO REGISTO DO FGH032
     * STATUS
     * INICIO WORKING-STORAGE PGHC102A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_MHYQ250A = "MHYQ250A" ;
    
    /**
     * @return instancia da classe local ConChaveDiferente
     */
    @Data
    protected abstract ConChaveDiferente conChaveDiferente() ;
    
    protected static final String CON_1400_OBTER = "1400-OBTER-DATAS-APL" ;
    
    protected static final String CON_1600_READ_FGH022 = "1600-READ-FGH022" ;
    
    protected static final String CON_2100_READ_FGH012 = "2100-READ-FGH012" ;
    
    protected static final String CON_2200_WRITE_FGH032 = "2200-WRITE-FGH032" ;
    
    protected static final String CON_3100_CLOSE_FGH012 = "3100-CLOSE-FGH012" ;
    
    protected static final String CON_3100_CLOSE_FGH022 = "3100-CLOSE-FGH022" ;
    
    protected static final String CON_3100_CLOSE_FGH032 = "3100-CLOSE-FGH032" ;
    
    protected static final String CON_OPEN_FGH012 = "OPEN-FGH012" ;
    
    protected static final String CON_OPEN_FGH022 = "OPEN-FGH022" ;
    
    protected static final String CON_OPEN_FGH032 = "OPEN-FGH032" ;
    
    protected static final String CON_FGH012 = "FGH012" ;
    
    protected static final String CON_FGH022 = "FGH022" ;
    
    protected static final String CON_FGH032 = "FGH032" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHC102A" ;
    
    protected static final String CON_DESCRICAO = "MOVIMENTO DO FICHEIRO" ;
    
    protected static final String CON_SEPARADOR = ";" ;
    
    protected static final String CON_SINAL = "." ;
    
    protected static final String CON_SX = "SX" ;
    
    protected static final String CON_GN = "GN" ;
    
    protected static final String CON_GP = "GP" ;
    
    protected static final String CON_4052 = "4052" ;
    
    protected static final String CON_4023 = "4023" ;
    
    protected static final String CON_4037 = "4037" ;
    
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
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (ficheiroFgh022().getStatusOk()) {
            m2000ProcessoPrograma() ;
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
        bhtp0011ObtemDados() ;
        m1200ObterJobname() ;
        m1300IniciaEstatisticas() ;
        m1400ObtemDataApl() ;
        m1500OpenFicheiros() ;
        m1600ReadFgh022() ;
        m1700ReadFgh012() ;
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
     * 1200-OBTER-JOBNAME
     * 
     */
    protected void m1200ObterJobname() {
        log(TraceLevel.Debug, "1200-OBTER-JOBNAME");
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
     * 1300-INICIA-ESTATISTICAS
     * 
     */
    protected void m1300IniciaEstatisticas() {
        log(TraceLevel.Debug, "1300-INICIA-ESTATISTICAS");
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1400-OBTEM-DATA-APL
     * 
     */
    protected void m1400ObtemDataApl() {
        log(TraceLevel.Debug, "1400-OBTEM-DATA-APL");
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
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_1400_OBTER);
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
     * 1500-OPEN-FICHEIROS
     * 
     */
    protected void m1500OpenFicheiros() {
        log(TraceLevel.Debug, " 1500-OPEN-FICHEIROS ");
        ficheiroFgh012().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH012);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh012().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh012().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH012);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh012().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_OPEN_FGH012);
            m9900Abend() ;
        }
        ficheiroFgh022().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH022);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh022().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh022().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH022);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh022().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_OPEN_FGH022);
            m9900Abend() ;
        }
        ficheiroFgh032().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH032);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh032().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh032().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH032);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh032().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_OPEN_FGH032);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FGH022
     * 
     */
    protected void m1600ReadFgh022() {
        log(TraceLevel.Debug, "1600-READ-FGH022");
        bghr0221().registo().initialize() ;
        ficheiroFgh022().read(bghr0221().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH022);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh022().getStatus());
        log(TraceLevel.Trace, "STATUS-FGH022 =", ficheiroFgh022().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh022().getStatusOk() && !ficheiroFgh022().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_1600_READ_FGH022);
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1700-READ-FGH012
     * 
     */
    protected void m1700ReadFgh012() {
        log(TraceLevel.Debug, "1700-READ-FGH012");
        bghr0121().registo().initialize() ;
        ficheiroFgh012().read(bghr0121().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH012);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh012().getStatus());
        log(TraceLevel.Debug, "BGHR0121-TS-MOVIMENTO = ", bghr0121().registo().tsMovimento());
        log(TraceLevel.Debug, "BGHR0121-NS-MOVIMENTO = ", bghr0121().registo().nsMovimento());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh012().getStatusOk() && !ficheiroFgh012().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_2100_READ_FGH012);
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "BGHR0221-A-APLICACAO  = ", bghr0221().registo().aAplicacao());
        log(TraceLevel.Debug, "BGHR0221-C-EVEN-OPEL  = ", bghr0221().registo().cEvenOpel());
        log(TraceLevel.Debug, "BGHR0221-TS-MOVIMENTO = ", bghr0221().registo().tsMovimento());
        log(TraceLevel.Debug, "BGHR0221-NS-MOVIMENTO = ", bghr0221().registo().nsMovimento());
        if ((bghr0221().registo().aAplicacao().isEqual(CON_SX) || 
            bghr0221().registo().aAplicacao().isEqual(CON_GN) || 
            bghr0221().registo().aAplicacao().isEqual(CON_GP)) && 
            !bghr0221().registo().cEvenOpel().isEqual(CON_4052) && 
            !bghr0221().registo().cEvenOpel().isEqual(CON_4023) && 
            !bghr0221().registo().cEvenOpel().isEqual(CON_4037)) {
            while ((!bghr0121().registo().tsMovimento().isEqual(bghr0221().registo().tsMovimento()) || !bghr0121().registo().nsMovimento().isEqual(bghr0221().registo().nsMovimento())) && ficheiroFgh012().getStatusOk()) {
                m1700ReadFgh012() ;
            }
            if (ficheiroFgh012().getStatusOk() && 
                bghr0121().registo().tsMovimento().isEqual(bghr0221().registo().tsMovimento()) && 
                bghr0121().registo().nsMovimento().isEqual(bghr0221().registo().nsMovimento())) {
                m2200WriteFgh032() ;
            } else {
                bhtw0033().dadosFicheiros().readSequential().setTrue() ;
                bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
                bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH022);
                bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh022().getStatus());
                conChaveDiferente().conChaveDiferenteTsMv().set(bghr0221().registo().tsMovimento());
                conChaveDiferente().conChaveDiferenteNsMv().set(bghr0221().registo().nsMovimento());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(conChaveDiferente());
                m9900Abend() ;
            }
        }
        m1600ReadFgh022() ;
    }
    
    /**
     * 
     * 2200-WRITE-FGH032
     * 
     */
    protected void m2200WriteFgh032() {
        log(TraceLevel.Debug, "2200-WRITE-FGH032");
        bghr0321().registo().initialize() ;
        wsVariaveis().wsMMovimento().set(bghr0121().registo().mMovimento());
        bghr0321().registo().cPaisIsoaCont().set(bghr0121().registo().cPaisIsoaCont());
        bghr0321().registo().cBancCont().set(bghr0121().registo().cBancCont());
        bghr0321().registo().cOeCont().set(bghr0121().registo().cOeCont());
        bghr0321().registo().nsRdclCont().set(bghr0121().registo().nsRdclCont());
        bghr0321().registo().vChkdCont().set(bghr0121().registo().vChkdCont());
        bghr0321().registo().cTipoCont().set(bghr0121().registo().cTipoCont());
        bghr0321().registo().separador1().set(CON_SEPARADOR);
        bghr0321().registo().nsDeposito().set(bghr0121().registo().nsDeposito());
        bghr0321().registo().separador2().set(CON_SEPARADOR);
        bghr0321().registo().nsMovimento().set(bghr0121().registo().nsMovimento());
        bghr0321().registo().separador3().set(CON_SEPARADOR);
        bghr0321().registo().iDbcr().set(bghr0121().registo().iDbcr());
        bghr0321().registo().separador4().set(CON_SEPARADOR);
        bghr0321().registo().mMovimento().mMovimento1().set(wsVariaveis().wsMMovimento().get(1, 15));
        bghr0321().registo().mMovimento().sinal().set(CON_SINAL);
        bghr0321().registo().mMovimento().mMovimento2().set(wsVariaveis().wsMMovimento().get(16, 2));
        bghr0321().registo().separador5().set(CON_SEPARADOR);
        bghr0321().registo().xRefMov().set(bghr0121().registo().xRefMov());
        bghr0321().registo().separador6().set(CON_SEPARADOR);
        bghr0321().registo().zValMov().set(bghr0121().registo().zValMov());
        bghr0321().registo().separador7().set(CON_SEPARADOR);
        bghr0321().registo().zMovLocl().set(bghr0121().registo().zMovLocl());
        ficheiroFgh032().write(ficheiroFgh032().regFgh032108) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH032);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh032().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh032().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH032);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh032().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_2200_WRITE_FGH032);
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
        m3200FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHAR-FICHEIROS
     * 
     */
    protected void m3100FecharFicheiros() {
        log(TraceLevel.Debug, " 3100-FECHAR-FICHEIROS");
        ficheiroFgh012().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH012);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh012().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh012().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH012);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh012().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_3100_CLOSE_FGH012);
            m9900Abend() ;
        }
        ficheiroFgh022().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH022);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh022().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh022().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH022);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh022().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_3100_CLOSE_FGH022);
            m9900Abend() ;
        }
        ficheiroFgh032().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH032);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh032().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh032().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH032);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh032().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_3100_CLOSE_FGH032);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3200-FIM-ESTATISTICA
     * 
     */
    protected void m3200FimEstatistica() {
        log(TraceLevel.Debug, "3200-FIM-ESTATISTICA");
        bhop0013FimEstatistica() ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFgh012().close() ;
        ficheiroFgh022().close() ;
        ficheiroFgh032().close() ;
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
     * AREA DE DEFINICAO DO FICHEIRO DE INPUT E OUTPUT
     * LAYOUT DO FICHEIRO DE INPUT
     * COPY DE DEFINICAO DO REGISTO DO FGH012
     * COPY DE DEFINICAO DO REGISTO DO FGH022
     * LAYOUT DO FICHEIRO DE OUTPUT
     * COPY DE DEFINICAO DO REGISTO DO FGH032
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
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh012() ;
        @Data
        @Condition("00")
        ICondition swFgh012Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh012Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh022() ;
        @Data
        @Condition("00")
        ICondition swFgh022Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh022Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh032() ;
        @Data
        @Condition("00")
        ICondition swFgh032Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh032Eof() ;
        
        
    }
    public interface ConChaveDiferente extends IDataStruct {
        
        @Data(format="ZZZ9", lpadding=18, lpaddingValue="CHAVE FICH FGH022(")
        IFormattedString conChaveDiferenteTsMv() ;
        
        @Data(format="ZZZZZZZZZZZZZ99", lpadding=1, rpadding=12, lpaddingValue="/", rpaddingValue="/")
        IFormattedString conChaveDiferenteNsMv() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsXCteuMhtq250a
         */
        @Data
        WsXCteuMhtq250a wsXCteuMhtq250a() ;
        
        @Data(size=17, decimal=2, value="0")
        IDecimal wsMMovimento() ;
        
        
        public interface WsXCteuMhtq250a extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString wsCPaisIsoMhyq250a() ;
            
            @Data(size=8, value=" ", lpadding=3, rpadding=79, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsAAplSgccMhyq250a() ;
            
        }
    }
    
}
