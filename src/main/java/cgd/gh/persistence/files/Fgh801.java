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
public abstract class Fgh801 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh801Pghq800a
     */
    @Data
    public abstract RegFgh801Pghq800a regFgh801Pghq800a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ3
     */
    public interface RegFgh801Pghq800a extends IDataStruct {
        
        @Data(size=3)
        IString fgh801CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh801CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh801COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh801NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh801VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh801CTipoCont() ;
        
        @Data(size=3)
        IString fgh801CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh801NsDeposito() ;
        
        @Data(size=26)
        IString fgh801TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh801NsMovimento() ;
        
        @Data(size=4)
        IString fgh801CTransaccao() ;
        
        @Data(size=2)
        IString fgh801AAplicacao() ;
        
        @Data(size=3)
        IString fgh801COpczMenu() ;
        
        @Data(size=5)
        IString fgh801COpeBbn() ;
        
        @Data(size=4)
        IString fgh801CEvenOpel() ;
        
        @Data(size=4)
        IString fgh801CTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh801COperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt fgh801COpexAtrx() ;
        
        @Data(size=8)
        IString fgh801CUserid() ;
        
        @Data(size=4)
        IString fgh801CTipoCanlAces() ;
        
        @Data(size=3)
        IString fgh801CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh801CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh801COeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh801CProdSgop() ;
        
        @Data(size=3)
        IString fgh801CFamiProd() ;
        
        @Data(size=3)
        IString fgh801CProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh801CCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh801CGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh801CTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fgh801TCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh801MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh801MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh801MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh801MCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh801MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh801MDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh801NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh801NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh801NsJourBbnDtlh() ;
        
        @Data(size=8)
        IString fgh801NmArqvOrig() ;
        
        @Data(size=26)
        IString fgh801TsActzUlt() ;
        
        @Data(size=8)
        IString fgh801CUsidActzUlt() ;
        
    }
}
