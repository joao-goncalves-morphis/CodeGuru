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
import cgd.hy.routines.Mhyj230a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * PRC19 - FIM
 * FWK200 - FICHEIRO MOVIMENTOS ENTRE DATAS
 * FWK210 - FICHEIRO MOVIMENTOS DAS CONTAS DA REPSOL
 * FWK220 - FICHEIRO MOVIMENTOS DAS CONTAS DA RHENUS
 * FWK300 - FICHEIRO MOVIMENTOS ENTRE DATAS - TRANS
 * FWK400 - GH00101 - MAPA MGH870
 * FWK400 - GH00107 - MAPA MGH870
 * FWK500 - GH00102 - MAPA MGH871
 * FWK600 - GH00103 - MAPA MGH872
 * FWK700 - GH00104 - MAPA MGH873
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : SEPARA FWK800 CRIADO NO PGHQ200A POR CODIGO
 * DE PEDIDO. O FWK800 E O FWK100 ORDENADO
 * RECORRENDO AS TABELAS:
 * VGH00201
 * VGH10201
 * ALTERACOES    :.PARA A INCLUIR O PEDIDO GH00004(NOSVOS)
 * NA ESCRITA DO FWK200 - PROC.GIP:GH328
 * :.PARA A INCLUIR O PEDIDO GH00003(REPSOL)
 * NA ESCRITA DO FWK210 - PROC.GIP:GH301
 * :.PARA A INCLUIR O PEDIDO GH00005(RHENUS)
 * NA ESCRITA DO FWK220 - PROC.GIP:GH710
 * :.ALTERCAO DO COMPRIMENTO DO FWK200 PARA
 * INCLUIR NOVOS CAMPOS - PROC.GIP:GH385
 * :.FORMATA SEGUNDA REFERENCIA EM FWK200
 * GIP:GH776 ! AUTOR:DACT685 ! DATA:2012-01-09
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq500a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
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
     * @return instancia da classe Vwsdghps00801Refmcbl
     */
    @Data
    protected abstract Vwsdghps00801Refmcbl hv00801Refmcbl() ;
    
    
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
     * @return instancia da classe Fwk800
     */
    @Handler(name="FWK800", record="regFwk800Pghq500a")
    @Data
    protected abstract Fwk800 fwk800() ;
    
    /**
     * @return instancia da classe Fwk200
     */
    @Handler(name="FWK200", record="regFwk200")
    @Data
    protected abstract Fwk200 fwk200() ;
    
    /**
     * @return instancia da classe Fwk210
     */
    @Handler(name="FWK210", record="regFwk210")
    @Data
    protected abstract Fwk210 fwk210() ;
    
    /**
     * @return instancia da classe Fwk220
     */
    @Handler(name="FWK220", record="regFwk220")
    @Data
    protected abstract Fwk220 fwk220() ;
    
    /**
     * @return instancia da classe Fwk300
     */
    @Handler(name="FWK300", record="regFwk300")
    @Data
    protected abstract Fwk300 fwk300() ;
    
    /**
     * @return instancia da classe Fwk400
     */
    @Handler(name="FWK400", record="regFwk400")
    @Data
    protected abstract Fwk400 fwk400() ;
    
    /**
     * @return instancia da classe Fwk500
     */
    @Handler(name="FWK500", record="regFwk500")
    @Data
    protected abstract Fwk500 fwk500() ;
    
    /**
     * @return instancia da classe Fwk600
     */
    @Handler(name="FWK600", record="regFwk600")
    @Data
    protected abstract Fwk600 fwk600() ;
    
    /**
     * @return instancia da classe Fwk700
     */
    @Handler(name="FWK700", record="regFwk700")
    @Data
    protected abstract Fwk700 fwk700() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
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
    
    
    @Data(size=2, signed=true, value="0")
    protected IInt wContador ;
    @Data
    @Condition("3")
    protected ICondition terceiraVez ;
    @Data
    @Condition("4")
    protected ICondition sair ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlTgh102 ;
    @Data
    @Condition("1")
    protected ICondition haTgh102 ;
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
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
    
    @Data(format="+ZZ9")
    protected IFormattedString wsCRtnoEvenSwal ;
    
    /**
     * PRC19 - INI
     * @return instancia da classe local WsFgh015
     */
    @Data
    protected abstract WsFgh015 wsFgh015() ;
    
    /**
     * PRC19 - FIM
     */
    @Data(size=26)
    protected IString wsTsInicio ;
    
    @Data(size=26)
    protected IString wsTsFim ;
    
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
    
    /**
     * AREAS DE LIGACAO
     */
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
     * 
     */
    protected void a32100AcedePedido() {
        log(TraceLevel.Debug, "A32100-ACEDE-PEDIDO");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().selectBghp001541() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set(" - SELECT TGH015 - ");
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32200ActualizaPedido() {
        log(TraceLevel.Debug, "A32200-ACTUALIZA-PEDIDO");
        if (hv01501Pedmovhst().pedmovhst().cEstPedHist().isEqual("A") || 
            hv01501Pedmovhst().pedmovhst().cEstPedHist().isEqual("C")) {
            if (hv01501Pedmovhst().pedmovhst().qDdbtPed().isEqual(0)) {
                hv01501Pedmovhst().pedmovhst().cEstPedHist().set("C");
            } else {
                hv01501Pedmovhst().pedmovhst().qDdbtPed().set(subtract(hv01501Pedmovhst().pedmovhst().qDdbtPed(), 1));
                if (hv01501Pedmovhst().pedmovhst().qDdbtPed().isLessOrEqual(0)) {
                    hv01501Pedmovhst().pedmovhst().cEstPedHist().set("C");
                    hv01501Pedmovhst().pedmovhst().qDdbtPed().set(0);
                } else {
                    hv01501Pedmovhst().pedmovhst().cEstPedHist().set("E");
                }
            }
        }
        if (hv01501Pedmovhst().pedmovhst().cEstPedHist().isEqual("C")) {
            hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
            if (hv01501Pedmovhst().pedmovhst().qDiaDpnzInf().isEqual(99)) {
                hv01501Pedmovhst().pedmovhst().zEliminacao().set(wTimestamp().wDataTimestamp());
            } else {
                a32310DetDataEliminacao() ;
            }
        }
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updateBghp0015121() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            sair.setTrue() ;
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
    protected void a32310DetDataEliminacao() {
        log(TraceLevel.Debug, "A32310-DET-DATA-ELIMINACAO");
        hrMhyj230a().bhyl230a().commarea().initialize() ;
        wSqlcode.initialize() ;
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(wsConSumDia);
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().iTipoExe().set("R");
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().datInput1().set(wTimestamp().wDataTimestamp());
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().prazo().cTipoPraz().set(wsConTipoPrazDias);
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().prazo().duTipoPraz().set(hv01501Pedmovhst().pedmovhst().qDiaDpnzInf());
        hrMhyj230a().run() ;
        if (hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            hv01501Pedmovhst().pedmovhst().zEliminacao().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().zOutput());
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().get(1, 21).set("- MHYJ230A -") ;
            wSqlcode.set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            wsCRtnoEvenSwal.set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
            tabelaImpressao().linha09().msgStatus().get(22, 4).set(wsCRtnoEvenSwal) ;
        }
    }
    
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
        bghw0300().wsNmPrograma().set("PGHQ500A");
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
            a14000AbrirFwk800() ;
        }
        if (progOk.isTrue()) {
            a15000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk800() ;
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
    protected void a14000AbrirFwk800() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK800");
        fwk800().open() ;
        if (!fwk800().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK800 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk800().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000AbrirFicheiros() {
        log(TraceLevel.Debug, "A15000-ABRIR-FICHEIROS");
        fwk200().open(CREATE ) ;
        if (!fwk200().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK200 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk200().getStatus());
        }
        fwk210().open(CREATE ) ;
        if (!fwk210().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK210 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk210().getStatus());
        }
        fwk220().open(CREATE ) ;
        if (!fwk220().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK220 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk220().getStatus());
        }
        fwk300().open(CREATE ) ;
        if (!fwk300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK300 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk300().getStatus());
        }
        fwk400().open(CREATE ) ;
        if (!fwk400().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK400 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk400().getStatus());
        }
        fwk500().open(CREATE ) ;
        if (!fwk500().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK500 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk500().getStatus());
        }
        fwk600().open(CREATE ) ;
        if (!fwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK600 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk600().getStatus());
        }
        fwk700().open(CREATE ) ;
        if (!fwk700().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK700 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk700().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk800() {
        log(TraceLevel.Debug, "A16000-LER-FWK800");
        fwk800().read() ;
        if (fwk800().getStatusOk()) {
            wsContadores().wsContadorPedidos().add(1);
        }
        if (!fwk800().getStatusOk() && !fwk800().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK800 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk800().getStatus());
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
            a32000ActualizaPedido() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk800() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarPedido() {
        log(TraceLevel.Debug, "A31000-TRATAR-PEDIDO");
        a31100OpenC1() ;
        if (progOk.isTrue()) {
            a31200FetchC1() ;
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue()) {
                a31300ExecutaPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a31400CloseC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenC1() {
        log(TraceLevel.Debug, "A31100-OPEN-C1");
        wSqlcode.initialize() ;
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-CONT    TO VGH00201-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT         TO VGH00201-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-CONT       TO VGH00201-C-OE-EGC-CONT
         * MOVE FGH015-NS-RDCL-CONT        TO VGH00201-NS-RDCL-CONT
         * MOVE FGH015-V-CHKD-CONT         TO VGH00201-V-CHKD-CONT
         * MOVE FGH015-C-TIPO-CONT         TO VGH00201-C-TIPO-CONT
         * MOVE FGH015-C-MOED-ISO-SCTA     TO VGH00201-C-MOED-ISO-SCTA
         * MOVE FGH015-NS-DEPOSITO         TO VGH00201-NS-DEPOSITO
         * MOVE FGH015-Z-INIC-MOV          TO WS-DATA-INICIO
         * MOVE W-TS-INICIO                TO WS-TS-INICIO
         * MOVE FGH015-Z-FIM-MOV           TO WS-DATA-FIM
         * MOVE W-TS-FIM                   TO WS-TS-FIM
         */
        hv00201Movhst().movhst().cPaisIsoaCont().set(fwk800().regFwk800Pghq500a().fwk800CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(fwk800().regFwk800Pghq500a().fwk800CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fwk800().regFwk800Pghq500a().fwk800COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(fwk800().regFwk800Pghq500a().fwk800NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(fwk800().regFwk800Pghq500a().fwk800VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(fwk800().regFwk800Pghq500a().fwk800CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(fwk800().regFwk800Pghq500a().fwk800CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(fwk800().regFwk800Pghq500a().fwk800NsDeposito());
        wTsInicio().wsDataInicio().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        wsTsInicio.set(wTsInicio());
        wTsFim().wsDataFim().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        wsTsFim.set(wTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00201Movhst().openPghq500a869(wsTsInicio, wsTsFim) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200FetchC1() {
        log(TraceLevel.Debug, "A31200-FETCH-C1");
        wSqlcode.initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv00201Movhst().fetchPghq500a896() ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            progOk.setTrue() ;
            wsCrtlTgh102.set(" ");
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FETCH C1- VGH00201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300ExecutaPedido() {
        log(TraceLevel.Debug, "A31300-EXECUTA-PEDIDO");
        if (progOk.isTrue()) {
            /**
             * IF FGH015-C-PED-INF-OPPS = 'GH00001' OR
             */
            if (!fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00001") && 
                !fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00012") && 
                !fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00101") && 
                !fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00107")) {
                a31310AcedeInfComplementar() ;
            }
        }
        if (progOk.isTrue()) {
            a31320SeparaPedido() ;
        }
        if (progOk.isTrue()) {
            a31200FetchC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AcedeInfComplementar() {
        log(TraceLevel.Debug, "S33530-ACEDE-INF-COMPLEMENTAR");
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq500a979(hv00201Movhst().movhst()) ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NORMAL) {
            haTgh102.setTrue() ;
        } else {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - SELECT  - VGH10201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320SeparaPedido() {
        log(TraceLevel.Debug, "A31320-SEPARA-PEDIDO");
        if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00001") || 
            fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00011") || 
            fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00012") || 
            fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00004")) {
            a31329AcedeTgh00008() ;
            a31321TrataFwk200() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00002")) {
            a31322TrataFwk300() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00101") || 
            fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00107")) {
            a31323TrataFwk400() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00102")) {
            a31324TrataFwk500() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00103")) {
            a31325TrataFwk600() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00104")) {
            a31326PreencheFwk700() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00003")) {
            a31327PreencheFwk210() ;
        } else if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00005")) {
            a31328PreencheFwk220() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31321TrataFwk200() {
        log(TraceLevel.Debug, "A31321-TRATAR-FWK200");
        fwk200().regFwk200().initialize() ;
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200TsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200ZValMov().set(hv00201Movhst().movhst().zValMov());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200ZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200MSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200MSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200TJuro().set(hv00201Movhst().movhst().tJuro());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200AAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200TsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
        /**
         * IF FGH015-C-PED-INF-OPPS = 'GH00011'
         */
        if (fwk800().regFwk800Pghq500a().fwk800CPedInfOpps().isEqual("GH00011")) {
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CUsidActzUlt().set(hv10201Movhstcpl().movhstcpl().cUserid());
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CTerminal().set(hv10201Movhstcpl().movhstcpl().cTerminal());
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK200-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK200-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK200-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK200-TS-PEDIDO
         * MOVE FGH015-C-ENDC-FTP-DEST    TO FWK200-C-ENDC-FTP-DEST
         */
        fwk200().regFwk200().fwk200Pedido().fwk200CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk200().regFwk200().fwk200Pedido().fwk200ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk200().regFwk200().fwk200Pedido().fwk200ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk200().regFwk200().fwk200Pedido().fwk200TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        fwk200().regFwk200().fwk200Pedido().fwk200CEndcFtpDest().set(fwk800().regFwk800Pghq500a().fwk800CEndcFtpDest());
        /**
         * PRC19 - FIM
         */
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk200().regFwk200().fwk200FicheiroFgh500().fwk200XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fwk200().regFwk200().fwk200FicheiroFgh500().fwk200XRefAux().set(hv00801Refmcbl().refmcbl().xRcnzMcblPrim());
        fwk200().write(fwk200().regFwk200()) ;
        if (fwk200().getStatusOk()) {
            wsContadores().wsContadorFwk200().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK200 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk200().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31322TrataFwk300() {
        log(TraceLevel.Debug, "A31322-TRATA-FWK300");
        fwk300().regFwk300().initialize() ;
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300TsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300ZValMov().set(hv00201Movhst().movhst().zValMov());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300ZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300MSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300MSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300MMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300TJuro().set(hv00201Movhst().movhst().tJuro());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300AAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300TsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300CUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTransaccao().set(hv10201Movhstcpl().movhstcpl().cTransaccao());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300AAplicacao().set(hv10201Movhstcpl().movhstcpl().aAplicacao());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTerminal().set(hv10201Movhstcpl().movhstcpl().cTerminal());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COperador().set(hv10201Movhstcpl().movhstcpl().cOperador());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COpexAtrx().set(hv10201Movhstcpl().movhstcpl().cOpexAtrx());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CProdSgop().set(hv10201Movhstcpl().movhstcpl().cProdSgop());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CFamiProd().set(hv10201Movhstcpl().movhstcpl().cFamiProd());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CProduto().set(hv10201Movhstcpl().movhstcpl().cProduto());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CCndzMovzCont().set(hv10201Movhstcpl().movhstcpl().cCndzMovzCont());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CGrupCont().set(hv10201Movhstcpl().movhstcpl().cGrupCont());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300CSectIttlBpor().set(hv10201Movhstcpl().movhstcpl().cTipoIttz());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300TCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MSldoRetd().set(hv10201Movhstcpl().movhstcpl().mSldoRetd());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MSldoVcob().set(hv10201Movhstcpl().movhstcpl().mSldoVcob());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MCmrgUtid().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdAtrd().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdUtid().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NJourBbn().set(hv10201Movhstcpl().movhstcpl().nJourBbn());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
        fwk300().regFwk300().fwk300Tgh00501Infhstcpl().fwk300NsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
        fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300ZEliminacao().set("0001-01-01");
        /**
         * PRC19 - INI
         */
        fwk300().regFwk300().fwk300Pedido().fwk300CPedInfOpps().set(wsFgh015().fgh015CPedInfOpps());
        /**
         * MOVE FGH015-Z-INIC-MOV         TO FWK300-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK300-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK300-TS-PEDIDO
         */
        fwk300().regFwk300().fwk300Pedido().fwk300CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk300().regFwk300().fwk300Pedido().fwk300ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk300().regFwk300().fwk300Pedido().fwk300ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk300().regFwk300().fwk300Pedido().fwk300TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        /**
         * PRC19 - FIM
         */
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk300().regFwk300().fwk300Tgh00500Infhst().fwk300XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fwk300().write(fwk300().regFwk300()) ;
        if (fwk300().getStatusOk()) {
            wsContadores().wsContadorFwk300().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK300 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk300().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31323TrataFwk400() {
        log(TraceLevel.Debug, "A31323-TRATA-FWK400");
        fwk400().regFwk400().initialize() ;
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400TsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400ZValor().set(hv00201Movhst().movhst().zValMov());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400ZMovimento().set(hv00201Movhst().movhst().zMovLocl());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400IDbcr().set(hv00201Movhst().movhst().iDbcr());
        if (hv00201Movhst().movhst().iEstorno().isEmpty()) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("D")) {
                fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set("-");
                fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set("-");
            } else {
                fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set(" ");
                fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set(" ");
            }
        } else if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set("-");
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set("-");
        } else {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMov().set(" ");
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalMovOrg().set(" ");
        }
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400CMoedIsoOrg().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        if (hv00201Movhst().movhst().mSldoCbloApos().isLess(0)) {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalSld().set("-");
        } else {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalSld().set(" ");
        }
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        if (hv00201Movhst().movhst().mSldoDpnlApos().isLess(0)) {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalDpnl().set("-");
        } else {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400SinalDpnl().set(" ");
        }
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400MMovMoeOrig().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk400().regFwk400().fwk400FicheiroFgh870().fwk400AApl().set(hv00201Movhst().movhst().aAplOrig());
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk400().regFwk400().fwk400FicheiroFgh870().fwk400DDesc().set(hv00201Movhst().movhst().xRefMov());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK400-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK400-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK400-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK400-TS-PEDIDO
         */
        fwk400().regFwk400().fwk400Pedido().fwk400CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk400().regFwk400().fwk400Pedido().fwk400ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk400().regFwk400().fwk400Pedido().fwk400ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk400().regFwk400().fwk400Pedido().fwk400TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        //Fwk480.write(fwk400().regFwk400()) ;
        if (fwk400().getStatusOk()) {
            wsContadores().wsContadorFwk400().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK400 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk400().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31324TrataFwk500() {
        log(TraceLevel.Debug, "A31324-TRATA-FWK500");
        fwk500().regFwk500().initialize() ;
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500TsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500ZValor().set(hv00201Movhst().movhst().zValMov());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500ZMovimento().set(hv00201Movhst().movhst().zMovLocl());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500MMovimento().set(hv00201Movhst().movhst().mMovimento());
        if (hv00201Movhst().movhst().iEstorno().isEmpty()) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("D")) {
                fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set("-");
                fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set("-");
            } else {
                fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set(" ");
                fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set(" ");
            }
        } else if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set("-");
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set("-");
        } else {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMov().set(" ");
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalMovOrg().set(" ");
        }
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CMoedIsoOrg().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        if (hv00201Movhst().movhst().mSldoCbloApos().isLess(0)) {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalSld().set("-");
        } else {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalSld().set(" ");
        }
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        if (hv00201Movhst().movhst().mSldoDpnlApos().isLess(0)) {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalDpnl().set("-");
        } else {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500SinalDpnl().set(" ");
        }
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500MMovMoeOrig().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        if (hv10201Movhstcpl().movhstcpl().cOperador().isEqual(0)) {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500COperador().set(hv10201Movhstcpl().movhstcpl().cUserid());
        } else {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500COperador().set(hv10201Movhstcpl().movhstcpl().cOperador());
        }
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500CTerminal().set(hv10201Movhstcpl().movhstcpl().cTerminal());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fwk500().regFwk500().fwk500FicheiroFgh871().fwk500AApl().set(hv00201Movhst().movhst().aAplOrig());
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk500().regFwk500().fwk500FicheiroFgh871().fwk500DDesc().set(hv00201Movhst().movhst().xRefMov());
        }
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK500-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK500-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK500-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK500-TS-PEDIDO
         */
        fwk500().regFwk500().fwk500Pedido().fwk500CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk500().regFwk500().fwk500Pedido().fwk500ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk500().regFwk500().fwk500Pedido().fwk500ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk500().regFwk500().fwk500Pedido().fwk500TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        fwk500().write(fwk500().regFwk500()) ;
        if (fwk500().getStatusOk()) {
            wsContadores().wsContadorFwk500().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK500 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk500().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31325TrataFwk600() {
        log(TraceLevel.Debug, "A31325-TRATA-FWK600");
        fwk600().regFwk600().initialize() ;
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600TsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600ZValor().set(hv00201Movhst().movhst().zValMov());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600ZMovimento().set(hv00201Movhst().movhst().zMovLocl());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MMovimento().set(hv00201Movhst().movhst().mMovimento());
        if (hv00201Movhst().movhst().iEstorno().isEmpty()) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("D")) {
                fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set("-");
                fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set("-");
            } else {
                fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set(" ");
                fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set(" ");
            }
        } else if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set("-");
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMov().set(" ");
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalMovOrg().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600CMoedIsoOrg().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        if (hv00201Movhst().movhst().mSldoCbloApos().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalSld().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalSld().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        if (hv00201Movhst().movhst().mSldoDpnlApos().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalDpnl().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalDpnl().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MMovMoeOrig().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600DDesc().set(hv00201Movhst().movhst().xRefMov());
        }
        if (hv10201Movhstcpl().movhstcpl().mSldoRetd().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoRetd().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoRetd().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MSldoRetd().set(hv10201Movhstcpl().movhstcpl().mSldoRetd());
        if (hv10201Movhstcpl().movhstcpl().mSldoVcob().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoVcob().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalSldoVcob().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MSldoVcob().set(hv10201Movhstcpl().movhstcpl().mSldoVcob());
        if (hv10201Movhstcpl().movhstcpl().mCmrgLim().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgLim().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgLim().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
        if (hv10201Movhstcpl().movhstcpl().mCmrgUtid().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgUtid().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalCmrgUtid().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MCmrgUtid().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
        if (hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdAtrd().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdAtrd().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MDcboNgcdAtrd().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd());
        if (hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid().isLess(0)) {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdUtid().set("-");
        } else {
            fwk600().regFwk600().fwk600FicheiroFgh872().fwk600SinalDcboNgcdUtid().set(" ");
        }
        fwk600().regFwk600().fwk600FicheiroFgh872().fwk600MDcboNgcdUtid().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK600-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK600-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK600-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK600-TS-PEDIDO
         */
        fwk600().regFwk600().fwk600Pedido().fwk600CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk600().regFwk600().fwk600Pedido().fwk600ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk600().regFwk600().fwk600Pedido().fwk600ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk600().regFwk600().fwk600Pedido().fwk600TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        fwk600().write(fwk600().regFwk600()) ;
        if (fwk600().getStatusOk()) {
            wsContadores().wsContadorFwk600().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK600 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk600().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31326PreencheFwk700() {
        log(TraceLevel.Debug, "A31326-PREENCHE-FWK700");
        fwk700().regFwk700().initialize() ;
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700TsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700ZValor().set(hv00201Movhst().movhst().zValMov());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700ZMovimento().set(hv00201Movhst().movhst().zMovLocl());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700IDbcr().set(hv00201Movhst().movhst().iDbcr());
        if (hv00201Movhst().movhst().iEstorno().isEmpty()) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("D")) {
                fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set("-");
                fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set("-");
            } else {
                fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set(" ");
                fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set(" ");
            }
        } else if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set("-");
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set("-");
        } else {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMov().set(" ");
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalMovOrg().set(" ");
        }
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CMoedIsoOrg().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        if (hv00201Movhst().movhst().mSldoCbloApos().isLess(0)) {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalSld().set("-");
        } else {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalSld().set(" ");
        }
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700MSldoCblo().set(hv00201Movhst().movhst().mSldoCbloApos());
        if (hv00201Movhst().movhst().mSldoDpnlApos().isLess(0)) {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalDpnl().set("-");
        } else {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700SinalDpnl().set(" ");
        }
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700MSldoDpnl().set(hv00201Movhst().movhst().mSldoDpnlApos());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700MMovMoeOrig().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CProduto().set(hv10201Movhstcpl().movhstcpl().cProduto());
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700DDesc().set(hrMghk800a().bghl800a().output().xRefMov());
        } else {
            fwk700().regFwk700().fwk700FicheiroFgh873().fwk700DDesc().set(hv00201Movhst().movhst().xRefMov());
        }
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CSectGrupo().set(hv10201Movhstcpl().movhstcpl().cTipoIttz());
        fwk700().regFwk700().fwk700FicheiroFgh873().fwk700CCndzCont().set(hv10201Movhstcpl().movhstcpl().cCndzMovzCont());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK700-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK700-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK700-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK700-TS-PEDIDO
         */
        fwk700().regFwk700().fwk700Pedido().fwk700CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk700().regFwk700().fwk700Pedido().fwk700ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk700().regFwk700().fwk700Pedido().fwk700ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk700().regFwk700().fwk700Pedido().fwk700TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        fwk700().write(fwk700().regFwk700()) ;
        if (fwk700().getStatusOk()) {
            wsContadores().wsContadorFwk700().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK700 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk700().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31327PreencheFwk210() {
        log(TraceLevel.Debug, "A31327-PREENCHE-FWK210");
        fwk210().regFwk210().initialize() ;
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210ZMovimento().set(hv00201Movhst().movhst().tsMovimento().get(1, 10));
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210ZValMov().set(hv00201Movhst().movhst().zValMov());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210MSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210AAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210COpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        fwk210().regFwk210().fwk210FicheiroFgh513().fwk210CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK210-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK210-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK210-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK210-TS-PEDIDO
         */
        fwk210().regFwk210().fwk210Pedido().fwk210CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk210().regFwk210().fwk210Pedido().fwk210ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk210().regFwk210().fwk210Pedido().fwk210ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk210().regFwk210().fwk210Pedido().fwk210TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        /**
         * PRC19 - FIM
         */
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk210().regFwk210().fwk210FicheiroFgh513().fwk210XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fwk210().write(fwk210().regFwk210()) ;
        if (fwk210().getStatusOk()) {
            wsContadores().wsContadorFwk210().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK210 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk210().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31328PreencheFwk220() {
        log(TraceLevel.Debug, "A31328-PREENCHE-FWK220");
        fwk220().regFwk220().initialize() ;
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CBancCont().set(hv00201Movhst().movhst().cBancCont());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220VChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220ZMovimento().set(hv00201Movhst().movhst().tsMovimento().get(1, 10));
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220ZValMov().set(hv00201Movhst().movhst().zValMov());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().set(hv00201Movhst().movhst().iDbcr());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento().set(hv00201Movhst().movhst().mMovimento());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IEstorno().set(hv00201Movhst().movhst().iEstorno());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220XRefMov().set(hv00201Movhst().movhst().xRefMov());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220AAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PED-INF-OPPS     TO FWK220-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV         TO FWK220-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV          TO FWK220-Z-FIM-MOV
         * MOVE FGH015-TS-PEDIDO          TO FWK220-TS-PEDIDO
         */
        fwk220().regFwk220().fwk220Pedido().fwk220CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        fwk220().regFwk220().fwk220Pedido().fwk220ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        fwk220().regFwk220().fwk220Pedido().fwk220ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        fwk220().regFwk220().fwk220Pedido().fwk220TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        /**
         * PRC19 - FIM
         */
        if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
            hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31399BuscaDescricao() ;
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fwk220().write(fwk220().regFwk220()) ;
        if (fwk220().getStatusOk()) {
            wsContadores().wsContadorFwk220().add(1);
        } else {
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - FWK220 - WRITE- ");
            tabelaImpressao().linha09().impStatus().set(fwk220().getStatus());
            setReturnCode(16) ;
            progStatus.set(16);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31329AcedeTgh00008() {
        log(TraceLevel.Debug, "A31329-ACEDE-TGH00008");
        hv00801Refmcbl().refmcbl().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00801_REFMCBL
         */
        hv00801Refmcbl().selectPghq500a1898(hv00201Movhst().movhst()) ;
        if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv00801Refmcbl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - SELECT  - VGH00801 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31399BuscaDescricao() {
        log(TraceLevel.Debug, "A31399-BUSCA-DESCRICAO");
        if (!haTgh102.isTrue()) {
            a31310AcedeInfComplementar() ;
        }
        if (progOk.isTrue()) {
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
    }
    
    /**
     * 
     * 
     */
    protected void a31400CloseC1() {
        log(TraceLevel.Debug, "A31400-CLOSE-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv00201Movhst().closePghq500a2011() ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ500A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActualizaPedido() {
        log(TraceLevel.Debug, "A32000-ACTUALIZA-PEDIDO");
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-CONT  TO VGH01501-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT       TO VGH01501-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-CONT     TO VGH01501-C-OE-EGC-CONT
         * MOVE FGH015-NS-RDCL-CONT      TO VGH01501-NS-RDCL-CONT
         * MOVE FGH015-V-CHKD-CONT       TO VGH01501-V-CHKD-CONT
         * MOVE FGH015-C-TIPO-CONT       TO VGH01501-C-TIPO-CONT
         * MOVE FGH015-C-MOED-ISO-SCTA   TO VGH01501-C-MOED-ISO-SCTA
         * MOVE FGH015-NS-DEPOSITO       TO VGH01501-NS-DEPOSITO
         * MOVE FGH015-C-PED-INF-OPPS    TO VGH01501-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV        TO VGH01501-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV         TO VGH01501-Z-FIM-MOV
         */
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk800().regFwk800Pghq500a().fwk800CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk800().regFwk800Pghq500a().fwk800CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk800().regFwk800Pghq500a().fwk800COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk800().regFwk800Pghq500a().fwk800NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk800().regFwk800Pghq500a().fwk800VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk800().regFwk800Pghq500a().fwk800CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk800().regFwk800Pghq500a().fwk800CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk800().regFwk800Pghq500a().fwk800NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        wsFgh015().fgh015CPaisIsoaCont().set(fwk800().regFwk800Pghq500a().fwk800CPaisIsoaCont());
        wsFgh015().fgh015CBancCont().set(fwk800().regFwk800Pghq500a().fwk800CBancCont());
        wsFgh015().fgh015COeEgcCont().set(fwk800().regFwk800Pghq500a().fwk800COeEgcCont());
        wsFgh015().fgh015NsRdclCont().set(fwk800().regFwk800Pghq500a().fwk800NsRdclCont());
        wsFgh015().fgh015VChkdCont().set(fwk800().regFwk800Pghq500a().fwk800VChkdCont());
        wsFgh015().fgh015CTipoCont().set(fwk800().regFwk800Pghq500a().fwk800CTipoCont());
        wsFgh015().fgh015CMoedIsoScta().set(fwk800().regFwk800Pghq500a().fwk800CMoedIsoScta());
        wsFgh015().fgh015NsDeposito().set(fwk800().regFwk800Pghq500a().fwk800NsDeposito());
        wsFgh015().fgh015CPedInfOpps().set(fwk800().regFwk800Pghq500a().fwk800CPedInfOpps());
        wsFgh015().fgh015ZInicMov().set(fwk800().regFwk800Pghq500a().fwk800ZInicMov());
        wsFgh015().fgh015ZFimMov().set(fwk800().regFwk800Pghq500a().fwk800ZFimMov());
        wsFgh015().fgh015TsPedido().set(fwk800().regFwk800Pghq500a().fwk800TsPedido());
        wsFgh015().fgh015ZPedido().set(fwk800().regFwk800Pghq500a().fwk800ZPedido());
        wsFgh015().fgh015CEstPedHist().set(fwk800().regFwk800Pghq500a().fwk800CEstPedHist());
        wsFgh015().fgh015CTipoRpte().set(fwk800().regFwk800Pghq500a().fwk800CTipoRpte());
        wsFgh015().fgh015NmFichOutpRtno().set(fwk800().regFwk800Pghq500a().fwk800NmFichOutpRtno());
        wsFgh015().fgh015AAplDest().set(fwk800().regFwk800Pghq500a().fwk800AAplDest());
        wsFgh015().fgh015CFrmtInf().set(fwk800().regFwk800Pghq500a().fwk800CFrmtInf());
        wsFgh015().fgh015CCanlTrmzInf().set(fwk800().regFwk800Pghq500a().fwk800CCanlTrmzInf());
        wsFgh015().fgh015CEndcFtpDest().set(fwk800().regFwk800Pghq500a().fwk800CEndcFtpDest());
        wsFgh015().fgh015ZCluzPed().set(fwk800().regFwk800Pghq500a().fwk800ZCluzPed());
        wsFgh015().fgh015QDiaDpnzInf().set(fwk800().regFwk800Pghq500a().fwk800QDiaDpnzInf());
        wsFgh015().fgh015MParmPedHstMax().set(fwk800().regFwk800Pghq500a().fwk800MParmPedHstMax());
        wsFgh015().fgh015MParmPedHstMin().set(fwk800().regFwk800Pghq500a().fwk800MParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMax().set(fwk800().regFwk800Pghq500a().fwk800CParmPedHstMax());
        wsFgh015().fgh015CParmPedHstMin().set(fwk800().regFwk800Pghq500a().fwk800CParmPedHstMin());
        wsFgh015().fgh015CParmPedHstMin().set(fwk800().regFwk800Pghq500a().fwk800CParmPedHstMin());
        wsFgh015().fgh015XMtvoDvlzPed().set(fwk800().regFwk800Pghq500a().fwk800XMtvoDvlzPed());
        wsFgh015().fgh015ZEliminacao().set(fwk800().regFwk800Pghq500a().fwk800ZEliminacao());
        wsFgh015().fgh015CUsidCrix().set(fwk800().regFwk800Pghq500a().fwk800CUsidCrix());
        wsFgh015().fgh015CPaisIsoaOeOpx().set(fwk800().regFwk800Pghq500a().fwk800CPaisIsoaOeOpx());
        wsFgh015().fgh015CMnemEgcOpex().set(fwk800().regFwk800Pghq500a().fwk800CMnemEgcOpex());
        wsFgh015().fgh015COeEgcOpex().set(fwk800().regFwk800Pghq500a().fwk800COeEgcOpex());
        wsFgh015().fgh015QDdbtPed().set(fwk800().regFwk800Pghq500a().fwk800QDdbtPed());
        wsFgh015().fgh015TsActzUlt().set(fwk800().regFwk800Pghq500a().fwk800TsActzUlt());
        wsFgh015().fgh015CUsidActzUlt().set(fwk800().regFwk800Pghq500a().fwk800CUsidActzUlt());
        log(TraceLevel.Debug, "A32000-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(wsFgh015().fgh015CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(wsFgh015().fgh015CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(wsFgh015().fgh015COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(wsFgh015().fgh015NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(wsFgh015().fgh015VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(wsFgh015().fgh015CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(wsFgh015().fgh015CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(wsFgh015().fgh015NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(wsFgh015().fgh015CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsFgh015().fgh015ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsFgh015().fgh015ZFimMov());
        a32100AcedePedido() ;
        if (progOk.isTrue()) {
            a32200ActualizaPedido() ;
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
            tabelaImpressao().linha05().impRegLidosFwk800().set(wsContadores().wsContadorPedidos());
            tabelaImpressaoMask().zimp().setIndex(5) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK200");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk200());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK210");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk210());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK220");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk220());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK300");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk300());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK400");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk400());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK500");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk500());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK600");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk600());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK700");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorFwk700());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ500A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fwk200().close() ;
        fwk210().close() ;
        fwk220().close() ;
        fwk300().close() ;
        fwk400().close() ;
        fwk500().close() ;
        fwk600().close() ;
        fwk700().close() ;
        fwk800().close() ;
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
            while (!fwk800().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * PRC19 - INI
     * 
     * @version 2.0
     * 
     */
    public interface WsFgh015 extends IDataStruct {
        
        @Data(size=3)
        IString fgh015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh015CTipoCont() ;
        
        @Data(size=3)
        IString fgh015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015NsDeposito() ;
        
        @Data(size=7)
        IString fgh015CPedInfOpps() ;
        
        @Data(size=10)
        IString fgh015ZInicMov() ;
        
        @Data(size=10)
        IString fgh015ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh015TsPedido() ;
        
        @Data(size=10)
        IString fgh015ZPedido() ;
        
        @Data(size=1)
        IString fgh015CEstPedHist() ;
        
        @Data(size=1)
        IString fgh015CTipoRpte() ;
        
        @Data(size=20)
        IString fgh015NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fgh015AAplDest() ;
        
        @Data(size=1)
        IString fgh015CFrmtInf() ;
        
        @Data(size=2)
        IString fgh015CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fgh015CEndcFtpDest() ;
        
        @Data(size=10)
        IString fgh015ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh015QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh015MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh015MParmPedHstMin() ;
        
        @Data(size=15)
        IString fgh015CParmPedHstMax() ;
        
        @Data(size=15)
        IString fgh015CParmPedHstMin() ;
        
        @Data(size=40)
        IString fgh015XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fgh015ZEliminacao() ;
        
        @Data(size=8)
        IString fgh015CUsidCrix() ;
        
        @Data(size=3)
        IString fgh015CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh015CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh015QDdbtPed() ;
        
        @Data(size=26)
        IString fgh015TsActzUlt() ;
        
        @Data(size=8)
        IString fgh015CUsidActzUlt() ;
        
    }
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
        ILong wsContadorFwk200() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk210() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk220() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk300() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk400() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk500() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk600() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorFwk700() ;
        
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
            
            @Data(size=8, value="PGHQ500A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ500A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK800")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk800() ;
            
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
