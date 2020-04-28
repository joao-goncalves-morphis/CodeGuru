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
public abstract class Fwk302 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rwk30201Pghc191a
     */
    @Data
    public abstract Rwk30201Pghc191a rwk30201Pghc191a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface Rwk30201Pghc191a extends IDataStruct {
        
        @Data(size=3)
        IString fwk302CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk302CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk302COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk302NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk302VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk302CTipoCont() ;
        
        @Data(size=3)
        IString fwk302CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk302NsDeposito() ;
        
        @Data(size=26)
        IString fwk302TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk302NsMovimento() ;
        
        @Data(size=4)
        IString fwk302CTransaccao() ;
        
        @Data(size=2)
        IString fwk302AAplicacao() ;
        
        @Data(size=3)
        IString fwk302COpczMenu() ;
        
        @Data(size=5)
        IString fwk302COpeBbn() ;
        
        @Data(size=4)
        IString fwk302CEvenOpel() ;
        
        @Data(size=4)
        IString fwk302CTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fwk302COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fwk302COpexAtrx() ;
        
        @Data(size=8)
        IString fwk302CUserid() ;
        
        @Data(size=4)
        IString fwk302CTipoCanlAces() ;
        
        @Data(size=3)
        IString fwk302CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk302CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk302COeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk302CProdSgop() ;
        
        @Data(size=3)
        IString fwk302CFamiProd() ;
        
        @Data(size=3)
        IString fwk302CProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk302CCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk302CGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk302CTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk302TCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk302MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk302MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk302MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk302MCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk302MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk302MDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk302NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk302NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk302NsJourBbnDtlh() ;
        
        @Data(size=8)
        IString fwk302NmArqvOrig() ;
        
        @Data(size=26)
        IString fwk302TsActzUlt() ;
        
        @Data(size=8)
        IString fwk302CUsidActzUlt() ;
        
    }
}
