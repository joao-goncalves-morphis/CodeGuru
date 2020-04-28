package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtw1013 extends IDataStruct {
    
    /**
     * @return instancia da classe local DadosInput
     */
    @Data
    DadosInput dadosInput() ;
    
    /**
     * @return instancia da classe local DadosAuxiliares
     */
    @Data
    DadosAuxiliares dadosAuxiliares() ;
    
    public static final String BHTW1013_CON_TABELA = "T" ;
    
    public static final String BHTW1013_CON_FICHEIRO = "F" ;
    
    public static final String BHTW1013_CON_ROTINA = "R" ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTW1013
     * 
     * @version 2.0
     * 
     */
    public interface DadosInput extends IDataStruct {
        
        @Data(size=8, value=" ")
        IString nmPrograma() ;
        
        @Data(size=50, value=" ")
        IString dFunlPrg() ;
        
        @Data(size=1, value=" ")
        IString tabFichRot() ;
        @Data
        @Condition("T")
        ICondition tabela() ;
        @Data
        @Condition("F")
        ICondition ficheiro() ;
        @Data
        @Condition("R")
        ICondition rotina() ;
        
        
        @Data(size=50, value=" ")
        IString xCteuAlig() ;
        
        /**
         * @return instancia da classe local DadosTabela
         */
        @Data
        DadosTabela dadosTabela() ;
        
        /**
         * @return instancia da classe local DadosFicheiro
         */
        @Data
        DadosFicheiro dadosFicheiro() ;
        
        /**
         * @return instancia da classe local DadosRotinas
         */
        @Data
        DadosRotinas dadosRotinas() ;
        
        
        public interface DadosTabela extends IDataStruct {
            
            @Data(size=18, value=" ")
            IString nmTabela() ;
            
            @Data(size=2, value=" ")
            IString cTipoOpeObjDb2() ;
            @Data
            @Condition("BD")
            ICondition swBeginDeclare() ;
            @Data
            @Condition("CA")
            ICondition swCall() ;
            @Data
            @Condition("CL")
            ICondition swCloseCursor() ;
            @Data
            @Condition("CO")
            ICondition swCommit() ;
            @Data
            @Condition("EI")
            ICondition swPrepExecSql() ;
            @Data
            @Condition("EX")
            ICondition swExecSql() ;
            @Data
            @Condition("FE")
            ICondition swFetch() ;
            @Data
            @Condition("IN")
            ICondition swInsert() ;
            @Data
            @Condition("JN")
            ICondition swJoin() ;
            @Data
            @Condition("LT")
            ICondition swLockTable() ;
            @Data
            @Condition("OC")
            ICondition swOpenCursor() ;
            @Data
            @Condition("RB")
            ICondition swRollback() ;
            @Data
            @Condition("SE")
            ICondition swSelect() ;
            @Data
            @Condition("UP")
            ICondition swUpdate() ;
            @Data
            @Condition("DE")
            ICondition swDelete() ;
            
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
        }
        
        public interface DadosFicheiro extends IDataStruct {
            
            @Data(size=6, value=" ")
            IString nmFicheiro() ;
            
            @Data(size=2, value=" ")
            IString cTipoOpeFich() ;
            @Data
            @Condition("CL")
            ICondition swCloseFich() ;
            @Data
            @Condition("DL")
            ICondition swDeleteFich() ;
            @Data
            @Condition("OB")
            ICondition swOpenInOut() ;
            @Data
            @Condition("OI")
            ICondition swOpenIn() ;
            @Data
            @Condition("OO")
            ICondition swOpenOut() ;
            @Data
            @Condition("OE")
            ICondition swOpenExt() ;
            @Data
            @Condition("RR")
            ICondition swReadRandom() ;
            @Data
            @Condition("RS")
            ICondition swReadSeq() ;
            @Data
            @Condition("RW")
            ICondition swRewrite() ;
            @Data
            @Condition("SE")
            ICondition swStartEqual() ;
            @Data
            @Condition("SG")
            ICondition swStartGreater() ;
            @Data
            @Condition("ST")
            ICondition swStartNotLess() ;
            @Data
            @Condition("WR")
            ICondition swWrite() ;
            
            
            @Data(size=2, value=" ")
            IString cFsttCobl() ;
            
        }
        
        public interface DadosRotinas extends IDataStruct {
            
            @Data(size=8)
            IString nmRotina() ;
            
            @Data(size=1)
            IString iOperacao() ;
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    public interface DadosAuxiliares extends IDataStruct {
        
        @Data(size=10, value="0")
        ILong qAces() ;
        
        /**
         * @return instancia da classe local DataAux
         */
        @Data
        DataAux dataAux() ;
        
        /**
         * @return instancia da classe local DataAux2
         */
        @Data
        DataAux2 dataAux2() ;
        
        /**
         * @return instancia da classe local HoraAux
         */
        @Data
        HoraAux horaAux() ;
        
        /**
         * @return instancia da classe local HoraAux2
         */
        @Data
        HoraAux2 horaAux2() ;
        
        /**
         * @return instancia da classe local TiAcesso
         */
        @Data(length=99)
        IArray<TiAcesso> tiAcesso() ;
        
        
        public interface DataAux extends IDataStruct {
            
            @Data(size=2)
            IString dataAuxAno() ;
            
            @Data(size=2)
            IString dataAuxMes() ;
            
            @Data(size=2)
            IString dataAuxDia() ;
            
        }
        
        public interface DataAux2 extends IDataStruct {
            
            @Data(size=2)
            IString dataAux2Sec() ;
            
            @Data(size=2)
            IString dataAux2Ano() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IString dataAux2Mes() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IString dataAux2Dia() ;
            
        }
        
        public interface HoraAux extends IDataStruct {
            
            @Data(size=2)
            IString horaAuxH() ;
            
            @Data(size=2)
            IString horaAuxM() ;
            
            @Data(size=2)
            IString horaAuxS() ;
            
            @Data(size=2)
            IString horaAuxMil() ;
            
        }
        
        public interface HoraAux2 extends IDataStruct {
            
            @Data(size=2)
            IString horaAux2H() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IString horaAux2M() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IString horaAux2S() ;
            
        }
        
        public interface TiAcesso extends IDataStruct {
            
            
            @Data(size=1, value=" ")
            IString tiTabFichRot() ;
            
            @Data(size=50, value=" ")
            IString tiXCteuAlig() ;
            
            @Data(size=18, value=" ")
            IString tiNmTabela() ;
            
            @Data(size=6, value=" ")
            IString tiNmFicheiro() ;
            
            @Data(size=10, compression=COMP3)
            ILong tiQAces() ;
            
            @Data(size=2, value=" ")
            IString tiCTipoOpeObjDb2() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong tiCSqlcode() ;
            
            @Data(size=2, value=" ")
            IString tiCTipoOpeFich() ;
            
            @Data(size=2, value=" ")
            IString tiCFsttCobl() ;
            
            @Data(size=8, value=" ")
            IString tiNmRotina() ;
            
            @Data(size=1, value=" ")
            IString tiIOperacao() ;
            
            @Data(size=2, value=" ")
            IString tiCTipoErroBbn() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt tiCRtnoEvenSwal() ;
            
            @Data(size=2, value=" ")
            IString tiAAplErr() ;
            
        }
    }
    
}
