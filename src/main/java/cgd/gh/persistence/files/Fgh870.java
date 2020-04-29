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
public abstract class Fgh870 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fgh870Registo
     */
    @Data
    public abstract Fgh870Registo fgh870Registo() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FGH870 - DEFENICAO DO FICHEIRO FGH870
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DA SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface Fgh870Registo extends IDataStruct {
        
        @Data(size=230)
        IString fgh870Dados() ;
        
        /**
         * @return instancia da classe local Fgh870Header
         */
        @Data
        @Mask
        Fgh870Header fgh870Header() ;
        
        /**
         * @return instancia da classe local Fgh870Detalhe
         */
        @Data
        @Mask
        Fgh870Detalhe fgh870Detalhe() ;
        
        /**
         * @return instancia da classe local Fgh870Totais
         */
        @Data
        @Mask
        Fgh870Totais fgh870Totais() ;
        
        
        public interface Fgh870Header extends IDataMask {
            
            @Data(size=6)
            IString fgh870CMapaR1() ;
            
            @Data(size=6)
            IString fgh870CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh870ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh870HMapaR1() ;
            
            @Data(size=3)
            IString fgh870CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh870NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh870NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh870NIdRegCabcR1() ;
            
            @Data(size=3)
            IString fgh870CPaisIsoContR1() ;
            
            @Data(size=30)
            IString fgh870DPaisIsoContR1() ;
            
            @Data(size=4)
            IInt fgh870CBancContR1() ;
            
            @Data(size=30)
            IString fgh870DBancContR1() ;
            
            @Data(size=4)
            IInt fgh870COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh870DOeEgcContR1() ;
            
            @Data(size=10)
            IString fgh870ZInicPesqR1() ;
            
            @Data(size=10)
            IString fgh870ZFimPesqR1() ;
            
            /**
             * @return instancia da classe local Fgh870SubcontaR1
             */
            @Data(rpadding=27)
            Fgh870SubcontaR1 fgh870SubcontaR1() ;
            
            
            public interface Fgh870SubcontaR1 extends IDataMask {
                
                @Data(size=3)
                IString fgh870CPaisContR1() ;
                
                @Data(size=4)
                IInt fgh870CBancR1() ;
                
                @Data(size=13)
                IString fgh870ContaR1() ;
                
                @Data(size=4)
                IInt fgh870NsDepositoR1() ;
                
                @Data(size=3)
                IString fgh870CMoedIsoSctaR1() ;
                
            }
        }
        
        public interface Fgh870Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh870CMapaR2() ;
            
            @Data(size=6)
            IString fgh870CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh870ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh870HMapaR2() ;
            
            @Data(size=3)
            IString fgh870CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh870NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh870NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh870NIdRegCabcR2() ;
            
            @Data(size=8)
            ILong fgh870NsRegDtlhCabR2() ;
            
            @Data(size=10)
            IString fgh870ZMovimentoR2() ;
            
            @Data(size=21)
            IString fgh870DDescR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh870MMovimentoR2() ;
            
            @Data(size=1)
            IString fgh870SinalMovR2() ;
            
            @Data(size=1)
            IString fgh870IDbcrR2() ;
            
            @Data(size=1)
            IString fgh870IEstornoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh870MSldoCbloR2() ;
            
            @Data(size=1)
            IString fgh870SinalSldR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh870MSldoDpnlR2() ;
            
            @Data(size=1)
            IString fgh870SinalDpnlR2() ;
            
            @Data(size=10)
            IString fgh870ZValorR2() ;
            
            @Data(size=10)
            ILong fgh870NDocOppsR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh870MMovMoeOrigR2() ;
            
            @Data(size=1)
            IString fgh870SinalMovOrgR2() ;
            
            @Data(size=3)
            IString fgh870CMoedIsoOrgR2() ;
            
            @Data(size=2)
            IString fgh870AAplR2() ;
            
            @Data(size=15, rpadding=22)
            ILong fgh870NsMovimentoR2() ;
            
        }
        
        public interface Fgh870Totais extends IDataMask {
            
            @Data(size=6)
            IString fgh870CMapaR3() ;
            
            @Data(size=6)
            IString fgh870CTipoRegR3() ;
            
            @Data(size=10)
            IString fgh870ZMapaR3() ;
            
            @Data(size=6)
            IInt fgh870HMapaR3() ;
            
            @Data(size=3)
            IString fgh870CIdioIsoR3() ;
            
            @Data(size=8)
            ILong fgh870NsRegFichR3() ;
            
            @Data(size=8)
            ILong fgh870NIdRegDestR3() ;
            
            @Data(size=8)
            ILong fgh870NIdRegCabcR3() ;
            
            @Data(size=8)
            ILong fgh870NIdRegTotR3() ;
            
            @Data(size=9, rpadding=158)
            ILong fgh870TotalMovimentsR3() ;
            
        }
    }
}
