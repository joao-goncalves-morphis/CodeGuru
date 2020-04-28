package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr4371 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fgh437Registo
     */
    @Data
    Fgh437Registo fgh437Registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPYBOOK : BGHR4371
     * LAYOUT DO FICHEIRO FGH437 COM A INFORMACAO DA PESQUISA A
     * EFETUAR PARA OBTENCAO DE SALDOS CONTABILISTICOS E DISPONIVEIS
     * DE CLIENTES
     * ACTUALIZACOES AO COPYBOOK:
     * DATA   /       AUTOR       / DESCRICAO :
     * 14-08-18 / ACCENTURE         / CRIACAO
     * 
     * @version 2.0
     * 
     */
    public interface Fgh437Registo extends IDataStruct {
        
        /**
         * 05 FGH437-N-CLIENTE               PIC S9(10) COMP-3.
         */
        @Data(size=10)
        ILong fgh437NCliente() ;
        
        @Data(size=3)
        IString fgh437CPaisIsoaCont() ;
        
        /**
         * 05 FGH437-C-BANC-CONT             PIC S9(04) COMP-3.
         * 05 FGH437-C-OE-EGC-CONT           PIC S9(04) COMP-3.
         * 05 FGH437-NS-RDCL-CONT            PIC S9(07) COMP-3.
         * 05 FGH437-V-CHKD-CONT             PIC S9(01) COMP-3.
         * 05 FGH437-C-TIPO-CONT             PIC S9(03) COMP-3.
         */
        @Data(size=4)
        IInt fgh437CBancCont() ;
        
        @Data(size=4)
        IInt fgh437COeEgcCont() ;
        
        @Data(size=7)
        IInt fgh437NsRdclCont() ;
        
        @Data(size=1)
        IInt fgh437VChkdCont() ;
        
        @Data(size=3)
        IInt fgh437CTipoCont() ;
        
        @Data(size=10)
        IString fgh437DataSaldo() ;
        
        @Data(size=1)
        IString fgh437IndicadorObito() ;
        
    }
    
}
