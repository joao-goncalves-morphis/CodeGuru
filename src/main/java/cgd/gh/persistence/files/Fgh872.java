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
public abstract class Fgh872 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fgh872Registo
     */
    @Data
    public abstract Fgh872Registo fgh872Registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FGH872 - DEFENICAO DO FICHEIRO FGH872
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DA SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface Fgh872Registo extends IDataStruct {
        
        @Data(size=299)
        IString fgh872Dados() ;
        
        /**
         * @return instancia da classe local Fgh872Header
         */
        @Data
        @Mask
        Fgh872Header fgh872Header() ;
        
        /**
         * @return instancia da classe local Fgh872Detalhe
         */
        @Data
        @Mask
        Fgh872Detalhe fgh872Detalhe() ;
        
        /**
         * @return instancia da classe local Fgh872Totais
         */
        @Data
        @Mask
        Fgh872Totais fgh872Totais() ;
        
        
        public interface Fgh872Header extends IDataMask {
            
            @Data(size=6)
            IString fgh872CMapaR1() ;
            
            @Data(size=6)
            IString fgh872CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh872ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh872HMapaR1() ;
            
            @Data(size=3)
            IString fgh872CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh872NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh872NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh872NIdRegCabcR1() ;
            
            @Data(size=3)
            IString fgh872CPaisIsoContR1() ;
            
            @Data(size=30)
            IString fgh872DPaisIsoContR1() ;
            
            @Data(size=4)
            IInt fgh872CBancContR1() ;
            
            @Data(size=30)
            IString fgh872DBancContR1() ;
            
            @Data(size=4)
            IInt fgh872COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh872DOeEgcContR1() ;
            
            @Data(size=10)
            IString fgh872ZInicPesqR1() ;
            
            @Data(size=10)
            IString fgh872ZFimPesqR1() ;
            
            @Data(size=3)
            IString fgh872CPaisContR1() ;
            
            @Data(size=4)
            IInt fgh872CBancR1() ;
            
            @Data(size=13)
            IString fgh872ContaR1() ;
            
            @Data(size=4)
            IInt fgh872NsDepositoR1() ;
            
            @Data(size=3, rpadding=96)
            IString fgh872CMoedIsoSctaR1() ;
            
        }
        
        public interface Fgh872Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh872CMapaR2() ;
            
            @Data(size=6)
            IString fgh872CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh872ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh872HMapaR2() ;
            
            @Data(size=3)
            IString fgh872CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh872NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh872NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh872NIdRegCabcR2() ;
            
            @Data(size=8)
            ILong fgh872NsRegDtlhCabR2() ;
            
            @Data(size=10)
            IString fgh872ZMovimentoR2() ;
            
            @Data(size=21)
            IString fgh872DDescR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MMovimentoR2() ;
            
            @Data(size=1)
            IString fgh872SinalMovR2() ;
            
            @Data(size=1)
            IString fgh872IDbcrR2() ;
            
            @Data(size=1)
            IString fgh872IEstornoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MSldoCbloR2() ;
            
            @Data(size=1)
            IString fgh872SinalSldR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MSldoDpnlR2() ;
            
            @Data(size=1)
            IString fgh872SinalDpnlR2() ;
            
            @Data(size=10)
            IString fgh872ZValorR2() ;
            
            @Data(size=10)
            ILong fgh872NDocOppsR2() ;
            
            @Data(size=3)
            IString fgh872CMoedIsoOrgR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MMovMoeOrigR2() ;
            
            @Data(size=1)
            IString fgh872SinalMovOrgR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MSldoRetdR2() ;
            
            @Data(size=1)
            IString fgh872SinalSldoRetdR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MSldoVcobR2() ;
            
            @Data(size=1)
            IString fgh872SinalSldoVcobR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MCmrgLimR2() ;
            
            @Data(size=1)
            IString fgh872SinalCmrgLimR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MCmrgUtidR2() ;
            
            @Data(size=1)
            IString fgh872SinalCmrgUtidR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MDcboNgcdAtrdR2() ;
            
            @Data(size=1)
            IString fgh872SinalDcboNgcdAtrdR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh872MDcboNgcdUtidR2() ;
            
            @Data(size=1)
            IString fgh872SinalDcboNgcdUtidR2() ;
            
        }
        
        public interface Fgh872Totais extends IDataMask {
            
            @Data(size=6)
            IString fgh872CMapaR3() ;
            
            @Data(size=6)
            IString fgh872CTipoRegR3() ;
            
            @Data(size=10)
            IString fgh872ZMapaR3() ;
            
            @Data(size=6)
            IInt fgh872HMapaR3() ;
            
            @Data(size=3)
            IString fgh872CIdioIsoR3() ;
            
            @Data(size=8)
            ILong fgh872NsRegFichR3() ;
            
            @Data(size=8)
            ILong fgh872NIdRegDestR3() ;
            
            @Data(size=8)
            ILong fgh872NIdRegCabcR3() ;
            
            @Data(size=8)
            ILong fgh872NIdRegTotR3() ;
            
            @Data(size=9, rpadding=227)
            ILong fgh872TotalMovimentsR3() ;
            
        }
    }
}
