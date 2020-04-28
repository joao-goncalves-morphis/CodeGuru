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
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghr0231 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.routines.Mhtq250a ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE OUTPUT
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq923a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk923
     */
    @Handler(name="FWK923", record="regFwk923")
    @Data
    protected abstract Fwk923 ficheiroFwk923() ;
    
    /**
     * @return instancia da classe Fgh023
     */
    @Handler(name="FGH023", record="regFgh023246")
    @Data
    protected abstract Fgh023 ficheiroFgh023() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr0231
     */
    @Data
    protected abstract Bghr0231 bghr0231() ;
    
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
     * STATUS
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK923 = "FWK923" ;
    
    protected static final String CON_FGH023 = "FGH023" ;
    
    protected static final String CON_VGH10201 = "VGH10201" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ923A" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_PROGRAM_DESC = "MIGRACAO - HISTORICO MOVIMENTOS   " ;
    
    @Data(size=8, value="MGHK800A")
    protected IString mgh800aCRotina ;
    
    /**
     * VARIAVEIS AUXILIARES
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
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
        while (!ficheiroFwk923().getStatusOk()) {
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
        m1600ReadFwk923() ;
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
        ficheiroFwk923().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK923);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk923().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk923().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK923);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk923().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
        ficheiroFgh023().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH023);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh023().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh023().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH023);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh023().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FWK923
     * 
     */
    protected void m1600ReadFwk923() {
        log(TraceLevel.Debug, "1600-READ-FWK923");
        /**
         * INITIALIZE VGH00201-MOVHST      REPLACING
         * ALPHANUMERIC     BY SPACES
         * NUMERIC      BY ZEROES.
         */
        ficheiroFwk923().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK923);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk923().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk923().getStatusOk() && !ficheiroFwk923().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK923);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk923().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FWK923");
            m9900Abend() ;
        } else if (ficheiroFwk923().getStatusOk()) {
            wsVariaveis().wsRead().add(1);
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        wsVariaveis().wsQuociente().set(divide(wsVariaveis().wsRead(), 500000));
        wsVariaveis().wsResto().set(remainder(wsVariaveis().wsRead(), 500000));
        if (wsVariaveis().wsResto().isEqual(0)) {
            log(TraceLevel.Error, "REG LIDOS:", wsVariaveis().wsRead());
        }
        m2100FormataOutput() ;
        m2200EscreveOutput() ;
        m1600ReadFwk923() ;
    }
    
    /**
     * 
     * 2100-FORMATA-OUTPUT
     * 
     */
    protected void m2100FormataOutput() {
        log(TraceLevel.Debug, "2100-FORMATA-OUTPUT");
        bghr0231().registo().initialize() ;
        bghr0231().registo().cPaisIsoaCont().set(ficheiroFwk923().regFwk923().cPaisIsoaCont());
        bghr0231().registo().cBancCont().set(ficheiroFwk923().regFwk923().cBancCont());
        bghr0231().registo().cOeEgcCont().set(ficheiroFwk923().regFwk923().cOeEgcCont());
        bghr0231().registo().nsRdclCont().set(ficheiroFwk923().regFwk923().nsRdclCont());
        bghr0231().registo().vChkdCont().set(ficheiroFwk923().regFwk923().vChkdCont());
        bghr0231().registo().cTipoCont().set(ficheiroFwk923().regFwk923().cTipoCont());
        bghr0231().registo().cMoedIsoScta().set(ficheiroFwk923().regFwk923().cMoedIsoScta());
        bghr0231().registo().nsDeposito().set(ficheiroFwk923().regFwk923().nsDeposito());
        bghr0231().registo().nsMovimento().set(ficheiroFwk923().regFwk923().nsMovimento());
        bghr0231().registo().zMovimento().set(ficheiroFwk923().regFwk923().tsMovimento().get(1, 10));
        bghr0231().registo().tsMovimento().set(ficheiroFwk923().regFwk923().tsMovimento());
        bghr0231().registo().zValMov().set(ficheiroFwk923().regFwk923().zValMov());
        if (ficheiroFwk923().regFwk923().xRefMov().isEmpty()) {
            m2300ObtemDescritivoMov() ;
        } else {
            bghr0231().registo().xRefMov().set(ficheiroFwk923().regFwk923().xRefMov());
        }
        bghr0231().registo().mMovimento().set(ficheiroFwk923().regFwk923().mMovimento());
        bghr0231().registo().iDbcr().set(ficheiroFwk923().regFwk923().iDbcr());
        bghr0231().registo().iEstorno().set(ficheiroFwk923().regFwk923().iEstorno());
        bghr0231().registo().cMoedIsoOriMov().set(ficheiroFwk923().regFwk923().cMoedIsoOriMov());
        bghr0231().registo().mSldoCbloApos().set(ficheiroFwk923().regFwk923().mSldoCbloApos());
        bghr0231().registo().mSldoDpnlApos().set(ficheiroFwk923().regFwk923().mSldoDpnlApos());
        bghr0231().registo().mMovMoeOrigMov().set(ficheiroFwk923().regFwk923().mMovMoeOrigMov());
        bghr0231().registo().nDocOpps().set(ficheiroFwk923().regFwk923().nDocOpps());
        bghr0231().registo().aAplOrig().set(ficheiroFwk923().regFwk923().aAplOrig());
        bghr0231().registo().tJuro().set(ficheiroFwk923().regFwk923().tJuro());
        bghr0231().registo().iExisInfAdi().set(ficheiroFwk923().regFwk923().iExisInfAdi());
        bghr0231().registo().mSldoRetd().set(ficheiroFwk923().regFwk923().mSldoRetd());
        bghr0231().registo().mSldoVcob().set(ficheiroFwk923().regFwk923().mSldoVcob());
        bghr0231().registo().cCategMov().set("000");
    }
    
    /**
     * 
     * 2200-ESCREVE-OUTPUT
     * 
     */
    protected void m2200EscreveOutput() {
        log(TraceLevel.Debug, "2200-ESCREVE-OUTPUT");
        ficheiroFgh023().write(ficheiroFgh023().regFgh023246) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH023);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh023().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh023().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH023);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh023().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-ESCREVE-OUTPUT");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-OBTEM-DESCRITIVO-MOV
     * 
     */
    protected void m2300ObtemDescritivoMov() {
        log(TraceLevel.Debug, "2300-OBTEM-DESCRITIVO-MOV");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(ficheiroFwk923().regFwk923().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(ficheiroFwk923().regFwk923().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(ficheiroFwk923().regFwk923().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(ficheiroFwk923().regFwk923().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(ficheiroFwk923().regFwk923().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(ficheiroFwk923().regFwk923().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(ficheiroFwk923().regFwk923().cMoedIsoScta());
        hrMghk800a().bghl800a().input().iDbcr().set(ficheiroFwk923().regFwk923().iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(ficheiroFwk923().regFwk923().iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(ficheiroFwk923().regFwk923().zValMov());
        hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(ficheiroFwk923().regFwk923().cPaisIsoaOeOpx());
        hrMghk800a().bghl800a().input().cMnemEgcOpex().set(ficheiroFwk923().regFwk923().cMnemEgcOpex());
        hrMghk800a().bghl800a().input().cOeEgcOpex().set(ficheiroFwk923().regFwk923().cOeEgcOpex());
        hrMghk800a().bghl800a().input().cOpeBbn().set(ficheiroFwk923().regFwk923().cOpeBbn());
        hrMghk800a().run() ;
        if (hrMghk800a().bghl800a().ok().isTrue()) {
            bghr0231().registo().xRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            bghr0231().registo().xRefMov().set(" ");
            log(TraceLevel.Error, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno(), "/", hrMghk800a().bghl800a().nmPrograma(), "/", hrMghk800a().bghl800a().cSqlcode());
        }
    }
    
    /**
     * 
     * 2400-SELECT-VGH10201
     * *2400-SELECT-VGH10201.
     * IF SW-DEBUG-SIM
     * DISPLAY '2400-SELECT-VGH10201'
     * END-IF.
     * INITIALIZE VGH10201-MOVHSTCPL
     * REPLACING ALPHANUMERIC BY SPACES
     * NUMERIC BY ZEROS.
     * MOVE VGH00201-C-PAIS-ISOA-CONT  TO VGH10201-C-PAIS-ISOA-CONT.
     * MOVE VGH00201-C-BANC-CONT       TO VGH10201-C-BANC-CONT.
     * MOVE VGH00201-C-OE-EGC-CONT     TO VGH10201-C-OE-EGC-CONT.
     * MOVE VGH00201-NS-RDCL-CONT      TO VGH10201-NS-RDCL-CONT.
     * MOVE VGH00201-V-CHKD-CONT       TO VGH10201-V-CHKD-CONT.
     * MOVE VGH00201-C-TIPO-CONT       TO VGH10201-C-TIPO-CONT..
     * MOVE VGH00201-C-MOED-ISO-SCTA   TO VGH10201-C-MOED-ISO-SCTA.
     * MOVE VGH00201-NS-DEPOSITO       TO VGH10201-NS-DEPOSITO.
     * MOVE VGH00201-TS-MOVIMENTO      TO VGH10201-TS-MOVIMENTO.
     * MOVE VGH00201-NS-MOVIMENTO      TO VGH10201-NS-MOVIMENTO.
     * EXEC SQL
     * SELECT C_PAIS_ISOA_OE_OPX,
     * C_MNEM_EGC_OPEX,
     * C_OE_EGC_OPEX,
     * C_OPE_BBN
     * INTO :VGH10201-C-PAIS-ISOA-OE-OPX,
     * :VGH10201-C-MNEM-EGC-OPEX,
     * :VGH10201-C-OE-EGC-OPEX,
     * :VGH10201-C-OPE-BBN
     * FROM VGH10201_MOVHSTCPL
     * WHERE C_PAIS_ISOA_CONT =: VGH10201-C-PAIS-ISOA-CONT
     * AND C_BANC_CONT      =: VGH10201-C-BANC-CONT
     * AND C_OE_EGC_CONT    =: VGH10201-C-OE-EGC-CONT
     * AND NS_RDCL_CONT     =: VGH10201-NS-RDCL-CONT
     * AND V_CHKD_CONT      =: VGH10201-V-CHKD-CONT
     * AND C_TIPO_CONT      =: VGH10201-C-TIPO-CONT
     * AND C_MOED_ISO_SCTA  =: VGH10201-C-MOED-ISO-SCTA
     * AND NS_DEPOSITO      =: VGH10201-NS-DEPOSITO
     * AND TS_MOVIMENTO     =: VGH10201-TS-MOVIMENTO
     * AND NS_MOVIMENTO     =: VGH10201-NS-MOVIMENTO
     * END-EXEC.
     * MOVE SQLCODE                    TO SW-SQLCODE-VGH10201.
     * ADD 1                           TO WS-SELECT.
     * EVALUATE TRUE
     * WHEN SQLCODE = 0
     * ADD 1                     TO WS-SELECT-OK
     * WHEN SQLCODE = +100
     * ADD 1                     TO WS-SELECT-NOK
     * WHEN OTHER
     * SET BHTW0030-ABEND-DB2    TO TRUE
     * MOVE BHOW0013-C-TIPO-OPE-OBJ-DB2
     * TO
     * BHTW0030-C-TIPO-OPE-OBJ-DB2
     * MOVE CON-VGH10201         TO BHTW0030-NM-TABELA
     * MOVE SW-SQLCODE-VGH10201  TO BHTW0030-C-SQLCODE
     * MOVE '2400-SELECT-VGH10201'
     * TO BHTW0030-X-SUG-RTNO-SWAL
     * PERFORM 9900-ABEND
     * THRU 9900-ABEND-EXIT
     * END-EVALUATE.
     * *2400-SELECT-VGH10201-EXIT.
     * EXIT.
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
        ficheiroFwk923().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK923);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk923().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk923().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK923);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk923().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FICHEIROS");
            m9900Abend() ;
        }
        ficheiroFgh023().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH023);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh023().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh023().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH023);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh023().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FICHEIROS");
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
        log(TraceLevel.Trace, "LEITURA A TABELA VGH10201");
        log(TraceLevel.Trace, "   NUMERO DE SELECT = ", wsVariaveis().wsSelect());
        log(TraceLevel.Trace, "              FOUND = ", wsVariaveis().wsSelectOk());
        log(TraceLevel.Trace, "          NOT FOUND = ", wsVariaveis().wsSelectNok());
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
        ficheiroFwk923().close() ;
        ficheiroFgh023().close() ;
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
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk923() ;
        @Data
        @Condition("00")
        ICondition swFwk923Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk923Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh023() ;
        @Data
        @Condition("00")
        ICondition swFgh023Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh023Eof() ;
        
        
    }
    
    /**
     * 
     * VARIAVEIS AUXILIARES
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=9, value="0")
        ILong wsRead() ;
        
        @Data(size=9, value="0")
        ILong wsSelect() ;
        
        @Data(size=9, value="0")
        ILong wsSelectOk() ;
        
        @Data(size=9, value="0")
        ILong wsSelectNok() ;
        
        @Data(size=9, value="0")
        ILong wsResto() ;
        
        @Data(size=9, value="0")
        ILong wsQuociente() ;
        
    }
    public interface SwSwitches extends IDataStruct {
        
        /**
         * 05 SW-SQLCODE-VGH00201         PIC S9(03) VALUE ZEROS.
         * 88 SW-VGH00201-OK                      VALUE +0.
         * 88 SW-VGH00201-NOTFND                  VALUE +100.
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        
        
    }
    
}
