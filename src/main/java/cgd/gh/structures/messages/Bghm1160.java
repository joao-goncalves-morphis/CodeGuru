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
public interface Bghm1160 extends IDataStruct {
    
    @Data(size=4, signed=true, value="848", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="9")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="848", compression=COMP)
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
             * @return instancia da classe local CPaisIsoAlfnSt
             */
            @Data
            CPaisIsoAlfnSt cPaisIsoAlfnSt() ;
            
            /**
             * @return instancia da classe local CMnemEmpGcxSt
             */
            @Data
            CMnemEmpGcxSt cMnemEmpGcxSt() ;
            
            /**
             * @return instancia da classe local CRefMsgSwifSt
             */
            @Data
            CRefMsgSwifSt cRefMsgSwifSt() ;
            
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
            
            
            public interface CPaisIsoAlfnSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoAlfnS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoAlfn0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoAlfn1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoAlfnM() ;
                
            }
            
            public interface CMnemEmpGcxSt extends IDataStruct {
                
                @Data(size=1)
                IString cMnemEmpGcxS() ;
                @Data
                @Condition("0")
                ICondition cMnemEmpGcx0() ;
                @Data
                @Condition("1")
                ICondition cMnemEmpGcx1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cMnemEmpGcxM() ;
                
            }
            
            public interface CRefMsgSwifSt extends IDataStruct {
                
                @Data(size=1)
                IString cRefMsgSwifS() ;
                @Data
                @Condition("0")
                ICondition cRefMsgSwif0() ;
                @Data
                @Condition("1")
                ICondition cRefMsgSwif1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRefMsgSwifM() ;
                
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
            
            /**
             * DADOS DA OPERACAO
             */
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=16)
            IString cRefMsgSwif() ;
            
            @Data(size=1)
            IString cTipoOpeCont() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCheque() ;
            
            /**
             * INTERVENIENTE NA OPERACAO
             */
            @Data(size=1)
            IString cTipoItvtDep() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovNmri() ;
            
            @Data(size=1)
            IString iCliCgd() ;
            
            @Data(size=1)
            IString cTipoCli() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=135)
            IString nmCliente() ;
            
            @Data(size=10)
            IString zNascCli() ;
            
            @Data(size=3)
            IString cPaisNacnCli() ;
            
            @Data(size=160)
            IString nmEmpRnpc() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cAe() ;
            
            @Data(size=80)
            IString dAe() ;
            
            @Data(size=20)
            IString nIpc() ;
            
            /**
             * IDENTIFICACAO DO REPRESENTANTE NA EMRRESA
             */
            @Data(size=1)
            IString iCliCgdRprt() ;
            
            @Data(size=1)
            IString cTipoCliRprt() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nClienteRprt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCliRprt() ;
            
            @Data(size=135)
            IString nmClienteRprt() ;
            
            @Data(size=10)
            IString zNascCliRprt() ;
            
            @Data(size=3)
            IString cPaisNacnCliRp() ;
            
            /**
             * DOCUMENTO APRESENTADO
             */
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
            
            /**
             * DOCUMENTO PRINCIPAL
             */
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
            
            /**
             * DOCUMENTO DO REPRESENTANTE DA EMPRESA
             */
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
            
            /**
             * **OUT
             */
            @Data(size=1)
            IString iPedJstzOrmFnd() ;
            
            @Data(size=1)
            IString iRcsJstzOrmFnd() ;
            
            @Data(size=1)
            IString cMtvoPedJstz() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mAcmdLimOpe() ;
            
            /**
             * @return instancia da classe local NrElectronico
             */
            @Data
            NrElectronico nrElectronico() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt qMoed() ;
            
            @Data(size=1)
            IString iDocDszd() ;
            
            @Data(size=1)
            IString iNcssTrrFotoc() ;
            
            @Data(size=1)
            IString iCbrcEncg() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=1)
            IString iInszDocIdCli() ;
            
            @Data(size=2)
            IString cEstCliFltg() ;
            
            @Data(size=1)
            IString cPfiRisBrqmCap() ;
            
            @Data(size=1)
            IString iDocDszdRprt() ;
            
            @Data(size=1)
            IString iNcssTrrFotRpt() ;
            
            @Data(size=1)
            IString iInszDocCliRpt() ;
            
            
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
