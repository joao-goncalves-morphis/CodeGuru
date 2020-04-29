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


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : ACTUALIZA TABELA TGH00009_INFAUXMOV COM
 * OS DADOS AUXILIARES DOS MOVIMENTOS DO DIA
 * ACCENTURE     : GH1043 - FORMATACAO DA ESTATISTICA
 * ACCENTURE     : GH1863 - INCLUSAO DE NOVOS CAMPOS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq009a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00901Infauxmov
     */
    @Data
    protected abstract Vwsdghps00901Infauxmov hv00901Infauxmov() ;
    
    
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
     * @return instancia da classe Fwk070
     */
    @Handler(name="FWK070", record="fwk070RegPghq009a")
    @Data
    protected abstract Fwk070 fwk070() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghq009a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    
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
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk070 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh00901 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong auxContRegLidos ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ009A");
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
            a14000AbrirFwk900() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk900() ;
        }
        if (progOk.isTrue()) {
            a16000AbrirFwk070() ;
        }
        if (progOk.isTrue()) {
            while (contRegLidosFwk070.isLessOrEqual(auxContRegLidos) && !fwk070().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17000LerFwk070() ;
            }
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
    protected void a14000AbrirFwk900() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK900");
        fwk900().open(WRITE) ;
        if (!fwk900().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk900() {
        log(TraceLevel.Debug, "A15000-LER-FWK900");
        fwk900().read() ;
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq009a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            tabelaImpressao().linha10().msgLivre().set(fwk900().fwk900RegPghq009a().fwk900NCommit());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15100TratarOutputFwk900() {
        log(TraceLevel.Debug, "A15100-TRATAR-OUTPUT-FWK900");
        fwk900().open(CREATE ) ;
        if (fwk900().getStatusOk()) {
            fwk900().fwk900RegPghq009a().initialize() ;
            fwk900().fwk900RegPghq009a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghq009a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - OPEN- ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFwk070() {
        log(TraceLevel.Debug, "A16000-ABRIR-FWK070");
        fwk070().open() ;
        if (!fwk070().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK070 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk070().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerFwk070() {
        log(TraceLevel.Debug, "A17000-LER-FWK070");
        fwk070().read() ;
        if (fwk070().getStatusOk()) {
            contRegLidosFwk070.add(1);
        }
        if (!fwk070().getStatusOk() && !fwk070().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK070 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk070().getStatus());
            contRegLidosFwk070.add(1);
            tabelaImpressao().linha10().msgLivre().set(contRegLidosFwk070);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            a31000TratarInfauxmov() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17000LerFwk070() ;
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
            tabelaImpressao().linha05().impFichRead().set("FWK070");
            tabelaImpressao().linha05().impRegLidosFwk070().set(contRegLidosFwk070);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("VGH00901");
            tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh00901);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            if (progOk.isTrue()) {
                commit() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ009A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk070().close() ;
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
    protected void a31000TratarInfauxmov() {
        log(TraceLevel.Debug, "A31000-TRATAR-CONTIPHST");
        wSqlcode.initialize() ;
        hv00901Infauxmov().infauxmov().initialize() ;
        hv00901Infauxmov().infauxmov().cPaisIsoaCont().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070CPaisIsoaCont());
        hv00901Infauxmov().infauxmov().cBancCont().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070CBancCont());
        hv00901Infauxmov().infauxmov().cOeEgcCont().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070COeEgcCont());
        hv00901Infauxmov().infauxmov().nsRdclCont().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070NsRdclCont());
        hv00901Infauxmov().infauxmov().vChkdCont().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070VChkdCont());
        hv00901Infauxmov().infauxmov().cTipoCont().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070CTipoCont());
        hv00901Infauxmov().infauxmov().cMoedIsoScta().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070CMoedIsoScta());
        hv00901Infauxmov().infauxmov().nsDeposito().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070NsDeposito());
        hv00901Infauxmov().infauxmov().tsMovimento().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070TsMovimento());
        hv00901Infauxmov().infauxmov().nsMovimento().set(fwk070().fwk070RegPghq009a().fwk070WsChave().fwk070NsMovimento());
        hv00901Infauxmov().infauxmov().iTrnzEfcdOnln().set(fwk070().fwk070RegPghq009a().fwk070ITrnzEfcdOnln());
        hv00901Infauxmov().infauxmov().iExiAtzJourBbn().set(fwk070().fwk070RegPghq009a().fwk070IExiAtzJourBbn());
        hv00901Infauxmov().infauxmov().iPenalizacao().set(fwk070().fwk070RegPghq009a().fwk070IPenalizacao());
        hv00901Infauxmov().infauxmov().cPaisIsoaGerx().set(fwk070().fwk070RegPghq009a().fwk070CPaisIsoaGerx());
        hv00901Infauxmov().infauxmov().cBancGcxGerx().set(fwk070().fwk070RegPghq009a().fwk070CBancGcxGerx());
        hv00901Infauxmov().infauxmov().cOeEgcGerx().set(fwk070().fwk070RegPghq009a().fwk070COeEgcGerx());
        hv00901Infauxmov().infauxmov().nAtrzCamb().set(0);
        hv00901Infauxmov().infauxmov().xRefMovOrig().set(" ");
        hv00901Infauxmov().infauxmov().tsActzUlt().set(fwk070().fwk070RegPghq009a().fwk070TsActzUlt());
        hv00901Infauxmov().infauxmov().cUsidActzUlt().set(fwk070().fwk070RegPghq009a().fwk070CUsidActzUlt());
        hv00901Infauxmov().infauxmov().iEstorno().set(fwk070().fwk070RegPghq009a().fwk070IEstorno());
        hv00901Infauxmov().infauxmov().nsMovEtnd().set(fwk070().fwk070RegPghq009a().fwk070NsMovEtnd());
        hv00901Infauxmov().infauxmov().mMovCtrvEuro().set(fwk070().fwk070RegPghq009a().fwk070MMovCtrvEuro());
        hv00901Infauxmov().infauxmov().tCambEuro().set(fwk070().fwk070RegPghq009a().fwk070TCambEuro());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00901_INFAUXMOV
         */
        hv00901Infauxmov().insertPghq009a599() ;
        if (hv00901Infauxmov().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh00901.add(1);
        } else {
            wSqlcode.set(hv00901Infauxmov().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - INSERT- VGH00901 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            tabelaImpressao().linha10().msgLivre().set(fwk070().fwk070RegPghq009a().fwk070WsChave());
            log(TraceLevel.Trace, "SQLCODE-", wSqlcode);
            log(TraceLevel.Trace, "VGH00901-C-PAIS-ISOA-CONT: ", hv00901Infauxmov().infauxmov().cPaisIsoaCont());
            log(TraceLevel.Trace, "VGH00901-C-BANC-CONT: ", hv00901Infauxmov().infauxmov().cBancCont());
            log(TraceLevel.Trace, "VGH00901-C-OE-EGC-CONT: ", hv00901Infauxmov().infauxmov().cOeEgcCont());
            log(TraceLevel.Trace, "VGH00901-NS-RDCL-CONT: ", hv00901Infauxmov().infauxmov().nsRdclCont());
            log(TraceLevel.Trace, "VGH00901-V-CHKD-CONT: ", hv00901Infauxmov().infauxmov().vChkdCont());
            log(TraceLevel.Trace, "VGH00901-C-TIPO-CONT: ", hv00901Infauxmov().infauxmov().cTipoCont());
            log(TraceLevel.Trace, "VGH00901-C-MOED-ISO-SCTA: ", hv00901Infauxmov().infauxmov().cMoedIsoScta());
            log(TraceLevel.Trace, "VGH00901-NS-DEPOSITO : ", hv00901Infauxmov().infauxmov().nsDeposito());
            log(TraceLevel.Trace, "VGH00901-TS-MOVIMENTO: ", hv00901Infauxmov().infauxmov().tsMovimento());
            log(TraceLevel.Trace, "VGH00901-NS-MOVIMENTO: ", hv00901Infauxmov().infauxmov().nsMovimento());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000ControlaCommit() {
        log(TraceLevel.Debug, "A36000-CONTROLA-COMMIT");
        contRegCommit.add(1);
        if (contRegCommit.isEqual(1000)) {
            commit() ;
            a36100EscreverFwk900() ;
            if (progOk.isTrue()) {
                contRegCommit.set(0);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36100EscreverFwk900() {
        log(TraceLevel.Debug, "A36100-ESCREVER-FWK900");
        a14000AbrirFwk900() ;
        if (progOk.isTrue()) {
            fwk900().read() ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghq009a().fwk900NCommit().set(add(fwk900().fwk900RegPghq009a().fwk900NCommit(), contRegCommit));
            fwk900().rewrite(fwk900().fwk900RegPghq009a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ009A - FWK900 - REWRITE -");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        }
        if (progOk.isTrue()) {
            fwk900().close() ;
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
            while (!fwk070().getStatusOk() && progOk.isTrue()) {
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
            
            @Data(size=8, value="PGHQ009A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ009A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFwk070() ;
            
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
