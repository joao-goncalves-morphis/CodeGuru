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
public abstract class Fgh124 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh10201
     */
    @Data
    public abstract Rgh10201 rgh10201() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh10201 extends IDataStruct {
        
        @Data(size=3)
        IString fgh102CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh102CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh102COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh102NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh102VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh102CTipoCont() ;
        
        @Data(size=3)
        IString fgh102CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh102NsDeposito() ;
        
        @Data(size=26)
        IString fgh102TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh102NsMovimento() ;
        
        @Data(size=4)
        IString fgh102CTransaccao() ;
        
        @Data(size=2)
        IString fgh102AAplicacao() ;
        
        @Data(size=3)
        IString fgh102COpczMenu() ;
        
        @Data(size=5)
        IString fgh102COpeBbn() ;
        
        @Data(size=4)
        IString fgh102CEvenOpel() ;
        
        @Data(size=4)
        IString fgh102CTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh102COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh102COpexAtrx() ;
        
        @Data(size=8)
        IString fgh102CUserid() ;
        
        @Data(size=4)
        IString fgh102CTipoCanlAces() ;
        
        @Data(size=3)
        IString fgh102CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh102CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh102COeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh102CProdSgop() ;
        
        @Data(size=3)
        IString fgh102CFamiProd() ;
        
        @Data(size=3)
        IString fgh102CProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh102CCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh102CGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh102CTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fgh102TCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh102MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh102MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh102MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh102MCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh102MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh102MDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh102NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh102NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh102NsJourBbnDtlh() ;
        
        @Data(size=8)
        IString fgh102NmArqvOrig() ;
        
        @Data(size=26)
        IString fgh102TsActzUlt() ;
        
        @Data(size=8)
        IString fgh102CUsidActzUlt() ;
        
    }
}
