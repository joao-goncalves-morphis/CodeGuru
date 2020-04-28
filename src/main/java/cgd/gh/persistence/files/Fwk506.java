package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
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
public abstract class Fwk506 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk505
     */
    @Data
    public abstract RegFwk505 regFwk505() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk505 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk505Subconta
         */
        @Data
        Fwk505Subconta fwk505Subconta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk505NsMovimento() ;
        
        @Data(size=10)
        IString fwk505ZContabilizacao() ;
        
        @Data(size=10)
        IString fwk505ZMovimento() ;
        
        @Data(size=10)
        IString fwk505ZValor() ;
        
        @Data(size=1)
        IString fwk505IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MMovimento() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MSldoDpnl() ;
        
        @Data(size=3)
        IString fwk505CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MMovMoeOrigMov() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk505TCambio() ;
        
        @Data(size=5)
        IString fwk505COpeBbn() ;
        
        @Data(size=21)
        IString fwk505XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fwk505NCheque() ;
        
        @Data(size=1)
        IString fwk505IEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk505NsMovEtnd() ;
        
        @Data(size=1)
        IString fwk505ITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString fwk505ITipoOrigTrnz() ;
        
        @Data(size=1)
        IString fwk505IExiAtzJourBbn() ;
        
        @Data(size=4)
        IString fwk505CTipoCanlAces() ;
        
        @Data(size=2)
        IString fwk505AAplicacao() ;
        @Data
        @Condition("TQ")
        ICondition fwk505AAplicacaoTq() ;
        
        
        @Data(size=3)
        IString fwk505COpczMenu() ;
        
        @Data(size=3)
        IString fwk505CFamiProd() ;
        
        @Data(size=3)
        IString fwk505CProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk505CSectIttlBpor() ;
        
        @Data(size=3)
        IString fwk505CPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk505CBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk505COeEgcGerx() ;
        
        @Data(size=1)
        IString fwk505IMovActzVsld() ;
        
        @Data(size=10)
        IString fwk505ZProcessamento() ;
        
        @Data(size=3)
        IString fwk505CMnemEgcOpex() ;
        
        @Data(size=3)
        IString fwk505CPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk505COeEgcOpex() ;
        
        @Data(size=8)
        IString fwk505CUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk505NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk505NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk505NsJourBbnDtlh() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MSldoVcobUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MDcboNgcdUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk505MCmrgUtid() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt fwk505QDiaCalcJuro() ;
        
        @Data(size=2)
        IString fwk505CTipoJuro() ;
        
        @Data(size=1)
        IString fwk505ITipoCalcJuro() ;
        
        @Data(size=1)
        IString fwk505IPenalizacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk505QRenovacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk505NsUtizCmrg() ;
        
        @Data(size=4)
        IString fwk505CEvenOpel() ;
        
        @Data(size=26)
        IString fwk505TsActzUlt() ;
        
        @Data(size=8)
        IString fwk505CUsidActzUlt() ;
        
        @Data(size=7)
        IString fwk505CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk505ZInicMov() ;
        
        @Data(size=10)
        IString fwk505ZFimMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk505TsPedido() ;
        
        
        public interface Fwk505Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fwk505CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk505CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk505COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk505NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk505VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk505CTipoCont() ;
            
            @Data(size=3)
            IString fwk505CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk505NsDeposito() ;
            
        }
    }
}
