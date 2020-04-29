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
public interface Bhtw0033 extends IDataStruct {
    
    /**
     * @return instancia da classe local DadosGerais
     */
    @Data
    DadosGerais dadosGerais() ;
    
    @Data(size=100)
    IString dadosFuncionais() ;
    
    /**
     * @return instancia da classe local DadosDb2
     */
    @Data
    DadosDb2 dadosDb2() ;
    
    /**
     * @return instancia da classe local DadosFicheiros
     */
    @Data
    DadosFicheiros dadosFicheiros() ;
    
    /**
     * @return instancia da classe local DadosRotina
     */
    @Data
    DadosRotina dadosRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTW0033   AREA WORKING       DO COPY DE PROCEDURE PARA
     * ESCRITA DE ESTATISTICAS
     * 
     * @version 2.0
     * 
     */
    public interface DadosGerais extends IDataStruct {
        
        @Data(size=8)
        IString nmPrograma() ;
        
        @Data(size=50)
        IString dFunlPrg() ;
        
        @Data(size=10)
        IString zInicPrct() ;
        
        @Data(size=8)
        IString hInicPrct() ;
        
        @Data(size=10)
        IString zFimPrct() ;
        
        @Data(size=8)
        IString hFimPrct() ;
        
        @Data(size=50)
        IString xCteuAlig() ;
        
    }
    public interface DadosDb2 extends IDataStruct {
        
        @Data(size=18)
        IString nmTabela() ;
        
        @Data(size=2)
        IString cTipoOpeObjDb2() ;
        @Data
        @Condition("BD")
        ICondition beginDeclare() ;
        @Data
        @Condition("CA")
        ICondition call() ;
        @Data
        @Condition("CL")
        ICondition closeCursor() ;
        @Data
        @Condition("CO")
        ICondition commit() ;
        @Data
        @Condition("DC")
        ICondition declareCursor() ;
        @Data
        @Condition("DL")
        ICondition delete() ;
        @Data
        @Condition("EI")
        ICondition prepareSqlStatem() ;
        @Data
        @Condition("EX")
        ICondition executeSql() ;
        @Data
        @Condition("FE")
        ICondition fetch() ;
        @Data
        @Condition("IN")
        ICondition insert() ;
        @Data
        @Condition("JN")
        ICondition join() ;
        @Data
        @Condition("LT")
        ICondition lockTable() ;
        @Data
        @Condition("OC")
        ICondition openCursor() ;
        @Data
        @Condition("RB")
        ICondition rollback() ;
        @Data
        @Condition("SE")
        ICondition select() ;
        @Data
        @Condition("UP")
        ICondition update() ;
        
        
        @Data(format="999999999-")
        IFormattedString cSqlcode() ;
        
        @Data(size=10)
        ILong qAcesTab() ;
        
    }
    public interface DadosFicheiros extends IDataStruct {
        
        @Data(size=8)
        IString nmFicheiro() ;
        
        @Data(size=2)
        IString cTipoOpeFich() ;
        @Data
        @Condition("CL")
        ICondition close() ;
        @Data
        @Condition("DL")
        ICondition delete() ;
        @Data
        @Condition("OB")
        ICondition openIO() ;
        @Data
        @Condition("OI")
        ICondition openInput() ;
        @Data
        @Condition("OO")
        ICondition openOutput() ;
        @Data
        @Condition("OE")
        ICondition openExtended() ;
        @Data
        @Condition("RR")
        ICondition readRandom() ;
        @Data
        @Condition("RS")
        ICondition readSequential() ;
        @Data
        @Condition("RW")
        ICondition rewrite() ;
        @Data
        @Condition("SE")
        ICondition startEqual() ;
        @Data
        @Condition("SG")
        ICondition startGreater() ;
        @Data
        @Condition("ST")
        ICondition startNotLess() ;
        @Data
        @Condition("WR")
        ICondition write() ;
        
        
        @Data(size=2)
        IString cFsttCobl() ;
        
        @Data(size=10)
        ILong qAcesFich() ;
        
    }
    public interface DadosRotina extends IDataStruct {
        
        @Data(size=8)
        IString nmRtnaAces() ;
        
        @Data(size=1)
        IString iOperacao() ;
        
        @Data(size=2)
        IString cTipoErroBbn() ;
        
        @Data(format="999-")
        IFormattedString cRtnoEvenSwal() ;
        
        @Data(size=2)
        IString aAplErr() ;
        
        @Data(size=10)
        ILong qAcesRtna() ;
        
    }
    
}
