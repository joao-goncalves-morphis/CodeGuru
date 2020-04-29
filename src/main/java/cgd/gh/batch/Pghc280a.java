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


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : SEPARA O FICHEIRO FWK280 NOS SEGUINTES:
 * . FWK290 - PEDIDO GH00001
 * . FWK291 - PEDIDO GH00011
 * . FWK292 - PEDIDO GH00012
 * ALTERACOES    : INCLUI O FICHEIRO FWK211 - PEDIDO GH00004
 * CONTAS NOSVOS - PROC.GIP:GH328
 * ALTERACOES    : ALTERAR O TAMANHO DOS FICHEIROS DE SAIDA (270)*
 * GIP:GH385
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc280a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk280
     */
    @Handler(name="FWK280", record="regFwk280")
    @Data
    protected abstract Fwk280 fwk280() ;
    
    /**
     * @return instancia da classe Fwk211
     */
    @Handler(name="FWK211", record="regFwk211")
    @Data
    protected abstract Fwk211 fwk211() ;
    
    /**
     * @return instancia da classe Fwk290
     */
    @Handler(name="FWK290", record="regFwk290")
    @Data
    protected abstract Fwk290 fwk290() ;
    
    /**
     * @return instancia da classe Fwk292
     */
    @Handler(name="FWK292", record="regFwk292")
    @Data
    protected abstract Fwk292 fwk292() ;
    
    /**
     * @return instancia da classe Fwk291
     */
    @Handler(name="FWK291", record="regFwk291286")
    @Data
    protected abstract Fwk291 fwk291() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
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
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFwk211 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFwk292 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFwk290 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFwk291 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk280 ;
    
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
        progOk.setTrue() ;
        bghw0300().wsNmPrograma().set("PGHC280A");
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
            a13000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a17000LerFwk280() ;
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
    protected void a13000AbrirFicheiros() {
        log(TraceLevel.Debug, "A13000-ABRIR-FICHEIROS");
        fwk211().open(CREATE ) ;
        if (!fwk211().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK211 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk211().getStatus());
        }
        fwk290().open(CREATE ) ;
        if (!fwk290().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK290 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk290().getStatus());
        }
        fwk291().open(CREATE ) ;
        if (!fwk291().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK291 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk291().getStatus());
        }
        fwk292().open(CREATE ) ;
        if (!fwk292().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK292 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk292().getStatus());
        }
        fwk280().open() ;
        if (!fwk280().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK280 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk280().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerFwk280() {
        log(TraceLevel.Debug, "A17000-LER-FWK280");
        fwk280().read() ;
        if (fwk280().getStatusOk()) {
            contRegLidosFwk280.add(1);
        }
        if (!fwk280().getStatusOk() && !fwk280().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK280 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk280().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        switch (fwk280().regFwk280().fwk200Pedido().fwk200CPedInfOpps().get()) {
            case "GH00001":
                a31000EscreverFwk290() ;
                break;
            case "GH00011":
                a32000EscreverFwk291() ;
                break;
            case "GH00012":
                a33000EscreverFwk292() ;
                break;
            case "GH00004":
                a34000EscreverFwk211() ;
                break;
            default :
                break ;
        }
        if (progOk.isTrue()) {
            a17000LerFwk280() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000EscreverFwk290() {
        log(TraceLevel.Debug, "A31000-ESCREVER-FWK290");
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CPaisIsoaCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CPaisIsoaCont());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CBancCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CBancCont());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290COeEgcCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200COeEgcCont());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsRdclCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsRdclCont());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290VChkdCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200VChkdCont());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CTipoCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CTipoCont());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CMoedIsoScta().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CMoedIsoScta());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsDeposito().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsDeposito());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290TsMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TsMovimento());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsMovimento());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290ZValMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200ZValMov());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290ZMovLocl().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200ZMovLocl());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290IDbcr().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200IDbcr());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MMovimento());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290IEstorno().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200IEstorno());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CMoedIsoOriMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MSldoCbloApos().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MSldoCbloApos());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MSldoDpnlApos().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MSldoDpnlApos());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MMovMoeOrigMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290XRefMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200XRefMov());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NDocOpps().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NDocOpps());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290TJuro().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TJuro());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290AAplOrig().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200AAplOrig());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290TsActzUlt().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TsActzUlt());
        fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CUsidActzUlt().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CUsidActzUlt());
        fwk290().regFwk290().fwk290Pedido().fwk290CPedInfOpps().set(fwk280().regFwk280().fwk200Pedido().fwk200CPedInfOpps());
        fwk290().regFwk290().fwk290Pedido().fwk290ZInicMov().set(fwk280().regFwk280().fwk200Pedido().fwk200ZInicMov());
        fwk290().regFwk290().fwk290Pedido().fwk290ZFimMov().set(fwk280().regFwk280().fwk200Pedido().fwk200ZFimMov());
        fwk290().regFwk290().fwk290Pedido().fwk290TsPedido().set(fwk280().regFwk280().fwk200Pedido().fwk200TsPedido());
        fwk290().regFwk290().fwk290Pedido().fwk290CEndcFtpDest().set(fwk280().regFwk280().fwk200Pedido().fwk200CEndcFtpDest());
        fwk290().write(fwk290().regFwk290()) ;
        if (fwk290().getStatusOk()) {
            contRegEscrtFwk290.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK290 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk290().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFwk291() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FWK291");
        fwk291().setRecord(fwk280().getRecord()) ;
        fwk291().write(fwk291().regFwk291286) ;
        if (fwk291().getStatusOk()) {
            contRegEscrtFwk291.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK291 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk291().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000EscreverFwk292() {
        log(TraceLevel.Debug, "A33000-ESCREVER-FWK292");
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292CPaisIsoaCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CPaisIsoaCont());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292CBancCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CBancCont());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292COeEgcCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200COeEgcCont());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292NsRdclCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsRdclCont());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292VChkdCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200VChkdCont());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292CTipoCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CTipoCont());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292CMoedIsoScta().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CMoedIsoScta());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292NsDeposito().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsDeposito());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292TsMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TsMovimento());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292NsMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsMovimento());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292ZValMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200ZValMov());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292ZMovLocl().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200ZMovLocl());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292IDbcr().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200IDbcr());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292MMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MMovimento());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292IEstorno().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200IEstorno());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292CMoedIsoOriMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292MSldoCbloApos().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MSldoCbloApos());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292MSldoDpnlApos().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MSldoDpnlApos());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292MMovMoeOrigMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292XRefMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200XRefMov());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292NDocOpps().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NDocOpps());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292TJuro().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TJuro());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292AAplOrig().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200AAplOrig());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292TsActzUlt().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TsActzUlt());
        fwk292().regFwk292().fwk292FicheiroFgh500().fwk292CUsidActzUlt().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CUsidActzUlt());
        fwk292().regFwk292().fwk292Pedido().fwk292CPedInfOpps().set(fwk280().regFwk280().fwk200Pedido().fwk200CPedInfOpps());
        fwk292().regFwk292().fwk292Pedido().fwk292ZInicMov().set(fwk280().regFwk280().fwk200Pedido().fwk200ZInicMov());
        fwk292().regFwk292().fwk292Pedido().fwk292ZFimMov().set(fwk280().regFwk280().fwk200Pedido().fwk200ZFimMov());
        fwk292().regFwk292().fwk292Pedido().fwk292TsPedido().set(fwk280().regFwk280().fwk200Pedido().fwk200TsPedido());
        fwk292().regFwk292().fwk292Pedido().fwk292CEndcFtpDest().set(fwk280().regFwk280().fwk200Pedido().fwk200CEndcFtpDest());
        fwk292().write(fwk292().regFwk292()) ;
        if (fwk292().getStatusOk()) {
            contRegEscrtFwk292.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK292 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk292().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreverFwk211() {
        log(TraceLevel.Debug, "A34000-ESCREVER-FWK211");
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CPaisIsoaCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CPaisIsoaCont());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CBancCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CBancCont());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211COeEgcCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200COeEgcCont());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsRdclCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsRdclCont());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211VChkdCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200VChkdCont());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CTipoCont().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CTipoCont());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CMoedIsoScta().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CMoedIsoScta());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsDeposito().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsDeposito());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211TsMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TsMovimento());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NsMovimento());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211ZValMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200ZValMov());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211ZMovLocl().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200ZMovLocl());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211IDbcr().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200IDbcr());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MMovimento().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MMovimento());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211IEstorno().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200IEstorno());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CMoedIsoOriMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MSldoCbloApos().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MSldoCbloApos());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MSldoDpnlApos().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MSldoDpnlApos());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MMovMoeOrigMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211XRefMov().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200XRefMov());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NDocOpps().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200NDocOpps());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211TJuro().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TJuro());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211AAplOrig().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200AAplOrig());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211TsActzUlt().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200TsActzUlt());
        fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CUsidActzUlt().set(fwk280().regFwk280().fwk200FicheiroFgh500().fwk200CUsidActzUlt());
        fwk211().regFwk211().fwk211Pedido().fwk211CPedInfOpps().set(fwk280().regFwk280().fwk200Pedido().fwk200CPedInfOpps());
        fwk211().regFwk211().fwk211Pedido().fwk211ZInicMov().set(fwk280().regFwk280().fwk200Pedido().fwk200ZInicMov());
        fwk211().regFwk211().fwk211Pedido().fwk211ZFimMov().set(fwk280().regFwk280().fwk200Pedido().fwk200ZFimMov());
        fwk211().regFwk211().fwk211Pedido().fwk211TsPedido().set(fwk280().regFwk280().fwk200Pedido().fwk200TsPedido());
        fwk211().regFwk211().fwk211Pedido().fwk211CEndcFtpDest().set(fwk280().regFwk280().fwk200Pedido().fwk200CEndcFtpDest());
        fwk211().write(fwk211().regFwk211()) ;
        if (fwk211().getStatusOk()) {
            contRegEscrtFwk211.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC280A - FWK211 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk211().getStatus());
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
            tabelaImpressao().linha05().impFichRead().set("FWK280");
            tabelaImpressao().linha05().impRegLidosFwk280().set(contRegLidosFwk280);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK211");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk211);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FWK290");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk290);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK291");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk291);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK292");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk292);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHC280A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk280().close() ;
        fwk292().close() ;
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
            while (!fwk280().getStatusOk() && progOk.isTrue()) {
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
            
            @Data(size=8, value="PGHC280A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC280A")
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
            IFormattedString impRegLidosFwk280() ;
            
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
