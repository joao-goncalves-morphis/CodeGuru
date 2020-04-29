package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0590 ;
import cgd.gh.structures.messages.Bghm0591 ;
import cgd.gh.routines.Mghs016a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA OE ASSOCIADOS A DETERMINADO PEDIDO DE
 * INFORMACAO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho059a extends CgdGhBaseOnline<Pgho059a.EnvelopeIn, Pgho059a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0590
     */
    public abstract Bghm0590 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0591
     */
    public abstract Bghm0591 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0590.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0591.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs016a
     */
    @Data
    protected abstract Mghs016a hrMghs016a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=3, signed=true)
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
    @Condition("080")
    protected ICondition progNaoExisteConta ;
    @Data
    @Condition("091")
    protected ICondition progDataMinInv ;
    @Data
    @Condition("092")
    protected ICondition progDataMaxInv ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    @Data
    @Condition("211")
    protected ICondition progAcesso ;
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_FIM_CONSULTA = "FC" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH01801")
    protected IString wsNmRecurso ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsCEibresp ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtMais ;
    @Data
    @Condition("1")
    protected ICondition naoHaMais ;
    @Data
    @Condition("2")
    protected ICondition haMais ;
    
    
    @Data(size=2, value="10")
    protected IInt wsLimite ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        /**
         * *----------------------------------------------------------------*
         */
        msgIn().msg().initialize() ;
        msgOut().msg().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
        msgOut().msg().ade().grPed().resetIndex() ;
        if (msgIn().msg().ade().tsPedido().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs016a().bghl016a().initialize() ;
        hrMghs016a().bghl016a().listar().setTrue() ;
        hrMghs016a().bghl016a().argumento().tsPedido().set(msgIn().msg().ade().tsPedido());
        hrMghs016a().bghl016a().argumento().cPaisIsoaDest().set(msgIn().msg().ade().cPaisIsoaDst());
        hrMghs016a().bghl016a().argumento().cMnemEgcDest().set(msgIn().msg().ade().cMnemEgcDst());
        hrMghs016a().bghl016a().argumento().cOeEgcDest().set(msgIn().msg().ade().cOeEgcDest());
        hrMghs016a().run() ;
        if (!hrMghs016a().bghl016a().ok().isTrue()) {
            progStatus.set(hrMghs016a().bghl016a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs016a().bghl016a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00016");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs016a().bghl016a().qItens().isLessOrEqual(wsLimite)) {
                wsQItens.set(hrMghs016a().bghl016a().qItens());
            } else {
                wsQItens.set(wsLimite);
                haMais.setTrue() ;
            }
            for (hrMghs016a().bghl016a().tabela().lista().setIndex(1); hrMghs016a().bghl016a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs016a().bghl016a().tabela().lista().incIndex()) {
                hrMghs016a().bghl016a().argumento().set(hrMghs016a().bghl016a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs016a().bghl016a().detalhe().set(hrMghs016a().bghl016a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grPed().getCurrent().cPaisIsoaDst().set(hrMghs016a().bghl016a().argumento().cPaisIsoaDest());
                msgOut().msg().ade().grPed().getCurrent().cMnemEgcDst().set(hrMghs016a().bghl016a().argumento().cMnemEgcDest());
                msgOut().msg().ade().grPed().getCurrent().cOeEgcDest().set(hrMghs016a().bghl016a().argumento().cOeEgcDest());
                msgOut().msg().ade().grPed().incIndex() ;
            }
        }
        if (progOk.isTrue()) {
            if (haMais.isTrue()) {
                msgOut().msg().ade().iMsgCtnd().set("S");
                msgOut().msg().ade().cPaisIsoaDstK().set(hrMghs016a().bghl016a().argumento().cPaisIsoaDest());
                msgOut().msg().ade().cMnemEgcDstK().set(hrMghs016a().bghl016a().argumento().cMnemEgcDest());
                msgOut().msg().ade().cOeEgcDestK().set(hrMghs016a().bghl016a().argumento().cOeEgcDest());
            } else {
                msgOut().msg().ade().iMsgCtnd().set("N");
                envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
        if (!envOut.errosGraves().semErros().isTrue() && !envOut.errosGraves().fimConsulta().isTrue()) {
            msgOut().msg().ase().tsPedidoSt().tsPedido1().setTrue() ;
            msgOut().msg().ase().tsPedidoSt().tsPedidoM().set(progStatus);
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        message.mensagem().headerR().transaccao().vizualizacao().setTrue() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
}
