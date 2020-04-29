package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
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
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghr1001 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq010a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk923
     */
    @Handler(name="FWK923", record="regFwk267")
    @Data
    protected abstract Fwk923 ficheiroFwk267() ;
    
    /**
     * @return instancia da classe Fgh100
     */
    @Handler(name="FGH100", record="regFgh100106")
    @Data
    protected abstract Fgh100 ficheiroFgh100() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr1001
     */
    @Data
    protected abstract Bghr1001 bghr1001() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    protected static final String CON_PROGRAMA = "PGHQ010A" ;
    
    protected static final String CON_DESCRICAO = "GERAR ALERTA PARA OS MOV DAS CONTAS POUPANCA E DP" ;
    
    protected static final String CON_FWK923 = "FWK923" ;
    
    protected static final String CON_FGH100 = "FGH100" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_ROTINA = "RO" ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitch
     */
    @Data
    protected abstract SwSwitch swSwitch() ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "********** INICIO **********");
        log(TraceLevel.Debug, CON_PROGRAMA, " - ", CON_DESCRICAO);
        m1000InicioPrograma() ;
        while (!ficheiroFwk267().getStatusOk()) {
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
        m1100IniciaVars() ;
        m1200TrataEstatIni() ;
        m8000DataHoraIni() ;
        m1300OpenFicheiros() ;
        m1400ReadFwk923() ;
    }
    
    /**
     * 
     * 1100-INICIA-VARS
     * 
     */
    protected void m1100IniciaVars() {
        log(TraceLevel.Debug, "1100-INICIA-VARS");
        wsVariaveis().initialize() ;
        bhtp0011ObtemDados() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OPEN-FICHEIROS
     * 
     */
    protected void m1300OpenFicheiros() {
        log(TraceLevel.Debug, "1300-OPEN-FICHEIROS");
        ficheiroFwk267().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK923);
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk267().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk267().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1300-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK923);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk267().getStatus());
            m9100TrataErroFich() ;
        }
        ficheiroFwk267().regFwk267().initialize() ;
        ficheiroFgh100().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH100);
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh100().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh100().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1300-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH100);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh100().getStatus());
            m9100TrataErroFich() ;
        }
        ficheiroFgh100().regFgh100106.initialize() ;
    }
    
    /**
     * 
     * 1400-READ-FWK923
     * 
     */
    protected void m1400ReadFwk923() {
        log(TraceLevel.Debug, "1400-READ-FWK923");
        ficheiroFwk267().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK923);
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk267().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk267().getStatusOk() && !ficheiroFwk267().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-READ-FWK923");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK923);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk267().getStatus());
            m9100TrataErroFich() ;
        } else {
            wsVariaveis().ws923ContaN().ws923CPaisIsoaN().set(ficheiroFwk267().regFwk267().subconta().cPaisIsoaCont());
            wsVariaveis().ws923ContaN().ws923CBancN().set(ficheiroFwk267().regFwk267().subconta().cBancCont());
            wsVariaveis().ws923ContaN().ws923COeEgcN().set(ficheiroFwk267().regFwk267().subconta().cOeEgcCont());
            wsVariaveis().ws923ContaN().ws923NsRdclN().set(ficheiroFwk267().regFwk267().subconta().nsRdclCont());
            wsVariaveis().ws923ContaN().ws923VChkdN().set(ficheiroFwk267().regFwk267().subconta().vChkdCont());
            wsVariaveis().ws923ContaN().ws923CTipoN().set(ficheiroFwk267().regFwk267().subconta().cTipoCont());
            wsVariaveis().ws923ContaN().ws923CMoedIsoN().set(ficheiroFwk267().regFwk267().subconta().cMoedIsoScta());
            wsVariaveis().ws923ContaN().ws923NsDepoN().set(ficheiroFwk267().regFwk267().subconta().nsDeposito());
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        if (ficheiroFwk267().regFwk267().iEstorno().isEqual(bhok0002().situacaoMov().sitMovEstornador())) {
            m2100FormataMovimento() ;
            wsVariaveis().ws923ContaNAnt().ws923CPaisIsoaNAnt().set(wsVariaveis().ws923ContaN().ws923CPaisIsoaN());
            wsVariaveis().ws923ContaNAnt().ws923CBancNAnt().set(wsVariaveis().ws923ContaN().ws923CBancN());
            wsVariaveis().ws923ContaNAnt().ws923COeEgcNAnt().set(wsVariaveis().ws923ContaN().ws923COeEgcN());
            wsVariaveis().ws923ContaNAnt().ws923NsRdclNAnt().set(wsVariaveis().ws923ContaN().ws923NsRdclN());
            wsVariaveis().ws923ContaNAnt().ws923VChkdNAnt().set(wsVariaveis().ws923ContaN().ws923VChkdN());
            wsVariaveis().ws923ContaNAnt().ws923CTipoNAnt().set(wsVariaveis().ws923ContaN().ws923CTipoN());
            wsVariaveis().ws923ContaNAnt().ws923CMoedIsoNAnt().set(wsVariaveis().ws923ContaN().ws923CMoedIsoN());
            wsVariaveis().ws923ContaNAnt().ws923NsDepoNAnt().set(wsVariaveis().ws923ContaN().ws923NsDepoN());
        } else if (ficheiroFwk267().regFwk267().subconta().cPaisIsoaCont().isEqual(wsVariaveis().ws923ContaNAnt().ws923CPaisIsoaNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().cBancCont().isEqual(wsVariaveis().ws923ContaNAnt().ws923CBancNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().cOeEgcCont().isEqual(wsVariaveis().ws923ContaNAnt().ws923COeEgcNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().nsRdclCont().isEqual(wsVariaveis().ws923ContaNAnt().ws923NsRdclNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().vChkdCont().isEqual(wsVariaveis().ws923ContaNAnt().ws923VChkdNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().cTipoCont().isEqual(wsVariaveis().ws923ContaNAnt().ws923CTipoNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().cMoedIsoScta().isEqual(wsVariaveis().ws923ContaNAnt().ws923CMoedIsoNAnt()) && 
            ficheiroFwk267().regFwk267().subconta().nsDeposito().isEqual(wsVariaveis().ws923ContaNAnt().ws923NsDepoNAnt())) {
            m2100FormataMovimento() ;
        }
        m1400ReadFwk923() ;
    }
    
    /**
     * 
     * 2100-FORMATA-MOVIMENTO
     * 
     */
    protected void m2100FormataMovimento() {
        log(TraceLevel.Debug, "2100-FORMATA-MOVIMENTO");
        ficheiroFgh100().regFgh100106.initialize() ;
        wsVariaveis().ws923Conta().set(wsVariaveis().ws923ContaN());
        bghr1001().registo().cCttoEgc().set(wsVariaveis().ws923Conta());
        bghr1001().registo().zMovimento().set(ficheiroFwk267().regFwk267().zMovimento());
        bghr1001().registo().timerMov().get(1, 2).set(ficheiroFwk267().regFwk267().tsActzUlt().get(12, 2)) ;
        bghr1001().registo().timerMov().get(3, 2).set(ficheiroFwk267().regFwk267().tsActzUlt().get(15, 2)) ;
        bghr1001().registo().mMovimento().set(ficheiroFwk267().regFwk267().mMovimento());
        bghr1001().registo().cUserid().set(ficheiroFwk267().regFwk267().cUserid());
        bghr1001().registo().oeOrigMov().set(ficheiroFwk267().regFwk267().cOeEgcOpex());
        bghr1001().registo().iEstorno().set(ficheiroFwk267().regFwk267().iEstorno());
        bghr1001().registo().iDbcr().set(ficheiroFwk267().regFwk267().iDbcr());
        bghr1001().registo().dataValor().set(ficheiroFwk267().regFwk267().zValor());
        bghr1001().registo().cMoedIsoOriMov().set(ficheiroFwk267().regFwk267().cMoedIsoOriMov());
        bghr1001().registo().cOpeBbn().set(ficheiroFwk267().regFwk267().cOpeBbn());
        bghr1001().registo().cTipoCanlAces().set(ficheiroFwk267().regFwk267().cTipoCanlAces());
        bghr1001().registo().aAplicacao().set(ficheiroFwk267().regFwk267().aAplicacao());
        bghr1001().registo().cOpczMenu().set(ficheiroFwk267().regFwk267().cOpczMenu());
        bghr1001().registo().evento().set(ficheiroFwk267().regFwk267().cEvenOpel());
        m2200WriteFgh100() ;
    }
    
    /**
     * 
     * 2200-WRITE-FGH100
     * 
     */
    protected void m2200WriteFgh100() {
        log(TraceLevel.Debug, "2200-WRITE-FGH100");
        ficheiroFgh100().write(ficheiroFgh100().regFgh100106) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH100);
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh100().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh100().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-WRITE-FGH100");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH100);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh100().getStatus());
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
        bhop0013FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIROS
     * 
     */
    protected void m3100FechaFicheiros() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIROS");
        ficheiroFwk267().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK923);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk267().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk267().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK923);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk267().getStatus());
            m9100TrataErroFich() ;
        }
        ficheiroFgh100().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH100);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh100().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh100().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH100);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh100().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9100TrataErroFich() ;
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
        bhop0013FimEstatistica() ;
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
        ficheiroFwk267().close() ;
        ficheiroFgh100().close() ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
        rollback() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        /**
         * FORMATACAO DE RETURN-CODE E ROLLBACK
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
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitch extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFwk923() ;
        @Data
        @Condition("00")
        ICondition swFwk923Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk923Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh100() ;
        @Data
        @Condition("00")
        ICondition swFgh100Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh100Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local Ws923ContaN
         */
        @Data
        Ws923ContaN ws923ContaN() ;
        
        /**
         * 05 WS-923-CONTA                 PIC X(22) VALUE SPACES.
         */
        @Data(size=29, value=" ")
        IString ws923Conta() ;
        
        /**
         * @return instancia da classe local Ws923ContaMask
         */
        @Data
        @Mask
        Ws923ContaMask ws923ContaMask() ;
        
        /**
         * @return instancia da classe local Ws923ContaNAnt
         */
        @Data
        Ws923ContaNAnt ws923ContaNAnt() ;
        
        /**
         * 05 WS-923-CONTA-ANT             PIC X(22) VALUE SPACES.
         */
        @Data(size=29, value=" ")
        IString ws923ContaAnt() ;
        
        /**
         * @return instancia da classe local Ws923ContaAntMask
         */
        @Data
        @Mask
        Ws923ContaAntMask ws923ContaAntMask() ;
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=10, value=" ")
        IString wsZProcessamento() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        
        public interface Ws923ContaN extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString ws923CPaisIsoaN() ;
            
            @Data(size=4, value="0")
            IInt ws923CBancN() ;
            
            @Data(size=4, value="0")
            IInt ws923COeEgcN() ;
            
            @Data(size=7, value="0")
            IInt ws923NsRdclN() ;
            
            @Data(size=1, value="0")
            IInt ws923VChkdN() ;
            
            @Data(size=3, value="0")
            IInt ws923CTipoN() ;
            
            @Data(size=3, value=" ")
            IString ws923CMoedIsoN() ;
            
            @Data(size=4, value="0")
            IInt ws923NsDepoN() ;
            
        }
        
        public interface Ws923ContaMask extends IDataMask {
            
            @Data(size=3)
            IString ws923CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt ws923CBancCont() ;
            
            @Data(size=4)
            IInt ws923COeEgcCont() ;
            
            @Data(size=7)
            IInt ws923NsRdclCont() ;
            
            @Data(size=1)
            IInt ws923VChkdCont() ;
            
            @Data(size=3)
            IInt ws923CTipoCont() ;
            
            @Data(size=3)
            IString ws923CMoedIsoScta() ;
            
            @Data(size=4)
            IInt ws923NsDeposito() ;
            
        }
        
        public interface Ws923ContaNAnt extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString ws923CPaisIsoaNAnt() ;
            
            @Data(size=4, value="0")
            IInt ws923CBancNAnt() ;
            
            @Data(size=4, value="0")
            IInt ws923COeEgcNAnt() ;
            
            @Data(size=7, value="0")
            IInt ws923NsRdclNAnt() ;
            
            @Data(size=1, value="0")
            IInt ws923VChkdNAnt() ;
            
            @Data(size=3, value="0")
            IInt ws923CTipoNAnt() ;
            
            @Data(size=3, value=" ")
            IString ws923CMoedIsoNAnt() ;
            
            @Data(size=4, value="0")
            IInt ws923NsDepoNAnt() ;
            
        }
        
        public interface Ws923ContaAntMask extends IDataMask {
            
            @Data(size=3)
            IString ws923CPaisIsoaContAnt() ;
            
            @Data(size=4)
            IInt ws923CBancContAnt() ;
            
            @Data(size=4)
            IInt ws923COeEgcContAnt() ;
            
            @Data(size=7)
            IInt ws923NsRdclContAnt() ;
            
            @Data(size=1)
            IInt ws923VChkdContAnt() ;
            
            @Data(size=3)
            IInt ws923CTipoContAnt() ;
            
            @Data(size=3)
            IString ws923CMoedIsoSctaAnt() ;
            
            @Data(size=4)
            IInt ws923NsDepositoAnt() ;
            
        }
    }
    
}
