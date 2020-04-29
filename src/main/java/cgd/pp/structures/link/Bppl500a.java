package cgd.pp.structures.link;

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
public interface Bppl500a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MPPJ500A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BPPL500A - AREA DE LIGACAO AO MODULO MPPJ500A
     * HISTÓRICO MOVIMENTOS - INFO ADICIONAL PARA LIGAÇÃO À APILC.GH
     * CHAVE PP               : BPPL500A-APLICACAO
     * BPPL500A-X-INF-RTNO
     * BPPL500A-C-IDIO-ISO
     * CHAVE HR MIGRADO EM PP : BPPL500A-APLICACAO
     * BPPL500A-Z-PROCESSAMENTO
     * BPPL500A-C-PAIS-ISOA-OPX
     * BPPL500A-C-MNEM-EGC-OPEX
     * BPPL500A-C-OE-EGC-OPEX
     * BPPL500A-C-USERID
     * BPPL500A-N-JOUR-BBN
     * CHAVE HM MIGRADO EM PP : BPPL500A-APLICACAO
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
         * @return instancia da classe local DadosOutputPpHr
         */
        @Data
        DadosOutputPpHr dadosOutputPpHr() ;
        
        /**
         * @return instancia da classe local DadosOutputHm
         */
        @Data
        DadosOutputHm dadosOutputHm() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString debug() ;
            @Data
            @Condition("S")
            ICondition debugSim() ;
            @Data
            @Condition("N")
            ICondition debugNao() ;
            
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=2)
            IString aplicacao() ;
            
            @Data(size=30)
            IString xInfRtno() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=3)
            IString cPaisIsoaOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong tipoMovimento() ;
            @Data
            @Condition("0000000001")
            ICondition tipoMovimentoDstn() ;
            @Data
            @Condition("0000000002")
            ICondition tipoMovimentoEmp() ;
            @Data
            @Condition("0000000003")
            ICondition tipoMovimentoOic() ;
            
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qOccursIn() ;
            
            /**
             * @return instancia da classe local ChaveCont
             */
            @Data
            ChaveCont chaveCont() ;
            
            
            public interface ChaveCont extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoAlfnC() ;
                
                @Data(size=3)
                IString cMnemEmpGcxC() ;
                
                @Data(size=12, signed=true, compression=COMP3)
                ILong nsLotePsepC() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRegLotePsepC() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cServSddSepaC() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt nsMovLotePsepC() ;
                
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
        
        public interface DadosOutputPpHr extends IDataStruct {
            
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
             * 10 BPPL500A-NM-ORDN                 PIC  X(30).
             */
            @Data(size=35)
            IString nmOrdn() ;
            
            @Data(size=17, decimal=2, signed=true)
            IDecimal mMovOrdTrfc() ;
            
            @Data(size=2)
            IInt qTrfcDstn() ;
            
            @Data(size=1)
            IString iTrfcDstnExced() ;
            
            @Data(size=35)
            IString cIdCrdxCbcSepa() ;
            
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
                IString cPaisIsoAlfn() ;
                
                @Data(size=3)
                IString cMnemEmpGcx() ;
                
                @Data(size=12, signed=true, compression=COMP3)
                ILong nsLotePsep() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRegLotePsep() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cServSddSepa() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt nsMovLotePsep() ;
                
            }
            
            public interface TabDstnTrfc extends IDataStruct {
                
                
                @Data(size=11)
                IString cEndcSwifDstn() ;
                
                @Data(size=34)
                IString cIbanDstn() ;
                
                @Data(size=3)
                IString cMoedContDstn() ;
                
                /**
                 * 15 BPPL500A-NM-DSTN              PIC  X(30).
                 */
                @Data(size=35)
                IString nmDstn() ;
                
                @Data(size=17, decimal=2, signed=true)
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
        
        public interface DadosOutputHm extends IDataStruct {
            
            @Data(size=17, decimal=2, signed=true)
            IDecimal mMovimento() ;
            
            @Data(size=3)
            IString cMoeIsoSctaMov() ;
            
            /**
             * @return instancia da classe local NibDstn
             */
            @Data
            NibDstn nibDstn() ;
            
            @Data(size=36)
            IString nmOrdnHm() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cOpeSibsHm() ;
            
            @Data(size=30)
            IString dOpeSibsHm() ;
            
            /**
             * @return instancia da classe local DadosAdic
             */
            @Data
            DadosAdic dadosAdic() ;
            
            /**
             * @return instancia da classe local NibOrdn
             */
            @Data
            NibOrdn nibOrdn() ;
            
            
            public interface NibDstn extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContDstn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContDstn() ;
                
                @Data(size=8, signed=true, compression=COMP3)
                ILong nsRdclContDstn() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContDstn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt cTipoContDstn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt vChkdNibDstn() ;
                
            }
            
            public interface DadosAdic extends IDataStruct {
                
                @Data(size=3)
                IString cCrtzMovCrcb() ;
                
                @Data(size=20)
                IString xRefAdcCrxSibs() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nIdCrdxSibs() ;
                
                @Data(size=35)
                IString xRefMovOrig() ;
                
                @Data(size=1)
                IString iSepaHm() ;
                
            }
            
            public interface NibOrdn extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContOrdn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContOrdn() ;
                
                @Data(size=8, signed=true, compression=COMP3)
                ILong nsRdclContOrdn() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContOrdn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt cTipoContOrdn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt vChkdNibOrdn() ;
                
            }
        }
    }
    
}
