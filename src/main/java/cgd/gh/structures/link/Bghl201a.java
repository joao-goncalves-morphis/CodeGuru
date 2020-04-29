package cgd.gh.structures.link;

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
public interface Bghl201a extends IDataStruct {
    
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
    
    @Data(size=8, value="MGHJ201A")
    IString mgh201aCon() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * APLICACAO     : GH - GESTAO DE HISTORICOS DE MOVIMENTOS
     * PROGRAMA      : MGHO201A
     * OBJECTIVO     : INFORMACAO SOBRE SUBCONTAS
     * 
     * @version 2.0
     * 
     */
    public interface DadosInput extends IDataStruct {
        
        @Data(size=2)
        IString cAccao() ;
        @Data
        @Condition({ "AS", "CS", "RS" })
        ICondition cAccaoValido() ;
        @Data
        @Condition("AS")
        ICondition abraScta() ;
        @Data
        @Condition("CS")
        ICondition ccltScta() ;
        @Data
        @Condition("RS")
        ICondition rabtScta() ;
        
        
        /**
         * @return instancia da classe local ArgumentoConta
         */
        @Data
        ArgumentoConta argumentoConta() ;
        
        /**
         * @return instancia da classe local ArgumentoData
         */
        @Data
        ArgumentoData argumentoData() ;
        
        
        public interface ArgumentoConta extends IDataStruct {
            
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
        
        public interface ArgumentoData extends IDataStruct {
            
            @Data(size=10)
            IString zAbraScta() ;
            
            @Data(size=10)
            IString zRabtScta() ;
            
            @Data(size=10)
            IString zCcltScta() ;
            
        }
    }
    public interface DadosOutput extends IDataStruct {
        
        /**
         * @return instancia da classe local GrErroBbn
         */
        @Data
        GrErroBbn grErroBbn() ;
        
        
        public interface GrErroBbn extends IDataStruct {
            
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
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoSwal() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErro() ;
            
        }
    }
    
}
