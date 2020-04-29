package cgd.hr.structures.link;

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
public interface Bhrl500a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHRJ500A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHRL500A - AREA DE LIGACAO AO MODULO MHRJ500A
     * HISTÓRICO MOVIMENTOS - INFO ADICIONAL PARA LIGAÇÃO À APILC.GH
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
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=3)
            IString cPaisIsoaOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4)
            IInt cOeEgcOpex() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9)
            ILong nJourBbn() ;
            
            @Data(size=1)
            IString tipoOperacao() ;
            @Data
            @Condition("D")
            ICondition debug() ;
            
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qOccursIn() ;
            
            /**
             * @return instancia da classe local ChaveCont
             */
            @Data
            ChaveCont chaveCont() ;
            
            
            public interface ChaveCont extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaTrfcCh() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancTrfcCh() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt zaOrdTrfcCh() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nsOrdTrfcCh() ;
                
                @Data(size=10)
                IString zProcessamentoCh() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsIstzDstnTrfcCh() ;
                
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
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
            ICondition errosFuncao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=1)
            IString iFchoCpszUrgt() ;
            
            @Data(size=2)
            IInt cServSibsTei() ;
            
            @Data(size=30)
            IString dServSibsTei() ;
            
            @Data(size=2)
            IInt cOpeSibs() ;
            
            @Data(size=30)
            IString dOpeSibs() ;
            
            @Data(size=1)
            IString iSepa() ;
            
            @Data(size=11)
            IString cEndcSwifOrdn() ;
            
            @Data(size=34)
            IString cIbanOrdn() ;
            
            @Data(size=3)
            IString cMoedContOrdn() ;
            
            /**
             * 10 BHRL500A-NM-ORDN                 PIC  X(30).
             */
            @Data(size=35)
            IString nmOrdn() ;
            
            @Data(size=15, decimal=2, signed=true)
            IDecimal mMovOrdTrfc() ;
            
            @Data(size=2)
            IInt qTrfcDstn() ;
            
            @Data(size=1)
            IString iTrfcDstnExced() ;
            
            /**
             * @return instancia da classe local ChaveContOut
             */
            @Data
            ChaveContOut chaveContOut() ;
            
            /**
             * @return instancia da classe local TabDstnTrfc
             */
            @Data(length=3)
            IArray<TabDstnTrfc> tabDstnTrfc() ;
            
            
            public interface ChaveContOut extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaTrfc() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancTrfc() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt zaOrdTrfc() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nsOrdTrfc() ;
                
                @Data(size=10)
                IString zProcTrfc() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsIstzDstnTrfc() ;
                
            }
            
            public interface TabDstnTrfc extends IDataStruct {
                
                
                @Data(size=11)
                IString cEndcSwifDstn() ;
                
                @Data(size=34)
                IString cIbanDstn() ;
                
                @Data(size=3)
                IString cMoedContDstn() ;
                
                /**
                 * 15 BHRL500A-NM-DSTN              PIC  X(30).
                 */
                @Data(size=35)
                IString nmDstn() ;
                
                @Data(size=15, decimal=2, signed=true)
                IDecimal mMovOrdDstn() ;
                
                @Data(size=20)
                IString xRefMovOrnSibs() ;
                
                @Data(size=4)
                IString cMtvoDvlzSepa() ;
                
                @Data(size=35)
                IString xMtvoTrnzSepa() ;
                
                @Data(size=4)
                IString cCatgMtvTrfIso() ;
                
                @Data(size=30)
                IString dCatgMtvTrfIso() ;
                
                @Data(size=140)
                IString xInfAdiSepa() ;
                
            }
        }
    }
    
}
