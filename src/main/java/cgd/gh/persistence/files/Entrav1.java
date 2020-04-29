package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Entrav1 extends DataFileHandler {
    
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
        
        @Data(size=4)
        IString cTransaccao() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        @Data(size=3)
        IString cOpczMenu() ;
        
        @Data(size=1)
        IString iAccao() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=10)
        IString zProcessamento() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=4)
        IInt cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9)
        ILong nJourBbn() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt nsSessao() ;
        
        @Data(size=1)
        IString iExiAtzJourBbn() ;
        
        @Data(size=1)
        IString iPedDad() ;
        
        @Data(size=1)
        IString iTrnzSimz() ;
        
        @Data(size=10)
        IString zPrctJourBbn() ;
        
        @Data(size=10)
        IString zCtlzJourBbn() ;
        
        @Data(size=4)
        IString cTerminal() ;
        
        @Data(size=8)
        IString cUsidVrtl() ;
        
        @Data(size=3)
        IString cPaisIsoAlfn() ;
        
        @Data(size=3)
        IString cMnemEgcUtl() ;
        
        @Data(size=3)
        IString cIdioIso() ;
        
        @Data(size=8)
        IString cPerfUtlBbn() ;
        
        @Data(size=1)
        IString iAcesContStff() ;
        
        @Data(size=8)
        IString cUsidAlcl() ;
        
        @Data(size=1)
        IString ctNvlAtzBbnLcl() ;
        
        @Data(size=8)
        IString cUsidAcrl() ;
        
        @Data(size=1)
        IString ctNvlAtzBbnCrl() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt nEmpregado() ;
        
        @Data(size=1)
        IString iUltGerxCli() ;
        
        @Data(size=1)
        IString iUltGerxCont() ;
        
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=3)
        IString cMnemEgcEstn() ;
        
        @Data(size=3)
        IString cPaisIsoaOeEsn() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcEstn() ;
        
        @Data(size=8)
        IString cUsidEstn() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbnTrnEsn() ;
        
        @Data(size=3)
        IString cMnemEgcOrig() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOri() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOrig() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBanco() ;
        
        @Data(size=26)
        IString tsLocal() ;
        
        @Data(size=26)
        IString tsCentral() ;
        
        @Data(size=1300)
        IString xMsgBbnInp() ;
        
        @Data(size=1300)
        IString xMsgBbnOut() ;
        
    }
}
