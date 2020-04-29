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
public interface Bhjk0001 extends IDataStruct {
    
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
     * BHJK0001 - COPY DE CONSTANTES DE ERROS
     * 
     * @version 2.0
     * 
     */
    public interface Erros extends IDataStruct {
        
        @Data(size=3, signed=true, value="1")
        IInt moradaNaoExiste() ;
        
        @Data(size=3, signed=true, value="2")
        IInt clienteNaoExiste() ;
        
        @Data(size=3, signed=true, value="3")
        IInt errUpdHjt01() ;
        
        @Data(size=3, signed=true, value="4")
        IInt errInsHjt03() ;
        
        @Data(size=3, signed=true, value="5")
        IInt errOpenHjt03() ;
        
        @Data(size=3, signed=true, value="6")
        IInt errUpdHjt03() ;
        
        @Data(size=3, signed=true, value="7")
        IInt nomeNaoPreenchido() ;
        
        @Data(size=3, signed=true, value="11")
        IInt anotacaoInexistente() ;
        
        @Data(size=3, signed=true, value="12")
        IInt relacaoNaoExiste() ;
        
        @Data(size=3, signed=true, value="20")
        IInt errUpdHjt04() ;
        
        @Data(size=3, signed=true, value="21")
        IInt errInsHjt04() ;
        
        @Data(size=3, signed=true, value="22")
        IInt errDelHjt04() ;
        
        @Data(size=3, signed=true, value="23")
        IInt errOpenHjt04() ;
        
        @Data(size=3, signed=true, value="24")
        IInt errUpdHjt12() ;
        
        @Data(size=3, signed=true, value="25")
        IInt errInsHjt12() ;
        
        @Data(size=3, signed=true, value="26")
        IInt errDelHjt12() ;
        
        @Data(size=3, signed=true, value="27")
        IInt errOpenHjt12() ;
        
        @Data(size=3, signed=true, value="28")
        IInt infMktJaExiste() ;
        
        @Data(size=3, signed=true, value="29")
        IInt infMktNaoExiste() ;
        
        @Data(size=3, signed=true, value="30")
        IInt errUpdHjt13() ;
        
        @Data(size=3, signed=true, value="31")
        IInt errInsHjt13() ;
        
        @Data(size=3, signed=true, value="32")
        IInt errOpenHjt13() ;
        
        @Data(size=3, signed=true, value="33")
        IInt infCompJaExiste() ;
        
        @Data(size=3, signed=true, value="34")
        IInt infCompNaoExiste() ;
        
        @Data(size=3, signed=true, value="35")
        IInt errUpdHjt05() ;
        
        @Data(size=3, signed=true, value="36")
        IInt errInsHjt05() ;
        
        @Data(size=3, signed=true, value="38")
        IInt errUpdHjt06() ;
        
        @Data(size=3, signed=true, value="39")
        IInt errInsHjt06() ;
        
        @Data(size=3, signed=true, value="43")
        IInt errUpdHjt07() ;
        
        @Data(size=3, signed=true, value="44")
        IInt errInsHjt07() ;
        
        @Data(size=3, signed=true, value="45")
        IInt errOpenHjt07() ;
        
        @Data(size=3, signed=true, value="64")
        IInt errSelHst01() ;
        
        @Data(size=3, signed=true, value="65")
        IInt clienteJaExiste() ;
        
        @Data(size=3, signed=true, value="66")
        IInt docCliInvalido() ;
        
        @Data(size=3, signed=true, value="68")
        IInt errInsHjt01() ;
        
        @Data(size=3, signed=true, value="70")
        IInt errInsHjt15() ;
        
        @Data(size=3, signed=true, value="71")
        IInt errDelHjt07() ;
        
        @Data(size=3, signed=true, value="88")
        IInt errSelHjt03() ;
        
        @Data(size=3, signed=true, value="104")
        IInt errSelTat02() ;
        
        @Data(size=3, signed=true, value="105")
        IInt errSelHjt08() ;
        
        @Data(size=3, signed=true, value="133")
        IInt errFetchHjt08() ;
        
        @Data(size=3, signed=true, value="134")
        IInt errFetchHjt03() ;
        
        @Data(size=3, signed=true, value="137")
        IInt errOpnHjt02() ;
        
        @Data(size=3, signed=true, value="138")
        IInt errSelHjt02() ;
        
        @Data(size=3, signed=true, value="139")
        IInt errFetHjt02() ;
        
        @Data(size=3, signed=true, value="140")
        IInt errInsHjt02() ;
        
        @Data(size=3, signed=true, value="141")
        IInt errUpdHjt02() ;
        
        @Data(size=3, signed=true, value="142")
        IInt errDelHjt02() ;
        
        @Data(size=3, signed=true, value="143")
        IInt errClsHjt02() ;
        
        @Data(size=3, signed=true, value="149")
        IInt errSelHjt05() ;
        
        @Data(size=3, signed=true, value="150")
        IInt errSelHjt06() ;
        
        @Data(size=3, signed=true, value="171")
        IInt errCloseHjt01() ;
        
        @Data(size=3, signed=true, value="184")
        IInt declJaEmitida() ;
        
        @Data(size=3, signed=true, value="194")
        IInt errFetchHjt07() ;
        
        @Data(size=3, signed=true, value="195")
        IInt errCloseHjt07() ;
        
        @Data(size=3, signed=true, value="196")
        IInt errOpenHjt15() ;
        
        @Data(size=3, signed=true, value="197")
        IInt errFetchHjt15() ;
        
        @Data(size=3, signed=true, value="198")
        IInt errCloseHjt15() ;
        
        @Data(size=3, signed=true, value="199")
        IInt errCloseHjt03() ;
        
        @Data(size=3, signed=true, value="200")
        IInt errCloseHjt04() ;
        
        @Data(size=3, signed=true, value="201")
        IInt errFetchHjt04() ;
        
        @Data(size=3, signed=true, value="202")
        IInt errFetchHjt01() ;
        
        @Data(size=3, signed=true, value="215")
        IInt naoExitReg() ;
        
        @Data(size=3, signed=true, value="216")
        IInt naoPodeTerNagref() ;
        
        @Data(size=3, signed=true, value="275")
        IInt erroSelHjt07() ;
        
        @Data(size=3, signed=true, value="276")
        IInt erroSelHjt04() ;
        
        @Data(size=3, signed=true, value="341")
        IInt contactoNaoExiste() ;
        
        @Data(size=3, signed=true, value="342")
        IInt erroSelHjt49() ;
        
        @Data(size=3, signed=true, value="344")
        IInt erroInsHjt49() ;
        
        @Data(size=3, signed=true, value="345")
        IInt erroUpdHjt49() ;
        
        @Data(size=3, signed=true, value="346")
        IInt errSelHjt13() ;
        
        @Data(size=3, signed=true, value="347")
        IInt errCloseHjt49() ;
        
        @Data(size=3, signed=true, value="348")
        IInt errOpenHjt49() ;
        
        @Data(size=3, signed=true, value="389")
        IInt erroInsHjt17() ;
        
        @Data(size=3, signed=true, value="390")
        IInt erroUpdHjt17() ;
        
        @Data(size=3, signed=true, value="391")
        IInt erroOpenHjt19() ;
        
        @Data(size=3, signed=true, value="392")
        IInt erroFetchHjt19() ;
        
        @Data(size=3, signed=true, value="393")
        IInt erroCloseHjt19() ;
        
        @Data(size=3, signed=true, value="394")
        IInt erroOpenHjt23() ;
        
        @Data(size=3, signed=true, value="395")
        IInt erroFetchHjt23() ;
        
        @Data(size=3, signed=true, value="396")
        IInt erroCloseHjt23() ;
        
        @Data(size=3, signed=true, value="501")
        IInt inputInsuf() ;
        
        @Data(size=3, signed=true, value="502")
        IInt cliNaoEmigrante() ;
        
        @Data(size=3, signed=true, value="503")
        IInt prEmigIne() ;
        
        @Data(size=3, signed=true, value="505")
        IInt errSelHjt87() ;
        
        @Data(size=3, signed=true, value="506")
        IInt acessoVedado() ;
        
        @Data(size=3, signed=true, value="507")
        IInt acesConced() ;
        
        @Data(size=3, signed=true, value="508")
        IInt erMhtq300a() ;
        
        @Data(size=3, signed=true, value="510")
        IInt zAdesInvl() ;
        
        @Data(size=3, signed=true, value="515")
        IInt gecnInxist() ;
        
        @Data(size=3, signed=true, value="516")
        IInt existeGecn() ;
        
        @Data(size=3, signed=true, value="517")
        IInt exLidGecn() ;
        
        @Data(size=3, signed=true, value="518")
        IInt exRelGecn() ;
        
        @Data(size=3, signed=true, value="523")
        IInt pedidoFusaoExiste() ;
        
        @Data(size=3, signed=true, value="524")
        IInt pedidoFusaoInexist() ;
        
        @Data(size=3, signed=true, value="526")
        IInt habHerdExistente() ;
        
        @Data(size=3, signed=true, value="527")
        IInt habHerdInexistente() ;
        
        @Data(size=3, signed=true, value="528")
        IInt agregadoFu() ;
        
        @Data(size=3, signed=true, value="529")
        IInt cliJaAgregFusao() ;
        
        @Data(size=3, signed=true, value="532")
        IInt fusaoHabHerd() ;
        
        @Data(size=3, signed=true, value="533")
        IInt fuPrvEmig() ;
        
        @Data(size=3, signed=true, value="534")
        IInt cliNaoParticular() ;
        
        @Data(size=3, signed=true, value="535")
        IInt docNaoExis() ;
        
        @Data(size=3, signed=true, value="536")
        IInt docRepetido() ;
        
        @Data(size=3, signed=true, value="537")
        IInt canalJaExiste() ;
        
        @Data(size=3, signed=true, value="538")
        IInt canalNaoExiste() ;
        
        @Data(size=3, signed=true, value="539")
        IInt docExiste() ;
        
        @Data(size=3, signed=true, value="546")
        IInt relacaoJaExiste() ;
        
        @Data(size=3, signed=true, value="550")
        IInt vinculoIncoerente() ;
        
        @Data(size=3, signed=true, value="551")
        IInt criteInsuf() ;
        
        @Data(size=3, signed=true, value="553")
        IInt errSelHjt19() ;
        
        @Data(size=3, signed=true, value="559")
        IInt altNPerm() ;
        
        @Data(size=3, signed=true, value="561")
        IInt elimNPerm() ;
        
        @Data(size=3, signed=true, value="564")
        IInt nomeNExi() ;
        
        @Data(size=3, signed=true, value="567")
        IInt mordNAlt() ;
        
        @Data(size=3, signed=true, value="573")
        IInt accaoInvalida() ;
        
        @Data(size=3, signed=true, value="574")
        IInt zFimInval() ;
        
        @Data(size=3, signed=true, value="575")
        IInt clientBloq() ;
        
        @Data(size=3, signed=true, value="576")
        IInt cliNBloq() ;
        
        @Data(size=3, signed=true, value="577")
        IInt nomeNAlt() ;
        
        @Data(size=3, signed=true, value="578")
        IInt cliIguAsc() ;
        
        @Data(size=3, signed=true, value="579")
        IInt relExiste() ;
        
        @Data(size=3, signed=true, value="580")
        IInt relIncoer() ;
        
        @Data(size=3, signed=true, value="582")
        IInt relDepend() ;
        
        @Data(size=3, signed=true, value="581")
        IInt perGrpInv() ;
        
        @Data(size=3, signed=true, value="583")
        IInt exPedDesg() ;
        
        @Data(size=3, signed=true, value="584")
        IInt pedDesgIn() ;
        
        @Data(size=3, signed=true, value="585")
        IInt clDesagFu() ;
        
        @Data(size=3, signed=true, value="586")
        IInt desgrdorFu() ;
        
        @Data(size=3, signed=true, value="587")
        IInt cliNEmpre() ;
        
        @Data(size=3, signed=true, value="588")
        IInt existAssoc() ;
        
        @Data(size=3, signed=true, value="589")
        IInt exiOrgSoc() ;
        
        @Data(size=3, signed=true, value="590")
        IInt nHaMovim() ;
        
        @Data(size=3, signed=true, value="591")
        IInt campoObrig() ;
        
        @Data(size=3, signed=true, value="592")
        IInt erCriAnot() ;
        
        @Data(size=3, signed=true, value="593")
        IInt erAnulAnt() ;
        
        @Data(size=3, signed=true, value="594")
        IInt cliNPart() ;
        
        @Data(size=3, signed=true, value="595")
        IInt temIncidente() ;
        
        @Data(size=3, signed=true, value="596")
        IInt zInvalida() ;
        
        @Data(size=3, signed=true, value="597")
        IInt indFalInv() ;
        
        @Data(size=3, signed=true, value="599")
        IInt altNotfnd() ;
        
        @Data(size=3, signed=true, value="600")
        IInt relCtraIn() ;
        
        @Data(size=3, signed=true, value="601")
        IInt erBhjw0019() ;
        
        @Data(size=3, signed=true, value="602")
        IInt contrInexi() ;
        
        @Data(size=3, signed=true, value="603")
        IInt declNEmit() ;
        
        @Data(size=3, signed=true, value="604")
        IInt exisEncarg() ;
        
        @Data(size=3, signed=true, value="605")
        IInt nExiEncar() ;
        
        @Data(size=3, signed=true, value="606")
        IInt encargInva() ;
        
        @Data(size=3, signed=true, value="607")
        IInt condInvald() ;
        
        @Data(size=3, signed=true, value="608")
        IInt existEscal() ;
        
        @Data(size=3, signed=true, value="609")
        IInt escalaoNExiste() ;
        
        @Data(size=3, signed=true, value="610")
        IInt escalNAlt() ;
        
        @Data(size=3, signed=true, value="611")
        IInt intervNExiste() ;
        
        @Data(size=3, signed=true, value="612")
        IInt regDuplic() ;
        
        @Data(size=3, signed=true, value="613")
        IInt ctratctaInv() ;
        
        @Data(size=3, signed=true, value="614")
        IInt cliDesagre() ;
        
        @Data(size=3, signed=true, value="615")
        IInt activExist() ;
        
        @Data(size=3, signed=true, value="616")
        IInt actiNExis() ;
        
        @Data(size=3, signed=true, value="617")
        IInt existProfi() ;
        
        @Data(size=3, signed=true, value="618")
        IInt nExisProf() ;
        
        @Data(size=3, signed=true, value="619")
        IInt existPedid() ;
        
        @Data(size=3, signed=true, value="620")
        IInt pedInexist() ;
        
        @Data(size=3, signed=true, value="621")
        IInt estJudInv() ;
        
        @Data(size=3, signed=true, value="622")
        IInt cliCancelado() ;
        
        @Data(size=3, signed=true, value="623")
        IInt dadosIncompativeis() ;
        
        @Data(size=3, signed=true, value="624")
        IInt liderNaoExiste() ;
        
        @Data(size=3, signed=true, value="625")
        IInt herdExiste() ;
        
        @Data(size=3, signed=true, value="626")
        IInt cliHerdExist() ;
        
        @Data(size=3, signed=true, value="627")
        IInt cliHerdInexist() ;
        
        @Data(size=3, signed=true, value="628")
        IInt registoExiste() ;
        
        @Data(size=3, signed=true, value="629")
        IInt estProtInvalido() ;
        
        @Data(size=3, signed=true, value="630")
        IInt complemNExistem() ;
        
        @Data(size=3, signed=true, value="631")
        IInt segmentoNaoExiste() ;
        
        @Data(size=3, signed=true, value="632")
        IInt protExiste() ;
        
        @Data(size=3, signed=true, value="633")
        IInt protNExis() ;
        
        @Data(size=3, signed=true, value="634")
        IInt zIniInval() ;
        
        @Data(size=3, signed=true, value="635")
        IInt errSelHjt01() ;
        
        @Data(size=3, signed=true, value="636")
        IInt errInsHjt08() ;
        
        @Data(size=3, signed=true, value="637")
        IInt errUpdHjt08() ;
        
        @Data(size=3, signed=true, value="638")
        IInt docAnulado() ;
        
        @Data(size=3, signed=true, value="639")
        IInt bancoDestInv() ;
        
        @Data(size=3, signed=true, value="640")
        IInt fusaoNaoCancela() ;
        
        @Data(size=3, signed=true, value="641")
        IInt fusaoComIncidentes() ;
        
        @Data(size=3, signed=true, value="642")
        IInt assocNaoExiste() ;
        
        @Data(size=3, signed=true, value="643")
        IInt protNaoExiste() ;
        
        @Data(size=3, signed=true, value="644")
        IInt alteracaoDados() ;
        
        @Data(size=3, signed=true, value="645")
        IInt desagNaoCancela() ;
        
        @Data(size=3, signed=true, value="646")
        IInt balcaoSemAut() ;
        
        @Data(size=3, signed=true, value="647")
        IInt encargoComEsc() ;
        
        @Data(size=3, signed=true, value="648")
        IInt cliIncoerente() ;
        
        @Data(size=3, signed=true, value="649")
        IInt clienteInibBp() ;
        
        @Data(size=3, signed=true, value="650")
        IInt dadosAlterados() ;
        
        @Data(size=3, signed=true, value="651")
        IInt bloqInvalid() ;
        
        @Data(size=3, signed=true, value="652")
        IInt cTipoCliInv() ;
        
        @Data(size=3, signed=true, value="653")
        IInt existBenefProt() ;
        
        @Data(size=3, signed=true, value="654")
        IInt pedAltConfDup() ;
        
        @Data(size=3, signed=true, value="655")
        IInt pedAltConfNExist() ;
        
        @Data(size=3, signed=true, value="656")
        IInt cliNExistEmp() ;
        
        @Data(size=3, signed=true, value="657")
        IInt pedAltConfCan() ;
        
        @Data(size=3, signed=true, value="658")
        IInt qOccursInvalida() ;
        
        @Data(size=3, signed=true, value="659")
        IInt pemgtCaducada() ;
        
        @Data(size=3, signed=true, value="660")
        IInt eliminaDoc() ;
        
        @Data(size=3, signed=true, value="661")
        IInt reactNPerm() ;
        
        @Data(size=3, signed=true, value="662")
        IInt jaExistAePrin() ;
        
        @Data(size=3, signed=true, value="663")
        IInt nExistAePrin() ;
        
        @Data(size=3, signed=true, value="664")
        IInt prEmigExi() ;
        
        @Data(size=3, signed=true, value="665")
        IInt docPrincNEnt() ;
        
        @Data(size=3, signed=true, value="666")
        IInt encargoMalCalc() ;
        
        @Data(size=3, signed=true, value="667")
        IInt pedAutAprovEscal() ;
        
        @Data(size=3, signed=true, value="668")
        IInt pedAutAprovEncg() ;
        
        @Data(size=3, signed=true, value="669")
        IInt herdeiroInvalido() ;
        
        @Data(size=3, signed=true, value="670")
        IInt nExistMordPrinc() ;
        
        @Data(size=3, signed=true, value="671")
        IInt orgaoNGestor() ;
        
        @Data(size=3, signed=true, value="672")
        IInt userNGestor() ;
        
        @Data(size=3, signed=true, value="673")
        IInt clienteMenor() ;
        
        @Data(size=3, signed=true, value="674")
        IInt canalInvalido() ;
        
        @Data(size=3, signed=true, value="675")
        IInt contratoInvalido() ;
        
        @Data(size=3, signed=true, value="676")
        IInt estadoCanalInvalido() ;
        
        @Data(size=3, signed=true, value="677")
        IInt primTitDoNaoPart() ;
        
        @Data(size=3, signed=true, value="678")
        IInt erroCliExiste() ;
        
        @Data(size=3, signed=true, value="700")
        IInt nExisteActividade() ;
        
        @Data(size=3, signed=true, value="701")
        IInt nExisteNfc() ;
        
        @Data(size=3, signed=true, value="702")
        IInt clienteParticular() ;
        
        @Data(size=3, signed=true, value="703")
        IInt zEmissInvalida() ;
        
        @Data(size=3, signed=true, value="704")
        IInt erroAcessoIntegrity() ;
        
        @Data(size=3, signed=true, value="705")
        IInt nElimMordPrin() ;
        
        @Data(size=3, signed=true, value="706")
        IInt zCaeInval() ;
        
        @Data(size=3, signed=true, value="707")
        IInt zInfNascConst() ;
        
        @Data(size=3, signed=true, value="708")
        IInt zObitoInval() ;
        
        @Data(size=3, signed=true, value="709")
        IInt estPemgtInv() ;
        
        @Data(size=3, signed=true, value="800")
        IInt pactoSocInex() ;
        
        @Data(size=3, signed=true, value="878")
        IInt tvaObrigatorio() ;
        
        @Data(size=3, signed=true, value="880")
        IInt errInsHj116() ;
        
        @Data(size=3, signed=true, value="881")
        IInt errUpdHj115() ;
        
        @Data(size=3, signed=true, value="882")
        IInt nacnJaExiste() ;
        
        @Data(size=3, signed=true, value="883")
        IInt necDocFslUs() ;
        
        @Data(size=3, signed=true, value="884")
        IInt sitEstInv() ;
        
        @Data(size=3, signed=true, value="885")
        IInt cRfinInv() ;
        
        @Data(size=3, signed=true, value="886")
        IInt paisOeCtcoObrg() ;
        
        @Data(size=3, signed=true, value="887")
        IInt paisDirzObrg() ;
        
        @Data(size=3, signed=true, value="888")
        IInt empOeCtcoObrg() ;
        
        @Data(size=3, signed=true, value="889")
        IInt empDirzObrg() ;
        
        @Data(size=3, signed=true, value="890")
        IInt cliSemEstatFatca() ;
        
        @Data(size=3, signed=true, value="891")
        IInt cliComEstatFatca() ;
        
        @Data(size=3, signed=true, value="892")
        IInt numCliObrigatorio() ;
        
        @Data(size=3, signed=true, value="893")
        IInt obrigDocFiscal() ;
        
        @Data(size=3, signed=true, value="894")
        IInt cliEmpSemBenEftv() ;
        
        @Data(size=3, signed=true, value="210")
        IInt benEtvNEmpresa() ;
        
        @Data(size=3, signed=true, value="89")
        IInt origCliAgrgInval() ;
        
        @Data(size=3, signed=true, value="895")
        IInt cliEmpInvalSelOrd() ;
        
        @Data(size=3, signed=true, value="896")
        IInt numCliObgBenEftv() ;
        
        @Data(size=3, signed=true, value="897")
        IInt nPermElimUltBenE() ;
        
        @Data(size=3, signed=true, value="203")
        IInt nElimMordFsl() ;
        
        @Data(size=3, signed=true, value="204")
        IInt nElimMordResi() ;
        
        @Data(size=3, signed=true, value="205")
        IInt nElimUltimaMord() ;
        
        @Data(size=3, signed=true, value="206")
        IInt cPaisFslDifFusao() ;
        
        @Data(size=3, signed=true, value="207")
        IInt cPaisResiDifFusao() ;
        
        @Data(size=3, signed=true, value="208")
        IInt mordResiNaoDfnida() ;
        
        @Data(size=3, signed=true, value="209")
        IInt mordFiscNaoDfnida() ;
        
        @Data(size=3, signed=true, value="898")
        IInt catInvxInad() ;
        
        @Data(size=3, signed=true, value="899")
        IInt estatCrsDif() ;
        
        @Data(size=3, signed=true, value="900")
        IInt estatCrsFatcDif() ;
        
        @Data(size=3, signed=true, value="901")
        IInt paisFslDifPaisSed() ;
        
        @Data(size=3, signed=true, value="902")
        IInt docFslEstgInex() ;
        
        @Data(size=3, signed=true, value="903")
        IInt docFslResiInex() ;
        
        @Data(size=3, signed=true, value="904")
        IInt paisDocDifMordFsl() ;
        
        @Data(size=3, signed=true, value="905")
        IInt cliComEstatCrs() ;
        
        @Data(size=3, signed=true, value="906")
        IInt cliSemEstatCrs() ;
        
        @Data(size=3, signed=true, value="907")
        IInt cliCEstatFatcCrs() ;
        
        @Data(size=3, signed=true, value="908")
        IInt cliSPaisDataNasc() ;
        
        @Data(size=3, signed=true, value="909")
        IInt oriInvPEmiDocFsl() ;
        
        @Data(size=3, signed=true, value="910")
        IInt paisNEmiDocFiscal() ;
        
        @Data(size=3, signed=true, value="911")
        IInt paisOpexNEmiDfsl() ;
        
        @Data(size=3, signed=true, value="912")
        IInt paramOriCliIncorr() ;
        
        @Data(size=3, signed=true, value="913")
        IInt estuCliCrsEmpInv() ;
        
        @Data(size=3, signed=true, value="914")
        IInt docFslDifDupTrib() ;
        
        @Data(size=3, signed=true, value="915")
        IInt paisMordFsclInval() ;
        
        @Data(size=3, signed=true, value="921")
        IInt emailInvalido() ;
        
        @Data(size=3, signed=true, value="922")
        IInt codLeiInexistente() ;
        
        @Data(size=3, signed=true, value="923")
        IInt codLeiInvExp() ;
        
        @Data(size=3, signed=true, value="14")
        IInt contctPrinObrig() ;
        
        @Data(size=3, signed=true, value="15")
        IInt cliCContactoSec() ;
        
        @Data(size=3, signed=true, value="19")
        IInt ctcoPrincInibido() ;
        
        @Data(size=3, signed=true, value="237")
        IInt contactoInvalido() ;
        
        @Data(size=3, signed=true, value="238")
        IInt contactoJaExiste() ;
        
        @Data(size=3, signed=true, value="680")
        IInt oeNegocioInvalido() ;
        
    }
    
}
