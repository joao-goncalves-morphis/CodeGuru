package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0018 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaPedProt
     */
    @Data
    TabelaPedProt tabelaPedProt() ;
    
    /**
     * @return instancia da classe local TbPedProt
     */
    @Data
    @Mask
    TbPedProt tbPedProt() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * ASSOCIACAO DOS PEDIDOS A PROTOCOLOS
     * ----> FORMA COMO SAO TRATADOS NA TGH15 <-----
     * - PROTOCOLO 11 SIGNIFICA QUE OS PEDIDOS SAO REPETIDOS COMO
     * NOVAS CRIACOES PARA O DIA SEGUINTE.
     * 
     * @version 2.0
     * 
     */
    public interface TabelaPedProt extends IDataStruct {
        
        @Data(size=10, value="GH00003-11")
        IString filler001() ;
        
        @Data(size=10, value="GH00005-11")
        IString filler002() ;
        
    }
    public interface TbPedProt extends IDataMask {
        
        /**
         * @return instancia da classe local ItemPedProt
         */
        @Data(length=2)
        IArray<ItemPedProt> itemPedProt() ;
        
        
        public interface ItemPedProt extends IDataMask {
            
            
            @Data(size=7)
            IString tabCPedido() ;
            
            @Data(size=2, lpadding=1)
            IInt tabCProtocolo() ;
            
        }
    }
    
}
