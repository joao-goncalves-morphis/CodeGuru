package cgd.gh.structures.work;

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
public interface Bghr4381 extends IDataStruct {
    
    @Data(size=86)
    IString fgh438Registo() ;
    
    /**
     * @return instancia da classe local Fgh438DadosSaldo
     */
    @Data
    @Mask
    Fgh438DadosSaldo fgh438DadosSaldo() ;
    
    @Data(size=86)
    @Mask
    IString fgh438MsgErro() ;
    
    /**
     * Inner Classes
     */
    public interface Fgh438DadosSaldo extends IDataMask {
        
        /**
         * 05 FGH438-N-CLIENTE         PIC S9(10) COMP-3.
         */
        @Data(size=10)
        ILong fgh438NCliente() ;
        
        @Data(size=1)
        IString fgh438Separador1() ;
        
        @Data(size=3)
        IString fgh438CPaisIsoaCont() ;
        
        /**
         * 05 FGH438-C-BANC-CONT       PIC S9(04) COMP-3.
         * 05 FGH438-C-OE-EGC-CONT     PIC S9(04) COMP-3.
         * 05 FGH438-NS-RDCL-CONT      PIC S9(07) COMP-3.
         * 05 FGH438-V-CHKD-CONT       PIC S9(01) COMP-3.
         * 05 FGH438-C-TIPO-CONT       PIC S9(03) COMP-3.
         */
        @Data(size=4)
        IInt fgh438CBancCont() ;
        
        @Data(size=4)
        IInt fgh438COeEgcCont() ;
        
        @Data(size=7)
        IInt fgh438NsRdclCont() ;
        
        @Data(size=1)
        IInt fgh438VChkdCont() ;
        
        @Data(size=3)
        IInt fgh438CTipoCont() ;
        
        @Data(size=1)
        IString fgh438Separador2() ;
        
        @Data(size=10)
        IString fgh438DataSaldo() ;
        
        @Data(size=1)
        IString fgh438Separador3() ;
        
        /**
         * 05 FGH438-SLDO-CBLO-APOS    PIC S9(15)V9(2) COMP-3.
         * 05 FGH438-SLDO-DPNL-APOS    PIC S9(15)V9(2) COMP-3.
         * 05 FGH438-SLDO-CBLO-APOS    PIC ZZZZZZZZZZZZZZZ.ZZ.
         * @return instancia da classe local Fgh438SldoCbloApos
         */
        @Data
        Fgh438SldoCbloApos fgh438SldoCbloApos() ;
        
        @Data(size=1)
        IString fgh438Separador4() ;
        
        /**
         * 05 FGH438-SLDO-DPNL-APOS    PIC ZZZZZZZZZZZZZZZ.ZZ.
         * @return instancia da classe local Fgh438SldoDpnlApos
         */
        @Data
        Fgh438SldoDpnlApos fgh438SldoDpnlApos() ;
        
        @Data(size=1)
        IString fgh438Separador5() ;
        
        @Data(size=3)
        IString fgh438Moeda() ;
        
        
        
        /**
         * 
         * 05 FGH438-SLDO-CBLO-APOS    PIC S9(15)V9(2) COMP-3.
         * 05 FGH438-SLDO-DPNL-APOS    PIC S9(15)V9(2) COMP-3.
         * 05 FGH438-SLDO-CBLO-APOS    PIC ZZZZZZZZZZZZZZZ.ZZ.
         * 
         * @version 2.0
         * 
         */
        public interface Fgh438SldoCbloApos extends IDataMask {
            
            @Data(size=15)
            ILong fgh438SaldoCblo1() ;
            
            @Data(size=1)
            IString fgh438Sinal1() ;
            
            @Data(size=2)
            IInt fgh438SaldoCblo2() ;
            
        }
        
        
        /**
         * 
         * 05 FGH438-SLDO-DPNL-APOS    PIC ZZZZZZZZZZZZZZZ.ZZ.
         * 
         * @version 2.0
         * 
         */
        public interface Fgh438SldoDpnlApos extends IDataMask {
            
            @Data(size=15)
            ILong fgh438SaldoDpnl1() ;
            
            @Data(size=1)
            IString fgh438Sinal2() ;
            
            @Data(size=2)
            IInt fgh438SaldoDpnl2() ;
            
        }
    }
    
}
