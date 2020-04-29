package cgd.gh.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghk0001 extends IDataStruct {
    
    /**
     * @return instancia da classe local Erros
     */
    @Data
    Erros erros() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHK0001   CONSTANTES COM CODIGOS DE ERRO 'GH'
     * 
     * @version 2.0
     * 
     */
    public interface Erros extends IDataStruct {
        
        /**
         * *** GH001 = IDENT INV. EXISTE REL CLI-CTA
         */
        @Data(size=3, signed=true, value="1")
        IInt identInvCliCtaRel() ;
        
        /**
         * *** GH002 = IDENT INV. N EXIST REL CLI-CTA
         */
        @Data(size=3, signed=true, value="2")
        IInt identInvNExistRel() ;
        
        /**
         * *** GH003 = INTERV OPERERACAO CLIENTE CGD
         */
        @Data(size=3, signed=true, value="3")
        IInt itvtOpexCliCgd() ;
        
        /**
         * *** GH004 = INTERV OPER S/ DOC ID OBRIGAT
         */
        @Data(size=3, signed=true, value="4")
        IInt itvtOpexSdocIdObg() ;
        
        /**
         * *** GH005 = N EXIST DETALHE INTERV OPERERACAO
         */
        @Data(size=3, signed=true, value="5")
        IInt nExistDthlItvtOpe() ;
        
        /**
         * *** GH006 = CLIENTE C/ DOC ID COMUM A OUTROS CLIENTES
         */
        @Data(size=3, signed=true, value="6")
        IInt cliDocIdComum() ;
        
        /**
         * *** GH007 = DOC ID APRESENTADO ATRIBUIDO A OUTRO CLIENTE CGD
         */
        @Data(size=3, signed=true, value="7")
        IInt docAptdOutroCli() ;
        
        /**
         * *** GH008 = NUMERO DOC ID APRESENTADO DIFERENTE DO DOC CARREGADO
         */
        @Data(size=3, signed=true, value="8")
        IInt nDocAptdDiferente() ;
        
        /**
         * *** GH009 = INSERIR DOC ID APRESENTADO AO CLIENTE CGD
         */
        @Data(size=3, signed=true, value="9")
        IInt insDocAptdCli() ;
        
        /**
         * *** GH010 = NAO CLIENTE CGD INVALIDO
         */
        @Data(size=3, signed=true, value="10")
        IInt naoCliCgdInvalido() ;
        
        /**
         * *** GH011 = NAO CLIENTE CGD REPRESENTANTE INVALIDO
         */
        @Data(size=3, signed=true, value="11")
        IInt nCliCgdRprtInval() ;
        
        /**
         * *** GH012 = NAO CLIENTE COM DADOS INCOMPLETOS. EXECUTAR PI6701
         */
        @Data(size=3, signed=true, value="12")
        IInt ncliDadosIncomp() ;
        
        /**
         * *** GH013 = NUMERO DOC ID APRESENTADO DIFERENTE DO DOC CARREGADO
         */
        @Data(size=3, signed=true, value="13")
        IInt nDocAptdRprtDif() ;
        
        /**
         * *** GH014 = DOC ID APRESENTADO RPRT ATRIBUIDO A OUTRO CLIENTE CGD
         */
        @Data(size=3, signed=true, value="14")
        IInt docAptdRptOutCli() ;
        
        /**
         * *** GH015 = NUMERO DOC APRESENTADO NAO CLIENTE DIFERE DOC BD
         */
        @Data(size=3, signed=true, value="15")
        IInt nDocAptdNcliDif() ;
        
        /**
         * *** GH016 = NUMERO DOC APTD P/ NAO CLI REPRESENTANTE DIFERE DOCBD
         */
        @Data(size=3, signed=true, value="16")
        IInt nDocAptNcliRptD() ;
        
        /**
         * *** GH017 = DOC ID APTD P/ CLI N CGD ATRIBUIDO A OUTRO CLI N CGD
         */
        @Data(size=3, signed=true, value="17")
        IInt docAptdOutNcli() ;
        
        /**
         * *** GH018 = DOC ID APTD P/ CLI N CGD ATRIBUIDO A OUTRO CLI N CGD
         */
        @Data(size=3, signed=true, value="18")
        IInt docAptdRptOtNcli() ;
        
        /**
         * *** GH019 = NAO CLIENTE REPRESENTANTE COM DADOS INCOMPLETOS
         */
        @Data(size=3, signed=true, value="19")
        IInt nCliRprtDadosInc() ;
        
        /**
         * *** GH020 = CLI RPT S/ DOC ID VALIDO
         */
        @Data(size=3, signed=true, value="20")
        IInt cliRptSDocValido() ;
        
        /**
         * *** GH021 = INS DOC CLI CGD NA CLIJ49
         */
        @Data(size=3, signed=true, value="21")
        IInt insDocCliEmpresa() ;
        
        /**
         * *** GH022 = NUMERO DOC DO CLIENTE EMPRESA DIF BASE DADOS
         */
        @Data(size=3, signed=true, value="22")
        IInt nDocEmpCliDif() ;
        
        /**
         * *** GH097 = NAO EXISTE MOV PARA CRITERIO
         */
        @Data(size=3, signed=true, value="97")
        IInt naoExistMovCrit() ;
        
        /**
         * *** GH233 = DADOS DE INPUT INVALIDOS
         */
        @Data(size=3, signed=true, value="233")
        IInt inputInvalido() ;
        
    }
    
}
