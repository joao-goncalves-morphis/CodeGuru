package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Entrav2 extends DataFileHandler {
    
    @Data
    public abstract Reg reg() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Reg extends IDataStruct {
        
        @Data(size=8)
        IString prog() ;
        
        @Data(size=10)
        IString zProcessamento() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data(size=4)
        IString cTransaccao() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        @Data(size=5)
        IString cOpePcnp() ;
        
        @Data(size=15)
        IString xChavOpePcnp() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=20)
        IString cTermPcnp() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nSessTermPcnp() ;
        
        @Data(size=26)
        IString tsTrnzLocl() ;
        
        @Data(size=26)
        IString tsInicPrctCtrl() ;
        
        @Data(size=26)
        IString tsFimPrctCtrl() ;
        
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        @Data(size=1)
        IString iAccao() ;
        
        @Data(size=1)
        IString iCslzTrnz() ;
        
        @Data(size=1)
        IString cEstPrctReg() ;
        
        @Data(size=1)
        IString cTipSteOpePcnp() ;
        
        @Data(size=21)
        IString xIdSpteOpePcnp() ;
        
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
        
        @Data(size=11)
        IString cBancSwif() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnl() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoAtrd() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=10)
        IString zValor() ;
        
        @Data(size=10)
        IString zCtlzJourBbn() ;
        
        @Data(size=3)
        IString cMoedIsoMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=3)
        IString cOpczMenu() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        @Data(size=3)
        IString cGranCli() ;
        
        @Data(size=10)
        IString cSegmCrm() ;
        
        @Data(size=3)
        IString cFamiProd() ;
        
        @Data(size=3)
        IString cProduto() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=10)
        IString cCpltMvopIcb() ;
        
        @Data(size=12, signed=true, compression=COMP3)
        ILong xIdMovCriv() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=15)
        IString xChvOpePcnpOri() ;
        
        @Data(size=3)
        IString cPaisIsoaOeEsn() ;
        
        @Data(size=3)
        IString cMnemEgcEstn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcEstn() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbnTrnEsn() ;
        
        @Data(size=8)
        IString cUsidEstn() ;
        
        @Data(size=2)
        IString aAplErro() ;
        
        @Data(size=2)
        IString cTipoErroBbn() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cRtnoSwal() ;
        
        @Data(size=4)
        IString cLclzErroPrg() ;
        
        @Data(size=8)
        IString nmPrgErro() ;
        
        @Data(size=100)
        IString xInfCplrErro() ;
        
        @Data(size=5)
        IString cRtnoSwalPcnp() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsVersMsg() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt qCterCmpMsgInp() ;
        
        @Data(size=7192)
        IString xMsgBbnIput() ;
        
        @Data(size=7192)
        IString xMsgBbnOutput() ;
        
    }
}
