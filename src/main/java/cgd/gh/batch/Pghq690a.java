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
public abstract class Pghq690a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh872
     */
    @Handler(name="FGH872", record="fgh872Registo")
    @Data
    protected abstract Fgh872 fgh872() ;
    
    /**
     * @return instancia da classe Fwk690
     */
    @Handler(name="FWK690", record="regFwk690")
    @Data
    protected abstract Fwk690 fwk690() ;
    
    
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
    
    @Data(size=6, value="MGH872")
    protected IString wsMapa ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFgh872 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk690 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ690A");
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
            a13000AbrirFgh872() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk690() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk690() ;
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
    protected void a13000AbrirFgh872() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH872");
        fgh872().open(CREATE ) ;
        if (!fgh872().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ690A - FGH872 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh872().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk690() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK690");
        fwk690().open() ;
        if (!fwk690().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ690A - FWK690 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk690().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk690() {
        log(TraceLevel.Debug, "A15000-LER-FWK690");
        wsChaveAnt().set(wsChave());
        fwk690().read() ;
        if (fwk690().getStatusOk()) {
            contRegLidosFwk690.add(1);
            wsChave().chaveTsPedido().set(fwk690().regFwk690().fwk690Pedido().fwk690TsPedido());
            wsChave().chaveCPedInfOpps().set(fwk690().regFwk690().fwk690Pedido().fwk690CPedInfOpps());
            wsChave().chaveZInicMov().set(fwk690().regFwk690().fwk690Pedido().fwk690ZInicMov());
            wsChave().chaveZFimMov().set(fwk690().regFwk690().fwk690Pedido().fwk690ZFimMov());
            wsChave().chaveCPaisIsoaDest().set(fwk690().regFwk690().fwk690Destino().fwk690CPaisIsoaDest());
            wsChave().chaveCMnemEgcDest().set(fwk690().regFwk690().fwk690Destino().fwk690CMnemEgcDest());
            wsChave().chaveCOePed().set(fwk690().regFwk690().fwk690Destino().fwk690COeEgcDest());
        }
        if (!fwk690().getStatusOk() && !fwk690().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK690 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk690().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (!fwk690().regFwk690().fwk690FicheiroFgh872().fwk690IDbcr().isEqual("X")) {
            a31100Detalhe() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk690() ;
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                fgh872().fgh872Registo().initialize() ;
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
        wsContadorFich.add(1);
        wsContadorDetalhe.add(1);
        fgh872().fgh872Registo().fgh872Detalhe().fgh872CMapaR2().set(wsMapa);
        fgh872().fgh872Registo().fgh872Detalhe().fgh872CTipoRegR2().set("R2");
        fgh872().fgh872Registo().fgh872Detalhe().fgh872ZMapaR2().set(wTimestamp().wDataTimestamp());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872HMapaR2().set(wTimerN());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872CIdioIsoR2().set("POR");
        fgh872().fgh872Registo().fgh872Detalhe().fgh872NIdRegDestR2().set(wsContadorDestino);
        fgh872().fgh872Registo().fgh872Detalhe().fgh872NIdRegCabcR2().set(wsContadorHeader);
        fgh872().fgh872Registo().fgh872Detalhe().fgh872NsRegDtlhCabR2().set(wsContadorDetalhe);
        fgh872().fgh872Registo().fgh872Detalhe().fgh872NsRegFichR2().set(wsContadorFich);
        fgh872().fgh872Registo().fgh872Detalhe().fgh872ZMovimentoR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690ZMovimento());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872DDescR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690DDesc());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MMovimentoR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MMovimento());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalMovR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalMov());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872IDbcrR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690IDbcr());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872IEstornoR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690IEstorno());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MSldoCbloR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MSldoCblo());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalSldR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalSld());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MSldoDpnlR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MSldoDpnl());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalDpnlR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalDpnl());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872ZValorR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690ZValor());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872NDocOppsR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690NDocOpps());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872CMoedIsoOrgR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CMoedIsoOrg());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MMovMoeOrigR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MMovMoeOrig());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalMovOrgR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalMovOrg());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MSldoRetdR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MSldoRetd());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalSldoRetdR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalSldoRetd());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MSldoVcobR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MSldoVcob());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalSldoVcobR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalSldoVcob());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MCmrgLimR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MCmrgLim());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalCmrgLimR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalCmrgLim());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MCmrgUtidR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MCmrgUtid());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalCmrgUtidR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalCmrgUtid());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MDcboNgcdAtrdR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MDcboNgcdAtrd());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalDcboNgcdAtrdR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalDcboNgcdAtrd());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872MDcboNgcdUtidR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690MDcboNgcdUtid());
        fgh872().fgh872Registo().fgh872Detalhe().fgh872SinalDcboNgcdUtidR2().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690SinalDcboNgcdUtid());
    }
    
    /**
     * 
     * 
     */
    protected void a31700Header() {
        log(TraceLevel.Debug, "A31700-HEADER");
        fgh872().fgh872Registo().initialize() ;
        a31730TrataDescricoes() ;
        wsContadorHeader.add(1);
        wsContadorDestino.add(1);
        wsContadorFich.add(1);
        wsContadorDetalhe.set(0);
        wsContadorTotais.set(0);
        fgh872().fgh872Registo().fgh872Header().fgh872CMapaR1().set(wsMapa);
        fgh872().fgh872Registo().fgh872Header().fgh872CTipoRegR1().set("R1");
        fgh872().fgh872Registo().fgh872Header().fgh872ZMapaR1().set(wTimestamp().wDataTimestamp());
        fgh872().fgh872Registo().fgh872Header().fgh872HMapaR1().set(wTimerN());
        fgh872().fgh872Registo().fgh872Header().fgh872CIdioIsoR1().set("POR");
        fgh872().fgh872Registo().fgh872Header().fgh872NsRegFichR1().set(wsContadorFich);
        fgh872().fgh872Registo().fgh872Header().fgh872NIdRegDestR1().set(wsContadorDestino);
        fgh872().fgh872Registo().fgh872Header().fgh872NIdRegCabcR1().set(wsContadorHeader);
        fgh872().fgh872Registo().fgh872Header().fgh872CPaisIsoContR1().set(fwk690().regFwk690().fwk690Destino().fwk690CPaisIsoaDest());
        fgh872().fgh872Registo().fgh872Header().fgh872CBancContR1().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CBancCont());
        fgh872().fgh872Registo().fgh872Header().fgh872CBancContR1().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CBancCont());
        fgh872().fgh872Registo().fgh872Header().fgh872COeEgcContR1().set(wsChave().chaveCOePed());
        fgh872().fgh872Registo().fgh872Header().fgh872ZInicPesqR1().set(fwk690().regFwk690().fwk690Pedido().fwk690ZInicMov());
        fgh872().fgh872Registo().fgh872Header().fgh872ZFimPesqR1().set(fwk690().regFwk690().fwk690Pedido().fwk690ZFimMov());
        fgh872().fgh872Registo().fgh872Header().fgh872CPaisContR1().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CPaisIsoaCont());
        fgh872().fgh872Registo().fgh872Header().fgh872CBancR1().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CBancCont());
        wsConta().contaCOeEgcCont().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690COeEgcCont());
        wsConta().contaNsRdclCont().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690NsRdclCont());
        wsConta().contaVChkdCont().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690VChkdCont());
        wsConta().contaCTipoCont().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CTipoCont());
        fgh872().fgh872Registo().fgh872Header().fgh872ContaR1().set(wsConta());
        fgh872().fgh872Registo().fgh872Header().fgh872NsDepositoR1().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690NsDeposito());
        fgh872().fgh872Registo().fgh872Header().fgh872CMoedIsoSctaR1().set(fwk690().regFwk690().fwk690FicheiroFgh872().fwk690CMoedIsoScta());
        s10000WriteFgh872() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31300Totais() {
        log(TraceLevel.Debug, "A31300-TOTAIS");
        fgh872().fgh872Registo().initialize() ;
        wsContadorTotais.add(1);
        wsContadorFich.add(1);
        fgh872().fgh872Registo().fgh872Totais().fgh872CMapaR3().set(wsMapa);
        fgh872().fgh872Registo().fgh872Totais().fgh872CTipoRegR3().set("R3");
        fgh872().fgh872Registo().fgh872Totais().fgh872ZMapaR3().set(wTimestamp().wDataTimestamp());
        fgh872().fgh872Registo().fgh872Totais().fgh872HMapaR3().set(wTimerN());
        fgh872().fgh872Registo().fgh872Totais().fgh872CIdioIsoR3().set("POR");
        fgh872().fgh872Registo().fgh872Totais().fgh872NsRegFichR3().set(wsContadorFich);
        fgh872().fgh872Registo().fgh872Totais().fgh872NIdRegDestR3().set(wsContadorDestino);
        fgh872().fgh872Registo().fgh872Totais().fgh872NIdRegCabcR3().set(wsContadorHeader);
        fgh872().fgh872Registo().fgh872Totais().fgh872TotalMovimentsR3().set(wsContadorDetalhe);
        fgh872().fgh872Registo().fgh872Totais().fgh872NIdRegTotR3().set(wsContadorTotais);
        wsContadorDetalhe.set(0);
        s10000WriteFgh872() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31100Detalhe() {
        log(TraceLevel.Debug, "A31100-DETALHE");
        fgh872().fgh872Registo().initialize() ;
        a31130MoverDetalhe() ;
        s10000WriteFgh872() ;
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
        hv01501Pedmovhst().updatePghq690a639() ;
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
        bhgl030a().commarea().dadosInput().cCodigo().set(fwk690().regFwk690().fwk690Destino().fwk690CPaisIsoaDest());
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh872().fgh872Registo().fgh872Header().fgh872DPaisIsoContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh872().fgh872Registo().fgh872Header().fgh872DPaisIsoContR1().set(" ");
        }
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("983");
        bhgl030a().commarea().dadosInput().cCodigo().get(1, 3).set(fwk690().regFwk690().fwk690Destino().fwk690CPaisIsoaDest()) ;
        bhgl030a().commarea().dadosInput().cCodigo().get(4, 4).set("35") ;
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh872().fgh872Registo().fgh872Header().fgh872DBancContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh872().fgh872Registo().fgh872Header().fgh872DBancContR1().set(" ");
        }
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(fwk690().regFwk690().fwk690Destino().fwk690CPaisIsoaDest());
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(fwk690().regFwk690().fwk690Destino().fwk690CMnemEgcDest());
        bhgl004a().commarea().dadosInput().cOeEgc().set(wsChave().chaveCOePed());
        bhgp0004RotDadosOe() ;
        if (bhgl004a().commarea().dadosOutput().semErros().isTrue()) {
            fgh872().fgh872Registo().fgh872Header().fgh872DOeEgcContR1().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
        } else {
            fgh872().fgh872Registo().fgh872Header().fgh872DOeEgcContR1().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000WriteFgh872() {
        log(TraceLevel.Debug, "S10000-WRITE-FGH872");
        fgh872().write(fgh872().fgh872Registo()) ;
        if (fgh872().getStatusOk()) {
            contRegEscrtFgh872.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ690A - FGH872 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh872().getStatus());
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
            tabelaImpressao().linha05().impFichRead().set("FWK690");
            tabelaImpressao().linha05().impRegLidosFwk690().set(contRegLidosFwk690);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FGH872");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh872);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ690A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk690().close() ;
        fgh872().close() ;
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
        if (fwk690().getStatusOk()) {
            if (progOk.isTrue()) {
                a31700Header() ;
                while (!fwk690().getStatusOk() && progOk.isTrue()) {
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
            
            @Data(size=8, value="PGHQ690A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ690A")
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
            IFormattedString impRegLidosFwk690() ;
            
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
