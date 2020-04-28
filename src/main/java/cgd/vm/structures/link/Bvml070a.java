package cgd.vm.structures.link;

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
public interface Bvml070a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MVMJ070A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPYBOOK: BVML070A - AREA DE LIGACAO AO MODULO MVMJ070A
     * USER : ACCENTURE DACT610
     * DATA CRIACAO :16-08-2010  DATA ULTIMA ALTERACAO :
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local Input
         */
        @Data
        Input input() ;
        
        /**
         * @return instancia da classe local Output
         */
        @Data
        Output output() ;
        
        /**
         * @return instancia da classe local Erros
         */
        @Data
        Erros erros() ;
        
        
        public interface Input extends IDataStruct {
            
            /**
             * CONTA D.O. DO MOVIMENTO
             */
            @Data(size=3)
            IString cPaisIsoaCtaDo() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContDo() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContDo() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContDo() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContDo() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContDo() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepSctaDo() ;
            
            /**
             * IDENTIFICACAO CONTABILISTICA DO MOVIMENTO
             */
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            /**
             * DADOS DO JOURNAL
             * @return instancia da classe local NrElectronico
             */
            @Data
            NrElectronico nrElectronico() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn() ;
            
            /**
             * APLICACAO ORIGEM DO MOVIMENTO
             */
            @Data(size=2)
            IString aAplicacao() ;
            
            
            
            /**
             * 
             * DADOS DO JOURNAL
             * 
             * @version 2.0
             * 
             */
            public interface NrElectronico extends IDataStruct {
                
                @Data(size=10)
                IString zProcessamento() ;
                
                @Data(size=3)
                IString cMnemEgcOpex() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcOpex() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong nJourBbn() ;
                
            }
        }
        
        public interface Output extends IDataStruct {
            
            /**
             * CHAVE DA OPERACAO ORIGEM DO MOVIMENTO
             */
            @Data(size=21)
            IString nrOpeActf() ;
            
            /**
             * TIPO DE MOVIMENTO NA CONTA D.O.
             */
            @Data(size=9)
            IString dTipoMovDo() ;
            
            /**
             * CONTA DE ACTIVOS FINANCEIROS
             */
            @Data(size=3)
            IString cPaisIsaCtaAcf() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContActf() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContActf() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContActf() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContActf() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContActf() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsPrclContActf() ;
            
            /**
             * TIPO DE OPERACAO
             */
            @Data(size=30)
            IString dTipoOpeActf() ;
            
            @Data(size=13, signed=true, compression=COMP3)
            ILong nsEvenActf() ;
            
            @Data(size=30)
            IString dTipoEvenActf() ;
            
            /**
             * ISIN DO ACTIVO FINANCEIRO
             */
            @Data(size=12)
            IString cEspeActf() ;
            
            /**
             * MERCADO DE NEGOCIACAO
             */
            @Data(size=30)
            IString dLoclNgcz() ;
            
            /**
             * OUTROS DADOS DA OPERACAO
             */
            @Data(size=18, decimal=9, signed=true, compression=COMP3)
            IDecimal mPrcoActfObls() ;
            
            @Data(size=18, decimal=2, signed=true, compression=COMP3)
            IDecimal mOpeActf() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=10)
            IString zOperacao() ;
            
            @Data(size=10)
            IString zLiqzMontObls() ;
            
            @Data(size=1)
            IString iExisCotzActf() ;
            
        }
        
        public interface Erros extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("629")
            ICondition inputIncompleto() ;
            @Data
            @Condition("598")
            ICondition movInext() ;
            @Data
            @Condition("487")
            ICondition istzInext() ;
            @Data
            @Condition("698")
            ICondition faltaCodIsinKondor() ;
            @Data
            @Condition("811")
            ICondition dadosIncoerentes() ;
            
            
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
            @Condition("DA")
            ICondition errosDadosEntrada() ;
            @Data
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    
}
