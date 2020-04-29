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
public abstract class Fgh871 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fgh871Registo
     */
    @Data
    public abstract Fgh871Registo fgh871Registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FGH871 - DEFENICAO DO FICHEIRO FGH871
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DA SUBCONTA COM A
     * INFORMACAO DA ORIGEM DO MOVIMENTO
     * 
     * @version 2.0
     * 
     */
    public interface Fgh871Registo extends IDataStruct {
        
        @Data(size=230)
        IString fgh871Dados() ;
        
        /**
         * @return instancia da classe local Fgh871Header
         */
        @Data
        @Mask
        Fgh871Header fgh871Header() ;
        
        /**
         * @return instancia da classe local Fgh871Detalhe
         */
        @Data
        @Mask
        Fgh871Detalhe fgh871Detalhe() ;
        
        /**
         * @return instancia da classe local Fgh871Totais
         */
        @Data
        @Mask
        Fgh871Totais fgh871Totais() ;
        
        
        public interface Fgh871Header extends IDataMask {
            
            @Data(size=6)
            IString fgh871CMapaR1() ;
            
            @Data(size=6)
            IString fgh871CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh871ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh871HMapaR1() ;
            
            @Data(size=3)
            IString fgh871CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh871NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh871NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh871NIdRegCabcR1() ;
            
            @Data(size=3)
            IString fgh871CPaisIsoContR1() ;
            
            @Data(size=30)
            IString fgh871DPaisIsoContR1() ;
            
            @Data(size=4)
            IInt fgh871CBancContR1() ;
            
            @Data(size=30)
            IString fgh871DBancContR1() ;
            
            @Data(size=4)
            IInt fgh871COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh871DOeEgcContR1() ;
            
            @Data(size=10)
            IString fgh871ZInicPesqR1() ;
            
            @Data(size=10)
            IString fgh871ZFimPesqR1() ;
            
            /**
             * @return instancia da classe local Fgh871SubcontaR1
             */
            @Data(rpadding=27)
            Fgh871SubcontaR1 fgh871SubcontaR1() ;
            
            
            public interface Fgh871SubcontaR1 extends IDataMask {
                
                @Data(size=3)
                IString fgh871CPaisContR1() ;
                
                @Data(size=4)
                IInt fgh871CBancR1() ;
                
                @Data(size=13)
                IString fgh871ContaR1() ;
                
                @Data(size=4)
                IInt fgh871NsDepositoR1() ;
                
                @Data(size=3)
                IString fgh871CMoedIsoSctaR1() ;
                
            }
        }
        
        public interface Fgh871Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh871CMapaR2() ;
            
            @Data(size=6)
            IString fgh871CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh871ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh871HMapaR2() ;
            
            @Data(size=3)
            IString fgh871CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh871NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh871NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh871NIdRegCabcR2() ;
            
            @Data(size=8)
            ILong fgh871NsRegDtlhCabR2() ;
            
            @Data(size=10)
            IString fgh871ZMovimentoR2() ;
            
            @Data(size=21)
            IString fgh871DDescR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh871MMovimentoR2() ;
            
            @Data(size=1)
            IString fgh871SinalMovR2() ;
            
            @Data(size=1)
            IString fgh871IDbcrR2() ;
            
            @Data(size=1)
            IString fgh871IEstornoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh871MSldoCbloR2() ;
            
            @Data(size=1)
            IString fgh871SinalSldR2() ;
            
            /**
             * 10 FGH871-M-SLDO-DPNL-R2    PIC 9(15)V9(02).
             * 10 FGH871-SINAL-DPNL-R2     PIC X(01).
             */
            @Data(size=10)
            IString fgh871ZValorR2() ;
            
            @Data(size=10)
            ILong fgh871NDocOppsR2() ;
            
            @Data(size=3)
            IString fgh871CMoedIsoOrgR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh871MMovMoeOrigR2() ;
            
            @Data(size=1)
            IString fgh871SinalMovOrgR2() ;
            
            @Data(size=2)
            IString fgh871AAplR2() ;
            
            @Data(size=4)
            IString fgh871CTipoCanlAcesR2() ;
            
            @Data(size=4)
            IString fgh871CTerminalR2() ;
            
            @Data(size=4)
            IInt fgh871COeEgcOpexR2() ;
            
            @Data(size=8)
            IString fgh871COperadorR2() ;
            
            @Data(size=15, rpadding=20)
            ILong fgh871NsMovimentoR2() ;
            
        }
        
        public interface Fgh871Totais extends IDataMask {
            
            @Data(size=6)
            IString fgh871CMapaR3() ;
            
            @Data(size=6)
            IString fgh871CTipoRegR3() ;
            
            @Data(size=10)
            IString fgh871ZMapaR3() ;
            
            @Data(size=6)
            IInt fgh871HMapaR3() ;
            
            @Data(size=3)
            IString fgh871CIdioIsoR3() ;
            
            @Data(size=8)
            ILong fgh871NsRegFichR3() ;
            
            @Data(size=8)
            ILong fgh871NIdRegDestR3() ;
            
            @Data(size=8)
            ILong fgh871NIdRegCabcR3() ;
            
            @Data(size=8)
            ILong fgh871NIdRegTotR3() ;
            
            @Data(size=9, rpadding=158)
            ILong fgh871TotalMovimentsR3() ;
            
        }
    }
}
