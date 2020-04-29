package cgd.gh.batch;

import static java.nio.file.StandardOpenOption.* ;
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
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hj.common.constants.Bhjk0001 ;
import cgd.na.structures.work.Bnar4901 ;
import cgd.na.structures.work.Bnaw0501 ;
import cgd.hj.structures.link.Bhjl013a ;
import cgd.hj.structures.link.Bhjl051a ;
import cgd.hg.structures.link.Bhgl003a ;
import cgd.hj.routines.Mhjj013a ;
import cgd.hj.routines.Mhjj051a ;
import cgd.hg.routines.Mhgj003a ;


/**
 * 
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc300a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk30101
     */
    @Handler(name="FWK301", record="regFwk301200")
    @Data
    protected abstract Fwk30101 ficheiroFwk301() ;
    
    /**
     * @return instancia da classe Fwk00103
     */
    @Handler(name="FWK001", record="statusFwk001")
    @Data
    protected abstract Fwk00103 ficheiroFwk001() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhjj013a
     */
    @Data
    protected abstract Mhjj013a hrMhjj013a() ;
    
    /**
     * @return instancia da classe Mhjj051a
     */
    @Data
    protected abstract Mhjj051a hrMhjj051a() ;
    
    /**
     * @return instancia da classe Mhgj003a
     */
    @Data
    protected abstract Mhgj003a hrMhgj003a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
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
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
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
     * @return instancia da classe Bhjk0001
     */
    @Data
    protected abstract Bhjk0001 bhjk0001() ;
    
    /**
     * @return instancia da classe Bnar4901
     */
    @Data
    protected abstract Bnar4901 bnar4901() ;
    
    /**
     * @return instancia da classe Bnaw0501
     */
    @Data
    protected abstract Bnaw0501 bnaw0501() ;
    
    /**
     * @return instancia da classe Bhjl013a
     */
    @Data
    protected abstract Bhjl013a bhjl013a() ;
    
    /**
     * @return instancia da classe Bhjl051a
     */
    @Data
    protected abstract Bhjl051a bhjl051a() ;
    
    /**
     * @return instancia da classe Bhgl003a
     */
    @Data
    protected abstract Bhgl003a bhgl003a() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHC300A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_FWK301 = "FWK301" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHC300A" ;
    
    protected static final String CON_PROGRAM_DESC = "FILTRO DE CLIENTES NAO DGE/DBI" ;
    
    /**
     * ****              CONSTANTES NUMERICAS                    ****
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    @Data(size=3, value=" ")
    protected IString wsCMnemEgcCtto ;
    
    /**
     * @return instancia da classe local WsSwitches
     */
    @Data
    protected abstract WsSwitches wsSwitches() ;
    
    
    
    /**
     * 
     * BHJP5013-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * BASICOS DO CLIENTE (MHJJ013A)
     * 
     */
    protected void bhjp5013AcedeMhjj013a() {
        hrMhjj013a().run() ;
    }
    
    /**
     * 
     * BHJP5051-ACESSO AO MODULO QUE OBTEM OBTEM OS CONTRATOS ACTIVOS
     * DE UM CLIENTE NUMA DETERMINADA DATA , COM POSSIBILIDADE DE
     * LIMITAR OS RESULTADOS POR  I_TIPO_ITVT (MHJJ051A)
     * 
     */
    protected void bhjp5051AcedeMhjj051a() {
        hrMhjj051a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DA EMPRESA DO GCX
     * MHGJ003A
     * 
     */
    protected void bhgp0003RotDadosEmp() {
        hrMhgj003a().run() ;
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
        m1500TrataFicheiros() ;
        m1600ReadFwk001() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        bnar4901().registo().initialize() ;
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
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500TrataFicheiros() {
        log(TraceLevel.Debug, "1500-TRATA-FICHEIROS");
        m1510OpenFwk001() ;
        m1520OpenFwk301() ;
    }
    
    /**
     * 
     * 1510-OPEN-FWK001
     * 
     */
    protected void m1510OpenFwk001() {
        log(TraceLevel.Debug, "1510-OPEN-FWK001");
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
     * 1520-OPEN-FWK301
     * 
     */
    protected void m1520OpenFwk301() {
        log(TraceLevel.Debug, "1520-OPEN-FWK301");
        ficheiroFwk301().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK301);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk301().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk301().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK301);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk301().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FWK301");
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
        ficheiroFwk001().read(bnar4901().registo()) ;
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
        m2100ValidaCliente() ;
        if (!wsSwitches().swOeDgedbiS().isTrue() && wsSwitches().swClienteEmpS().isTrue() && 
            !bhjl013a().commarea().erros().cRtnoEvenSwal().isEqual(bhjk0001().erros().acessoVedado())) {
            m2300EscreveOutput() ;
        }
        m1600ReadFwk001() ;
    }
    
    /**
     * 
     * 2100-VALIDA-CLIENTE
     * 
     */
    protected void m2100ValidaCliente() {
        log(TraceLevel.Debug, "2100-VALIDA-CLIENTE");
        bnaw0501().valTabelasGerais().op103SituacaoOper().set(bnar4901().registo().cSitOpcr());
        m2105ObterMneOe() ;
        if (!bnaw0501().valTabelasGerais().opContratada().isTrue()) {
            m2110ObtemCliData() ;
        }
        m2120AcedeMhjj013a() ;
    }
    
    /**
     * 
     * 2105-OBTER-MNE-OE
     * 
     */
    protected void m2105ObterMneOe() {
        log(TraceLevel.Debug, "2105-OBTER-MNE-OE");
        bhgl003a().commarea().initialize() ;
        wsCMnemEgcCtto.set(" ");
        bhgl003a().commarea().dadosInput().cPaisIsoAlfn().set(bnar4901().registo().contaDoCred().cPaisIsaCtaCre());
        bhgl003a().commarea().dadosInput().cBanco().set(bnar4901().registo().contaDoCred().cBancContCred());
        bhgp0003RotDadosEmp() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhgk0002().rotDadosEmpresa());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhgl003a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhgl003a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhgl003a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhgl003a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2105-OBTER-MNE-OE");
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhgk0002().rotDadosEmpresa());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhgl003a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhgl003a().commarea().dadosOutput().sqlca().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().nmTabela().set(bhgl003a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhgl003a().commarea());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        } else {
            wsCMnemEgcCtto.set(bhgl003a().commarea().dadosInput().cMnemEmpGcx());
        }
    }
    
    /**
     * 
     * 2110-OBTEM-CLI-DATA
     * 
     */
    protected void m2110ObtemCliData() {
        log(TraceLevel.Debug, "2110-OBTEM-CLI-DATA");
        bhjl051a().commarea().initialize() ;
        bhjl051a().commarea().dadosEntrada().qOccursInp().set(1);
        bhjl051a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bnar4901().registo().contaDoCred().cPaisIsaCtaCre());
        bhjl051a().commarea().dadosEntrada().cMnemEgcOpex().set(wsCMnemEgcCtto);
        bhjl051a().commarea().dadosEntrada().cPaisIsoaCont().set(bnar4901().registo().contaDoCred().cPaisIsaCtaCre());
        bhjl051a().commarea().dadosEntrada().cBancCont().set(bnar4901().registo().contaDoCred().cBancContCred());
        bhjl051a().commarea().dadosEntrada().cOeEgcCont().set(bnar4901().registo().contaDoCred().cOeEgcContCred());
        bhjl051a().commarea().dadosEntrada().nsRdclCont().set(bnar4901().registo().contaDoCred().nsRdclContCred());
        bhjl051a().commarea().dadosEntrada().vChkdCont().set(bnar4901().registo().contaDoCred().vChkdContCred());
        bhjl051a().commarea().dadosEntrada().cTipoCont().set(bnar4901().registo().contaDoCred().cTipoContCred());
        bhjl051a().commarea().dadosEntrada().titularL().setTrue() ;
        bhjl051a().commarea().dadosEntrada().zConsulta().set(bnar4901().registo().zSitOpcr());
        bhjl051a().commarea().dadosEntrada().nContaItvt().setTrue() ;
        bhjp5051AcedeMhjj051a() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhjl051a().nomeRotina());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhjl051a().commarea().erros().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhjl051a().commarea().erros().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhjl051a().commarea().erros().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhjl051a().commarea().erros().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-VALIDA-CLIENTE");
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhjl051a().nomeRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhjl051a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhjl051a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().nmTabela().set(bhjl051a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhjl051a().commarea());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2120-ACEDE-MHJJ013A
     * 
     */
    protected void m2120AcedeMhjj013a() {
        log(TraceLevel.Debug, "2120-ACEDE-MHJJ013A");
        bhjl013a().commarea().initialize() ;
        bhjl013a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhjl013a().commarea().dadosEntrada().cMnemEgcOpex().set(bhtw0011().commarea().dadosSaida().cMnemEmpGcx());
        if (!bnaw0501().valTabelasGerais().opContratada().isTrue()) {
            bhjl013a().commarea().dadosEntrada().nCliente().set(bhjl051a().commarea().dadosSaida().get(1).nCliente());
            bhjl013a().commarea().dadosEntrada().nsAbraCli().set(bhjl051a().commarea().dadosSaida().get(1).nsAbraCli());
        } else {
            bhjl013a().commarea().dadosEntrada().cPaisIsoaCont().set(bnar4901().registo().contaDoCred().cPaisIsaCtaCre());
            bhjl013a().commarea().dadosEntrada().cBancCont().set(bnar4901().registo().contaDoCred().cBancContCred());
            bhjl013a().commarea().dadosEntrada().cOeEgcCont().set(bnar4901().registo().contaDoCred().cOeEgcContCred());
            bhjl013a().commarea().dadosEntrada().nsRdclCont().set(bnar4901().registo().contaDoCred().nsRdclContCred());
            bhjl013a().commarea().dadosEntrada().vChkdCont().set(bnar4901().registo().contaDoCred().vChkdContCred());
            bhjl013a().commarea().dadosEntrada().cTipoCont().set(bnar4901().registo().contaDoCred().cTipoContCred());
        }
        bhjp5013AcedeMhjj013a() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhjl013a().nomeRotina());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhjl013a().commarea().erros().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhjl013a().commarea().erros().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhjl013a().commarea().erros().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhjl013a().commarea().erros().semErros().isTrue() && 
            !bhjl013a().commarea().erros().cRtnoEvenSwal().isEqual(bhjk0001().erros().acessoVedado())) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-VALIDA-CLIENTE");
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhjl013a().nomeRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhjl013a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhjl013a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().nmTabela().set(bhjl013a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhjl013a().commarea());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        } else if (!bhjl013a().commarea().erros().cRtnoEvenSwal().isEqual(bhjk0001().erros().acessoVedado()) && 
            bhjl013a().commarea().erros().semErros().isTrue()) {
            wsSwitches().swOeDgedbi().set(bhjl013a().commarea().dadosSaida().cDirzGerx());
            wsSwitches().swClienteEmp().set(bhjl013a().commarea().dadosSaida().cTipoCli());
        }
    }
    
    /**
     * 
     * 2300-ESCREVE-OUTPUT
     * 
     */
    protected void m2300EscreveOutput() {
        log(TraceLevel.Debug, "2300-ESCREVE-OUTPUT");
        ficheiroFwk301().write(ficheiroFwk301().regFwk301200) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK301);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk301().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk301().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK301);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk301().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-ESCREVE-OUTPUT");
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
        log(TraceLevel.Debug, "3100-FECHAR-FICHEIROS");
        m3110CloseFwk001() ;
        m3120CloseFwk301() ;
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
     * 3120-CLOSE-FWK301
     * 
     */
    protected void m3120CloseFwk301() {
        log(TraceLevel.Debug, "3120-CLOSE-FWK301");
        ficheiroFwk301().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK301);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk301().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk301().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK301);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk301().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FWK301");
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
        ficheiroFwk301().close() ;
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
        ICondition swFwk001Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk001Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk301() ;
        @Data
        @Condition("00")
        ICondition swFwk301Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk301Eof() ;
        
        
    }
    public interface WsSwitches extends IDataStruct {
        
        @Data(size=4, signed=true, value="0")
        IInt swOeDgedbi() ;
        @Data
        @Condition({ "9140", "9015", "9098" })
        ICondition swOeDgedbiS() ;
        
        
        @Data(size=1, value=" ")
        IString swClienteEmp() ;
        @Data
        @Condition("E")
        ICondition swClienteEmpS() ;
        
        
    }
    
}
