package cgd.ho.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhok0001 extends IDataStruct {
    
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
     * BHOK0001   CONSTANTES COM CODIGOS DE ERRO 'HO'
     * 
     * @version 2.0
     * 
     */
    public interface Erros extends IDataStruct {
        
        /**
         * *** HO001 = AVISO NAO EXISTE
         */
        @Data(size=3, signed=true, value="1")
        IInt avisoNaoExiste() ;
        
        /**
         * *** HO002 = ACCAO INCOMPATIVEL COM SITUACAO DA CONTA/SUBCONTA
         */
        @Data(size=3, signed=true, value="2")
        IInt accaoIncompSituacao() ;
        
        /**
         * *** HO003 = CONTA NAO EXISTE
         */
        @Data(size=3, signed=true, value="3")
        IInt ctaNaoExiste() ;
        
        /**
         * *** HO004 = SUBCONTA ENCERRADA
         */
        @Data(size=3, signed=true, value="4")
        IInt subcontaEncerrada() ;
        
        /**
         * *** HO005 = ERRO NA BASE DE DADOS
         */
        @Data(size=3, signed=true, value="5")
        IInt erroBaseDados() ;
        
        /**
         * *** HO006 = UTILIZADOR NAO AUTORIZADO
         */
        @Data(size=3, signed=true, value="6")
        IInt gestorNaoAutorizado() ;
        
        /**
         * *** HO007 = FUNCAO SO DISPONIVEL NA CONTA SUPORTE
         */
        @Data(size=3, signed=true, value="7")
        IInt funcSoNaCtaSpte() ;
        
        /**
         * *** HO008 = CATIVO NAO EXISTE
         */
        @Data(size=3, signed=true, value="8")
        IInt catNaoExiste() ;
        
        /**
         * *** HO009 = CANAL INVALIDAO PARA MOVIMENTACAO DE CASH E CARRY
         */
        @Data(size=3, signed=true, value="9")
        IInt canalNPermitMov() ;
        
        /**
         * *** HO010 = SALDO DISPONIVEL NEGATIVO
         */
        @Data(size=3, signed=true, value="10")
        IInt mSldoDisponivelNeg() ;
        
        /**
         * *** HO011 = SALDO CONTABILISTICO POSITIVO
         */
        @Data(size=3, signed=true, value="11")
        IInt sldoCbloPositivo() ;
        
        /**
         * *** HO012 = MOVIMENTO NAO RESPEITA O MONTANTE REMANESCENTE
         */
        @Data(size=3, signed=true, value="12")
        IInt mvNRespeitRemanesc() ;
        
        /**
         * *** HO013 = SUBCONTA SEM LIQUIDACAO CREDORA
         */
        @Data(size=3, signed=true, value="13")
        IInt sctaSemLiquidCred() ;
        
        /**
         * *** HO014 = SUBCONTA SEM LIQUIDACAO DEVEDORA
         */
        @Data(size=3, signed=true, value="14")
        IInt sctaSemLiquidDev() ;
        
        /**
         * *** HO015 = ALTERAACO DE ESTADO INVALIDA
         */
        @Data(size=3, signed=true, value="15")
        IInt altEstCtaInval() ;
        
        /**
         * *** HO016 = ESTADO DA CONTA/SUBCONTA NAO PERMITE ALTERACAO
         */
        @Data(size=3, signed=true, value="16")
        IInt estCtaNaoPermAlt() ;
        
        /**
         * *** HO017 = ALTERACAO DE ESTADO INVALIDA
         */
        @Data(size=3, signed=true, value="17")
        IInt altPrazoInvalida() ;
        
        /**
         * *** HO018 = ALTERACAO DE PERIODICIDADE CREDORA INVALIDA
         */
        @Data(size=3, signed=true, value="18")
        IInt altPeriodCredInval() ;
        
        /**
         * *** HO019 = ANULAACO INVALIDA; EXISTE REGISTO PARA PERIODO
         * ***         POSTERIOR
         */
        @Data(size=3, signed=true, value="19")
        IInt anulacInvalida() ;
        
        /**
         * *** HO020 = O PRODUTO DA CONTA NAO PERMITE DEBITOS
         */
        @Data(size=3, signed=true, value="20")
        IInt debitoInvalido() ;
        
        /**
         * *** HO021 = JA EXISTE SUBCONTA ACTIVA PARA O PRODUTO
         */
        @Data(size=3, signed=true, value="21")
        IInt haSctaActivDoProd() ;
        
        /**
         * *** HO022 = SUBCONTA SEM TAXA ASSOCIADA
         */
        @Data(size=3, signed=true, value="22")
        IInt sctaSemTaxaAssoc() ;
        
        /**
         * *** HO023 = O PEDIDO DE ALTERACAO CORRESPONDE AOS DADOS ACTUAIS
         */
        @Data(size=3, signed=true, value="23")
        IInt pedIgualDadActuais() ;
        
        /**
         * *** HO024 = JA EXISTE NEGOCIACAO DE TAXA DE JUROS PARA O PERIODO
         */
        @Data(size=3, signed=true, value="24")
        IInt negocTaxaJaExiste() ;
        
        /**
         * *** HO025 = ACCAO INVALIDA
         */
        @Data(size=3, signed=true, value="25")
        IInt accaoInvalida() ;
        
        /**
         * *** HO026 = ALTERACAO DE PERIODICIDADE CREDORA INVALIDA
         */
        @Data(size=3, signed=true, value="26")
        IInt altPeriodDevInval() ;
        
        /**
         * *** HO027 = EXISTE NEGOCIACAO DE TAXA DE JURO COM DATA DE INICIO
         * ***         POSTERIOR
         */
        @Data(size=3, signed=true, value="27")
        IInt haNegocTaxaFuturo() ;
        
        /**
         * *** HO28 = MONTANTE DE DESCOBERTO NEGOCIADO INFERIOR AO UTILIZADO
         */
        @Data(size=3, signed=true, value="28")
        IInt mDcboNgcdInfUtlz() ;
        
        /**
         * *** HO29 = MOVIMENTO PRE-PAGAMENTO CUSTAS JUDICIAIS INEXISTENTE
         */
        @Data(size=3, signed=true, value="29")
        IInt movPpcjInexist() ;
        
        /**
         * *** HO30 = NAO SAO PERMITIDAS OCORRENCIAS MONTANTES CONDICIONAIS
         */
        @Data(size=3, signed=true, value="30")
        IInt nPermOcorrDepCond() ;
        
        /**
         * *** HO31 = TIPO PRECATORIO INCOERENTE COM INDICADOR DE LIQUIDACAO
         */
        @Data(size=3, signed=true, value="31")
        IInt tipPrecIncILiqz() ;
        
        /**
         * *** HO32 = NECESSARIA INDICACAO DE EMISSAO DE PRECATORIO SOBRE
         * ***        MONTANTE CONDICIONAL
         */
        @Data(size=3, signed=true, value="32")
        IInt precComMontCond() ;
        
        /**
         * ERRO DEVOLVIDO PELOS MODULOS DUMMY USADOS PELO CATALOGO
         * FUNCIONALIDADE NAO DISPONIVEL
         */
        @Data(size=3, signed=true, value="33")
        IInt funcionalidadeNDisp() ;
        
        /**
         * *** HO034 = SUBCONTA COM MOVIMENTOS PARA O DIA
         */
        @Data(size=3, signed=true, value="34")
        IInt sctaCMovParaDia() ;
        
        /**
         * *** HO035 = BALCAO GESTOR NAO E O DA CONTA
         */
        @Data(size=3, signed=true, value="35")
        IInt oeNaoEODaConta() ;
        
        /**
         * *** HO036 = CONTA DEPOSITO OBRIGATORIO SEM SALDO
         */
        @Data(size=3, signed=true, value="36")
        IInt ctaDepObrSemSldo() ;
        
        /**
         * *** HO037 SUBCONTA NAO PERMITE LEVANTAMENTO SOBRE INDISPONIVEL
         */
        @Data(size=3, signed=true, value="37")
        IInt sctaNpermLevIndisp() ;
        
        /**
         * *** HO038 SUBCONTAS COM DATAS DE VENCIMENTO DIFERENTES
         */
        @Data(size=3, signed=true, value="38")
        IInt sctasDatasVencDif() ;
        
        /**
         * *** HO039 INDICADOR DE ORIGEM DE FUNDOS DIFERENTE DA(S) OUTRA(S)
         * SUBCONTA(S) DA CONTA
         */
        @Data(size=3, signed=true, value="39")
        IInt iOrigFndDifScta() ;
        
        /**
         * *** HO040 INDICADOR DE RETENCAO DE SALDO INVALIDO
         */
        @Data(size=3, signed=true, value="40")
        IInt iEstRsalInvalido() ;
        
        /**
         * *** HO041 = UTILIZADOR NAO EXISTE
         */
        @Data(size=3, signed=true, value="41")
        IInt gestorNotfnd() ;
        
        /**
         * *** HO042 = ENCARGO JÂ‡ ANULADO
         */
        @Data(size=3, signed=true, value="42")
        IInt encJaAnul() ;
        
        /**
         * *** HO043 = ENCARGO ACTIVO
         */
        @Data(size=3, signed=true, value="43")
        IInt encActivo() ;
        
        /**
         * *** HO044 = CONTA SEM EMISSÂ†O DE EXTRACTO SWIFT
         */
        @Data(size=3, signed=true, value="44")
        IInt ctaSemEmissaoSwif() ;
        
        /**
         * *** HO045 = MOVIMENTO NÂ†O EXISTE
         */
        @Data(size=3, signed=true, value="45")
        IInt movInexist() ;
        
        /**
         * *** HO046 = MOVIMENTO JA FOI ENVIADO NO EXTRACTO SWIFT
         */
        @Data(size=3, signed=true, value="46")
        IInt movExistExrtSwif() ;
        
        /**
         * *** HO047 = DESCRITIVO DA MSG SWIFT JÂ‡ INSERIDO
         */
        @Data(size=3, signed=true, value="47")
        IInt descMsgSwiftDup() ;
        
        /**
         * *** HO048 = DESCRITIVO DA MSG SWIFT NÂ†O EXISTE
         */
        @Data(size=3, signed=true, value="48")
        IInt descMsgSwiftNotfnd() ;
        
        /**
         * *** HO049 = NAO HA DADOS PARA O CRITERIO
         */
        @Data(size=3, signed=true, value="49")
        IInt dadosNotfnd() ;
        
        /**
         * *** HO050 = DADOS TABELA IGUAIS AOS DO PEDIDO
         */
        @Data(size=3, signed=true, value="50")
        IInt dadosTabIguaisPed() ;
        
        /**
         * *** HO051 = DADOS EXTRACTO SWIFT JA EXISTEM
         */
        @Data(size=3, signed=true, value="51")
        IInt dadosExrtSwifExist() ;
        
        /**
         * *** HO052 = DADOS EXTRACTO SWIFT NAO EXISTEM
         */
        @Data(size=3, signed=true, value="52")
        IInt dadosExrtSwifInex() ;
        
        /**
         * *** HO053 = ANULACAO DE TRANCHE INVALIDA
         */
        @Data(size=3, signed=true, value="53")
        IInt anulTranchesInval() ;
        
        /**
         * *** HO054 = A CONTA NÂ†O TEM EXTRACTO SWIFT
         */
        @Data(size=3, signed=true, value="54")
        IInt contaSemExrtSwift() ;
        
        /**
         * *** HO055 = NÂ†O EXISTE ENDERECO SWIFT
         */
        @Data(size=3, signed=true, value="55")
        IInt endSwiftInexist() ;
        
        /**
         * *** HO056 = DATA PESQUISA NAO PERTENCE INTERVALO DATAS NEGOCIACAO
         */
        @Data(size=3, signed=true, value="56")
        IInt zPesqNIntervZNeg() ;
        
        /**
         * *** HO057 = TIPO DE RETENCAO DE SALDO INVALIDO
         */
        @Data(size=3, signed=true, value="57")
        IInt iTipoRsalInvalido() ;
        
        /**
         * *** HO058 = VISUALIZACAO DE CATIVOS ONLINE
         */
        @Data(size=3, signed=true, value="58")
        IInt catvzOnlineNao() ;
        
        /**
         * *** HO059 = ALTERACAO SO PERMITIDA PARA PRODUTOS COM VENCIMENTO
         */
        @Data(size=3, signed=true, value="59")
        IInt alterSoProdVenc() ;
        
        /**
         * *** HO060 = TIPO DE MSG SWIFT NÂ†O PERMITE DESCRITIVO NO MOVIMENTO
         */
        @Data(size=3, signed=true, value="60")
        IInt descMovNotfdMsgSw() ;
        
        /**
         * *** HO061 = DATA DE VENCIMENTO NAO PERMITE ALTERACAO DO REGISTO
         */
        @Data(size=3, signed=true, value="61")
        IInt dataVencNAltera() ;
        
        /**
         * *** HO062 = ERRO NO ESTORNO EM CONTAS CORRENTES
         */
        @Data(size=3, signed=true, value="62")
        IInt erroEstornoCCorret() ;
        
        /**
         * *** HO063 = ERRO DB2 EM CONTAS CORRENTES
         */
        @Data(size=3, signed=true, value="63")
        IInt erroDb2CCorrente() ;
        
        /**
         * *** HO064 = ERRO DE INPUT EM CONTAS CORRENTES
         */
        @Data(size=3, signed=true, value="64")
        IInt erroInputCCorrente() ;
        
        /**
         * *** HO065 = TIPO SUPORTE NAO PERMITE PREENCHIMENTO DO NÂ‘ DA VIA
         */
        @Data(size=3, signed=true, value="65")
        IInt tipoSpteNPermVia() ;
        
        /**
         * *** HO066 = TIPO SUPORTE OBRIGA AO PREENCHIMENTO DO NÂ‘ DA VIA
         */
        @Data(size=3, signed=true, value="66")
        IInt tipoSpteObrigaVia() ;
        
        /**
         * *** HO067 = ERRO NAS VALIDACOES DA ROTINA DE CONTAS CORRENTES
         */
        @Data(size=3, signed=true, value="67")
        IInt erroValCtaCorrente() ;
        
        /**
         * *** HO068 = ERRO DE VALIDACAO QUE A CONTA DE JURO CREDOR
         * *** E UMA DO OU CONTA INTERNA
         */
        @Data(size=3, signed=true, value="68")
        IInt trttCtaJurosInv() ;
        
        /**
         * *** HO069 = CODIGO DA NATUREZA JURIDICA INVALIDO
         */
        @Data(size=3, signed=true, value="69")
        IInt cSectIttlBporInv() ;
        
        /**
         * *** HO070 = CONTA SEM PRIMEIRO TITULAR - ABEND
         */
        @Data(size=3, signed=true, value="70")
        IInt clienteNotfnd() ;
        
        /**
         * *** HOD0 = MOVIMENTO GERA SALDO CONTABILISTICO SUPERIOR
         */
        @Data(size=3, signed=true, value="71")
        IInt movGeraSldCbloSup() ;
        
        /**
         * *** HOD0 = IMPOSSIBILIDADE DE ANULACAO DO PAGAMENTO DO DIA
         */
        @Data(size=3, signed=true, value="72")
        IInt impossAnulPgmDia() ;
        
        /**
         * *** HOD0 = FUNCAO NAO DISPONIVEL PARA TIPO DE CONTA
         */
        @Data(size=3, signed=true, value="73")
        IInt cTrttContInval() ;
        
        /**
         * *** SUBCONTA SEM ENCARGOS PENDENTES
         */
        @Data(size=3, signed=true, value="74")
        IInt sctaSemEncgPend() ;
        
        /**
         * *** ENCARGO PENDENTE INACTIVO
         */
        @Data(size=3, signed=true, value="75")
        IInt encargoPendInactivo() ;
        
        /**
         * *** TABELAS INTERNAS CHEIAS
         */
        @Data(size=3, signed=true, value="76")
        IInt tiCheias() ;
        
        /**
         * *** HO077 = MENSAGEM SWIFT A PEDIDO JA EXISTE
         */
        @Data(size=3, signed=true, value="77")
        IInt msgSwfPedExist() ;
        
        /**
         * *** HO078 = MENSAGEM SWIFT A PEDIDO NAO EXISTE
         */
        @Data(size=3, signed=true, value="78")
        IInt msgSwfPedInex() ;
        
        /**
         * *** HO079 = CONTA NÂ†O ASSOCIADA A AVISOS DE OPERACAO
         */
        @Data(size=3, signed=true, value="79")
        IInt relAvisoContNotfnd() ;
        
        /**
         * *** HO080 = CONTA JA ESTA ASSOCIADA A AVISOS DE OPERACAO
         */
        @Data(size=3, signed=true, value="80")
        IInt relAvisoContExist() ;
        
        /**
         * *** HO081 = PENDENTE DE COBRANCA JA EXISTE
         */
        @Data(size=3, signed=true, value="81")
        IInt pendCobrancaExist() ;
        
        /**
         * *** HO082 = MOEDA DO PENDENTE INVALIDA
         */
        @Data(size=3, signed=true, value="82")
        IInt moedaPendInvalida() ;
        
        /**
         * *** H0083 = SUBCONTA PERTENCE A GRUPO CASH-POOLING
         */
        @Data(size=3, signed=true, value="83")
        IInt sctaPertGrupoCp() ;
        
        /**
         * *** H0084 = LOTE JA DESDOBRADO
         */
        @Data(size=3, signed=true, value="84")
        IInt loteJaDesdobrado() ;
        
        /**
         * *** HO085 = CATIVACAO NAO E POSSIVEL - DEP. ESTRUT. COM N SUBDEP
         */
        @Data(size=3, signed=true, value="85")
        IInt catvzNaoNSdep() ;
        
        /**
         * *** HO086 = DATA DE LIBERTACAO DO CATIVO SUPERIOR A DATA DE VENC.
         */
        @Data(size=3, signed=true, value="86")
        IInt dtQuedaSupDtVenc() ;
        
        /**
         * *** H0087 = O PEDIDO DE ALTERACAO DEVE SER ANULADO
         */
        @Data(size=3, signed=true, value="87")
        IInt pedDeveSerAnulado() ;
        
        /**
         * *** H0088 = SUBCONTA COM RESTRICOES A MOVIMENTACAO
         */
        @Data(size=3, signed=true, value="88")
        IInt subctaComRestricoes() ;
        
        /**
         * *** H0097 = FUNCAO NAO VALIDA PARA O PRODUTO
         */
        @Data(size=3, signed=true, value="97")
        IInt situctaInvalida() ;
        
        /**
         * *** HO098 = REGISTO NAO EXISTE
         */
        @Data(size=3, signed=true, value="98")
        IInt registoInexistente() ;
        
        /**
         * *** HO099 = ENDERECO SWIFT JA EXISTE
         */
        @Data(size=3, signed=true, value="99")
        IInt endcSwifJaExiste() ;
        
        /**
         * *** HO106 = LIMITE CTA MARGEM SUPERIOR SCORING
         */
        @Data(size=3, signed=true, value="106")
        IInt limCmrgSupScoring() ;
        
        /**
         * *** HO107 = NEGOCIACAO DE TAXA DE JURO NAO EXISTE
         */
        @Data(size=3, signed=true, value="107")
        IInt cndPartRemInexst() ;
        
        /**
         * *** HO108 = DATA DE ACTIVACAO DA NEGOCIACAO DE TAXAS ULTRAPASSADA
         * ***         (ACCAO JA NAO E POSSIVEL)
         */
        @Data(size=3, signed=true, value="108")
        IInt planoJaEmVigor() ;
        
        /**
         * *** HO109 = DATA SITUACAO INCUMPRIMENTO INVALIDA
         */
        @Data(size=3, signed=true, value="109")
        IInt dataSitIcptInval() ;
        
        /**
         * *** HO110 = ALTERACAO NAO PERMITIDA
         */
        @Data(size=3, signed=true, value="110")
        IInt altSitIcptInval() ;
        
        /**
         * *** HO111 = ACCAO INVALIDA DEVIDO A SITUACAO DE INCUMPRIMENTO
         */
        @Data(size=3, signed=true, value="111")
        IInt accaoInvalIcpt() ;
        
        /**
         * *** HO112 = REGULARIZACAO DE ENCARGOS NAO POSSIVEL
         */
        @Data(size=3, signed=true, value="112")
        IInt rgzzEncgNPossivel() ;
        
        /**
         * *** HO114 = LOTE NAO RECEPCIONADO NO CTD
         */
        @Data(size=3, signed=true, value="114")
        IInt loteNRecepCtd() ;
        
        /**
         * *** HO115 = JA EXISTE LIMITE DE SALDO DISPONIVEL CTA VOSTRO
         */
        @Data(size=3, signed=true, value="115")
        IInt jaExisteLimDisp() ;
        
        /**
         * *** HO123 = OS INTERVENIENTES DA CONTA SUPORTE SAO DIFERENTES
         */
        @Data(size=3, signed=true, value="123")
        IInt intervCtaSuportDif() ;
        
        /**
         * *** HO124 = O 1 TITULAR E O NOVO TITULAR NAO SAO PARENTES
         */
        @Data(size=3, signed=true, value="124")
        IInt grauParentescoInex() ;
        
        /**
         * *** HO125 = RELACAO INEXISTENTE ENTRE 1 TITULAR E RESTANTES
         */
        @Data(size=3, signed=true, value="125")
        IInt relacaoNaoExiste() ;
        
        /**
         * *** HO126 = CONTA NAO E NOSTRO
         */
        @Data(size=3, signed=true, value="126")
        IInt ctaNaoNostro() ;
        
        /**
         * *** HO127 = CODIGO MOVIMENTO NAO PERMITIDO
         */
        @Data(size=3, signed=true, value="127")
        IInt codMovNPerm() ;
        
        /**
         * *** HO167 = QUANTIDADE DE TITULARES INVALIDA PARA O PRODUTO
         */
        @Data(size=3, signed=true, value="167")
        IInt maxTitCtitular() ;
        
        /**
         * *** HO194 = SUBCONTA JA PERTENCE A UMA ASSOCIACAO CASH
         */
        @Data(size=3, signed=true, value="194")
        IInt assocExiste() ;
        
        /**
         * *** HO195 = ASSOCIACAO CASH NAO EXISTE
         */
        @Data(size=3, signed=true, value="195")
        IInt assocNaoExiste() ;
        
        /**
         * **** ERROS DE SGOP
         * *** HO196 = SALDO DE SUPORTE DIFERENTE
         */
        @Data(size=3, signed=true, value="196")
        IInt sldSptDiferente() ;
        
        /**
         * *** HO197 = VIA DE SUPORTE DIFERENTE
         */
        @Data(size=3, signed=true, value="197")
        IInt viaSptDiferente() ;
        
        /**
         * *** HO198 = PROGRAMA CHAMADOR INVALIDO
         */
        @Data(size=3, signed=true, value="198")
        IInt prgChamInval() ;
        
        /**
         * *** HO199 = CODIGO DE ACESSO INVALIDO
         */
        @Data(size=3, signed=true, value="199")
        IInt codAcesInval() ;
        
        /**
         * *** HO200 = CHAVE DE ACESSO INVALIDA
         */
        @Data(size=3, signed=true, value="200")
        IInt chvAcesInval() ;
        
        /**
         * *** HO201 = QUANTIDADE A ACTUALIZAR INVALIDA
         */
        @Data(size=3, signed=true, value="201")
        IInt qtdActualizInval() ;
        
        /**
         * *** HO202 = SERVICO INVALIDO PARA TIPO DE SUPORTE
         */
        @Data(size=3, signed=true, value="202")
        IInt servInvalTipSpt() ;
        
        /**
         * *** HO203 = SUPORTE INVALIDO PARA PENDENTE EXISTENTE
         */
        @Data(size=3, signed=true, value="203")
        IInt sptInvPendExit() ;
        
        /**
         * *** HO204 = SUPORTE INVALIDO PARA PENDENTE INEXISTENTE
         */
        @Data(size=3, signed=true, value="204")
        IInt sptInvPendInexi() ;
        
        /**
         * *** HO205 = NAO EXISTEM PENDENTES A ACTUALIZAR
         */
        @Data(size=3, signed=true, value="205")
        IInt nExiPendActual() ;
        
        /**
         * *** HO206 = NAO EXISTEM PENDENTES
         */
        @Data(size=3, signed=true, value="206")
        IInt nExiPendentes() ;
        
        /**
         * *** HO207 = FUNCAO INDISPONIVEL
         */
        @Data(size=3, signed=true, value="207")
        IInt funcaoIndispon() ;
        
        /**
         * *** HO208 = NUMERO DE CONTA INVALIDO
         */
        @Data(size=3, signed=true, value="208")
        IInt numCtaInval() ;
        
        /**
         * *** HO209 = ERRO DE ACESSO AO FICHEIRO
         */
        @Data(size=3, signed=true, value="209")
        IInt erroAcesFich() ;
        
        /**
         * *** HO210 = PROGRAMA CHAMADO NAO EXISTENTE
         */
        @Data(size=3, signed=true, value="210")
        IInt prgNExistente() ;
        
        /**
         * **** ERROS DE SGOP - FIM
         * *** HO224 = CONTA SUPORTE TEM DE SER CONTA Ã€ ORDEM
         */
        @Data(size=3, signed=true, value="224")
        IInt ctaNaoDo() ;
        
        /**
         * *** HO257 = CONTA COM CHEQUES ACTIVOS
         */
        @Data(size=3, signed=true, value="257")
        IInt ctaChqActivos() ;
        
        /**
         * *** HO259 = CONTA COM MOVIMENTOS PROGRAMADOS A FUTURO
         */
        @Data(size=3, signed=true, value="259")
        IInt ctaComMov() ;
        
        /**
         * *** HO312 = PEDIDO DE ALTERAÃƒÂ†O DE TIPO DE CÂ‡LCULO EXISTE
         */
        @Data(size=3, signed=true, value="312")
        IInt pedAltCalJurExis() ;
        
        /**
         * *** HO313 = ALTERAÃƒÂ†O NO MOMENTO INVÂ‡LIDA
         */
        @Data(size=3, signed=true, value="313")
        IInt iAltMontInvalido() ;
        
        /**
         * *** HO314 = DATA PEDIDO DE ALTERAÃƒÂ†O INVÂ‡LIDA
         */
        @Data(size=3, signed=true, value="314")
        IInt zPedAltInval() ;
        
        /**
         * *** HO315 = SITUAÃƒÂ†O DE PEDIDO ALTERAÃƒÂ†O INVÂ‡LIDA
         */
        @Data(size=3, signed=true, value="315")
        IInt iSitPedInval() ;
        
        /**
         * *** HO317 = DATA INVALIDA
         */
        @Data(size=3, signed=true, value="317")
        IInt dataInvalida() ;
        
        /**
         * *** HO344 = NAO E PERMITIDO ELIMINAR O PRIMEIRO TITULAR
         */
        @Data(size=3, signed=true, value="344")
        IInt altPriTit() ;
        
        /**
         * *** HO345 = ?????????????????????
         */
        @Data(size=3, signed=true, value="345")
        IInt contaJaExiste() ;
        
        /**
         * *** HO354 = NEGOCIACAO E ENCARGOS NAO EXISTE
         */
        @Data(size=3, signed=true, value="354")
        IInt encargoNaoExiste() ;
        
        /**
         * *** HO355 = JA EXISTE NEGOCIACAO DE ENCARGOS PARA O PERIODO
         */
        @Data(size=3, signed=true, value="355")
        IInt encargoJaExiste() ;
        
        /**
         * *** HO356 = DATA DE ACTIVACAO DA NEGOCIACAO ENCARGOS ULTRAPASSADA
         * ***         (ACCAO JA NAO E POSSIVEL)
         */
        @Data(size=3, signed=true, value="356")
        IInt encargoJaEmVigor() ;
        
        /**
         * *** HO383 = O PRIMEIRO ESCALAO TEM DE SER PARA PRAZO/MONTANTE
         * ***         ZERO
         */
        @Data(size=3, signed=true, value="383")
        IInt escNaoExiste() ;
        
        /**
         * *** HO384 = NAO E PERMITIDO ELIMINAR O PRIMEIRO ESCALAO
         */
        @Data(size=3, signed=true, value="384")
        IInt escNaoElimin() ;
        
        /**
         * *** HO385 = PRODUTO/NEGOCIACAO NAO PERMITE ESCALOES
         */
        @Data(size=3, signed=true, value="385")
        IInt escalNoAdmitidos() ;
        
        /**
         * *** HO386 = CONTA A MARGEM NAO EXISTE
         */
        @Data(size=3, signed=true, value="386")
        IInt contaMargInex() ;
        
        /**
         * *** HO387 = CONTA A MARGEM INACTIVA
         */
        @Data(size=3, signed=true, value="387")
        IInt contaMargInac() ;
        
        /**
         * *** HO388 = SUBCONTA NAO RENOVA
         */
        @Data(size=3, signed=true, value="388")
        IInt ctaNaoRenov() ;
        
        /**
         * *** HO389 = ?????????????????????
         */
        @Data(size=3, signed=true, value="389")
        IInt inserInvalida() ;
        
        /**
         * *** HO390 = DESCATIVACAO ONLINE NAO PERMITIDA
         */
        @Data(size=3, signed=true, value="390")
        IInt dctvzOnlineNao() ;
        
        /**
         * *** HO391 = SALDO INSUFICIENTE PARA A CATIVACAO
         */
        @Data(size=3, signed=true, value="391")
        IInt sldoCativarInsuf() ;
        
        /**
         * *** HO392 = VALOR A COBRANCA NAO EXISTE
         */
        @Data(size=3, signed=true, value="392")
        IInt pendenteNaoExist() ;
        
        /**
         * *** HO394 = NEGOCIACAO JA APROVADA
         */
        @Data(size=3, signed=true, value="394")
        IInt naoEscPendAprov() ;
        
        /**
         * *** HO395 = NEGOCIACAO SEM ESCALOES PARA APROVAR
         */
        @Data(size=3, signed=true, value="395")
        IInt escalNaoParam() ;
        
        /**
         * *** HO397 = PEDIDO DE MAPA NAO EXISTE
         */
        @Data(size=3, signed=true, value="397")
        IInt nExistePedMapa() ;
        
        /**
         * *** HO399 = PRECATORIO NAO EXISTE
         */
        @Data(size=3, signed=true, value="399")
        IInt precatNaoExiste() ;
        
        /**
         * *** HO400 = FUNCAO INVALIDA PARA PRODUTOS COM VENCIMENTO
         */
        @Data(size=3, signed=true, value="400")
        IInt repInval() ;
        
        /**
         * *** HO424 = CONDICOES DE MOVIMENTACAO INVALIDAS
         */
        @Data(size=3, signed=true, value="424")
        IInt cndzMovzInvalida() ;
        
        /**
         * *** HO401 = PRECATORIO DE CAPITAL SEM JUROS ANUAIS
         */
        @Data(size=3, signed=true, value="401")
        IInt precCapSemJAnual() ;
        
        /**
         * *** HO4 02 = PRECATORIO DE CAPITAL SEM JUROS DEVIDOS
         */
        @Data(size=3, signed=true, value="402")
        IInt precCapSemJDevd() ;
        
        /**
         * *** HO4 03 = PRECATORIO DE JUROS COM MONTANTE A ZEROS
         */
        @Data(size=3, signed=true, value="403")
        IInt mPrecJurosZero() ;
        
        /**
         * *** HO4 04 = OBRIG. PRECATORIO COM PERCENTAGEM TOTAL
         */
        @Data(size=3, signed=true, value="404")
        IInt precJuroPercTotal() ;
        
        /**
         * *** HO425 = MOEDA DA CONTA INVALIDO PARA O GRUPO
         */
        @Data(size=3, signed=true, value="425")
        IInt moedaNaoIgualAsso() ;
        
        /**
         * *** HO426 = PREMIO NAO EXISTE
         */
        @Data(size=3, signed=true, value="426")
        IInt premioInex() ;
        
        /**
         * *** HO427 = PREMIO NAO PODE SER ELIMINADO
         */
        @Data(size=3, signed=true, value="427")
        IInt erroDelPrm() ;
        
        /**
         * *** HO428 = PREMIO JA PAGO
         */
        @Data(size=3, signed=true, value="428")
        IInt premioJaPago() ;
        
        /**
         * *** HO429 = PREMIO NAO PAGO
         */
        @Data(size=3, signed=true, value="429")
        IInt premioNaoPago() ;
        
        /**
         * *** HO430 = DATA DE VALIDADE DO PREMIO ULTRAPASSADA
         */
        @Data(size=3, signed=true, value="430")
        IInt premioSemVlde() ;
        
        /**
         * *** HO431 = BANCO DA CONTA INVALIDO PARA O GRUPO
         */
        @Data(size=3, signed=true, value="431")
        IInt bancoNaoIgualAsso() ;
        
        /**
         * *** HO432 = METODO DE CALCULO DE JUROS DA CONTA INVALIDO PARA
         * ***         O GRUPO
         */
        @Data(size=3, signed=true, value="432")
        IInt calJurInvalAsso() ;
        
        /**
         * *** HO433 = PAIS DA CONTA INVALIDO PARA O GRUPO
         */
        @Data(size=3, signed=true, value="433")
        IInt paisNaoIgualAsso() ;
        
        /**
         * *** HO436 = SUBCONTA NAO ASSOCIADA A UMA CONTA CORRENTE
         */
        @Data(size=3, signed=true, value="436")
        IInt sctaNAssocCtacorr() ;
        
        /**
         * *** HO439 = ORGAO DE ESTRUTURA NAO AUTORIZADO
         */
        @Data(size=3, signed=true, value="439")
        IInt balcaoNaoAutorizado() ;
        
        /**
         * *** HO441 = SUBCONTA JA ASSOCIADA A UMA CONTA CORRENTE
         */
        @Data(size=3, signed=true, value="441")
        IInt sctaJaAssocCtacorr() ;
        
        /**
         * *** HO442 = SUBCONTAS COM DATAS DE VENCIMENTO DISTINTAS
         */
        @Data(size=3, signed=true, value="442")
        IInt sctaZVencDistintas() ;
        
        /**
         * *** HO443 = TITULAR FALECIDO
         */
        @Data(size=3, signed=true, value="443")
        IInt titularNPermAssoc() ;
        
        /**
         * *** HO445 = SUBCONTA NAO PERTENCE A UM GRUPO CASH
         */
        @Data(size=3, signed=true, value="445")
        IInt naoExiSctaGrupo() ;
        
        /**
         * *** HO480 = PREMIO ELIMINADO
         */
        @Data(size=3, signed=true, value="480")
        IInt premioEliminado() ;
        
        /**
         * *** HO482 = QUANTIDADE DE TITULARES NAO CORRESPONDE AOS ACTIVOS
         */
        @Data(size=3, signed=true, value="482")
        IInt totalIntervErrado() ;
        
        /**
         * *** HO484 = NAO EXISTE SUBCONTA VALIDA PARA A NOVA MOEDA BASE
         */
        @Data(size=3, signed=true, value="484")
        IInt moedaSctaInvalida() ;
        
        /**
         * *** HO485 = MODIFICACAO INVALIDA
         */
        @Data(size=3, signed=true, value="485")
        IInt modifInvalida() ;
        
        /**
         * *** HO488 = ?????????????????????
         */
        @Data(size=3, signed=true, value="488")
        IInt radicalReservado() ;
        
        /**
         * *** HO489 = RADICAL JA EXISTE
         */
        @Data(size=3, signed=true, value="489")
        IInt radicalJaExiste() ;
        
        /**
         * *** HO491 = TRANCHE DE RADICAIS DA CONTA DO OE ESGOTADA
         */
        @Data(size=3, signed=true, value="491")
        IInt trancheRadicalEsgt() ;
        
        /**
         * *** HO493 = ALTERACAO SO PERMITIDA NA CONTA SUPORTE
         */
        @Data(size=3, signed=true, value="493")
        IInt alterSoNaCtaSpte() ;
        
        /**
         * *** HO500 = PEDIDO JA EXISTE
         */
        @Data(size=3, signed=true, value="500")
        IInt pedidoExistente() ;
        
        /**
         * *** HO500 = PEDIDO NAO EXISTE
         */
        @Data(size=3, signed=true, value="502")
        IInt pedidoInexistente() ;
        
        /**
         * *** HO509 = ?????????????????????
         */
        @Data(size=3, signed=true, value="509")
        IInt ducInexistente() ;
        
        /**
         * *** HO513 = DUC NAO CORRIGIVEL
         */
        @Data(size=3, signed=true, value="513")
        IInt ducNaoCorrigivel() ;
        
        /**
         * *** HO519 = ERRO NOS DADOS
         */
        @Data(size=3, signed=true, value="519")
        IInt erroDadosInput() ;
        
        /**
         * *** HO521 = PEDIDO JA PROCESSADO
         */
        @Data(size=3, signed=true, value="521")
        IInt pedJaProcessado() ;
        
        /**
         * *** HO523 = JA EXISTE PEDIDO DE MAPA IGUAL
         */
        @Data(size=3, signed=true, value="523")
        IInt existePedMapIgual() ;
        
        /**
         * *** HO524 = EXTRACTO NAO EXISTE
         */
        @Data(size=3, signed=true, value="524")
        IInt nExisteExtracto() ;
        
        /**
         * *** HO525 = EVENTO INVALIDO
         */
        @Data(size=3, signed=true, value="525")
        IInt eventoInvalido() ;
        
        /**
         * *** HO527 = TIPO DE SUPORTE DA CONTA INCOMPATIVEL COM A FUNCAO
         */
        @Data(size=3, signed=true, value="527")
        IInt tipoSpteInvalido() ;
        
        /**
         * *** HO528 = VIA INVALIDA
         */
        @Data(size=3, signed=true, value="528")
        IInt viaInvalida() ;
        
        /**
         * *** HO529 = PIN NAO EXISTE
         */
        @Data(size=3, signed=true, value="529")
        IInt pinInexistente() ;
        
        /**
         * *** HO530 = MEMO NAO EXISTE
         */
        @Data(size=3, signed=true, value="530")
        IInt memoNaoExiste() ;
        
        /**
         * *** HO531 = MEMO INACTIVO
         */
        @Data(size=3, signed=true, value="531")
        IInt memoInactivo() ;
        
        /**
         * *** HO532 = MEMO ACTIVO
         */
        @Data(size=3, signed=true, value="532")
        IInt memoActivo() ;
        
        /**
         * *** HO533 = JA EXISTE MEMO PARA O PERIODO
         */
        @Data(size=3, signed=true, value="533")
        IInt memoExistente() ;
        
        /**
         * *** HO534 = MOVIMENTO DE DUC NAO EXISTE
         */
        @Data(size=3, signed=true, value="534")
        IInt movDucInexist() ;
        
        /**
         * *** HO535 = PAGAMENTO DE DUC NAO ENVIADO
         */
        @Data(size=3, signed=true, value="535")
        IInt ducNaoEnviado() ;
        
        /**
         * *** HO541 = CRIVO INVALIDO
         */
        @Data(size=3, signed=true, value="541")
        IInt crivoInvalido() ;
        
        /**
         * *** HO542 = TRIBUNAL JA EXISTE
         */
        @Data(size=3, signed=true, value="542")
        IInt tribunalJaExiste() ;
        
        /**
         * *** HO543 = TRIBUNAL NAO EXISTE
         */
        @Data(size=3, signed=true, value="543")
        IInt tribunalNaoExiste() ;
        
        /**
         * *** HO544 = DETALHE DE PAGAMENTO DE DUC NAO EXISTE
         */
        @Data(size=3, signed=true, value="544")
        IInt detDucInexist() ;
        
        /**
         * *** HO545 = LINHA DE DETALHE DE PAGAMENTO DE DUC NAO EXISTE
         */
        @Data(size=3, signed=true, value="545")
        IInt linDetDucInexist() ;
        
        /**
         * *** HO546 = MOVIMENTO NAO EXISTE
         */
        @Data(size=3, signed=true, value="546")
        IInt movimentoNExiste() ;
        
        /**
         * *** HO548 = CONTA SEM CADERNETA
         */
        @Data(size=3, signed=true, value="548")
        IInt contaSemCaderneta() ;
        
        /**
         * *** HO551 = OE SEM ACESSO
         */
        @Data(size=3, signed=true, value="551")
        IInt balcaoSemPerm() ;
        
        /**
         * *** HO552 = DUC NAO EXISTE
         */
        @Data(size=3, signed=true, value="552")
        IInt ducNExist() ;
        
        /**
         * *** HO553 = LOTE JA ENVIADO
         */
        @Data(size=3, signed=true, value="553")
        IInt loteJaEnvd() ;
        
        /**
         * *** HO554 = ORIGEM LOTE INVALIDA
         */
        @Data(size=3, signed=true, value="554")
        IInt origLoteInv() ;
        
        /**
         * *** HO555 = LOTE NAO EXISTE
         */
        @Data(size=3, signed=true, value="555")
        IInt loteNaoExiste() ;
        
        /**
         * *** HO556 = LOTE JA ABERTO
         */
        @Data(size=3, signed=true, value="556")
        IInt loteAberto() ;
        
        /**
         * *** HO557 = LOTE FECHADO
         */
        @Data(size=3, signed=true, value="557")
        IInt loteFechado() ;
        
        /**
         * *** HO558 = FECHO DE LOTE INVALIDO
         */
        @Data(size=3, signed=true, value="558")
        IInt fechoInvalido() ;
        
        /**
         * *** HO559 = LOTE JA EXISTE
         */
        @Data(size=3, signed=true, value="559")
        IInt loteJaExiste() ;
        
        /**
         * *** HO560 = MOVIMENTO NAO EXISTE
         */
        @Data(size=3, signed=true, value="560")
        IInt movNaoExiste() ;
        
        /**
         * *** HO561 = MOVIMENTO ANULADO
         */
        @Data(size=3, signed=true, value="561")
        IInt movAnulado() ;
        
        /**
         * *** HO562 = PRODUTO DA CONTA NAO PERMITE MORADA
         */
        @Data(size=3, signed=true, value="562")
        IInt prodNPermMord() ;
        
        /**
         * *** HO563 = DATA INICIO DA NEGOCIACAO INVALIDA
         */
        @Data(size=3, signed=true, value="563")
        IInt zEncgNaoValida() ;
        
        /**
         * *** HO568 = PENDENTE DE COBRANCA NAO EXISTE
         */
        @Data(size=3, signed=true, value="568")
        IInt naoExiPendCobr() ;
        
        /**
         * *** HO569 = MONTANTE LIMITE E INFERIOR AO UTILIZADO DA CONTA
         * ***         A MARGEM
         */
        @Data(size=3, signed=true, value="569")
        IInt contaMargSldo() ;
        
        /**
         * *** HO572 = INDICADOR DE PENALIZAÃƒÂ†O DE INPUT INVALIDO
         */
        @Data(size=3, signed=true, value="572")
        IInt iPenalizacaoErr() ;
        
        /**
         * *** HO574 = MONTANTE NAO DISPONIVEL
         */
        @Data(size=3, signed=true, value="574")
        IInt montNaoDisp() ;
        
        /**
         * *** HO576 = MONTANTE FORA DOS LIMITES PARA MOVIMENTAR
         */
        @Data(size=3, signed=true, value="576")
        IInt errLimMov() ;
        
        /**
         * *** HO578 = NAO SAO POSSIVEIS REFORCOS
         */
        @Data(size=3, signed=true, value="578")
        IInt reforzoNPos() ;
        
        /**
         * *** HO581 = DOCUMENTO JA INSERIDO
         */
        @Data(size=3, signed=true, value="581")
        IInt documJaInserido() ;
        
        /**
         * *** HO582 = PERIODICIDADE DE JUROS CREDORES INVALIDA
         */
        @Data(size=3, signed=true, value="582")
        IInt perCreJurosInv() ;
        
        /**
         * *** HO584 = SEGURO JA ANULADO
         */
        @Data(size=3, signed=true, value="584")
        IInt seguroJaAnulado() ;
        
        /**
         * *** HO585 = SALDO NAO PERMITE ASSOCIACAO DE SEGURO
         */
        @Data(size=3, signed=true, value="585")
        IInt sldoNPermAssSeg() ;
        
        /**
         * *** HO587 = PEDIDO NAO PODE SER EFECTUADO
         */
        @Data(size=3, signed=true, value="587")
        IInt pedNPodeSerEfect() ;
        
        /**
         * *** HO589 = LIQUIDACAO PREVIA NAO TEM DETALHE
         */
        @Data(size=3, signed=true, value="589")
        IInt liqPrevSDet() ;
        
        /**
         * *** HO591 = SUPORTE NAO E EXTRACTO
         */
        @Data(size=3, signed=true, value="591")
        IInt tipoSpteCtaNExt() ;
        
        /**
         * *** HO592 = PERIODICIDADE INVALIDA
         */
        @Data(size=3, signed=true, value="592")
        IInt periodicidadeInval() ;
        
        /**
         * *** HO601 = NUMERO CONTA A MARGEM ULTRAPASSOU O LIMITE MAXIMO
         * ***         DO CATALOGO
         */
        @Data(size=3, signed=true, value="601")
        IInt contaNrLim() ;
        
        /**
         * *** HO602 = MONTANTE DA CONTA A MARGEM NAO SE ENCONTRA DENTRO
         * ***         DOS PARAMETROS DO CATALOGO
         */
        @Data(size=3, signed=true, value="602")
        IInt montCmrgNStnd() ;
        
        /**
         * *** HO605 = EXISTEM SUBCONTAS NAO FECHADAS
         */
        @Data(size=3, signed=true, value="605")
        IInt existemSubcontasVal() ;
        
        /**
         * *** HO606 = EXISTEM RELACOES ACTIVAS
         */
        @Data(size=3, signed=true, value="606")
        IInt existemRelActivas() ;
        
        /**
         * *** HO607 = PRAZO INVALIDO
         */
        @Data(size=3, signed=true, value="607")
        IInt prazoInvalido() ;
        
        /**
         * *** HO609 = PRAZO DE NEGOCIACAO IGUAL A ZERO
         */
        @Data(size=3, signed=true, value="609")
        IInt przNgcZero() ;
        
        /**
         * *** HO610 = INDISPONIVEL NAO EXISTE
         */
        @Data(size=3, signed=true, value="610")
        IInt erroObtPent() ;
        
        /**
         * *** HO611 = INDICADOR DE JUSTIFICACAO INVALIDO
         */
        @Data(size=3, signed=true, value="611")
        IInt iJstzInvalido() ;
        
        /**
         * *** HO612 = CODIGO DE JUSTIFICACAO INVALIDO
         */
        @Data(size=3, signed=true, value="612")
        IInt cJstzInvalido() ;
        
        /**
         * *** HO614 = CATALOGO NAO PERMITE A ALTERACAO DA DATA
         */
        @Data(size=3, signed=true, value="614")
        IInt altZLiqzNValida() ;
        
        /**
         * *** HO615 = DADOS INVALIDOS
         */
        @Data(size=3, signed=true, value="615")
        IInt inputMalForm() ;
        
        /**
         * *** HO617 = EMPRESA DESTINO DIFERENTE DA ORIGINAL
         */
        @Data(size=3, signed=true, value="617")
        IInt empDstDiferOri() ;
        
        /**
         * *** HO618 = OE DESTINO DIFERENTE DO ORIGINAL
         */
        @Data(size=3, signed=true, value="618")
        IInt oeDstDiferOri() ;
        
        /**
         * *** HO619 = FAMILIA DESTINO DIFERENTE DA ORIGINAL
         */
        @Data(size=3, signed=true, value="619")
        IInt famiDstDiferOri() ;
        
        /**
         * *** HO620 = SUPORTE DA SUBCONTA DESTINO DIFERENTE DO DA ORIGINAL
         */
        @Data(size=3, signed=true, value="620")
        IInt suportDstDiferOri() ;
        
        /**
         * *** HO621 = INTERVENIENTE DA CONTA DESTINO DIFERENTE DE
         * ***         INTERVENIENTE DA CONTA ORIGEM
         */
        @Data(size=3, signed=true, value="621")
        IInt iCtaDstDiferOri() ;
        
        /**
         * *** HO622 = CADERNETA DESACTUALIZADA
         */
        @Data(size=3, signed=true, value="622")
        IInt cadernetaDesactual() ;
        
        /**
         * *** HO623 = EXISTEM MOVIMENTOS AGLUTINADOS
         */
        @Data(size=3, signed=true, value="623")
        IInt existemMovAglut() ;
        
        /**
         * *** HO626 = CONTA COM SEGUROS ASSOCIADOS
         */
        @Data(size=3, signed=true, value="626")
        IInt ctaAssServicos() ;
        
        /**
         * *** HO627 = ERRO DE MOVIMENTACAO DE FIM DE DIA
         */
        @Data(size=3, signed=true, value="627")
        IInt errMovBatch() ;
        
        /**
         * *** HO628 = SUBCONTA COM PREMIOS ASSOCIADOS
         */
        @Data(size=3, signed=true, value="628")
        IInt sctaComPremios() ;
        
        /**
         * *** HO629 = SUBCONTA COM RELACOES COM OUTRAS SUBCONTAS
         */
        @Data(size=3, signed=true, value="629")
        IInt sctaRelSctas() ;
        
        /**
         * *** HO630 = MOVIMENTO POUPANCA COM RESERVA NAO PROCESSADO
         */
        @Data(size=3, signed=true, value="630")
        IInt sctaMovResePPrc() ;
        
        /**
         * *** HO632 = DESCOBERTO SUPERA LIMITE
         */
        @Data(size=3, signed=true, value="632")
        IInt dcboSuperaLimite() ;
        
        /**
         * *** HO633 = SALDO DEVEDOR ABAIXO DO MINIMO
         */
        @Data(size=3, signed=true, value="633")
        IInt sldoDebMenorMin() ;
        
        /**
         * *** HO634 = JA EXISTE DESCRITIVO ESPECIAL PARA A CONTA
         */
        @Data(size=3, signed=true, value="634")
        IInt jaExisCtaDescrit() ;
        
        /**
         * *** HO635 = NAO EXISTE DESCRITIVO ESPECIAL PARA A CONTA
         */
        @Data(size=3, signed=true, value="635")
        IInt nExisCtaDescritivo() ;
        
        /**
         * *** HO636 = SUBCONTA CASH & CARRY INACTIVA
         */
        @Data(size=3, signed=true, value="636")
        IInt sctaCashInactiva() ;
        
        /**
         * *** HO638 = GATILHO DE CONTA CANCELADO
         */
        @Data(size=3, signed=true, value="638")
        IInt ctaGatCancel() ;
        
        /**
         * *** HO639 = EXISTEM GATILHOS DE LIQUIDACAO DA SUBCONTA
         * ***         COM DATA MINIMA
         */
        @Data(size=3, signed=true, value="639")
        IInt sctaGatCancel() ;
        
        /**
         * *** HO640 = ESTADO DA SUBCONTA NA MOEDA BASE INVALIDO
         */
        @Data(size=3, signed=true, value="640")
        IInt iEstSctaBaseInval() ;
        
        /**
         * *** HO641 = NEGOCIACAO JA PROCESSADA
         */
        @Data(size=3, signed=true, value="641")
        IInt ngczJaProcessada() ;
        
        /**
         * *** HO642 = SUBCONTA PREABERTA
         */
        @Data(size=3, signed=true, value="642")
        IInt sctaPrebaerta() ;
        
        /**
         * *** HO643 = DADOS INVALIDOS
         */
        @Data(size=3, signed=true, value="643")
        IInt notNumeric() ;
        
        /**
         * *** HO644 = FALTAM DADOS DA MORADA
         */
        @Data(size=3, signed=true, value="644")
        IInt faltamDadosMorada() ;
        
        /**
         * *** HO645 = NR. PROCESSO ADMIN. /TRIBUNAL DIFERENTE DO REGISTO
         * ***         DA TABELA THO00074_DPOBESP
         */
        @Data(size=3, signed=true, value="645")
        IInt nProcDifOutScta() ;
        
        /**
         * *** HO646 = LIQUIDACAO INCORRECTA
         */
        @Data(size=3, signed=true, value="646")
        IInt liquidacaoIncorr() ;
        
        /**
         * *** HO647 = OBJECTO INACTIVO
         */
        @Data(size=3, signed=true, value="647")
        IInt objectoInactivo() ;
        
        /**
         * *** HO649 = CONDICOES DE MOVIMENTACAO NAO EXISTEM
         */
        @Data(size=3, signed=true, value="649")
        IInt cCndzMovzInex() ;
        
        /**
         * *** HO650 = RELACAO COM SEGURO JA EXISTE
         */
        @Data(size=3, signed=true, value="650")
        IInt relServicoJaExiste() ;
        
        /**
         * *** HO651 = RELACAO COM SEGURO NAO EXISTE
         */
        @Data(size=3, signed=true, value="651")
        IInt relServicoNaoExist() ;
        
        /**
         * *** HO652 = CONTA NAO CONVERTIDA
         */
        @Data(size=3, signed=true, value="652")
        IInt ctaNaoConvertida() ;
        
        /**
         * *** HO653 = CASH-MANAGEMENT INVALIDO
         */
        @Data(size=3, signed=true, value="653")
        IInt cashManagementInv() ;
        
        /**
         * *** HO654 = ALTERACAO INVALIDA
         */
        @Data(size=3, signed=true, value="654")
        IInt alteracaoInvalida() ;
        
        /**
         * *** HO655 = DIAS DE ACTIVACAO DA CONTA A MARGEM INVALIDOS
         */
        @Data(size=3, signed=true, value="655")
        IInt diaAtvzCmrgInvalid() ;
        
        /**
         * *** HO656 = ERRO NA BASE DE DADOS
         */
        @Data(size=3, signed=true, value="656")
        IInt erroDb2() ;
        
        /**
         * *** HO765 = PRODUTO DEFAULT DIFERENTE
         */
        @Data(size=3, signed=true, value="765")
        IInt prodDfltDiferente() ;
        
        /**
         * *** HO766 = MOEDA DA SUBCONTA DIFERENTE DA MOEDA BASE
         */
        @Data(size=3, signed=true, value="766")
        IInt moeSctaDifMoeBas() ;
        
        /**
         * *** HO767 = PRAZO DE JUROS CREDORES NAO PREENCHIDO
         */
        @Data(size=3, signed=true, value="767")
        IInt campCrVazio() ;
        
        /**
         * *** HO768 = PRAZO DE JUROS DEVEDORES NAO PREENCHIDO
         */
        @Data(size=3, signed=true, value="768")
        IInt campDvVazio() ;
        
        /**
         * *** HO769 = PERIODICIDADE DE JUROS DEVEDORES INVALIDA
         */
        @Data(size=3, signed=true, value="769")
        IInt perJurosDvInval() ;
        
        /**
         * *** HO770 = DADOS JUROS DEVEDORES INVALIDOS
         */
        @Data(size=3, signed=true, value="770")
        IInt dadosDvPreenchidos() ;
        
        /**
         * *** HO771 = DADOS JUROS CREDORES INVALIDOS
         */
        @Data(size=3, signed=true, value="771")
        IInt dadosCrPreenchidos() ;
        
        /**
         * *** HO772 = PRODUTO COM CAPITALIZACAO OBRIGATORIA
         */
        @Data(size=3, signed=true, value="772")
        IInt produtoCapObrg() ;
        
        /**
         * *** HO773 = PRODUTO NAO PERMITE CAPITALIZACAO
         */
        @Data(size=3, signed=true, value="773")
        IInt produtoSemCap() ;
        
        /**
         * *** HO774 = PRODUTO COM RENOVACAO OBRIGATORIA
         */
        @Data(size=3, signed=true, value="774")
        IInt produtoRenovObrg() ;
        
        /**
         * *** HO775 = PRODUTO NAO PERMITE RENOVACAO
         */
        @Data(size=3, signed=true, value="775")
        IInt produtoSemRenov() ;
        
        /**
         * *** HO776 = DATA VALOR DE ABERTURA DA SUBCONTA INVALIDA
         */
        @Data(size=3, signed=true, value="776")
        IInt zValAbraSctaInval() ;
        
        /**
         * *** HO777 = SUBCONTA PARA JUROS CREDORES INVALIDA
         */
        @Data(size=3, signed=true, value="777")
        IInt subcontaJcrInval() ;
        
        /**
         * *** HO778 = SUBCONTA PARA JUROS DEVEDORES INVALIDA
         */
        @Data(size=3, signed=true, value="778")
        IInt subcontaJdvInval() ;
        
        /**
         * *** HO779 = DATA DE REABERTURA DA SUBCONTA INVALIDA
         */
        @Data(size=3, signed=true, value="779")
        IInt dtRabertSctaInval() ;
        
        /**
         * *** HO783 = FUNCAO SO DISPONIVEL PARA CONTA A ORDEM
         */
        @Data(size=3, signed=true, value="783")
        IInt cTipoTrttError() ;
        
        /**
         * *** HO785 = SUBCONTA JA ASSOCIADA
         */
        @Data(size=3, signed=true, value="785")
        IInt sctaJaAssoc() ;
        
        /**
         * *** HO786 = ASSOCIACAO NAO E DE CASH-MANAGEMENT
         */
        @Data(size=3, signed=true, value="786")
        IInt assocNaoCm() ;
        
        /**
         * *** HO787 = GRUPO CASH INCORRECTO
         */
        @Data(size=3, signed=true, value="787")
        IInt nsGrupCashDif() ;
        
        /**
         * *** HO788 = SUBCONTA NAO ASSOCIADA
         */
        @Data(size=3, signed=true, value="788")
        IInt sctaNaoAssoc() ;
        
        /**
         * *** HO789 = NAO E POSSIVEL ELIMINAR A SUBCONTA AGREGADORA DO GRUPO
         */
        @Data(size=3, signed=true, value="789")
        IInt impossElimCtaAggx() ;
        
        /**
         * *** HO790 = GRUPO SEM SUBCONTA AGREGADORA
         */
        @Data(size=3, signed=true, value="790")
        IInt grupoSemCtaAggx() ;
        
        /**
         * *** HO791 = DATA DE CRIACAO DO GRUPO CASH DIFERENTE
         * ***         DA DATA DO DIA
         */
        @Data(size=3, signed=true, value="791")
        IInt zCrizGcDifZDia() ;
        
        /**
         * *** HO792 = CALCULO DE JUROS INVALIDO
         */
        @Data(size=3, signed=true, value="792")
        IInt calJurInvalidos() ;
        
        /**
         * *** HO793 = ASSOCIACAO NAO E DE CASH-POOLING
         */
        @Data(size=3, signed=true, value="793")
        IInt assocNaoCp() ;
        
        /**
         * *** HO794 = CONTA/SUBCONTA TEMPORARIAMENTE INDISPONIVEL
         */
        @Data(size=3, signed=true, value="794")
        IInt subcontaBloqueada() ;
        
        /**
         * *** HO812 = TRANCHE DE RADICAIS NAO EXISTE
         */
        @Data(size=3, signed=true, value="812")
        IInt trancheRadicalInex() ;
        
        /**
         * *** HO815 = TRANCHE DE RADICAIS JA EXISTE
         */
        @Data(size=3, signed=true, value="815")
        IInt trancheRadicalExis() ;
        
        /**
         * *** HO816 = VALOR MINIMO DA TRANCHE INVALIDO
         */
        @Data(size=3, signed=true, value="816")
        IInt valMinTrancheInv() ;
        
        /**
         * *** HO817 = VALOR MAXIMO DA TRANCHE INVALIDO
         */
        @Data(size=3, signed=true, value="817")
        IInt valMaxTrancheInv() ;
        
        /**
         * *** HO839 = DESCOBERTO AUTORIZADO CANCELADO
         */
        @Data(size=3, signed=true, value="839")
        IInt dcboNgcdInactivo() ;
        
        /**
         * *** HO840 = DESCOBERTO AUTORIZADO NAO EXISTE
         */
        @Data(size=3, signed=true, value="840")
        IInt dcboNgcdInexistente() ;
        
        /**
         * *** HO841 = MONTANTE NAO CUMPRE O DEFINIDO NO CATALOGO
         */
        @Data(size=3, signed=true, value="841")
        IInt montDcboNgcdNStnd() ;
        
        /**
         * *** HO842 = DESCOB. AUTORIZADO NAO PERMITE RENOVACAO AUTOMATICA
         */
        @Data(size=3, signed=true, value="842")
        IInt dcboNgcdNaoRenova() ;
        
        /**
         * *** HO844 = PRAZO NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="844")
        IInt przDcboNgcdNAlt() ;
        
        /**
         * *** HO845 = REFERENCIA JA EXISTE
         */
        @Data(size=3, signed=true, value="845")
        IInt refExistente() ;
        
        /**
         * *** HO846 = NUMERO DE PROCESSO DE TRIBUNAL OBRIGATORIO
         */
        @Data(size=3, signed=true, value="846")
        IInt numProcTribObrg() ;
        
        /**
         * *** HO847 = SUBCONTA DE DEPOSITOS OBRIGATORIOS NAO EXISTE
         */
        @Data(size=3, signed=true, value="847")
        IInt sctaDobrigNaoEx() ;
        
        /**
         * ***HO105 = ENCARGO PENDENTE NAO EXISTE
         */
        @Data(size=3, signed=true, value="848")
        IInt pendEncgNExit() ;
        
        /**
         * *** HO851 = OCORRENCIA NAO EXISTE
         */
        @Data(size=3, signed=true, value="851")
        IInt ocorrNaoExiste() ;
        
        /**
         * *** HO853 = OCORRENCIA NAO ESTA ACTIVA
         */
        @Data(size=3, signed=true, value="853")
        IInt ocorrNaoActiva() ;
        
        /**
         * *** HO854 = OCORRENCIA COM MOVIMENTO ASSOCIADO
         */
        @Data(size=3, signed=true, value="854")
        IInt ocorrNsMovAssd() ;
        
        /**
         * *** HO855 = PRODUTO DA SUBCONTA NAO PERMITE OBJECTOS
         */
        @Data(size=3, signed=true, value="855")
        IInt prdSctaNPermObj() ;
        
        /**
         * *** HO857 = DATAS DE LIQUIDACAO NAO PERMITEM ALTERACAO
         * ***         SIMULTANEA DAS PERIODICIDADES
         */
        @Data(size=3, signed=true, value="857")
        IInt x2PedidosAltInval() ;
        
        /**
         * *** HO858 = CONTA INVALIDA PARA OPERACAO
         */
        @Data(size=3, signed=true, value="858")
        IInt ctaInvalParaOpx() ;
        
        /**
         * *** HO859 = ESTADO DA SUBCONTA INVALIDO
         */
        @Data(size=3, signed=true, value="859")
        IInt estSctaInval() ;
        
        /**
         * *** HO860 = SUBCONTA SEM ASSOCIACOES
         */
        @Data(size=3, signed=true, value="860")
        IInt sctaSemAssoc() ;
        
        /**
         * *** HO864 = NEGOCIACAO SEM ESCALOES
         */
        @Data(size=3, signed=true, value="864")
        IInt escalaoNExiste() ;
        
        /**
         * *** HO870 = ELIMINACAO NAO PERMITIDA
         */
        @Data(size=3, signed=true, value="870")
        IInt eliminNPermitida() ;
        
        /**
         * *** HO873 = CONTA SUPORTE NAO EXISTE
         */
        @Data(size=3, signed=true, value="873")
        IInt doSuporteInex() ;
        
        /**
         * *** HO876 = JURO PAGO
         */
        @Data(size=3, signed=true, value="876")
        IInt juroPago() ;
        
        /**
         * *** HO877 = PRODUTO NAO EXISTE
         */
        @Data(size=3, signed=true, value="877")
        IInt produtoInex() ;
        
        /**
         * *** HO878 = JURO NAO EXISTE
         */
        @Data(size=3, signed=true, value="878")
        IInt juroInexistente() ;
        
        /**
         * *** HO879 = ENCARGO MAL CALCULADO
         */
        @Data(size=3, signed=true, value="879")
        IInt encargoMalCalc() ;
        
        /**
         * *** HO880 = CONTA SUPORTE INVALIDA
         */
        @Data(size=3, signed=true, value="880")
        IInt doSuporteInval() ;
        
        /**
         * *** HO881 = DATA VALOR DE ABERTURA INVALIDA
         */
        @Data(size=3, signed=true, value="881")
        IInt dtValorAberInval() ;
        
        /**
         * *** HO882 = TIPO DE CONTA INVALIDO PARA O PRODUTO
         */
        @Data(size=3, signed=true, value="882")
        IInt tipoContInvalProd() ;
        
        /**
         * *** HO883 = PRODUTO NAO RELACIONADO
         */
        @Data(size=3, signed=true, value="883")
        IInt prodNaoRelacionado() ;
        
        /**
         * *** HO884 = RELACAO COM PRODUTO OBRIGATORIA
         */
        @Data(size=3, signed=true, value="884")
        IInt relProdObrigatorio() ;
        
        /**
         * *** HO885 = QUANTIDADE DE INTERVENIENTES INVALIDA
         */
        @Data(size=3, signed=true, value="885")
        IInt qIntervInvalida() ;
        
        /**
         * *** HO886 = QUANTIDADE DE TITULARES EXCEDIDA
         */
        @Data(size=3, signed=true, value="886")
        IInt quantTitExcedida() ;
        
        /**
         * *** HO887 = QUEDA JA EFECTUADA
         */
        @Data(size=3, signed=true, value="887")
        IInt quedaJaEfectuada() ;
        
        /**
         * *** HO888 = DEVE EFECTUAR ANULACAO DO REGISTO NA
         * ***         TABELA THO00036_IMPOSTOS
         */
        @Data(size=3, signed=true, value="888")
        IInt deveEfectAnlzDReg() ;
        
        /**
         * *** HO889 = CONTA CANCELADA ANTES DA MIGRACAO
         */
        @Data(size=3, signed=true, value="889")
        IInt ctaCancAntesMigrac() ;
        
        /**
         * *** HO890 = OE GESTOR NÂ†O AUTORIZADO
         */
        @Data(size=3, signed=true, value="890")
        IInt oeGestorNAut() ;
        
        /**
         * *** HO892 = ALTERACAO CONTA SUPORTADA INVALIDA
         */
        @Data(size=3, signed=true, value="892")
        IInt altSptadaInvalida() ;
        
        /**
         * *** HO893 = GESTOR DA CONTA SUPORTE DIFERENTE
         */
        @Data(size=3, signed=true, value="893")
        IInt gestorSpteDif() ;
        
        /**
         * *** HO894 = INDICADOR DE CLASSIFICACAO DA CONTA INVALIDO
         */
        @Data(size=3, signed=true, value="894")
        IInt iClszInvalido() ;
        
        /**
         * *** HO895 = QUANTIDADE DE DOMICILIACOES DIFERENTE DE ZERO
         */
        @Data(size=3, signed=true, value="895")
        IInt qAutDeDomNotzero() ;
        
        /**
         * *** HO896 = VALOR A COBRANCA CANCELADO
         */
        @Data(size=3, signed=true, value="896")
        IInt pendenteCancelado() ;
        
        /**
         * *** HO897 = CONTA SEM SUPORTE/CONTA SUPORTE
         */
        @Data(size=3, signed=true, value="897")
        IInt contaSemSpte() ;
        
        /**
         * *** HO898 = MONTANTE CREDOR INVALIDO
         */
        @Data(size=3, signed=true, value="898")
        IInt mCredInvalido() ;
        
        /**
         * *** HO899 = MOVIMENTO INVALIDO
         */
        @Data(size=3, signed=true, value="899")
        IInt movimentoInval() ;
        
        /**
         * *** HO900 = CONTA TEM CONTAS SUPORTADAS
         */
        @Data(size=3, signed=true, value="900")
        IInt ctaTemSctaSptdas() ;
        
        /**
         * *** HO901 = SUBCONTA PARA JUROS CREDORES INVALIDA
         */
        @Data(size=3, signed=true, value="901")
        IInt sctaJcrxInval() ;
        
        /**
         * *** HO902 = SUBCONTA PARA JUROS DEVEDORES INVALIDA
         */
        @Data(size=3, signed=true, value="902")
        IInt sctaJdvxInval() ;
        
        /**
         * *** HO903 = INDICADOR DE RENOVACAO INCOMPATIVEL COM CATALOGO
         */
        @Data(size=3, signed=true, value="903")
        IInt iRnvzIncompCat() ;
        
        /**
         * *** HO904 = INDICADOR DE CAPITALIZACÂ†O INCOMPATIVEL COM CATALOGO
         */
        @Data(size=3, signed=true, value="904")
        IInt iCapzIncompCat() ;
        
        /**
         * *** HO906 = PRODUTO DIFERENTE DO DA CONTA
         */
        @Data(size=3, signed=true, value="906")
        IInt prodDifCta() ;
        
        /**
         * *** HO907 = MOEDA DIFERENTE DA DA CONTA
         */
        @Data(size=3, signed=true, value="907")
        IInt moedaDifCta() ;
        
        /**
         * *** HO908 = DATA DE ABERTURA DE SUBCONTA INVALIDA
         */
        @Data(size=3, signed=true, value="908")
        IInt dtAbertSctaInval() ;
        
        /**
         * *** HO913 = SUBCONTA JA EXISTE
         */
        @Data(size=3, signed=true, value="913")
        IInt sctaJaExiste() ;
        
        /**
         * *** HO916 = SUBCONTA NAO CANCELADA
         */
        @Data(size=3, signed=true, value="916")
        IInt sctaNaoCancelada() ;
        
        /**
         * *** HO917 = PEDIDO DE AUTORIZACAO PARA APROVACAO DE ESCALOES
         */
        @Data(size=3, signed=true, value="917")
        IInt pedAutAprovEscal() ;
        
        /**
         * *** HO920 = EXISTEM CATIVOS ACTIVOS
         */
        @Data(size=3, signed=true, value="920")
        IInt existemCativo() ;
        
        /**
         * *** HO924 = EXISTE PEDIDO DE ALTERACAO DE PRODUTO PENDENTE
         */
        @Data(size=3, signed=true, value="924")
        IInt existPedAltProd() ;
        
        /**
         * *** HO931 = OBJECTO NAO EXISTE
         */
        @Data(size=3, signed=true, value="931")
        IInt objectoNaoExiste() ;
        
        /**
         * *** HO933 = A SUBCONTA JA TEM UM OBJECTO
         */
        @Data(size=3, signed=true, value="933")
        IInt jaExObjSubconta() ;
        
        /**
         * *** HO939 = DADOS DE INPUT MAL FORMATADOS
         */
        @Data(size=3, signed=true, value="939")
        IInt inputInsuf() ;
        
        /**
         * *** HO940 = PEDIDO DE TRANSFERENCIA NAO EXISTE
         */
        @Data(size=3, signed=true, value="940")
        IInt pedTranFutInex() ;
        
        /**
         * *** HO941 = INDICADOR DE ESTADO DO PRE-AVISO DIFERENTE
         * ***         DE 'P' - A PROCESSAR.
         */
        @Data(size=3, signed=true, value="941")
        IInt pedComEsInvAccao() ;
        
        /**
         * *** HO942 = DADOS INCOERENTES NA QUANTIDADE DE DIAS DE PRE-AVISO
         */
        @Data(size=3, signed=true, value="942")
        IInt operPorAplTran() ;
        
        /**
         * *** HO947 = MOVIMENTO DE GUIAS DE TRIBUNAL INEXISTENTE
         */
        @Data(size=3, signed=true, value="947")
        IInt movGtrblInexist() ;
        
        /**
         * *** HO949 = PAGAMENTO DE GUIAS DE TRIBUNAL ANULADO
         */
        @Data(size=3, signed=true, value="949")
        IInt gtAnulada() ;
        
        /**
         * *** HO950 = DATA DE ANULACAO INVALIDA
         */
        @Data(size=3, signed=true, value="950")
        IInt dataAnulInvalida() ;
        
        /**
         * *** HO952 = CHECKDIGITO INVALIDO
         */
        @Data(size=3, signed=true, value="952")
        IInt checkdigitoInvalido() ;
        
        /**
         * *** HO953 = ALTERACAO DE PRODUTO NAO EFECTUADA
         */
        @Data(size=3, signed=true, value="953")
        IInt errNoutraScta() ;
        
        /**
         * *** HO955 = SALDO CONTABILISTICO NEGATIVO
         */
        @Data(size=3, signed=true, value="955")
        IInt sldoCbloNegativo() ;
        
        /**
         * *** HO956 = SUBCONTA COM CATIVOS
         */
        @Data(size=3, signed=true, value="956")
        IInt comRetencaoSldo() ;
        
        /**
         * *** HO957 = SUBCONTA COM VALORES A COBRANÃƒA
         */
        @Data(size=3, signed=true, value="957")
        IInt comPendenteCobranca() ;
        
        /**
         * *** HO959 = SUBCONTA RELACIONADA
         */
        @Data(size=3, signed=true, value="959")
        IInt relacionadaDeOutra() ;
        
        /**
         * *** HO960 = SUBCONTA COM ASSOCIACOES
         */
        @Data(size=3, signed=true, value="960")
        IInt sctaComAssociacao() ;
        
        /**
         * *** HO961 = SUBCONTA COM DIVIDA PENDENTE
         */
        @Data(size=3, signed=true, value="961")
        IInt comDividaPendente() ;
        
        /**
         * *** HO962 = SUBCONTA COM CONTA CORRENTE ASSOCIADA
         */
        @Data(size=3, signed=true, value="962")
        IInt comContaCorrente() ;
        
        /**
         * *** HO964 = SUBCONTA COM IMPOSTO SOBRE SALDO MEDIO MENSAL
         * ***         DEVEDOR PENDENTE
         */
        @Data(size=3, signed=true, value="964")
        IInt impSldoMdioPendent() ;
        
        /**
         * *** HO965 = SUBCONTA COM SEGUROS ASSOCIADOS
         */
        @Data(size=3, signed=true, value="965")
        IInt comServicosAssociad() ;
        
        /**
         * *** HO967 = ULTIMA CONTA ESTA RELACIONADA COM OUTRA
         */
        @Data(size=3, signed=true, value="967")
        IInt ultContaERelacnada() ;
        
        /**
         * *** HO968 = DADOS INVALIDOS
         */
        @Data(size=3, signed=true, value="968")
        IInt erroDiasPreaviso() ;
        
        /**
         * *** HO970 = DADOS INVALIDOS
         */
        @Data(size=3, signed=true, value="970")
        IInt erroCondzMovimenta() ;
        
        /**
         * *** HO971 = O ESTORNO NAO E POSSIVEL
         */
        @Data(size=3, signed=true, value="971")
        IInt estornoNaoPossivel() ;
        
        /**
         * *** HO972 = IMPOSTO A REGULARIZAR DIFERENTE DO CALCULADO
         */
        @Data(size=3, signed=true, value="972")
        IInt regImpDifCalc() ;
        
        /**
         * *** HO973 = JUROS JA LANCADOS
         */
        @Data(size=3, signed=true, value="973")
        IInt jurosPagos() ;
        
        /**
         * *** HO974 = SUBCONTA COM JUROS QUE AGUARDAM LANCAMENTO/COBRANCA
         */
        @Data(size=3, signed=true, value="974")
        IInt jurosAguardamLanc() ;
        
        /**
         * *** HO975 = SUBCONTA COM JUROS PENDENTES
         */
        @Data(size=3, signed=true, value="975")
        IInt jurosPendentes() ;
        
        /**
         * *** HO976 = SUBCONTA COM ENCARGOS PENDENTES DE COBRANCA
         */
        @Data(size=3, signed=true, value="976")
        IInt encargosPendentes() ;
        
        /**
         * *** HO977 = DADOS INVALIDOS
         */
        @Data(size=3, signed=true, value="977")
        IInt nContInvalida() ;
        
        /**
         * *** HO978 = DADOS ALTERADOS POR OUTROS UTILIZADOR; VOLTE A
         * ***          CONSULTAR
         */
        @Data(size=3, signed=true, value="978")
        IInt dadosAlterados() ;
        
        /**
         * *** HO979 = DADOS INVALIDOS
         */
        @Data(size=3, signed=true, value="979")
        IInt dadosMalFormatados() ;
        
        /**
         * *** HO980 = ACCAO NAO PERMITIDA PARA CONTAS CASH CARRY
         */
        @Data(size=3, signed=true, value="980")
        IInt ctaCashCarry() ;
        
        /**
         * *** HO986 = VALOR A COBRANCA NAO EXISTE
         */
        @Data(size=3, signed=true, value="986")
        IInt pendenteInex() ;
        
        /**
         * *** HO994 = PRECATORIO ANULADO
         */
        @Data(size=3, signed=true, value="994")
        IInt precatorioAnulado() ;
        
        /**
         * *** HO987 = SALDO DEP SUPERIOR AO PERMITIDO
         */
        @Data(size=3, signed=true, value="987")
        IInt sldoSupPermitido() ;
        
        /**
         * *** HO991 = EXISTE MOVIMENTO PARA O PERIODO
         */
        @Data(size=3, signed=true, value="991")
        IInt existMovPeriodo() ;
        
        /**
         * *** HO995 = SUBCONTAS DIFERENTES
         */
        @Data(size=3, signed=true, value="995")
        IInt sctasDiferentes() ;
        
        /**
         * *** HO996 = JUSTIFICACAO OBRIGATORIA
         */
        @Data(size=3, signed=true, value="996")
        IInt jstzObrigatoria() ;
        
        /**
         * *** HO997 = MONTANTE CONDICIONAL DE DEPOSITO OBRIGATORIO NEGATIVO
         */
        @Data(size=3, signed=true, value="997")
        IInt mCondNegativo() ;
        
        /**
         * *** HO998 = MONT CONDICIONAL DAS OCORRENCIAS EXCEDE MONT
         * ***         CONDICIONAL DO DEPOSITO OBRIGATORIO
         */
        @Data(size=3, signed=true, value="998")
        IInt mCondExecMDep() ;
        
        /**
         * *** HO-001 = SUBCONTA COM PREMIOS PENDENTES DE ENTREGA
         */
        @Data(size=3, signed=true, value="-1")
        IInt premiosPorEntregar() ;
        
        /**
         * *** AUTORIZACAO PARA ANULACAO COBRANCA ENCARGOS
         */
        @Data(size=3, signed=true, value="990")
        IInt autorizAnulEncg() ;
        
        /**
         * *** HO-002 = SUBCONTA COM CHEQUES ACTIVOS
         */
        @Data(size=3, signed=true, value="-2")
        IInt chequesActivos() ;
        
        /**
         * *** HO-003 = SUBCONTA COM TRANSFERENCIAS PENDENTES
         */
        @Data(size=3, signed=true, value="-3")
        IInt transfFutur() ;
        
        /**
         * *** HO-005 = PRACATORIO JA PAGO
         */
        @Data(size=3, signed=true, value="-5")
        IInt precatorioJaPago() ;
        
        /**
         * *** HO-006 = O PRECATORIO JA SE ENCONTRA COM O ESTADO PRETENDIDO
         */
        @Data(size=3, signed=true, value="-6")
        IInt precComEstadoIgual() ;
        
        /**
         * *** HO-007 = MONTANTE DO PERCATÃ“RIO INCORRECTO
         */
        @Data(size=3, signed=true, value="-7")
        IInt montPrecatorioIncor() ;
        
        /**
         * *** HOM008 = TIPO DE CHEQUE INVALIDO
         */
        @Data(size=3, signed=true, value="-8")
        IInt tipoChequeInvalido() ;
        
        /**
         * *** HO-009 = PRECATORIO CATIVO
         */
        @Data(size=3, signed=true, value="-9")
        IInt precatorioCativo() ;
        
        /**
         * *** HO-010 = IMPOSTO DE SELO JA PAGO
         */
        @Data(size=3, signed=true, value="-10")
        IInt impostoSeloJaPago() ;
        
        /**
         * *** HO-011 = CONTA NAO E DE OBJECTO
         */
        @Data(size=3, signed=true, value="-11")
        IInt tipoContaNaoEObj() ;
        
        /**
         * *** HO-012 = NUMERO DE PRECATORIO OBRIGATORIO
         */
        @Data(size=3, signed=true, value="-12")
        IInt nPrecNaoPreenchido() ;
        
        /**
         * *** HO-013 = NUMERO DE PRECATORIO NAO PREENCHIVEL
         */
        @Data(size=3, signed=true, value="-13")
        IInt preenchNPrecNPerm() ;
        
        /**
         * *** HO-014 = OBJECTO NAO PERTENCE A CONTA
         */
        @Data(size=3, signed=true, value="-14")
        IInt objectoNaoEDaCta() ;
        
        /**
         * *** HO-015 = PRODUTO NAO PERMITE PRECATORIO DE JUROS
         */
        @Data(size=3, signed=true, value="-15")
        IInt ctaNPermPrecJuros() ;
        
        /**
         * *** HO-016 = PRECATORIO DE CAPITAL NAO EXISTE
         */
        @Data(size=3, signed=true, value="-16")
        IInt precCapitalNExiste() ;
        
        /**
         * *** HO-018 = MONTANTE DE PRACATORIO SUPERIOR AO SALDO DISPONIVEL
         */
        @Data(size=3, signed=true, value="-18")
        IInt montPrecSupPermitd() ;
        
        /**
         * *** HO-019 = MONTANTE CONDICIONAL NAO PERMITIDO
         */
        @Data(size=3, signed=true, value="-19")
        IInt montCndlNaoPermit() ;
        
        /**
         * *** HO-020 = PRODUTO NAO PERMITE DEPOSITOS CONDICIONAIS
         */
        @Data(size=3, signed=true, value="-20")
        IInt deposCndlNaoPermit() ;
        
        /**
         * *** HO-021 = MONTANTE NAO PERMITIDO PARA O TIPO DE PRECATORIO
         */
        @Data(size=3, signed=true, value="-21")
        IInt mPrecInputNaoPerm() ;
        
        /**
         * *** HO-022 = INTRODUZA AUTORIZACAO PARA DEPOSITOS CONDICIONAIS
         */
        @Data(size=3, signed=true, value="-22")
        IInt autzNecMontPrec() ;
        
        /**
         * *** HO-023 = INTRODUZA MONTANTE DO PERCATORIO
         */
        @Data(size=3, signed=true, value="-23")
        IInt mtPrecInputObrigat() ;
        
        /**
         * *** HO-024 = ESTORNO JA EFECTUADO
         */
        @Data(size=3, signed=true, value="-24")
        IInt estornoGtrbJaEfect() ;
        
        /**
         * *** HO-025 = A SUBCONTA E PARA DEPOSITO DE OBJECTOS
         */
        @Data(size=3, signed=true, value="-25")
        IInt sctaDpobObjecto() ;
        
        /**
         * *** HO-044 = ANULACAO DE MOVIMENTO DE GUIAS DE TRIBUNAL ESTORNADO
         */
        @Data(size=3, signed=true, value="-44")
        IInt anulGtrbEstornada() ;
        
        /**
         * *** HO-045 = ESTADO DO MOVIMENTO DE GUIAS DE TRIBUNAL INVALIDO
         */
        @Data(size=3, signed=true, value="-45")
        IInt estMovGtrbInvalido() ;
        
        /**
         * *** HO-046 = SUBCONTA COM ENCARGOS PENDENTES DE COBRANCA
         */
        @Data(size=3, signed=true, value="-46")
        IInt sctaComEncPend() ;
        
        /**
         * *** HO-047 = SUBCONTA COM DESPESAS DE MANUTENCAO
         * ***          POR COBRAR ASSOCIADAS
         */
        @Data(size=3, signed=true, value="-47")
        IInt sctaComDespManut() ;
        
        /**
         * *** HO-048 = SUBCONTA COM CONTAS A MARGEM ACTIVAS ASSOCIADAS
         */
        @Data(size=3, signed=true, value="-48")
        IInt sctaComLimCtaMrg() ;
        
        /**
         * *** HO-049 = SUBCONTA COM DESCOBERTOS AUTORIZADOS
         * ***          ACTIVOS ASSOCIADOS
         */
        @Data(size=3, signed=true, value="-49")
        IInt sctaComDcboNgcd() ;
        
        /**
         * *** HO-050 = SUBCONTA COM JUROS POR BENS PENDENTES
         */
        @Data(size=3, signed=true, value="-50")
        IInt sctaComJurosBem() ;
        
        /**
         * *** HO-051 = SUBCONTA COM ORDENS DE TRANSFERENCIA ASSOCIADAS
         */
        @Data(size=3, signed=true, value="-51")
        IInt sctaComOrdemTrfc() ;
        
        /**
         * *** HO-052 = PEDIDO DE ALTERACAO DE OE JA EXISTENTE
         */
        @Data(size=3, signed=true, value="-52")
        IInt pedAltBalcaoExist() ;
        
        /**
         * *** HO-053 = SUBCONTA COM AUTORIZACOES DE DOMICILIACAO ASSOCIADAS
         */
        @Data(size=3, signed=true, value="-53")
        IInt sctaComAtrzDomz() ;
        
        /**
         * *** HO-054 = MONTANTE A REGULARIZAR SUPERIOR AO CALCULADO
         */
        @Data(size=3, signed=true, value="-54")
        IInt mRgzzSupCalc() ;
        
        /**
         * *** HO-057 = PAGAMENTO JUROS CREDORES EM ESPECIE INVALIDO
         */
        @Data(size=3, signed=true, value="-57")
        IInt frmPagJcrxEspecie() ;
        
        /**
         * *** HO-058 = CONTA SEM PENDENTES
         */
        @Data(size=3, signed=true, value="-58")
        IInt ctaSemPend() ;
        
        /**
         * *** HO-059 = MONTANTE A REGULARIZAR SUPERIOR AO PENDENTE
         */
        @Data(size=3, signed=true, value="-59")
        IInt montSupPend() ;
        
        /**
         * *** HO-060 = TSU JA PAGO
         */
        @Data(size=3, signed=true, value="-60")
        IInt tsuPago() ;
        
        /**
         * *** HO-061 = PAGAMENTO DE TSU NAO EXISTE
         */
        @Data(size=3, signed=true, value="-61")
        IInt pagamTsuInexist() ;
        
        /**
         * *** HO-062 = SITUACAO DE TSU INCOMPATIVEL
         */
        @Data(size=3, signed=true, value="-62")
        IInt sitTsuIncompativel() ;
        
        /**
         * *** HO-063 = TIPO DE PAGAMENTO NAO CORRIGIVEL
         */
        @Data(size=3, signed=true, value="-63")
        IInt tipoPagNCorrigivel() ;
        
        /**
         * *** HO-064 = DUC JA PAGO
         */
        @Data(size=3, signed=true, value="-64")
        IInt ducPago() ;
        
        /**
         * *** HO-065 = ANULACAO DE TSU NAO EXISTE
         */
        @Data(size=3, signed=true, value="-65")
        IInt anulTsuNExiste() ;
        
        /**
         * *** HO-068 = MONTANTE DO SALDO DA VIA DO SUPORTE INVALIDO
         */
        @Data(size=3, signed=true, value="-68")
        IInt mSldoViaInvald() ;
        
        /**
         * *** HO-069 = SUPORTE DA SUBCONTA NAO E CADERNETA
         */
        @Data(size=3, signed=true, value="-69")
        IInt spteDiferCadernt() ;
        
        /**
         * *** HO-070 = VIA DO SUPORTE JA EXISTE
         */
        @Data(size=3, signed=true, value="-70")
        IInt nsViaSptExiste() ;
        
        /**
         * *** HO-071 = VIA DO SUPORTE INACTIVA
         */
        @Data(size=3, signed=true, value="-71")
        IInt nsViaNaoActivo() ;
        
        /**
         * *** HO-072 = VIA NAO EXISTE
         */
        @Data(size=3, signed=true, value="-72")
        IInt nsViaNaoExiste() ;
        
        /**
         * *** HO-074 = SALDO INCORRECTO
         */
        @Data(size=3, signed=true, value="-74")
        IInt saldoIncorrecto() ;
        
        /**
         * *** HO-075 = TIPO DE SUPORTE INVALIDO
         */
        @Data(size=3, signed=true, value="-75")
        IInt spteDiferTitulo() ;
        
        /**
         * *** HO-076 = TITULO JA INICIALIZADO
         */
        @Data(size=3, signed=true, value="-76")
        IInt viaJaExiste() ;
        
        /**
         * *** HO-149 = SUBCONTA NAO EXISTE
         */
        @Data(size=3, signed=true, value="-149")
        IInt subctaNaoExiste() ;
        
        /**
         * *** HO-150 = UTILIZADOR SEM ACESSO
         */
        @Data(size=3, signed=true, value="-150")
        IInt utilSemAcesso() ;
        
        /**
         * *** HO-151 = MOVIMENTO JA UTILIZADO
         */
        @Data(size=3, signed=true, value="-151")
        IInt creditoUtilizado() ;
        
        /**
         * *** HO-256 = MONTANTE DO MOVIMENTO INVALIDO
         */
        @Data(size=3, signed=true, value="-256")
        IInt valorMovInvalido() ;
        
        /**
         * *** HO-257 = MOEDA DO MOVIMENTO INVALIDA
         */
        @Data(size=3, signed=true, value="-257")
        IInt moedaMovInvalida() ;
        
        /**
         * *** HO-258 = CODIGO DE OPERACAO INVALIDO
         */
        @Data(size=3, signed=true, value="-258")
        IInt coperacMovInvalido() ;
        
        /**
         * *** HO-259 = DATA VALOR INVALIDA
         */
        @Data(size=3, signed=true, value="-259")
        IInt dataValorInvalida() ;
        
        /**
         * *** HO-266 = SUBCONTA INVALIDA
         */
        @Data(size=3, signed=true, value="-266")
        IInt valSubconta() ;
        
        /**
         * *** HO-267 = OBRIGATORIO PREENCHER O NUMERO DO CLIENTE
         */
        @Data(size=3, signed=true, value="-267")
        IInt nrClienteAusente() ;
        
        /**
         * *** HO-268 = OBRIGATORIO PREENCHER O MOTIVO DA COE
         */
        @Data(size=3, signed=true, value="-268")
        IInt motivoCoeAusente() ;
        
        /**
         * *** HO-269 = OBRIGATORIO PREENCHER O PAIS ORIGEM/DESTINO DA COE
         */
        @Data(size=3, signed=true, value="-269")
        IInt paisDestCoeAusente() ;
        
        /**
         * *** HO-288 = SALDO DISPONIVEL INSUFICIENTE
         */
        @Data(size=3, signed=true, value="-288")
        IInt montanteInsufCred() ;
        
        /**
         * *** HO-311 = LIMITE DE ESCALOES INVALIDO
         */
        @Data(size=3, signed=true, value="-311")
        IInt limEcloInvalido() ;
        
        /**
         * *** HO-325 = CONTA EM USO
         */
        @Data(size=3, signed=true, value="-325")
        IInt contaEmUso() ;
        
        /**
         * *** HO-356 = MONTANTE DE DESCOBERTO ACIMA DO MAXIMO
         */
        @Data(size=3, signed=true, value="-356")
        IInt mDcboLimInv() ;
        
        /**
         * *** HO-357 = MONTANTE DO DEBITO ABAIXO DO MINIMO
         */
        @Data(size=3, signed=true, value="-357")
        IInt mDebMinInv() ;
        
        /**
         * *** HO-358 = PRODUTO NAO PERMITE UNIFICACAO
         */
        @Data(size=3, signed=true, value="-358")
        IInt prodNaoUnifica() ;
        
        /**
         * *** HO-359 = DADOS TECNICOS INVALIDOS (LINKAGES MAL FORMATADAS)
         */
        @Data(size=3, signed=true, value="-359")
        IInt erroDominio() ;
        
        /**
         * *** HO-360 = QUANTIDADE DE DOMICILIACOES INVALIDA
         */
        @Data(size=3, signed=true, value="-360")
        IInt qDomicilZero() ;
        
        /**
         * CONSTANTES ERROS ASSOCIADOS A ERROS DE AUTORIZ DA ROT MOVIM
         * DATA VALOR DE ABERTURA DE SUBCONTA INVALIDA
         */
        @Data(size=3, signed=true, value="-364")
        IInt atrzZValorAbrScta() ;
        
        /**
         * SALDO CONTABILISTICO INSUFICIENTE
         */
        @Data(size=3, signed=true, value="-365")
        IInt atrzMSldoCbloInd() ;
        
        /**
         * SALDO DISPONVEL INSUFICIENTE
         */
        @Data(size=3, signed=true, value="-366")
        IInt atrzMSldoDpnlInd() ;
        
        /**
         * PENDENTES DE COBRANCA ACTIVOS
         */
        @Data(size=3, signed=true, value="-367")
        IInt atrzPendCobAct() ;
        
        /**
         * AUTORIZACAO PARA EXECUTAR PRIMEIRO MOVIMENTO DA SCTA
         */
        @Data(size=3, signed=true, value="-368")
        IInt atrzPrimeiroMovim() ;
        
        /**
         * AUTORIZACAO PARA DESPREZAR DIAS DE PRE-AVISO
         */
        @Data(size=3, signed=true, value="-369")
        IInt atrzDPavs() ;
        
        /**
         * *** HO-370 = DADOS DE MORA INVALIDOS PARA JUROS CREDORES
         */
        @Data(size=3, signed=true, value="-370")
        IInt dadosJmoraInvalidos() ;
        
        /**
         * *** INDICADOR DE ORIGEM DE FUNDO INVALIDO
         */
        @Data(size=3, signed=true, value="-371")
        IInt iOrigFndoInval() ;
        
        /**
         * *** DURACAO NAO ALTERAVEL PARA O TIPO TRATAMENTO DE CONTA
         */
        @Data(size=3, signed=true, value="-372")
        IInt durNaoAlter() ;
        
        /**
         * *** MONTANTE DE DESCOBERTO MOVIMENTOS VIA SIBS NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-373")
        IInt movSibsNaoAlter() ;
        
        /**
         * *** MONTANTE DE DESCOBERTO PARA DOMICILIACOES NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-374")
        IInt movDomzNaoAlter() ;
        
        /**
         * *** MONTANTE DE DESCOBERTO PARA VALOR-EM-COBRANCA NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-375")
        IInt movVcobNaoAlter() ;
        
        /**
         * ** MONTANTE DE DESCOBERTO PARA ACTIVOS FINANCEIROS NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-376")
        IInt movActfNaoAlter() ;
        
        /**
         * *** TIPO TRATAMENTO DE CONTA NAO PERMITE EXTRACTO SWIFT
         */
        @Data(size=3, signed=true, value="-377")
        IInt ctaNaoExtractSwif() ;
        
        /**
         * CODIGO CONDICOES MOVIMENTACAO DA CONTA NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-378")
        IInt dadosNaoAlterCndz() ;
        
        /**
         * NUMERO TOTAL TITULARES CONTA NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-379")
        IInt dadosNaoAlterTitc() ;
        
        /**
         * *** INDICADOR AUTORIZACAO ASSINATURA FAX NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-380")
        IInt dadosNaoAlterFax() ;
        
        /**
         * *** NUMERO FAX PARA CONTACTO NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-381")
        IInt dadosNaoAlterCtco() ;
        
        /**
         * *** INDICADOR EXISTENCIA DE CONTRATO NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-382")
        IInt dadosNaoAlterFisi() ;
        
        /**
         * *** INDICADOR EXISTENCIA OBSERVACAO CONTA  NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-383")
        IInt dadosNaoAlterExis() ;
        
        /**
         * *** CODIGO DO CANAL DA CONTA NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-384")
        IInt dadosNaoAlterAces() ;
        
        /**
         * *** CODIGO PAIS CONTA SUPORTE NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-385")
        IInt dadosNaoAlterPais() ;
        
        /**
         * *** MOEDA BASE DA CONTA NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-386")
        IInt dadosNaoAlterMoed() ;
        
        /**
         * *** INDICADOR DE EXTRACTO SWIFT NAO ALTERAVEL
         */
        @Data(size=3, signed=true, value="-387")
        IInt dadosNaoAlterSwif() ;
        
        /**
         * *** ESTADO INEXISTENTE COM A CONTA E MOVIMENTO ASSOCIADO
         */
        @Data(size=3, signed=true, value="-388")
        IInt estadoInexistente() ;
        
        /**
         * *** HO-390 = AS CONTAS DE CREDITO E DE DEBITO SAO IGUAIS
         */
        @Data(size=3, signed=true, value="-390")
        IInt contaCrIgContaDb() ;
        
        /**
         * *** HO-391 = A CONTA NÃƒO SUPORTA O PROTOCOLO - NAO EXISTEM
         * *** RESTRICOES A MOVIMENTACAO
         */
        @Data(size=3, signed=true, value="-391")
        IInt naoExistemRestrMov() ;
        
        /**
         * *** HO-392 = A CONTA JA TEM A RESTRICAO DE CONTA
         * *** RESTRICOES A MOVIMENTACAO
         */
        @Data(size=3, signed=true, value="-392")
        IInt jaExisteRestrMov() ;
        
        /**
         * *** HO-393 = AUTORIZACAO PARA NAO PENALIZAR
         */
        @Data(size=3, signed=true, value="-393")
        IInt autorizNPenaliz() ;
        
        /**
         * *** HO-394 = CHEQUE NAO VISADO
         */
        @Data(size=3, signed=true, value="-394")
        IInt chqNVisado() ;
        
        /**
         * *** HO-395 = ESTADO DE CHEQUE INVALIDO
         */
        @Data(size=3, signed=true, value="-395")
        IInt estChqInv() ;
        
    }
    
}
