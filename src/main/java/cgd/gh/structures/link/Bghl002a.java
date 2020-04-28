package cgd.gh.structures.link;

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
public interface Bghl002a extends IDataStruct {
    
    @Data(size=3)
    IInt cRetorno() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("233")
    ICondition dadosInvalidos() ;
    @Data
    @Condition("097")
    ICondition naoExiste() ;
    @Data
    @Condition("216")
    ICondition db2() ;
    
    
    @Data(size=9, signed=true, compression=COMP3)
    ILong cSqlcode() ;
    
    /**
     * @return instancia da classe local CriterioConsulta
     */
    @Data
    CriterioConsulta criterioConsulta() ;
    
    /**
     * @return instancia da classe local CriterioDbcr
     */
    @Data
    CriterioDbcr criterioDbcr() ;
    
    /**
     * @return instancia da classe local CriterioMontante
     */
    @Data
    CriterioMontante criterioMontante() ;
    
    /**
     * @return instancia da classe local CriterioSeleccao
     */
    @Data
    CriterioSeleccao criterioSeleccao() ;
    
    /**
     * @return instancia da classe local Argumento
     */
    @Data
    Argumento argumento() ;
    
    /**
     * @return instancia da classe local Detalhe
     */
    @Data
    Detalhe detalhe() ;
    
    @Data(size=2)
    IInt qItens() ;
    
    /**
     * @return instancia da classe local Tabela
     */
    @Data
    Tabela tabela() ;
    
    /**
     * Inner Classes
     */
    public interface CriterioConsulta extends IDataStruct {
        
        @Data(size=1)
        IString iCriterioCns() ;
        @Data
        @Condition("A")
        ICondition ascendente() ;
        @Data
        @Condition("D")
        ICondition descendente() ;
        
        
    }
    public interface CriterioDbcr extends IDataStruct {
        
        @Data(size=1)
        IString iCriterioDbcr() ;
        @Data
        @Condition("T")
        ICondition debito() ;
        @Data
        @Condition("C")
        ICondition credito() ;
        @Data
        @Condition(" ")
        ICondition ambos() ;
        
        
    }
    public interface CriterioMontante extends IDataStruct {
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMin() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMax() ;
        
    }
    public interface CriterioSeleccao extends IDataStruct {
        
        @Data(size=26)
        IString tsMovMax() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovMax() ;
        
    }
    public interface Argumento extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        @Data(size=26)
        IString tsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
    }
    public interface Detalhe extends IDataStruct {
        
        @Data(size=10)
        IString zValMov() ;
        
        @Data(size=10)
        IString zMovLocl() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tJuro() ;
        
        @Data(size=2)
        IString aAplOrig() ;
        
        @Data(size=1)
        IString iExisInfAdi() ;
        
        @Data(size=40)
        IString xChavAcsInfAdi() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    public interface Tabela extends IDataStruct {
        
        /**
         * @return instancia da classe local Lista
         */
        @Data(length=13)
        IArray<Lista> lista() ;
        
        
        public interface Lista extends IDataStruct {
            
            
            /**
             * @return instancia da classe local Item
             */
            @Data
            Item item() ;
            
            
            public interface Item extends IDataStruct {
                
                @Data(size=56)
                IString itemArgumento() ;
                
                @Data(size=171)
                IString itemDetalhe() ;
                
            }
        }
    }
    
}
