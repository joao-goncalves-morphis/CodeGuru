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
public interface Bghm1151 extends IDataStruct {
    
    @Data(size=4, signed=true, value="793", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="3")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="793", compression=COMP)
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
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=16)
            IString cRefMsgSwif() ;
            
            @Data(size=2)
            IString cEstMsgSwif() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCheque() ;
            
            /**
             * IDENTIFICACAO DO DOCUMENTOS APTD
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
             * IDENTIFICACAO DO ITVT OPERACAO (DOCUMENTOS)
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
             * IDENTIFICACAO DO REPRESENTANTE DA EMPRESA (DOCUMENTOS)
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
             * DADOS DA OPERACAO
             */
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=1)
            IString cTipoOpeCont() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnln() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=1)
            IString cTipoItvtDep() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovEuro() ;
            
            @Data(size=1)
            IString iPedJstzOrmFnd() ;
            
            @Data(size=1)
            IString iRcsJstzOrmFnd() ;
            
            @Data(size=1)
            IString cMtvoPedJstz() ;
            
            /**
             * DADOS DO INTVT OPERACAO
             */
            @Data(size=1)
            IString cTipoCli() ;
            
            @Data(size=1)
            IString iCliCgd() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=135)
            IString nmCliente() ;
            
            /**
             * DADOS CLIENTE PARTICULAR OU ENI
             */
            @Data(size=10)
            IString zNascCli() ;
            
            @Data(size=3)
            IString cPaisNacnCli() ;
            
            @Data(size=20)
            IString nif() ;
            
            /**
             * DADOS CLIENTE EMPRESA OU ENI
             */
            @Data(size=20)
            IString nIpc() ;
            
            @Data(size=160)
            IString nmEmpRnpc() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cAe() ;
            
            @Data(size=80)
            IString dAe() ;
            
            /**
             * DADOS DO CLIENTE REPRESENTANTE DA EMPRESA
             */
            @Data(size=1)
            IString cTipoCliRprt() ;
            
            @Data(size=1)
            IString iRprtCliCgd() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nClienteRprt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCliRprt() ;
            
            @Data(size=135)
            IString nmClienteRprt() ;
            
        }
    }
    
}
