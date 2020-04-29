package cgd.gh.structures.link;

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
public interface Bghl122a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MGHS122A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local CriterioConsulta
         */
        @Data
        CriterioConsulta criterioConsulta() ;
        
        /**
         * @return instancia da classe local Argumento
         */
        @Data
        Argumento argumento() ;
        
        /**
         * @return instancia da classe local Detalhe
         */
        @Data
        Detalhe detalhe() ;
        
        /**
         * @return instancia da classe local Erros
         */
        @Data
        Erros erros() ;
        
        
        public interface CriterioConsulta extends IDataStruct {
            
            @Data(size=1)
            IString crtlMovHst() ;
            @Data
            @Condition("D")
            ICondition movHstS() ;
            @Data
            @Condition("N")
            ICondition movHstN() ;
            
            
        }
        
        public interface Argumento extends IDataStruct {
            
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
            
            @Data(size=26)
            IString tsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
        }
        
        public interface Detalhe extends IDataStruct {
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=3)
            IString cOpczMenu() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=4)
            IString cTerminal() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cOperador() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cOpexAtrx() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cProdSgop() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cCndzMovzCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cGrupCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cTipoIttz() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambio() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoRetd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoVcob() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgLim() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgUtid() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboNgcdUtid() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbnDtlh() ;
            
            @Data(size=8)
            IString nmArqvOrig() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
        }
        
        public interface Erros extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("233")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("097")
            ICondition naoExiste() ;
            @Data
            @Condition("216")
            ICondition db2() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
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
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
