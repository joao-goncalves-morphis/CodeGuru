package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm1141 extends IDataStruct {
    
    @Data(size=4, signed=true, value="7113", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="10")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("10")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="10")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="7083", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="673")
    IInt lengthOccur() ;
    
    /**
     * @return instancia da classe local Msg
     */
    @Data
    Msg msg() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * PASSIVAS 4497 - FIM
     * 
     * @version 2.0
     * 
     */
    public interface Msg extends IDataStruct {
        
        /**
         * @return instancia da classe local Ase
         */
        @Data
        Ase ase() ;
        
        /**
         * @return instancia da classe local Ade
         */
        @Data
        Ade ade() ;
        
        
        public interface Ase extends IDataStruct {
            
            /**
             * @return instancia da classe local CPaisIsoaContSt
             */
            @Data
            CPaisIsoaContSt cPaisIsoaContSt() ;
            
            /**
             * @return instancia da classe local CBancContSt
             */
            @Data
            CBancContSt cBancContSt() ;
            
            /**
             * @return instancia da classe local COeEgcContSt
             */
            @Data
            COeEgcContSt cOeEgcContSt() ;
            
            /**
             * @return instancia da classe local NsRdclContSt
             */
            @Data
            NsRdclContSt nsRdclContSt() ;
            
            /**
             * @return instancia da classe local VChkdContSt
             */
            @Data
            VChkdContSt vChkdContSt() ;
            
            /**
             * @return instancia da classe local CTipoContSt
             */
            @Data
            CTipoContSt cTipoContSt() ;
            
            /**
             * @return instancia da classe local CMoedIsoSctaSt
             */
            @Data
            CMoedIsoSctaSt cMoedIsoSctaSt() ;
            
            /**
             * @return instancia da classe local NsDepositoSt
             */
            @Data
            NsDepositoSt nsDepositoSt() ;
            
            /**
             * @return instancia da classe local NClienteSt
             */
            @Data
            NClienteSt nClienteSt() ;
            
            /**
             * @return instancia da classe local NDocIdSt
             */
            @Data
            NDocIdSt nDocIdSt() ;
            
            
            public interface CPaisIsoaContSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoaContS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoaCont0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoaCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoaContM() ;
                
            }
            
            public interface CBancContSt extends IDataStruct {
                
                @Data(size=1)
                IString cBancContS() ;
                @Data
                @Condition("0")
                ICondition cBancCont0() ;
                @Data
                @Condition("1")
                ICondition cBancCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cBancContM() ;
                
            }
            
            public interface COeEgcContSt extends IDataStruct {
                
                @Data(size=1)
                IString cOeEgcContS() ;
                @Data
                @Condition("0")
                ICondition cOeEgcCont0() ;
                @Data
                @Condition("1")
                ICondition cOeEgcCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cOeEgcContM() ;
                
            }
            
            public interface NsRdclContSt extends IDataStruct {
                
                @Data(size=1)
                IString nsRdclContS() ;
                @Data
                @Condition("0")
                ICondition nsRdclCont0() ;
                @Data
                @Condition("1")
                ICondition nsRdclCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsRdclContM() ;
                
            }
            
            public interface VChkdContSt extends IDataStruct {
                
                @Data(size=1)
                IString vChkdContS() ;
                @Data
                @Condition("0")
                ICondition vChkdCont0() ;
                @Data
                @Condition("1")
                ICondition vChkdCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt vChkdContM() ;
                
            }
            
            public interface CTipoContSt extends IDataStruct {
                
                @Data(size=1)
                IString cTipoContS() ;
                @Data
                @Condition("0")
                ICondition cTipoCont0() ;
                @Data
                @Condition("1")
                ICondition cTipoCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoContM() ;
                
            }
            
            public interface CMoedIsoSctaSt extends IDataStruct {
                
                @Data(size=1)
                IString cMoedIsoSctaS() ;
                @Data
                @Condition("0")
                ICondition cMoedIsoScta0() ;
                @Data
                @Condition("1")
                ICondition cMoedIsoScta1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cMoedIsoSctaM() ;
                
            }
            
            public interface NsDepositoSt extends IDataStruct {
                
                @Data(size=1)
                IString nsDepositoS() ;
                @Data
                @Condition("0")
                ICondition nsDeposito0() ;
                @Data
                @Condition("1")
                ICondition nsDeposito1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsDepositoM() ;
                
            }
            
            public interface NClienteSt extends IDataStruct {
                
                @Data(size=1)
                IString nClienteS() ;
                @Data
                @Condition("0")
                ICondition nCliente0() ;
                @Data
                @Condition("1")
                ICondition nCliente1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nClienteM() ;
                
            }
            
            public interface NDocIdSt extends IDataStruct {
                
                @Data(size=1)
                IString nDocIdS() ;
                @Data
                @Condition("0")
                ICondition nDocId0() ;
                @Data
                @Condition("1")
                ICondition nDocId1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nDocIdM() ;
                
            }
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
    
}
