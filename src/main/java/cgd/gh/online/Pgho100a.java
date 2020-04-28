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
import cgd.gh.structures.messages.Bghm1000 ;
import cgd.gh.structures.messages.Bghm1001 ;
import cgd.gh.routines.Mghs018a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA PEDIDOS DE INFORMACAO DISPONIVEIS
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho100a extends CgdGhBaseOnline<Pgho100a.EnvelopeIn, Pgho100a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1000
     */
    public abstract Bghm1000 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1001
     */
    public abstract Bghm1001 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1000.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1001.Msg msgOut() ;
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
     * @return instancia da classe Mghs018a
     */
    @Data
    protected abstract Mghs018a hrMghs018a() ;
    
    
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
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs018a().bghl018a().initialize() ;
        hrMghs018a().bghl018a().listar().setTrue() ;
        hrMghs018a().bghl018a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        hrMghs018a().run() ;
        if (!hrMghs018a().bghl018a().ok().isTrue()) {
            progStatus.set(hrMghs018a().bghl018a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs018a().bghl018a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00018");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs018a().bghl018a().qItens().isLessOrEqual(wsLimite)) {
                wsQItens.set(hrMghs018a().bghl018a().qItens());
            } else {
                wsQItens.set(wsLimite);
                haMais.setTrue() ;
            }
            for (hrMghs018a().bghl018a().tabela().lista().setIndex(1); hrMghs018a().bghl018a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs018a().bghl018a().tabela().lista().incIndex()) {
                hrMghs018a().bghl018a().argumento().set(hrMghs018a().bghl018a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs018a().bghl018a().detalhe().set(hrMghs018a().bghl018a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grPed().getCurrent().cPedInfOpps().set(hrMghs018a().bghl018a().argumento().cPedInfOpps());
                msgOut().msg().ade().grPed().getCurrent().dPedInfOpps().set(hrMghs018a().bghl018a().detalhe().dPedInfOpps());
                msgOut().msg().ade().grPed().getCurrent().cFrmtInf().set(hrMghs018a().bghl018a().detalhe().cFrmtInf());
                msgOut().msg().ade().grPed().getCurrent().cTipoRpte().set(hrMghs018a().bghl018a().detalhe().cTipoRpte());
                msgOut().msg().ade().grPed().getCurrent().nmFichOutpRtno().set(hrMghs018a().bghl018a().detalhe().nmFichOutpRtno());
                msgOut().msg().ade().grPed().getCurrent().qDiaDpnzInf().set(hrMghs018a().bghl018a().detalhe().qDiaDpnzInf());
                msgOut().msg().ade().grPed().getCurrent().cUsidActzUlt().set(hrMghs018a().bghl018a().detalhe().cUsidActzUlt());
                msgOut().msg().ade().grPed().getCurrent().tsActzUlt().set(hrMghs018a().bghl018a().detalhe().tsActzUlt());
                msgOut().msg().ade().grPed().incIndex() ;
            }
        }
        if (progOk.isTrue()) {
            if (haMais.isTrue()) {
                msgOut().msg().ade().iMsgCtnd().set("S");
                msgOut().msg().ade().cPedInfOppsK().set(hrMghs018a().bghl018a().argumento().cPedInfOpps());
            } else {
                msgOut().msg().ade().iMsgCtnd().set("N");
                envOut.errosGraves().fimConsulta().setTrue() ;
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
            msgOut().msg().ase().cPedInfOppsSt().cPedInfOpps1().setTrue() ;
            msgOut().msg().ase().cPedInfOppsSt().cPedInfOppsM().set(progStatus);
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
