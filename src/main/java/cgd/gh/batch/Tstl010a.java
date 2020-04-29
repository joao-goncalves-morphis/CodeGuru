package cgd.gh.batch;

import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.ht.structures.link.Bhtl010a ;


/**
 * 
 * W O R K I N G   S T O R A G E
 * PROGRAMA: DADOSTST
 * FUNCAO  : LER DADOS DE TESTE, MAPEA-LOS PARA O HEADER1/2 E ESCRE
 * E N V I R O N M E N T   D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Tstl010a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    @Handler(name="ENTRAV2", record="reg()")
    @Data
    protected abstract Entrav2 entrav2() ;
    
    @Handler(name="SAIDA", record="reg()")
    @Data
    protected abstract Saida saida() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    @Data
    protected abstract Bhtl010a bhtl010a() ;
    
    @Data
    protected abstract WorkArea workArea() ;
    
    
    
    /**
     * 
     * ROTINA INICIAL
     * 
     */
    protected void inicializa() {
        workArea().initialize() ;
    }
    
    /**
     * 
     * ROTINA PARA ABERTURA DO ARQUIVO
     * 
     */
    protected void abertura() {
        entrav2().open() ;
        saida().open() ;
        if (!entrav2().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL010A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA ABERTURA DO ENTRADA              **");
            log(TraceLevel.Error, "** STATUS      : ", entrav2().getStatus());
            log(TraceLevel.Error, "** ABERTURA");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
        if (!saida().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL010A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA ABERTURA DO SAIDA                 **");
            log(TraceLevel.Error, "** STATUS      : ", saida().getStatus());
            log(TraceLevel.Error, "** ABERTURA");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
    }
    
    /**
     * 
     * ROTINA DE LEITURA DO ENTRADA
     * 
     */
    protected void leitura() {
        entrav2().read() ;
        if (!entrav2().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL010A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** LEITURA DE ENTRADA                       **");
            log(TraceLevel.Error, "** STATUS ENTRADA = ", entrav2().getStatus());
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
    }
    
    /**
     * 
     * ROTINA PARA ESCRITA DO ARQUIVO SAIDA
     * 
     */
    protected void escrita() {
        saida().write(saida().reg()) ;
        if (!saida().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL010A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA LEITURA  DO SAIDA               **");
            log(TraceLevel.Error, "** STATUS      : ", saida().getStatus());
            log(TraceLevel.Error, "** ESCRITA ");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
    }
    
    /**
     * 
     * ROTINA DE PROCESSAMENTO
     * 
     */
    protected void processamento() {
        workArea().acLidos().add(1);
        bhtl010a().commarea().initialize() ;
        saida().reg().initialize() ;
        /**
         * **** Mapeamentos HEADERS
         */
        bhtl010a().commarea().mensagem().nEltnJourBbn().zProcessamento().set(entrav2().reg().zProcessamento());
        bhtl010a().commarea().mensagem().nEltnJourBbn().cPaisIsoaOeOpx().set(entrav2().reg().cPaisIsoaOeOpx());
        bhtl010a().commarea().mensagem().nEltnJourBbn().cMnemEgcOpex().set(entrav2().reg().cMnemEgcOpex());
        bhtl010a().commarea().mensagem().nEltnJourBbn().cOeEgcOpex().set(entrav2().reg().cOeEgcOpex());
        bhtl010a().commarea().mensagem().nEltnJourBbn().cUserid().set(entrav2().reg().cUserid());
        bhtl010a().commarea().mensagem().nEltnJourBbn().nJourBbn().set(entrav2().reg().nJourBbn());
        bhtl010a().commarea().nsJourBbn().set(entrav2().reg().nsJourBbn());
        bhtl010a().commarea().mensagem().cTransaccao().set(entrav2().reg().cTransaccao());
        bhtl010a().commarea().mensagem().aAplicacao().set(entrav2().reg().aAplicacao());
        bhtl010a().commarea().mensagem().cOpePcnp().set(entrav2().reg().cOpePcnp());
        bhtl010a().commarea().mensagem().xChavOpePcnp().set(entrav2().reg().xChavOpePcnp());
        bhtl010a().commarea().mensagem().cTipoCanlAces().set(entrav2().reg().cTipoCanlAces());
        bhtl010a().commarea().mensagem().cTermPcnp().set(entrav2().reg().cTermPcnp());
        bhtl010a().commarea().mensagem().nSessTermPcnp().set(entrav2().reg().nSessTermPcnp());
        bhtl010a().commarea().mensagem().tsTrnzLocl().set(entrav2().reg().tsTrnzLocl());
        bhtl010a().commarea().mensagem().tsInicPrctCtrl().set(entrav2().reg().tsInicPrctCtrl());
        bhtl010a().commarea().mensagem().tsFimPrctCtrl().set(entrav2().reg().tsFimPrctCtrl());
        bhtl010a().commarea().mensagem().iTrnzEfcdOnln().set(entrav2().reg().iTrnzEfcdOnln());
        bhtl010a().commarea().mensagem().iAccao().set(entrav2().reg().iAccao());
        bhtl010a().commarea().mensagem().iCslzTrnz().set(entrav2().reg().iCslzTrnz());
        bhtl010a().commarea().mensagem().cEstPrctReg().set(entrav2().reg().cEstPrctReg());
        bhtl010a().commarea().mensagem().cTipSteOpePcnp().set(entrav2().reg().cTipSteOpePcnp());
        bhtl010a().commarea().mensagem().xIdSpteOpePcnp().set(entrav2().reg().xIdSpteOpePcnp());
        bhtl010a().commarea().mensagem().cPaisIsoaCont().set(entrav2().reg().cPaisIsoaCont());
        bhtl010a().commarea().mensagem().cBancCont().set(entrav2().reg().cBancCont());
        bhtl010a().commarea().mensagem().cOeEgcCont().set(entrav2().reg().cOeEgcCont());
        bhtl010a().commarea().mensagem().nsRdclCont().set(entrav2().reg().nsRdclCont());
        bhtl010a().commarea().mensagem().vChkdCont().set(entrav2().reg().vChkdCont());
        bhtl010a().commarea().mensagem().cTipoCont().set(entrav2().reg().cTipoCont());
        bhtl010a().commarea().mensagem().cMoedIsoScta().set(entrav2().reg().cMoedIsoScta());
        bhtl010a().commarea().mensagem().nsDeposito().set(entrav2().reg().nsDeposito());
        bhtl010a().commarea().mensagem().cBancSwif().set(entrav2().reg().cBancSwif());
        bhtl010a().commarea().mensagem().mSldoCblo().set(entrav2().reg().mSldoCblo());
        bhtl010a().commarea().mensagem().mSldoDpnl().set(entrav2().reg().mSldoDpnl());
        bhtl010a().commarea().mensagem().mSldoAtrd().set(entrav2().reg().mSldoAtrd());
        bhtl010a().commarea().mensagem().zMovimento().set(entrav2().reg().zMovimento());
        bhtl010a().commarea().mensagem().zValor().set(entrav2().reg().zValor());
        bhtl010a().commarea().mensagem().zCtlzJourBbn().set(entrav2().reg().zCtlzJourBbn());
        bhtl010a().commarea().mensagem().cMoedIsoMov().set(entrav2().reg().cMoedIsoMov());
        bhtl010a().commarea().mensagem().mMovimento().set(entrav2().reg().mMovimento());
        bhtl010a().commarea().mensagem().cOpczMenu().set(entrav2().reg().cOpczMenu());
        bhtl010a().commarea().mensagem().nCliente().set(entrav2().reg().nCliente());
        bhtl010a().commarea().mensagem().nsAbraCli().set(entrav2().reg().nsAbraCli());
        bhtl010a().commarea().mensagem().cGranCli().set(entrav2().reg().cGranCli());
        bhtl010a().commarea().mensagem().cSegmCrm().set(entrav2().reg().cSegmCrm());
        bhtl010a().commarea().mensagem().cFamiProd().set(entrav2().reg().cFamiProd());
        bhtl010a().commarea().mensagem().cProduto().set(entrav2().reg().cProduto());
        bhtl010a().commarea().mensagem().cEvenOpel().set(entrav2().reg().cEvenOpel());
        bhtl010a().commarea().mensagem().cOpeBbn().set(entrav2().reg().cOpeBbn());
        bhtl010a().commarea().mensagem().cCpltMvopIcb().set(entrav2().reg().cCpltMvopIcb());
        bhtl010a().commarea().mensagem().xIdMovCriv().set(entrav2().reg().xIdMovCriv());
        bhtl010a().commarea().mensagem().iEstorno().set(entrav2().reg().iEstorno());
        bhtl010a().commarea().mensagem().xChvOpePcnpOri().set(entrav2().reg().xChvOpePcnpOri());
        bhtl010a().commarea().mensagem().cPaisIsoaOeEsn().set(entrav2().reg().cPaisIsoaOeEsn());
        bhtl010a().commarea().mensagem().cMnemEgcEstn().set(entrav2().reg().cMnemEgcEstn());
        bhtl010a().commarea().mensagem().cOeEgcEstn().set(entrav2().reg().cOeEgcEstn());
        bhtl010a().commarea().mensagem().nJourBbnTrnEsn().set(entrav2().reg().nJourBbnTrnEsn());
        bhtl010a().commarea().mensagem().cUsidEstn().set(entrav2().reg().cUsidEstn());
        bhtl010a().commarea().mensagem().aAplErro().set(entrav2().reg().aAplErro());
        bhtl010a().commarea().mensagem().cTipoErroBbn().set(entrav2().reg().cTipoErroBbn());
        bhtl010a().commarea().mensagem().cRtnoSwal().set(entrav2().reg().cRtnoSwal());
        bhtl010a().commarea().mensagem().cLclzErroPrg().set(entrav2().reg().cLclzErroPrg());
        bhtl010a().commarea().mensagem().nmPrgErro().set(entrav2().reg().nmPrgErro());
        bhtl010a().commarea().mensagem().xInfCplrErro().set(entrav2().reg().xInfCplrErro());
        bhtl010a().commarea().mensagem().cRtnoSwalPcnp().set(entrav2().reg().cRtnoSwalPcnp());
        bhtl010a().commarea().mensagem().nsVersMsg().set(entrav2().reg().nsVersMsg());
        bhtl010a().commarea().mensagem().qCterCmpMsgInp().set(entrav2().reg().qCterCmpMsgInp());
        /**
         * **** Mapeamentos ENV INPUT
         */
        bhtl010a().commarea().mensagem().xMsgBbnIput().set(entrav2().reg().xMsgBbnIput());
        saida().reg().msgInp().set(bhtl010a().commarea());
        /**
         * **** Mapeamentos ENV OUTPUT
         */
        bhtl010a().commarea().mensagem().xMsgBbnIput().set(" ");
        bhtl010a().commarea().mensagem().xMsgBbnIput().set(entrav2().reg().xMsgBbnOutput());
        saida().reg().msgOut().set(bhtl010a().commarea());
        /**
         * **** Mapeamentos da tabela de testes
         */
        saida().reg().trans().set(entrav2().reg().cTransaccao());
        saida().reg().progName().set(entrav2().reg().prog());
        saida().reg().envVersion().set("02");
        saida().reg().zProcessamento().set(entrav2().reg().zProcessamento());
        saida().reg().cMnemEgcOpex().set(entrav2().reg().cMnemEgcOpex());
        saida().reg().cPaisIsoaOeOpx().set(entrav2().reg().cPaisIsoaOeOpx());
        saida().reg().cOeEgcOpex().set(entrav2().reg().cOeEgcOpex());
        saida().reg().cUserid().set(entrav2().reg().cUserid());
        saida().reg().nJourBbn().set(entrav2().reg().nJourBbn());
        saida().reg().aAplicacao().set(entrav2().reg().aAplicacao());
        saida().reg().cOpePcnp().set(entrav2().reg().cOpePcnp());
        saida().reg().xChavOpePcnp().set(entrav2().reg().xChavOpePcnp());
        saida().reg().toTest().set(" ");
        /**
         * **** Escreve registo saida
         */
        escrita() ;
        leitura() ;
    }
    
    /**
     * 
     * ROTINA FINAL.
     * 
     */
    protected void finaliza() {
        log(TraceLevel.Trace, workArea().acLidos(), " = REGISTROS LIDOS");
        log(TraceLevel.Trace, workArea().acGravs(), " = REGISTROS GRAVADOS");
        entrav2().close() ;
        saida().close() ;
        if (!entrav2().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL010A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA CLOSE DO ENTRADA                  **");
            log(TraceLevel.Error, "** STATUS      : ", entrav2().getStatus());
            log(TraceLevel.Error, "** FINALIZA  ");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
        if (!saida().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL010A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA CLOSE DO SAIDA                  **");
            log(TraceLevel.Error, "** STATUS      : ", saida().getStatus());
            log(TraceLevel.Error, "** FINALIZA  ");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
        log(TraceLevel.Trace, "**** TSTL010A - FIM NORMAL *****");
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        inicializa() ;
        abertura() ;
        leitura() ;
        while (!entrav2().getStatusEof()) {
            processamento() ;
        }
        finaliza() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WorkArea extends IDataStruct {
        
        @Data(size=2)
        IInt entradaStatus() ;
        
        @Data(size=2)
        IInt saidaStatus() ;
        
        @Data(size=8, signed=true)
        ILong acLidos() ;
        
        @Data(size=8, signed=true)
        ILong acGravs() ;
        
    }
    
}
