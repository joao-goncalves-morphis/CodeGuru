package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr9231 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fgh923Registo
     */
    @Data
    Fgh923Registo fgh923Registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * DEFINICAO DE FICHEIRO FGH923
     * 
     * @version 2.0
     * 
     */
    public interface Fgh923Registo extends IDataStruct {
        
        @Data(size=3)
        IString fgh923CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh923CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh923COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh923NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh923VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh923CTipoCont() ;
        
        @Data(size=3)
        IString fgh923CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh923NsDeposito() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh923NsMovimento() ;
        
        @Data(size=10)
        IString fgh923ZContabilizacao() ;
        
        @Data(size=10)
        IString fgh923ZMovimento() ;
        
        @Data(size=10)
        IString fgh923ZValor() ;
        
        @Data(size=1)
        IString fgh923IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MMovimento() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MSldoDpnl() ;
        
        @Data(size=3)
        IString fgh923CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MMovMoeOrigMov() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fgh923TCambio() ;
        
        @Data(size=5)
        IString fgh923COpeBbn() ;
        
        @Data(size=21)
        IString fgh923XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh923NCheque() ;
        
        @Data(size=1)
        IString fgh923IEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh923NsMovEtnd() ;
        
        @Data(size=1)
        IString fgh923ITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString fgh923ITipoOrigTrnz() ;
        
        @Data(size=1)
        IString fgh923IExiAtzJourBbn() ;
        
        @Data(size=4)
        IString fgh923CTipoCanlAces() ;
        
        @Data(size=2)
        IString fgh923AAplicacao() ;
        
        @Data(size=3)
        IString fgh923COpczMenu() ;
        
        @Data(size=3)
        IString fgh923CFamiProd() ;
        
        @Data(size=3)
        IString fgh923CProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh923CSectIttlBpor() ;
        
        @Data(size=3)
        IString fgh923CPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh923CBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh923COeEgcGerx() ;
        
        @Data(size=1)
        IString fgh923IMovActzVsld() ;
        
        @Data(size=10)
        IString fgh923ZProcessamento() ;
        
        @Data(size=3)
        IString fgh923CMnemEgcOpex() ;
        
        @Data(size=3)
        IString fgh923CPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh923COeEgcOpex() ;
        
        @Data(size=8)
        IString fgh923CUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh923NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh923NsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh923NsJourBbnDtlh() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MSldoVcobUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MDcboNgcdUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MCmrgUtid() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt fgh923QDiaCalcJuro() ;
        
        @Data(size=2)
        IString fgh923CTipoJuro() ;
        
        @Data(size=1)
        IString fgh923ITipoCalcJuro() ;
        
        @Data(size=1)
        IString fgh923IPenalizacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh923QRenovacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh923NsUtizCmrg() ;
        
        @Data(size=4)
        IString fgh923CEvenOpel() ;
        
        @Data(size=26)
        IString fgh923TsActzUlt() ;
        
        @Data(size=8)
        IString fgh923CUsidActzUlt() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh923MMovimentoCntrvl() ;
        
        @Data(size=3, rpadding=21)
        IString fgh923CMnemEmpGcx() ;
        
    }
    
}
