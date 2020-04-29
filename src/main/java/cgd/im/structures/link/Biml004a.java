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
public interface Biml004a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MIMJ004A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * ROTINA DE CONSULTA AH TABELA TIM00004
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
         * @return instancia da classe local DadosInOut
         */
        @Data
        DadosInOut dadosInOut() ;
        
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
            IString cModoAcesso() ;
            @Data
            @Condition("C")
            ICondition cTim00004() ;
            @Data
            @Condition("I")
            ICondition iTim00004() ;
            @Data
            @Condition("U")
            ICondition uTim00004() ;
            
            
            @Data(size=19)
            IString nCartCluIn() ;
            
            @Data(size=10)
            IString zVldeCart() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsRemzCartClu() ;
            
            @Data(size=10)
            IString zAnlzCart() ;
            
        }
        
        public interface DadosInOut extends IDataStruct {
            
            @Data(size=19)
            IString nCartCluOut() ;
            
            @Data(size=10)
            IString zVldeCartOut() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsRemzCartCluOut() ;
            
            @Data(size=10)
            IString zAnlzCartOut() ;
            
            @Data(size=3)
            IString cPaisIsoaPrct() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancPrct() ;
            
            @Data(size=3)
            IString cPaisIsoaCcar() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancCcar() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCcar() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclCcar() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdCcar() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoCcar() ;
            
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
            IInt nsDepScta() ;
            
            @Data(size=3)
            IString cTitHonoCart() ;
            
            @Data(size=32)
            IString nmTitrCartCetr() ;
            
            @Data(size=8)
            IString cClasCliClu() ;
            
            @Data(size=1)
            IString cEstCartCetr() ;
            
            @Data(size=2)
            IString cTipoCartCetr() ;
            
            @Data(size=1)
            IString iCartDbcr() ;
            
            @Data(size=4)
            IString cRedeCartClu() ;
            
            @Data(size=1)
            IString cModPagCarCetr() ;
            
            @Data(size=1)
            IString cBlqoCartCetr() ;
            
            @Data(size=1)
            IString cMtvBlqCarCetr() ;
            
            @Data(size=10)
            IString zBlqoCart() ;
            
            @Data(size=10)
            IString zAnlzBlqoCart() ;
            
            @Data(size=10)
            IString zPrctPedCart() ;
            
            @Data(size=10)
            IString zRnvzCart() ;
            
            @Data(size=8)
            IString hBlqoCart() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCartLim() ;
            
            @Data(size=1)
            IString cDtbzCartClu() ;
            
            @Data(size=1)
            IString cDtbzPinCarClu() ;
            
            @Data(size=2)
            IString cMtvoAnzCarClu() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mAnuiCartUlt() ;
            
            @Data(size=10)
            IString zAnuiCartUlt() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mAnuiCartProx() ;
            
            @Data(size=10)
            IString zAnuiCartProx() ;
            
            @Data(size=10)
            IString zAtveCartUlt() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt qTntvPinCart() ;
            
            @Data(size=26)
            IString tsTntvPinUlt() ;
            
            @Data(size=1)
            IString iPedRemzPin() ;
            
            @Data(size=19)
            IString nCartCluAnt() ;
            
            @Data(size=10)
            IString zCrizCart() ;
            
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
            @Data
            @Condition("026")
            ICondition regInexistente() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=43)
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
