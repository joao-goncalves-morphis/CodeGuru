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
public interface Bhol727a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ727A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL727A
     * COPY DE LINKAGE DO MHOJ727A DE CALCULO DE DESCRITIVOS
     * PARA EXTRACTOS
     * MHOJ727A
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
             * @return instancia da classe local Conta
             */
            @Data
            Conta conta() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=1)
            IString iDcvoEspl() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCheque() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            
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
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=40)
            IString dMovimento() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            @Data
            @Condition("102")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("103")
            ICondition tabSemCampDef() ;
            @Data
            @Condition("104")
            ICondition indicadorInexist() ;
            @Data
            @Condition("105")
            ICondition accaoInexistente() ;
            @Data
            @Condition("106")
            ICondition erroSelThg00002() ;
            @Data
            @Condition("117")
            ICondition tabNaoExiste() ;
            @Data
            @Condition("170")
            ICondition inputMalFormatad() ;
            @Data
            @Condition("172")
            ICondition opcaoMalFormatad() ;
            @Data
            @Condition("173")
            ICondition opcaoInvalida() ;
            @Data
            @Condition("177")
            ICondition dataIncorrecta() ;
            @Data
            @Condition("181")
            ICondition prazoNaoExiste() ;
            
            
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
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
    }
    
}
