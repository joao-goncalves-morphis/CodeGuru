package cgd.hy.structures.work;

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
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhyw0001 extends IDataStruct {
    
    /**
     * @return instancia da classe local Journal
     */
    @Data
    Journal journal() ;
    
    @Data(size=1)
    IInt cImgTabJour() ;
    
    /**
     * @return instancia da classe local Header2
     */
    @Data
    Header2 header2() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHYW0001 - LAYOUT JOURNAL  - INFORMACAO A INSERIR NO JOURNAL
     * NOTA: COMPRIMENTO MAXIMO POSSIVEL 4048 BYTES (PAGIMA DB2)
     * COMPRIMENTO TOTAL ACTUAL : 4042 BYTES
     * DADOS DO HEADER DA MENSAGEM - VEM DO LOCAL
     * BHYW0001-Z-PROCESSAMENTO-KEY : DATA DE PROCESSAMENTO
     * BHYW0001-C-MNEM-EGC-OPEX-KEY : EMPRESA OPERANTE
     * BHYW0001-C-PAIS-ISOA-OPX-KEY : PAIS OPERANTE
     * BHYW0001-C-OE-EGC-OPEX-KEY   : ORGAO DE ESTRUTURA OPERANTE
     * BHYW0001-C-USERID-KEY        : CODIGO UTILIZADOR
     * BHYW0001-N-JOUR-BBN-KEY      : NUMERO DO JOURNAL
     * BHYW0001-NS-JOUR-BBN-KEY     : NUMERO DE SEQUENCIA DO JOURNAL
     * BHYW0001-H-PROCESSAMENTO     : HORA DE PROCESSAMENTO
     * BHYW0001-C-TRANSACCAO        : CODIGO TRANSACCAO
     * BHYW0001-A-APLICACAO         : APLICACAO ORIGEM FLX FINANCEIRO
     * BHYW0001-C-OPCZ-MENU         : OPCAO MENU ORIGEM FLX FINANCEIRO*
     * BHYW0001-I-ACCAO             : ACCAO
     * BHYW0001-C-TIPO-CANL-ACES    : CANAL
     * BHYW0001-Z-PROCESSAMENTO     : DATA PROCESSAMENTO (NR ELECTRON)*
     * BHYW0001-C-USERID            : CODIGO UTILIZADOR  (NR ELECTRON)*
     * BHYW0001-N-JOUR-BBN          : NUMERO DO JOURNAL  (NR ELECTRON)*
     * BHYW0001-NS-SESSAO           : NUMERO SESSAO (TOTALIZACAO)
     * BHYW0001-I-EXI-ATZ-JOUR-BBN  : INDICADOR EXISTENCIA AUTORIZACAO*
     * BHYW0001-I-PED-DAD           : INDICADOR DE PEDIDO DE DADOS
     * BHYW0001-I-TRNZ-SIMZ         : INDICADOR DE SIMULACAO
     * BHYW0001-Z-PRCT-JOUR-BBN     : DATA DE PROCESSAMENTO
     * BHYW0001-Z-CTLZ-JOUR-BBN     : DATA CONTABILISITICA
     * BHYW0001-C-TERMINAL          : CODIGO TERMINAL
     * BHYW0001-C-USID-VRTL         : CODIGO UTILZIADOR VIRTUAL
     * BHYW0001-C-PAIS-ISO-ALFN     : CODIGO PAIS DO UTILZIADOR
     * BHYW0001-C-MNEM-EGC-UTL      : EMPRESA DO UTILIZADOR
     * BHYW0001-C-IDIO-ISO          : CODIGO IDIOMA DO UTILIZADOR
     * BHYW0001-C-PERF-UTL-BBN      : CODIGO DE PERFIL
     * BHYW0001-I-ACES-CONT-STFF    : INDICADOR DE ACESSO CONTAS STAFF*
     * BHYW0001-C-USID-ALCL         : UTILIZADOR QUE DEU AUTORIZ LOCAL*
     * BHYW0001-CT-NVL-ATZ-BBN-LCL  : NIVEL AUTORIZACAO UTIL AUT LOCAL*
     * BHYW0001-C-USID-ALRL         : UTILIZADOR QUE DEU AUTORIZ CENTR*
     * BHYW0001-CT-NVL-ATZ-BBN-CRL  : NIVEL AUTORIZACAO UTIL AUT CENTR*
     * BHYW0001-N-EMPREGADO         : NUMERO DE EMPREGADO
     * BHYW0001-I-ULT-GERX-CLI      : INDICADOR DE GESTOR DE CLIENTE
     * BHYW0001-I-ULT-GERX-CONT     : INDICADOR DE GESTOR DE CONTA
     * BHYW0001-I-TRNZ-EFCD-ONLN    : INDICADOR ON-LINE OFF-LINE
     * BHYW0001-I-ESTORNO           : INDICADOR DE ESTORNO
     * BHYW0001-C-MNEM-EGC-ESTN     : EMPRESA DO OE DO ESTORNO
     * BHYW0001-C-PAIS-ISOA-OE-ESN  : PAIS DO OE DO ESTORNO
     * BHYW0001-C-OE-EGC-ESTN       : OE DO ESTORNO
     * BHYW0001-C-USID-ESTN         : UTILIZADOR DE ESTORNO
     * BHYW0001-N-JOUR-BBN-TRN-ESN  : NUMERO DE JOURNAL DE ESTORNO
     * BHYW0001-C-MNEM-EGC-ORIG     : EMPRESA ORIGEM
     * BHYW0001-C-PAIS-ISOA-OE-ORI  : PAIS ORIGEM
     * BHYW0001-C-OE-EGC-ORIG       : ORGAO DE ESTRUTURA ORIGEM
     * BHYW0001-C-BANCO             : CODIGO BANCO
     * BHYW0001-TS-LOCAL            : TIMESTAMP LOCAL
     * BHYW0001-TS-CENTRAL          : TIMESTAMP CENTRAL
     * BHYW0001-I-TRNZ-CBLO         : INDICADOR TRN CONTABILISTICA
     * INFORMACAO ADICIONAL PARA A CONTABILIDADE
     * BHYW0001-A-APL-INSZ-JOUR     : APLICACAO QUE INSERIU NO JOURNAL*
     * BHYW0001-C-EVEN-OPEL         : CODIGO ENVENTO
     * BHYW0001-Z-VALOR             : DATA VALOR
     * BHYW0001-X-ID-MOV-CRIV       : CODIGO DE CRIVO
     * DADOS PARA A CONTABILIDADE
     * DADOS DA CONTA:
     * BHYW0001-C-PAIS-CONT         : PAIS DA CONTA
     * BHYW0001-C-BANC-CONT         : BANCO DA CONTA
     * BHYW0001-C-OE-EGC-CONT       : ORGAO DE ESTRUTURA DA CONTA
     * BHYW0001-NS-RDCL-CONT        : RADICAL DA CONTA
     * BHYW0001-V-CHKD-CONT         : CHECK DIGITO DA CONTA
     * BHYW0001-C-TIPO-CONT         : TIPO DA CONTA
     * BHYW0001-NS-DEPOSITO         : NUMERO DO DEPOSITO
     * BHYW0001-C-TIPO-TRTT-CONT    : TIPO DE TRATAMENTO DA CONTA
     * BHYW0001-C-FAMI-PROD         : FAMILIA-PRODUTO DA CONTA
     * BHYW0001-C-PRODUTO           : PRODUTO DA CONTA
     * BHYW0001-C-MOED-ISO-SCTA     : MOEDA DA CONTA
     * BHYW0001-C-MNEM-EGC-TIT      : EMPRESA BALCAO TITULAR DA CONTA
     * BHYW0001-C-PAIS-ISOA-OE-TIT  : PAIS BALCAO TITULAR DA CONTA
     * BHYW0001-C-OE-EGC-TIT        : ORGAO ESTRUTURA TITULAR DA CONTA*
     * BHYW0001-C-SECT-ITTL-BPOR    : NATUREZA JURIDICA
     * BHYW0001-C-ECLO-PRAZ-CBLO    : ESCALAO PRAZO CONTABILISITICO
     * BHYW0001-M-LNCD-CONT-LIQ     : MONTANTE LIQUIDO LANCADO A CONTA*
     * BHYW0001-M-SLDO-CBLO         : MONTANTE DO SALDO CONTABILISTICO*
     * BHYW0001-M-SLDO-DPNL         : MONTANTE DO SALDO DISPONIVEL
     * BHYW0001-C-AE                : CODIGO ACTIVIDADE ECONOMICA
     * BHYW0001-FILLER              : UTILIZACAO FUTURA
     * DADOS DO MOVIMENTO:
     * BHYW0001-C-MOED-ISO-MOV      : CODIGO DA MOEDA DO MOVIMENTO
     * BHYW0001-M-BASE-ICDC-MOV     : MONTANTE BASE DE INCIDENCIA MOV
     * BHYW0001-C-OPE-BBN           : CODIGO DE OPERACAO
     * BHYW0001-M-MOVIMENTO         : VALOR A CONTABILIZAR
     * BHYW0001-I-TIPO-NMRI         : INDICADOR TIPO NUEMRARIO
     * BHYW0001-C-CPLT-MVOP-ICB     : CODIGO CONTABILISITCO AUXILIAR
     * DADOS DA MENSAGEM
     * BHYW0001-MSG-INPUT           : MENSAGEM DE INPUT
     * BHYW0001-Q-CAMP-EST-TRNZ     : QUANTIDADE DE CAMPOS DE STATUS
     * BHYW0001-Q-CTER-CMPT-ALIG    : COMPRIMENTO DA MENSAGEM
     * BHYW0001-MSG-OUTPUT          : MENSAGEM DE OUTPUT
     * CAMPO PARA IDENTIFICACAO QUAL EH A TABELA ACTIVA
     * BHYW0001-C-IMG-TAB-JOUR      : IMAGEM TABELA DE JOURNAL ACTIVA
     * 
     * @version 2.0
     * 
     */
    public interface Journal extends IDataStruct {
        
        /**
         * @return instancia da classe local NEltnJourBbnKey
         */
        @Data
        NEltnJourBbnKey nEltnJourBbnKey() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnKey() ;
        
        @Data(size=8)
        IString hProcessamento() ;
        
        /**
         * @return instancia da classe local HeaderMsg
         */
        @Data
        HeaderMsg headerMsg() ;
        
        @Data(size=2)
        IString aAplInszJour() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=10)
        IString zValor() ;
        
        @Data(size=12, signed=true, compression=COMP3)
        ILong xIdMovCriv() ;
        
        /**
         * @return instancia da classe local DadosConta
         */
        @Data(length=3)
        IArray<DadosConta> dadosConta() ;
        
        @Data(size=1300)
        IString msgInput() ;
        
        @Data(size=3, compression=COMP3)
        IInt qCampEstTrnz() ;
        
        @Data(size=4, signed=true, compression=COMP)
        IInt qCterCmptAlig() ;
        
        @Data(size=1300)
        IString msgOutput() ;
        
        @Data(size=8)
        IString nmPrograma() ;
        
        @Data(size=39)
        IString campoLivre0() ;
        
        @Data(size=2)
        IString aAplCanl() ;
        
        @Data(size=2)
        IString aAplOrig() ;
        
        @Data(size=3)
        IString cOpczMenuOrig() ;
        
        
        public interface NEltnJourBbnKey extends IDataStruct {
            
            @Data(size=10)
            IString zProcessamentoKey() ;
            
            @Data(size=3)
            IString cMnemEgcOpexKey() ;
            
            @Data(size=3)
            IString cPaisIsoaOpxKey() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpexKey() ;
            
            @Data(size=8)
            IString cUseridKey() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbnKey() ;
            
        }
        
        public interface HeaderMsg extends IDataStruct {
            
            @Data(size=4)
            IString cTransaccao() ;
            
            /**
             * @return instancia da classe local Transaccao
             */
            @Data
            Transaccao transaccao() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            /**
             * @return instancia da classe local NrElectronico
             */
            @Data
            NrElectronico nrElectronico() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsSessao() ;
            
            @Data(size=1)
            IString iExiAtzJourBbn() ;
            @Data
            @Condition("0")
            ICondition semAut() ;
            @Data
            @Condition("1")
            ICondition comAut() ;
            @Data
            @Condition("3")
            ICondition comAutLoc() ;
            
            
            @Data(size=1)
            IString iPedDad() ;
            @Data
            @Condition("S")
            ICondition pedidoSim() ;
            @Data
            @Condition("N")
            ICondition pedidoNao() ;
            
            
            @Data(size=1)
            IString iTrnzSimz() ;
            @Data
            @Condition("S")
            ICondition simzSim() ;
            @Data
            @Condition("N")
            ICondition simzNao() ;
            
            
            /**
             * @return instancia da classe local DatasProcesso
             */
            @Data
            DatasProcesso datasProcesso() ;
            
            @Data(size=4)
            IString cTerminal() ;
            
            @Data(size=8)
            IString cUsidVrtl() ;
            
            /**
             * @return instancia da classe local Seguranca
             */
            @Data
            Seguranca seguranca() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnln() ;
            @Data
            @Condition("1")
            ICondition trnOnLine() ;
            @Data
            @Condition("2")
            ICondition trnOffLine() ;
            
            
            @Data(size=1)
            IString iEstorno() ;
            @Data
            @Condition("S")
            ICondition anulDiaSim() ;
            @Data
            @Condition("N")
            ICondition anulDiaNao() ;
            
            
            /**
             * @return instancia da classe local NrAnulacao
             */
            @Data
            NrAnulacao nrAnulacao() ;
            
            @Data(size=3)
            IString cMnemEgcOrig() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOri() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOrig() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=26)
            IString tsLocal() ;
            
            @Data(size=26)
            IString tsCentral() ;
            
            @Data(size=1)
            IString iTrnzCblo() ;
            
            
            public interface Transaccao extends IDataStruct {
                
                @Data(size=2)
                IString aAplicacao() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=1)
                IString iAccao() ;
                @Data
                @Condition("V")
                ICondition vizualizacao() ;
                @Data
                @Condition("C")
                ICondition criacao() ;
                @Data
                @Condition("M")
                ICondition modificacao() ;
                @Data
                @Condition("A")
                ICondition anulacao() ;
                @Data
                @Condition("N")
                ICondition anulNotrunc() ;
                
                
            }
            
            public interface NrElectronico extends IDataStruct {
                
                @Data(size=10)
                IString zProcessamento() ;
                
                @Data(size=3)
                IString cMnemEgcOpex() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpx() ;
                
                @Data(size=4)
                IInt cOeEgcOpex() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=9)
                ILong nJourBbn() ;
                
            }
            
            public interface DatasProcesso extends IDataStruct {
                
                @Data(size=10)
                IString zPrctJourBbn() ;
                
                @Data(size=10)
                IString zCtlzJourBbn() ;
                
            }
            
            public interface Seguranca extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoAlfn() ;
                
                @Data(size=3)
                IString cMnemEgcUtl() ;
                
                @Data(size=3)
                IString cIdioIso() ;
                
                @Data(size=8)
                IString cPerfUtlBbn() ;
                
                @Data(size=1)
                IString iAcesContStff() ;
                @Data
                @Condition("S")
                ICondition iAcesContStffS() ;
                @Data
                @Condition("N")
                ICondition iAcesContStffN() ;
                
                
                @Data(size=8)
                IString cUsidAlcl() ;
                
                @Data(size=1)
                IString ctNvlAtzBbnLcl() ;
                
                @Data(size=8)
                IString cUsidAlrl() ;
                
                @Data(size=1)
                IString ctNvlAtzBbnCrl() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nEmpregado() ;
                
                @Data(size=1)
                IString iUltGerxCli() ;
                
                @Data(size=1)
                IString iUltGerxCont() ;
                
            }
            
            public interface NrAnulacao extends IDataStruct {
                
                @Data(size=3)
                IString cMnemEgcEstn() ;
                
                @Data(size=3)
                IString cPaisIsoaOeEsn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcEstn() ;
                
                @Data(size=8)
                IString cUsidEstn() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong nJourBbnTrnEsn() ;
                
            }
        }
        
        public interface DadosConta extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoCont() ;
            
            @Data(size=3)
            IString cMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito() ;
            
            @Data(size=2)
            IString cTipoTrttCont() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3)
            IString cMnemEgcTit() ;
            
            @Data(size=3)
            IString cPaisIsoaOeTit() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcTit() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cSectIttlBpor() ;
            
            @Data(size=3)
            IString cPrazIcb() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mLncdContLiq() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCblo() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoDpnl() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cAe() ;
            
            @Data(size=4)
            IString filler() ;
            
            /**
             * @return instancia da classe local DadosMovimento
             */
            @Data(length=8)
            IArray<DadosMovimento> dadosMovimento() ;
            
            
            public interface DadosMovimento extends IDataStruct {
                
                @Data(size=3)
                IString cMoedIsoMov() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mBaseIcdcMov() ;
                
                @Data(size=5)
                IString cOpeBbn() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimento() ;
                
                @Data(size=1)
                IString iTipoNmri() ;
                
                @Data(size=10)
                IString cCpltMvopIcb() ;
                
            }
        }
    }
    public interface Header2 extends IDataStruct {
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal campoLivre1() ;
        
        @Data(size=10)
        IString campoLivre2() ;
        
        @Data(size=1)
        IString campoLivre3() ;
        
        @Data(size=3)
        IString campoLivre4() ;
        
        @Data(size=50)
        IString campoLivre5() ;
        
    }
    
}
