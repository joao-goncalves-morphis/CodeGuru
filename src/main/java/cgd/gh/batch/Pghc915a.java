package cgd.gh.batch;

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
import cgd.hg.structures.link.Bhgl030a ;
import cgd.hg.structures.link.Bhgl004a ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;


/**
 * 
 * INPUT1 - FICHEIRO DOS PEDIDOS
 * FWK401 - GH00101 - MAPA MGH870
 * FWK401 - GH00107 - MAPA MGH870
 * FWK501 - GH00102 - MAPA MGH871
 * FWK601 - GH00103 - MAPA MGH872
 * FWK701 - GH00104 - MAPA MGH873
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    - SEPARA FWK915 CRIADO COM UM UNLOAD DA TABELA
 * 15 COM OS PEDIDOS SEM MOVIMENTOS
 * - CRIA REGISTOS DE PEDIDOS SEM MOVIMENTOS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc915a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk915
     */
    @Handler(name="FWK915", record="regFgh015")
    @Data
    protected abstract Fwk915 fwk915() ;
    
    /**
     * @return instancia da classe Fwk401
     */
    @Handler(name="FWK401", record="regFwk400")
    @Data
    protected abstract Fwk401 fwk401() ;
    
    /**
     * @return instancia da classe Fwk50102
     */
    @Handler(name="FWK501", record="regFwk500")
    @Data
    protected abstract Fwk50102 fwk501() ;
    
    /**
     * @return instancia da classe Fwk601
     */
    @Handler(name="FWK601", record="regFwk600")
    @Data
    protected abstract Fwk601 fwk601() ;
    
    /**
     * @return instancia da classe Fwk70101
     */
    @Handler(name="FWK701", record="regFwk700")
    @Data
    protected abstract Fwk70101 fwk701() ;
    
    
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
        bghw0300().wsNmPrograma().set("PGHC915A");
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
            a14000AbrirFwk915() ;
        }
        if (progOk.isTrue()) {
            a15000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk915() ;
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
    protected void a14000AbrirFwk915() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK915");
        fwk915().open() ;
        if (!fwk915().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK915 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk915().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000AbrirFicheiros() {
        log(TraceLevel.Debug, "A15000-ABRIR-FICHEIROS");
        fwk401().open(CREATE ) ;
        if (!fwk401().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK401 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk401().getStatus());
        }
        fwk501().open(CREATE ) ;
        if (!fwk501().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK501 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
        }
        fwk601().open(CREATE ) ;
        if (!fwk601().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK601 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk601().getStatus());
        }
        fwk701().open(CREATE ) ;
        if (!fwk701().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK701 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk701().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk915() {
        log(TraceLevel.Debug, "A16000-LER-FWK915");
        fwk915().read() ;
        if (fwk915().getStatusOk()) {
            wsContadores().wsContadorPedidos().add(1);
        }
        if (!fwk915().getStatusOk() && !fwk915().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK915 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk915().getStatus());
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
            a16000LerFwk915() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarPedido() {
        log(TraceLevel.Debug, "A31000-TRATAR-PEDIDO");
        if (progOk.isTrue()) {
            a31300ExecutaPedido() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300ExecutaPedido() {
        log(TraceLevel.Debug, "A31300-EXECUTA-PEDIDO");
        if (progOk.isTrue()) {
            a31320SeparaPedido() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320SeparaPedido() {
        log(TraceLevel.Debug, "A31320-SEPARA-PEDIDO");
        if (fwk915().regFgh015().fgh015CPedInfOpps().isEqual("GH00101") || 
            fwk915().regFgh015().fgh015CPedInfOpps().isEqual("GH00107")) {
            a31323TrataFwk401() ;
        } else if (fwk915().regFgh015().fgh015CPedInfOpps().isEqual("GH00102")) {
            a31324TrataFwk501() ;
        } else if (fwk915().regFgh015().fgh015CPedInfOpps().isEqual("GH00103")) {
            a31325TrataFwk601() ;
        } else if (fwk915().regFgh015().fgh015CPedInfOpps().isEqual("GH00104")) {
            a31326PreencheFwk701() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31323TrataFwk401() {
        log(TraceLevel.Debug, "A31323-TRATA-FWK401");
        fwk401().regFwk400().initialize() ;
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CPaisIsoaCont().set(fwk915().regFgh015().fgh015CPaisIsoaCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CBancCont().set(fwk915().regFgh015().fgh015CBancCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400COeEgcCont().set(fwk915().regFgh015().fgh015COeEgcCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsRdclCont().set(fwk915().regFgh015().fgh015NsRdclCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400VChkdCont().set(fwk915().regFgh015().fgh015VChkdCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CTipoCont().set(fwk915().regFgh015().fgh015CTipoCont());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoScta().set(fwk915().regFgh015().fgh015CMoedIsoScta());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400NsDeposito().set(fwk915().regFgh015().fgh015NsDeposito());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400TsMovimento().set(fwk915().regFgh015().fgh015TsPedido());
        fwk401().regFwk400().fwk400Pedido().fwk400CPedInfOpps().set(fwk915().regFgh015().fgh015CPedInfOpps());
        fwk401().regFwk400().fwk400Pedido().fwk400ZInicMov().set(fwk915().regFgh015().fgh015ZInicMov());
        fwk401().regFwk400().fwk400Pedido().fwk400ZFimMov().set(fwk915().regFgh015().fgh015ZFimMov());
        fwk401().regFwk400().fwk400Pedido().fwk400TsPedido().set(fwk915().regFgh015().fgh015TsPedido());
        fwk401().regFwk400().fwk400FicheiroFgh870().fwk400IDbcr().set("X");
        fwk401().write(fwk401().regFwk400()) ;
        if (fwk401().getStatusOk()) {
            wsContadores().wsContadorFwk401().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK401 - WRITE- ");
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
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CPaisIsoaCont().set(fwk915().regFgh015().fgh015CPaisIsoaCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CBancCont().set(fwk915().regFgh015().fgh015CBancCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcCont().set(fwk915().regFgh015().fgh015COeEgcCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsRdclCont().set(fwk915().regFgh015().fgh015NsRdclCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500VChkdCont().set(fwk915().regFgh015().fgh015VChkdCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCont().set(fwk915().regFgh015().fgh015CTipoCont());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoScta().set(fwk915().regFgh015().fgh015CMoedIsoScta());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500NsDeposito().set(fwk915().regFgh015().fgh015NsDeposito());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500TsMovimento().set(fwk915().regFgh015().fgh015TsPedido());
        fwk501().regFwk500().fwk500Pedido().fwk500CPedInfOpps().set(fwk915().regFgh015().fgh015CPedInfOpps());
        fwk501().regFwk500().fwk500Pedido().fwk500ZInicMov().set(fwk915().regFgh015().fgh015ZInicMov());
        fwk501().regFwk500().fwk500Pedido().fwk500ZFimMov().set(fwk915().regFgh015().fgh015ZFimMov());
        fwk501().regFwk500().fwk500Pedido().fwk500TsPedido().set(fwk915().regFgh015().fgh015TsPedido());
        fwk501().regFwk500().fwk500FicheiroFgh871().fwk500IDbcr().set("X");
        fwk501().write(fwk501().regFwk500()) ;
        if (fwk501().getStatusOk()) {
            wsContadores().wsContadorFwk501().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK501 - WRITE- ");
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
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CPaisIsoaCont().set(fwk915().regFgh015().fgh015CPaisIsoaCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CBancCont().set(fwk915().regFgh015().fgh015CBancCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600COeEgcCont().set(fwk915().regFgh015().fgh015COeEgcCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsRdclCont().set(fwk915().regFgh015().fgh015NsRdclCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600VChkdCont().set(fwk915().regFgh015().fgh015VChkdCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CTipoCont().set(fwk915().regFgh015().fgh015CTipoCont());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoScta().set(fwk915().regFgh015().fgh015CMoedIsoScta());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600NsDeposito().set(fwk915().regFgh015().fgh015NsDeposito());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600TsMovimento().set(fwk915().regFgh015().fgh015TsPedido());
        fwk601().regFwk600().fwk600Pedido().fwk600CPedInfOpps().set(fwk915().regFgh015().fgh015CPedInfOpps());
        fwk601().regFwk600().fwk600Pedido().fwk600ZInicMov().set(fwk915().regFgh015().fgh015ZInicMov());
        fwk601().regFwk600().fwk600Pedido().fwk600ZFimMov().set(fwk915().regFgh015().fgh015ZFimMov());
        fwk601().regFwk600().fwk600Pedido().fwk600TsPedido().set(fwk915().regFgh015().fgh015TsPedido());
        fwk601().regFwk600().fwk600FicheiroFgh872().fwk600IDbcr().set("X");
        fwk601().write(fwk601().regFwk600()) ;
        if (fwk601().getStatusOk()) {
            wsContadores().wsContadorFwk601().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK601 - WRITE- ");
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
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CPaisIsoaCont().set(fwk915().regFgh015().fgh015CPaisIsoaCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CBancCont().set(fwk915().regFgh015().fgh015CBancCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700COeEgcCont().set(fwk915().regFgh015().fgh015COeEgcCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsRdclCont().set(fwk915().regFgh015().fgh015NsRdclCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700VChkdCont().set(fwk915().regFgh015().fgh015VChkdCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CTipoCont().set(fwk915().regFgh015().fgh015CTipoCont());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoScta().set(fwk915().regFgh015().fgh015CMoedIsoScta());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700NsDeposito().set(fwk915().regFgh015().fgh015NsDeposito());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700TsMovimento().set(fwk915().regFgh015().fgh015TsPedido());
        fwk701().regFwk700().fwk700Pedido().fwk700CPedInfOpps().set(fwk915().regFgh015().fgh015CPedInfOpps());
        fwk701().regFwk700().fwk700Pedido().fwk700ZInicMov().set(fwk915().regFgh015().fgh015ZInicMov());
        fwk701().regFwk700().fwk700Pedido().fwk700ZFimMov().set(fwk915().regFgh015().fgh015ZFimMov());
        fwk701().regFwk700().fwk700Pedido().fwk700TsPedido().set(fwk915().regFgh015().fgh015TsPedido());
        fwk701().regFwk700().fwk700FicheiroFgh873().fwk700IDbcr().set("X");
        fwk701().write(fwk701().regFwk700()) ;
        if (fwk701().getStatusOk()) {
            wsContadores().wsContadorFwk701().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHC915A - FWK701 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk701().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
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
            tabelaImpressao().linha05().impRegLidosFwk915().set(wsContadores().wsContadorPedidos());
            tabelaImpressaoMask().zimp().setIndex(5) ;
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
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC915A - FIM ANORMAL ");
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
            while (!fwk915().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
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
            
            @Data(size=8, value="PGHC915A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC915A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK915")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk915() ;
            
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
