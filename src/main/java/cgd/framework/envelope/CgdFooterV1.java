package cgd.framework.envelope;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface CgdFooterV1 extends IDataStruct {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe local Journal
     */
    @Data
    Journal journal() ;
    
    /**
     * @return instancia da classe local AutorizacoesNiv
     */
    @Data
    AutorizacoesNiv autorizacoesNiv() ;
    
    /**
     * @return instancia da classe local Assyncrono
     */
    @Data
    Assyncrono assyncrono() ;
    
    /**
     * ****************** INICIO HT320 E HT321 **********************
     * 10 BHTL001A-X-ALIG-TRNZ-ASIN        PIC  X(249).
     * @return instancia da classe local Header1
     */
    @Data
    Header1 header1() ;
    
    /**
     * HEADER-2 FOI INCLUIDOS PARA UTILIZAOES FUTURAS
     * @return instancia da classe local Header2
     */
    @Data
    Header2 header2() ;
    
    /**
     * CAMPO APLICACAO E OPCAO MENU ORIGEM
     * @return instancia da classe local Header3
     */
    @Data
    Header3 header3() ;
    
    /**
     * CAMPO BHTL001A-I-MSG-TRUD INCLUIDO A PEDIDO DA WAI
     */
    @Data(size=1)
    IString iMsgTrud() ;
    @Data
    @Condition("N")
    ICondition naoTruncada() ;
    @Data
    @Condition("S")
    ICondition truncada() ;
    
    
    /**
     * CAMPOS DE APLICAOES PARA DESCODIFICAR AUTORIZACOES
     * @return instancia da classe local AplicacoesAutoriz
     */
    @Data(length=15)
    IArray<AplicacoesAutoriz> aplicacoesAutoriz() ;
    
    @Data(size=102)
    IString filler() ;
    
    /**
     * ******************  FIM  HT320 E HT321 ***********************
     */
    @Data(size=2, signed=true, compression=COMP3)
    IInt qPgnCnslLstMax() ;
    
    @Data(size=1)
    IString iCexiApl() ;
    @Data
    @Condition("S")
    ICondition iCexiAplSim() ;
    @Data
    @Condition("N")
    ICondition iCexiAplNao() ;
    
    
    @Data(size=4)
    IString cTrnzProx() ;
    
    @Data(size=1, signed=true)
    IInt cImgTabJour() ;
    
    @Data(size=1, signed=true)
    IInt iTabJourMov() ;
    @Data
    @Condition("1")
    ICondition journal1() ;
    @Data
    @Condition("2")
    ICondition journal2() ;
    @Data
    @Condition("3")
    ICondition journal3() ;
    @Data
    @Condition("4")
    ICondition journal4() ;
    @Data
    @Condition("5")
    ICondition journalVespera() ;
    
    
    /**
     * @return instancia da classe local ErrosGraves
     */
    @Data
    ErrosGraves errosGraves() ;
    
    /**
     * @return instancia da classe local CicsLog
     */
    @Data
    CicsLog cicsLog() ;
    
    /**
     * @return instancia da classe local Db2Log
     */
    @Data
    Db2Log db2Log() ;
    
    @Data(size=8, signed=true, compression=COMP)
    ILong cEibresp() ;
    
    
    
    public interface Journal extends IDataStruct {
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
    }
    
    public interface AutorizacoesNiv extends IDataStruct {
        
        @Data(size=1)
        IInt ctNvlAtzBbn() ;
        
        @Data(size=3)
        IString cPaisIsoCtaAtz() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancAtrz() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcContAtrz() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclContAtrz() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdContAtrz() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContAtrz() ;
        
        @Data(size=3)
        IString cMoedIsoSctaAtrz() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepositoAtrz() ;
        
        @Data(size=10)
        IString zValor() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnl() ;
        
        @Data(size=3)
        IString cMoedIso() ;
        
    }
    
    public interface Assyncrono extends IDataStruct {
        
        @Data(size=1)
        IString iTipoPrctTrnz() ;
        @Data
        @Condition("S")
        ICondition iTipoPrctTrnzOn() ;
        @Data
        @Condition("A")
        ICondition iTipoPrctTrnzOff() ;
        
        
    }
    
    
    /**
     * 
     * ****************** INICIO HT320 E HT321 **********************
     * 10 BHTL001A-X-ALIG-TRNZ-ASIN        PIC  X(249).
     * 
     * @version 2.0
     * 
     */
    public interface Header1 extends IDataStruct {
        
        @Data(size=2)
        IString aAplCanl() ;
        
        @Data(size=12, signed=true, compression=COMP3)
        ILong xIdMovCriv() ;
        
        @Data(size=3)
        IString cPaisIsaOeAcrl() ;
        
        @Data(size=3)
        IString cMnemEgcAcrl() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcAcrl() ;
        
        @Data(size=4)
        IString cTermAcrl() ;
        
        @Data(size=3)
        IString cPaisIsaOeAlcl() ;
        
        @Data(size=3)
        IString cMnemEgcAlcl() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcAlcl() ;
        
        @Data(size=4)
        IString cTermAlcl() ;
        
        @Data(size=1)
        IString iMsgLong() ;
        @Data
        @Condition("S")
        ICondition iMsgSup1300Sim() ;
        @Data
        @Condition("N")
        ICondition iMsgSup1300Nao() ;
        
        
    }
    
    
    /**
     * 
     * HEADER-2 FOI INCLUIDOS PARA UTILIZAOES FUTURAS
     * 
     * @version 2.0
     * 
     */
    public interface Header2 extends IDataStruct {
        
        /**
         * 10 BHTL001A-CAMPO-LIVRE-1            PIC S9(15)V99 COMP-3.
         * @return instancia da classe local CampoLivre1
         */
        @Data
        CampoLivre1 campoLivre1() ;
        
        @Data(size=10)
        IString campoLivre2() ;
        
        @Data(size=1)
        IString campoLivre3() ;
        
        @Data(size=3)
        IString campoLivre4() ;
        
        @Data(size=50)
        IString campoLivre5() ;
        
        
        
        /**
         * 
         * 10 BHTL001A-CAMPO-LIVRE-1            PIC S9(15)V99 COMP-3.
         * 
         * @version 2.0
         * 
         */
        public interface CampoLivre1 extends IDataStruct {
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal iTrcdLst() ;
            
        }
    }
    
    
    /**
     * 
     * CAMPO APLICACAO E OPCAO MENU ORIGEM
     * 
     * @version 2.0
     * 
     */
    public interface Header3 extends IDataStruct {
        
        @Data(size=2)
        IString aAplOrig() ;
        
        @Data(size=3)
        IString cOpczMenuOrig() ;
        
        @Data(size=2)
        IInt nsJourBbnOut() ;
        
    }
    
    
    /**
     * 
     * CAMPOS DE APLICAOES PARA DESCODIFICAR AUTORIZACOES
     * 
     * @version 2.0
     * 
     */
    public interface AplicacoesAutoriz extends IDataStruct {
        
        @Data(size=2)
        IString aAplAutz() ;
        
    }
    
    public interface ErrosGraves extends IDataStruct {
        
        @Data(size=2)
        IString aAplErr() ;
        
        @Data(size=2)
        IString cTipoErroBbn() ;
        @Data
        @Condition("A1")
        ICondition abend() ;
        @Data
        @Condition("A2")
        ICondition abendDb2() ;
        @Data
        @Condition("A3")
        ICondition abendCics() ;
        @Data
        @Condition("AT")
        ICondition errosArq() ;
        @Data
        @Condition({ "FU", "AU", "  ", "FC", "FT", "BL" })
        ICondition errosValidos() ;
        @Data
        @Condition("FU")
        ICondition errosFuncao() ;
        @Data
        @Condition("FT")
        ICondition errosTele() ;
        @Data
        @Condition("AU")
        ICondition autorizacao() ;
        @Data
        @Condition("FC")
        ICondition fimConsulta() ;
        @Data
        @Condition("PF")
        ICondition pgmFuncao() ;
        @Data
        @Condition("NF")
        ICondition npgmFuncao() ;
        @Data
        @Condition("LP")
        ICondition limPaginas() ;
        @Data
        @Condition("BL")
        ICondition blif() ;
        @Data
        @Condition("  ")
        ICondition semErros() ;
        @Data
        @Condition({ "A1", "A2", "A3" })
        ICondition errosAbend() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cRtnoEvenSwal() ;
        
    }
    
    public interface CicsLog extends IDataStruct {
        
        @Data(size=2)
        IString cEibfn() ;
        
        @Data(size=6)
        IString cEibrcode() ;
        
        @Data(size=8)
        IString cEibrsrce() ;
        
    }
    
    public interface Db2Log extends IDataStruct {
        
        @Data(size=16)
        IString nmTabela() ;
        
        /**
         * @return instancia da classe local Sqlca
         */
        @Data
        Sqlca sqlca() ;
        
        
        public interface Sqlca extends IDataStruct {
            
            @Data(size=8)
            IString xSqlaid() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong qSqlabc() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            /**
             * @return instancia da classe local Sqlerrm
             */
            @Data
            Sqlerrm sqlerrm() ;
            
            @Data(size=8)
            IString sqlerrp() ;
            
            /**
             * @return instancia da classe local CSqlerrd
             */
            @Data(length=6)
            IArray<CSqlerrd> cSqlerrd() ;
            
            /**
             * @return instancia da classe local Sqlwarn
             */
            @Data
            Sqlwarn sqlwarn() ;
            
            @Data(size=8)
            IString xSqlext() ;
            
            
            public interface Sqlerrm extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP)
                IInt qSqlerrml() ;
                
                @Data(size=70)
                IString xSqlerrmc() ;
                
            }
            
            public interface CSqlerrd extends IDataStruct {
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlerrdItem() ;
                
            }
            
            public interface Sqlwarn extends IDataStruct {
                
                @Data(size=1)
                IString iSqlwarn0() ;
                
                @Data(size=1)
                IString iSqlwarn1() ;
                
                @Data(size=1)
                IString iSqlwarn2() ;
                
                @Data(size=1)
                IString iSqlwarn3() ;
                
                @Data(size=1)
                IString iSqlwarn4() ;
                
                @Data(size=1)
                IString iSqlwarn5() ;
                
                @Data(size=1)
                IString iSqlwarn6() ;
                
                @Data(size=1)
                IString iSqlwarn7() ;
                
            }
        }
    }
}
