package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0580 ;
import cgd.gh.structures.messages.Bghm0581 ;
import cgd.gh.routines.Mghs015a ;
import cgd.gh.routines.Mghs018a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : PARAMETRIZACAO DOS SERVICOS QUE FICAM DISPONI-*
 * VEIS PARA A CRIACAO DE PEDIDOS
 * DISPONIVEL PARA DIRECCOES E 0987
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho058a extends CgdGhBaseOnline<Pgho058a.EnvelopeIn, Pgho058a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0580
     */
    public abstract Bghm0580 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0581
     */
    public abstract Bghm0581 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0580.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0581.Msg msgOut() ;
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
     * @return instancia da classe Mghs015a
     */
    @Data
    protected abstract Mghs015a hrMghs015a() ;
    
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
    @Condition("069")
    protected ICondition progFormatoInv ;
    @Data
    @Condition("068")
    protected ICondition progReportInv ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("088")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("089")
    protected ICondition progJaExiste ;
    @Data
    @Condition("079")
    protected ICondition progAutorizacao ;
    @Data
    @Condition("095")
    protected ICondition progPedidoInv ;
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
    
    @Data(size=4)
    protected IInt wsCOeGerx ;
    
    /**
     * @return instancia da classe local WsCOeGerxMask
     */
    @Data
    @Mask
    protected abstract WsCOeGerxMask wsCOeGerxMask() ;
    
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
        if (msgIn().msg().ade().criacao().isTrue() || msgIn().msg().ade().eliminacao().isTrue()) {
            wsCOeGerx.set(message.mensagem().headerR().nrElectronico().cOeEgcOpex());
            if (!wsCOeGerxMask().direccao().isTrue() && !wsCOeGerxMask().dso().isTrue()) {
                progPedidoInv.setTrue() ;
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        } else {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().criacao().isTrue()) {
                if (!msgIn().msg().ade().frmtValido().isTrue()) {
                    progFormatoInv.setTrue() ;
                    envOut.errosGraves().aAplErr().set(WS_APL_HST);
                    envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                }
                if (progOk.isTrue()) {
                    if (!msgIn().msg().ade().rpteValido().isTrue()) {
                        progReportInv.setTrue() ;
                        envOut.errosGraves().aAplErr().set(WS_APL_HST);
                        envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                    }
                }
            }
        }
        if (progOk.isTrue()) {
            if (!msgIn().msg().ade().autorizado().isTrue()) {
                progAutorizacao.setTrue() ;
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            }
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
        if (msgIn().msg().ade().eliminacao().isTrue()) {
            a51000ValidaEliminacao() ;
        }
        if (progOk.isTrue()) {
            a52000AcedePedinf() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ValidaEliminacao() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs015a().bghl015a().initialize() ;
        hrMghs015a().bghl015a().cnslPed().setTrue() ;
        hrMghs018a().bghl018a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        hrMghs015a().run() ;
        if (!hrMghs015a().bghl015a().ok().isTrue()) {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000AcedePedinf() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs018a().bghl018a().initialize() ;
        hrMghs018a().bghl018a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        if (msgIn().msg().ade().criacao().isTrue()) {
            hrMghs018a().bghl018a().inserir().setTrue() ;
            hrMghs018a().bghl018a().detalhe().dPedInfOpps().set(msgIn().msg().ade().dPedInfOpps());
            hrMghs018a().bghl018a().detalhe().cFrmtInf().set(msgIn().msg().ade().cFrmtInf());
            hrMghs018a().bghl018a().detalhe().cTipoRpte().set(msgIn().msg().ade().cTipoRpte());
            hrMghs018a().bghl018a().detalhe().nmFichOutpRtno().set(msgIn().msg().ade().nmFichOutpRtno());
            hrMghs018a().bghl018a().detalhe().qDiaDpnzInf().set(msgIn().msg().ade().qDiaDpnzInf());
            hrMghs018a().bghl018a().detalhe().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
            hrMghs018a().bghl018a().detalhe().tsActzUlt().set(message.mensagem().headerR().tsLocal());
        } else {
            hrMghs018a().bghl018a().eliminar().setTrue() ;
        }
        hrMghs018a().run() ;
        if (!hrMghs018a().bghl018a().ok().isTrue()) {
            progStatus.set(hrMghs018a().bghl018a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs018a().bghl018a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00018");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
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
        if (!envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ase().iAcco().iAccao1().setTrue() ;
            msgOut().msg().ase().iAcco().iAccaoM().set(progStatus);
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
    /**
     * Inner Classes
     */
    public interface WsCOeGerxMask extends IDataMask {
        
        @Data(size=1)
        IInt wsPrim() ;
        @Data
        @Condition("9")
        ICondition direccao() ;
        
        
        @Data(size=3)
        IInt wsResto() ;
        @Data
        @Condition("987")
        ICondition dso() ;
        
        
    }
    
}
