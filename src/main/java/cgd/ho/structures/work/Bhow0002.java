package cgd.ho.structures.work;

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
public interface Bhow0002 extends IDataStruct {
    
    /**
     * @return instancia da classe local AreaComum
     */
    @Data
    AreaComum areaComum() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOW0002 - COPY WORKING DE VALIDACAO DE CONTA MODO MISTO
     * 
     * @version 2.0
     * 
     */
    public interface AreaComum extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        @Data(size=8, value="VHO00101")
        IString vho00101() ;
        
        @Data(size=8, value="BHOP0002")
        IString bhop0002() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local Descompactador
         */
        @Data
        Descompactador descompactador() ;
        
        /**
         * @return instancia da classe local Status
         */
        @Data
        Status status() ;
        
        
        public interface DadosInput extends IDataStruct {
            
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
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cPerfUtlBbn() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt ctNvelAtrzBbn() ;
            
            @Data(size=1)
            IString iRstzAcesCont() ;
            @Data
            @Condition("0")
            ICondition iraConNao() ;
            @Data
            @Condition("1")
            ICondition iraConSim() ;
            @Data
            @Condition("2")
            ICondition iraConValSim() ;
            @Data
            @Condition("3")
            ICondition iraConValNao() ;
            
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("-150")
            ICondition utilSemAcesso() ;
            @Data
            @Condition("003")
            ICondition ctaNaoExiste() ;
            @Data
            @Condition("005")
            ICondition erroBaseDados() ;
            
            
            @Data(size=8, value=" ")
            IString nmTabela() ;
            
            @Data(size=8, value=" ")
            IString modOrigemErro() ;
            
            @Data(size=40, value=" ")
            IString chAcesso() ;
            
            @Data(size=50, value=" ")
            IString msgErrob() ;
            
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
            @Condition(" ")
            ICondition semErros() ;
            @Data
            @Condition({ " ", "FU", "FC" })
            ICondition errosValidos() ;
            
            
        }
        
        public interface Descompactador extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaContD() ;
            
            @Data(size=4)
            IInt cBancContD() ;
            
            @Data(size=4)
            IInt cOeEgcContD() ;
            
            @Data(size=7)
            IInt nsRdclContD() ;
            
            @Data(size=1)
            IInt vChkdContD() ;
            
            @Data(size=3)
            IInt cTipoContD() ;
            
        }
        
        public interface Status extends IDataStruct {
            
            @Data(size=3, signed=true, value="0")
            IInt sqlcodeVho00101() ;
            @Data
            @Condition("0")
            ICondition vho00101Ok() ;
            @Data
            @Condition("100")
            ICondition vho00101Notfnd() ;
            
            
        }
    }
    
}
