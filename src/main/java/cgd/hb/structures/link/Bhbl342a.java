package cgd.hb.structures.link;

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
public interface Bhbl342a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHBJ342A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHBL342A - AREA DE LIGACAO AO MODULO MHBJ342A
     * ROTINA VIZUALIZACAO DE ENCARGOS PENDENTES POR Nº ELECTRONICO
     * JOURNAL
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
             * @return instancia da classe local CamposObrig
             */
            @Data
            CamposObrig camposObrig() ;
            
            @Data(size=1)
            IString iDebug() ;
            @Data
            @Condition("S")
            ICondition debugS() ;
            @Data
            @Condition("N")
            ICondition debugN() ;
            
            
            
            public interface CamposObrig extends IDataStruct {
                
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
                
                @Data(size=10)
                IString zProcessamento() ;
                
                @Data(size=3)
                IString cMnemEgcOpex() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcOpex() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong nJourBbn() ;
                
                @Data(size=2)
                IString aAplicacao() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=1)
                IString iDbcr() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=4)
            IString cSeveOpel() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=1)
            IString cEstPagEncg() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nContribuinte() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cSectIttlBpor() ;
            
            @Data(size=1)
            IString iTipoPagEncg() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt qEncargos() ;
            
            /**
             * @return instancia da classe local TabelaEncargos
             */
            @Data(length=5)
            IArray<TabelaEncargos> tabelaEncargos() ;
            
            
            public interface TabelaEncargos extends IDataStruct {
                
                
                @Data(size=1)
                IString cTipoEncg() ;
                
                @Data(size=3)
                IString cEncargo() ;
                
                @Data(size=3)
                IString cMoeIsoPaisEcg() ;
                
                @Data(size=5)
                IString cOpeBbnEncg() ;
                
                @Data(size=5)
                IString cOpeBbnEcgAnlz() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncgStd() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncgNgcd() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncgIsenUtl() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncargo() ;
                
                @Data(size=3)
                IString cImposto() ;
                
                @Data(size=3)
                IString cMoedIsoImp() ;
                
                @Data(size=5)
                IString cOpeBbnImp() ;
                
                @Data(size=5)
                IString cOpeBbnImpAnlz() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mImposto() ;
                
                @Data(size=10, decimal=7, compression=COMP3)
                IDecimal tImposto() ;
                
                @Data(size=10, decimal=7, compression=COMP3)
                IDecimal tImpStd() ;
                
                @Data(size=5)
                IString cOpeBbnIsezImp() ;
                
                @Data(size=5)
                IString cOpeBbnIseAnlz() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mIsezImp() ;
                
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
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
            ICondition errosFuncao() ;
            @Data
            @Condition("DA")
            ICondition dadosEntrada() ;
            @Data
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
    }
    
}
