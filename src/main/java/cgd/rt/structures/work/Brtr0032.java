package cgd.rt.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
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
public interface Brtr0032 extends IDataStruct {
    
    @Data(size=4, signed=true, value="120", compression=COMP)
    IInt compriFrt003In() ;
    
    /**
     * @return instancia da classe local FicheiroFrt003
     */
    @Data
    FicheiroFrt003 ficheiroFrt003() ;
    
    /**
     * Inner Classes
     */
    public interface FicheiroFrt003 extends IDataStruct {
        
        @Data(size=13, signed=true, compression=COMP3)
        ILong numClienteMov() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt numeroSequenciaMov() ;
        
        @Data(size=4)
        IString timerSeqMov() ;
        
        @Data(size=4)
        IString codigoTransaccaoMov() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt cofreMovimentoMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt caixaMov() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt numeroAnteriorCaixaMov() ;
        
        /**
         * @return instancia da classe local NumeroAnteriorCaixaMovMask
         */
        @Data
        @Mask
        NumeroAnteriorCaixaMovMask numeroAnteriorCaixaMovMask() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt numeroAnteriorContaMov() ;
        
        /**
         * *==> C-EURO CONVERSION 26/09/01 18:34:44:83
         * *==> FIXD: 006 * PICTURE CHANGED                     FIX BEGIN:
         * 03  VALOR-MOV                       PIC S9(12)V9    COMP-3.
         */
        @Data(size=13, decimal=2, signed=true, compression=COMP3)
        IDecimal valorMov() ;
        
        /**
         * *==>                                                 FIX ENDED.
         * *==> C-EURO CONVERSION 26/09/01 18:34:44:83
         * *==> FIXD: 005 * PICTURE CHANGED                     FIX BEGIN:
         * 03  SALDO-CONTA-MOV                 PIC S9(12)V9    COMP-3.
         */
        @Data(size=13, decimal=2, signed=true, compression=COMP3)
        IDecimal saldoContaMov() ;
        
        /**
         * *==>                                                 FIX ENDED.
         */
        @Data(size=4)
        IString numeroTerminalMov() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong numeroDocumentoMov() ;
        
        @Data(size=9)
        IString descritivoMov() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt dataUltimoLancamentoMov() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt dataValorMov() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt dataUltimoMovimentoMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt grupoContaMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt condicoesEspeciaisMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt taxaJuroMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt numeroDocumentosLoteMov() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        @Mask
        IInt codAgenciaAtmMov() ;
        
        /**
         * *==> C-EURO CONVERSION 26/09/01 18:34:44:83
         * *==> FIXD: 004 * PICTURE CHANGED                     FIX BEGIN:
         * 03  JUROS-PAGOS-MOV                 PIC S9(10)V9    COMP-3.
         */
        @Data(size=11, decimal=2, signed=true, compression=COMP3)
        IDecimal jurosPagosMov() ;
        
        /**
         * *==>                                                 FIX ENDED.
         */
        @Data(size=2, signed=true, compression=COMP3)
        IInt periodicidadeExtractoMov() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt passwordMov() ;
        
        @Data(size=7, decimal=4, signed=true, compression=COMP3)
        @Mask
        IDecimal cambioMov() ;
        
        /**
         * *==> C-EURO CONVERSION 26/09/01 18:34:44:83
         * *==> FIXD: 003 * PICTURE CHANGED                     FIX BEGIN:
         * 03  JUR-DEV-MOV                     PIC S9(12)V9    COMP-3.
         */
        @Data(size=13, decimal=2, signed=true, compression=COMP3)
        IDecimal jurDevMov() ;
        
        /**
         * *==>                                                 FIX ENDED.
         */
        @Data(size=13, signed=true, compression=COMP3)
        @Mask
        ILong importFrfMov() ;
        
        /**
         * *==> C-EURO CONVERSION 26/09/01 18:34:44:83
         * *==> FIXD: 001 * PICTURE CHANGED                     FIX BEGIN:
         * 03  JUR-CRE-CAL-MOV                 PIC S9(10)V9    COMP-3.
         */
        @Data(size=11, decimal=2, signed=true, compression=COMP3)
        IDecimal jurCreCalMov() ;
        
        /**
         * *==>                                                 FIX ENDED.
         * *==> C-EURO CONVERSION 26/09/01 18:34:44:83
         * *==> FIXD: 002 * PICTURE CHANGED                     FIX BEGIN:
         * 03  JUR-DEB-CAL-MOV                 PIC S9(10)V9    COMP-3.
         */
        @Data(size=11, decimal=2, signed=true, compression=COMP3)
        IDecimal jurDebCalMov() ;
        
        /**
         * *==>                                                 FIX ENDED.
         */
        @Data(size=2, signed=true, compression=COMP3)
        IInt localEnvioCorrespMov() ;
        
        @Data(size=3, value=" ")
        IString dataM19MovX() ;
        
        /**
         * @return instancia da classe local DataM19MovXMask1
         */
        @Data
        @Mask
        DataM19MovXMask1 dataM19MovXMask1() ;
        
        /**
         * @return instancia da classe local DataM19MovXMask2
         */
        @Data
        @Mask
        DataM19MovXMask2 dataM19MovXMask2() ;
        
        /**
         * @return instancia da classe local PeriodoCompSibsMovX
         */
        @Data
        PeriodoCompSibsMovX periodoCompSibsMovX() ;
        
        @Data(size=2)
        @Mask
        IString siglaAplResponsavel() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt dataCpuProcMov() ;
        
        
        public interface NumeroAnteriorCaixaMovMask extends IDataMask {
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt balcaoOrigemMov() ;
            
            @Data(size=1)
            IString indTaxasNegociadasMov() ;
            
            @Data(size=1)
            @Mask
            IString indMoedaOrigMov() ;
            
        }
        
        public interface DataM19MovXMask1 extends IDataMask {
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt dataM19Mov() ;
            
        }
        
        public interface DataM19MovXMask2 extends IDataMask {
            
            @Data(size=1)
            IString indLimiteCreditoMov() ;
            @Data
            @Condition("0")
            ICondition semLimiteCreditoMov() ;
            @Data
            @Condition("1")
            ICondition comLimiteCreditoMov() ;
            
            
            @Data(size=1, rpadding=1)
            IString indMovEstornCredDescob() ;
            @Data
            @Condition("0")
            ICondition semMovEstornCredDescob() ;
            @Data
            @Condition("1")
            ICondition comMovEstornCredDescob() ;
            
            
        }
        
        public interface PeriodoCompSibsMovX extends IDataStruct {
            
            @Data(size=4, signed=true, compression=COMP)
            IInt periodoCompSibsMov() ;
            
        }
    }
    
}
