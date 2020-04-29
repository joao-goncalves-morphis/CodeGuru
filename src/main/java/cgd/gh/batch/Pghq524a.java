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
 * FGH507 - FICHEIRO DOS MOVIMENTOS DAS 2ª VIAS EXT
 * ** TABELAS DB2
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.TRATA PEDIDO GH0094 A PARTIR DO FICHEIRO
 * FWK094 CRIADO NO PROGRAMA PGHC201A
 * 2.CRIA O FICHEIRO FGH507
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq524a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk094
     */
    @Handler(name="FWK094", record="regFwk094Pghq524a")
    @Data
    protected abstract Fwk094 fwk094() ;
    
    /**
     * @return instancia da classe Fgh507
     */
    @Handler(name="FGH507", record="regFgh507")
    @Data
    protected abstract Fgh507 fgh507() ;
    
    
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
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString wsMghj801a ;
    
    @Data(size=21)
    protected IString wsXRefMov ;
    
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
    protected ILong contRegLidosFwk094 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh507 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ524A");
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
            a13000AbrirFgh507() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk094() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk094() ;
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
    protected void a13000AbrirFgh507() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH507");
        fgh507().open(CREATE ) ;
        if (!fgh507().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - FGH507 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fgh507().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk094() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK094");
        fwk094().open() ;
        if (!fwk094().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - FWK094 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fwk094().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk094() {
        log(TraceLevel.Debug, "A15000-LER-FWK094");
        fwk094().read() ;
        if (fwk094().getStatusOk()) {
            contRegLidosFwk094.add(1);
        }
        if (!fwk094().getStatusOk() && !fwk094().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - FWK094 - READ - ");
            tabelaImpressao().linha08().impStatus().set(fwk094().getStatus());
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
            a15000LerFwk094() ;
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
            tabelaImpressao().linha05().impFichEsc().set("FGH507");
            tabelaImpressao().linha05().impRegEscrt().set(contRegEscrtFgh507);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFgh507.isEqual(0)) {
                tabelaImpressao().linha07().impMens1().set("]]]] NAO HA MOVIMENTOS ]]]]");
                tabelaImpressaoMask().zimp().setIndex(7) ;
                a12000EscreverFgh300() ;
            }
        } else {
            tabelaImpressao().linha06().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha06().impReturnCode().set(returnCode);
            tabelaImpressao().linha07().impMens1().set("PGHQ524A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fgh507().close() ;
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
            while (!progNaoExiste.isTrue()) {
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
         * MOVE FGH015-C-PARM-PED-HST-MIN(1:5)
         * TO VGH10201-C-OPE-BBN
         * MOVE FGH015-Z-INIC-MOV           TO WS-DATA-INICIO
         * MOVE WS-TS-INICIO                TO WS-TS-MOV-INICIO
         * MOVE FGH015-Z-FIM-MOV            TO WS-DATA-FIM
         * MOVE WS-TS-FIM                   TO WS-TS-MOV-FIM
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(fwk094().regFwk094Pghq524a().fwk094CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(fwk094().regFwk094Pghq524a().fwk094CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(fwk094().regFwk094Pghq524a().fwk094COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(fwk094().regFwk094Pghq524a().fwk094NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(fwk094().regFwk094Pghq524a().fwk094VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(fwk094().regFwk094Pghq524a().fwk094CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(fwk094().regFwk094Pghq524a().fwk094CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(fwk094().regFwk094Pghq524a().fwk094NsDeposito());
        hv10201Movhstcpl().movhstcpl().cOpeBbn().set(fwk094().regFwk094Pghq524a().fwk094CParmPedHstMin().get(1, 5));
        wsTsInicio().wsDataInicio().set(fwk094().regFwk094Pghq524a().fwk094ZInicMov());
        wsTsMovInicio.set(wsTsInicio());
        wsTsFim().wsDataFim().set(fwk094().regFwk094Pghq524a().fwk094ZFimMov());
        wsTsMovFim.set(wsTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv10201Movhstcpl().openPghq524a714(wsTsMovFim, wsTsMovInicio) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - CURSOR C1   - OPEN - ");
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
        hv10201Movhstcpl().fetchPghq524a743() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - FETCH C1- VGH10201 - ");
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
        /**
         * END-IF
         */
        if (progOk.isTrue()) {
            /**
             * IF VGH00201-I-ESTORNO = SPACES
             */
            a31320EscreverFgh507() ;
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
        hv00201Movhst().selectPghq524a803(hv10201Movhstcpl().movhstcpl()) ;
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - SELECT  - VGH00201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320EscreverFgh507() {
        log(TraceLevel.Debug, "A31320-ESCREVER-FGH507");
        fgh507().regFgh507().initialize() ;
        fgh507().regFgh507().fgh507Subconta().fgh507CPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        fgh507().regFgh507().fgh507Subconta().fgh507CBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        fgh507().regFgh507().fgh507Subconta().fgh507COeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        fgh507().regFgh507().fgh507Subconta().fgh507NsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        fgh507().regFgh507().fgh507Subconta().fgh507VChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        fgh507().regFgh507().fgh507Subconta().fgh507CTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        fgh507().regFgh507().fgh507Subconta().fgh507CMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
        fgh507().regFgh507().fgh507Subconta().fgh507NsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
        fgh507().regFgh507().fgh507NsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
        fgh507().regFgh507().fgh507ZMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fgh507().regFgh507().fgh507ZValMov().set(hv00201Movhst().movhst().zValMov());
        fgh507().regFgh507().fgh507IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fgh507().regFgh507().fgh507MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fgh507().regFgh507().fgh507IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fgh507().regFgh507().fgh507CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fgh507().regFgh507().fgh507MSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        fgh507().regFgh507().fgh507MSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fgh507().regFgh507().fgh507MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fgh507().regFgh507().fgh507XRefMov().set(hv00201Movhst().movhst().xRefMov());
        if (fgh507().regFgh507().fgh507XRefMov().isEmpty()) {
            a31330ObtemDescricao() ;
        }
        fgh507().regFgh507().fgh507NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fgh507().regFgh507().fgh507AAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        fgh507().regFgh507().fgh507COpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        fgh507().regFgh507().fgh507COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fgh507().regFgh507().fgh507CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        fgh507().regFgh507().fgh507CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fgh507().regFgh507().fgh507CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fgh507().regFgh507().fgh507COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fgh507().write(fgh507().regFgh507()) ;
        if (fgh507().getStatusOk()) {
            contRegEscrtFgh507.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - FGH507 - WRITE   - ");
            tabelaImpressao().linha08().impStatus().set(fgh507().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31330ObtemDescricao() {
        log(TraceLevel.Debug, "A31330-OBTEM-DESCRICAO");
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
        hv10201Movhstcpl().closePghq524a947() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ524A - CURSOR C1 -CLOSE - ");
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
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk094().regFwk094Pghq524a().fwk094CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk094().regFwk094Pghq524a().fwk094CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk094().regFwk094Pghq524a().fwk094COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk094().regFwk094Pghq524a().fwk094NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk094().regFwk094Pghq524a().fwk094VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk094().regFwk094Pghq524a().fwk094CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk094().regFwk094Pghq524a().fwk094CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk094().regFwk094Pghq524a().fwk094NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk094().regFwk094Pghq524a().fwk094CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk094().regFwk094Pghq524a().fwk094ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk094().regFwk094Pghq524a().fwk094ZFimMov());
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
        hv01501Pedmovhst().updatePghq524a1003() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("- UPDATE VGH01501 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
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
            while (!fwk094().getStatusOk() && progOk.isTrue()) {
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
            
            @Data(size=8, value="PGHQ524A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ524A")
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
