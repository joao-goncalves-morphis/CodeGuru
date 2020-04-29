package cgd.framework.envelope;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
public interface CgdHeaderV2 extends IDataStruct {
    /**
     * Member Variables(Working Storage)
     */
    @Data(size=4, signed=true, compression=COMP3)
    IInt qCterCmptMsg() ;
    
    @Data(size=1)
    IString iTipoOrigTrnz() ;
    @Data
    @Condition("E")
    ICondition ambiente3270() ;
    @Data
    @Condition("P")
    ICondition ambiente3600() ;
    @Data
    @Condition("T")
    ICondition ambienteTele() ;
    @Data
    @Condition("S")
    ICondition ambienteSibs() ;
    @Data
    @Condition("B")
    ICondition batch() ;
    @Data
    @Condition("L")
    ICondition portaLink() ;
    @Data
    @Condition("W")
    ICondition aWai() ;
    
    
    @Data(size=8, compression=COMP3)
    ILong zSessao() ;
    
    @Data(size=6, compression=COMP3)
    IInt hSessao() ;
    
    @Data(size=1)
    IString iOfflPlgd() ;
    @Data
    @Condition("S")
    ICondition offlPlgdSim() ;
    @Data
    @Condition("N")
    ICondition offlPlgdNao() ;
    
    
    @Data(size=1)
    IString iTipoTrnzBbn() ;
    @Data
    @Condition("A")
    ICondition aberturaBalcao() ;
    @Data
    @Condition("B")
    ICondition aberturaSemUser() ;
    @Data
    @Condition("M")
    ICondition trnAposFechoBal() ;
    @Data
    @Condition("T")
    ICondition transacao() ;
    @Data
    @Condition("C")
    ICondition conversacao() ;
    
    
    
}
