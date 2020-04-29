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
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1090 ;
import cgd.gh.structures.messages.Bghm1091 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.routines.Mghs003a ;
import cgd.ho.routines.Mhoj354a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS109A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH689
 * FUNCAO     : PROGRAMA QUE OBTEM DA TABELA DE MOVIMENTOS O NR
 * DE OCORRENCIAS QUE ESTA DEVOLVERA PARA A CONTA
 * NO PERIODO CONSIDERADO
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES:
 * LOG DE ALTERACOES
 * PROCESSO GIP !   DATA   !    UTILIZADOR    !    OBSERVACOES
 * GH689      2011-07-14   DACT610 - ACCN         CRIACAO
 * GH1159      2013-03-12   DACT701 - ACCN       ALTERACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs109a extends CgdGhBaseOnline<Pghs109a.EnvelopeIn, Pghs109a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1090
     */
    public abstract Bghm1090 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1091
     */
    public abstract Bghm1091 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1090.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1091.Msg msgOut() ;
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
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mhoj354a
     */
    @Data
    protected abstract Mhoj354a hrMhoj354a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * GH1159 - INICIO
     */
    protected static final String CON_DEBITO = "D" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    /**
     * GH1159 - FIM
     * ****              CONSTANTES ALFANUMERICAS                ****
     * ----- DB2
     */
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH02201 = "VGH02201" ;
    
    protected static final String CON_GH = "GH" ;
    
    protected static final String CON_ERR_FUNC = "FU" ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * GH1159 - FIM
     * SWITCHES
     */
    @Data(size=4, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("328")
    protected ICondition progMovJaExiste ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    /**
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
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
        hv00201Movhst().movhst().initialize() ;
        msgOut().msg().ade().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        m1100ValidaInput() ;
    }
    
    /**
     * 
     * 1100-VALIDA-INPUT
     * 
     */
    protected void m1100ValidaInput() {
        log(TraceLevel.Debug, "1100-VALIDA-INPUT");
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            !msgIn().msg().ade().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().cTipoCont().isNumeric() || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            !msgIn().msg().ade().nsDeposito().isNumeric() || 
            msgIn().msg().ade().zMovIni().isEmpty() || 
            msgIn().msg().ade().zMovFim().isEmpty() || 
            msgIn().msg().ade().zMovFim().isLess(msgIn().msg().ade().zMovIni())) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().nsRdclContSt().nsRdclCont1().setTrue() ;
            progDadosInvalidos.setTrue() ;
            msgOut().msg().ase().nsRdclContSt().nsRdclContM().set(progStatus);
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        /**
         * GH1159 - INI
         */
        m2100ConsultaGatCnsMov() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgIn().msg().ade().zMovFim().isLess(hrMghs003a().bghl003a().zHoje())) {
                m2200ObtemMovHistorico() ;
                m2300ObtemMovOntem() ;
            } else if (msgIn().msg().ade().zMovFim().isEqual(hrMghs003a().bghl003a().zHoje())) {
                m2200ObtemMovHistorico() ;
                m2300ObtemMovOntem() ;
                if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("I")) {
                    m2340ObtemMovDiaHo() ;
                }
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2500FormataOutput() ;
        }
    }
    
    /**
     * 
     * GH1159 - INI
     * 2100-CONSULTA-GAT-CNS-MOV
     * 
     */
    protected void m2100ConsultaGatCnsMov() {
        log(TraceLevel.Debug, "2100-CONSULTA-GAT-CNS-MOV");
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            progStatus.set(hrMghs003a().bghl003a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
    }
    
    /**
     * 
     * GH1159 - FIM
     * 2200-OBTEM-MOV-HISTORICO
     * 
     */
    protected void m2200ObtemMovHistorico() {
        log(TraceLevel.Debug, "2200-OBTEM-MOV-HISTORICO");
        hv00201Movhst().movhst().initialize() ;
        wsVariaveis().wsQMovTgh2().initialize() ;
        wsVariaveis().wsCrit1().initialize() ;
        wsVariaveis().wsCrit2().initialize() ;
        wsVariaveis().wsMMovMin().initialize() ;
        wsVariaveis().wsMMovMax().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        wsVariaveis().wsTsMovIni().set(msgIn().msg().ade().zMovIni());
        wsVariaveis().wsTsMovFim().set(msgIn().msg().ade().zMovFim());
        /**
         * GH1159 - INI
         */
        if (msgIn().msg().ade().ambos().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        } else if (msgIn().msg().ade().debito().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_DEBITO);
        } else {
            wsVariaveis().wsCrit1().set(CON_CREDITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        }
        if (msgIn().msg().ade().iCritMontante().mMovMin().isEqual(0) && 
            msgIn().msg().ade().iCritMontante().mMovMax().isEqual(0)) {
            wsVariaveis().wsMMovMin().set(0);
            wsVariaveis().wsMMovMax().set(999999999999999.99);
        } else {
            wsVariaveis().wsMMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
            wsVariaveis().wsMMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        }
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghs109a379(wsVariaveis().wsTsMovIni(), wsVariaveis().wsTsMovFim(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsQMovTgh2()) ;
        log(TraceLevel.Debug, "WS-Q-MOV-TGH2   :", wsVariaveis().wsQMovTgh2());
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().swVgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            } else {
                wsVariaveis().wsQMovTot().add(wsVariaveis().wsQMovTgh2());
            }
        }
    }
    
    /**
     * 
     * GH1159 - INI
     * 2300-OBTEM-MOV-ONTEM
     * 
     */
    protected void m2300ObtemMovOntem() {
        log(TraceLevel.Debug, "2300-OBTEM-MOV-ONTEM");
        if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("A")) {
            /**
             * MOVIMENTOS DO DIA D-1 ESTAO NA TGH022
             */
            m2310ObtemMovDiaAntGh() ;
        } else if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("H")) {
            /**
             * MOVIMENTOS DO DIA D-1 ESTAO NA APLICACAO HO
             */
            m2320ObtemMovDiaAntHo() ;
        }
    }
    
    /**
     * 
     * 2310-OBTEM-MOV-DIA-ANT-GH
     * 
     */
    protected void m2310ObtemMovDiaAntGh() {
        log(TraceLevel.Debug, "2310-OBTEM-MOV-DIA-ANT-GH");
        hv02201Movdiaant().movdiaant().initialize() ;
        wsVariaveis().wsQMovTgh22().initialize() ;
        wsVariaveis().wsCrit1().initialize() ;
        wsVariaveis().wsCrit2().initialize() ;
        wsVariaveis().wsMMovMin().initialize() ;
        wsVariaveis().wsMMovMax().initialize() ;
        hv02201Movdiaant().movdiaant().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv02201Movdiaant().movdiaant().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv02201Movdiaant().movdiaant().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv02201Movdiaant().movdiaant().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv02201Movdiaant().movdiaant().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv02201Movdiaant().movdiaant().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv02201Movdiaant().movdiaant().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv02201Movdiaant().movdiaant().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        wsVariaveis().wsTsMovIni().set(msgIn().msg().ade().zMovIni());
        wsVariaveis().wsTsMovFim().set(msgIn().msg().ade().zMovFim());
        if (msgIn().msg().ade().ambos().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        } else if (msgIn().msg().ade().debito().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_DEBITO);
        } else {
            wsVariaveis().wsCrit1().set(CON_CREDITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        }
        if (msgIn().msg().ade().iCritMontante().mMovMin().isEqual(0) && 
            msgIn().msg().ade().iCritMontante().mMovMax().isEqual(0)) {
            wsVariaveis().wsMMovMin().set(0);
            wsVariaveis().wsMMovMax().set(999999999999999.99);
        } else {
            wsVariaveis().wsMMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
            wsVariaveis().wsMMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        }
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectPghs109a506(wsVariaveis().wsTsMovIni(), wsVariaveis().wsTsMovFim(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsQMovTgh22()) ;
        log(TraceLevel.Debug, "WS-Q-MOV-TGH22   :", wsVariaveis().wsQMovTgh22());
        swSwitches().swSqlcodeVgh02201().set(hv02201Movdiaant().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv02201Movdiaant().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH02201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().swVgh02201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            } else {
                wsVariaveis().wsQMovTot().add(wsVariaveis().wsQMovTgh22());
            }
        }
    }
    
    /**
     * 
     * 2320-OBTEM-MOV-DIA-ANT-HO
     * 
     */
    protected void m2320ObtemMovDiaAntHo() {
        log(TraceLevel.Debug, "2320-OBTEM-MOV-DIA-ANT-HO");
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().consultaMovDia().setTrue() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set("N");
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovIni().set(msgIn().msg().ade().zMovIni());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovFim().set(msgIn().msg().ade().zMovFim());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMhoj354a().run() ;
        if (!hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue()) {
            progDadosInvalidos.setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            envOut.errosGraves().aAplErr().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            msgIn().msg().ase().nsRdclContSt().nsRdclCont1().setTrue() ;
            msgIn().msg().ase().nsRdclContSt().nsRdclContM().set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
        } else {
            wsVariaveis().wsQMovTot().add(hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
            log(TraceLevel.Debug, "BHOL354A-Q-MOV-HO:", hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
        }
    }
    
    /**
     * 
     * 2340-OBTEM-MOV-DIA-HO
     * 
     */
    protected void m2340ObtemMovDiaHo() {
        log(TraceLevel.Debug, "2340-OBTEM-MOV-DIA-HO");
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().consultaMovDia().setTrue() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovIni().set(msgIn().msg().ade().zMovIni());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovFim().set(msgIn().msg().ade().zMovFim());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMhoj354a().run() ;
        if (!hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue()) {
            progDadosInvalidos.setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            envOut.errosGraves().aAplErr().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            msgIn().msg().ase().nsRdclContSt().nsRdclCont1().setTrue() ;
            msgIn().msg().ase().nsRdclContSt().nsRdclContM().set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
        } else {
            wsVariaveis().wsQMovTot().add(hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
            log(TraceLevel.Debug, "BHOL354A-Q-MOV-HO:", hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
        }
    }
    
    /**
     * 
     * GH1159 - FIM
     * 2500-FORMATA-OUTPUT
     * 
     */
    protected void m2500FormataOutput() {
        log(TraceLevel.Debug, "2500-FORMATA-OUTPUT");
        msgOut().msg().ade().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        msgOut().msg().ade().cBancCont().set(msgIn().msg().ade().cBancCont());
        msgOut().msg().ade().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        msgOut().msg().ade().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        msgOut().msg().ade().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        msgOut().msg().ade().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        msgOut().msg().ade().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        msgOut().msg().ade().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        msgOut().msg().ade().zMovIni().set(msgIn().msg().ade().zMovIni());
        msgOut().msg().ade().zMovFim().set(msgIn().msg().ade().zMovFim());
        /**
         * GH1159 - INI
         */
        msgOut().msg().ade().qMovimentos().set(wsVariaveis().wsQMovTot());
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        message.mensagem().headerR().transaccao().anulNotrunc().setTrue() ;
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
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        /**
         * GH1159 - INICIO
         */
        @Data(size=10, signed=true, value="0", compression=COMP3)
        ILong wsQMovTgh2() ;
        
        @Data(size=10, signed=true, value="0", compression=COMP3)
        ILong wsQMovTgh22() ;
        
        /**
         * GH1159 - FIM
         */
        @Data(size=10, value="0")
        ILong wsQMovTot() ;
        
        @Data(size=10, value=" ")
        IString wsTsMovIni() ;
        
        @Data(size=10, value=" ")
        IString wsTsMovFim() ;
        
        /**
         * GH1159 - INICIO
         */
        @Data(size=1, value=" ")
        IString wsCrit1() ;
        
        @Data(size=1, value=" ")
        IString wsCrit2() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMMovMin() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMMovMax() ;
        
    }
    public interface SwSwitches extends IDataStruct {
        
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
        @Data
        @Condition("-803")
        ICondition swVgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02201() ;
        @Data
        @Condition("0")
        ICondition swVgh02201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh02201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh02201Null() ;
        
        
    }
    
}
