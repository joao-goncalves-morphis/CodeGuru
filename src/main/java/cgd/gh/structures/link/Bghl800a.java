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
public interface Bghl800a extends IDataStruct {
    
    @Data(size=3)
    IInt cRetorno() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("233")
    ICondition dadosInvalidos() ;
    @Data
    @Condition("097")
    ICondition naoExiste() ;
    @Data
    @Condition("098")
    ICondition naoExisteConta() ;
    @Data
    @Condition("216")
    ICondition db2() ;
    
    
    @Data(size=9, signed=true, compression=COMP3)
    ILong cSqlcode() ;
    
    @Data(size=8)
    IString nmPrograma() ;
    
    /**
     * @return instancia da classe local Input
     */
    @Data
    Input input() ;
    
    /**
     * @return instancia da classe local Output
     */
    @Data
    Output output() ;
    
    /**
     * Inner Classes
     */
    public interface Input extends IDataStruct {
        
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
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=10)
        IString zValMov() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
    }
    public interface Output extends IDataStruct {
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(size=2)
        IString cTipoTrttCont() ;
        @Data
        @Condition("01")
        ICondition trttDepOrdem() ;
        @Data
        @Condition("02")
        ICondition trttPoupanca() ;
        @Data
        @Condition("03")
        ICondition trttDepPrazo() ;
        @Data
        @Condition("09")
        ICondition trttDepEstru() ;
        @Data
        @Condition("12")
        ICondition trttDepObrig() ;
        @Data
        @Condition("19")
        ICondition trttCtaMarg() ;
        @Data
        @Condition("26")
        ICondition trttCashCarry() ;
        @Data
        @Condition("27")
        ICondition trttCtaVostr() ;
        @Data
        @Condition("28")
        ICondition trttCtaNostr() ;
        @Data
        @Condition("32")
        ICondition trttCtaInter() ;
        
        
    }
    
}
