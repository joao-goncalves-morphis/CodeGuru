package cgd.gh.batch;

import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
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
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.structures.work.Bghr9231 ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hg.structures.link.Bhgl003a ;
import cgd.gh.structures.work.Bghw0001 ;
import cgd.gh.structures.work.Bghw0002 ;
import cgd.gh.structures.work.Bghwj001 ;
import cgd.hg.routines.Mhgj003a ;


/**
 * 
 * D A T A   D I V I S I O N
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc923a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh923
     */
    @Handler(name="FGH923", record="regFgh923360")
    @Data
    protected abstract Fgh923 ficheiroFgh923() ;
    
    /**
     * @return instancia da classe Fwk600
     */
    @Handler(name="FWK600", record="statusFwk60002")
    @Data
    protected abstract Fwk600 ficheiroFwk600() ;
    
    /**
     * @return instancia da classe Fwk923
     */
    @Handler(name="FWK923", record="regFwk267")
    @Data
    protected abstract Fwk923 ficheiroFwk267() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhgj003a
     */
    @Data
    protected abstract Mhgj003a hrMhgj003a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr9231
     */
    @Data
    protected abstract Bghr9231 bghr9231() ;
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhgl003a
     */
    @Data
    protected abstract Bhgl003a bhgl003a() ;
    
    /**
     * @return instancia da classe Bghw0001
     */
    @Data
    protected abstract Bghw0001 bghw0001() ;
    
    /**
     * @return instancia da classe Bghw0002
     */
    @Data
    protected abstract Bghw0002 bghw0002() ;
    
    /**
     * @return instancia da classe Bghwj001
     */
    @Data
    protected abstract Bghwj001 bghwj001() ;
    
    /**
     * COPY DO LAYOUT DO FICHEIRO FWK600
     * INICIO WORKING-STORAGE PGHC923A
     * @return instancia da classe local Fwk600Movdiaant
     */
    @Data
    protected abstract Fwk600Movdiaant fwk600Movdiaant() ;
    
    /**
     * AREA DE LIGACAO OBTENCAO DE MNEMONICA DE BANCO
     * COPYS DA APLICACAO
     * FILE STATUS
     */
    @Data(size=2, value="00")
    protected IString statusFhy003 ;
    @Data
    @Condition("00")
    protected ICondition swFhy003Ok ;
    @Data
    @Condition("10")
    protected ICondition swFhy003Eof ;
    
    
    /**
     * CONSTANTES
     * @return instancia da classe local WsConContantes
     */
    @Data
    protected abstract WsConContantes wsConContantes() ;
    
    /**
     * VARIAVEIS
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DA EMPRESA DO GCX
     * MHGJ003A
     * 
     */
    protected void bhgp0003RotDadosEmp() {
    }
    
    /**
     * 
     * PROCESSO
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFwk267().getStatusOk() && !ficheiroFwk600().getStatusOk()) {
            m2000ProcPrograma() ;
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        wsVariaveis().initialize() ;
        m1200OpenFicheiros() ;
        m1500ReadFwk600() ;
        m1600ReadFwk923() ;
    }
    
    /**
     * 
     * 1200-OPEN-FICHEIROS
     * 
     */
    protected void m1200OpenFicheiros() {
        log(TraceLevel.Debug, "1100-OPEN-FICHEIROS");
        ficheiroFwk600().open() ;
        if (!ficheiroFwk600().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk600());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conOpen());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk600().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotOpenFwk600().add(1);
        }
        ficheiroFwk267().open() ;
        if (!ficheiroFwk267().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk923());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conOpen());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk267().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotOpenFwk923().add(1);
        }
        ficheiroFgh923().open(CREATE ) ;
        if (!ficheiroFgh923().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFgh923());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conOpen());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFgh923().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotOpenFgh923().add(1);
        }
    }
    
    /**
     * 
     * 1500-READ-FWK600
     * 
     */
    protected void m1500ReadFwk600() {
        log(TraceLevel.Debug, "1500-READ-FWK600");
        ficheiroFwk600().read(fwk600Movdiaant()) ;
        if (ficheiroFwk600().getStatusOk()) {
            wsVariaveis().wsTotReadFwk600().add(1);
            wsVariaveis().wsChaveFwk600().wsCPaisIsoaFwk600().set(fwk600Movdiaant().fwk600CPaisIsoaCont());
            wsVariaveis().wsChaveFwk600().wsCBancContFwk600().set(fwk600Movdiaant().fwk600CBancCont());
            wsVariaveis().wsChaveFwk600().wsCOeEgcContFwk600().set(fwk600Movdiaant().fwk600COeEgcCont());
            wsVariaveis().wsChaveFwk600().wsNsRdclContFwk600().set(fwk600Movdiaant().fwk600NsRdclCont());
            wsVariaveis().wsChaveFwk600().wsVChkdContFwk600().set(fwk600Movdiaant().fwk600VChkdCont());
            wsVariaveis().wsChaveFwk600().wsCTipoContFwk600().set(fwk600Movdiaant().fwk600CTipoCont());
            wsVariaveis().wsChaveFwk600().wsCMoedIsoFwk600().set(fwk600Movdiaant().fwk600CMoedIsoScta());
            wsVariaveis().wsChaveFwk600().wsNsDepositoFwk600().set(fwk600Movdiaant().fwk600NsDeposito());
            wsVariaveis().wsChaveFwk600().wsNsMovimentoFwk600().set(fwk600Movdiaant().fwk600NsMovimento());
        } else if (!ficheiroFwk600().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk600());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conRead());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk600().getStatus());
            m9300TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FWK923
     * 
     */
    protected void m1600ReadFwk923() {
        log(TraceLevel.Debug, "1600-READ-FWK923");
        ficheiroFwk267().read() ;
        if (ficheiroFwk267().getStatusOk()) {
            wsVariaveis().wsTotReadFwk923().add(1);
            wsVariaveis().wsChaveFwk923().wsCPaisIsoaFwk923().set(ficheiroFwk267().regFwk267().subconta().cPaisIsoaCont());
            wsVariaveis().wsChaveFwk923().wsCBancContFwk923().set(ficheiroFwk267().regFwk267().subconta().cBancCont());
            wsVariaveis().wsChaveFwk923().wsCOeEgcContFwk923().set(ficheiroFwk267().regFwk267().subconta().cOeEgcCont());
            wsVariaveis().wsChaveFwk923().wsNsRdclContFwk923().set(ficheiroFwk267().regFwk267().subconta().nsRdclCont());
            wsVariaveis().wsChaveFwk923().wsVChkdContFwk923().set(ficheiroFwk267().regFwk267().subconta().vChkdCont());
            wsVariaveis().wsChaveFwk923().wsCTipoContFwk923().set(ficheiroFwk267().regFwk267().subconta().cTipoCont());
            wsVariaveis().wsChaveFwk923().wsCMoedIsoFwk923().set(ficheiroFwk267().regFwk267().subconta().cMoedIsoScta());
            wsVariaveis().wsChaveFwk923().wsNsDepositoFwk923().set(ficheiroFwk267().regFwk267().subconta().nsDeposito());
            wsVariaveis().wsChaveFwk923().wsNsMovimentoFwk923().set(ficheiroFwk267().regFwk267().nsMovimento());
        } else if (!ficheiroFwk267().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk923());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conRead());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk267().getStatus());
            m9300TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        /**
         * *GH1145--> INICIO                                                 
         */
        m2100FormataOutput() ;
        /**
         * *GH1145--> FIM                                                    
         */
        if (!ficheiroFwk267().getStatusOk()) {
            if (wsVariaveis().wsChaveFwk923().isEqual(wsVariaveis().wsChaveFwk600())) {
                bghr9231().fgh923Registo().fgh923MMovimentoCntrvl().set(fwk600Movdiaant().fwk600MMovimento());
                m2120WriteFgh923() ;
                m1600ReadFwk923() ;
                m1500ReadFwk600() ;
            } else if (wsVariaveis().wsChaveFwk923().isLess(wsVariaveis().wsChaveFwk600())) {
                bghr9231().fgh923Registo().fgh923MMovimentoCntrvl().set(ficheiroFwk267().regFwk267().mMovimento());
                m2120WriteFgh923() ;
                m1600ReadFwk923() ;
            } else {
                m1500ReadFwk600() ;
            }
        }
    }
    
    /**
     * 
     * 2100-FORMATA-OUTPUT
     * 
     */
    protected void m2100FormataOutput() {
        log(TraceLevel.Debug, "2100-FORMATA-OUTPUT");
        if (!ficheiroFwk267().regFwk267().cPaisIsoaGerx().isEqual(wsVariaveis().wsCPaisAnt()) || 
            !ficheiroFwk267().regFwk267().cBancGcxGerx().isEqual(wsVariaveis().wsCBancAnt())) {
            m2200ObtemMnemonica() ;
            wsVariaveis().wsCPaisAnt().set(ficheiroFwk267().regFwk267().cPaisIsoaGerx());
            wsVariaveis().wsCBancAnt().set(ficheiroFwk267().regFwk267().cBancGcxGerx());
        }
        /**
         * MOVER OS CAMPOS DO  FICHEIRO DE INPUT PARA FICHEIRO DE OUTPUT
         */
        bghr9231().fgh923Registo().fgh923CMnemEmpGcx().set(bhgl003a().commarea().dadosInput().cMnemEmpGcx());
        bghr9231().fgh923Registo().fgh923CPaisIsoaCont().set(ficheiroFwk267().regFwk267().subconta().cPaisIsoaCont());
        bghr9231().fgh923Registo().fgh923CBancCont().set(ficheiroFwk267().regFwk267().subconta().cBancCont());
        bghr9231().fgh923Registo().fgh923COeEgcCont().set(ficheiroFwk267().regFwk267().subconta().cOeEgcCont());
        bghr9231().fgh923Registo().fgh923NsRdclCont().set(ficheiroFwk267().regFwk267().subconta().nsRdclCont());
        bghr9231().fgh923Registo().fgh923VChkdCont().set(ficheiroFwk267().regFwk267().subconta().vChkdCont());
        bghr9231().fgh923Registo().fgh923CTipoCont().set(ficheiroFwk267().regFwk267().subconta().cTipoCont());
        bghr9231().fgh923Registo().fgh923CMoedIsoScta().set(ficheiroFwk267().regFwk267().subconta().cMoedIsoScta());
        bghr9231().fgh923Registo().fgh923NsDeposito().set(ficheiroFwk267().regFwk267().subconta().nsDeposito());
        bghr9231().fgh923Registo().fgh923NsMovimento().set(ficheiroFwk267().regFwk267().nsMovimento());
        bghr9231().fgh923Registo().fgh923ZContabilizacao().set(ficheiroFwk267().regFwk267().zContabilizacao());
        bghr9231().fgh923Registo().fgh923ZMovimento().set(ficheiroFwk267().regFwk267().zMovimento());
        bghr9231().fgh923Registo().fgh923ZValor().set(ficheiroFwk267().regFwk267().zValor());
        bghr9231().fgh923Registo().fgh923IDbcr().set(ficheiroFwk267().regFwk267().iDbcr());
        bghr9231().fgh923Registo().fgh923MMovimento().set(ficheiroFwk267().regFwk267().mMovimento());
        bghr9231().fgh923Registo().fgh923MSldoCblo().set(ficheiroFwk267().regFwk267().mSldoCblo());
        bghr9231().fgh923Registo().fgh923MSldoDpnl().set(ficheiroFwk267().regFwk267().mSldoDpnl());
        bghr9231().fgh923Registo().fgh923CMoedIsoOriMov().set(ficheiroFwk267().regFwk267().cMoedIsoOriMov());
        bghr9231().fgh923Registo().fgh923MMovMoeOrigMov().set(ficheiroFwk267().regFwk267().mMovMoeOrigMov());
        bghr9231().fgh923Registo().fgh923TCambio().set(ficheiroFwk267().regFwk267().tCambio());
        bghr9231().fgh923Registo().fgh923COpeBbn().set(ficheiroFwk267().regFwk267().cOpeBbn());
        bghr9231().fgh923Registo().fgh923XRefMov().set(ficheiroFwk267().regFwk267().xRefMov());
        bghr9231().fgh923Registo().fgh923NCheque().set(ficheiroFwk267().regFwk267().nCheque());
        bghr9231().fgh923Registo().fgh923IEstorno().set(ficheiroFwk267().regFwk267().iEstorno());
        bghr9231().fgh923Registo().fgh923NsMovEtnd().set(ficheiroFwk267().regFwk267().nsMovEtnd());
        bghr9231().fgh923Registo().fgh923ITrnzEfcdOnln().set(ficheiroFwk267().regFwk267().iTrnzEfcdOnln());
        bghr9231().fgh923Registo().fgh923ITipoOrigTrnz().set(ficheiroFwk267().regFwk267().iTipoOrigTrnz());
        bghr9231().fgh923Registo().fgh923IExiAtzJourBbn().set(ficheiroFwk267().regFwk267().iExiAtzJourBbn());
        bghr9231().fgh923Registo().fgh923CTipoCanlAces().set(ficheiroFwk267().regFwk267().cTipoCanlAces());
        bghr9231().fgh923Registo().fgh923AAplicacao().set(ficheiroFwk267().regFwk267().aAplicacao());
        bghr9231().fgh923Registo().fgh923COpczMenu().set(ficheiroFwk267().regFwk267().cOpczMenu());
        bghr9231().fgh923Registo().fgh923CFamiProd().set(ficheiroFwk267().regFwk267().cFamiProd());
        bghr9231().fgh923Registo().fgh923CProduto().set(ficheiroFwk267().regFwk267().cProduto());
        bghr9231().fgh923Registo().fgh923CSectIttlBpor().set(ficheiroFwk267().regFwk267().cSectIttlBpor());
        bghr9231().fgh923Registo().fgh923CPaisIsoaGerx().set(ficheiroFwk267().regFwk267().cPaisIsoaGerx());
        bghr9231().fgh923Registo().fgh923CBancGcxGerx().set(ficheiroFwk267().regFwk267().cBancGcxGerx());
        bghr9231().fgh923Registo().fgh923COeEgcGerx().set(ficheiroFwk267().regFwk267().cOeEgcGerx());
        bghr9231().fgh923Registo().fgh923IMovActzVsld().set(ficheiroFwk267().regFwk267().iMovActzVsld());
        bghr9231().fgh923Registo().fgh923ZProcessamento().set(ficheiroFwk267().regFwk267().zProcessamento());
        bghr9231().fgh923Registo().fgh923CMnemEgcOpex().set(ficheiroFwk267().regFwk267().cMnemEgcOpex());
        bghr9231().fgh923Registo().fgh923CPaisIsoaOeOpx().set(ficheiroFwk267().regFwk267().cPaisIsoaOeOpx());
        bghr9231().fgh923Registo().fgh923COeEgcOpex().set(ficheiroFwk267().regFwk267().cOeEgcOpex());
        bghr9231().fgh923Registo().fgh923CUserid().set(ficheiroFwk267().regFwk267().cUserid());
        bghr9231().fgh923Registo().fgh923NJourBbn().set(ficheiroFwk267().regFwk267().nJourBbn());
        bghr9231().fgh923Registo().fgh923NsJourBbn().set(ficheiroFwk267().regFwk267().nsJourBbn());
        bghr9231().fgh923Registo().fgh923NsJourBbnDtlh().set(ficheiroFwk267().regFwk267().nsJourBbnDtlh());
        bghr9231().fgh923Registo().fgh923MSldoRetd().set(ficheiroFwk267().regFwk267().mSldoRetd());
        bghr9231().fgh923Registo().fgh923MSldoVcob().set(ficheiroFwk267().regFwk267().mSldoVcob());
        bghr9231().fgh923Registo().fgh923MSldoVcobUtid().set(ficheiroFwk267().regFwk267().mSldoVcobUtid());
        bghr9231().fgh923Registo().fgh923MDcboNgcdAtrd().set(ficheiroFwk267().regFwk267().mDcboNgcdAtrd());
        bghr9231().fgh923Registo().fgh923MDcboNgcdUtid().set(ficheiroFwk267().regFwk267().mDcboNgcdUtid());
        bghr9231().fgh923Registo().fgh923MCmrgLim().set(ficheiroFwk267().regFwk267().mCmrgLim());
        bghr9231().fgh923Registo().fgh923MCmrgUtid().set(ficheiroFwk267().regFwk267().mCmrgUtid());
        bghr9231().fgh923Registo().fgh923QDiaCalcJuro().set(ficheiroFwk267().regFwk267().qDiaCalcJuro());
        bghr9231().fgh923Registo().fgh923CTipoJuro().set(ficheiroFwk267().regFwk267().cTipoJuro());
        bghr9231().fgh923Registo().fgh923ITipoCalcJuro().set(ficheiroFwk267().regFwk267().iTipoCalcJuro());
        bghr9231().fgh923Registo().fgh923IPenalizacao().set(ficheiroFwk267().regFwk267().iPenalizacao());
        bghr9231().fgh923Registo().fgh923QRenovacao().set(ficheiroFwk267().regFwk267().qRenovacao());
        bghr9231().fgh923Registo().fgh923NsUtizCmrg().set(ficheiroFwk267().regFwk267().nsUtizCmrg());
        bghr9231().fgh923Registo().fgh923CEvenOpel().set(ficheiroFwk267().regFwk267().cEvenOpel());
        bghr9231().fgh923Registo().fgh923TsActzUlt().set(ficheiroFwk267().regFwk267().tsActzUlt());
        bghr9231().fgh923Registo().fgh923CUsidActzUlt().set(ficheiroFwk267().regFwk267().cUsidActzUlt());
    }
    
    /**
     * 
     * 2120-WRITE-FGH923
     * 
     */
    protected void m2120WriteFgh923() {
        log(TraceLevel.Debug, "2120-WRITE-FGH923");
        ficheiroFgh923().setRecord(bghr9231().fgh923Registo()) ;
        ficheiroFgh923().write(ficheiroFgh923().regFgh923360) ;
        if (ficheiroFwk267().getStatusOk()) {
            wsVariaveis().wsTotWriteFgh923().add(1);
        } else {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFgh923());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conWrite());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFgh923().getStatus());
            m9300TrataErroFich() ;
        }
    }
    
    /**
     * 
     * *GH1145--> INICIO
     * 2200-OBTEM-MNEMONICA
     * 
     */
    protected void m2200ObtemMnemonica() {
        log(TraceLevel.Debug, "2200-OBTEM-MNEMONICA");
        bhgl003a().commarea().initialize() ;
        bhgl003a().commarea().dadosInput().cPaisIsoAlfn().set(ficheiroFwk267().regFwk267().cPaisIsoaGerx());
        bhgl003a().commarea().dadosInput().cBanco().set(ficheiroFwk267().regFwk267().cBancGcxGerx());
        bhgp0003RotDadosEmp() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhgk0002().rotDadosEmpresa());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhgl003a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhgl003a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhgl003a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhgl003a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhgl003a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhgl003a().commarea().dadosOutput().sqlca().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhgk0002().rotDadosEmpresa());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhgl003a().commarea().dadosInput());
            bhtw0030().dadosEntrada().nmTabela().set(bhgl003a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO ACESSO MHGJ003A");
            bhtw0030().dadosEntrada().xCteuChavTab().set(bhgl003a().commarea().dadosInput());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * *GH1145--> FIM
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, "3000-FIM-PROGRAMA");
        m3100CloseFicheiros() ;
        m3400EscreveEstat() ;
    }
    
    /**
     * 
     * 3100-CLOSE-FICHEIROS
     * 
     */
    protected void m3100CloseFicheiros() {
        log(TraceLevel.Debug, "3100-CLOSE-FICHEIROS");
        ficheiroFwk600().close() ;
        if (!ficheiroFwk600().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk600());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conClose());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk600().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotCloseFwk600().add(1);
        }
        log(TraceLevel.Debug, "3100-CLOSE-FICHEIROS");
        ficheiroFwk267().close() ;
        if (!ficheiroFwk267().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk923());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conClose());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk267().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotCloseFwk923().add(1);
        }
        ficheiroFgh923().close() ;
        if (!ficheiroFgh923().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFgh923());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conClose());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFgh923().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotCloseFgh923().add(1);
        }
    }
    
    /**
     * 
     * 3400-ESCREVE-ESTAT
     * 
     */
    protected void m3400EscreveEstat() {
        m9400DataHoraFim() ;
        bhtw0033().dadosGerais().zFimPrct().set(wsVariaveis().wsDataFim());
        bhtw0033().dadosGerais().hFimPrct().set(wsVariaveis().wsHoraFim());
        /**
         * ESTATITISTICAS DE EXECUCAO DO FICHEIRO DE INPUT 1
         */
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conOpen());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk600());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk600().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotOpenFwk600());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conRead());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk600());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk600().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotReadFwk600());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conClose());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk600());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk600().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotCloseFwk600());
        bhtp0033WriteEstatF() ;
        /**
         * ESTATITISTICAS DE EXECUCAO DO FICHEIRO DE INPUT FGH923
         */
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conOpen());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFgh923());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFgh923().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotOpenFgh923());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conRead());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFgh923());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFgh923().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotWriteFgh923());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conClose());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFgh923());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFgh923().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotCloseFgh923());
        bhtp0033WriteEstatF() ;
        /**
         * ESTATITISTICAS DE EXECUCAO DO FICHEIRO DE OUTPUT 1
         */
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conOpen());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk923());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk267().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotOpenFwk923());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conWrite());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk923());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk267().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotReadFwk923());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conClose());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk923());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk267().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotCloseFwk923());
        bhtp0033WriteEstatF() ;
    }
    
    /**
     * 
     * 9300-TRATA-ERRO-FICH
     * 
     */
    protected void m9300TrataErroFich() {
        m9400DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(wsConContantes().conPrograma());
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhtw0030().dadosEntrada().nmFicheiro().set(wsVariaveis().wsNomeFicheiro());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(wsVariaveis().wsAccaoFicheiro());
        bhtw0030().dadosEntrada().cTipoErroBbn().set(wsConContantes().conErroFicheiro());
        bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsConContantes().conObs());
        bhtw0030().dadosEntrada().cFsttCobl().set(wsVariaveis().wsStatusFicheiro());
        bhtp0030DisplayErro() ;
        m3400EscreveEstat() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9400-DATA-HORA-FIM
     * 
     */
    protected void m9400DataHoraFim() {
        wsVariaveis().wsHora().set(getTime()) ;
        wsVariaveis().wsHoraFim().wsHhFim().set(wsVariaveis().wsHora().wsHh());
        wsVariaveis().wsHoraFim().wsMmFim().set(wsVariaveis().wsHora().wsMm());
        wsVariaveis().wsHoraFim().wsSsFim().set(wsVariaveis().wsHora().wsSs());
        wsVariaveis().wsData().set(getDate()) ;
        wsVariaveis().wsDataFim().wsAnoFim().set(wsVariaveis().wsData().wsAno());
        wsVariaveis().wsDataFim().wsMesFim().set(wsVariaveis().wsData().wsMes());
        wsVariaveis().wsDataFim().wsDiaFim().set(wsVariaveis().wsData().wsDia());
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Trace, "9900-ABEND");
        ficheiroFwk600().close() ;
        ficheiroFwk267().close() ;
        ficheiroFgh923().close() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        exit() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        m0000Mainline() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPY DO LAYOUT DO FICHEIRO FWK600
     * 
     * @version 2.0
     * 
     */
    public interface Fwk600Movdiaant extends IDataStruct {
        
        @Data(size=3)
        IString fwk600CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk600CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk600COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk600NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk600VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk600CTipoCont() ;
        
        @Data(size=3)
        IString fwk600CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk600NsDeposito() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk600NsMovimento() ;
        
        @Data(size=10)
        IString fwk600ZContabilizacao() ;
        
        @Data(size=10)
        IString fwk600ZMovimento() ;
        
        @Data(size=10)
        IString fwk600ZValor() ;
        
        @Data(size=1)
        IInt fwk600IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, rpadding=312, compression=COMP3)
        IDecimal fwk600MMovimento() ;
        
    }
    
    /**
     * 
     * CONSTANTES
     * 
     * @version 2.0
     * 
     */
    public interface WsConContantes extends IDataStruct {
        
        @Data(size=20, value="DESCRICAO           ")
        IString conDescricao() ;
        
        @Data(size=20, value="OBSERVACAO          ")
        IString conObs() ;
        
        @Data(size=2, value="WR")
        IString conWrite() ;
        
        @Data(size=2, value="RS")
        IString conRead() ;
        
        @Data(size=2, value="CL")
        IString conClose() ;
        
        @Data(size=2, value="OP")
        IString conOpen() ;
        
        @Data(size=8, value="FWK600")
        IString conFwk600() ;
        
        @Data(size=8, value="FWK923")
        IString conFwk923() ;
        
        @Data(size=2, value="FI")
        IString conErroFicheiro() ;
        
        @Data(size=1, value="1")
        IInt con1() ;
        
        @Data(size=8, value="FGH923")
        IString conFgh923() ;
        
        @Data(size=8, value="PGHC923A")
        IString conPrograma() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisAnt() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCBancAnt() ;
        
        /**
         * CONTADORES DE ESTATISTICAS (FICHEIRO DE INPUT 1)
         */
        @Data(size=10, value="0")
        ILong wsTotOpenFwk600() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFwk600() ;
        
        @Data(size=10, value="0")
        ILong wsTotCloseFwk600() ;
        
        /**
         * CONTADORES DE ESTATISTICAS (FICHEIRO DE INPUT 2)
         */
        @Data(size=10, value="0")
        ILong wsTotOpenFwk923() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFwk923() ;
        
        @Data(size=10, value="0")
        ILong wsTotCloseFwk923() ;
        
        /**
         * CONTADORES DE ESTATITISTICAS (FICHEIRO DE OUTPUT )
         */
        @Data(size=10, value="0")
        ILong wsTotOpenFgh923() ;
        
        @Data(size=10, value="0")
        ILong wsTotWriteFgh923() ;
        
        @Data(size=10, value="0")
        ILong wsTotCloseFgh923() ;
        
        /**
         * @return instancia da classe local WsChaveFwk923
         */
        @Data
        WsChaveFwk923 wsChaveFwk923() ;
        
        /**
         * @return instancia da classe local WsChaveFwk600
         */
        @Data
        WsChaveFwk600 wsChaveFwk600() ;
        
        @Data(size=8)
        IString wsNomeFicheiro() ;
        
        @Data(size=2)
        IString wsAccaoFicheiro() ;
        
        @Data(size=2)
        IString wsStatusFicheiro() ;
        
        /**
         * VARIAVEIS DE MANIPULACAO DE DATAS
         * @return instancia da classe local WsData
         */
        @Data
        WsData wsData() ;
        
        /**
         * @return instancia da classe local WsHora
         */
        @Data
        WsHora wsHora() ;
        
        /**
         * @return instancia da classe local WsDataIni
         */
        @Data
        WsDataIni wsDataIni() ;
        
        /**
         * @return instancia da classe local WsDataFim
         */
        @Data
        WsDataFim wsDataFim() ;
        
        /**
         * @return instancia da classe local WsHoraIni
         */
        @Data
        WsHoraIni wsHoraIni() ;
        
        /**
         * @return instancia da classe local WsHoraFim
         */
        @Data
        WsHoraFim wsHoraFim() ;
        
        
        public interface WsChaveFwk923 extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaFwk923() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancContFwk923() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCOeEgcContFwk923() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRdclContFwk923() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsVChkdContFwk923() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsCTipoContFwk923() ;
            
            @Data(size=3)
            IString wsCMoedIsoFwk923() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsNsDepositoFwk923() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimentoFwk923() ;
            
        }
        
        public interface WsChaveFwk600 extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaFwk600() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancContFwk600() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCOeEgcContFwk600() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRdclContFwk600() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsVChkdContFwk600() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsCTipoContFwk600() ;
            
            @Data(size=3)
            IString wsCMoedIsoFwk600() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsNsDepositoFwk600() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimentoFwk600() ;
            
        }
        
        
        /**
         * 
         * VARIAVEIS DE MANIPULACAO DE DATAS
         * 
         * @version 2.0
         * 
         */
        public interface WsData extends IDataStruct {
            
            @Data(size=2, value="0")
            IInt wsAno() ;
            
            @Data(size=2, value="0")
            IInt wsMes() ;
            
            @Data(size=2, value="0")
            IInt wsDia() ;
            
        }
        
        public interface WsHora extends IDataStruct {
            
            @Data(size=2, value="0")
            IInt wsHh() ;
            
            @Data(size=2, value="0")
            IInt wsMm() ;
            
            @Data(size=2, value="0")
            IInt wsSs() ;
            
        }
        
        public interface WsDataIni extends IDataStruct {
            
            @Data(size=2, value="20")
            IString wsSecIni() ;
            
            @Data(size=2, value=" ")
            IString wsAnoIni() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsMesIni() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsDiaIni() ;
            
        }
        
        public interface WsDataFim extends IDataStruct {
            
            @Data(size=2, value="20")
            IString wsSecFim() ;
            
            @Data(size=2, value=" ")
            IString wsAnoFim() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsMesFim() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsDiaFim() ;
            
        }
        
        public interface WsHoraIni extends IDataStruct {
            
            @Data(size=2, value=" ")
            IString wsHhIni() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
            IString wsMmIni() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
            IString wsSsIni() ;
            
        }
        
        public interface WsHoraFim extends IDataStruct {
            
            @Data(size=2, value=" ")
            IString wsHhFim() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
            IString wsMmFim() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
            IString wsSsFim() ;
            
        }
    }
    
}
