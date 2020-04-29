package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
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
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ht.routines.Mhtq200a ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq900a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fhy003
     */
    @Handler(name="FHY003")
    @Data
    protected abstract Fhy003 ficheiroFhy003() ;
    
    /**
     * @return instancia da classe Fvg900
     */
    @Handler(name="FVG900", record="regFwk545Pghq900a")
    @Data
    protected abstract Fvg900 ficheiroFwk545() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
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
     * COPY DOS SQLCA
     * AREA DE CONSTANTES
     * INICIO WORKING-STORAGE PGHQ900A
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ900A" ;
    
    protected static final String CON_FWK545 = "FWK545" ;
    
    protected static final String CON_S = "S" ;
    
    protected static final String CON_N = "N" ;
    
    protected static final String CON_DESCRICAO = "ACTUALIZA DATA MOVIMENTO NA TGH00002" ;
    
    /**
     * AREA DE VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local WsTsMovimento
     */
    @Data
    protected abstract WsTsMovimento wsTsMovimento() ;
    
    /**
     * AREA DE STATUS
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    
    
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
        /**
         * SET DEBUG-SIM             TO TRUE.
         */
        m1000Inicio() ;
        while (ficheiroFwk545().getStatusOk()) {
            m2000Processo() ;
        }
        m3000Fim() ;
    }
    
    /**
     * 
     * 1000-INICIO
     * 
     */
    protected void m1000Inicio() {
        m1050Inicializacoes() ;
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
        m1100AbreFicheiros() ;
        m1200ObtemDatasApli() ;
        m1300ObtemDatasD() ;
        m1500LeFichFwk545() ;
        wsVariaveis().wsContadoresRegistos().wsNumRegFwk545().set(1);
    }
    
    /**
     * 
     * 1050-INICIALIZACOES
     * 
     */
    protected void m1050Inicializacoes() {
        bhtl200a().commarea().initialize() ;
        wsVariaveis().initialize() ;
    }
    
    /**
     * 
     * 1100-ABRE-FICHEIRO
     * 
     */
    protected void m1100AbreFicheiros() {
        ficheiroFwk545().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK545);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk545().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk545().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
    }
    
    /**
     * 
     * 1200-OBTEM-DATAS-APLICACAO
     * 
     */
    protected void m1200ObtemDatasApli() {
        bhtl200a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl200a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0010CaplicDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl200a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl200a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl200a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl200a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl200a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl200a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1300-OBTEM-DATAS-D
     * DATA NECESSARIA PARA O REARRANQUE DO PROGRAMA]
     * 
     */
    protected void m1300ObtemDatasD() {
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasDAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * PROCEDIMENTO STANDART DE LEITURA DE FICHEIRO DE INPUT
     * 
     */
    protected void m1500LeFichFwk545() {
        ficheiroFwk545().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK545);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk545().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFwk545().getStatusOk()) {
            wsVariaveis().wsContadoresRegistos().wsNumRegFwk545().add(1);
        } else if (!ficheiroFwk545().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO
     * 
     */
    protected void m2000Processo() {
        m2100ActzZMovTgh002() ;
        m2200ActzZMovTgh102() ;
        m1500LeFichFwk545() ;
    }
    
    /**
     * 
     * 2100-ACTZ-Z-MOV-TGH002
     * 
     */
    protected void m2100ActzZMovTgh002() {
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545NsDeposito());
        hv00201Movhst().movhst().nsMovimento().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545NsMovimento());
        wsTsMovimento().wsData().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545ZMovimento());
        hv00201Movhst().movhst().tsMovimento().set(wsTsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq900a395() ;
        swStatus().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("TGH00002");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swStatus().swVgh00201Ok().isTrue()) {
            m9800ErroDb2() ;
        }
    }
    
    /**
     * 
     * 2200-ACTZ-Z-MOV-TGH102
     * 
     */
    protected void m2200ActzZMovTgh102() {
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545Conta().bhow8545CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545Subconta().bhow8545NsDeposito());
        hv10201Movhstcpl().movhstcpl().nsMovimento().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545NsMovimento());
        wsTsMovimento().wsData().set(ficheiroFwk545().regFwk545Pghq900a().bhow8545ZMovimento());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(wsTsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().updatePghq900a445() ;
        swStatus().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("TGH00102");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swStatus().swVgh10201Ok().isTrue()) {
            m9800ErroDb2() ;
        }
    }
    
    /**
     * 
     * 3000-FIM
     * 
     */
    protected void m3000Fim() {
        log(TraceLevel.Debug, "3000-FIM                 ");
        m3100FechaFicheiro() ;
        bhop0013FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIRO
     * 
     */
    protected void m3100FechaFicheiro() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIRO      ");
        ficheiroFwk545().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK545);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk545().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk545().getStatusOk()) {
            m9700ErroFicheiro() ;
        }
    }
    
    /**
     * 
     * 9700-PREENCHE - ERRO FICHEIRO
     * 
     */
    protected void m9700ErroFicheiro() {
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
        bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
        bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9800-PREENCHE-CHAVE DE ACESSO DE ERRO DB2
     * 
     */
    protected void m9800ErroDb2() {
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
        bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
        bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
        bhtw0030().dadosEntrada().abendDb2().setTrue() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        /**
         * DISPLAY '---------------  VAI ABENDAR]]  ------------------'.
         * DISPLAY 'QTD DE REG EM QUE FAZ COMMIT:'BHYL500A-Q-COMMIT.
         * DISPLAY 'NUM DE REGS PARA REARRANQUE :'WS-NUM-REG-REARRAN545.
         * DISPLAY 'NUMERO DE READS TOTAL       :'WS-CONTADOR-READ-TOT.
         * DISPLAY 'NUMERO DE READS INICIO      :'WS-CONTADOR-READ-INI.
         * DISPLAY 'NUMERO DE COMMITS EFECUADOS :'WS-CONTADOR-COMMITS.
         */
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
    
    /**
     * 
     * AREA DE VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsContadoresRegistos
         */
        @Data
        WsContadoresRegistos wsContadoresRegistos() ;
        
        /**
         * REARRANQUE DE FICHEIRO DE LEITURA
         * @return instancia da classe local WsRearranque
         */
        @Data
        WsRearranque wsRearranque() ;
        
        /**
         * 05 WS-CONTADOR-READ-TOT         PIC 9(05) VALUE ZEROS.
         * 05 WS-CONTADOR-READ-INI         PIC 9(05) VALUE ZEROS.
         * 05 WS-CONTADOR-COMMITS          PIC 9(05) VALUE ZEROS.
         * @return instancia da classe local WsMontantes
         */
        @Data
        WsMontantes wsMontantes() ;
        
        /**
         * @return instancia da classe local WsChvAuxTab110
         */
        @Data
        WsChvAuxTab110 wsChvAuxTab110() ;
        
        
        public interface WsContadoresRegistos extends IDataStruct {
            
            @Data(size=15)
            ILong wsNumRegFwk545() ;
            
        }
        
        
        /**
         * 
         * REARRANQUE DE FICHEIRO DE LEITURA
         * 
         * @version 2.0
         * 
         */
        public interface WsRearranque extends IDataStruct {
            
            @Data(size=15, rpadding=235)
            ILong wsNumRegRearran545() ;
            
        }
        
        
        /**
         * 
         * 05 WS-CONTADOR-READ-TOT         PIC 9(05) VALUE ZEROS.
         * 05 WS-CONTADOR-READ-INI         PIC 9(05) VALUE ZEROS.
         * 05 WS-CONTADOR-COMMITS          PIC 9(05) VALUE ZEROS.
         * 
         * @version 2.0
         * 
         */
        public interface WsMontantes extends IDataStruct {
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal wsMJuroPagoTit() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal wsMImpPagoTit() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal wsMImpIsezTit() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal ws110MJuroCaldPend() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal ws110MImpCaldPend() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal ws110MImpIsezPend() ;
            
        }
        
        public interface WsChvAuxTab110 extends IDataStruct {
            
            @Data(size=3)
            IString aux2CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt aux2CBancCont() ;
            
            @Data(size=4)
            IInt aux2COeEgcCont() ;
            
            @Data(size=7)
            IInt aux2NsRdclCont() ;
            
            @Data(size=1)
            IInt aux2VChkdCont() ;
            
            @Data(size=3)
            IInt aux2CTipoCont() ;
            
            @Data(size=3)
            IString aux2CMoedIsoScta() ;
            
            @Data(size=4)
            IInt aux2NsDeposito() ;
            
            @Data(size=6)
            IInt aux2NsCmrg() ;
            
            @Data(size=3)
            IInt aux2NsSdep() ;
            
            @Data(size=2)
            IString aux2CTipoJuro() ;
            
            @Data(size=10)
            IString aux2ZLiquidacao() ;
            
            @Data(size=10)
            IString aux2ZFimPerCalc() ;
            
        }
    }
    public interface WsTsMovimento extends IDataStruct {
        
        @Data(size=10)
        IString wsData() ;
        
        @Data(size=16, value="-00.00.00.000000")
        IString wsTimestamp() ;
        
    }
    
    /**
     * 
     * AREA DE STATUS
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
        IString statusFwk545() ;
        @Data
        @Condition("00")
        ICondition swFwk545Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk545Eof() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
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
