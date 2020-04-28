package cgd.ho.structures.link;

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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhol354a extends IDataStruct {
    
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
     * BHOL354A - DEVOLVE INFORMACAO SOBRE SALDOS COMPLEMENTARES
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * HO23870 - FIM
         * @return instancia da classe local AreaOutput
         */
        @Data
        AreaOutput areaOutput() ;
        
        /**
         * HO23870 - FIM
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=2)
            IString modoAcesso() ;
            @Data
            @Condition("CM")
            ICondition consultaMovDia() ;
            
            
            /**
             * HO23870 - FIM
             * @return instancia da classe local Subconta
             */
            @Data
            Subconta subconta() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=1)
            IString iMovDia() ;
            
            /**
             * HO23870 - INI
             */
            @Data(size=10)
            IString zMovIni() ;
            
            @Data(size=10)
            IString zMovFim() ;
            
            /**
             * @return instancia da classe local ICritMontante
             */
            @Data
            ICritMontante iCritMontante() ;
            
            @Data(size=1)
            IString iCritDbcr() ;
            @Data
            @Condition("T")
            ICondition debito() ;
            @Data
            @Condition("C")
            ICondition credito() ;
            @Data
            @Condition(" ")
            ICondition ambos() ;
            
            
            
            
            /**
             * 
             * HO23870 - FIM
             * 
             * @version 2.0
             * 
             */
            public interface Subconta extends IDataStruct {
                
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
            
            public interface ICritMontante extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMin() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMax() ;
                
            }
        }
        
        
        /**
         * 
         * HO23870 - FIM
         * 
         * @version 2.0
         * 
         */
        public interface AreaOutput extends IDataStruct {
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mSldoRetd() ;
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mSldoVcob() ;
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mSldoVcobUtid() ;
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mDcboNgcdUtid() ;
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mCmrgLim() ;
            
            @Data(size=17, decimal=2, compression=COMP3)
            IDecimal mCmrgUtid() ;
            
            /**
             * HO23870 - INI
             */
            @Data(size=15, signed=true, compression=COMP3)
            ILong qMovHo() ;
            
        }
        
        
        /**
         * 
         * HO23870 - FIM
         * 
         * @version 2.0
         * 
         */
        public interface DadosErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
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
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
