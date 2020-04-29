package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk700 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk70002
     */
    @Data
    public abstract RegFwk70002 regFwk700() ;
    
    /**
     * @return instancia da classe local Rjd07001
     */
    @Data
    public abstract Rjd07001 rjd07001() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk70002 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk700FicheiroFgh873
         */
        @Data
        Fwk700FicheiroFgh873 fwk700FicheiroFgh873() ;
        
        /**
         * @return instancia da classe local Fwk700Pedido
         */
        @Data
        Fwk700Pedido fwk700Pedido() ;
        
        
        public interface Fwk700FicheiroFgh873 extends IDataStruct {
            
            @Data(size=3)
            IString fwk700CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk700CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk700COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk700NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk700VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk700CTipoCont() ;
            
            @Data(size=3)
            IString fwk700CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk700NsDeposito() ;
            
            @Data(size=26)
            IString fwk700TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk700NsMovimento() ;
            
            @Data(size=10)
            IString fwk700ZMovimento() ;
            
            @Data(size=21)
            IString fwk700DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk700MMovimento() ;
            
            @Data(size=1)
            IString fwk700SinalMov() ;
            
            @Data(size=1)
            IString fwk700IDbcr() ;
            
            @Data(size=1)
            IString fwk700IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk700MSldoCblo() ;
            
            @Data(size=1)
            IString fwk700SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk700MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk700SinalDpnl() ;
            
            @Data(size=10)
            IString fwk700ZValor() ;
            
            @Data(size=10)
            ILong fwk700NDocOpps() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk700MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk700SinalMovOrg() ;
            
            @Data(size=3)
            IString fwk700CMoedIsoOrg() ;
            
            @Data(size=9)
            IString fwk700CProduto() ;
            
            @Data(size=7)
            IInt fwk700CSectGrupo() ;
            
            @Data(size=4)
            IInt fwk700CCndzCont() ;
            
        }
        
        public interface Fwk700Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk700CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk700ZInicMov() ;
            
            @Data(size=10)
            IString fwk700ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk700TsPedido() ;
            
        }
    }
    public interface Rjd07001 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fjd070Chave
         */
        @Data
        Fjd070Chave fjd070Chave() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt fjd070NsPnde() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt fjd070NsPe20Ult() ;
        
        /**
         * @return instancia da classe local Fjd070XInfPends
         */
        @Data
        Fjd070XInfPends fjd070XInfPends() ;
        
        
        public interface Fjd070Chave extends IDataStruct {
            
            @Data(size=13, signed=true, compression=COMP3)
            ILong fjd070NConta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fjd070CBanco() ;
            
            @Data(size=3)
            IString fjd070CMoedIso() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fjd070NsDeposito() ;
            
        }
        
        public interface Fjd070XInfPends extends IDataStruct {
            
            @Data(length=20, size=97)
            IArray<IString> fjd070XInfPend() ;
            
        }
    }
}
