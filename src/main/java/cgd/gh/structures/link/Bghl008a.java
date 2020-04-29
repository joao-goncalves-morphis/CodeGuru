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
public interface Bghl008a extends IDataStruct {
    
    @Data(size=2)
    IString cAcesso() ;
    @Data
    @Condition({ "L ", "A ", "I ", "E " })
    ICondition acessoValido() ;
    @Data
    @Condition("L ")
    ICondition leitura() ;
    @Data
    @Condition("A ")
    ICondition actualizacao() ;
    @Data
    @Condition("I ")
    ICondition insercao() ;
    @Data
    @Condition("E ")
    ICondition eliminacao() ;
    
    
    @Data(size=3, signed=true, compression=COMP3)
    IInt cRtnoEvenSwal() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("233")
    ICondition dadosInvalidos() ;
    @Data
    @Condition("097")
    ICondition naoExisteMov() ;
    @Data
    @Condition("328")
    ICondition movJaExiste() ;
    @Data
    @Condition("216")
    ICondition erroDb2() ;
    
    
    @Data(size=2)
    IString cTipoErro() ;
    @Data
    @Condition("A1")
    ICondition abend() ;
    @Data
    @Condition("A2")
    ICondition abendDb2() ;
    @Data
    @Condition("FU")
    ICondition errosFuncao() ;
    @Data
    @Condition("FC")
    ICondition fimConsulta() ;
    
    
    @Data(size=8)
    IString nmTabela() ;
    
    @Data(size=9, signed=true, compression=COMP3)
    ILong cSqlcode() ;
    
    /**
     * @return instancia da classe local Argumento
     */
    @Data
    Argumento argumento() ;
    
    /**
     * @return instancia da classe local Detalhe
     */
    @Data
    Detalhe detalhe() ;
    
    /**
     * Inner Classes
     */
    public interface Argumento extends IDataStruct {
        
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
        
        @Data(size=26)
        IString tsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
    }
    public interface Detalhe extends IDataStruct {
        
        @Data(size=16)
        IString xRcnzMcblPrim() ;
        
        @Data(size=16)
        IString xRcnzMcblSegn() ;
        
        @Data(size=35)
        IString xRcnzMcblTerc() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    
}
