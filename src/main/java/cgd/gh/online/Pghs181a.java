package cgd.gh.online;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseOnline ;
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
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1180 ;
import cgd.gh.structures.messages.Bghm1181 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ho.structures.work.Bhow0002 ;
import cgd.ho.structures.work.Bhow0004 ;
import cgd.hs.structures.link.Bhsl110a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hs.common.constants.Bhsk0002 ;
import cgd.hs.routines.Mhsj110a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghj206a ;
import cgd.gh.routines.Mghj207a ;
import cgd.gh.routines.Mghs022a ;
import cgd.gh.routines.Mghs805a ;
import cgd.gh.routines.Mghs002a ;
import cgd.gh.routines.Mghs804a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghs102a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS181A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1863
 * FUNCAO     : CONSULTA MOVIMENTOS A CREDITO DE UMA CONTA CUJAS
 * CARACTERISTICAS LHE PERMITEM TER UMA EXTENSAO DE
 * GARANTIA
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES:
 * LOG DE ALTERACOES
 * PROCESSO!   DATA   ! UTILZ ! OBSERVACOES
 * GH1863  !2015-09-07!E001449!  CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs181a extends CgdGhBaseOnline<Pghs181a.EnvelopeIn, Pghs181a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1180
     */
    public abstract Bghm1180 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1181
     */
    public abstract Bghm1181 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1180.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1181.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00901Infauxmov
     */
    @Data
    protected abstract Vwsdghps00901Infauxmov hv00901Infauxmov() ;
    
    /**
     * @return instancia da classe Vwsdghps20001Movexgdep
     */
    @Data
    protected abstract Vwsdghps20001Movexgdep hv20001Movexgdep() ;
    
    /**
     * @return instancia da classe Vwsdhops00101Contas
     */
    @Data
    protected abstract Vwsdhops00101Contas hv00101Contas() ;
    
    /**
     * @return instancia da classe Vwsdhops00201Subcontas
     */
    @Data
    protected abstract Vwsdhops00201Subcontas hv00201Subcontas() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhsj110a
     */
    @Data
    protected abstract Mhsj110a hrMhsj110a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mghj206a
     */
    @Data
    protected abstract Mghj206a hrMghj206a() ;
    
    /**
     * @return instancia da classe Mghj207a
     */
    @Data
    protected abstract Mghj207a hrMghj207a() ;
    
    /**
     * @return instancia da classe Mghs022a
     */
    @Data
    protected abstract Mghs022a hrMghs022a() ;
    
    /**
     * @return instancia da classe Mghs805a
     */
    @Data
    protected abstract Mghs805a hrMghs805a() ;
    
    /**
     * @return instancia da classe Mghs002a
     */
    @Data
    protected abstract Mghs002a hrMghs002a() ;
    
    /**
     * @return instancia da classe Mghs804a
     */
    @Data
    protected abstract Mghs804a hrMghs804a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bhok0001
     */
    @Data
    protected abstract Bhok0001 bhok0001() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhow0002
     */
    @Data
    protected abstract Bhow0002 bhow0002() ;
    
    /**
     * @return instancia da classe Bhow0004
     */
    @Data
    protected abstract Bhow0004 bhow0004() ;
    
    /**
     * @return instancia da classe Bhsl110a
     */
    @Data
    protected abstract Bhsl110a bhsl110a() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhsk0002
     */
    @Data
    protected abstract Bhsk0002 bhsk0002() ;
    
    @Data(size=8, value="MGHK800A")
    protected IString mgh800aCRotina ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_A_APL_GH = "GH" ;
    
    protected static final String CON_A_APL_HO = "HO" ;
    
    protected static final String CON_S = "S" ;
    
    protected static final String CON_N = "N" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    protected static final String CON_1 = "1" ;
    
    protected static final String CON_J07 = "J07" ;
    
    protected static final String CON_POR = "POR" ;
    
    protected static final String CON_DATA_MINIMA = "0001-01-01" ;
    
    protected static final String CON_DATA_MAXIMA = "9999-12-31" ;
    
    protected static final String CON_VGH20001 = "VGH20001" ;
    
    protected static final String CON_VGH00901 = "VGH00901" ;
    
    protected static final String CON_ATIVO = "A" ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_3N = 3 ;
    
    protected static final int CON_MAX_OCC_DLVDAS = 13 ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local WsTs
     */
    @Data
    protected abstract WsTs wsTs() ;
    
    /**
     * @return instancia da classe local WsTimestamp
     */
    @Data
    protected abstract WsTimestamp wsTimestamp() ;
    
    /**
     * ****          TABELAS INTERNAS                            ****
     * @return instancia da classe local WsTabelaMovimento
     */
    @Data
    protected abstract WsTabelaMovimento wsTabelaMovimento() ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * CONTAS - VALIDACAO DA CONTA SEM OPCAO UPDATE MODO MISTO
     * PROCEDURE: BHOP0002.
     * O COPY PROCEDURE IRA:
     * -EFECTUA SELECT A TABELA DE CONTAS COM A CHAVE DA TABELA
     * -VALIDA A EXISTENCIA DA CONTA
     * -VALIDA RESTRICOES DE ACESSO DA CONTA
     * 
     */
    protected void bhop0002ValConta() {
        bhop0002InicVariaveis() ;
        bhop0002SelectRegisto() ;
        if (bhow0002().areaComum().dadosOutput().semErros().isTrue()) {
            if (bhow0002().areaComum().dadosInput().iraConSim().isTrue()) {
                if (hv00101Contas().contas().iExisRstzCont().isEqual(bhok0002().BHOK0002_CON_S)) {
                    bhop0002ValidaRestricao() ;
                }
            }
        }
    }
    
    /**
     * 
     * BHOP0002-INIC-VARIAVEIS
     * 
     */
    protected void bhop0002InicVariaveis() {
        bhow0002().areaComum().dadosOutput().initialize() ;
    }
    
    /**
     * 
     * BHOP0002-SELECT-REGISTO
     * 
     */
    protected void bhop0002SelectRegisto() {
        hv00101Contas().contas().cPaisIsoaCont().set(bhow0002().areaComum().dadosInput().cPaisIsoaCont());
        hv00101Contas().contas().cBancCont().set(bhow0002().areaComum().dadosInput().cBancCont());
        hv00101Contas().contas().cOeEgcCont().set(bhow0002().areaComum().dadosInput().cOeEgcCont());
        hv00101Contas().contas().nsRdclCont().set(bhow0002().areaComum().dadosInput().nsRdclCont());
        hv00101Contas().contas().vChkdCont().set(bhow0002().areaComum().dadosInput().vChkdCont());
        hv00101Contas().contas().cTipoCont().set(bhow0002().areaComum().dadosInput().cTipoCont());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO00101_CONTAS
         */
        hv00101Contas().selectBhop000255() ;
        bhow0002().areaComum().dadosOutput().cSqlcode().set(hv00101Contas().getPersistenceCode());
        bhow0002().areaComum().status().sqlcodeVho00101().set(hv00101Contas().getPersistenceCode());
        m9020Db2check() ;
        if (bhow0002().areaComum().dadosOutput().semErros().isTrue()) {
            if (bhow0002().areaComum().status().vho00101Notfnd().isTrue()) {
                bhop0002TratErros() ;
                bhow0002().areaComum().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                bhow0002().areaComum().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().ctaNaoExiste());
                bhow0002().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                bhow0002().areaComum().dadosOutput().msgErrob().set("REGISTO INEXISTENTE NA TABELA CONTAS");
            } else if (!bhow0002().areaComum().status().vho00101Ok().isTrue()) {
                bhop0002TratErros() ;
                bhow0002().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                bhow0002().areaComum().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                bhow0002().areaComum().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().erroBaseDados());
                bhow0002().areaComum().dadosOutput().msgErrob().set("REGISTO INEXISTENTE NA TABELA CONTAS");
            }
        }
    }
    
    /**
     * 
     * BHOP0002-VALIDA-RESTRICAO
     * ACEDE A UM MODULO DA ARQUITECTURA P/ VERIFICAR SE A CONTA
     * POSSUI RESTRICOES RELATIVAMENTE AO UTILIZADOR.
     * ACTUALIZA O INDICADOR DA MENSAGEM DE LIGACAO COM O RESULTADO DO*
     * MODULO DE RESTRICAO DE CONTA.
     * 
     */
    protected void bhop0002ValidaRestricao() {
        bhsl110a().commarea().initialize() ;
        bhsl110a().commarea().dadosEntrada().cTransaccao().set(bhow0002().areaComum().dadosInput().cTransaccao());
        bhsl110a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0002().areaComum().dadosInput().cPaisIsoaCont());
        bhsl110a().commarea().dadosEntrada().cBancCont().set(bhow0002().areaComum().dadosInput().cBancCont());
        bhsl110a().commarea().dadosEntrada().cOeEgcCont().set(bhow0002().areaComum().dadosInput().cOeEgcCont());
        bhsl110a().commarea().dadosEntrada().nsRdclCont().set(bhow0002().areaComum().dadosInput().nsRdclCont());
        bhsl110a().commarea().dadosEntrada().cTipoCont().set(bhow0002().areaComum().dadosInput().cTipoCont());
        bhsl110a().commarea().dadosEntrada().cUserid().set(bhow0002().areaComum().dadosInput().cUserid());
        bhsl110a().commarea().dadosEntrada().cPerfUtlBbn().set(bhow0002().areaComum().dadosInput().cPerfUtlBbn());
        bhsl110a().commarea().dadosEntrada().ctNvelAtrzBbn().set(bhow0002().areaComum().dadosInput().ctNvelAtrzBbn());
        bhsp0110ValRestAcesCt() ;
        bhow0002().areaComum().dadosInput().iRstzAcesCont().set(bhsl110a().commarea().dadosSaida().iRstzAcesCont());
        if (bhsl110a().commarea().dadosSaida().semErros().isTrue()) {
            if (bhow0002().areaComum().dadosInput().iraConValSim().isTrue()) {
                bhow0002().areaComum().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().utilSemAcesso());
                bhow0002().areaComum().dadosOutput().modOrigemErro().set(bhow0002().areaComum().bhop0002());
                bhow0002().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                bhow0002().areaComum().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                bhow0002().areaComum().dadosOutput().msgErrob().set("UTILIZADOR SEM ACESSO");
            }
        } else {
            bhow0002().areaComum().dadosOutput().cSqlcode().set(bhsl110a().commarea().dadosSaida().cSqlcode());
            bhow0002().areaComum().dadosOutput().nmTabela().set(bhsl110a().commarea().dadosSaida().nmTabela());
            bhow0002().areaComum().dadosOutput().chAcesso().set(bhsl110a().commarea().dadosSaida().chvAces());
            bhow0002().areaComum().dadosOutput().msgErrob().set("ERRO NO ACESSO A ROTINA MHSJ110A");
            bhow0002().areaComum().dadosOutput().aAplErr().set(bhsl110a().commarea().dadosSaida().aAplErr());
            bhow0002().areaComum().dadosOutput().modOrigemErro().set("MHSJ110A");
            bhow0002().areaComum().dadosOutput().cRtnoEvenSwal().set(bhsl110a().commarea().dadosSaida().cRtnoEvenSwal());
            bhow0002().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
        }
    }
    
    /**
     * 
     * BHOP0002-TRAT-ERROS
     * 
     */
    protected void bhop0002TratErros() {
        bhow0002().areaComum().dadosOutput().nmTabela().set(bhow0002().areaComum().vho00101());
        bhow0002().areaComum().dadosOutput().modOrigemErro().set(bhow0002().areaComum().bhop0002());
        bhow0002().areaComum().descompactador().cPaisIsoaContD().set(bhow0002().areaComum().dadosInput().cPaisIsoaCont());
        bhow0002().areaComum().descompactador().cBancContD().set(bhow0002().areaComum().dadosInput().cBancCont());
        bhow0002().areaComum().descompactador().cOeEgcContD().set(bhow0002().areaComum().dadosInput().cOeEgcCont());
        bhow0002().areaComum().descompactador().nsRdclContD().set(bhow0002().areaComum().dadosInput().nsRdclCont());
        bhow0002().areaComum().descompactador().vChkdContD().set(bhow0002().areaComum().dadosInput().vChkdCont());
        bhow0002().areaComum().descompactador().cTipoContD().set(bhow0002().areaComum().dadosInput().cTipoCont());
        bhow0002().areaComum().dadosOutput().chAcesso().set(bhow0002().areaComum().descompactador());
    }
    
    /**
     * 
     * CONTAS - VALIDACAO DA SUBCONTA SEM OPCAO UPDATE MODO MISTO*
     * PROCEDURE: BHOP0004.
     * O COPY PROCEDURE IRA:
     * -EFECTUA SELECT A TABELA DE SUBCONTAS COM A CHV DA TABELA*
     * -VALIDA A EXISTENCIA DA SUBCONTA
     * -VALIDA RESTRICOES DE ACESSO DA SUBCONTA
     * 
     */
    protected void bhop0004ValSubcta() {
        bhop0004IniVariaveis() ;
        bhop0004SelectRegisto() ;
        if (bhow0004().areaComum().dadosOutput().semErros().isTrue()) {
            if (bhow0004().areaComum().dadosInput().iraConSim().isTrue()) {
                if (hv00201Subcontas().subcontas().iExisRstzScta().isEqual(bhok0002().BHOK0002_CON_S)) {
                    bhop0004ValRestricao() ;
                }
            }
        }
    }
    
    /**
     * 
     * BHOP0004-INI-VARIAVEIS
     * 
     */
    protected void bhop0004IniVariaveis() {
        bhow0004().areaComum().dadosOutput().initialize() ;
    }
    
    /**
     * 
     * BHOP0004-SELECT-REGISTO
     * 
     */
    protected void bhop0004SelectRegisto() {
        hv00201Subcontas().subcontas().cPaisIsoaCont().set(bhow0004().areaComum().dadosInput().cPaisIsoaCont());
        hv00201Subcontas().subcontas().cBancCont().set(bhow0004().areaComum().dadosInput().cBancCont());
        hv00201Subcontas().subcontas().cOeEgcCont().set(bhow0004().areaComum().dadosInput().cOeEgcCont());
        hv00201Subcontas().subcontas().nsRdclCont().set(bhow0004().areaComum().dadosInput().nsRdclCont());
        hv00201Subcontas().subcontas().vChkdCont().set(bhow0004().areaComum().dadosInput().vChkdCont());
        hv00201Subcontas().subcontas().cTipoCont().set(bhow0004().areaComum().dadosInput().cTipoCont());
        hv00201Subcontas().subcontas().cMoedIsoScta().set(bhow0004().areaComum().dadosInput().cMoedIsoScta());
        hv00201Subcontas().subcontas().nsDeposito().set(bhow0004().areaComum().dadosInput().nsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO00201_SUBCONTAS
         */
        hv00201Subcontas().selectBhop000458() ;
        bhow0004().areaComum().dadosOutput().cSqlcode().set(hv00201Subcontas().getPersistenceCode());
        bhow0004().areaComum().status().sqlcodeVho00201().set(hv00201Subcontas().getPersistenceCode());
        m9020Db2check() ;
        if (bhow0004().areaComum().dadosOutput().semErros().isTrue()) {
            if (bhow0004().areaComum().status().vho00201Notfnd().isTrue()) {
                bhop0004TratErros() ;
                bhow0004().areaComum().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                bhow0004().areaComum().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().subctaNaoExiste());
                bhow0004().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                bhow0004().areaComum().dadosOutput().msgErrob().set("REGISTO INEXISTENTE NA TABELA SUBCONTAS");
            } else if (!bhow0004().areaComum().status().vho00201Ok().isTrue()) {
                bhop0004TratErros() ;
                bhow0004().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                bhow0004().areaComum().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                bhow0004().areaComum().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().erroBaseDados());
                bhow0004().areaComum().dadosOutput().msgErrob().set("ERRO SELECT NA TABELA SUBCONTAS");
            }
        }
    }
    
    /**
     * 
     * BHOP0004-TRAT-ERROS
     * 
     */
    protected void bhop0004TratErros() {
        bhow0004().areaComum().dadosOutput().nmTabela().set(bhow0004().areaComum().dadosInput().vho00201());
        bhow0004().areaComum().dadosOutput().modOrigemErro().set(bhow0004().areaComum().dadosInput().bhop0004());
        bhow0004().areaComum().descompactador().cPaisIsoaContD().set(bhow0004().areaComum().dadosInput().cPaisIsoaCont());
        bhow0004().areaComum().descompactador().cBancContD().set(bhow0004().areaComum().dadosInput().cBancCont());
        bhow0004().areaComum().descompactador().cOeEgcContD().set(bhow0004().areaComum().dadosInput().cOeEgcCont());
        bhow0004().areaComum().descompactador().nsRdclContD().set(bhow0004().areaComum().dadosInput().nsRdclCont());
        bhow0004().areaComum().descompactador().vChkdContD().set(bhow0004().areaComum().dadosInput().vChkdCont());
        bhow0004().areaComum().descompactador().cTipoContD().set(bhow0004().areaComum().dadosInput().cTipoCont());
        bhow0004().areaComum().descompactador().cMoedIsoSctaD().set(bhow0004().areaComum().dadosInput().cMoedIsoScta());
        bhow0004().areaComum().descompactador().nsDepositoD().set(bhow0004().areaComum().dadosInput().nsDeposito());
        bhow0004().areaComum().dadosOutput().chAcesso().set(bhow0004().areaComum().descompactador());
    }
    
    /**
     * 
     * BHOP0004-VAL-RESTRICAO
     * 
     */
    protected void bhop0004ValRestricao() {
        bhsl110a().commarea().initialize() ;
        bhsl110a().commarea().dadosEntrada().cTransaccao().set(bhow0004().areaComum().dadosInput().cTransaccao());
        bhsl110a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0004().areaComum().dadosInput().cPaisIsoaCont());
        bhsl110a().commarea().dadosEntrada().cBancCont().set(bhow0004().areaComum().dadosInput().cBancCont());
        bhsl110a().commarea().dadosEntrada().cOeEgcCont().set(bhow0004().areaComum().dadosInput().cOeEgcCont());
        bhsl110a().commarea().dadosEntrada().nsRdclCont().set(bhow0004().areaComum().dadosInput().nsRdclCont());
        bhsl110a().commarea().dadosEntrada().cTipoCont().set(bhow0004().areaComum().dadosInput().cTipoCont());
        bhsl110a().commarea().dadosEntrada().cUserid().set(bhow0004().areaComum().dadosInput().cUserid());
        bhsl110a().commarea().dadosEntrada().cPerfUtlBbn().set(bhow0004().areaComum().dadosInput().cPerfUtlBbn());
        bhsl110a().commarea().dadosEntrada().ctNvelAtrzBbn().set(bhow0004().areaComum().dadosInput().ctNvelAtrzBbn());
        bhsp0110ValRestAcesCt() ;
        bhow0004().areaComum().dadosInput().iRstzAcesCont().set(bhsl110a().commarea().dadosSaida().iRstzAcesCont());
        if (bhsl110a().commarea().dadosSaida().semErros().isTrue()) {
            if (bhow0004().areaComum().dadosInput().iraConValSim().isTrue()) {
                bhow0004().areaComum().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().utilSemAcesso());
                bhow0004().areaComum().dadosOutput().modOrigemErro().set(bhow0004().areaComum().dadosInput().bhop0004());
                bhow0004().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                bhow0004().areaComum().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                bhow0004().areaComum().dadosOutput().msgErrob().set("UTILIZADOR SEM ACESSO");
            }
        } else {
            bhow0004().areaComum().dadosOutput().cSqlcode().set(bhsl110a().commarea().dadosSaida().cSqlcode());
            bhow0004().areaComum().dadosOutput().nmTabela().set(bhsl110a().commarea().dadosSaida().nmTabela());
            bhow0004().areaComum().dadosOutput().chAcesso().set(bhsl110a().commarea().dadosSaida().chvAces());
            bhow0004().areaComum().dadosOutput().msgErrob().set("ERRO NO ACESSO A ROTINA MHSJ110A");
            bhow0004().areaComum().dadosOutput().aAplErr().set(bhsl110a().commarea().dadosSaida().aAplErr());
            bhow0004().areaComum().dadosOutput().modOrigemErro().set("MHSJ110A");
            bhow0004().areaComum().dadosOutput().cRtnoEvenSwal().set(bhsl110a().commarea().dadosSaida().cRtnoEvenSwal());
            bhow0004().areaComum().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
        }
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
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "************** INICIO ************************");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (envOut.errosGraves().semErros().isTrue()) {
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
        wsVariaveis().initialize() ;
        hrMghs003a().bghl003a().initialize() ;
        hrMghs002a().bghl002a().initialize() ;
        hrMghs022a().bghl022a().initialize() ;
        hrMghs804a().bghl804a().initialize() ;
        msgOut().msg().ade().initialize() ;
        swSwitches().swContInvocacaoN().setTrue() ;
        log(TraceLevel.Debug, "ANTES INICIALIZACAO DA TAB INTERNA");
        wsVariaveis().wsTeste().set(0);
        /**
         * INICIALIZACAO DA TABELA INTERNA
         */
        for (wsTabelaMovimento().wsMovimentos().setIndex(1); wsTabelaMovimento().wsMovimentos().index().isLessOrEqual(msgOut().indiceInverso()); wsTabelaMovimento().wsMovimentos().incIndex()) {
            wsVariaveis().wsTeste().add(1);
            log(TraceLevel.Debug, "OCORRENCIA:", wsVariaveis().wsTeste());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(" ");
            wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(" ");
            wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(" ");
            wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(0);
            wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(" ");
            wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(0);
            wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(" ");
            wsTabelaMovimento().wsMovimentos().getCurrent().wsCCarExt().set(" ");
        }
        log(TraceLevel.Debug, "APOS INICIALIZACAO DA TAB INTERNA");
        wsTabelaMovimento().wsMovimentos().resetIndex() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().indice().set(1);
        wsVariaveis().wsRegTabInt().set(0);
        log(TraceLevel.Debug, "ANTES DO VALIDA INPUT");
        if (envOut.errosGraves().semErros().isTrue()) {
            m1100ValidaInput() ;
        }
    }
    
    /**
     * 
     * 1100-VALIDA-INPUT
     * 
     */
    protected void m1100ValidaInput() {
        log(TraceLevel.Debug, "1100-VALIDA-INPUT");
        /**
         * -- SE OS CAMPOS NS-MOVIMENTO-PG E Z-MOVIMENTO-PG ESTAO AMBOS
         * -- PREENCHIDOS, SIGNIFICA QUE NAO E PRIMEIRA INVOCACAO
         */
        if (msgIn().msg().ade().nsMovimentoPg().isGreater(0) && 
            !msgIn().msg().ade().zMovimentoPg().isEqual(CON_DATA_MINIMA)) {
            swSwitches().swContInvocacaoS().setTrue() ;
            log(TraceLevel.Debug, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            log(TraceLevel.Debug, "~~~ NAO E A PRIMEIRA INVOCACAO     ~~~~");
            log(TraceLevel.Debug, "~~~                                ~~~~");
            log(TraceLevel.Debug, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        /**
         * -- SE O CAMPO NS-MOVIMENTO-PG ESTA PREENCHIDO E A
         * -- Z-MOVIMENTO-PG NAO, SIGNIFICA QUE SE TRATA DO
         * -- ENCADEAMENTO DA MVPHI0
         */
        if (msgIn().msg().ade().nsMovimentoPg().isGreater(0) && 
            msgIn().msg().ade().zMovimentoPg().isEqual(CON_DATA_MINIMA)) {
            swSwitches().swEncadeamentoMvphi0().setTrue() ;
            log(TraceLevel.Debug, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            log(TraceLevel.Debug, "~~~     ENCADEAMENTO DA MVPHI0     ~~~~");
            log(TraceLevel.Debug, "~~~                                ~~~~");
            log(TraceLevel.Debug, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            wsVariaveis().wsDtDiaMenos1Ano().set( getDBDate() ) ;
            log(TraceLevel.Debug, "  - WS-DT-DIA-MENOS-1-ANO         :", wsVariaveis().wsDtDiaMenos1Ano());
            if (msgIn().msg().ade().zIniCons().isLess(wsVariaveis().wsDtDiaMenos1Ano())) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bhok0001().erros().dataInvalida());
                envOut.errosGraves().aAplErr().set(CON_A_APL_HO);
                log(TraceLevel.Error, " ERRO-DT");
            }
        }
        log(TraceLevel.Debug, "**********************************");
        log(TraceLevel.Debug, "***      DADOS DE ENTRADA      ***");
        log(TraceLevel.Debug, "**********************************");
        log(TraceLevel.Debug, "   BGHM1180-C-PAIS-ISOA-CONT  : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1180-C-BANC-CONT       : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1180-C-OE-EGC-CONT     : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1180-NS-RDCL-CONT      : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1180-V-CHKD-CONT       : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "   BGHM1180-C-TIPO-CONT       : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "   BGHM1180-C-MOED-ISO-SCTA   : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "   BGHM1180-Z-INI-CONS        : ", msgIn().msg().ade().zIniCons());
        log(TraceLevel.Debug, "   BGHM1180-Z-FIM-CONS        : ", msgIn().msg().ade().zFimCons());
        log(TraceLevel.Debug, " ------------- PAGINACAO ------------- ");
        log(TraceLevel.Debug, "   BGHM1180-NS-MOVIMENTO-PG   : ", msgIn().msg().ade().nsMovimentoPg());
        log(TraceLevel.Debug, "   BGHM1180-Z-MOVIMENTO-PG    : ", msgIn().msg().ade().zMovimentoPg());
        log(TraceLevel.Debug, "**********************************");
        log(TraceLevel.Debug, "**********************************");
        log(TraceLevel.Debug, "**********************************");
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            !msgIn().msg().ade().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().cTipoCont().isNumeric() || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().zIniCons().isEqual(CON_DATA_MINIMA) || 
            msgIn().msg().ade().zFimCons().isEqual(CON_DATA_MINIMA) || 
            msgIn().msg().ade().zFimCons().isEqual(CON_DATA_MAXIMA))) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().inputInvalido());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, " ERRO-01");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1120ValidaConta() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1130ValidaSubconta() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1200ConsultaGatcnsmov() ;
        }
    }
    
    /**
     * 
     * 1120-VALIDA-CONTA
     * 
     */
    protected void m1120ValidaConta() {
        log(TraceLevel.Debug, "1120-VALIDA-CONTA");
        bhow0002().areaComum().dadosInput().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhow0002().areaComum().dadosInput().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhow0002().areaComum().dadosInput().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhow0002().areaComum().dadosInput().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhow0002().areaComum().dadosInput().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhow0002().areaComum().dadosInput().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhow0002().areaComum().dadosInput().cTransaccao().set(message.mensagem().headerR().cTransaccao());
        bhow0002().areaComum().dadosInput().cUserid().set(message.mensagem().headerR().nrElectronico().cUserid());
        bhow0002().areaComum().dadosInput().ctNvelAtrzBbn().set(envIn.indicaCutiliza().ctNvelAtrzBbn());
        bhow0002().areaComum().dadosInput().cPerfUtlBbn().set(message.mensagem().headerR().seguranca().cPerfUtlBbn());
        bhow0002().areaComum().dadosInput().iRstzAcesCont().set(envIn.cct().iRstzAcesCont());
        bhop0002ValConta() ;
        if (!bhow0002().areaComum().dadosOutput().semErros().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhow0002().areaComum().dadosOutput().cTipoErroBbn());
            envOut.errosGraves().aAplErr().set(bhow0002().areaComum().dadosOutput().aAplErr());
            if (envOut.errosGraves().abendDb2().isTrue()) {
                envOut.db2Log().sqlca().cSqlcode().set(bhow0002().areaComum().dadosOutput().cSqlcode());
                envOut.db2Log().nmTabela().set(bhow0002().areaComum().dadosOutput().nmTabela());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            } else {
                msgOut().msg().ase().cBancContSt().cBancContS().set(CON_1N);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhow0002().areaComum().dadosOutput().cRtnoEvenSwal());
            }
            log(TraceLevel.Error, "ERRO-00");
        }
    }
    
    /**
     * 
     * 1130-VALIDA-SUBCONTA
     * 
     */
    protected void m1130ValidaSubconta() {
        log(TraceLevel.Debug, "1130-VALIDA-SUBCONTA");
        bhow0004().areaComum().dadosInput().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhow0004().areaComum().dadosInput().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhow0004().areaComum().dadosInput().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhow0004().areaComum().dadosInput().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhow0004().areaComum().dadosInput().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhow0004().areaComum().dadosInput().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhow0004().areaComum().dadosInput().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        bhow0004().areaComum().dadosInput().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        bhow0004().areaComum().dadosInput().cTransaccao().set(message.mensagem().headerR().cTransaccao());
        bhow0004().areaComum().dadosInput().cUserid().set(message.mensagem().headerR().nrElectronico().cUserid());
        bhow0004().areaComum().dadosInput().ctNvelAtrzBbn().set(envIn.indicaCutiliza().ctNvelAtrzBbn());
        bhow0004().areaComum().dadosInput().cPerfUtlBbn().set(message.mensagem().headerR().seguranca().cPerfUtlBbn());
        bhow0004().areaComum().dadosInput().iRstzAcesCont().set(envIn.cct().iRstzAcesCont());
        bhop0004ValSubcta() ;
        if (!bhow0004().areaComum().dadosOutput().semErros().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhow0004().areaComum().dadosOutput().cTipoErroBbn());
            envOut.errosGraves().aAplErr().set(bhow0004().areaComum().dadosOutput().aAplErr());
            if (envOut.errosGraves().abendDb2().isTrue()) {
                envOut.db2Log().sqlca().cSqlcode().set(bhow0004().areaComum().dadosOutput().cSqlcode());
                envOut.db2Log().nmTabela().set(bhow0004().areaComum().dadosOutput().nmTabela());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            } else {
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContS().set(CON_1N);
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bhow0004().areaComum().dadosOutput().cRtnoEvenSwal());
            }
            log(TraceLevel.Error, "ERRO-11");
        }
    }
    
    /**
     * 
     * 1200-CONSULTA-GATCNSMOV
     * 
     */
    protected void m1200ConsultaGatcnsmov() {
        log(TraceLevel.Debug, "1200-CONSULTA-GATCNSMOV");
        /**
         * -- ACEDE AO MODULO MGHS003A, CUJO OBJETIVO E PERCEBER ONDE
         * -- ESTAO OS MOVIMENTOS
         * -- O RETORNO PODE ASSUMIR OS SEGUINTES ESTADOS
         * -- 1) ESTADO H:
         * --     SIGNIFICA QUE OS MOVIMENTOS DO DIA D-1
         * --     ESTAO NOS HO'S
         * -- 2) ESTADO A:
         * --     ESTAO NA TABELA TGH00022
         * -- 3) ESTADO I:
         * --     ESTAO JA EM HISTORICO TGH000102
         */
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs003a().bghl003a().cRetorno());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, " ERRO-02");
        }
        log(TraceLevel.Debug, " --------------> MGH003A-I-EST-RCRS:", hrMghs003a().bghl003a().detalhe().iEstRcrs());
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "------> MGH003A-Z-HOJE:", hrMghs003a().bghl003a().zHoje());
        /**
         * -- SE ESTAMOS A TRATAR O ENCADEAMENTO, SO VAI SER DEVOLVIDO
         * -- UM REGISTO
         */
        if (swSwitches().swEncadeamentoMvphi0().isTrue()) {
            /**
             * »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
             * »» ENCADEAMENTO                                           ««
             * ««««««««««««««««««««««««««««««««««««««««««««««««««««««««««««
             */
            if (msgIn().msg().ade().zIniCons().isEqual(hrMghs003a().bghl003a().zHoje())) {
                /**
                 * -- OBTEM DADOS DO MOVIMENTO QUE ESTA EM CONTAS - HO
                 */
                m2001ObtemMovDia() ;
            } else {
                /**
                 * -- OBTEM DADOS DO MOVIMENTO QUE PODE ESTAR EM NA APL
                 * -- GH OU CONTAS
                 */
                m2002ObtemMovDiasAnt() ;
                if (swSwitches().swObtemDadosMov().isTrue()) {
                    /**
                     * -- SE NAO FORAM ENCONTRADOS OS MOVIMENTOS, E PQ SAO
                     * -- MAIS ANTIGOS E SE ENCONTRAM NA TGH00002
                     */
                    m2003ObtemMovHist() ;
                }
            }
        } else {
            /**
             * »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»
             * »» ACESSO DIRETO                                          ««
             * ««««««««««««««««««««««««««««««««««««««««««««««««««««««««««««
             * -- SE A DATA FIM DA AREA DE PESQUISA FOR IGUAL A DATA DO
             * -- DIA, OBTEM PRIMEIRO OS MOVIMENTOS DO DIA, QUE AINDA TAO
             * -- NA APLICACAO DE CONTAS - HO.
             */
            if (msgIn().msg().ade().zFimCons().isEqual(hrMghs003a().bghl003a().zHoje())) {
                m2100ObtemMovDiaHo() ;
            }
            /**
             * -- SE AS OCORRENCIAS DA LISTA DE OUTPUT AINDA NAO ESTAO
             * -- TODAS PREENCHIDAS E A DATA DE INICIO DE PESQUISA
             * -- E DIFERENTE DO DIA DE PROCESSAMENTO (MENOR),
             * -- OBTEM RESTANTES MOVIMENTOS A APRESENTAR NA LISTA (CASO
             * -- EXISTAM), MOVIMENTOS DO DIA ANTERIOR, Q JA PODEM ESTAR
             * -- NA APLICACAO DE GESTAO DE HISTORICO DE PASSIVAS - GH
             * -- (TGH00022) OU AINDA EM CONTAS - HO (THO00020/21).
             */
            if (envOut.errosGraves().semErros().isTrue()) {
                if (!msgOut().paginaCheia().isTrue()) {
                    if (msgIn().msg().ade().zIniCons().isLess(hrMghs003a().bghl003a().zHoje())) {
                        m2200ObtemMovOntem() ;
                    }
                }
            }
            /**
             * -- SE AS OCORRENCIAS DA LISTA DE OUTPUT AINDA NAO ESTAO
             * -- TODAS PREENCHIDAS E A DATA DE INICIO DE PESQUISA
             * -- E DIFERENTE DO DIA DE PROCESSAMENTO (MENOR),
             * -- OBTEM RESTANTES MOVIMENTOS A APRESENTAR NA LISTA
             * -- CASO EXISTAM), MOVIMENTOS ESTES QUE SE ENCONTRAM NA
             * -- APLICACAO DE GESTAO DE HISTORICO DE PASSIVAS - GH.
             */
            if (envOut.errosGraves().semErros().isTrue()) {
                if (!msgOut().paginaCheia().isTrue()) {
                    if (msgIn().msg().ade().zIniCons().isLess(hrMghs003a().bghl003a().zHoje())) {
                        m2300ObtemMovHst() ;
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 2001-OBTEM-MOV-DIA
     * 
     */
    protected void m2001ObtemMovDia() {
        log(TraceLevel.Debug, "2001-OBTEM-MOV-DIA");
        hrMghj206a().bghl206a().commarea().initialize() ;
        hrMghj206a().bghl206a().commarea().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghj206a().bghl206a().commarea().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghj206a().bghl206a().commarea().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghj206a().bghl206a().commarea().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghj206a().bghl206a().commarea().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghj206a().bghl206a().commarea().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghj206a().bghl206a().commarea().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghj206a().bghl206a().commarea().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghj206a().bghl206a().commarea().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        log(TraceLevel.Debug, " » MGH206A-C-PAIS-ISOA-CONT:", hrMghj206a().bghl206a().commarea().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, " » MGH206A-C-BANC-CONT     :", hrMghj206a().bghl206a().commarea().argumento().cBancCont());
        log(TraceLevel.Debug, " » MGH206A-C-OE-EGC-CONT   :", hrMghj206a().bghl206a().commarea().argumento().cOeEgcCont());
        log(TraceLevel.Debug, " » MGH206A-NS-RDCL-CONT    :", hrMghj206a().bghl206a().commarea().argumento().nsRdclCont());
        log(TraceLevel.Debug, " » MGH206A-V-CHKD-CONT     :", hrMghj206a().bghl206a().commarea().argumento().vChkdCont());
        log(TraceLevel.Debug, " » MGH206A-C-TIPO-CONT     :", hrMghj206a().bghl206a().commarea().argumento().cTipoCont());
        log(TraceLevel.Debug, " » MGH206A-C-MOED-ISO-SCTA :", hrMghj206a().bghl206a().commarea().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, " » MGH206A-NS-DEPOSITO     :", hrMghj206a().bghl206a().commarea().argumento().nsDeposito());
        log(TraceLevel.Debug, " » MGH206A-NS-MOVIMENTO    :", hrMghj206a().bghl206a().commarea().argumento().nsMovimento());
        hrMghj206a().run() ;
        if (!hrMghs002a().bghl002a().ok().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs002a().bghl002a().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00020");
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs002a().bghl002a().cRetorno());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, "ERRO-1E");
        } else if (hrMghj206a().bghl206a().commarea().detalhe().iEstorno().isEmpty() && 
            hrMghj206a().bghl206a().commarea().detalhe().iDbcr().isEqual(CON_CREDITO)) {
            wsTabelaMovimento().wsMovimentos().resetIndex() ;
            swSwitches().swMovHstS().setTrue() ;
            wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghj206a().bghl206a().commarea().detalhe().zMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghj206a().bghl206a().commarea().detalhe().zValor());
            wsTs().wDataTs().set(hrMghj206a().bghl206a().commarea().detalhe().zMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(wsTs());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghj206a().bghl206a().commarea().argumento().nsMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghj206a().bghl206a().commarea().detalhe().xRefMov());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghj206a().bghl206a().commarea().detalhe().mMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghj206a().bghl206a().commarea().detalhe().cMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2002-OBTEM-MOV-DIAS-ANT
     * 
     */
    protected void m2002ObtemMovDiasAnt() {
        log(TraceLevel.Debug, "2002-OBTEM-MOV-DIAS-ANT");
        switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
            case "I":
                swSwitches().swObtemDadosMov().setTrue() ;
                break;
            case "A":
                /**
                 * -- OS MOVIMENTOS DO DIA D-1 ESTAO NA TGH00022
                 */
                m2012ObtemMovDiaAntGh() ;
                break;
            case "H":
                /**
                 * -- OS MOVIMENTOS DO DIA D-1 ESTAO NA NA APLICACAO HO
                 */
                m2022ObtemMovDiaAntHo() ;
                break;
            default :
                break ;
        }
    }
    
    /**
     * 
     * 2003-OBTEM-MOV-HIST
     * 
     */
    protected void m2003ObtemMovHist() {
        log(TraceLevel.Debug, "2003-OBTEM-MOV-HIST");
        hrMghj207a().bghl207a().commarea().initialize() ;
        hrMghj207a().bghl207a().commarea().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghj207a().bghl207a().commarea().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghj207a().bghl207a().commarea().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghj207a().bghl207a().commarea().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghj207a().bghl207a().commarea().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghj207a().bghl207a().commarea().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghj207a().bghl207a().commarea().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghj207a().bghl207a().commarea().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghj207a().bghl207a().commarea().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        wsTs().wDataTs().set(msgIn().msg().ade().zIniCons());
        hrMghj207a().bghl207a().commarea().argumento().tsMovimento().set(wsTs());
        log(TraceLevel.Debug, " »»»»»»»»»»»»» ACESSO MGHJ207A ««««««««««««« ");
        log(TraceLevel.Debug, " »»» MGH207A-C-PAIS-ISOA-CONT      :", hrMghj207a().bghl207a().commarea().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, " »»» MGH207A-C-BANC-CONT           :", hrMghj207a().bghl207a().commarea().argumento().cBancCont());
        log(TraceLevel.Debug, " »»» MGH207A-C-OE-EGC-CONT         :", hrMghj207a().bghl207a().commarea().argumento().cOeEgcCont());
        log(TraceLevel.Debug, " »»» MGH207A-NS-RDCL-CONT          :", hrMghj207a().bghl207a().commarea().argumento().nsRdclCont());
        log(TraceLevel.Debug, " »»» MGH207A-V-CHKD-CONT           :", hrMghj207a().bghl207a().commarea().argumento().vChkdCont());
        log(TraceLevel.Debug, " »»» MGH207A-C-TIPO-CONT           :", hrMghj207a().bghl207a().commarea().argumento().cTipoCont());
        log(TraceLevel.Debug, " »»» MGH207A-C-MOED-ISO-SCTA       :", hrMghj207a().bghl207a().commarea().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, " »»» MGH207A-NS-DEPOSITO           :", hrMghj207a().bghl207a().commarea().argumento().nsDeposito());
        log(TraceLevel.Debug, " »»» MGH207A-NS-MOVIMENTO          :", hrMghj207a().bghl207a().commarea().argumento().nsMovimento());
        log(TraceLevel.Debug, " »»» MGH207A-TS-MOVIMENTO          :", hrMghj207a().bghl207a().commarea().argumento().tsMovimento());
        log(TraceLevel.Debug, " »»»»»»»»»»»»»»»»»»»»».««««««««««««««««««««« ");
        hrMghj207a().run() ;
        if (!hrMghj207a().bghl207a().commarea().ok().isTrue()) {
            if (!hrMghj207a().bghl207a().commarea().naoExiste().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.db2Log().sqlca().cSqlcode().set(hrMghj207a().bghl207a().commarea().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00002");
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghj207a().bghl207a().commarea().cRetorno());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, "ERRO-4E");
            }
        } else if (hrMghj207a().bghl207a().commarea().detalhe().iEstorno().isEmpty() && 
            hrMghj207a().bghl207a().commarea().detalhe().iDbcr().isEqual(CON_CREDITO)) {
            /**
             * -- VALIDA SE O MOVIMENTO FOI ESTORNADO
             * -- ATRAVES DA TGH00009
             */
            wsVariaveis().wsNsMovimentoTgh9().set(hrMghj207a().bghl207a().commarea().argumento().nsMovimento());
            /**
             * MOVE MGH207A-Z-MOV-LOCL TO WS-DT-MOVIMENTO-TGH9
             */
            wsVariaveis().wsDtMovimentoTgh9().set(hrMghj207a().bghl207a().commarea().argumento().tsMovimento().get(1, 10));
            m2311ValMovEstn() ;
            if ((swSwitches().swVgh00901Ok().isTrue() && 
                hv00901Infauxmov().infauxmov().iEstorno().isEmpty()) || 
                swSwitches().swVgh00901Notfnd().isTrue()) {
                /**
                 * -- SE MOVIMENTO NAO EXISTE NA TGH00009, SIGNIFICA
                 * -- QUE O MOVIMENTO NAO FOI ESTORNADO
                 */
                wsTabelaMovimento().wsMovimentos().resetIndex() ;
                swSwitches().swMovHstS().setTrue() ;
                wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghj207a().bghl207a().commarea().argumento().tsMovimento().get(1, 10));
                wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghj207a().bghl207a().commarea().detalhe().zValMov());
                wsTs().wDataTs().set(hrMghj207a().bghl207a().commarea().argumento().tsMovimento().get(1, 10));
                wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(wsTs());
                wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghj207a().bghl207a().commarea().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghj207a().bghl207a().commarea().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghj207a().bghl207a().commarea().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghj207a().bghl207a().commarea().detalhe().cMoedIsoOriMov());
            }
        }
    }
    
    /**
     * 
     * 2012-OBTEM-MOV-DIA-ANT-GH
     * 
     */
    protected void m2012ObtemMovDiaAntGh() {
        log(TraceLevel.Debug, "2012-OBTEM-MOV-DIA-ANT-GH");
        hrMghs022a().bghl022a().initialize() ;
        /**
         * -- MGH022A-TS-MOV-MAX NAO E UTILIZADO NA ROTINA....]]]]
         * MOVE BGHM1180-Z-FIM-CONS (1:4)
         * TO WS-ANO-AA.
         * MOVE BGHM1180-Z-FIM-CONS (6:2)
         * TO WS-MES-MM.
         * MOVE BGHM1180-Z-FIM-CONS (9:2)
         * TO WS-DIA-DD.
         * MOVE WS-TIMESTAMP             TO MGH022A-TS-MOV-MAX.
         */
        hrMghs022a().bghl022a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs022a().bghl022a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs022a().bghl022a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs022a().bghl022a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs022a().bghl022a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs022a().bghl022a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs022a().bghl022a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs022a().bghl022a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs022a().bghl022a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        hrMghs022a().bghl022a().criterioConsulta().descendente().setTrue() ;
        hrMghs022a().bghl022a().criterioDbcr().credito().setTrue() ;
        hrMghs022a().bghl022a().criterioMontante().mMovMin().set(0);
        hrMghs022a().bghl022a().criterioMontante().mMovMax().set(0);
        log(TraceLevel.Debug, " -------- ACESSO MGH022A -------- ");
        log(TraceLevel.Debug, " - MGH022A-I-CRITERIO-CNS      :", hrMghs022a().bghl022a().criterioConsulta().iCriterioCns());
        log(TraceLevel.Debug, " - MGH022A-I-CRITERIO-DBCR     :", hrMghs022a().bghl022a().criterioDbcr().iCriterioDbcr());
        log(TraceLevel.Debug, " - MGH022A-C-PAIS-ISOA-CONT    :", hrMghs022a().bghl022a().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, " - MGH022A-C-BANC-CONT         :", hrMghs022a().bghl022a().argumento().cBancCont());
        log(TraceLevel.Debug, " - MGH022A-C-OE-EGC-CONT       :", hrMghs022a().bghl022a().argumento().cOeEgcCont());
        log(TraceLevel.Debug, " - MGH022A-NS-RDCL-CONT        :", hrMghs022a().bghl022a().argumento().nsRdclCont());
        log(TraceLevel.Debug, " - MGH022A-V-CHKD-CONT         :", hrMghs022a().bghl022a().argumento().vChkdCont());
        log(TraceLevel.Debug, " - MGH022A-C-TIPO-CONT         :", hrMghs022a().bghl022a().argumento().cTipoCont());
        log(TraceLevel.Debug, " - MGH022A-C-MOED-ISO-SCTA     :", hrMghs022a().bghl022a().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, " - MGH022A-NS-DEPOSITO         :", hrMghs022a().bghl022a().argumento().nsDeposito());
        log(TraceLevel.Debug, " - MGH022A-Z-MOVIMENTO         :", hrMghs022a().bghl022a().argumento().zMovimento());
        log(TraceLevel.Debug, " - MGH022A-NS-MOVIMENTO        :", hrMghs022a().bghl022a().argumento().nsMovimento());
        log(TraceLevel.Debug, " -------------------------------- ");
        hrMghs022a().run() ;
        if (!hrMghs022a().bghl022a().ok().isTrue()) {
            if (hrMghs022a().bghl022a().naoExiste().isTrue()) {
                swSwitches().swObtemDadosMov().setTrue() ;
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs022a().bghl022a().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00022");
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs022a().bghl022a().cRetorno());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, " ERRO-2E");
            }
        } else {
            hrMghs022a().bghl022a().tabela().lista().setIndex(CON_1N);
            log(TraceLevel.Debug, "-------------MGH022A-Q-ITENS:", hrMghs022a().bghl022a().qItens());
            for (hrMghs022a().bghl022a().tabela().lista().setIndex(1); wsTabelaMovimento().wsMovimentos().index().isLessOrEqual(1) && envOut.errosGraves().semErros().isTrue(); hrMghs022a().bghl022a().tabela().lista().incIndex()) {
                hrMghs022a().bghl022a().argumento().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs022a().bghl022a().detalhe().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe());
                if (hrMghs022a().bghl022a().detalhe().iEstorno().isEmpty() && 
                    hrMghs022a().bghl022a().argumento().zMovimento().isEqual(msgIn().msg().ade().zIniCons()) && 
                    hrMghs022a().bghl022a().argumento().nsMovimento().isEqual(msgIn().msg().ade().nsMovimentoPg())) {
                    wsVariaveis().wsRegTabInt().add(1);
                    log(TraceLevel.Debug, " **** MOVIMENTO TRATADO ****");
                    log(TraceLevel.Debug, " - MGH022A-Z-MOVIMENTO   :");
                    log(TraceLevel.Debug, "          ", wsVariaveis().wsRegTabInt(), "      ", hrMghs022a().bghl022a().argumento().zMovimento());
                    log(TraceLevel.Debug, " - MGH022A-NS-MOVIMENTO  :", hrMghs022a().bghl022a().argumento().nsMovimento());
                    log(TraceLevel.Debug, " - MGH022A-X-REF-MOV     :", hrMghs022a().bghl022a().detalhe().xRefMov());
                    log(TraceLevel.Debug, " - MGH022A-M-MOVIMENTO   :", hrMghs022a().bghl022a().detalhe().mMovimento());
                    log(TraceLevel.Debug, " - MGH022A-C-MOED-ISO-ORI-MOV:", hrMghs022a().bghl022a().detalhe().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghs022a().bghl022a().detalhe().zValMov());
                    wsTs().wDataTs().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(wsTs());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghs022a().bghl022a().argumento().nsMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghs022a().bghl022a().detalhe().xRefMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghs022a().bghl022a().detalhe().mMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghs022a().bghl022a().detalhe().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().incIndex() ;
                }
            }
        }
    }
    
    /**
     * 
     * 2022-OBTEM-MOV-DIA-ANT-HO
     * 
     */
    protected void m2022ObtemMovDiaAntHo() {
        log(TraceLevel.Debug, "2022-OBTEM-MOV-DIA-ANT-HO");
        hrMghs805a().bghl805a().initialize() ;
        hrMghs805a().bghl805a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs805a().bghl805a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs805a().bghl805a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs805a().bghl805a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs805a().bghl805a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs805a().bghl805a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs805a().bghl805a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs805a().bghl805a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs805a().bghl805a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        hrMghs805a().run() ;
        if (!hrMghs805a().bghl805a().ok().isTrue()) {
            if (hrMghs805a().bghl805a().naoExiste().isTrue()) {
                swSwitches().swObtemDadosMov().setTrue() ;
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs805a().bghl805a().cSqlcode());
                envOut.db2Log().nmTabela().set("THO00020");
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs805a().bghl805a().cRetorno());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, "ERRO-3E");
            }
        } else if (hrMghs805a().bghl805a().detalhe().iEstorno().isEmpty() && 
            hrMghs805a().bghl805a().detalhe().iDbcr().isEqual(CON_CREDITO)) {
            wsTabelaMovimento().wsMovimentos().resetIndex() ;
            wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghs805a().bghl805a().detalhe().zMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghs805a().bghl805a().detalhe().zValor());
            wsTs().wDataTs().set(hrMghs805a().bghl805a().detalhe().zMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(wsTs());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghs805a().bghl805a().argumento().nsMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghs805a().bghl805a().detalhe().xRefMov());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghs805a().bghl805a().detalhe().mMovimento());
            wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghs805a().bghl805a().detalhe().cMoedIsoOriMov());
        }
    }
    
    /**
     * 
     * 2100-OBTEM-MOV-DIA-HO
     * 
     */
    protected void m2100ObtemMovDiaHo() {
        log(TraceLevel.Debug, "2100-OBTEM-MOV-DIA-HO");
        hrMghs804a().bghl804a().initialize() ;
        hrMghs804a().bghl804a().criterioDia().iMovDia().set(CON_S);
        log(TraceLevel.Debug, "--------------------- WS-Q-MOVS-DEVOLVIDOS:", wsVariaveis().wsQMovsDevolvidos());
        log(TraceLevel.Debug, "--------------------- MGH804A-C-RETORNO:", hrMghs804a().bghl804a().cRetorno());
        log(TraceLevel.Debug, "--------------------- MGH804A-Q-ITENS:", hrMghs804a().bghl804a().qItens());
        log(TraceLevel.Debug, "--------------------- BGHM1181-INDICE:", msgOut().indice());
        log(TraceLevel.Debug, "--------------------- BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        while ((wsVariaveis().wsQMovsDevolvidos().isGreaterOrEqual(CON_MAX_OCC_DLVDAS) || !hrMghs804a().bghl804a().ok().isTrue() || hrMghs804a().bghl804a().qItens().isLessOrEqual(0)) && !hrMghs804a().bghl804a().naoExiste().isTrue() && wsVariaveis().wsRegTabInt().isLess(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue()) {
            m2500AcedeHo() ;
        }
    }
    
    /**
     * 
     * 2200-OBTEM-MOV-ONTEM
     * 
     */
    protected void m2200ObtemMovOntem() {
        log(TraceLevel.Debug, "2200-OBTEM-MOV-ONTEM");
        /**
         * -- O MAX DE OCORRENCIAS DEVOLVIDAS PELAS ROTINAS
         * -- MGHS022A E MGH804A E 13
         * -- SO PARA DE ACEDER A ESTES MODULOS QUANDO JA TIVEREM SIDO
         * -- DEVOLVIDOS TODOS OS MOVIMENTOS
         */
        switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
            case "A":
                /**
                 * MOVIMENTOS DO DIA D-1 ESTAO NA TGH00022             -*
                 */
                while ((wsVariaveis().wsQMovsDevolvidos().isGreaterOrEqual(CON_MAX_OCC_DLVDAS) || !hrMghs022a().bghl022a().ok().isTrue() || hrMghs022a().bghl022a().qItens().isLessOrEqual(0)) && !hrMghs022a().bghl022a().naoExiste().isTrue() && wsVariaveis().wsRegTabInt().isLess(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue()) {
                    m2210ObtemMovDiaAntGh() ;
                }
                break;
            case "H":
                /**
                 * MOVIMENTOS DO DIA D-1 ESTAO NA NA APLICACAO HO      -*
                 */
                m2220ObtemMovDiaAntHo() ;
                break;
            default :
                break ;
        }
    }
    
    /**
     * 
     * 2210-OBTEM-MOV-DIA-ANT-GH
     * 
     */
    protected void m2210ObtemMovDiaAntGh() {
        log(TraceLevel.Debug, "2210-OBTEM-MOV-DIA-ANT-GH");
        hrMghs022a().bghl022a().initialize() ;
        wsTimestamp().wsDataTimestamp().wsAnoAa().set(msgIn().msg().ade().zFimCons().get(1, 4));
        wsTimestamp().wsDataTimestamp().wsMesMm().set(msgIn().msg().ade().zFimCons().get(6, 2));
        wsTimestamp().wsDataTimestamp().wsDiaDd().set(msgIn().msg().ade().zFimCons().get(9, 2));
        hrMghs022a().bghl022a().criterioSeleccao().tsMovMax().set(wsTimestamp());
        hrMghs022a().bghl022a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs022a().bghl022a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs022a().bghl022a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs022a().bghl022a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs022a().bghl022a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs022a().bghl022a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs022a().bghl022a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs022a().bghl022a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs022a().bghl022a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        hrMghs022a().bghl022a().criterioConsulta().descendente().setTrue() ;
        hrMghs022a().bghl022a().criterioDbcr().credito().setTrue() ;
        hrMghs022a().bghl022a().criterioMontante().mMovMin().set(0);
        hrMghs022a().bghl022a().criterioMontante().mMovMax().set(0);
        log(TraceLevel.Debug, " -------- ACESSO MGH022A -------- ");
        log(TraceLevel.Debug, " - MGH022A-I-CRITERIO-CNS      :", hrMghs022a().bghl022a().criterioConsulta().iCriterioCns());
        log(TraceLevel.Debug, " - MGH022A-I-CRITERIO-DBCR     :", hrMghs022a().bghl022a().criterioDbcr().iCriterioDbcr());
        log(TraceLevel.Debug, " - MGH022A-M-MOV-MIN           :", hrMghs022a().bghl022a().criterioMontante().mMovMin());
        log(TraceLevel.Debug, " - MGH022A-M-MOV-MAX           :", hrMghs022a().bghl022a().criterioMontante().mMovMax());
        log(TraceLevel.Debug, " - MGH022A-TS-MOV-MAX          :", hrMghs022a().bghl022a().criterioSeleccao().tsMovMax());
        log(TraceLevel.Debug, " - MGH022A-NS-MOV-MAX          :", hrMghs022a().bghl022a().criterioSeleccao().nsMovMax());
        log(TraceLevel.Debug, " - MGH022A-C-PAIS-ISOA-CONT    :", hrMghs022a().bghl022a().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, " - MGH022A-C-BANC-CONT         :", hrMghs022a().bghl022a().argumento().cBancCont());
        log(TraceLevel.Debug, " - MGH022A-C-OE-EGC-CONT       :", hrMghs022a().bghl022a().argumento().cOeEgcCont());
        log(TraceLevel.Debug, " - MGH022A-NS-RDCL-CONT        :", hrMghs022a().bghl022a().argumento().nsRdclCont());
        log(TraceLevel.Debug, " - MGH022A-V-CHKD-CONT         :", hrMghs022a().bghl022a().argumento().vChkdCont());
        log(TraceLevel.Debug, " - MGH022A-C-TIPO-CONT         :", hrMghs022a().bghl022a().argumento().cTipoCont());
        log(TraceLevel.Debug, " - MGH022A-C-MOED-ISO-SCTA     :", hrMghs022a().bghl022a().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, " - MGH022A-NS-DEPOSITO         :", hrMghs022a().bghl022a().argumento().nsDeposito());
        log(TraceLevel.Debug, " - MGH022A-Z-MOVIMENTO         :", hrMghs022a().bghl022a().argumento().zMovimento());
        log(TraceLevel.Debug, " - MGH022A-NS-MOVIMENTO        :", hrMghs022a().bghl022a().argumento().nsMovimento());
        log(TraceLevel.Debug, " -------------------------------- ");
        hrMghs022a().run() ;
        if (!hrMghs022a().bghl022a().ok().isTrue()) {
            if (!hrMghs022a().bghl022a().naoExiste().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs022a().bghl022a().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00022");
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs022a().bghl022a().cRetorno());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, " ERRO-03");
            }
        } else {
            hrMghs022a().bghl022a().tabela().lista().setIndex(CON_1N);
            log(TraceLevel.Debug, "-------------MGH022A-Q-ITENS:", hrMghs022a().bghl022a().qItens());
            wsVariaveis().wsQMovsDevolvidos().set(hrMghs022a().bghl022a().qItens());
            for (hrMghs022a().bghl022a().tabela().lista().setIndex(1); hrMghs022a().bghl022a().tabela().lista().index().isLessOrEqual(hrMghs022a().bghl022a().qItens()) && wsTabelaMovimento().wsMovimentos().index().isLessOrEqual(msgOut().indiceInverso()) && wsVariaveis().wsRegTabInt().isLessOrEqual(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue(); hrMghs022a().bghl022a().tabela().lista().incIndex()) {
                hrMghs022a().bghl022a().argumento().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs022a().bghl022a().detalhe().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe());
                msgIn().msg().ade().nsMovimentoPg().set(hrMghs022a().bghl022a().argumento().nsMovimento());
                if (msgIn().msg().ade().nsMovimentoPg().isGreater(1)) {
                    msgIn().msg().ade().nsMovimentoPg().subtract(1);
                }
                msgIn().msg().ade().zMovimentoPg().set(hrMghs022a().bghl022a().argumento().zMovimento());
                if (hrMghs022a().bghl022a().detalhe().iEstorno().isEmpty() && 
                    hrMghs022a().bghl022a().detalhe().iDbcr().isEqual(CON_CREDITO) && 
                    hrMghs022a().bghl022a().argumento().zMovimento().isGreaterOrEqual(msgIn().msg().ade().zIniCons()) && 
                    hrMghs022a().bghl022a().argumento().zMovimento().isLessOrEqual(msgIn().msg().ade().zFimCons())) {
                    wsVariaveis().wsRegTabInt().add(1);
                    log(TraceLevel.Debug, " **** MOVIMENTO TRATADO ****");
                    log(TraceLevel.Debug, " - MGH022A-Z-MOVIMENTO   :");
                    log(TraceLevel.Debug, "          ", wsVariaveis().wsRegTabInt(), "      ", hrMghs022a().bghl022a().argumento().zMovimento());
                    log(TraceLevel.Debug, " - MGH022A-NS-MOVIMENTO  :", hrMghs022a().bghl022a().argumento().nsMovimento());
                    log(TraceLevel.Debug, " - MGH022A-X-REF-MOV     :", hrMghs022a().bghl022a().detalhe().xRefMov());
                    log(TraceLevel.Debug, " - MGH022A-M-MOVIMENTO   :", hrMghs022a().bghl022a().detalhe().mMovimento());
                    log(TraceLevel.Debug, " - MGH022A-C-MOED-ISO-ORI-MOV:", hrMghs022a().bghl022a().detalhe().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghs022a().bghl022a().detalhe().zValMov());
                    wsTs().wDataTs().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(wsTs());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghs022a().bghl022a().argumento().nsMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghs022a().bghl022a().detalhe().xRefMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghs022a().bghl022a().detalhe().mMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghs022a().bghl022a().detalhe().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().incIndex() ;
                }
            }
        }
    }
    
    /**
     * 
     * 2220-OBTEM-MOV-DIA-ANT-HO
     * 
     */
    protected void m2220ObtemMovDiaAntHo() {
        log(TraceLevel.Debug, "2220-OBTEM-MOV-DIA-ANT-HO");
        hrMghs804a().bghl804a().initialize() ;
        hrMghs804a().bghl804a().criterioDia().iMovDia().set(CON_N);
        while ((wsVariaveis().wsQMovsDevolvidos().isGreaterOrEqual(CON_MAX_OCC_DLVDAS) || !hrMghs804a().bghl804a().ok().isTrue() || hrMghs804a().bghl804a().qItens().isLessOrEqual(0)) && !hrMghs804a().bghl804a().naoExiste().isTrue() && wsVariaveis().wsRegTabInt().isLess(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue()) {
            m2500AcedeHo() ;
        }
    }
    
    /**
     * 
     * 2300-OBTEM-MOV-HST
     * 
     */
    protected void m2300ObtemMovHst() {
        log(TraceLevel.Debug, "2300-OBTEM-MOV-HST");
        /**
         * -- O MAX DE OCORRENCIAS DEVOLVIDO PELA MGHS002A E 13
         * -- SO PARA DE ACEDER A ESTES MODULOS QUANDO JA TIVEREM SIDO
         * -- DEVOLVIDOS TODOS OS MOVIMENTOS OU NAO EXISTIR MAIS ESPACO
         * -- NA LISTA DE OUTPUT (21 OCORRENCIAS)
         */
        while ((wsVariaveis().wsQMovsDevolvidos().isGreaterOrEqual(CON_MAX_OCC_DLVDAS) || !hrMghs002a().bghl002a().ok().isTrue() || hrMghs002a().bghl002a().qItens().isLessOrEqual(0)) && !hrMghs002a().bghl002a().naoExiste().isTrue() && wsVariaveis().wsRegTabInt().isLess(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue()) {
            m2301ObtemMovHstGh() ;
        }
    }
    
    /**
     * 
     * 2301-OBTEM-MOV-HST-GH
     * 
     */
    protected void m2301ObtemMovHstGh() {
        log(TraceLevel.Debug, "2301-OBTEM-MOV-HST-GH");
        hrMghs002a().bghl002a().initialize() ;
        hrMghs002a().bghl002a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs002a().bghl002a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs002a().bghl002a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs002a().bghl002a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs002a().bghl002a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs002a().bghl002a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs002a().bghl002a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs002a().bghl002a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        if (msgIn().msg().ade().nsMovimentoPg().isEqual(0)) {
            hrMghs002a().bghl002a().argumento().nsMovimento().set(999999999999999L);
        } else {
            hrMghs002a().bghl002a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        }
        /**
         * -- O MODULO MGHS002A ESTA PREPARADO PARA RECEBER AS DATAS
         * -- INVERTIDAS PARA O MODO DESCENTENTE
         */
        if (!msgIn().msg().ade().zMovimentoPg().isEqual(CON_DATA_MINIMA)) {
            /**
             * -- DATA FIM --> MGH002A-TS-MOVIMENTO
             */
            wsTimestamp().wsDataTimestamp().wsAnoAa().set(msgIn().msg().ade().zMovimentoPg().get(1, 4));
            wsTimestamp().wsDataTimestamp().wsMesMm().set(msgIn().msg().ade().zMovimentoPg().get(6, 2));
            wsTimestamp().wsDataTimestamp().wsDiaDd().set(msgIn().msg().ade().zMovimentoPg().get(9, 2));
            wsTimestamp().wsTimerTimestamp().wsHh().set(23);
            wsTimestamp().wsTimerTimestamp().wsMm().set(59);
            wsTimestamp().wsTimerTimestamp().wsSs().set(59);
            wsTimestamp().wsTimerTimestamp().wsRestoTms().set(999999);
            hrMghs002a().bghl002a().argumento().tsMovimento().set(wsTimestamp());
            log(TraceLevel.Debug, "- BGHM1180-Z-MOVIMENTO-PG:", msgIn().msg().ade().zMovimentoPg());
            log(TraceLevel.Debug, "- MGH002A-TS-MOVIMENTO:", hrMghs002a().bghl002a().argumento().tsMovimento());
        } else {
            /**
             * -- DATA FIM --> MGH002A-TS-MOVIMENTO
             */
            wsTimestamp().wsDataTimestamp().wsAnoAa().set(msgIn().msg().ade().zFimCons().get(1, 4));
            wsTimestamp().wsDataTimestamp().wsMesMm().set(msgIn().msg().ade().zFimCons().get(6, 2));
            wsTimestamp().wsDataTimestamp().wsDiaDd().set(msgIn().msg().ade().zFimCons().get(9, 2));
            wsTimestamp().wsTimerTimestamp().wsHh().set(23);
            wsTimestamp().wsTimerTimestamp().wsMm().set(59);
            wsTimestamp().wsTimerTimestamp().wsSs().set(59);
            wsTimestamp().wsTimerTimestamp().wsRestoTms().set(999999);
            hrMghs002a().bghl002a().argumento().tsMovimento().set(wsTimestamp());
        }
        /**
         * -- DATA INICIO --> MGH002A-TS-MOV-MAX
         */
        wsTimestamp().wsDataTimestamp().wsAnoAa().set(msgIn().msg().ade().zIniCons().get(1, 4));
        wsTimestamp().wsDataTimestamp().wsMesMm().set(msgIn().msg().ade().zIniCons().get(6, 2));
        wsTimestamp().wsDataTimestamp().wsDiaDd().set(msgIn().msg().ade().zIniCons().get(9, 2));
        wsTimestamp().get(11, 16).set("-00.00.00.000000") ;
        hrMghs002a().bghl002a().criterioSeleccao().tsMovMax().set(wsTimestamp());
        hrMghs002a().bghl002a().criterioConsulta().descendente().setTrue() ;
        hrMghs002a().bghl002a().criterioDbcr().credito().setTrue() ;
        hrMghs002a().bghl002a().criterioMontante().mMovMin().set(0);
        hrMghs002a().bghl002a().criterioMontante().mMovMax().set(0);
        log(TraceLevel.Debug, " ------------- ACESSO MGHS002A ------------- ");
        log(TraceLevel.Debug, " - MGH002A-I-CRITERIO-CNS      :", hrMghs002a().bghl002a().criterioConsulta().iCriterioCns());
        log(TraceLevel.Debug, " - MGH002A-I-CRITERIO-DBCR     :", hrMghs002a().bghl002a().criterioDbcr().iCriterioDbcr());
        log(TraceLevel.Debug, " - MGH002A-M-MOV-MIN           :", hrMghs002a().bghl002a().criterioMontante().mMovMin());
        log(TraceLevel.Debug, " - MGH002A-M-MOV-MAX           :", hrMghs002a().bghl002a().criterioMontante().mMovMax());
        log(TraceLevel.Debug, " - MGH002A-TS-MOV-MAX          :", hrMghs002a().bghl002a().criterioSeleccao().tsMovMax());
        log(TraceLevel.Debug, " - MGH002A-NS-MOV-MAX          :", hrMghs002a().bghl002a().criterioSeleccao().nsMovMax());
        log(TraceLevel.Debug, " - MGH002A-C-PAIS-ISOA-CONT    :", hrMghs002a().bghl002a().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, " - MGH002A-C-BANC-CONT         :", hrMghs002a().bghl002a().argumento().cBancCont());
        log(TraceLevel.Debug, " - MGH002A-C-OE-EGC-CONT       :", hrMghs002a().bghl002a().argumento().cOeEgcCont());
        log(TraceLevel.Debug, " - MGH002A-NS-RDCL-CONT        :", hrMghs002a().bghl002a().argumento().nsRdclCont());
        log(TraceLevel.Debug, " - MGH002A-V-CHKD-CONT         :", hrMghs002a().bghl002a().argumento().vChkdCont());
        log(TraceLevel.Debug, " - MGH002A-C-TIPO-CONT         :", hrMghs002a().bghl002a().argumento().cTipoCont());
        log(TraceLevel.Debug, " - MGH002A-C-MOED-ISO-SCTA     :", hrMghs002a().bghl002a().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, " - MGH002A-NS-DEPOSITO         :", hrMghs002a().bghl002a().argumento().nsDeposito());
        log(TraceLevel.Debug, " - MGH002A-TS-MOVIMENTO        :", hrMghs002a().bghl002a().argumento().tsMovimento());
        log(TraceLevel.Debug, " - MGH002A-NS-MOVIMENTO        :", hrMghs002a().bghl002a().argumento().nsMovimento());
        log(TraceLevel.Debug, " - BGHM1180-NS-MOVIMENTO-PG    :", msgIn().msg().ade().nsMovimentoPg());
        hrMghs002a().run() ;
        if (!hrMghs002a().bghl002a().ok().isTrue()) {
            if (!hrMghs002a().bghl002a().naoExiste().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs002a().bghl002a().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00002");
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs002a().bghl002a().cRetorno());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, "ERRO-04");
            }
        } else {
            /**
             * -- TRATA MOVIMENTOS DEVOLVIDOS PELA MGHS002A
             * -- POR CADA MOVIMENTO:
             * --    FORMATA TABELA INTERNA (PARA POSTERIOR FORMATACAO
             * --    DA LISTA DE OUTPUT), SENDO APENAS APRESENTADOS
             * --    OS MOVIMENTOS A CREDITO E QUE NAO TENHAM SIDO
             * --    ESTORNADOS
             */
            wsVariaveis().wsQMovsDevolvidos().set(hrMghs002a().bghl002a().qItens());
            hrMghs002a().bghl002a().tabela().lista().setIndex(CON_1N);
            log(TraceLevel.Debug, "-------------MGH002A-Q-ITENS:", hrMghs002a().bghl002a().qItens());
            log(TraceLevel.Debug, "-------------BGHM1181-INDICE-INVERSO:", msgOut().indiceInverso());
            for (hrMghs002a().bghl002a().tabela().lista().setIndex(1); hrMghs002a().bghl002a().tabela().lista().index().isLessOrEqual(hrMghs002a().bghl002a().qItens()) && wsTabelaMovimento().wsMovimentos().index().isLessOrEqual(msgOut().indiceInverso()) && wsVariaveis().wsRegTabInt().isLessOrEqual(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue(); hrMghs002a().bghl002a().tabela().lista().incIndex()) {
                hrMghs002a().bghl002a().argumento().set(hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs002a().bghl002a().detalhe().set(hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemDetalhe());
                log(TraceLevel.Debug, "MGH002A-C-PAIS-ISOA-CONT: ", hrMghs002a().bghl002a().argumento().cPaisIsoaCont());
                log(TraceLevel.Debug, "MGH002A-C-BANC-CONT     : ", hrMghs002a().bghl002a().argumento().cBancCont());
                log(TraceLevel.Debug, "MGH002A-C-OE-EGC-CONT   : ", hrMghs002a().bghl002a().argumento().cOeEgcCont());
                log(TraceLevel.Debug, "MGH002A-NS-RDCL-CONT    : ", hrMghs002a().bghl002a().argumento().nsRdclCont());
                log(TraceLevel.Debug, "MGH002A-V-CHKD-CONT     : ", hrMghs002a().bghl002a().argumento().vChkdCont());
                log(TraceLevel.Debug, "MGH002A-C-TIPO-CONT     : ", hrMghs002a().bghl002a().argumento().cTipoCont());
                log(TraceLevel.Debug, "MGH002A-C-MOED-ISO-SCTA : ", hrMghs002a().bghl002a().argumento().cMoedIsoScta());
                log(TraceLevel.Debug, "MGH002A-NS-DEPOSITO     : ", hrMghs002a().bghl002a().argumento().nsDeposito());
                log(TraceLevel.Debug, "MGH002A-TS-MOVIMENTO    : ", hrMghs002a().bghl002a().argumento().tsMovimento());
                log(TraceLevel.Debug, "MGH002A-NS-MOVIMENTO    : ", hrMghs002a().bghl002a().argumento().nsMovimento());
                msgIn().msg().ade().nsMovimentoPg().set(hrMghs002a().bghl002a().argumento().nsMovimento());
                if (msgIn().msg().ade().nsMovimentoPg().isGreater(1)) {
                    msgIn().msg().ade().nsMovimentoPg().subtract(1);
                }
                msgIn().msg().ade().zMovimentoPg().set(hrMghs002a().bghl002a().argumento().tsMovimento().get(1, 10));
                if (hrMghs002a().bghl002a().detalhe().iEstorno().isEmpty() && 
                    hrMghs002a().bghl002a().detalhe().iDbcr().isEqual(CON_CREDITO) && 
                    hrMghs002a().bghl002a().argumento().tsMovimento().get(1, 10).isGreaterOrEqual(msgIn().msg().ade().zIniCons()) && 
                    hrMghs002a().bghl002a().argumento().tsMovimento().get(1, 10).isLessOrEqual(msgIn().msg().ade().zFimCons())) {
                    /**
                     * -- VALIDA SE O MOVIMENTO FOI ESTORNADO
                     * -- ATRAVES DA TGH00009
                     */
                    wsVariaveis().wsNsMovimentoTgh9().set(hrMghs002a().bghl002a().argumento().nsMovimento());
                    wsVariaveis().wsDtMovimentoTgh9().set(hrMghs002a().bghl002a().argumento().tsMovimento().get(1, 10));
                    m2311ValMovEstn() ;
                    if ((swSwitches().swVgh00901Ok().isTrue() && 
                        hv00901Infauxmov().infauxmov().iEstorno().isEmpty()) || 
                        swSwitches().swVgh00901Notfnd().isTrue()) {
                        /**
                         * -- SE MOVIMENTO NAO EXISTE NA TGH00009,
                         * -- SIGNIFICA Q O MOVIMENTO NAO FOI ESTORNADO
                         */
                        wsVariaveis().wsRegTabInt().add(1);
                        log(TraceLevel.Debug, " **** MOVIMENTO TRATADO ****");
                        log(TraceLevel.Debug, "        ", wsVariaveis().wsRegTabInt(), "      ");
                        log(TraceLevel.Debug, " - MGH002A-Z-VAL-MOV     :", hrMghs002a().bghl002a().detalhe().zValMov());
                        log(TraceLevel.Debug, " - MGH002A-NS-MOVIMENTO  :", hrMghs002a().bghl002a().argumento().nsMovimento());
                        log(TraceLevel.Debug, " - MGH002A-X-REF-MOV     :", hrMghs002a().bghl002a().detalhe().xRefMov());
                        log(TraceLevel.Debug, " - MGH002A-M-MOVIMENTO   :", hrMghs002a().bghl002a().detalhe().mMovimento());
                        log(TraceLevel.Debug, " - MGH002A-C-MOED-ISO-ORI-MOV:", hrMghs002a().bghl002a().detalhe().cMoedIsoOriMov());
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghs002a().bghl002a().argumento().tsMovimento().get(1, 10));
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghs002a().bghl002a().detalhe().zValMov());
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(hrMghs002a().bghl002a().argumento().tsMovimento());
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghs002a().bghl002a().argumento().nsMovimento());
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghs002a().bghl002a().detalhe().xRefMov());
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghs002a().bghl002a().detalhe().mMovimento());
                        wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghs002a().bghl002a().detalhe().cMoedIsoOriMov());
                        wsTabelaMovimento().wsMovimentos().incIndex() ;
                        swSwitches().swMovHstS().setTrue() ;
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 2311-VAL-MOV-ESTN
     * 
     */
    protected void m2311ValMovEstn() {
        log(TraceLevel.Debug, "2311-VAL-MOV-ESTN");
        hv00901Infauxmov().infauxmov().initialize() ;
        hv00901Infauxmov().infauxmov().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv00901Infauxmov().infauxmov().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv00901Infauxmov().infauxmov().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv00901Infauxmov().infauxmov().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv00901Infauxmov().infauxmov().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv00901Infauxmov().infauxmov().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv00901Infauxmov().infauxmov().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv00901Infauxmov().infauxmov().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hv00901Infauxmov().infauxmov().nsMovimento().set(wsVariaveis().wsNsMovimentoTgh9());
        log(TraceLevel.Debug, "---------- TGH00009 ----------");
        log(TraceLevel.Debug, " . VGH00901-C-PAIS-ISOA-CONT:", hv00901Infauxmov().infauxmov().cPaisIsoaCont());
        log(TraceLevel.Debug, " . VGH00901-C-BANC-CONT     :", hv00901Infauxmov().infauxmov().cBancCont());
        log(TraceLevel.Debug, " . VGH00901-C-OE-EGC-CONT   :", hv00901Infauxmov().infauxmov().cOeEgcCont());
        log(TraceLevel.Debug, " . VGH00901-NS-RDCL-CONT    :", hv00901Infauxmov().infauxmov().nsRdclCont());
        log(TraceLevel.Debug, " . VGH00901-V-CHKD-CONT     :", hv00901Infauxmov().infauxmov().vChkdCont());
        log(TraceLevel.Debug, " . VGH00901-C-TIPO-CONT     :", hv00901Infauxmov().infauxmov().cTipoCont());
        log(TraceLevel.Debug, " . VGH00901-C-MOED-ISO-SCTA :", hv00901Infauxmov().infauxmov().cMoedIsoScta());
        log(TraceLevel.Debug, " . VGH00901-NS-DEPOSITO     :", hv00901Infauxmov().infauxmov().nsDeposito());
        log(TraceLevel.Debug, " . VGH00901-NS-MOVIMENTO    :", hv00901Infauxmov().infauxmov().nsMovimento());
        log(TraceLevel.Debug, " . WS-DT-MOVIMENTO-TGH9     :", wsVariaveis().wsDtMovimentoTgh9());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00901_INFAUXMOV
         */
        hv00901Infauxmov().selectPghs181a1761(wsVariaveis().wsDtMovimentoTgh9()) ;
        log(TraceLevel.Debug, "---------- TGH00009 ----------");
        log(TraceLevel.Debug, " ---> SQLCODE :", hv00901Infauxmov().getPersistenceCode());
        swSwitches().swSqlcodeVgh00901().set(hv00901Infauxmov().getPersistenceCode());
        m9020Db2check() ;
        if (!swSwitches().swVgh00901Ok().isTrue() && !swSwitches().swVgh00901Notfnd().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(hv00901Infauxmov().getPersistenceCode());
            envOut.db2Log().nmTabela().set(CON_VGH00901);
        }
    }
    
    /**
     * 
     * 2500-ACEDE-HO
     * 
     */
    protected void m2500AcedeHo() {
        log(TraceLevel.Debug, "2500-ACEDE-HO");
        hrMghs804a().bghl804a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs804a().bghl804a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs804a().bghl804a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs804a().bghl804a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs804a().bghl804a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs804a().bghl804a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs804a().bghl804a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs804a().bghl804a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        if (msgIn().msg().ade().nsMovimentoPg().isGreater(0)) {
            hrMghs804a().bghl804a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimentoPg());
        }
        hrMghs804a().bghl804a().criterioConsulta().descendente().setTrue() ;
        hrMghs804a().bghl804a().criterioDbcr().credito().setTrue() ;
        log(TraceLevel.Debug, " ********** ACESSO MGHS804A ********** ");
        log(TraceLevel.Debug, " - MGH804A-C-PAIS-ISOA-CONT :", hrMghs804a().bghl804a().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, " - MGH804A-C-BANC-CONT      :", hrMghs804a().bghl804a().argumento().cBancCont());
        log(TraceLevel.Debug, " - MGH804A-C-OE-EGC-CONT    :", hrMghs804a().bghl804a().argumento().cOeEgcCont());
        log(TraceLevel.Debug, " - MGH804A-NS-RDCL-CONT     :", hrMghs804a().bghl804a().argumento().nsRdclCont());
        log(TraceLevel.Debug, " - MGH804A-V-CHKD-CONT      :", hrMghs804a().bghl804a().argumento().vChkdCont());
        log(TraceLevel.Debug, " - MGH804A-C-TIPO-CONT      :", hrMghs804a().bghl804a().argumento().cTipoCont());
        log(TraceLevel.Debug, " - MGH804A-C-MOED-ISO-SCTA  :", hrMghs804a().bghl804a().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, " - MGH804A-NS-DEPOSITO      :", hrMghs804a().bghl804a().argumento().nsDeposito());
        log(TraceLevel.Debug, " - MGH804A-Z-MOVIMENTO      :", hrMghs804a().bghl804a().argumento().zMovimento());
        log(TraceLevel.Debug, " - MGH804A-NS-MOVIMENTO     :", hrMghs804a().bghl804a().argumento().nsMovimento());
        hrMghs804a().run() ;
        log(TraceLevel.Debug, " ********** RETORNO MGHS804A ********** ");
        log(TraceLevel.Debug, " - MGH804A-C-RETORNO:", hrMghs804a().bghl804a().cRetorno());
        log(TraceLevel.Debug, " ************************************** ");
        if (!hrMghs804a().bghl804a().ok().isTrue()) {
            if (!hrMghs804a().bghl804a().naoExiste().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs804a().bghl804a().cSqlcode());
                envOut.db2Log().nmTabela().set("THO00020");
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs804a().bghl804a().cRetorno());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, "ERRO-05");
            }
        } else {
            log(TraceLevel.Debug, "-------------MGH804A-Q-ITENS:", hrMghs804a().bghl804a().qItens());
            wsVariaveis().wsQMovsDevolvidos().set(hrMghs804a().bghl804a().qItens());
            for (hrMghs804a().bghl804a().tabela().lista().setIndex(1); hrMghs804a().bghl804a().tabela().lista().index().isLessOrEqual(hrMghs804a().bghl804a().qItens()) && wsTabelaMovimento().wsMovimentos().index().isLessOrEqual(msgOut().indiceInverso()) && wsVariaveis().wsRegTabInt().isLessOrEqual(msgOut().indiceInverso()) && envOut.errosGraves().semErros().isTrue(); hrMghs804a().bghl804a().tabela().lista().incIndex()) {
                hrMghs804a().bghl804a().argumento().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs804a().bghl804a().detalhe().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe());
                msgIn().msg().ade().nsMovimentoPg().set(hrMghs804a().bghl804a().argumento().nsMovimento());
                if (msgIn().msg().ade().nsMovimentoPg().isGreater(1)) {
                    msgIn().msg().ade().nsMovimentoPg().subtract(1);
                }
                log(TraceLevel.Debug, " --------------------------- ");
                log(TraceLevel.Debug, " -----> MGH804A-I-ESTORNO:", hrMghs804a().bghl804a().detalhe().iEstorno());
                log(TraceLevel.Debug, " -----> MGH804A-I-DBCR   :", hrMghs804a().bghl804a().detalhe().iDbcr());
                log(TraceLevel.Debug, " --------------------------- ");
                if (hrMghs804a().bghl804a().detalhe().iEstorno().isEmpty() && 
                    hrMghs804a().bghl804a().detalhe().iDbcr().isEqual(CON_CREDITO) && 
                    hrMghs804a().bghl804a().argumento().zMovimento().isGreaterOrEqual(msgIn().msg().ade().zIniCons()) && 
                    hrMghs804a().bghl804a().argumento().zMovimento().isLessOrEqual(msgIn().msg().ade().zFimCons())) {
                    wsVariaveis().wsRegTabInt().add(1);
                    log(TraceLevel.Debug, " **** MOVIMENTO TRATADO **** ");
                    log(TraceLevel.Debug, "          ", wsVariaveis().wsRegTabInt(), "      ");
                    log(TraceLevel.Debug, " - MGH804A-Z-MOVIMENTO        :", hrMghs804a().bghl804a().argumento().zMovimento());
                    log(TraceLevel.Debug, " - MGH804A-NS-MOVIMENTO       :", hrMghs804a().bghl804a().argumento().nsMovimento());
                    log(TraceLevel.Debug, " - MGH804A-X-REF-MOV          :", hrMghs804a().bghl804a().detalhe().xRefMov());
                    log(TraceLevel.Debug, " - MGH804A-M-MOVIMENTO        :", hrMghs804a().bghl804a().detalhe().mMovimento());
                    log(TraceLevel.Debug, " - MGH804A-C-MOED-ISO-ORI-MOV :", hrMghs804a().bghl804a().detalhe().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().set(hrMghs804a().bghl804a().argumento().zMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov().set(hrMghs804a().bghl804a().detalhe().zValor());
                    wsTs().wDataTs().set(hrMghs804a().bghl804a().argumento().zMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento().set(wsTs());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().set(hrMghs804a().bghl804a().argumento().nsMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().set(hrMghs804a().bghl804a().detalhe().xRefMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento().set(hrMghs804a().bghl804a().detalhe().mMovimento());
                    wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov().set(hrMghs804a().bghl804a().detalhe().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().incIndex() ;
                    swSwitches().swMovHstS().setTrue() ;
                }
            }
        }
        log(TraceLevel.Debug, "_______________________________________________");
        log(TraceLevel.Debug, "                                           ");
        log(TraceLevel.Debug, " >>>>>>> WS-REG-TAB-INT: ", wsVariaveis().wsRegTabInt());
        log(TraceLevel.Debug, "_______________________________________________");
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, " 3000-FINAL-PROGRAMA");
        log(TraceLevel.Debug, " --> BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        if (envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ade().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
            msgOut().msg().ade().cBancCont().set(msgIn().msg().ade().cBancCont());
            msgOut().msg().ade().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
            msgOut().msg().ade().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
            msgOut().msg().ade().vChkdCont().set(msgIn().msg().ade().vChkdCont());
            msgOut().msg().ade().cTipoCont().set(msgIn().msg().ade().cTipoCont());
            msgOut().msg().ade().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
            msgOut().msg().ade().nsDeposito().set(msgIn().msg().ade().nsDeposito());
            msgOut().msg().ade().zIniCons().set(msgIn().msg().ade().zIniCons());
            msgOut().msg().ade().zFimCons().set(msgIn().msg().ade().zFimCons());
            msgOut().indice().set(0);
            wsTabelaMovimento().wsMovimentos().resetIndex() ;
            while (!msgOut().indice().isEqual(msgOut().indiceInverso()) && !wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento().isEqual(0)) {
                m3500FormaListaOutput() ;
            }
        }
        log(TraceLevel.Debug, " WS-NS-MOVIMENTO(1):", wsTabelaMovimento().wsMovimentos().get(1).wsNsMovimento());
        /**
         * -- CASO NAO HAJA NENHUM OCORRENCIA PREENCHIDA, DEVOLVE ERRO
         * -- FUNCIONAL
         * -- SW-CONT-INVOCACAO SERVE PARA CONTROLAR SE E A PRIMEIRA
         * -- INVOCACAO
         */
        if (envOut.errosGraves().semErros().isTrue() && swSwitches().swContInvocacaoN().isTrue() && 
            wsTabelaMovimento().wsMovimentos().get(1).wsNsMovimento().isEqual(0)) {
            envOut.errosGraves().aAplErr().set("GH");
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().naoExistMovCrit());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-09");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            log(TraceLevel.Error, "BGHM1181-INDICE:", msgOut().indice());
            if (!msgOut().paginaCheia().isTrue()) {
                msgOut().indiceInverso().subtract(msgOut().indice());
                msgOut().diminuiLength().set(multiply(msgOut().indiceInverso(), msgOut().lengthOccur()));
                msgOut().qCterCmptAlig().subtract(msgOut().diminuiLength());
                log(TraceLevel.Debug, "-----------------------------------");
                log(TraceLevel.Debug, "-- F I M  D E  C O N S U L T A  ---");
                log(TraceLevel.Debug, "-----------------------------------");
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().fimConsulta());
            }
        }
        message.mensagem().headerR().transaccao().anulNotrunc().setTrue() ;
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        exit() ;
    }
    
    /**
     * 
     * 3500-FORMA-LISTA-OUTPUT
     * 
     */
    protected void m3500FormaListaOutput() {
        log(TraceLevel.Debug, " 3500-FORMA-LISTA-OUTPUT");
        msgOut().indice().add(CON_1N);
        log(TraceLevel.Debug, " ---- OCORRENCIA Nº ", msgOut().indice(), "---");
        m3510ObtemCCarMov() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).zMovimentoL().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento());
            msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov());
            msgOut().msg().ade().linha().get(msgOut().indice()).mMontanteMovL().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsMMovimento());
            msgOut().msg().ade().linha().get(msgOut().indice()).cMoedaMovL().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsCMoedIsoOriMov());
            msgOut().msg().ade().linha().get(msgOut().indice()).cCarExtL().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsCCarExt());
            msgOut().msg().ade().linha().get(msgOut().indice()).nsMovimentoL().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento());
        }
        log(TraceLevel.Debug, " ----> BGHM1181-Z-MOVIMENTO-L   :", msgOut().msg().ade().linha().get(msgOut().indice()).zMovimentoL());
        log(TraceLevel.Debug, " ----> BGHM1181-X-REF-MOV-L     :", msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL());
        log(TraceLevel.Debug, " ----> BGHM1181-M-MONTANTE-MOV-L:", msgOut().msg().ade().linha().get(msgOut().indice()).mMontanteMovL());
        log(TraceLevel.Debug, " ----> BGHM1181-C-MOEDA-MOV-L   :", msgOut().msg().ade().linha().get(msgOut().indice()).cMoedaMovL());
        log(TraceLevel.Debug, " ----> BGHM1181-C-CAR-EXT-L     :", msgOut().msg().ade().linha().get(msgOut().indice()).cCarExtL());
        log(TraceLevel.Debug, " ----> BGHM1181-NS-MOVIMENTO-L  :", msgOut().msg().ade().linha().get(msgOut().indice()).nsMovimentoL());
        if (envOut.errosGraves().semErros().isTrue() && 
            wsTabelaMovimento().wsMovimentos().getCurrent().wsXRefMov().isEmpty()) {
            if (wsTabelaMovimento().wsMovimentos().getCurrent().wsZMovimento().isEqual(hrMghs003a().bghl003a().zHoje())) {
                if (swSwitches().swEncadeamentoMvphi0().isTrue()) {
                    m3521ObtemDescMovDia() ;
                } else {
                    /**
                     * -- ENVIA ESPACOS, POIS A MGHS804A JA EFETUOU O ACESSO
                     * -- FEITO NO PARAG 3521-OBTEM-DESC-MOV-DIA
                     */
                    msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL().set(" ");
                }
            } else {
                m3522ObtemDescritivoMov() ;
            }
        }
        wsTabelaMovimento().wsMovimentos().incIndex() ;
    }
    
    /**
     * 
     * 3510-OBTEM-C-CAR-MOV
     * 
     */
    protected void m3510ObtemCCarMov() {
        log(TraceLevel.Debug, " 3510-OBTEM-C-CAR-MOV");
        hv20001Movexgdep().movexgdep().initialize() ;
        hv20001Movexgdep().movexgdep().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv20001Movexgdep().movexgdep().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv20001Movexgdep().movexgdep().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv20001Movexgdep().movexgdep().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv20001Movexgdep().movexgdep().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv20001Movexgdep().movexgdep().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv20001Movexgdep().movexgdep().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv20001Movexgdep().movexgdep().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hv20001Movexgdep().movexgdep().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento());
        hv20001Movexgdep().movexgdep().cEstExtsGarDep().set(CON_ATIVO);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().selectPghs181a2153() ;
        swSwitches().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        m9020Db2check() ;
        if (swSwitches().swVgh20001Ok().isTrue()) {
            wsTabelaMovimento().wsMovimentos().getCurrent().wsCCarExt().set(hv20001Movexgdep().movexgdep().cCrtzMovExsGar());
        } else if (swSwitches().swVgh20001Notfnd().isTrue()) {
            wsTabelaMovimento().wsMovimentos().getCurrent().wsCCarExt().set(" ");
        } else {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
        }
    }
    
    /**
     * 
     * 3521-OBTEM-DESC-MOV-DIA
     * 
     */
    protected void m3521ObtemDescMovDia() {
        log(TraceLevel.Debug, " 3521-OBTEM-DESC-MOV-DIA");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(hrMghj206a().bghl206a().commarea().detalhe().iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(hrMghj206a().bghl206a().commarea().detalhe().iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(hrMghj206a().bghl206a().commarea().detalhe().zValor());
        hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghj206a().bghl206a().commarea().detalhe().cPaisIsoaOeOpx());
        hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghj206a().bghl206a().commarea().detalhe().cMnemEgcOpex());
        hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghj206a().bghl206a().commarea().detalhe().cOeEgcOpex());
        hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghj206a().bghl206a().commarea().detalhe().cOpeBbn());
        hrMghk800a().run() ;
        log(TraceLevel.Debug, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
        if (hrMghk800a().bghl800a().ok().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL().set(hrMghk800a().bghl800a().output().xRefMov());
            log(TraceLevel.Error, "WS-X-REF-MOV-", hrMghk800a().bghl800a().output().xRefMov());
        } else {
            msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL().set(" ");
        }
    }
    
    /**
     * 
     * 3522-OBTEM-DESCRITIVO-MOV
     * 
     */
    protected void m3522ObtemDescritivoMov() {
        log(TraceLevel.Debug, " 3522-OBTEM-DESCRITIVO-MOV");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(CON_CREDITO);
        hrMghk800a().bghl800a().input().iEstorno().set(" ");
        hrMghk800a().bghl800a().input().zValMov().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsZValMov());
        m3521ObtemCOeOpex() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m3522ObtemCOpeBbn() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs102a().bghl102a().detalhe().cOpeBbn());
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            hrMghk800a().run() ;
            if (hrMghk800a().bghl800a().ok().isTrue()) {
                msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL().set(hrMghk800a().bghl800a().output().xRefMov());
            } else {
                log(TraceLevel.Error, " MGH800A-C-RETORNO----->", hrMghk800a().bghl800a().cRetorno());
                log(TraceLevel.Error, " MGH800A-NM-PROGRAMA--->", hrMghk800a().bghl800a().nmPrograma());
                log(TraceLevel.Error, " MGH800A-C-SQLCODE----->", hrMghk800a().bghl800a().cSqlcode());
                msgOut().msg().ade().linha().get(msgOut().indice()).xRefMovL().set(" ");
            }
        }
    }
    
    /**
     * 
     * 3521-OBTEM-C-OE-OPEX
     * 
     */
    protected void m3521ObtemCOeOpex() {
        log(TraceLevel.Debug, " 3521-OBTEM-C-OE-OPEX");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtOnde().setTrue() ;
        if (swSwitches().swMovHstS().isTrue()) {
            hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        } else {
            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
        }
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento());
        log(TraceLevel.Debug, " »»»»»»»»»»»»» MGHS102A «««««««««««««« ");
        log(TraceLevel.Debug, " - MGH102A-TS-MOVIMENTO        :", hrMghs102a().bghl102a().argumento().tsMovimento());
        log(TraceLevel.Debug, " - MGH102A-NS-MOVIMENTO        :", hrMghs102a().bghl102a().argumento().nsMovimento());
        log(TraceLevel.Debug, " »»»»»»»»»»»»»    .    «««««««««««««« ");
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, "ERRO-13");
        }
    }
    
    /**
     * 
     * 3522-OBTEM-C-OPE-BBN
     * 
     */
    protected void m3522ObtemCOpeBbn() {
        log(TraceLevel.Debug, " 3522-OBTEM-C-OPE-BBN");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtQuem().setTrue() ;
        if (swSwitches().swMovHstS().isTrue()) {
            hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        } else {
            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
        }
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsTsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().wsNsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, "ERRO-14");
        }
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
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=3, value="0")
        IInt wsTeste() ;
        
        @Data(size=2, value="0")
        IInt wsRegTabInt() ;
        
        @Data(size=10, value=" ")
        IString wsDtDiaMenos1Ano() ;
        
        @Data(size=10, value=" ")
        IString wsDtMovimentoTgh9() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimentoTgh9() ;
        
        @Data(size=2, value="0")
        IInt wsQMovsDevolvidos() ;
        
        /**
         * @return instancia da classe local WsNDocId
         */
        @Data
        WsNDocId wsNDocId() ;
        
        @Data(format="999-", value="0")
        IFormattedString wsSqlcodeErro() ;
        
        
        public interface WsNDocId extends IDataStruct {
            
            @Data(size=9, value="0")
            ILong wsNIpc() ;
            
            @Data(size=11, value=" ")
            IString wsResto() ;
            
        }
    }
    public interface WsTs extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTs
         */
        @Data(rpadding=16, rpaddingValue="")
        WDataTs wDataTs() ;
        
        
        public interface WDataTs extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaMin() ;
            
        }
    }
    public interface WsTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataTimestamp
         */
        @Data
        WsDataTimestamp wsDataTimestamp() ;
        
        /**
         * @return instancia da classe local WsTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WsTimerTimestamp wsTimerTimestamp() ;
        
        
        public interface WsDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wsAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wsMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wsDiaDd() ;
            
        }
        
        public interface WsTimerTimestamp extends IDataStruct {
            
            @Data(size=2, value="0")
            IInt wsHh() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wsMm() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wsSs() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wsRestoTms() ;
            
        }
    }
    
    /**
     * 
     * ****          TABELAS INTERNAS                            ****
     * 
     * @version 2.0
     * 
     */
    public interface WsTabelaMovimento extends IDataStruct {
        
        /**
         * @return instancia da classe local WsMovimentos
         */
        @Data(length=22)
        IArray<WsMovimentos> wsMovimentos() ;
        
        
        public interface WsMovimentos extends IDataStruct {
            
            
            @Data(size=10)
            IString wsZMovimento() ;
            
            @Data(size=10)
            IString wsZValMov() ;
            
            @Data(size=26)
            IString wsTsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimento() ;
            
            @Data(size=21)
            IString wsXRefMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal wsMMovimento() ;
            
            @Data(size=3)
            IString wsCMoedIsoOriMov() ;
            
            @Data(size=3)
            IString wsCCarExt() ;
            
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
        
        /**
         * ----- GERAIS
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00901() ;
        @Data
        @Condition("100")
        ICondition swVgh00901Notfnd() ;
        @Data
        @Condition("0")
        ICondition swVgh00901Ok() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20001() ;
        @Data
        @Condition("100")
        ICondition swVgh20001Notfnd() ;
        @Data
        @Condition("0")
        ICondition swVgh20001Ok() ;
        
        
        @Data(size=1, value="N")
        IString swContInvocacao() ;
        @Data
        @Condition("S")
        ICondition swContInvocacaoS() ;
        @Data
        @Condition("N")
        ICondition swContInvocacaoN() ;
        
        
        @Data(size=1, value=" ")
        IString swCrtMovHst() ;
        @Data
        @Condition("S")
        ICondition swMovHstS() ;
        @Data
        @Condition("N")
        ICondition swMovHstN() ;
        
        
        @Data(size=1, value=" ")
        IString swEncadeamentos() ;
        @Data
        @Condition("0")
        ICondition swEncadeamentoMvphi0() ;
        
        
        @Data(size=1, value="N")
        IString swObtencaoDados() ;
        @Data
        @Condition("S")
        ICondition swObtemDadosMov() ;
        
        
    }
    
}
