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
public abstract class Fwk103 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rwk10301Pghc190a
     */
    @Data
    public abstract Rwk10301Pghc190a rwk10301Pghc190a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface Rwk10301Pghc190a extends IDataStruct {
        
        @Data(size=3)
        IString fwk103CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk103CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk103COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk103NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk103VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk103CTipoCont() ;
        
        @Data(size=3)
        IString fwk103CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk103NsDeposito() ;
        
        @Data(size=26)
        IString fwk103TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk103NsMovimento() ;
        
        @Data(size=4)
        IString fwk103CTransaccao() ;
        
        @Data(size=2)
        IString fwk103AAplicacao() ;
        
        @Data(size=3)
        IString fwk103COpczMenu() ;
        
        @Data(size=5)
        IString fwk103COpeBbn() ;
        
        @Data(size=4)
        IString fwk103CEvenOpel() ;
        
        @Data(size=4)
        IString fwk103CTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fwk103COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fwk103COpexAtrx() ;
        
        @Data(size=8)
        IString fwk103CUserid() ;
        
        @Data(size=4)
        IString fwk103CTipoCanlAces() ;
        
        @Data(size=3)
        IString fwk103CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk103CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk103COeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk103CProdSgop() ;
        
        @Data(size=3)
        IString fwk103CFamiProd() ;
        
        @Data(size=3)
        IString fwk103CProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk103CCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk103CGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk103CTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk103TCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk103MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk103MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk103MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk103MCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk103MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk103MDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk103NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk103NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk103NsJourBbnDtlh() ;
        
        @Data(size=8)
        IString fwk103NmArqvOrig() ;
        
        @Data(size=26)
        IString fwk103TsActzUlt() ;
        
        @Data(size=8)
        IString fwk103CUsidActzUlt() ;
        
    }
}
