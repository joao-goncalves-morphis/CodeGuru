package cgd.hm.structures.link;

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
public interface Bhml215a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHMJ215A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHML215A - AREA DE LIGACAO PARA O MODULO MHMJ215A
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
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=3)
            IString cPaisIsoaFich() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=10)
            IString zMovimento() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nDocOppsMov() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=17, decimal=2, signed=true)
            IDecimal mMovimento() ;
            
            @Data(size=3)
            IString cMoeIsoSctaMov() ;
            
            /**
             * @return instancia da classe local NibDstn
             */
            @Data
            NibDstn nibDstn() ;
            
            @Data(size=36)
            IString nmOrdn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cOpeSibs() ;
            
            @Data(size=30)
            IString dOpeSibs() ;
            
            /**
             * @return instancia da classe local DadosAdic
             */
            @Data
            DadosAdic dadosAdic() ;
            
            /**
             * @return instancia da classe local NibOrdn
             */
            @Data
            NibOrdn nibOrdn() ;
            
            
            public interface NibDstn extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContDstn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContDstn() ;
                
                @Data(size=8, signed=true, compression=COMP3)
                ILong nsRdclContDstn() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContDstn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt cTipoContDstn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt vChkdNibDstn() ;
                
            }
            
            public interface DadosAdic extends IDataStruct {
                
                @Data(size=3)
                IString cCrtzMovCrcb() ;
                
                @Data(size=20)
                IString xRefAdcCrxSibs() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nIdCrdxSibs() ;
                
                @Data(size=35)
                IString xRefMovOrig() ;
                
                @Data(size=1)
                IString iSepa() ;
                
            }
            
            public interface NibOrdn extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContOrdn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContOrdn() ;
                
                @Data(size=8, signed=true, compression=COMP3)
                ILong nsRdclContOrdn() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContOrdn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt cTipoContOrdn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt vChkdNibOrdn() ;
                
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
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
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
