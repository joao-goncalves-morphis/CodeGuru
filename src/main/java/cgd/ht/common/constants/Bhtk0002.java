package cgd.ht.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtk0002 extends IDataStruct {
    
    @Data(size=2, value="HT")
    IString siglaArquit() ;
    
    @Data(size=4, value="BALC")
    IString canalBalcao() ;
    
    @Data(size=4, value="BATC")
    IString canalBatch() ;
    
    @Data(size=4, value="INTR")
    IString canalInternet() ;
    
    @Data(size=8, value="MHTJ300A")
    IString rotSequen() ;
    
    @Data(size=8, value="MHTQ200A")
    IString rotDatasAplic() ;
    
    @Data(size=8, value="MHTQ250A")
    IString rotDatasDAplic() ;
    
    @Data(size=8, value="MHTK100A")
    IString rotChkDigito() ;
    
    @Data(size=8, value="MHTK400A")
    IString rotAddtMont() ;
    
    @Data(size=8, value="MHTS540A")
    IString rotJobOnline() ;
    
    @Data(size=8, value="MHTQ034A")
    IString rotRecuperacao() ;
    
    /**
     * @return instancia da classe local IndErros
     */
    @Data
    IndErros indErros() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * I N D I C A D O R E S   D E    E R R O
     * 
     * @version 2.0
     * 
     */
    public interface IndErros extends IDataStruct {
        
        @Data(size=2, value="A1")
        IString abend() ;
        
        @Data(size=2, value="A2")
        IString abendDb2() ;
        
        @Data(size=2, value="A3")
        IString abendCics() ;
        
        @Data(size=2, value="AT")
        IString errosArq() ;
        
        @Data(size=2, value="FU")
        IString errosFuncao() ;
        
        @Data(size=2, value="FT")
        IString errosTele() ;
        
        @Data(size=2, value="AU")
        IString autorizacao() ;
        
        @Data(size=2, value="FC")
        IString fimConsulta() ;
        
        @Data(size=2, value="CC")
        IString contConsulta() ;
        
        @Data(size=2, value="RB")
        IString rollback() ;
        
        @Data(size=2, value="AT")
        IString xerroInex() ;
        
        @Data(size=2, value="PF")
        IString pgmFuncao() ;
        
        @Data(size=2, value="NF")
        IString npgmFuncao() ;
        
        @Data(size=2, value="LP")
        IString limPaginas() ;
        
    }
    
}
