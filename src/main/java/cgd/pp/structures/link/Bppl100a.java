package cgd.pp.structures.link;

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
public interface Bppl100a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MPPK100A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BPPL100A AREA DE LIGACAO PARA O MPPK100A
     * MODULO QUE CALCULA O CHKD DO NIB DE CONTAS DO GCGD
     * E TRANSFORMA IBAN EM CONTA E CONTA EM IBAN
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * AREA INPUT
         */
        @Data(size=1, value=" ")
        IString iAccao() ;
        @Data
        @Condition("1")
        ICondition calcNib() ;
        @Data
        @Condition("2")
        ICondition devCont() ;
        @Data
        @Condition("3")
        ICondition calcCknib() ;
        
        
        @Data(size=3, value=" ")
        IString cIdioIso() ;
        
        @Data(size=3, value=" ")
        IString cPaisIsoaCont() ;
        
        /**
         * @return instancia da classe local ContaInput
         */
        @Data
        ContaInput contaInput() ;
        
        /**
         * @return instancia da classe local IbanInput
         */
        @Data
        IbanInput ibanInput() ;
        
        /**
         * AREA OUTPUT
         */
        @Data(size=4, value=" ")
        IString iban04Output() ;
        
        @Data(size=25, value=" ")
        IString iban25Output() ;
        
        @Data(size=21, value=" ")
        IString nib21Output() ;
        
        @Data(size=2, value="0")
        IInt vChkdNibOutput() ;
        
        /**
         * @return instancia da classe local IbanContaOutput
         */
        @Data
        IbanContaOutput ibanContaOutput() ;
        
        /**
         * ERROS
         */
        @Data(size=2, value=" ")
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
        @Condition("AU")
        ICondition autorizacao() ;
        @Data
        @Condition("FC")
        ICondition fimConsulta() ;
        @Data
        @Condition("  ")
        ICondition semErros() ;
        
        
        @Data(size=3, signed=true, value="0", compression=COMP3)
        IInt cSqlcode() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cRtnoEvenSwal() ;
        @Data
        @Condition("101")
        ICondition inputInsuf() ;
        @Data
        @Condition("102")
        ICondition dadosInvalidos() ;
        @Data
        @Condition("103")
        ICondition tabSCamposDefinido() ;
        @Data
        @Condition("104")
        ICondition indicadorInexistente() ;
        @Data
        @Condition("105")
        ICondition accaoInexistente() ;
        @Data
        @Condition("106")
        ICondition errSelThg00002() ;
        @Data
        @Condition("107")
        ICondition errSelThg00001() ;
        @Data
        @Condition("109")
        ICondition codInexistente() ;
        @Data
        @Condition("110")
        ICondition erroSelect() ;
        @Data
        @Condition("111")
        ICondition erroInsert() ;
        @Data
        @Condition("112")
        ICondition erroUpdate() ;
        @Data
        @Condition("113")
        ICondition erroDelete() ;
        @Data
        @Condition("114")
        ICondition registoInexistente() ;
        @Data
        @Condition("117")
        ICondition codTabInexistente() ;
        @Data
        @Condition("181")
        ICondition paisInexistente() ;
        
        
        @Data(size=50)
        IString msgErrob() ;
        
        @Data(size=8)
        IString nmTabela() ;
        
        @Data(size=2)
        IString aAplErr() ;
        
        @Data(size=8)
        IString modOrigemErro() ;
        
        /**
         * VARIAVEIS AUXILIARES
         */
        @Data(size=19, value=" ")
        IString numConta19() ;
        
        @Data(size=4)
        IString ibanConta() ;
        
        @Data(size=2)
        IInt nibIbanConta() ;
        
        @Data(size=2, value="0")
        IInt indice() ;
        
        @Data(size=6)
        IInt soma() ;
        
        @Data(size=6)
        IInt resto() ;
        
        @Data(size=6)
        IInt result() ;
        
        @Data(size=6)
        IInt result1() ;
        
        
        public interface ContaInput extends IDataStruct {
            
            @Data(size=4)
            IInt cBancNib() ;
            
            @Data(size=4)
            IInt cOeNib() ;
            
            /**
             * @return instancia da classe local Conta11Input
             */
            @Data
            Conta11Input conta11Input() ;
            
            
            public interface Conta11Input extends IDataStruct {
                
                @Data(size=7)
                IInt nsRdclNib() ;
                
                @Data(size=1)
                IInt vChkdNib() ;
                
                @Data(size=3)
                IInt cTipoNib() ;
                
            }
        }
        
        public interface IbanInput extends IDataStruct {
            
            @Data(size=4)
            IString ibanIban() ;
            
            /**
             * @return instancia da classe local IbanNibInput
             */
            @Data
            IbanNibInput ibanNibInput() ;
            
            
            public interface IbanNibInput extends IDataStruct {
                
                @Data(size=4)
                IInt cBancIban() ;
                
                @Data(size=4)
                IInt cOeIban() ;
                
                @Data(size=1)
                IInt cTipoIban1() ;
                
                @Data(size=7)
                IInt nsRdclIban() ;
                
                @Data(size=1)
                IInt vChkdIban() ;
                
                @Data(size=2)
                IInt cTipoIban2() ;
                
                @Data(size=2)
                IInt nibIban() ;
                
            }
        }
        
        public interface IbanContaOutput extends IDataStruct {
            
            @Data(size=4)
            IInt cBancIbanConta() ;
            
            @Data(size=4)
            IInt cOeIbanConta() ;
            
            /**
             * @return instancia da classe local Conta11Output
             */
            @Data
            Conta11Output conta11Output() ;
            
            
            public interface Conta11Output extends IDataStruct {
                
                @Data(size=7)
                IInt nsRdclIbanConta() ;
                
                @Data(size=1)
                IInt vChkdIbanConta() ;
                
                @Data(size=3)
                IInt cTipoIbanConta() ;
                
            }
        }
    }
    
}
