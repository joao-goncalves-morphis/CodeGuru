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
public abstract class Fwk600 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk60002
     */
    @Data
    public abstract RegFwk60002 regFwk600() ;
    
    @Data(size=327)
    public IString regFwk600327 ;
    
    /**
     * @return instancia da classe local RegFwk600Pghc001a
     */
    @Data
    public abstract RegFwk600Pghc001a regFwk600Pghc001a() ;
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    public abstract Registo registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk600Pghc001a extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk600Conta
         */
        @Data
        Fwk600Conta fwk600Conta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk600NsMovimento() ;
        
        @Data(size=10)
        IString fwk600ZContabilizacao() ;
        
        @Data(size=10)
        IString fwk600ZMovimento() ;
        
        @Data(size=10)
        IString fwk600ZValor() ;
        
        @Data(size=1)
        IString fwk600IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MMovimento() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MSldoDpnl() ;
        
        @Data(size=3)
        IString fwk600CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MMovMoeOrigMov() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk600TCambio() ;
        
        @Data(size=5)
        IString fwk600COpeBbn() ;
        
        @Data(size=21)
        IString fwk600XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fwk600NCheque() ;
        
        @Data(size=1)
        IString fwk600IEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk600NsMovEtnd() ;
        
        @Data(size=1)
        IString fwk600ITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString fwk600ITipoOrigTrnz() ;
        
        @Data(size=1)
        IString fwk600IExiAtzJourBbn() ;
        
        @Data(size=4)
        IString fwk600CTipoCanlAces() ;
        
        @Data(size=2)
        IString fwk600AAplicacao() ;
        
        @Data(size=3)
        IString fwk600COpczMenu() ;
        
        @Data(size=3)
        IString fwk600CFamiProd() ;
        
        @Data(size=3)
        IString fwk600CProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk600CSectIttlBpor() ;
        
        @Data(size=3)
        IString fwk600CPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk600CBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk600COeEgcGerx() ;
        
        @Data(size=1)
        IString fwk600IMovActzVsld() ;
        
        @Data(size=10)
        IString fwk600ZProcessamento() ;
        
        @Data(size=3)
        IString fwk600CMnemEgcOpex() ;
        
        @Data(size=3)
        IString fwk600CPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk600COeEgcOpex() ;
        
        @Data(size=8)
        IString fwk600CUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fwk600NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk600NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk600NsJourBbnDtlh() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MSldoVcobUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MDcboNgcdUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk600MCmrgUtid() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt fwk600QDiaCalcJuro() ;
        
        @Data(size=2)
        IString fwk600CTipoJuro() ;
        
        @Data(size=1)
        IString fwk600ITipoCalcJuro() ;
        
        @Data(size=1)
        IString fwk600IPenalizacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk600QRenovacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk600NsUtizCmrg() ;
        
        @Data(size=4)
        IString fwk600CEvenOpel() ;
        
        @Data(size=26)
        IString fwk600TsActzUlt() ;
        
        @Data(size=8)
        IString fwk600CUsidActzUlt() ;
        
        
        public interface Fwk600Conta extends IDataStruct {
            
            @Data(size=3)
            IString fwk600CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk600NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk600VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk600CTipoCont() ;
            
            @Data(size=3)
            IString fwk600CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600NsDeposito() ;
            
        }
    }
    /**
     * Global
     */
    public interface RegFwk60002 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk600FicheiroFgh872
         */
        @Data
        Fwk600FicheiroFgh872 fwk600FicheiroFgh872() ;
        
        /**
         * @return instancia da classe local Fwk600Pedido
         */
        @Data
        Fwk600Pedido fwk600Pedido() ;
        
        
        public interface Fwk600FicheiroFgh872 extends IDataStruct {
            
            @Data(size=3)
            IString fwk600CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk600NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk600VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk600CTipoCont() ;
            
            @Data(size=3)
            IString fwk600CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600NsDeposito() ;
            
            @Data(size=26)
            IString fwk600TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk600NsMovimento() ;
            
            @Data(size=10)
            IString fwk600ZMovimento() ;
            
            @Data(size=21)
            IString fwk600DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MMovimento() ;
            
            @Data(size=1)
            IString fwk600SinalMov() ;
            
            @Data(size=1)
            IString fwk600IDbcr() ;
            
            @Data(size=1)
            IString fwk600IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoCblo() ;
            
            @Data(size=1)
            IString fwk600SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk600SinalDpnl() ;
            
            @Data(size=10)
            IString fwk600ZValor() ;
            
            @Data(size=10)
            ILong fwk600NDocOpps() ;
            
            @Data(size=3)
            IString fwk600CMoedIsoOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk600SinalMovOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoRetd() ;
            
            @Data(size=1)
            IString fwk600SinalSldoRetd() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoVcob() ;
            
            @Data(size=1)
            IString fwk600SinalSldoVcob() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MCmrgLim() ;
            
            @Data(size=1)
            IString fwk600SinalCmrgLim() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MCmrgUtid() ;
            
            @Data(size=1)
            IString fwk600SinalCmrgUtid() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MDcboNgcdAtrd() ;
            
            @Data(size=1)
            IString fwk600SinalDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MDcboNgcdUtid() ;
            
            @Data(size=1)
            IString fwk600SinalDcboNgcdUtid() ;
            
        }
        
        public interface Fwk600Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk600CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk600ZInicMov() ;
            
            @Data(size=10)
            IString fwk600ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk600TsPedido() ;
            
        }
    }
    
    /**
     * 
     * BHOR04C1- REGISTO DO FICHEIRO FHO04C
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        /**
         * @return instancia da classe local Conta
         */
        @Data
        Conta conta() ;
        
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
        
        
        public interface Conta extends IDataStruct {
            
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
}
