package cgd.ht.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
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
public interface Bhtl220a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTL220A - AREA LIGACAO ROTINA DE JORNALIZACAO
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        @Data(size=4, signed=true, compression=COMP)
        IInt qCterCmptAlig() ;
        
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
        @Data
        @Condition("DA")
        ICondition dadosEntrada() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cRtnoEvenSwal() ;
        
        @Data(size=4093)
        IString xCteuRegJour() ;
        
        @Data(size=1)
        IInt cImgTabJour() ;
        
        @Data(size=16)
        IString nmTabela() ;
        
        /**
         * @return instancia da classe local Sqlca
         */
        @Data
        Sqlca sqlca() ;
        
        /**
         * @return instancia da classe local Header2
         */
        @Data
        Header2 header2() ;
        
        
        public interface Sqlca extends IDataStruct {
            
            @Data(size=8)
            IString xSqlaid() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong qSqlabc() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            /**
             * @return instancia da classe local Sqlerrm
             */
            @Data
            Sqlerrm sqlerrm() ;
            
            @Data(size=8)
            IString sqlerrp() ;
            
            /**
             * @return instancia da classe local Sqlerrd
             */
            @Data(length=6)
            IArray<Sqlerrd> sqlerrd() ;
            
            /**
             * @return instancia da classe local Sqlwarn
             */
            @Data
            Sqlwarn sqlwarn() ;
            
            @Data(size=8)
            IString xSqlext() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            
            public interface Sqlerrm extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP)
                IInt qSqlerrml() ;
                
                @Data(size=70)
                IString xSqlerrmc() ;
                
            }
            
            public interface Sqlerrd extends IDataStruct {
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlerrdItem() ;
                
            }
            
            public interface Sqlwarn extends IDataStruct {
                
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
                
            }
        }
        
        public interface Header2 extends IDataStruct {
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal campoLivre1() ;
            
            @Data(size=10)
            IString campoLivre2() ;
            
            @Data(size=1)
            IString campoLivre3() ;
            
            @Data(size=3)
            IString campoLivre4() ;
            
            @Data(size=50)
            IString campoLivre5() ;
            
        }
    }
    
}
