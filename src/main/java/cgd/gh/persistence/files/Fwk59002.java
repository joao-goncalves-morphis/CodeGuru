package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk59002 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk590Pghq330a
     */
    @Data
    public abstract RegFwk590Pghq330a regFwk590Pghq330a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk590Pghq330a extends IDataStruct {
        
        @Data(size=3)
        IString fwk590CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk590CBancCont() ;
        
        @Data(size=4)
        IInt fwk590COeEgcCont() ;
        
        @Data(size=7)
        IInt fwk590NsRdclCont() ;
        
        @Data(size=1)
        IInt fwk590VChkdCont() ;
        
        @Data(size=3)
        IInt fwk590CTipoCont() ;
        
        @Data(size=1, value=";")
        IString wsVirgula1() ;
        
        @Data(size=3)
        IString fwk590CMoedIsoScta() ;
        
        @Data(size=1, value=";")
        IString wsVirgula2() ;
        
        @Data(size=4)
        IInt fwk590NsDeposito() ;
        
        @Data(size=1, value=";")
        IString wsVirgula3() ;
        
        @Data(size=10)
        IString fwk590TsZMovimento() ;
        
        @Data(size=1, value=";")
        IString wsVirgula4() ;
        
        @Data(size=10)
        IString fwk590ZValMov() ;
        
        @Data(size=1, value=";")
        IString wsVirgula5() ;
        
        @Data(size=15)
        IString fwk590TsTimer() ;
        
        @Data(size=1, value=";")
        IString wsVirgula6() ;
        
        @Data(size=21)
        IString fwk590XRefMov() ;
        
        @Data(size=1, value=";")
        IString wsVirgula7() ;
        
        @Data(size=10)
        ILong fwk590NDocOpps() ;
        
        @Data(size=1, value=";")
        IString wsVirgula8() ;
        
        @Data(format="ZZZZZZZZZZZZZZ9,99-")
        IFormattedString fwk590MMovimento() ;
        
        @Data(size=1, value=";")
        IString wsVirgula9() ;
        
        @Data(format="ZZZZZZZZZZZZZZ9,99-")
        IFormattedString fwk590MSldoCbloApos() ;
        
        @Data(size=1, value=";")
        IString wsVirgula10() ;
        
        @Data(size=1)
        IString fwk590IDbcr() ;
        
        @Data(size=1, value=";")
        IString wsVirgula11() ;
        
        @Data(size=1)
        IString fwk590IEstorno() ;
        
        @Data(size=1, value=";")
        IString wsVirgula12() ;
        
        @Data(size=4)
        IInt fwk590COeEgcOpex102() ;
        
        @Data(size=1, value=";")
        IString wsVirgula13() ;
        
        @Data(size=4)
        IString fwk590CTipoCanlAces102() ;
        
        @Data(size=1, value=";")
        IString wsVirgula14() ;
        
        @Data(size=8)
        IString fwk590CUserid102() ;
        
        @Data(size=1, value=";")
        IString wsVirgula15() ;
        
        @Data(size=15)
        ILong fwk590NsMovimento() ;
        
        @Data(size=1, value=";", rpadding=102)
        IString wsVirgula16() ;
        
    }
}
