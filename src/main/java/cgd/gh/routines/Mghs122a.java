package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl122a ;
import cgd.gh.common.constants.Bghk0001 ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : MGHS122A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1516
 * FUNCAO     : OBTENCAO DA CHAVE DE JOURNAL COMPLETA DE
 * MOVIMENTOS EM HISTORICO ATE 3 ANOS
 * (CONSULTADOS NA MVPHI0)
 * TIPO       : ROTINA ONLINE C/ DB2
 * OBSERVACOES: ROTINA CRIADA PARA A MVPHIG (PROJETO TERC)
 * AREA DE LIGACAO: BGHL122A
 * LOG DE ALTERACOES
 * PROCESSO GIP !   DATA   ! UTILIZADOR ! OBSERVACOES
 * GH1516     2014-08-20   ACT0701       CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * migrated from program [MGHS122A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs122a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl122a
     */
    @Data
    public abstract Bghl122a bghl122a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * ----- ROTINA
     */
    protected static final String CON_MGHS122A = "MGHS122A" ;
    
    protected static final String CON_VGH02201 = "VGH02201" ;
    
    protected static final String CON_VGH10201 = "VGH10201" ;
    
    protected static final String CON_GH = "GH" ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_1 = 1 ;
    
    /**
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
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
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    public void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (bghl122a().commarea().erros().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
        }
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
        wsVariaveis().initialize() ;
        bghl122a().commarea().detalhe().initialize() ;
        bghl122a().commarea().erros().initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv02201Movdiaant().movdiaant().initialize() ;
        hv00201Movhst().movhst().initialize() ;
    }
    
    /**
     * 
     * 1200-VALIDA-INPUT
     * 
     */
    public void m1200ValidaInput() {
        log(TraceLevel.Debug, "  1200-VALIDA-INPUT");
        /**
         * FORMATACAO DE ERRO FUNCIONAL
         */
        if (bghl122a().commarea().argumento().cPaisIsoaCont().isEmpty() || 
            bghl122a().commarea().argumento().cBancCont().isEqual(0) || 
            bghl122a().commarea().argumento().cOeEgcCont().isEqual(0) || 
            bghl122a().commarea().argumento().nsRdclCont().isEqual(0) || 
            !bghl122a().commarea().argumento().vChkdCont().isNumeric() || 
            bghl122a().commarea().argumento().cMoedIsoScta().isEmpty() || 
            bghl122a().commarea().argumento().tsMovimento().isEmpty() || 
            bghl122a().commarea().argumento().nsMovimento().isEqual(0)) {
            bghl122a().commarea().erros().erroFuncao().setTrue() ;
            bghl122a().commarea().erros().aAplErr().set(CON_GH);
            bghl122a().commarea().erros().cRtnoEvenSwal().set(bghk0001().erros().inputInvalido());
            bghl122a().commarea().erros().msgErrob().set("DADOS DE INPUT INVALIDOS");
            bghl122a().commarea().erros().modOrigemErro().set(CON_MGHS122A);
            bghl122a().commarea().erros().chAcesso().set(bghl122a().commarea().argumento());
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    public void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        if (bghl122a().commarea().erros().semErros().isTrue()) {
            if (bghl122a().commarea().criterioConsulta().movHstS().isTrue()) {
                m2100AcedeHist102() ;
            } else {
                m2200AcedeHist022() ;
            }
        }
    }
    
    /**
     * 
     * 2100-ACEDE-HIST-102
     * 
     */
    public void m2100AcedeHist102() {
        log(TraceLevel.Debug, "  2100-ACEDE-HIST-102");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv00201Movhst().movhst().initialize() ;
        swSwitches().swNaoHaMov().setTrue() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl122a().commarea().argumento().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl122a().commarea().argumento().cBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl122a().commarea().argumento().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl122a().commarea().argumento().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl122a().commarea().argumento().vChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl122a().commarea().argumento().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl122a().commarea().argumento().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl122a().commarea().argumento().nsDeposito());
        wTsInicio().set(bghl122a().commarea().argumento().tsMovimento());
        wsVariaveis().wsTsInicio().set(bghl122a().commarea().argumento().tsMovimento());
        wTsFim().wsDataFim().set(wTsInicio().wsDataInicio());
        wsVariaveis().wsTsFim().set(wTsFim());
        hv10201Movhstcpl().movhstcpl().nsMovimento().set(bghl122a().commarea().argumento().nsMovimento());
        log(TraceLevel.Debug, "   WS-TS-INICIO: ", wsVariaveis().wsTsInicio());
        log(TraceLevel.Debug, "   WS-TS-FIM   : ", wsVariaveis().wsTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs122a331(wsVariaveis().wsTsInicio(), wsVariaveis().wsTsFim(), hv00201Movhst().movhst().zMovLocl()) ;
        swSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bghl122a().commarea().erros().nmTabela().set(CON_VGH10201);
        /**
         * ---
         */
        if (!swSwitches().swVgh10201Ok().isTrue() && !swSwitches().swVgh10201Notfnd().isTrue()) {
            bghl122a().commarea().erros().abendDb2().setTrue() ;
            bghl122a().commarea().erros().db2().setTrue() ;
            bghl122a().commarea().erros().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            bghl122a().commarea().erros().modOrigemErro().set(CON_MGHS122A);
            bghl122a().commarea().erros().aAplErr().set(CON_GH);
        } else if (swSwitches().swVgh10201Notfnd().isTrue()) {
            bghl122a().commarea().erros().erroFuncao().setTrue() ;
            bghl122a().commarea().erros().naoExiste().setTrue() ;
            bghl122a().commarea().erros().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            bghl122a().commarea().erros().modOrigemErro().set(CON_MGHS122A);
            bghl122a().commarea().erros().aAplErr().set(CON_GH);
            /**
             * --- CHAVE
             */
            wsVariaveis().wsChave().wsCPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
            wsVariaveis().wsChave().wsCBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
            wsVariaveis().wsChave().wsCOeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
            wsVariaveis().wsChave().wsNsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
            wsVariaveis().wsChave().wsVChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
            wsVariaveis().wsChave().wsCTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
            wsVariaveis().wsChave().wsCMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
            wsVariaveis().wsChave().wsNsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
            wsVariaveis().wsChave().wsNsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
            bghl122a().commarea().erros().chAcesso().set(wsVariaveis().wsChave());
        } else {
            swSwitches().swHaMovSim().setTrue() ;
        }
        if (bghl122a().commarea().erros().semErros().isTrue()) {
            if (swSwitches().swHaMovSim().isTrue()) {
                bghl122a().commarea().detalhe().cTransaccao().set(hv10201Movhstcpl().movhstcpl().cTransaccao());
                bghl122a().commarea().detalhe().aAplicacao().set(hv10201Movhstcpl().movhstcpl().aAplicacao());
                bghl122a().commarea().detalhe().cOpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
                bghl122a().commarea().detalhe().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
                bghl122a().commarea().detalhe().cEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
                bghl122a().commarea().detalhe().cTerminal().set(hv10201Movhstcpl().movhstcpl().cTerminal());
                bghl122a().commarea().detalhe().cOperador().set(hv10201Movhstcpl().movhstcpl().cOperador());
                bghl122a().commarea().detalhe().cOpexAtrx().set(hv10201Movhstcpl().movhstcpl().cOpexAtrx());
                bghl122a().commarea().detalhe().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
                bghl122a().commarea().detalhe().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
                bghl122a().commarea().detalhe().cTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
                bghl122a().commarea().detalhe().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
                bghl122a().commarea().detalhe().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
                bghl122a().commarea().detalhe().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
                bghl122a().commarea().detalhe().cProdSgop().set(hv10201Movhstcpl().movhstcpl().cProdSgop());
                bghl122a().commarea().detalhe().cFamiProd().set(hv10201Movhstcpl().movhstcpl().cFamiProd());
                bghl122a().commarea().detalhe().cProduto().set(hv10201Movhstcpl().movhstcpl().cProduto());
                bghl122a().commarea().detalhe().cCndzMovzCont().set(hv10201Movhstcpl().movhstcpl().cCndzMovzCont());
                bghl122a().commarea().detalhe().cGrupCont().set(hv10201Movhstcpl().movhstcpl().cGrupCont());
                bghl122a().commarea().detalhe().cTipoIttz().set(hv10201Movhstcpl().movhstcpl().cTipoIttz());
                bghl122a().commarea().detalhe().tCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
                bghl122a().commarea().detalhe().mSldoRetd().set(hv10201Movhstcpl().movhstcpl().mSldoRetd());
                bghl122a().commarea().detalhe().mSldoVcob().set(hv10201Movhstcpl().movhstcpl().mSldoVcob());
                bghl122a().commarea().detalhe().mCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
                bghl122a().commarea().detalhe().mCmrgUtid().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
                bghl122a().commarea().detalhe().mDcboNgcdAtrd().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd());
                bghl122a().commarea().detalhe().mDcboNgcdUtid().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid());
                bghl122a().commarea().detalhe().nJourBbn().set(hv10201Movhstcpl().movhstcpl().nJourBbn());
                bghl122a().commarea().detalhe().nsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
                bghl122a().commarea().detalhe().nsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
                bghl122a().commarea().detalhe().nmArqvOrig().set(hv10201Movhstcpl().movhstcpl().nmArqvOrig());
                bghl122a().commarea().detalhe().tsActzUlt().set(hv10201Movhstcpl().movhstcpl().tsActzUlt());
                bghl122a().commarea().detalhe().cUsidActzUlt().set(hv10201Movhstcpl().movhstcpl().cUsidActzUlt());
                bghl122a().commarea().detalhe().zProcessamento().set(hv00201Movhst().movhst().zMovLocl());
            }
        }
    }
    
    /**
     * 
     * 2200-ACEDE-HIST-022
     * 
     */
    public void m2200AcedeHist022() {
        log(TraceLevel.Debug, "  2200-ACEDE-HIST-022");
        hv02201Movdiaant().movdiaant().initialize() ;
        hv02201Movdiaant().movdiaant().cPaisIsoaCont().set(bghl122a().commarea().argumento().cPaisIsoaCont());
        hv02201Movdiaant().movdiaant().cBancCont().set(bghl122a().commarea().argumento().cBancCont());
        hv02201Movdiaant().movdiaant().cOeEgcCont().set(bghl122a().commarea().argumento().cOeEgcCont());
        hv02201Movdiaant().movdiaant().nsRdclCont().set(bghl122a().commarea().argumento().nsRdclCont());
        hv02201Movdiaant().movdiaant().vChkdCont().set(bghl122a().commarea().argumento().vChkdCont());
        hv02201Movdiaant().movdiaant().cTipoCont().set(bghl122a().commarea().argumento().cTipoCont());
        hv02201Movdiaant().movdiaant().cMoedIsoScta().set(bghl122a().commarea().argumento().cMoedIsoScta());
        hv02201Movdiaant().movdiaant().nsDeposito().set(bghl122a().commarea().argumento().nsDeposito());
        hv02201Movdiaant().movdiaant().nsMovimento().set(bghl122a().commarea().argumento().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs122a562() ;
        swSwitches().swSqlcodeVgh02201().set(hv02201Movdiaant().getPersistenceCode());
        bghl122a().commarea().erros().nmTabela().set(CON_VGH02201);
        /**
         * ---
         */
        if (!swSwitches().swVgh02201Ok().isTrue() && !swSwitches().swVgh02201Notfnd().isTrue()) {
            bghl122a().commarea().erros().abendDb2().setTrue() ;
            bghl122a().commarea().erros().db2().setTrue() ;
            bghl122a().commarea().erros().cSqlcode().set(swSwitches().swSqlcodeVgh02201());
            bghl122a().commarea().erros().modOrigemErro().set(CON_MGHS122A);
            bghl122a().commarea().erros().aAplErr().set(CON_GH);
        } else if (swSwitches().swVgh02201Notfnd().isTrue()) {
            bghl122a().commarea().erros().erroFuncao().setTrue() ;
            bghl122a().commarea().erros().naoExiste().setTrue() ;
            bghl122a().commarea().erros().cSqlcode().set(swSwitches().swSqlcodeVgh02201());
            bghl122a().commarea().erros().modOrigemErro().set(CON_MGHS122A);
            bghl122a().commarea().erros().aAplErr().set(CON_GH);
            /**
             * --- CHAVE
             */
            wsVariaveis().wsChave().wsCPaisIsoaCont().set(hv02201Movdiaant().movdiaant().cPaisIsoaCont());
            wsVariaveis().wsChave().wsCBancCont().set(hv02201Movdiaant().movdiaant().cBancCont());
            wsVariaveis().wsChave().wsCOeEgcCont().set(hv02201Movdiaant().movdiaant().cOeEgcCont());
            wsVariaveis().wsChave().wsNsRdclCont().set(hv02201Movdiaant().movdiaant().nsRdclCont());
            wsVariaveis().wsChave().wsVChkdCont().set(hv02201Movdiaant().movdiaant().vChkdCont());
            wsVariaveis().wsChave().wsCTipoCont().set(hv02201Movdiaant().movdiaant().cTipoCont());
            wsVariaveis().wsChave().wsCMoedIsoScta().set(hv02201Movdiaant().movdiaant().cMoedIsoScta());
            wsVariaveis().wsChave().wsNsDeposito().set(hv02201Movdiaant().movdiaant().nsDeposito());
            wsVariaveis().wsChave().wsNsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
            bghl122a().commarea().erros().chAcesso().set(wsVariaveis().wsChave());
        } else {
            bghl122a().commarea().detalhe().cPaisIsoaOeOpx().set(hv02201Movdiaant().movdiaant().cPaisIsoaOeOpx());
            bghl122a().commarea().detalhe().cMnemEgcOpex().set(hv02201Movdiaant().movdiaant().cMnemEgcOpex());
            bghl122a().commarea().detalhe().cOeEgcOpex().set(hv02201Movdiaant().movdiaant().cOeEgcOpex());
            bghl122a().commarea().detalhe().cUserid().set(hv02201Movdiaant().movdiaant().cUserid());
            bghl122a().commarea().detalhe().nJourBbn().set(hv02201Movdiaant().movdiaant().nJourBbn());
            bghl122a().commarea().detalhe().nsJourBbn().set(hv02201Movdiaant().movdiaant().nsJourBbn());
            bghl122a().commarea().detalhe().nsJourBbnDtlh().set(hv02201Movdiaant().movdiaant().nsJourBbnDtlh());
            bghl122a().commarea().detalhe().zProcessamento().set(hv02201Movdiaant().movdiaant().zProcessamento());
        }
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
        
        @Data(size=8, signed=true, compression=COMP)
        ILong cicscode() ;
        
        /**
         * ----- ESPECIFICAS
         * @return instancia da classe local WsChave
         */
        @Data
        WsChave wsChave() ;
        
        @Data(size=26)
        IString wsTsInicio() ;
        
        @Data(size=26)
        IString wsTsFim() ;
        
        
        
        /**
         * 
         * ----- ESPECIFICAS
         * 
         * @version 2.0
         * 
         */
        public interface WsChave extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaCont() ;
            
            @Data(size=4)
            IInt wsCBancCont() ;
            
            @Data(size=4)
            IInt wsCOeEgcCont() ;
            
            @Data(size=7)
            IInt wsNsRdclCont() ;
            
            @Data(size=1)
            IInt wsVChkdCont() ;
            
            @Data(size=3)
            IInt wsCTipoCont() ;
            
            @Data(size=3)
            IString wsCMoedIsoScta() ;
            
            @Data(size=4)
            IInt wsNsDeposito() ;
            
            @Data(size=26)
            IString wsTsMovimento() ;
            
            @Data(size=15)
            ILong wsNsMovimento() ;
            
        }
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
        
        @Data(size=6, value="999999", lpadding=1, lpaddingValue=".")
        IInt wsRestFim() ;
        
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
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02201() ;
        @Data
        @Condition("0")
        ICondition swVgh02201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh02201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh02201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh10201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh10201Null() ;
        
        
        @Data(size=1)
        IString swHaMovimento() ;
        @Data
        @Condition("S")
        ICondition swHaMovSim() ;
        @Data
        @Condition("N")
        ICondition swNaoHaMov() ;
        
        
    }
}
