package cgd.hs.structures.link;

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
public interface Bhsl110a extends IDataStruct {
    
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
     * AREA DE LIGACAO COM A ROTINA MHSS110A
     * VALIDACAO DE RESTRICAO DE ACESSO A CONTAS
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=3)
            IString cPaisIsoaCont() ;
            
            @Data(size=4, signed=true)
            IInt cBancCont() ;
            
            @Data(size=4, signed=true)
            IInt cOeEgcCont() ;
            
            @Data(size=7, signed=true)
            IInt nsRdclCont() ;
            
            @Data(size=1, signed=true)
            IInt vChkdCont() ;
            
            @Data(size=3, signed=true)
            IInt cTipoCont() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=1)
            IString ctNvelAtrzBbn() ;
            
            @Data(size=8)
            IString cPerfUtlBbn() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
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
            @Condition("AT")
            ICondition errosArq() ;
            @Data
            @Condition(" ")
            ICondition semErros() ;
            @Data
            @Condition("DA")
            ICondition erroDadosEntrada() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=30)
            IString chvAces() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            @Data
            @Condition("BD")
            ICondition beginDeclare() ;
            @Data
            @Condition("CA")
            ICondition call() ;
            @Data
            @Condition("CL")
            ICondition closeCursor() ;
            @Data
            @Condition("CO")
            ICondition commit() ;
            @Data
            @Condition("DC")
            ICondition declareCursor() ;
            @Data
            @Condition("DL")
            ICondition delete() ;
            @Data
            @Condition("EI")
            ICondition prepareSql() ;
            @Data
            @Condition("EX")
            ICondition executeSql() ;
            @Data
            @Condition("FE")
            ICondition fetch() ;
            @Data
            @Condition("IN")
            ICondition insert() ;
            @Data
            @Condition("JN")
            ICondition join() ;
            @Data
            @Condition("LT")
            ICondition lockTable() ;
            @Data
            @Condition("OC")
            ICondition openCursor() ;
            @Data
            @Condition("RB")
            ICondition rollback() ;
            @Data
            @Condition("SE")
            ICondition select() ;
            @Data
            @Condition("UP")
            ICondition update() ;
            
            
            @Data(size=30)
            IString campErro() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    
}
