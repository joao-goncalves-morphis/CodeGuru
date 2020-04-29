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
import cgd.gh.routines.Mghj801a ;
import cgd.ho.routines.Mhoj727a ;
import cgd.hy.routines.Mhyj230a ;


/**
 * 
 * PRC19 - FIM
 * FWK505 - FICHEIRO DOS MOVIMENTOS DA TSU
 * ** TABELAS DB2
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.TRATA PEDIDO GH0098 A PARTIR DO FICHEIRO
 * FWK098 CRIADO NO PROGRAMA PGHC201A
 * 2.CRIACAO DE FICHEIRO MENSAL PARA A DBI DAS
 * COBRANCAS DA TSU
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq504a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
     * @return instancia da classe Fwk098
     */
    @Handler(name="FWK098", record="regFwk098Pghq504a")
    @Data
    protected abstract Fwk098 fwk098() ;
    
    /**
     * @return instancia da classe Fwk505
     */
    @Handler(name="FWK505", record="regFwk505")
    @Data
    protected abstract Fwk505 fwk505() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghj801a
     */
    @Data
    protected abstract Mghj801a hrMghj801a() ;
    
    /**
     * @return instancia da classe Mhoj727a
     */
    @Data
    protected abstract Mhoj727a hrMhoj727a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
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
    
    
    @Data(size=21)
    protected IString wsXRefMov ;
    
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
    
    
    /**
     * PRC19 - INI
     * @return instancia da classe local WsFgh015
     */
    @Data
    protected abstract WsFgh015 wsFgh015() ;
    
    /**
     * PRC19 - FIM
     */
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
    
    @Data(size=26)
    protected IString wsTsMovFim ;
    
    @Data(size=26)
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
    protected ILong contRegLidosFwk098 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk505 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ504A");
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
            a13000AbrirFwk505() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk098() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk098() ;
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
    protected void a13000AbrirFwk505() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK505");
        fwk505().open(CREATE ) ;
        if (!fwk505().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - FWK505 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fwk505().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk098() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK098");
        fwk098().open() ;
        if (!fwk098().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - FWK098 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fwk098().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk098() {
        log(TraceLevel.Debug, "A15000-LER-FWK098");
        fwk098().read() ;
        if (fwk098().getStatusOk()) {
            contRegLidosFwk098.add(1);
        }
        if (!fwk098().getStatusOk() && !fwk098().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ200A - FWK098 - READ - ");
            tabelaImpressao().linha08().impStatus().set(fwk098().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarHistoricoMov() ;
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a32000ActPedido() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk098() ;
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
            tabelaImpressao().linha06().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichEsc().set("FWK505");
            tabelaImpressao().linha05().impRegEscrt().set(contRegEscrtFwk505);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk505.isEqual(0)) {
                tabelaImpressao().linha07().impMens1().set("]]]] NAO HA MOVIMENTOS ]]]]");
                tabelaImpressaoMask().zimp().setIndex(7) ;
                a12000EscreverFgh300() ;
            }
        } else {
            tabelaImpressao().linha06().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha06().impReturnCode().set(returnCode);
            tabelaImpressao().linha07().impMens1().set("PGHQ504A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk505().close() ;
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
    protected void a31000TratarHistoricoMov() {
        log(TraceLevel.Debug, "A31000-TRATAR-HISTORICO-MOV");
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL) {
                a31300TratarMovimentos() ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenCursorC1() {
        log(TraceLevel.Debug, "A31100-OPEN-CURSOR-C1");
        wSqlcode.initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-CONT     TO VGH10201-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT          TO VGH10201-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-CONT        TO VGH10201-C-OE-EGC-CONT
         * MOVE FGH015-NS-RDCL-CONT         TO VGH10201-NS-RDCL-CONT
         * MOVE FGH015-V-CHKD-CONT          TO VGH10201-V-CHKD-CONT
         * MOVE FGH015-C-TIPO-CONT          TO VGH10201-C-TIPO-CONT
         * MOVE FGH015-C-MOED-ISO-SCTA      TO VGH10201-C-MOED-ISO-SCTA
         * MOVE FGH015-NS-DEPOSITO          TO VGH10201-NS-DEPOSITO
         * MOVE FGH015-Z-INIC-MOV           TO WS-DATA-INICIO
         * MOVE WS-TS-INICIO                TO WS-TS-MOV-INICIO
         * MOVE FGH015-Z-FIM-MOV            TO WS-DATA-FIM
         * MOVE WS-TS-FIM                   TO WS-TS-MOV-FIM
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(fwk098().regFwk098Pghq504a().fwk098CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(fwk098().regFwk098Pghq504a().fwk098CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(fwk098().regFwk098Pghq504a().fwk098COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(fwk098().regFwk098Pghq504a().fwk098NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(fwk098().regFwk098Pghq504a().fwk098VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(fwk098().regFwk098Pghq504a().fwk098CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(fwk098().regFwk098Pghq504a().fwk098CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(fwk098().regFwk098Pghq504a().fwk098NsDeposito());
        wsTsInicio().wsDataInicio().set(fwk098().regFwk098Pghq504a().fwk098ZInicMov());
        wsTsMovInicio.set(wsTsInicio());
        wsTsFim().wsDataFim().set(fwk098().regFwk098Pghq504a().fwk098ZFimMov());
        wsTsMovFim.set(wsTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv10201Movhstcpl().openPghq504a760(wsTsMovFim, wsTsMovInicio) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200FetchCursorC1() {
        log(TraceLevel.Debug, "A31200-FETCH-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv10201Movhstcpl().fetchPghq504a789() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - FETCH C1- VGH10201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarMovimentos() {
        log(TraceLevel.Debug, "A31300-TRATAR-MOVIMENTOS");
        a31310AcederMovHst() ;
        if (progOk.isTrue()) {
            a31320EscreverFwk505() ;
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AcederMovHst() {
        log(TraceLevel.Debug, "A31310-ACEDER-MOV-HST-CMPL");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq504a874(hv10201Movhstcpl().movhstcpl()) ;
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - SELECT  - VGH10201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320EscreverFwk505() {
        /**
         * *----------------------------------------------------------------*
         */
        fwk505().regFwk505().initialize() ;
        fwk505().regFwk505().fwk505Subconta().fwk505CPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        fwk505().regFwk505().fwk505CPaisIsoaGerx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        fwk505().regFwk505().fwk505Subconta().fwk505CBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        fwk505().regFwk505().fwk505CBancGcxGerx().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        fwk505().regFwk505().fwk505Subconta().fwk505COeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        fwk505().regFwk505().fwk505COeEgcGerx().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        fwk505().regFwk505().fwk505Subconta().fwk505NsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        fwk505().regFwk505().fwk505Subconta().fwk505VChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        fwk505().regFwk505().fwk505Subconta().fwk505CTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        fwk505().regFwk505().fwk505Subconta().fwk505CMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
        fwk505().regFwk505().fwk505Subconta().fwk505NsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
        fwk505().regFwk505().fwk505NsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
        fwk505().regFwk505().fwk505ZContabilizacao().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fwk505().regFwk505().fwk505ZMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fwk505().regFwk505().fwk505ZProcessamento().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fwk505().regFwk505().fwk505ZValor().set(hv00201Movhst().movhst().zValMov());
        fwk505().regFwk505().fwk505IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk505().regFwk505().fwk505MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk505().regFwk505().fwk505MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        fwk505().regFwk505().fwk505MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk505().regFwk505().fwk505CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk505().regFwk505().fwk505MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk505().regFwk505().fwk505TCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
        fwk505().regFwk505().fwk505COpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        fwk505().regFwk505().fwk505XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk505().regFwk505().fwk505NCheque().set(hv00201Movhst().movhst().nDocOpps());
        fwk505().regFwk505().fwk505IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk505().regFwk505().fwk505CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        fwk505().regFwk505().fwk505AAplicacao().set(hv00201Movhst().movhst().aAplOrig());
        fwk505().regFwk505().fwk505COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fwk505().regFwk505().fwk505CFamiProd().set(hv10201Movhstcpl().movhstcpl().cFamiProd());
        fwk505().regFwk505().fwk505CProduto().set(hv10201Movhstcpl().movhstcpl().cProduto());
        fwk505().regFwk505().fwk505CSectIttlBpor().set(hv10201Movhstcpl().movhstcpl().cTipoIttz());
        fwk505().regFwk505().fwk505CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fwk505().regFwk505().fwk505CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fwk505().regFwk505().fwk505COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fwk505().regFwk505().fwk505CUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
        fwk505().regFwk505().fwk505NJourBbn().set(hv10201Movhstcpl().movhstcpl().nJourBbn());
        fwk505().regFwk505().fwk505NsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
        fwk505().regFwk505().fwk505NsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
        fwk505().regFwk505().fwk505MSldoRetd().set(hv10201Movhstcpl().movhstcpl().mSldoRetd());
        fwk505().regFwk505().fwk505MSldoVcob().set(hv10201Movhstcpl().movhstcpl().mSldoVcob());
        fwk505().regFwk505().fwk505MDcboNgcdAtrd().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd());
        fwk505().regFwk505().fwk505MDcboNgcdUtid().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid());
        fwk505().regFwk505().fwk505MCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
        fwk505().regFwk505().fwk505MCmrgUtid().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
        fwk505().regFwk505().fwk505CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        fwk505().regFwk505().fwk505TsActzUlt().set(hv10201Movhstcpl().movhstcpl().tsActzUlt());
        fwk505().regFwk505().fwk505CUsidActzUlt().set(hv10201Movhstcpl().movhstcpl().cUsidActzUlt());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK505-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK505-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK505-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK505-TS-PEDIDO
         */
        fwk505().regFwk505().fwk505CPedInfOpps().set(fwk098().regFwk098Pghq504a().fwk098CPedInfOpps());
        fwk505().regFwk505().fwk505ZInicMov().set(fwk098().regFwk098Pghq504a().fwk098ZInicMov());
        fwk505().regFwk505().fwk505ZFimMov().set(fwk098().regFwk098Pghq504a().fwk098ZFimMov());
        fwk505().regFwk505().fwk505TsPedido().set(fwk098().regFwk098Pghq504a().fwk098TsPedido());
        /**
         * PRC19 - FIM
         */
        if (fwk505().regFwk505().fwk505XRefMov().isEmpty()) {
            a31320ObtemDescricao() ;
            if (progOk.isTrue()) {
                fwk505().regFwk505().fwk505XRefMov().set(wsXRefMov);
            }
        }
        fwk505().write(fwk505().regFwk505()) ;
        if (fwk505().getStatusOk()) {
            contRegEscrtFwk505.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - FWK505 - WRITE   - ");
            tabelaImpressao().linha08().impStatus().set(fwk505().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320ObtemDescricao() {
        log(TraceLevel.Debug, "A31320-OBTEM-DESCRICAO");
        hrMghj801a().bghl801a().initialize() ;
        hrMhoj727a().bhol727a().commarea().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cOeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().nsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().vChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        if (hv00201Movhst().movhst().iEstorno().isEqual("E")) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
                hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
                hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(hv00201Movhst().movhst().iDbcr());
            hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set(hv00201Movhst().movhst().iDbcr());
        }
        hrMhoj727a().bhol727a().commarea().dadosInput().cOeEgc().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        hrMhoj727a().bhol727a().commarea().dadosInput().zValor().set(hv00201Movhst().movhst().zValMov());
        hrMhoj727a().bhol727a().commarea().dadosInput().nCheque().set(hv00201Movhst().movhst().nDocOpps());
        hrMhoj727a().bhol727a().commarea().dadosInput().xRefMov().set(hv00201Movhst().movhst().xRefMov());
        hrMhoj727a().bhol727a().commarea().dadosInput().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        hrMhoj727a().bhol727a().commarea().dadosInput().cIdioIso().set("POR");
        hrMghj801a().run() ;
        if (hrMghj801a().bghl801a().ok().isTrue()) {
            hrMhoj727a().bhol727a().commarea().dadosInput().iDcvoEspl().set(hrMghj801a().bghl801a().detalhe().iDcvoEspl());
        } else {
            log(TraceLevel.Error, "MGH801A-C-RETORNO-", hrMghj801a().bghl801a().cRetorno());
            hrMghj801a().bghl801a().detalhe().iDcvoEsplN().setTrue() ;
            hrMhoj727a().bhol727a().commarea().dadosInput().iDcvoEspl().set(hrMghj801a().bghl801a().detalhe().iDcvoEspl());
        }
        hrMhoj727a().run() ;
        if (hrMhoj727a().bhol727a().commarea().dadosErro().semErros().isTrue()) {
            wsXRefMov.set(hrMhoj727a().bhol727a().commarea().dadosOutput().dMovimento());
        } else {
            wsXRefMov.set(" ");
            log(TraceLevel.Error, "BHOL727A-C-RTNO-EVEN-SWAL -", hrMhoj727a().bhol727a().commarea().dadosErro().cRtnoEvenSwal());
            log(TraceLevel.Error, "BHOL727A-C-TIPO-ERRO-BBN -", hrMhoj727a().bhol727a().commarea().dadosErro().cTipoErroBbn());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400CloseCursorC1() {
        log(TraceLevel.Debug, "A31400-CLOSE-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv10201Movhstcpl().closePghq504a1051() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ504A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActPedido() {
        log(TraceLevel.Debug, "A32000-ACT-PEDIDO");
        /**
         * PRC19 - INI
         */
        wsFgh015().fgh015CPaisIsoaCont().set(fwk098().regFwk098Pghq504a().fwk098CPaisIsoaCont());
        wsFgh015().fgh015CBancCont().set(fwk098().regFwk098Pghq504a().fwk098CBancCont());
        wsFgh015().fgh015COeEgcCont().set(fwk098().regFwk098Pghq504a().fwk098COeEgcCont());
        wsFgh015().fgh015NsRdclCont().set(fwk098().regFwk098Pghq504a().fwk098NsRdclCont());
        wsFgh015().fgh015VChkdCont().set(fwk098().regFwk098Pghq504a().fwk098VChkdCont());
        wsFgh015().fgh015CTipoCont().set(fwk098().regFwk098Pghq504a().fwk098CTipoCont());
        wsFgh015().fgh015CMoedIsoScta().set(fwk098().regFwk098Pghq504a().fwk098CMoedIsoScta());
        wsFgh015().fgh015NsDeposito().set(fwk098().regFwk098Pghq504a().fwk098NsDeposito());
        wsFgh015().fgh015CPedInfOpps().set(fwk098().regFwk098Pghq504a().fwk098CPedInfOpps());
        wsFgh015().fgh015ZInicMov().set(fwk098().regFwk098Pghq504a().fwk098ZInicMov());
        wsFgh015().fgh015ZFimMov().set(fwk098().regFwk098Pghq504a().fwk098ZFimMov());
        wsFgh015().fgh015TsPedido().set(fwk098().regFwk098Pghq504a().fwk098TsPedido());
        wsFgh015().fgh015ZPedido().set(fwk098().regFwk098Pghq504a().fwk098ZPedido());
        wsFgh015().fgh015CEstPedHist().set(fwk098().regFwk098Pghq504a().fwk098CEstPedHist());
        wsFgh015().fgh015CTipoRpte().set(fwk098().regFwk098Pghq504a().fwk098CTipoRpte());
        wsFgh015().fgh015NmFichOutpRtno().set(fwk098().regFwk098Pghq504a().fwk098NmFichOutpRtno());
        wsFgh015().fgh015AAplDest().set(fwk098().regFwk098Pghq504a().fwk098AAplDest());
        wsFgh015().fgh015CFrmtInf().set(fwk098().regFwk098Pghq504a().fwk098CFrmtInf());
        wsFgh015().fgh015CCanlTrmzInf().set(fwk098().regFwk098Pghq504a().fwk098CCanlTrmzInf());
        wsFgh015().fgh015CEndcFtpDest().set(fwk098().regFwk098Pghq504a().fwk098CEndcFtpDest());
        wsFgh015().fgh015ZCluzPed().set(fwk098().regFwk098Pghq504a().fwk098ZCluzPed());
        wsFgh015().fgh015QDiaDpnzInf().set(fwk098().regFwk098Pghq504a().fwk098QDiaDpnzInf());
        wsFgh015().fgh015MParmPedHstMax().set(fwk098().regFwk098Pghq504a().fwk098MParmPedHstMax());
        wsFgh015().fgh015MParmPedHstMin().set(fwk098().regFwk098Pghq504a().fwk098MParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMax().set(fwk098().regFwk098Pghq504a().fwk098CParmPedHstMax());
        wsFgh015().fgh015CParmPedHstMin().set(fwk098().regFwk098Pghq504a().fwk098CParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMin().set(fwk098().regFwk098Pghq504a().fwk098CParmPedHstMin());
        wsFgh015().fgh015XMtvoDvlzPed().set(fwk098().regFwk098Pghq504a().fwk098XMtvoDvlzPed());
        wsFgh015().fgh015ZEliminacao().set(fwk098().regFwk098Pghq504a().fwk098ZEliminacao());
        wsFgh015().fgh015CUsidCrix().set(fwk098().regFwk098Pghq504a().fwk098CUsidCrix());
        wsFgh015().fgh015CPaisIsoaOeOpx().set(fwk098().regFwk098Pghq504a().fwk098CPaisIsoaOeOpx());
        wsFgh015().fgh015CMnemEgcOpex().set(fwk098().regFwk098Pghq504a().fwk098CMnemEgcOpex());
        wsFgh015().fgh015COeEgcOpex().set(fwk098().regFwk098Pghq504a().fwk098COeEgcOpex());
        wsFgh015().fgh015QDdbtPed().set(fwk098().regFwk098Pghq504a().fwk098QDdbtPed());
        wsFgh015().fgh015TsActzUlt().set(fwk098().regFwk098Pghq504a().fwk098TsActzUlt());
        wsFgh015().fgh015CUsidActzUlt().set(fwk098().regFwk098Pghq504a().fwk098CUsidActzUlt());
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
            while (!fwk098().getStatusOk() && progOk.isTrue()) {
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ504A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ504A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
