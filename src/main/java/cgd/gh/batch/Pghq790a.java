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
 * OBJECTIVO     : TRATAMENTO DO PEDIDO GH00XXX
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq790a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh873
     */
    @Handler(name="FGH873", record="fgh873Registo")
    @Data
    protected abstract Fgh873 fgh873() ;
    
    /**
     * @return instancia da classe Fwk790
     */
    @Handler(name="FWK790", record="regFwk790")
    @Data
    protected abstract Fwk790 fwk790() ;
    
    
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
    
    @Data(size=6, value="MGH873")
    protected IString wsMapa ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFgh873 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk790 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDestino ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorHeader ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDetalhe ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorTotais ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorFich ;
    
    @Data(size=1)
    protected IString dfheiblk ;
    
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
        hrMhgj030a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DO ORGAO DE ESTRUTURA
     * MHGJ004A
     * 
     */
    protected void bhgp0004RotDadosOe() {
        hrMhgj004a().run() ;
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ790A");
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
            a13000AbrirFgh873() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk790() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk790() ;
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
    protected void a13000AbrirFgh873() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH873");
        fgh873().open(CREATE ) ;
        if (!fgh873().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ790A - FGH873 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh873().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk790() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK790");
        fwk790().open() ;
        if (!fwk790().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ790A - FWK790 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk790().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk790() {
        log(TraceLevel.Debug, "A15000-LER-FWK790");
        wsChaveAnt().set(wsChave());
        fwk790().read() ;
        if (fwk790().getStatusOk()) {
            contRegLidosFwk790.add(1);
            wsChave().chaveTsPedido().set(fwk790().regFwk790().fwk790Pedido().fwk790TsPedido());
            wsChave().chaveCPedInfOpps().set(fwk790().regFwk790().fwk790Pedido().fwk790CPedInfOpps());
            wsChave().chaveZInicMov().set(fwk790().regFwk790().fwk790Pedido().fwk790ZInicMov());
            wsChave().chaveZFimMov().set(fwk790().regFwk790().fwk790Pedido().fwk790ZFimMov());
            wsChave().chaveCPaisIsoaDest().set(fwk790().regFwk790().fwk790Destino().fwk790CPaisIsoaDest());
            wsChave().chaveCMnemEgcDest().set(fwk790().regFwk790().fwk790Destino().fwk790CMnemEgcDest());
            wsChave().chaveCOePed().set(fwk790().regFwk790().fwk790Destino().fwk790COeEgcDest());
        }
        if (!fwk790().getStatusOk() && !fwk790().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK790 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk790().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (!fwk790().regFwk790().fwk790FicheiroFgh873().fwk790IDbcr().isEqual("X")) {
            a31100Detalhe() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk790() ;
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                fgh873().fgh873Registo().initialize() ;
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
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CMapaR2().set(wsMapa);
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CTipoRegR2().set("R2");
        fgh873().fgh873Registo().fgh873Detalhe().fgh873ZMapaR2().set(wTimestamp().wDataTimestamp());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873HMapaR2().set(wTimerN());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CIdioIsoR2().set("POR");
        fgh873().fgh873Registo().fgh873Detalhe().fgh873NsRegFichR2().set(wsContadorFich);
        fgh873().fgh873Registo().fgh873Detalhe().fgh873NIdRegDestR2().set(wsContadorDestino);
        fgh873().fgh873Registo().fgh873Detalhe().fgh873NIdRegCabcR2().set(wsContadorHeader);
        fgh873().fgh873Registo().fgh873Detalhe().fgh873NsRegDtlhCabR2().set(wsContadorDetalhe);
        fgh873().fgh873Registo().fgh873Detalhe().fgh873ZMovimentoR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790ZMovimento());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873DDescR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790DDesc());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873MMovimentoR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790MMovimento());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873SinalMovR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790SinalMov());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873IDbcrR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790IDbcr());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873IEstornoR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790IEstorno());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873MSldoCbloR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790MSldoCblo());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873SinalSldR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790SinalSld());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873MSldoDpnlR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790MSldoDpnl());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873SinalDpnlR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790SinalDpnl());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873ZValorR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790ZValor());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873NDocOppsR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790NDocOpps());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873MMovMoeOrigR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790MMovMoeOrig());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873SinalMovOrgR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790SinalMovOrg());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CMoedIsoOrgR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CMoedIsoOrg());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CProdutoR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CProduto());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CSectGrupoR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CSectGrupo());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873CCndzContR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CCndzCont());
        fgh873().fgh873Registo().fgh873Detalhe().fgh873NsMovimentoR2().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790NsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a31700Header() {
        log(TraceLevel.Debug, "A31700-HEADER");
        fgh873().fgh873Registo().initialize() ;
        a31730TrataDescricoes() ;
        wsContadorHeader.add(1);
        wsContadorDestino.add(1);
        wsContadorFich.add(1);
        wsContadorDetalhe.set(0);
        fgh873().fgh873Registo().fgh873Header().fgh873CMapaR1().set(wsMapa);
        fgh873().fgh873Registo().fgh873Header().fgh873CTipoRegR1().set("R1");
        fgh873().fgh873Registo().fgh873Header().fgh873ZMapaR1().set(wTimestamp().wDataTimestamp());
        fgh873().fgh873Registo().fgh873Header().fgh873HMapaR1().set(wTimerN());
        fgh873().fgh873Registo().fgh873Header().fgh873CIdioIsoR1().set("POR");
        fgh873().fgh873Registo().fgh873Header().fgh873NsRegFichR1().set(wsContadorFich);
        fgh873().fgh873Registo().fgh873Header().fgh873NIdRegDestR1().set(wsContadorDestino);
        fgh873().fgh873Registo().fgh873Header().fgh873NIdRegCabcR1().set(wsContadorHeader);
        fgh873().fgh873Registo().fgh873Header().fgh873CPaisIsoContR1().set(fwk790().regFwk790().fwk790Destino().fwk790CPaisIsoaDest());
        fgh873().fgh873Registo().fgh873Header().fgh873CBancContR1().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CBancCont());
        fgh873().fgh873Registo().fgh873Header().fgh873CBancContR1().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CBancCont());
        fgh873().fgh873Registo().fgh873Header().fgh873COeEgcContR1().set(wsChave().chaveCOePed());
        fgh873().fgh873Registo().fgh873Header().fgh873ZInicPesqR1().set(fwk790().regFwk790().fwk790Pedido().fwk790ZInicMov());
        fgh873().fgh873Registo().fgh873Header().fgh873ZFimPesqR1().set(fwk790().regFwk790().fwk790Pedido().fwk790ZFimMov());
        fgh873().fgh873Registo().fgh873Header().fgh873CPaisContR1().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CPaisIsoaCont());
        fgh873().fgh873Registo().fgh873Header().fgh873CBancR1().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CBancCont());
        wsConta().contaCOeEgcCont().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790COeEgcCont());
        wsConta().contaNsRdclCont().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790NsRdclCont());
        wsConta().contaVChkdCont().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790VChkdCont());
        wsConta().contaCTipoCont().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CTipoCont());
        fgh873().fgh873Registo().fgh873Header().fgh873ContaR1().set(wsConta());
        fgh873().fgh873Registo().fgh873Header().fgh873NsDepositoR1().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790NsDeposito());
        fgh873().fgh873Registo().fgh873Header().fgh873CMoedIsoSctaR1().set(fwk790().regFwk790().fwk790FicheiroFgh873().fwk790CMoedIsoScta());
        s10000WriteFgh873() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31300Totais() {
        log(TraceLevel.Debug, "A31300-TOTAIS");
        fgh873().fgh873Registo().initialize() ;
        wsContadorTotais.add(1);
        wsContadorFich.add(1);
        fgh873().fgh873Registo().fgh873Totais().fgh873CMapaR3().set(wsMapa);
        fgh873().fgh873Registo().fgh873Totais().fgh873CTipoRegR3().set("R3");
        fgh873().fgh873Registo().fgh873Totais().fgh873ZMapaR3().set(wTimestamp().wDataTimestamp());
        fgh873().fgh873Registo().fgh873Totais().fgh873HMapaR3().set(wTimerN());
        fgh873().fgh873Registo().fgh873Totais().fgh873CIdioIsoR3().set("POR");
        fgh873().fgh873Registo().fgh873Totais().fgh873NsRegFichR3().set(wsContadorFich);
        fgh873().fgh873Registo().fgh873Totais().fgh873NIdRegDestR3().set(wsContadorDestino);
        fgh873().fgh873Registo().fgh873Totais().fgh873NIdRegCabcR3().set(wsContadorHeader);
        fgh873().fgh873Registo().fgh873Totais().fgh873TotalMovimentsR3().set(wsContadorDetalhe);
        fgh873().fgh873Registo().fgh873Totais().fgh873NIdRegTotR3().set(wsContadorTotais);
        wsContadorDetalhe.set(0);
        s10000WriteFgh873() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31100Detalhe() {
        log(TraceLevel.Debug, "A31100-DETALHE");
        fgh873().fgh873Registo().initialize() ;
        a31130MoverDetalhe() ;
        s10000WriteFgh873() ;
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
        hv01501Pedmovhst().updatePghq790a628() ;
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
        bhgl030a().commarea().dadosInput().cCodigo().set(fwk790().regFwk790().fwk790Destino().fwk790CPaisIsoaDest());
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh873().fgh873Registo().fgh873Header().fgh873DPaisIsoContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh873().fgh873Registo().fgh873Header().fgh873DPaisIsoContR1().set(" ");
        }
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("983");
        bhgl030a().commarea().dadosInput().cCodigo().get(1, 3).set(fwk790().regFwk790().fwk790Destino().fwk790CPaisIsoaDest()) ;
        bhgl030a().commarea().dadosInput().cCodigo().get(4, 4).set("35") ;
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh873().fgh873Registo().fgh873Header().fgh873DBancContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh873().fgh873Registo().fgh873Header().fgh873DBancContR1().set(" ");
        }
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(fwk790().regFwk790().fwk790Destino().fwk790CPaisIsoaDest());
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(fwk790().regFwk790().fwk790Destino().fwk790CMnemEgcDest());
        bhgl004a().commarea().dadosInput().cOeEgc().set(wsChave().chaveCOePed());
        bhgp0004RotDadosOe() ;
        if (bhgl004a().commarea().dadosOutput().semErros().isTrue()) {
            fgh873().fgh873Registo().fgh873Header().fgh873DOeEgcContR1().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
        } else {
            fgh873().fgh873Registo().fgh873Header().fgh873DOeEgcContR1().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000WriteFgh873() {
        log(TraceLevel.Debug, "S10000-WRITE-FGH873");
        fgh873().write(fgh873().fgh873Registo()) ;
        if (fgh873().getStatusOk()) {
            contRegEscrtFgh873.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ790A - FGH873 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh873().getStatus());
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
            tabelaImpressao().linha05().impFichRead().set("FWK790");
            tabelaImpressao().linha05().impRegLidosFwk790().set(contRegLidosFwk790);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FGH873");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh873);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ790A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk790().close() ;
        fgh873().close() ;
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
        if (fwk790().getStatusOk()) {
            if (progOk.isTrue()) {
                a31700Header() ;
                while (!fwk790().getStatusOk() && progOk.isTrue()) {
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
            
            @Data(size=8, value="PGHQ790A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ790A")
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
            IFormattedString impRegLidosFwk790() ;
            
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
