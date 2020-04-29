package cgd.hj.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhjk0011 extends IDataStruct {
    
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
     * BHJK0011 - COPY TEMPORARIO
     * DE CONSTANTES DE ERROS
     * 
     * @version 2.0
     * 
     */
    public interface Erros extends IDataStruct {
        
        @Data(size=3, signed=true, value="711")
        IInt bhjk0001TipoMoradJaExiste() ;
        
        @Data(size=3, signed=true, value="712")
        IInt bhjk0001NomeEspacosAMais() ;
        
        @Data(size=3, signed=true, value="713")
        IInt bhjk0001DocEmVariosClis() ;
        
        @Data(size=3, signed=true, value="714")
        IInt bhjk0001ZIniCaeInf16const() ;
        
        @Data(size=3, signed=true, value="715")
        IInt bhjk0001NExstLimsPCli() ;
        
        @Data(size=3, signed=true, value="716")
        IInt bhjk0001NExstLimsPGrupo() ;
        
        @Data(size=3, signed=true, value="717")
        IInt bhjk0001NExstOutrosClis() ;
        
        @Data(size=3, signed=true, value="718")
        IInt bhjk0001ZIniCaeSupNconst() ;
        
        @Data(size=3, signed=true, value="719")
        IInt bhjk0001ActPrincNPodElmn() ;
        
        /**
         * ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         */
        @Data(size=3, signed=true, value="720")
        IInt bhjk0001ClientesIguais() ;
        
        @Data(size=3, signed=true, value="721")
        IInt bhjk0001NomeDiferente() ;
        
        @Data(size=3, signed=true, value="722")
        IInt bhjk0001TipoClienteInv() ;
        
        @Data(size=3, signed=true, value="723")
        IInt bhjk0001ZNascDiferente() ;
        
        @Data(size=3, signed=true, value="724")
        IInt bhjk0001RegJurDiferente() ;
        
        @Data(size=3, signed=true, value="725")
        IInt bhjk0001FiscDiferente() ;
        
        @Data(size=3, signed=true, value="726")
        IInt bhjk0001BiEquivDiferente() ;
        
        @Data(size=3, signed=true, value="727")
        IInt bhjk0001NifEquivDiferente() ;
        
        @Data(size=3, signed=true, value="728")
        IInt bhjk0001Mais8Agregados() ;
        
        @Data(size=3, signed=true, value="729")
        IInt bhjk0001ConfDiferente() ;
        
        @Data(size=3, signed=true, value="730")
        IInt bhjk0001AePrinDiferente() ;
        
        @Data(size=3, signed=true, value="731")
        IInt bhjk0001AgregadorInvalido() ;
        
        @Data(size=3, signed=true, value="732")
        IInt bhjk0001AgregadoInvalido() ;
        
        @Data(size=3, signed=true, value="733")
        IInt bhjk0001AgregadoComPemg() ;
        
        @Data(size=3, signed=true, value="734")
        IInt bhjk0001AgregadoComHabherd() ;
        
        @Data(size=3, signed=true, value="735")
        IInt bhjk0001AgregadoComRelcli() ;
        
        @Data(size=3, signed=true, value="736")
        IInt bhjk0001AgregadoComCanais() ;
        
        @Data(size=3, signed=true, value="737")
        IInt bhjk0001AgregadoComDimemp() ;
        
        @Data(size=3, signed=true, value="738")
        IInt bhjk0001AgregadoComExt() ;
        
        @Data(size=3, signed=true, value="739")
        IInt bhjk0001AgregadoNomeExt() ;
        
        @Data(size=3, signed=true, value="740")
        IInt bhjk0001AgregadoMordExt() ;
        
        /**
         * FIM DOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         */
        @Data(size=3, signed=true, value="741")
        IInt bhjk0001PactoNaoAlteravel() ;
        
        @Data(size=3, signed=true, value="742")
        IInt bhjk0001PactoNaoEliminado() ;
        
        @Data(size=3, signed=true, value="743")
        IInt bhjk0001MsgErrCxDirecta15() ;
        
        @Data(size=3, signed=true, value="744")
        IInt bhjk0001MsgErrCxDirecta01() ;
        
        @Data(size=3, signed=true, value="745")
        IInt bhjk0001MsgErrCxDirecta02() ;
        
        @Data(size=3, signed=true, value="746")
        IInt bhjk0001MsgErrCxDirecta03() ;
        
        @Data(size=3, signed=true, value="747")
        IInt bhjk0001MsgErrCxDirecta04() ;
        
        @Data(size=3, signed=true, value="748")
        IInt bhjk0001MsgErrCxDirecta09() ;
        
        @Data(size=3, signed=true, value="749")
        IInt bhjk0001MsgErrPercSup100() ;
        
        @Data(size=3, signed=true, value="750")
        IInt bhjk0001MsgErrVNomInval() ;
        
        @Data(size=3, signed=true, value="751")
        IInt bhjk0001MsgErrSomaAccSup() ;
        
        @Data(size=3, signed=true, value="752")
        IInt bhjk0001PedAutElimDoc() ;
        
        @Data(size=3, signed=true, value="753")
        IInt bhjk0001InsNPerm() ;
        
        @Data(size=3, signed=true, value="754")
        IInt bhjk0001PactoSocialInex() ;
        
        /**
         * CONCEITO CLIENTE - 2004-05-17 -- INI
         */
        @Data(size=3, signed=true, value="755")
        IInt bhjk0001MoradaObrigatoria() ;
        
        @Data(size=3, signed=true, value="756")
        IInt bhjk0001NomeObrigatorio() ;
        
        @Data(size=3, signed=true, value="757")
        IInt bhjk0001AeObrigatoria() ;
        
        @Data(size=3, signed=true, value="758")
        IInt bhjk0001NifObrigatorio() ;
        
        @Data(size=3, signed=true, value="759")
        IInt bhjk0001BiObrigatorio() ;
        
        @Data(size=3, signed=true, value="760")
        IInt bhjk0001ZNascObrigatoria() ;
        
        @Data(size=3, signed=true, value="761")
        IInt bhjk0001ZConstObrigatoria() ;
        
        @Data(size=3, signed=true, value="762")
        IInt bhjk0001ProfissObrigatoria() ;
        
        @Data(size=3, signed=true, value="763")
        IInt bhjk0001EstCivilObrigatorio() ;
        
        @Data(size=3, signed=true, value="764")
        IInt bhjk0001GranCliObrigatoria() ;
        
        @Data(size=3, signed=true, value="765")
        IInt bhjk0001TipoFiscObrigatorio() ;
        
        @Data(size=3, signed=true, value="766")
        IInt bhjk0001PaisNascObrigatorio() ;
        
        @Data(size=3, signed=true, value="767")
        IInt bhjk0001PaisNatuObrigatorio() ;
        
        @Data(size=3, signed=true, value="768")
        IInt bhjk0001PaisResiObrigatorio() ;
        
        @Data(size=3, signed=true, value="769")
        IInt bhjk0001SectBporObrigatorio() ;
        
        @Data(size=3, signed=true, value="770")
        IInt bhjk0001PaisEmpObrigatorio() ;
        
        @Data(size=3, signed=true, value="771")
        IInt bhjk0001PaisSedeObrigatorio() ;
        
        @Data(size=3, signed=true, value="772")
        IInt bhjk0001TipoScdeObrigatorio() ;
        
        @Data(size=3, signed=true, value="773")
        IInt bhjk0001GnroCliObrigatorio() ;
        
        @Data(size=3, signed=true, value="774")
        IInt bhjk0001OrigCliIndefinida() ;
        
        @Data(size=3, signed=true, value="775")
        IInt bhjk0001RegimJuridIncomp() ;
        
        /**
         * CONCEITO CLIENTE - 2004-05-17 -- FIM
         * NOVOS ERROS DA TRANSACCAO DE CAIXA DIRECTA -- INI
         */
        @Data(size=3, signed=true, value="776")
        IInt bhjk0001MsgErrCxDirecta05() ;
        
        @Data(size=3, signed=true, value="777")
        IInt bhjk0001MsgErrCxDirecta06() ;
        
        @Data(size=3, signed=true, value="778")
        IInt bhjk0001ElimiCxdirOnLine() ;
        
        /**
         * NOVOS ERROS DA TRANSACCAO DE CAIXA DIRECTA -- FIM
         * NOVOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         */
        @Data(size=3, signed=true, value="779")
        IInt bhjk0001CliComGatilhos() ;
        
        @Data(size=3, signed=true, value="780")
        IInt bhjk0001CliSemDocIgual() ;
        
        @Data(size=3, signed=true, value="781")
        IInt bhjk0001CliComGestCli() ;
        
        @Data(size=3, signed=true, value="782")
        IInt bhjk0001CliComOeGestor() ;
        
        @Data(size=3, signed=true, value="783")
        IInt bhjk0001CliIntMesmaConta() ;
        
        @Data(size=3, signed=true, value="784")
        IInt bhjk0001CGranCliIncomp() ;
        
        @Data(size=3, signed=true, value="785")
        IInt bhjk0001AgregadoComNegocia() ;
        
        /**
         * FIM DOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         * NOVOS ERROS DA TRANSACCAO DE NAO RESIDENTES
         */
        @Data(size=3, signed=true, value="786")
        IInt bhjk0001NaoCliNaoResidt() ;
        
        @Data(size=3, signed=true, value="787")
        IInt bhjk0001PnrIne() ;
        
        @Data(size=3, signed=true, value="788")
        IInt bhjk0001PnrExist() ;
        
        @Data(size=3, signed=true, value="789")
        IInt bhjk0001EstPnrInv() ;
        
        /**
         * FIM DOS ERROS DA TRANSACCAO DE NAO RESIDENTES
         * NOVOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         */
        @Data(size=3, signed=true, value="790")
        IInt bhjk0001CliComRendenc() ;
        
        /**
         * FIM DOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         * NOVOS ERROS DO CONCEITO DE CLIENTE
         */
        @Data(size=3, signed=true, value="791")
        IInt bhjk0001DadosGestCliIncomp() ;
        
        @Data(size=3, signed=true, value="792")
        IInt bhjk0001TipDocInvaldPOrig() ;
        
        @Data(size=3, signed=true, value="793")
        IInt bhjk0001TipItvtNPermPOri() ;
        
        /**
         * FIM DOS ERROS DO CONCEITO DE CLIENTE
         * NOVOS ERROS DO UNIVERSITARIOS
         */
        @Data(size=3, signed=true, value="794")
        IInt bhjk0001UniversNaoExiste() ;
        
        @Data(size=3, signed=true, value="795")
        IInt bhjk0001PreechBalcCtco() ;
        
        @Data(size=3, signed=true, value="796")
        IInt bhjk0001EstgVidaInval() ;
        
        @Data(size=3, signed=true, value="797")
        IInt bhjk0001CrsInsNaoExiste() ;
        
        @Data(size=3, signed=true, value="798")
        IInt bhjk0001AnoCurrInval() ;
        
        @Data(size=3, signed=true, value="799")
        IInt bhjk0001AnoLectivoInval() ;
        
        @Data(size=3, signed=true, value="807")
        IInt bhjk0001AltUnivNaoPerm() ;
        
        @Data(size=3, signed=true, value="808")
        IInt bhjk0001Cliente31Anos() ;
        
        @Data(size=3, signed=true, value="809")
        IInt bhjk0001DurCursInval() ;
        
        @Data(size=3, signed=true, value="810")
        IInt bhjk0001ClienFimCiclo() ;
        
        @Data(size=3, signed=true, value="811")
        IInt bhjk0001AltBalcUnivNPerm() ;
        
        @Data(size=3, signed=true, value="812")
        IInt bhjk0001DataFimCrsInval() ;
        
        @Data(size=3, signed=true, value="813")
        IInt bhjk0001AnlecIncomDatFim() ;
        
        @Data(size=3, signed=true, value="814")
        IInt bhjk0001AncurIncomDatFim() ;
        
        @Data(size=3, signed=true, value="815")
        IInt bhjk0001EstagIncomDatFim() ;
        
        @Data(size=3, signed=true, value="816")
        IInt bhjk0001NAlunoInvalido() ;
        
        /**
         * FIM DOS ERROS DO UNIVERSITARIOS
         */
        @Data(size=3, signed=true, value="817")
        IInt bhjk0001BalcaoGestorSemAut() ;
        
        @Data(size=3, signed=true, value="818")
        IInt bhjk0001GestorClientSemAut() ;
        
        /**
         * NOVOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         */
        @Data(size=3, signed=true, value="819")
        IInt bhjk0001AgregadoCUniv() ;
        
        @Data(size=3, signed=true, value="820")
        IInt bhjk0001OrigensIncompat() ;
        
        /**
         * NOVOS ERROS DA MOPE
         */
        @Data(size=3, signed=true, value="821")
        IInt bhjk0001ClienteComAccj() ;
        
        @Data(size=3, signed=true, value="822")
        IInt bhjk0001ClienteComFalAccr() ;
        
        /**
         * FIM DOS ERROS DA TRANSACCAO DE PEDIDOS DE FUSAO
         * NOVOS ERROS DO CONCEITO DE CLIENTE
         */
        @Data(size=3, signed=true, value="823")
        IInt bhjk0001FiliacaoObrigatoria() ;
        
        @Data(size=3, signed=true, value="824")
        IInt bhjk0001EntidEmitenteObrig() ;
        
        @Data(size=3, signed=true, value="825")
        IInt bhjk0001EntidPatronalObrig() ;
        
        @Data(size=3, signed=true, value="826")
        IInt bhjk0001SitSocioProfObrig() ;
        
        @Data(size=3, signed=true, value="827")
        IInt bhjk0001TipoDpdcProfObrig() ;
        
        @Data(size=3, signed=true, value="828")
        IInt bhjk0001ZInicAtvePObrig() ;
        
        @Data(size=3, signed=true, value="829")
        IInt bhjk0001ParticOrgSocObrig() ;
        
        @Data(size=3, signed=true, value="830")
        IInt bhjk0001UtilSeNPosDocVa() ;
        
        /**
         * FIM DOS NOVOS ERROS DO CONCEITO DE CLIENTE
         */
        @Data(size=3, signed=true, value="831")
        IInt bhjk0001UtilNAutNegDescen() ;
        
        @Data(size=3, signed=true, value="832")
        IInt bhjk0001UtilNAutNegCentra() ;
        
        @Data(size=3, signed=true, value="833")
        IInt bhjk0001ObrigUtilizDespacho() ;
        
        @Data(size=3, signed=true, value="834")
        IInt bhjk0001UtilDespachoSemAut() ;
        
        @Data(size=3, signed=true, value="835")
        IInt bhjk0001BalcGestorIncGran() ;
        
        @Data(size=3, signed=true, value="836")
        IInt bhjk0001GranIncBalcGestor() ;
        
        @Data(size=3, signed=true, value="837")
        IInt bhjk0001ArruamentoSuper40() ;
        
        @Data(size=3, signed=true, value="838")
        IInt bhjk0001GrauVinculNCalc() ;
        
        @Data(size=3, signed=true, value="839")
        IInt bhjk0001ActualzNPermitida() ;
        
        @Data(size=3, signed=true, value="919")
        IInt bhjk0001RelUgdOeGestInv() ;
        
        @Data(size=3, signed=true, value="920")
        IInt bhjk0001OeContactoNaoUgd() ;
        
        @Data(size=3, signed=true, value="927")
        IInt bhjk0001MotInvBloq() ;
        
    }
    
}
