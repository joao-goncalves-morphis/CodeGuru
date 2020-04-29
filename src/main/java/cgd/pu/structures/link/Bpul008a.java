package cgd.pu.structures.link;

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
public interface Bpul008a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MPUJ008A")
    IString conMpuj008a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BPUL008A - AREA DE LIGACAO DA ROTINA PARA OBTENCAO DE DADOS
     * DE ORDENS EMITIDAS
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
         * *PU2028-F
         * @return instancia da classe local AreaOutput
         */
        @Data
        AreaOutput areaOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            /**
             * 10 BPUL008A-C-MNEM-EMP-GCX        PIC X(03).
             */
            @Data(size=4)
            IString cBancCont() ;
            
            @Data(size=16)
            IString cRefMsgSwif() ;
            
            /**
             * @return instancia da classe local XNumConta
             */
            @Data
            XNumConta xNumConta() ;
            
            /**
             * *PU2028-I
             */
            @Data(size=3)
            IString cMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito() ;
            
            @Data(size=26)
            IString tsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            
            public interface XNumConta extends IDataStruct {
                
                @Data(size=4)
                IString cOeEgcCont() ;
                
                @Data(size=7)
                IString nsRdclCont() ;
                
                @Data(size=1)
                IString vChkdCont() ;
                
                @Data(size=3)
                IString cTipoCont() ;
                
            }
        }
        
        
        /**
         * 
         * *PU2028-F
         * 
         * @version 2.0
         * 
         */
        public interface AreaOutput extends IDataStruct {
            
            /**
             * ESTADO DA MSG SWIFT
             */
            @Data(size=2)
            IString cEstMsgSwif() ;
            
            /**
             * DADOS DO ORDENADOR
             * @return instancia da classe local XInfOrdnLn01
             */
            @Data
            XInfOrdnLn01 xInfOrdnLn01() ;
            
            @Data(size=3)
            IString cMoedIsoOrig() ;
            
            @Data(size=35)
            IString xNomeOrdn() ;
            
            /**
             * DADOS DO BENEFICIARIO
             */
            @Data(size=25)
            IString xInfBeneLn01() ;
            
            @Data(size=35)
            IString xNomeBene() ;
            
            /**
             * 10 BPUL008A-X-MORADA-BENE         PIC X(35).
             */
            @Data(size=40)
            IString xMoradaBene() ;
            
            @Data(size=10)
            IString xCodPostalBene() ;
            
            /**
             * 10 BPUL008A-X-CIDADE-BENE         PIC X(25).
             */
            @Data(size=40)
            IString xCidadeBene() ;
            
            @Data(size=3)
            IString xPaisBene() ;
            
            /**
             * DADOS DO BANCO DO BENEFICIARIO
             */
            @Data(size=11)
            IString cEndSwf() ;
            
            @Data(size=35)
            IString xNomeBcoBene() ;
            
            @Data(size=35)
            IString xMoradaBcoBene() ;
            
            @Data(size=10)
            IString xCodPostalBcoBene() ;
            
            @Data(size=25)
            IString xCidadeBcoBene() ;
            
            @Data(size=3)
            IString xPaisBcoBene() ;
            
            @Data(size=2)
            IString cTipoClrg() ;
            
            @Data(size=23)
            IString cClearing() ;
            
            /**
             * DADOS DA TRANSFERENCIA
             */
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwif() ;
            
            @Data(size=3)
            IString cMoedIsoOrigT() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwifMoeOri() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong nAtrzCamb() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambio() ;
            
            @Data(size=10)
            IString zValMsgSwif() ;
            
            @Data(size=1)
            IString iOpagUrgt() ;
            
            @Data(size=3)
            IString cTipLqzPagItrl() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor() ;
            
            @Data(size=3)
            IString cDtlhEncgSwif() ;
            
            @Data(size=35)
            IString xDetPag1() ;
            
            @Data(size=35)
            IString xDetPag2() ;
            
            @Data(size=35)
            IString xDetPag3() ;
            
            @Data(size=35)
            IString xDetPag4() ;
            
            @Data(size=35)
            IString xInfPag1() ;
            
            @Data(size=35)
            IString xInfPag2() ;
            
            @Data(size=1)
            IString iAcdoLvp() ;
            
            /**
             * @return instancia da classe local XIdContLiqzEcg
             */
            @Data
            XIdContLiqzEcg xIdContLiqzEcg() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgOrdnSwif() ;
            
            @Data(size=3)
            IInt indice() ;
            @Data
            @Condition("10")
            ICondition paginaCheia() ;
            
            
            /**
             * DESPESAS BANCARIAS
             * TABELA INTERNA COM 10 OCORRENCIAS:
             * @return instancia da classe local TabIncEncg
             */
            @Data(length=10)
            IArray<TabIncEncg> tabIncEncg() ;
            
            /**
             * RETORNO DO COMPLEMENTO
             */
            @Data(size=2, signed=true, compression=COMP3)
            IInt cMtvDvzCpltOpg() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            @Data
            @Condition("002")
            ICondition naoExistemDados() ;
            @Data
            @Condition("003")
            ICondition dadosInputInv() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
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
            @Condition("DA")
            ICondition dadosNValidos() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
            
            
            /**
             * 
             * DADOS DO ORDENADOR
             * 
             * @version 2.0
             * 
             */
            public interface XInfOrdnLn01 extends IDataStruct {
                
                @Data(size=4)
                IString cOeEgcCntOrd() ;
                
                @Data(size=7)
                IString nsRdclCntOrd() ;
                
                @Data(size=1)
                IString vChkdCntOrd() ;
                
                @Data(size=3)
                IString cTipoCntOrd() ;
                
            }
            
            public interface XIdContLiqzEcg extends IDataStruct {
                
                @Data(size=4)
                IString cOeEgcCntEcg() ;
                
                @Data(size=7)
                IString nsRdclCntEcg() ;
                
                @Data(size=1)
                IString vChkdCntEcg() ;
                
                @Data(size=3)
                IString cTipoCntEcg() ;
                
            }
            
            
            /**
             * 
             * DESPESAS BANCARIAS
             * TABELA INTERNA COM 10 OCORRENCIAS:
             * 
             * @version 2.0
             * 
             */
            public interface TabIncEncg extends IDataStruct {
                
                @Data(size=1)
                IString cTipoEncg() ;
                
                @Data(size=3)
                IString cEncg() ;
                
                @Data(size=15, decimal=2, signed=true, compression=COMP3)
                IDecimal mEncg() ;
                
                @Data(size=3)
                IString cMoedEncg() ;
                
                @Data(size=1)
                IString cTipoImp() ;
                
                @Data(size=3)
                IString cImp() ;
                
                @Data(size=15, decimal=2, signed=true, compression=COMP3)
                IDecimal mImp() ;
                
                @Data(size=3)
                IString cMoedImp() ;
                
            }
        }
    }
    
}
