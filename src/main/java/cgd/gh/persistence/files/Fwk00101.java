package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fwk00101.Input1Reg.Subconta ;
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
public abstract class Fwk00101 extends DataFileHandler {
    
    @Data(size=327)
    public IString fwk001Reg327 ;
    
    /**
     * @return instancia da classe local Input1Reg
     */
    @Data
    public abstract Input1Reg input1Reg() ;
    
    /**
     * @return instancia da classe local RegFwk001
     */
    @Data
    public abstract RegFwk001 regFwk001() ;
    
    /**
     * @return instancia da classe local RegFwk001Pghq320a
     */
    @Data
    public abstract RegFwk001Pghq320a regFwk001Pghq320a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk001Pghq320a extends IDataStruct {
        
        @Data(size=3)
        IString fwk001CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk001CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk001COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk001NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk001VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk001CTipoCont() ;
        
        @Data(size=3)
        IString fwk001CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk001NsDeposito() ;
        
        @Data(size=26)
        IString fwk001TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk001NsMovimento() ;
        
        @Data(size=5)
        IString fwk001COpeBbn() ;
        
        @Data(size=4)
        IString fwk001CEvenOpel() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk001MCmrgLim() ;
        
    }
    /**
     * Global
     */
    public interface Input1Reg extends IDataStruct {
        
        /**
         * @return instancia da classe local Subconta
         */
        @Data
        Subconta subconta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        @Data(size=10)
        IString zContabilizacao() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=10)
        IString zValor() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnl() ;
        
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambio() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovEtnd() ;
        
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        @Data(size=1)
        IString iTipoOrigTrnz() ;
        
        @Data(size=1)
        IString iExiAtzJourBbn() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        @Data(size=3)
        IString cOpczMenu() ;
        
        @Data(size=3)
        IString cFamiProd() ;
        
        @Data(size=3)
        IString cProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        @Data(size=1)
        IString iMovActzVsld() ;
        
        @Data(size=10)
        IString zProcessamento() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcobUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtid() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt qDiaCalcJuro() ;
        
        @Data(size=2)
        IString cTipoJuro() ;
        
        @Data(size=1)
        IString iTipoCalcJuro() ;
        
        @Data(size=1)
        IString iPenalizacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qRenovacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsUtizCmrg() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
        
        public interface Subconta extends IDataStruct {
            
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
            
        }
    }
    public interface RegFwk001 extends IDataStruct {
        
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
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        @Data(size=10)
        IString zContabilizacao() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=10)
        IString zValor() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnl() ;
        
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambio() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovEtnd() ;
        
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        @Data(size=1)
        IString iTipoOrigTrnz() ;
        
        @Data(size=1)
        IString iExiAtzJourBbn() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        @Data(size=3)
        IString cOpczMenu() ;
        
        @Data(size=3)
        IString cFamiProd() ;
        
        @Data(size=3)
        IString cProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        @Data(size=1)
        IString iMovActzVsld() ;
        
        @Data(size=10)
        IString zProcessamento() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcobUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtid() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt qDiaCalcJuro() ;
        
        @Data(size=2)
        IString cTipoJuro() ;
        
        @Data(size=1)
        IString iTipoCalcJuro() ;
        
        @Data(size=1)
        IString iPenalizacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qRenovacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsUtizCmrg() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
}
