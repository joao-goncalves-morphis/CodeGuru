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
import cgd.gh.routines.Mghj801a ;
import cgd.ho.routines.Mhoj727a ;


/**
 * 
 * PRC19 - FIM
 * FWK503 - FICHEIRO DOS MOVIMENTOS DA CONTA DA DBI
 * FGH506 - FICHEIRO DOS MOVIMENTOS PARA ENTREGAR A APLICACAO HO
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.TRATA PEDIDO GH0096 E 97 A PARTIR DO FICHEIRO
 * FWK096 CRIADO NO PROGRAMA PGHC201A
 * 2.CRIACAO DE FICHEIRO MENSAL PARA A DBI A ENVIAR*
 * POR CONNECT-DIRECT
 * 3.O FICHEIRO FGH506 PARA PARA A APLICACAO HO
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq523a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk096
     */
    @Handler(name="FWK096", record="regFwk096Pghq523a")
    @Data
    protected abstract Fwk096 fwk096() ;
    
    /**
     * @return instancia da classe Fwk503
     */
    @Handler(name="FWK503", record="rwk50301")
    @Data
    protected abstract Fwk503 fwk503() ;
    
    /**
     * @return instancia da classe Fgh506
     */
    @Handler(name="FGH506", record="rgh50601")
    @Data
    protected abstract Fgh506 fgh506() ;
    
    
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
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0503
     */
    @Data
    protected abstract Bghw0503 bghw0503() ;
    
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
    
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    @Data(size=21)
    protected IString wsXRefMov ;
    
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
    protected IString wsTsInicio ;
    
    @Data(size=26)
    protected IString wsTsFim ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
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
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk096 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk503 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh506 ;
    
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
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ523A");
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
            a13000AbrirFwk503() ;
        }
        if (progOk.isTrue()) {
            a13100AbrirFgh506() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk096() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk096() ;
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
    protected void a13000AbrirFwk503() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK503");
        fwk503().open(CREATE ) ;
        if (!fwk503().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FWK503 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk503().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a13100AbrirFgh506() {
        log(TraceLevel.Debug, "A13100-ABRIR-FGH506");
        fgh506().open(CREATE ) ;
        if (!fgh506().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FGH506 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh506().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk096() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK096");
        fwk096().open() ;
        if (!fwk096().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FWK096 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk096().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk096() {
        log(TraceLevel.Debug, "A15000-LER-FWK096");
        fwk096().read() ;
        if (fwk096().getStatusOk()) {
            contRegLidosFwk096.add(1);
        }
        if (!fwk096().getStatusOk() && !fwk096().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK096 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk096().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            switch (fwk096().regFwk096Pghq523a().fwk096CPedInfOpps().get()) {
                case "GH00096":
                    a31000TratarPedidoGh096() ;
                    break;
                case "GH00097":
                    a31000TratarPedidoGh097() ;
                    break;
                default :
                    break ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a32000ActPedido() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk096() ;
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
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichLidos().set("FWK096");
            tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk096);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FWK503");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk503);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FGH506");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh506);
            a12000EscreverFgh300() ;
            if (contRegEscrtFwk503.isEqual(0)) {
                tabelaImpressao().linha08().impMens1().set("]]]] NAO HA MOVIMENTOS - FWK503 ]]]]");
                tabelaImpressaoMask().zimp().setIndex(7) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFgh506.isEqual(0)) {
                tabelaImpressao().linha08().impMens1().set("]]]] NAO HA MOVIMENTOS - FGH506 ]]]]");
                tabelaImpressaoMask().zimp().setIndex(7) ;
                a12000EscreverFgh300() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ523A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk503().close() ;
        fgh506().close() ;
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
    protected void a31000TratarPedidoGh097() {
        log(TraceLevel.Debug, "A31000-TRATAR-PEDIDO-GH097");
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue()) {
                a31300TratarMovimentosGh097() ;
            }
        }
        if (progOk.isTrue() || progNaoExiste.isTrue()) {
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarPedidoGh096() {
        log(TraceLevel.Debug, "A31000-TRATAR-PEDIDO-GH096");
        a31100OpenCursorC3() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC3() ;
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue()) {
                a31300TratarMovimentosGh096() ;
            }
        }
        if (progOk.isTrue() || progNaoExiste.isTrue()) {
            a31400CloseCursorC3() ;
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
         * MOVE W-TS-INICIO                 TO WS-TS-INICIO
         * MOVE FGH015-Z-FIM-MOV            TO WS-DATA-FIM
         * MOVE W-TS-FIM                    TO WS-TS-FIM
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(fwk096().regFwk096Pghq523a().fwk096CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(fwk096().regFwk096Pghq523a().fwk096CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(fwk096().regFwk096Pghq523a().fwk096COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(fwk096().regFwk096Pghq523a().fwk096NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(fwk096().regFwk096Pghq523a().fwk096VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(fwk096().regFwk096Pghq523a().fwk096CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(fwk096().regFwk096Pghq523a().fwk096CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(fwk096().regFwk096Pghq523a().fwk096NsDeposito());
        wTsInicio().wsDataInicio().set(fwk096().regFwk096Pghq523a().fwk096ZInicMov());
        wsTsInicio.set(wTsInicio());
        wTsFim().wsDataFim().set(fwk096().regFwk096Pghq523a().fwk096ZFimMov());
        wsTsFim.set(wTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv10201Movhstcpl().openPghq523a849(wsTsInicio, wsTsFim) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
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
        hv10201Movhstcpl().fetchPghq523a878() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FETCH C1- VGH10201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenCursorC3() {
        log(TraceLevel.Debug, "A31100-OPEN-CURSOR-C3");
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
         * MOVE FGH015-C-PARM-PED-HST-MIN(1:5)
         * TO VGH10201-C-OPE-BBN
         * MOVE FGH015-Z-INIC-MOV           TO WS-DATA-INICIO
         * MOVE W-TS-INICIO                 TO WS-TS-INICIO
         * MOVE FGH015-Z-FIM-MOV            TO WS-DATA-FIM
         * MOVE W-TS-FIM                    TO WS-TS-FIM
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(fwk096().regFwk096Pghq523a().fwk096CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(fwk096().regFwk096Pghq523a().fwk096CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(fwk096().regFwk096Pghq523a().fwk096COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(fwk096().regFwk096Pghq523a().fwk096NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(fwk096().regFwk096Pghq523a().fwk096VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(fwk096().regFwk096Pghq523a().fwk096CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(fwk096().regFwk096Pghq523a().fwk096CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(fwk096().regFwk096Pghq523a().fwk096NsDeposito());
        hv10201Movhstcpl().movhstcpl().cOpeBbn().set(fwk096().regFwk096Pghq523a().fwk096CParmPedHstMin().get(1, 5));
        wTsInicio().wsDataInicio().set(fwk096().regFwk096Pghq523a().fwk096ZInicMov());
        wsTsInicio.set(wTsInicio());
        wTsFim().wsDataFim().set(fwk096().regFwk096Pghq523a().fwk096ZFimMov());
        wsTsFim.set(wTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv10201Movhstcpl().openPghq523a959(wsTsInicio, wsTsFim) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - CURSOR C3   - OPEN - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200FetchCursorC3() {
        log(TraceLevel.Debug, "A31200-FETCH-CURSOR-C3");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C3
         */
        hv10201Movhstcpl().fetchPghq523a988() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FETCH C3- VGH10201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            a31400CloseCursorC3() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarMovimentosGh097() {
        log(TraceLevel.Debug, "A31300-TRATAR-MOVIMENTOS-GH097");
        a31310AcederMovHst() ;
        if (progOk.isTrue()) {
            a31330EscreverFgh506() ;
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarMovimentosGh096() {
        log(TraceLevel.Debug, "A31300-TRATAR-MOVIMENTOS");
        a31310AcederMovHst() ;
        if (progOk.isTrue()) {
            if (hv00201Movhst().movhst().iEstorno().isEmpty()) {
                a31320EscreverFwk503() ;
            }
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC3() ;
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
        hv00201Movhst().selectPghq523a1075(hv10201Movhstcpl().movhstcpl()) ;
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - SELECT  - VGH00201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320EscreverFwk503() {
        log(TraceLevel.Debug, "A31320-ESCREVER-FWK503");
        fwk503().rwk50301().initialize() ;
        fwk503().rwk50301().fwk503Subconta().fwk503CPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        fwk503().rwk50301().fwk503Subconta().fwk503CBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        fwk503().rwk50301().fwk503Subconta().fwk503COeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        fwk503().rwk50301().fwk503Subconta().fwk503NsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        fwk503().rwk50301().fwk503Subconta().fwk503VChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        fwk503().rwk50301().fwk503Subconta().fwk503CTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        fwk503().rwk50301().fwk503Subconta().fwk503CMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
        fwk503().rwk50301().fwk503Subconta().fwk503NsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
        fwk503().rwk50301().fwk503ZMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fwk503().rwk50301().fwk503NsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
        fwk503().rwk50301().fwk503ZValor().set(hv00201Movhst().movhst().zValMov());
        fwk503().rwk50301().fwk503XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk503().rwk50301().fwk503CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk503().rwk50301().fwk503MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk503().rwk50301().fwk503MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk503().rwk50301().fwk503IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk503().rwk50301().fwk503MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        if (fwk503().rwk50301().fwk503MSldoCblo().isGreaterOrEqual(0)) {
            fwk503().rwk50301().fwk503ISinalSldoCblo().set(" ");
        } else {
            fwk503().rwk50301().fwk503ISinalSldoCblo().set("-");
        }
        fwk503().rwk50301().fwk503MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        if (fwk503().rwk50301().fwk503MSldoDpnl().isGreaterOrEqual(0)) {
            fwk503().rwk50301().fwk503ISinalSldoDpnl().set(" ");
        } else {
            fwk503().rwk50301().fwk503ISinalSldoDpnl().set("-");
        }
        fwk503().rwk50301().fwk503CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        fwk503().rwk50301().fwk503CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fwk503().rwk50301().fwk503CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fwk503().rwk50301().fwk503COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fwk503().rwk50301().fwk503AAplicacao().set(hv00201Movhst().movhst().aAplOrig());
        fwk503().rwk50301().fwk503COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fwk503().rwk50301().fwk503NCheque().set(hv00201Movhst().movhst().nDocOpps());
        fwk503().rwk50301().fwk503CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        fwk503().rwk50301().fwk503IDbcr().set(hv00201Movhst().movhst().iDbcr());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK503-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK503-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK503-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK503-TS-PEDIDO
         */
        fwk503().rwk50301().fwk503Pedido().fwk503CPedInfOpps().set(fwk096().regFwk096Pghq523a().fwk096CPedInfOpps());
        fwk503().rwk50301().fwk503Pedido().fwk503ZInicMov().set(fwk096().regFwk096Pghq523a().fwk096ZInicMov());
        fwk503().rwk50301().fwk503Pedido().fwk503ZFimMov().set(fwk096().regFwk096Pghq523a().fwk096ZFimMov());
        fwk503().rwk50301().fwk503Pedido().fwk503TsPedido().set(fwk096().regFwk096Pghq523a().fwk096TsPedido());
        /**
         * PRC19 - FIM
         */
        if (fwk503().rwk50301().fwk503XRefMov().isEmpty()) {
            a31320ObtemDescritivo() ;
            if (progOk.isTrue()) {
                fwk503().rwk50301().fwk503XRefMov().set(wsXRefMov);
            }
        }
        fwk503().write(fwk503().rwk50301()) ;
        if (fwk503().getStatusOk()) {
            contRegEscrtFwk503.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FWK503 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk503().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31330EscreverFgh506() {
        log(TraceLevel.Debug, "A31330-ESCREVER-FGH506");
        fgh506().rgh50601().initialize() ;
        fgh506().rgh50601().fgh506Subconta().fgh506CPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        fgh506().rgh50601().fgh506Subconta().fgh506CBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        fgh506().rgh50601().fgh506Subconta().fgh506COeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        fgh506().rgh50601().fgh506Subconta().fgh506NsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        fgh506().rgh50601().fgh506Subconta().fgh506VChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        fgh506().rgh50601().fgh506Subconta().fgh506CTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        fgh506().rgh50601().fgh506Subconta().fgh506CMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
        fgh506().rgh50601().fgh506Subconta().fgh506NsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
        fgh506().rgh50601().fgh506ZMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fgh506().rgh50601().fgh506NsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
        fgh506().rgh50601().fgh506ZValor().set(hv00201Movhst().movhst().zValMov());
        fgh506().rgh50601().fgh506XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fgh506().rgh50601().fgh506CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fgh506().rgh50601().fgh506MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fgh506().rgh50601().fgh506MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fgh506().rgh50601().fgh506IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fgh506().rgh50601().fgh506MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        fgh506().rgh50601().fgh506MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fgh506().rgh50601().fgh506CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        fgh506().rgh50601().fgh506CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fgh506().rgh50601().fgh506CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fgh506().rgh50601().fgh506COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fgh506().rgh50601().fgh506AAplicacao().set(hv00201Movhst().movhst().aAplOrig());
        fgh506().rgh50601().fgh506COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fgh506().rgh50601().fgh506NCheque().set(hv00201Movhst().movhst().nDocOpps());
        fgh506().rgh50601().fgh506CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        fgh506().rgh50601().fgh506IDbcr().set(hv00201Movhst().movhst().iDbcr());
        /**
         * MOVE FGH015-C-ENDC-FTP-DEST    TO FGH506-C-ENDC-FTP-DEST
         */
        fgh506().rgh50601().fgh506CEndcFtpDest().set(fwk096().regFwk096Pghq523a().fwk096CEndcFtpDest());
        if (fgh506().rgh50601().fgh506XRefMov().isEmpty()) {
            a31320ObtemDescritivo() ;
            if (progOk.isTrue()) {
                fgh506().rgh50601().fgh506XRefMov().set(wsXRefMov);
            }
        }
        fgh506().write(fgh506().rgh50601()) ;
        if (fgh506().getStatusOk()) {
            contRegEscrtFgh506.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - FGH506 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh506().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320ObtemDescritivo() {
        log(TraceLevel.Debug, "A31320-OBTEM-DESCRITIVO");
        hrMghj801a().bghl801a().initialize() ;
        hrMhoj727a().bhol727a().commarea().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(hv00201Movhst().movhst().cBancCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cBancCont().set(hv00201Movhst().movhst().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().nsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().vChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cTipoCont().set(hv00201Movhst().movhst().cTipoCont());
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
        hv10201Movhstcpl().closePghq523a1312() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400CloseCursorC3() {
        log(TraceLevel.Debug, "A31400-CLOSE-CURSOR-C3");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C3
         */
        hv10201Movhstcpl().closePghq523a1338() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ523A - CURSOR C3 -CLOSE - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActPedido() {
        log(TraceLevel.Debug, "A32000-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-CONT     TO VGH01501-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT          TO VGH01501-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-CONT        TO VGH01501-C-OE-EGC-CONT
         * MOVE FGH015-NS-RDCL-CONT         TO VGH01501-NS-RDCL-CONT
         * MOVE FGH015-V-CHKD-CONT          TO VGH01501-V-CHKD-CONT
         * MOVE FGH015-C-TIPO-CONT          TO VGH01501-C-TIPO-CONT
         * MOVE FGH015-C-MOED-ISO-SCTA      TO VGH01501-C-MOED-ISO-SCTA
         * MOVE FGH015-NS-DEPOSITO          TO VGH01501-NS-DEPOSITO
         * MOVE FGH015-C-PED-INF-OPPS       TO VGH01501-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV           TO VGH01501-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV            TO VGH01501-Z-FIM-MOV
         */
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk096().regFwk096Pghq523a().fwk096CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk096().regFwk096Pghq523a().fwk096CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk096().regFwk096Pghq523a().fwk096COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk096().regFwk096Pghq523a().fwk096NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk096().regFwk096Pghq523a().fwk096VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk096().regFwk096Pghq523a().fwk096CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk096().regFwk096Pghq523a().fwk096CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk096().regFwk096Pghq523a().fwk096NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk096().regFwk096Pghq523a().fwk096CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk096().regFwk096Pghq523a().fwk096ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk096().regFwk096Pghq523a().fwk096ZFimMov());
        /**
         * PRC19 - FIM
         */
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq523a1393() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- UPDATE VGH01501 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
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
            while (!fwk096().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
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
    public interface WTsInicio extends IDataStruct {
        
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
    public interface WTsFim extends IDataStruct {
        
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ523A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ523A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS     ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichLidos() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidos() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
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
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
