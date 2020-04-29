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
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * PRC19 - FIM
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : ELABORAR O MAPA MGH0874 - MOVIMENTOS POR
 * OPERADOR
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq206a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps01601Oeatrdped
     */
    @Data
    protected abstract Vwsdghps01601Oeatrdped hv01601Oeatrdped() ;
    
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
     * @return instancia da classe Fgh874
     */
    @Handler(name="FGH874", record="fgh874Registo")
    @Data
    protected abstract Fgh874 fgh874() ;
    
    /**
     * @return instancia da classe Fwk815
     */
    @Handler(name="FWK815", record="regFwk815Pghq206a")
    @Data
    protected abstract Fwk815 fwk815() ;
    
    
    /**
     * Handled Routines
     */
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
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    @Data(size=6, value="MGH874")
    protected IString wsMapa ;
    
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
     * @return instancia da classe local WTimerN
     */
    @Data
    protected abstract WTimerN wTimerN() ;
    
    @Data(size=26)
    protected IString wsTsMovimentoMax ;
    
    @Data(size=26)
    protected IString wsTsMovimentoMin ;
    
    @Data(size=15)
    protected ILong wsTsPedido ;
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHK800A")
    protected IString wsDescritivos ;
    
    /**
     * @return instancia da classe local WsConta
     */
    @Data
    protected abstract WsConta wsConta() ;
    
    /**
     * @return instancia da classe local WsMensagem
     */
    @Data
    protected abstract WsMensagem wsMensagem() ;
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * CONTADORES
     * @return instancia da classe local WsContadores
     */
    @Data
    protected abstract WsContadores wsContadores() ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosTgh016 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh874 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ206A");
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
        wTimerN().wHhN().set(wTimestamp().wTimerTimestamp().wHh());
        wTimerN().wMmN().set(wTimestamp().wTimerTimestamp().wMm());
        wTimerN().wSsN().set(wTimestamp().wTimerTimestamp().wSs());
        wTimerN().wDdN().set(wTimestamp().wTimerTimestamp().wDd());
        if (progOk.isTrue()) {
            a13000AbrirFgh874() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk815() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk815() ;
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
    protected void a13000AbrirFgh874() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH874");
        fgh874().open(CREATE ) ;
        if (!fgh874().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - FGH874 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fgh874().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk815() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK815");
        fwk815().open() ;
        if (!fwk815().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - FWK815 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fwk815().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk815() {
        log(TraceLevel.Debug, "A15000-LER-FWK815");
        fwk815().read() ;
        if (fwk815().getStatusOk()) {
            wsContadores().wsContadorPedidos().add(1);
        }
        if (!fwk815().getStatusOk() && !fwk815().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - FWK815 - READ - ");
            tabelaImpressao().linha08().impStatus().set(fwk815().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Pedidos() {
        log(TraceLevel.Debug, "S30000-PEDIDOS");
        if (progOk.isTrue()) {
            a32000TrataPedidoOe() ;
        }
        if (progOk.isTrue()) {
            a35800ActualizaPedido() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk815() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000TrataPedidoOe() {
        log(TraceLevel.Debug, "A32000-TRATA-PEDIDO-OE");
        /**
         * DISPLAY 'PEDIDO : 'FWK815-TS-PEDIDO
         */
        a32100AbrirC1() ;
        if (progOk.isTrue()) {
            a32200FetchC1() ;
        }
        if (getPersistenceCode() == PersistenceCode.NOTFND) {
            wSqlcode.set(getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PED.INEXISTENTE VGH01601-");
            /**
             * MOVE FWK815-TS-PEDIDO         TO WS-TS-PEDIDO
             */
            wsTsPedido.set(fwk815().regFwk815Pghq206a().fwk815TsPedido());
            tabelaImpressao().linha08().msgStatus().get(26, 15).set(wsTsPedido) ;
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue() && !progNaoExiste.isTrue()) {
                a35000Movimentos() ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a32600CloseC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100AbrirC1() {
        log(TraceLevel.Debug, "A32100-ABRIR-C1");
        wSqlcode.initialize() ;
        hv01601Oeatrdped().oeatrdped().initialize() ;
        /**
         * MOVE FWK815-TS-PEDIDO            TO VGH01601-TS-PEDIDO
         */
        hv01601Oeatrdped().oeatrdped().tsPedido().set(fwk815().regFwk815Pghq206a().fwk815TsPedido());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01601Oeatrdped().openPghq206a624() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32200FetchC1() {
        log(TraceLevel.Debug, "A32200-FETCH-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv01601Oeatrdped().fetchPghq206a650() ;
        switch (hv01601Oeatrdped().getPersistenceCode()) {
            case NORMAL:
                contRegLidosTgh016.add(1);
                break;
            case NOTFND:
                progNaoExiste.setTrue() ;
                break;
            default :
                wSqlcode.set(getPersistenceCode());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha08().msgStatus().set("PGHQ206A - FETCH C1- VGH01601 - ");
                tabelaImpressao().linha08().impStatus().set(wSqlcode);
                break;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32600CloseC1() {
        log(TraceLevel.Debug, "A32600-CLOSE-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv01601Oeatrdped().closePghq206a681() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000Movimentos() {
        log(TraceLevel.Debug, "A35000-MOVIMENTOS");
        if (progOk.isTrue()) {
            a35100AbrirC3() ;
        }
        if (progOk.isTrue()) {
            a35200FetchC3() ;
        }
        if (progOk.isTrue()) {
            a39000Header() ;
            if (progOk.isTrue()) {
                while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue() && !progNaoExiste.isTrue()) {
                    a35500ProcessaMapa() ;
                }
            }
            if (progNaoExiste.isTrue()) {
                a35700Totais() ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a35600CloseC3() ;
        }
        if (progOk.isTrue()) {
            a32200FetchC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35100AbrirC3() {
        log(TraceLevel.Debug, "A35100-ABRIR-C3");
        wSqlcode.initialize() ;
        hv00201Movhst().movhst().initialize() ;
        /**
         * PRC19 - INI
         * MOVE FWK815-C-PAIS-ISOA-CONT     TO VGH10201-C-PAIS-ISOA-CONT
         * MOVE FWK815-C-BANC-CONT          TO VGH10201-C-BANC-CONT
         * MOVE FWK815-C-OE-EGC-OPEX        TO VGH10201-C-OE-EGC-OPEX
         * MOVE FWK815-Z-INIC-MOV           TO WS-TS-MOVIMENTO-MIN(1:10)
         * MOVE '-00.00.00.000000'         TO WS-TS-MOVIMENTO-MIN(11:16)
         * MOVE FWK815-Z-FIM-MOV            TO WS-TS-MOVIMENTO-MAX(1:10)
         * MOVE '-23.59.59.000000'         TO WS-TS-MOVIMENTO-MAX(11:16)
         * MOVE FWK815-C-PARM-PED-HST-MIN(1:8) TO
         * VGH10201-C-USERID
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(fwk815().regFwk815Pghq206a().fwk815CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(fwk815().regFwk815Pghq206a().fwk815CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(fwk815().regFwk815Pghq206a().fwk815COeEgcOpex());
        wsTsMovimentoMin.get(1, 10).set(fwk815().regFwk815Pghq206a().fwk815ZInicMov()) ;
        wsTsMovimentoMin.get(11, 16).set("-00.00.00.000000") ;
        wsTsMovimentoMax.get(1, 10).set(fwk815().regFwk815Pghq206a().fwk815ZFimMov()) ;
        wsTsMovimentoMax.get(11, 16).set("-23.59.59.000000") ;
        hv10201Movhstcpl().movhstcpl().cUserid().set(fwk815().regFwk815Pghq206a().fwk815CParmPedHstMin().get(1, 8));
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv10201Movhstcpl().openPghq206a770(wsTsMovimentoMax, wsTsMovimentoMin) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - CURSOR C3   - OPEN - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35200FetchC3() {
        log(TraceLevel.Debug, "A35200-FETCH-C3");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C3
         */
        hv10201Movhstcpl().fetchPghq206a796() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - FETCH C3- VGH10201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35500ProcessaMapa() {
        log(TraceLevel.Debug, "A35500-PROCESSA-MAPA");
        fgh874().fgh874Registo().initialize() ;
        a35530SelectTgh0002() ;
        if (progOk.isTrue()) {
            wsContadores().wsContadorDetalh().add(1);
            wsContadores().wsContadorFich().add(1);
            fgh874().fgh874Registo().fgh874Detalhe().fgh874CMapaR2().set(wsMapa);
            fgh874().fgh874Registo().fgh874Detalhe().fgh874CTipoRegR2().set("R2");
            fgh874().fgh874Registo().fgh874Detalhe().fgh874ZMapaR2().set(wTimestamp().wDataTimestamp());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874HMapaR2().set(wTimerN());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874CIdioIsoR2().set("POR");
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsRegFichR2().set(wsContadores().wsContadorFich());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NIdRegDestR2().set(wsContadores().wsContadorDestino());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NIdRegCabcR2().set(wsContadores().wsContadorHeader());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsRegDtlhCabR2().fgh874CPaisContR2().set(hv00201Movhst().movhst().cPaisIsoaCont());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsRegDtlhCabR2().fgh874CBancR2().set(hv00201Movhst().movhst().cBancCont());
            wsConta().contaCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
            wsConta().contaNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
            wsConta().contaVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
            wsConta().contaCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsRegDtlhCabR2().fgh874ContaR2().set(wsConta());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsRegDtlhCabR2().fgh874NsDepositoR2().set(hv00201Movhst().movhst().nsDeposito());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsRegDtlhCabR2().fgh874CMoedIsoSctaR2().set(hv00201Movhst().movhst().cMoedIsoScta());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874ZMovimentoR2().set(hv00201Movhst().movhst().zMovLocl());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874MMovimentoR2().set(hv00201Movhst().movhst().mMovimento());
            if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovR2().set(" ");
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovOrgR2().set(" ");
            } else {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovR2().set("-");
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovOrgR2().set("-");
            }
            if (hv00201Movhst().movhst().iDbcr().isEqual("C") && 
                hv00201Movhst().movhst().iEstorno().isEqual("E")) {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovR2().set("-");
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovOrgR2().set("-");
            }
            if (hv00201Movhst().movhst().iDbcr().isEqual("D") && 
                hv00201Movhst().movhst().iEstorno().isEqual("E")) {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovR2().set(" ");
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalMovOrgR2().set(" ");
            }
            fgh874().fgh874Registo().fgh874Detalhe().fgh874IDbcrR2().set(hv00201Movhst().movhst().iDbcr());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874IEstornoR2().set(hv00201Movhst().movhst().iEstorno());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874MSldoCbloR2().set(hv00201Movhst().movhst().mSldoCbloApos());
            if (hv00201Movhst().movhst().mSldoCbloApos().isGreaterOrEqual(0)) {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalSldR2().set(" ");
            } else {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874SinalSldR2().set("-");
            }
            fgh874().fgh874Registo().fgh874Detalhe().fgh874ZValorR2().set(hv00201Movhst().movhst().zValMov());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874MMovMoeOrigR2().set(hv00201Movhst().movhst().mMovMoeOrigMov());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874CMoedIsoOrgR2().set(hv00201Movhst().movhst().cMoedIsoOriMov());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NsMovimentoR2().set(hv00201Movhst().movhst().nsMovimento());
            if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
                hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
                a35550BuscaDescricao() ;
                fgh874().fgh874Registo().fgh874Detalhe().fgh874DDescR2().set(hrMghk800a().bghl800a().output().xRefMov());
            } else {
                fgh874().fgh874Registo().fgh874Detalhe().fgh874DDescR2().set(hv00201Movhst().movhst().xRefMov());
            }
            fgh874().fgh874Registo().fgh874Detalhe().fgh874NDocOppsR2().set(hv00201Movhst().movhst().nDocOpps());
            fgh874().fgh874Registo().fgh874Detalhe().fgh874COeEgcOpexR2().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
            s10000WriteMapa() ;
            if (progOk.isTrue()) {
                a35200FetchC3() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35530SelectTgh0002() {
        log(TraceLevel.Debug, "A35530-SELECT-TGH0002");
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq206a932(hv10201Movhstcpl().movhstcpl()) ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - SELECT  - VGH00201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35550BuscaDescricao() {
        log(TraceLevel.Debug, "A35550-BUSCA-DESCRICAO");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(hv00201Movhst().movhst().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        hrMghk800a().bghl800a().input().nsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        hrMghk800a().bghl800a().input().iDbcr().set(hv00201Movhst().movhst().iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(hv00201Movhst().movhst().iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(hv00201Movhst().movhst().zValMov());
        hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        hrMghk800a().bghl800a().input().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        hrMghk800a().bghl800a().input().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        hrMghk800a().run() ;
        if (!hrMghk800a().bghl800a().ok().isTrue()) {
            log(TraceLevel.Debug, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
            log(TraceLevel.Debug, "MGH800A-NM-PROGRAMA-", hrMghk800a().bghl800a().nmPrograma());
            log(TraceLevel.Debug, "MGH800A-C-SQLCODE-", hrMghk800a().bghl800a().cSqlcode());
            hrMghk800a().bghl800a().output().xRefMov().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35600CloseC3() {
        log(TraceLevel.Debug, "A35800-CLOSE-C3");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C3
         */
        hv10201Movhstcpl().closePghq206a1055() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - CURSOR C3 -CLOSE - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35800ActualizaPedido() {
        log(TraceLevel.Debug, "A35800-ACTUALIZA-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        /**
         * PRC19 - INI
         * MOVE FWK815-C-PAIS-ISOA-CONT     TO VGH01501-C-PAIS-ISOA-CONT
         * MOVE FWK815-C-BANC-CONT          TO VGH01501-C-BANC-CONT
         * MOVE FWK815-C-OE-EGC-CONT        TO VGH01501-C-OE-EGC-CONT
         * MOVE FWK815-NS-RDCL-CONT         TO VGH01501-NS-RDCL-CONT
         * MOVE FWK815-V-CHKD-CONT          TO VGH01501-V-CHKD-CONT
         * MOVE FWK815-C-TIPO-CONT          TO VGH01501-C-TIPO-CONT
         * MOVE FWK815-C-MOED-ISO-SCTA      TO VGH01501-C-MOED-ISO-SCTA
         * MOVE FWK815-NS-DEPOSITO          TO VGH01501-NS-DEPOSITO
         * MOVE FWK815-C-PED-INF-OPPS       TO VGH01501-C-PED-INF-OPPS
         * MOVE FWK815-Z-INIC-MOV           TO VGH01501-Z-INIC-MOV
         * MOVE FWK815-Z-FIM-MOV            TO VGH01501-Z-FIM-MOV
         */
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk815().regFwk815Pghq206a().fwk815CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk815().regFwk815Pghq206a().fwk815CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk815().regFwk815Pghq206a().fwk815COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk815().regFwk815Pghq206a().fwk815NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk815().regFwk815Pghq206a().fwk815VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk815().regFwk815Pghq206a().fwk815CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk815().regFwk815Pghq206a().fwk815CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk815().regFwk815Pghq206a().fwk815NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk815().regFwk815Pghq206a().fwk815CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk815().regFwk815Pghq206a().fwk815ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk815().regFwk815Pghq206a().fwk815ZFimMov());
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
        hv01501Pedmovhst().updatePghq206a1108() ;
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
    protected void a39000Header() {
        log(TraceLevel.Debug, "A39000-HEADER");
        fgh874().fgh874Registo().initialize() ;
        a39300TrataDescricoes() ;
        wsContadores().wsContadorHeader().add(1);
        wsContadores().wsContadorDestino().add(1);
        wsContadores().wsContadorFich().add(1);
        wsContadores().wsContadorDetalh().set(0);
        fgh874().fgh874Registo().fgh874Header().fgh874CMapaR1().set(wsMapa);
        fgh874().fgh874Registo().fgh874Header().fgh874CTipoRegR1().set("R1");
        fgh874().fgh874Registo().fgh874Header().fgh874ZMapaR1().set(wTimestamp().wDataTimestamp());
        fgh874().fgh874Registo().fgh874Header().fgh874HMapaR1().set(wTimerN());
        fgh874().fgh874Registo().fgh874Header().fgh874CIdioIsoR1().set("POR");
        fgh874().fgh874Registo().fgh874Header().fgh874NsRegFichR1().set(wsContadores().wsContadorFich());
        fgh874().fgh874Registo().fgh874Header().fgh874NIdRegDestR1().set(wsContadores().wsContadorDestino());
        fgh874().fgh874Registo().fgh874Header().fgh874COeEgcContR1().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
        fgh874().fgh874Registo().fgh874Header().fgh874NIdRegCabcR1().set(wsContadores().wsContadorHeader());
        /**
         * PRC19 - INI
         * MOVE FWK815-C-PAIS-ISOA-CONT
         * TO FGH874-C-PAIS-ISO-CONT-R1
         * MOVE FWK815-C-BANC-CONT
         * TO FGH874-C-BANC-CONT-R1
         * MOVE FWK815-C-PARM-PED-HST-MAX (1:8)
         * TO FGH874-C-OPERADOR-R1
         * MOVE FWK815-Z-INIC-MOV   TO FGH874-Z-INIC-MOV-R1
         * MOVE FWK815-Z-FIM-MOV    TO FGH874-Z-FIM-MOV-R1
         */
        fgh874().fgh874Registo().fgh874Header().fgh874CPaisIsoContR1().set(fwk815().regFwk815Pghq206a().fwk815CPaisIsoaCont());
        fgh874().fgh874Registo().fgh874Header().fgh874CBancContR1().set(fwk815().regFwk815Pghq206a().fwk815CBancCont());
        fgh874().fgh874Registo().fgh874Header().fgh874COperadorR1().set(fwk815().regFwk815Pghq206a().fwk815CParmPedHstMax().get(1, 8));
        fgh874().fgh874Registo().fgh874Header().fgh874ZInicMovR1().set(fwk815().regFwk815Pghq206a().fwk815ZInicMov());
        fgh874().fgh874Registo().fgh874Header().fgh874ZFimMovR1().set(fwk815().regFwk815Pghq206a().fwk815ZFimMov());
        /**
         * PRC19 - FIM
         */
        s10000WriteMapa() ;
    }
    
    /**
     * 
     * 
     */
    protected void a35700Totais() {
        log(TraceLevel.Debug, "A35700-TOTAIS");
        wsContadores().wsContadorTotais().add(1);
        wsContadores().wsContadorFich().add(1);
        fgh874().fgh874Registo().fgh874Totais().fgh874CMapaR3().set(wsMapa);
        fgh874().fgh874Registo().fgh874Totais().fgh874CTipoRegR3().set("R3");
        fgh874().fgh874Registo().fgh874Totais().fgh874ZMapaR3().set(wTimestamp().wDataTimestamp());
        fgh874().fgh874Registo().fgh874Totais().fgh874HMapaR3().set(wTimerN());
        fgh874().fgh874Registo().fgh874Totais().fgh874CIdioIsoR3().set("POR");
        fgh874().fgh874Registo().fgh874Totais().fgh874NsRegFichR3().set(wsContadores().wsContadorFich());
        fgh874().fgh874Registo().fgh874Totais().fgh874NIdRegDestR3().set(wsContadores().wsContadorDestino());
        fgh874().fgh874Registo().fgh874Totais().fgh874NIdRegCabcR3().set(wsContadores().wsContadorHeader());
        fgh874().fgh874Registo().fgh874Totais().fgh874TotalMovimentsR3().set(wsContadores().wsContadorDetalh());
        fgh874().fgh874Registo().fgh874Totais().fgh874NIdRegTotR3().set(wsContadores().wsContadorTotais());
        wsContadores().wsContadorDetalh().set(0);
        s10000WriteMapa() ;
    }
    
    /**
     * 
     * 
     */
    protected void s10000WriteMapa() {
        log(TraceLevel.Debug, "S10000-WRITE-MAPA");
        fgh874().write(fgh874().fgh874Registo()) ;
        if (fgh874().getStatusOk()) {
            fgh874().fgh874Registo().fgh874Dados().initialize() ;
            contRegEscrtFgh874.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ206A - FGH874 - READ - ");
            tabelaImpressao().linha08().impStatus().set(fgh874().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a39300TrataDescricoes() {
        log(TraceLevel.Debug, "A39300-TRATA-DESCRICOES");
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("910");
        bhgl030a().commarea().dadosInput().cCodigo().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh874().fgh874Registo().fgh874Header().fgh874DPaisIsoContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh874().fgh874Registo().fgh874Header().fgh874DPaisIsoContR1().set(" ");
        }
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("983");
        bhgl030a().commarea().dadosInput().cCodigo().get(1, 3).set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest()) ;
        bhgl030a().commarea().dadosInput().cCodigo().get(4, 4).set("35") ;
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh874().fgh874Registo().fgh874Header().fgh874DBancContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh874().fgh874Registo().fgh874Header().fgh874DBancContR1().set(" ");
        }
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(hv01601Oeatrdped().oeatrdped().cMnemEgcDest());
        bhgl004a().commarea().dadosInput().cOeEgc().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
        bhgp0004RotDadosOe() ;
        if (bhgl004a().commarea().dadosOutput().semErros().isTrue()) {
            fgh874().fgh874Registo().fgh874Header().fgh874DOeEgcContR1().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
        } else {
            fgh874().fgh874Registo().fgh874Header().fgh874DOeEgcContR1().set(" ");
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
            tabelaImpressao().linha06().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressaoMask().zimp().setIndex(9) ;
            wsMensagem().wsNumero().set(wsContadores().wsContadorPedidos());
            wsMensagem().wsTexto().set("PEDIDOS LIDOS TGH15");
            tabelaImpressao().linha09().msgLivre().set(wsMensagem());
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(9) ;
            wsMensagem().wsNumero().set(contRegLidosTgh016);
            wsMensagem().wsTexto().set("DESTINOS LIDOS TGH16");
            tabelaImpressao().linha09().msgLivre().set(wsMensagem());
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(9) ;
            wsMensagem().wsNumero().set(contRegEscrtFgh874);
            wsMensagem().wsTexto().set("REGISTOS ESCRITOS   ");
            tabelaImpressao().linha09().msgLivre().set(wsMensagem());
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha06().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha06().impReturnCode().set(returnCode);
            tabelaImpressao().linha07().impMens1().set("PGHQ206A - FIM ANORMAL ");
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
            while (fwk815().getStatusOk() && progOk.isTrue()) {
                s30000Pedidos() ;
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
    public interface WTimerN extends IDataStruct {
        
        @Data(size=2)
        IInt wHhN() ;
        
        @Data(size=2)
        IInt wMmN() ;
        
        @Data(size=2)
        IInt wSsN() ;
        
        @Data(size=6)
        IInt wDdN() ;
        
    }
    public interface WsConta extends IDataStruct {
        
        @Data(size=4)
        IInt contaCOeEgcCont() ;
        
        @Data(size=6)
        IInt contaNsRdclCont() ;
        
        @Data(size=1)
        IInt contaVChkdCont() ;
        
        @Data(size=2)
        IInt contaCTipoCont() ;
        
    }
    public interface WsMensagem extends IDataStruct {
        
        @Data(size=30)
        IString wsTexto() ;
        
        @Data(size=8)
        ILong wsNumero() ;
        
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
        ILong wsContadorFich() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorDestino() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorHeader() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorDetalh() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorTotais() ;
        
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
            
            @Data(size=8, value="PGHQ206A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ206A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=39, value=" ")
            IString filler002() ;
            
            @Data(size=66, value=" ")
            IString filler003() ;
            
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
