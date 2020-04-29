package cgd.hs.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhsk0002 extends IDataStruct {
    
    @Data(size=2, value="HS")
    IString aplicSegranca() ;
    
    /**
     * @return instancia da classe local Numericas
     */
    @Data
    Numericas numericas() ;
    
    /**
     * @return instancia da classe local Rotinas
     */
    @Data
    Rotinas rotinas() ;
    
    /**
     * @return instancia da classe local Tabelas
     */
    @Data
    Tabelas tabelas() ;
    
    /**
     * Inner Classes
     */
    public interface Numericas extends IDataStruct {
        
        @Data(size=1, value="1")
        IInt con1() ;
        
    }
    
    /**
     * 
     * CONSTANTES ROTINAS
     * 
     * @version 2.0
     * 
     */
    public interface Rotinas extends IDataStruct {
        
        @Data(size=8, value="MHSS100A")
        IString rotElimRetAcesCts() ;
        
        @Data(size=8, value="MHSJ110A")
        IString rotValRestAcesCts() ;
        
        @Data(size=8, value="MHSJ130A")
        IString conUtil() ;
        
        @Data(size=8, value="MHSS009A")
        IString vldMoper() ;
        
        @Data(size=8, value="MHSS010A")
        IString vldAut() ;
        
        @Data(size=8, value="MHSS001A")
        IString vldUserid() ;
        
        @Data(size=8, value="MHSS002A")
        IString vldPerfil() ;
        
        @Data(size=8, value="MHSS013A")
        IString vldAcesTabGer() ;
        
        @Data(size=8, value="PHYQ150A")
        IString actDesAplTran() ;
        
    }
    
    /**
     * 
     * DESCRICAO DE TABELAS
     * 
     * @version 2.0
     * 
     */
    public interface Tabelas extends IDataStruct {
        
        @Data(size=8, value="VHS00101")
        IString vhs00101() ;
        
        @Data(size=8, value="VHS00201")
        IString vhs00201() ;
        
        @Data(size=8, value="VHS00301")
        IString vhs00301() ;
        
        @Data(size=8, value="VHS00501")
        IString vhs00501() ;
        
        @Data(size=8, value="VHS00601")
        IString vhs00601() ;
        
        @Data(size=8, value="VHS00901")
        IString vhs00901() ;
        
        @Data(size=8, value="VHS01001")
        IString vhs01001() ;
        
        @Data(size=8, value="VHS01201")
        IString vhs01201() ;
        
        @Data(size=8, value="VHS01301")
        IString vhs01301() ;
        
        @Data(size=8, value="VHS01401")
        IString vhs01401() ;
        
        @Data(size=8, value="VHS01501")
        IString vhs01501() ;
        
        @Data(size=8, value="VHS01601")
        IString vhs01601() ;
        
        @Data(size=8, value="VHS01701")
        IString vhs01701() ;
        
        @Data(size=8, value="VHS01901")
        IString vhs01901() ;
        
        @Data(size=8, value="VHS02001")
        IString vhs02001() ;
        
        @Data(size=8, value="VHS02201")
        IString vhs02201() ;
        
    }
    
}
