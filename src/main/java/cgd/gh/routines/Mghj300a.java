package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl300a ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.pu.structures.link.Bpul300a ;
import cgd.pk.structures.link.Bpkl300a ;
import cgd.pu.routines.Mpuj300a ;
import cgd.pk.routines.Mpkj300a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : MGHJ300A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1692 - TERC - 3ª FASE - TRANSACOES OCASIONIAS
 * FUNCAO     : CONSULTA DO ESTADO ORDENS EMITIDAS OU RECEBIDAS.
 * SE O ESTADO FOR FINAL E FEITO UPDATE DO ESTADO
 * NA TGH00130.
 * TIPO       : ROTINA MISTA C/ DB2
 * OBSERVACOES:
 * AREA DE LIGACAO: BGHL300A
 * LOG DE ALTERACOES
 * *PROC.GIP !   DATA   !UTILIZ.! OBSERVACOES
 * GH1692  !2015-03-04!ACT0649! TERC - FASE 3 -  CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * migrated from program [MGHJ300A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj300a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl300a
     */
    @Data
    public abstract Bghl300a bghl300a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps13001Movdep
     */
    @Data
    protected abstract Vwsdghps13001Movdep hv13001Movdep() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mpuj300a
     */
    @Data
    protected abstract Mpuj300a hrMpuj300a() ;
    
    /**
     * @return instancia da classe Mpkj300a
     */
    @Data
    protected abstract Mpkj300a hrMpkj300a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bpul300a
     */
    @Data
    protected abstract Bpul300a bpul300a() ;
    
    /**
     * @return instancia da classe Bpkl300a
     */
    @Data
    protected abstract Bpkl300a bpkl300a() ;
    
    /**
     * ----- ROTINA
     */
    protected static final String CON_MGHJ300A = "MGHJ300A" ;
    
    protected static final String CON_VGH13001 = "MGHJ300A" ;
    
    protected static final String CON_GH = "GH" ;
    
    /**
     * ----- DB2
     */
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_INSERT = "IN" ;
    
    protected static final String CON_UPDATE = "UP" ;
    
    protected static final String CON_DELETE = "DL" ;
    
    /**
     * *---TIPO DE OPERACAO
     */
    protected static final String CON_ORDENS_RECEBIDAS = "R" ;
    
    protected static final String CON_ORDENS_EMITIDAS = "S" ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_1 = 1 ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MPUJ300A - CONSULTA DA TABELA DE ORDENS EMITIDAS
     * 
     */
    public void bpup0300OrdensEmit() {
        hrMpuj300a().run() ;
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MPKJ300A - CONSULTA DA TABELA DE ORDENS RECEBIDAS
     * 
     */
    public void bpkp5300OrdensRecb() {
        hrMpkj300a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    public void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (bghl300a().commarea().erros().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
        }
        m3000MostraSaida() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    public void m1000InicioPrograma() {
        log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
        m1100Inicializacoes() ;
        m1200ValidaInput() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    public void m1100Inicializacoes() {
        log(TraceLevel.Debug, "  1100-INICIALIZACOES");
        bghl300a().commarea().dadosSaida().initialize() ;
        bghl300a().commarea().erros().initialize() ;
        hv13001Movdep().movdep().initialize() ;
    }
    
    /**
     * 
     * 1200-VALIDA-INPUT
     * 
     */
    public void m1200ValidaInput() {
        log(TraceLevel.Debug, "  1200-VALIDA-INPUT");
        /**
         * --
         */
        if (bghl300a().commarea().erros().semErros().isTrue() && !bghl300a().commarea().dadosEntrada().visualizacao().isTrue() && 
            !bghl300a().commarea().dadosEntrada().insercao().isTrue() && 
            !bghl300a().commarea().dadosEntrada().modificacao().isTrue() && 
            !bghl300a().commarea().dadosEntrada().eliminacao().isTrue()) {
            bghl300a().commarea().erros().erroFuncao().setTrue() ;
            bghl300a().commarea().erros().aAplErr().set(CON_GH);
            bghl300a().commarea().erros().cRtnoEvenSwal().set(bghk0001().erros().inputInvalido());
            /**
             * THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 55
             */
            bghl300a().commarea().erros().msgErrob().set("DADOS DE INPUT INVALIDOS");
            bghl300a().commarea().erros().modOrigemErro().set(CON_MGHJ300A);
            bghl300a().commarea().erros().chAcesso().set(bghl300a().commarea().dadosEntrada());
            log(TraceLevel.Error, "  ERRO-01");
            log(TraceLevel.Error, "   I-ACCAO-TAB-BBN : ", bghl300a().commarea().dadosEntrada().iAccaoTabBbn());
        }
        /**
         * --
         */
        if (bghl300a().commarea().erros().semErros().isTrue()) {
            if (bghl300a().commarea().dadosEntrada().cPaisIsoAlfn().isEmpty() || 
                bghl300a().commarea().dadosEntrada().cMnemEmpGcx().isEmpty() || 
                bghl300a().commarea().dadosEntrada().cRefMsgSwif().isEmpty() || 
                bghl300a().commarea().dadosEntrada().cTipoOpeCont().isEmpty()) {
                bghl300a().commarea().erros().erroFuncao().setTrue() ;
                bghl300a().commarea().erros().aAplErr().set(CON_GH);
                bghl300a().commarea().erros().cRtnoEvenSwal().set(bghk0001().erros().inputInvalido());
                bghl300a().commarea().erros().msgErrob().set("DADOS DE INPUT INVALIDOS");
                bghl300a().commarea().erros().modOrigemErro().set(CON_MGHJ300A);
                bghl300a().commarea().erros().chAcesso().set(bghl300a().commarea().dadosEntrada());
                log(TraceLevel.Error, "  ERRO-02");
                log(TraceLevel.Error, "   DADOS DE INPUT INVALIDOS");
                log(TraceLevel.Error, "   ", bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
                log(TraceLevel.Error, "   ", bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
                log(TraceLevel.Error, "   ", bghl300a().commarea().dadosEntrada().cRefMsgSwif());
                log(TraceLevel.Error, "   ", bghl300a().commarea().dadosEntrada().cTipoOpeCont());
            }
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    public void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "   BGHL300A-C-PAIS-ISO-ALFN : ", bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   BGHL300A-C-MNEM-EMP-GCX  : ", bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
        log(TraceLevel.Debug, "   BGHL300A-C-REF-MSG-SWIF  : ", bghl300a().commarea().dadosEntrada().cRefMsgSwif());
        log(TraceLevel.Debug, "   BGHL300A-C-TIPO-OPE-CONT : ", bghl300a().commarea().dadosEntrada().cTipoOpeCont());
        swSwitches().swCTipoOpeCont().set(bghl300a().commarea().dadosEntrada().cTipoOpeCont());
        /**
         * -- AVALIA BGHL300A-C-TIPO-OPE-CONT
         */
        if (swSwitches().swOrdensEmitidas().isTrue()) {
            m2100VerOrdemEmit() ;
        } else if (swSwitches().swOrdensRecebidas().isTrue()) {
            m2200VerOrdemRecb() ;
        }
        if (bghl300a().commarea().erros().semErros().isTrue() && bghl300a().commarea().dadosEntrada().modificacao().isTrue()) {
            if (!bghl300a().commarea().dadosEntrada().cEstMsgSwifI().isEqual(bghl300a().commarea().dadosSaida().cEstMsgSwifO())) {
                m2300UpdEstOrdem130() ;
            }
        }
    }
    
    /**
     * 
     * 2100-VER-ORDEM-EMIT
     * 
     */
    public void m2100VerOrdemEmit() {
        log(TraceLevel.Debug, "  2100-VER-ORDEM-EMIT");
        bpul300a().commarea().initialize() ;
        bpul300a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bpul300a().commarea().dadosEntrada().cPaisIsoAlfn().set(bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
        bpul300a().commarea().dadosEntrada().cMnemEmpGcx().set(bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
        bpul300a().commarea().dadosEntrada().cRefMsgSwif().set(bghl300a().commarea().dadosEntrada().cRefMsgSwif());
        bpup0300OrdensEmit() ;
        if (!bpul300a().commarea().dadosSaida().semErros().isTrue()) {
            bghl300a().commarea().erros().cTipoErroBbn().set(bpul300a().commarea().dadosSaida().cTipoErroBbn());
            bghl300a().commarea().erros().cRtnoEvenSwal().set(bpul300a().commarea().dadosSaida().cRtnoEvenSwal());
            bghl300a().commarea().erros().cSqlcode().set(bpul300a().commarea().dadosSaida().cSqlcode());
            bghl300a().commarea().erros().aAplErr().set(bpul300a().commarea().dadosSaida().aAplErr());
            bghl300a().commarea().erros().msgErrob().set(bpul300a().commarea().dadosSaida().msgErrob());
            bghl300a().commarea().erros().nmTabela().set(bpul300a().commarea().dadosSaida().nmTabela());
            bghl300a().commarea().erros().modOrigemErro().set(bpul300a().commarea().dadosSaida().modOrigemErro());
            bghl300a().commarea().erros().chAcesso().set(bpul300a().commarea().dadosSaida().chAcesso());
            log(TraceLevel.Error, "  ERRO-03");
        } else {
            bghl300a().commarea().dadosSaida().cEstMsgSwifO().set(bpul300a().commarea().dadosSaida().cEstMsgSwif1());
            swSwitches().swCEstMsgSwif().set(bpul300a().commarea().dadosSaida().cEstMsgSwif1());
        }
    }
    
    /**
     * 
     * 2200-VER-ORDEM-RECB
     * 
     */
    public void m2200VerOrdemRecb() {
        log(TraceLevel.Debug, "  2200-VER-ORDEM-RECB");
        bpkl300a().commarea().initialize() ;
        bpkl300a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bpkl300a().commarea().dadosEntrada().cPaisIsoAlfn().set(bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
        bpkl300a().commarea().dadosEntrada().cMnemEmpGcx().set(bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
        bpkl300a().commarea().dadosEntrada().cRefMsgSwif().set(bghl300a().commarea().dadosEntrada().cRefMsgSwif());
        bpkp5300OrdensRecb() ;
        if (!bpkl300a().commarea().dadosSaida().semErros().isTrue()) {
            bghl300a().commarea().erros().cTipoErroBbn().set(bpkl300a().commarea().dadosSaida().cTipoErroBbn());
            bghl300a().commarea().erros().cRtnoEvenSwal().set(bpkl300a().commarea().dadosSaida().cRtnoEvenSwal());
            bghl300a().commarea().erros().cSqlcode().set(bpkl300a().commarea().dadosSaida().cSqlcode());
            bghl300a().commarea().erros().aAplErr().set(bpkl300a().commarea().dadosSaida().aAplErr());
            bghl300a().commarea().erros().msgErrob().set(bpkl300a().commarea().dadosSaida().msgErrob());
            bghl300a().commarea().erros().nmTabela().set(bpkl300a().commarea().dadosSaida().nmTabela());
            bghl300a().commarea().erros().modOrigemErro().set(bpkl300a().commarea().dadosSaida().modOrigemErro());
            bghl300a().commarea().erros().chAcesso().set(bpkl300a().commarea().dadosSaida().chAcesso());
            log(TraceLevel.Error, "  ERRO-04");
        } else {
            bghl300a().commarea().dadosSaida().cEstMsgSwifO().set(bpkl300a().commarea().dadosSaida().cEstMsgSwif1());
            swSwitches().swCEstMsgSwif().set(bpkl300a().commarea().dadosSaida().cEstMsgSwif1());
        }
    }
    
    /**
     * 
     * 2300-UPD-EST-ORDEM-130
     * 
     */
    public void m2300UpdEstOrdem130() {
        log(TraceLevel.Debug, "  2300-UPD-EST-ORDEM-130");
        /**
         * -- CHAVE
         */
        hv13001Movdep().movdep().cPaisIsoAlfn().set(bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
        hv13001Movdep().movdep().cMnemEmpGcx().set(bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
        hv13001Movdep().movdep().cRefMsgSwif().set(bghl300a().commarea().dadosEntrada().cRefMsgSwif());
        /**
         * -- AVALIA BGHL300A-C-TIPO-OPE-CONT
         */
        if (swSwitches().swOrdensEmitidas().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ORDENS_EMITIDAS);
            bghl300a().commarea().dadosEntrada().cTipoOpeCont().set(CON_ORDENS_EMITIDAS);
        } else if (swSwitches().swOrdensRecebidas().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ORDENS_RECEBIDAS);
            bghl300a().commarea().dadosEntrada().cTipoOpeCont().set(CON_ORDENS_RECEBIDAS);
        }
        /**
         * -- UPDATE
         */
        hv13001Movdep().movdep().cEstMsgSwif().set(bghl300a().commarea().dadosSaida().cEstMsgSwifO());
        hv13001Movdep().movdep().cUsidActzUlt().set(CON_MGHJ300A);
        log(TraceLevel.Debug, "      CHAVE...                ");
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISO-ALFN : ", hv13001Movdep().movdep().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   VGH13001-C-MNEM-EMP-GCX  : ", hv13001Movdep().movdep().cMnemEmpGcx());
        log(TraceLevel.Debug, "   VGH13001-C-REF-MSG-SWIF  : ", hv13001Movdep().movdep().cRefMsgSwif());
        log(TraceLevel.Debug, "   VGH13001-C-TIPO-OPE-CONT : ", hv13001Movdep().movdep().cTipoOpeCont());
        log(TraceLevel.Debug, "      UPDATE...               ");
        log(TraceLevel.Debug, "   VGH13001-C-EST-MSG-SWIF  : ", hv13001Movdep().movdep().cEstMsgSwif());
        log(TraceLevel.Debug, "   VGH13001-C-USID-ACTZ-ULT : ", hv13001Movdep().movdep().cUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH13001_MOVDEP
         */
        hv13001Movdep().updateMghj300a446() ;
        swSwitches().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        bghl300a().commarea().erros().cSqlcode().set(hv13001Movdep().getPersistenceCode());
        m9020Db2check() ;
        if (!swSwitches().swVgh13001Ok().isTrue()) {
            bghl300a().commarea().erros().abendDb2().setTrue() ;
            bghl300a().commarea().erros().aAplErr().set(bhtk0002().siglaArquit());
            bghl300a().commarea().erros().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            bghl300a().commarea().erros().aAplErr().set(CON_GH);
            bghl300a().commarea().erros().msgErrob().set(" ERRO NO UPDATE ESTADO");
            bghl300a().commarea().erros().nmTabela().set(CON_VGH13001);
            bghl300a().commarea().erros().modOrigemErro().set(CON_UPDATE);
            bghl300a().commarea().erros().chAcesso().set(bghl300a().commarea().dadosEntrada());
            log(TraceLevel.Error, "  ERRO-05");
            log(TraceLevel.Error, "   ERRO UPDATE ESTADO TGH130-SQLCODE :", swSwitches().swSqlcodeVgh13001());
            log(TraceLevel.Error, "   CHAVE  : ");
            log(TraceLevel.Error, "     C-PAIS ", hv13001Movdep().movdep().cPaisIsoAlfn());
            log(TraceLevel.Error, "     C-MNEM ", hv13001Movdep().movdep().cMnemEmpGcx());
            log(TraceLevel.Error, "     C-REF- ", hv13001Movdep().movdep().cRefMsgSwif());
            log(TraceLevel.Error, "     C-TIPO ", hv13001Movdep().movdep().cTipoOpeCont());
        }
    }
    
    /**
     * 
     * 3000-MOSTRA-SAIDA
     * 
     */
    public void m3000MostraSaida() {
        log(TraceLevel.Debug, " 3000-MOSTRA-SAIDA      ");
        log(TraceLevel.Debug, "   BGHL300A-C-PAIS-ISO-ALFN      : ", bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   BGHL300A-C-MNEM-EMP-GCX       : ", bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
        log(TraceLevel.Debug, "   BGHL300A-C-REF-MSG-SWIF       : ", bghl300a().commarea().dadosEntrada().cRefMsgSwif());
        log(TraceLevel.Debug, "   BGHL300A-C-TIPO-OPE-CONT      : ", bghl300a().commarea().dadosEntrada().cTipoOpeCont());
        log(TraceLevel.Debug, "   BGHL300A-C-EST-MSG-SWIF-I     : ", bghl300a().commarea().dadosEntrada().cEstMsgSwifI());
        log(TraceLevel.Debug, "   ............................... ");
        log(TraceLevel.Debug, "   BGHL300A-C-EST-MSG-SWIF-O     : ", bghl300a().commarea().dadosSaida().cEstMsgSwifO());
        log(TraceLevel.Debug, "   ............................... ");
        log(TraceLevel.Debug, "   BGHL300A-C-TIPO-ERRO-BBN      : ", bghl300a().commarea().erros().cTipoErroBbn());
        log(TraceLevel.Debug, "   BGHL300A-C-RTNO-EVEN-SWAL     : ", bghl300a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, "   BGHL300A-C-SQLCODE            : ", bghl300a().commarea().erros().cSqlcode());
        log(TraceLevel.Debug, "   BGHL300A-A-APL-ERR            : ", bghl300a().commarea().erros().aAplErr());
        log(TraceLevel.Debug, "   BGHL300A-MSG-ERROB            : ", bghl300a().commarea().erros().msgErrob());
        log(TraceLevel.Debug, "   BGHL300A-NM-TABELA            : ", bghl300a().commarea().erros().nmTabela());
        log(TraceLevel.Debug, "   ............................... ");
        log(TraceLevel.Debug, "   SAIU MGHJ300A                   ");
        log(TraceLevel.Debug, "   ");
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        m0000Mainline() ;
    }
    
    
    /**
     * 
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
    }
    
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        /**
         * ---- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh13001() ;
        @Data
        @Condition("0")
        ICondition swVgh13001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh13001Notfnd() ;
        
        
        /**
         * *----- TABELA GERAL LOGICA 'G65' - TIPO DE OPERACAO NA CONTA
         */
        @Data(size=1, value=" ")
        IString swCTipoOpeCont() ;
        @Data
        @Condition("C")
        ICondition swCambio() ;
        @Data
        @Condition("D")
        ICondition swTrocoDestroco() ;
        @Data
        @Condition({ "T", "S", "R" })
        ICondition swTransferencias() ;
        @Data
        @Condition({ "S", "U", "W" })
        ICondition swOrdensEmitidas() ;
        @Data
        @Condition("R")
        ICondition swOrdensRecebidas() ;
        @Data
        @Condition({ "O", "C", "D", "T", "S", "R" })
        ICondition swOcasionais() ;
        @Data
        @Condition({ "U", "W", "Z" })
        ICondition swAnulacoesEstornosRef() ;
        @Data
        @Condition("U")
        ICondition swPi3105EstornoOrdens() ;
        @Data
        @Condition("W")
        ICondition swPi3102AnulacaoOrdens() ;
        @Data
        @Condition("Z")
        ICondition swPi3503AnulEstorChq() ;
        
        
        /**
         * *----- AVALIA ESTADO DA ORDEM - C-EST-MSG-SWIF
         */
        @Data(size=2, value="0")
        IInt swCEstMsgSwif() ;
        @Data
        @Condition("02")
        ICondition swEnviada() ;
        @Data
        @Condition("16")
        ICondition swAnulada() ;
        @Data
        @Condition("18")
        ICondition swDevolvida() ;
        @Data
        @Condition("28")
        ICondition swLiquidada() ;
        @Data
        @Condition("31")
        ICondition swEstornada() ;
        @Data
        @Condition("38")
        ICondition swAgrdDevolFundos() ;
        @Data
        @Condition("53")
        ICondition swFundosDesviados() ;
        @Data
        @Condition({ "02", "6", "18", "28", "38", "53" })
        ICondition swEstFinalValidos() ;
        
        
    }
}
