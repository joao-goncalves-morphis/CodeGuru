package cgd.ht.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtk0001 extends IDataStruct {
    
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
     * BHTK0001   CONSTANTES COM CODIGOS DE ERRO ARQUITECTURA
     * MSG >= 900 TEM QUE EXISTIR PARA TODAS AS
     * APLICACOES
     * 
     * @version 2.0
     * 
     */
    public interface Erros extends IDataStruct {
        
        /**
         * ERROS GENERICOS DE ARQUITECTURA
         */
        @Data(size=3, signed=true, value="-871")
        IInt dadosAlterados() ;
        
        /**
         * ERROS DE ARQITECTURA
         */
        @Data(size=3, signed=true, value="1")
        IInt receiveMsg() ;
        
        @Data(size=3, signed=true, value="2")
        IInt sendMsg() ;
        
        @Data(size=3, signed=true, value="3")
        IInt terminalNotfnd() ;
        
        @Data(size=3, signed=true, value="4")
        IInt warningDb2() ;
        
        @Data(size=3, signed=true, value="5")
        IInt erroDb2() ;
        
        @Data(size=3, signed=true, value="6")
        IInt aplicNotfnd() ;
        
        @Data(size=3, signed=true, value="7")
        IInt aplicInactiva() ;
        
        @Data(size=3, signed=true, value="8")
        IInt ambienteInval() ;
        
        @Data(size=3, signed=true, value="9")
        IInt trnNotfnd() ;
        
        @Data(size=3, signed=true, value="10")
        IInt trnInactiva() ;
        
        @Data(size=3, signed=true, value="11")
        IInt trnAmbInval() ;
        
        @Data(size=3, signed=true, value="12")
        IInt trnInvalida() ;
        
        @Data(size=3, signed=true, value="13")
        IInt balcaoNotfnd() ;
        
        @Data(size=3, signed=true, value="14")
        IInt syncDatas() ;
        
        @Data(size=3, signed=true, value="15")
        IInt usrNotfnd() ;
        
        @Data(size=3, signed=true, value="16")
        IInt usrSemLogon1() ;
        
        @Data(size=3, signed=true, value="17")
        IInt usrNaoLog() ;
        
        @Data(size=3, signed=true, value="18")
        IInt usrInactivo() ;
        
        @Data(size=3, signed=true, value="19")
        IInt usrSemSync() ;
        
        @Data(size=3, signed=true, value="20")
        IInt usrTerInv() ;
        
        @Data(size=3, signed=true, value="21")
        IInt hbComAut() ;
        
        @Data(size=3, signed=true, value="22")
        IInt usrTerBalInv() ;
        
        @Data(size=3, signed=true, value="23")
        IInt prfNotfnd() ;
        
        @Data(size=3, signed=true, value="24")
        IInt prfInact() ;
        
        @Data(size=3, signed=true, value="25")
        IInt usrSemAcc() ;
        
        @Data(size=3, signed=true, value="26")
        IInt accPrfInv() ;
        
        @Data(size=3, signed=true, value="27")
        IInt copcaoNotNum() ;
        
        @Data(size=3, signed=true, value="29")
        IInt errSelHbt03() ;
        
        @Data(size=3, signed=true, value="30")
        IInt errUpdHbt03() ;
        
        @Data(size=3, signed=true, value="31")
        IInt errInsJournal() ;
        
        @Data(size=3, signed=true, value="32")
        IInt linkPgmjournal() ;
        
        @Data(size=3, signed=true, value="33")
        IInt linkPgmsequen() ;
        
        @Data(size=3, signed=true, value="34")
        IInt linkPgmtotaliz() ;
        
        @Data(size=3, signed=true, value="35")
        IInt errUpdJourAnu() ;
        
        @Data(size=3, signed=true, value="36")
        IInt errSelJourAnu() ;
        
        @Data(size=3, signed=true, value="37")
        IInt linkPgmempres() ;
        
        @Data(size=3, signed=true, value="38")
        IInt correspNotfnd() ;
        
        @Data(size=3, signed=true, value="39")
        IInt regtotNotfnd() ;
        
        @Data(size=3, signed=true, value="40")
        IInt msginpIncoer() ;
        
        @Data(size=3, signed=true, value="41")
        IInt errSelHyt12() ;
        
        @Data(size=3, signed=true, value="42")
        IInt errUpdHyt12() ;
        
        @Data(size=3, signed=true, value="43")
        IInt errIndOper() ;
        
        @Data(size=3, signed=true, value="44")
        IInt erroPedAssync() ;
        
        @Data(size=3, signed=true, value="45")
        IInt anulInvalida() ;
        
        @Data(size=3, signed=true, value="46")
        IInt autEspecInv() ;
        
        @Data(size=3, signed=true, value="47")
        IInt cautorizNotfnd() ;
        
        @Data(size=3, signed=true, value="48")
        IInt tercicsTerpc() ;
        
        @Data(size=3, signed=true, value="49")
        IInt balcaoInact() ;
        
        @Data(size=3, signed=true, value="50")
        IInt balNaoContab() ;
        
        @Data(size=3, signed=true, value="51")
        IInt tbSemSync() ;
        
        @Data(size=3, signed=true, value="52")
        IInt trnJaAnulada() ;
        
        @Data(size=3, signed=true, value="53")
        IInt errSelHbt01() ;
        
        @Data(size=3, signed=true, value="54")
        IInt autEspecInc() ;
        
        @Data(size=3, signed=true, value="55")
        IInt erroTat03() ;
        
        @Data(size=3, signed=true, value="56")
        IInt erroHjt08() ;
        
        @Data(size=3, signed=true, value="58")
        IInt naoHaMaisPag() ;
        
        @Data(size=3, signed=true, value="59")
        IInt naoHaPagAnt() ;
        
        @Data(size=3, signed=true, value="60")
        IInt maisDoQueUm() ;
        
        @Data(size=3, signed=true, value="62")
        IInt naoHaReg() ;
        
        @Data(size=3, signed=true, value="63")
        IInt erroNrsequencia() ;
        
        @Data(size=3, signed=true, value="64")
        IInt tcta018Notfnd() ;
        
        @Data(size=3, signed=true, value="65")
        IInt tcta075Notfnd() ;
        
        @Data(size=3, signed=true, value="66")
        IInt tcta071Notfnd() ;
        
        @Data(size=3, signed=true, value="67")
        IInt errUpdOffprlAnu() ;
        
        @Data(size=3, signed=true, value="68")
        IInt errSelOffprlAnu() ;
        
        @Data(size=3, signed=true, value="69")
        IInt codcampoNotfnd() ;
        
        @Data(size=3, signed=true, value="70")
        IInt totCoperacNotfnd() ;
        
        @Data(size=3, signed=true, value="71")
        IInt errPctr0400() ;
        
        @Data(size=3, signed=true, value="101")
        IInt fimSessao() ;
        
        @Data(size=3, signed=true, value="104")
        IInt erroCics() ;
        
        @Data(size=3, signed=true, value="105")
        IInt errInsHyt04() ;
        
        @Data(size=3, signed=true, value="106")
        IInt erroDatas() ;
        
        @Data(size=3, signed=true, value="107")
        IInt erroTerminal() ;
        
        @Data(size=3, signed=true, value="108")
        IInt pgmNotfnd() ;
        
        @Data(size=3, signed=true, value="109")
        IInt erroLog() ;
        
        @Data(size=3, signed=true, value="110")
        IInt pwInvalida() ;
        
        @Data(size=3, signed=true, value="111")
        IInt pwNova() ;
        
        @Data(size=3, signed=true, value="112")
        IInt pwDiferentes() ;
        
        @Data(size=3, signed=true, value="113")
        IInt pwRepetir() ;
        
        @Data(size=3, signed=true, value="116")
        IInt aplicInvalida() ;
        
        @Data(size=3, signed=true, value="117")
        IInt aplicAEsp() ;
        
        @Data(size=3, signed=true, value="118")
        IInt aplicNao3270() ;
        
        @Data(size=3, signed=true, value="119")
        IInt naoEJcl() ;
        
        @Data(size=3, signed=true, value="122")
        IInt usrPerfilNotfnd() ;
        
        @Data(size=3, signed=true, value="123")
        IInt usrPerfilInactivo() ;
        
        @Data(size=3, signed=true, value="124")
        IInt usrSAcesso() ;
        
        @Data(size=3, signed=true, value="125")
        IInt usrSAcessoOpc() ;
        
        @Data(size=3, signed=true, value="126")
        IInt usrSAcessoApl() ;
        
        @Data(size=3, signed=true, value="127")
        IInt opcaoInvalida() ;
        
        @Data(size=3, signed=true, value="128")
        IInt opcaoInactiva() ;
        
        @Data(size=3, signed=true, value="129")
        IInt opcaoAEsp() ;
        
        @Data(size=3, signed=true, value="130")
        IInt semPagSeg() ;
        
        @Data(size=3, signed=true, value="131")
        IInt semPagAnt() ;
        
        @Data(size=3, signed=true, value="132")
        IInt naoHaHelp() ;
        
        @Data(size=3, signed=true, value="133")
        IInt maisDoQue1() ;
        
        @Data(size=3, signed=true, value="134")
        IInt fimConsulta() ;
        
        @Data(size=3, signed=true, value="136")
        IInt dadosErrados() ;
        
        @Data(size=3, signed=true, value="137")
        IInt dataInv() ;
        
        @Data(size=3, signed=true, value="138")
        IInt numInval() ;
        
        @Data(size=3, signed=true, value="139")
        IInt pfInvalida() ;
        
        @Data(size=3, signed=true, value="140")
        IInt pfNaoDef() ;
        
        @Data(size=3, signed=true, value="141")
        IInt introdDados() ;
        
        @Data(size=3, signed=true, value="142")
        IInt criEfect() ;
        
        @Data(size=3, signed=true, value="143")
        IInt modEfect() ;
        
        @Data(size=3, signed=true, value="144")
        IInt anuEfect() ;
        
        @Data(size=3, signed=true, value="145")
        IInt modIdent() ;
        
        @Data(size=3, signed=true, value="146")
        IInt teclaConf() ;
        
        @Data(size=3, signed=true, value="147")
        IInt dadosInvalidos() ;
        
        @Data(size=3, signed=true, value="148")
        IInt ultPag() ;
        
        @Data(size=3, signed=true, value="149")
        IInt nModIdent() ;
        
        @Data(size=3, signed=true, value="150")
        IInt confF16() ;
        
        @Data(size=3, signed=true, value="151")
        IInt confF17() ;
        
        @Data(size=3, signed=true, value="152")
        IInt confF18() ;
        
        @Data(size=3, signed=true, value="153")
        IInt caractNVal() ;
        
        @Data(size=3, signed=true, value="154")
        IInt numNPre() ;
        
        @Data(size=3, signed=true, value="155")
        IInt compInv() ;
        
        @Data(size=3, signed=true, value="156")
        IInt ndecInval() ;
        
        @Data(size=3, signed=true, value="157")
        IInt nVirInval() ;
        
        @Data(size=3, signed=true, value="158")
        IInt nSinaisInval() ;
        
        @Data(size=3, signed=true, value="159")
        IInt cancelada() ;
        
        @Data(size=3, signed=true, value="160")
        IInt campoObrigat() ;
        
        @Data(size=3, signed=true, value="161")
        IInt introdIdent() ;
        
        @Data(size=3, signed=true, value="162")
        IInt sinalInv() ;
        
        @Data(size=3, signed=true, value="163")
        IInt indFastInv() ;
        
        @Data(size=3, signed=true, value="164")
        IInt valorInv() ;
        
        @Data(size=3, signed=true, value="165")
        IInt opcaoNao3270() ;
        
        @Data(size=3, signed=true, value="166")
        IInt primaEnter() ;
        
        @Data(size=3, signed=true, value="167")
        IInt userSPoder() ;
        
        @Data(size=3, signed=true, value="168")
        IInt insiraPw() ;
        
        @Data(size=3, signed=true, value="169")
        IInt confInsere() ;
        
        @Data(size=3, signed=true, value="170")
        IInt confModifi() ;
        
        @Data(size=3, signed=true, value="171")
        IInt confAnular() ;
        
        @Data(size=3, signed=true, value="172")
        IInt transidInvalida() ;
        
        @Data(size=3, signed=true, value="173")
        IInt opcaoFastpat() ;
        
        @Data(size=3, signed=true, value="174")
        IInt antigaArquitectura() ;
        
        @Data(size=3, signed=true, value="175")
        IInt tarefasAResolver() ;
        
        @Data(size=3, signed=true, value="176")
        IInt aplicBatch() ;
        
        @Data(size=3, signed=true, value="177")
        IInt impressoraNDef() ;
        
        @Data(size=3, signed=true, value="178")
        IInt balcaoInvalido() ;
        
        @Data(size=3, signed=true, value="179")
        IInt confFormaliz() ;
        
        @Data(size=3, signed=true, value="180")
        IInt confAnulFormaliz() ;
        
        @Data(size=3, signed=true, value="181")
        IInt menuCOpcoes() ;
        
        @Data(size=3, signed=true, value="182")
        IInt erroRotina() ;
        
        @Data(size=3, signed=true, value="183")
        IInt lstAceite() ;
        
        @Data(size=3, signed=true, value="184")
        IInt teleVazio() ;
        
        @Data(size=3, signed=true, value="185")
        IInt usrJaLogon() ;
        
        @Data(size=3, signed=true, value="186")
        IInt erroRotinaTab() ;
        
        @Data(size=3, signed=true, value="187")
        IInt erroHlt01() ;
        
        @Data(size=3, signed=true, value="188")
        IInt erroTat02() ;
        
        @Data(size=3, signed=true, value="189")
        IInt tercicsBalcao() ;
        
        @Data(size=3, signed=true, value="190")
        IInt ctermBalcao() ;
        
        @Data(size=3, signed=true, value="191")
        IInt errCallMhgj002a() ;
        
        @Data(size=3, signed=true, value="192")
        IInt errCallMhyj300a() ;
        
        @Data(size=3, signed=true, value="193")
        IInt errCallMhys110a() ;
        
        @Data(size=3, signed=true, value="194")
        IInt errCallMhtq200a() ;
        
        @Data(size=3, signed=true, value="195")
        IInt paramValInexist() ;
        
        @Data(size=3, signed=true, value="232")
        IInt revoked() ;
        
        @Data(size=3, signed=true, value="233")
        IInt bdInactiva() ;
        
        @Data(size=3, signed=true, value="234")
        IInt tabActNotfnd() ;
        
        @Data(size=3, signed=true, value="235")
        IInt relUsrOeNotfnd() ;
        
        @Data(size=3, signed=true, value="236")
        IInt naoValResCon() ;
        
        @Data(size=3, signed=true, value="237")
        IInt naoValResCli() ;
        
        @Data(size=3, signed=true, value="238")
        IInt trResCon() ;
        
        @Data(size=3, signed=true, value="239")
        IInt trResCli() ;
        
        @Data(size=3, signed=true, value="240")
        IInt abendSoftware() ;
        
        @Data(size=3, signed=true, value="241")
        IInt errCallMhyq300a() ;
        
        @Data(size=3, signed=true, value="242")
        IInt naoExstDdsRecup() ;
        
        @Data(size=3, signed=true, value="243")
        IInt relUsrOeInact() ;
        
        @Data(size=3, signed=true, value="244")
        IInt iValCtrlInexist() ;
        
        @Data(size=3, signed=true, value="700")
        IInt faltaBdNcr() ;
        
        @Data(size=3, signed=true, value="701")
        IInt ncrOffline() ;
        
        @Data(size=3, signed=true, value="702")
        IInt ncrTimeout() ;
        
        @Data(size=3, signed=true, value="703")
        IInt ncrTransmit() ;
        
        @Data(size=3, signed=true, value="704")
        IInt msgInv() ;
        
        @Data(size=3, signed=true, value="705")
        IInt caInv() ;
        
        @Data(size=3, signed=true, value="706")
        IInt pacFull() ;
        
        @Data(size=3, signed=true, value="707")
        IInt tabOcup() ;
        
        @Data(size=3, signed=true, value="708")
        IInt cvInv() ;
        
        @Data(size=3, signed=true, value="709")
        IInt abendtncr() ;
        
        @Data(size=3, signed=true, value="710")
        IInt termncrNotfnd() ;
        
        @Data(size=3, signed=true, value="800")
        IInt ok() ;
        
        @Data(size=3, signed=true, value="801")
        IInt caplicExiste() ;
        
        @Data(size=3, signed=true, value="802")
        IInt caplicNaoExiste() ;
        
        @Data(size=3, signed=true, value="803")
        IInt errUpdHyt01() ;
        
        @Data(size=3, signed=true, value="804")
        IInt hyt04Notfnd() ;
        
        @Data(size=3, signed=true, value="805")
        IInt errInsHyt01() ;
        
        @Data(size=3, signed=true, value="806")
        IInt hyt04Fim() ;
        
        @Data(size=3, signed=true, value="807")
        IInt errInsHyt03() ;
        
        @Data(size=3, signed=true, value="808")
        IInt errInsHyt02() ;
        
        @Data(size=3, signed=true, value="809")
        IInt errUpdHyt02() ;
        
        @Data(size=3, signed=true, value="810")
        IInt errDelHyt02() ;
        
        @Data(size=3, signed=true, value="811")
        IInt csequenExiste() ;
        
        @Data(size=3, signed=true, value="812")
        IInt csequenNaoExiste() ;
        
        @Data(size=3, signed=true, value="813")
        IInt ctermExiste() ;
        
        @Data(size=3, signed=true, value="814")
        IInt ctermNaoExiste() ;
        
        @Data(size=3, signed=true, value="815")
        IInt errInsHyt12() ;
        
        @Data(size=3, signed=true, value="816")
        IInt errInsHyt11() ;
        
        @Data(size=3, signed=true, value="817")
        IInt errUpdHyt11() ;
        
        @Data(size=3, signed=true, value="819")
        IInt errUpdHyt03() ;
        
        @Data(size=3, signed=true, value="820")
        IInt errDelHyt11() ;
        
        @Data(size=3, signed=true, value="821")
        IInt cbalcaoExiste() ;
        
        @Data(size=3, signed=true, value="822")
        IInt cbalcaoNaoExiste() ;
        
        @Data(size=3, signed=true, value="823")
        IInt hyt01Notfnd() ;
        
        @Data(size=3, signed=true, value="824")
        IInt hyt01Fim() ;
        
        @Data(size=3, signed=true, value="825")
        IInt copcaoExiste() ;
        
        @Data(size=3, signed=true, value="826")
        IInt copcaoNaoExiste() ;
        
        @Data(size=3, signed=true, value="827")
        IInt cpaisExiste() ;
        
        @Data(size=3, signed=true, value="828")
        IInt errUpdHyt20() ;
        
        @Data(size=3, signed=true, value="829")
        IInt hyt08Notfnd() ;
        
        @Data(size=3, signed=true, value="830")
        IInt hyt20Notfnd() ;
        
        @Data(size=3, signed=true, value="831")
        IInt hyt08Fim() ;
        
        @Data(size=3, signed=true, value="832")
        IInt hyt20Fim() ;
        
        @Data(size=3, signed=true, value="833")
        IInt errInsHyt20() ;
        
        @Data(size=3, signed=true, value="834")
        IInt errDelHyt20() ;
        
        @Data(size=3, signed=true, value="835")
        IInt hyt03Notfnd() ;
        
        @Data(size=3, signed=true, value="836")
        IInt hyt11Notfnd() ;
        
        @Data(size=3, signed=true, value="837")
        IInt hyt03Fim() ;
        
        @Data(size=3, signed=true, value="838")
        IInt hyt11Fim() ;
        
        @Data(size=3, signed=true, value="839")
        IInt msgExiste() ;
        
        @Data(size=3, signed=true, value="840")
        IInt msgNaoExiste() ;
        
        @Data(size=3, signed=true, value="841")
        IInt errInsHyt05() ;
        
        @Data(size=3, signed=true, value="842")
        IInt errUpdHyt05() ;
        
        @Data(size=3, signed=true, value="843")
        IInt errDelHyt05() ;
        
        @Data(size=3, signed=true, value="844")
        IInt errUpdHyt10() ;
        
        @Data(size=3, signed=true, value="845")
        IInt errInsHyt10() ;
        
        @Data(size=3, signed=true, value="846")
        IInt balcaoNaoActiva() ;
        
        @Data(size=3, signed=true, value="847")
        IInt ddiacalExiste() ;
        
        @Data(size=3, signed=true, value="848")
        IInt ddiacalNaoExiste() ;
        
        @Data(size=3, signed=true, value="849")
        IInt ddiacalError() ;
        
        @Data(size=3, signed=true, value="850")
        IInt errInsHyt08() ;
        
        @Data(size=3, signed=true, value="851")
        IInt errUpdHyt08() ;
        
        @Data(size=3, signed=true, value="852")
        IInt errDelHyt08() ;
        
        @Data(size=3, signed=true, value="853")
        IInt errUpdHyt07() ;
        
        @Data(size=3, signed=true, value="854")
        IInt errDelHyt07() ;
        
        @Data(size=3, signed=true, value="855")
        IInt idiautExiste() ;
        
        @Data(size=3, signed=true, value="856")
        IInt idiautNaoExiste() ;
        
        @Data(size=3, signed=true, value="857")
        IInt idiautError() ;
        
        @Data(size=3, signed=true, value="858")
        IInt idiautErrCoe() ;
        
        @Data(size=3, signed=true, value="859")
        IInt naoExistemDatas() ;
        
        @Data(size=3, signed=true, value="860")
        IInt jaExistemDatas() ;
        
        @Data(size=3, signed=true, value="861")
        IInt errInsFat01() ;
        
        @Data(size=3, signed=true, value="862")
        IInt ultDiaNaoExiste() ;
        
        @Data(size=3, signed=true, value="863")
        IInt penDiaNaoExiste() ;
        
        @Data(size=3, signed=true, value="864")
        IInt ultUtiNaoExiste() ;
        
        @Data(size=3, signed=true, value="865")
        IInt erroDifUteis() ;
        
        @Data(size=3, signed=true, value="866")
        IInt erroDifDias() ;
        
        @Data(size=3, signed=true, value="867")
        IInt utiSegNaoExiste() ;
        
        @Data(size=3, signed=true, value="868")
        IInt dataEhMaxUti() ;
        
        @Data(size=3, signed=true, value="869")
        IInt utiAntNaoExiste() ;
        
        @Data(size=3, signed=true, value="870")
        IInt dataEhMinUti() ;
        
        @Data(size=3, signed=true, value="871")
        IInt inputMalFormatad() ;
        
        @Data(size=3, signed=true, value="872")
        IInt dataIlogica() ;
        
        @Data(size=3, signed=true, value="873")
        IInt opcaoMalFormatad() ;
        
        @Data(size=3, signed=true, value="875")
        IInt somaPrazNaoExist() ;
        
        @Data(size=3, signed=true, value="876")
        IInt subtPrazNaoExist() ;
        
        @Data(size=3, signed=true, value="877")
        IInt limitCalNaoExist() ;
        
        @Data(size=3, signed=true, value="878")
        IInt dataIncorrecta() ;
        
        @Data(size=3, signed=true, value="879")
        IInt limitUtiNaoExist() ;
        
        @Data(size=3, signed=true, value="880")
        IInt sumUtilNaoExiste() ;
        
        @Data(size=3, signed=true, value="881")
        IInt subUtilNaoExiste() ;
        
        @Data(size=3, signed=true, value="882")
        IInt prazoNaoExiste() ;
        
        @Data(size=3, signed=true, value="883")
        IInt dataNaoExiste() ;
        
        @Data(size=3, signed=true, value="884")
        IInt tmrTrxNaoSelec() ;
        
        @Data(size=3, signed=true, value="885")
        IInt tmrTrxResolvida() ;
        
        @Data(size=3, signed=true, value="886")
        IInt errUpdHst01() ;
        
        @Data(size=3, signed=true, value="900")
        IInt balOffPrl() ;
        
        @Data(size=3, signed=true, value="901")
        IInt ctaSemTit() ;
        
        @Data(size=3, signed=true, value="902")
        IInt hbCliAcesso() ;
        
        @Data(size=3, signed=true, value="903")
        IInt hbCtaAcesso() ;
        
        @Data(size=3, signed=true, value="904")
        IInt hbCtaImp() ;
        
        @Data(size=3, signed=true, value="905")
        IInt trxJaFeita() ;
        
        @Data(size=3, signed=true, value="907")
        IInt errAccao() ;
        
        @Data(size=3, signed=true, value="908")
        IInt errMsgstr() ;
        
        @Data(size=3, signed=true, value="909")
        IInt errNokey() ;
        
        @Data(size=3, signed=true, value="910")
        IInt handleAbend() ;
        
    }
    
}
