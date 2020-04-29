package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr1231 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fgh123Registo
     */
    @Data
    Fgh123Registo fgh123Registo() ;
    
    /**
     * @return instancia da classe local WsLayoutEscrita2
     */
    @Data
    WsLayoutEscrita2 wsLayoutEscrita2() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPYBOOK : BGHR1231
     * LAYOUT DO FICHEIRO FGH123 COM A ESTRUTURA DA CONDICAO DE
     * INCLUDE PARA PESQUISA EM FICHEIRO DE HISTORICO
     * ACTUALIZACOES AO COPYBOOK:
     * DATA   /       AUTOR       / DESCRICAO :
     * 14-08-18 / ACCENTURE         / CRIACAO
     * 
     * @version 2.0
     * 
     */
    public interface Fgh123Registo extends IDataStruct {
        
        @Data(size=80)
        IString fgh123CampoLivre() ;
        
    }
    public interface WsLayoutEscrita2 extends IDataStruct {
        
        /**
         * @return instancia da classe local LinhaParm01
         */
        @Data
        LinhaParm01 linhaParm01() ;
        
        /**
         * @return instancia da classe local LinhaParm02
         */
        @Data
        LinhaParm02 linhaParm02() ;
        
        /**
         * @return instancia da classe local LinhaParm03
         */
        @Data
        LinhaParm03 linhaParm03() ;
        
        /**
         * @return instancia da classe local LinhaParm04
         */
        @Data
        LinhaParm04 linhaParm04() ;
        
        /**
         * @return instancia da classe local LinhaParm05
         */
        @Data
        LinhaParm05 linhaParm05() ;
        
        /**
         * @return instancia da classe local LinhaParm06
         */
        @Data
        LinhaParm06 linhaParm06() ;
        
        /**
         * @return instancia da classe local LinhaParm07
         */
        @Data
        LinhaParm07 linhaParm07() ;
        
        /**
         * @return instancia da classe local LinhaParm08
         */
        @Data
        LinhaParm08 linhaParm08() ;
        
        /**
         * @return instancia da classe local LinhaParm09
         */
        @Data
        LinhaParm09 linhaParm09() ;
        
        /**
         * @return instancia da classe local LinhaParm10
         */
        @Data
        LinhaParm10 linhaParm10() ;
        
        /**
         * @return instancia da classe local LinhaParm11
         */
        @Data
        LinhaParm11 linhaParm11() ;
        
        /**
         * @return instancia da classe local LinhaParm12
         */
        @Data
        LinhaParm12 linhaParm12() ;
        
        /**
         * @return instancia da classe local LinhaParm13
         */
        @Data
        LinhaParm13 linhaParm13() ;
        
        /**
         * @return instancia da classe local LinhaParm14
         */
        @Data
        LinhaParm14 linhaParm14() ;
        
        /**
         * @return instancia da classe local LinhaParm15
         */
        @Data
        LinhaParm15 linhaParm15() ;
        
        /**
         * @return instancia da classe local LinhaParm16
         */
        @Data
        LinhaParm16 linhaParm16() ;
        
        
        public interface LinhaParm01 extends IDataStruct {
            
            @Data(size=6, value=" ")
            IString filler001() ;
            
            @Data(size=16, value="SORT FIELDS=COPY")
            IString filler002() ;
            
            @Data(size=58, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaParm02 extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString filler001() ;
            
            @Data(size=13, value="INCLUDE COND=")
            IString filler002() ;
            
            @Data(size=2, value="((")
            IString filler003() ;
            
            @Data(size=13, value="67,10,CH,EQ,C")
            IString filler004() ;
            
            @Data(size=1)
            IString filler005() ;
            
            @Data(size=10)
            IString wsData1() ;
            
            @Data(size=1)
            IString filler006() ;
            
            @Data(size=4, value=",OR,")
            IString filler007() ;
            
            @Data(size=28, value=" ")
            IString filler008() ;
            
        }
        
        public interface LinhaParm03 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="67,10,CH,LE,C")
            IString filler002() ;
            
            @Data(size=10)
            IString wsData2() ;
            
            @Data(size=7, value="),AND,")
            IString filler003() ;
            
            @Data(size=26, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm04 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=23, value="(01,03,CH,EQ,C'PT',AND,")
            IString filler002() ;
            
            @Data(size=36, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaParm05 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=23, value="04,03,PD,EQ,0035,AND,")
            IString filler002() ;
            
            @Data(size=38, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaParm06 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="07,03,PD,EQ,")
            IString filler002() ;
            
            @Data(size=4)
            IString wsOe1() ;
            
            @Data(size=5, value=",AND,")
            IString filler003() ;
            
            @Data(size=38, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm07 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="10,04,PD,EQ,")
            IString filler002() ;
            
            @Data(size=7)
            IString wsNsRdcl1() ;
            
            @Data(size=5, value=",AND,")
            IString filler003() ;
            
            @Data(size=35, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm08 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="14,01,PD,EQ,")
            IString filler002() ;
            
            @Data(size=1)
            IString wsVChkd1() ;
            
            @Data(size=5, value=",AND,")
            IString filler003() ;
            
            @Data(size=41, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm09 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="15,02,PD,EQ,")
            IString filler002() ;
            
            @Data(size=3)
            IString wsCTipo1() ;
            
            @Data(size=2, value="))")
            IString filler003() ;
            
            @Data(size=42, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm10 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=24, value="((01,03,CH,EQ,C'PT',AND,")
            IString filler002() ;
            
            @Data(size=35, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaParm11 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="15,02,PD,EQ,")
            IString filler002() ;
            
            @Data(size=3)
            IString wsCTipo2() ;
            
            @Data(size=5, value="),OR,")
            IString filler003() ;
            
            @Data(size=39, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm12 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=12, value="15,02,PD,EQ,")
            IString filler002() ;
            
            @Data(size=3)
            IString wsCTipo3() ;
            
            @Data(size=3, value=")))")
            IString filler003() ;
            
            @Data(size=41, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm13 extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString filler001() ;
            
            @Data(size=13, value="INCLUDE COND=")
            IString filler002() ;
            
            @Data(size=3, value="(((")
            IString filler003() ;
            
            @Data(size=14, value="67,10,CH,EQ,C")
            IString filler004() ;
            
            @Data(size=10)
            IString wsData3() ;
            
            @Data(size=5, value=",OR,")
            IString filler005() ;
            
            @Data(size=27, value=" ")
            IString filler006() ;
            
        }
        
        public interface LinhaParm14 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=15, value="(67,10,CH,EQ,C")
            IString filler002() ;
            
            @Data(size=10)
            IString wsData4() ;
            
            @Data(size=5, value=",OR,")
            IString filler003() ;
            
            @Data(size=29, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm15 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="67,10,CH,LE,C")
            IString filler002() ;
            
            @Data(size=10)
            IString wsData5() ;
            
            @Data(size=6, value="),OR,")
            IString filler003() ;
            
            @Data(size=29, value=" ")
            IString filler004() ;
            
        }
        
        public interface LinhaParm16 extends IDataStruct {
            
            @Data(size=21, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="67,10,CH,LE,C")
            IString filler002() ;
            
            @Data(size=10)
            IString wsData6() ;
            
            @Data(size=8, value=")),AND,")
            IString filler003() ;
            
            @Data(size=27, value=" ")
            IString filler004() ;
            
        }
    }
    
}
