package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghw0503 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.ho.structures.link.Bhol727a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * PRC19 - FIM
 * FGH003 - HISTORICO DE MOVIMENTOS ENTRE 2 E 8 ANOS
 * - INFORMACAO PRINCIPAL
 * FGH103 - HISTORICO DE MOVIMENTOS ENTRE 2 E 8 ANOS
 * - INFORMACAO COMPLEMENTAR
 * FWK201 - FICHEIRO MOVIMENTOS ENTRE DATAS
 * FWK301 - FICHEIRO MOVIMENTOS ENTRE DATAS - TRANS
 * FWK401 - GH00101 - MAPA MGH870
 * FWK401 - GH00107 - MAPA MGH870
 * FWK501 - GH00102 - MAPA MGH871
 * FWK601 - GH00103 - MAPA MGH872
 * FWK701 - GH00104 - MAPA MGH873
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.TRATAR OS PEDIDOS A PARTIR DO FICHEIRO
 * FWK007(INPUT1) CRIADO NO PROGRAMA PGHQ200A
 * 2.CRIA OS FICHEIROS FWK201, FWK301, FWK401,
 * FWK501, FWK601, FWK701
 * ALTERACOES:   1.ALIMENTAR OS NOVOS CAMPOS DO BOOK BGHW8200
 * GIP:GH385
 * ALTERACOES    : FORMATA SEGUNDA REFERENCIA EM FWK201
 * GIP:GH776 ! AUTOR:DACT685 ! DATA:2012-01-09
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq202a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdghps00801Refmcbl
     */
    @Data
    protected abstract Vwsdghps00801Refmcbl hv00801Refmcbl() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    /**
     * @return instancia da classe Input1
     */
    @Handler(name="INPUT1", record="regInput1Pghq202a")
    @Data
    protected abstract Input1 input1() ;
    
    /**
     * @return instancia da classe Fgh003
     */
    @Handler(name="FGH003", record="rgh00301")
    @Data
    protected abstract Fgh003 fgh003() ;
    
    /**
     * @return instancia da classe Fgh103
     */
    @Handler(name="FGH103", record="rgh10301")
    @Data
    protected abstract Fgh103 fgh103() ;
    
    /**
     * @return instancia da classe Fwk20101
     */
    @Handler(name="FWK201", record="regFwk200")
    @Data
    protected abstract Fwk20101 fwk201() ;
    
    /**
     * @return instancia da classe Fwk301
     */
    @Handler(name="FWK301", record="regFwk300")
    @Data
    protected abstract Fwk301 fwk301() ;
    
    /**
     * @return instancia da classe Fwk401
     */
    @Handler(name="FWK401", record="regFwk400")
    @Data
    protected abstract Fwk401 fwk401() ;
    
    /**
     * @return instancia da classe Fwk50101
     */
    @Handler(name="FWK501", record="regFwk500")
    @Data
    protected abstract Fwk50101 fwk501() ;
    
    /**
     * @return instancia da classe Fwk601
     */
    @Handler(name="FWK601", record="regFwk600")
    @Data
    protected abstract Fwk601 fwk601() ;
    
    /**
     * @return instancia da classe Fwk701
     */
    @Handler(name="FWK701", record="regFwk700")
    @Data
    protected abstract Fwk701 fwk701() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0503
     */
    @Data
    protected abstract Bghw0503 bghw0503() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhol727a
     */
    @Data
    protected abstract Bhol727a bhol727a() ;
    
    /**
     * AREA DB2/SQL - COMUNICATION AREA
     * ** TABELAS DB2
     * TABELA DE REFERENCIAS CONTABILISTICAS ASSOCIADAS AO MOVIMENTO
     * ***     AREAS DE TRABALHO COMUM    ***
     * PRC19 - INI
     * @return instancia da classe local WsFgh015
     */
    @Data
    protected abstract WsFgh015 wsFgh015() ;
    
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("8")
    protected ICondition progJaExiste ;
    
    
    @Data(size=1)
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition swContaIgual ;
    @Data
    @Condition("4")
    protected ICondition swContaDiferente ;
    
    
    @Data(size=1)
    protected IString swCrtlMov ;
    @Data
    @Condition("A")
    protected ICondition haMov ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlFgh103 ;
    @Data
    @Condition("1")
    protected ICondition haFgh103 ;
    
    
    @Data(size=1)
    protected IString swCrtlExiste ;
    @Data
    @Condition("6")
    protected ICondition swContaExiste ;
    @Data
    @Condition("4")
    protected ICondition swContaNaoExiste ;
    
    
    @Data(size=1)
    protected IString swCrtlVerContaHst ;
    @Data
    @Condition("5")
    protected ICondition verContaHst ;
    @Data
    @Condition("4")
    protected ICondition naoVerContaHst ;
    
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString wsMghj801a ;
    
    @Data(size=8, value="MGHK800A")
    protected IString wsMghk800a ;
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsChaveInput1
     */
    @Data
    protected abstract WsChaveInput1 wsChaveInput1() ;
    
    /**
     * @return instancia da classe local WsChaveFgh003
     */
    @Data
    protected abstract WsChaveFgh003 wsChaveFgh003() ;
    
    /**
     * @return instancia da classe local WsChaveFgh103
     */
    @Data
    protected abstract WsChaveFgh103 wsChaveFgh103() ;
    
    /**
     * @return instancia da classe local WsInput1
     */
    @Data
    protected abstract WsInput1 wsInput1() ;
    
    /**
     * @return instancia da classe local WsFgh003
     */
    @Data
    protected abstract WsFgh003 wsFgh003() ;
    
    /**
     * @return instancia da classe local WsFgh103
     */
    @Data
    protected abstract WsFgh103 wsFgh103() ;
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(format="+ZZ9")
    protected IFormattedString wsCRtnoEvenSwal ;
    
    @Data(size=2, signed=true, value="0")
    protected IInt wContador ;
    @Data
    @Condition("3")
    protected ICondition terceiraVez ;
    @Data
    @Condition("4")
    protected ICondition sair ;
    
    
    @Data(size=8, value="0")
    protected ILong dataCorrente ;
    
    /**
     * @return instancia da classe local DataCorrenteMask
     */
    @Data
    @Mask
    protected abstract DataCorrenteMask dataCorrenteMask() ;
    
    @Data(size=8, value="0")
    protected ILong dataNum ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovFim ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovInicio ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local WsTsInicio
     */
    @Data
    protected abstract WsTsInicio wsTsInicio() ;
    
    /**
     * @return instancia da classe local WsTsFim
     */
    @Data
    protected abstract WsTsFim wsTsFim() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosInput1 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFgh003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFgh103 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk301 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk401 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk501 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk601 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk701 ;
    
    /**
     * TABELA DE IMPRESSAO DE FGH300
     * @return instancia da classe local TabelaImpressao
     */
    @Data
    protected abstract TabelaImpressao tabelaImpressao() ;
    
    /**
     * @return instancia da classe local TabelaImpressaoMask
     */
    @Data
    @Mask
    protected abstract TabelaImpressaoMask tabelaImpressaoMask() ;
    
    
    
    /**
     * 
     * 
     */
    protected void a32100AcedePedido() {
        log(TraceLevel.Debug, "A32100-ACEDE-PEDIDO");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().selectBghp001541() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32200ActualizaPedido() {
        log(TraceLevel.Debug, "A32200-ACTUALIZA-PEDIDO");
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updateBghp0015121() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
    }
    
    /**
     * 
     * 
     */
    protected void a32310DetDataEliminacao() {
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ202A");
        progOk.setTrue() ;
        bghw0300().wsVariaveisHora().horaInicio().set(getTime()) ;
        dataCorrente.set(getTime("yyyyMMdd"));
        dataNum.set(dataCorrente);
        wTimestamp().wDataTimestamp().wAnoAa().set(dataCorrenteMask().anoCorrente());
        wTimestamp().wDataTimestamp().wMesMm().set(dataCorrenteMask().mesCorrente());
        wTimestamp().wDataTimestamp().wDiaDd().set(dataCorrenteMask().diaCorrente());
        tabelaImpressao().linha02().impData().set(wTimestamp().wDataTimestamp());
        tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
        wTimestamp().wTimerTimestamp().wHh().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().hhInicio());
        wTimestamp().wTimerTimestamp().wMm().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().mmInicio());
        wTimestamp().wTimerTimestamp().wSs().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().ssInicio());
        wTimestamp().wTimerTimestamp().wDd().set(0);
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a11000AbrirFichInput() ;
        }
        if (progOk.isTrue()) {
            a12000AbrirFichOutput() ;
        }
        if (progOk.isTrue()) {
            a13000LerInput1() ;
        }
        if (progOk.isTrue()) {
            while (wsChaveFgh003().wsChvPrincFgh003().isLess(wsChaveInput1().wsChvPrincInput1()) && !fgh003().getStatusOk() && progOk.isTrue()) {
                a14000LerFgh003() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A12000-ABRIR-FGH300");
        fgh300().open(WRITE) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - OPEN - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000EscreverFgh300() {
        log(TraceLevel.Debug, "A12000-ESCREVER-FGH300");
        fgh300().write(fgh300().rgh03001121) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - WRITE - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a11000AbrirFichInput() {
        log(TraceLevel.Debug, "A11000-ABRIR-FICH-INPUT");
        input1().open() ;
        if (!input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - INPUT1 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(input1().getStatus());
        }
        fgh003().open() ;
        if (!fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FGH003 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fgh003().getStatus());
        }
        fgh103().open() ;
        if (!fgh103().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FGH103 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fgh103().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000AbrirFichOutput() {
        log(TraceLevel.Debug, "A12000-ABRIR-FICH-OUTPUT");
        fwk201().open(CREATE ) ;
        if (!fwk201().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK201 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk201().getStatus());
        }
        fwk301().open(CREATE ) ;
        if (!fwk301().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK301 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk301().getStatus());
        }
        fwk401().open(CREATE ) ;
        if (!fwk401().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK401 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk401().getStatus());
        }
        fwk501().open(CREATE ) ;
        if (!fwk501().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK501 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk501().getStatus());
        }
        fwk601().open(CREATE ) ;
        if (!fwk601().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK601 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk601().getStatus());
        }
        fwk701().open(CREATE ) ;
        if (!fwk701().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK701 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk701().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a13000LerInput1() {
        log(TraceLevel.Debug, "A13000-LER-INPUT1");
        input1().read() ;
        if (input1().getStatusOk()) {
            contRegLidosInput1.add(1);
            swCrtlMov.set(" ");
            /**
             * MOVE FGH015-C-PAIS-ISOA-CONT
             */
            wsChaveInput1().wsChvPrincInput1().wsCPaisIsoaContInput1().set(input1().regInput1Pghq202a().input1CPaisIsoaCont());
            wsInput1().wsCPaisIsoaContD315().set(input1().regInput1Pghq202a().input1CPaisIsoaCont());
            /**
             * MOVE FGH015-C-BANC-CONT
             */
            wsChaveInput1().wsChvPrincInput1().wsCBancContInput1().set(input1().regInput1Pghq202a().input1CBancCont());
            wsInput1().wsCBancContD315().set(input1().regInput1Pghq202a().input1CBancCont());
            /**
             * MOVE FGH015-C-OE-EGC-CONT
             */
            wsChaveInput1().wsChvPrincInput1().wsCOeEgcContInput1().set(input1().regInput1Pghq202a().input1COeEgcCont());
            wsInput1().wsCOeEgcContD315().set(input1().regInput1Pghq202a().input1COeEgcCont());
            /**
             * MOVE FGH015-NS-RDCL-CONT
             */
            wsChaveInput1().wsChvPrincInput1().wsNsRdclContInput1().set(input1().regInput1Pghq202a().input1NsRdclCont());
            wsInput1().wsNsRdclContD315().set(input1().regInput1Pghq202a().input1NsRdclCont());
            /**
             * MOVE FGH015-V-CHKD-CONT
             */
            wsChaveInput1().wsChvPrincInput1().wsVChkdContInput1().set(input1().regInput1Pghq202a().input1VChkdCont());
            wsInput1().wsVChkdContD315().set(input1().regInput1Pghq202a().input1VChkdCont());
            /**
             * MOVE FGH015-C-TIPO-CONT
             */
            wsChaveInput1().wsChvPrincInput1().wsCTipoContInput1().set(input1().regInput1Pghq202a().input1CTipoCont());
            wsInput1().wsCTipoContD315().set(input1().regInput1Pghq202a().input1CTipoCont());
            /**
             * MOVE FGH015-C-MOED-ISO-SCTA
             */
            wsChaveInput1().wsChvPrincInput1().wsCMoedIsoSctaInput1().set(input1().regInput1Pghq202a().input1CMoedIsoScta());
            wsInput1().wsCMoedIsoSctaD315().set(input1().regInput1Pghq202a().input1CMoedIsoScta());
            /**
             * MOVE FGH015-NS-DEPOSITO
             */
            wsChaveInput1().wsChvPrincInput1().wsNsDepositoInput1().set(input1().regInput1Pghq202a().input1NsDeposito());
            wsInput1().wsNsDepositoD315().set(input1().regInput1Pghq202a().input1NsDeposito());
            /**
             * MOVE FGH015-Z-INIC-MOV TO WS-DATA-INICIO
             */
            wsTsInicio().wsDataInicio().set(input1().regInput1Pghq202a().input1ZInicMov());
            wsChaveInput1().wsChvSecInput1().wsZInicMovInput1().set(input1().regInput1Pghq202a().input1ZInicMov());
            wsInput1().wsZInicMovD315().set(input1().regInput1Pghq202a().input1ZInicMov());
            /**
             * MOVE FGH015-Z-FIM-MOV TO WS-DATA-FIM
             */
            wsTsFim().wsDataFim().set(input1().regInput1Pghq202a().input1ZFimMov());
            wsChaveInput1().wsChvSecInput1().wsZFimMovInput1().set(input1().regInput1Pghq202a().input1ZFimMov());
            wsInput1().wsZFimMovD315().set(input1().regInput1Pghq202a().input1ZFimMov());
        }
        if (!input1().getStatusOk() && !input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - INPUT1 - READ - ");
            tabelaImpressao().linha11().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000LerFgh003() {
        log(TraceLevel.Debug, "A14000-LER-FGH003");
        fgh003().read() ;
        if (fgh003().getStatusOk()) {
            contRegLidosFgh003.add(1);
            wsChaveFgh003().wsChvPrincFgh003().wsCPaisIsoaContFgh003().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
            wsFgh003().wsCPaisIsoaContD003().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCBancContFgh003().set(fgh003().rgh00301().fgh003CBancCont());
            wsFgh003().wsCBancContD003().set(fgh003().rgh00301().fgh003CBancCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCOeEgcContFgh003().set(fgh003().rgh00301().fgh003COeEgcCont());
            wsFgh003().wsCOeEgcContD003().set(fgh003().rgh00301().fgh003COeEgcCont());
            wsChaveFgh003().wsChvPrincFgh003().wsNsRdclContFgh003().set(fgh003().rgh00301().fgh003NsRdclCont());
            wsFgh003().wsNsRdclContD003().set(fgh003().rgh00301().fgh003NsRdclCont());
            wsChaveFgh003().wsChvPrincFgh003().wsVChkdContFgh003().set(fgh003().rgh00301().fgh003VChkdCont());
            wsFgh003().wsVChkdContD003().set(fgh003().rgh00301().fgh003VChkdCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCTipoContFgh003().set(fgh003().rgh00301().fgh003CTipoCont());
            wsFgh003().wsCTipoContD003().set(fgh003().rgh00301().fgh003CTipoCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCMoedIsoSctaFgh003().set(fgh003().rgh00301().fgh003CMoedIsoScta());
            wsFgh003().wsCMoedIsoSctaD003().set(fgh003().rgh00301().fgh003CMoedIsoScta());
            wsChaveFgh003().wsChvPrincFgh003().wsNsDepositoFgh003().set(fgh003().rgh00301().fgh003NsDeposito());
            wsFgh003().wsNsDepositoD003().set(fgh003().rgh00301().fgh003NsDeposito());
            wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().set(fgh003().rgh00301().fgh003TsMovimento());
            wsFgh003().wsTsMovimentoD003().set(fgh003().rgh00301().fgh003TsMovimento());
            wsChaveFgh003().wsChvSecFgh003().wsNsMovimentoFgh003().set(fgh003().rgh00301().fgh003NsMovimento());
            wsFgh003().wsNsMovimentoD003().set(fgh003().rgh00301().fgh003NsMovimento());
        }
        if (!fgh003().getStatusOk() && !fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FGH003 - READ - ");
            tabelaImpressao().linha11().impStatus().set(fgh003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFgh103() {
        log(TraceLevel.Debug, "A15000-LER-FGH103");
        fgh103().read() ;
        if (fgh103().getStatusOk()) {
            contRegLidosFgh103.add(1);
            wsChaveFgh103().wsChvPrincFgh103().wsCPaisIsoaContFgh103().set(fgh103().rgh10301().fgh103CPaisIsoaCont());
            wsFgh103().wsCPaisIsoaContD103().set(fgh103().rgh10301().fgh103CPaisIsoaCont());
            wsChaveFgh103().wsChvPrincFgh103().wsCBancContFgh103().set(fgh103().rgh10301().fgh103CBancCont());
            wsFgh103().wsCBancContD103().set(fgh103().rgh10301().fgh103CBancCont());
            wsChaveFgh103().wsChvPrincFgh103().wsCOeEgcContFgh103().set(fgh103().rgh10301().fgh103COeEgcCont());
            wsFgh103().wsCOeEgcContD103().set(fgh103().rgh10301().fgh103COeEgcCont());
            wsChaveFgh103().wsChvPrincFgh103().wsNsRdclContFgh103().set(fgh103().rgh10301().fgh103NsRdclCont());
            wsFgh103().wsNsRdclContD103().set(fgh103().rgh10301().fgh103NsRdclCont());
            wsChaveFgh103().wsChvPrincFgh103().wsVChkdContFgh103().set(fgh103().rgh10301().fgh103VChkdCont());
            wsFgh103().wsVChkdContD103().set(fgh103().rgh10301().fgh103VChkdCont());
            wsChaveFgh103().wsChvPrincFgh103().wsCTipoContFgh103().set(fgh103().rgh10301().fgh103CTipoCont());
            wsFgh103().wsCTipoContD103().set(fgh103().rgh10301().fgh103CTipoCont());
            wsChaveFgh103().wsChvPrincFgh103().wsCMoedIsoSctaFgh103().set(fgh103().rgh10301().fgh103CMoedIsoScta());
            wsFgh103().wsCMoedIsoSctaD103().set(fgh103().rgh10301().fgh103CMoedIsoScta());
            wsChaveFgh103().wsChvPrincFgh103().wsNsDepositoFgh103().set(fgh103().rgh10301().fgh103NsDeposito());
            wsFgh103().wsNsDepositoD103().set(fgh103().rgh10301().fgh103NsDeposito());
            wsChaveFgh103().wsChvSecFgh103().wsTsMovimentoFgh103().set(fgh103().rgh10301().fgh103TsMovimento());
            wsFgh103().wsTsMovimentoD103().set(fgh103().rgh10301().fgh103TsMovimento());
            wsChaveFgh103().wsChvSecFgh103().wsNsMovimentoFgh103().set(fgh103().rgh10301().fgh103NsMovimento());
            wsFgh103().wsNsMovimentoD103().set(fgh103().rgh10301().fgh103NsMovimento());
        }
        if (!fgh103().getStatusOk() && !fgh103().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FGH103 - READ - ");
            tabelaImpressao().linha11().impStatus().set(fgh103().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        while (wsChaveFgh003().wsChvPrincFgh003().isLessOrEqual(wsChaveInput1().wsChvPrincInput1()) && !fgh003().getStatusOk() && progOk.isTrue()) {
            a31000TratarMovimentos() ;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                a32000ActPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a13000LerInput1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        /**
         * *----------------------------------------------------------------*
         */
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            tabelaImpressao().linha09().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impRegLidosInput1().set(contRegLidosInput1);
            tabelaImpressao().linha06().impRegLidosFgh003().set(contRegLidosFgh003);
            tabelaImpressao().linha07().impRegLidosFgh103().set(contRegLidosFgh103);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(7); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha08().impFichEsc().set("FWK201");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk201);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impFichEsc().set("FWK301");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk301);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impFichEsc().set("FWK401");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk401);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impFichEsc().set("FWK501");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk501);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impFichEsc().set("FWK601");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk601);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impFichEsc().set("FWK701");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk701);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha09().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha09().impReturnCode().set(returnCode);
            tabelaImpressao().linha10().impMens1().set("PGHQ202A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(12); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        input1().close() ;
        fgh003().close() ;
        fgh103().close() ;
        fwk201().close() ;
        fwk301().close() ;
        fwk401().close() ;
        fwk501().close() ;
        fwk601().close() ;
        fwk701().close() ;
    }
    
    /**
     * 
     * 
     */
    protected void a71000CalculaTempoExecucao() {
        /**
         * *----------------------------------------------------------------*
         */
        bghw0300().wsVariaveisHora().horaFim().set(getTime()) ;
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghp0300() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarMovimentos() {
        log(TraceLevel.Debug, "A31000-TRATAR-MOVIMENTOS");
        if (wsChaveFgh003().wsChvPrincFgh003().isEqual(wsChaveInput1().wsChvPrincInput1()) && 
            wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().isGreaterOrEqual(wsTsInicio()) && 
            wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().isLessOrEqual(wsTsFim())) {
            if (input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00001") || 
                input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00012")) {
                a34000EscreveFwk201() ;
            } else if (wsFgh015().fgh015CPedInfOpps().isEqual("GH00101")) {
                wsCrtlFgh103.set(" ");
                /**
                 * GH2230-FIM
                 */
                a36000EscreveFwk401() ;
            } else if (input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00101") || 
                input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00107")) {
                wsCrtlFgh103.set(" ");
                /**
                 * GH2230-FIM
                 */
                a36000EscreveFwk401() ;
            } else if (input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00002") || 
                input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00102") || 
                input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00103") || 
                input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00104") || 
                input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00011")) {
                wsCrtlFgh103.set(" ");
                while (wsChaveFgh103().isLess(wsChaveFgh003()) && !fgh103().getStatusOk() && progOk.isTrue()) {
                    a33000TratarMovCpl() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a14000LerFgh003() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarMovCpl() {
        log(TraceLevel.Debug, "A33000-TRATAR-MOV-CPL");
        while (wsChaveFgh103().isLess(wsChaveFgh003()) && !fgh103().getStatusOk() && progOk.isTrue()) {
            a15000LerFgh103() ;
        }
        if (wsChaveFgh103().isEqual(wsChaveFgh003())) {
            haFgh103.setTrue() ;
            switch (input1().regInput1Pghq202a().input1CPedInfOpps().get()) {
                case "GH00011":
                    a34000EscreveFwk201() ;
                    break;
                case "GH00002":
                    a35000EscreveFwk301() ;
                    break;
                case "GH00102":
                    a37000EscreveFwk501() ;
                    break;
                case "GH00103":
                    a38000EscreveFwk601() ;
                    break;
                case "GH00104":
                    a39000EscreveFwk701() ;
                    break;
                default :
                    break ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreveFwk201() {
        log(TraceLevel.Debug, "A34000-ESCREVE-FWK201");
        a34100AcedeTgh00008() ;
        fwk201().regFwk200().initialize() ;
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200COeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200VChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200TsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200ZValMov().set(fgh003().rgh00301().fgh003ZValMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200ZMovLocl().set(fgh003().rgh00301().fgh003ZMovLocl());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200IDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200IEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MSldoCbloApos().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MSldoDpnlApos().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().set(fgh003().rgh00301().fgh003XRefMov());
        if (fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().isEmpty() || 
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            if (haFgh103.isTrue()) {
                a32100BuscaDescricao() ;
                fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
            }
        }
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200TJuro().set(fgh003().rgh00301().fgh003TJuro());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200AAplOrig().set(fgh003().rgh00301().fgh003AAplOrig());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200TsActzUlt().set(fgh003().rgh00301().fgh003TsActzUlt());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(fgh003().rgh00301().fgh003CUsidActzUlt());
        /**
         * IF FGH015-C-PED-INF-OPPS = 'GH00011'
         */
        if (input1().regInput1Pghq202a().input1CPedInfOpps().isEqual("GH00011")) {
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(fgh103().rgh10301().fgh103CUserid());
            if (fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().isEmpty()) {
                fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(fgh103().rgh10301().fgh103COperador());
            }
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CTerminal().set(fgh103().rgh10301().fgh103CTerminal());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CTipoCanlAces().set(fgh103().rgh10301().fgh103CTipoCanlAces());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CPaisIsoaOeOpx().set(fgh103().rgh10301().fgh103CPaisIsoaOeOpx());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CMnemEgcOpex().set(fgh103().rgh10301().fgh103CMnemEgcOpex());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200COeEgcOpex().set(fgh103().rgh10301().fgh103COeEgcOpex());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK200-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK200-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK200-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK200-TS-PEDIDO
         * MOVE FGH015-C-ENDC-FTP-DEST    TO FWK200-C-ENDC-FTP-DEST
         */
        fwk201().regFwk200().fwk200Pedido().fwk200CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        fwk201().regFwk200().fwk200Pedido().fwk200ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        fwk201().regFwk200().fwk200Pedido().fwk200ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        fwk201().regFwk200().fwk200Pedido().fwk200TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        fwk201().regFwk200().fwk200Pedido().fwk200CEndcFtpDest().set(input1().regInput1Pghq202a().input1CEndcFtpDest());
        /**
         * PRC19 - FIM
         */
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefAux().set(hv00801Refmcbl().refmcbl().xRcnzMcblPrim());
        fwk201().write(fwk201().regFwk200()) ;
        if (fwk201().getStatusOk()) {
            contRegEscrtFwk201.add(1);
            haMov.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK201 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk201().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000EscreveFwk301() {
        log(TraceLevel.Debug, "A35000-ESCREVE-FWK301");
        fwk301().regFwk300().initialize() ;
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300COeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300VChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300TsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300ZValMov().set(fgh003().rgh00301().fgh003ZValMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300ZMovLocl().set(fgh003().rgh00301().fgh003ZMovLocl());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300IDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300IEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CMoedIsoOriMov().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MSldoCbloApos().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MSldoDpnlApos().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MMovMoeOrigMov().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().set(fgh003().rgh00301().fgh003XRefMov());
        if (fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().isEmpty() || 
            fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            if (haFgh103.isTrue()) {
                a32100BuscaDescricao() ;
                fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
            }
        }
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300TJuro().set(fgh003().rgh00301().fgh003TJuro());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300AAplOrig().set(fgh003().rgh00301().fgh003AAplOrig());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300ZEliminacao().set("0001-01-01");
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300TsActzUlt().set(fgh003().rgh00301().fgh003TsActzUlt());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CUsidActzUlt().set(fgh003().rgh00301().fgh003CUsidActzUlt());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTransaccao().set(fgh103().rgh10301().fgh103CTransaccao());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300AAplicacao().set(fgh103().rgh10301().fgh103AAplicacao());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpczMenu().set(fgh103().rgh10301().fgh103COpczMenu());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpeBbn().set(fgh103().rgh10301().fgh103COpeBbn());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CEvenOpel().set(fgh103().rgh10301().fgh103CEvenOpel());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTerminal().set(fgh103().rgh10301().fgh103CTerminal());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COperador().set(fgh103().rgh10301().fgh103COperador());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpexAtrx().set(fgh103().rgh10301().fgh103COpexAtrx());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CUserid().set(fgh103().rgh10301().fgh103CUserid());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTipoCanlAces().set(fgh103().rgh10301().fgh103CTipoCanlAces());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CPaisIsoaOeOpx().set(fgh103().rgh10301().fgh103CPaisIsoaOeOpx());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CMnemEgcOpex().set(fgh103().rgh10301().fgh103CMnemEgcOpex());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COeEgcOpex().set(fgh103().rgh10301().fgh103COeEgcOpex());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CProdSgop().set(fgh103().rgh10301().fgh103CProdSgop());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CFamiProd().set(fgh103().rgh10301().fgh103CFamiProd());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CProduto().set(fgh103().rgh10301().fgh103CProduto());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CCndzMovzCont().set(fgh103().rgh10301().fgh103CCndzMovzCont());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CGrupCont().set(fgh103().rgh10301().fgh103CGrupCont());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CSectIttlBpor().set(fgh103().rgh10301().fgh103CTipoIttz());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300TCambio().set(fgh103().rgh10301().fgh103TCambio());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MSldoRetd().set(fgh103().rgh10301().fgh103MSldoRetd());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MSldoVcob().set(fgh103().rgh10301().fgh103MSldoVcob());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MCmrgLim().set(fgh103().rgh10301().fgh103MCmrgLim());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MCmrgUtid().set(fgh103().rgh10301().fgh103MCmrgUtid());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdAtrd().set(fgh103().rgh10301().fgh103MDcboNgcdAtrd());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdUtid().set(fgh103().rgh10301().fgh103MDcboNgcdUtid());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NJourBbn().set(fgh103().rgh10301().fgh103NJourBbn());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NsJourBbn().set(fgh103().rgh10301().fgh103NsJourBbn());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NsJourBbnDtlh().set(fgh103().rgh10301().fgh103NsJourBbnDtlh());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK300-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK300-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK300-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK300-TS-PEDIDO
         */
        fwk301().regFwk300().fwk300Pedido().fwk300CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        fwk301().regFwk300().fwk300Pedido().fwk300ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        fwk301().regFwk300().fwk300Pedido().fwk300ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        fwk301().regFwk300().fwk300Pedido().fwk300TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        fwk301().write(fwk301().regFwk300()) ;
        if (fwk301().getStatusOk()) {
            contRegEscrtFwk301.add(1);
            haMov.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK301 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk301().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000EscreveFwk401() {
        log(TraceLevel.Debug, "A36000-ESCREVE-FWK401");
        fwk401().regFwk400().initialize() ;
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400COeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400VChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400TsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400ZMovimento().set(fgh003().rgh00301().fgh003TsMovimento().get(1, 10));
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().set(fgh003().rgh00301().fgh003XRefMov());
        if (fwk401().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().isEmpty() || 
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().isEqual(String.valueOf(LOW_VALUES))) {
            if (haFgh103.isTrue()) {
                a32100BuscaDescricao() ;
                fwk401().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
            }
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set("-");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400IDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400IEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MSldoCblo().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        if (fgh003().rgh00301().fgh003MSldoCbloApos().isLess(0)) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalSld().set("-");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MSldoDpnl().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        if (fgh003().rgh00301().fgh003MSldoDpnlApos().isLess(0)) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalDpnl().set("-");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400ZValor().set(fgh003().rgh00301().fgh003ZValMov());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MMovMoeOrig().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set("-");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoOrg().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        /**
         * *GH2230-INI
         * MOVE FGH103-A-APLICACAO         TO FWK400-A-APL
         */
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400AApl().set(fgh003().rgh00301().fgh003AAplOrig());
        /**
         * *GH2230-FIM
         */
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK400-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK400-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK400-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK400-TS-PEDIDO
         */
        fwk401().regFwk400().fwk400Pedido().fwk400CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        fwk401().regFwk400().fwk400Pedido().fwk400ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        fwk401().regFwk400().fwk400Pedido().fwk400ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        fwk401().regFwk400().fwk400Pedido().fwk400TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        fwk401().write(fwk401().regFwk400()) ;
        if (fwk401().getStatusOk()) {
            contRegEscrtFwk401.add(1);
            haMov.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK401 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk401().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a37000EscreveFwk501() {
        log(TraceLevel.Debug, "A37000-ESCREVE-FWK501");
        fwk501().regFwk500().initialize() ;
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500VChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500TsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500ZMovimento().set(fgh003().rgh00301().fgh003TsMovimento().get(1, 10));
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500DDesc().set(fgh003().rgh00301().fgh003XRefMov());
        if (fgh003().rgh00301().fgh003XRefMov().isEmpty() || 
            fgh003().rgh00301().fgh003XRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            if (haFgh103.isTrue()) {
                a32100BuscaDescricao() ;
                fwk501().regFwk500().fwk500FicheiroFgh871().fwk500DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
            }
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set("-");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500IDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500IEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MSldoCblo().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        if (fgh003().rgh00301().fgh003MSldoCbloApos().isLess(0)) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalSld().set("-");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MSldoDpnl().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        if (fgh003().rgh00301().fgh003MSldoDpnlApos().isLess(0)) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalDpnl().set("-");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500ZValor().set(fgh003().rgh00301().fgh003ZValMov());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoOrg().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MMovMoeOrig().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set("-");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500AApl().set(fgh103().rgh10301().fgh103AAplicacao());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCanlAces().set(fgh103().rgh10301().fgh103CTipoCanlAces());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTerminal().set(fgh103().rgh10301().fgh103CTerminal());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcOpex().set(fgh103().rgh10301().fgh103COeEgcOpex());
        if (fgh103().rgh10301().fgh103COperador().isEqual(0)) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COperador().set(fgh103().rgh10301().fgh103CUserid());
        } else {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COperador().set(fgh103().rgh10301().fgh103COperador());
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK500-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK500-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK500-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK500-TS-PEDIDO
         */
        fwk501().regFwk500().fwk500Pedido().fwk500CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        fwk501().regFwk500().fwk500Pedido().fwk500ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        fwk501().regFwk500().fwk500Pedido().fwk500ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        fwk501().regFwk500().fwk500Pedido().fwk500TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        fwk501().write(fwk501().regFwk500()) ;
        if (fwk501().getStatusOk()) {
            contRegEscrtFwk501.add(1);
            haMov.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK501 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk501().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a38000EscreveFwk601() {
        log(TraceLevel.Debug, "A38000-ESCREVE-FWK601");
        fwk601().regFwk600().initialize() ;
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600COeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600VChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600TsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600ZMovimento().set(fgh003().rgh00301().fgh003TsMovimento().get(1, 10));
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().set(fgh003().rgh00301().fgh003XRefMov());
        if (fwk601().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().isEmpty() || 
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().isEqual(String.valueOf(LOW_VALUES))) {
            if (haFgh103.isTrue()) {
                a32100BuscaDescricao() ;
                fwk601().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
            }
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600IDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600IEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoCblo().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        if (fgh003().rgh00301().fgh003MSldoCbloApos().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSld().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoDpnl().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        if (fgh003().rgh00301().fgh003MSldoDpnlApos().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDpnl().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600ZValor().set(fgh003().rgh00301().fgh003ZValMov());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoOrg().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MMovMoeOrig().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoRetd().set(fgh103().rgh10301().fgh103MSldoRetd());
        if (fgh103().rgh10301().fgh103MSldoRetd().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoRetd().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoVcob().set(fgh103().rgh10301().fgh103MSldoVcob());
        if (fgh103().rgh10301().fgh103MSldoVcob().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoVcob().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MCmrgLim().set(fgh103().rgh10301().fgh103MCmrgLim());
        if (fgh103().rgh10301().fgh103MCmrgLim().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgLim().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MCmrgUtid().set(fgh103().rgh10301().fgh103MCmrgUtid());
        if (fgh103().rgh10301().fgh103MCmrgUtid().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgUtid().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MDcboNgcdAtrd().set(fgh103().rgh10301().fgh103MDcboNgcdAtrd());
        if (fgh103().rgh10301().fgh103MDcboNgcdAtrd().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdAtrd().set("-");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MDcboNgcdUtid().set(fgh103().rgh10301().fgh103MDcboNgcdUtid());
        if (fgh103().rgh10301().fgh103MDcboNgcdUtid().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdUtid().set("-");
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK600-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK600-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK600-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK600-TS-PEDIDO
         */
        fwk601().regFwk600().fwk600Pedido().fwk600CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        fwk601().regFwk600().fwk600Pedido().fwk600ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        fwk601().regFwk600().fwk600Pedido().fwk600ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        fwk601().regFwk600().fwk600Pedido().fwk600TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        fwk601().write(fwk601().regFwk600()) ;
        if (fwk601().getStatusOk()) {
            contRegEscrtFwk601.add(1);
            haMov.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK601 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk601().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a39000EscreveFwk701() {
        log(TraceLevel.Debug, "A39000-ESCREVE-FWK701");
        fwk701().regFwk700().initialize() ;
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700COeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700VChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700TsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700ZMovimento().set(fgh003().rgh00301().fgh003TsMovimento().get(1, 10));
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700DDesc().set(fgh003().rgh00301().fgh003XRefMov());
        if (fgh003().rgh00301().fgh003XRefMov().isEmpty() || 
            fgh003().rgh00301().fgh003XRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            if (haFgh103.isTrue()) {
                a32100BuscaDescricao() ;
                fwk701().regFwk700().fwk700FicheiroFgh873().fwk700DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
            }
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set("-");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700IDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700IEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MSldoCblo().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        if (fgh003().rgh00301().fgh003MSldoCbloApos().isLess(0)) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalSld().set("-");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MSldoDpnl().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        if (fgh003().rgh00301().fgh003MSldoDpnlApos().isLess(0)) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalDpnl().set("-");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700ZValor().set(fgh003().rgh00301().fgh003ZValMov());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MMovMoeOrig().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        if ((fgh003().rgh00301().fgh003IDbcr().isEqual("D") && 
            fgh003().rgh00301().fgh003IEstorno().isEmpty()) || 
            (fgh003().rgh00301().fgh003IDbcr().isEqual("C") && 
            fgh003().rgh00301().fgh003IEstorno().isEqual("E"))) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set("-");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoOrg().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CProduto().set(fgh103().rgh10301().fgh103CProduto());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CSectGrupo().set(fgh103().rgh10301().fgh103CGrupCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CCndzCont().set(fgh103().rgh10301().fgh103CCndzMovzCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK700-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK700-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK700-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK700-TS-PEDIDO
         */
        fwk701().regFwk700().fwk700Pedido().fwk700CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        fwk701().regFwk700().fwk700Pedido().fwk700ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        fwk701().regFwk700().fwk700Pedido().fwk700ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        fwk701().regFwk700().fwk700Pedido().fwk700TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        fwk701().write(fwk701().regFwk700()) ;
        if (fwk701().getStatusOk()) {
            contRegEscrtFwk701.add(1);
            haMov.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - FWK701 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk701().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34100AcedeTgh00008() {
        log(TraceLevel.Debug, "A34100-ACEDE-TGH00008");
        hv00801Refmcbl().refmcbl().initialize() ;
        hv00801Refmcbl().refmcbl().cPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        hv00801Refmcbl().refmcbl().cBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        hv00801Refmcbl().refmcbl().cOeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        hv00801Refmcbl().refmcbl().nsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        hv00801Refmcbl().refmcbl().vChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        hv00801Refmcbl().refmcbl().cTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        hv00801Refmcbl().refmcbl().cMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        hv00801Refmcbl().refmcbl().nsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        hv00801Refmcbl().refmcbl().tsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        hv00801Refmcbl().refmcbl().nsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00801_REFMCBL
         */
        hv00801Refmcbl().selectPghq202a1800() ;
        if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv00801Refmcbl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ202A - SELECT  - VGH00801 - ");
            tabelaImpressao().linha11().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100BuscaDescricao() {
        log(TraceLevel.Debug, "A32100-BUSCA-DESCRICAO");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        hrMghk800a().bghl800a().input().zValMov().set(fgh003().rgh00301().fgh003ZValMov());
        hrMghk800a().bghl800a().input().iDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(fgh103().rgh10301().fgh103CPaisIsoaOeOpx());
        hrMghk800a().bghl800a().input().cMnemEgcOpex().set(fgh103().rgh10301().fgh103CMnemEgcOpex());
        hrMghk800a().bghl800a().input().cOeEgcOpex().set(fgh103().rgh10301().fgh103COeEgcOpex());
        hrMghk800a().bghl800a().input().cOpeBbn().set(fgh103().rgh10301().fgh103COpeBbn());
        hrMghk800a().run() ;
        if (!hrMghk800a().bghl800a().ok().isTrue()) {
            log(TraceLevel.Error, "MGH800A-C-RETORNO   -", hrMghk800a().bghl800a().cRetorno());
            log(TraceLevel.Error, "MGH800A-NM-PROGRAMA -", hrMghk800a().bghl800a().nmPrograma());
            log(TraceLevel.Error, "MGH800A-C-SQLCODE   -", hrMghk800a().bghl800a().cSqlcode());
            hrMghk800a().bghl800a().output().xRefMov().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActPedido() {
        wsFgh015().fgh015CPaisIsoaCont().set(input1().regInput1Pghq202a().input1CPaisIsoaCont());
        wsFgh015().fgh015CBancCont().set(input1().regInput1Pghq202a().input1CBancCont());
        wsFgh015().fgh015COeEgcCont().set(input1().regInput1Pghq202a().input1COeEgcCont());
        wsFgh015().fgh015NsRdclCont().set(input1().regInput1Pghq202a().input1NsRdclCont());
        wsFgh015().fgh015VChkdCont().set(input1().regInput1Pghq202a().input1VChkdCont());
        wsFgh015().fgh015CTipoCont().set(input1().regInput1Pghq202a().input1CTipoCont());
        wsFgh015().fgh015CMoedIsoScta().set(input1().regInput1Pghq202a().input1CMoedIsoScta());
        wsFgh015().fgh015NsDeposito().set(input1().regInput1Pghq202a().input1NsDeposito());
        wsFgh015().fgh015CPedInfOpps().set(input1().regInput1Pghq202a().input1CPedInfOpps());
        wsFgh015().fgh015ZInicMov().set(input1().regInput1Pghq202a().input1ZInicMov());
        wsFgh015().fgh015ZFimMov().set(input1().regInput1Pghq202a().input1ZFimMov());
        wsFgh015().fgh015TsPedido().set(input1().regInput1Pghq202a().input1TsPedido());
        wsFgh015().fgh015ZPedido().set(input1().regInput1Pghq202a().input1ZPedido());
        wsFgh015().fgh015CEstPedHist().set(input1().regInput1Pghq202a().input1CEstPedHist());
        wsFgh015().fgh015CTipoRpte().set(input1().regInput1Pghq202a().input1CTipoRpte());
        wsFgh015().fgh015NmFichOutpRtno().set(input1().regInput1Pghq202a().input1NmFichOutpRtno());
        wsFgh015().fgh015AAplDest().set(input1().regInput1Pghq202a().input1AAplDest());
        wsFgh015().fgh015CFrmtInf().set(input1().regInput1Pghq202a().input1CFrmtInf());
        wsFgh015().fgh015CCanlTrmzInf().set(input1().regInput1Pghq202a().input1CCanlTrmzInf());
        wsFgh015().fgh015CEndcFtpDest().set(input1().regInput1Pghq202a().input1CEndcFtpDest());
        wsFgh015().fgh015ZCluzPed().set(input1().regInput1Pghq202a().input1ZCluzPed());
        wsFgh015().fgh015QDiaDpnzInf().set(input1().regInput1Pghq202a().input1QDiaDpnzInf());
        wsFgh015().fgh015MParmPedHstMax().set(input1().regInput1Pghq202a().input1MParmPedHstMax());
        wsFgh015().fgh015MParmPedHstMin().set(input1().regInput1Pghq202a().input1MParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMax().set(input1().regInput1Pghq202a().input1CParmPedHstMax());
        wsFgh015().fgh015CParmPedHstMin().set(input1().regInput1Pghq202a().input1CParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMin().set(input1().regInput1Pghq202a().input1CParmPedHstMin());
        wsFgh015().fgh015XMtvoDvlzPed().set(input1().regInput1Pghq202a().input1XMtvoDvlzPed());
        wsFgh015().fgh015ZEliminacao().set(input1().regInput1Pghq202a().input1ZEliminacao());
        wsFgh015().fgh015CUsidCrix().set(input1().regInput1Pghq202a().input1CUsidCrix());
        wsFgh015().fgh015CPaisIsoaOeOpx().set(input1().regInput1Pghq202a().input1CPaisIsoaOeOpx());
        wsFgh015().fgh015CMnemEgcOpex().set(input1().regInput1Pghq202a().input1CMnemEgcOpex());
        wsFgh015().fgh015COeEgcOpex().set(input1().regInput1Pghq202a().input1COeEgcOpex());
        wsFgh015().fgh015QDdbtPed().set(input1().regInput1Pghq202a().input1QDdbtPed());
        wsFgh015().fgh015TsActzUlt().set(input1().regInput1Pghq202a().input1TsActzUlt());
        wsFgh015().fgh015CUsidActzUlt().set(input1().regInput1Pghq202a().input1CUsidActzUlt());
        log(TraceLevel.Debug, "A32000-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(wsFgh015().fgh015CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(wsFgh015().fgh015CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(wsFgh015().fgh015COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(wsFgh015().fgh015NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(wsFgh015().fgh015VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(wsFgh015().fgh015CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(wsFgh015().fgh015CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(wsFgh015().fgh015NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(wsFgh015().fgh015CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsFgh015().fgh015ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsFgh015().fgh015ZFimMov());
        a32100AcedePedido() ;
        if (progOk.isTrue()) {
            a32200ActualizaPedido() ;
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        /**
         * *-----------------------------------------------------------------
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!input1().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DB2/SQL - COMUNICATION AREA
     * ** TABELAS DB2
     * TABELA DE REFERENCIAS CONTABILISTICAS ASSOCIADAS AO MOVIMENTO
     * ***     AREAS DE TRABALHO COMUM    ***
     * PRC19 - INI
     * 
     * @version 2.0
     * 
     */
    public interface WsFgh015 extends IDataStruct {
        
        @Data(size=3)
        IString fgh015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh015CTipoCont() ;
        
        @Data(size=3)
        IString fgh015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015NsDeposito() ;
        
        @Data(size=7)
        IString fgh015CPedInfOpps() ;
        
        @Data(size=10)
        IString fgh015ZInicMov() ;
        
        @Data(size=10)
        IString fgh015ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh015TsPedido() ;
        
        @Data(size=10)
        IString fgh015ZPedido() ;
        
        @Data(size=1)
        IString fgh015CEstPedHist() ;
        
        @Data(size=1)
        IString fgh015CTipoRpte() ;
        
        @Data(size=20)
        IString fgh015NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fgh015AAplDest() ;
        
        @Data(size=1)
        IString fgh015CFrmtInf() ;
        
        @Data(size=2)
        IString fgh015CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fgh015CEndcFtpDest() ;
        
        @Data(size=10)
        IString fgh015ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh015QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh015MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh015MParmPedHstMin() ;
        
        @Data(size=15)
        IString fgh015CParmPedHstMax() ;
        
        @Data(size=15)
        IString fgh015CParmPedHstMin() ;
        
        @Data(size=40)
        IString fgh015XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fgh015ZEliminacao() ;
        
        @Data(size=8)
        IString fgh015CUsidCrix() ;
        
        @Data(size=3)
        IString fgh015CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh015CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh015QDdbtPed() ;
        
        @Data(size=26)
        IString fgh015TsActzUlt() ;
        
        @Data(size=8)
        IString fgh015CUsidActzUlt() ;
        
    }
    public interface WsChaveAnt extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvPrincAnt
         */
        @Data
        WsChvPrincAnt wsChvPrincAnt() ;
        
        /**
         * @return instancia da classe local WsChvSecAnt
         */
        @Data
        WsChvSecAnt wsChvSecAnt() ;
        
        
        public interface WsChvPrincAnt extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContAnt() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContAnt() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContAnt() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContAnt() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContAnt() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContAnt() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaAnt() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsNsDepositoAnt() ;
            
        }
        
        public interface WsChvSecAnt extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsZInicMovAnt() ;
            
            @Data(size=10, value=" ")
            IString wsZFimMovAnt() ;
            
        }
    }
    public interface WsChaveInput1 extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvPrincInput1
         */
        @Data
        WsChvPrincInput1 wsChvPrincInput1() ;
        
        /**
         * @return instancia da classe local WsChvSecInput1
         */
        @Data
        WsChvSecInput1 wsChvSecInput1() ;
        
        
        public interface WsChvPrincInput1 extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContInput1() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContInput1() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContInput1() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContInput1() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContInput1() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContInput1() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaInput1() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsNsDepositoInput1() ;
            
        }
        
        public interface WsChvSecInput1 extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsZInicMovInput1() ;
            
            @Data(size=10, value=" ")
            IString wsZFimMovInput1() ;
            
        }
    }
    public interface WsChaveFgh003 extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvPrincFgh003
         */
        @Data
        WsChvPrincFgh003 wsChvPrincFgh003() ;
        
        /**
         * @return instancia da classe local WsChvSecFgh003
         */
        @Data
        WsChvSecFgh003 wsChvSecFgh003() ;
        
        
        public interface WsChvPrincFgh003 extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContFgh003() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContFgh003() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContFgh003() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContFgh003() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContFgh003() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContFgh003() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaFgh003() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsNsDepositoFgh003() ;
            
        }
        
        public interface WsChvSecFgh003 extends IDataStruct {
            
            @Data(size=26, value=" ")
            IString wsTsMovimentoFgh003() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimentoFgh003() ;
            
        }
    }
    public interface WsChaveFgh103 extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvPrincFgh103
         */
        @Data
        WsChvPrincFgh103 wsChvPrincFgh103() ;
        
        /**
         * @return instancia da classe local WsChvSecFgh103
         */
        @Data
        WsChvSecFgh103 wsChvSecFgh103() ;
        
        
        public interface WsChvPrincFgh103 extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContFgh103() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContFgh103() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContFgh103() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContFgh103() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContFgh103() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContFgh103() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaFgh103() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsNsDepositoFgh103() ;
            
        }
        
        public interface WsChvSecFgh103 extends IDataStruct {
            
            @Data(size=26, value=" ")
            IString wsTsMovimentoFgh103() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimentoFgh103() ;
            
        }
    }
    public interface WsInput1 extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaContD315() ;
        
        @Data(size=4, value="0")
        IInt wsCBancContD315() ;
        
        @Data(size=4, value="0")
        IInt wsCOeEgcContD315() ;
        
        @Data(size=7, value="0")
        IInt wsNsRdclContD315() ;
        
        @Data(size=1, value="0")
        IInt wsVChkdContD315() ;
        
        @Data(size=3, value="0")
        IInt wsCTipoContD315() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoSctaD315() ;
        
        @Data(size=4, value="0")
        IInt wsNsDepositoD315() ;
        
        @Data(size=10, value=" ")
        IString wsZInicMovD315() ;
        
        @Data(size=10, value=" ")
        IString wsZFimMovD315() ;
        
    }
    public interface WsFgh003 extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaContD003() ;
        
        @Data(size=4, value="0")
        IInt wsCBancContD003() ;
        
        @Data(size=4, value="0")
        IInt wsCOeEgcContD003() ;
        
        @Data(size=7, value="0")
        IInt wsNsRdclContD003() ;
        
        @Data(size=1, value="0")
        IInt wsVChkdContD003() ;
        
        @Data(size=3, value="0")
        IInt wsCTipoContD003() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoSctaD003() ;
        
        @Data(size=4, value="0")
        IInt wsNsDepositoD003() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoD003() ;
        
        @Data(size=15, value="0")
        ILong wsNsMovimentoD003() ;
        
    }
    public interface WsFgh103 extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaContD103() ;
        
        @Data(size=4, value="0")
        IInt wsCBancContD103() ;
        
        @Data(size=4, value="0")
        IInt wsCOeEgcContD103() ;
        
        @Data(size=7, value="0")
        IInt wsNsRdclContD103() ;
        
        @Data(size=1, value="0")
        IInt wsVChkdContD103() ;
        
        @Data(size=3, value="0")
        IInt wsCTipoContD103() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoSctaD103() ;
        
        @Data(size=4, value="0")
        IInt wsNsDepositoD103() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoD103() ;
        
        @Data(size=15, value="0")
        ILong wsNsMovimentoD103() ;
        
    }
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
    }
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHh() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSs() ;
            
            @Data(size=6, lpadding=1, lpaddingValue=".")
            IInt wDd() ;
            
        }
    }
    public interface WsTsInicio extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataInicio
         */
        @Data
        WsDataInicio wsDataInicio() ;
        
        /**
         * @return instancia da classe local WTimerInicio
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerInicio wTimerInicio() ;
        
        
        public interface WsDataInicio extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAaIni() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMmIni() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDdIni() ;
            
        }
        
        public interface WTimerInicio extends IDataStruct {
            
            @Data(size=2, value="0")
            IInt wHhIni() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wMmIni() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wSsIni() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wDdIni() ;
            
        }
    }
    public interface WsTsFim extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataFim
         */
        @Data
        WsDataFim wsDataFim() ;
        
        /**
         * @return instancia da classe local WTimerFim
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerFim wTimerFim() ;
        
        
        public interface WsDataFim extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAaFim() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMmFim() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDdFim() ;
            
        }
        
        public interface WTimerFim extends IDataStruct {
            
            @Data(size=2, value="23")
            IInt wHhFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wMmFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wSsFim() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wDdFim() ;
            
        }
    }
    
    /**
     * 
     * TABELA DE IMPRESSAO DE FGH300
     * 
     * @version 2.0
     * 
     */
    public interface TabelaImpressao extends IDataStruct {
        
        @Data(size=121, value=" ")
        IString linha01() ;
        
        /**
         * @return instancia da classe local Linha02
         */
        @Data
        Linha02 linha02() ;
        
        /**
         * @return instancia da classe local Linha03
         */
        @Data
        Linha03 linha03() ;
        
        /**
         * @return instancia da classe local Linha04
         */
        @Data
        Linha04 linha04() ;
        
        /**
         * @return instancia da classe local Linha05
         */
        @Data
        Linha05 linha05() ;
        
        /**
         * @return instancia da classe local Linha06
         */
        @Data
        Linha06 linha06() ;
        
        /**
         * @return instancia da classe local Linha07
         */
        @Data
        Linha07 linha07() ;
        
        /**
         * @return instancia da classe local Linha08
         */
        @Data
        Linha08 linha08() ;
        
        /**
         * @return instancia da classe local Linha09
         */
        @Data
        Linha09 linha09() ;
        
        /**
         * @return instancia da classe local Linha10
         */
        @Data
        Linha10 linha10() ;
        
        /**
         * @return instancia da classe local Linha11
         */
        @Data
        Linha11 linha11() ;
        
        /**
         * @return instancia da classe local Linha12
         */
        @Data
        Linha12 linha12() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ202A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="DATA:     ")
            IString filler004() ;
            
            @Data(size=10, rpadding=84, rpaddingValue="")
            IString impData() ;
            
        }
        
        public interface Linha03 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="HORA INICIO: ")
            IString filler002() ;
            
            @Data(size=8, decimal=2, value="0")
            IDecimal impHoraInicio() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="HORA FIM: ")
            IString filler004() ;
            
            @Data(size=8, decimal=2, value="0", rpadding=55, rpaddingValue="")
            IDecimal impHoraFim() ;
            
        }
        
        public interface Linha04 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ202A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM INPUT1")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosInput1() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FGH003")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFgh003() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FGH103")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFgh103() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha11 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha12 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
