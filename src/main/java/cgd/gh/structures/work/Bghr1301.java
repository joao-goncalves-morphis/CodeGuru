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
public interface Bghr1301 extends IDataStruct {
    
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
     * LAYOUT DO FICHEIRO DE INPUT DO PROGRAMA PGHQ130A
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
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
        
        @Data(size=3)
        IString cPaisIsoAlfn() ;
        
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        @Data(size=16)
        IString cRefMsgSwif() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt cEstMsgSwif() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        @Data(size=3)
        IString cPaisIsaEmsDoc() ;
        
        @Data(size=3)
        IString cTipoDocId() ;
        
        @Data(size=20)
        IString nDocId() ;
        
        @Data(size=10)
        IString zVldeDocId() ;
        
        @Data(size=10)
        IString cEntEmixDocId() ;
        
        @Data(size=3)
        IString cPaisEmsDocApt() ;
        
        @Data(size=3)
        IString cTipoDocIdAptd() ;
        
        @Data(size=20)
        IString nDocIdAptd() ;
        
        @Data(size=10)
        IString zVldeDocIdAptd() ;
        
        @Data(size=10)
        IString cEntEmiDidAptd() ;
        
        @Data(size=3)
        IString cPaisEmsDocRpt() ;
        
        @Data(size=3)
        IString cTipoDocIdRprt() ;
        
        @Data(size=20)
        IString nDocIdRprt() ;
        
        @Data(size=10)
        IString zVldeDocIdRprt() ;
        
        @Data(size=10)
        IString cEntEmixDidRpt() ;
        
        @Data(size=135)
        IString nmCliente() ;
        
        @Data(size=1)
        IString iCliCgd() ;
        
        @Data(size=1)
        IString iRprtCliCgd() ;
        
        @Data(size=1)
        IString cTipoItvtDep() ;
        
        @Data(size=1)
        IString cTipoMdti() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovEuro() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=1)
        IString cTipoOpeCont() ;
        
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        @Data(size=1)
        IString iPedJstzOrmFnd() ;
        
        @Data(size=1)
        IString cMtvoPedJstz() ;
        
        @Data(size=1)
        IString iRcsJstzOrmFnd() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=26)
        IString tsInsercao() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    
}
