package cgd.hj.structures.work;

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
public interface Bhjw0016 extends IDataStruct {
    
    @Data(size=10, value="0", compression=COMP3)
    ILong nCliente() ;
    
    @Data(size=3, value="0", compression=COMP3)
    IInt nsAbraCli() ;
    
    @Data(size=4, value="0", compression=COMP3)
    IInt nsNomeCli() ;
    
    @Data(size=3, value=" ")
    IString cTipoNomeCli() ;
    
    @Data(size=35, value=" ")
    IString nmCliAbvd() ;
    
    @Data(size=20, value=" ")
    IString anCliPrim() ;
    
    @Data(size=6, value=" ")
    IString anCliSegn() ;
    
    @Data(size=22, value=" ")
    IString anCliTerc() ;
    
    @Data(size=2, value=" ")
    IString retorno() ;
    @Data
    @Condition("00")
    ICondition semErro() ;
    @Data
    @Condition("10")
    ICondition clientConfid() ;
    @Data
    @Condition("20")
    ICondition cliSemRelBancOpe() ;
    @Data
    @Condition("30")
    ICondition cliSemRelBanco() ;
    @Data
    @Condition("90")
    ICondition erroDb2() ;
    
    
    @Data(size=3, signed=true, value="0")
    IInt cSqlcode() ;
    
    @Data(size=3, signed=true, value="0")
    IInt cRtnoEvenSwal() ;
    
    @Data(size=50, value=" ")
    IString msgErrob() ;
    
    @Data(size=8, value=" ")
    IString nmTabela() ;
    
    @Data(size=8, value=" ")
    IString modOrigemErro() ;
    
    @Data(size=40, value=" ")
    IString chAcesso() ;
    
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
    @Condition("FU")
    ICondition erroFuncao() ;
    @Data
    @Condition("AU")
    ICondition autorizacao() ;
    @Data
    @Condition("FC")
    ICondition fimConsulta() ;
    @Data
    @Condition("  ")
    ICondition semErros() ;
    
    
}
