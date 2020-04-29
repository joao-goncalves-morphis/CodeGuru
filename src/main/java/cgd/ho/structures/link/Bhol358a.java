package cgd.ho.structures.link;

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
public interface Bhol358a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ358A")
    IString conMhoj358a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL358A - DEVOLVE INFORMACAO SOBRE DETALHE DE JUROS
     * DATA CRIACAO - 2010-06-23   UTILIZADOR: DACT388
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            /**
             * @return instancia da classe local Subconta
             */
            @Data
            Subconta subconta() ;
            
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
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            
            public interface Subconta extends IDataStruct {
                
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
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local SubcontaOut
             */
            @Data
            SubcontaOut subcontaOut() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsCmrg() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsSdep() ;
            
            @Data(size=2)
            IString cTipoJuro() ;
            
            @Data(size=10)
            IString zFimPerCalc() ;
            
            @Data(size=10)
            IString zPagJuro() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsPagJuro() ;
            
            @Data(size=10)
            IString zInicPerCalc() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mJuro() ;
            
            @Data(size=5)
            IString cOpeBbnImp() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mImposto() ;
            
            @Data(size=5)
            IString cOpeBbnIsezImp() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mIsezImp() ;
            
            @Data(size=5)
            IString cOpeBbnImpJmor() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mJmorPago() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mImpJmorPago() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovCtrvEuro() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambEuro() ;
            
            @Data(size=3)
            IString cPaisIsaCtaDst() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContDest() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContDest() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContDest() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContDest() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContDest() ;
            
            @Data(size=3)
            IString cMoeIsoSctaDst() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepDest() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=3)
            IString cFamiProdCmrg() ;
            
            @Data(size=3)
            IString cProdCmrg() ;
            
            @Data(size=30)
            IString dCodAbvdProdCmr() ;
            
            @Data(size=3)
            IString cFamiProdJur() ;
            
            @Data(size=3)
            IString cProdJur() ;
            
            @Data(size=30)
            IString dCodAbvdProdJur() ;
            
            @Data(size=30)
            IString dCodAbvdJuro() ;
            
            
            public interface SubcontaOut extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaContO() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContO() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContO() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclContO() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContO() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoContO() ;
                
                @Data(size=3)
                IString cMoedIsoSctaO() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDepositoO() ;
                
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("A1")
            ICondition abend() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("A3")
            ICondition abendCics() ;
            @Data
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
