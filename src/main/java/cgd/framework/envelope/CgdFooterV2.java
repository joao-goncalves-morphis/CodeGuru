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
public interface CgdFooterV2 extends IDataStruct {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * *TERMINO DA MENSAGEM
     */
    @Data(size=4)
    IString cTerminal() ;
    
    @Data(size=2, signed=true, compression=COMP3)
    IInt nsJourBbn() ;
    
    /**
     * @return instancia da classe local Assyncrono
     */
    @Data
    Assyncrono assyncrono() ;
    
    @Data(size=1, signed=true)
    IInt cImgTabJour() ;
    @Data
    @Condition("1")
    ICondition cJournal1() ;
    @Data
    @Condition("2")
    ICondition cJournal2() ;
    
    
    @Data(size=1, signed=true)
    IInt iTabJourMov() ;
    @Data
    @Condition("1")
    ICondition iJournal1() ;
    @Data
    @Condition("2")
    ICondition iJournal2() ;
    
    
    @Data(size=99)
    IString chvTabErro() ;
    
    @Data(size=2)
    IString cEibfn() ;
    
    @Data(size=6)
    IString cEibrcode() ;
    
    @Data(size=8)
    IString cEibrsrce() ;
    
    /**
     * @return instancia da classe local Db2Log
     */
    @Data
    Db2Log db2Log() ;
    
    @Data(size=8, signed=true, compression=COMP)
    ILong cEibresp() ;
    
    
    
    public interface Assyncrono extends IDataStruct {
        
        @Data(size=1)
        IString iTipoPrctTrnz() ;
        @Data
        @Condition("S")
        ICondition iTipoPrctTrnzOn() ;
        @Data
        @Condition("A")
        ICondition iTipoPrctTrnzOff() ;
        
        
        @Data(size=249)
        IString xAligTrnzAsin() ;
        
    }
    
    public interface Db2Log extends IDataStruct {
        
        @Data(size=16)
        IString nmTabela() ;
        
        /**
         * @return instancia da classe local Sqlca
         */
        @Data
        Sqlca sqlca() ;
        
        
        public interface Sqlca extends IDataStruct {
            
            @Data(size=8)
            IString xSqlcaid() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong qSqlcabc() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            @Data(size=4, signed=true, compression=COMP)
            IInt qSqlerrml() ;
            
            @Data(size=70)
            IString xSqlerrmc() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlerrd() ;
            
            @Data(size=1)
            IString iSqlwarn0() ;
            
            @Data(size=1)
            IString iSqlwarn1() ;
            
            @Data(size=1)
            IString iSqlwarn2() ;
            
            @Data(size=1)
            IString iSqlwarn3() ;
            
            @Data(size=1)
            IString iSqlwarn4() ;
            
            @Data(size=1)
            IString iSqlwarn5() ;
            
            @Data(size=1)
            IString iSqlwarn6() ;
            
            @Data(size=1)
            IString iSqlwarn7() ;
            
            @Data(size=8)
            IString xSqlext() ;
            
        }
    }
}
