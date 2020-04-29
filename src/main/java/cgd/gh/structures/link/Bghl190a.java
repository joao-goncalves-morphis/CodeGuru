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
public interface Bghl190a extends IDataStruct {
    
    /**
     * @return instancia da classe local DadosInput
     */
    @Data
    DadosInput dadosInput() ;
    
    /**
     * @return instancia da classe local DadosOutput
     */
    @Data
    DadosOutput dadosOutput() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHL190A- AREA DE LIGACAO AO MODULO MGHO190A
     * OBTEM 30 ULTIMOS MOVIMENTOS DA SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface DadosInput extends IDataStruct {
        
        /**
         * @return instancia da classe local CriterioConsulta
         */
        @Data
        CriterioConsulta criterioConsulta() ;
        
        /**
         * @return instancia da classe local Conta
         */
        @Data
        Conta conta() ;
        
        /**
         * @return instancia da classe local Movimento
         */
        @Data
        Movimento movimento() ;
        
        /**
         * @return instancia da classe local KeyContz
         */
        @Data
        KeyContz keyContz() ;
        
        
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
        
        public interface Conta extends IDataStruct {
            
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
            
        }
        
        public interface Movimento extends IDataStruct {
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt qMovRtno() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=10)
            IString zInicio() ;
            
            @Data(size=10)
            IString zFim() ;
            
        }
        
        public interface KeyContz extends IDataStruct {
            
            @Data(size=26)
            IString tsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
        }
    }
    public interface DadosOutput extends IDataStruct {
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong cSqlcode() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cRtnoEvenSwal() ;
        
        @Data(size=8)
        IString nmTabela() ;
        
        @Data(size=2)
        IString aAplErr() ;
        
        @Data(size=2)
        IString cTipoErroBbn() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qPndeEnvr() ;
        
        /**
         * @return instancia da classe local Movimentos
         */
        @Data(length=30)
        IArray<Movimentos> movimentos() ;
        
        @Data(size=26)
        IString tsMovimentoK() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimentoK() ;
        
        
        public interface Movimentos extends IDataStruct {
            
            
            @Data(size=10)
            IString zMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimentoO() ;
            
            @Data(size=10)
            IString zValMov() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
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
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nDocOpps() ;
            
            @Data(size=2)
            IString aAplOrig() ;
            
            @Data(size=5, decimal=3, signed=true, compression=COMP3)
            IDecimal tJuro() ;
            
        }
    }
    
}
