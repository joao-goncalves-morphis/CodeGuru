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
public abstract class Fwk299 extends DataFileHandler {
    
    @Data(size=237)
    public IString fwk299Reg237 ;
    
    /**
     * @return instancia da classe local RegFwk299
     */
    @Data
    public abstract RegFwk299 regFwk299() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk299 extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoAlfn() ;
        
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt zaAgendamento() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nsIstzAgnt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsVersAgnt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsDstnAgnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsOpeAgnt() ;
        
        @Data(size=3)
        IString cTipoOpeIszAgn() ;
        
        @Data(size=3)
        IString cTipoServAgnt() ;
        
        @Data(size=2)
        IString cEstOpeAgnt() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mOpeAgntEfcd() ;
        
        @Data(size=3)
        IString cMoedIsoOpeAgn() ;
        
        @Data(size=10)
        IString zExeOpeAgnt() ;
        
        @Data(size=3)
        IString cFamiProd() ;
        
        @Data(size=3)
        IString cProduto() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=4)
        IString cSeveOpel() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt cOpeSibs() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliOrdn() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCliOrdn() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliAtrd() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCliAtrd() ;
        
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mOpeAgntOrig() ;
        
        @Data(size=3)
        IString cMoedIsoOpeOri() ;
        
        @Data(size=3)
        IString cPaisIsaCtaDtn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancNibDstn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeNibDstn() ;
        
        @Data(size=11, signed=true, compression=COMP3)
        ILong nContNibDstn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt vChkdNibDstn() ;
        
        @Data(size=3)
        IString cMoeIsoSctaDtn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepSctaDstn() ;
        
        @Data(size=3)
        IString cPaisIsaGrxDtn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGrxDtn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerxDstn() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data(size=27)
        IString nmDstnMovSibs() ;
        
        @Data(size=12)
        IString xRefAdiMov() ;
        
        @Data(size=20)
        IString xDsc1Sibs() ;
        
        @Data(size=20)
        IString xDsc2Sibs() ;
        
    }
}
