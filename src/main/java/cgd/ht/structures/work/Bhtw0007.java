package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtw0007 extends IDataStruct {
    
    /**
     * @return instancia da classe local IndicadoresErro
     */
    @Data
    IndicadoresErro indicadoresErro() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTW0007   COPY DE WORKING DO COPY BHTP0004 -
     * DB2CHECK PARA ROTINAS
     * 
     * @version 2.0
     * 
     */
    public interface IndicadoresErro extends IDataStruct {
        
        @Data(size=2)
        IString cTipoErroBbn() ;
        @Data
        @Condition("A1")
        ICondition abend() ;
        @Data
        @Condition("A2")
        ICondition abendDb2() ;
        @Data
        @Condition("A3")
        ICondition abendCics() ;
        @Data
        @Condition("AT")
        ICondition errosArq() ;
        @Data
        @Condition({ "FU", "AU", " ", "FC" })
        ICondition errosValidos() ;
        @Data
        @Condition("FU")
        ICondition errosFuncao() ;
        @Data
        @Condition("AU")
        ICondition autorizacao() ;
        @Data
        @Condition("FC")
        ICondition fimConsulta() ;
        @Data
        @Condition(" ")
        ICondition semErros() ;
        
        
        @Data(size=3, signed=true, value="0", compression=COMP3)
        IInt cRtnoEvenSwal() ;
        
        @Data(size=2)
        IString aAplErr() ;
        
    }
    
}
