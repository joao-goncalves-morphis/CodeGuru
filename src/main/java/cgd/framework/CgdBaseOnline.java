package cgd.framework;

import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.procedures.BaseProgram ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV2 ;
import cgd.framework.envelope.CgdMessageV2 ;
import cgd.framework.envelope.CgdFooterV2 ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtw0007 ;


/**
 * 
 * migrated from copybook [BHTP0002]
 * 
 * @version 2.0
 * 
 */
public abstract class CgdBaseOnline<I extends CgdEnvelope, O extends CgdEnvelope> extends BaseProgram {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe CgdEnvelope
     */
    protected CgdEnvelope envelope ;
    
    /**
     * @return instancia da classe CgdHeaderV2
     */
    protected CgdHeaderV2 headerV2 ;
    
    /**
     * @return instancia da classe CgdMessageV2
     */
    protected CgdMessageV2 messageV2 ;
    
    /**
     * @return instancia da classe CgdFooterV2
     */
    protected CgdFooterV2 footerV2 ;
    
    /**
     * @return instancia da classe CgdHeaderV1
     */
    protected CgdHeaderV1 header ;
    
    /**
     * @return instancia da classe CgdMessageV1
     */
    protected CgdMessageV1 message ;
    
    /**
     * @return instancia da classe CgdFooterV1
     */
    protected CgdFooterV1 footer ;
    
    /**
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
    /**
     * @return instancia da classe Bhtk0001
     */
    @Data
    protected abstract Bhtk0001 bhtk0001() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhtw0007
     */
    @Data
    protected abstract Bhtw0007 bhtw0007() ;
    
    
    public I envIn ;
    public O envOut ;
    
    public void setEnvelopes(I envIn, O envOut) {
        this.envIn = envIn ;
        this.envOut = envOut ;
        
        this.envelope = envIn ;
        
        if(envOut instanceof CgdMessageV1) {
            header = (CgdHeaderV1)envOut ;
            message = (CgdMessageV1)envOut ;
            footer = (CgdFooterV1)envOut ;
        }
        else {
            headerV2 = (CgdHeaderV2)envOut ;
            messageV2 = (CgdMessageV2)envOut ;
            footerV2 = (CgdFooterV2)envOut ;
        }
    }
    
    /**
     * 
     * Invocação anónima de serviços online
     * 
     * @param pgmName
     * @param commArea
     */
    public static Object execute(String pgmName, Object commArea) {
        return null ;
    }
    
    /**
     * 
     * 9020-DB2CHECK
     * 
     */
    public void bhtp0002M9020Db2check() {
        bhtw0005().cSqlcode().set(getPersistenceCode());
        footer.db2Log().sqlca().set(getSqlMessage());
        if (!getSqlMessage().isEmpty()) {
            footer.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().warningDb2());
            footer.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abend());
            footer.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
        } else if (!bhtw0005().notfnd().isTrue() && !bhtw0005().ok().isTrue() && 
            !bhtw0005().duprec().isTrue()) {
            footer.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            footer.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            footer.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
        }
    }
    
    /**
     * 
     * 
     */
    public void bhtp0001() {
        /**
         * BHTP0001   TRATAMENTO DE ERROS CICS
         */
        footer.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendCics());
        footer.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
        footer.cicsLog().cEibfn().set("EIBFN");
        footer.cicsLog().cEibrcode().set("EIBRCODE");
        footer.cicsLog().cEibrsrce().set("EIBRSRCE");
    }
    
    /**
     * 
     * 9020-DB2CHECK
     * PARA CANAIS NAO PRESENCIAIS
     * 
     */
    public void bhtp0008M9020Db2check() {
        bhtw0005().cSqlcode().set(getPersistenceCode());
        footerV2.db2Log().sqlca().set(getSqlMessage());
        if (!getSqlMessage().isEmpty()) {
            messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().warningDb2());
            messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abend());
            messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
        } else if (!bhtw0005().notfnd().isTrue() && !bhtw0005().ok().isTrue() && 
            !bhtw0005().duprec().isTrue()) {
            messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
            messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
        }
    }
    
    /**
     * 
     * 9020-DB2CHECK  (TRANSACCIONAL)
     * VARIANTE PARA PROGRAMAS COM COMMAREAS ESPECIFICAS
     * 
     */
    public void m9020Db2check() {
        bhtw0007().indicadoresErro().cTipoErroBbn().set(" ");
        bhtw0007().indicadoresErro().aAplErr().set(" ");
        bhtw0007().indicadoresErro().cRtnoEvenSwal().set(0);
        bhtw0005().cSqlcode().set(getPersistenceCode());
        if (!getSqlMessage().isEmpty()) {
            bhtw0007().indicadoresErro().cRtnoEvenSwal().set(bhtk0001().erros().warningDb2());
            bhtw0007().indicadoresErro().cTipoErroBbn().set(bhtk0002().indErros().abend());
            bhtw0007().indicadoresErro().aAplErr().set(bhtk0002().siglaArquit());
        } else if (!bhtw0005().notfnd().isTrue() && !bhtw0005().ok().isTrue() && 
            !bhtw0005().duprec().isTrue()) {
            bhtw0007().indicadoresErro().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            bhtw0007().indicadoresErro().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            bhtw0007().indicadoresErro().aAplErr().set(bhtk0002().siglaArquit());
        }
    }
}
