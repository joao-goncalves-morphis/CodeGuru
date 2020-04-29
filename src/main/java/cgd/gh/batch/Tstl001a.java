package cgd.gh.batch;

import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.ht.structures.link.Bhtl001a ;


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
public abstract class Tstl001a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    @Handler(name="ENTRAV1", record="reg()")
    @Data
    protected abstract Entrav1 entrav1() ;
    
    @Handler(name="SAIDA", record="reg()")
    @Data
    protected abstract Saida saida() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    @Data
    protected abstract Bhtl001a bhtl001a() ;
    
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
        entrav1().open() ;
        saida().open() ;
        if (!entrav1().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL001A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA ABERTURA DO ENTRADA              **");
            log(TraceLevel.Error, "** STATUS      : ", entrav1().getStatus());
            log(TraceLevel.Error, "** ABERTURA");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
        if (!saida().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL001A CANCELADO MOTIVO :      **");
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
        entrav1().read() ;
        if (!entrav1().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL001A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** LEITURA DE ENTRADA                       **");
            log(TraceLevel.Error, "** STATUS ENTRADA = ", entrav1().getStatus());
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
            log(TraceLevel.Error, "** PROGRAMA TSTL001A CANCELADO MOTIVO :      **");
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
        bhtl001a().commarea().initialize() ;
        saida().reg().initialize() ;
        /**
         * **** Mapeamentos HEADERS
         */
        bhtl001a().commarea().mensagem().headerR().cTransaccao().set(entrav1().reg().cTransaccao());
        bhtl001a().commarea().mensagem().headerR().transaccao().aAplicacao().set(entrav1().reg().aAplicacao());
        bhtl001a().commarea().mensagem().headerR().transaccao().cOpczMenu().set(entrav1().reg().cOpczMenu());
        bhtl001a().commarea().mensagem().headerR().transaccao().iAccao().set(entrav1().reg().iAccao());
        bhtl001a().commarea().mensagem().headerR().transaccao().cTipoCanlAces().set(entrav1().reg().cTipoCanlAces());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().zProcessamento().set(entrav1().reg().zProcessamento());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().cMnemEgcOpex().set(entrav1().reg().cMnemEgcOpex());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().cPaisIsoaOeOpx().set(entrav1().reg().cPaisIsoaOeOpx());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().cOeEgcOpex().set(entrav1().reg().cOeEgcOpex());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().cUserid().set(entrav1().reg().cUserid());
        bhtl001a().commarea().mensagem().headerR().nrElectronico().nJourBbn().set(entrav1().reg().nJourBbn());
        bhtl001a().commarea().mensagem().headerR().nsSessao().set(entrav1().reg().nsSessao());
        bhtl001a().commarea().mensagem().headerR().iExiAtzJourBbn().set(entrav1().reg().iExiAtzJourBbn());
        bhtl001a().commarea().mensagem().headerR().iPedDad().set(entrav1().reg().iPedDad());
        bhtl001a().commarea().mensagem().headerR().iTrnzSimz().set(entrav1().reg().iTrnzSimz());
        bhtl001a().commarea().mensagem().headerR().datasProcesso().zPrctJourBbn().set(entrav1().reg().zPrctJourBbn());
        bhtl001a().commarea().mensagem().headerR().datasProcesso().zCtlzJourBbn().set(entrav1().reg().zCtlzJourBbn());
        bhtl001a().commarea().mensagem().headerR().cTerminal().set(entrav1().reg().cTerminal());
        bhtl001a().commarea().mensagem().headerR().cUsidVrtl().set(entrav1().reg().cUsidVrtl());
        bhtl001a().commarea().mensagem().headerR().seguranca().cPaisIsoAlfn().set(entrav1().reg().cPaisIsoAlfn());
        bhtl001a().commarea().mensagem().headerR().seguranca().cMnemEgcUtl().set(entrav1().reg().cMnemEgcUtl());
        bhtl001a().commarea().mensagem().headerR().seguranca().cIdioIso().set(entrav1().reg().cIdioIso());
        bhtl001a().commarea().mensagem().headerR().seguranca().cPerfUtlBbn().set(entrav1().reg().cPerfUtlBbn());
        bhtl001a().commarea().mensagem().headerR().seguranca().iAcesContStff().set(entrav1().reg().iAcesContStff());
        bhtl001a().commarea().mensagem().headerR().seguranca().cUsidAlcl().set(entrav1().reg().cUsidAlcl());
        bhtl001a().commarea().mensagem().headerR().seguranca().ctNvlAtzBbnLcl().set(entrav1().reg().ctNvlAtzBbnLcl());
        bhtl001a().commarea().mensagem().headerR().seguranca().cUsidAcrl().set(entrav1().reg().cUsidAcrl());
        bhtl001a().commarea().mensagem().headerR().seguranca().ctNvlAtzBbnCrl().set(entrav1().reg().ctNvlAtzBbnCrl());
        bhtl001a().commarea().mensagem().headerR().seguranca().nEmpregado().set(entrav1().reg().nEmpregado());
        bhtl001a().commarea().mensagem().headerR().seguranca().iUltGerxCli().set(entrav1().reg().iUltGerxCli());
        bhtl001a().commarea().mensagem().headerR().seguranca().iUltGerxCont().set(entrav1().reg().iUltGerxCont());
        bhtl001a().commarea().mensagem().headerR().iTrnzEfcdOnln().set(entrav1().reg().iTrnzEfcdOnln());
        bhtl001a().commarea().mensagem().headerR().iEstorno().set(entrav1().reg().iEstorno());
        bhtl001a().commarea().mensagem().headerR().nrAnulacao().cMnemEgcEstn().set(entrav1().reg().cMnemEgcEstn());
        bhtl001a().commarea().mensagem().headerR().nrAnulacao().cPaisIsoaOeEsn().set(entrav1().reg().cPaisIsoaOeEsn());
        bhtl001a().commarea().mensagem().headerR().nrAnulacao().cOeEgcEstn().set(entrav1().reg().cOeEgcEstn());
        bhtl001a().commarea().mensagem().headerR().nrAnulacao().cUsidEstn().set(entrav1().reg().cUsidEstn());
        bhtl001a().commarea().mensagem().headerR().nrAnulacao().nJourBbnTrnEsn().set(entrav1().reg().nJourBbnTrnEsn());
        bhtl001a().commarea().mensagem().headerR().cMnemEgcOrig().set(entrav1().reg().cMnemEgcOrig());
        bhtl001a().commarea().mensagem().headerR().cPaisIsoaOeOri().set(entrav1().reg().cPaisIsoaOeOri());
        bhtl001a().commarea().mensagem().headerR().cOeEgcOrig().set(entrav1().reg().cOeEgcOrig());
        bhtl001a().commarea().mensagem().headerR().cBanco().set(entrav1().reg().cBanco());
        bhtl001a().commarea().mensagem().headerR().tsLocal().set(entrav1().reg().tsLocal());
        bhtl001a().commarea().mensagem().headerR().tsCentral().set(entrav1().reg().tsCentral());
        /**
         * **** Mapeamentos ENV INPUT
         */
        bhtl001a().commarea().mensagem().xMsgBbn().set(entrav1().reg().xMsgBbnInp());
        saida().reg().msgInp().set(bhtl001a().commarea());
        /**
         * **** Mapeamentos ENV OUTPUT
         */
        bhtl001a().commarea().mensagem().xMsgBbn().set(" ");
        bhtl001a().commarea().mensagem().xMsgBbn().set(entrav1().reg().xMsgBbnOut());
        saida().reg().msgOut().set(bhtl001a().commarea());
        /**
         * **** Mapeamentos da tabela de testes
         */
        saida().reg().trans().set(entrav1().reg().cTransaccao());
        saida().reg().progName().set(entrav1().reg().prog());
        saida().reg().envVersion().set("01");
        saida().reg().zProcessamento().set(entrav1().reg().zProcessamento());
        saida().reg().cMnemEgcOpex().set(entrav1().reg().cMnemEgcOpex());
        saida().reg().cPaisIsoaOeOpx().set(entrav1().reg().cPaisIsoaOeOpx());
        saida().reg().cOeEgcOpex().set(entrav1().reg().cOeEgcOpex());
        saida().reg().cUserid().set(entrav1().reg().cUserid());
        saida().reg().nJourBbn().set(entrav1().reg().nJourBbn());
        saida().reg().aAplicacao().set(" ");
        saida().reg().cOpePcnp().set(" ");
        saida().reg().xChavOpePcnp().set(" ");
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
        entrav1().close() ;
        saida().close() ;
        if (!entrav1().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL001A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA CLOSE DO ENTRADA                  **");
            log(TraceLevel.Error, "** STATUS      : ", entrav1().getStatus());
            log(TraceLevel.Error, "** FINALIZA  ");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
        if (!saida().getStatusOk()) {
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** PROGRAMA TSTL001A CANCELADO MOTIVO :      **");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "** ERRO NA CLOSE DO SAIDA                  **");
            log(TraceLevel.Error, "** STATUS      : ", saida().getStatus());
            log(TraceLevel.Error, "** FINALIZA  ");
            log(TraceLevel.Error, "***********************************************");
            log(TraceLevel.Error, "***********************************************");
            exit() ;
        }
        log(TraceLevel.Trace, "**** TSTL001A - FIM NORMAL *****");
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
        while (!entrav1().getStatusEof()) {
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
