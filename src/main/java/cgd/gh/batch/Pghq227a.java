package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
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
import cgd.hq.common.constants.Bhqk0002 ;
import cgd.hr.common.constants.Bhrk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ho.structures.work.Bhow0070 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hg.structures.link.Bhgl911a ;
import cgd.hy.structures.link.Bhyl009a ;
import cgd.ho.structures.work.Bhor1771 ;
import cgd.gh.structures.work.Bghr1701 ;
import cgd.ho.structures.link.Bhol708a ;
import cgd.hr.structures.link.Bhrl500a ;
import cgd.ho.structures.work.Bhow0002 ;
import cgd.hs.structures.link.Bhsl110a ;
import cgd.hv.structures.link.Bhvl152a ;
import cgd.hj.structures.link.Bhjl014a ;
import cgd.hq.structures.link.Bhql100a ;
import cgd.hj.structures.link.Bhjl031a ;
import cgd.hv.structures.link.Bhvl100a ;
import cgd.hs.common.constants.Bhsk0002 ;
import cgd.ht.structures.link.Bhtl001a ;
import cgd.ht.routines.Mhtq250a ;
import cgd.hg.routines.Mhgj011a ;
import cgd.hy.routines.Mhyj009a ;
import cgd.ho.routines.Mhoj708a ;
import cgd.hs.routines.Mhsj110a ;
import cgd.hr.routines.Mhrj500a ;
import cgd.hv.routines.Mhvj152a ;
import cgd.hj.routines.Mhjj014a ;
import cgd.hq.routines.Mhqj100a ;
import cgd.hj.routines.Mhjj031a ;


/**
 * 
 * CLAUSULAS DE FILE DEFINITION DOS FICHEIROS DE OUTPUT
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq227a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops00101Contas
     */
    @Data
    protected abstract Vwsdhops00101Contas hv00101Contas() ;
    
    
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
    @Handler(name="FWK001", record="statusFwk00102")
    @Data
    protected abstract Fwk00102 ficheiroFwk001() ;
    
    
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
     * @return instancia da classe Mhsj110a
     */
    @Data
    protected abstract Mhsj110a hrMhsj110a() ;
    
    /**
     * @return instancia da classe Mhrj500a
     */
    @Data
    protected abstract Mhrj500a hrMhrj500a() ;
    
    /**
     * @return instancia da classe Mhvj152a
     */
    @Data
    protected abstract Mhvj152a hrMhvj152a() ;
    
    /**
     * @return instancia da classe Mhjj014a
     */
    @Data
    protected abstract Mhjj014a hrMhjj014a() ;
    
    /**
     * @return instancia da classe Mhqj100a
     */
    @Data
    protected abstract Mhqj100a hrMhqj100a() ;
    
    /**
     * @return instancia da classe Mhjj031a
     */
    @Data
    protected abstract Mhjj031a hrMhjj031a() ;
    
    
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
     * @return instancia da classe Bhqk0002
     */
    @Data
    protected abstract Bhqk0002 bhqk0002() ;
    
    /**
     * @return instancia da classe Bhrk0002
     */
    @Data
    protected abstract Bhrk0002 bhrk0002() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhow0070
     */
    @Data
    protected abstract Bhow0070 bhow0070() ;
    
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
     * @return instancia da classe Bhrl500a
     */
    @Data
    protected abstract Bhrl500a bhrl500a() ;
    
    /**
     * @return instancia da classe Bhow0002
     */
    @Data
    protected abstract Bhow0002 bhow0002() ;
    
    /**
     * @return instancia da classe Bhsl110a
     */
    @Data
    protected abstract Bhsl110a bhsl110a() ;
    
    /**
     * @return instancia da classe Bhvl152a
     */
    @Data
    protected abstract Bhvl152a bhvl152a() ;
    
    /**
     * @return instancia da classe Bhjl014a
     */
    @Data
    protected abstract Bhjl014a bhjl014a() ;
    
    /**
     * @return instancia da classe Bhql100a
     */
    @Data
    protected abstract Bhql100a bhql100a() ;
    
    /**
     * @return instancia da classe Bhjl031a
     */
    @Data
    protected abstract Bhjl031a bhjl031a() ;
    
    /**
     * @return instancia da classe Bhvl100a
     */
    @Data
    protected abstract Bhvl100a bhvl100a() ;
    
    /**
     * @return instancia da classe Bhsk0002
     */
    @Data
    protected abstract Bhsk0002 bhsk0002() ;
    
    /**
     * @return instancia da classe Bhtl001a
     */
    @Data
    protected abstract Bhtl001a bhtl001a() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHQ227A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ227A" ;
    
    protected static final String CON_MHGJ011A = "MHGJ011A" ;
    
    protected static final String CON_MHYJ009A = "MHYJ009A" ;
    
    protected static final String CON_FILE_V11 = "FGH172" ;
    
    protected static final String CON_FILE_V12 = "FGH173" ;
    
    protected static final String CON_FILE_V17 = "FGH174" ;
    
    protected static final String CON_FILE_V13 = "FGH175" ;
    
    protected static final String CON_FILE_V15 = "FGH176" ;
    
    protected static final String CON_SEPA = "HR" ;
    
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
    }
    
    /**
     * 
     * ACESSO A ROTINA MHYJ009A - DADOS DE MAPAS
     * 
     */
    protected void bhyp0009RotMapas() {
    }
    
    /**
     * 
     * BHOP0708 - COPY PROCEDURE DE CHAMADA A ROTINA DE VALIDACAO DE
     * CONTA E SITUACAO CONTRA ACCAO
     * 
     */
    protected void bhop0708ValConta() {
    }
    
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
     * ACESSO A ROTINA QUE VALIDA A RESTRICAO
     * DE ACESSO A CONTAS: MHSS110A
     * 
     */
    protected void bhsp0110ValRestAcesCt() {
        hrMhsj110a().run() ;
    }
    
    /**
     * 
     * ORIGEM MOV PAIS = PT    DESTINO MOV PAIS <> PT
     * ESTE COPYBOOK DEVERA MANIPULAR OS DADOS DOS ULTIMOS 2 TIPOS
     * PARA REFLECTIR O MOVIMENTO DENTRO DE PORTUGAL
     * DEVERA SUBSTITUIR A CONTA A CRE/DEB NO ESTRANGEIRO POR UMA
     * CONTA NOSTRO / VOSTRO DE PORTUGAL DO BANCO DESTINO
     * NO CASO DE DEBITO PAIS 1 -> CREDITO PAIS 2
     * DEVERAO SER GERADOS 4 MOVIMENTOS
     * MOV1 : DEBITO PAIS 1 -> CREDITO CONTA VOSTRO / NOSTRO
     * MOV2 : DEBITO CONTA VOSTRO / NOSTRO -> CREDITO PAIS 2
     * MOV1 : GERA SAIDA FINANCEIRA DO PAIS1 PARA O ESTRANGEIRO
     * MOV2 : GERA ENTRADA FINANCEIRA DO ESTRANGEIRO AO PAIS2
     * OPERATIVO COES MULTI-EMPRESA
     * EXISTEM NO COPY 2 CONTAS. A CONTA DE DEBITO E CONTA CREDITO
     * PELO MENOS UMA DELAS ESTA PREENCHIDA
     * A INFORMACAO CONTABILISTA TEM SEMPRE AS 2 PERNAS PREENCHIDAS*
     * ONDE HA DEBITO A CREDITO - REGRA DE OURO ALNOVA E VIDA
     * EXISTEM 4 TIPOS DE MOVIMENTO NO ALNOVA CGD
     * ORIGEM MOV PAIS = PT    DESTINO MOV PAIS = PT
     * ORIGEM MOV PAIS <> PT   DESTINO MOV PAIS <> PT
     * ORIGEM MOV PAIS <> PT   DESTINO MOV PAIS = PT
     * 
     */
    protected void bhop0070ObtemCoe() {
        if (bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest().isEqual(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest())) {
            bhop0070CoeSimples() ;
        } else {
            bhop0070CoeDupla() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhop0070CoeSimples() {
        if (bhow0070().commarea().dadosOutput().semErros().isTrue() && 
            bhow0070().commarea().dadosEntrada().cTransaccaoArq().isEqual(bhow0070().commarea().dadosEntrada().cTransaccaoPgm()) && 
            !bhow0070().commarea().dadosEntrada().mMovimento().isEqual(0)) {
            if (bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDebS().isTrue() || bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCreS().isTrue() || 
                bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDDecgS().isTrue() || 
                bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCDecgS().isTrue()) {
                bhop0070ValidaCoeInp() ;
                if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
                    bhop0070AcedeModCoe() ;
                }
            }
        }
    }
    
    /**
     * 
     * BHOP0070-VALIDA-COE-INP
     * 
     */
    protected void bhop0070ValidaCoeInp() {
        if (bhow0070().commarea().dadosEntrada().coeInputObrig().isTrue()) {
            bhow0070().commarea().dadosOutput().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
            if (bhow0070().commarea().dadosEntrada().cPaisIsoAtc().isEmpty()) {
                bhow0070().commarea().dadosOutput().abend().setTrue() ;
                bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().paisDestCoeAusente());
                bhow0070().commarea().dadosOutput().msgErrob().set("PAIS DESTINO COE AUSENTE");
                bhow0070().commarea().dadosOutput().modOrigemErro().set("BHOP0070");
            }
        }
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            bhop0070PreencheOpx() ;
        }
    }
    
    /**
     * 
     * BHOP0070-ACEDE-MOD-COE
     * 
     */
    protected void bhop0070AcedeModCoe() {
        bhql100a().commarea().dadosEntrada().swIEstorno().set(bhow0070().commarea().dadosEntrada().swIEstorno());
        bhql100a().commarea().dadosEntrada().swISimulz().set(bhow0070().commarea().dadosEntrada().swISimulz());
        bhql100a().commarea().dadosEntrada().swIOffline().set(bhow0070().commarea().dadosEntrada().swIOffline());
        bhql100a().commarea().dadosEntrada().swIProc().set(bhow0070().commarea().dadosEntrada().swIProc());
        bhql100a().commarea().dadosEntrada().tipoOper().set(bhow0070().commarea().dadosEntrada().swTipoOper());
        bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlAux1Deb().set(bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlBporDeb());
        bhow0070().commarea().dadosEntrada().identContCre().cSectIttlAux1Cre().set(bhow0070().commarea().dadosEntrada().identContCre().cSectIttlBporCre());
        if (bhow0070().commarea().dadosEntrada().swIEstornoNao().isTrue()) {
            bhql100a().commarea().dadosEntrada().nJourBbn().set(bhow0070().commarea().dadosEntrada().nJourBbn());
        } else {
            bhql100a().commarea().dadosEntrada().nJourBbn().set(bhow0070().commarea().dadosEntrada().nJourBbnEsn());
        }
        if (!bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().isEmpty()) {
            if (!bhow0070().commarea().dadosEntrada().identContDeb().nsMovDeb().isEmpty()) {
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(1, 4).set(bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(5, 7).set(bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(12, 1).set(bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(13, 3).set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(16, 9).set(bhow0070().commarea().dadosEntrada().identContDeb().nsMovDeb().get(7, 9)) ;
            } else {
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(1, 2).set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(3, 4).set(bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(7, 7).set(bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(14, 1).set(bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb()) ;
                bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(15, 3).set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb()) ;
            }
        } else if (!bhow0070().commarea().dadosEntrada().identContCre().nsMovCre().isEmpty()) {
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(1, 4).set(bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(5, 7).set(bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(12, 1).set(bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(13, 3).set(bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(16, 9).set(bhow0070().commarea().dadosEntrada().identContCre().nsMovCre().get(7, 9)) ;
        } else {
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(1, 2).set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(3, 4).set(bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(7, 7).set(bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(14, 1).set(bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre()) ;
            bhql100a().commarea().dadosEntrada().cRefOrigOpet().get(15, 3).set(bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre()) ;
        }
        bhql100a().commarea().dadosEntrada().iOpCxMeNao().setTrue() ;
        bhql100a().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().cBancContDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().cOeEgcContDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().nsRdclContDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().vChkdContDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().cTipoContDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb());
        bhql100a().commarea().dadosEntrada().identContDeb().nsDepositoDeb().set(bhow0070().commarea().dadosEntrada().identContDeb().nsDepositoDeb());
        bhql100a().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
        bhql100a().commarea().dadosEntrada().identContCre().cBancContCre().set(bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
        bhql100a().commarea().dadosEntrada().identContCre().cOeEgcContCre().set(bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre());
        bhql100a().commarea().dadosEntrada().identContCre().nsRdclContCre().set(bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre());
        bhql100a().commarea().dadosEntrada().identContCre().vChkdContCre().set(bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre());
        bhql100a().commarea().dadosEntrada().identContCre().cTipoContCre().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre());
        bhql100a().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre().set(bhow0070().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre());
        bhql100a().commarea().dadosEntrada().identContCre().nsDepositoCre().set(bhow0070().commarea().dadosEntrada().identContCre().nsDepositoCre());
        bhql100a().commarea().dadosEntrada().cSiglApl().set(bhow0070().commarea().dadosEntrada().aAplicacao());
        bhql100a().commarea().dadosEntrada().zProcessamento().set(bhow0070().commarea().dadosEntrada().zProcessamento());
        if (bhow0070().commarea().dadosEntrada().swIEstornoNao().isTrue()) {
            /**
             * MOVE BHOW0070-C-OE-EGC            TO BHQL100A-C-OE-EGC
             */
            bhql100a().commarea().dadosEntrada().cUserid().set(bhow0070().commarea().dadosEntrada().cUserid());
        } else {
            /**
             * MOVE BHOW0070-C-OE-EGC-ESTN       TO BHQL100A-C-OE-EGC
             */
            bhql100a().commarea().dadosEntrada().cUserid().set(bhow0070().commarea().dadosEntrada().cUsidEstn());
        }
        if (bhow0070().commarea().dadosEntrada().swIOnLine().isTrue()) {
            bhql100a().commarea().dadosEntrada().tsTransaccao().set(bhow0070().commarea().dadosEntrada().tsCentral());
        } else {
            bhow0070().commarea().dadosEntrada().tsCentral().set(getDate()) ;
            bhow0070().commarea().dadosOutput().auxTs().get(1, 2).set("20") ;
            bhow0070().commarea().dadosOutput().auxTs().get(3, 2).set(bhow0070().commarea().dadosEntrada().tsCentral().get(1, 2)) ;
            bhow0070().commarea().dadosOutput().auxTs().get(5, 1).set("-") ;
            bhow0070().commarea().dadosOutput().auxTs().get(6, 2).set(bhow0070().commarea().dadosEntrada().tsCentral().get(3, 2)) ;
            bhow0070().commarea().dadosOutput().auxTs().get(8, 1).set("-") ;
            bhow0070().commarea().dadosOutput().auxTs().get(9, 2).set(bhow0070().commarea().dadosEntrada().tsCentral().get(5, 2)) ;
            bhow0070().commarea().dadosOutput().auxTs().get(11, 1).set("-") ;
            bhow0070().commarea().dadosEntrada().tsCentral().set(getTime()) ;
            bhow0070().commarea().dadosOutput().auxTs().get(12, 2).set(bhow0070().commarea().dadosEntrada().tsCentral().get(1, 2)) ;
            bhow0070().commarea().dadosOutput().auxTs().get(14, 1).set(".") ;
            bhow0070().commarea().dadosOutput().auxTs().get(15, 2).set(bhow0070().commarea().dadosEntrada().tsCentral().get(3, 2)) ;
            bhow0070().commarea().dadosOutput().auxTs().get(17, 1).set(".") ;
            bhow0070().commarea().dadosOutput().auxTs().get(18, 2).set(bhow0070().commarea().dadosEntrada().tsCentral().get(5, 2)) ;
            bhow0070().commarea().dadosOutput().auxTs().get(20, 1).set(".") ;
            bhow0070().commarea().dadosOutput().auxTs().get(21, 6).set("0") ;
            bhql100a().commarea().dadosEntrada().tsTransaccao().set(bhow0070().commarea().dadosOutput().auxTs());
        }
        if (bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDDecgS().isTrue()) {
            bhql100a().commarea().dadosEntrada().cTipoOpetBpor().set(bhok0002().cTipOptBporDecg());
        } else if (bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCDecgS().isTrue()) {
            bhql100a().commarea().dadosEntrada().cTipoOpetBpor().set(bhok0002().cTipOptBporDecg());
        } else {
            bhql100a().commarea().dadosEntrada().cTipoOpetBpor().set(bhow0070().commarea().dadosEntrada().cTipoOpetBpor());
        }
        if (!bhow0070().commarea().dadosEntrada().cTcmd().isEmpty() && 
            !bhow0070().commarea().dadosEntrada().cTcmc().isEmpty()) {
            bhql100a().commarea().dadosEntrada().cTcmd().set(bhow0070().commarea().dadosEntrada().cTcmd());
            bhql100a().commarea().dadosEntrada().cTcmc().set(bhow0070().commarea().dadosEntrada().cTcmc());
            if (bhql100a().commarea().dadosEntrada().cTcmd().isEqual("78") || 
                bhql100a().commarea().dadosEntrada().cTcmc().isEqual("78")) {
                bhql100a().commarea().dadosEntrada().nIpc().set(bhok0002().BHOK0002_NIF_CGD);
            } else {
                bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
            }
        } else {
            bhql100a().commarea().dadosEntrada().cTcmd().set(" ");
            bhql100a().commarea().dadosEntrada().cTcmc().set(" ");
        }
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cCpltMvopIcb().set(" ");
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cCpltMvopIcb().set(" ");
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).iTipoFmonIcb().set("I");
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).iTipoFmonIcb().set("I");
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).aAplInszJour().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).aAplInszJour());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cOpczMenu().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpczMenu());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cOpeBbn().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpeBbn());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cFamiProd().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cFamiProd());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cProduto().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cProduto());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDst().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest());
        bhql100a().commarea().dadosEntrada().acessIcb().get(1).cSectIttlBpor().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cSectIttlBpor());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).aAplInszJour().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).aAplInszJour());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cOpczMenu().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpczMenu());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cFamiProd().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cFamiProd());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cProduto().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cProduto());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDst().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cOeEgcDest().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOeEgcDest());
        bhql100a().commarea().dadosEntrada().acessIcb().get(2).cSectIttlBpor().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cSectIttlBpor());
        bhql100a().commarea().dadosEntrada().cEvento().set(bhow0070().commarea().dadosEntrada().cEvento());
        bhql100a().commarea().dadosEntrada().cSubEvento().set(bhow0070().commarea().dadosEntrada().cSubEvento());
        bhql100a().commarea().dadosEntrada().zOpert().set(bhow0070().commarea().dadosEntrada().zCtlzJourBbn());
        bhql100a().commarea().dadosEntrada().mOpetBpor().set(bhow0070().commarea().dadosEntrada().mMovimento());
        bhql100a().commarea().dadosEntrada().cMoedIsoAlfn().set(bhow0070().commarea().dadosEntrada().cMoedIsoAlfn());
        bhql100a().commarea().dadosEntrada().cBaseIcdcOpe().set(bhow0070().commarea().dadosEntrada().cBaseIcdcOpe());
        /**
         * HO23868 - INICIO
         */
        bhql100a().commarea().dadosEntrada().aAplicacao().set(bhow0070().commarea().dadosEntrada().aAplicacao());
        bhql100a().commarea().dadosEntrada().cOpczMnReg().set(bhow0070().commarea().dadosEntrada().cOpczMnReg());
        bhql100a().commarea().dadosEntrada().xAudtBporSegn().set(bhow0070().commarea().dadosEntrada().xAudtBporSegn());
        bhql100a().commarea().dadosEntrada().xAudtBporTerc().set(bhow0070().commarea().dadosEntrada().xAudtBporTerc());
        bhql100a().commarea().dadosEntrada().cEntEmitCtrpBp().set(bhow0070().commarea().dadosEntrada().cEntEmitCtrpBp());
        bhql100a().commarea().dadosEntrada().cPaisResiCtpBp().set(bhow0070().commarea().dadosEntrada().cPaisResiCtpBp());
        bhql100a().commarea().dadosEntrada().cPaisEntActfBp().set(bhow0070().commarea().dadosEntrada().cPaisEntActfBp());
        bhql100a().commarea().dadosEntrada().cSectIttlBpCtp().set(bhow0070().commarea().dadosEntrada().cSectIttlBpCtp());
        bhql100a().commarea().dadosEntrada().xObsOpetBpor().set(bhow0070().commarea().dadosEntrada().xObsOpetBpor());
        bhql100a().commarea().dadosEntrada().xAudtBporQrto().set(bhow0070().commarea().dadosEntrada().xAudtBporQrto());
        bhql100a().commarea().dadosEntrada().cUsidRsplCriz().set(bhow0070().commarea().dadosEntrada().cUsidRsplCriz());
        /**
         * HO23868 - FIM
         */
        if (bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().isEmpty() && 
            !bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().isEmpty()) {
            if (bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre().isEqual("S")) {
                bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().set(bhok0002().tpConta().tpContaEmpresa());
            } else if (bhow0070().commarea().dadosEntrada().identContCre().cSectIttlAux2Cre().cSectPartCre().isEqual("32")) {
                bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().set(bhok0002().tpConta().tpContaParticular());
            } else {
                bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().set(bhok0002().tpConta().tpContaEmpresa());
            }
        }
        if (bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().isEmpty() && 
            !bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().isEmpty()) {
            if (bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb().isEqual("S")) {
                bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().set(bhok0002().tpConta().tpContaEmpresa());
            } else if (bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlAux2Deb().cSectPartDeb().isEqual("32")) {
                bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().set(bhok0002().tpConta().tpContaParticular());
            } else {
                bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().set(bhok0002().tpConta().tpContaEmpresa());
            }
        }
        if (bhow0070().commarea().dadosEntrada().cPaisIsoAtc().isEmpty()) {
            bhop0070ProcuraPais() ;
        } else {
            bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhow0070().commarea().dadosEntrada().cPaisIsoAtc());
        }
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            if (bhow0070().commarea().dadosEntrada().identContCre().cSectIttlAux2Cre().cSectIttlCre().isEqual("1")) {
                bhql100a().commarea().dadosEntrada().acessoCntas().iClszTtr1Cont().set(bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre());
                bhql100a().commarea().dadosEntrada().acessoCntas().iEmpsNomeIdvl().set(bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre());
                if (bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().isEqual(bhok0002().tpConta().tpContaEmpresa()) || 
                    bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre().isEqual("S")) {
                    bhjl031a().commarea().initialize() ;
                    bhjl031a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                    bhjl031a().commarea().dadosEntrada().cBancCont().set(bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
                    bhjl031a().commarea().dadosEntrada().cOeEgcCont().set(bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre());
                    bhjl031a().commarea().dadosEntrada().nsRdclCont().set(bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre());
                    bhjl031a().commarea().dadosEntrada().vChkdCont().set(bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre());
                    bhjl031a().commarea().dadosEntrada().cTipoCont().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre());
                    if (!bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre().isEmpty()) {
                        bhjl031a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                        bhjl031a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre());
                    } else {
                        bhjl031a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
                        bhjl031a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
                    }
                    bhjp5031AcedeMhjj031a() ;
                    if (!bhjl031a().commarea().erros().semErros().isTrue()) {
                        if (bhjl031a().commarea().erros().naoExitReg().isTrue()) {
                            bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
                        }
                    }
                    if (bhjl031a().commarea().erros().semErros().isTrue() || bhjl031a().commarea().erros().fimConsulta().isTrue()) {
                        bhow0070().commarea().dadosEntrada().nIpc2().set(bhjl031a().commarea().dadosSaida().get(1).nDocId());
                        if (bhow0070().commarea().dadosEntrada().nIpc2().nIpcNum().isNumeric()) {
                            bhql100a().commarea().dadosEntrada().nIpc().set(bhow0070().commarea().dadosEntrada().nIpc2().nIpcNum());
                        } else {
                            bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
                        }
                    } else if (bhow0070().commarea().dadosEntrada().swIProc().isEqual("B")) {
                        bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
                    } else {
                        bhow0070().commarea().dadosOutput().cSqlcode().set(bhjl031a().commarea().erros().cSqlcode());
                        bhow0070().commarea().dadosOutput().nmTabela().set(bhjl031a().commarea().erros().nmTabela());
                        bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhjl031a().commarea().erros().cTipoErroBbn());
                        bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhjl031a().commarea().erros().cRtnoEvenSwal());
                        bhow0070().commarea().dadosOutput().aAplErr().set(bhjl031a().commarea().erros().aAplErr());
                        bhow0070().commarea().dadosOutput().modOrigemErro().set(bhjl031a().commarea().erros().modOrigemErro());
                        bhow0070().commarea().dadosOutput().msgErrob().set(bhjl031a().commarea().erros().msgErrob());
                        bhow0070().commarea().dadosOutput().chAcesso().set(bhjl031a().commarea().erros().chAcesso());
                        if (bhjl031a().commarea().erros().cTipoErroBbn().isEqual(bhtk0002().indErros().errosFuncao())) {
                            bhow0070().commarea().dadosOutput().abend().setTrue() ;
                        }
                    }
                }
            } else if (bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlAux2Deb().cSectIttlDeb().isEqual("1")) {
                bhql100a().commarea().dadosEntrada().acessoCntas().iClszTtr1Cont().set(bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb());
                bhql100a().commarea().dadosEntrada().acessoCntas().iEmpsNomeIdvl().set(bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb());
                if (bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().isEqual(bhok0002().tpConta().tpContaEmpresa()) || 
                    bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb().isEqual("S")) {
                    bhjl031a().commarea().initialize() ;
                    bhjl031a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
                    bhjl031a().commarea().dadosEntrada().cBancCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
                    bhjl031a().commarea().dadosEntrada().cOeEgcCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb());
                    bhjl031a().commarea().dadosEntrada().nsRdclCont().set(bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb());
                    bhjl031a().commarea().dadosEntrada().vChkdCont().set(bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb());
                    bhjl031a().commarea().dadosEntrada().cTipoCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb());
                    if (!bhow0070().commarea().dadosEntrada().identContDeb().cMnemEmpGcxDeb().isEmpty()) {
                        bhjl031a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
                        bhjl031a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().identContDeb().cMnemEmpGcxDeb());
                    } else {
                        bhjl031a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
                        bhjl031a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
                    }
                    bhjp5031AcedeMhjj031a() ;
                    if (!bhjl031a().commarea().erros().semErros().isTrue()) {
                        if (bhjl031a().commarea().erros().naoExitReg().isTrue()) {
                            bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
                        }
                    }
                    if (bhjl031a().commarea().erros().semErros().isTrue() || bhjl031a().commarea().erros().fimConsulta().isTrue()) {
                        bhow0070().commarea().dadosEntrada().nIpc2().set(bhjl031a().commarea().dadosSaida().get(1).nDocId());
                        if (bhow0070().commarea().dadosEntrada().nIpc2().nIpcNum().isNumeric()) {
                            bhql100a().commarea().dadosEntrada().nIpc().set(bhow0070().commarea().dadosEntrada().nIpc2().nIpcNum());
                        } else {
                            bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
                        }
                    } else if (bhow0070().commarea().dadosEntrada().swIProc().isEqual("B")) {
                        bhql100a().commarea().dadosEntrada().nIpc().set(777777777);
                    } else {
                        bhow0070().commarea().dadosOutput().cSqlcode().set(bhjl031a().commarea().erros().cSqlcode());
                        bhow0070().commarea().dadosOutput().nmTabela().set(bhjl031a().commarea().erros().nmTabela());
                        bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhjl031a().commarea().erros().cTipoErroBbn());
                        bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhjl031a().commarea().erros().cRtnoEvenSwal());
                        bhow0070().commarea().dadosOutput().aAplErr().set(bhjl031a().commarea().erros().aAplErr());
                        bhow0070().commarea().dadosOutput().modOrigemErro().set(bhjl031a().commarea().erros().modOrigemErro());
                        bhow0070().commarea().dadosOutput().msgErrob().set(bhjl031a().commarea().erros().msgErrob());
                        bhow0070().commarea().dadosOutput().chAcesso().set(bhjl031a().commarea().erros().chAcesso());
                        if (bhjl031a().commarea().erros().cTipoErroBbn().isEqual(bhtk0002().indErros().errosFuncao())) {
                            bhow0070().commarea().dadosOutput().abend().setTrue() ;
                        }
                    }
                }
            }
        }
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            bhqp5100RotinaCoes() ;
            if (!bhql100a().commarea().dadosSaida().semErros().isTrue()) {
                if (bhql100a().commarea().dadosSaida().erroAcessoVhq02801().isTrue()) {
                    bhow0070().commarea().dadosOutput().cTipoErroBbn().set(" ");
                    bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(0);
                    bhow0070().commarea().dadosOutput().cSqlcode().set(0);
                } else {
                    bhop0070DisplayCoes() ;
                    log(TraceLevel.Error, "**** ERRO BHOP0070 **** INI ****");
                    log(TraceLevel.Error, "C-TIPO-ERRO-BBN ", bhql100a().commarea().dadosSaida().cTipoErroBbn());
                    log(TraceLevel.Error, "C-RTNO-EVEN-SWAL", bhql100a().commarea().dadosSaida().cRtnoEvenSwal());
                    log(TraceLevel.Error, "NM-TABELA       ", bhql100a().commarea().dadosSaida().nmTabela());
                    log(TraceLevel.Error, "SQLCODE         ", bhql100a().commarea().dadosSaida().cSqlcode());
                    log(TraceLevel.Error, "MSG-ERROB       ", bhql100a().commarea().dadosSaida().msgErrob());
                    log(TraceLevel.Error, "CH-ACESSO       ", bhql100a().commarea().dadosSaida().chAcesso());
                    log(TraceLevel.Error, "A-APL-ERR       ", bhql100a().commarea().dadosSaida().aAplErr());
                    log(TraceLevel.Error, "MOD-ORIGEM-ERRO ", bhql100a().commarea().dadosSaida().modOrigemErro());
                    log(TraceLevel.Error, "**** ERRO BHOP0070 **** FIM ****");
                    bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhql100a().commarea().dadosSaida().cTipoErroBbn());
                    bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhql100a().commarea().dadosSaida().cRtnoEvenSwal());
                    bhow0070().commarea().dadosOutput().nmTabela().set(bhql100a().commarea().dadosSaida().nmTabela());
                    bhow0070().commarea().dadosOutput().cSqlcode().set(bhql100a().commarea().dadosSaida().cSqlcode());
                    bhow0070().commarea().dadosOutput().msgErrob().set(bhql100a().commarea().dadosSaida().msgErrob());
                    bhow0070().commarea().dadosOutput().chAcesso().set(bhql100a().commarea().dadosSaida().chAcesso());
                    bhow0070().commarea().dadosOutput().aAplErr().set(bhql100a().commarea().dadosSaida().aAplErr());
                    bhow0070().commarea().dadosOutput().modOrigemErro().set(bhql100a().commarea().dadosSaida().modOrigemErro());
                }
            }
        }
    }
    
    /**
     * 
     * FORMATACAO DE PAIS E BANCO DA OPERACAO
     * COM BASE NA INFORMACAO CONTABILISTICA VAI SER ESPECIFICADO
     * O PAIS / EMPRESA QUE IREMOS INFORMAR O BANCO DE PORTUGAL
     * ESTA MARTELADO MAS VAI SER SUBSTITUIDO POR ACESSOS QUE
     * TRADUZAM EMPRESA EM CODIGO BANCO
     * NOTA - A CGD E SFE ENVIAM O MESMO CODIGO DE BANCO = 0035
     * A SUCURSAL LUXEMBURGO MANDA 0302
     * A SUCURSAL DE MACAU NAO GERA COE
     * AS OPERACOES CONTABILISTICAS A REPORTAR DEVERAO FECHAR
     * SEMPRE NO MESMO PAIS / EMPRESA
     * E SE ALGUEM TIVER UM PROBLEMA COM ISSO PODE FALAR COMIGO
     * RUIV76
     * 
     */
    protected void bhop0070PreencheOpx() {
        if (!bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest().isEqual(bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest())) {
            /**
             * OR BHOW0070-C-MNEM-EGC-DEST(1)
             * NOT = BHOW0070-C-MNEM-EGC-DEST(2)
             */
            bhow0070().commarea().dadosOutput().cSqlcode().set(0);
            bhow0070().commarea().dadosOutput().nmTabela().set(" ");
            bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().accaoInvalida());
            bhow0070().commarea().dadosOutput().aAplErr().set("HO");
            bhow0070().commarea().dadosOutput().modOrigemErro().set("BHOP0070");
            bhow0070().commarea().dadosOutput().msgErrob().set("ERRO GRAVE COES - OPERACAO CBLO CRUZADA EMPRESAS");
            bhow0070().commarea().dadosOutput().chAcesso().set(concat(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest(), bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest(), bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest(), bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest()));
        }
        bhql100a().commarea().dadosEntrada().cPaisIsoBancPt().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest());
        bhql100a().commarea().dadosEntrada().cOeEgc().set(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest());
        if (bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest().isEqual("PT")) {
            bhql100a().commarea().dadosEntrada().cEmpBancPt().set(35);
        } else if (bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest().isEqual("LU")) {
            bhql100a().commarea().dadosEntrada().cEmpBancPt().set(302);
        } else {
            bhow0070().commarea().dadosOutput().cSqlcode().set(0);
            bhow0070().commarea().dadosOutput().nmTabela().set(" ");
            bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhok0001().erros().accaoInvalida());
            bhow0070().commarea().dadosOutput().aAplErr().set("HO");
            bhow0070().commarea().dadosOutput().modOrigemErro().set("BHOP0070");
            bhow0070().commarea().dadosOutput().msgErrob().set("ESTE PAIS NAO GERA COES - BOPS");
            bhow0070().commarea().dadosOutput().chAcesso().set(concat(bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest(), bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest(), bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest(), bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest()));
        }
        bhql100a().commarea().dadosEntrada().cBanco().set(0);
    }
    
    /**
     * 
     * BHOP0070-PROCURA-PAIS
     * 
     */
    protected void bhop0070ProcuraPais() {
        if (bhow0070().commarea().dadosEntrada().identContCre().cSectIttlAux2Cre().cSectIttlCre().isEqual("2") && 
            !bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().isEmpty()) {
            bhok0002().cTipoTrttCont().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre());
            if (bhok0002().cTipoTrttCtaNostr().isTrue()) {
                bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
            } else {
                bhjl014a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                bhjl014a().commarea().dadosEntrada().cBancCont().set(bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
                bhjl014a().commarea().dadosEntrada().cOeEgcCont().set(bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre());
                bhjl014a().commarea().dadosEntrada().nsRdclCont().set(bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre());
                bhjl014a().commarea().dadosEntrada().vChkdCont().set(bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre());
                bhjl014a().commarea().dadosEntrada().cTipoCont().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre());
                bhow0070().commarea().dadosEntrada().swICtaCreEst().setTrue() ;
                if (!bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre().isEmpty()) {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre());
                } else {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
                }
            }
        } else if (bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlAux2Deb().cSectIttlDeb().isEqual("2") && 
            !bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().isEmpty()) {
            bhok0002().cTipoTrttCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoTrttContDeb());
            if (bhok0002().cTipoTrttCtaNostr().isTrue()) {
                bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
            } else {
                bhjl014a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
                bhjl014a().commarea().dadosEntrada().cBancCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
                bhjl014a().commarea().dadosEntrada().cOeEgcCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb());
                bhjl014a().commarea().dadosEntrada().nsRdclCont().set(bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb());
                bhjl014a().commarea().dadosEntrada().vChkdCont().set(bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb());
                bhjl014a().commarea().dadosEntrada().cTipoCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb());
                bhow0070().commarea().dadosEntrada().swICtaDebEst().setTrue() ;
                if (!bhow0070().commarea().dadosEntrada().identContDeb().cMnemEmpGcxDeb().isEmpty()) {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().identContDeb().cMnemEmpGcxDeb());
                } else {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
                }
            }
        } else if (!bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().isEmpty()) {
            bhok0002().cTipoTrttCont().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre());
            if (bhok0002().cTipoTrttCtaNostr().isTrue()) {
                bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
            } else {
                bhjl014a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                bhjl014a().commarea().dadosEntrada().cBancCont().set(bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
                bhjl014a().commarea().dadosEntrada().cOeEgcCont().set(bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre());
                bhjl014a().commarea().dadosEntrada().nsRdclCont().set(bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre());
                bhjl014a().commarea().dadosEntrada().vChkdCont().set(bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre());
                bhjl014a().commarea().dadosEntrada().cTipoCont().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre());
                bhow0070().commarea().dadosEntrada().swICtaCreEst().setTrue() ;
                if (!bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre().isEmpty()) {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre());
                } else {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
                }
            }
        } else if (!bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().isEmpty()) {
            bhok0002().cTipoTrttCont().set(bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre());
            if (bhok0002().cTipoTrttCtaNostr().isTrue()) {
                bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
            } else {
                bhjl014a().commarea().dadosEntrada().cPaisIsoaCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
                bhjl014a().commarea().dadosEntrada().cBancCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
                bhjl014a().commarea().dadosEntrada().cOeEgcCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb());
                bhjl014a().commarea().dadosEntrada().nsRdclCont().set(bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb());
                bhjl014a().commarea().dadosEntrada().vChkdCont().set(bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb());
                bhjl014a().commarea().dadosEntrada().cTipoCont().set(bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb());
                bhow0070().commarea().dadosEntrada().swICtaDebEst().setTrue() ;
                if (!bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre().isEmpty()) {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre());
                } else {
                    bhjl014a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
                    bhjl014a().commarea().dadosEntrada().cMnemEgcOpex().set(bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
                }
            }
        } else {
            bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
        }
        if (bhql100a().commarea().dadosEntrada().cPaisIsoAtc().isEmpty()) {
            bhjp5014AcedeMhjj014a() ;
            if (bhjl014a().commarea().erros().semErros().isTrue()) {
                if (bhow0070().commarea().dadosEntrada().swICtaCreEst().isTrue()) {
                    if (bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().isEqual(bhok0002().tpConta().tpContaEmpresa()) && 
                        bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre().isEqual("N")) {
                        bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhjl014a().commarea().dadosSaida().cPaisIsoaEmp());
                    } else {
                        bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhjl014a().commarea().dadosSaida().cPaisIsoaResi());
                    }
                    if (bhql100a().commarea().dadosEntrada().cPaisIsoAtc().isEmpty()) {
                        bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
                    }
                } else {
                    if (bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().isEqual(bhok0002().tpConta().tpContaEmpresa()) && 
                        bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb().isEqual("N")) {
                        bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhjl014a().commarea().dadosSaida().cPaisIsoaEmp());
                    } else {
                        bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhjl014a().commarea().dadosSaida().cPaisIsoaResi());
                    }
                    if (bhql100a().commarea().dadosEntrada().cPaisIsoAtc().isEmpty()) {
                        bhql100a().commarea().dadosEntrada().cPaisIsoAtc().set(bhok0002().BHOK0002_COD_PAIS_ISOA);
                    }
                }
            } else {
                bhow0070().commarea().dadosOutput().cSqlcode().set(bhjl014a().commarea().erros().cSqlcode());
                bhow0070().commarea().dadosOutput().nmTabela().set(bhjl014a().commarea().erros().nmTabela());
                bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhjl014a().commarea().erros().cTipoErroBbn());
                bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhjl014a().commarea().erros().cRtnoEvenSwal());
                bhow0070().commarea().dadosOutput().aAplErr().set(bhjl014a().commarea().erros().aAplErr());
                bhow0070().commarea().dadosOutput().modOrigemErro().set(bhjl014a().commarea().erros().modOrigemErro());
                bhow0070().commarea().dadosOutput().msgErrob().set(bhjl014a().commarea().erros().msgErrob());
                bhow0070().commarea().dadosOutput().chAcesso().set(bhjl014a().commarea().erros().chAcesso());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhop0070DisplayCoes() {
        log(TraceLevel.Trace, "*********************************************");
        log(TraceLevel.Trace, "***     DISPLAY DE AREA DE COES - INI    ****");
        log(TraceLevel.Trace, "*********************************************");
        log(TraceLevel.Trace, "C-TRANSACCAO-ARQ     ", bhow0070().commarea().dadosEntrada().cTransaccaoArq());
        log(TraceLevel.Trace, "C-TRANSACCAO-PGM     ", bhow0070().commarea().dadosEntrada().cTransaccaoPgm());
        log(TraceLevel.Trace, "I-ESTORNO            ", bhow0070().commarea().dadosEntrada().swIEstorno());
        log(TraceLevel.Trace, "I-SIMULZ             ", bhow0070().commarea().dadosEntrada().swISimulz());
        log(TraceLevel.Trace, "I-OFFLINE            ", bhow0070().commarea().dadosEntrada().swIOffline());
        log(TraceLevel.Trace, "I-PROC               ", bhow0070().commarea().dadosEntrada().swIProc());
        log(TraceLevel.Trace, "TIPO-OPER            ", bhow0070().commarea().dadosEntrada().swTipoOper());
        log(TraceLevel.Trace, "C-PAIS-ISOA-CONT-DEB ", bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
        log(TraceLevel.Trace, "C-BANC-CONT-DEB      ", bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
        log(TraceLevel.Trace, "C-OE-EGC-CONT-DEB    ", bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb());
        log(TraceLevel.Trace, "NS-RDCL-CONT-DEB     ", bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb());
        log(TraceLevel.Trace, "V-CHKD-CONT-DEB      ", bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb());
        log(TraceLevel.Trace, "C-TIPO-CONT-DEB      ", bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb());
        log(TraceLevel.Trace, "C-MOED-ISO-SCTA-DEB  ", bhow0070().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb());
        log(TraceLevel.Trace, "NS-DEPOSITO-DEB      ", bhow0070().commarea().dadosEntrada().identContDeb().nsDepositoDeb());
        log(TraceLevel.Trace, "NS-MOV-DEB           ", bhow0070().commarea().dadosEntrada().identContDeb().nsMovDeb());
        log(TraceLevel.Trace, "I-GRAZ-COE-DEB       ", bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDeb());
        log(TraceLevel.Trace, "C-SECT-ITTL-BPOR-DEB ", bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlBporDeb());
        log(TraceLevel.Trace, "C-SECT-ITTL-AUX1-DEB ", bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlAux1Deb());
        log(TraceLevel.Trace, "I-CLSZ-TTR1-CONT-DEB ", bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb());
        log(TraceLevel.Trace, "I-EMPS-NOME-IDVL-DEB ", bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb());
        log(TraceLevel.Trace, "C-TIPO-TRTT-CONT-DEB ", bhow0070().commarea().dadosEntrada().identContDeb().cTipoTrttContDeb());
        log(TraceLevel.Trace, "C-PAIS-ISOA-CONT-CRE ", bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
        log(TraceLevel.Trace, "C-BANC-CONT-CRE      ", bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
        log(TraceLevel.Trace, "C-OE-EGC-CONT-CRE    ", bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre());
        log(TraceLevel.Trace, "NS-RDCL-CONT-CRE     ", bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre());
        log(TraceLevel.Trace, "V-CHKD-CONT-CRE      ", bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre());
        log(TraceLevel.Trace, "C-TIPO-CONT-CRE      ", bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre());
        log(TraceLevel.Trace, "C-MOED-ISO-SCTA-CRE  ", bhow0070().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre());
        log(TraceLevel.Trace, "NS-DEPOSITO-CRE      ", bhow0070().commarea().dadosEntrada().identContCre().nsDepositoCre());
        log(TraceLevel.Trace, "NS-MOV-CRE           ", bhow0070().commarea().dadosEntrada().identContCre().nsMovCre());
        log(TraceLevel.Trace, "I-GRAZ-COE-CRE       ", bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCre());
        log(TraceLevel.Trace, "C-SECT-ITTL-BPOR-CRE ", bhow0070().commarea().dadosEntrada().identContCre().cSectIttlBporCre());
        log(TraceLevel.Trace, "C-SECT-ITTL-AUX1-CRE ", bhow0070().commarea().dadosEntrada().identContCre().cSectIttlAux1Cre());
        log(TraceLevel.Trace, "I-CLSZ-TTR1-CONT-CRE ", bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre());
        log(TraceLevel.Trace, "I-EMPS-NOME-IDVL-CRE ", bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre());
        log(TraceLevel.Trace, "C-TIPO-TRTT-CONT-CRE ", bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre());
        log(TraceLevel.Trace, "C-BANCO-OPEX         ", bhow0070().commarea().dadosEntrada().cBancoOpex());
        log(TraceLevel.Trace, "C-PAIS-ISOA-OE-OPX   ", bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Trace, "C-MNEM-EGC-OPEX      ", bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Trace, "C-OE-EGC             ", bhow0070().commarea().dadosEntrada().cOeEgc());
        log(TraceLevel.Trace, "C-USERID             ", bhow0070().commarea().dadosEntrada().cUserid());
        log(TraceLevel.Trace, "N-JOUR-BBN           ", bhow0070().commarea().dadosEntrada().nJourBbn());
        log(TraceLevel.Trace, "C-PAIS-ISOA-OE-ESN   ", bhow0070().commarea().dadosEntrada().cPaisIsoaOeEsn());
        log(TraceLevel.Trace, "C-OE-EGC-ESTN        ", bhow0070().commarea().dadosEntrada().cOeEgcEstn());
        log(TraceLevel.Trace, "C-USID-ESTN          ", bhow0070().commarea().dadosEntrada().cUsidEstn());
        log(TraceLevel.Trace, "N-JOUR-BBN-ESN       ", bhow0070().commarea().dadosEntrada().nJourBbnEsn());
        log(TraceLevel.Trace, "A-APLICACAO          ", bhow0070().commarea().dadosEntrada().aAplicacao());
        log(TraceLevel.Trace, "Z-PROCESSAMENTO      ", bhow0070().commarea().dadosEntrada().zProcessamento());
        log(TraceLevel.Trace, "TS-CENTRAL           ", bhow0070().commarea().dadosEntrada().tsCentral());
        log(TraceLevel.Trace, "C-TIPO-OPET-BPOR     ", bhow0070().commarea().dadosEntrada().cTipoOpetBpor());
        log(TraceLevel.Trace, "C-TCMD               ", bhow0070().commarea().dadosEntrada().cTcmd());
        log(TraceLevel.Trace, "C-TCMC               ", bhow0070().commarea().dadosEntrada().cTcmc());
        log(TraceLevel.Trace, "C-BASE-ICDC-OPE      ", bhow0070().commarea().dadosEntrada().cBaseIcdcOpe());
        log(TraceLevel.Trace, "A-APL-INSZ-JOUR(1)   ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).aAplInszJour());
        log(TraceLevel.Trace, "C-OPCZ-MENU(1)       ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpczMenu());
        log(TraceLevel.Trace, "C-OPE-BBN(1)         ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpeBbn());
        log(TraceLevel.Trace, "C-FAMI-PROD(1)       ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cFamiProd());
        log(TraceLevel.Trace, "C-PRODUTO(1)         ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cProduto());
        log(TraceLevel.Trace, "C-PAIS-ISOA-OE-(1) ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest());
        log(TraceLevel.Trace, "C-MNEM-EGC-DEST(1)   ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest());
        log(TraceLevel.Trace, "C-OE-EGC-DEST(1)     ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest());
        log(TraceLevel.Trace, "C-SECT-ITTL-BPOR(1)  ", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cSectIttlBpor());
        log(TraceLevel.Trace, "A-APL-INSZ-JOUR(2)   ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).aAplInszJour());
        log(TraceLevel.Trace, "C-OPCZ-MENU(2)       ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpczMenu());
        log(TraceLevel.Trace, "C-OPE-BBN(2)         ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn());
        log(TraceLevel.Trace, "C-FAMI-PROD(2)       ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cFamiProd());
        log(TraceLevel.Trace, "C-PRODUTO(2)         ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cProduto());
        log(TraceLevel.Trace, "C-PAIS-ISOA-OE-(2) ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest());
        log(TraceLevel.Trace, "-MNEM-EGC-DEST(2)     ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest());
        log(TraceLevel.Trace, "C-OE-EGC-DEST(2)      ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOeEgcDest());
        log(TraceLevel.Trace, "C-SECT-ITTL-BPOR(2)   ", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cSectIttlBpor());
        log(TraceLevel.Trace, "C-EVENTO              ", bhow0070().commarea().dadosEntrada().cEvento());
        log(TraceLevel.Trace, "C-SUB-EVENTO          ", bhow0070().commarea().dadosEntrada().cSubEvento());
        log(TraceLevel.Trace, "Z-CTLZ-JOUR-BBN       ", bhow0070().commarea().dadosEntrada().zCtlzJourBbn());
        log(TraceLevel.Trace, "M-MOVIMENTO           ", bhow0070().commarea().dadosEntrada().mMovimento());
        log(TraceLevel.Trace, "C-MOED-ISO-ALFN       ", bhow0070().commarea().dadosEntrada().cMoedIsoAlfn());
        log(TraceLevel.Trace, "C-PAIS-ISO-ATC        ", bhow0070().commarea().dadosEntrada().cPaisIsoAtc());
        log(TraceLevel.Trace, "C-BANC-MOV-CTPT       ", bhow0070().commarea().dadosEntrada().cBancMovCtpt());
        log(TraceLevel.Trace, "N-IPC                 ", bhow0070().commarea().dadosEntrada().nIpc());
        log(TraceLevel.Trace, "N-IPC-2               ", bhow0070().commarea().dadosEntrada().nIpc2());
        log(TraceLevel.Trace, "N-IPC-NUM             ", bhow0070().commarea().dadosEntrada().nIpc2().nIpcNum());
        log(TraceLevel.Trace, "SW-I-CTA-ESTRANG      ", bhow0070().commarea().dadosEntrada().swICtaEstrang());
        log(TraceLevel.Trace, "SW-OBRIG-COE-INPUT    ", bhow0070().commarea().dadosEntrada().obrigCoeInput());
        log(TraceLevel.Trace, "*********************************************");
        log(TraceLevel.Trace, "***     DISPLAY DE AREA DE COES - FIM    ****");
        log(TraceLevel.Trace, "*********************************************");
    }
    
    /**
     * 
     * ESTA GERACAO DE COE ESTA DIVIDIDA EM DUAS PARTES
     * DEB CONTA CLIENTE / CAIXA -> CRE CONTA NOSTRO / VOSTRO
     * DEB CONTA NOSTRO / VOSTRO -> CRE CONTA CLIENTE / CAIXA
     * 
     */
    protected void bhop0070CoeDupla() {
        bhop0070ObtemMovimento() ;
        bhow0070().commarea().dadosEntrada().identContAux().set(bhow0070().commarea().dadosEntrada().identContCre());
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            bhop0070CreNosvos() ;
        }
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            bhop0070CoeSimples() ;
        }
        bhow0070().commarea().dadosEntrada().identContCre().set(bhow0070().commarea().dadosEntrada().identContAux());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).set(bhow0070().commarea().dadosEntrada().acessIcbAux());
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            bhop0070DebNosvos() ;
        }
        if (bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            bhop0070CoeSimples() ;
        }
    }
    
    /**
     * 
     * VAI BUSCAR DADOS DA OPERACAO PARA SABER QUE CONTAS NOSTRO
     * E VOSTRO E SEUS DADOS FORAM MOVIMENTADAS
     * 
     */
    protected void bhop0070ObtemMovimento() {
        bhvl152a().commarea().initialize() ;
        bhvl152a().commarea().dadosInput().cPaisIsoaOpex().set(bhtl001a().commarea().mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhvl152a().commarea().dadosInput().cBancOpex().set(bhtl001a().commarea().mensagem().headerR().cBanco());
        if (bhtl001a().commarea().mensagem().headerR().nrElectronico().cPaisIsoaOeOpx().isEqual(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre())) {
            bhvl152a().commarea().dadosInput().cPaisIsoaDst().set(bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
            bhvl152a().commarea().dadosInput().cBancDest().set(bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
            bhvl152a().commarea().dadosInput().iDbcr().set(bhok0002().BHOK0002_CON_DEBITO);
        } else {
            bhvl152a().commarea().dadosInput().cPaisIsoaDst().set(bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
            bhvl152a().commarea().dadosInput().cBancDest().set(bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
            bhvl152a().commarea().dadosInput().iDbcr().set(bhok0002().BHOK0002_CON_CREDITO);
        }
        bhvl152a().commarea().dadosInput().cMoedIsoOpex().set(bhvl100a().commarea().areaInput().areaDadosBase().cMoedIsoScta());
        bhvl152a().commarea().dadosInput().cFineOpelCont().set(bhok0002().cFineMovIntEmpr());
        bhvl152a().commarea().dadosInput().zPrctJourBbn().set(bhvl100a().commarea().areaInput().areaArquitectura().datasProcesso().zPrctJourBbn());
        bhvp0152CoeInterEmprsa() ;
        if (!bhvl152a().commarea().areaErro().semErros().isTrue()) {
            bhow0070().commarea().dadosOutput().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            bhow0070().commarea().dadosOutput().msgErrob().set(bhvl152a().commarea().areaErro().msgErrob());
            bhow0070().commarea().dadosOutput().chAcesso().set(bhvl152a().commarea().areaErro().chAcesso());
            bhow0070().commarea().dadosOutput().nmTabela().set(bhvl152a().commarea().areaErro().nmTabela());
            bhow0070().commarea().dadosOutput().cSqlcode().set(bhvl152a().commarea().areaErro().cSqlcode());
            bhow0070().commarea().dadosOutput().aAplErr().set(bhvl152a().commarea().areaErro().aAplErr());
            bhow0070().commarea().dadosOutput().cRtnoEvenSwal().set(bhvl152a().commarea().areaErro().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhop0070CreNosvos() {
        bhow0070().commarea().dadosEntrada().opetBporAux().set(bhow0070().commarea().dadosEntrada().cTipoOpetBpor());
        if (bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDebS().isTrue()) {
            bhow0070().commarea().dadosEntrada().cTipoOpetBpor().set(52);
        } else {
            bhow0070().commarea().dadosEntrada().cTipoOpetBpor().set(66);
        }
        bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().set(bhvl152a().commarea().areaOutput().get(1).cPaisIsoaCont());
        bhow0070().commarea().dadosEntrada().identContCre().cBancContCre().set(bhvl152a().commarea().areaOutput().get(1).cBancCont());
        bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre().set(bhvl152a().commarea().areaOutput().get(1).cOeEgcCont());
        bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre().set(bhvl152a().commarea().areaOutput().get(1).nsRdclCont());
        bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre().set(bhvl152a().commarea().areaOutput().get(1).vChkdCont());
        bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre().set(bhvl152a().commarea().areaOutput().get(1).cTipoCont());
        bhow0070().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre().set(bhvl152a().commarea().areaOutput().get(1).cMoedIsoScta());
        bhow0070().commarea().dadosEntrada().identContCre().nsDepositoCre().set(bhvl152a().commarea().areaOutput().get(1).nsDeposito());
        bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCre().set(bhvl152a().commarea().areaOutput().get(1).iGrazCoe());
        bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre().set(bhvl152a().commarea().areaOutput().get(1).cMnemEmpGcx());
        bhow0070().commarea().dadosEntrada().identContCre().cSectIttlBporCre().set(bhvl152a().commarea().areaOutput().get(1).cSectIttlBpor());
        bhow0070().commarea().dadosEntrada().identContCre().cSectIttlAux1Cre().set(bhvl152a().commarea().areaOutput().get(1).cSectIttlBpor());
        bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().set(bhvl152a().commarea().areaOutput().get(1).iClszTtr1Cont());
        bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre().set(bhvl152a().commarea().areaOutput().get(1).iEmpsNomeIdvl());
        bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre().set(bhvl152a().commarea().areaOutput().get(1).cTipoTrttCont());
        bhow0070().commarea().dadosEntrada().acessIcbAux().set(bhow0070().commarea().dadosEntrada().acessIcb().get(2));
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cFamiProd().set(bhvl152a().commarea().areaOutput().get(1).cFamiProd());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).aAplInszJour().set(bhvl152a().commarea().areaOutput().get(1).aAplInszJour());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cProduto().set(bhvl152a().commarea().areaOutput().get(1).cProduto());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpczMenu().set(bhvl152a().commarea().areaOutput().get(1).cOpczMenu());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn().set(bhvl152a().commarea().areaOutput().get(1).cOpeBbn());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest().set(bhvl152a().commarea().areaOutput().get(1).cPaisIsoaCont());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest().set(bhvl152a().commarea().areaOutput().get(1).cMnemEmpGcx());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOeEgcDest().set(bhvl152a().commarea().areaOutput().get(1).cOeEgcCont());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cSectIttlBpor().set(bhvl152a().commarea().areaOutput().get(1).cSectIttlBpor());
    }
    
    /**
     * 
     * 
     */
    protected void bhop0070DebNosvos() {
        bhow0070().commarea().dadosEntrada().cTipoOpetBpor().set(bhow0070().commarea().dadosEntrada().opetBporAux());
        bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().set(bhvl152a().commarea().areaOutput().get(2).cPaisIsoaCont());
        bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb().set(bhvl152a().commarea().areaOutput().get(2).cBancCont());
        bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb().set(bhvl152a().commarea().areaOutput().get(2).cOeEgcCont());
        bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb().set(bhvl152a().commarea().areaOutput().get(2).nsRdclCont());
        bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb().set(bhvl152a().commarea().areaOutput().get(2).vChkdCont());
        bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb().set(bhvl152a().commarea().areaOutput().get(2).cTipoCont());
        bhow0070().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb().set(bhvl152a().commarea().areaOutput().get(2).cMoedIsoScta());
        bhow0070().commarea().dadosEntrada().identContDeb().nsDepositoDeb().set(bhvl152a().commarea().areaOutput().get(2).nsDeposito());
        bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDeb().set(bhvl152a().commarea().areaOutput().get(2).iGrazCoe());
        bhow0070().commarea().dadosEntrada().identContDeb().cMnemEmpGcxDeb().set(bhvl152a().commarea().areaOutput().get(2).cMnemEmpGcx());
        bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlBporDeb().set(bhvl152a().commarea().areaOutput().get(2).cSectIttlBpor());
        bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlAux1Deb().set(bhvl152a().commarea().areaOutput().get(2).cSectIttlBpor());
        bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().set(bhvl152a().commarea().areaOutput().get(2).iClszTtr1Cont());
        bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb().set(bhvl152a().commarea().areaOutput().get(2).iEmpsNomeIdvl());
        bhow0070().commarea().dadosEntrada().identContDeb().cTipoTrttContDeb().set(bhvl152a().commarea().areaOutput().get(2).cTipoTrttCont());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cFamiProd().set(bhvl152a().commarea().areaOutput().get(2).cFamiProd());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).aAplInszJour().set(bhvl152a().commarea().areaOutput().get(2).aAplInszJour());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cProduto().set(bhvl152a().commarea().areaOutput().get(2).cProduto());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpczMenu().set(bhvl152a().commarea().areaOutput().get(2).cOpczMenu());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpeBbn().set(bhvl152a().commarea().areaOutput().get(2).cOpeBbn());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest().set(bhvl152a().commarea().areaOutput().get(2).cPaisIsoaCont());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest().set(bhvl152a().commarea().areaOutput().get(2).cMnemEmpGcx());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest().set(bhvl152a().commarea().areaOutput().get(2).cOeEgcCont());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cSectIttlBpor().set(bhvl152a().commarea().areaOutput().get(2).cSectIttlBpor());
    }
    
    /**
     * 
     * BHRP0500 - ACEDE A ROTINA MHRJ500A
     * 
     */
    protected void bhrp0500AcedeMhrj500a() {
        hrMhrj500a().run() ;
    }
    
    /**
     * 
     * BHVP0152 - COPY DE CAHAMA A ROTINA DE MOVIMENTACAO
     * INTER-EMPRESA  MHVJ150A
     * 
     */
    protected void bhvp0152CoeInterEmprsa() {
        hrMhvj152a().run() ;
    }
    
    /**
     * 
     * BHJP5014-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * COMPLEMENTARES DO CLIENTE (MHJJ014A)
     * 
     */
    protected void bhjp5014AcedeMhjj014a() {
        hrMhjj014a().run() ;
    }
    
    /**
     * 
     * ROTINA DE GERACAO AUTOMATICA COE'S
     * 
     */
    protected void bhqp5100RotinaCoes() {
        hrMhqj100a().run() ;
    }
    
    /**
     * 
     * BHJP5031-ACESSO AO MODULO DE OBTENCAO DOS DOCUMENTOS
     * DE IDENTIFICACAO DO CLIENTE (MHJJ031A)
     * 
     */
    protected void bhjp5031AcedeMhjj031a() {
        hrMhjj031a().run() ;
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
        /**
         * SO VAMOS VALIDAR MOVIMENTOS SEPA  DO LUXEMBURGO
         */
        if (bhor1771().registo().aAplicacao().isEqual(CON_SEPA) && 
            bhor1771().registo().cPaisIsoaOeOpx().isEqual("LU") && 
            bhor1771().registo().cMnemEgcOpex().isEqual("CLU") && 
            (bhor1771().registo().cFamiProd().isEqual("400") || 
            bhor1771().registo().cFamiProd().isEqual("402") || 
            bhor1771().registo().cFamiProd().isEqual("352"))) {
            m2100ValidaConta() ;
            m2100AcederMhrj500a() ;
            m2200GeraCoe() ;
        }
        m1540ReadFwk001() ;
    }
    
    /**
     * 
     * 2100-VALIDA-CONTA
     * 
     */
    protected void m2100ValidaConta() {
        bhow0002().areaComum().dadosInput().cPaisIsoaCont().set(bhor1771().registo().subconta().cPaisIsoaCont());
        bhow0002().areaComum().dadosInput().cBancCont().set(bhor1771().registo().subconta().cBancCont());
        bhow0002().areaComum().dadosInput().cOeEgcCont().set(bhor1771().registo().subconta().cOeEgcCont());
        bhow0002().areaComum().dadosInput().nsRdclCont().set(bhor1771().registo().subconta().nsRdclCont());
        bhow0002().areaComum().dadosInput().vChkdCont().set(bhor1771().registo().subconta().vChkdCont());
        bhow0002().areaComum().dadosInput().cTipoCont().set(bhor1771().registo().subconta().cTipoCont());
        bhop0002ValConta() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("BHOP0070");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhow0002().areaComum().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhow0002().areaComum().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhow0002().areaComum().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhow0002().areaComum().dadosOutput().semErros().isTrue()) {
            if (bhow0002().areaComum().dadosOutput().abendDb2().isTrue()) {
                bhtw0030().dadosEntrada().cSqlcode().set(bhow0002().areaComum().dadosOutput().cSqlcode());
                bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0002().areaComum().dadosOutput().modOrigemErro());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhow0002().areaComum().dadosOutput().msgErrob());
                bhtw0030().dadosEntrada().nmTabela().set(bhow0002().areaComum().dadosOutput().nmTabela());
                bhtw0030().dadosEntrada().xCteuChavTab().set(bhow0002().areaComum().dadosOutput().chAcesso());
                bhtw0030().dadosEntrada().xCteuAlig().set(bhow0002().areaComum().dadosInput());
                bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0002().areaComum().dadosOutput().cTipoErroBbn());
                bhtw0030().dadosEntrada().abend().setTrue() ;
                m9900Abend() ;
            }
        }
    }
    
    /**
     * 
     * ***                  2100-ACEDER-MHRJ500A                      ***
     * 
     */
    protected void m2100AcederMhrj500a() {
        bhrl500a().commarea().initialize() ;
        wsVariaveis().wsInd().set(0);
        /**
         * *BRUNO CAMPOS 05-02-2013                                          
         * MOVE SPACES             TO BHRL500A-TIPO-OPERACAO
         */
        bhrl500a().commarea().dadosInput().tipoOperacao().set("D");
        /**
         * *BRUNO CAMPOS 05-02-2013                                          
         */
        bhrl500a().commarea().dadosInput().iDbcr().set(bhor1771().registo().iDbcr());
        bhrl500a().commarea().dadosInput().zProcessamento().set(bhor1771().registo().zProcessamento());
        bhrl500a().commarea().dadosInput().cPaisIsoaOpx().set(bhor1771().registo().cPaisIsoaOeOpx());
        bhrl500a().commarea().dadosInput().cMnemEgcOpex().set(bhor1771().registo().cMnemEgcOpex());
        /**
         * MOVE BHOR1771-C-OE-EGC-OPEX
         */
        bhrl500a().commarea().dadosInput().cOeEgcOpex().set(bhrk0002().iTipoFmon().cOeGerxLr());
        bhrl500a().commarea().dadosInput().cUserid().set(bhor1771().registo().cUserid());
        bhrl500a().commarea().dadosInput().nJourBbn().set(bhor1771().registo().nJourBbn());
        bhrl500a().commarea().dadosInput().qOccursIn().set(0);
        bhrl500a().commarea().dadosInput().chaveCont().cPaisIsoaTrfcCh().set(" ");
        bhrl500a().commarea().dadosInput().chaveCont().cBancTrfcCh().set(0);
        bhrl500a().commarea().dadosInput().chaveCont().zaOrdTrfcCh().set(0);
        bhrl500a().commarea().dadosInput().chaveCont().nsOrdTrfcCh().set(0);
        bhrl500a().commarea().dadosInput().chaveCont().zProcessamentoCh().set(" ");
        bhrl500a().commarea().dadosInput().chaveCont().nsIstzDstnTrfcCh().set(0);
        bhrl500a().commarea().dadosInput().qOccursIn().set(1);
        log(TraceLevel.Trace, "*-------------------------------------------------*");
        log(TraceLevel.Trace, "               BHRL500A-DADOS-INPUT                ");
        log(TraceLevel.Trace, "*-------------------------------------------------*");
        log(TraceLevel.Trace, "WS-I-DBCR         : ", bhrl500a().commarea().dadosInput().iDbcr());
        log(TraceLevel.Trace, "WS-Z-PROCESSAMENTO: ", bhrl500a().commarea().dadosInput().zProcessamento());
        log(TraceLevel.Trace, "WS-C-PAIS-ISOA-OPX: ", bhrl500a().commarea().dadosInput().cPaisIsoaOpx());
        log(TraceLevel.Trace, "WS-C-MNEM-EGC-OPEX: ", bhrl500a().commarea().dadosInput().cMnemEgcOpex());
        log(TraceLevel.Trace, "WS-C-OE-EGC-OPEX  : ", bhrl500a().commarea().dadosInput().cOeEgcOpex());
        log(TraceLevel.Trace, "WS-C-USERID       : ", bhrl500a().commarea().dadosInput().cUserid());
        log(TraceLevel.Trace, "WS-N-JOUR-BBN     : ", bhrl500a().commarea().dadosInput().nJourBbn());
        log(TraceLevel.Trace, "WS-TIPO-OPERACAO  : ", bhrl500a().commarea().dadosInput().tipoOperacao());
        log(TraceLevel.Trace, "WS-Q-OCCURS-IN    : ", bhrl500a().commarea().dadosInput().qOccursIn());
        log(TraceLevel.Trace, "WS-CHAVE-CONT-IN  : ", bhrl500a().commarea().dadosInput().chaveCont());
        log(TraceLevel.Trace, "*-------------------------------------------------*");
        bhrp0500AcedeMhrj500a() ;
        log(TraceLevel.Trace, "               BHRL500A-DADOS-OUTPUT               ");
        log(TraceLevel.Trace, "*-------------------------------------------------*");
        log(TraceLevel.Trace, "C-SQLCODE         : ", bhrl500a().commarea().dadosErro().cSqlcode());
        log(TraceLevel.Trace, "A-APL-ERR         : ", bhrl500a().commarea().dadosErro().aAplErr());
        log(TraceLevel.Trace, "NM-TABELA         : ", bhrl500a().commarea().dadosErro().nmTabela());
        log(TraceLevel.Trace, "C-RTNO-EVEN-SWAL  : ", bhrl500a().commarea().dadosErro().cRtnoEvenSwal());
        log(TraceLevel.Trace, "MSG-ERROB         : ", bhrl500a().commarea().dadosErro().msgErrob());
        log(TraceLevel.Trace, "MOD-ORIGEM-ERRO   : ", bhrl500a().commarea().dadosErro().modOrigemErro());
        log(TraceLevel.Trace, "CH-ACESSO         : ", bhrl500a().commarea().dadosErro().chAcesso());
        log(TraceLevel.Trace, "*-------------------------------------------------*");
        log(TraceLevel.Trace, "I-FCHO-CPSZ-URGT  : ", bhrl500a().commarea().dadosOutput().iFchoCpszUrgt());
        log(TraceLevel.Trace, "C-SERV-SIBS-TEI   : ", bhrl500a().commarea().dadosOutput().cServSibsTei());
        log(TraceLevel.Trace, "D-SERV-SIBS-TEI   : ", bhrl500a().commarea().dadosOutput().dServSibsTei());
        log(TraceLevel.Trace, "C-OPE-SIBS        : ", bhrl500a().commarea().dadosOutput().cOpeSibs());
        log(TraceLevel.Trace, "D-OPE-SIBS        : ", bhrl500a().commarea().dadosOutput().dOpeSibs());
        log(TraceLevel.Trace, "I-SEPA            : ", bhrl500a().commarea().dadosOutput().iSepa());
        log(TraceLevel.Trace, "C-IBAN-ORDN       : ", bhrl500a().commarea().dadosOutput().cIbanOrdn());
        log(TraceLevel.Trace, "C-MOED-CONT-ORDN  : ", bhrl500a().commarea().dadosOutput().cMoedContOrdn());
        log(TraceLevel.Trace, "NM-ORDN           : ", bhrl500a().commarea().dadosOutput().nmOrdn());
        log(TraceLevel.Trace, "M-MOV-ORD-TRFC    : ", bhrl500a().commarea().dadosOutput().mMovOrdTrfc());
        log(TraceLevel.Trace, "Q-TRFC-DSTN       : ", bhrl500a().commarea().dadosOutput().qTrfcDstn());
        log(TraceLevel.Trace, "I-TRFC-DSTN-EXCED : ", bhrl500a().commarea().dadosOutput().iTrfcDstnExced());
        log(TraceLevel.Trace, "WS-CHAVE-CONT-OUT : ", bhrl500a().commarea().dadosOutput().chaveContOut());
        while (!wsVariaveis().wsInd().isEqual(bhrl500a().commarea().dadosOutput().qTrfcDstn())) {
            wsVariaveis().wsInd().add(1);
            log(TraceLevel.Trace, "WS-IND            : ", wsVariaveis().wsInd());
            log(TraceLevel.Trace, "C-IBAN-DSTN       : ", bhrl500a().commarea().dadosOutput().tabDstnTrfc().get(wsVariaveis().wsInd()).cIbanDstn());
            log(TraceLevel.Trace, "C-MOED-CONT-DSTN  : ", bhrl500a().commarea().dadosOutput().tabDstnTrfc().get(wsVariaveis().wsInd()).cMoedContDstn());
            log(TraceLevel.Trace, "NM-DSTN           : ", bhrl500a().commarea().dadosOutput().tabDstnTrfc().get(wsVariaveis().wsInd()).nmDstn());
            log(TraceLevel.Trace, "M-MOV-ORD-DSTN    : ", bhrl500a().commarea().dadosOutput().tabDstnTrfc().get(wsVariaveis().wsInd()).mMovOrdDstn());
            log(TraceLevel.Trace, "X-REF-MOV-ORN-SIBS: ", bhrl500a().commarea().dadosOutput().tabDstnTrfc().get(wsVariaveis().wsInd()).xRefMovOrnSibs());
            log(TraceLevel.Trace, "*-------------------------------------------------*");
        }
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("BHOP0070");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhrl500a().commarea().dadosErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhrl500a().commarea().dadosErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhrl500a().commarea().dadosErro().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhrl500a().commarea().dadosErro().semErros().isTrue()) {
            if (bhrl500a().commarea().dadosErro().abendDb2().isTrue()) {
                bhtw0030().dadosEntrada().cSqlcode().set(bhrl500a().commarea().dadosErro().cSqlcode());
                bhtw0030().dadosEntrada().nmPrgChmd().set(bhrl500a().commarea().dadosErro().modOrigemErro());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhrl500a().commarea().dadosErro().msgErrob());
                bhtw0030().dadosEntrada().nmTabela().set(bhrl500a().commarea().dadosErro().nmTabela());
                bhtw0030().dadosEntrada().xCteuChavTab().set(bhrl500a().commarea().dadosErro().chAcesso());
                bhtw0030().dadosEntrada().xCteuAlig().set(bhrl500a().commarea().dadosInput());
                bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhrl500a().commarea().dadosErro().cTipoErroBbn());
                bhtw0030().dadosEntrada().abend().setTrue() ;
                m9900Abend() ;
            }
        }
    }
    
    /**
     * 
     * 2200-GERA-COE
     * 
     */
    protected void m2200GeraCoe() {
        bhow0070().commarea().initialize() ;
        bhjl031a().commarea().initialize() ;
        bhjl014a().commarea().initialize() ;
        bhql100a().commarea().initialize() ;
        bhow0070().commarea().dadosEntrada().swIEstornoNao().setTrue() ;
        bhow0070().commarea().dadosEntrada().swIOfflineSim().setTrue() ;
        bhow0070().commarea().dadosEntrada().swIGeraCoeRedz().setTrue() ;
        bhow0070().commarea().dadosEntrada().swISimulzNao().setTrue() ;
        bhow0070().commarea().dadosEntrada().swIBatch().setTrue() ;
        /**
         * PREENCHER CONTA DEBITO/CREDITO
         */
        if (bhor1771().registo().iDbcr().isEqual("C")) {
            bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCre().set("S");
            bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().set(bhor1771().registo().subconta().cPaisIsoaCont());
            bhow0070().commarea().dadosEntrada().identContCre().cBancContCre().set(bhor1771().registo().subconta().cBancCont());
            bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre().set(bhor1771().registo().subconta().cOeEgcCont());
            bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre().set(bhor1771().registo().subconta().nsRdclCont());
            bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre().set(bhor1771().registo().subconta().vChkdCont());
            bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre().set(bhor1771().registo().subconta().cTipoCont());
            bhow0070().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre().set(bhor1771().registo().subconta().cMoedIsoScta());
            bhow0070().commarea().dadosEntrada().identContCre().nsDepositoCre().set(bhor1771().registo().subconta().nsDeposito());
            bhow0070().commarea().dadosEntrada().identContCre().cSectIttlBporCre().set(bhor1771().registo().cSectIttlBpor());
            bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().set(hv00101Contas().contas().iClszTtr1Cont());
            bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre().set(hv00101Contas().contas().iEmpsNomeIdvl());
            bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre().set(hv00101Contas().contas().cTipoTrttCont());
            bhow0070().commarea().dadosEntrada().identContCre().cMnemEmpGcxCre().set(bhor1771().registo().cMnemEgcOpex());
            bhow0070().commarea().dadosEntrada().cTcmd().set(bhqk0002().cTipoContaBdp().cNostro());
            bhow0070().commarea().dadosEntrada().identContCre().nsMovCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().nsMovDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().cTipoTrttContDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb().set(0);
            bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb().set(0);
            bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb().set(0);
            bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb().set(0);
            bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb().set(0);
            bhow0070().commarea().dadosEntrada().identContDeb().nsDepositoDeb().set(0);
            bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlBporDeb().set(0);
        }
        if (bhor1771().registo().iDbcr().isEqual("D")) {
            bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDeb().set("S");
            bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb().set(bhor1771().registo().subconta().cPaisIsoaCont());
            bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb().set(bhor1771().registo().subconta().cBancCont());
            bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb().set(bhor1771().registo().subconta().cOeEgcCont());
            bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb().set(bhor1771().registo().subconta().nsRdclCont());
            bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb().set(bhor1771().registo().subconta().vChkdCont());
            bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb().set(bhor1771().registo().subconta().cTipoCont());
            bhow0070().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb().set(bhor1771().registo().subconta().cMoedIsoScta());
            bhow0070().commarea().dadosEntrada().identContDeb().nsDepositoDeb().set(bhor1771().registo().subconta().nsDeposito());
            bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlBporDeb().set(bhor1771().registo().cSectIttlBpor());
            bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb().set(hv00101Contas().contas().iClszTtr1Cont());
            bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb().set(hv00101Contas().contas().iEmpsNomeIdvl());
            bhow0070().commarea().dadosEntrada().identContDeb().cTipoTrttContDeb().set(hv00101Contas().contas().cTipoTrttCont());
            bhow0070().commarea().dadosEntrada().identContDeb().cMnemEmpGcxDeb().set(bhor1771().registo().cMnemEgcOpex());
            bhow0070().commarea().dadosEntrada().identContDeb().nsMovDeb().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().nsMovCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre().set(" ");
            bhow0070().commarea().dadosEntrada().identContCre().cBancContCre().set(0);
            bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre().set(0);
            bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre().set(0);
            bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre().set(0);
            bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre().set(0);
            bhow0070().commarea().dadosEntrada().identContCre().nsDepositoCre().set(0);
            bhow0070().commarea().dadosEntrada().identContCre().cSectIttlBporCre().set(0);
        }
        bhow0070().commarea().dadosEntrada().cBancoOpex().set(bhor1771().registo().cBancGcxGerx());
        bhtl001a().commarea().mensagem().headerR().cBanco().set(bhor1771().registo().cBancGcxGerx());
        bhow0070().commarea().dadosEntrada().aAplicacao().set(bhor1771().registo().aAplicacao());
        bhow0070().commarea().dadosEntrada().tsCentral().set(bhor1771().registo().tsActzUlt());
        bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhor1771().registo().cPaisIsoaOeOpx());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().cPaisIsoaOeOpx().set(bhor1771().registo().cPaisIsoaOeOpx());
        bhow0070().commarea().dadosEntrada().cMnemEgcOpex().set(bhor1771().registo().cMnemEgcOpex());
        bhow0070().commarea().dadosEntrada().cOeEgc().set(bhor1771().registo().cOeEgcOpex());
        bhow0070().commarea().dadosEntrada().cUserid().set(bhor1771().registo().cUserid());
        bhow0070().commarea().dadosEntrada().zProcessamento().set(bhor1771().registo().zContabilizacao());
        bhow0070().commarea().dadosEntrada().nJourBbn().set(bhor1771().registo().nJourBbn());
        bhow0070().commarea().dadosEntrada().cBaseIcdcOpe().set(" ");
        bhow0070().commarea().dadosEntrada().zCtlzJourBbn().set(bhor1771().registo().zMovimento());
        bhow0070().commarea().dadosEntrada().mMovimento().set(bhor1771().registo().mMovimento());
        bhow0070().commarea().dadosEntrada().cMoedIsoAlfn().set(bhor1771().registo().subconta().cMoedIsoScta());
        bhow0070().commarea().dadosEntrada().cEvento().set(bhor1771().registo().cEvenOpel());
        /**
         * MOVE BHOR1771-C-PAIS-ISOA-CONT TO BHOW0070-C-PAIS-ISO-ATC.
         */
        if (bhor1771().registo().iDbcr().isEqual("C")) {
            bhow0070().commarea().dadosEntrada().cPaisIsoAtc().set(bhrl500a().commarea().dadosOutput().cIbanOrdn().get(1, 2));
        } else {
            bhow0070().commarea().dadosEntrada().cPaisIsoAtc().set(bhrl500a().commarea().dadosOutput().tabDstnTrfc().get(1).cIbanDstn().get(1, 2));
        }
        /**
         * VALIDA SE EH UMA COMISSAO DE UMA TRANSFERENCIA
         */
        swStatus().swCOpeBbn().set(bhor1771().registo().cOpeBbn());
        if (swStatus().swCOpeBbnValido().isTrue()) {
            bhow0070().commarea().dadosEntrada().cTipoOpetBpor().set(352);
        } else {
            bhow0070().commarea().dadosEntrada().cTipoOpetBpor().set(0);
        }
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).aAplInszJour().set("HV");
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpczMenu().set(bhor1771().registo().cOpczMenu());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpeBbn().set(bhor1771().registo().cOpeBbn());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cFamiProd().set(bhor1771().registo().cFamiProd());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cProduto().set(bhor1771().registo().cProduto());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest().set(bhor1771().registo().cOeEgcGerx());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cSectIttlBpor().set(bhor1771().registo().cSectIttlBpor());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest().set(bhor1771().registo().cPaisIsoaGerx());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest().set(bhor1771().registo().cPaisIsoaGerx());
        bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest().set(bhor1771().registo().cMnemEgcOpex());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest().set(bhor1771().registo().cMnemEgcOpex());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).aAplInszJour().set("HV");
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpczMenu().set(bhor1771().registo().cOpczMenu());
        if (bhor1771().registo().iDbcr().isEqual("C")) {
            bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn().set("HR877");
        } else {
            bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn().set("HR878");
        }
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cFamiProd().set("410");
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cProduto().set("L01");
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest().set(bhor1771().registo().cMnemEgcOpex());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOeEgcDest().set(bhor1771().registo().cOeEgcGerx());
        bhow0070().commarea().dadosEntrada().acessIcb().get(2).cSectIttlBpor().set(2111000);
        if (bhor1771().registo().iDbcr().isEqual("D")) {
            bhow0070().commarea().dadosEntrada().cTcmc().set(bhqk0002().cTipoContaBdp().cNostro());
            if (bhor1771().registo().cSectIttlBpor().isLess(2000000)) {
                bhow0070().commarea().dadosEntrada().cTcmd().set(bhqk0002().cTipoContaBdp().cResidente());
            } else {
                bhow0070().commarea().dadosEntrada().cTcmd().set(bhqk0002().cTipoContaBdp().cNaoResidente());
            }
        } else {
            if (bhor1771().registo().cSectIttlBpor().isLess(2000000)) {
                bhow0070().commarea().dadosEntrada().cTcmc().set(bhqk0002().cTipoContaBdp().cResidente());
            } else {
                bhow0070().commarea().dadosEntrada().cTcmc().set(bhqk0002().cTipoContaBdp().cNaoResidente());
            }
            bhow0070().commarea().dadosEntrada().cTcmd().set(bhqk0002().cTipoContaBdp().cNostro());
        }
        bhop0070ObtemCoe() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("BHOP0070");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhow0070().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhow0070().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhow0070().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhow0070().commarea().dadosOutput().semErros().isTrue()) {
            log(TraceLevel.Error, " ----------------- INPUT -------------------");
            log(TraceLevel.Error, "BHOW0070-C-TRANSACCAO-ARQ       :", bhow0070().commarea().dadosEntrada().cTransaccaoArq());
            log(TraceLevel.Error, "BHOW0070-C-TRANSACCAO-PGM       :", bhow0070().commarea().dadosEntrada().cTransaccaoPgm());
            log(TraceLevel.Error, "BHOW0070-SW-I-ESTORNO           :", bhow0070().commarea().dadosEntrada().swIEstorno());
            log(TraceLevel.Error, "BHOW0070-SW-I-SIMULZ            :", bhow0070().commarea().dadosEntrada().swISimulz());
            log(TraceLevel.Error, "BHOW0070-SW-I-OFFLINE           :", bhow0070().commarea().dadosEntrada().swIOffline());
            log(TraceLevel.Error, "BHOW0070-I-GRAZ-COE-CRE         :", bhow0070().commarea().dadosEntrada().identContCre().iGrazCoeCre());
            log(TraceLevel.Error, "BHOW0070-C-PAIS-ISOA-CONT-CRE   :", bhow0070().commarea().dadosEntrada().identContCre().cPaisIsoaContCre());
            log(TraceLevel.Error, "BHOW0070-C-BANC-CONT-CRE        :", bhow0070().commarea().dadosEntrada().identContCre().cBancContCre());
            log(TraceLevel.Error, "BHOW0070-C-OE-EGC-CONT-CRE      :", bhow0070().commarea().dadosEntrada().identContCre().cOeEgcContCre());
            log(TraceLevel.Error, "BHOW0070-NS-RDCL-CONT-CRE       :", bhow0070().commarea().dadosEntrada().identContCre().nsRdclContCre());
            log(TraceLevel.Error, "BHOW0070-V-CHKD-CONT-CRE        :", bhow0070().commarea().dadosEntrada().identContCre().vChkdContCre());
            log(TraceLevel.Error, "BHOW0070-C-TIPO-CONT-CRE        :", bhow0070().commarea().dadosEntrada().identContCre().cTipoContCre());
            log(TraceLevel.Error, "BHOW0070-C-MOED-ISO-SCTA-CRE    :", bhow0070().commarea().dadosEntrada().identContCre().cMoedIsoSctaCre());
            log(TraceLevel.Error, "BHOW0070-NS-DEPOSITO-CRE        :", bhow0070().commarea().dadosEntrada().identContCre().nsDepositoCre());
            log(TraceLevel.Error, "BHOW0070-C-SECT-ITTL-BPOR-CRE   :", bhow0070().commarea().dadosEntrada().identContCre().cSectIttlBporCre());
            log(TraceLevel.Error, "BHOW0070-I-CLSZ-TTR1-CONT-CRE   :", bhow0070().commarea().dadosEntrada().identContCre().iClszTtr1ContCre());
            log(TraceLevel.Error, "BHOW0070-I-EMPS-NOME-IDVL-CRE   :", bhow0070().commarea().dadosEntrada().identContCre().iEmpsNomeIdvlCre());
            log(TraceLevel.Error, "BHOW0070-C-TIPO-TRTT-CONT-CRE   :", bhow0070().commarea().dadosEntrada().identContCre().cTipoTrttContCre());
            log(TraceLevel.Error, "BHOW0070-NS-MOV-CRE             :", bhow0070().commarea().dadosEntrada().identContCre().nsMovCre());
            log(TraceLevel.Error, "BHOW0070-C-PAIS-ISOA-CONT-DEB   :", bhow0070().commarea().dadosEntrada().identContDeb().cPaisIsoaContDeb());
            log(TraceLevel.Error, "BHOW0070-C-MOED-ISO-SCTA-DEB    :", bhow0070().commarea().dadosEntrada().identContDeb().cMoedIsoSctaDeb());
            log(TraceLevel.Error, "BHOW0070-NS-MOV-DEB             :", bhow0070().commarea().dadosEntrada().identContDeb().nsMovDeb());
            log(TraceLevel.Error, "BHOW0070-I-GRAZ-COE-DEB         :", bhow0070().commarea().dadosEntrada().identContDeb().iGrazCoeDeb());
            log(TraceLevel.Error, "BHOW0070-I-CLSZ-TTR1-CONT-DEB   :", bhow0070().commarea().dadosEntrada().identContDeb().iClszTtr1ContDeb());
            log(TraceLevel.Error, "BHOW0070-I-EMPS-NOME-IDVL-DEB   :", bhow0070().commarea().dadosEntrada().identContDeb().iEmpsNomeIdvlDeb());
            log(TraceLevel.Error, "BHOW0070-C-TIPO-TRTT-CONT-DEB   :", bhow0070().commarea().dadosEntrada().identContDeb().cTipoTrttContDeb());
            log(TraceLevel.Error, "BHOW0070-C-BANC-CONT-DEB        :", bhow0070().commarea().dadosEntrada().identContDeb().cBancContDeb());
            log(TraceLevel.Error, "BHOW0070-C-OE-EGC-CONT-DEB      :", bhow0070().commarea().dadosEntrada().identContDeb().cOeEgcContDeb());
            log(TraceLevel.Error, "BHOW0070-NS-RDCL-CONT-DEB       :", bhow0070().commarea().dadosEntrada().identContDeb().nsRdclContDeb());
            log(TraceLevel.Error, "BHOW0070-V-CHKD-CONT-DEB        :", bhow0070().commarea().dadosEntrada().identContDeb().vChkdContDeb());
            log(TraceLevel.Error, "BHOW0070-C-TIPO-CONT-DEB        :", bhow0070().commarea().dadosEntrada().identContDeb().cTipoContDeb());
            log(TraceLevel.Error, "BHOW0070-NS-DEPOSITO-DEB        :", bhow0070().commarea().dadosEntrada().identContDeb().nsDepositoDeb());
            log(TraceLevel.Error, "BHOW0070-C-SECT-ITTL-BPOR-DEB   :", bhow0070().commarea().dadosEntrada().identContDeb().cSectIttlBporDeb());
            log(TraceLevel.Error, "BHOW0070-C-BANCO-OPEX           :", bhow0070().commarea().dadosEntrada().cBancoOpex());
            log(TraceLevel.Error, "BHOW0070-A-APLICACAO            :", bhow0070().commarea().dadosEntrada().aAplicacao());
            log(TraceLevel.Error, "BHOW0070-TS-CENTRAL             :", bhow0070().commarea().dadosEntrada().tsCentral());
            log(TraceLevel.Error, "BHOW0070-C-PAIS-ISOA-OE-OPX     :", bhow0070().commarea().dadosEntrada().cPaisIsoaOeOpx());
            log(TraceLevel.Error, "BHOW0070-C-MNEM-EGC-OPEX        :", bhow0070().commarea().dadosEntrada().cMnemEgcOpex());
            log(TraceLevel.Error, "BHOW0070-C-OE-EGC               :", bhow0070().commarea().dadosEntrada().cOeEgc());
            log(TraceLevel.Error, "BHOW0070-C-USERID               :", bhow0070().commarea().dadosEntrada().cUserid());
            log(TraceLevel.Error, "BHOW0070-Z-PROCESSAMENTO        :", bhow0070().commarea().dadosEntrada().zProcessamento());
            log(TraceLevel.Error, "BHOW0070-N-JOUR-BBN             :", bhow0070().commarea().dadosEntrada().nJourBbn());
            log(TraceLevel.Error, "BHOW0070-C-BASE-ICDC-OPE        :", bhow0070().commarea().dadosEntrada().cBaseIcdcOpe());
            log(TraceLevel.Error, "BHOW0070-Z-CTLZ-JOUR-BBN        :", bhow0070().commarea().dadosEntrada().zCtlzJourBbn());
            log(TraceLevel.Error, "BHOW0070-M-MOVIMENTO            :", bhow0070().commarea().dadosEntrada().mMovimento());
            log(TraceLevel.Error, "BHOW0070-C-MOED-ISO-ALFN        :", bhow0070().commarea().dadosEntrada().cMoedIsoAlfn());
            log(TraceLevel.Error, "BHOW0070-C-EVENTO               :", bhow0070().commarea().dadosEntrada().cEvento());
            log(TraceLevel.Error, "BHOW0070-C-PAIS-ISO-ATC         :", bhow0070().commarea().dadosEntrada().cPaisIsoAtc());
            log(TraceLevel.Error, "BHOW0070-C-TIPO-OPET-BPOR       :", bhow0070().commarea().dadosEntrada().cTipoOpetBpor());
            log(TraceLevel.Error, "BHOW0070-C-TCMC                 :", bhow0070().commarea().dadosEntrada().cTcmc());
            log(TraceLevel.Error, "BHOW0070-C-TCMD                 :", bhow0070().commarea().dadosEntrada().cTcmd());
            log(TraceLevel.Error, "BHOW0070-A-APL-INSZ-JOUR(1)     :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).aAplInszJour());
            log(TraceLevel.Error, "BHOW0070-C-OPCZ-MENU(1)         :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpczMenu());
            log(TraceLevel.Error, "BHOW0070-C-OPE-BBN(1)           :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOpeBbn());
            log(TraceLevel.Error, "BHOW0070-C-FAMI-PROD(1)         :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cFamiProd());
            log(TraceLevel.Error, "BHOW0070-C-PRODUTO(1).          :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cProduto());
            log(TraceLevel.Error, "BHOW0070-C-PAIS-ISOA-OE-DEST(1) :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cPaisIsoaOeDest());
            log(TraceLevel.Error, "BHOW0070-C-MNEM-EGC-DEST(1)     :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cMnemEgcDest());
            log(TraceLevel.Error, "BHOW0070-C-OE-EGC-DEST(1)       :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cOeEgcDest());
            log(TraceLevel.Error, "BHOW0070-C-SECT-ITTL-BPOR(1)    :", bhow0070().commarea().dadosEntrada().acessIcb().get(1).cSectIttlBpor());
            log(TraceLevel.Error, "BHOW0070-A-APL-INSZ-JOUR(2)     :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).aAplInszJour());
            log(TraceLevel.Error, "BHOW0070-C-OPCZ-MENU(2)         :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpczMenu());
            log(TraceLevel.Error, "BHOW0070-C-OPE-BBN(2)           :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOpeBbn());
            log(TraceLevel.Error, "BHOW0070-C-FAMI-PROD(2)         :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cFamiProd());
            log(TraceLevel.Error, "BHOW0070-C-PRODUTO(2)           :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cProduto());
            log(TraceLevel.Error, "BHOW0070-C-PAIS-ISOA-OE-DEST(2) :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cPaisIsoaOeDest());
            log(TraceLevel.Error, "BHOW0070-C-MNEM-EGC-DEST(2)     :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cMnemEgcDest());
            log(TraceLevel.Error, "BHOW0070-C-OE-EGC-DEST(2)       :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cOeEgcDest());
            log(TraceLevel.Error, "BHOW0070-C-SECT-ITTL-BPOR(2)    :", bhow0070().commarea().dadosEntrada().acessIcb().get(2).cSectIttlBpor());
            log(TraceLevel.Error, "BHOW0013-NM-TABELA       :", bhow0013().dadosInput().dadosTabela().nmTabela());
            log(TraceLevel.Error, "BHOW0013-A-APL-ERR       :", bhow0013().dadosInput().dadosRotinas().aAplErr());
            log(TraceLevel.Error, "BHOW0013-C-TIPO-ERRO-BBN :", bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            log(TraceLevel.Error, "BHOW0013-C-SQLCODE       :", bhow0013().dadosInput().dadosTabela().cSqlcode());
            log(TraceLevel.Error, "BHOW0013-C-RTNO-EVEN-SWAL:", bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal());
            if (bhow0070().commarea().dadosOutput().abendDb2().isTrue()) {
                bhtw0030().dadosEntrada().cSqlcode().set(bhow0070().commarea().dadosOutput().cSqlcode());
                bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0070().commarea().dadosOutput().modOrigemErro());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhow0070().commarea().dadosOutput().msgErrob());
                bhtw0030().dadosEntrada().nmTabela().set(bhow0070().commarea().dadosOutput().nmTabela());
                bhtw0030().dadosEntrada().xCteuChavTab().set(bhow0070().commarea().dadosOutput().chAcesso());
                bhtw0030().dadosEntrada().xCteuAlig().set(bhow0070().commarea().dadosEntrada());
                bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0070().commarea().dadosOutput().cTipoErroBbn());
                bhtw0030().dadosEntrada().abend().setTrue() ;
                m9900Abend() ;
            }
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
     * 3200-ESCREVE-ESTAT
     * 
     */
    protected void m3200EscreveEstat() {
        log(TraceLevel.Debug, "3200-ESCREVE-ESTAT");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
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
        
        
        @Data(size=5)
        IString swCOpeBbn() ;
        @Data
        @Condition({ "HR307", "HR396", "HR331", "HR418", "HR346", "HR422", "HR335", "HR420" })
        ICondition swCOpeBbnValido() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=1, value=" ")
        IString wsSysin() ;
        
        @Data(size=15, value="0")
        ILong wsLidosFwk001() ;
        
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
        
        @Data(size=4, value="0")
        IInt wsInd() ;
        
        @Data(size=5, value="0")
        IInt wsIndTabMax() ;
        
        /**
         * @return instancia da classe local TabMovFich
         */
        @Data(length=9999)
        IArray<TabMovFich> tabMovFich() ;
        
        @Data(size=4, signed=true, compression=COMP)
        IInt wsIndNull() ;
        
        
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
