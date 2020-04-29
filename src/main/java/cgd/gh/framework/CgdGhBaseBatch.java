package cgd.gh.framework;

import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import cgd.framework.CgdBaseBatch ;
import cgd.gh.structures.work.Bghw0300 ;


/**
 * 
 * migrated from copybook [BGHP0300]
 * 
 * @version 2.0
 * 
 */
public abstract class CgdGhBaseBatch extends CgdBaseBatch {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bghw0300
     */
    @Data
    protected abstract Bghw0300 bghw0300() ;
    
    
    
    /**
     * 
     * 
     */
    protected void bghp0300() {
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghw0300().wsVariaveisHora().hhFimW().set(bghw0300().wsVariaveisHora().horaFimR().hhFim());
        bghw0300().wsVariaveisHora().mmFimW().set(bghw0300().wsVariaveisHora().horaFimR().mmFim());
        bghw0300().wsVariaveisHora().ssFimW().set(bghw0300().wsVariaveisHora().horaFimR().ssFim());
        bghw0300().wsVariaveisHora().ccFimW().set(bghw0300().wsVariaveisHora().horaFimR().ccFim());
        bghw0300().wsVariaveisHora().ccDifW().set(subtract(bghw0300().wsVariaveisHora().ccFimW(), bghw0300().wsVariaveisHora().horaInicioR().ccInicio()));
        if (bghw0300().wsVariaveisHora().ccDifW().isLess(0)) {
            bghw0300().wsVariaveisHora().ccDifW().set(add(bghw0300().wsVariaveisHora().ccDifW(), 100));
            bghw0300().wsVariaveisHora().ssFimW().subtract(1);
        }
        bghw0300().wsVariaveisHora().ssDifW().set(subtract(bghw0300().wsVariaveisHora().ssFimW(), bghw0300().wsVariaveisHora().horaInicioR().horaMapa().ssInicio()));
        if (bghw0300().wsVariaveisHora().ssDifW().isLess(0)) {
            bghw0300().wsVariaveisHora().ssDifW().set(add(bghw0300().wsVariaveisHora().ssDifW(), 60));
            bghw0300().wsVariaveisHora().mmFimW().subtract(1);
        }
        bghw0300().wsVariaveisHora().mmDifW().set(subtract(bghw0300().wsVariaveisHora().mmFimW(), bghw0300().wsVariaveisHora().horaInicioR().horaMapa().mmInicio()));
        if (bghw0300().wsVariaveisHora().mmDifW().isLess(0)) {
            bghw0300().wsVariaveisHora().mmDifW().set(add(bghw0300().wsVariaveisHora().mmDifW(), 60));
            bghw0300().wsVariaveisHora().hhFimW().subtract(1);
        }
        bghw0300().wsVariaveisHora().hhDifW().set(subtract(bghw0300().wsVariaveisHora().hhFimW(), bghw0300().wsVariaveisHora().horaInicioR().horaMapa().hhInicio()));
        if (bghw0300().wsVariaveisHora().hhDifW().isLess(0)) {
            bghw0300().wsVariaveisHora().hhDifW().set(add(bghw0300().wsVariaveisHora().hhDifW(), 24));
        }
        bghw0300().wsVariaveisHora().tempoExecucaoR().ccDif().set(bghw0300().wsVariaveisHora().ccDifW());
        bghw0300().wsVariaveisHora().tempoExecucaoR().ssDif().set(bghw0300().wsVariaveisHora().ssDifW());
        bghw0300().wsVariaveisHora().tempoExecucaoR().mmDif().set(bghw0300().wsVariaveisHora().mmDifW());
        bghw0300().wsVariaveisHora().tempoExecucaoR().hhDif().set(bghw0300().wsVariaveisHora().hhDifW());
    }
}
