package cgd.hy.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhyr0031 extends IDataStruct {
    
    @Data(size=100)
    IString fhy003Area() ;
    
    /**
     * @return instancia da classe local Fhy003AreaCabc
     */
    @Data
    @Mask
    Fhy003AreaCabc fhy003AreaCabc() ;
    
    /**
     * @return instancia da classe local Fhy003AreaDb2
     */
    @Data
    @Mask
    Fhy003AreaDb2 fhy003AreaDb2() ;
    
    /**
     * @return instancia da classe local Fhy003AreaFich
     */
    @Data
    @Mask
    Fhy003AreaFich fhy003AreaFich() ;
    
    /**
     * @return instancia da classe local Fhy003AreaRoti
     */
    @Data
    @Mask
    Fhy003AreaRoti fhy003AreaRoti() ;
    
    /**
     * Inner Classes
     */
    public interface Fhy003AreaCabc extends IDataMask {
        
        @Data(size=8)
        IString fhy003NmPrograma() ;
        
        @Data(size=50, lpadding=1)
        IString fhy003DFunlPrg() ;
        
        @Data(size=10, lpadding=1)
        IString fhy003ZInicPrct() ;
        
        @Data(size=8, lpadding=1)
        IString fhy003HInicPrct() ;
        
        @Data(size=10, lpadding=1)
        IString fhy003ZFimPrct() ;
        
        @Data(size=8, lpadding=1, rpadding=1)
        IString fhy003HFimPrct() ;
        
    }
    public interface Fhy003AreaDb2 extends IDataMask {
        
        @Data(size=18)
        IString fhy003NmTabela() ;
        
        @Data(size=2, lpadding=1)
        IString fhy003CTipoOpeObjDb2() ;
        
        @Data(size=9, signed=true, lpadding=1)
        ILong fhy003CSqlcode() ;
        
        @Data(size=10, lpadding=1, rpadding=58)
        ILong fhy003QAcesTab() ;
        
    }
    public interface Fhy003AreaFich extends IDataMask {
        
        @Data(size=6)
        IString fhy003NmFicheiro() ;
        
        @Data(size=2, lpadding=1)
        IString fhy003CTipoOpeFich() ;
        
        @Data(size=2, lpadding=1)
        IString fhy003CFsttCobl() ;
        
        @Data(size=10, lpadding=1, rpadding=78)
        ILong fhy003QAcesFich() ;
        
    }
    public interface Fhy003AreaRoti extends IDataMask {
        
        @Data(size=8)
        IString fhy003NmRtnaAces() ;
        
        @Data(size=1, lpadding=1)
        IString fhy003IOperacao() ;
        
        @Data(size=2, lpadding=1)
        IString fhy003AAplErr() ;
        
        @Data(size=2, lpadding=1)
        IString fhy003CTipoErroBbn() ;
        
        @Data(size=3, signed=true, lpadding=1)
        IInt fhy003CRtnoEvenSwal() ;
        
        @Data(size=10, lpadding=1, rpadding=69)
        ILong fhy003QAcesRtna() ;
        
    }
    
}
