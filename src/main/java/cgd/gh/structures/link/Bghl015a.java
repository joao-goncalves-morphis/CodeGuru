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
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghl015a extends IDataStruct {
    
    @Data(size=2)
    IString cAcesso() ;
    @Data
    @Condition({ "C", "LB", "LP", "I", "E", "CP", "CC", "CA" })
    ICondition acessoValido() ;
    @Data
    @Condition("C")
    ICondition consultar() ;
    @Data
    @Condition("LB")
    ICondition listarSubconta() ;
    @Data
    @Condition("LP")
    ICondition listarPedido() ;
    @Data
    @Condition("I ")
    ICondition inserir() ;
    @Data
    @Condition("E ")
    ICondition eliminar() ;
    @Data
    @Condition("CP")
    ICondition cnslPed() ;
    @Data
    @Condition("CC")
    ICondition cnslCntPed() ;
    @Data
    @Condition("CA")
    ICondition cnslPedAct() ;
    
    
    @Data(size=3)
    IInt cRetorno() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("233")
    ICondition dadosInvalidos() ;
    @Data
    @Condition("099")
    ICondition naoExisteInf() ;
    @Data
    @Condition("089")
    ICondition jaExiste() ;
    @Data
    @Condition("094")
    ICondition estadoPdInv() ;
    @Data
    @Condition("077")
    ICondition existePedido() ;
    @Data
    @Condition("216")
    ICondition db2() ;
    
    
    @Data(size=9, signed=true, compression=COMP3)
    ILong cSqlcode() ;
    
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
    
    @Data(size=2)
    IInt qItens() ;
    
    /**
     * @return instancia da classe local Tabela
     */
    @Data
    Tabela tabela() ;
    
    @Data(size=10, signed=true, compression=COMP3)
    ILong nClientePed() ;
    
    @Data(size=3, signed=true, compression=COMP3)
    IInt nsAbraCliPed() ;
    
    /**
     * Inner Classes
     */
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
        
        @Data(size=7)
        IString cPedInfOpps() ;
        
        @Data(size=10)
        IString zInicMov() ;
        
        @Data(size=10)
        IString zFimMov() ;
        
    }
    public interface Detalhe extends IDataStruct {
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong tsPedido() ;
        
        @Data(size=10)
        IString zPedido() ;
        
        @Data(size=1)
        IString cEstPedHist() ;
        
        @Data(size=1)
        IString cTipoRpte() ;
        
        @Data(size=20)
        IString nmFichOutpRtno() ;
        
        @Data(size=2)
        IString aAplDest() ;
        
        @Data(size=1)
        IString cFrmtInf() ;
        
        @Data(size=2)
        IString cCanlTrmzInf() ;
        
        @Data(size=15)
        IString cEndcFtpDest() ;
        
        @Data(size=10)
        IString zCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt qDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mParmPedHstMin() ;
        
        @Data(size=15)
        IString cParmPedHstMax() ;
        
        @Data(size=15)
        IString cParmPedHstMin() ;
        
        @Data(size=40)
        IString xMtvoDvlzPed() ;
        
        @Data(size=10)
        IString zEliminacao() ;
        
        @Data(size=8)
        IString cUsidCrix() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt qDdbtPed() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    public interface Tabela extends IDataStruct {
        
        /**
         * @return instancia da classe local Lista
         */
        @Data(length=11)
        IArray<Lista> lista() ;
        
        
        public interface Lista extends IDataStruct {
            
            
            /**
             * @return instancia da classe local Item
             */
            @Data
            Item item() ;
            
            
            public interface Item extends IDataStruct {
                
                @Data(size=49)
                IString itemArgumento() ;
                
                @Data(size=223)
                IString itemDetalhe() ;
                
            }
        }
    }
    
}
