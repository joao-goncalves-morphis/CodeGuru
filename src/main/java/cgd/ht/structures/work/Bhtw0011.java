package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
public interface Bhtw0011 extends IDataStruct {
    
    /**
     * @return instancia da classe local AreaDados
     */
    @Data
    AreaDados areaDados() ;
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=1, value=" ")
    IString alMhtq111a() ;
    
    @Data(size=8, value="MHTQ111A")
    IString rotinaRollback() ;
    
    @Data(size=2)
    IString returnCode() ;
    @Data
    @Condition("16")
    ICondition erro() ;
    
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTW0011: AREA DE LIGACAO COM O MODULO DE DADOS DEFAULT
     * PARA PROCESSAMENTO BATCH
     * 
     * @version 2.0
     * 
     */
    public interface AreaDados extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInternos
         */
        @Data
        DadosInternos dadosInternos() ;
        
        public static final String CON_C_MNEM_EGC_REF_FER_LX = "CGD" ;
        
        public static final String CON_C_PAIS_OE_REF_FER_LX = "PT " ;
        
        public static final int CON_C_OE_EGC_REF_FER_LX = 1 ;
        
        public static final String CON_C_MNEM_EMP_CPD = "CGD" ;
        
        public static final String CON_C_PAIS_ISOA_CPD = "PT " ;
        
        public static final int CON_C_OE_CPD = 9500 ;
        
        public static final String CON_C_MNEM_EMP_GCX = "CGD" ;
        
        public static final int CON_C_BANCO = 35 ;
        
        public static final String CON_C_TIPO_CANL_ACES = "BATC" ;
        
        
        public interface DadosInternos extends IDataStruct {
            
            @Data(size=2, value="00")
            IString statusFht011() ;
            @Data
            @Condition("00")
            ICondition fht011Ok() ;
            @Data
            @Condition("10")
            ICondition fht011Fim() ;
            
            
        }
    }
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=3)
            IString cMnemEgcRefFerLx() ;
            
            @Data(size=3)
            IString cPaisOeRefFerLx() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcRefFerLx() ;
            
            @Data(size=3)
            IString cMnemEmpCpd() ;
            
            @Data(size=3)
            IString cPaisIsoaCpd() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeCpd() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
        }
    }
    
}
