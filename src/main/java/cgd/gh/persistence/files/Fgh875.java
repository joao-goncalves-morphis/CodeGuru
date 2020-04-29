package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.annotations.Mask ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fgh875 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fgh875Registo
     */
    @Data
    public abstract Fgh875Registo fgh875Registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FGH875 - DEFENICAO DO FICHEIRO FGH875
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DA SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface Fgh875Registo extends IDataStruct {
        
        @Data(size=270)
        IString fgh875Dados() ;
        
        /**
         * @return instancia da classe local Fgh875Header
         */
        @Data
        @Mask
        Fgh875Header fgh875Header() ;
        
        /**
         * @return instancia da classe local Fgh875Detalhe
         */
        @Data
        @Mask
        Fgh875Detalhe fgh875Detalhe() ;
        
        
        public interface Fgh875Header extends IDataMask {
            
            @Data(size=6)
            IString fgh875CMapaR1() ;
            
            @Data(size=6)
            IString fgh875CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh875ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh875HMapaR1() ;
            
            @Data(size=3)
            IString fgh875CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh875NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh875NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh875NIdRegCabcR1() ;
            
            @Data(size=4)
            IInt fgh875COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh875DOeEgcContR1() ;
            
            @Data(size=10)
            IString fgh875ZInicPesqR1() ;
            
            @Data(size=10)
            IString fgh875ZFimPesqR1() ;
            
            /**
             * @return instancia da classe local Fgh875SubcontaR1
             */
            @Data
            Fgh875SubcontaR1 fgh875SubcontaR1() ;
            
            @Data(size=25)
            IString fgh875IbanR1() ;
            
            @Data(size=21)
            IString fgh875NibR1() ;
            
            @Data(size=11)
            IString fgh875SwiftR1() ;
            
            @Data(size=10)
            ILong fgh875NClienteR1() ;
            
            @Data(size=3)
            IString fgh875CTitHon() ;
            
            @Data(size=35, rpadding=29)
            IString fgh875NmClienteR1() ;
            
            
            public interface Fgh875SubcontaR1 extends IDataMask {
                
                @Data(size=3)
                IString fgh875CPaisContR1() ;
                
                @Data(size=4)
                IInt fgh875CBancR1() ;
                
                @Data(size=13)
                IString fgh875ContaR1() ;
                
                @Data(size=4)
                IInt fgh875NsDepositoR1() ;
                
                @Data(size=3)
                IString fgh875CMoedIsoSctaR1() ;
                
            }
        }
        
        public interface Fgh875Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh875CMapaR2() ;
            
            @Data(size=6)
            IString fgh875CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh875ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh875HMapaR2() ;
            
            @Data(size=3)
            IString fgh875CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh875NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh875NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh875NIdRegCabcR2() ;
            
            @Data(size=8)
            ILong fgh875NsRegDtlhCabR2() ;
            
            @Data(size=10)
            IString fgh875ZMovimentoR2() ;
            
            @Data(size=10)
            IString fgh875ZValorR2() ;
            
            @Data(size=21)
            IString fgh875DDescR2() ;
            
            @Data(size=10)
            ILong fgh875NDocOppsR2() ;
            
            @Data(size=17, decimal=2, signed=true)
            IDecimal fgh875MMovimentoR2() ;
            
            @Data(size=17, decimal=2, signed=true)
            IDecimal fgh875MSldoCbloR2() ;
            
            @Data(size=15, rpadding=107)
            ILong fgh875NsMovimentoR2() ;
            
        }
    }
}
