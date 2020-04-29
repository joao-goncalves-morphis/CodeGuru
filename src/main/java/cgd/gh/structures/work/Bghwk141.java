package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;

import static morphis.framework.datatypes.serialization.Algorithm.COMP3;

import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghwk141 extends IDataStruct {

    public interface WsDocCliLinha extends IDataMask {
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc1() ;
        
        @Data(size=3)
        IString wsCTipoDocId1() ;
        
        @Data(size=20)
        IString wsNDocId1() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc2() ;
        
        @Data(size=3)
        IString wsCTipoDocId2() ;
        
        @Data(size=20)
        IString wsNDocId2() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc3() ;
        
        @Data(size=3)
        IString wsCTipoDocId3() ;
        
        @Data(size=20)
        IString wsNDocId3() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc4() ;
        
        @Data(size=3)
        IString wsCTipoDocId4() ;
        
        @Data(size=20)
        IString wsNDocId4() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc5() ;
        
        @Data(size=3)
        IString wsCTipoDocId5() ;
        
        @Data(size=20)
        IString wsNDocId5() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc6() ;
        
        @Data(size=3)
        IString wsCTipoDocId6() ;
        
        @Data(size=20)
        IString wsNDocId6() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc7() ;
        
        @Data(size=3)
        IString wsCTipoDocId7() ;
        
        @Data(size=20)
        IString wsNDocId7() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc8() ;
        
        @Data(size=3)
        IString wsCTipoDocId8() ;
        
        @Data(size=20)
        IString wsNDocId8() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc9() ;
        
        @Data(size=3)
        IString wsCTipoDocId9() ;
        
        @Data(size=20)
        IString wsNDocId9() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc10() ;
        
        @Data(size=3)
        IString wsCTipoDocId10() ;
        
        @Data(size=20)
        IString wsNDocId10() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc11() ;
        
        @Data(size=3)
        IString wsCTipoDocId11() ;
        
        @Data(size=20)
        IString wsNDocId11() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc12() ;
        
        @Data(size=3)
        IString wsCTipoDocId12() ;
        
        @Data(size=20)
        IString wsNDocId12() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc13() ;
        
        @Data(size=3)
        IString wsCTipoDocId13() ;
        
        @Data(size=20)
        IString wsNDocId13() ;
        
        @Data(size=3)
        IString wsCPaisIsaEmsDoc14() ;
        
        @Data(size=3)
        IString wsCTipoDocId14() ;
        
        @Data(size=20)
        IString wsNDocId14() ;
        
    }
    public interface Ade extends IDataStruct {
        
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
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        @Data(size=3)
        IString cPaisIsoAlfn() ;
        
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        @Data(size=16)
        IString cRefMsgSwif() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        @Data(size=3)
        IString cPaisIsaEmsDoc() ;
        
        @Data(size=3)
        IString cTipoDocId() ;
        
        @Data(size=20)
        IString nDocId() ;
        
        @Data(size=135)
        IString nmCliCompl() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovNmriMin() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovNmriMax() ;
        
        @Data(size=1)
        IString cTipoOpeCont() ;
        
        @Data(size=1)
        IString iCritDbcr() ;
        
        @Data(size=1)
        IString iCliCgd() ;
        
        @Data(size=1)
        IString cTipoItvtDep() ;
        
        @Data(size=1)
        IString iConsulta() ;
        
        @Data(size=10)
        IString zMovimentoMin() ;
        
        @Data(size=10)
        IString zMovimentoMax() ;
        
        @Data(size=1)
        IString iModoPesq() ;
        
        @Data(size=10)
        IString zProcessamentoC() ;
        
        @Data(size=3)
        IString cMnemEgcOpexC() ;
        
        @Data(size=3)
        IString cPaisIsoaOpxC() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpexC() ;
        
        @Data(size=8)
        IString cUseridC() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbnC() ;
        
        @Data(size=3)
        IString cPaisIsoaContC() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancContC() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcContC() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclContC() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdContC() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContC() ;
        
        @Data(size=3)
        IString cMoedIsoSctaC() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepositoC() ;
        
        @Data(size=10)
        IString zMovimentoC() ;
        
        @Data(size=26)
        IString tsInsercaoC() ;
        
        /**
         * @return instancia da classe local Linha
         */
        @Data(length=10)
        IArray<Linha> linha() ;
        
        
        public interface Linha extends IDataStruct {
            
            @Data(size=10)
            IString zProcessamentoL() ;
            
            @Data(size=3)
            IString cMnemEgcOpexL() ;
            
            @Data(size=3)
            IString cPaisIsoaOpxL() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpexL() ;
            
            @Data(size=8)
            IString cUseridL() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbnL() ;
            
            @Data(size=3)
            IString cPaisIsoaContL() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContL() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContL() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContL() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContL() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContL() ;
            
            @Data(size=3)
            IString cMoedIsoSctaL() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepositoL() ;
            
            @Data(size=3)
            IString cPaisIsoAlfnL() ;
            
            @Data(size=3)
            IString cMnemEmpGcxL() ;
            
            @Data(size=16)
            IString cRefMsgSwifL() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifL() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nChequeL() ;
            
            @Data(size=3)
            IString cPaisIEmsDocL() ;
            
            @Data(size=3)
            IString cTipoDocIdL() ;
            
            @Data(size=20)
            IString nDocIdL() ;
            
            @Data(size=10)
            IString zVldeDocIdL() ;
            
            @Data(size=10)
            IString cEntEmiDocIdL() ;
            
            @Data(size=3)
            IString cPaisEmsDocAL() ;
            
            @Data(size=3)
            IString cTipoDocIdApL() ;
            
            @Data(size=20)
            IString nDocIdAptdL() ;
            
            @Data(size=10)
            IString zVldeDocIdApL() ;
            
            @Data(size=10)
            IString cEntEmiDidApL() ;
            
            @Data(size=3)
            IString cPaisEmsDocRL() ;
            
            @Data(size=3)
            IString cTipoDocIdRpL() ;
            
            @Data(size=20)
            IString nDocIdRprtL() ;
            
            @Data(size=10)
            IString zVldeDocIdRpL() ;
            
            @Data(size=10)
            IString cEntEmixDidRL() ;
            
            @Data(size=1)
            IString iCliCgdL() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nClienteL() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCliL() ;
            
            @Data(size=135)
            IString nmCliComplL() ;
            
            @Data(size=1)
            IString iRprtCliCgd() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nClienteRprtL() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCliRprtL() ;
            
            @Data(size=135)
            IString nmCliComplRprL() ;
            
            @Data(size=1)
            IString cTipoItvtDepL() ;
            
            @Data(size=1)
            IString cTipoMdtiL() ;
            
            @Data(size=10)
            IString zMovimentoL() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovEuroL() ;
            
            @Data(size=1)
            IString iDbcrL() ;
            
            @Data(size=4)
            IString cTipoCanlAcesL() ;
            
            @Data(size=1)
            IString cTipoOpeContL() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnlnL() ;
            
            @Data(size=1)
            IString iPedJstzOFndL() ;
            
            @Data(size=1)
            IString cMtvoPedJstzL() ;
            
            @Data(size=1)
            IString iRcsJstzOFndL() ;
            
            @Data(size=1)
            IString iEstornoL() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt qMoedaL() ;
            
            @Data(size=26)
            IString tsInsercaoL() ;
            
            @Data(size=50)
            IString xInfAtsL() ;
            
            /**
             * PASSIVAS 4497 - INI
             */
            @Data(size=1)
            IString cTipRelDepL() ;
            
            @Data(size=50)
            IString xInfJstzDepL() ;
            
        }
    }

}
