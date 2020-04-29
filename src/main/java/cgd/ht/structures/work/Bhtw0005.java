package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtw0005 extends IDataStruct {
    
    @Data(size=3, signed=true, value="0")
    IInt cSqlcode() ;
    @Data
    @Condition("100")
    ICondition notfnd() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("-803")
    ICondition duprec() ;
    @Data
    @Condition("-811")
    ICondition multrow() ;
    @Data
    @Condition("-924")
    ICondition db2NotExist() ;
    @Data
    @Condition("-530")
    ICondition fkntfnd() ;
    @Data
    @Condition("-305")
    ICondition fncNotFnd() ;
    @Data
    @Condition("-532")
    ICondition restrict() ;
    @Data
    @Condition({ "-180", "-181" })
    ICondition datas() ;
    
    
}
