package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghf0860 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fgh860Registo
     */
    @Data
    Fgh860Registo fgh860Registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * FGH860 - DEFENICAO DO FICHEIRO FGH860
     * FICHEIRO DE SGPD PARA MAPA DE MOVIMENTOS DO MONTANTE
     * 
     * @version 2.0
     * 
     */
    public interface Fgh860Registo extends IDataStruct {
        
        @Data(size=230)
        IString fgh860Dados() ;
        
        /**
         * @return instancia da classe local Fgh860Header
         */
        @Data
        @Mask
        Fgh860Header fgh860Header() ;
        
        /**
         * @return instancia da classe local Fgh860Detalhe
         */
        @Data
        @Mask
        Fgh860Detalhe fgh860Detalhe() ;
        
        /**
         * @return instancia da classe local Fgh860Totais
         */
        @Data
        @Mask
        Fgh860Totais fgh860Totais() ;
        
        
        public interface Fgh860Header extends IDataMask {
            
            @Data(size=6)
            IString fgh860CMapaR1() ;
            
            @Data(size=6)
            IString fgh860CTipoRegR1() ;
            
            @Data(size=10)
            IString fgh860ZMapaR1() ;
            
            @Data(size=6)
            IInt fgh860HMapaR1() ;
            
            @Data(size=3)
            IString fgh860CIdioIsoR1() ;
            
            @Data(size=8)
            ILong fgh860NsRegFichR1() ;
            
            @Data(size=8)
            ILong fgh860NIdRegDestR1() ;
            
            @Data(size=8)
            ILong fgh860NIdRegCabcR1() ;
            
            @Data(size=3)
            IString fgh860CPaisIsoContR1() ;
            
            @Data(size=30)
            IString fgh860DPaisIsoContR1() ;
            
            @Data(size=4)
            IInt fgh860CBancContR1() ;
            
            @Data(size=30)
            IString fgh860DBancContR1() ;
            
            @Data(size=4)
            IInt fgh860COeEgcContR1() ;
            
            @Data(size=30)
            IString fgh860DOeEgcContR1() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh860MInicPesqR1() ;
            
            @Data(size=1)
            IString fgh860SinalInicR1() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh860MFimPesqR1() ;
            
            @Data(size=1)
            IString fgh860SinalFimR1() ;
            
            @Data(size=10)
            IString fgh860ZInicPesqR1() ;
            
            @Data(size=10, rpadding=18)
            IString fgh860ZFimPesqR1() ;
            
        }
        
        public interface Fgh860Detalhe extends IDataMask {
            
            @Data(size=6)
            IString fgh860CMapaR2() ;
            
            @Data(size=6)
            IString fgh860CTipoRegR2() ;
            
            @Data(size=10)
            IString fgh860ZMapaR2() ;
            
            @Data(size=6)
            IInt fgh860HMapaR2() ;
            
            @Data(size=3)
            IString fgh860CIdioIsoR2() ;
            
            @Data(size=8)
            ILong fgh860NsRegFichR2() ;
            
            @Data(size=8)
            ILong fgh860NIdRegDestR2() ;
            
            @Data(size=8)
            ILong fgh860NIdRegCabcR2() ;
            
            @Data(size=8)
            ILong fgh860NsRegDtlhCabR2() ;
            
            /**
             * @return instancia da classe local Fgh870SubcontaR2
             */
            @Data
            Fgh870SubcontaR2 fgh870SubcontaR2() ;
            
            @Data(size=10)
            IString fgh860ZMovimentoR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh860MMovimentoR2() ;
            
            @Data(size=1)
            IString fgh860SinalMovR2() ;
            
            @Data(size=1)
            IString fgh860IDbcrR2() ;
            
            @Data(size=1)
            IString fgh860IEstornoR2() ;
            
            @Data(size=4)
            IString fgh860CTipoCanlAcesR2() ;
            
            @Data(size=4)
            IInt fgh860COeEgcOpexR2() ;
            
            @Data(size=8)
            IString fgh860COperadorR2() ;
            
            @Data(size=10)
            IString fgh860ZValorR2() ;
            
            @Data(size=17, decimal=2)
            IDecimal fgh860MMovMoeOrigR2() ;
            
            @Data(size=1)
            IString fgh860SinalMovOrgR2() ;
            
            @Data(size=1)
            IString fgh860IDbcrOrgR2() ;
            
            @Data(size=1)
            IString fgh860IEstornoOrgR2() ;
            
            @Data(size=3)
            IString fgh860CMoedIsoOrgR2() ;
            
            @Data(size=15)
            ILong fgh860NsMovimentoR2() ;
            
            @Data(size=21)
            IString fgh860DDescR2() ;
            
            @Data(size=10, rpadding=15)
            ILong fgh860NDocOppsR2() ;
            
            
            public interface Fgh870SubcontaR2 extends IDataMask {
                
                @Data(size=3)
                IString fgh860CPaisContR2() ;
                
                @Data(size=4)
                IInt fgh860CBancR2() ;
                
                @Data(size=13)
                IString fgh860ContaR2() ;
                
                @Data(size=4)
                IInt fgh860NsDepositoR2() ;
                
                @Data(size=3)
                IString fgh860CMoedIsoSctaR2() ;
                
            }
        }
        
        public interface Fgh860Totais extends IDataMask {
            
            @Data(size=6)
            IString fgh860CMapaR3() ;
            
            @Data(size=6)
            IString fgh860CTipoRegR3() ;
            
            @Data(size=10)
            IString fgh860ZMapaR3() ;
            
            @Data(size=6)
            IInt fgh860HMapaR3() ;
            
            @Data(size=3)
            IString fgh860CIdioIsoR3() ;
            
            @Data(size=8)
            ILong fgh860NsRegFichR3() ;
            
            @Data(size=8)
            ILong fgh860NIdRegDestR3() ;
            
            @Data(size=8)
            ILong fgh860NIdRegCabcR3() ;
            
            @Data(size=8)
            ILong fgh860NIdRegTotR3() ;
            
            @Data(size=9, rpadding=158)
            ILong fgh860TotalMovimentosR3() ;
            
        }
    }
    
}
