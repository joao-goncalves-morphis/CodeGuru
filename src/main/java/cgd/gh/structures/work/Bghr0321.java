package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr0321 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPYBOOK : BGHR0321
     * DATA    /    AUTOR     / DESCRICAO :
     * 17-12-2018 /   MARGARIDA  / ---------
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * 05 BGHR0321-C-BANC-CONT            PIC S9(04) COMP-3.
         * 05 BGHR0321-C-OE-CONT              PIC S9(04) COMP-3.
         * 05 BGHR0321-NS-RDCL-CONT           PIC S9(07) COMP-3.
         * 05 BGHR0321-V-CHKD-CONT            PIC S9(01) COMP-3.
         * 05 BGHR0321-C-TIPO-CONT            PIC S9(03) COMP-3.
         * 05 BGHR0321-NS-DEPOSITO            PIC S9(4)V COMP-3.
         * 05 BGHR0321-NS-MOVIMENTO           PIC S9(15)V COMP-3.
         */
        @Data(size=4)
        IInt cBancCont() ;
        
        @Data(size=4)
        IInt cOeCont() ;
        
        @Data(size=7)
        IInt nsRdclCont() ;
        
        @Data(size=1)
        IInt vChkdCont() ;
        
        @Data(size=3)
        IInt cTipoCont() ;
        
        @Data(size=1)
        IString separador1() ;
        
        @Data(size=4)
        IInt nsDeposito() ;
        
        @Data(size=1)
        IString separador2() ;
        
        @Data(size=15)
        ILong nsMovimento() ;
        
        @Data(size=1)
        IString separador3() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=1)
        IString separador4() ;
        
        /**
         * 05 BGHR0321-M-MOVIMENTO            PIC S9(15)V9(2) COMP-3.
         * @return instancia da classe local MMovimento
         */
        @Data
        MMovimento mMovimento() ;
        
        @Data(size=1)
        IString separador5() ;
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(size=1)
        IString separador6() ;
        
        @Data(size=10)
        IString zValMov() ;
        
        @Data(size=1)
        IString separador7() ;
        
        @Data(size=10)
        IString zMovLocl() ;
        
        
        
        /**
         * 
         * 05 BGHR0321-M-MOVIMENTO            PIC S9(15)V9(2) COMP-3.
         * 
         * @version 2.0
         * 
         */
        public interface MMovimento extends IDataStruct {
            
            @Data(size=15)
            ILong mMovimento1() ;
            
            @Data(size=1)
            IString sinal() ;
            
            @Data(size=2)
            IInt mMovimento2() ;
            
        }
    }
    
}
