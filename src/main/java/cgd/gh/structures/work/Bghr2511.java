package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr2511 extends IDataStruct {
    
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
     * FGH251
     * UNLOAD DA TABELA 1 DE CONTAS
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
        
        @Data(size=3)
        IString cFamiProd() ;
        
        @Data(size=2)
        IString cTipoTrttCont() ;
        
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        @Data(size=3)
        IString cPaisIsoaAbra() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancAbraCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcAbra() ;
        
        @Data(size=3)
        IString cMoedIso() ;
        
        @Data(size=2)
        IString iEstCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cCndzMovzCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        @Data(size=10)
        IString zAbraCont() ;
        
        @Data(size=10)
        IString zValAbraCont() ;
        
        @Data(size=10)
        IString zRabtContUlt() ;
        
        @Data(size=10)
        IString zCcltCont() ;
        
        @Data(size=10)
        IString zMgrzCont() ;
        
        @Data(size=1)
        IString iTipoSpte() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qTitc() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qTitcAtiv() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qAtrdAtiv() ;
        
        @Data(size=15)
        IString nFaxCtco() ;
        
        @Data(size=1)
        IString iAtrzAsstFax() ;
        
        @Data(size=1)
        IString iInbzCheq() ;
        
        @Data(size=1)
        IString iExisObsCont() ;
        
        @Data(size=1)
        IString iExisContSpte() ;
        
        @Data(size=1)
        IString iExisCttoFisi() ;
        
        @Data(size=1)
        IString iEmpsNomeIdvl() ;
        
        @Data(size=1)
        IString iExisRstzCont() ;
        
        @Data(size=1)
        IString iExisGerxCont() ;
        
        @Data(size=1)
        IString iEmsAvsoAbrCta() ;
        
        @Data(size=1)
        IString iClszTtr1Cont() ;
        
        @Data(size=1)
        IString iObrgExisScta() ;
        
        @Data(size=1)
        IString iObrgEtgJurEst() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qAtrzDomz() ;
        
        @Data(size=3)
        IString cProdDflt() ;
        
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt nsAvsoContUlt() ;
        
        @Data(size=1)
        IString iAltOeEgcGerx() ;
        
        @Data(size=1)
        IString iAltUsidGrxCta() ;
        
        @Data(size=1)
        IString iIgdeIrTitc() ;
        
        @Data(size=1)
        IString iDcvoEspl() ;
        
        @Data(size=1)
        IString iGrazCoe() ;
        
        @Data(size=1)
        IString iExrtSwif() ;
        
        @Data(size=1)
        IString cBlqoCont() ;
        
        @Data(size=2)
        IString iEstContAnt() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpAnt() ;
        
        @Data(size=10)
        IString zCtlSectIttlBp() ;
        
        @Data(size=10)
        IString zAltSectIttlBp() ;
        
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
            
        }
    }
    
}
