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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm1130 extends IDataStruct {
    
    @Data(size=4, signed=true, value="610", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="14")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="568", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=2, value="0")
    IInt lengthOccur() ;
    
    /**
     * @return instancia da classe local Msg
     */
    @Data
    Msg msg() ;
    
    /**
     * Inner Classes
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
             * @return instancia da classe local ZProcessamentoSt
             */
            @Data
            ZProcessamentoSt zProcessamentoSt() ;
            
            /**
             * @return instancia da classe local CMnemEgcOpexSt
             */
            @Data
            CMnemEgcOpexSt cMnemEgcOpexSt() ;
            
            /**
             * @return instancia da classe local CPaisIsoaOeOpxSt
             */
            @Data
            CPaisIsoaOeOpxSt cPaisIsoaOeOpxSt() ;
            
            /**
             * @return instancia da classe local COeEgcOpexSt
             */
            @Data
            COeEgcOpexSt cOeEgcOpexSt() ;
            
            /**
             * @return instancia da classe local CUseridSt
             */
            @Data
            CUseridSt cUseridSt() ;
            
            /**
             * @return instancia da classe local NJourBbnSt
             */
            @Data
            NJourBbnSt nJourBbnSt() ;
            
            
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
            
            public interface ZProcessamentoSt extends IDataStruct {
                
                @Data(size=1)
                IString zProcessamentoS() ;
                @Data
                @Condition("0")
                ICondition zProcessamento0() ;
                @Data
                @Condition("1")
                ICondition zProcessamento1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt zProcessamentoM() ;
                
            }
            
            public interface CMnemEgcOpexSt extends IDataStruct {
                
                @Data(size=1)
                IString cMnemEgcOpexS() ;
                @Data
                @Condition("0")
                ICondition cMnemEgcOpex0() ;
                @Data
                @Condition("1")
                ICondition cMnemEgcOpex1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cMnemEgcOpexM() ;
                
            }
            
            public interface CPaisIsoaOeOpxSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoaOeOpxS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoaOeOpx0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoaOeOpx1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoaOeOpxM() ;
                
            }
            
            public interface COeEgcOpexSt extends IDataStruct {
                
                @Data(size=1)
                IString cOeEgcOpexS() ;
                @Data
                @Condition("0")
                ICondition cOeEgcOpex0() ;
                @Data
                @Condition("1")
                ICondition cOeEgcOpex1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cOeEgcOpexM() ;
                
            }
            
            public interface CUseridSt extends IDataStruct {
                
                @Data(size=1)
                IString cUseridS() ;
                @Data
                @Condition("0")
                ICondition cUserid0() ;
                @Data
                @Condition("1")
                ICondition cUserid1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cUseridM() ;
                
            }
            
            public interface NJourBbnSt extends IDataStruct {
                
                @Data(size=1)
                IString nJourBbnS() ;
                @Data
                @Condition("0")
                ICondition nJourBbn0() ;
                @Data
                @Condition("1")
                ICondition nJourBbn1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nJourBbnM() ;
                
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
            
            @Data(size=1)
            IString cTipoItvtDep() ;
            
            @Data(size=1)
            IString cTipoMdti() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovNmri() ;
            
            @Data(size=1)
            IString iCliCgd() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=1)
            IString iClszTtr1Cont() ;
            
            @Data(size=135)
            IString nmCliente() ;
            
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
            IString cPaisEmDocPrin() ;
            
            @Data(size=3)
            IString cTipoDocIdPrin() ;
            
            @Data(size=20)
            IString nDocIdPrin() ;
            
            @Data(size=10)
            IString zVldeDocIdPrin() ;
            
            @Data(size=10)
            IString cEntEmiDocPrin() ;
            
            @Data(size=1)
            IString iRcsJstzOrmFnd() ;
            
            /**
             * @return instancia da classe local NrElectronico
             */
            @Data
            NrElectronico nrElectronico() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt qMoed() ;
            
            @Data(size=1)
            IString iPedJstzOrmFnd() ;
            
            @Data(size=1)
            IString cMtvoPedJstz() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mAcmdEtga() ;
            
            @Data(size=1)
            IString iDocDszd() ;
            
            @Data(size=1)
            IString iNcssTrrFotoc() ;
            
            @Data(size=135)
            IString nmClienteT() ;
            
            @Data(size=3)
            IString cPaisIsaEmsDocT() ;
            
            @Data(size=3)
            IString cTipoDocIdT() ;
            
            @Data(size=20)
            IString nDocIdT() ;
            
            @Data(size=10)
            IString zVldeDocIdT() ;
            
            @Data(size=10)
            IString cEntEmixDocIdT() ;
            
            @Data(size=1)
            IString iCbrcEncg() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=1)
            IString cTipoMovScta() ;
            
            @Data(size=1)
            IString iInszDocIdCli() ;
            
            /**
             * *PASSIVAS 2972 - I
             */
            @Data(size=1)
            IString iValidaDocId() ;
            
            /**
             * *PASSIVAS 2972 - F
             * PASSIVAS 4497 - INI
             */
            @Data(size=1)
            IString cTipRelDep() ;
            
            /**
             * 88 BGHM1130-C-TIP-REL-DEP-FAMIL      VALUE 'F'.
             * 88 BGHM1130-C-TIP-REL-DEP-AMIGO      VALUE 'A'.
             * 88 BGHM1130-C-TIP-REL-DEP-CONHE      VALUE 'C'.
             * 88 BGHM1130-C-TIP-REL-DEP-RELCM      VALUE 'R'.
             * 88 BGHM1130-C-TIP-REL-DEP-OUTRO      VALUE 'O'.
             * 88 BGHM1130-C-TIP-REL-DEP-SRELA      VALUE 'S'.
             * 88 BGHM1130-C-TIP-REL-DEP-VALID      VALUE 'F','A','C',
             * 'R','O','S'.
             */
            @Data(size=50)
            IString xInfJstzDep() ;
            
            
            public interface NrElectronico extends IDataStruct {
                
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
                
            }
        }
    }
    
}
