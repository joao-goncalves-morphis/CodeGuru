package cgd.framework;

import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.procedures.BaseProgram ;
import cgd.ht.structures.work.Bhtw0007 ;
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;


/**
 * 
 * migrated from copybook [BHTP0004]
 * 
 * @version 2.0
 * 
 */
public abstract class CgdBaseRoutine extends BaseProgram {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bhtw0007
     */
    @Data
    protected abstract Bhtw0007 bhtw0007() ;
    
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
