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
public interface Bghf0832 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * DEFINICAO DO FICHEIRO FGH832
     * FICHEIRO PARA ENVIO DE DADOS PARA SAM&CDD (COPIA BHOW8832)
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
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
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
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
        
        @Data(size=4, value=" ")
        IString cEvenOpel() ;
        
        @Data(size=26, value=" ")
        IString tsActzUlt() ;
        
        @Data(size=3)
        IString cPaisIsoaOpcr() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancOpcr() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpcr() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclOpcr() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdOpcr() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContOpcr() ;
        
        @Data(size=3, value=" ")
        IString cMoedIso1() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mBase1() ;
        
        @Data(size=5, value=" ")
        IString cOpeBbn1() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mMontante1() ;
        
        @Data(size=3, value=" ")
        IString cMoedIso2() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mBase2() ;
        
        @Data(size=5, value=" ")
        IString cOpeBbn2() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mMontante2() ;
        
        @Data(size=3, value=" ")
        IString cMoedIso3() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mBase3() ;
        
        @Data(size=5, value=" ")
        IString cOpeBbn3() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mMontante3() ;
        
        @Data(size=3, value=" ")
        IString cMoedIso4() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mBase4() ;
        
        @Data(size=5, value=" ")
        IString cOpeBbn4() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal mMontante4() ;
        
    }
    
}
