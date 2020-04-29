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
public interface Bghr4391 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fgh439Registo
     */
    @Data
    Fgh439Registo fgh439Registo() ;
    
    /**
     * @return instancia da classe local WsLayoutEscrita
     */
    @Data
    WsLayoutEscrita wsLayoutEscrita() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPYBOOK : BGHR4391
     * LAYOUT DO FICHEIRO FGH439 COM A ESTRUTURA DO JCL PARA PESQUISA
     * EM FICHEIRO HISTORICO
     * ACTUALIZACOES AO COPYBOOK:
     * DATA   /       AUTOR       / DESCRICAO :
     * 14-08-18 / ACCENTURE         / CRIACAO
     * 
     * @version 2.0
     * 
     */
    public interface Fgh439Registo extends IDataStruct {
        
        @Data(size=80)
        IString fgh439CampoLivre() ;
        
    }
    public interface WsLayoutEscrita extends IDataStruct {
        
        /**
         * @return instancia da classe local LinhaCab01
         */
        @Data
        LinhaCab01 linhaCab01() ;
        
        /**
         * @return instancia da classe local LinhaCab02
         */
        @Data
        LinhaCab02 linhaCab02() ;
        
        /**
         * @return instancia da classe local LinhaCab03
         */
        @Data
        LinhaCab03 linhaCab03() ;
        
        /**
         * @return instancia da classe local LinhaCab04
         */
        @Data
        LinhaCab04 linhaCab04() ;
        
        /**
         * @return instancia da classe local LinhaCab05
         */
        @Data
        LinhaCab05 linhaCab05() ;
        
        /**
         * @return instancia da classe local LinhaCab06
         */
        @Data
        LinhaCab06 linhaCab06() ;
        
        /**
         * @return instancia da classe local LinhaCab07
         */
        @Data
        LinhaCab07 linhaCab07() ;
        
        /**
         * @return instancia da classe local LinhaCab08
         */
        @Data
        LinhaCab08 linhaCab08() ;
        
        /**
         * @return instancia da classe local LinhaSortin01
         */
        @Data
        LinhaSortin01 linhaSortin01() ;
        
        /**
         * @return instancia da classe local LinhaSortin02
         */
        @Data
        LinhaSortin02 linhaSortin02() ;
        
        /**
         * @return instancia da classe local LinhaSortin03
         */
        @Data
        LinhaSortin03 linhaSortin03() ;
        
        
        public interface LinhaCab01 extends IDataStruct {
            
            @Data(size=3, value="//*")
            IString filler001() ;
            
            @Data(size=1, value="+")
            IString filler002() ;
            
            @Data(size=75, value="---------------------------------------------------------------------------")
            IString filler003() ;
            
            @Data(size=1, value="+")
            IString filler004() ;
            
        }
        
        public interface LinhaCab02 extends IDataStruct {
            
            @Data(size=3, value="//*")
            IString filler001() ;
            
            @Data(size=1, value="|")
            IString filler002() ;
            
            @Data(size=48, value="      SORT01 - MERGE DE FICHEIROS               ")
            IString filler003() ;
            
            /**
             * 05 FILLER             PIC X(27) VALUE  '            '.
             */
            @Data(size=27, value=" ")
            IString filler004() ;
            
            @Data(size=1, value="|")
            IString filler005() ;
            
        }
        
        public interface LinhaCab03 extends IDataStruct {
            
            @Data(size=3, value="//*")
            IString filler001() ;
            
            @Data(size=1, value="+")
            IString filler002() ;
            
            @Data(size=75, value="---------------------------------------------------------------------------")
            IString filler003() ;
            
            @Data(size=1, value="+")
            IString filler004() ;
            
        }
        
        public interface LinhaCab04 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=48, value="SORT01 EXEC PGM=ICEMAN,COND=(0,NE)              ")
            IString filler002() ;
            
            @Data(size=30, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab05 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="SYSPRINT DD  SYSOUT=*                             ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab06 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="SYSOUT   DD  SYSOUT=*                             ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab07 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="TOOLMSG  DD  SYSOUT=*                             ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaCab08 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=50, value="DFSMSG   DD  SYSOUT=*                             ")
            IString filler002() ;
            
            @Data(size=28, value=" ")
            IString filler003() ;
            
        }
        
        public interface LinhaSortin01 extends IDataStruct {
            
            @Data(size=6, lpadding=2, lpaddingValue="//")
            IString wsSortin() ;
            
            @Data(size=16, value="   DD  DISP=SHR,")
            IString filler001() ;
            
            @Data(size=56, value=" ")
            IString filler002() ;
            
        }
        
        public interface LinhaSortin02 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=13, value=" ")
            IString filler002() ;
            
            @Data(size=4, value="DSN=")
            IString filler003() ;
            
            @Data(size=32, rpadding=29, rpaddingValue="")
            IString wsFicheiro() ;
            
        }
        
        public interface LinhaSortin03 extends IDataStruct {
            
            @Data(size=2, value="//")
            IString filler001() ;
            
            @Data(size=6, value=" ")
            IString filler002() ;
            
            @Data(size=16, value="   DD  DISP=SHR,")
            IString filler003() ;
            
            @Data(size=16, value="UNIT=AFF=SORTIN,")
            IString filler004() ;
            
            @Data(size=40, value=" ")
            IString filler005() ;
            
        }
    }
    
}
