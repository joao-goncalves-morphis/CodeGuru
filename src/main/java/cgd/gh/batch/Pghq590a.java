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
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : TRATAMENTO DO PEDIDO GH00102
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq590a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    
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
     * @return instancia da classe Fgh871
     */
    @Handler(name="FGH871", record="fgh871Registo")
    @Data
    protected abstract Fgh871 fgh871() ;
    
    /**
     * @return instancia da classe Fwk59001
     */
    @Handler(name="FWK590", record="regFwk590")
    @Data
    protected abstract Fwk59001 fwk590() ;
    
    
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
    
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    @Data(size=10, signed=true, value="0")
    protected ILong wSqlcode ;
    
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
     * @return instancia da classe local DataNumMask
     */
    @Data
    @Mask
    protected abstract DataNumMask dataNumMask() ;
    
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
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsConta
     */
    @Data
    protected abstract WsConta wsConta() ;
    
    /**
     * @return instancia da classe local WsChave
     */
    @Data
    protected abstract WsChave wsChave() ;
    
    @Data(size=6, value="MGH871")
    protected IString wsMapa ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFgh871 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk590 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorFich ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDestino ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorHeader ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDetalhe ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorTotais ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ590A");
        progStatus.set(0);
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
        wTimestamp().wDataTimestamp().wAnoAa().set(dataNumMask().anoNum());
        wTimerN().wHhN().set(wTimestamp().wTimerTimestamp().wHh());
        wTimerN().wMmN().set(wTimestamp().wTimerTimestamp().wMm());
        wTimerN().wSsN().set(wTimestamp().wTimerTimestamp().wSs());
        wTimerN().wDdN().set(wTimestamp().wTimerTimestamp().wDd());
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsChaveAnt().initialize() ;
        wsChave().initialize() ;
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFgh871() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk590() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk590() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A10000-ABRIR-FGH300");
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
    protected void a13000AbrirFgh871() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH871");
        fgh871().open(CREATE ) ;
        if (!fgh871().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ590A - FGH871 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh871().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk590() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK590");
        fwk590().open() ;
        if (!fwk590().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ590A - FWK590 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk590().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk590() {
        log(TraceLevel.Debug, "A15000-LER-FWK590");
        wsChaveAnt().set(wsChave());
        fwk590().read() ;
        if (fwk590().getStatusOk()) {
            contRegLidosFwk590.add(1);
            wsChave().chaveTsPedido().set(fwk590().regFwk590().fwk590Pedido().fwk590TsPedido());
            wsChave().chaveCPedInfOpps().set(fwk590().regFwk590().fwk590Pedido().fwk590CPedInfOpps());
            wsChave().chaveZInicMov().set(fwk590().regFwk590().fwk590Pedido().fwk590ZInicMov());
            wsChave().chaveZFimMov().set(fwk590().regFwk590().fwk590Pedido().fwk590ZFimMov());
            wsChave().chaveCPaisIsoaDest().set(fwk590().regFwk590().fwk590Destino().fwk590CPaisIsoaDest());
            wsChave().chaveCMnemEgcDest().set(fwk590().regFwk590().fwk590Destino().fwk590CMnemEgcDest());
            wsChave().chaveCOePed().set(fwk590().regFwk590().fwk590Destino().fwk590COeEgcDest());
        }
        if (!fwk590().getStatusOk() && !fwk590().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK590 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk590().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (!fwk590().regFwk590().fwk590FicheiroFgh871().fwk590IDbcr().isEqual("X")) {
            a31100Detalhe() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk590() ;
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                fgh871().fgh871Registo().initialize() ;
                a31300Totais() ;
                a31500ActPedido() ;
                if (wsChave().chaveTsPedido().isGreater(0)) {
                    a31700Header() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31130MoverDetalhe() {
        /**
         * *----------------------------------------------------------------*
         */
        wsContadorDetalhe.add(1);
        wsContadorFich.add(1);
        fgh871().fgh871Registo().fgh871Detalhe().fgh871CMapaR2().set(wsMapa);
        fgh871().fgh871Registo().fgh871Detalhe().fgh871CTipoRegR2().set("R2");
        fgh871().fgh871Registo().fgh871Detalhe().fgh871ZMapaR2().set(wTimestamp().wDataTimestamp());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871HMapaR2().set(wTimerN());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871CIdioIsoR2().set("POR");
        fgh871().fgh871Registo().fgh871Detalhe().fgh871NsRegFichR2().set(wsContadorFich);
        fgh871().fgh871Registo().fgh871Detalhe().fgh871NIdRegDestR2().set(wsContadorDestino);
        fgh871().fgh871Registo().fgh871Detalhe().fgh871NIdRegCabcR2().set(wsContadorHeader);
        fgh871().fgh871Registo().fgh871Detalhe().fgh871NsRegDtlhCabR2().set(wsContadorDetalhe);
        fgh871().fgh871Registo().fgh871Detalhe().fgh871ZMovimentoR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590ZMovimento());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871DDescR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590DDesc());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871MMovimentoR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590MMovimento());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871SinalMovR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590SinalMov());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871IDbcrR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590IDbcr());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871IEstornoR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590IEstorno());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871MSldoCbloR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590MSldoCblo());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871SinalSldR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590SinalSld());
        /**
         * MOVE FWK590-M-SLDO-DPNL    TO FGH871-M-SLDO-DPNL-R2
         * MOVE FWK590-SINAL-DPNL     TO FGH871-SINAL-DPNL-R2
         */
        fgh871().fgh871Registo().fgh871Detalhe().fgh871ZValorR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590ZValor());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871NDocOppsR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590NDocOpps());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871MMovMoeOrigR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590MMovMoeOrig());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871SinalMovOrgR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590SinalMovOrg());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871CMoedIsoOrgR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CMoedIsoOrg());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871AAplR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590AApl());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871NsMovimentoR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590NsMovimento());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871CTerminalR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CTerminal());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871CTipoCanlAcesR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CTipoCanlAces());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871COeEgcOpexR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590COeEgcOpex());
        fgh871().fgh871Registo().fgh871Detalhe().fgh871COperadorR2().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590COperador());
    }
    
    /**
     * 
     * 
     */
    protected void a31700Header() {
        log(TraceLevel.Debug, "A31700-HEADER");
        a31730SelectTgh0015() ;
        fgh871().fgh871Registo().initialize() ;
        a31730TrataDescricoes() ;
        wsContadorHeader.add(1);
        wsContadorDestino.add(1);
        wsContadorFich.add(1);
        wsContadorDetalhe.set(0);
        fgh871().fgh871Registo().fgh871Header().fgh871CMapaR1().set(wsMapa);
        fgh871().fgh871Registo().fgh871Header().fgh871CTipoRegR1().set("R1");
        fgh871().fgh871Registo().fgh871Header().fgh871ZMapaR1().set(wTimestamp().wDataTimestamp());
        fgh871().fgh871Registo().fgh871Header().fgh871HMapaR1().set(wTimerN());
        fgh871().fgh871Registo().fgh871Header().fgh871CIdioIsoR1().set("POR");
        fgh871().fgh871Registo().fgh871Header().fgh871NsRegFichR1().set(wsContadorFich);
        fgh871().fgh871Registo().fgh871Header().fgh871NIdRegDestR1().set(wsContadorDestino);
        fgh871().fgh871Registo().fgh871Header().fgh871NIdRegCabcR1().set(wsContadorHeader);
        fgh871().fgh871Registo().fgh871Header().fgh871CPaisIsoContR1().set(fwk590().regFwk590().fwk590Destino().fwk590CPaisIsoaDest());
        fgh871().fgh871Registo().fgh871Header().fgh871CBancContR1().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CBancCont());
        fgh871().fgh871Registo().fgh871Header().fgh871CBancContR1().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CBancCont());
        fgh871().fgh871Registo().fgh871Header().fgh871COeEgcContR1().set(wsChave().chaveCOePed());
        fgh871().fgh871Registo().fgh871Header().fgh871ZInicPesqR1().set(hv01501Pedmovhst().pedmovhst().zInicMov());
        fgh871().fgh871Registo().fgh871Header().fgh871ZFimPesqR1().set(hv01501Pedmovhst().pedmovhst().zFimMov());
        fgh871().fgh871Registo().fgh871Header().fgh871SubcontaR1().fgh871CPaisContR1().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
        fgh871().fgh871Registo().fgh871Header().fgh871SubcontaR1().fgh871CBancR1().set(hv01501Pedmovhst().pedmovhst().cBancCont());
        wsConta().contaCOeEgcCont().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590COeEgcCont());
        wsConta().contaNsRdclCont().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590NsRdclCont());
        wsConta().contaVChkdCont().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590VChkdCont());
        wsConta().contaCTipoCont().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CTipoCont());
        fgh871().fgh871Registo().fgh871Header().fgh871SubcontaR1().fgh871ContaR1().set(wsConta());
        fgh871().fgh871Registo().fgh871Header().fgh871SubcontaR1().fgh871NsDepositoR1().set(hv01501Pedmovhst().pedmovhst().nsDeposito());
        fgh871().fgh871Registo().fgh871Header().fgh871SubcontaR1().fgh871CMoedIsoSctaR1().set(fwk590().regFwk590().fwk590FicheiroFgh871().fwk590CMoedIsoScta());
        s10000WriteFgh871() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31730SelectTgh0015() {
        log(TraceLevel.Debug, "A31730-SELECT-TGH0015");
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(wsChave().chaveCPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsChave().chaveZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsChave().chaveZFimMov());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsChave().chaveTsPedido());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().selectPghq590a585() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            progOk.setTrue() ;
        } else {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ590A - SELECT  - VGH01501 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300Totais() {
        log(TraceLevel.Debug, "A31300-TOTAIS");
        fgh871().fgh871Registo().initialize() ;
        wsContadorTotais.add(1);
        wsContadorFich.add(1);
        fgh871().fgh871Registo().fgh871Totais().fgh871CMapaR3().set(wsMapa);
        fgh871().fgh871Registo().fgh871Totais().fgh871CTipoRegR3().set("R3");
        fgh871().fgh871Registo().fgh871Totais().fgh871ZMapaR3().set(wTimestamp().wDataTimestamp());
        fgh871().fgh871Registo().fgh871Totais().fgh871HMapaR3().set(wTimerN());
        fgh871().fgh871Registo().fgh871Totais().fgh871CIdioIsoR3().set("POR");
        fgh871().fgh871Registo().fgh871Totais().fgh871NsRegFichR3().set(wsContadorFich);
        fgh871().fgh871Registo().fgh871Totais().fgh871NIdRegDestR3().set(wsContadorDestino);
        fgh871().fgh871Registo().fgh871Totais().fgh871NIdRegCabcR3().set(wsContadorHeader);
        fgh871().fgh871Registo().fgh871Totais().fgh871TotalMovimentsR3().set(wsContadorDetalhe);
        fgh871().fgh871Registo().fgh871Totais().fgh871NIdRegTotR3().set(wsContadorTotais);
        wsContadorDetalhe.set(0);
        s10000WriteFgh871() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31100Detalhe() {
        log(TraceLevel.Debug, "A31100-DETALHE");
        fgh871().fgh871Registo().initialize() ;
        a31130MoverDetalhe() ;
        s10000WriteFgh871() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31500ActPedido() {
        log(TraceLevel.Debug, "A31500-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(wsChaveAnt().antCPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsChaveAnt().antZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsChaveAnt().antZFimMov());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsChaveAnt().antTsPedido());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq590a688() ;
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
    protected void a31730TrataDescricoes() {
        log(TraceLevel.Debug, "A39300-TRATA-DESCRICOES");
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("910");
        bhgl030a().commarea().dadosInput().cCodigo().set(fwk590().regFwk590().fwk590Destino().fwk590CPaisIsoaDest());
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh871().fgh871Registo().fgh871Header().fgh871DPaisIsoContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh871().fgh871Registo().fgh871Header().fgh871DPaisIsoContR1().set(" ");
        }
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("983");
        bhgl030a().commarea().dadosInput().cCodigo().get(1, 3).set(fwk590().regFwk590().fwk590Destino().fwk590CPaisIsoaDest()) ;
        bhgl030a().commarea().dadosInput().cCodigo().get(4, 4).set("35") ;
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh871().fgh871Registo().fgh871Header().fgh871DBancContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh871().fgh871Registo().fgh871Header().fgh871DBancContR1().set(" ");
        }
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(fwk590().regFwk590().fwk590Destino().fwk590CPaisIsoaDest());
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(fwk590().regFwk590().fwk590Destino().fwk590CMnemEgcDest());
        bhgl004a().commarea().dadosInput().cOeEgc().set(wsChave().chaveCOePed());
        bhgp0004RotDadosOe() ;
        if (bhgl004a().commarea().dadosOutput().semErros().isTrue()) {
            fgh871().fgh871Registo().fgh871Header().fgh871DOeEgcContR1().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
        } else {
            fgh871().fgh871Registo().fgh871Header().fgh871DOeEgcContR1().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000WriteFgh871() {
        log(TraceLevel.Debug, "S10000-WRITE-FGH871");
        fgh871().write(fgh871().fgh871Registo()) ;
        if (fgh871().getStatusOk()) {
            contRegEscrtFgh871.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ590A - FGH871 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh871().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FWK590");
            tabelaImpressao().linha05().impRegLidosFwk590().set(contRegLidosFwk590);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FGH871");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh871);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ590A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk590().close() ;
        fgh871().close() ;
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
        if (fwk590().getStatusOk()) {
            if (progOk.isTrue()) {
                a31700Header() ;
                while (!fwk590().getStatusOk() && progOk.isTrue()) {
                    s30000Processar() ;
                }
            }
            if (progOk.isTrue()) {
                a31300Totais() ;
            }
            if (progOk.isTrue()) {
                a31500ActPedido() ;
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
    public interface DataNumMask extends IDataMask {
        
        @Data(size=4)
        IInt anoNum() ;
        
        @Data(size=2)
        IInt mesNum() ;
        
        @Data(size=2)
        IInt diaNum() ;
        
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
    public interface WsChaveAnt extends IDataStruct {
        
        @Data(size=7)
        IString antCPedInfOpps() ;
        
        @Data(size=10)
        IString antZInicMov() ;
        
        @Data(size=10)
        IString antZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong antTsPedido() ;
        
        @Data(size=3)
        IString antCPaisIsoaDest() ;
        
        @Data(size=3)
        IString antCMnemEgcDest() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt antCOePed() ;
        
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
    public interface WsChave extends IDataStruct {
        
        @Data(size=7)
        IString chaveCPedInfOpps() ;
        
        @Data(size=10)
        IString chaveZInicMov() ;
        
        @Data(size=10)
        IString chaveZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong chaveTsPedido() ;
        
        @Data(size=3)
        IString chaveCPaisIsoaDest() ;
        
        @Data(size=3)
        IString chaveCMnemEgcDest() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt chaveCOePed() ;
        
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
            
            @Data(size=8, value="PGHQ590A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ590A")
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
            IFormattedString impRegLidosFwk590() ;
            
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
