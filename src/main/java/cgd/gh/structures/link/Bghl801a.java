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
public interface Bghl801a extends IDataStruct {
    
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
    
    @Data(size=1)
    IString argSubconta() ;
    @Data
    @Condition("S")
    ICondition iDadosSubcontaS() ;
    @Data
    @Condition("N")
    ICondition iDadosSubcontaN() ;
    
    
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
        
        @Data(size=1)
        IString iDbcr() ;
        
    }
    public interface Detalhe extends IDataStruct {
        
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
        
        
        @Data(size=1)
        IString iTipoSpte() ;
        @Data
        @Condition("E")
        ICondition iTipoSpteExt() ;
        @Data
        @Condition("C")
        ICondition iTipoSpteCad() ;
        @Data
        @Condition("T")
        ICondition iTipoSpteTit() ;
        @Data
        @Condition("O")
        ICondition iTipoSpteOut() ;
        
        
        @Data(size=1)
        IString iDcvoEspl() ;
        @Data
        @Condition("S")
        ICondition iDcvoEsplS() ;
        @Data
        @Condition("N")
        ICondition iDcvoEsplN() ;
        
        
        @Data(size=20)
        IString cDcvoEspl() ;
        
        @Data(size=3)
        IString cFamiProd() ;
        
        @Data(size=3)
        IString cProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cCndzMovzCont() ;
        
    }
    
}
