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
public abstract class Fgh103 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh10301
     */
    @Data
    public abstract Rgh10301 rgh10301() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh10301 extends IDataStruct {
        
        @Data(size=3)
        IString fgh103CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh103CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh103COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh103NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh103VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh103CTipoCont() ;
        
        @Data(size=3)
        IString fgh103CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh103NsDeposito() ;
        
        @Data(size=26)
        IString fgh103TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh103NsMovimento() ;
        
        @Data(size=4)
        IString fgh103CTransaccao() ;
        
        @Data(size=2)
        IString fgh103AAplicacao() ;
        
        @Data(size=3)
        IString fgh103COpczMenu() ;
        
        @Data(size=5)
        IString fgh103COpeBbn() ;
        
        @Data(size=4)
        IString fgh103CEvenOpel() ;
        
        @Data(size=4)
        IString fgh103CTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh103COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh103COpexAtrx() ;
        
        @Data(size=8)
        IString fgh103CUserid() ;
        
        @Data(size=4)
        IString fgh103CTipoCanlAces() ;
        
        @Data(size=3)
        IString fgh103CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh103CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh103COeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh103CProdSgop() ;
        
        @Data(size=3)
        IString fgh103CFamiProd() ;
        
        @Data(size=3)
        IString fgh103CProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh103CCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh103CGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh103CTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fgh103TCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh103MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh103MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh103MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh103MCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh103MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh103MDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh103NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh103NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh103NsJourBbnDtlh() ;
        
        @Data(size=8)
        IString fgh103NmArqvOrig() ;
        
        @Data(size=26)
        IString fgh103TsActzUlt() ;
        
        @Data(size=8)
        IString fgh103CUsidActzUlt() ;
        
    }
}
