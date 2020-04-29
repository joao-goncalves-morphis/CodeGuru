package cgd.gh.persistence.files;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.persistence.files.DataFileHandler ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk504 extends DataFileHandler {
    /**
     * Inner Classes
     */
    public interface Rwk50301 extends IDataStruct {
        
        @Data
        Fwk503Subconta fwk503Subconta() ;
        
        @Data(size=15)
        ILong fwk503NsMovimento() ;
        
        @Data(size=10)
        IString fwk503ZMovimento() ;
        
        @Data(size=10)
        IString fwk503ZValor() ;
        
        @Data(size=21)
        IString fwk503XRefMov() ;
        
        @Data(size=3)
        IString fwk503CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MMovMoeOrigMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MMovimento() ;
        
        @Data(size=1)
        IString fwk503IEstorno() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MSldoCblo() ;
        
        @Data(size=1)
        IString fwk503ISinalSldoCblo() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MSldoDpnl() ;
        
        @Data(size=1)
        IString fwk503ISinalSldoDpnl() ;
        
        @Data(size=4)
        IString fwk503CTipoCanlAces() ;
        
        @Data(size=3)
        IString fwk503CMnemEgcOpex() ;
        
        @Data(size=3)
        IString fwk503CPaisIsoaOeOpx() ;
        
        @Data(size=4)
        IInt fwk503COeEgcOpex() ;
        
        @Data(size=2)
        IString fwk503AAplicacao() ;
        
        @Data(size=3)
        IString fwk503COpczMenu() ;
        
        @Data(size=10)
        ILong fwk503NCheque() ;
        
        @Data(size=4)
        IString fwk503CEvenOpel() ;
        
        @Data(size=1)
        IString fwk503IDbcr() ;
        
        @Data
        Fwk503Pedido fwk503Pedido() ;
        
        
        public interface Fwk503Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fwk503CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt fwk503CBancCont() ;
            
            @Data(size=4)
            IInt fwk503COeEgcCont() ;
            
            @Data(size=7)
            IInt fwk503NsRdclCont() ;
            
            @Data(size=1)
            IInt fwk503VChkdCont() ;
            
            @Data(size=3)
            IInt fwk503CTipoCont() ;
            
            @Data(size=3)
            IString fwk503CMoedIsoScta() ;
            
            @Data(size=4)
            IInt fwk503NsDeposito() ;
            
        }
        
        public interface Fwk503Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk503CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk503ZInicMov() ;
            
            @Data(size=10)
            IString fwk503ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk503TsPedido() ;
            
        }
    }
    public interface RegFwk504 extends IDataStruct {
        
        @Data(size=3)
        IString fwk504CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk504NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk504VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk504CTipoCont() ;
        
        @Data(size=3)
        IString fwk504CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504NsDeposito() ;
        
        @Data(size=8)
        IString fwk504NmRecurso() ;
        
        @Data(size=1)
        IString fwk504CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504ZaFim() ;
        
        @Data(size=26)
        IString fwk504TsActzUlt() ;
        
        @Data(size=8)
        IString fwk504CUsidActzUlt() ;
        
    }
    
    /**
     * BatchC
     */
    @Data
    public abstract RegFwk504 regFwk504() ;
    /**
     * Global
     */
    @Data
    public abstract Rwk50301 rwk50301() ;
}
