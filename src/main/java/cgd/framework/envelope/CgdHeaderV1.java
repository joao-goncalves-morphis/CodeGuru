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
public interface CgdHeaderV1 extends IDataStruct {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe local Controlo
     */
    @Data
    Controlo controlo() ;
    
    /**
     * @return instancia da classe local Balcao
     */
    @Data
    Balcao balcao() ;
    
    /**
     * @return instancia da classe local IndicaCutiliza
     */
    @Data
    IndicaCutiliza indicaCutiliza() ;
    
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
    
    
    /**
     * @return instancia da classe local Cct
     */
    @Data
    Cct cct() ;
    
    
    
    public interface Controlo extends IDataStruct {
        
        @Data(size=4, signed=true, compression=COMP)
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
        @Condition("M")
        ICondition mqseries() ;
        @Data
        @Condition("L")
        ICondition portaLink() ;
        
        
        @Data(size=8)
        ILong zSessao() ;
        
        @Data(size=6)
        IInt hSessao() ;
        
        @Data(size=1)
        IString iMsgPendEnvi() ;
        @Data
        @Condition("S")
        ICondition msgSim() ;
        @Data
        @Condition("N")
        ICondition msgNao() ;
        
        
    }
    
    public interface Balcao extends IDataStruct {
        
        @Data(size=1)
        IString iOfflPlgd() ;
        @Data
        @Condition("S")
        ICondition iOfflPlgdSim() ;
        @Data
        @Condition("N")
        ICondition iOfflPlgdNao() ;
        
        
    }
    
    public interface IndicaCutiliza extends IDataStruct {
        
        @Data(size=1)
        IString ctNvelAtrzBbn() ;
        
    }
    
    public interface Cct extends IDataStruct {
        
        @Data(size=1)
        IString iTrnAcsCtaStff() ;
        @Data
        @Condition("S")
        ICondition iTrnAcesSim() ;
        @Data
        @Condition("N")
        ICondition iTrnAcesNao() ;
        
        
        @Data(size=8)
        IString nmPrograma() ;
        
        @Data(size=1)
        IString iRstzAcesCont() ;
        @Data
        @Condition("0")
        ICondition iraConNao() ;
        @Data
        @Condition("1")
        ICondition iraConSim() ;
        @Data
        @Condition("2")
        ICondition iraConValSim() ;
        @Data
        @Condition("3")
        ICondition iraConValNao() ;
        
        
        @Data(size=1)
        IString iRstzAcesCli() ;
        @Data
        @Condition("0")
        ICondition iraCliNao() ;
        @Data
        @Condition("1")
        ICondition iraCliSim() ;
        @Data
        @Condition("2")
        ICondition iraCliValSim() ;
        @Data
        @Condition("3")
        ICondition iraCliValNao() ;
        
        
    }
}
