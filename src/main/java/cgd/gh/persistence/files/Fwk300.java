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
public abstract class Fwk300 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk300
     */
    @Data
    public abstract RegFwk300 regFwk300() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk300 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk300Tgh00500Infhst
         */
        @Data
        Fwk300Tgh00500Infhst fwk300Tgh00500Infhst() ;
        
        /**
         * @return instancia da classe local Fwk300Tgh00501Infhstcpl
         */
        @Data
        Fwk300Tgh00501Infhstcpl fwk300Tgh00501Infhstcpl() ;
        
        /**
         * @return instancia da classe local Fwk300Pedido
         */
        @Data
        Fwk300Pedido fwk300Pedido() ;
        
        
        public interface Fwk300Tgh00500Infhst extends IDataStruct {
            
            @Data(size=3)
            IString fwk300CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk300CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk300COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk300NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk300VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk300CTipoCont() ;
            
            @Data(size=3)
            IString fwk300CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk300NsDeposito() ;
            
            @Data(size=26)
            IString fwk300TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk300NsMovimento() ;
            
            @Data(size=10)
            IString fwk300ZValMov() ;
            
            @Data(size=10)
            IString fwk300ZMovLocl() ;
            
            @Data(size=1)
            IString fwk300IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MMovimento() ;
            
            @Data(size=1)
            IString fwk300IEstorno() ;
            
            @Data(size=3)
            IString fwk300CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MSldoDpnlApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MMovMoeOrigMov() ;
            
            @Data(size=21)
            IString fwk300XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk300NDocOpps() ;
            
            @Data(size=10, decimal=7, signed=true, compression=COMP3)
            IDecimal fwk300TJuro() ;
            
            @Data(size=2)
            IString fwk300AAplOrig() ;
            
            @Data(size=10)
            IString fwk300ZEliminacao() ;
            
            @Data(size=26)
            IString fwk300TsActzUlt() ;
            
            @Data(size=8)
            IString fwk300CUsidActzUlt() ;
            
        }
        
        public interface Fwk300Tgh00501Infhstcpl extends IDataStruct {
            
            @Data(size=4)
            IString fwk300CTransaccao() ;
            
            @Data(size=2)
            IString fwk300AAplicacao() ;
            
            @Data(size=3)
            IString fwk300COpczMenu() ;
            
            @Data(size=5)
            IString fwk300COpeBbn() ;
            
            @Data(size=4)
            IString fwk300CEvenOpel() ;
            
            @Data(size=4)
            IString fwk300CTerminal() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt fwk300COperador() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt fwk300COpexAtrx() ;
            
            @Data(size=8)
            IString fwk300CUserid() ;
            
            @Data(size=4)
            IString fwk300CTipoCanlAces() ;
            
            @Data(size=3)
            IString fwk300CPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString fwk300CMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk300COeEgcOpex() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong fwk300CProdSgop() ;
            
            @Data(size=3)
            IString fwk300CFamiProd() ;
            
            @Data(size=3)
            IString fwk300CProduto() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk300CCndzMovzCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk300CGrupCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk300CSectIttlBpor() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal fwk300TCambio() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MSldoRetd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MSldoVcob() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MCmrgLim() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MCmrgUtid() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk300MDcboNgcdUtid() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong fwk300NJourBbn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt fwk300NsJourBbn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt fwk300NsJourBbnDtlh() ;
            
        }
        
        public interface Fwk300Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk300CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk300ZInicMov() ;
            
            @Data(size=10)
            IString fwk300ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk300TsPedido() ;
            
        }
    }
}
