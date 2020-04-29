package cgd.ho.structures.link;

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
public interface Bhol826a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ826A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL826A
     * COPY DE LINKAGE DO MHOJ826A DE CLASSIFICACAO MOVIMENTOS
     * EM CONTA D.O. POR CATEGORIA(CRITERIOS CGD)
     * MHOJ826A
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
            
            /**
             * @return instancia da classe local Subconta
             */
            @Data
            Subconta subconta() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=10)
            IString zMovimento() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=10)
            ILong nCheque() ;
            
            @Data(size=3)
            IString cPaisIsoaOpe() ;
            
            @Data(size=3)
            IString cMnemEgcOpe() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=4)
            IString aAplOrig() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbn() ;
            
            
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
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=20)
            IString dMovimento() ;
            
            @Data(size=3)
            IString cCatgMov() ;
            
            @Data(size=3)
            IString cCatgMovNvl1() ;
            
            @Data(size=1)
            IString iCatgNvl2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoEntNvl2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cAtbtEntNvl2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt vPoszIniEntNv2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt qCterCmpEntNv2() ;
            
            @Data(size=35)
            IString cIdCrdxCbcSepa() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
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
