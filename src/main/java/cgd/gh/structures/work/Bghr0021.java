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
public interface Bghr0021 extends IDataStruct {
    
    /**
     * @return instancia da classe local Rgh00201
     */
    @Data
    Rgh00201 rgh00201() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * DEFINICAO DO FICHEIRO FGH002
     * FICHEIRO IMAGEM DA TABELA VGH00201_MOVHST
     * 
     * @version 2.0
     * 
     */
    public interface Rgh00201 extends IDataStruct {
        
        @Data(size=3)
        IString fgh002CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh002CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh002COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh002NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh002VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh002CTipoCont() ;
        
        @Data(size=3)
        IString fgh002CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh002NsDeposito() ;
        
        @Data(size=26)
        IString fgh002TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh002NsMovimento() ;
        
        @Data(size=10)
        IString fgh002ZValMov() ;
        
        @Data(size=10)
        IString fgh002ZMovLocl() ;
        
        @Data(size=1)
        IString fgh002IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh002MMovimento() ;
        
        @Data(size=1)
        IString fgh002IEstorno() ;
        
        @Data(size=3)
        IString fgh002CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh002MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh002MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh002MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh002XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh002NDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal fgh002TJuro() ;
        
        @Data(size=2)
        IString fgh002AAplOrig() ;
        
        @Data(size=1)
        IString fgh002IExisInfAdi() ;
        
        @Data(size=40)
        IString fgh002XChavAcsInfAdi() ;
        
        @Data(size=26)
        IString fgh002TsActzUlt() ;
        
        @Data(size=8)
        IString fgh002CUsidActzUlt() ;
        
    }
    
}
