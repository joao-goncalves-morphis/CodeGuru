package cgd.dr.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bdrl402a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * B D R L 4 0 2 A
     * AREA DE LIGACAO COM A ROTINA DE OBTENCAO DE INFORMACAO DE
     * HISTORICO DE PASSIVAS (GHP) - MDRJ402A (SEL "TDR00100")
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosWorking
         */
        @Data
        DadosWorking dadosWorking() ;
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosWorking extends IDataStruct {
            
            @Data(size=8)
            IString nmModulo() ;
            
        }
        
        public interface DadosInput extends IDataStruct {
            
            /**
             * @return instancia da classe local AccessKey
             */
            @Data
            AccessKey accessKey() ;
            
            
            public interface AccessKey extends IDataStruct {
                
                @Data(size=10)
                IString akZProcessamento() ;
                
                @Data(size=8)
                IString akCUserid() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong akNJourBbn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt akNsJourBbn() ;
                
                @Data(size=3)
                IString akCPaisIsoaOeRpl() ;
                
                @Data(size=3)
                IString akCMnemEgcRspl() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt akCOeEgcRspl() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local WOutputFields
             */
            @Data
            WOutputFields wOutputFields() ;
            
            /**
             * @return instancia da classe local WOutputError
             */
            @Data
            WOutputError wOutputError() ;
            
            
            public interface WOutputFields extends IDataStruct {
                
                @Data(size=2)
                IString ofAAplicacao() ;
                
                @Data(size=5)
                IString ofCOpePcnp() ;
                
                @Data(size=15)
                IString ofXChavOpePcnp() ;
                
                @Data(size=21)
                IString ofXIdSpteOpePcnp() ;
                
                @Data(size=21)
                IString ofXRefContOrmMov() ;
                
                @Data(size=4)
                IString ofCTermAts() ;
                
                @Data(size=18)
                IString ofCDptvAts() ;
                
                @Data(size=40)
                IString ofNmLocalidade() ;
                
                @Data(size=15)
                IString ofCPostal() ;
                
                @Data(size=8)
                IString ofHTrnzLocl() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal ofMMovimento() ;
                
                @Data(size=3)
                IString ofCMoedIsoMov() ;
                
                @Data(size=21)
                IString ofXRefContDstMov() ;
                
                @Data(size=36)
                IString ofNmOrdnTrfc() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt ofCEntCbrSrvSibs() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong ofCRefPagSrvSibs() ;
                
                @Data(size=30)
                IString ofDMsgSesBanSibs() ;
                
                @Data(size=2)
                IString ofCAplPddSibs() ;
                
                @Data(size=8, signed=true, compression=COMP3)
                ILong ofNRegLogSibs() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt ofNLogSibs() ;
                
                @Data(size=1)
                IString ofCTipSteOpePcnp() ;
                
                @Data(size=100)
                IString ofXInfAdiMov() ;
                
                @Data(size=4)
                IString ofCTrnzCriz() ;
                
                @Data(size=8)
                IString ofCUsidRsplCriz() ;
                
                @Data(size=8)
                IString ofNmPrgInsz() ;
                
                @Data(size=26)
                IString ofTsCriacao() ;
                
                @Data(size=4)
                IString ofCTrnzActzUlt() ;
                
                @Data(size=8)
                IString ofCUsidActzUlt() ;
                
                @Data(size=8)
                IString ofNmPrgActzUlt() ;
                
                @Data(size=26)
                IString ofTsActzUlt() ;
                
            }
            
            public interface WOutputError extends IDataStruct {
                
                @Data(size=2)
                IString oeAAplErr() ;
                
                @Data(size=18)
                IString oeNmTabela() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt oeCSqlcode() ;
                
                @Data(size=8)
                IString oeCSqlwarn() ;
                
                @Data(size=2)
                IString oeCTipoErroBbn() ;
                @Data
                @Condition(" ")
                ICondition semErros() ;
                @Data
                @Condition("A2")
                ICondition abendDb2() ;
                @Data
                @Condition("FU")
                ICondition errosFuncao() ;
                
                
                @Data(size=4)
                IString oeCLclzErroPrg() ;
                
                @Data(size=100)
                IString oeXInfCplrErro() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt oeCRtnoEvenSwal() ;
                @Data
                @Condition("012")
                ICondition dadosInvalidos() ;
                @Data
                @Condition("014")
                ICondition naoHaRegistos() ;
                @Data
                @Condition("022")
                ICondition tdr100Indisponivel() ;
                
                
            }
        }
    }
    
}
