package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtw0030 extends IDataStruct {
    
    /**
     * @return instancia da classe local DadosEntrada
     */
    @Data
    DadosEntrada dadosEntrada() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTW0030   AREA WORKING    DO    COPY DE PROCEDURE PARA
     * INFORMAR A OPERACAO DO ERRO CORRIDO
     * 
     * @version 2.0
     * 
     */
    public interface DadosEntrada extends IDataStruct {
        
        @Data(size=8)
        IString nmPrograma() ;
        
        @Data(size=10)
        IString zInicExePrg() ;
        
        @Data(size=10)
        IString zErro() ;
        
        @Data(size=8)
        IString hInicExePrg() ;
        
        @Data(size=8)
        IString hErro() ;
        
        @Data(size=2)
        IString cTipoErroBbn() ;
        @Data
        @Condition("A1")
        ICondition abend() ;
        @Data
        @Condition("A2")
        ICondition abendDb2() ;
        @Data
        @Condition("FI")
        ICondition abendFicheiro() ;
        @Data
        @Condition("  ")
        ICondition semErros() ;
        
        
        @Data(format="999999999-")
        IFormattedString cSqlcode() ;
        
        @Data(size=18)
        IString nmTabela() ;
        
        @Data(size=2)
        IString cTipoOpeObjDb2() ;
        
        @Data(size=50)
        IString xCteuChavTab() ;
        
        @Data(size=8)
        IString nmPrgChmd() ;
        
        @Data(size=2)
        IString cTipoErrPrgChmd() ;
        @Data
        @Condition("A1")
        ICondition rotAbend() ;
        @Data
        @Condition("A2")
        ICondition rotAbendDb2() ;
        @Data
        @Condition("A3")
        ICondition rotAbendCics() ;
        @Data
        @Condition("AT")
        ICondition rotErroArquitectura() ;
        @Data
        @Condition("FU")
        ICondition rotErroFuncao() ;
        @Data
        @Condition("AU")
        ICondition rotAutorizacao() ;
        @Data
        @Condition("FC")
        ICondition rotFimDeConsulta() ;
        @Data
        @Condition("  ")
        ICondition rotSemErros() ;
        
        
        @Data(size=100)
        IString xCteuAlig() ;
        
        @Data(size=6)
        IString nmFicheiro() ;
        
        @Data(size=2)
        IString cFsttCobl() ;
        
        @Data(size=50)
        IString xSugRtnoSwal() ;
        
    }
    
}
