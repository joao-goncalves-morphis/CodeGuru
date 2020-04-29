package cgd.gh.online;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseOnline ;
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
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1190 ;
import cgd.gh.structures.messages.Bghm1191 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hh.structures.link.Bhhl070a ;
import cgd.hy.structures.work.Bhyw0001 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.gh.common.constants.Bghk0005 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.structures.work.Bhtw0009 ;
import cgd.hy.routines.Mhyj230a ;
import cgd.gh.online.Pghs191a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS194A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1921
 * FUNCAO     : MANUTENCAO (MODO ELIMINACAO) DOS MOVIMENTOS
 * MARCADOS COMO EXTENSAO DA GARANTIA DE DEPOSITO
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES:
 * LOG DE ALTERACOES
 * PROC.GIP !   DATA   !UTILIZ.! OBSERVACOES
 * GH1921  !2016-03-14!ACT0264! CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs194a extends CgdGhBaseOnline<Pghs194a.EnvelopeIn, Pghs194a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1190
     */
    public abstract Bghm1190 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1191
     */
    public abstract Bghm1191 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1190.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1191.Msg msgOut() ;
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
     * @return instancia da classe Vwsdghps20001Movexgdep
     */
    @Data
    protected abstract Vwsdghps20001Movexgdep hv20001Movexgdep() ;
    
    /**
     * @return instancia da classe Vwsdghps20101Titexgdep
     */
    @Data
    protected abstract Vwsdghps20101Titexgdep hv20101Titexgdep() ;
    
    
    /**
     * Handled Services
     */
    /**
     * @return instancia da classe Pghs191a
     */
    protected abstract Pghs191a hoPghs191a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhhl070a
     */
    @Data
    protected abstract Bhhl070a bhhl070a() ;
    
    /**
     * @return instancia da classe Bhyw0001
     */
    @Data
    protected abstract Bhyw0001 bhyw0001() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bghk0005
     */
    @Data
    protected abstract Bghk0005 bghk0005() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhtw0009
     */
    @Data
    protected abstract Bhtw0009 bhtw0009() ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHS194A" ;
    
    protected static final String CON_PROGRAMA_CONSULTA = "PGHS191A" ;
    
    protected static final String CON_APLICACAO_GH = "GH" ;
    
    protected static final String CON_APLICACAO_HO = "HO" ;
    
    protected static final String CON_ESTADO_CANCELADO = "C" ;
    
    protected static final String CON_ESTADO_ATIVO = "A" ;
    
    protected static final int CON_1N = 1 ;
    
    /**
     * DB2
     */
    protected static final String CON_VGH20001 = "VGH20001" ;
    
    protected static final String CON_VGH20101 = "VGH20101" ;
    
    /**
     * TABELA INTERNAS
     * *N/A
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * SWITCHS
     * @return instancia da classe local SwSwitchs
     */
    @Data
    protected abstract SwSwitchs swSwitchs() ;
    
    
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
    }
    
    /**
     * 
     * . MOVE NOME DO PROGRAMA A EXECUTAR PARA BHTW0009-PGMID
     * . MOVE NR. SEQ. DE OPERACAO <> 00  PARA
     * BHTW0009-SEQUENCIA-OPER
     * . MOVE MSG A PROCESSAR PARA BHTW0009-MSG-SUB-FUNCAO
     * . MOVE LENGTH DA MSG A PROCESSAR PARA
     * BHTW0009-LENFTH-SUB-FUNCAO
     * . MOVE NR.CAMPOS DA MSG A PROCESSAR
     * BHTW0009-NR-CAMPOS-SUB-FUNCAO
     * == OBTEM ==
     * . NA BHTL001A - SQLCA E ERROS POSSIVEIS
     * . CICS LOG
     * BHTP0007
     * LINK A PROGRAMA DE FUNCAO A PARTIR DE
     * PROGRAMA DE FUNCAO BASE
     * EX. DP (CONSTITUI DEPOSITO A PRAZO)
     * LINK (PROGRAMA DEB DE DO PASSANDO COMMAREA)
     * 
     */
    protected void bhtp0007NovaFuncao() {
        bhtw0009().commarea().set(envelope);
        bhtw0009().commarea().header3().aAplOrig().set(message.mensagem().headerR().transaccao().aAplicacao());
        bhtw0009().commarea().header3().cOpczMenuOrig().set(message.mensagem().headerR().transaccao().cOpczMenu());
        bhtw0009().commarea().header3().nsJourBbnOut().set(0);
        bhtw0009().commarea().mensagem().headerR().cTransaccao().aAplicacao().set(bhtw0009().camposControlo().aAplicacaoSfun());
        bhtw0009().commarea().mensagem().headerR().cTransaccao().cOpczMenu().set(bhtw0009().camposControlo().cOpczMenuSfun());
        bhtw0009().commarea().journal().nsJourBbn().set(bhtw0009().camposControlo().nsJourBbnSfun());
        bhtw0009().commarea().mensagem().qCterCmptAlig().set(bhtw0009().camposControlo().qCterCmptAligSfun());
        bhtw0009().commarea().mensagem().qCampEstTrnz().set(bhtw0009().camposControlo().qCampEstTrnzSfun());
        bhtw0009().commarea().mensagem().xMsgBbn().set(bhtw0009().camposControlo().xMsgBbnSfun());
        bhtw0009().commarea().iCexiApl().set(envOut.iCexiApl());
        bhtw0009().commarea().cTrnzProx().set(envOut.cTrnzProx());
        bhtw0009().commarea().controlo().iTipoOrigTrnz().set(envIn.controlo().iTipoOrigTrnz());
        bhtw0009().commarea().cImgTabJour().set(envOut.cImgTabJour());
        bhtw0009().commarea().iTabJourMov().set(envOut.iTabJourMov());
        envOut.header3().nsJourBbnOut().set(bhtw0009().commarea().journal().nsJourBbn());
        envOut.db2Log().set(bhtw0009().commarea().db2Log());
        envOut.autorizacoesNiv().set(bhtw0009().commarea().autorizacoesNiv());
        envOut.cicsLog().set(bhtw0009().commarea().cicsLog());
        envOut.errosGraves().set(bhtw0009().commarea().errosGraves());
    }
    
    /**
     * 
     * 
     */
    protected void bhtp0007ErroFuncao() {
        envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendCics());
        envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
        envOut.cicsLog().cEibfn().set("EIBFN");
        envOut.cicsLog().cEibrcode().set("EIBRCODE");
        envOut.cicsLog().cEibrsrce().set("EIBRSRCE");
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "********** INICIO DO PROGRAMA ****************");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
        log(TraceLevel.Debug, "* * * * * * * * * * * * * * * * * * * * * * * *");
        log(TraceLevel.Debug, " BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Debug, "* * * * * * * * * * * * * * * * * * * * * * * *");
        log(TraceLevel.Debug, "***********************************************");
        log(TraceLevel.Debug, " OCORRENCIAS DE INPUT -----> ", msgIn().indice());
        log(TraceLevel.Debug, "***********************************************");
        wsVariaveis().initialize() ;
        hv20001Movexgdep().movexgdep().initialize() ;
        hv20101Titexgdep().titexgdep().initialize() ;
        msgOut().msg().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().set(msgIn().msg().ade());
        msgOut().indice().set(CON_1N);
        while (msgOut().indice().isLessOrEqual(msgOut().indiceInverso())) {
            msgOut().msg().ade().linha().get(msgOut().indice()).iAcczMntzLstaL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iTitcExsGarL().set("0");
            msgOut().msg().ade().linha().get(msgOut().indice()).nsItvtL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).iTipoItvtL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(0);
            msgOut().indice().add(CON_1N);
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        /**
         * *CASO EXISTA ALGUM MOVIMENTO MARCADO COMO CANCELADO
         * *(C_EST_EXTS_GAR_DEP = C), ELIMINA O MESMO (DELETE A TGH00200).
         */
        m2100DeleteThg200() ;
        /**
         * *UPADATE A TGH00200 PARA C_EST_EXTS_GAR_DEP = C
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            m2200UpdateThg200() ;
        }
        /**
         * *FAZER O DELETE DOS REGISTOS (PELA CHAVE) À TGH00201
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            m2300DeleteThg201() ;
        }
    }
    
    /**
     * 
     * 2100-DELETE-THG200
     * 
     */
    protected void m2100DeleteThg200() {
        log(TraceLevel.Debug, "2100-DELETE-THG200");
        hv20001Movexgdep().movexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20001Movexgdep().movexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20001Movexgdep().movexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20001Movexgdep().movexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20001Movexgdep().movexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20001Movexgdep().movexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20001Movexgdep().movexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20001Movexgdep().movexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20001Movexgdep().movexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hv20001Movexgdep().movexgdep().cEstExtsGarDep().set(CON_ESTADO_CANCELADO);
        log(TraceLevel.Debug, " --- CHAVE TGH00200 --- ");
        log(TraceLevel.Debug, " . VGH20001-C-PAIS-ISOA-CONT       :", hv20001Movexgdep().movexgdep().cPaisIsoaCont());
        log(TraceLevel.Debug, " . VGH20001-C-BANC-CONT            :", hv20001Movexgdep().movexgdep().cBancCont());
        log(TraceLevel.Debug, " . VGH20001-C-OE-EGC-CONT          :", hv20001Movexgdep().movexgdep().cOeEgcCont());
        log(TraceLevel.Debug, " . VGH20001-NS-RDCL-CONT           :", hv20001Movexgdep().movexgdep().nsRdclCont());
        log(TraceLevel.Debug, " . VGH20001-V-CHKD-CONT            :", hv20001Movexgdep().movexgdep().vChkdCont());
        log(TraceLevel.Debug, " . VGH20001-C-TIPO-CONT            :", hv20001Movexgdep().movexgdep().cTipoCont());
        log(TraceLevel.Debug, " . VGH20001-C-MOED-ISO-SCTA        :", hv20001Movexgdep().movexgdep().cMoedIsoScta());
        log(TraceLevel.Debug, " . VGH20001-NS-DEPOSITO            :", hv20001Movexgdep().movexgdep().nsDeposito());
        log(TraceLevel.Debug, " . VGH20001-NS-MOVIMENTO           :", hv20001Movexgdep().movexgdep().nsMovimento());
        log(TraceLevel.Debug, " . VGH20001-C-EST-EXTS-GAR-DEP     :", hv20001Movexgdep().movexgdep().cEstExtsGarDep());
        /**
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().deletePghs194a300() ;
        swSwitchs().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20001Movexgdep().getPersistenceCode());
        log(TraceLevel.Debug, " --- SQLCODE >>>>>>>>>>>> ", hv20001Movexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20001Ok().isTrue() && !swSwitchs().swVgh20001Notfnd().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
        }
    }
    
    /**
     * 
     * 2200-UPDATE-THG200
     * 
     */
    protected void m2200UpdateThg200() {
        log(TraceLevel.Debug, "2200-UPDATE-THG200");
        hv20001Movexgdep().movexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20001Movexgdep().movexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20001Movexgdep().movexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20001Movexgdep().movexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20001Movexgdep().movexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20001Movexgdep().movexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20001Movexgdep().movexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20001Movexgdep().movexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20001Movexgdep().movexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hv20001Movexgdep().movexgdep().cEstExtsGarDep().set(CON_ESTADO_CANCELADO);
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().updatePghs194a356() ;
        swSwitchs().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20001Movexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        log(TraceLevel.Debug, " >>> SQLCODE >>>>>>>>>> ", hv20001Movexgdep().getPersistenceCode());
        if (!swSwitchs().swVgh20001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
        }
    }
    
    /**
     * 
     * 2300-DELETE-THG201
     * 
     */
    protected void m2300DeleteThg201() {
        log(TraceLevel.Debug, "2300-DELETE-THG201");
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH20101_TITEXGDEP
         */
        hv20101Titexgdep().deletePghs194a411() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20101);
            envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, " 3000-FIM-PROGRAMA");
        /**
         * -- DEVOLVE FIM DE CONSULTA, NAO MOSTRA MAIS REGISTOS DA LISTA
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            envOut.errosGraves().fimConsulta().setTrue() ;
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
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
     * TABELA INTERNAS
     * *N/A
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(format="999-", value="0")
        IFormattedString wsSqlcodeErro() ;
        
    }
    
    /**
     * 
     * SWITCHS
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitchs extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20001() ;
        @Data
        @Condition("0")
        ICondition swVgh20001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh20001Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20101() ;
        @Data
        @Condition("0")
        ICondition swVgh20101Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh20101Notfnd() ;
        
        
    }
    
}
