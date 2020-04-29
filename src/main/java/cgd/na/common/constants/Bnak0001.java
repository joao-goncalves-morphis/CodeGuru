package cgd.na.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bnak0001 extends IDataStruct {
    
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
     * BNAK0001
     * CONSTANTES COM CODIGOS DE ERRO DA APLICACAO DE CREDITO
     * (EMPRESTIMOS, CONTAS CORRENTES E GARANTIAS BANCARIAS)
     * 
     * @version 2.0
     * 
     */
    public interface Erros extends IDataStruct {
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-PREMIOS-POR-ENTREGAR    PIC S9(3) VALUE -001.
         * 05 B..K0001-CHEQUES-ACTIVOS         PIC S9(3) VALUE -002.
         * 05 B..K0001-TRANSF-FUTUR            PIC S9(3) VALUE -003.
         * 05 B..K0001-ATRZ-Z-VALOR-ABR-SCTA   PIC S9(3) VALUE -364.
         * 05 B..K0001-ATRZ-M-SLDO-CBLO-IND    PIC S9(3) VALUE -365.
         * 05 B..K0001-ATRZ-M-SLDO-DPNL-IND    PIC S9(3) VALUE -366.
         * 05 B..K0001-ATRZ-PEND-COB-ACT       PIC S9(3) VALUE -367.
         * 05 B..K0001-ATRZ-PRIMEIRO-MOVIM     PIC S9(3) VALUE -368.
         * 05 B..K0001-ATRZ-ATRZ-D-PAVS        PIC S9(3) VALUE -369.
         * 05 B..K0001-AUTORIZ-N-PENALIZ       PIC S9(3) VALUE -393.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="1")
        IInt operacaoCreditoInxs() ;
        
        @Data(size=3, signed=true, value="2")
        IInt operacaoCreditoBloq() ;
        
        @Data(size=3, signed=true, value="3")
        IInt sitInvExecTransac() ;
        
        @Data(size=3, signed=true, value="4")
        IInt regModificado() ;
        
        @Data(size=3, signed=true, value="5")
        IInt instPlanoExiste() ;
        
        @Data(size=3, signed=true, value="6")
        IInt sitCondInvElimina() ;
        
        @Data(size=3, signed=true, value="7")
        IInt sitCondInvModifica() ;
        
        @Data(size=3, signed=true, value="8")
        IInt pendCobNotfnd() ;
        
        @Data(size=3, signed=true, value="9")
        IInt movNotfnd() ;
        
        @Data(size=3, signed=true, value="10")
        IInt altContaDoAssoc() ;
        
        @Data(size=3, signed=true, value="11")
        IInt plnoNPermitido() ;
        
        @Data(size=3, signed=true, value="12")
        IInt mntMenorMinimo() ;
        
        @Data(size=3, signed=true, value="13")
        IInt mntMaiorMax() ;
        
        @Data(size=3, signed=true, value="14")
        IInt dtInstInvalida() ;
        
        @Data(size=3, signed=true, value="15")
        IInt instSindbancNotfnd() ;
        
        @Data(size=3, signed=true, value="16")
        IInt condContrNotfnd() ;
        
        @Data(size=3, signed=true, value="17")
        IInt movBonifNotfnd() ;
        
        @Data(size=3, signed=true, value="18")
        IInt tabContabOverflow() ;
        
        @Data(size=3, signed=true, value="19")
        IInt prestNotfnd() ;
        
        @Data(size=3, signed=true, value="20")
        IInt prazDiasInv() ;
        
        @Data(size=3, signed=true, value="21")
        IInt condDinTaxNotfnd() ;
        
        @Data(size=3, signed=true, value="22")
        IInt perOpNotfnd() ;
        
        @Data(size=3, signed=true, value="23")
        IInt condDinFnd() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-DEB-MOV-CONT-DEST-IND   PIC S9(3) VALUE +024.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="25")
        IInt bonifReclNotfnd() ;
        
        @Data(size=3, signed=true, value="27")
        IInt pedMapdocNotfnd() ;
        
        @Data(size=3, signed=true, value="28")
        IInt txEsfoClSupProd() ;
        
        @Data(size=3, signed=true, value="29")
        IInt perInconsProxPer() ;
        
        @Data(size=3, signed=true, value="30")
        IInt perInconsFase() ;
        
        @Data(size=3, signed=true, value="31")
        IInt condDinGerNotfnd() ;
        
        @Data(size=3, signed=true, value="32")
        IInt credInterSOpPrinc() ;
        
        @Data(size=3, signed=true, value="33")
        IInt impAltPrzFaseAnt() ;
        
        @Data(size=3, signed=true, value="34")
        IInt alterPrzAlterFase() ;
        
        @Data(size=3, signed=true, value="35")
        IInt prazoUtilMaiorMax() ;
        
        @Data(size=3, signed=true, value="36")
        IInt prazoUtilMenorMin() ;
        
        @Data(size=3, signed=true, value="37")
        IInt prazoDiferMaiorMax() ;
        
        @Data(size=3, signed=true, value="38")
        IInt prazoDiferMenorMin() ;
        
        @Data(size=3, signed=true, value="39")
        IInt prazoAmortMaiorMax() ;
        
        @Data(size=3, signed=true, value="40")
        IInt prazoAmortMenorMin() ;
        
        @Data(size=3, signed=true, value="41")
        IInt limAutNotfnd() ;
        
        @Data(size=3, signed=true, value="42")
        IInt erroDb2() ;
        
        @Data(size=3, signed=true, value="43")
        IInt doDebitoSemTitOp() ;
        
        @Data(size=3, signed=true, value="44")
        IInt doCreditoSemTitOp() ;
        
        @Data(size=3, signed=true, value="45")
        IInt nEnvioProcEntEx() ;
        
        @Data(size=3, signed=true, value="46")
        IInt nAprSubEntEx() ;
        
        @Data(size=3, signed=true, value="47")
        IInt nEstMntAplRelev() ;
        
        @Data(size=3, signed=true, value="48")
        IInt divSaldCapUtil() ;
        
        @Data(size=3, signed=true, value="49")
        IInt doAssocContCorr() ;
        
        @Data(size=3, signed=true, value="50")
        IInt sitCtaDoInvalida() ;
        
        @Data(size=3, signed=true, value="51")
        IInt segObrgNSubscrts() ;
        
        @Data(size=3, signed=true, value="52")
        IInt operSemOperCptlz() ;
        
        @Data(size=3, signed=true, value="53")
        IInt operTransOicNotfnd() ;
        
        @Data(size=3, signed=true, value="54")
        IInt dtLimAutAnt() ;
        
        @Data(size=3, signed=true, value="55")
        IInt montDispInsuf() ;
        
        @Data(size=3, signed=true, value="56")
        IInt operacaoNBonificada() ;
        
        @Data(size=3, signed=true, value="57")
        IInt insercaoNPermitida() ;
        
        @Data(size=3, signed=true, value="58")
        IInt modifNPermitida() ;
        
        @Data(size=3, signed=true, value="59")
        IInt eliminNPermitida() ;
        
        @Data(size=3, signed=true, value="60")
        IInt declaracaoInvalida() ;
        
        @Data(size=3, signed=true, value="61")
        IInt comprovativoInexist() ;
        
        @Data(size=3, signed=true, value="62")
        IInt gatAlterPrzExist() ;
        
        @Data(size=3, signed=true, value="63")
        IInt gatAlterPrzInxst() ;
        
        @Data(size=3, signed=true, value="64")
        IInt altMtvoBlqoNPerm() ;
        
        @Data(size=3, signed=true, value="65")
        IInt altImpossGatilho() ;
        
        @Data(size=3, signed=true, value="66")
        IInt periodCapJurDifer() ;
        
        @Data(size=3, signed=true, value="67")
        IInt planoManualIncrnt() ;
        
        @Data(size=3, signed=true, value="68")
        IInt rnvzAutNPermitida() ;
        
        @Data(size=3, signed=true, value="69")
        IInt bloqOpInexist() ;
        
        @Data(size=3, signed=true, value="70")
        IInt codBloqInexist() ;
        
        @Data(size=3, signed=true, value="71")
        IInt erroNumInst() ;
        
        @Data(size=3, signed=true, value="72")
        IInt numInstMaiorMax() ;
        
        @Data(size=3, signed=true, value="73")
        IInt numInstMenorMin() ;
        
        @Data(size=3, signed=true, value="74")
        IInt elimInstNPermt() ;
        
        @Data(size=3, signed=true, value="75")
        IInt codTipoPlnoNotfnd() ;
        
        @Data(size=3, signed=true, value="76")
        IInt dadosAlterados() ;
        
        @Data(size=3, signed=true, value="77")
        IInt revtxInconsPerJur() ;
        
        @Data(size=3, signed=true, value="78")
        IInt prazoOpcrMaiorMax() ;
        
        @Data(size=3, signed=true, value="79")
        IInt prazoOpcrMenorMin() ;
        
        @Data(size=3, signed=true, value="80")
        IInt przOpcrInconsFas() ;
        
        @Data(size=3, signed=true, value="81")
        IInt anosCrescInconsPrz() ;
        
        @Data(size=3, signed=true, value="82")
        IInt mtdoCapIncPerCap() ;
        
        @Data(size=3, signed=true, value="83")
        IInt mtdoJurIncPerJur() ;
        
        @Data(size=3, signed=true, value="84")
        IInt metamortNPermCapit() ;
        
        @Data(size=3, signed=true, value="85")
        IInt zPrvtSupZAbraPrp() ;
        
        @Data(size=3, signed=true, value="86")
        IInt clienteInvalido() ;
        
        @Data(size=3, signed=true, value="87")
        IInt nEmpregadoGcgd() ;
        
        @Data(size=3, signed=true, value="88")
        IInt clienteNEmigrante() ;
        
        @Data(size=3, signed=true, value="89")
        IInt duracaoPlnRemObrg() ;
        
        @Data(size=3, signed=true, value="90")
        IInt zPrvCtSupZAbraP() ;
        
        @Data(size=3, signed=true, value="91")
        IInt prazoIncorrecto() ;
        
        @Data(size=3, signed=true, value="92")
        IInt contaJaExisteSist() ;
        
        @Data(size=3, signed=true, value="93")
        IInt dataInvalida() ;
        
        @Data(size=3, signed=true, value="94")
        IInt sitProNArquivar() ;
        
        @Data(size=3, signed=true, value="95")
        IInt sitProNReabrir() ;
        
        @Data(size=3, signed=true, value="96")
        IInt sitProNRecusar() ;
        
        @Data(size=3, signed=true, value="97")
        IInt inputMalForm() ;
        
        @Data(size=3, signed=true, value="98")
        IInt bonifObrigPrestCon() ;
        
        @Data(size=3, signed=true, value="99")
        IInt admOpNotfnd() ;
        
        @Data(size=3, signed=true, value="100")
        IInt cCrtcCdnmInv() ;
        
        @Data(size=3, signed=true, value="101")
        IInt zCtrDifZProc() ;
        
        @Data(size=3, signed=true, value="102")
        IInt prodNaoTransfOic() ;
        
        @Data(size=3, signed=true, value="103")
        IInt dadosNAlterados() ;
        
        @Data(size=3, signed=true, value="104")
        IInt erroPercResp() ;
        
        @Data(size=3, signed=true, value="105")
        IInt tipoAccaoInvalido() ;
        
        @Data(size=3, signed=true, value="106")
        IInt dadosInputObrig() ;
        
        @Data(size=3, signed=true, value="107")
        IInt operCreditoSemBloq() ;
        
        @Data(size=3, signed=true, value="108")
        IInt contaComRelActivas() ;
        
        @Data(size=3, signed=true, value="109")
        IInt gatAltProdExist() ;
        
        @Data(size=3, signed=true, value="110")
        IInt gatAltProdInexist() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-ACCAO-INVAL-ICPT        PIC S9(3) VALUE +111.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="112")
        IInt periodicOrigemInval() ;
        
        @Data(size=3, signed=true, value="113")
        IInt nPermRfroCapPsvl() ;
        
        @Data(size=3, signed=true, value="114")
        IInt nPermRduzCapPsvl() ;
        
        @Data(size=3, signed=true, value="115")
        IInt pagNPrevista() ;
        
        @Data(size=3, signed=true, value="116")
        IInt prodSemFasCat() ;
        
        @Data(size=3, signed=true, value="117")
        IInt lbonifMudaAnuid() ;
        
        @Data(size=3, signed=true, value="118")
        IInt mcCapPrgrMudAnuid() ;
        
        @Data(size=3, signed=true, value="119")
        IInt segCliInvProd() ;
        
        @Data(size=3, signed=true, value="120")
        IInt prodSemPrzFasOpcr() ;
        
        @Data(size=3, signed=true, value="121")
        IInt mCttdMenorPermt() ;
        
        @Data(size=3, signed=true, value="122")
        IInt mCttdMenorCapDiv() ;
        
        @Data(size=3, signed=true, value="123")
        IInt docObrigProdInex() ;
        
        @Data(size=3, signed=true, value="124")
        IInt sldoMaiorMGbnc() ;
        
        @Data(size=3, signed=true, value="125")
        IInt mCttdMaiorMax() ;
        
        @Data(size=3, signed=true, value="126")
        IInt mCttdMenorMin() ;
        
        @Data(size=3, signed=true, value="127")
        IInt sldoGbncMaiorMax() ;
        
        @Data(size=3, signed=true, value="128")
        IInt sldoGbncMenorMin() ;
        
        @Data(size=3, signed=true, value="129")
        IInt prodObrigFasUtil() ;
        
        @Data(size=3, signed=true, value="130")
        IInt prodObrigFasDifer() ;
        
        @Data(size=3, signed=true, value="131")
        IInt prodObrigFasAmort() ;
        
        @Data(size=3, signed=true, value="132")
        IInt prodNPerFasUtil() ;
        
        @Data(size=3, signed=true, value="133")
        IInt prodNPerFasDifer() ;
        
        @Data(size=3, signed=true, value="134")
        IInt prodNPerFasAmort() ;
        
        @Data(size=3, signed=true, value="135")
        IInt mcAmoInconsMcJur() ;
        
        @Data(size=3, signed=true, value="136")
        IInt ctaDbCrSemTitOp() ;
        
        @Data(size=3, signed=true, value="137")
        IInt plnoInvalido() ;
        
        @Data(size=3, signed=true, value="138")
        IInt inputInvalido() ;
        
        @Data(size=3, signed=true, value="139")
        IInt lmMaxMaiorCapCttd() ;
        
        @Data(size=3, signed=true, value="140")
        IInt capUtidMaiorLmMax() ;
        
        @Data(size=3, signed=true, value="141")
        IInt erroAnlIvtOpcr() ;
        
        @Data(size=3, signed=true, value="142")
        IInt nExistemCtrActivos() ;
        
        @Data(size=3, signed=true, value="143")
        IInt histBasicosNotfnd() ;
        
        @Data(size=3, signed=true, value="144")
        IInt histAdmnNotfnd() ;
        
        @Data(size=3, signed=true, value="145")
        IInt parametrOpNotfnd() ;
        
        @Data(size=3, signed=true, value="146")
        IInt taxasContratNotfnd() ;
        
        @Data(size=3, signed=true, value="147")
        IInt declRendimNotfnd() ;
        
        @Data(size=3, signed=true, value="148")
        IInt impAltMovLotePago() ;
        
        @Data(size=3, signed=true, value="149")
        IInt movNInclLote() ;
        
        @Data(size=3, signed=true, value="150")
        IInt impEmitirMapaLote() ;
        
        @Data(size=3, signed=true, value="151")
        IInt dadosOpOicExist() ;
        
        @Data(size=3, signed=true, value="152")
        IInt movimPosterExist() ;
        
        @Data(size=3, signed=true, value="153")
        IInt rfroRduzExist() ;
        
        @Data(size=3, signed=true, value="154")
        IInt rfroRduzInxst() ;
        
        @Data(size=3, signed=true, value="155")
        IInt codMovInexist() ;
        
        @Data(size=3, signed=true, value="156")
        IInt erroOperCredito() ;
        
        @Data(size=3, signed=true, value="157")
        IInt paramFsUtlInxs() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-ATRZ-M-SLDO-IND         PIC S9(3) VALUE +158.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="159")
        IInt paramFsAmozInxs() ;
        
        @Data(size=3, signed=true, value="160")
        IInt cTipoPrazInv() ;
        
        @Data(size=3, signed=true, value="161")
        IInt iTipoAjtePrazInv() ;
        
        @Data(size=3, signed=true, value="162")
        IInt zAniversarioInv() ;
        
        @Data(size=3, signed=true, value="163")
        IInt prazMesesInv() ;
        
        @Data(size=3, signed=true, value="164")
        IInt formatoDataIncorrec() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-SALDO-INSUF             PIC S9(3) VALUE +165.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="166")
        IInt zValorAmozInv() ;
        
        @Data(size=3, signed=true, value="167")
        IInt divPendExistente() ;
        
        @Data(size=3, signed=true, value="168")
        IInt amozDiaExist() ;
        
        @Data(size=3, signed=true, value="169")
        IInt amozInxst() ;
        
        @Data(size=3, signed=true, value="170")
        IInt zValorElimAmozInv() ;
        
        @Data(size=3, signed=true, value="171")
        IInt istzAmozDataExist() ;
        
        @Data(size=3, signed=true, value="172")
        IInt sbtxUltrapLimCat() ;
        
        @Data(size=3, signed=true, value="173")
        IInt semFases() ;
        
        @Data(size=3, signed=true, value="174")
        IInt mntDifMaiorMax() ;
        
        @Data(size=3, signed=true, value="175")
        IInt plnoBonifSPlnoJur() ;
        
        @Data(size=3, signed=true, value="176")
        IInt nIstzBonzJuro() ;
        
        @Data(size=3, signed=true, value="177")
        IInt montBonzMontJur() ;
        
        @Data(size=3, signed=true, value="178")
        IInt nPermAmozAtpdFase() ;
        
        @Data(size=3, signed=true, value="179")
        IInt mRmncMenorMin() ;
        
        @Data(size=3, signed=true, value="180")
        IInt sindicatoSemGcgd() ;
        
        @Data(size=3, signed=true, value="181")
        IInt mLiqIstzInvld() ;
        
        @Data(size=3, signed=true, value="182")
        IInt sitIncNEncg() ;
        
        @Data(size=3, signed=true, value="183")
        IInt sitOpcrNEncg() ;
        
        @Data(size=3, signed=true, value="184")
        IInt mCttdMenorUtizMax() ;
        
        @Data(size=3, signed=true, value="185")
        IInt prazUtizInvalido() ;
        
        @Data(size=3, signed=true, value="186")
        IInt prazDiftInvalido() ;
        
        @Data(size=3, signed=true, value="187")
        IInt prazAmozInvalido() ;
        
        @Data(size=3, signed=true, value="188")
        IInt erroModoAcesso() ;
        
        @Data(size=3, signed=true, value="189")
        IInt erroCodCondicao() ;
        
        @Data(size=3, signed=true, value="190")
        IInt erroDataEntrVig() ;
        
        @Data(size=3, signed=true, value="191")
        IInt erroDataIncoernt() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-AUTOR-NEG-ENCARG        PIC S9(3) VALUE +192.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="193")
        IInt erroFmTaxa() ;
        
        @Data(size=3, signed=true, value="194")
        IInt erroFmPeriodJur() ;
        
        @Data(size=3, signed=true, value="195")
        IInt erroFmPeriodCap() ;
        
        @Data(size=3, signed=true, value="196")
        IInt erroFmMetodoJur() ;
        
        @Data(size=3, signed=true, value="197")
        IInt erroFmMetodoCap() ;
        
        @Data(size=3, signed=true, value="198")
        IInt erroFmCapitalizac() ;
        
        @Data(size=3, signed=true, value="199")
        IInt erroFmPeriodCom() ;
        
        @Data(size=3, signed=true, value="200")
        IInt erroFmLinhaBonif() ;
        
        @Data(size=3, signed=true, value="201")
        IInt erroFmPlanoRemun() ;
        
        @Data(size=3, signed=true, value="202")
        IInt erroFmIReplicacao() ;
        
        @Data(size=3, signed=true, value="203")
        IInt erroInicPrzCdCat() ;
        
        @Data(size=3, signed=true, value="204")
        IInt existeCondDinData() ;
        
        @Data(size=3, signed=true, value="205")
        IInt erroOcorrExcLim() ;
        
        @Data(size=3, signed=true, value="206")
        IInt opcrNRlcnd() ;
        
        @Data(size=3, signed=true, value="207")
        IInt cOeEgcOpexInv() ;
        
        @Data(size=3, signed=true, value="208")
        IInt naoCapitalizaJmor() ;
        
        @Data(size=3, signed=true, value="209")
        IInt nPermRetornGest() ;
        
        @Data(size=3, signed=true, value="210")
        IInt nPermAbateActivo() ;
        
        @Data(size=3, signed=true, value="211")
        IInt tranNPermAltPrz() ;
        
        @Data(size=3, signed=true, value="212")
        IInt somPrzDifPrzOper() ;
        
        @Data(size=3, signed=true, value="213")
        IInt zInicVldePost() ;
        
        @Data(size=3, signed=true, value="215")
        IInt exstOpcrComGarRel() ;
        
        @Data(size=3, signed=true, value="216")
        IInt nAmozContPoup() ;
        
        @Data(size=3, signed=true, value="217")
        IInt movCntLiqInv() ;
        
        @Data(size=3, signed=true, value="218")
        IInt opcrLiquidada() ;
        
        @Data(size=3, signed=true, value="219")
        IInt opcrRecusada() ;
        
        @Data(size=3, signed=true, value="220")
        IInt dadosBonifOpExist() ;
        
        @Data(size=3, signed=true, value="221")
        IInt opcrSbNIntercalar() ;
        
        @Data(size=3, signed=true, value="222")
        IInt opcrNCapzNoutra() ;
        
        @Data(size=3, signed=true, value="223")
        IInt opcrPrNConvenc() ;
        
        @Data(size=3, signed=true, value="224")
        IInt opcrSbNLiquidada() ;
        
        @Data(size=3, signed=true, value="225")
        IInt gatAlterTaxaInxst() ;
        
        @Data(size=3, signed=true, value="226")
        IInt eventoContratExist() ;
        
        @Data(size=3, signed=true, value="227")
        IInt eventoContratInxst() ;
        
        @Data(size=3, signed=true, value="228")
        IInt modifNPermApVenc() ;
        
        @Data(size=3, signed=true, value="229")
        IInt tipoTaxNaoConvers() ;
        
        @Data(size=3, signed=true, value="230")
        IInt saldoCarteiraInx() ;
        
        @Data(size=3, signed=true, value="231")
        IInt tabCodMovOverflow() ;
        
        @Data(size=3, signed=true, value="232")
        IInt zPrvtDifZAbert() ;
        
        @Data(size=3, signed=true, value="233")
        IInt planoUtlzInexist() ;
        
        @Data(size=3, signed=true, value="234")
        IInt planoUtlzExist() ;
        
        @Data(size=3, signed=true, value="235")
        IInt durPrazOrigemInval() ;
        
        @Data(size=3, signed=true, value="236")
        IInt tabRegrasOverflow() ;
        
        @Data(size=3, signed=true, value="237")
        IInt dtNUltDiaUtilMes() ;
        
        @Data(size=3, signed=true, value="238")
        IInt dtNFimMesNatural() ;
        
        @Data(size=3, signed=true, value="239")
        IInt operSemDoMovim() ;
        
        @Data(size=3, signed=true, value="240")
        IInt prestExist() ;
        
        @Data(size=3, signed=true, value="241")
        IInt limAutrzExist() ;
        
        @Data(size=3, signed=true, value="242")
        IInt sldMovimExist() ;
        
        @Data(size=3, signed=true, value="243")
        IInt dtValorContrInval() ;
        
        @Data(size=3, signed=true, value="244")
        IInt zInstrAntZAbert() ;
        
        @Data(size=3, signed=true, value="245")
        IInt dtMovMenorDtSld() ;
        
        @Data(size=3, signed=true, value="246")
        IInt movimPosterInexist() ;
        
        @Data(size=3, signed=true, value="247")
        IInt evNEstImpAltCont() ;
        
        @Data(size=3, signed=true, value="248")
        IInt utizForaFaseNPerm() ;
        
        @Data(size=3, signed=true, value="249")
        IInt istzUtizDataExist() ;
        
        @Data(size=3, signed=true, value="250")
        IInt utlzDiaExist() ;
        
        @Data(size=3, signed=true, value="251")
        IInt gtloUtlzInxst() ;
        
        @Data(size=3, signed=true, value="252")
        IInt catlgNPermCond() ;
        
        @Data(size=3, signed=true, value="253")
        IInt plnSimExstente() ;
        
        @Data(size=3, signed=true, value="254")
        IInt plnSimInxt() ;
        
        @Data(size=3, signed=true, value="255")
        IInt dtEnviadaSupRegist() ;
        
        @Data(size=3, signed=true, value="256")
        IInt loteInexist() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-CTA-CHQ-ACTIVOS         PIC S9(3) VALUE +257.
         * Reservados... (FIM).
         * 05 B..K0001-CTA-COM-MOV             PIC S9(3) VALUE +259.
         */
        @Data(size=3, signed=true, value="260")
        IInt propNPermAltProd() ;
        
        @Data(size=3, signed=true, value="261")
        IInt zValorSupZProc() ;
        
        @Data(size=3, signed=true, value="262")
        IInt nPermActualLimAut() ;
        
        @Data(size=3, signed=true, value="263")
        IInt nPermAnularLimAut() ;
        
        @Data(size=3, signed=true, value="264")
        IInt opcrUtlVinculoVist() ;
        
        @Data(size=3, signed=true, value="265")
        IInt limAutInexDt() ;
        
        @Data(size=3, signed=true, value="266")
        IInt mtdoCalcNPermSiml() ;
        
        @Data(size=3, signed=true, value="267")
        IInt mCapUtiMaxNAlt() ;
        
        @Data(size=3, signed=true, value="268")
        IInt utizAmozRtzzPost() ;
        
        @Data(size=3, signed=true, value="269")
        IInt capUtidInfZero() ;
        
        @Data(size=3, signed=true, value="270")
        IInt gatOpNotfnd() ;
        
        @Data(size=3, signed=true, value="271")
        IInt mMovimNMultiplo() ;
        
        @Data(size=3, signed=true, value="272")
        IInt motivoBlqoNotfnd() ;
        
        @Data(size=3, signed=true, value="273")
        IInt comissPeriodNotfnd() ;
        
        @Data(size=3, signed=true, value="274")
        IInt zVencDifZAbert() ;
        
        @Data(size=3, signed=true, value="275")
        IInt codDesagrInvalido() ;
        
        @Data(size=3, signed=true, value="276")
        IInt comPerExistData() ;
        
        @Data(size=3, signed=true, value="277")
        IInt nAplNPostos() ;
        
        @Data(size=3, signed=true, value="278")
        IInt mMovIndisponivel() ;
        
        @Data(size=3, signed=true, value="279")
        IInt mMovMenorMin() ;
        
        @Data(size=3, signed=true, value="280")
        IInt mMovMaiorMax() ;
        
        @Data(size=3, signed=true, value="281")
        IInt dtFimMenorUltVenc() ;
        
        @Data(size=3, signed=true, value="282")
        IInt altUltCondesp() ;
        
        @Data(size=3, signed=true, value="283")
        IInt exstAplicCondesp() ;
        
        @Data(size=3, signed=true, value="284")
        IInt utilMovMntInv() ;
        
        @Data(size=3, signed=true, value="285")
        IInt origMovCredInv() ;
        
        @Data(size=3, signed=true, value="286")
        IInt txAplIgualTxCat() ;
        
        @Data(size=3, signed=true, value="287")
        IInt movimEstornoInxs() ;
        
        @Data(size=3, signed=true, value="288")
        IInt zMenorZVnctProx() ;
        
        @Data(size=3, signed=true, value="289")
        IInt zMaiorZProcess() ;
        
        @Data(size=3, signed=true, value="290")
        IInt sldoCapSupMontMax() ;
        
        @Data(size=3, signed=true, value="291")
        IInt opcrOicExist() ;
        
        @Data(size=3, signed=true, value="292")
        IInt planoManualInexist() ;
        
        @Data(size=3, signed=true, value="293")
        IInt estnZAberturaInv() ;
        
        @Data(size=3, signed=true, value="294")
        IInt denuncGbncExist() ;
        
        @Data(size=3, signed=true, value="295")
        IInt gtloDenunGbncInxst() ;
        
        @Data(size=3, signed=true, value="296")
        IInt trttNValido() ;
        
        @Data(size=3, signed=true, value="297")
        IInt opcrNConvencionados() ;
        
        @Data(size=3, signed=true, value="298")
        IInt opcrNPrincipal() ;
        
        @Data(size=3, signed=true, value="299")
        IInt gtloDenunGbncExit() ;
        
        @Data(size=3, signed=true, value="300")
        IInt dadosBonifOpInxs() ;
        
        @Data(size=3, signed=true, value="301")
        IInt dadosSemModificacao() ;
        
        @Data(size=3, signed=true, value="302")
        IInt gtloConvencInxst() ;
        
        @Data(size=3, signed=true, value="303")
        IInt qDiaRtazUltrap() ;
        
        @Data(size=3, signed=true, value="304")
        IInt operacaoRelacInxs() ;
        
        @Data(size=3, signed=true, value="305")
        IInt mMovEstnInv() ;
        
        @Data(size=3, signed=true, value="306")
        IInt movCapitalInxst() ;
        
        @Data(size=3, signed=true, value="307")
        IInt dataSupProxVenc() ;
        
        @Data(size=3, signed=true, value="308")
        IInt dtValorLiqAntInv() ;
        
        @Data(size=3, signed=true, value="309")
        IInt gatCapitalizInex() ;
        
        @Data(size=3, signed=true, value="310")
        IInt mtvoMovContLiqInv() ;
        
        @Data(size=3, signed=true, value="311")
        IInt movCtLiqInsuf() ;
        
        @Data(size=3, signed=true, value="312")
        IInt gatilhoRepetidoData() ;
        
        @Data(size=3, signed=true, value="313")
        IInt entdVigProxData() ;
        
        @Data(size=3, signed=true, value="314")
        IInt amozNPermtCarencia() ;
        
        @Data(size=3, signed=true, value="315")
        IInt mudfsSemFsSegu() ;
        
        @Data(size=3, signed=true, value="316")
        IInt amortSemCapUtil() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-ATRZ-M-SLDO-IND         PIC S9(3) VALUE +317.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="318")
        IInt gtloLiqAntInxst() ;
        
        @Data(size=3, signed=true, value="319")
        IInt gtloLiqAntExist() ;
        
        @Data(size=3, signed=true, value="320")
        IInt mUtdMaiorMCndz() ;
        
        @Data(size=3, signed=true, value="321")
        IInt movOperNAutorizado() ;
        
        @Data(size=3, signed=true, value="322")
        IInt dtIstzPlnAmozInv() ;
        
        @Data(size=3, signed=true, value="323")
        IInt instzNPermitida() ;
        
        @Data(size=3, signed=true, value="324")
        IInt agendComPlanoUtiz() ;
        
        @Data(size=3, signed=true, value="325")
        IInt dtIstzPlnJurosInv() ;
        
        @Data(size=3, signed=true, value="326")
        IInt dividaAlterada() ;
        
        @Data(size=3, signed=true, value="327")
        IInt gatCobrancaExist() ;
        
        @Data(size=3, signed=true, value="328")
        IInt nAplRelevRealizd() ;
        
        @Data(size=3, signed=true, value="329")
        IInt condContrExist() ;
        
        @Data(size=3, signed=true, value="330")
        IInt montMinSemMovAut() ;
        
        @Data(size=3, signed=true, value="331")
        IInt propNPermAltDo() ;
        
        @Data(size=3, signed=true, value="332")
        IInt movACobrDiaInex() ;
        
        @Data(size=3, signed=true, value="333")
        IInt montCobrSupDiv() ;
        
        @Data(size=3, signed=true, value="334")
        IInt gatCobrancaInexist() ;
        
        @Data(size=3, signed=true, value="335")
        IInt condContratObrgInx() ;
        
        @Data(size=3, signed=true, value="336")
        IInt formatacaoZnlvErrad() ;
        
        @Data(size=3, signed=true, value="337")
        IInt tabCmczOverflow() ;
        
        @Data(size=3, signed=true, value="338")
        IInt sitBonifInvalida() ;
        
        @Data(size=3, signed=true, value="339")
        IInt operacaoTitularizada() ;
        
        @Data(size=3, signed=true, value="340")
        IInt gatAfectDajInx() ;
        
        @Data(size=3, signed=true, value="341")
        IInt gatVencAntecInx() ;
        
        @Data(size=3, signed=true, value="342")
        IInt dtFimVencMenorUlt() ;
        
        @Data(size=3, signed=true, value="343")
        IInt cBancOicInvalido() ;
        
        @Data(size=3, signed=true, value="344")
        IInt cliNIntervBem() ;
        
        @Data(size=3, signed=true, value="345")
        IInt zPrimVencNValido() ;
        
        @Data(size=3, signed=true, value="346")
        IInt carNPAltPrzPCap() ;
        
        @Data(size=3, signed=true, value="347")
        IInt perJurMaiorPerCap() ;
        
        @Data(size=3, signed=true, value="348")
        IInt erroCalculoTir() ;
        
        @Data(size=3, signed=true, value="349")
        IInt dtValorInfDtAbert() ;
        
        @Data(size=3, signed=true, value="350")
        IInt tabDetalheNotaDeb() ;
        
        @Data(size=3, signed=true, value="351")
        IInt opTtlzNAltProdB() ;
        
        @Data(size=3, signed=true, value="352")
        IInt naoAvancouZEventos() ;
        
        @Data(size=3, signed=true, value="353")
        IInt metCalcCapitalInxs() ;
        
        @Data(size=3, signed=true, value="354")
        IInt metCalcJuroInxs() ;
        
        @Data(size=3, signed=true, value="355")
        IInt linhaBonificInxs() ;
        
        @Data(size=3, signed=true, value="356")
        IInt tipoTaxaInxs() ;
        
        @Data(size=3, signed=true, value="357")
        IInt tipoSpreadInxs() ;
        
        @Data(size=3, signed=true, value="359")
        IInt cdPerJurosNotfnd() ;
        
        @Data(size=3, signed=true, value="360")
        IInt cdPerCapitNotfnd() ;
        
        @Data(size=3, signed=true, value="361")
        IInt cdMetCJurNotfnd() ;
        
        @Data(size=3, signed=true, value="362")
        IInt cdMetCCapNotfnd() ;
        
        @Data(size=3, signed=true, value="363")
        IInt cdCapitalizNotfnd() ;
        
        @Data(size=3, signed=true, value="364")
        IInt cdPerComisNotfnd() ;
        
        @Data(size=3, signed=true, value="365")
        IInt cdLinBonifNotfnd() ;
        
        @Data(size=3, signed=true, value="366")
        IInt inicPrzCdTxCat() ;
        
        @Data(size=3, signed=true, value="367")
        IInt inicPrzCdPerJCat() ;
        
        @Data(size=3, signed=true, value="368")
        IInt inicPrzCdPerCCat() ;
        
        @Data(size=3, signed=true, value="369")
        IInt inicPrzCdMetJCat() ;
        
        @Data(size=3, signed=true, value="370")
        IInt inicPrzCdMetCCat() ;
        
        @Data(size=3, signed=true, value="371")
        IInt inicPrzCdCapitCat() ;
        
        @Data(size=3, signed=true, value="372")
        IInt inicPrzCdPrCoCat() ;
        
        @Data(size=3, signed=true, value="373")
        IInt inicPrzCdBonifCat() ;
        
        @Data(size=3, signed=true, value="374")
        IInt catNPermPerJur() ;
        
        @Data(size=3, signed=true, value="375")
        IInt catNPermPerCap() ;
        
        @Data(size=3, signed=true, value="376")
        IInt catNPermPerCom() ;
        
        @Data(size=3, signed=true, value="377")
        IInt catNPermMetJur() ;
        
        @Data(size=3, signed=true, value="378")
        IInt catNPermMetCap() ;
        
        @Data(size=3, signed=true, value="379")
        IInt catNPermCapital() ;
        
        @Data(size=3, signed=true, value="380")
        IInt catNPermLBonif() ;
        
        @Data(size=3, signed=true, value="381")
        IInt catNPermCdTaxa() ;
        
        @Data(size=3, signed=true, value="382")
        IInt altNPermForaAnuid() ;
        
        @Data(size=3, signed=true, value="383")
        IInt exComPerDifInser() ;
        
        @Data(size=3, signed=true, value="384")
        IInt pendenteCobrado() ;
        
        @Data(size=3, signed=true, value="385")
        IInt montPlnoInvalido() ;
        
        @Data(size=3, signed=true, value="386")
        IInt numInstrMaiorMax() ;
        
        @Data(size=3, signed=true, value="387")
        IInt numInstrMenorMin() ;
        
        @Data(size=3, signed=true, value="388")
        IInt plnoAmozIcnt() ;
        
        @Data(size=3, signed=true, value="389")
        IInt plnoUtizIcnt() ;
        
        @Data(size=3, signed=true, value="390")
        IInt comPerNAplProd() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-SLD-CATIVAR-INSUF       PIC S9(3) VALUE +391.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="392")
        IInt trzFaseUtlTot() ;
        
        @Data(size=3, signed=true, value="393")
        IInt opSemGartInexBalc() ;
        
        @Data(size=3, signed=true, value="394")
        IInt nPrmtDenunciaGbnc() ;
        
        @Data(size=3, signed=true, value="395")
        IInt nPermAnulCgd() ;
        
        @Data(size=3, signed=true, value="396")
        IInt zTrfcMaiorZAbert() ;
        
        @Data(size=3, signed=true, value="397")
        IInt cBondMaiorCCttd() ;
        
        @Data(size=3, signed=true, value="398")
        IInt prioRotzInvalida() ;
        
        @Data(size=3, signed=true, value="399")
        IInt periodRotzLosdInv() ;
        
        @Data(size=3, signed=true, value="400")
        IInt gatPerdDividaInx() ;
        
        /**
         * Modulo FS - Inicio ......................................
         */
        @Data(size=3, signed=true, value="401")
        IInt tipoSegInvalido() ;
        
        @Data(size=3, signed=true, value="402")
        IInt valEmprMalFormato() ;
        
        @Data(size=3, signed=true, value="403")
        IInt prazoMalFormatado() ;
        
        @Data(size=3, signed=true, value="404")
        IInt numTomadMalFormt() ;
        
        @Data(size=3, signed=true, value="405")
        IInt idadTomad1MalForm() ;
        
        @Data(size=3, signed=true, value="406")
        IInt idadTomad1Invalida() ;
        
        @Data(size=3, signed=true, value="407")
        IInt idadTomad2MalForm() ;
        
        @Data(size=3, signed=true, value="408")
        IInt idadTomad2Invalida() ;
        
        @Data(size=3, signed=true, value="409")
        IInt iCredicaixaMalForm() ;
        
        @Data(size=3, signed=true, value="410")
        IInt iAnuidadeMalFormt() ;
        
        @Data(size=3, signed=true, value="411")
        IInt numDias1AnuidInv() ;
        
        @Data(size=3, signed=true, value="412")
        IInt tipCobertMalForm() ;
        
        @Data(size=3, signed=true, value="413")
        IInt taxaInxstTbVfs04() ;
        
        @Data(size=3, signed=true, value="414")
        IInt erroOpenCursor() ;
        
        @Data(size=3, signed=true, value="415")
        IInt erroFecthCursor() ;
        
        @Data(size=3, signed=true, value="416")
        IInt erroCloseCursor() ;
        
        /**
         * Modulo FS - Fim .........................................
         */
        @Data(size=3, signed=true, value="417")
        IInt opcrNSindbanc() ;
        
        @Data(size=3, signed=true, value="418")
        IInt cOpeBbnAnlzNFrmt() ;
        
        @Data(size=3, signed=true, value="419")
        IInt condContrNApOpcr() ;
        
        @Data(size=3, signed=true, value="420")
        IInt obrCcProcEntEx() ;
        
        @Data(size=3, signed=true, value="421")
        IInt fRspeInvalida() ;
        
        @Data(size=3, signed=true, value="422")
        IInt instSindExiste() ;
        
        @Data(size=3, signed=true, value="423")
        IInt dtAnteriorAbert() ;
        
        @Data(size=3, signed=true, value="424")
        IInt txDefCatNeg() ;
        
        @Data(size=3, signed=true, value="425")
        IInt mEncgFixoZero() ;
        
        @Data(size=3, signed=true, value="426")
        IInt txNegUltrapLimCat() ;
        
        @Data(size=3, signed=true, value="427")
        IInt dtPrestInvalida() ;
        
        @Data(size=3, signed=true, value="428")
        IInt sprNegUltrLimCat() ;
        
        @Data(size=3, signed=true, value="429")
        IInt movAbatActivNotfnd() ;
        
        @Data(size=3, signed=true, value="430")
        IInt condDinTaxMoraInx() ;
        
        @Data(size=3, signed=true, value="431")
        IInt altInvAntZUltVen() ;
        
        @Data(size=3, signed=true, value="432")
        IInt opcrBlqoCbrcRmnz() ;
        
        @Data(size=3, signed=true, value="433")
        IInt tipoTrttEncgInval() ;
        
        @Data(size=3, signed=true, value="434")
        IInt alteracaoProdNPerm() ;
        
        @Data(size=3, signed=true, value="435")
        IInt dtValorInfDtRemu() ;
        
        @Data(size=3, signed=true, value="436")
        IInt movNaoImputCredito() ;
        
        @Data(size=3, signed=true, value="437")
        IInt datEntVigSupCanc() ;
        
        @Data(size=3, signed=true, value="438")
        IInt tipoMovNContab() ;
        
        @Data(size=3, signed=true, value="439")
        IInt movImputBonExist() ;
        
        @Data(size=3, signed=true, value="440")
        IInt sbtzProdImputBon() ;
        
        /**
         * Modulo Movimentacao FS - Inicio .............................
         */
        @Data(size=3, signed=true, value="441")
        IInt balcMovMalFormat() ;
        
        @Data(size=3, signed=true, value="442")
        IInt montanteInvalido() ;
        
        @Data(size=3, signed=true, value="443")
        IInt indMovimMalForm() ;
        
        @Data(size=3, signed=true, value="444")
        IInt dataMovimInvalida() ;
        
        @Data(size=3, signed=true, value="445")
        IInt dataMovimMalForm() ;
        
        @Data(size=3, signed=true, value="446")
        IInt tipoSeguroMalForm() ;
        
        @Data(size=3, signed=true, value="447")
        IInt codTermMalFormatad() ;
        
        @Data(size=3, signed=true, value="448")
        IInt tipoSeguroInexist() ;
        
        @Data(size=3, signed=true, value="449")
        IInt erroSelect() ;
        
        @Data(size=3, signed=true, value="450")
        IInt erroCreditoCtaDo() ;
        
        @Data(size=3, signed=true, value="451")
        IInt erroDebitoCtaDo() ;
        
        @Data(size=3, signed=true, value="452")
        IInt emprestimoInvalido() ;
        
        @Data(size=3, signed=true, value="453")
        IInt valContratadoInval() ;
        
        @Data(size=3, signed=true, value="454")
        IInt codPrazoInvalido() ;
        
        @Data(size=3, signed=true, value="455")
        IInt bnka0001ContaDoInvalida() ;
        
        /**
         * *IS 2005-12-12 - Alteracao do descritivo INI
         * 05 BNAK0001-CLIENTE-INVALIDO        PIC S9(3) VALUE +456.
         */
        @Data(size=3, signed=true, value="456")
        IInt clienteInvalidoFs() ;
        
        /**
         * *IS 2005-12-12 FIM
         */
        @Data(size=3, signed=true, value="457")
        IInt seguroJaExistente() ;
        
        @Data(size=3, signed=true, value="458")
        IInt obrPreenchNEmpreg() ;
        
        @Data(size=3, signed=true, value="459")
        IInt acessoTiposSeguros() ;
        
        @Data(size=3, signed=true, value="460")
        IInt acessoContabSgop() ;
        
        @Data(size=3, signed=true, value="461")
        IInt contSProvisaoSgop() ;
        
        @Data(size=3, signed=true, value="462")
        IInt acessoTxCredicaixa() ;
        
        @Data(size=3, signed=true, value="463")
        IInt prazoEmprInvalido() ;
        
        @Data(size=3, signed=true, value="464")
        IInt idadeForaParamt() ;
        
        @Data(size=3, signed=true, value="465")
        IInt numContribInval() ;
        
        @Data(size=3, signed=true, value="466")
        IInt erroInsPropEntrg() ;
        
        @Data(size=3, signed=true, value="467")
        IInt balcaoMovimInval() ;
        
        @Data(size=3, signed=true, value="468")
        IInt historicoPropostas() ;
        
        @Data(size=3, signed=true, value="469")
        IInt acessoAEntregas() ;
        
        @Data(size=3, signed=true, value="470")
        IInt dtMovimForaPrmt() ;
        
        @Data(size=3, signed=true, value="471")
        IInt updFfs009() ;
        
        @Data(size=3, signed=true, value="472")
        IInt vlEntrForaPrmt() ;
        
        @Data(size=3, signed=true, value="473")
        IInt vlEntrSupPlafond() ;
        
        @Data(size=3, signed=true, value="474")
        IInt estrVlEntrNPrch() ;
        
        @Data(size=3, signed=true, value="475")
        IInt valorEntrNPreench() ;
        
        @Data(size=3, signed=true, value="476")
        IInt tpSegExistEmprest() ;
        
        @Data(size=3, signed=true, value="477")
        IInt erroDeleteRopostas() ;
        
        /**
         * Modulo Movimentacao FS - Fim ................................
         */
        @Data(size=3, signed=true, value="478")
        IInt reclamacLoteAutomtc() ;
        
        @Data(size=3, signed=true, value="479")
        IInt pagamentLoteAutomtc() ;
        
        @Data(size=3, signed=true, value="480")
        IInt sitMapaNPermReclm() ;
        
        @Data(size=3, signed=true, value="481")
        IInt sitLoteNPermAccao() ;
        
        @Data(size=3, signed=true, value="482")
        IInt catObrigaPerJur() ;
        
        @Data(size=3, signed=true, value="483")
        IInt catObrigaPerCap() ;
        
        @Data(size=3, signed=true, value="484")
        IInt catObrigaMetJur() ;
        
        @Data(size=3, signed=true, value="485")
        IInt catObrigaMetCap() ;
        
        @Data(size=3, signed=true, value="486")
        IInt catObrigaCapital() ;
        
        @Data(size=3, signed=true, value="487")
        IInt catObrigaLBonif() ;
        
        @Data(size=3, signed=true, value="488")
        IInt catObrigaCdTaxa() ;
        
        @Data(size=3, signed=true, value="489")
        IInt agdorSemCapDpn() ;
        
        @Data(size=3, signed=true, value="490")
        IInt impBonifOutraOrig() ;
        
        @Data(size=3, signed=true, value="491")
        IInt zValorSupZCancel() ;
        
        @Data(size=3, signed=true, value="492")
        IInt bonzNDependeRab() ;
        
        @Data(size=3, signed=true, value="493")
        IInt prstMntNPermSimul() ;
        
        @Data(size=3, signed=true, value="494")
        IInt ultlNPermConvenc() ;
        
        @Data(size=3, signed=true, value="495")
        IInt gatRepHistExiste() ;
        
        @Data(size=3, signed=true, value="496")
        IInt capitalzNaoPermitid() ;
        
        @Data(size=3, signed=true, value="497")
        IInt impAgAltPrzProp() ;
        
        @Data(size=3, signed=true, value="498")
        IInt nExtDados() ;
        
        @Data(size=3, signed=true, value="499")
        IInt segurosComTomadores() ;
        
        @Data(size=3, signed=true, value="500")
        IInt dataInfUltVenc() ;
        
        @Data(size=3, signed=true, value="501")
        IInt produtoNaoSimulavel() ;
        
        @Data(size=3, signed=true, value="502")
        IInt impAltCntAgndUtlz() ;
        
        @Data(size=3, signed=true, value="503")
        IInt impAltCntAgndAmoz() ;
        
        @Data(size=3, signed=true, value="504")
        IInt przOpcrMnMinLqz() ;
        
        @Data(size=3, signed=true, value="505")
        IInt zCancelInvalid() ;
        
        @Data(size=3, signed=true, value="506")
        IInt ctlObgrMdFsUtlzT() ;
        
        @Data(size=3, signed=true, value="507")
        IInt ctlNPermMdFase() ;
        
        @Data(size=3, signed=true, value="508")
        IInt opcrNGbncBanc() ;
        
        @Data(size=3, signed=true, value="509")
        IInt titularInexst() ;
        
        @Data(size=3, signed=true, value="510")
        IInt benefeciarioInexst() ;
        
        @Data(size=3, signed=true, value="511")
        IInt dtVencSupDtFimFs() ;
        
        @Data(size=3, signed=true, value="512")
        IInt acNPermitidaInstr() ;
        
        @Data(size=3, signed=true, value="513")
        IInt nExistMovimCobr() ;
        
        @Data(size=3, signed=true, value="514")
        IInt mInvtOrigInfMPed() ;
        
        @Data(size=3, signed=true, value="515")
        IInt prazoMaxAnular() ;
        
        @Data(size=3, signed=true, value="516")
        IInt exstMovAbateActivo() ;
        
        @Data(size=3, signed=true, value="517")
        IInt operForaFaseAmort() ;
        
        @Data(size=3, signed=true, value="518")
        IInt existePerCarDef() ;
        
        @Data(size=3, signed=true, value="519")
        IInt perCarNaoDefin() ;
        
        @Data(size=3, signed=true, value="520")
        IInt paramPerCarIncoer() ;
        
        @Data(size=3, signed=true, value="521")
        IInt perCarMaiorMaxCat() ;
        
        @Data(size=3, signed=true, value="522")
        IInt entdVigCdPerCarc() ;
        
        @Data(size=3, signed=true, value="523")
        IInt impEstAntPerCarc() ;
        
        @Data(size=3, signed=true, value="524")
        IInt paramFsDifInxs() ;
        
        @Data(size=3, signed=true, value="525")
        IInt mudfsImpMntDisp() ;
        
        @Data(size=3, signed=true, value="526")
        IInt impElimCondCatlg() ;
        
        @Data(size=3, signed=true, value="527")
        IInt impLiqAntInterc() ;
        
        @Data(size=3, signed=true, value="528")
        IInt proOpcrCreNInterc() ;
        
        @Data(size=3, signed=true, value="529")
        IInt prOpcrAssNCreHab() ;
        
        @Data(size=3, signed=true, value="530")
        IInt grtOprAsscMaisEfi() ;
        
        @Data(size=3, signed=true, value="531")
        IInt opcrNPermPerCar() ;
        
        @Data(size=3, signed=true, value="532")
        IInt montOpcrAssSupMax() ;
        
        @Data(size=3, signed=true, value="533")
        IInt dtCanOpcrSupPermt() ;
        
        @Data(size=3, signed=true, value="534")
        IInt mExcLimGart() ;
        
        @Data(size=3, signed=true, value="535")
        IInt cProdEspOpcrInval() ;
        
        @Data(size=3, signed=true, value="536")
        IInt incidInvalComAnt() ;
        
        @Data(size=3, signed=true, value="537")
        IInt perCarMenorVncCap() ;
        
        @Data(size=3, signed=true, value="538")
        IInt naoExistemOperReld() ;
        
        @Data(size=3, signed=true, value="539")
        IInt montIntSupMaxPerm() ;
        
        @Data(size=3, signed=true, value="540")
        IInt semComissaoDevolver() ;
        
        @Data(size=3, signed=true, value="541")
        IInt nEnvioRelFnEntEx() ;
        
        @Data(size=3, signed=true, value="542")
        IInt prmtzPrzInct() ;
        
        @Data(size=3, signed=true, value="543")
        IInt credIntcSmOpcrRld() ;
        
        @Data(size=3, signed=true, value="544")
        IInt faltEstbUmaRldObg() ;
        
        @Data(size=3, signed=true, value="545")
        IInt rlMultCrdobrNEfef() ;
        
        @Data(size=3, signed=true, value="546")
        IInt opcrNCrtzTitulariz() ;
        
        @Data(size=3, signed=true, value="547")
        IInt dtFimNSupDataIni() ;
        
        @Data(size=3, signed=true, value="548")
        IInt impAnzlRelAgrd() ;
        
        @Data(size=3, signed=true, value="549")
        IInt codTtlzInval() ;
        
        @Data(size=3, signed=true, value="550")
        IInt estnPrimUtzPrzDes() ;
        
        @Data(size=3, signed=true, value="551")
        IInt numOperMaiorMax48() ;
        
        @Data(size=3, signed=true, value="552")
        IInt fimUtizCRdzLmTot() ;
        
        @Data(size=3, signed=true, value="553")
        IInt modNPermitidaAgend() ;
        
        @Data(size=3, signed=true, value="554")
        IInt impAnulMovAntTit() ;
        
        @Data(size=3, signed=true, value="555")
        IInt zDiaSupZFimTtlz() ;
        
        @Data(size=3, signed=true, value="556")
        IInt recalReclassAltPrz() ;
        
        @Data(size=3, signed=true, value="557")
        IInt sitFncNperAltIncp() ;
        
        @Data(size=3, signed=true, value="558")
        IInt capVincNegativo() ;
        
        @Data(size=3, signed=true, value="559")
        IInt calcPrestValorNeg() ;
        
        @Data(size=3, signed=true, value="560")
        IInt movContLiqNPoupH() ;
        
        @Data(size=3, signed=true, value="561")
        IInt movContLiqPoupHab() ;
        
        @Data(size=3, signed=true, value="562")
        IInt exPendentCobranca() ;
        
        @Data(size=3, signed=true, value="563")
        IInt plnoAmozExistente() ;
        
        @Data(size=3, signed=true, value="564")
        IInt sldMovimInexist() ;
        
        @Data(size=3, signed=true, value="565")
        IInt instrInexist() ;
        
        @Data(size=3, signed=true, value="566")
        IInt qUtizCapMaxEsg() ;
        
        @Data(size=3, signed=true, value="567")
        IInt cliIntervSegMForm() ;
        
        @Data(size=3, signed=true, value="568")
        IInt dataValAntIniAmoz() ;
        
        @Data(size=3, signed=true, value="569")
        IInt dtIfadapDifDtCgd() ;
        
        @Data(size=3, signed=true, value="570")
        IInt opcrCgdNContrad() ;
        
        @Data(size=3, signed=true, value="571")
        IInt bonifObrigPrestPr() ;
        
        @Data(size=3, signed=true, value="572")
        IInt sitInvalOpcrInterc() ;
        
        @Data(size=3, signed=true, value="573")
        IInt mGbncInvalido() ;
        
        @Data(size=3, signed=true, value="574")
        IInt limNaoPermitidGbnc() ;
        
        @Data(size=3, signed=true, value="575")
        IInt utlzNaoPermitdGbnc() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-ERR-LIM-MOV             PIC S9(3) VALUE +576.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="577")
        IInt amzNaoPermitdProd() ;
        
        @Data(size=3, signed=true, value="578")
        IInt condespEncSobrep() ;
        
        @Data(size=3, signed=true, value="579")
        IInt impAgendUtlz() ;
        
        @Data(size=3, signed=true, value="580")
        IInt impBonifJaAnulada() ;
        
        @Data(size=3, signed=true, value="581")
        IInt elimObrEstornoPrev() ;
        
        @Data(size=3, signed=true, value="582")
        IInt operLiqAntecipada() ;
        
        @Data(size=3, signed=true, value="583")
        IInt comissPerVencPost() ;
        
        @Data(size=3, signed=true, value="584")
        IInt impSeloVencPost() ;
        
        @Data(size=3, signed=true, value="585")
        IInt capDifdMaiorMax() ;
        
        @Data(size=3, signed=true, value="586")
        IInt capDifdMenorMin() ;
        
        @Data(size=3, signed=true, value="587")
        IInt altrProdAnulImp() ;
        
        @Data(size=3, signed=true, value="588")
        IInt dtComissDtGbnc() ;
        
        @Data(size=3, signed=true, value="589")
        IInt zObtTaxaInvalida() ;
        
        @Data(size=3, signed=true, value="590")
        IInt evntNProcessados() ;
        
        @Data(size=3, signed=true, value="591")
        IInt erroPrazoIncoernt() ;
        
        @Data(size=3, signed=true, value="592")
        IInt prodNTrfrOic() ;
        
        @Data(size=3, signed=true, value="593")
        IInt sinlSpreCatInval() ;
        
        @Data(size=3, signed=true, value="594")
        IInt sindicatoSemLider() ;
        
        @Data(size=3, signed=true, value="595")
        IInt opcrEstProposta() ;
        
        @Data(size=3, signed=true, value="596")
        IInt movNaoImputOpcr() ;
        
        @Data(size=3, signed=true, value="597")
        IInt pedidoIsJurosMora() ;
        
        @Data(size=3, signed=true, value="598")
        IInt numLiderSupUm() ;
        
        @Data(size=3, signed=true, value="599")
        IInt sindSemInstRetImp() ;
        
        @Data(size=3, signed=true, value="600")
        IInt altMcCNPermit() ;
        
        @Data(size=3, signed=true, value="601")
        IInt altMcJNPermit() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-MONT-CMRG-N-STND        PIC S9(3) VALUE +602.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="603")
        IInt valorObrigCalEncg() ;
        
        @Data(size=3, signed=true, value="604")
        IInt comPerObrigNotfnd() ;
        
        @Data(size=3, signed=true, value="605")
        IInt taxaNaoAplicOpcr() ;
        
        @Data(size=3, signed=true, value="606")
        IInt zFimVldeInvalid() ;
        
        @Data(size=3, signed=true, value="607")
        IInt vencManSemProcEvt() ;
        
        @Data(size=3, signed=true, value="608")
        IInt zVencNAplicProd() ;
        
        @Data(size=3, signed=true, value="609")
        IInt exstLimAutObrig() ;
        
        @Data(size=3, signed=true, value="610")
        IInt tipoFormalzInc() ;
        
        @Data(size=3, signed=true, value="611")
        IInt mMovAmozIndisp() ;
        
        @Data(size=3, signed=true, value="612")
        IInt zValEstnPostVenc() ;
        
        @Data(size=3, signed=true, value="613")
        IInt plnoJuroIcnt() ;
        
        @Data(size=3, signed=true, value="614")
        IInt gatAfectDajExist() ;
        
        @Data(size=3, signed=true, value="615")
        IInt gatVencAntecExist() ;
        
        @Data(size=3, signed=true, value="616")
        IInt gatPerdDividaExist() ;
        
        @Data(size=3, signed=true, value="617")
        IInt paramCatlgDescnhcd() ;
        
        @Data(size=3, signed=true, value="618")
        IInt zSbtzApurInval() ;
        
        @Data(size=3, signed=true, value="619")
        IInt emsMapaLoteAutomtc() ;
        
        /**
         * *IS 2005-12-12 INI
         */
        @Data(size=3, signed=true, value="620")
        IInt dtComissDtAdaj() ;
        
        @Data(size=3, signed=true, value="621")
        IInt impAnSAnulAgrd() ;
        
        @Data(size=3, signed=true, value="622")
        IInt impAnSAnulAgdor() ;
        
        @Data(size=3, signed=true, value="623")
        IInt simulaProdSemSegur() ;
        
        @Data(size=3, signed=true, value="624")
        IInt impAmozSAnulAgdor() ;
        
        @Data(size=3, signed=true, value="625")
        IInt coefMontSoltInvt() ;
        
        @Data(size=3, signed=true, value="626")
        IInt impUtilizDtCont() ;
        
        @Data(size=3, signed=true, value="627")
        IInt existAmozContPoup() ;
        
        /**
         * Reservados... (INI).
         * 05 B..K0001-SCTA-COM-PREMIOS        PIC S9(3) VALUE +628.
         * Reservados... (FIM).
         */
        @Data(size=3, signed=true, value="629")
        IInt plnAutObrgUtlz() ;
        
        @Data(size=3, signed=true, value="630")
        IInt mtdCapObrgPerMens() ;
        
        @Data(size=3, signed=true, value="631")
        IInt przNMultplSemestre() ;
        
        /**
         * *IS 2005-12-12 FIM
         */
        @Data(size=3, signed=true, value="632")
        IInt perCapInconPerJur() ;
        
        @Data(size=3, signed=true, value="633")
        IInt sitOpcrRldInvalida() ;
        
        @Data(size=3, signed=true, value="634")
        IInt opcrSemTitCoinc() ;
        
        @Data(size=3, signed=true, value="635")
        IInt impElimFaseDtCont() ;
        
        @Data(size=3, signed=true, value="636")
        IInt dtPrimUtlzInval() ;
        
        @Data(size=3, signed=true, value="637")
        IInt ctlgObrgUtlzContr() ;
        
        @Data(size=3, signed=true, value="638")
        IInt utilNAutNegDesc() ;
        
        @Data(size=3, signed=true, value="639")
        IInt utilNAutNegCtrl() ;
        
        @Data(size=3, signed=true, value="640")
        IInt utlDspNPreenchido() ;
        
        @Data(size=3, signed=true, value="641")
        IInt utilDespSemAut() ;
        
        @Data(size=3, signed=true, value="642")
        IInt cphSemTitOp() ;
        
        @Data(size=3, signed=true, value="643")
        IInt opcrCredNAprov() ;
        
        @Data(size=3, signed=true, value="644")
        IInt erroSelTna18() ;
        
        @Data(size=3, signed=true, value="645")
        IInt tna18Notfnd() ;
        
        @Data(size=3, signed=true, value="646")
        IInt erroInsertTna18() ;
        
        @Data(size=3, signed=true, value="647")
        IInt erroUpdateTna18() ;
        
        @Data(size=3, signed=true, value="648")
        IInt segObrig() ;
        
        @Data(size=3, signed=true, value="649")
        IInt mapCodInex() ;
        
        @Data(size=3, signed=true, value="650")
        IInt tabLogInex() ;
        
        @Data(size=3, signed=true, value="651")
        IInt insRegExistTna061() ;
        
        @Data(size=3, signed=true, value="652")
        IInt reporDados() ;
        
        @Data(size=3, signed=true, value="653")
        IInt cdivOicInfMCttd() ;
        
        @Data(size=3, signed=true, value="656")
        IInt utilizBloqCpd() ;
        
        @Data(size=3, signed=true, value="657")
        IInt amortzBloqCpd() ;
        
        @Data(size=3, signed=true, value="658")
        IInt nPermCpd() ;
        
        /**
         * Operacoes GAT - Ini
         */
        @Data(size=3, signed=true, value="659")
        IInt utlNPermGat() ;
        
        @Data(size=3, signed=true, value="660")
        IInt amtzNPermGat() ;
        
        @Data(size=3, signed=true, value="661")
        IInt lqdzNPermGat() ;
        
        @Data(size=3, signed=true, value="662")
        IInt estNPermGat() ;
        
        /**
         * Operacoes GAT - Fim
         */
        @Data(size=3, signed=true, value="663")
        IInt ccCpdsUtiliz() ;
        
        /**
         * Modulo Movimentacao FS - Ini ................................
         */
        @Data(size=3, signed=true, value="664")
        IInt codImgJourNNum() ;
        
        @Data(size=3, signed=true, value="665")
        IInt codCnlAcssNNum() ;
        
        @Data(size=3, signed=true, value="666")
        IInt numJournNNum() ;
        
        @Data(size=3, signed=true, value="667")
        IInt nsJournNNum() ;
        
        @Data(size=3, signed=true, value="668")
        IInt journEstNNum() ;
        
        @Data(size=3, signed=true, value="669")
        IInt codUtlzNPreench() ;
        
        @Data(size=3, signed=true, value="670")
        IInt codEventoNPreen() ;
        
        @Data(size=3, signed=true, value="671")
        IInt idCrivoNNum() ;
        
        @Data(size=3, signed=true, value="672")
        IInt idCrivoMenorPerm() ;
        
        /**
         * Modulo Movimentacao FS - Fim ................................
         */
        @Data(size=3, signed=true, value="673")
        IInt prazoCarMenorMin() ;
        
        @Data(size=3, signed=true, value="674")
        IInt prazoCarMaiorMax() ;
        
        @Data(size=3, signed=true, value="675")
        IInt perdaoParcialExec() ;
        
        @Data(size=3, signed=true, value="676")
        IInt perdaoNaoLiquida() ;
        
        @Data(size=3, signed=true, value="677")
        IInt clasBonifNAtrib() ;
        
        @Data(size=3, signed=true, value="678")
        IInt erroCritCssl() ;
        
        @Data(size=3, signed=true, value="679")
        IInt insRegExistTna062() ;
        
        @Data(size=3, signed=true, value="680")
        IInt erroUpdateTna62() ;
        
        @Data(size=3, signed=true, value="681")
        IInt insRegExistTna063() ;
        
        @Data(size=3, signed=true, value="682")
        IInt erroUpdateTna63() ;
        
        @Data(size=3, signed=true, value="684")
        IInt impLiqTrfIntCgd() ;
        
        @Data(size=3, signed=true, value="685")
        IInt impLiqComPendentes() ;
        
        @Data(size=3, signed=true, value="686")
        IInt nvPrzDgtNMultiplo() ;
        
        @Data(size=3, signed=true, value="687")
        IInt opcrDgtNEstaAnuid() ;
        
        @Data(size=3, signed=true, value="688")
        IInt idadeInexistente() ;
        
        @Data(size=3, signed=true, value="689")
        IInt idade3tomMalFormat() ;
        
        @Data(size=3, signed=true, value="690")
        IInt idadeTom3MalInv() ;
        
        @Data(size=3, signed=true, value="691")
        IInt idade4tomMalFormat() ;
        
        @Data(size=3, signed=true, value="692")
        IInt idadeTom4MalInv() ;
        
        @Data(size=3, signed=true, value="693")
        IInt opMoratEmDivida() ;
        
        @Data(size=3, signed=true, value="694")
        IInt operNaoMoratoria() ;
        
        @Data(size=3, signed=true, value="695")
        IInt dtAberDifDtVnct() ;
        
        @Data(size=3, signed=true, value="696")
        IInt operRelInvalida() ;
        
        @Data(size=3, signed=true, value="697")
        IInt bonifNaoDecres() ;
        
        @Data(size=3, signed=true, value="698")
        IInt nExisDeclDesemp() ;
        
        @Data(size=3, signed=true, value="699")
        IInt dadosPortNAlter() ;
        
        @Data(size=3, signed=true, value="700")
        IInt altPortNPerm() ;
        
        @Data(size=3, signed=true, value="701")
        IInt opcrDgtNaoPrxAnui() ;
        
        @Data(size=3, signed=true, value="702")
        IInt mMenorMPrevDef() ;
        
        @Data(size=3, signed=true, value="703")
        IInt alterProdAntPrim() ;
        
        @Data(size=3, signed=true, value="704")
        IInt txCttlSupTxUsra() ;
        
        @Data(size=3, signed=true, value="705")
        IInt opcrBlqoCalcJmor() ;
        
        @Data(size=3, signed=true, value="706")
        IInt critCsslNRecup() ;
        
        @Data(size=3, signed=true, value="707")
        IInt altAnuiOic1aPrsz() ;
        
        @Data(size=3, signed=true, value="708")
        IInt verifAnuiOic() ;
        
        @Data(size=3, signed=true, value="709")
        IInt zInicInfZUltVenc() ;
        
        @Data(size=3, signed=true, value="710")
        IInt zFimInfZProxVenc() ;
        
        @Data(size=3, signed=true, value="711")
        IInt przSimInvalido() ;
        
        @Data(size=3, signed=true, value="712")
        IInt dataSimInvalida() ;
        
        @Data(size=3, signed=true, value="713")
        IInt altInvAntZUltAnu() ;
        
        @Data(size=3, signed=true, value="714")
        IInt tabAtingiuLimite() ;
        
        @Data(size=3, signed=true, value="732")
        IInt espContrInxst() ;
        
        @Data(size=3, signed=true, value="734")
        IInt afNElegivOpcr() ;
        
        @Data(size=3, signed=true, value="735")
        IInt fineCredInvalida() ;
        
        @Data(size=3, signed=true, value="736")
        IInt rcInfRcMin() ;
        
        @Data(size=3, signed=true, value="737")
        IInt movCcifNPermAnu() ;
        
        @Data(size=3, signed=true, value="738")
        IInt ordensAssocPend() ;
        
        @Data(size=3, signed=true, value="739")
        IInt exstPpAssociados() ;
        
        @Data(size=3, signed=true, value="740")
        IInt atrzValDfltCtrlRc() ;
        
        @Data(size=3, signed=true, value="842")
        IInt zCapIgualProxVenc() ;
        
        @Data(size=3, signed=true, value="845")
        IInt rnvzAutNPermitida02() ;
        
        @Data(size=3, signed=true, value="846")
        IInt prodNPermModif() ;
        
        /**
         * NA21686 - DL58 - INI
         */
        @Data(size=3, signed=true, value="925")
        IInt moratVencExist() ;
        
        @Data(size=3, signed=true, value="980")
        IInt perMin3Meses() ;
        
        /**
         * NA21686 - DL58 - FIM
         */
        @Data(size=3, signed=true, value="973")
        IInt erroActualizeScrg() ;
        
        @Data(size=3, signed=true, value="974")
        IInt sprScrgNPermit() ;
        
        /**
         * NA30184 - INICIO
         */
        @Data(size=3, signed=true, value="754")
        IInt autAmrtizDiaNUtil() ;
        
    }
    
}
