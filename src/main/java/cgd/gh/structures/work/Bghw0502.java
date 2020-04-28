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
public interface Bghw0502 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaPedidos
     */
    @Data
    TabelaPedidos tabelaPedidos() ;
    
    /**
     * @return instancia da classe local TabPedidos
     */
    @Data
    @Mask
    TabPedidos tabPedidos() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHW0502 - CARREGAMENTO INICIAL DA TABELA TGH00018_PEDINF
     * -------------> NOTA IMPORTANTE <----------------
     * SEMPRE QUE HOUVER ALTERACAO DESTE BOOK E NECESSARIO ALTERAR
     * O PROGRAM PGHQ600A
     * 
     * @version 2.0
     * 
     */
    public interface TabelaPedidos extends IDataStruct {
        
        @Data(size=7, value="GH00001")
        IString wsCPedInfOpps() ;
        
        @Data(size=50, value="FICHEIRO DOS MOVIMENTOS POR CONTA ENTRE DATAS     ")
        IString wsDPedInfOpps() ;
        
        @Data(size=1, value="T")
        IString wsCFrmtInf() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte() ;
        
        @Data(size=20, value="FGH500")
        IString wsNmFichOutpRtno() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf() ;
        
        @Data(size=7, value="GH00002")
        IString wsCPedInfOpps02001() ;
        
        @Data(size=50, value="MOVIMENTOS ENTRE DATAS - CONSULTA POR TRANSACCAO  ")
        IString wsDPedInfOpps02001() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02001() ;
        
        @Data(size=1, value="T")
        IString wsCTipoRpte02001() ;
        
        @Data(size=20, value="GHI1  ")
        IString wsNmFichOutpRtno02001() ;
        
        @Data(size=2, value="20")
        IInt wsQDiaDpnzInf02001() ;
        
        @Data(size=7, value="GH00011")
        IString wsCPedInfOpps02002() ;
        
        @Data(size=50, value="FICH MOVIMENTOS POR CONTA ENTRE DATAS EM FMT EXCEL")
        IString wsDPedInfOpps02002() ;
        
        @Data(size=1, value="X")
        IString wsCFrmtInf02002() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02002() ;
        
        @Data(size=20, value="FGH501")
        IString wsNmFichOutpRtno02002() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02002() ;
        
        @Data(size=7, value="GH00012")
        IString wsCPedInfOpps02003() ;
        
        @Data(size=50, value="FICH MOV POR CONTA ENTRE DATAS - OUTRAS APLICACOES")
        IString wsDPedInfOpps02003() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02003() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02003() ;
        
        @Data(size=20, value="FGH502")
        IString wsNmFichOutpRtno02003() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02003() ;
        
        @Data(size=7, value="GH00094")
        IString wsCPedInfOpps02004() ;
        
        @Data(size=50, value="FICHEIRO MOVIMENTOS PARA 2AS VIAS EXTRACTO        ")
        IString wsDPedInfOpps02004() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02004() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02004() ;
        
        @Data(size=20, value="FGH507")
        IString wsNmFichOutpRtno02004() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02004() ;
        
        @Data(size=7, value="GH00095")
        IString wsCPedInfOpps02005() ;
        
        @Data(size=50, value="FICHEIRO DOS MOVIMENTOS DAS CONTAS DA DCR        ")
        IString wsDPedInfOpps02005() ;
        
        @Data(size=1, value="T")
        IString wsCFrmtInf02005() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02005() ;
        
        @Data(size=20, value="FGH505")
        IString wsNmFichOutpRtno02005() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02005() ;
        
        @Data(size=7, value="GH00096")
        IString wsCPedInfOpps02006() ;
        
        @Data(size=50, value="FICHEIRO MENSAL CONTAGEM MOVIMENTOS DBI MES ANTER ")
        IString wsDPedInfOpps02006() ;
        
        @Data(size=1, value="T")
        IString wsCFrmtInf02006() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02006() ;
        
        @Data(size=20, value="FGH503")
        IString wsNmFichOutpRtno02006() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02006() ;
        
        @Data(size=7, value="GH00097")
        IString wsCPedInfOpps02007() ;
        
        @Data(size=50, value="MOVIMENTO ENTRE DATAS COM JUSTIF DE JURO CALCULADO")
        IString wsDPedInfOpps02007() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02007() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02007() ;
        
        @Data(size=20, value="FGH506")
        IString wsNmFichOutpRtno02007() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02007() ;
        
        @Data(size=7, value="GH00098")
        IString wsCPedInfOpps02008() ;
        
        @Data(size=50, value="FICHEIRO MENSAL DE PAGAMENTOS DA TSU              ")
        IString wsDPedInfOpps02008() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02008() ;
        
        @Data(size=1, value="F")
        IString wsCTipoRpte02008() ;
        
        @Data(size=20, value="FGH507")
        IString wsNmFichOutpRtno02008() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02008() ;
        
        @Data(size=7, value="GH00101")
        IString wsCPedInfOpps02009() ;
        
        @Data(size=50, value="MAPA MOVIMENTOS POR CONTA, ENTRE DATAS            ")
        IString wsDPedInfOpps02009() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02009() ;
        
        @Data(size=1, value="M")
        IString wsCTipoRpte02009() ;
        
        @Data(size=20, value="MGH870")
        IString wsNmFichOutpRtno02009() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02009() ;
        
        @Data(size=7, value="GH00102")
        IString wsCPedInfOpps02010() ;
        
        @Data(size=50, value="MAPA MOVIMENTOS POR CONTA ENTRE DATAS COM ORIGEM  ")
        IString wsDPedInfOpps02010() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02010() ;
        
        @Data(size=1, value="M")
        IString wsCTipoRpte02010() ;
        
        @Data(size=20, value="MGH871")
        IString wsNmFichOutpRtno02010() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02010() ;
        
        @Data(size=7, value="GH00103")
        IString wsCPedInfOpps02011() ;
        
        @Data(size=50, value="MAPA MOVIMENTOS POR CONTA ENTRE DATAS-SALDOS COMPL")
        IString wsDPedInfOpps02011() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02011() ;
        
        @Data(size=1, value="M")
        IString wsCTipoRpte02011() ;
        
        @Data(size=20, value="MGH872")
        IString wsNmFichOutpRtno02011() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02011() ;
        
        @Data(size=7, value="GH00104")
        IString wsCPedInfOpps02012() ;
        
        @Data(size=50, value="MOVIMENTOS POR CONTA, ENTRE DATAS, COM DADOS POSIC")
        IString wsDPedInfOpps02012() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02012() ;
        
        @Data(size=1, value="M")
        IString wsCTipoRpte02012() ;
        
        @Data(size=20, value="MGH873")
        IString wsNmFichOutpRtno02012() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02012() ;
        
        @Data(size=7, value="GH00105")
        IString wsCPedInfOpps02013() ;
        
        @Data(size=50, value="MAPA DE MOVIMENTOS POR MONTANTES                  ")
        IString wsDPedInfOpps02013() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02013() ;
        
        @Data(size=1, value="M")
        IString wsCTipoRpte02013() ;
        
        @Data(size=20, value="MGH860")
        IString wsNmFichOutpRtno02013() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02013() ;
        
        @Data(size=7, value="GH00106")
        IString wsCPedInfOpps02014() ;
        
        @Data(size=50, value="MAPA DE MOVIMENTOS POR UTILIZADOR                 ")
        IString wsDPedInfOpps02014() ;
        
        @Data(size=1, value="N")
        IString wsCFrmtInf02014() ;
        
        @Data(size=1, value="M")
        IString wsCTipoRpte02014() ;
        
        @Data(size=20, value="MGH874")
        IString wsNmFichOutpRtno02014() ;
        
        @Data(size=2, value="99")
        IInt wsQDiaDpnzInf02014() ;
        
    }
    public interface TabPedidos extends IDataMask {
        
        /**
         * @return instancia da classe local ElemPed
         */
        @Data(length=15)
        IArray<ElemPed> elemPed() ;
        
        
        public interface ElemPed extends IDataMask {
            
            
            @Data(size=7)
            IString tabCPedInfOpps() ;
            
            @Data(size=50)
            IString tabDPedInfOpps() ;
            
            @Data(size=1)
            IString tabCFrmtInf() ;
            
            @Data(size=1)
            IString tabCTipoRpte() ;
            
            @Data(size=20)
            IString tabNmFichOutpRtno() ;
            
            @Data(size=2)
            IInt tabQDiaDpnzInf() ;
            
        }
    }
    
}
