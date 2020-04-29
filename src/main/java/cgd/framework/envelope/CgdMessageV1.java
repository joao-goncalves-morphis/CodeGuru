package cgd.framework.envelope;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
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
public interface CgdMessageV1 extends IDataStruct {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe local Mensagem
     */
    Mensagem mensagem() ;
    
    
    
    
    /**
     * 
     * 
     * @version 2.0
     * 
     */
    @Data
    public interface Mensagem extends IDataStruct {
        
        @Data(size=221)
        IString header() ;
        
        /**
         * @return instancia da classe local HeaderR
         */
        @Data
        @Mask
        HeaderR headerR() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt qCterCmptAlig() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt qCampEstTrnz() ;
        
        
        public interface HeaderR extends IDataMask {
            
            @Data(size=4)
            IString cTransaccao() ;
            
            /**
             * @return instancia da classe local Transaccao
             */
            @Data
            Transaccao transaccao() ;
            
            /**
             * @return instancia da classe local NrElectronico
             */
            @Data
            NrElectronico nrElectronico() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsSessao() ;
            
            @Data(size=1)
            IString iExiAtzJourBbn() ;
            @Data
            @Condition("0")
            ICondition semAut() ;
            @Data
            @Condition("1")
            ICondition comAut() ;
            @Data
            @Condition("3")
            ICondition comAutLoc() ;
            
            
            @Data(size=1)
            IString iPedDad() ;
            @Data
            @Condition("S")
            ICondition pedidoSim() ;
            @Data
            @Condition("N")
            ICondition pedidoNao() ;
            
            
            @Data(size=1)
            IString iTrnzSimz() ;
            @Data
            @Condition("S")
            ICondition simzSim() ;
            @Data
            @Condition("N")
            ICondition simzNao() ;
            
            
            /**
             * @return instancia da classe local DatasProcesso
             */
            @Data
            DatasProcesso datasProcesso() ;
            
            @Data(size=4)
            IString cTerminal() ;
            
            @Data(size=8)
            IString cUsidVrtl() ;
            
            /**
             * @return instancia da classe local Seguranca
             */
            @Data
            Seguranca seguranca() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnln() ;
            @Data
            @Condition("1")
            ICondition trnOnLine() ;
            @Data
            @Condition("2")
            ICondition trnOffLine() ;
            
            
            @Data(size=1)
            IString iEstorno() ;
            @Data
            @Condition("S")
            ICondition anulDiaSim() ;
            @Data
            @Condition("N")
            ICondition anulDiaNao() ;
            
            
            /**
             * @return instancia da classe local NrAnulacao
             */
            @Data
            NrAnulacao nrAnulacao() ;
            
            @Data(size=3)
            IString cMnemEgcOrig() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOri() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOrig() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=26)
            IString tsLocal() ;
            
            @Data(size=26)
            IString tsCentral() ;
            
            @Data(size=1)
            IString iTrnzCblo() ;
            @Data
            @Condition("S")
            ICondition iTrnzCbloSim() ;
            @Data
            @Condition("N")
            ICondition iTrnzCbloNao() ;
            
            
            
            public interface Transaccao extends IDataMask {
                
                @Data(size=2)
                IString aAplicacao() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=1)
                IString iAccao() ;
                @Data
                @Condition("V")
                ICondition vizualizacao() ;
                @Data
                @Condition("C")
                ICondition criacao() ;
                @Data
                @Condition("M")
                ICondition modificacao() ;
                @Data
                @Condition("A")
                ICondition anulacao() ;
                @Data
                @Condition("N")
                ICondition anulNotrunc() ;
                
                
                @Data(size=4)
                IString cTipoCanlAces() ;
                
            }
            
            public interface NrElectronico extends IDataMask {
                
                @Data(size=10)
                IString zProcessamento() ;
                
                @Data(size=3)
                IString cMnemEgcOpex() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpx() ;
                
                @Data(size=4)
                IInt cOeEgcOpex() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=9)
                ILong nJourBbn() ;
                
            }
            
            public interface DatasProcesso extends IDataMask {
                
                @Data(size=10)
                IString zPrctJourBbn() ;
                
                @Data(size=10)
                IString zCtlzJourBbn() ;
                
            }
            
            public interface Seguranca extends IDataMask {
                
                @Data(size=3)
                IString cPaisIsoAlfn() ;
                
                @Data(size=3)
                IString cMnemEgcUtl() ;
                
                @Data(size=3)
                IString cIdioIso() ;
                
                @Data(size=8)
                IString cPerfUtlBbn() ;
                
                @Data(size=1)
                IString iAcesContStff() ;
                @Data
                @Condition("S")
                ICondition iAcesContStffS() ;
                @Data
                @Condition("N")
                ICondition iAcesContStffN() ;
                
                
                @Data(size=8)
                IString cUsidAlcl() ;
                
                @Data(size=1)
                IString ctNvlAtzBbnLcl() ;
                
                @Data(size=8)
                IString cUsidAcrl() ;
                
                @Data(size=1)
                IString ctNvlAtzBbnCrl() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nEmpregado() ;
                
                @Data(size=1)
                IString iUltGerxCli() ;
                
                @Data(size=1)
                IString iUltGerxCont() ;
                
            }
            
            public interface NrAnulacao extends IDataMask {
                
                @Data(size=3)
                IString cMnemEgcEstn() ;
                
                @Data(size=3)
                IString cPaisIsoaOeEsn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcEstn() ;
                
                @Data(size=8)
                IString cUsidEstn() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong nJourBbnTrnEsn() ;
                
            }
        }
    }
}
