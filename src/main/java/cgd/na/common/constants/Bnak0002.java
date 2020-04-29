package cgd.na.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bnak0002 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelasGerais
     */
    @Data
    TabelasGerais tabelasGerais() ;
    
    /**
     * @return instancia da classe local ValoresGenericos
     */
    @Data
    ValoresGenericos valoresGenericos() ;
    
    /**
     * @return instancia da classe local ValoresBooleanos
     */
    @Data
    ValoresBooleanos valoresBooleanos() ;
    
    /**
     * @return instancia da classe local AcessoRotinas
     */
    @Data
    AcessoRotinas acessoRotinas() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BNAK0002 CONSTANTES E SWITCHES DA APLICACAO DE CREDITO
     * 
     * @version 2.0
     * 
     */
    public interface TabelasGerais extends IDataStruct {
        
        @Data(size=3, value="103")
        IString tgSituacoesOperacao() ;
        
        @Data(size=3, value="104")
        IString tgGatilhoPProc() ;
        
        @Data(size=3, value="105")
        IString tgTrxParmOpcr() ;
        
        @Data(size=3, value="106")
        IString tgEscalaoSisa() ;
        
        @Data(size=3, value="108")
        IString tgEvSubEncImp() ;
        
        @Data(size=3, value="110")
        IString tgMapaBonif() ;
        
        @Data(size=3, value="113")
        IString tgPriorCbrc() ;
        
        @Data(size=3, value="114")
        IString tgDataCbrcEmpg() ;
        
        @Data(size=3, value="116")
        IString tgRegrasMov() ;
        
        @Data(size=3, value="880")
        IString tgAgregSitProfEmp() ;
        
        @Data(size=3, value="119")
        IString tgTipoCobPrszEmpg() ;
        
        @Data(size=3, value="120")
        IString tgProdsegu() ;
        
        @Data(size=3, value="121")
        IString tgCodTitularizacao() ;
        
        @Data(size=3, value="158")
        IString tgFamiliaProduto() ;
        
        @Data(size=3, value="167")
        IString tgCFineCred() ;
        
        @Data(size=3, value="189")
        IString tgLinhaBonif() ;
        
        @Data(size=3, value="260")
        IString tgTipoPdeJuros() ;
        
        @Data(size=3, value="277")
        IString tgTipoPraz() ;
        
        @Data(size=3, value="290")
        IString tgEntRsplBonz() ;
        
        @Data(size=3, value="302")
        IString tgTipoContrato() ;
        
        @Data(size=3, value="457")
        IString tgCritDap() ;
        
        @Data(size=3, value="474")
        IString tgFaseOpcr() ;
        
        @Data(size=3, value="585")
        IString tgCodMnemonica() ;
        
        @Data(size=3, value="685")
        IString tgParcalipt() ;
        
        @Data(size=3, value="764")
        IString tgCMovOpContab() ;
        
        @Data(size=3, value="756")
        IString tgCodEncargos() ;
        
        @Data(size=3, value="765")
        IString tgFamilia() ;
        
        @Data(size=3, value="814")
        IString tgDesdobrGarantia() ;
        
        @Data(size=3, value="879")
        IString tgRegimeJuridico() ;
        
        @Data(size=3, value="910")
        IString tgPais() ;
        
        @Data(size=3, value="920")
        IString tgCodigoPostal() ;
        
        @Data(size=3, value="983")
        IString tgBancoPorPais() ;
        
        @Data(size=3, value="A07")
        IString tgCodErro() ;
        
        @Data(size=3, value="E99")
        IString tgCTipoTaxa() ;
        
        @Data(size=3, value="V17")
        IString tgMtvoBlqoOpcr() ;
        
        @Data(size=3, value="V34")
        IString tgTipoLoteRecl() ;
        
        @Data(size=3, value="V20")
        IString tgSitFncoOpcr() ;
        
        @Data(size=3, value="121")
        IString tgCodTitularz() ;
        
        @Data(size=3, value="V48")
        IString tgCodCondicion() ;
        
    }
    public interface ValoresGenericos extends IDataStruct {
        
        @Data(size=2, value="NA")
        IString aAplCredito() ;
        
        @Data(size=2, value="NL")
        IString aAplContLiq() ;
        
        @Data(size=1, value="S")
        IString sim() ;
        
        @Data(size=1, value="N")
        IString nao() ;
        
        @Data(size=1, value="E")
        IString movimentoEstorno() ;
        
        @Data(size=10, value="0001-01-01")
        IString dataMinima() ;
        
        @Data(size=10, value="9999-12-31")
        IString dataMaxima() ;
        
        @Data(size=1, value="1")
        IString erro() ;
        
        @Data(size=1, value="P")
        IString visMensal() ;
        
        @Data(size=1, value="A")
        IString visAnual() ;
        
        @Data(size=2, value="01")
        IString diaUm() ;
        
        @Data(size=2, value="01")
        IString mesUm() ;
        
        @Data(size=1, value="0")
        IInt zero() ;
        
        @Data(size=1, value="1")
        IInt um() ;
        
        @Data(size=1, value="2")
        IInt dois() ;
        
        @Data(size=1, value="9")
        IInt nove() ;
        
        @Data(size=2, value="15")
        IInt quinzeDias() ;
        
        @Data(size=2, value="30")
        IInt trintaDias() ;
        
        @Data(size=3, value="999")
        IInt tresNoves() ;
        
        @Data(size=4, value="9999")
        IInt quatroNoves() ;
        
        @Data(size=1, value="X")
        IString valorX() ;
        
        @Data(size=17, decimal=2, signed=true, value="999999", compression=COMP3)
        IDecimal conMaxEncargo() ;
        
        @Data(size=10, decimal=7, signed=true, value="58", compression=COMP3)
        IDecimal perJurNcapDl328b86() ;
        
        @Data(size=4, value="9999")
        IInt cOeInformatica() ;
        
        @Data(size=4, value="35")
        IInt cBancoGcgd() ;
        
        @Data(size=3, value="125")
        IInt ifCgd() ;
        
        @Data(size=3, value="PT ")
        IString pt() ;
        
        @Data(size=1, value="V")
        IString visualizacao() ;
        
        @Data(size=4, value="9170")
        IInt cDpi() ;
        
        @Data(size=3, value="DPI")
        IString mneDpi() ;
        
        @Data(size=4, value="9350")
        IInt cDpe() ;
        
        @Data(size=3, value="DPE")
        IString mneDpe() ;
        
        @Data(size=4, value="9015")
        IInt cDcp() ;
        
        @Data(size=3, value="DCP")
        IString mneDcp() ;
        
        @Data(size=9, value="500960046")
        ILong nIpcCgd() ;
        
        @Data(size=3, value="99")
        IInt prioPrctGtlo99() ;
        
        @Data(size=1, value="I")
        IString iTipoFmonIcb() ;
        
        @Data(size=4, value="9170")
        IInt cOeServico() ;
        
        /**
         * Sector Institucional para a rotina de encargos, quando
         * nao ha numero de cliente. Serve para determinar isencoes
         * de impostos. Assume-se "Outros Particulares Residentes".
         */
        @Data(size=7, signed=true, value="1321200", compression=COMP3)
        IInt sIttlOutPartResid() ;
        
        /**
         * Tipo de isencao para a rotina de encargos, quando nao
         * ha numero de cliente. Assume-se "Nao Isento".
         */
        @Data(size=6, value="000000")
        IString tipoIsezFsclSIsez() ;
        
        /**
         * Para totalizacao. Os totalizadores nao variam por tipo de
         * conta, no Credito.
         */
        @Data(size=3, signed=true, value="999", compression=COMP3)
        IInt cTipoContDefault() ;
        
        /**
         * Para obtencao das regras de afectacao de saldos: primeiro
         * acede com o evento especifico e depois com este evento
         * default...
         */
        @Data(size=4, value="DFLT")
        IString cEvenDfltAfctSld() ;
        
        /**
         * Para controlar o notfnd sem ter de incluir o BHGK0001...
         * 05 BHGK0001-CODIGO-INEXISTENTE   PIC S9(03) VALUE +109.
         */
        @Data(size=3, signed=true, value="109")
        IInt codigoInexistente() ;
        
        @Data(size=1, value="T")
        IString tratado() ;
        
        @Data(size=1, value="R")
        IString rejeitado() ;
        
        @Data(size=1, value="C")
        IString confirmado() ;
        
        @Data(size=1, value="A")
        IString agravamento() ;
        
        @Data(size=1, value="M")
        IString melhoria() ;
        
        @Data(size=2, value="99")
        IInt doisNoves() ;
        
        @Data(size=1, value="6")
        IInt seis() ;
        
        /**
         * NA21686 - DL58 - INI
         */
        @Data(size=10, value="2013-09-05")
        IString dataDl582013() ;
        
    }
    
    /**
     * 
     * NA21686 - DL58 - FIM
     * 
     * @version 2.0
     * 
     */
    public interface ValoresBooleanos extends IDataStruct {
        
        @Data(size=1)
        IString estadoOperacao() ;
        @Data
        @Condition("P")
        ICondition swEstadoProposta() ;
        @Data
        @Condition("C")
        ICondition swEstadoContrato() ;
        @Data
        @Condition("I")
        ICondition swEstadoIncumprim() ;
        
        
        @Data(size=5)
        IInt codigosPeriodicidade() ;
        @Data
        @Condition(range={"03", "09"})
        ICondition swPerValido() ;
        @Data
        @Condition("00")
        ICondition swSemPer() ;
        @Data
        @Condition("01")
        ICondition swPerDiaria() ;
        @Data
        @Condition("02")
        ICondition swPerSemanal() ;
        @Data
        @Condition("03")
        ICondition swPerQuinzenal() ;
        @Data
        @Condition("04")
        ICondition swPerMensal() ;
        @Data
        @Condition("05")
        ICondition swPerBimestral() ;
        @Data
        @Condition("06")
        ICondition swPerTrimestral() ;
        @Data
        @Condition("07")
        ICondition swPerQuadrimestral() ;
        @Data
        @Condition("08")
        ICondition swPerSemestral() ;
        @Data
        @Condition("09")
        ICondition swPerAnual() ;
        @Data
        @Condition("32")
        ICondition swPerFimFase() ;
        
        
        /**
         * *IS 2005-12-12 FIM
         */
        @Data(size=1)
        IString tiposConvTaxa() ;
        @Data
        @Condition("N")
        ICondition swConvNominal() ;
        @Data
        @Condition("E")
        ICondition swConvEfectiva() ;
        @Data
        @Condition("Q")
        ICondition swConvEquivalente() ;
        
        
        @Data(size=2)
        IString codigoTipoTrttCont() ;
        @Data
        @Condition({ "01", "19", "26", "27", "28" })
        ICondition swDepositosOrdem() ;
        @Data
        @Condition("04")
        ICondition swEmprestimos() ;
        @Data
        @Condition("05")
        ICondition swGarantBancarias() ;
        @Data
        @Condition("08")
        ICondition swContasCaucao() ;
        @Data
        @Condition("11")
        ICondition swEfeitos() ;
        @Data
        @Condition("13")
        ICondition swContasCorrentes() ;
        @Data
        @Condition("20")
        ICondition swLimites() ;
        @Data
        @Condition("21")
        ICondition swSeguros() ;
        @Data
        @Condition("22")
        ICondition swContasLiquidar() ;
        @Data
        @Condition("31")
        ICondition swCartoes() ;
        
        
        @Data(size=1)
        IString tiposVencimento() ;
        @Data
        @Condition("A")
        ICondition swVencAntecipado() ;
        @Data
        @Condition("P")
        ICondition swVencPostecipado() ;
        
        
        @Data(size=1)
        IString sinalMovimento() ;
        @Data
        @Condition("D")
        ICondition swMovimDebito() ;
        @Data
        @Condition("C")
        ICondition swMovimCredito() ;
        
        
        @Data(size=1)
        IString tiposCobranca() ;
        @Data
        @Condition("I")
        ICondition swCobrancaImediata() ;
        @Data
        @Condition("P")
        ICondition swPendCobranca() ;
        
        
        @Data(size=1)
        IString codSitCntLiq() ;
        @Data
        @Condition("C")
        ICondition swCntLiqNActiva() ;
        @Data
        @Condition("A")
        ICondition swCntLiqActiva() ;
        
        
        @Data(size=9)
        IString codPrograma() ;
        @Data
        @Condition("PNLS013A")
        ICondition swMovCntLiq() ;
        @Data
        @Condition("PNAS393A")
        ICondition swBloAdm() ;
        @Data
        @Condition("PNAS013A")
        ICondition swContratacao() ;
        @Data
        @Condition("PNAS014A")
        ICondition swContratacaoA() ;
        @Data
        @Condition("PNAS033A")
        ICondition swAlterContratuais() ;
        @Data
        @Condition("PNAS232A")
        ICondition swImputacaoEnc() ;
        @Data
        @Condition("PNAS234A")
        ICondition swImputacaoEncA() ;
        @Data
        @Condition("PNAS123A")
        ICondition swLimAutorizado() ;
        @Data
        @Condition("PNAS327A")
        ICondition swImputacaoBonif() ;
        @Data
        @Condition("PNAS132A")
        ICondition swRfroRduzI() ;
        @Data
        @Condition("PNAS134A")
        ICondition swRfroRduzA() ;
        @Data
        @Condition("PNAS191A")
        ICondition swAlterBalcTit() ;
        @Data
        @Condition("PNAS173A")
        ICondition swDenunciaGbnc() ;
        @Data
        @Condition("PNAQ240A")
        ICondition swRecalPrestBonif() ;
        @Data
        @Condition("PNAQ260A")
        ICondition swConstLote() ;
        @Data
        @Condition("PNAQ262A")
        ICondition swReclDevlBonif() ;
        @Data
        @Condition("PNAQ020A")
        ICondition swLancamentoOpvs() ;
        @Data
        @Condition("PNAQ025A")
        ICondition swContratacaoOpvs() ;
        @Data
        @Condition("PNAQ300A")
        ICondition swActzSldDtValor() ;
        @Data
        @Condition("PNAS371A")
        ICondition swGestaoLtBonif() ;
        @Data
        @Condition("PNAQ150A")
        ICondition swInstUtiliLTele() ;
        @Data
        @Condition("PNAQ151A")
        ICondition swInstAmortLTele() ;
        @Data
        @Condition("PNAQ155A")
        ICondition swIstzAmozUtizO() ;
        @Data
        @Condition("PNAQ220A")
        ICondition swEvenDataAdmin() ;
        @Data
        @Condition("PNAQ340A")
        ICondition swTratOperClRecla() ;
        @Data
        @Condition("PNAQ342A")
        ICondition swReclAltInstCLiR00() ;
        @Data
        @Condition("PNLQ344A")
        ICondition swReclAltInstCLiR01() ;
        @Data
        @Condition("PNAQ695A")
        ICondition swAcumSaldosCart() ;
        @Data
        @Condition("PNAQ268A")
        ICondition swApmtAdicionais() ;
        @Data
        @Condition("PNAS278A")
        ICondition swUtlzConvencA() ;
        @Data
        @Condition("PNAS276A")
        ICondition swUtlzConvencI() ;
        @Data
        @Condition("PNAQ320A")
        ICondition swProgPeriodif() ;
        @Data
        @Condition("PNAQ325A")
        ICondition swPrdfComssPeriod() ;
        @Data
        @Condition("PNAS212A")
        ICondition swAmortizacaoI() ;
        @Data
        @Condition("PNAS214A")
        ICondition swAmortizacaoA() ;
        @Data
        @Condition("PNAQ142A")
        ICondition swLiquidacaoAutom() ;
        @Data
        @Condition("PNAQ764A")
        ICondition swCalcImpSeloB() ;
        @Data
        @Condition("PNAQ760A")
        ICondition swTrmtVenciment0s() ;
        @Data
        @Condition("PNAQ396A")
        ICondition swActualizaClAtras() ;
        @Data
        @Condition("PNAQ161A")
        ICondition swDistValorMovim() ;
        @Data
        @Condition("PNAS141A")
        ICondition swManutInstsbanc() ;
        @Data
        @Condition("PNAS202A")
        ICondition swUtilizacaoI() ;
        @Data
        @Condition("PNAS204A")
        ICondition swUtilizacaoA() ;
        @Data
        @Condition("PNAS222A")
        ICondition swLiqAntecipadaI() ;
        @Data
        @Condition("PNAS224A")
        ICondition swLiqAntecipadaA() ;
        @Data
        @Condition("PNAS062A")
        ICondition swSbtzProdutoC() ;
        @Data
        @Condition("PNAS064A")
        ICondition swSbtzProdutoA() ;
        @Data
        @Condition("PNAS293A")
        ICondition swTitularizRecM() ;
        @Data
        @Condition("PNAS333A")
        ICondition swEstornoManualM() ;
        @Data
        @Condition("PNAS253A")
        ICondition swAnulCobrancaM() ;
        @Data
        @Condition("PNAQ264A")
        ICondition swAfectBonific() ;
        @Data
        @Condition("PNAQ762A")
        ICondition swTratVencComPer() ;
        @Data
        @Condition("PNAQ170A")
        ICondition swTratMProdPraz() ;
        @Data
        @Condition("PNAQ110A")
        ICondition swAnaliseResTeled() ;
        @Data
        @Condition("PNAQ100A")
        ICondition swCobrancaAutomat() ;
        @Data
        @Condition("PNAS243A")
        ICondition swCobrancaManualM() ;
        @Data
        @Condition("PNAQ115A")
        ICondition swCobrancaRemunera() ;
        @Data
        @Condition("PNAQ120A")
        ICondition swTratRespMeta4() ;
        @Data
        @Condition("PNAQ736A")
        ICondition swCalculoJurosMora() ;
        @Data
        @Condition("PNAQ190A")
        ICondition swEntdVigCondDin() ;
        
        
        @Data(size=1)
        IString cBaseIncidEnc() ;
        @Data
        @Condition("C")
        ICondition swCIncidCapital() ;
        @Data
        @Condition("J")
        ICondition swCIncidJuros() ;
        @Data
        @Condition("M")
        ICondition swCIncidJmora() ;
        @Data
        @Condition("O")
        ICondition swCIncidOutro() ;
        
        
        @Data(size=2)
        IString codProdutoEspecial() ;
        @Data
        @Condition("01")
        ICondition swFinancSeguros() ;
        @Data
        @Condition("02")
        ICondition swFundosPerdidos() ;
        @Data
        @Condition("03")
        ICondition swOperacaoSindicada() ;
        @Data
        @Condition("04")
        ICondition swConvencionados() ;
        @Data
        @Condition("05")
        ICondition swCreditoIntercalar() ;
        @Data
        @Condition("06")
        ICondition swRecursoAlheio() ;
        @Data
        @Condition("07")
        ICondition swMultiopcoes() ;
        @Data
        @Condition("08")
        ICondition swCrediobras() ;
        @Data
        @Condition("09")
        ICondition swCcCpd() ;
        @Data
        @Condition("10")
        ICondition swCcGat() ;
        
        
        @Data(size=2)
        IString codMcCapital() ;
        @Data
        @Condition({ "PP", "MT", "PC" })
        ICondition swMccFactorCresc() ;
        @Data
        @Condition("PP")
        ICondition swMccPercJNCap() ;
        @Data
        @Condition({ "FR", "RF", "CD", "EP", "DF" })
        ICondition swMccPerIguais() ;
        @Data
        @Condition({ "LI", "AM", "99", "  ", "HL" })
        ICondition swMccSemPer() ;
        @Data
        @Condition("LI")
        ICondition swMccPlanos() ;
        @Data
        @Condition({ "HC", "AM", "FR", "RF", "PP", "MT", "HL", "PA", "PC", "CD", "EP", "DF" })
        ICondition swMccJurosPeriodo() ;
        @Data
        @Condition({ "HC", "AM", "LI", "HL", "PA" })
        ICondition swMccJurosDia() ;
        @Data
        @Condition({ "HC", "AM", "LI", "HL" })
        ICondition swMccJurosPlanos() ;
        
        
        @Data(size=2)
        IString codMcJuros() ;
        @Data
        @Condition("PM")
        ICondition swMcjPlanos() ;
        @Data
        @Condition({ "PM", "PJ", "DF", "99", "  " })
        ICondition swMcjSemPer() ;
        
        
        /**
         * GS - 2005/07/21 - FORAM INCLUIDOS NESTE SWITCH OS VALORES DAS
         * LINHAS DE BONIFICACAO USADOS PELA MNAJ022A PARA CALCULO DAS
         * PRESTACOES.
         * ]]]]]]]]]]]]]]]]]   ATENCAO ]]]]]]]]]]]]]]]]]]]]]]]]
         * E OBRIGATORIO GARANTIR QUE SE OS CODIGOS DAS LINHAS DE
         * BONIFICACAO INCLUIDAS NOS NIVEIS 88 QUE AS AGRUPAM POR TIPO
         * FOREM ALTERADOS, ESSES NIVEIS 88 TAMBEM TERAO QUE O SER.
         */
        @Data(size=3, signed=true, compression=COMP3)
        IInt codLinhaBonif() ;
        @Data
        @Condition({ "320", "322", "323", "324", "325" })
        ICondition lbEmiPart() ;
        @Data
        @Condition({ "570", "571", "044", "589", "590" })
        ICondition lbEmiEmp() ;
        @Data
        @Condition({ "370", "371" })
        ICondition lbInhPart() ;
        @Data
        @Condition({ "140", "150", "170", "175", "176", "177" })
        ICondition lbInhEmp() ;
        @Data
        @Condition({ "301", "302" })
        ICondition lbCooperativas() ;
        @Data
        @Condition({ "390", "391", "392", "420", "421", "422", "450", "452", "480", "481", "405", "406", "407", "435", "436", "437", "451", "465", "466", "467" })
        ICondition lb328b86() ;
        @Data
        @Condition({ "385", "386", "387", "415", "416", "417", "445", "446", "447", "475", "476", "400", "401", "402", "430", "431", "433", "460", "461", "462" })
        ICondition lb22489() ;
        @Data
        @Condition({ "380", "381", "382", "410", "411", "412", "440", "441", "442", "470", "471", "700", "701", "702", "706", "395", "396", "397", "425", "426", "427", "455", "456", "457", "703", "704", "705" })
        ICondition lb15091() ;
        @Data
        @Condition({ "315", "316", "317", "318", "319", "680", "681", "682", "683", "684", "685", "686", "687", "688", "689", "495" })
        ICondition lbDefConst() ;
        @Data
        @Condition({ "350", "351", "352", "353", "354" })
        ICondition lbEmpregados() ;
        @Data
        @Condition("321")
        ICondition lb54076() ;
        @Data
        @Condition({ "340", "341" })
        ICondition lb51577() ;
        @Data
        @Condition({ "330", "331", "332" })
        ICondition lb43580() ;
        @Data
        @Condition({ "312", "335", "336", "337", "355", "356", "367", "368", "369", "372" })
        ICondition lb45983() ;
        @Data
        @Condition({ "344", "345" })
        ICondition lbRcm() ;
        @Data
        @Condition({ "304", "305", "306", "307", "308", "309", "310", "311" })
        ICondition lbSismo() ;
        @Data
        @Condition({ "480", "481" })
        ICondition lb7789() ;
        @Data
        @Condition({ "385", "386", "387", "415", "416", "417", "445", "446", "447", "400", "401", "402", "430", "431", "433", "460", "461", "462", "380", "381", "382", "410", "411", "412", "440", "441", "442", "395", "396", "397", "425", "426", "427", "455", "456", "457", "470", "471", "475", "476", "700", "701", "702", "703", "704", "705", "706" })
        ICondition lbObrigaPrestCon() ;
        @Data
        @Condition({ "390", "391", "392", "420", "421", "422", "452", "405", "406", "407", "435", "436", "437", "451", "450", "465", "466", "467", "480", "481" })
        ICondition lbObrigaPrestProg() ;
        @Data
        @Condition({ "390", "391", "392", "420", "421", "422", "452", "405", "406", "407", "435", "436", "437", "450", "451", "465", "466", "467", "385", "386", "387", "415", "416", "417", "445", "446", "447", "400", "401", "402", "430", "431", "433", "460", "461", "462", "380", "381", "382", "410", "411", "412", "440", "441", "442", "395", "396", "397", "425", "426", "427", "455", "456", "457", "470", "471", "475", "476", "480", "481", "700", "701", "702", "703", "704", "705", "706" })
        ICondition lbDependeRab() ;
        @Data
        @Condition({ "390", "391", "392", "420", "421", "422", "452", "405", "406", "407", "435", "436", "437", "450", "451", "465", "466", "467", "385", "386", "387", "415", "416", "417", "445", "446", "447", "400", "401", "402", "430", "431", "433", "460", "461", "462", "380", "381", "382", "410", "411", "412", "440", "441", "442", "395", "396", "397", "425", "426", "427", "455", "456", "457", "470", "471", "475", "476", "480", "481", "495", "700", "701", "702", "703", "704", "705", "706" })
        ICondition lbADevolver() ;
        @Data
        @Condition({ "385", "386", "387", "415", "416", "417", "445", "446", "447", "400", "401", "402", "430", "431", "433", "460", "461", "462", "475", "476" })
        ICondition lbConstante() ;
        @Data
        @Condition({ "315", "316", "317", "318", "319", "680", "681", "682", "683", "684", "685", "686", "687", "688", "689", "495" })
        ICondition lbDeficientes() ;
        @Data
        @Condition({ "320", "322", "323", "324", "325", "570", "571", "044", "589", "590" })
        ICondition lbEmigrantes() ;
        @Data
        @Condition({ "405", "406", "407", "435", "436", "437", "451", "465", "466", "467", "400", "401", "402", "430", "431", "433", "460", "461", "462", "395", "396", "397", "425", "426", "427", "455", "456", "457", "703", "704", "705" })
        ICondition lbRabJovem() ;
        @Data
        @Condition({ "390", "391", "392", "420", "421", "422", "450", "452", "385", "386", "387", "415", "416", "417", "445", "446", "447", "380", "381", "382", "410", "411", "412", "440", "441", "442", "470", "471", "475", "476", "480", "481", "700", "701", "702", "706" })
        ICondition lbRabNJovem() ;
        @Data
        @Condition({ "321", "344", "345" })
        ICondition lbBonifDifPrest() ;
        @Data
        @Condition({ "390", "391", "392", "420", "421", "422", "452", "405", "406", "407", "435", "436", "437", "450", "451", "465", "466", "467", "385", "386", "387", "415", "416", "417", "445", "446", "447", "400", "401", "402", "430", "431", "433", "460", "461", "462", "312", "335", "336", "337", "355", "356", "367", "368", "369", "372", "475", "476", "480", "481" })
        ICondition lbBonifFixPAno() ;
        
        
        @Data(size=1)
        IString permPlnUtlzLivre() ;
        @Data
        @Condition("A")
        ICondition swPlnUtlzAuto() ;
        @Data
        @Condition("M")
        ICondition swPlnUtlzManual() ;
        @Data
        @Condition("N")
        ICondition swNaoPrmtPlnUtlz() ;
        
        
        @Data(size=1)
        IString iTipoSimul() ;
        @Data
        @Condition("1")
        ICondition swValorEmprestimo() ;
        @Data
        @Condition("2")
        ICondition swPrzEmprestimo() ;
        @Data
        @Condition("3")
        ICondition swValorAmortAnt() ;
        @Data
        @Condition("4")
        ICondition swValorUtilCap() ;
        
        
        @Data(size=3)
        IString cdProcessoBatch() ;
        @Data
        @Condition("125")
        ICondition swOpvs() ;
        @Data
        @Condition("142")
        ICondition swLiqAutomatica() ;
        @Data
        @Condition("262")
        ICondition swReclDevlBonifB() ;
        @Data
        @Condition("264")
        ICondition swAfectBonif() ;
        @Data
        @Condition("268")
        ICondition swApmtAdicion() ;
        @Data
        @Condition("320")
        ICondition swPeriodificacao() ;
        @Data
        @Condition("325")
        ICondition swPeriodifComss() ;
        @Data
        @Condition("760")
        ICondition swTrmtVencimentos() ;
        @Data
        @Condition("764")
        ICondition swCalcImpSeloCc() ;
        @Data
        @Condition("762")
        ICondition swTratComPeriod() ;
        @Data
        @Condition("170")
        ICondition swTratAltProdPraz() ;
        @Data
        @Condition("220")
        ICondition swTratEvenAdmin() ;
        @Data
        @Condition("398")
        ICondition contrlElectSaldos() ;
        @Data
        @Condition("110")
        ICondition swAnalsTeleCobr() ;
        @Data
        @Condition("150")
        ICondition swInstUtiliLTeled() ;
        @Data
        @Condition("151")
        ICondition swInstAmortLTeled() ;
        @Data
        @Condition("155")
        ICondition swAnalsTeleInstr() ;
        @Data
        @Condition("161")
        ICondition swDistValorOutEnt() ;
        @Data
        @Condition("736")
        ICondition swCalcJurosMora() ;
        @Data
        @Condition("801")
        ICondition swTitularizRecomp() ;
        @Data
        @Condition("190")
        ICondition swEntdVigCd() ;
        @Data
        @Condition("854")
        ICondition swAfectDesafOh() ;
        @Data
        @Condition("857")
        ICondition swAfectDesafOsp() ;
        @Data
        @Condition("120")
        ICondition swAnlsCobrEmpd() ;
        
        
        @Data(size=1)
        IString accao() ;
        @Data
        @Condition(" ")
        ICondition semAccao() ;
        @Data
        @Condition("I")
        ICondition accaoInsercao() ;
        @Data
        @Condition("A")
        ICondition accaoAnulacao() ;
        @Data
        @Condition("M")
        ICondition accaoAlteracao() ;
        
        
        @Data(size=3)
        IInt tipoTitular() ;
        @Data
        @Condition("001")
        ICondition primeiroTit() ;
        
        
        @Data(size=1)
        IString sinalReforcoReducao() ;
        @Data
        @Condition("R")
        ICondition swReforco() ;
        @Data
        @Condition("D")
        ICondition swReducao() ;
        
        
        @Data(size=1)
        IString tipoOrigMovim() ;
        @Data
        @Condition("O")
        ICondition swOrigemOnline() ;
        @Data
        @Condition("B")
        ICondition swOrigemBatch() ;
        
        
        @Data(size=1)
        IString tipoCliente() ;
        @Data
        @Condition("E")
        ICondition swClienteEmpresa() ;
        @Data
        @Condition("P")
        ICondition swClienteParticular() ;
        @Data
        @Condition("I")
        ICondition swClienteEni() ;
        
        
        @Data(size=2)
        IString cdTipoTrttEnc() ;
        @Data
        @Condition("01")
        ICondition swComissaoVlrFixo() ;
        @Data
        @Condition("02")
        ICondition swJurosMora() ;
        @Data
        @Condition("03")
        ICondition swComsMntIncid() ;
        @Data
        @Condition("04")
        ICondition swComsMCttdOpcr() ;
        @Data
        @Condition("05")
        ICondition swDespesas() ;
        @Data
        @Condition("06")
        ICondition swEncImputOpcr() ;
        @Data
        @Condition("07")
        ICondition swTermoGarBanc() ;
        @Data
        @Condition("08")
        ICondition swMovimentoDirecto() ;
        @Data
        @Condition("09")
        ICondition swMovimentoImposto() ;
        @Data
        @Condition(range={"01", "09"})
        ICondition swTpTrttEncValid() ;
        
        
        @Data(size=2)
        IString tipoProdutoGarantia() ;
        @Data
        @Condition("01")
        ICondition swTpHipoteca() ;
        @Data
        @Condition("02")
        ICondition swTpRealPenhor() ;
        @Data
        @Condition("03")
        ICondition swTpConsigRend() ;
        @Data
        @Condition("04")
        ICondition swTpPenhorEst() ;
        @Data
        @Condition("05")
        ICondition swTpPenhorOutros() ;
        @Data
        @Condition("06")
        ICondition swTpPessoalAval() ;
        @Data
        @Condition("07")
        ICondition swTpPessAvalOutr() ;
        @Data
        @Condition("08")
        ICondition swTpPessoalFianca() ;
        @Data
        @Condition("09")
        ICondition swTpLivSemAval() ;
        @Data
        @Condition("10")
        ICondition swTpConfortLetter() ;
        @Data
        @Condition("11")
        ICondition swTpProcIrrevogvl() ;
        @Data
        @Condition("12")
        ICondition swTpPromssHipot() ;
        @Data
        @Condition("13")
        ICondition swTpOutrCompromis() ;
        @Data
        @Condition("14")
        ICondition swTpTercHipoteca() ;
        @Data
        @Condition("15")
        ICondition swTpOutrCessCred() ;
        @Data
        @Condition("16")
        ICondition swTpOutrConsgRec() ;
        
        
        @Data(size=2)
        IString tipoProdutoCredito() ;
        @Data
        @Condition("01")
        ICondition swCredConsumo() ;
        @Data
        @Condition("02")
        ICondition swCredHipoteca() ;
        @Data
        @Condition("03")
        ICondition swCredEmpresas() ;
        
        
        @Data(size=1)
        IString interfaceTJuro() ;
        @Data
        @Condition("F")
        ICondition swTjFixa() ;
        @Data
        @Condition("A")
        ICondition swTjAjusta() ;
        
        
        @Data(size=3)
        IString cTipoRctbIcb() ;
        @Data
        @Condition("2")
        ICondition swAplicacoes() ;
        @Data
        @Condition("4")
        ICondition swProvAReceb() ;
        @Data
        @Condition("11")
        ICondition swCompromRevogaveis() ;
        @Data
        @Condition("12")
        ICondition swJurosVencEptm() ;
        @Data
        @Condition("13")
        ICondition swDespCredVenc() ;
        @Data
        @Condition("15")
        ICondition swGarantiasBanc() ;
        @Data
        @Condition("16")
        ICondition swValAdministrados() ;
        @Data
        @Condition("17")
        ICondition swCredDiversos() ;
        @Data
        @Condition("18")
        ICondition swDevDiversos() ;
        @Data
        @Condition("20")
        ICondition swProvARecBonif() ;
        @Data
        @Condition("26")
        ICondition swBonifARestituir() ;
        @Data
        @Condition("29")
        ICondition swDespConservatoria() ;
        @Data
        @Condition("37")
        ICondition swCpClssAtrasoI() ;
        @Data
        @Condition("38")
        ICondition swCpClssAtrasoIi() ;
        @Data
        @Condition("39")
        ICondition swCpClssAtrasoIii() ;
        @Data
        @Condition("40")
        ICondition swCpClssAtrasoIv() ;
        @Data
        @Condition("41")
        ICondition swCpClssAtrasoV() ;
        @Data
        @Condition("42")
        ICondition swJrClssAtraso0() ;
        @Data
        @Condition("43")
        ICondition swJrClssAtrasoI() ;
        @Data
        @Condition("44")
        ICondition swJrClssAtrasoIi() ;
        @Data
        @Condition("45")
        ICondition swJrClssAtrasoIii() ;
        @Data
        @Condition("46")
        ICondition swJrClssAtrasoIv() ;
        @Data
        @Condition("47")
        ICondition swJrClssAtrasoV() ;
        
        
        @Data(size=3)
        IInt cServicoTeledisco() ;
        @Data
        @Condition("001")
        ICondition swCsRemuneracao() ;
        @Data
        @Condition("120")
        ICondition swCsRprInstrAmort() ;
        @Data
        @Condition("121")
        ICondition swCsCobranAutomat() ;
        @Data
        @Condition("122")
        ICondition swCsInstrAmortz() ;
        @Data
        @Condition("123")
        ICondition swCsDebOutrEntid() ;
        @Data
        @Condition("124")
        ICondition swCsRcbBnfPag() ;
        @Data
        @Condition("520")
        ICondition swCsContratOpv() ;
        @Data
        @Condition("521")
        ICondition swCsRprInstrUtilz() ;
        @Data
        @Condition("522")
        ICondition swCsInstrUtiliz() ;
        @Data
        @Condition("523")
        ICondition swCsCreOutrEntid() ;
        @Data
        @Condition("524")
        ICondition swCsRcbBnfDevPag() ;
        
        
        @Data(size=1)
        IString nsTeledisco() ;
        @Data
        @Condition("1")
        ICondition swCobranca() ;
        @Data
        @Condition("2")
        ICondition swInstrUtiliz() ;
        @Data
        @Condition("3")
        ICondition swInstrAmortz() ;
        @Data
        @Condition("4")
        ICondition swDistrMovOic() ;
        @Data
        @Condition("5")
        ICondition swCobrancaRemun() ;
        @Data
        @Condition("6")
        ICondition swRecebBonif() ;
        @Data
        @Condition("7")
        ICondition swLancamentoOpv() ;
        @Data
        @Condition("8")
        ICondition swReprocesso() ;
        @Data
        @Condition("9")
        ICondition swPlanosRegulz() ;
        
        
        @Data(size=1)
        IString msgSitTeledisco() ;
        @Data
        @Condition("L")
        ICondition swMsgLancado() ;
        @Data
        @Condition("R")
        ICondition swMsgRecusado() ;
        @Data
        @Condition("P")
        ICondition swMsgPerdido() ;
        @Data
        @Condition("Z")
        ICondition swMsgRejZCont() ;
        
        
    }
    public interface AcessoRotinas extends IDataStruct {
        
        /**
         * @return instancia da classe local ModoAcessoMhyj230a
         */
        @Data
        ModoAcessoMhyj230a modoAcessoMhyj230a() ;
        
        /**
         * @return instancia da classe local TpExecucaoMhyj230a
         */
        @Data
        TpExecucaoMhyj230a tpExecucaoMhyj230a() ;
        
        /**
         * @return instancia da classe local TipoOpcaoMnis300a
         */
        @Data
        TipoOpcaoMnis300a tipoOpcaoMnis300a() ;
        
        /**
         * @return instancia da classe local TipoAccaoMnis300a
         */
        @Data
        TipoAccaoMnis300a tipoAccaoMnis300a() ;
        
        /**
         * @return instancia da classe local TipoModoMnis300a
         */
        @Data
        TipoModoMnis300a tipoModoMnis300a() ;
        
        @Data(size=8)
        IString codRotina() ;
        @Data
        @Condition("MNAJ006A")
        ICondition swAnuidade() ;
        @Data
        @Condition("MNAJ010A")
        ICondition swEvAlteracaoPrazo() ;
        @Data
        @Condition("MNAJ011A")
        ICondition swEvMudancaFase() ;
        @Data
        @Condition("MNAJ012A")
        ICondition swEvAlteracaoProd() ;
        @Data
        @Condition("MNAJ013A")
        ICondition swEntdVigPeriod() ;
        @Data
        @Condition("MNAJ016A")
        ICondition swEntdVigMtdCalc() ;
        @Data
        @Condition("MNAJ018A")
        ICondition swEntdVigBonificac() ;
        @Data
        @Condition("MNAJ019A")
        ICondition swEntdVigTaxa() ;
        @Data
        @Condition("MNAJ022A")
        ICondition swCalculoPrestacao() ;
        @Data
        @Condition("MNAJ033A")
        ICondition swEntdVigCapitaliz() ;
        @Data
        @Condition("MNAQ046A")
        ICondition swReclassificacao() ;
        @Data
        @Condition("MNAJ042A")
        ICondition swRenovacaoAutom() ;
        @Data
        @Condition("MNAJ054A")
        ICondition swIstzAmozUtizR() ;
        @Data
        @Condition("MNAJ055A")
        ICondition swRotacaoLider() ;
        @Data
        @Condition("MNAJ061A")
        ICondition swRevisaoTaxa() ;
        @Data
        @Condition("MNAS064A")
        ICondition swCalcImpSelo() ;
        @Data
        @Condition("MNAS073A")
        ICondition swAnulacaoCobranca() ;
        
        
        /**
         * @return instancia da classe local NmRotAbertProp
         */
        @Data
        NmRotAbertProp nmRotAbertProp() ;
        
        /**
         * @return instancia da classe local NmRotInterfIncumpr
         */
        @Data
        NmRotInterfIncumpr nmRotInterfIncumpr() ;
        
        /**
         * @return instancia da classe local IContrValMhjj012a
         */
        @Data
        IContrValMhjj012a iContrValMhjj012a() ;
        
        @Data(size=2)
        IString cIncidMovimento() ;
        @Data
        @Condition("BC")
        ICondition swBonifCapital() ;
        @Data
        @Condition("BJ")
        ICondition swBonifJuros() ;
        
        
        /**
         * @return instancia da classe local CodPrzIcb
         */
        @Data
        CodPrzIcb codPrzIcb() ;
        
        /**
         * @return instancia da classe local AcedeVhg68501
         */
        @Data
        AcedeVhg68501 acedeVhg68501() ;
        
        @Data(size=1)
        IString tipoInformacao() ;
        @Data
        @Condition("A")
        ICondition swActualizAnoCap() ;
        @Data
        @Condition("S")
        ICondition swActualizSemCap() ;
        @Data
        @Condition("C")
        ICondition swContratacoesOper() ;
        @Data
        @Condition("D")
        ICondition swAnulContratOper() ;
        @Data
        @Condition("L")
        ICondition swLiquidOper() ;
        @Data
        @Condition("M")
        ICondition swAnulLiqOper() ;
        @Data
        @Condition("P")
        ICondition swAlteracaoPrazo() ;
        
        
        @Data(size=6)
        IString codProtocolo() ;
        @Data
        @Condition("001002")
        ICondition swDl7789() ;
        @Data
        @Condition("002003")
        ICondition swInh() ;
        @Data
        @Condition("003004")
        ICondition swLocapor() ;
        @Data
        @Condition("004005")
        ICondition swImoleasing() ;
        @Data
        @Condition("005006")
        ICondition swFunPenForArmada() ;
        @Data
        @Condition("006007")
        ICondition swIpe() ;
        
        
        @Data(size=3)
        IInt tipoRegisto() ;
        @Data
        @Condition("003")
        ICondition swSaldo() ;
        @Data
        @Condition("004")
        ICondition swFluxo() ;
        
        
        @Data(size=2)
        IString cDistrito() ;
        @Data
        @Condition(range={"30", "39"})
        ICondition swMadeira() ;
        @Data
        @Condition(range={"40", "49"})
        ICondition swAcores() ;
        
        
        /**
         * @return instancia da classe local RotinasEventos
         */
        @Data
        RotinasEventos rotinasEventos() ;
        
        @Data(size=1)
        IString estadoSeguro() ;
        @Data
        @Condition("S")
        ICondition swSegSubscrito() ;
        @Data
        @Condition("D")
        ICondition swSegDispensado() ;
        @Data
        @Condition("P")
        ICondition swSegPendente() ;
        @Data
        @Condition("C")
        ICondition swSegSubsContr() ;
        @Data
        @Condition("E")
        ICondition swSegEmSubscricao() ;
        
        
        /**
         * *IS 2005-12-12 FIM
         */
        @Data(size=1)
        IString movPassivelCobIs() ;
        @Data
        @Condition("U")
        ICondition mpisUtilizacao() ;
        @Data
        @Condition("C")
        ICondition mpisCobComissao() ;
        @Data
        @Condition("N")
        ICondition mpisNotoriado() ;
        @Data
        @Condition("E")
        ICondition mpisEscritosContrat() ;
        @Data
        @Condition("A")
        ICondition swSegAceite() ;
        @Data
        @Condition("R")
        ICondition swSegRecusado() ;
        
        
        @Data(size=3)
        IString opcaoMenu() ;
        @Data
        @Condition("001")
        ICondition omContratacao() ;
        @Data
        @Condition("003")
        ICondition omAlterContr() ;
        @Data
        @Condition("013")
        ICondition omRefRedCapital() ;
        @Data
        @Condition("020")
        ICondition omUtilizCapital() ;
        @Data
        @Condition("021")
        ICondition omAmortizExtra() ;
        @Data
        @Condition("022")
        ICondition omLiqAntecipada() ;
        @Data
        @Condition("023")
        ICondition omMovExtraPrest() ;
        @Data
        @Condition("024")
        ICondition omCobrancaManual() ;
        @Data
        @Condition("025")
        ICondition omAnlCobConfirm() ;
        @Data
        @Condition("032")
        ICondition omImputBonific() ;
        @Data
        @Condition("033")
        ICondition omAnlzManualMovim() ;
        @Data
        @Condition("034")
        ICondition omVencManualPrest() ;
        @Data
        @Condition("050")
        ICondition omReprocesso() ;
        @Data
        @Condition("069")
        ICondition omCobrancaDirecc() ;
        @Data
        @Condition("110")
        ICondition omCobrancaAutom() ;
        @Data
        @Condition("127")
        ICondition omUtilizCcAgreg() ;
        @Data
        @Condition("155")
        ICondition omInstUltzAmoz() ;
        @Data
        @Condition("936")
        ICondition omUtilizCcif() ;
        @Data
        @Condition("937")
        ICondition omAmortCcif() ;
        
        
        @Data(size=2)
        IString cBaseIncidBnz() ;
        @Data
        @Condition("BJ")
        ICondition swCIcdcBnzJur() ;
        @Data
        @Condition("BC")
        ICondition swCIcdcBnzCap() ;
        
        
        @Data(size=2)
        IInt tipoContaSintese() ;
        @Data
        @Condition({ "84", "85", "99" })
        ICondition tipoContaCh() ;
        @Data
        @Condition({ "81", "82", "87", "88", "90", "91" })
        ICondition tipoContaAce() ;
        
        
        /**
         * @return instancia da classe local MovimDoCoexist
         */
        @Data
        MovimDoCoexist movimDoCoexist() ;
        
        @Data(size=3)
        IString tipoSeguro() ;
        @Data
        @Condition("CCC")
        ICondition segVidaEspHabit() ;
        @Data
        @Condition("PC ")
        ICondition acidentesPessoais() ;
        @Data
        @Condition("RVE")
        ICondition vidaEmpregados() ;
        @Data
        @Condition("RVD")
        ICondition vidaDeficientes() ;
        @Data
        @Condition("RVB")
        ICondition vidaProteccaoBase() ;
        @Data
        @Condition("RVC")
        ICondition vidaProteccaoMais() ;
        @Data
        @Condition("CIN")
        ICondition incendio() ;
        @Data
        @Condition("CMR")
        ICondition multiRiscosHabit() ;
        
        
        @Data(size=1)
        IString iPlnoManlIcnt() ;
        @Data
        @Condition(" ")
        ICondition swPlnoManlCnt() ;
        @Data
        @Condition("1")
        ICondition swPlnoAmozIcnt() ;
        @Data
        @Condition("2")
        ICondition swPlnoUtizIcnt() ;
        @Data
        @Condition("3")
        ICondition swPlnoManlIcnt() ;
        
        
        @Data(size=5)
        IString cOpeBbnIsEscritos() ;
        @Data
        @Condition("I0121")
        ICondition swIsEscritContin() ;
        @Data
        @Condition("I0122")
        ICondition swIsEscritMadeira() ;
        @Data
        @Condition("I0123")
        ICondition swIsEscritAcores() ;
        
        
        @Data(size=4)
        IString cTaxaJuro() ;
        @Data
        @Condition("0079")
        ICondition cTaxaJuroNeg() ;
        @Data
        @Condition("0061")
        ICondition cTaxaSobretaxaMora() ;
        @Data
        @Condition("1462")
        ICondition cTaxaBaseMoraLegl() ;
        @Data
        @Condition("1463")
        ICondition cTaxaMrBaseGarbnc() ;
        
        
        /**
         * NA21686 - DL58 - FIM
         */
        @Data(size=3)
        IInt duBaseCalculo() ;
        @Data
        @Condition("360")
        ICondition duBaseCalculo360() ;
        @Data
        @Condition("365")
        ICondition duBaseCalculo365() ;
        
        
        @Data(size=1)
        IString iBaseCalculo() ;
        @Data
        @Condition("D")
        ICondition iBaseCalculo360() ;
        @Data
        @Condition("F")
        ICondition iBaseCalculo365() ;
        
        
        @Data(size=3)
        IString iTipoItvtProf() ;
        @Data
        @Condition("001")
        ICondition iItvtProprio() ;
        
        
        @Data(size=6)
        IString cProfCliente() ;
        @Data
        @Condition("412205")
        ICondition cProfBancario() ;
        
        
        @Data(size=1)
        IString iTipoCndzEspl() ;
        @Data
        @Condition("R")
        ICondition iTipoCndzEsplRel() ;
        @Data
        @Condition("F")
        ICondition iTipoCndzEsplFixo() ;
        @Data
        @Condition("T")
        ICondition iTipoCndzEsplTaxa() ;
        
        
        @Data(size=1)
        IString cSitMov() ;
        @Data
        @Condition("A")
        ICondition cSitMovAnul() ;
        @Data
        @Condition("N")
        ICondition cSitMovNAnul() ;
        @Data
        @Condition("T")
        ICondition cSitMovTodos() ;
        
        
        /**
         * @return instancia da classe local NrOpcrSimulacao
         */
        @Data
        NrOpcrSimulacao nrOpcrSimulacao() ;
        
        /**
         * @return instancia da classe local BlqoCalcJmor
         */
        @Data
        BlqoCalcJmor blqoCalcJmor() ;
        
        /**
         * @return instancia da classe local IProdEmpd
         */
        @Data
        IProdEmpd iProdEmpd() ;
        
        /**
         * @return instancia da classe local ITipoPrazo
         */
        @Data
        ITipoPrazo iTipoPrazo() ;
        
        /**
         * @return instancia da classe local DespExtraJud
         */
        @Data
        DespExtraJud despExtraJud() ;
        
        @Data(size=1)
        IInt factorIfadap() ;
        @Data
        @Condition("8")
        ICondition fIfadapAno1() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno2() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno3() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno4() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno5() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno6() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno7() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno8() ;
        @Data
        @Condition("9")
        ICondition fIfadapAno9() ;
        @Data
        @Condition("5")
        ICondition fIfadapAno10() ;
        @Data
        @Condition("5")
        ICondition fIfadapAno11() ;
        @Data
        @Condition("5")
        ICondition fIfadapAno12() ;
        
        
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
        @Condition("071")
        ICondition cgCcif() ;
        
        
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
        @Data
        @Condition("001000")
        ICondition fcForfaitCdi() ;
        @Data
        @Condition("001001")
        ICondition fcForfaitCde() ;
        @Data
        @Condition("001002")
        ICondition fcForfaitCdeNotif() ;
        @Data
        @Condition("001068")
        ICondition fcCcif() ;
        
        
        /**
         * @return instancia da classe local AtrzCcifEspCtrt
         */
        @Data
        AtrzCcifEspCtrt atrzCcifEspCtrt() ;
        
        
        public interface ModoAcessoMhyj230a extends IDataStruct {
            
            @Data(size=2, value="03")
            IString calcUltDiaUtMes() ;
            
            @Data(size=2, value="06")
            IString subtraiDatas() ;
            
            @Data(size=2, value="09")
            IString retornaUltDiaMes() ;
            
            @Data(size=2, value="10")
            IString retornaDiaUt() ;
            
            @Data(size=2, value="21")
            IString adicionaPeriod() ;
            
            @Data(size=2, value="23")
            IString subtraiPeriod() ;
            
            @Data(size=2, value="27")
            IString subtraiDiaUtil() ;
            
            @Data(size=2, value="33")
            IString adicionaDiasAData() ;
            
            @Data(size=2, value="34")
            IString subtraiDiasAData() ;
            
        }
        
        public interface TpExecucaoMhyj230a extends IDataStruct {
            
            @Data(size=1, value="B")
            IString processBase() ;
            
            @Data(size=1, value="R")
            IString processReduzido() ;
            
        }
        
        public interface TipoOpcaoMnis300a extends IDataStruct {
            
            @Data(size=3, value="002")
            IString altDadosBasicos() ;
            
            @Data(size=3, value="005")
            IString consComsPeriod() ;
            
            @Data(size=3, value="007")
            IString gestaoCdGerais() ;
            
            @Data(size=3, value="008")
            IString gestaoCdTaxas() ;
            
            @Data(size=3, value="009")
            IString gestaoPlManual() ;
            
            @Data(size=3, value="010")
            IString compRendAgreg() ;
            
            @Data(size=3, value="011")
            IString manutDadosOic() ;
            
            @Data(size=3, value="014")
            IString manutSindBanc() ;
            
            @Data(size=3, value="015")
            IString gestaoCondContr() ;
            
            @Data(size=3, value="016")
            IString manutCondEncg() ;
            
        }
        
        public interface TipoAccaoMnis300a extends IDataStruct {
            
            @Data(size=1, value="A")
            IString actualizacao() ;
            
        }
        
        public interface TipoModoMnis300a extends IDataStruct {
            
            @Data(size=1, value="V")
            IString valida() ;
            
            @Data(size=1, value="A")
            IString anula() ;
            
            @Data(size=1, value="C")
            IString actAccao() ;
            
            @Data(size=1, value="G")
            IString actGar() ;
            
        }
        
        public interface NmRotAbertProp extends IDataStruct {
            
            @Data(size=8, value="MNAJ025A")
            IString nmMnaj025a() ;
            
            @Data(size=8, value="MNAJ027A")
            IString nmMnaj027a() ;
            
            @Data(size=8, value="MNAJ028A")
            IString nmMnaj028a() ;
            
            @Data(size=8, value="MNAJ029A")
            IString nmMnaj029a() ;
            
            @Data(size=8, value="MNAJ030A")
            IString nmMnaj030a() ;
            
            @Data(size=8, value="MNAJ031A")
            IString nmMnaj031a() ;
            
            @Data(size=8, value="MNAJ032A")
            IString nmMnaj032a() ;
            
            @Data(size=8, value="MNAJ038A")
            IString nmMnaj038a() ;
            
        }
        
        public interface NmRotInterfIncumpr extends IDataStruct {
            
            @Data(size=8, value="MNAS047A")
            IString nmMnas047a() ;
            
            @Data(size=8, value="MNAJ048A")
            IString nmMnaj048a() ;
            
            @Data(size=8, value="MNAJ050A")
            IString nmMnaj050a() ;
            
            @Data(size=8, value="MNAS051A")
            IString nmMnas051a() ;
            
            @Data(size=8, value="MNAJ052A")
            IString nmMnaj052a() ;
            
            @Data(size=8, value="MNAS059A")
            IString nmMnas059a() ;
            
            @Data(size=8, value="MNAS063A")
            IString nmMnas063a() ;
            
            @Data(size=8, value="MNAS068A")
            IString nmMnas068a() ;
            
            @Data(size=8, value="MNAS069A")
            IString nmMnas069a() ;
            
            @Data(size=8, value="MNAS070A")
            IString nmMnas070a() ;
            
            @Data(size=8, value="MNAJ071A")
            IString nmMnaj071a() ;
            
            @Data(size=8, value="MNAJ072A")
            IString nmMnaj072a() ;
            
            @Data(size=8, value="MNAS080A")
            IString nmMnas080a() ;
            
        }
        
        public interface IContrValMhjj012a extends IDataStruct {
            
            @Data(size=1, value="1")
            IString comContrValidade() ;
            
            @Data(size=1, value="0")
            IString semContrValidade() ;
            
        }
        
        public interface CodPrzIcb extends IDataStruct {
            
            @Data(size=3, value="MLP")
            IString medLongPrz() ;
            
            @Data(size=3, value="CP")
            IString curtoPrz() ;
            
        }
        
        public interface AcedeVhg68501 extends IDataStruct {
            
            @Data(size=2, value="MM")
            IString montMinPrest() ;
            
            @Data(size=2, value="NP")
            IString qMaxPrest() ;
            
            @Data(size=2, value="DA")
            IString qDiaAtso() ;
            
        }
        
        public interface RotinasEventos extends IDataStruct {
            
            @Data(size=1)
            IString swMnaj006a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj006a() ;
            
            
            @Data(size=1)
            IString swMnaj007a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj007a() ;
            
            
            @Data(size=1)
            IString swMnaj008a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj008a() ;
            
            
            @Data(size=1)
            IString swMnaj009a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj009a() ;
            
            
            @Data(size=1)
            IString swMnaj010a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj010a() ;
            
            
            @Data(size=1)
            IString swMnaj011a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj011a() ;
            
            
            @Data(size=1)
            IString swMnaj012a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj012a() ;
            
            
            @Data(size=1)
            IString swMnaj013a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj013a() ;
            
            
            @Data(size=1)
            IString swMnaj014a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj014a() ;
            
            
            @Data(size=1)
            IString swMnaj015a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj015a() ;
            
            
            @Data(size=1)
            IString swMnaj016a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj016a() ;
            
            
            @Data(size=1)
            IString swMnaj017a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj017a() ;
            
            
            @Data(size=1)
            IString swMnaj018a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj018a() ;
            
            
            @Data(size=1)
            IString swMnaj019a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj019a() ;
            
            
            @Data(size=1)
            IString swMnaj020a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj020a() ;
            
            
            @Data(size=1)
            IString swMnaj033a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj033a() ;
            
            
            @Data(size=1)
            IString swMnaj042a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj042a() ;
            
            
            @Data(size=1)
            IString swMnaj054a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj054a() ;
            
            
            @Data(size=1)
            IString swMnaj061a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj061a() ;
            
            
            @Data(size=1)
            IString swMnaj062a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj062a() ;
            
            
            @Data(size=1)
            IString swMnaj063a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj063a() ;
            
            
            @Data(size=1)
            IString swMnaj071a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj071a() ;
            
            
            @Data(size=1)
            IString swMnaj073a() ;
            @Data
            @Condition("S")
            ICondition swExeMnaj073a() ;
            
            
        }
        
        public interface MovimDoCoexist extends IDataStruct {
            
            @Data(size=4, value="JSW0")
            IString trxMovimCredito() ;
            
            @Data(size=4, value="JSX0")
            IString trxMovimDebito() ;
            
            @Data(size=4, value="JSX5")
            IString trxMovimDebLim() ;
            
            @Data(size=4, value="JSZ9")
            IString trxValidaDo() ;
            
            @Data(size=1, value="S")
            IString aplicacaoSig() ;
            
            @Data(size=1, value="D")
            IString tipoCambMoed() ;
            
            @Data(size=1, value="D")
            IString atrzPrimeiroMov() ;
            
            @Data(size=1, value="C")
            IString atrzSaldoContab() ;
            
            @Data(size=1, value="E")
            IString atrzSaldoDispon() ;
            
            @Data(size=1, value="P")
            IString atrzSaldoValcob() ;
            
            @Data(size=1, value="R")
            IString atrzMinimoAbert() ;
            
            @Data(size=1, value="Q")
            IString atrzDiasPreAviso() ;
            
        }
        
        public interface NrOpcrSimulacao extends IDataStruct {
            
            /**
             * O pais, banco e o.e. so servem para sequenciar o numero
             * de conta ficticio, que ira ficar com o pais, banco e o.e.
             * operantes, check-digito e tipo de conta abaixo indicados.
             * A diferenciacao em relacao a contas reais e feita pelo
             * tipo de conta 999 (os reais so vao ate 099).
             */
            @Data(size=3, value="SIM")
            IString cPaisSimulacao() ;
            
            @Data(size=4, signed=true, value="9999", compression=COMP3)
            IInt cBancoSimulacao() ;
            
            @Data(size=4, signed=true, value="9999", compression=COMP3)
            IInt cOeSimulacao() ;
            
            @Data(size=1, signed=true, value="9", compression=COMP3)
            IInt vChkdSimulacao() ;
            
            @Data(size=3, signed=true, value="999", compression=COMP3)
            IInt tipoCSimulacao() ;
            
        }
        
        public interface BlqoCalcJmor extends IDataStruct {
            
            /**
             * Para bloqueio temporario de calculo de mora, por rejeicao
             * de cobranca pelo teledisco devido a mudanca de data
             * contabilistica (passagem das 0 horas) - So na tabela TNA11.
             */
            @Data(size=1, value="S")
            IString blqoCalcJmorSim() ;
            
            @Data(size=1, value="N")
            IString blqoCalcJmorNao() ;
            
            @Data(size=1, value="D")
            IString blqoCalcJmorPosS() ;
            
            @Data(size=1, value="A")
            IString blqoCalcJmorPosN() ;
            
        }
        
        public interface IProdEmpd extends IDataStruct {
            
            @Data(size=1, value="S")
            IString iProdEmpdSim() ;
            
            @Data(size=1, value="N")
            IString iProdEmpdNao() ;
            
            /**
             * Este Indicador e utilizado para que os pendentes que sao
             * cobrados na remuneracao nao sejam novamente enviados para
             * cobranca na remuneracao, caso tenha existido uma anulacao
             * de cobranca.
             */
            @Data(size=1, value="X")
            IString iProdEmpdRemun() ;
            
        }
        
        public interface ITipoPrazo extends IDataStruct {
            
            @Data(size=1, value="A")
            IString iTipoPrazoAnual() ;
            
            @Data(size=1, value="M")
            IString iTipoPrazoMensal() ;
            
            @Data(size=1, value="D")
            IString iTipoPrazoDiario() ;
            
        }
        
        public interface DespExtraJud extends IDataStruct {
            
            @Data(size=10, decimal=7, signed=true, value="4", compression=COMP3)
            IDecimal percDespExtraJud() ;
            
        }
        
        public interface AtrzCcifEspCtrt extends IDataStruct {
            
            @Data(size=1, value="A")
            IString atrzValDfltCtrlRc() ;
            
            /**
             * *NA32012 - I
             */
            @Data(size=1, value="B")
            IString atrzDfltCtrlRcMod() ;
            
        }
    }
    
}
