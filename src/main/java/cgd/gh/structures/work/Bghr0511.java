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
public interface Bghr0511 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * DEFINICAO DE FICHEIRO FGH051
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=200)
        IString registoDados() ;
        
        /**
         * @return instancia da classe local RegistoHeader1
         */
        @Data
        @Mask
        RegistoHeader1 registoHeader1() ;
        
        /**
         * @return instancia da classe local RegistoHeader3
         */
        @Data
        @Mask
        RegistoHeader3 registoHeader3() ;
        
        /**
         * @return instancia da classe local RegistoDetalhe
         */
        @Data
        @Mask
        RegistoDetalhe registoDetalhe() ;
        
        
        public interface RegistoHeader1 extends IDataMask {
            
            @Data(size=16, rpadding=182)
            IString tituloH1() ;
            
        }
        
        public interface RegistoHeader3 extends IDataMask {
            
            @Data(size=8)
            IString paisIsoaGH() ;
            
            @Data(size=1)
            IString fillerH1() ;
            
            @Data(size=8)
            IString bancGesH() ;
            
            @Data(size=1)
            IString fillerH2() ;
            
            @Data(size=8)
            IString oeGesH() ;
            
            @Data(size=1)
            IString fillerH3() ;
            
            @Data(size=8)
            IString paisContH() ;
            
            @Data(size=1)
            IString fillerH4() ;
            
            @Data(size=8)
            IString bancContH() ;
            
            @Data(size=1)
            IString fillerH5() ;
            
            @Data(size=8)
            IString oeContH() ;
            
            @Data(size=1)
            IString fillerH6() ;
            
            @Data(size=8)
            IString rdclContH() ;
            
            @Data(size=1)
            IString fillerH7() ;
            
            @Data(size=8)
            IString chkdContH() ;
            
            @Data(size=1)
            IString fillerH8() ;
            
            @Data(size=8)
            IString tipoContH() ;
            
            @Data(size=1)
            IString fillerH9() ;
            
            @Data(size=7)
            IString nClienteH() ;
            
            @Data(size=1)
            IString fillerH10() ;
            
            @Data(size=10)
            IString nsAbraCliH() ;
            
            @Data(size=1)
            IString fillerH11() ;
            
            @Data(size=8)
            IString iTipoItvtH() ;
            
            @Data(size=1)
            IString fillerH12() ;
            
            @Data(size=10)
            IString nsTitcH() ;
            
            @Data(size=1)
            IString fillerH13() ;
            
            @Data(size=9)
            IString iSitCliH() ;
            
            @Data(size=1)
            IString fillerH14() ;
            
            @Data(size=17)
            IString zInicRelH() ;
            
            @Data(size=1)
            IString fillerH15() ;
            
            @Data(size=9)
            IString iEstContH() ;
            
            @Data(size=1)
            IString fillerH16() ;
            
            @Data(size=15)
            IString iRstzContH() ;
            
            @Data(size=1)
            IString fillerH17() ;
            
            @Data(size=9)
            IString mSldContabH() ;
            
            @Data(size=1, rpadding=14)
            IString fillerH18() ;
            
        }
        
        public interface RegistoDetalhe extends IDataMask {
            
            @Data(size=3)
            IString cPaisIsoaGerx() ;
            
            @Data(size=1)
            IString v01() ;
            
            @Data(size=4)
            IInt cBancGcxGerx() ;
            
            @Data(size=1)
            IString v02() ;
            
            @Data(size=4)
            IInt cOeEgcGerx() ;
            
            @Data(size=1)
            IString v03() ;
            
            /**
             * @return instancia da classe local Conta
             */
            @Data
            Conta conta() ;
            
            @Data(size=10)
            ILong nCliente() ;
            
            @Data(size=1)
            IString v10() ;
            
            @Data(size=3)
            IInt nsAbraCli() ;
            
            @Data(size=1)
            IString v11() ;
            
            @Data(size=3)
            IInt iTipoItvt() ;
            
            @Data(size=1)
            IString v12() ;
            
            @Data(size=3)
            IInt nsTitc() ;
            
            @Data(size=1)
            IString v13() ;
            
            @Data(size=3)
            IString iSitCli() ;
            
            @Data(size=1)
            IString v14() ;
            
            @Data(size=10)
            IString zInicRel() ;
            
            @Data(size=1)
            IString v15() ;
            
            @Data(size=2)
            IString iEstCont() ;
            
            @Data(size=1)
            IString v16() ;
            
            @Data(size=1)
            IString iExisRstzCont() ;
            
            @Data(size=1)
            IString v17() ;
            
            @Data(format="ZZZ.ZZZ.ZZZ.ZZ9,99-")
            IFormattedString mSldoCblo() ;
            
            @Data(size=1)
            IString v18() ;
            
            @Data(size=95)
            IString filler() ;
            
            
            public interface Conta extends IDataMask {
                
                @Data(size=3)
                IString cPaisIsoaCont() ;
                
                @Data(size=1)
                IString v04() ;
                
                @Data(size=4)
                IInt cBancCont() ;
                
                @Data(size=1)
                IString v05() ;
                
                @Data(size=4)
                IInt cOeEgcCont() ;
                
                @Data(size=1)
                IString v06() ;
                
                @Data(size=7)
                IInt nsRdclCont() ;
                
                @Data(size=1)
                IString v07() ;
                
                @Data(size=1)
                IInt vChkdCont() ;
                
                @Data(size=1)
                IString v08() ;
                
                @Data(size=3)
                IInt cTipoCont() ;
                
                @Data(size=1)
                IString v09() ;
                
            }
        }
    }
    
}
