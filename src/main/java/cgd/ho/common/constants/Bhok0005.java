package cgd.ho.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhok0005 extends IDataStruct {
    
    /**
     * @return instancia da classe local Eventos
     */
    @Data
    Eventos eventos() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOK0005
     * COPY DE EVENTOS
     * HO E HV
     * 
     * @version 2.0
     * 
     */
    public interface Eventos extends IDataStruct {
        
        /**
         * *EVENTOS COM CODIGO NUMERICO
         */
        @Data(size=4, value="3214")
        IString pagChequesCnp() ;
        
        @Data(size=4, value="3215")
        IString devolImpRendIa() ;
        
        @Data(size=4, value="3216")
        IString movimCtasBlq() ;
        
        @Data(size=4, value="3217")
        IString eventoExtractoSgcc() ;
        
        /**
         * *EVENTO: 2A VIA DE CADERNETA
         */
        @Data(size=4, value="0002")
        IString x2ViaCaderneta() ;
        
        /**
         * *SUBEVENTOS DO EVENTO 2A VIA DE CADERNETA
         */
        @Data(size=4, value="0001")
        IString redeNormal() ;
        
        @Data(size=4, value="0002")
        IString caixapostalNInf() ;
        
        @Data(size=4, value="0003")
        IString caixapostalInform() ;
        
        /**
         * *EVENTO: 2A VIA DE TITULOS DE DEPOSITOS
         */
        @Data(size=4, value="0003")
        IString x2ViaTitulosDep() ;
        
        /**
         * *EVENTO: MINIMO PARA CALCULO DE IMPOSTO SOBRE JUROS
         */
        @Data(size=4, value="0004")
        IString minImpJuros() ;
        
        /**
         * *EVENTO: MOBILIZACAO ANTECIPADA
         */
        @Data(size=4, value="0005")
        IString mobAntecipada() ;
        
        /**
         * *EVENTO: DESPESAS DE MANUTENCAO
         */
        @Data(size=4, value="0006")
        IString despesasManutencao() ;
        
        /**
         * *EVENTO: ENCARGOS DE DUCS
         */
        @Data(size=4, value="0007")
        IString encargosDucs() ;
        
        /**
         * *SUBEVENTOS DO EVENTO ENCARGOS DE DUCS
         */
        @Data(size=4, value="0001")
        IString ducsAutoliq() ;
        
        @Data(size=4, value="0002")
        IString ducsLiqPrev() ;
        
        /**
         * *EVENTO: CASH-MANAGEMENT
         */
        @Data(size=4, value="0008")
        IString evCashManagement() ;
        
        /**
         * *EVENTO: ENCERRAMENTO AUTOMATICO DE SUBCONTA
         */
        @Data(size=4, value="0009")
        IString encerAutomSubc() ;
        
        /**
         * *EVENTO: ENCERRAMENTO AUTOMATICO DE CONTA
         */
        @Data(size=4, value="0010")
        IString encerAutomConta() ;
        
        /**
         * *EVENTO: ACTUALIZACAO DO INDICADOR DE INSUFICIENCIA DE FUNDOS
         */
        @Data(size=4, value="0011")
        IString actIInsFundos() ;
        
        /**
         * *EVENTO: EMISSAO DE DELARACAO ANUAL
         */
        @Data(size=4, value="0017")
        IString emissaoDclAno() ;
        
        /**
         * *EVENTO: INFORMACAO ELECTRONICA PARA DGCI
         */
        @Data(size=4, value="0018")
        IString infElectronicaDgci() ;
        
        /**
         * *EVENTO: MONT MAXIMO PERM REFORCO/SUBSCRICAO DEP ESTR
         */
        @Data(size=4, value="0021")
        IString montMaxPermEstrut() ;
        
        /**
         * *EVENTO: PEDIDO DE EXTRACTO
         */
        @Data(size=4, value="0022")
        IString pedidosExtracto() ;
        
        /**
         * *SUBEVENTOS DO EVENTO PEDIDO DE EXTRACTO
         */
        @Data(size=4, value="0001")
        IString pedExtBalcao() ;
        
        @Data(size=4, value="0002")
        IString reemExtSimp1Fol() ;
        
        @Data(size=4, value="0003")
        IString reemExtComb() ;
        
        @Data(size=4, value="0004")
        IString reemExtSimpFols() ;
        
        @Data(size=4, value="0005")
        IString reemSimpDso1Fol() ;
        
        @Data(size=4, value="0006")
        IString reemSimpDsoFols() ;
        
        /**
         * *EVENTO: PAGAMENTO DE JUROS VENCIDOS
         */
        @Data(size=4, value="0024")
        IString pagJuroVenc() ;
        
        /**
         * *EVENTO: COBRANCA DE JUROS VENCIDOS
         */
        @Data(size=4, value="0025")
        IString cobJuroVenc() ;
        
        /**
         * *EVENTO: PAGAMENTO DE JUROS POR BEM
         */
        @Data(size=4, value="0026")
        IString pagJuroBem() ;
        
        /**
         * *EVENTO: LIQUIDACAO ANTECIPADA
         */
        @Data(size=4, value="0030")
        IString eventLiqzAnt() ;
        
        /**
         * *EVENTO: PASSAGEM DE JUROS VENCIDOS
         */
        @Data(size=4, value="0049")
        IString passagJuroVenc() ;
        
        /**
         * *EVENTO: PAGAMENTO DE JUROS
         */
        @Data(size=4, value="0050")
        IString pagamentoJcrx() ;
        
        /**
         * *EVENTO: COBRANCA DE JUROS
         */
        @Data(size=4, value="0051")
        IString cobrancaJuros() ;
        
        /**
         * *EVENTO: COBRANCA DE IMOBILIZADO
         */
        @Data(size=4, value="0054")
        IString cobrancaImobilizado() ;
        
        /**
         * *EVENTO: COBRANCA DE EXCESSO
         */
        @Data(size=4, value="0055")
        IString cobrancaExcesso() ;
        
        /**
         * *EVENTO: DIARIZACAO INCREMENTAL DE JUROS
         */
        @Data(size=4, value="0056")
        IString diarizacao() ;
        
        /**
         * *EVENTO: MENSUALIZACAO DE DESPESAS DE MANUTENCAO
         */
        @Data(size=4, value="0059")
        IString despManutMensualiz() ;
        
        /**
         * *EVENTO: PASSAGEM A CREDITO INCOBRAVEL
         */
        @Data(size=4, value="0060")
        IString passagCredIncob() ;
        
        /**
         * *EVENTO: DAR CONHECIMENTO DA ENTREGA EM DEPOSITO OBRIGATORIO
         */
        @Data(size=4, value="0061")
        IString conhecimDepObrig() ;
        
        /**
         * *EVENTO: EMISSAO DE EXTRACTO SIMPLES
         */
        @Data(size=4, value="0062")
        IString emissExtrSimples() ;
        
        /**
         * *EVENTO: ALTERACAO DE PRODUTO
         */
        @Data(size=4, value="0063")
        IString altProduto() ;
        
        /**
         * *EVENTO: ALTERACAO LIMITE LDN
         */
        @Data(size=4, value="0065")
        IString altLimLdn() ;
        
        /**
         * *EVENTO: ALTERACAO UTILIZADO LDN
         */
        @Data(size=4, value="0066")
        IString altUtilizLdn() ;
        
        /**
         * *EVENTO: VENCIMENTO DE DEPOSITOS
         */
        @Data(size=4, value="0067")
        IString evVctoSubdepos() ;
        
        /**
         * *EVENTO: RECLASSIFICACAO DE SALDOS DEVEDORES
         */
        @Data(size=4, value="0069")
        IString reclassSldosDv() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - CAPITAL EM DIVIDA VENCIDO
         */
        @Data(size=4, value="0075")
        IString capitalVencido() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - JUROS VENCIDOS EM DIVIDA
         */
        @Data(size=4, value="0076")
        IString juroVencidoDiv() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - COMISSOES VENCIDAS EM DIVIDA
         */
        @Data(size=4, value="0077")
        IString comissaoVencidaDiv() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - DESPESAS VENCIDAS EM DIVIDA
         */
        @Data(size=4, value="0078")
        IString despesaVencidaDiv() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - IMPOSTO EM DIVIDA
         */
        @Data(size=4, value="0079")
        IString impostoDivida() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - JUROS DE MORA EM DIVIDA
         */
        @Data(size=4, value="0080")
        IString juroMoraDivida() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - IMPOSTO SELO DE SALDO MEDIO DEVEDOR
         */
        @Data(size=4, value="0081")
        IString impostoSmd() ;
        
        /**
         * *EVENTO: INCUMPRIMENTO - IMPOSTO SOBRE JURO DE MORA
         */
        @Data(size=4, value="0082")
        IString impostoJmor() ;
        
        /**
         * *EVENTO: CPH MODELO 15
         */
        @Data(size=4, value="0085")
        IString evCphMod15() ;
        
        /**
         * *EVENTO: AVISO DE OPERACOES
         */
        @Data(size=4, value="0088")
        IString avsoOper() ;
        
        /**
         * *EVENTO: CONTAS A MARGEM
         */
        @Data(size=4, value="0089")
        IString evCmrgCtasOrden() ;
        
        /**
         * *EVENTO: MOVIMENTACAO INTER-EMPRESA
         */
        @Data(size=4, value="0090")
        IString movInterEmpresa() ;
        
        /**
         * *EVENTO: MOVIMENTACAO A DEBITO DE CONTAS CORRENTES - DESCATIVACAO
         */
        @Data(size=4, value="0091")
        IString debitoCcDescat() ;
        
        /**
         * *EVENTO: MOVIMENTACAO A DEBITO DE CONTAS CORRENTES - PENDENTES
         */
        @Data(size=4, value="0092")
        IString debitoCcPend() ;
        
        /**
         * *EVENTO: MOVIMENTACAO A DEBITO DE CONTAS CORRENTES
         */
        @Data(size=4, value="0012")
        IString movDebitoCcorrente() ;
        
        /**
         * *EVENTO: ACERTO SALDO A DEBITO DE CONTAS CORRENTES
         */
        @Data(size=4, value="0093")
        IString debitoCcorrentes() ;
        
        /**
         * *EVENTO: MOVIMENTACAO A CREDITO DE CONTAS CORRENTES
         */
        @Data(size=4, value="0013")
        IString movCreditoCcorrente() ;
        
        /**
         * *EVENTO: ACERTO SALDO A CREDITO DE CONTAS CORRENTES
         */
        @Data(size=4, value="0094")
        IString creditoCcorrentes() ;
        
        /**
         * *EVENTO: ENTREGA DE LOTES PARA DESDOBRAMENTO NO CTD
         */
        @Data(size=4, value="0095")
        IString etgaLotesDesdobCtd() ;
        
        /**
         * *EVENTOS DE PAGAMENTOS DE JUROS
         */
        @Data(size=4)
        IString eventosJuros() ;
        @Data
        @Condition({ "0050", "0024", "HVD1", "HVD2", "HVB1" })
        ICondition evenPagJuros() ;
        
        
        /**
         * *EVENTOS DE HO
         * *EVENTO: COM CONTA DORMANT
         */
        @Data(size=4, value="3218")
        IString comContaDormant() ;
        
        /**
         * *EVENTO: ABERTURA DE CONTA
         */
        @Data(size=4, value="HOA1")
        IString eventoAbertura() ;
        
        /**
         * *EVENTO: MANUTENCAO DE TITULARES
         */
        @Data(size=4, value="HOA3")
        IString altNatJur() ;
        
        /**
         * *EVENTO: TRANSFERENCIA DE DEPOSITOS
         */
        @Data(size=4, value="HOB1")
        IString transferencia() ;
        
        /**
         * *EVENTO: ABERTURA DE SUBCONTA
         */
        @Data(size=4, value="HOB7")
        IString abrtScta() ;
        
        /**
         * *SUBEVENTOS DO EVENTO ABERTURA DE SUBCONTA
         */
        @Data(size=4, value="0001")
        IString planoEntregas() ;
        
        @Data(size=4, value="0002")
        IString reforco() ;
        
        @Data(size=4, value="0003")
        IString mMinAbrtScta() ;
        
        @Data(size=4, value="0004")
        IString liquidacaoJurCr() ;
        
        @Data(size=4, value="0005")
        IString reliqJurCr() ;
        
        @Data(size=4, value="0006")
        IString liquidacaoJurDv() ;
        
        @Data(size=4, value="0007")
        IString reliqJurDv() ;
        
        @Data(size=4, value="0008")
        IString maxChqDisp() ;
        
        @Data(size=4, value="0009")
        IString maxModChqReserv() ;
        
        @Data(size=4, value="0011")
        IString retroactAbrtScta() ;
        
        @Data(size=4, value="0012")
        IString primeiroDeposito() ;
        
        @Data(size=4, value="0014")
        IString qDiaRcal() ;
        
        @Data(size=4, value="0016")
        IString fiscalidadeEspec() ;
        
        /**
         * *EVENTO: ALTERACAO DE OE GESTOR
         */
        @Data(size=4, value="HOD3")
        IString altOeEgcGerx() ;
        
        /**
         * *EVENTO: REGULARIZACAO DE JUROS QUE AGUARDAM LANCAMENTO
         */
        @Data(size=4, value="HOE1")
        IString regulJurAguarLanc() ;
        
        /**
         * *EVENTO: REGULARIZACAO DE JUROS PENDENTES DE LANCAMENTO
         */
        @Data(size=4, value="HOE2")
        IString regulJurospendLanc() ;
        
        /**
         * *EVENTO: INDICADOR DE ORIGEM DE FUNDOS EXTERNA
         */
        @Data(size=4, value="OFEX")
        IString indOrigFndoExterna() ;
        
        /**
         * EVENTO: PARAMETRIZACAO DE GRUPO GAT
         */
        @Data(size=4, value="3200")
        IString evGrupoGat() ;
        
        /**
         * *SUBEVENTOS DO EVENTO GRUPO GAT - 3200
         */
        @Data(size=4, value="0001")
        IString gatSldRmncDoCpou() ;
        
        @Data(size=4, value="0002")
        IString gatSldTrfDoCpou() ;
        
        @Data(size=4, value="0003")
        IString gatSldTrfCpouDo() ;
        
        @Data(size=4, value="0004")
        IString gatSldTrfDoCcte() ;
        
        @Data(size=4, value="0005")
        IString gatSldTrfCcteDo() ;
        
        @Data(size=4, value="0006")
        IString gatMTrchTrfCpou() ;
        
        @Data(size=4, value="0007")
        IString gatMTrchTrfCcte() ;
        
        /**
         * EVENTO ENCERRAMENTO CTA GAT - HVE4 - CNTVE4
         */
        @Data(size=4, value="HVE4")
        IString evEncGrupoGat() ;
        
        /**
         * EVENTO: GRUPO GAT - INVESTIMENTO NA POUPANCA
         */
        @Data(size=4, value="3202")
        IString evInvestPoupGat() ;
        
        /**
         * EVENTO: GRUPO GAT - UTILIZACAO DA POUPANCA
         */
        @Data(size=4, value="3203")
        IString evUtilizacaoPpGat() ;
        
        /**
         * EVENTO: LDE
         */
        @Data(size=4, value="3204")
        IString evComEstudo() ;
        
        @Data(size=4, value="3205")
        IString evComContra() ;
        
        @Data(size=4, value="3206")
        IString evComProces() ;
        
        @Data(size=4, value="3207")
        IString evComGestao() ;
        
        @Data(size=4, value="3208")
        IString evComRenova() ;
        
        /**
         * *EVENTOS DE HV
         * *EVENTO: ENTREGA DE NUMERARIO
         */
        @Data(size=4, value="HVA1")
        IString entregaNumerario() ;
        
        /**
         * *EVENTO: LEVANTAMENTO DE NUMERARIO
         */
        @Data(size=4, value="HVA2")
        IString levantNumerario() ;
        
        /**
         * *EVENTO: ENTREGA DE CHEQUE PROPRIO
         */
        @Data(size=4, value="HVA3")
        IString entregaChqProp() ;
        
        /**
         * *EVENTO: ENTREGA MISTA NUMERÃ¡RIO, VALORES E OU TRANSFERENCIA
         */
        @Data(size=4, value="HVA4")
        IString etgaLotesBalcao() ;
        
        /**
         * *EVENTO: ABERTURA DE D.P. COM ENTREGA POR TRANSFERENCIA DE D.O.
         */
        @Data(size=4, value="HVA5")
        IString abertDpPorTrsf() ;
        
        /**
         * *EVENTO: CREDITOS DIVERSOS
         */
        @Data(size=4, value="HVA6")
        IString credDiversos() ;
        
        /**
         * *EVENTO: LEVANTAMENTO DE CHEQUE PROPRIO
         */
        @Data(size=4, value="HVA7")
        IString levantChqProp() ;
        
        /**
         * *EVENTO: DEBITOS DIVERSOS
         */
        @Data(size=4, value="HVA8")
        IString debDiversos() ;
        
        /**
         * *EVENTO: DESCATIVACAO COM DEBITO
         */
        @Data(size=4, value="HVB0")
        IString descatComDebito() ;
        
        /**
         * *EVENTO: CANCELAMENTO DE SUBCONTA
         */
        @Data(size=4, value="HVB1")
        IString cancelamentoScta() ;
        
        /**
         * *EVENTO: LEVANTAMENTO DE CHEQUE VISADO
         */
        @Data(size=4, value="HVB2")
        IString levantChqVisado() ;
        
        /**
         * *EVENTO: TRANSFERENCIA CONTA A CONTA
         */
        @Data(size=4, value="HVB3")
        IString transfCtaACta() ;
        
        /**
         * *EVENTO: INICIALIZACAO DE CADERNETA
         */
        @Data(size=4, value="HVB6")
        IString iniczCaderneta() ;
        
        /**
         * *EVENTO: PAGAMENTO DE PREMIOS
         */
        @Data(size=4, value="HVB7")
        IString pagamPremios() ;
        
        /**
         * *EVENTO: ANULACAO DE PAGAMENTO DE PREMIOS
         */
        @Data(size=4, value="HVB8")
        IString anulPagamPremios() ;
        
        /**
         * *EVENTO: PAGAMENTO/COB DE JUROS ON-LINE
         */
        @Data(size=4, value="HVC4")
        IString pagJurosOnLine() ;
        
        /**
         * *EVENTO: TSU - ANULACAO
         */
        @Data(size=4, value="HVC5")
        IString tsuAnulacao() ;
        
        /**
         * *EVENTO: TSU - NUMERARIO E CHEQUE PROPRIO
         */
        @Data(size=4, value="HVC6")
        IString tsuNumChqProp() ;
        
        /**
         * *EVENTO: TSU - TRANSFERENCIA
         */
        @Data(size=4, value="HVC7")
        IString tsuTransferencia() ;
        
        /**
         * *EVENTO: DEBITO COM QUEDA DE PENDENTES
         */
        @Data(size=4, value="HVC8")
        IString debitoComQuedaPend() ;
        
        /**
         * *EVENTO: GT - ANULACAO DE PRE-PAGAMENTO
         */
        @Data(size=4, value="HVC9")
        IString gtAnulPrePagam() ;
        
        /**
         * *EVENTO: PAGAMENTO/COB DE JUROS VENCIDOS ON-LINE
         */
        @Data(size=4, value="HVD1")
        IString pagJurVencOnLine() ;
        
        /**
         * *EVENTO: REGULARIZACAO DE JUROS PAGOS
         */
        @Data(size=4, value="HVD2")
        IString regulJurosPagos() ;
        
        /**
         * *EVENTO: UNIFICACAO DE DEPOSITOS
         */
        @Data(size=4, value="HVD3")
        IString unificaDeposito() ;
        
        /**
         * *EVENTO: SUBSCRICAO DEPOSITO ESTRUTURADO
         */
        @Data(size=4, value="HVD5")
        IString subscricDepEstrut() ;
        
        /**
         * *EVENTO: PAGAMENTO DE GUIA DE TRIBUNAL POR TRANSFERENCIA
         */
        @Data(size=4, value="HVD6")
        IString gtTransferencia() ;
        
        /**
         * *EVENTO: PAGAMENTO GUIA DE TRIBUNAL POR NUMERARIO E CHQ PROPRIO
         */
        @Data(size=4, value="HVD7")
        IString gtNumChqProp() ;
        
        /**
         * *EVENTO: ANULACAO DE PAGAMENTO DE GUIA DE TRIBUNAL
         */
        @Data(size=4, value="HVD8")
        IString gtAnulacao() ;
        
        /**
         * *EVENTO: PREPAGAMENTO DE CUSTAS POR NUMERARIO E CHQ PROPRIO
         */
        @Data(size=4, value="HVD9")
        IString gtPpNumChqProp() ;
        
        /**
         * *EVENTO: PREPAGAMENTO DE CUSTAS POR TRANSFERENCIA
         */
        @Data(size=4, value="HVE0")
        IString gtPpTransferencia() ;
        
        /**
         * *EVENTO: EXECUCAO - NUMERARIO E CHEQUE PROPRIO
         */
        @Data(size=4, value="HVE1")
        IString execNumChqProp() ;
        
        /**
         * *EVENTO: EXECUCAO COBRANCA - TRANSFERENCIA
         */
        @Data(size=4, value="HVE2")
        IString execTransferencia() ;
        
        /**
         * *EVENTO: EXECUCAO COBRANCA - ANULACAO
         */
        @Data(size=4, value="HVE3")
        IString execAnulacao() ;
        
        /**
         * *EVENTO: LEVANTAMENTO DE CHEQUE BANCARIO
         */
        @Data(size=4, value="HVE5")
        IString levantChequeBancar() ;
        
        /**
         * *EVENTO: PAGAMENTO DE DUC POR NUMERARIO E CHEQUE PROPRIO
         */
        @Data(size=4, value="HVE6")
        IString ducNumChqProp() ;
        
        /**
         * *EVENTO: PAGAMENTO DE DUC POR TRANSFERENCIA
         */
        @Data(size=4, value="HVE7")
        IString ducTransferencia() ;
        
        /**
         * *EVENTO: CORRECCAO DE PAGAMENTO DE DUC
         */
        @Data(size=4, value="HVE8")
        IString ducCorreccao() ;
        
        /**
         * *EVENTO: PAGAMENTO DE IMPOSTO DE SELO SALDO MEDIO DEVEDOR
         */
        @Data(size=4, value="HVE9")
        IString pgImpSeloSmd() ;
        
        /**
         * *EVENTO: SIMULACAO DE DEBITO PARA PRODUTOS COM VENCIMENTO
         */
        @Data(size=4, value="HVF5")
        IString simulacaoDebito() ;
        
        /**
         * *EVENTO: EMISSAO DE PRECATORIO CHEQUE
         */
        @Data(size=4, value="HVK0")
        IString emisPrecatorioCheq() ;
        
        /**
         * *SUBEVENTOS DO EVENTO EMISSAO DE PRECATORIO CHEQUE
         */
        @Data(size=4, value="0001")
        IString isEmisPrecChq() ;
        
        @Data(size=4, value="0002")
        IString encgEmisPrecChq() ;
        
        /**
         * *EVENTO: PAGAMENTO DE PRECATORIO CHEQUE
         */
        @Data(size=4, value="HVK1")
        IString pagPrecatorioCheque() ;
        
        /**
         * *EVENTO: ANULACAO/CATIVACAO/DESACTIVACAO DE PRECATORIO CHEQUE
         */
        @Data(size=4, value="HVK2")
        IString anulPrecatorioChq() ;
        
        /**
         * *EVENTO: ENTREGA DE PRECATORIO CHEQUE
         */
        @Data(size=4, value="HVK3")
        IString entrPrecatorioChq() ;
        
        /**
         * *EVENTO: COBRANCA DE ENCARGOS
         */
        @Data(size=4, value="HVK4")
        IString cobrancaEncg() ;
        
        /**
         * *EVENTO: ENTREGA EM DEPOSITOS ESTRUTURADOS
         */
        @Data(size=4, value="HVK6")
        IString entregaDepEstr() ;
        
        /**
         * *EVENTO: ANULACAO DE DEPOSITOS ESTRUTURADOS
         */
        @Data(size=4, value="HVK7")
        IString anulacaoDepEstr() ;
        
        /**
         * *EVENTO: LEVANTAMENTO DE DEPOSITOS ESTRUTURADOS
         */
        @Data(size=4, value="HVK8")
        IString levantoDepEstr() ;
        
        /**
         * *EVENTO: LEVANTAMENTO DE CHEQUES DA CARTA CHEQUE
         */
        @Data(size=4, value="HVL3")
        IString levantoCchq() ;
        
        /**
         * *EVENTO: LIQUIDACAO DE JUROS DO PROPRIO ANO DE DEP OBRIGATORIOS
         */
        @Data(size=4, value="HVM1")
        IString liqJurAno() ;
        
        /**
         * *EVENTO: LIQUIDACAO DE JUROS DO ANO ANTERIOR DE DEP OBRIGATORIOS
         */
        @Data(size=4, value="HVM2")
        IString liqJurAnoAnt() ;
        
        /**
         * *EVENTOS ASSOCIADOS A ENTREGAS PARA PROTOCOLOS
         * *EVENTO: PROTOCOLO UNIVERSIDADE
         */
        @Data(size=4, value="UNVE")
        IString protocoloUnivers() ;
        
        /**
         * *EVENTO: PROTOCOLO CIRCULO DE LEITORES
         */
        @Data(size=4, value="CLEI")
        IString protocoloCircLeito() ;
        
        /**
         * *EVENTO: PROTOCOLO CHRISTIAN LAY
         */
        @Data(size=4, value="CLAY")
        IString protocoloChristLay() ;
        
        /**
         * *EVENTO: ENTREGA DE LOTES DE VALORES PARA TESOURARIA - TSU
         */
        @Data(size=4, value="TSUG")
        IString etgaLoteValorTsu() ;
        
        /**
         * *EVENTO: ENTREGA DE LOTES DE VALORES PARA TESOURARIA - TSU
         * *ACORES
         */
        @Data(size=4, value="TSUZ")
        IString etgaLoteTsuAcores() ;
        
        /**
         * *EVENTO: ENTREGA PARA ENTIDADES BANCARIAS
         */
        @Data(size=4, value="ENTB")
        IString etgaEntdBancarias() ;
        
    }
    
}
