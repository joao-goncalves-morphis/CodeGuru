package cgd.im.structures.link;

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
public interface Biml002a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MIMJ002A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * ROTINA DE CONSULTA TIM0002
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
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
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString iDebug() ;
            @Data
            @Condition("S")
            ICondition iDebugOn() ;
            @Data
            @Condition("N")
            ICondition iDebugOff() ;
            
            
            @Data(size=1)
            IString iModoAcesso() ;
            @Data
            @Condition("A")
            ICondition iTim0002() ;
            @Data
            @Condition("A")
            ICondition iModoAcessoValid() ;
            
            
            @Data(size=3)
            IString cPaisIsaCtaMovIn() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContMovIn() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContMovIn() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContMovIn() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContMovIn() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContMovIn() ;
            
            @Data(size=3)
            IString cMoeIsoSctaMovIn() ;
            
            @Data(size=10)
            IString zValorIn() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbnIn() ;
            
            @Data(size=4)
            IString cEvenOpelIn() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimentoIn() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaPrct() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancPrct() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsFichBbn() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsLoteFich() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRegLote() ;
            
            @Data(size=3)
            IString cPaisIsaCtaMov() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContMov() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContMov() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContMov() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContMov() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContMov() ;
            
            @Data(size=3)
            IString cMoeIsoSctaMov() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepSctaMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=1)
            IString iDbcrMov() ;
            
            @Data(size=35)
            IString nmTitrCartBgrx() ;
            
            @Data(size=19)
            IString nCartClu() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsRemzCartClu() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt zpExpzCart() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mComsCbrd() ;
            
            @Data(size=8)
            IString cTarfComsCetr() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt cRgaoOpeCetr() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt cTipoOpeCetr() ;
            
            @Data(size=1)
            IString cCatgOpeCetr() ;
            
            @Data(size=10)
            IString zOpeOril() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=10)
            IString zFchoPerCblo() ;
            
            @Data(size=4)
            IString cMnemBancAqrt() ;
            
            @Data(size=8)
            IString cTermOpeCetr() ;
            
            @Data(size=1)
            IString cTipoTermCetr() ;
            
            @Data(size=25)
            IString xLoclOpe() ;
            
            @Data(size=5)
            IString cPostLoclOpe() ;
            
            @Data(size=3)
            IString cPaisIsoaOpe() ;
            
            @Data(size=13)
            IString nmCiddCpra() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCompra() ;
            
            @Data(size=3)
            IString cMoedIsoCpra() ;
            
            @Data(size=12, signed=true, compression=COMP3)
            ILong tCvrsCpraEuro() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fExptTaxaCvrs() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMkup() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt hOperacao() ;
            
            @Data(size=6)
            IString nAtrzOpeCetr() ;
            
            @Data(size=23)
            IString nRefAqrtCetr() ;
            
            @Data(size=12)
            IString nRefIntoCetr() ;
            
            @Data(size=30)
            IString dErroLret() ;
            
            @Data(size=10)
            IString zRejeicao() ;
            
            @Data(size=1)
            IString iEstMov() ;
            
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
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=8)
            IString cUsidRsplCriz() ;
            
            @Data(size=26)
            IString tsCarregamento() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("011")
            ICondition inputInvalido() ;
            @Data
            @Condition("019")
            ICondition erroDb2() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
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
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
    }
    
}
