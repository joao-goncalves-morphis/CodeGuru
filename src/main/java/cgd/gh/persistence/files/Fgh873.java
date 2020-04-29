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
public abstract class Fgh873 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fgh873Registo
     */
    @Data
    public abstract Fgh873Registo fgh873Registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FGH873 - DEFINICAO DO FICHEIRO FGH873
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DA SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface Fgh873Registo extends IDataStruct {
        
        @Data(size=230)
        IString fgh873Dados() ;
        
        /**
         * @return instancia da classe local Fgh873Header
         */
        @Data
        @Mask
        Fgh873Header fgh873Header() ;
        
        /**
         * @return instancia da classe local Fgh873Detalhe
         */
        @Data
        @Mask
        Fgh873Detalhe fgh873Detalhe() ;
        
        /**
         * @return instancia da classe local Fgh873Totais
         */
        @Data
        @Mask
        Fgh873Totais fgh873Totais() ;
        
        
        public interface Fgh873Header extends IDataMask {
            
            @Data(size=6)
            IString fgh873CMapaR1() ;
            
            @Data(size=6)
            IString fgh873CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh873ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh873HMapaR1() ;
            
            @Data(size=3)
            IString fgh873CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh873NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh873NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh873NIdRegCabcR1() ;
            
            @Data(size=3)
            IString fgh873CPaisIsoContR1() ;
            
            @Data(size=30)
            IString fgh873DPaisIsoContR1() ;
            
            @Data(size=4)
            IInt fgh873CBancContR1() ;
            
            @Data(size=30)
            IString fgh873DBancContR1() ;
            
            @Data(size=4)
            IInt fgh873COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh873DOeEgcContR1() ;
            
            @Data(size=10)
            IString fgh873ZInicPesqR1() ;
            
            @Data(size=10)
            IString fgh873ZFimPesqR1() ;
            
            @Data(size=3)
            IString fgh873CPaisContR1() ;
            
            @Data(size=4)
            IInt fgh873CBancR1() ;
            
            @Data(size=13)
            IString fgh873ContaR1() ;
            
            @Data(size=4)
            IInt fgh873NsDepositoR1() ;
            
            @Data(size=3)
            IString fgh873CMoedIsoSctaR1() ;
            
        }
        
        public interface Fgh873Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh873CMapaR2() ;
            
            @Data(size=6)
            IString fgh873CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh873ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh873HMapaR2() ;
            
            @Data(size=3)
            IString fgh873CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh873NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh873NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh873NIdRegCabcR2() ;
            
            @Data(size=8)
            ILong fgh873NsRegDtlhCabR2() ;
            
            @Data(size=10)
            IString fgh873ZMovimentoR2() ;
            
            @Data(size=21)
            IString fgh873DDescR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh873MMovimentoR2() ;
            
            @Data(size=1)
            IString fgh873SinalMovR2() ;
            
            @Data(size=1)
            IString fgh873IDbcrR2() ;
            
            @Data(size=1)
            IString fgh873IEstornoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh873MSldoCbloR2() ;
            
            @Data(size=1)
            IString fgh873SinalSldR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh873MSldoDpnlR2() ;
            
            @Data(size=1)
            IString fgh873SinalDpnlR2() ;
            
            @Data(size=10)
            IString fgh873ZValorR2() ;
            
            @Data(size=10)
            ILong fgh873NDocOppsR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh873MMovMoeOrigR2() ;
            
            @Data(size=1)
            IString fgh873SinalMovOrgR2() ;
            
            @Data(size=3)
            IString fgh873CMoedIsoOrgR2() ;
            
            @Data(size=9)
            IString fgh873CProdutoR2() ;
            
            @Data(size=7)
            IInt fgh873CSectGrupoR2() ;
            
            @Data(size=4)
            IInt fgh873CCndzContR2() ;
            
            @Data(size=15, rpadding=4)
            ILong fgh873NsMovimentoR2() ;
            
        }
        
        public interface Fgh873Totais extends IDataMask {
            
            @Data(size=6)
            IString fgh873CMapaR3() ;
            
            @Data(size=6)
            IString fgh873CTipoRegR3() ;
            
            @Data(size=10)
            IString fgh873ZMapaR3() ;
            
            @Data(size=6)
            IInt fgh873HMapaR3() ;
            
            @Data(size=3)
            IString fgh873CIdioIsoR3() ;
            
            @Data(size=8)
            ILong fgh873NsRegFichR3() ;
            
            @Data(size=8)
            ILong fgh873NIdRegDestR3() ;
            
            @Data(size=8)
            ILong fgh873NIdRegCabcR3() ;
            
            @Data(size=8)
            ILong fgh873NIdRegTotR3() ;
            
            @Data(size=9, rpadding=158)
            ILong fgh873TotalMovimentsR3() ;
            
        }
    }
}
