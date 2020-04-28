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
public abstract class Fwk102 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk102Pghq330a
     */
    @Data
    public abstract RegFwk102Pghq330a regFwk102Pghq330a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk102Pghq330a extends IDataStruct {
        
        @Data(size=3)
        IString fwk102CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk102CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk102COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk102NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk102VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk102CTipoCont() ;
        
        @Data(size=3)
        IString fwk102CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk102NsDeposito() ;
        
        @Data(size=26)
        IString fwk102TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk102NsMovimento() ;
        
        @Data(size=4)
        IString fwk102CTransaccao() ;
        
        @Data(size=2)
        IString fwk102AAplicacao() ;
        
        @Data(size=3)
        IString fwk102COpczMenu() ;
        
        @Data(size=5)
        IString fwk102COpeBbn() ;
        
        @Data(size=4)
        IString fwk102CEvenOpel() ;
        
        @Data(size=4)
        IString fwk102CTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fwk102COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fwk102COpexAtrx() ;
        
        @Data(size=8)
        IString fwk102CUserid() ;
        
        @Data(size=4)
        IString fwk102CTipoCanlAces() ;
        
        @Data(size=3)
        IString fwk102CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk102CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk102COeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk102CProdSgop() ;
        
        @Data(size=3)
        IString fwk102CFamiProd() ;
        
        @Data(size=3)
        IString fwk102CProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk102CCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk102CGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk102CTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk102TCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk102MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk102MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk102MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk102MCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk102MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk102MDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk102NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk102NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk102NsJourBbnDtlh() ;
        
        @Data(size=8)
        IString fwk102NmArqvOrig() ;
        
        @Data(size=26)
        IString fwk102TsActzUlt() ;
        
        @Data(size=8)
        IString fwk102CUsidActzUlt() ;
        
    }
}
