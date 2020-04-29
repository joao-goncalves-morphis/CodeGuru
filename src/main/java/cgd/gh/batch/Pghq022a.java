package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
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
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghwz001 ;
import cgd.gh.structures.work.Bghw0004 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq022a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk600
     */
    @Handler(name="FWK600", record="registo")
    @Data
    protected abstract Fwk600 fwk600() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghwz001
     */
    @Data
    protected abstract Bghwz001 bghwz001() ;
    
    /**
     * @return instancia da classe Bghw0004
     */
    @Data
    protected abstract Bghw0004 bghw0004() ;
    
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
    protected ILong contRegLidosFwk600 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh00201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong auxContRegLidos ;
    
    /**
     * @return instancia da classe local TabelaImpressao
     */
    @Data
    protected abstract TabelaImpressao tabelaImpressao() ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ022A");
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
        /**
         * *...........                                                      
         */
        if (progOk.isTrue()) {
            a18000AbrirFwk600() ;
        }
        /**
         * *...........                                                      
         */
        if (progOk.isTrue()) {
            a19000LerFwk600() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a18000AbrirFwk600() {
        log(TraceLevel.Debug, "A18000-ABRIR-FWK600");
        fwk600().open() ;
        if (!fwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ022A - FWK600 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk600().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a19000LerFwk600() {
        log(TraceLevel.Debug, "A19000-LER-FWK600");
        fwk600().read() ;
        if (fwk600().getStatusOk()) {
            contRegLidosFwk600.add(1);
        }
        if (!fwk600().getStatusOk() && !fwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ022A - FWK600 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fwk600().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            a30000EscreverHistorico() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        /**
         * *........                                                         
         */
        if (progOk.isTrue()) {
            a19000LerFwk600() ;
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
            log(TraceLevel.Error, "CONT-REG-INS-VGH00201: ", contRegInsVgh00201);
            tabelaImpressao().linha08().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            fwk600().close() ;
        }
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
    protected void a30000EscreverHistorico() {
        log(TraceLevel.Debug, "A30000-ESCREVER-HISTORICO");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(fwk600().registo().conta().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(fwk600().registo().conta().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fwk600().registo().conta().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(fwk600().registo().conta().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(fwk600().registo().conta().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(fwk600().registo().conta().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(fwk600().registo().conta().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(fwk600().registo().conta().nsDeposito());
        hv00201Movhst().movhst().nsMovimento().set(fwk600().registo().nsMovimento());
        if (fwk600().registo().aAplicacao().isEqual("PP") && 
            !fwk600().registo().xRefMov().isEmpty()) {
            hv00201Movhst().movhst().xChavAcsInfAdi().get(1, 21).set(fwk600().registo().xRefMov()) ;
            hv00201Movhst().movhst().xChavAcsInfAdi().get(22, 4).set(fwk600().registo().cEvenOpel()) ;
            hv00201Movhst().movhst().xChavAcsInfAdi().get(26, 5).set(fwk600().registo().cOpeBbn()) ;
            hv00201Movhst().movhst().iExisInfAdi().set("S");
            a30001InsVgh00201Movhst() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30001InsVgh00201Movhst() {
        log(TraceLevel.Debug, "A30001-INS-VGH00201-MOVHST");
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq022a368() ;
        switch (hv00201Movhst().getPersistenceCode()) {
            case NORMAL:
                contRegInsVgh00201.add(1);
                break;
            case NOTFND:
                log(TraceLevel.Trace, " CHAVE VGH00201: ");
                log(TraceLevel.Trace, " C-PAIS-ISOA-CONT:", hv00201Movhst().movhst().cPaisIsoaCont());
                log(TraceLevel.Trace, " C-BANC-CONT     :", hv00201Movhst().movhst().cBancCont());
                log(TraceLevel.Trace, " C-OE-EGC-CONT   :", hv00201Movhst().movhst().cOeEgcCont());
                log(TraceLevel.Trace, " NS-RDCL-CONT    :", hv00201Movhst().movhst().nsRdclCont());
                log(TraceLevel.Trace, " V-CHKD-CONT     :", hv00201Movhst().movhst().vChkdCont());
                log(TraceLevel.Trace, " C-TIPO-CONT     :", hv00201Movhst().movhst().cTipoCont());
                log(TraceLevel.Trace, " C-MOED-ISO-SCTA :", hv00201Movhst().movhst().cMoedIsoScta());
                log(TraceLevel.Trace, " NS-DEPOSITO     :", hv00201Movhst().movhst().nsDeposito());
                log(TraceLevel.Trace, " NS-MOVIMENTO    :", hv00201Movhst().movhst().nsMovimento());
                break;
            default :
                log(TraceLevel.Trace, " CHAVE VGH00201: ");
                log(TraceLevel.Trace, " C-PAIS-ISOA-CONT:", hv00201Movhst().movhst().cPaisIsoaCont());
                log(TraceLevel.Trace, " C-BANC-CONT     :", hv00201Movhst().movhst().cBancCont());
                log(TraceLevel.Trace, " C-OE-EGC-CONT   :", hv00201Movhst().movhst().cOeEgcCont());
                log(TraceLevel.Trace, " NS-RDCL-CONT    :", hv00201Movhst().movhst().nsRdclCont());
                log(TraceLevel.Trace, " V-CHKD-CONT     :", hv00201Movhst().movhst().vChkdCont());
                log(TraceLevel.Trace, " C-TIPO-CONT     :", hv00201Movhst().movhst().cTipoCont());
                log(TraceLevel.Trace, " C-MOED-ISO-SCTA :", hv00201Movhst().movhst().cMoedIsoScta());
                log(TraceLevel.Trace, " NS-DEPOSITO     :", hv00201Movhst().movhst().nsDeposito());
                log(TraceLevel.Trace, " NS-MOVIMENTO    :", hv00201Movhst().movhst().nsMovimento());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHQ022A - VGH00201 - UPDATE  - ");
                wSqlcode.set(getPersistenceCode());
                tabelaImpressao().linha10().impStatus().set(wSqlcode);
                log(TraceLevel.Trace, "W-SQLCODE :", wSqlcode);
                break;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000ControlaCommit() {
        log(TraceLevel.Debug, "A36000-CONTROLA-COMMIT");
        contRegCommit.add(1);
        if (contRegCommit.isEqual(1)) {
            commit() ;
            if (progOk.isTrue()) {
                contRegCommit.set(0);
            }
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
        log(TraceLevel.Trace, "INICIO DO PGHQ022A");
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (fwk600().getStatusOk() && progOk.isTrue()) {
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
        
        /**
         * @return instancia da classe local Linha11
         */
        @Data
        Linha11 linha11() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ022A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ022A")
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
            
            @Data(size=30, value="NUMERO DE REGISTOS ELIMINADOS ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichDel() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegDel() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha11 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    
}
