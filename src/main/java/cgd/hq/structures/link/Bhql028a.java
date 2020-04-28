package cgd.hq.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
public interface Bhql028a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHQJ028A")
    IString cMhqj028a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO COM A ROTINA MHQJ028A
     * CONSULTA DOS DADOS DE UMA OPERACAO COE (THQ00028)
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data(length=9999)
        IArray<DadosOutput> dadosOutput() ;
        
        @Data(size=4)
        IInt qOccursOut() ;
        @Data
        @Condition("9999")
        ICondition qOccursMax() ;
        
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString swIDebug() ;
            @Data
            @Condition("S")
            ICondition swIDebugS() ;
            @Data
            @Condition("N")
            ICondition swIDebugN() ;
            
            
            @Data(size=1)
            IString swIModo() ;
            @Data
            @Condition("G")
            ICondition swIConsultaGeral() ;
            @Data
            @Condition("C")
            ICondition swIConsultaConta() ;
            
            
            @Data(size=1)
            IString swIMovimento() ;
            @Data
            @Condition("C")
            ICondition swIMovimentoC() ;
            @Data
            @Condition("D")
            ICondition swIMovimentoD() ;
            
            
            @Data(size=3)
            IString cPaisIsoCoeI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancRsplOpetI() ;
            
            @Data(size=24)
            IString nRefOpetBporI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsOpetI() ;
            
            @Data(size=3)
            IString cPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoCont() ;
            
            @Data(size=3)
            IString cMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoCoe() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancRsplOpet() ;
            
            @Data(size=24)
            IString nRefOpetBpor() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsOpet() ;
            
            @Data(size=1)
            IString iNtzaRegBpor() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cTipCtaDebBpor() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cTipCtaCreBpor() ;
            
            @Data(size=10)
            IString zOpet() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong mOpetBpor() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=3)
            IString cPaisIsoAlf3() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor() ;
            
            @Data(size=3)
            IString cPaisIsaCtaDeb() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContDeb() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContDeb() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContDeb() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContDeb() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContDeb() ;
            
            @Data(size=3)
            IString cMoeIsoSctaDeb() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepDeb() ;
            
            @Data(size=3)
            IString cPaisIsaCtaCre() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContCred() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContCred() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContCred() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContCred() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContCred() ;
            
            @Data(size=3)
            IString cMoeIsoSctaCre() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepCrdr() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nIpc() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=10)
            IString zCmczBpor() ;
            
            @Data(size=1)
            IString iInfDtlhOpet() ;
            
            @Data(size=1)
            IString cEstCoe() ;
            
            @Data(size=24)
            IString cRefOrigOpet() ;
            
            @Data(size=24)
            IString nRefAggzOpetBp() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("008")
            ICondition erroSelVhq02801() ;
            @Data
            @Condition("021")
            ICondition coeNaoExiste() ;
            @Data
            @Condition("022")
            ICondition erroAcessoVhq02801() ;
            
            
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
            @Data
            @Condition("DA")
            ICondition erDadosEntrada() ;
            
            
        }
    }
    
}
