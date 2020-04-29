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
import cgd.hj.routines.Mhjj011a ;


/**
 * 
 * INPUT1 - FICHEIRO DOS CONTAS RECEBIDA DA APLICACAO HO
 * FWK502 - FICHEIRO DOS MOVIMENTOS DAS CONTAS INDICADAS EM FWK050
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : DEVOLVE OS MOVIMENTOS DAS CONTA INDICADAS NO
 * INPUT PARA O INTERVALO DE DATAS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq502a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
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
     * @return instancia da classe Fwk051
     */
    @Handler(name="INPUT1", record="regFwk050")
    @Data
    protected abstract Fwk051 input1() ;
    
    /**
     * @return instancia da classe Fwk502
     */
    @Handler(name="FWK502", record="rwk50201")
    @Data
    protected abstract Fwk502 fwk502() ;
    
    
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
     * @return instancia da classe Mhjj011a
     */
    @Data
    protected abstract Mhjj011a hrMhjj011a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
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
    
    
    @Data(size=8, value="MGHJ801A")
    protected IString wsMghj801a ;
    
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
    protected IString wsTsMovInicio ;
    
    @Data(size=26)
    protected IString wsTsMovFim ;
    
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
     * HD-2390606 - FIM
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosInput1 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk502 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ502A");
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
            a13000AbrirFwk502() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirInput1() ;
        }
        if (progOk.isTrue()) {
            a15000LerInput1() ;
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
    protected void a13000AbrirFwk502() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK502");
        fwk502().open(CREATE ) ;
        if (!fwk502().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - FWK502 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk502().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirInput1() {
        log(TraceLevel.Debug, "A14000-ABRIR-INPUT1");
        input1().open() ;
        if (!input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - INPUT1 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerInput1() {
        log(TraceLevel.Debug, "A15000-LER-INPUT1");
        input1().read() ;
        if (input1().getStatusOk()) {
            contRegLidosInput1.add(1);
            wsTsInicio().wsDataInicio().set(input1().regFwk050().fwk050ZIniMov());
            wsTsMovInicio.set(wsTsInicio());
            wsTsFim().wsDataFim().set(input1().regFwk050().fwk050ZFimMov());
            wsTsMovFim.set(wsTsFim());
        }
        if (!input1().getStatusOk() && !input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - INPUT1 - READ - ");
            tabelaImpressao().linha09().impStatus().set(input1().getStatus());
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
            a15000LerInput1() ;
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
            tabelaImpressao().linha05().impFichRead().set("INPUT1");
            tabelaImpressao().linha05().impRegLidosInput1().set(contRegLidosInput1);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK502");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk502);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ502A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        input1().close() ;
        fwk502().close() ;
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
            while (!progNaoExiste.isTrue() && progOk.isTrue()) {
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
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(input1().regFwk050().fwk050Subconta().fwk050Conta().fwk050CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(input1().regFwk050().fwk050Subconta().fwk050Conta().fwk050CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(input1().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(input1().regFwk050().fwk050Subconta().fwk050Conta().fwk050NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(input1().regFwk050().fwk050Subconta().fwk050Conta().fwk050VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(input1().regFwk050().fwk050Subconta().fwk050Conta().fwk050CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(input1().regFwk050().fwk050Subconta().fwk050CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(input1().regFwk050().fwk050Subconta().fwk050NsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00201Movhst().openPghq502a595(wsTsMovFim, wsTsMovInicio) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
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
        hv00201Movhst().fetchPghq502a624() ;
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - FETCH C1- VGH00201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarMovimentos() {
        log(TraceLevel.Debug, "A31300-TRATAR-MOVIMENTOS");
        fwk502().rwk50201().initialize() ;
        fwk502().rwk50201().fwk502Subconta().fwk502CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk502().rwk50201().fwk502Subconta().fwk502CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk502().rwk50201().fwk502Subconta().fwk502COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk502().rwk50201().fwk502Subconta().fwk502NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk502().rwk50201().fwk502Subconta().fwk502VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk502().rwk50201().fwk502Subconta().fwk502CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk502().rwk50201().fwk502Subconta().fwk502CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk502().rwk50201().fwk502Subconta().fwk502NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk502().rwk50201().fwk502ZMovimento().set(hv00201Movhst().movhst().tsMovimento().get(1, 10));
        fwk502().rwk50201().fwk502NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk502().rwk50201().fwk502ZValMov().set(hv00201Movhst().movhst().zValMov());
        fwk502().rwk50201().fwk502IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk502().rwk50201().fwk502MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk502().rwk50201().fwk502IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk502().rwk50201().fwk502CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk502().rwk50201().fwk502MSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        fwk502().rwk50201().fwk502MSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk502().rwk50201().fwk502MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk502().rwk50201().fwk502XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk502().rwk50201().fwk502NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk502().rwk50201().fwk502AAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        a31310AcederMovHstCmpl() ;
        if (progOk.isTrue()) {
            fwk502().rwk50201().fwk502COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
            fwk502().rwk50201().fwk502COpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
            fwk502().rwk50201().fwk502CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
            fwk502().rwk50201().fwk502CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
            fwk502().rwk50201().fwk502CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
            fwk502().rwk50201().fwk502CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
            fwk502().rwk50201().fwk502COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
            fwk502().rwk50201().fwk502TCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
            fwk502().rwk50201().fwk502ChvFicheiro().set(input1().regFwk050().fwk050ChvFicheiro());
            if (fwk502().rwk50201().fwk502XRefMov().isEmpty()) {
                a31320ObtemDescricao() ;
            }
        }
        if (progOk.isTrue()) {
            a31330EscreverFwk502() ;
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AcederMovHstCmpl() {
        log(TraceLevel.Debug, "A31310-ACEDER-MOV-HST-CMPL");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq502a741(hv00201Movhst().movhst()) ;
        wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - SELECT  - VGH10201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a31400CloseCursorC1() ;
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
        hrMhjj011a().bhjl011a().commarea().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(fwk502().rwk50201().fwk502Subconta().fwk502CPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(fwk502().rwk50201().fwk502Subconta().fwk502CBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(fwk502().rwk50201().fwk502Subconta().fwk502COeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(fwk502().rwk50201().fwk502Subconta().fwk502NsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(fwk502().rwk50201().fwk502Subconta().fwk502VChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(fwk502().rwk50201().fwk502Subconta().fwk502CTipoCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().set(input1().regFwk050().fwk050Subconta().fwk050Conta());
        if (fwk502().rwk50201().fwk502IEstorno().isEqual("E")) {
            if (fwk502().rwk50201().fwk502IDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
                hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
                hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(fwk502().rwk50201().fwk502IDbcr());
            hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set(fwk502().rwk50201().fwk502IDbcr());
        }
        if (fwk502().rwk50201().fwk502Subconta().fwk502CPaisIsoaCont().isEqual("PT ")) {
            hrMhoj727a().bhol727a().commarea().dadosInput().cIdioIso().set("POR");
        } else {
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().cPaisIsoaCont().set(fwk502().rwk50201().fwk502Subconta().fwk502CPaisIsoaCont());
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().cBancCont().set(fwk502().rwk50201().fwk502Subconta().fwk502CBancCont());
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().cOeEgcCont().set(fwk502().rwk50201().fwk502Subconta().fwk502COeEgcCont());
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().nsRdclCont().set(fwk502().rwk50201().fwk502Subconta().fwk502NsRdclCont());
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().vChkdCont().set(fwk502().rwk50201().fwk502Subconta().fwk502VChkdCont());
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().cTipoCont().set(fwk502().rwk50201().fwk502Subconta().fwk502CTipoCont());
            hrMhjj011a().bhjl011a().commarea().dadosEntrada().cIdioIsoIn().set(" ");
            hrMhjj011a().run() ;
            if (hrMhjj011a().bhjl011a().commarea().erros().semErros().isTrue()) {
                hrMhoj727a().bhol727a().commarea().dadosInput().cIdioIso().set(hrMhjj011a().bhjl011a().commarea().dadosSaida().cIdioIso());
            } else {
                log(TraceLevel.Error, "BHJL011A-C-RTNO-EVEN-SWAL -", hrMhjj011a().bhjl011a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, "BHJL011A-C-TIPO-ERRO-BBN -", hrMhjj011a().bhjl011a().commarea().erros().cTipoErroBbn());
            }
        }
        hrMhoj727a().bhol727a().commarea().dadosInput().cOeEgc().set(fwk502().rwk50201().fwk502COeEgcOpex());
        hrMhoj727a().bhol727a().commarea().dadosInput().zValor().set(fwk502().rwk50201().fwk502ZValMov());
        hrMhoj727a().bhol727a().commarea().dadosInput().nCheque().set(fwk502().rwk50201().fwk502NDocOpps());
        hrMhoj727a().bhol727a().commarea().dadosInput().xRefMov().set(fwk502().rwk50201().fwk502XRefMov());
        hrMhoj727a().bhol727a().commarea().dadosInput().cOpeBbn().set(fwk502().rwk50201().fwk502COpeBbn());
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
            fwk502().rwk50201().fwk502XRefMov().set(hrMhoj727a().bhol727a().commarea().dadosOutput().dMovimento());
        } else {
            fwk502().rwk50201().fwk502XRefMov().set(" ");
            log(TraceLevel.Error, "BHOL727A-C-RTNO-EVEN-SWAL -", hrMhoj727a().bhol727a().commarea().dadosErro().cRtnoEvenSwal());
            log(TraceLevel.Error, "BHOL727A-C-TIPO-ERRO-BBN -", hrMhoj727a().bhol727a().commarea().dadosErro().cTipoErroBbn());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31330EscreverFwk502() {
        log(TraceLevel.Debug, "A31330-ESCREVER-FWK502");
        fwk502().rwk50201().fwk502GrFicheiro().resetIndex() ;
        for (input1().regFwk050().fwk050GrFicheiro().setIndex(1); input1().regFwk050().fwk050GrFicheiro().index().isLessOrEqual(3); input1().regFwk050().fwk050GrFicheiro().incIndex()) {
            fwk502().rwk50201().fwk502GrFicheiro().getCurrent().fwk502NmFicheiro().set(input1().regFwk050().fwk050GrFicheiro().getCurrent().fwk050NmFicheiro());
            fwk502().rwk50201().fwk502GrFicheiro().incIndex() ;
        }
        fwk502().write(fwk502().rwk50201()) ;
        if (fwk502().getStatusOk()) {
            contRegEscrtFwk502.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - FWK502 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk502().getStatus());
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
        hv00201Movhst().closePghq502a839() ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
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
         * *----------------------------------------------------------------*
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
            
            /**
             * HD-2390606 - ISTO NAO PODE SER ZEROS SENAO NAO DEVOLVE OS MOV.
             * DAS 29.59.59.000000 ATE AS 29.59.59.999999
             * 10 W-DD-FIM             PIC 9(06)  VALUE ZEROS.
             */
            @Data(size=6, value="999999", lpadding=1, lpaddingValue=".")
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
         * @return instancia da classe local Linha0602
         */
        @Data
        Linha0602 linha0602() ;
        
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
            
            @Data(size=8, value="PGHQ502A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ502A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosInput1() ;
            
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
        
        public interface Linha0602 extends IDataStruct {
            
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
