package cgd.na.structures.work;

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
public interface Bnaw0501 extends IDataStruct {
    
    /**
     * @return instancia da classe local ValTabelasGerais
     */
    @Data
    ValTabelasGerais valTabelasGerais() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BNAW0501 - VARIAVEIS BOOLEANAS, CORRESPONDENTES A VALORES
     * PARAMETRIZADOS EM TABELAS GERAIS
     * 
     * @version 2.0
     * 
     */
    public interface ValTabelasGerais extends IDataStruct {
        
        @Data(size=1)
        IString op103SituacaoOper() ;
        @Data
        @Condition("0")
        ICondition opEmCurso() ;
        @Data
        @Condition("1")
        ICondition opEmAnalise() ;
        @Data
        @Condition("2")
        ICondition opProntaDecisao() ;
        @Data
        @Condition("3")
        ICondition opEmDecisao() ;
        @Data
        @Condition("4")
        ICondition opRecusada() ;
        @Data
        @Condition("5")
        ICondition opAprovada() ;
        @Data
        @Condition("6")
        ICondition opArquivada() ;
        @Data
        @Condition("7")
        ICondition opContratada() ;
        @Data
        @Condition("8")
        ICondition opLiquidada() ;
        @Data
        @Condition("9")
        ICondition opLiqBonzRgzr() ;
        @Data
        @Condition("A")
        ICondition opAbatidaActivo() ;
        @Data
        @Condition("S")
        ICondition opGestaoSuspensa() ;
        @Data
        @Condition("E")
        ICondition opLiquidadaHistoric() ;
        @Data
        @Condition("R")
        ICondition opReactivada() ;
        
        
        @Data(size=2)
        IString rh923TipoRelHrqa() ;
        @Data
        @Condition("20")
        ICondition rhDirGestora() ;
        @Data
        @Condition("21")
        ICondition rhDirComercial() ;
        @Data
        @Condition("22")
        ICondition rhRegiao() ;
        @Data
        @Condition("23")
        ICondition rhBalcSuperior() ;
        
        
        @Data(size=2)
        IString opX11CSitIncump() ;
        @Data
        @Condition("NR")
        ICondition opNormal() ;
        @Data
        @Condition("PC")
        ICondition opPreCtx() ;
        @Data
        @Condition("DC")
        ICondition opDespCtx() ;
        @Data
        @Condition("CJ")
        ICondition opDajCobr() ;
        @Data
        @Condition("CO")
        ICondition opDajOutr() ;
        @Data
        @Condition("AB")
        ICondition opAbatActivo() ;
        @Data
        @Condition("AD")
        ICondition opAbatActivoDaj() ;
        @Data
        @Condition("AI")
        ICondition opAbatIncobravel() ;
        @Data
        @Condition("AJ")
        ICondition opAbatIncobCont() ;
        @Data
        @Condition("PN")
        ICondition opPerdaoNegociado() ;
        @Data
        @Condition("CC")
        ICondition opCessaoCredito() ;
        @Data
        @Condition("IN")
        ICondition opLiqIncobravel() ;
        @Data
        @Condition("RC")
        ICondition retornGestRepVinc() ;
        @Data
        @Condition("RS")
        ICondition retornGest() ;
        @Data
        @Condition("VA")
        ICondition vencimentoAntec() ;
        @Data
        @Condition("DP")
        ICondition opDacao() ;
        
        
        @Data(size=2)
        IString pr378PlanoRemun() ;
        @Data
        @Condition("CR")
        ICondition prCredor() ;
        @Data
        @Condition("MR")
        ICondition prMora() ;
        @Data
        @Condition("OP")
        ICondition prFinancOpv() ;
        @Data
        @Condition("DV")
        ICondition prDevedor() ;
        
        
        @Data(size=1)
        IString cd418CondDinam() ;
        @Data
        @Condition("1")
        ICondition cdPeriodJuros() ;
        @Data
        @Condition("2")
        ICondition cdPeriodCapital() ;
        @Data
        @Condition("4")
        ICondition cdMetodoJuros() ;
        @Data
        @Condition("5")
        ICondition cdMetodoCapital() ;
        @Data
        @Condition("6")
        ICondition cdCapitalizacao() ;
        @Data
        @Condition("7")
        ICondition cdLinhaBonificacao() ;
        @Data
        @Condition("8")
        ICondition cdTaxa() ;
        
        
        @Data(size=3)
        IString md417MmentCndDin() ;
        @Data
        @Condition("001")
        ICondition mdInicioContrato() ;
        @Data
        @Condition("002")
        ICondition mdInicioUtilizacao() ;
        @Data
        @Condition("003")
        ICondition mdInicioDiferimento() ;
        @Data
        @Condition("004")
        ICondition mdInicioAmortizacao() ;
        
        
        @Data(size=1)
        IString ap460AjusteZPrsz() ;
        @Data
        @Condition("A")
        ICondition apAniversario() ;
        @Data
        @Condition("B")
        ICondition apFimNatural() ;
        @Data
        @Condition("C")
        ICondition apFimUtil() ;
        
        
        @Data(size=2)
        IString plV11TipoPlano() ;
        @Data
        @Condition("MA")
        ICondition plMPlanoAmortz() ;
        @Data
        @Condition("MI")
        ICondition plMInstrAmortz() ;
        @Data
        @Condition("MU")
        ICondition plMPlanoUtilizacao() ;
        @Data
        @Condition("MT")
        ICondition plMInstrUtilizacao() ;
        @Data
        @Condition("MJ")
        ICondition plMPlanoJuros() ;
        @Data
        @Condition("MB")
        ICondition plMPlanoBonif() ;
        @Data
        @Condition("MC")
        ICondition plMPlnJurosCalc() ;
        @Data
        @Condition("ME")
        ICondition plMInstrAmortzExp() ;
        
        
        /**
         * NA15612 - FIM
         */
        @Data(size=1)
        IString fo474FaseOperacao() ;
        @Data
        @Condition("1")
        ICondition foUtilizacao() ;
        @Data
        @Condition("2")
        ICondition foDiferimento() ;
        @Data
        @Condition("3")
        ICondition foAmortizacao() ;
        
        
        @Data(size=1)
        IString cdV02SitCondDin() ;
        @Data
        @Condition("E")
        ICondition cdSitExecutada() ;
        @Data
        @Condition("P")
        ICondition cdSitPendExec() ;
        
        
        @Data(size=2)
        IString tm113TipoMovOpcr() ;
        @Data
        @Condition("01")
        ICondition tmLimiteCredito() ;
        @Data
        @Condition("02")
        ICondition tmCapital() ;
        @Data
        @Condition("03")
        ICondition tmJuros() ;
        @Data
        @Condition("04")
        ICondition tmJurosPeriodif() ;
        @Data
        @Condition("05")
        ICondition tmJurosMora() ;
        @Data
        @Condition("06")
        ICondition tmJurosCapitalizado() ;
        @Data
        @Condition("07")
        ICondition tmJurosExtrapatrim() ;
        @Data
        @Condition("08")
        ICondition tmComissao() ;
        @Data
        @Condition("09")
        ICondition tmDespesa() ;
        @Data
        @Condition("10")
        ICondition tmImposto() ;
        @Data
        @Condition("11")
        ICondition tmBonificacao() ;
        @Data
        @Condition("12")
        ICondition tmContaDo() ;
        @Data
        @Condition("13")
        ICondition tmContasLiquidar() ;
        @Data
        @Condition("14")
        ICondition tmCtaLiqInterdep() ;
        @Data
        @Condition("15")
        ICondition tmRemuneracao() ;
        @Data
        @Condition("16")
        ICondition tmVlrReceber() ;
        @Data
        @Condition("17")
        ICondition tmVlrEntregar() ;
        @Data
        @Condition("18")
        ICondition tmGarantiaBancaria() ;
        @Data
        @Condition("19")
        ICondition tmVlrReceberJuros() ;
        @Data
        @Condition("20")
        ICondition tmVlrEntregarJuros() ;
        @Data
        @Condition("21")
        ICondition tmVlrReceberImp() ;
        @Data
        @Condition("22")
        ICondition tmVlrEntregarImp() ;
        @Data
        @Condition("23")
        ICondition tmComissaoPeriodif() ;
        
        
        @Data(size=1)
        IString spV08SitPrest() ;
        @Data
        @Condition("P")
        ICondition spPrestPaga() ;
        @Data
        @Condition("N")
        ICondition spPrestNaoPaga() ;
        @Data
        @Condition("F")
        ICondition spPrestProxima() ;
        
        
        @Data(size=1)
        IString gtV01SitGatilho() ;
        @Data
        @Condition("P")
        ICondition gtGatilhoPendente() ;
        @Data
        @Condition("E")
        ICondition gtGatilhoExecutado() ;
        @Data
        @Condition("R")
        ICondition gtGatilhoRejeitado() ;
        
        
        @Data(size=3)
        IString cg104CodGatilho() ;
        @Data
        @Condition("001")
        ICondition cgReclassAltBaltit() ;
        @Data
        @Condition("002")
        ICondition cgAlteracaoPrazo() ;
        @Data
        @Condition("003")
        ICondition cgContratacao() ;
        @Data
        @Condition("004")
        ICondition cgUtilizacao() ;
        @Data
        @Condition("005")
        ICondition cgLiqzAntecipada() ;
        @Data
        @Condition("006")
        ICondition cgAmortizacaoExtra() ;
        @Data
        @Condition("007")
        ICondition cgRfroRduz() ;
        @Data
        @Condition("008")
        ICondition cgDenunciaGbnc() ;
        @Data
        @Condition("009")
        ICondition cgSbtzProd() ;
        @Data
        @Condition("011")
        ICondition cgAlterPeriod() ;
        @Data
        @Condition("012")
        ICondition cgAlterMcalc() ;
        @Data
        @Condition("013")
        ICondition cgAlterBonif() ;
        @Data
        @Condition("014")
        ICondition cgAlterCapitaliz() ;
        @Data
        @Condition("015")
        ICondition cgAlterTaxa() ;
        @Data
        @Condition("016")
        ICondition cgAfectDaj() ;
        @Data
        @Condition("017")
        ICondition cgReclassAltNatjur() ;
        @Data
        @Condition("018")
        ICondition cgUtlzConvenc() ;
        @Data
        @Condition("019")
        ICondition cgCapitalizDivida() ;
        @Data
        @Condition("020")
        ICondition cgCobrancaDivida() ;
        @Data
        @Condition("021")
        ICondition cgVencAntecipado() ;
        @Data
        @Condition("022")
        ICondition cgTitularizacao() ;
        @Data
        @Condition("023")
        ICondition cgRecompra() ;
        @Data
        @Condition("024")
        ICondition cgAvsVencimento() ;
        @Data
        @Condition("025")
        ICondition cgAvsEtgaRednim() ;
        @Data
        @Condition("026")
        ICondition cgAvsFimContrato() ;
        @Data
        @Condition("027")
        ICondition cgAvsConstHipoteca() ;
        @Data
        @Condition("028")
        ICondition cgAplicacaoCrm() ;
        @Data
        @Condition("029")
        ICondition cgAplicacaoCmvm() ;
        @Data
        @Condition("030")
        ICondition cgAplicGarantias() ;
        @Data
        @Condition("031")
        ICondition cgAplicAuditOutras() ;
        @Data
        @Condition("032")
        ICondition cgAvsEmisExtrOpcr() ;
        @Data
        @Condition("033")
        ICondition cgAvsVencOpSindic() ;
        @Data
        @Condition("034")
        ICondition cgEmisExtractoEmpd() ;
        @Data
        @Condition("035")
        ICondition cgAplicacaoFsSemn() ;
        @Data
        @Condition("036")
        ICondition cgHistoricoOpcrs() ;
        @Data
        @Condition("037")
        ICondition cgIntfcCallCIncmp() ;
        @Data
        @Condition("038")
        ICondition cgInterfcDajIncump() ;
        @Data
        @Condition("039")
        ICondition cgPerdaoDivida() ;
        @Data
        @Condition("040")
        ICondition cgIntfcDwSldOpcr() ;
        @Data
        @Condition("041")
        ICondition cgIntfcDwMovOpcr() ;
        @Data
        @Condition("042")
        ICondition cgIntfcDwGartOpcr() ;
        @Data
        @Condition("043")
        ICondition cgReposicaoHistoric() ;
        @Data
        @Condition("044")
        ICondition cgAvsAmLqNExec() ;
        @Data
        @Condition("045")
        ICondition cgPeriodoCarencia() ;
        @Data
        @Condition("046")
        ICondition cgAlterProxPrest() ;
        @Data
        @Condition("047")
        ICondition cgRecalculo() ;
        @Data
        @Condition("048")
        ICondition cgAvsVencComsPer() ;
        @Data
        @Condition("049")
        ICondition cgAvsGtloOpcr() ;
        @Data
        @Condition("050")
        ICondition cgAlterZVnct() ;
        @Data
        @Condition("051")
        ICondition cgAbateDivida() ;
        @Data
        @Condition("052")
        ICondition cgInfoDgt() ;
        @Data
        @Condition("053")
        ICondition cgAltCanNegocio() ;
        @Data
        @Condition("057")
        ICondition cgAltZCobDefntiva() ;
        @Data
        @Condition("058")
        ICondition cgAltZCobPontual() ;
        @Data
        @Condition("068")
        ICondition cgBonzDl22489() ;
        @Data
        @Condition("531")
        ICondition cgLiqFinOpv() ;
        @Data
        @Condition("CCD")
        ICondition cgCessao() ;
        @Data
        @Condition("DCP")
        ICondition cgDacao() ;
        @Data
        @Condition("074")
        ICondition cgAgendCsll() ;
        @Data
        @Condition("076")
        ICondition cgInterfPrjAndorra() ;
        
        
        /**
         * PROJ ANDORRA - F
         * *NA32102 - F
         */
        @Data(size=1)
        IString sfV20SitFinanc() ;
        @Data
        @Condition("N")
        ICondition sfNormal() ;
        @Data
        @Condition("M")
        ICondition sfMora() ;
        
        
        @Data(size=4)
        IString ev255Eventos() ;
        @Data
        @Condition("0186")
        ICondition evImpComNtPrvt() ;
        @Data
        @Condition("0187")
        ICondition evComDefntConvReg() ;
        @Data
        @Condition("0188")
        ICondition evComDftRegHip() ;
        @Data
        @Condition("0189")
        ICondition evPeriodifComiss() ;
        @Data
        @Condition("0190")
        ICondition evTitularizacao() ;
        @Data
        @Condition("0191")
        ICondition evRecompra() ;
        @Data
        @Condition("0195")
        ICondition evPeriodoCarencia() ;
        @Data
        @Condition("0196")
        ICondition evAnlzImpDespCli() ;
        @Data
        @Condition("0197")
        ICondition evAnlzReclassif() ;
        @Data
        @Condition("0198")
        ICondition evAvisoAmLiqNEx() ;
        @Data
        @Condition("0199")
        ICondition evDespRegulrzImp() ;
        @Data
        @Condition("0200")
        ICondition evContratacao() ;
        @Data
        @Condition("0201")
        ICondition evAvsHistorPagmnt() ;
        @Data
        @Condition("0202")
        ICondition evUtilizacao() ;
        @Data
        @Condition("0203")
        ICondition evMovContaLiquid() ;
        @Data
        @Condition("0204")
        ICondition evLiquidAntecipada() ;
        @Data
        @Condition("0205")
        ICondition evAmortizacao() ;
        @Data
        @Condition("0206")
        ICondition evRenovacaoOper() ;
        @Data
        @Condition("0207")
        ICondition evAlteracaoPrz() ;
        @Data
        @Condition("0208")
        ICondition evVencimento() ;
        @Data
        @Condition("0209")
        ICondition evAnlzAlterPrz() ;
        @Data
        @Condition("0210")
        ICondition evDiminuiRspe() ;
        @Data
        @Condition("0211")
        ICondition evApurImpSeloCc() ;
        @Data
        @Condition("0212")
        ICondition evApurAdicBonific() ;
        @Data
        @Condition("0213")
        ICondition evImpBonificacoes() ;
        @Data
        @Condition("0214")
        ICondition evSimulacaoEncargos() ;
        @Data
        @Condition("0215")
        ICondition evAnlzImputBonif() ;
        @Data
        @Condition("0216")
        ICondition evReclBonificacoes() ;
        @Data
        @Condition("0217")
        ICondition evDevlBonificacoes() ;
        @Data
        @Condition("0194")
        ICondition evAnlzReclBonific() ;
        @Data
        @Condition("0193")
        ICondition evAnlzDevlBonific() ;
        @Data
        @Condition("0192")
        ICondition evGestaoLotesBonif() ;
        @Data
        @Condition("0218")
        ICondition evAfectBonificacao() ;
        @Data
        @Condition("0219")
        ICondition evAcertoPagmBonif() ;
        @Data
        @Condition("0220")
        ICondition evDenunciaGbnc() ;
        @Data
        @Condition("0221")
        ICondition evCobranca() ;
        @Data
        @Condition("0222")
        ICondition evAnulacaoCobranca() ;
        @Data
        @Condition("0223")
        ICondition evMudancaFase() ;
        @Data
        @Condition("0224")
        ICondition evReclassificacao() ;
        @Data
        @Condition("0225")
        ICondition evAviVnctPrszSind() ;
        @Data
        @Condition("0226")
        ICondition evAviSldoDevedores() ;
        @Data
        @Condition("0227")
        ICondition evCalculoMora() ;
        @Data
        @Condition("0228")
        ICondition evUtilizacaoConven() ;
        @Data
        @Condition("0229")
        ICondition evAviCertidaoUtlz() ;
        @Data
        @Condition("0230")
        ICondition evPeriodificacao() ;
        @Data
        @Condition("0231")
        ICondition evDespProvConvReg() ;
        @Data
        @Condition("0232")
        ICondition evAnlzDespRgzrImp() ;
        @Data
        @Condition("0233")
        ICondition evImpComissInterv() ;
        @Data
        @Condition("0234")
        ICondition evImpComissGestao() ;
        @Data
        @Condition("0235")
        ICondition evImpDesRevog() ;
        @Data
        @Condition("0236")
        ICondition evImpComEstudoMan() ;
        @Data
        @Condition("0237")
        ICondition evImpComissEtPrst() ;
        @Data
        @Condition("0238")
        ICondition evImpDesDesloca() ;
        @Data
        @Condition("0239")
        ICondition evAfectCapDiferido() ;
        @Data
        @Condition("0240")
        ICondition evImpPrepDesCons() ;
        @Data
        @Condition("0241")
        ICondition evAltBalcaoTitular() ;
        @Data
        @Condition("0242")
        ICondition evPeriodifExeAnt() ;
        @Data
        @Condition("0243")
        ICondition evImpDesDeclDivd() ;
        @Data
        @Condition("0244")
        ICondition evImpDesExtCtVg() ;
        @Data
        @Condition("0245")
        ICondition evImpDesExtCtLq() ;
        @Data
        @Condition("0246")
        ICondition evImpDesSeguros() ;
        @Data
        @Condition("0247")
        ICondition evImpDesDiversas() ;
        @Data
        @Condition("0248")
        ICondition evImpJurosMora() ;
        @Data
        @Condition("0250")
        ICondition evSubtzProd() ;
        @Data
        @Condition("0251")
        ICondition evDtbzValEntExter() ;
        @Data
        @Condition("0252")
        ICondition evImpDispRgtsProv() ;
        @Data
        @Condition("0253")
        ICondition evImpComsAltTit() ;
        @Data
        @Condition("0254")
        ICondition evVencComsPeriod() ;
        @Data
        @Condition("0255")
        ICondition evInicioIncumpr() ;
        @Data
        @Condition("0256")
        ICondition evImpDesAltCntr() ;
        @Data
        @Condition("0257")
        ICondition evContratComUtiz() ;
        @Data
        @Condition("0258")
        ICondition evContratSemUtiz() ;
        @Data
        @Condition("0259")
        ICondition evImpComAcomGst() ;
        @Data
        @Condition("0260")
        ICondition evImpComsAltTx() ;
        @Data
        @Condition("0261")
        ICondition evImpComsCbrc() ;
        @Data
        @Condition("0262")
        ICondition evAnlzContratacao() ;
        @Data
        @Condition("0263")
        ICondition evMigracao() ;
        @Data
        @Condition("0264")
        ICondition evAnlzUtilizacao() ;
        @Data
        @Condition("0265")
        ICondition evAnlzLiqAntecip() ;
        @Data
        @Condition("0266")
        ICondition evAnlzAmtzExtraor() ;
        @Data
        @Condition("0267")
        ICondition evAnlzVencimento() ;
        @Data
        @Condition("0268")
        ICondition evAnlzManualMovim() ;
        @Data
        @Condition("0269")
        ICondition evEmissaoTermoGb() ;
        @Data
        @Condition("0270")
        ICondition evLiqdAutomatica() ;
        @Data
        @Condition("0271")
        ICondition evCobrAbatActivo() ;
        @Data
        @Condition("0272")
        ICondition evAnlzAbatActivo() ;
        @Data
        @Condition("0273")
        ICondition evAvisoVencPrst() ;
        @Data
        @Condition("0274")
        ICondition evAvisoDclRendP() ;
        @Data
        @Condition("0275")
        ICondition evAvisoDclRendS() ;
        @Data
        @Condition("0276")
        ICondition evImpDespOcClient() ;
        @Data
        @Condition("0277")
        ICondition evAvisoFimContrato() ;
        @Data
        @Condition("0278")
        ICondition evAvisoConstitHipo() ;
        @Data
        @Condition("0279")
        ICondition evAvisoIncapacidade() ;
        @Data
        @Condition("0280")
        ICondition evAvisoAprvEscolar() ;
        @Data
        @Condition("0281")
        ICondition evImpDespOcCgd() ;
        @Data
        @Condition("0282")
        ICondition evAvisoNotaLancam() ;
        @Data
        @Condition("0283")
        ICondition evAvisoEncgPrevis() ;
        @Data
        @Condition("0284")
        ICondition evEmissaoExtrOper() ;
        @Data
        @Condition("0285")
        ICondition evVencimentoManual() ;
        @Data
        @Condition("0286")
        ICondition evAumentoRspe() ;
        @Data
        @Condition("0287")
        ICondition evInformEntBonific() ;
        @Data
        @Condition("0288")
        ICondition evAnlzUtilConven() ;
        @Data
        @Condition("0289")
        ICondition evAnlzImputJmora() ;
        @Data
        @Condition("0290")
        ICondition evReforcoCapital() ;
        @Data
        @Condition("0291")
        ICondition evReducaoCapital() ;
        @Data
        @Condition("0292")
        ICondition evAvisoAltPrxPres() ;
        @Data
        @Condition("0293")
        ICondition evAnlzSubtzProd() ;
        @Data
        @Condition("0294")
        ICondition evAvsDeclEncgIrs() ;
        @Data
        @Condition("0295")
        ICondition evAnlzReforcoCapit() ;
        @Data
        @Condition("0296")
        ICondition evAnlzReducaoCapit() ;
        @Data
        @Condition("0297")
        ICondition evAnlzDenunciaGbnc() ;
        @Data
        @Condition("0298")
        ICondition evEmissaoExtrEmpd() ;
        @Data
        @Condition("0299")
        ICondition evCobrancaRemunera() ;
        @Data
        @Condition("0324")
        ICondition evVencComProcess() ;
        @Data
        @Condition("0330")
        ICondition evAfectacao() ;
        @Data
        @Condition("0331")
        ICondition evDesafectacao() ;
        @Data
        @Condition("0332")
        ICondition evAfectacaoOsp() ;
        @Data
        @Condition("0333")
        ICondition evDesafectacaoOsp() ;
        @Data
        @Condition("0335")
        ICondition evAmortizacaoExp() ;
        @Data
        @Condition("0336")
        ICondition evAnulAmortzExp() ;
        @Data
        @Condition("0804")
        ICondition evAbateActivo() ;
        @Data
        @Condition("0805")
        ICondition evAnlzAbateActivo() ;
        @Data
        @Condition("0813")
        ICondition evAfectDaj() ;
        @Data
        @Condition("0803")
        ICondition evRetGestRepVenc() ;
        @Data
        @Condition("0814")
        ICondition evPerdaoDivida() ;
        @Data
        @Condition("0806")
        ICondition evAnlzPerdaoDivida() ;
        @Data
        @Condition("0816")
        ICondition evVencimAntecipado() ;
        @Data
        @Condition("0817")
        ICondition evAnlzVenciAntecip() ;
        @Data
        @Condition("0815")
        ICondition evCapitManualDivid() ;
        @Data
        @Condition("0802")
        ICondition evAnlzCapitManDiv() ;
        @Data
        @Condition("0835")
        ICondition evDacao() ;
        
        
        @Data(size=8)
        IString seE03EvSubEv() ;
        @Data
        @Condition("02000001")
        ICondition seDocPartCCphAb() ;
        @Data
        @Condition("02000002")
        ICondition seEscNotaPriv() ;
        @Data
        @Condition("02000003")
        ICondition seEscNotarioPub() ;
        @Data
        @Condition("02000004")
        ICondition seOtDocParticular() ;
        @Data
        @Condition("02000005")
        ICondition seOtEscNotaPriv() ;
        @Data
        @Condition("02000006")
        ICondition seOtEscNotroPub() ;
        @Data
        @Condition("02000007")
        ICondition seEscNtPrivCHp() ;
        @Data
        @Condition("02000008")
        ICondition seEscNtPubliCHp() ;
        @Data
        @Condition("02000009")
        ICondition seDocPartSCphAb() ;
        @Data
        @Condition("02000012")
        ICondition seOtDocPartComP() ;
        @Data
        @Condition("02000014")
        ICondition seOutroDocPart() ;
        @Data
        @Condition("02000015")
        ICondition seCasaPronta() ;
        @Data
        @Condition("02000016")
        ICondition seCasaProntaTrf() ;
        @Data
        @Condition("02040001")
        ICondition seLiqGbncHip() ;
        @Data
        @Condition("02040002")
        ICondition seLiqGbncNHip() ;
        @Data
        @Condition("02050001")
        ICondition seAmortParcialPnlz() ;
        @Data
        @Condition("02070001")
        ICondition seReducaoPrz() ;
        @Data
        @Condition("02070002")
        ICondition seProrrogacaoPrz() ;
        @Data
        @Condition("02080001")
        ICondition seProcPrestMens() ;
        @Data
        @Condition("02080002")
        ICondition seProcPrestNMens() ;
        @Data
        @Condition("02080003")
        ICondition seEmpregadosActivo() ;
        @Data
        @Condition("02140001")
        ICondition seEncgAteContrato() ;
        @Data
        @Condition("02140002")
        ICondition seComissaoDeEstudo() ;
        @Data
        @Condition("02140003")
        ICondition seRgtAqCCphHpp() ;
        @Data
        @Condition("02140004")
        ICondition seRgtAqSCphHpp() ;
        @Data
        @Condition("02140005")
        ICondition seRgtAqHsr() ;
        @Data
        @Condition("02140006")
        ICondition seRgtHipoteca() ;
        @Data
        @Condition("02140007")
        ICondition seSisa() ;
        @Data
        @Condition("02140025")
        ICondition seDespesasAvaliacao() ;
        @Data
        @Condition("02140008")
        ICondition seEncgGenericos() ;
        @Data
        @Condition("02140009")
        ICondition seConversaoRgtAqsz() ;
        @Data
        @Condition("02140010")
        ICondition seConversaoRgtHipt() ;
        @Data
        @Condition("02140011")
        ICondition seEmolumentConvRgt() ;
        @Data
        @Condition("02140012")
        ICondition seImpSeloAqImovel() ;
        @Data
        @Condition("02140013")
        ICondition seSegurosNaoObrigt() ;
        @Data
        @Condition("02140014")
        ICondition seDocumntParticular() ;
        @Data
        @Condition("02140015")
        ICondition seCtrtDocParCCph() ;
        @Data
        @Condition("02140016")
        ICondition seCtrtDocParSCph() ;
        @Data
        @Condition("02140017")
        ICondition seCtrtDocPar() ;
        @Data
        @Condition("02140018")
        ICondition seEscrituraPublica() ;
        @Data
        @Condition("02140019")
        ICondition seMinutaEscPub() ;
        @Data
        @Condition("02140020")
        ICondition seEscPubCCphHpp() ;
        @Data
        @Condition("02140021")
        ICondition seEscPubSCphHpp() ;
        @Data
        @Condition("02140022")
        ICondition seEscPubHsr() ;
        @Data
        @Condition("02140023")
        ICondition seEscPubMutuoHipt() ;
        @Data
        @Condition("02140024")
        ICondition seImpSeloEscPub() ;
        @Data
        @Condition("02350001")
        ICondition seRevogDeclPartic() ;
        @Data
        @Condition("02350002")
        ICondition seRevogNotarioPub() ;
        @Data
        @Condition("02350003")
        ICondition seRevogNotarioPriv() ;
        @Data
        @Condition("02430001")
        ICondition seJudiciarioImpSuc() ;
        @Data
        @Condition("02430002")
        ICondition seTransferParaOic() ;
        @Data
        @Condition("02430003")
        ICondition seDeclEncargoDiv() ;
        @Data
        @Condition("02430004")
        ICondition seDeclDivOutrosEf() ;
        @Data
        @Condition("02450001")
        ICondition seExtCtLqMens5an() ;
        @Data
        @Condition("02450002")
        ICondition seExtCtLqMais5an() ;
        @Data
        @Condition("02540001")
        ICondition seComDisponGestao() ;
        @Data
        @Condition("02540002")
        ICondition seComImobilizacao() ;
        @Data
        @Condition("02540003")
        ICondition seComGarntBancaria() ;
        @Data
        @Condition("02540004")
        ICondition seComAcompGestGb() ;
        @Data
        @Condition("02570001")
        ICondition contrCUtlzNOic() ;
        @Data
        @Condition("02570002")
        ICondition contrCUtlzSHipot() ;
        @Data
        @Condition("02570003")
        ICondition cntrCUtzTrsfCHip() ;
        @Data
        @Condition("02570004")
        ICondition cntrCUtzTrfsSHip() ;
        @Data
        @Condition("02580001")
        ICondition contrSUtlzAvSGar() ;
        @Data
        @Condition("02580002")
        ICondition contrSUtlzGarEsp() ;
        @Data
        @Condition("02580003")
        ICondition cntrSUtzGarGenDn() ;
        @Data
        @Condition("02580004")
        ICondition cntrSUtzTrsfSHip() ;
        @Data
        @Condition("02760001")
        ICondition seOcCliRecNotar() ;
        @Data
        @Condition("02760002")
        ICondition seOcCliDespTrib() ;
        @Data
        @Condition("02760003")
        ICondition seOcCliMpJudic() ;
        @Data
        @Condition("02760004")
        ICondition seOcCliDespCons() ;
        @Data
        @Condition("02760005")
        ICondition seOcCliSpCheque() ;
        @Data
        @Condition("02760006")
        ICondition seOcCliConvReg() ;
        @Data
        @Condition("02760007")
        ICondition seOcCliDespTxJst() ;
        @Data
        @Condition("02760008")
        ICondition seOcCliPublAnunc() ;
        @Data
        @Condition("02760009")
        ICondition seOcCliAdtSlExec() ;
        @Data
        @Condition("02760010")
        ICondition seOcCliRmnSlExec() ;
        @Data
        @Condition("02760011")
        ICondition seOcCliDespPgImp() ;
        @Data
        @Condition("02760012")
        ICondition seOcCliDspPgCert() ;
        @Data
        @Condition("02810001")
        ICondition seOcCgdRecNotar() ;
        @Data
        @Condition("02810002")
        ICondition seOcCgdDespTrib() ;
        @Data
        @Condition("02810003")
        ICondition seOcCgdMpJudic() ;
        @Data
        @Condition("02810004")
        ICondition seOcCgdDespCons() ;
        @Data
        @Condition("02810005")
        ICondition seOcCgdSpCheque() ;
        @Data
        @Condition("02170001")
        ICondition seDevlBonLiqAnt() ;
        @Data
        @Condition("02170002")
        ICondition seDevlBonAltPrd() ;
        @Data
        @Condition("02170003")
        ICondition seDevlBonAftDaj() ;
        @Data
        @Condition("02140026")
        ICondition seCtrtDocParPenh() ;
        @Data
        @Condition("02140027")
        ICondition seImpSeloFinanc() ;
        
        
        /**
         * *IS 2005-12-12 FIM
         */
        @Data(size=2)
        IString tbV16TipoBloq() ;
        @Data
        @Condition("01")
        ICondition tbGeralOp() ;
        @Data
        @Condition("02")
        ICondition tbCobranca() ;
        @Data
        @Condition("03")
        ICondition tbVencimento() ;
        @Data
        @Condition("04")
        ICondition tbJurosMora() ;
        @Data
        @Condition("05")
        ICondition tbAutomatico() ;
        
        
        @Data(size=5)
        IString mbV17MotivoTpBloq() ;
        @Data
        @Condition("02001")
        ICondition mbAfectaDaj() ;
        @Data
        @Condition("05001")
        ICondition mbErroCoerencia() ;
        @Data
        @Condition("05002")
        ICondition mbSemParametrizacao() ;
        
        
        @Data(size=3)
        IString rl506Relacoes() ;
        @Data
        @Condition("001")
        ICondition rlOperIntercalar() ;
        @Data
        @Condition("002")
        ICondition rlCapitalizacao() ;
        @Data
        @Condition("003")
        ICondition rlConvencionados() ;
        @Data
        @Condition("004")
        ICondition rlReestruturacao() ;
        @Data
        @Condition("005")
        ICondition rlGarantias() ;
        @Data
        @Condition("006")
        ICondition rlOpcrAssociadas() ;
        @Data
        @Condition("007")
        ICondition rlChAntigoChNovo() ;
        @Data
        @Condition("008")
        ICondition rlIntercalarChAntg() ;
        @Data
        @Condition("009")
        ICondition rlIntercalarChNovo() ;
        @Data
        @Condition("010")
        ICondition rlMultCrediobras() ;
        
        
        @Data(size=3)
        IString ccV14CondContrat() ;
        @Data
        @Condition("001")
        ICondition ccEnvioProcEntEx() ;
        @Data
        @Condition("002")
        ICondition ccRejSubEntEx() ;
        @Data
        @Condition("003")
        ICondition ccAprSubEntEx() ;
        @Data
        @Condition("004")
        ICondition ccEstMntAplRelev() ;
        @Data
        @Condition("005")
        ICondition ccAplRelevRealizd() ;
        @Data
        @Condition("006")
        ICondition ccPostosTrabCriad() ;
        @Data
        @Condition("007")
        ICondition ccEnvRelFnEntEx() ;
        
        
        @Data(size=2)
        IString mc370MetCalcJuros() ;
        @Data
        @Condition("PM")
        ICondition mcJPlanoManual() ;
        @Data
        @Condition("PJ")
        ICondition mcJPlanoJuros() ;
        @Data
        @Condition("JP")
        ICondition mcJPeriodo() ;
        @Data
        @Condition("JD")
        ICondition mcJDia() ;
        @Data
        @Condition("DF")
        ICondition mcJDiaAntecipado() ;
        @Data
        @Condition({ "99", "  " })
        ICondition mcJSemMetodo() ;
        @Data
        @Condition({ "PM", "PJ", "JP", "JD", "DF", "99", "  " })
        ICondition mcJValido() ;
        
        
        @Data(size=2)
        IString mc969MetCalcCapit() ;
        @Data
        @Condition("PA")
        ICondition mcCPar() ;
        @Data
        @Condition("LI")
        ICondition mcCPlanoManual() ;
        @Data
        @Condition("FR")
        ICondition mcCPrtzConstantes() ;
        @Data
        @Condition("RF")
        ICondition mcCPrtzFixas() ;
        @Data
        @Condition("AM")
        ICondition mcCAmozUnica() ;
        @Data
        @Condition("PP")
        ICondition mcCPrtzProgressiv() ;
        @Data
        @Condition("MT")
        ICondition mcCPrtzMistas() ;
        @Data
        @Condition("HC")
        ICondition mcCAmozConstantes() ;
        @Data
        @Condition("HL")
        ICondition mcCAmozFlexiveis() ;
        @Data
        @Condition("PC")
        ICondition mcCPrtzCrescentes() ;
        @Data
        @Condition("CD")
        ICondition mcCCapDiferido() ;
        @Data
        @Condition("EP")
        ICondition mcC14prtz12meses() ;
        @Data
        @Condition("DF")
        ICondition mcCCapDifRf() ;
        @Data
        @Condition({ "99", "  " })
        ICondition mcCSemMetodo() ;
        @Data
        @Condition({ "LI", "PA", "FR", "RF", "AM", "PP", "MT", "HC", "HL", "PC", "CD", "EP", "DF", "99", "  " })
        ICondition mcCValido() ;
        
        
        @Data(size=1)
        IString ipV03SitInstrPln() ;
        @Data
        @Condition("E")
        ICondition ipExecutada() ;
        @Data
        @Condition("P")
        ICondition ipPendenteExec() ;
        @Data
        @Condition("R")
        ICondition ipRejeitada() ;
        
        
        @Data(size=2)
        IString omV28OrigMvCtLiq() ;
        @Data
        @Condition("01")
        ICondition omMaisValias() ;
        @Data
        @Condition("02")
        ICondition omCtaLiqTesouro() ;
        @Data
        @Condition("03")
        ICondition omCtaLiqBalcao() ;
        @Data
        @Condition("04")
        ICondition omContaDo() ;
        @Data
        @Condition("05")
        ICondition omArrematacao() ;
        @Data
        @Condition("06")
        ICondition omOpcrCredito() ;
        @Data
        @Condition("07")
        ICondition omCtaLiqImoCx() ;
        @Data
        @Condition("08")
        ICondition omCtaRegDrc() ;
        @Data
        @Condition("09")
        ICondition omProveitosCiv() ;
        
        
        @Data(size=4)
        IInt tp277TiposPrazo() ;
        @Data
        @Condition("1")
        ICondition tpDias() ;
        @Data
        @Condition("2")
        ICondition tpSemanas() ;
        @Data
        @Condition("4")
        ICondition tpMeses() ;
        @Data
        @Condition("9")
        ICondition tpAnos() ;
        
        
        @Data(size=1)
        IString tvE07TipoValEnc() ;
        @Data
        @Condition("T")
        ICondition tvTaxa() ;
        @Data
        @Condition("M")
        ICondition tvMontante() ;
        
        
        @Data(size=3)
        IString rt706RegraTransic() ;
        @Data
        @Condition("001")
        ICondition rtUtilizacaoTotal() ;
        @Data
        @Condition("002")
        ICondition rtFimPrazo() ;
        
        
        @Data(size=1)
        IString tsE98TipoSpread() ;
        @Data
        @Condition("1")
        ICondition tsTodasCondsDif() ;
        @Data
        @Condition("2")
        ICondition tsPicsPromocoes() ;
        @Data
        @Condition("4")
        ICondition tsNegociado() ;
        @Data
        @Condition({ "1", "2", "4", " " })
        ICondition tsValido() ;
        
        
        @Data(size=1)
        IString ss271SinalSpread() ;
        @Data
        @Condition("A")
        ICondition ssAditivo() ;
        @Data
        @Condition("S")
        ICondition ssSubtractivo() ;
        @Data
        @Condition("M")
        ICondition ssMultiplicativo() ;
        @Data
        @Condition({ "A", "S", "M", " " })
        ICondition ssValido() ;
        
        
        @Data(size=1)
        IString ttE99TipoTaxa() ;
        @Data
        @Condition("1")
        ICondition ttNegociada() ;
        @Data
        @Condition("2")
        ICondition ttVariavel() ;
        @Data
        @Condition("3")
        ICondition ttPeriodificada() ;
        @Data
        @Condition("4")
        ICondition ttFixa() ;
        @Data
        @Condition("5")
        ICondition ttMista() ;
        @Data
        @Condition("6")
        ICondition ttPremio() ;
        @Data
        @Condition({ "1", "2", "3", "4", "5", "6", " " })
        ICondition ttValido() ;
        
        
        @Data(size=1)
        IString ae146AmozExtra() ;
        @Data
        @Condition("1")
        ICondition aeNaoPermite() ;
        @Data
        @Condition("2")
        ICondition aeEmVencimento() ;
        @Data
        @Condition("3")
        ICondition aeEmQqData() ;
        
        
        /**
         * 05 BNAW0501-RP-136-REFLX-PRSZ          PIC X(03).
         * 88 BNAW0501-RP-ABAT-SALDO-CAPITAL       VALUE '001'.
         * 88 BNAW0501-RP-ALTER-PRAZO              VALUE '002'.
         * 88 BNAW0501-RP-CARENCIA-CAPITAL         VALUE '003'.
         */
        @Data(size=2)
        IString sbV15SitBonif() ;
        @Data
        @Condition("N0")
        ICondition sbApurada() ;
        @Data
        @Condition("N1")
        ICondition sbEmCondRecl() ;
        @Data
        @Condition("N2")
        ICondition sbReclamada() ;
        @Data
        @Condition("N3")
        ICondition sbPaga() ;
        @Data
        @Condition("N4")
        ICondition sbEmReclamacao() ;
        @Data
        @Condition("I0")
        ICondition sbImputadaCliente() ;
        @Data
        @Condition("I1")
        ICondition sbImputadaRecl() ;
        @Data
        @Condition("I2")
        ICondition sbImputadaPaga() ;
        @Data
        @Condition("D0")
        ICondition sbApurDevolver() ;
        @Data
        @Condition("D1")
        ICondition sbADevolver() ;
        @Data
        @Condition("D2")
        ICondition sbDevolvida() ;
        @Data
        @Condition("D3")
        ICondition sbDevolvidaPaga() ;
        @Data
        @Condition("E0")
        ICondition sbEstornadaRecl() ;
        @Data
        @Condition("E1")
        ICondition sbEstornadaPaga() ;
        
        
        @Data(size=1)
        IString smV07SitPedMapa() ;
        @Data
        @Condition("E")
        ICondition smExecutado() ;
        @Data
        @Condition("P")
        ICondition smPendExecucao() ;
        
        
        @Data(size=3)
        IString fp765FamProd() ;
        @Data
        @Condition("300")
        ICondition fpCreCpEmpPriv() ;
        @Data
        @Condition("304")
        ICondition fpGarantiaBancaria() ;
        @Data
        @Condition("209")
        ICondition fpOpv() ;
        
        
        @Data(size=6)
        IString pp158FamProdProd() ;
        @Data
        @Condition("350001")
        ICondition ppContaALiquidar() ;
        @Data
        @Condition("106001")
        ICondition ppMultiOpcoes() ;
        @Data
        @Condition("202001")
        ICondition ppCredicurso() ;
        @Data
        @Condition("100016")
        ICondition ppAquiIpeHabPer() ;
        @Data
        @Condition("100017")
        ICondition ppAquiIpeHabSec() ;
        @Data
        @Condition("100020")
        ICondition ppAquiInhBonDec() ;
        @Data
        @Condition("100021")
        ICondition ppAquiInhBonCon() ;
        @Data
        @Condition("100022")
        ICondition ppAquiInhProgres() ;
        @Data
        @Condition("100023")
        ICondition ppAquiInhDeficie() ;
        @Data
        @Condition("100038")
        ICondition ppAquiLocapHabPer() ;
        @Data
        @Condition("100039")
        ICondition ppAquiImoleHabPer() ;
        @Data
        @Condition("100040")
        ICondition ppAquiImoleHabSec() ;
        @Data
        @Condition("100041")
        ICondition ppAquiFunPenFoAr() ;
        @Data
        @Condition("103016")
        ICondition ppObBenIpeHabPer() ;
        @Data
        @Condition("103017")
        ICondition ppObBenIpeHabSec() ;
        @Data
        @Condition("103038")
        ICondition ppObBenLocapHPer() ;
        @Data
        @Condition("103039")
        ICondition ppObBenImoleHPer() ;
        @Data
        @Condition("104016")
        ICondition ppConstIpeHabPer() ;
        @Data
        @Condition("104017")
        ICondition ppConstIpeHabSec() ;
        @Data
        @Condition("104038")
        ICondition ppConstLocapHaPer() ;
        @Data
        @Condition("300007")
        ICondition ppCrdCpDenuncGbnc() ;
        @Data
        @Condition("303006")
        ICondition ppConvencionadoAgrd() ;
        @Data
        @Condition("300026")
        ICondition ppConvencionadoCp() ;
        @Data
        @Condition("209001")
        ICondition ppOpv() ;
        @Data
        @Condition("301019")
        ICondition ppCreditoParCgd() ;
        
        
        @Data(size=1)
        IString cb150CritCbcr() ;
        @Data
        @Condition("P")
        ICondition cbPrestacao() ;
        @Data
        @Condition("V")
        ICondition cbVerba() ;
        
        
        @Data(size=3)
        IInt ti891TipoIntervenc() ;
        @Data
        @Condition("101")
        ICondition tiTitular() ;
        @Data
        @Condition("012")
        ICondition tiBeneficiario() ;
        
        
        @Data(size=3)
        IString x476RgraCapNutd() ;
        @Data
        @Condition("001")
        ICondition forcarUtilizCapital() ;
        @Data
        @Condition("002")
        ICondition reducaoMontEmpr() ;
        @Data
        @Condition("003")
        ICondition mantemDisponivel() ;
        
        
        @Data(size=1)
        IString slV31SituacaoLote() ;
        @Data
        @Condition("0")
        ICondition slApurado() ;
        @Data
        @Condition("1")
        ICondition slAReclamar() ;
        @Data
        @Condition("2")
        ICondition slReclamado() ;
        @Data
        @Condition("3")
        ICondition slAReceber() ;
        @Data
        @Condition("4")
        ICondition slRecebido() ;
        @Data
        @Condition("5")
        ICondition slEmReclamacao() ;
        
        
        @Data(size=1)
        IString trV34TipoLote() ;
        @Data
        @Condition("R")
        ICondition trReclamacao() ;
        @Data
        @Condition("D")
        ICondition trDevolucao() ;
        @Data
        @Condition("E")
        ICondition trEstorno() ;
        
        
        @Data(size=1)
        IString smV04SituacaoMapa() ;
        @Data
        @Condition("0")
        ICondition smAEmitir() ;
        @Data
        @Condition("1")
        ICondition smEmitido() ;
        @Data
        @Condition("2")
        ICondition smNEmite() ;
        @Data
        @Condition("3")
        ICondition smNEmitido() ;
        
        
        @Data(size=1)
        IString pd761PrzDeslizante() ;
        @Data
        @Condition("1")
        ICondition pdPrzDeslizante() ;
        @Data
        @Condition("2")
        ICondition pdPrzNDeslizante() ;
        
        
        @Data(size=1)
        IString tpV12TipoLideranca() ;
        @Data
        @Condition("F")
        ICondition tpFixa() ;
        @Data
        @Condition("R")
        ICondition tpRotativa() ;
        
        
        @Data(size=1)
        IString tcE95TipoCollar() ;
        @Data
        @Condition("N")
        ICondition tcCollarNormal() ;
        @Data
        @Condition("I")
        ICondition tcCollarInverso() ;
        
        
        @Data(size=1)
        IString mvV29SitMovContlq() ;
        @Data
        @Condition("C")
        ICondition mvComUtizEspecif() ;
        @Data
        @Condition("S")
        ICondition mvSemUtizEspecif() ;
        @Data
        @Condition("N")
        ICondition mvNaoAplicavel() ;
        @Data
        @Condition("A")
        ICondition mvAnulado() ;
        @Data
        @Condition("E")
        ICondition mvDeAnulacao() ;
        
        
        @Data(size=1)
        IString cdV09CrtDesagreg() ;
        @Data
        @Condition("0")
        ICondition cdNenhum() ;
        @Data
        @Condition("1")
        ICondition cdDirecComercial() ;
        @Data
        @Condition("2")
        ICondition cdDirecRegional() ;
        @Data
        @Condition("3")
        ICondition cdBalcaoTit() ;
        @Data
        @Condition("4")
        ICondition cdFamProd() ;
        @Data
        @Condition("5")
        ICondition cdProduto() ;
        @Data
        @Condition("6")
        ICondition cdStFncoOpcr() ;
        @Data
        @Condition("7")
        ICondition cdStIcpt() ;
        
        
        @Data(size=1)
        IString tpV23TipoPrsz() ;
        @Data
        @Condition("1")
        ICondition tpCapital() ;
        @Data
        @Condition("2")
        ICondition tpJuros() ;
        @Data
        @Condition("3")
        ICondition tpCapitalJuros() ;
        @Data
        @Condition("4")
        ICondition tpComissao() ;
        @Data
        @Condition("5")
        ICondition tpDuplaCapJur() ;
        
        
        /**
         * VS - 2006/04/06 - NA272 - FIM
         */
        @Data(size=1)
        IString maV35MovAnul() ;
        @Data
        @Condition("A")
        ICondition maAnulado() ;
        @Data
        @Condition("E")
        ICondition maDeEstorno() ;
        
        
        @Data(size=1)
        IString te055TipoEncargo() ;
        @Data
        @Condition("C")
        ICondition teComissao() ;
        @Data
        @Condition("D")
        ICondition teDespesa() ;
        @Data
        @Condition("I")
        ICondition teImposto() ;
        
        
        @Data(size=3)
        IString mr242MomentoRecl() ;
        @Data
        @Condition("001")
        ICondition mrZCalAposPgmt() ;
        @Data
        @Condition("002")
        ICondition mrVencimento() ;
        @Data
        @Condition("003")
        ICondition mrAposPgmtPrst() ;
        @Data
        @Condition("004")
        ICondition mrZCalAposVenc() ;
        @Data
        @Condition("005")
        ICondition mrPerRcmzAposPgmt() ;
        
        
        @Data(size=1)
        IString cj760ICapzJuros() ;
        @Data
        @Condition("1")
        ICondition cjNao() ;
        @Data
        @Condition("2")
        ICondition cjPropriaOpcr() ;
        @Data
        @Condition("3")
        ICondition cjNoutraOpcr() ;
        
        
        @Data(size=4)
        IString ec148EvCobranca() ;
        @Data
        @Condition("0001")
        ICondition ecUniversal() ;
        
        
        @Data(size=3)
        IInt lb189LinhasBonif() ;
        @Data
        @Condition({ "999", "0" })
        ICondition lbSemBonificacao() ;
        @Data
        @Condition(range={"0", "999"})
        ICondition lbValida() ;
        
        
        @Data(size=1)
        IString cbV32CondBonif() ;
        @Data
        @Condition("N")
        ICondition cbNormal() ;
        @Data
        @Condition("I")
        ICondition cbImputada() ;
        @Data
        @Condition("D")
        ICondition cbDevolvida() ;
        @Data
        @Condition("E")
        ICondition cbEstornada() ;
        
        
        @Data(size=3)
        IString cm812CodMoeda() ;
        @Data
        @Condition("EUR")
        ICondition cmEuro() ;
        
        
        @Data(size=3)
        IString mdV36MotivoCntaDb() ;
        @Data
        @Condition("001")
        ICondition mdCHabOutrInstCr() ;
        
        
        @Data(size=3)
        IString msV22MotSubstProd() ;
        @Data
        @Condition("001")
        ICondition msFalsasDeclar() ;
        @Data
        @Condition("002")
        ICondition msCobranJudicial() ;
        @Data
        @Condition("003")
        ICondition msHonraGarantia() ;
        
        
        @Data(size=3)
        IString ce756CodEncargo() ;
        @Data
        @Condition("155")
        ICondition ceComDisponGestao() ;
        @Data
        @Condition("156")
        ICondition ceComImobilizacao() ;
        
        
        @Data(size=1)
        IString tfV37TipoFormal() ;
        @Data
        @Condition("E")
        ICondition tfEscNotaPriv() ;
        @Data
        @Condition("P")
        ICondition tfEscNotarioPub() ;
        @Data
        @Condition("D")
        ICondition tfOtDoc() ;
        @Data
        @Condition("N")
        ICondition tfOtEscPubNtPrv() ;
        @Data
        @Condition("C")
        ICondition tfOtEscPubNtPub() ;
        @Data
        @Condition("F")
        ICondition tfDocCCphAb() ;
        @Data
        @Condition("A")
        ICondition tfDocSCphAb() ;
        @Data
        @Condition("O")
        ICondition tfOtrCntDocPrt() ;
        @Data
        @Condition("B")
        ICondition tfOtrCntDocPrtPn() ;
        @Data
        @Condition("G")
        ICondition tfOtrCntDocPrtC() ;
        @Data
        @Condition("Q")
        ICondition tfEscPubNtPubHp() ;
        @Data
        @Condition("R")
        ICondition tfEscPbNotPrivHp() ;
        @Data
        @Condition("S")
        ICondition tfCasaPronta() ;
        @Data
        @Condition("T")
        ICondition tfCasaProntaTrf() ;
        
        
        /**
         * MCM - 2008-09-17 - Casa Pronta - FIM
         */
        @Data(size=6)
        IInt fc167FineCred() ;
        @Data
        @Condition("000001")
        ICondition fcAqHabPermNova() ;
        @Data
        @Condition("000002")
        ICondition fcAqHabPermUsada() ;
        @Data
        @Condition("000003")
        ICondition fcAqHabSecNova() ;
        @Data
        @Condition("000004")
        ICondition fcAqHabSecUsada() ;
        @Data
        @Condition("000005")
        ICondition fcAqHabRendNova() ;
        @Data
        @Condition("000006")
        ICondition fcAqHabRendUsada() ;
        @Data
        @Condition("000007")
        ICondition fcAqImovRendimento() ;
        @Data
        @Condition("000008")
        ICondition fcAqImovServProp() ;
        @Data
        @Condition("000009")
        ICondition fcAqOutrasFinalid() ;
        @Data
        @Condition("000010")
        ICondition fcAqTerrConstrucao() ;
        @Data
        @Condition("000013")
        ICondition fcCtHabPermanente() ;
        @Data
        @Condition("000014")
        ICondition fcCtHabSecundaria() ;
        @Data
        @Condition("000015")
        ICondition fcCtHabRendimento() ;
        @Data
        @Condition("000020")
        ICondition fcObHabPerm() ;
        @Data
        @Condition("000021")
        ICondition fcObHabSec() ;
        @Data
        @Condition("000022")
        ICondition fcObHabRend() ;
        @Data
        @Condition("000023")
        ICondition fcObConsHabPerm() ;
        @Data
        @Condition("000024")
        ICondition fcObConsHabSec() ;
        @Data
        @Condition("000025")
        ICondition fcObConsHabRend() ;
        @Data
        @Condition("000026")
        ICondition fcObCoexHabPerm() ;
        @Data
        @Condition("000027")
        ICondition fcObCoexHabSec() ;
        @Data
        @Condition("000028")
        ICondition fcObCoexHabRend() ;
        @Data
        @Condition("000029")
        ICondition fcObBenHabPerm() ;
        @Data
        @Condition("000030")
        ICondition fcObBenHabSec() ;
        @Data
        @Condition("000031")
        ICondition fcObBenHabRend() ;
        @Data
        @Condition("000032")
        ICondition fcObImovRendimento() ;
        @Data
        @Condition("000033")
        ICondition fcObImovServProp() ;
        @Data
        @Condition("000034")
        ICondition fcObOutrasFinalid() ;
        @Data
        @Condition("000035")
        ICondition fcObCondominio() ;
        @Data
        @Condition("000036")
        ICondition fcObInquilinos() ;
        @Data
        @Condition("000040")
        ICondition fcCnHabPermanente() ;
        @Data
        @Condition("000041")
        ICondition fcCnHabSecundaria() ;
        @Data
        @Condition("000042")
        ICondition fcCnHabRendimento() ;
        @Data
        @Condition("000043")
        ICondition fcCnImovRendimento() ;
        @Data
        @Condition("000044")
        ICondition fcCnImovServProp() ;
        @Data
        @Condition("000045")
        ICondition fcCnOutrasFinalid() ;
        @Data
        @Condition("000050")
        ICondition fcInPreFbHabPer() ;
        @Data
        @Condition("000051")
        ICondition fcInPreFbHabSec() ;
        @Data
        @Condition("000052")
        ICondition fcInPreFbHabRend() ;
        @Data
        @Condition("000064")
        ICondition fcIntercalarSinal() ;
        @Data
        @Condition("000065")
        ICondition fcIntercalarTroca() ;
        @Data
        @Condition("000066")
        ICondition fcIntercalarAqTer() ;
        @Data
        @Condition("000067")
        ICondition fcCrediobrasHabPer() ;
        @Data
        @Condition("000068")
        ICondition fcCrediobrasHabSec() ;
        @Data
        @Condition("000069")
        ICondition fcCrediobrasHabRen() ;
        @Data
        @Condition("000160")
        ICondition fcAplFinBenefFisc() ;
        @Data
        @Condition("000161")
        ICondition fcAccoesCimpor() ;
        @Data
        @Condition("000162")
        ICondition fcAccoesEdp() ;
        @Data
        @Condition("000163")
        ICondition fcAccoesBrisa() ;
        @Data
        @Condition("000164")
        ICondition fcAccoesSoporcel() ;
        @Data
        @Condition("000165")
        ICondition fcAccoesRobialac() ;
        @Data
        @Condition("000166")
        ICondition fcAccoesPteTelecom() ;
        @Data
        @Condition("000167")
        ICondition fcAccoesPtMultimed() ;
        @Data
        @Condition("000168")
        ICondition fcAccoesSonae() ;
        @Data
        @Condition("000169")
        ICondition fcAccoesDeutsTelek() ;
        @Data
        @Condition("000170")
        ICondition fcAccoesCxgestPrem() ;
        @Data
        @Condition("000224")
        ICondition fcObConsHabSecAn() ;
        @Data
        @Condition("000227")
        ICondition fcObCoexHabSecAn() ;
        @Data
        @Condition("000230")
        ICondition fcObBenfHabSecAn() ;
        @Data
        @Condition("000268")
        ICondition fcCrediobHabSecAn() ;
        @Data
        @Condition("000374")
        ICondition fcIapmeiIntD95J96() ;
        @Data
        @Condition("000376")
        ICondition fcIapmeiIntD9697() ;
        @Data
        @Condition({ "000385", "000424" })
        ICondition fcIapmeiIntOutN97() ;
        @Data
        @Condition({ "000420", "000423" })
        ICondition fcIapmeiIntD96J97() ;
        @Data
        @Condition("000539")
        ICondition fcIniComPmeIapmei() ;
        @Data
        @Condition("000543")
        ICondition fcObReabUrbSocial() ;
        @Data
        @Condition("000544")
        ICondition fcObReabUrbana() ;
        @Data
        @Condition("000571")
        ICondition fcIapmeiIngaIfadap() ;
        @Data
        @Condition("000633")
        ICondition fcReestrutCredito() ;
        @Data
        @Condition("000651")
        ICondition fcIapmeiIncend2003() ;
        
        
        @Data(size=1)
        IString esV21EventoPlnFin() ;
        @Data
        @Condition("1")
        ICondition esVencPrestacao() ;
        @Data
        @Condition("2")
        ICondition esVencComissao() ;
        @Data
        @Condition("3")
        ICondition esAmortizacao() ;
        @Data
        @Condition("4")
        ICondition esUtilizacao() ;
        @Data
        @Condition("5")
        ICondition esImpSeloMensal() ;
        @Data
        @Condition("6")
        ICondition esSimCContratacao() ;
        @Data
        @Condition("7")
        ICondition esSimSContratacao() ;
        @Data
        @Condition("8")
        ICondition esVencPrestDupla() ;
        
        
        /**
         * VS - 2006/04/06 - NA272 - FIM
         */
        @Data(size=2)
        IString sp114CSitProfEmp() ;
        @Data
        @Condition("01")
        ICondition spActivo() ;
        @Data
        @Condition("02")
        ICondition spRequisVencCgd() ;
        @Data
        @Condition("03")
        ICondition spPreReforma() ;
        @Data
        @Condition("04")
        ICondition spRequisitado() ;
        @Data
        @Condition("05")
        ICondition spLicencSemVenc() ;
        @Data
        @Condition("06")
        ICondition spAposentadoCgd() ;
        @Data
        @Condition("07")
        ICondition spAposFpExBnu() ;
        @Data
        @Condition("08")
        ICondition spSuspenso() ;
        @Data
        @Condition("09")
        ICondition spFalecido() ;
        
        
        @Data(size=1)
        IString td119CTipoDebito() ;
        @Data
        @Condition("1")
        ICondition tdRemuneracao() ;
        @Data
        @Condition("2")
        ICondition tdDo1dUtilMesSeg() ;
        @Data
        @Condition("3")
        ICondition tdDoDiaPensaoCga() ;
        @Data
        @Condition("4")
        ICondition tdDoDiaPensaoFp() ;
        @Data
        @Condition("5")
        ICondition tdDoDiaPrestacao() ;
        @Data
        @Condition("6")
        ICondition tdDoCobrancaManual() ;
        
        
        @Data(size=1)
        IString caX01CClasseAtras() ;
        @Data
        @Condition("0")
        ICondition caCredVencClss0() ;
        @Data
        @Condition("1")
        ICondition caCredVencClss1() ;
        @Data
        @Condition("2")
        ICondition caCredVencClss2() ;
        @Data
        @Condition("3")
        ICondition caCredVencClss3() ;
        @Data
        @Condition("4")
        ICondition caCredVencClss4() ;
        @Data
        @Condition("5")
        ICondition caCredVencClss5() ;
        @Data
        @Condition("6")
        ICondition caCredVencClss6() ;
        @Data
        @Condition("7")
        ICondition caCredVencClss7() ;
        @Data
        @Condition("8")
        ICondition caCredVencClss8() ;
        @Data
        @Condition("9")
        ICondition caCredVencClss9() ;
        @Data
        @Condition("A")
        ICondition caCredVencClss10() ;
        @Data
        @Condition("B")
        ICondition caCredVencClss11() ;
        @Data
        @Condition("C")
        ICondition caCredVencClss12() ;
        
        
        @Data(size=1)
        IString opV39TitulrzRecomp() ;
        @Data
        @Condition("T")
        ICondition opTitularizada() ;
        @Data
        @Condition("N")
        ICondition opNaoTitularizada() ;
        @Data
        @Condition("R")
        ICondition opRecomprada() ;
        @Data
        @Condition("A")
        ICondition opAfecta() ;
        @Data
        @Condition("D")
        ICondition opDesafecta() ;
        @Data
        @Condition("E")
        ICondition opEleita() ;
        @Data
        @Condition("F")
        ICondition opAfectaOsp() ;
        @Data
        @Condition("S")
        ICondition opDesafectaOsp() ;
        @Data
        @Condition("L")
        ICondition opEleitaOsp() ;
        
        
        @Data(size=2)
        IString cd121CodTitulrz() ;
        @Data
        @Condition("NC")
        ICondition cdNostrumConsumer() ;
        @Data
        @Condition("NM")
        ICondition cdNostrumMortgage() ;
        @Data
        @Condition("OH")
        ICondition cdObrigHipotec() ;
        @Data
        @Condition("OP")
        ICondition cdObrigSectPub() ;
        
        
        @Data(size=3)
        IInt csS20CompSeguros() ;
        @Data
        @Condition("001")
        ICondition csFidelidade() ;
        
        
        @Data(size=1)
        IString mpE91MeioPgmtBonz() ;
        @Data
        @Condition("1")
        ICondition mpDebitoCtaDo() ;
        @Data
        @Condition("2")
        ICondition mpRegularizDiario() ;
        @Data
        @Condition("3")
        ICondition mpCreditoNib() ;
        @Data
        @Condition("4")
        ICondition mpCredContaCgdBp() ;
        
        
        @Data(size=2)
        IInt rc320CodRgaoCntab() ;
        @Data
        @Condition("01")
        ICondition rcContinente() ;
        @Data
        @Condition("02")
        ICondition rcRaMadeira() ;
        @Data
        @Condition("03")
        ICondition rcRaAcores() ;
        
        
        @Data(size=2)
        IString fc167FineCredIrs() ;
        @Data
        @Condition("F1")
        ICondition fcHabitacao() ;
        @Data
        @Condition("F2")
        ICondition fcHabitacaoArrend() ;
        @Data
        @Condition("F3")
        ICondition fcMatInformatico() ;
        @Data
        @Condition("F4")
        ICondition fcDespSaude() ;
        @Data
        @Condition("F5")
        ICondition fcHabitacaoSecund() ;
        
        
        @Data(size=3)
        IString td312TipoDocSpte() ;
        @Data
        @Condition("034")
        ICondition tdAtestIncapTemp() ;
        @Data
        @Condition("123")
        ICondition tdCompRendEscolar() ;
        @Data
        @Condition("162")
        ICondition tdNotaLiquidacao() ;
        
        
        @Data(size=3)
        IString eb290CEntBonif() ;
        @Data
        @Condition("001")
        ICondition ebCaixaGeralDep() ;
        @Data
        @Condition("002")
        ICondition ebBancoPortugal() ;
        @Data
        @Condition("003")
        ICondition ebDirGeralTesouro() ;
        
        
        @Data(size=3)
        IString ci585CodigoInst() ;
        @Data
        @Condition("CGD")
        ICondition ciCaixaGeralDep() ;
        @Data
        @Condition("INH")
        ICondition ciInstNacionalHab() ;
        
        
        @Data(size=3)
        IString tdY01CodTipoDecl() ;
        @Data
        @Condition("FSC")
        ICondition tdDeclaracaoFiscal() ;
        @Data
        @Condition("AGF")
        ICondition tdDeclaracaoAgf() ;
        
        
        @Data(size=3)
        IString jp238JustContPoup() ;
        @Data
        @Condition("SHP")
        ICondition jpSinAqHabPerm() ;
        @Data
        @Condition("SHA")
        ICondition jpSinAqHabArre() ;
        @Data
        @Condition("AQP")
        ICondition jpAquisiHabPerm() ;
        @Data
        @Condition("AQA")
        ICondition jpAquisiHabArre() ;
        @Data
        @Condition("CHP")
        ICondition jpConstrHabPerm() ;
        @Data
        @Condition("CHA")
        ICondition jpConstrHabArre() ;
        @Data
        @Condition("ECO")
        ICondition jpEntregCoopHab() ;
        @Data
        @Condition("OHP")
        ICondition jpObrasHabPerm() ;
        @Data
        @Condition("OHA")
        ICondition jpObrasHabArre() ;
        @Data
        @Condition("AIN")
        ICondition jpAmoEmpHabCgd() ;
        
        
        @Data(size=3)
        IInt tc272TipoConta() ;
        @Data
        @Condition({ "007", "013", "023" })
        ICondition tcPoupHabitacao() ;
        
        
        @Data(size=3)
        IString mr459ModReclam() ;
        @Data
        @Condition("001")
        ICondition mrFicheiro() ;
        @Data
        @Condition("002")
        ICondition mrRelatorio() ;
        @Data
        @Condition("003")
        ICondition mrDespachoNorm() ;
        
        
        @Data(size=1)
        IString tlH06TipoLote() ;
        @Data
        @Condition("A")
        ICondition tlAutomatico() ;
        @Data
        @Condition("M")
        ICondition tlManual() ;
        
        
    }
    
}
