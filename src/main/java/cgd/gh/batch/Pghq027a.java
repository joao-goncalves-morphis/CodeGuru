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
import cgd.hg.structures.link.Bhgl030a ;
import cgd.hg.structures.link.Bhgl004a ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * PRC19 - FIM
 * FWK201 - FICHEIRO MOVIMENTOS ENTRE DATAS
 * FWK301 - FICHEIRO MOVIMENTOS ENTRE DATAS - TRANS
 * FWK401 - GH00101 - MAPA MGH870
 * FWK401 - GH00107 - MAPA MGH870
 * FWK501 - GH00102 - MAPA MGH871
 * FWK601 - GH00103 - MAPA MGH872
 * FWK701 - GH00104 - MAPA MGH873
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : SEPARA FWK024 CRIADO NO PGHQ200A POR CODIGO
 * DE PEDIDO. O FWK024 E O FWK003 ORDENADO
 * RECORRENDO AS TABELAS:
 * VGH02701_MOVHIST7
 * VGH12701_MOVHIST7
 * ALTERACOES    : ALIMENTAR OS NOVOS CAMPOS DO BOOK BGHW8200
 * GIP:GH385
 * ALTERACOES    : FORMATA SEGUNDA REFERENCIA EM FWK201
 * GIP:GH776 ! AUTOR:DACT685 ! DATA:2012-01-09
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq027a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdghps12701Movhstcp7
     */
    @Data
    protected abstract Vwsdghps12701Movhstcp7 hv12701Movhstcp7() ;
    
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
     * @return instancia da classe Fwk024
     */
    @Handler(name="FWK024", record="regFwk024Pghq027a")
    @Data
    protected abstract Fwk024 fwk024() ;
    
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
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Mhgj004a
     */
    @Data
    protected abstract Mhgj004a hrMhgj004a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhgl030a
     */
    @Data
    protected abstract Bhgl030a bhgl030a() ;
    
    /**
     * @return instancia da classe Bhgl004a
     */
    @Data
    protected abstract Bhgl004a bhgl004a() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
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
    
    
    @Data(size=2, signed=true, value="0")
    protected IInt wContador ;
    @Data
    @Condition("3")
    protected ICondition terceiraVez ;
    @Data
    @Condition("4")
    protected ICondition sair ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlTgh102 ;
    @Data
    @Condition("1")
    protected ICondition haTgh102 ;
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    @Data(size=6, value="MGH874")
    protected IString wsMapa ;
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHK800A")
    protected IString wsDescritivos ;
    
    @Data(format="+ZZ9")
    protected IFormattedString wsCRtnoEvenSwal ;
    
    @Data(size=26)
    protected IString wsTsInicio ;
    
    @Data(size=26)
    protected IString wsTsFim ;
    
    /**
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
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
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * AREAS DE LIGACAO
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * CONTADORES
     * @return instancia da classe local WsContadores
     */
    @Data
    protected abstract WsContadores wsContadores() ;
    
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
     * TABELA GERAIS - ACESSO A TABELAS GERAIS
     * 
     */
    protected void bhgp0030AcessoTabela() {
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DO ORGAO DE ESTRUTURA
     * MHGJ004A
     * 
     */
    protected void bhgp0004RotDadosOe() {
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ027A");
        wsContadores().initialize() ;
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
        a11000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk024() ;
        }
        if (progOk.isTrue()) {
            a15000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk024() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a11000AbrirFgh300() {
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
    protected void a14000AbrirFwk024() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK024");
        fwk024().open() ;
        if (!fwk024().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK024 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk024().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000AbrirFicheiros() {
        log(TraceLevel.Debug, "A15000-ABRIR-FICHEIROS");
        fwk201().open(CREATE ) ;
        if (!fwk201().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK201 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk201().getStatus());
        }
        fwk301().open(CREATE ) ;
        if (!fwk301().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK301 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk301().getStatus());
        }
        fwk401().open(CREATE ) ;
        if (!fwk401().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK401 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk401().getStatus());
        }
        fwk501().open(CREATE ) ;
        if (!fwk501().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK501 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
        }
        fwk601().open(CREATE ) ;
        if (!fwk601().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK601 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk601().getStatus());
        }
        fwk701().open(CREATE ) ;
        if (!fwk701().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK701 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk701().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk024() {
        log(TraceLevel.Debug, "A16000-LER-FWK024");
        fwk024().read() ;
        if (fwk024().getStatusOk()) {
            wsContadores().wsContadorPedidos().add(1);
        }
        if (!fwk024().getStatusOk() && !fwk024().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK024 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk024().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarPedido() ;
        if (progOk.isTrue()) {
            a32000ActualizaPedido() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk024() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarPedido() {
        log(TraceLevel.Debug, "A31000-TRATAR-PEDIDO");
        a31100OpenC1() ;
        if (progOk.isTrue()) {
            a31200FetchC1() ;
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue()) {
                a31300ExecutaPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a31400CloseC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenC1() {
        log(TraceLevel.Debug, "A31100-OPEN-C1");
        wSqlcode.initialize() ;
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-CONT    TO VGH02701-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT         TO VGH02701-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-CONT       TO VGH02701-C-OE-EGC-CONT
         * MOVE FGH015-NS-RDCL-CONT        TO VGH02701-NS-RDCL-CONT
         * MOVE FGH015-V-CHKD-CONT         TO VGH02701-V-CHKD-CONT
         * MOVE FGH015-C-TIPO-CONT         TO VGH02701-C-TIPO-CONT
         * MOVE FGH015-C-MOED-ISO-SCTA     TO VGH02701-C-MOED-ISO-SCTA
         * MOVE FGH015-NS-DEPOSITO         TO VGH02701-NS-DEPOSITO
         * MOVE FGH015-Z-INIC-MOV          TO WS-DATA-INICIO
         * MOVE W-TS-INICIO                TO WS-TS-INICIO
         * MOVE FGH015-Z-FIM-MOV           TO WS-DATA-FIM
         * MOVE W-TS-FIM                   TO WS-TS-FIM
         */
        hv02701Movhist7().movhist7().cPaisIsoaCont().set(fwk024().regFwk024Pghq027a().fwk024CPaisIsoaCont());
        hv02701Movhist7().movhist7().cBancCont().set(fwk024().regFwk024Pghq027a().fwk024CBancCont());
        hv02701Movhist7().movhist7().cOeEgcCont().set(fwk024().regFwk024Pghq027a().fwk024COeEgcCont());
        hv02701Movhist7().movhist7().nsRdclCont().set(fwk024().regFwk024Pghq027a().fwk024NsRdclCont());
        hv02701Movhist7().movhist7().vChkdCont().set(fwk024().regFwk024Pghq027a().fwk024VChkdCont());
        hv02701Movhist7().movhist7().cTipoCont().set(fwk024().regFwk024Pghq027a().fwk024CTipoCont());
        hv02701Movhist7().movhist7().cMoedIsoScta().set(fwk024().regFwk024Pghq027a().fwk024CMoedIsoScta());
        hv02701Movhist7().movhist7().nsDeposito().set(fwk024().regFwk024Pghq027a().fwk024NsDeposito());
        wTsInicio().wsDataInicio().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        wsTsInicio.set(wTsInicio());
        wTsFim().wsDataFim().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        wsTsFim.set(wTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv02701Movhist7().openPghq027a819(wsTsInicio, wsTsFim) ;
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv02701Movhist7().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200FetchC1() {
        log(TraceLevel.Debug, "A31200-FETCH-C1");
        wSqlcode.initialize() ;
        hv12701Movhstcp7().movhstcp7().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv02701Movhist7().fetchPghq027a846() ;
        if (hv02701Movhist7().getPersistenceCode() == PersistenceCode.NORMAL) {
            progOk.setTrue() ;
            wsCrtlTgh102.set(" ");
        }
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv02701Movhist7().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FETCH C1- VGH02701 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300ExecutaPedido() {
        log(TraceLevel.Debug, "A31300-EXECUTA-PEDIDO");
        if (progOk.isTrue()) {
            /**
             * IF FGH015-C-PED-INF-OPPS NOT = 'GH00001' AND
             */
            if (!fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00001") && 
                !fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00012") && 
                !fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00101") && 
                !fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00107")) {
                a31310AcedeInfComplementar() ;
            }
        }
        if (progOk.isTrue()) {
            a31320SeparaPedido() ;
        }
        if (progOk.isTrue()) {
            a31200FetchC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AcedeInfComplementar() {
        log(TraceLevel.Debug, "S33530-ACEDE-INF-COMPLEMENTAR");
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectPghq027a928(hv02701Movhist7().movhist7()) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NORMAL) {
            haTgh102.setTrue() ;
        } else {
            wSqlcode.set(hv12701Movhstcp7().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - SELECT  - VGH12701 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320SeparaPedido() {
        log(TraceLevel.Debug, "A31320-SEPARA-PEDIDO");
        if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00001") || 
            fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00011") || 
            fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00012")) {
            a31327AcedeTgh00008() ;
            a31321TrataFwk201() ;
        } else if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00002")) {
            a31322TrataFwk301() ;
        } else if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00101") || 
            fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00107")) {
            a31323TrataFwk401() ;
        } else if (wsFgh015().fgh015CPedInfOpps().isEqual("GH00102")) {
            a31324TrataFwk501() ;
        } else if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00102")) {
            a31324TrataFwk501() ;
        } else if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00103")) {
            a31325TrataFwk601() ;
        } else if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00104")) {
            a31326PreencheFwk701() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31321TrataFwk201() {
        log(TraceLevel.Debug, "A31321-TRATAR-FWK201");
        fwk201().regFwk200().initialize() ;
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CBancCont().set(hv02701Movhist7().movhist7().cBancCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200COeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200VChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200TsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200ZValMov().set(hv02701Movhist7().movhist7().zValMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200ZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200IDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200IEstorno().set(hv02701Movhist7().movhist7().iEstorno());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MSldoDpnlApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().set(hv02701Movhist7().movhist7().xRefMov());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200NDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200TJuro().set(hv02701Movhist7().movhist7().tJuro());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200AAplOrig().set(hv02701Movhist7().movhist7().aAplOrig());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200TsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(hv02701Movhist7().movhist7().cUsidActzUlt());
        /**
         * IF FGH015-C-PED-INF-OPPS  =  'GH00011'
         */
        if (fwk024().regFwk024Pghq027a().fwk024CPedInfOpps().isEqual("GH00011")) {
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(hv12701Movhstcp7().movhstcp7().cUserid());
            if (fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().isEmpty()) {
                fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(hv12701Movhstcp7().movhstcp7().cOperador());
            }
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200CMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200COeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK200-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK200-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK200-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK200-TS-PEDIDO
         * MOVE FGH015-C-ENDC-FTP-DEST    TO FWK200-C-ENDC-FTP-DEST
         */
        fwk201().regFwk200().fwk200Pedido().fwk200CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        fwk201().regFwk200().fwk200Pedido().fwk200ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        fwk201().regFwk200().fwk200Pedido().fwk200ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        fwk201().regFwk200().fwk200Pedido().fwk200TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        fwk201().regFwk200().fwk200Pedido().fwk200CEndcFtpDest().set(fwk024().regFwk024Pghq027a().fwk024CEndcFtpDest());
        /**
         * PRC19 - FIM
         */
        if (hv02701Movhist7().movhist7().xRefMov().isEmpty() || 
            hv02701Movhist7().movhist7().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fwk201().regFwk200().fwk200FicheiroFgh500().fwk200XRefAux().set(hv00801Refmcbl().refmcbl().xRcnzMcblPrim());
        fwk201().write(fwk201().regFwk200()) ;
        if (fwk201().getStatusOk()) {
            wsContadores().wsContadorFwk201().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK201 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk201().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31322TrataFwk301() {
        log(TraceLevel.Debug, "A31322-TRATA-FWK301");
        fwk301().regFwk300().initialize() ;
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CBancCont().set(hv02701Movhist7().movhist7().cBancCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300COeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300VChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300TsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300ZValMov().set(hv02701Movhist7().movhist7().zValMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300ZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300IDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300IEstorno().set(hv02701Movhist7().movhist7().iEstorno());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MSldoDpnlApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300MMovMoeOrigMov().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().set(hv02701Movhist7().movhist7().xRefMov());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300NDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300TJuro().set(hv02701Movhist7().movhist7().tJuro());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300AAplOrig().set(hv02701Movhist7().movhist7().aAplOrig());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300TsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300CUsidActzUlt().set(hv02701Movhist7().movhist7().cUsidActzUlt());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTransaccao().set(hv12701Movhstcp7().movhstcp7().cTransaccao());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300AAplicacao().set(hv12701Movhstcp7().movhstcp7().aAplicacao());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpczMenu().set(hv12701Movhstcp7().movhstcp7().cOpczMenu());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpeBbn().set(hv12701Movhstcp7().movhstcp7().cOpeBbn());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CEvenOpel().set(hv12701Movhstcp7().movhstcp7().cEvenOpel());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COperador().set(hv12701Movhstcp7().movhstcp7().cOperador());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpexAtrx().set(hv12701Movhstcp7().movhstcp7().cOpexAtrx());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CProdSgop().set(hv12701Movhstcp7().movhstcp7().cProdSgop());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CFamiProd().set(hv12701Movhstcp7().movhstcp7().cFamiProd());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CProduto().set(hv12701Movhstcp7().movhstcp7().cProduto());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CCndzMovzCont().set(hv12701Movhstcp7().movhstcp7().cCndzMovzCont());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CGrupCont().set(hv12701Movhstcp7().movhstcp7().cGrupCont());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CSectIttlBpor().set(hv12701Movhstcp7().movhstcp7().cTipoIttz());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300TCambio().set(hv12701Movhstcp7().movhstcp7().tCambio());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MSldoRetd().set(hv12701Movhstcp7().movhstcp7().mSldoRetd());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MSldoVcob().set(hv12701Movhstcp7().movhstcp7().mSldoVcob());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MCmrgLim().set(hv12701Movhstcp7().movhstcp7().mCmrgLim());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MCmrgUtid().set(hv12701Movhstcp7().movhstcp7().mCmrgUtid());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdAtrd().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdUtid().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NJourBbn().set(hv12701Movhstcp7().movhstcp7().nJourBbn());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NsJourBbn().set(hv12701Movhstcp7().movhstcp7().nsJourBbn());
        fwk301().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NsJourBbnDtlh().set(hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh());
        fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300ZEliminacao().set("0001-01-01");
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK300-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK300-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK300-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK300-TS-PEDIDO
         */
        fwk301().regFwk300().fwk300Pedido().fwk300CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        fwk301().regFwk300().fwk300Pedido().fwk300ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        fwk301().regFwk300().fwk300Pedido().fwk300ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        fwk301().regFwk300().fwk300Pedido().fwk300TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        /**
         * PRC19 - FIM
         */
        if (hv02701Movhist7().movhist7().xRefMov().isEmpty() || 
            hv02701Movhist7().movhist7().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk301().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fwk301().write(fwk301().regFwk300()) ;
        if (fwk301().getStatusOk()) {
            wsContadores().wsContadorFwk301().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK301 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk301().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31323TrataFwk401() {
        log(TraceLevel.Debug, "A31323-TRATA-FWK401");
        fwk401().regFwk400().initialize() ;
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CBancCont().set(hv02701Movhist7().movhist7().cBancCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400COeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400VChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400TsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400ZValor().set(hv02701Movhist7().movhist7().zValMov());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400ZMovimento().set(hv02701Movhist7().movhist7().zMovLocl());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400IDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        if (hv02701Movhist7().movhist7().iEstorno().isEmpty()) {
            if (hv02701Movhist7().movhist7().iDbcr().isEqual("D")) {
                fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set("-");
                fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set("-");
            } else {
                fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set(" ");
                fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set(" ");
            }
        } else if (hv02701Movhist7().movhist7().iDbcr().isEqual("C")) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set("-");
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set("-");
        } else {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set(" ");
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set(" ");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400IEstorno().set(hv02701Movhist7().movhist7().iEstorno());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoOrg().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
        if (hv02701Movhist7().movhist7().mSldoCbloApos().isLess(0)) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalSld().set("-");
        } else {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalSld().set(" ");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MSldoCblo().set(hv02701Movhist7().movhist7().mSldoCbloApos());
        if (hv02701Movhist7().movhist7().mSldoDpnlApos().isLess(0)) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalDpnl().set("-");
        } else {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalDpnl().set(" ");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MSldoDpnl().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
        if (hv02701Movhist7().movhist7().mMovMoeOrigMov().isLess(0)) {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set("-");
        } else {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set(" ");
        }
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400MMovMoeOrig().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400AApl().set(hv02701Movhist7().movhist7().aAplOrig());
        if (hv02701Movhist7().movhist7().xRefMov().isEmpty() || 
            hv02701Movhist7().movhist7().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk401().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().set(hv02701Movhist7().movhist7().xRefMov());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK400-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK400-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK400-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK400-TS-PEDIDO
         */
        fwk401().regFwk400().fwk400Pedido().fwk400CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        fwk401().regFwk400().fwk400Pedido().fwk400ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        fwk401().regFwk400().fwk400Pedido().fwk400ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        fwk401().regFwk400().fwk400Pedido().fwk400TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        fwk401().write(fwk401().regFwk400()) ;
        if (fwk401().getStatusOk()) {
            wsContadores().wsContadorFwk401().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK401 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk401().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31324TrataFwk501() {
        log(TraceLevel.Debug, "A31324-TRATA-FWK501");
        fwk501().regFwk500().initialize() ;
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CBancCont().set(hv02701Movhist7().movhist7().cBancCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500VChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500TsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500ZValor().set(hv02701Movhist7().movhist7().zValMov());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500ZMovimento().set(hv02701Movhist7().movhist7().zMovLocl());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500IDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        if (hv02701Movhist7().movhist7().iEstorno().isEmpty()) {
            if (hv02701Movhist7().movhist7().iDbcr().isEqual("D")) {
                fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set("-");
                fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set("-");
            } else {
                fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set(" ");
                fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set(" ");
            }
        } else if (hv02701Movhist7().movhist7().iDbcr().isEqual("C")) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set("-");
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set("-");
        } else {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set(" ");
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set(" ");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500IEstorno().set(hv02701Movhist7().movhist7().iEstorno());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoOrg().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
        if (hv02701Movhist7().movhist7().mSldoCbloApos().isLess(0)) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalSld().set("-");
        } else {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalSld().set(" ");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MSldoCblo().set(hv02701Movhist7().movhist7().mSldoCbloApos());
        if (hv02701Movhist7().movhist7().mSldoDpnlApos().isLess(0)) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalDpnl().set("-");
        } else {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500SinalDpnl().set(" ");
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MSldoDpnl().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500MMovMoeOrig().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
        if (hv12701Movhstcp7().movhstcp7().cOperador().isEqual(0)) {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COperador().set(hv12701Movhstcp7().movhstcp7().cUserid());
        } else {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COperador().set(hv12701Movhstcp7().movhstcp7().cOperador());
        }
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500AApl().set(hv02701Movhist7().movhist7().aAplOrig());
        if (hv02701Movhist7().movhist7().xRefMov().isEmpty() || 
            hv02701Movhist7().movhist7().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk501().regFwk500().fwk500FicheiroFgh871().fwk500DDesc().set(hv02701Movhist7().movhist7().xRefMov());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK500-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK500-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK500-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK500-TS-PEDIDO
         */
        fwk501().regFwk500().fwk500Pedido().fwk500CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        fwk501().regFwk500().fwk500Pedido().fwk500ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        fwk501().regFwk500().fwk500Pedido().fwk500ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        fwk501().regFwk500().fwk500Pedido().fwk500TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        fwk501().write(fwk501().regFwk500()) ;
        if (fwk501().getStatusOk()) {
            wsContadores().wsContadorFwk501().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK501 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31325TrataFwk601() {
        log(TraceLevel.Debug, "A31325-TRATA-FWK601");
        fwk601().regFwk600().initialize() ;
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CBancCont().set(hv02701Movhist7().movhist7().cBancCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600COeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600VChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600TsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600ZValor().set(hv02701Movhist7().movhist7().zValMov());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600ZMovimento().set(hv02701Movhist7().movhist7().zMovLocl());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600IDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        if (hv02701Movhist7().movhist7().iEstorno().isEmpty()) {
            if (hv02701Movhist7().movhist7().iDbcr().isEqual("D")) {
                fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set("-");
                fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set("-");
            } else {
                fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set(" ");
                fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set(" ");
            }
        } else if (hv02701Movhist7().movhist7().iDbcr().isEqual("C")) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set("-");
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set(" ");
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600IEstorno().set(hv02701Movhist7().movhist7().iEstorno());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoOrg().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
        if (hv02701Movhist7().movhist7().mSldoCbloApos().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSld().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSld().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoCblo().set(hv02701Movhist7().movhist7().mSldoCbloApos());
        if (hv02701Movhist7().movhist7().mSldoDpnlApos().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDpnl().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDpnl().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoDpnl().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MMovMoeOrig().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
        if (hv02701Movhist7().movhist7().xRefMov().isEmpty() || 
            hv02701Movhist7().movhist7().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().set(hv02701Movhist7().movhist7().xRefMov());
        }
        if (hv12701Movhstcp7().movhstcp7().mSldoRetd().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoRetd().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoRetd().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoRetd().set(hv12701Movhstcp7().movhstcp7().mSldoRetd());
        if (hv12701Movhstcp7().movhstcp7().mSldoVcob().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoVcob().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoVcob().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MSldoVcob().set(hv12701Movhstcp7().movhstcp7().mSldoVcob());
        if (hv12701Movhstcp7().movhstcp7().mCmrgLim().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgLim().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgLim().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MCmrgLim().set(hv12701Movhstcp7().movhstcp7().mCmrgLim());
        if (hv12701Movhstcp7().movhstcp7().mCmrgUtid().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgUtid().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgUtid().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MCmrgUtid().set(hv12701Movhstcp7().movhstcp7().mCmrgUtid());
        if (hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdAtrd().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdAtrd().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MDcboNgcdAtrd().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd());
        if (hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid().isLess(0)) {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdUtid().set("-");
        } else {
            fwk601().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdUtid().set(" ");
        }
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600MDcboNgcdUtid().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK600-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK600-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK600-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK600-TS-PEDIDO
         */
        fwk601().regFwk600().fwk600Pedido().fwk600CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        fwk601().regFwk600().fwk600Pedido().fwk600ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        fwk601().regFwk600().fwk600Pedido().fwk600ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        fwk601().regFwk600().fwk600Pedido().fwk600TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        fwk601().write(fwk601().regFwk600()) ;
        if (fwk601().getStatusOk()) {
            wsContadores().wsContadorFwk601().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK601 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk601().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31326PreencheFwk701() {
        log(TraceLevel.Debug, "A31326-PREENCHE-FWK701");
        fwk701().regFwk700().initialize() ;
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CBancCont().set(hv02701Movhist7().movhist7().cBancCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700COeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700VChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700TsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700ZValor().set(hv02701Movhist7().movhist7().zValMov());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700ZMovimento().set(hv02701Movhist7().movhist7().zMovLocl());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700IDbcr().set(hv02701Movhist7().movhist7().iDbcr());
        if (hv02701Movhist7().movhist7().iEstorno().isEmpty()) {
            if (hv02701Movhist7().movhist7().iDbcr().isEqual("D")) {
                fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set("-");
                fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set("-");
            } else {
                fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set(" ");
                fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set(" ");
            }
        } else if (hv02701Movhist7().movhist7().iDbcr().isEqual("C")) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set("-");
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set("-");
        } else {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set(" ");
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set(" ");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MMovimento().set(hv02701Movhist7().movhist7().mMovimento());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700IEstorno().set(hv02701Movhist7().movhist7().iEstorno());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoOrg().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
        if (hv02701Movhist7().movhist7().mSldoCbloApos().isLess(0)) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalSld().set("-");
        } else {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalSld().set(" ");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MSldoCblo().set(hv02701Movhist7().movhist7().mSldoCbloApos());
        if (hv02701Movhist7().movhist7().mSldoDpnlApos().isLess(0)) {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalDpnl().set("-");
        } else {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700SinalDpnl().set(" ");
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MSldoDpnl().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700MMovMoeOrig().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CProduto().set(hv12701Movhstcp7().movhstcp7().cProduto());
        if (hv02701Movhist7().movhist7().xRefMov().isEmpty() || 
            hv02701Movhist7().movhist7().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk701().regFwk700().fwk700FicheiroFgh873().fwk700DDesc().set(hv02701Movhist7().movhist7().xRefMov());
        }
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CSectGrupo().set(hv12701Movhstcp7().movhstcp7().cTipoIttz());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CCndzCont().set(hv12701Movhstcp7().movhstcp7().cCndzMovzCont());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK700-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK700-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK700-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK700-TS-PEDIDO
         */
        fwk701().regFwk700().fwk700Pedido().fwk700CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        fwk701().regFwk700().fwk700Pedido().fwk700ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        fwk701().regFwk700().fwk700Pedido().fwk700ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        fwk701().regFwk700().fwk700Pedido().fwk700TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        fwk701().write(fwk701().regFwk700()) ;
        if (fwk701().getStatusOk()) {
            wsContadores().wsContadorFwk701().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - FWK701 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk701().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31327AcedeTgh00008() {
        log(TraceLevel.Debug, "A31327-ACEDE-TGH00008");
        hv00801Refmcbl().refmcbl().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00801_REFMCBL
         */
        hv00801Refmcbl().selectPghq027a1715(hv02701Movhist7().movhist7()) ;
        if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv00801Refmcbl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - SELECT  - VGH00801 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31399BuscaDescricao() {
        log(TraceLevel.Debug, "A31399-BUSCA-DESCRICAO");
        if (!haTgh102.isTrue()) {
            a31310AcedeInfComplementar() ;
        }
        if (progOk.isTrue()) {
            hrMghk800a().bghl800a().initialize() ;
            hrMghk800a().bghl800a().input().cPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
            hrMghk800a().bghl800a().input().cBancCont().set(hv02701Movhist7().movhist7().cBancCont());
            hrMghk800a().bghl800a().input().cOeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
            hrMghk800a().bghl800a().input().nsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
            hrMghk800a().bghl800a().input().vChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
            hrMghk800a().bghl800a().input().cTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
            hrMghk800a().bghl800a().input().nsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
            hrMghk800a().bghl800a().input().cMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
            hrMghk800a().bghl800a().input().iDbcr().set(hv02701Movhist7().movhist7().iDbcr());
            hrMghk800a().bghl800a().input().iEstorno().set(hv02701Movhist7().movhist7().iEstorno());
            hrMghk800a().bghl800a().input().zValMov().set(hv02701Movhist7().movhist7().zValMov());
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
            hrMghk800a().bghl800a().input().cOpeBbn().set(hv12701Movhstcp7().movhstcp7().cOpeBbn());
            hrMghk800a().run() ;
            if (!hrMghk800a().bghl800a().ok().isTrue()) {
                log(TraceLevel.Debug, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
                log(TraceLevel.Debug, "MGH800A-NM-PROGRAMA-", hrMghk800a().bghl800a().nmPrograma());
                log(TraceLevel.Debug, "MGH800A-C-SQLCODE-", hrMghk800a().bghl800a().cSqlcode());
                hrMghk800a().bghl800a().output().xRefMov().set(" ");
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400CloseC1() {
        log(TraceLevel.Debug, "A31400-CLOSE-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv02701Movhist7().closePghq027a1827() ;
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ027A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv02701Movhist7().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActualizaPedido() {
        wsFgh015().fgh015CPaisIsoaCont().set(fwk024().regFwk024Pghq027a().fwk024CPaisIsoaCont());
        wsFgh015().fgh015CBancCont().set(fwk024().regFwk024Pghq027a().fwk024CBancCont());
        wsFgh015().fgh015COeEgcCont().set(fwk024().regFwk024Pghq027a().fwk024COeEgcCont());
        wsFgh015().fgh015NsRdclCont().set(fwk024().regFwk024Pghq027a().fwk024NsRdclCont());
        wsFgh015().fgh015VChkdCont().set(fwk024().regFwk024Pghq027a().fwk024VChkdCont());
        wsFgh015().fgh015CTipoCont().set(fwk024().regFwk024Pghq027a().fwk024CTipoCont());
        wsFgh015().fgh015CMoedIsoScta().set(fwk024().regFwk024Pghq027a().fwk024CMoedIsoScta());
        wsFgh015().fgh015NsDeposito().set(fwk024().regFwk024Pghq027a().fwk024NsDeposito());
        wsFgh015().fgh015CPedInfOpps().set(fwk024().regFwk024Pghq027a().fwk024CPedInfOpps());
        wsFgh015().fgh015ZInicMov().set(fwk024().regFwk024Pghq027a().fwk024ZInicMov());
        wsFgh015().fgh015ZFimMov().set(fwk024().regFwk024Pghq027a().fwk024ZFimMov());
        wsFgh015().fgh015TsPedido().set(fwk024().regFwk024Pghq027a().fwk024TsPedido());
        wsFgh015().fgh015ZPedido().set(fwk024().regFwk024Pghq027a().fwk024ZPedido());
        wsFgh015().fgh015CEstPedHist().set(fwk024().regFwk024Pghq027a().fwk024CEstPedHist());
        wsFgh015().fgh015CTipoRpte().set(fwk024().regFwk024Pghq027a().fwk024CTipoRpte());
        wsFgh015().fgh015NmFichOutpRtno().set(fwk024().regFwk024Pghq027a().fwk024NmFichOutpRtno());
        wsFgh015().fgh015AAplDest().set(fwk024().regFwk024Pghq027a().fwk024AAplDest());
        wsFgh015().fgh015CFrmtInf().set(fwk024().regFwk024Pghq027a().fwk024CFrmtInf());
        wsFgh015().fgh015CCanlTrmzInf().set(fwk024().regFwk024Pghq027a().fwk024CCanlTrmzInf());
        wsFgh015().fgh015CEndcFtpDest().set(fwk024().regFwk024Pghq027a().fwk024CEndcFtpDest());
        wsFgh015().fgh015ZCluzPed().set(fwk024().regFwk024Pghq027a().fwk024ZCluzPed());
        wsFgh015().fgh015QDiaDpnzInf().set(fwk024().regFwk024Pghq027a().fwk024QDiaDpnzInf());
        wsFgh015().fgh015MParmPedHstMax().set(fwk024().regFwk024Pghq027a().fwk024MParmPedHstMax());
        wsFgh015().fgh015MParmPedHstMin().set(fwk024().regFwk024Pghq027a().fwk024MParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMax().set(fwk024().regFwk024Pghq027a().fwk024CParmPedHstMax());
        wsFgh015().fgh015CParmPedHstMin().set(fwk024().regFwk024Pghq027a().fwk024CParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMin().set(fwk024().regFwk024Pghq027a().fwk024CParmPedHstMin());
        wsFgh015().fgh015XMtvoDvlzPed().set(fwk024().regFwk024Pghq027a().fwk024XMtvoDvlzPed());
        wsFgh015().fgh015ZEliminacao().set(fwk024().regFwk024Pghq027a().fwk024ZEliminacao());
        wsFgh015().fgh015CUsidCrix().set(fwk024().regFwk024Pghq027a().fwk024CUsidCrix());
        wsFgh015().fgh015CPaisIsoaOeOpx().set(fwk024().regFwk024Pghq027a().fwk024CPaisIsoaOeOpx());
        wsFgh015().fgh015CMnemEgcOpex().set(fwk024().regFwk024Pghq027a().fwk024CMnemEgcOpex());
        wsFgh015().fgh015COeEgcOpex().set(fwk024().regFwk024Pghq027a().fwk024COeEgcOpex());
        wsFgh015().fgh015QDdbtPed().set(fwk024().regFwk024Pghq027a().fwk024QDdbtPed());
        wsFgh015().fgh015TsActzUlt().set(fwk024().regFwk024Pghq027a().fwk024TsActzUlt());
        wsFgh015().fgh015CUsidActzUlt().set(fwk024().regFwk024Pghq027a().fwk024CUsidActzUlt());
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
    protected void s70000Fim() {
        /**
         * *----------------------------------------------------------------*
         */
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha05().impRegLidosFwk024().set(wsContadores().wsContadorPedidos());
            tabelaImpressaoMask().zimp().setIndex(5) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK201");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk201());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK301");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk301());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK401");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk401());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK501");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk501());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK601");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk601());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK701");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk701());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ027A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
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
    @Override
    protected void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!fwk024().getStatusOk() && progOk.isTrue()) {
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
    public interface WTsInicio extends IDataStruct {
        
        @Data(size=10)
        IString wsDataInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHoraInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsMinInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsSecInicio() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestInicio() ;
        
    }
    public interface WTsFim extends IDataStruct {
        
        @Data(size=10)
        IString wsDataFim() ;
        
        @Data(size=2, value="23", lpadding=1, lpaddingValue="-")
        IInt wsHoraFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsMinFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsSecFim() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestFim() ;
        
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
    
    /**
     * 
     * CONTADORES
     * 
     * @version 2.0
     * 
     */
    public interface WsContadores extends IDataStruct {
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorPedidos() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk201() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk301() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk401() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk501() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk601() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk701() ;
        
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ027A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ027A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK024")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk024() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
