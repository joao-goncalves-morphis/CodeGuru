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
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.hy.routines.Mhyq150a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : INACTIVA TRANSACCOES NA ARQUITECTURA ALNOVA
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc110a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Sysin
     */
    @Handler(name="SYSIN", record="statusFgh11002")
    @Data
    protected abstract Sysin fgh110() ;
    
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyq150a
     */
    @Data
    protected abstract Mhyq150a hrMhyq150a() ;
    
    
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
    
    @Data(size=8, value="MHYQ150A")
    protected IString conMhyq150a ;
    
    /**
     * @return instancia da classe local WsRegFgh110
     */
    @Data
    protected abstract WsRegFgh110 wsRegFgh110() ;
    
    @Data(size=12, value="BATCH CONTAS")
    protected IString wsXInfOrigPed ;
    
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
    protected void s00000TratarParm() {
        /**
         * *----------------------------------------------------------------*
         */
        a00001AbrirFgh110() ;
        if (progOk.isTrue()) {
            a00002LerFgh110() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a00001AbrirFgh110() {
        log(TraceLevel.Debug, "A00001-ABRIR-FGH110");
        fgh110().open() ;
        if (!fgh110().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().msgStatus().set("PGHC110A - FGH110 - OPEN - ");
            tabelaImpressao().linha07().impStatus().set(fgh110().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a00002LerFgh110() {
        log(TraceLevel.Debug, "A00002-LER-FGH110");
        fgh110().read(wsRegFgh110()) ;
        if (fgh110().getStatusOk()) {
            a00003ValidarParm() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().msgStatus().set("PGHC110A - FGH110 - READ - ");
            tabelaImpressao().linha07().impStatus().set(fgh110().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a00003ValidarParm() {
        log(TraceLevel.Debug, "A00003-VALIDAR-PARM");
        if (wsRegFgh110().wsCTransaccao1().isEmpty() && 
            wsRegFgh110().wsCTransaccao2().isEmpty() && 
            wsRegFgh110().wsCTransaccao3().isEmpty() && 
            wsRegFgh110().wsCTransaccao4().isEmpty()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, "PARM INVALIDO");
            tabelaImpressao().linha07().msgStatus().set("PARM INVALIDO");
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        progOk.setTrue() ;
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHC110A");
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
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (!wsRegFgh110().wsCTransaccao1().isEmpty()) {
            a31000InactivaTrn1() ;
        }
        if (progOk.isTrue()) {
            if (!wsRegFgh110().wsCTransaccao2().isEmpty()) {
                a32000InactivaTrn2() ;
            }
        }
        if (progOk.isTrue()) {
            if (!wsRegFgh110().wsCTransaccao3().isEmpty()) {
                a33000InactivaTrn3() ;
            }
        }
        if (progOk.isTrue()) {
            if (!wsRegFgh110().wsCTransaccao4().isEmpty()) {
                a34000InactivaTrn4() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000InactivaTrn1() {
        log(TraceLevel.Debug, "A31000-INACTIVA-TRN-1");
        hrMhyq150a().bhyl150a().commarea().initialize() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().iAtvzDtvzInactiva().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().transaccao().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().aAplicOrig().set("GH");
        hrMhyq150a().bhyl150a().commarea().dadosInput().xInfOrigPend().set(wsXInfOrigPed);
        hrMhyq150a().bhyl150a().commarea().dadosInput().cTrnzApl().set(wsRegFgh110().wsCTransaccao1());
        hrMhyq150a().run() ;
        if (!hrMhyq150a().bhyl150a().commarea().dadosOutput().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().msgStatus().get(1, 21).set("PGHC110A - MHYQ150A -") ;
            tabelaImpressao().linha07().msgStatus().get(23, 4).set("WS-C-TRANSACCAO-1") ;
            wSqlcode.set(hrMhyq150a().bhyl150a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha07().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000InactivaTrn2() {
        log(TraceLevel.Debug, "A32000-INACTIVA-TRN-2");
        hrMhyq150a().bhyl150a().commarea().initialize() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().iAtvzDtvzInactiva().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().transaccao().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().aAplicOrig().set("GH");
        hrMhyq150a().bhyl150a().commarea().dadosInput().xInfOrigPend().set(wsXInfOrigPed);
        hrMhyq150a().bhyl150a().commarea().dadosInput().cTrnzApl().set(wsRegFgh110().wsCTransaccao2());
        hrMhyq150a().run() ;
        if (!hrMhyq150a().bhyl150a().commarea().dadosOutput().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().msgStatus().get(1, 21).set("PGHC110A - MHYQ150A -") ;
            tabelaImpressao().linha07().msgStatus().get(23, 4).set("WS-C-TRANSACCAO-2") ;
            wSqlcode.set(hrMhyq150a().bhyl150a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha07().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000InactivaTrn3() {
        log(TraceLevel.Debug, "A32000-INACTIVA-TRN-3");
        hrMhyq150a().bhyl150a().commarea().initialize() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().iAtvzDtvzInactiva().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().transaccao().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().aAplicOrig().set("GH");
        hrMhyq150a().bhyl150a().commarea().dadosInput().xInfOrigPend().set(wsXInfOrigPed);
        hrMhyq150a().bhyl150a().commarea().dadosInput().cTrnzApl().set(wsRegFgh110().wsCTransaccao3());
        hrMhyq150a().run() ;
        if (!hrMhyq150a().bhyl150a().commarea().dadosOutput().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().msgStatus().get(1, 21).set("PGHC110A - MHYQ150A -") ;
            tabelaImpressao().linha07().msgStatus().get(23, 4).set("WS-C-TRANSACCAO-3") ;
            wSqlcode.set(hrMhyq150a().bhyl150a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha07().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000InactivaTrn4() {
        log(TraceLevel.Debug, "A34000-INACTIVA-TRN-4");
        hrMhyq150a().bhyl150a().commarea().initialize() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().iAtvzDtvzInactiva().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().transaccao().setTrue() ;
        hrMhyq150a().bhyl150a().commarea().dadosInput().aAplicOrig().set("GH");
        hrMhyq150a().bhyl150a().commarea().dadosInput().xInfOrigPend().set(wsXInfOrigPed);
        hrMhyq150a().bhyl150a().commarea().dadosInput().cTrnzApl().set(wsRegFgh110().wsCTransaccao4());
        hrMhyq150a().run() ;
        if (!hrMhyq150a().bhyl150a().commarea().dadosOutput().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().msgStatus().get(1, 21).set("PGHC110A - MHYQ150A -") ;
            tabelaImpressao().linha07().msgStatus().get(23, 4).set("WS-C-TRANSACCAO-4") ;
            wSqlcode.set(hrMhyq150a().bhyl150a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha07().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha05().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            if (!wsRegFgh110().wsCTransaccao1().isEmpty()) {
                tabelaImpressao().linha08().msgLivre().get(1, 23).set("INACTIVACAO-TRANSACCAO-") ;
                tabelaImpressao().linha08().msgLivre().get(24, 4).set(wsRegFgh110().wsCTransaccao1()) ;
                tabelaImpressaoMask().zimp().setIndex(8) ;
                a12000EscreverFgh300() ;
            }
            if (!wsRegFgh110().wsCTransaccao2().isEmpty()) {
                tabelaImpressao().linha08().msgLivre().get(1, 23).set("INACTIVACAO-TRANSACCAO-") ;
                tabelaImpressao().linha08().msgLivre().get(24, 4).set(wsRegFgh110().wsCTransaccao2()) ;
                tabelaImpressaoMask().zimp().setIndex(8) ;
                a12000EscreverFgh300() ;
            }
            if (!wsRegFgh110().wsCTransaccao3().isEmpty()) {
                tabelaImpressao().linha08().msgLivre().get(1, 23).set("INACTIVACAO-TRANSACCAO-") ;
                tabelaImpressao().linha08().msgLivre().get(24, 4).set(wsRegFgh110().wsCTransaccao3()) ;
                tabelaImpressaoMask().zimp().setIndex(8) ;
                a12000EscreverFgh300() ;
            }
            if (!wsRegFgh110().wsCTransaccao4().isEmpty()) {
                tabelaImpressao().linha08().msgLivre().get(1, 23).set("INACTIVACAO-TRANSACCAO-") ;
                tabelaImpressao().linha08().msgLivre().get(24, 4).set(wsRegFgh110().wsCTransaccao4()) ;
                tabelaImpressaoMask().zimp().setIndex(8) ;
                a12000EscreverFgh300() ;
            }
        } else {
            tabelaImpressao().linha05().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha05().impReturnCode().set(returnCode);
            tabelaImpressao().linha06().impMens1().set("PGHC110A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fgh110().close() ;
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
            s00000TratarParm() ;
        }
        if (progOk.isTrue()) {
            s30000Processar() ;
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=2)
        IInt secCorrente() ;
        
        @Data(size=2)
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
    public interface WsRegFgh110 extends IDataStruct {
        
        @Data(size=4)
        IString wsCTransaccao1() ;
        
        @Data(size=4, lpadding=1)
        IString wsCTransaccao2() ;
        
        @Data(size=4, lpadding=1)
        IString wsCTransaccao3() ;
        
        @Data(size=4, lpadding=1, rpadding=61)
        IString wsCTransaccao4() ;
        
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHC110A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC110A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=8, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
