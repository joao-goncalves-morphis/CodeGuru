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
public interface Bhtw7000 extends IDataStruct {
    
    @Data(size=8, value="PZYA710A")
    IString pgmname() ;
    
    @Data(size=8, value=" ")
    IString sysParm() ;
    @Data
    @Condition("SYSNAME")
    ICondition sysname() ;
    @Data
    @Condition("JOBNAME")
    ICondition jobname() ;
    @Data
    @Condition("JOBID  ")
    ICondition jobid() ;
    
    
    /**
     * @return instancia da classe local Parmarea
     */
    @Data
    Parmarea parmarea() ;
    
    /**
     * @return instancia da classe local IndicadoresErro
     */
    @Data
    IndicadoresErro indicadoresErro() ;
    
    /**
     * Inner Classes
     */
    public interface Parmarea extends IDataStruct {
        
        @Data(size=2, value="8", compression=COMP)
        IInt tamanho() ;
        
        @Data(size=8, value="????????")
        IString area8() ;
        
    }
    public interface IndicadoresErro extends IDataStruct {
        
        @Data(size=2, value=" ")
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
        
        @Data(size=50)
        IString msgErrob() ;
        
        @Data(size=8)
        IString modOrigemErro() ;
        
        @Data(size=40)
        IString chAcesso() ;
        
    }
    
}
