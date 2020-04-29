package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0550 ;
import cgd.gh.structures.messages.Bghm0551 ;
import cgd.gh.routines.Mghs007a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CRIACAO E MANUTENCAO DA INFORMACAO ADICIONAL
 * ASSOCIADA AO MOVIMENTO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho055a extends CgdGhBaseOnline<Pgho055a.EnvelopeIn, Pgho055a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0550
     */
    public abstract Bghm0550 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0551
     */
    public abstract Bghm0551 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0550.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0551.Msg msgOut() ;
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
     * @return instancia da classe Mghs007a
     */
    @Data
    protected abstract Mghs007a hrMghs007a() ;
    
    
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
    
    
    /**
     * @return instancia da classe local AreaDescritivo
     */
    @Data
    protected abstract AreaDescritivo areaDescritivo() ;
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    
    
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
    }
    
    /**
     * 
     * 
     */
    protected void s30000Validar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().tsMovimento().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().criar().isTrue() || msgIn().msg().ade().modificar().isTrue()) {
                if (msgIn().msg().ade().xInfPeslMov().isEmpty()) {
                    progDadosInvalidos.setTrue() ;
                    envOut.errosGraves().aAplErr().set(WS_APL_HST);
                    envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                }
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
        hrMghs007a().bghl007a().initialize() ;
        hrMghs007a().bghl007a().argumentoAcesso().cAcesso().set(msgIn().msg().ade().cAccao());
        hrMghs007a().bghl007a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs007a().bghl007a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs007a().bghl007a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs007a().bghl007a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs007a().bghl007a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs007a().bghl007a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs007a().bghl007a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs007a().bghl007a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs007a().bghl007a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs007a().bghl007a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        areaDescritivo().set(msgIn().msg().ade().xInfPeslMov());
        for (areaDescritivo().letra().setIndex(1); areaDescritivo().letra().index().isLessOrEqual(62); areaDescritivo().letra().incIndex()) {
            a51000TestaDescritivo() ;
        }
        hrMghs007a().bghl007a().detalhe().xInfPeslMov().set(areaDescritivo());
        hrMghs007a().bghl007a().detalhe().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        hrMghs007a().run() ;
        if (hrMghs007a().bghl007a().naoExiste().isTrue()) {
            progStatus.set(hrMghs007a().bghl007a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.db2Log().nmTabela().set("TGH00007");
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (!hrMghs007a().bghl007a().naoExiste().isTrue() && !hrMghs007a().bghl007a().ok().isTrue()) {
            progStatus.set(hrMghs007a().bghl007a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs007a().bghl007a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00007");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().consultar().isTrue()) {
                msgOut().msg().ade().xInfPeslMov().set(hrMghs007a().bghl007a().detalhe().xInfPeslMov());
                msgOut().msg().ade().tsActzUlt().set(hrMghs007a().bghl007a().detalhe().tsActzUlt());
                msgOut().msg().ade().cUsidActzUlt().set(hrMghs007a().bghl007a().detalhe().cUsidActzUlt());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000TestaDescritivo() {
        /**
         * *----------------------------------------------------------------*
         */
        if (!areaDescritivo().letraValida().get(areaDescritivo().letra().index()).isTrue()) {
            areaDescritivo().letra().getCurrent().set(" ");
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
            msgOut().msg().ase().cAccaoSt().cAccao1().setTrue() ;
            msgOut().msg().ase().cAccaoSt().cAccaoM().set(progStatus);
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
            s30000Validar() ;
        }
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface AreaDescritivo extends IDataStruct {
        
        @Data(length=62, size=1)
        IArray<IString> letra() ;
        @Data
        @Condition({ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" })
        IConditions letraValida() ;
        
        
    }
    
}
