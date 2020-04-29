package cgd.hv.structures.link;

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
public interface Bhvl152a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHVJ152A")
    IString conMhvj152a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHVL152A - COES MULTIEMPRESA
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
         * @return instancia da classe local AreaOutput
         */
        @Data(length=2)
        IArray<AreaOutput> areaOutput() ;
        
        /**
         * @return instancia da classe local AreaErro
         */
        @Data
        AreaErro areaErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancOpex() ;
            
            @Data(size=3)
            IString cPaisIsoaDst() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancDest() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=3)
            IString cMoedIsoOpex() ;
            
            @Data(size=1)
            IString cFineOpelCont() ;
            
            @Data(size=10)
            IString zPrctJourBbn() ;
            
        }
        
        public interface AreaOutput extends IDataStruct {
            
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
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=1)
            IString iGrazCoe() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cSectIttlBpor() ;
            
            @Data(size=1)
            IString iClszTtr1Cont() ;
            
            @Data(size=1)
            IString iEmpsNomeIdvl() ;
            
            @Data(size=2)
            IString cTipoTrttCont() ;
            
            @Data(size=2)
            IString aAplInszJour() ;
            
            @Data(size=3)
            IString cOpczMenu() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
        }
        
        public interface AreaErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
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
