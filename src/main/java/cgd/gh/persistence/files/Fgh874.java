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
public abstract class Fgh874 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fgh874Registo
     */
    @Data
    public abstract Fgh874Registo fgh874Registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FGH874 - DEFENICAO DO FICHEIRO FGH874
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DO UTILIZADOR
     * 
     * @version 2.0
     * 
     */
    public interface Fgh874Registo extends IDataStruct {
        
        @Data(size=230)
        IString fgh874Dados() ;
        
        /**
         * @return instancia da classe local Fgh874Header
         */
        @Data
        @Mask
        Fgh874Header fgh874Header() ;
        
        /**
         * @return instancia da classe local Fgh874Detalhe
         */
        @Data
        @Mask
        Fgh874Detalhe fgh874Detalhe() ;
        
        /**
         * @return instancia da classe local Fgh874Totais
         */
        @Data
        @Mask
        Fgh874Totais fgh874Totais() ;
        
        
        public interface Fgh874Header extends IDataMask {
            
            @Data(size=6)
            IString fgh874CMapaR1() ;
            
            @Data(size=6)
            IString fgh874CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh874ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh874HMapaR1() ;
            
            @Data(size=3)
            IString fgh874CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh874NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh874NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh874NIdRegCabcR1() ;
            
            @Data(size=3)
            IString fgh874CPaisIsoContR1() ;
            
            @Data(size=30)
            IString fgh874DPaisIsoContR1() ;
            
            @Data(size=4)
            IInt fgh874CBancContR1() ;
            
            @Data(size=30)
            IString fgh874DBancContR1() ;
            
            @Data(size=4)
            IInt fgh874COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh874DOeEgcContR1() ;
            
            @Data(size=8)
            IString fgh874COperadorR1() ;
            
            @Data(size=10)
            IString fgh874ZInicMovR1() ;
            
            @Data(size=10, rpadding=46)
            IString fgh874ZFimMovR1() ;
            
        }
        
        public interface Fgh874Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh874CMapaR2() ;
            
            @Data(size=6)
            IString fgh874CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh874ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh874HMapaR2() ;
            
            @Data(size=3)
            IString fgh874CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh874NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh874NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh874NIdRegCabcR2() ;
            
            /**
             * @return instancia da classe local Fgh874NsRegDtlhCabR2
             */
            @Data
            Fgh874NsRegDtlhCabR2 fgh874NsRegDtlhCabR2() ;
            
            @Data(size=10)
            IString fgh874ZMovimentoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh874MMovimentoR2() ;
            
            @Data(size=1)
            IString fgh874SinalMovR2() ;
            
            @Data(size=1)
            IString fgh874IDbcrR2() ;
            
            @Data(size=1)
            IString fgh874IEstornoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh874MSldoCbloR2() ;
            
            @Data(size=1)
            IString fgh874SinalSldR2() ;
            
            @Data(size=10)
            IString fgh874ZValorR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh874MMovMoeOrigR2() ;
            
            @Data(size=1)
            IString fgh874SinalMovOrgR2() ;
            
            @Data(size=3)
            IString fgh874CMoedIsoOrgR2() ;
            
            @Data(size=15)
            ILong fgh874NsMovimentoR2() ;
            
            @Data(size=21)
            IString fgh874DDescR2() ;
            
            @Data(size=10)
            ILong fgh874NDocOppsR2() ;
            
            @Data(size=4, rpadding=19)
            IInt fgh874COeEgcOpexR2() ;
            
            
            public interface Fgh874NsRegDtlhCabR2 extends IDataMask {
                
                @Data(size=3)
                IString fgh874CPaisContR2() ;
                
                @Data(size=4)
                IInt fgh874CBancR2() ;
                
                @Data(size=13)
                IString fgh874ContaR2() ;
                
                @Data(size=4)
                IInt fgh874NsDepositoR2() ;
                
                @Data(size=3)
                IString fgh874CMoedIsoSctaR2() ;
                
            }
        }
        
        public interface Fgh874Totais extends IDataMask {
            
            @Data(size=6)
            IString fgh874CMapaR3() ;
            
            @Data(size=6)
            IString fgh874CTipoRegR3() ;
            
            @Data(size=10)
            IString fgh874ZMapaR3() ;
            
            @Data(size=6)
            IInt fgh874HMapaR3() ;
            
            @Data(size=3)
            IString fgh874CIdioIsoR3() ;
            
            @Data(size=8)
            ILong fgh874NsRegFichR3() ;
            
            @Data(size=8)
            ILong fgh874NIdRegDestR3() ;
            
            @Data(size=8)
            ILong fgh874NIdRegCabcR3() ;
            
            @Data(size=8)
            ILong fgh874NIdRegTotR3() ;
            
            @Data(size=9, rpadding=158)
            ILong fgh874TotalMovimentsR3() ;
            
        }
    }
}
