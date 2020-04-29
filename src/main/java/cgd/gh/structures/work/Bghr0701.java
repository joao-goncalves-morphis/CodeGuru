package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr0701 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fgh070Registo
     */
    @Data
    Fgh070Registo fgh070Registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * REGISTO DO FICHEIRO FGH070
     * 
     * @version 2.0
     * 
     */
    public interface Fgh070Registo extends IDataStruct {
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070CCcmz() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070CCcmzApoi() ;
        
        @Data(size=4)
        IString fgh070CTerminal() ;
        
        @Data(size=26)
        IString fgh070TsTransaccao() ;
        
        @Data(size=2)
        IString fgh070AAplicacao() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070CBanco() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070CCcmzAtrx() ;
        
        @Data(size=3)
        IString fgh070CMoedIso() ;
        
        @Data(size=3)
        IString fgh070CMoedIsoMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh070CMtvoMov() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070COeGerx() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh070COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh070COpexAtrx() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh070CServPrsdCgd() ;
        
        @Data(size=9, signed=true, compression=COMP)
        ILong fgh070CTaxaJcrx() ;
        
        @Data(size=9, signed=true, compression=COMP)
        ILong fgh070CTaxaJdvx() ;
        
        @Data(size=9, signed=true, compression=COMP)
        ILong fgh070CTaxaJmba() ;
        
        @Data(size=9, signed=true, compression=COMP)
        ILong fgh070CTaxaNgcdJcrx() ;
        
        @Data(size=9, signed=true, compression=COMP)
        ILong fgh070CTaxaNgcdJdvx() ;
        
        @Data(size=9, signed=true, compression=COMP)
        ILong fgh070CTaxaNgcdMoba() ;
        
        @Data(size=4)
        IString fgh070CTransaccao() ;
        
        @Data(size=21)
        IString fgh070DMovOpps() ;
        
        @Data(size=6)
        IString fgh070DTransaccao() ;
        
        @Data(size=3)
        IString fgh070CClasTrnz() ;
        
        @Data(size=1)
        IString fgh070IEstorno() ;
        
        @Data(size=1)
        IString fgh070ILnctTot() ;
        
        @Data(size=1)
        IString fgh070IMovEfcdOnln() ;
        
        @Data(size=1)
        IString fgh070ITipoDocOpps() ;
        
        @Data(size=1)
        IString fgh070ITipoSltx() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MComsMoba() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MIs() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJcrx() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJdvx() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJcmg() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJmorSdvx() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MImposto() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MMovCtrv() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MMovDep() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MMovMoba() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MMovSldoDevx() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJmba() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MSldoCbloCtrv() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJuroPago() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MSldoDpnlApos() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070NsDeposito() ;
        
        @Data(size=13, signed=true, compression=COMP3)
        ILong fgh070NConta() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh070NDocOppsMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh070NSessAtmCgd() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh070NSessSibs() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MPremio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MDespesa() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh070MJuroCpst() ;
        
        @Data(size=26)
        IString fgh070TsMovAnt() ;
        
        @Data(size=10)
        IString fgh070ZValMov() ;
        
        @Data(size=26)
        IString fgh070TsMovimento() ;
        
    }
    
}
