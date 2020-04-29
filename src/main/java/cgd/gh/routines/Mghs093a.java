package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl022a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00022_MOVDIAANT
 * DESCRICAO     : LISTA REGISTOS DO DIA ANTERIOR
 * ------->     CANAIS NAO  PRESENCIAIS  <--------
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS093A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs093a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl022a
     */
    @Data
    public abstract Bghl022a bghl022a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREA DE TRABALHO COMUM     ***
     */
    @Data(size=4, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("328")
    protected ICondition progMovJaEstornado ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    @Data(size=2, value=" ")
    protected IString wCTipoErroBbn ;
    @Data
    @Condition(" ")
    protected ICondition wsSemErros ;
    @Data
    @Condition("A1")
    protected ICondition wsAbend ;
    @Data
    @Condition("A2")
    protected ICondition wsAbendDb2 ;
    @Data
    @Condition("A3")
    protected ICondition wsAbendCics ;
    @Data
    @Condition("FU")
    protected ICondition wsErrosFuncao ;
    @Data
    @Condition("AU")
    protected ICondition wsAutorizacao ;
    @Data
    @Condition("FC")
    protected ICondition wsFimConsulta ;
    
    
    @Data(size=2)
    protected IInt wsInd ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtCriterio ;
    @Data
    @Condition("Z")
    protected ICondition criterioData ;
    @Data
    @Condition("N")
    protected ICondition criterioMovimento ;
    
    
    /**
     * @return instancia da classe local WsVgh02201
     */
    @Data
    protected abstract WsVgh02201 wsVgh02201() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl022a().cRetorno().initialize() ;
        bghl022a().cSqlcode().initialize() ;
        if (bghl022a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl022a().argumento().cBancCont().isEqual(0) || 
            bghl022a().argumento().cOeEgcCont().isEqual(0) || 
            bghl022a().argumento().nsRdclCont().isEqual(0) || 
            bghl022a().argumento().cMoedIsoScta().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void s3000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        a5100FormatarArea() ;
        a5200AcedeTabela() ;
    }
    
    /**
     * 
     * 
     */
    public void a5100FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         */
        hv02201Movdiaant().movdiaant().initialize() ;
        hv02201Movdiaant().movdiaant().cPaisIsoaCont().set(bghl022a().argumento().cPaisIsoaCont());
        hv02201Movdiaant().movdiaant().cBancCont().set(bghl022a().argumento().cBancCont());
        hv02201Movdiaant().movdiaant().cOeEgcCont().set(bghl022a().argumento().cOeEgcCont());
        hv02201Movdiaant().movdiaant().nsRdclCont().set(bghl022a().argumento().nsRdclCont());
        hv02201Movdiaant().movdiaant().vChkdCont().set(bghl022a().argumento().vChkdCont());
        hv02201Movdiaant().movdiaant().cTipoCont().set(bghl022a().argumento().cTipoCont());
        hv02201Movdiaant().movdiaant().cMoedIsoScta().set(bghl022a().argumento().cMoedIsoScta());
        hv02201Movdiaant().movdiaant().nsDeposito().set(bghl022a().argumento().nsDeposito());
    }
    
    /**
     * 
     * 
     */
    public void a5200AcedeTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv02201Movdiaant().openMghs093a299() ;
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02201Movdiaant().fetchMghs093a311() ;
            if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(30); wsInd.add(1)) {
                wsVgh02201().wsCPaisIsoaCont().set(hv02201Movdiaant().movdiaant().cPaisIsoaCont());
                wsVgh02201().wsCBancCont().set(hv02201Movdiaant().movdiaant().cBancCont());
                wsVgh02201().wsCOeEgcCont().set(hv02201Movdiaant().movdiaant().cOeEgcCont());
                wsVgh02201().wsNsRdclCont().set(hv02201Movdiaant().movdiaant().nsRdclCont());
                wsVgh02201().wsVChkdCont().set(hv02201Movdiaant().movdiaant().vChkdCont());
                wsVgh02201().wsCTipoCont().set(hv02201Movdiaant().movdiaant().cTipoCont());
                wsVgh02201().wsCMoedIsoScta().set(hv02201Movdiaant().movdiaant().cMoedIsoScta());
                wsVgh02201().wsNsDeposito().set(hv02201Movdiaant().movdiaant().nsDeposito());
                wsVgh02201().wsNsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
                wsVgh02201().wsZContabilizacao().set(hv02201Movdiaant().movdiaant().zContabilizacao());
                wsVgh02201().wsZMovimento().set(hv02201Movdiaant().movdiaant().zMovimento());
                wsVgh02201().wsZValor().set(hv02201Movdiaant().movdiaant().zValor());
                wsVgh02201().wsIDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
                wsVgh02201().wsMMovimento().set(hv02201Movdiaant().movdiaant().mMovimento());
                wsVgh02201().wsMSldoCblo().set(hv02201Movdiaant().movdiaant().mSldoCblo());
                wsVgh02201().wsMSldoDpnl().set(hv02201Movdiaant().movdiaant().mSldoDpnl());
                wsVgh02201().wsCMoedIsoOriMov().set(hv02201Movdiaant().movdiaant().cMoedIsoOriMov());
                wsVgh02201().wsMMovMoeOrigMov().set(hv02201Movdiaant().movdiaant().mMovMoeOrigMov());
                wsVgh02201().wsTCambio().set(hv02201Movdiaant().movdiaant().tCambio());
                wsVgh02201().wsCOpeBbn().set(hv02201Movdiaant().movdiaant().cOpeBbn());
                wsVgh02201().wsXRefMov().set(hv02201Movdiaant().movdiaant().xRefMov());
                wsVgh02201().wsNCheque().set(hv02201Movdiaant().movdiaant().nCheque());
                wsVgh02201().wsIEstorno().set(hv02201Movdiaant().movdiaant().iEstorno());
                wsVgh02201().wsNsMovEtnd().set(hv02201Movdiaant().movdiaant().nsMovEtnd());
                wsVgh02201().wsITrnzEfcdOnln().set(hv02201Movdiaant().movdiaant().iTrnzEfcdOnln());
                wsVgh02201().wsITipoOrigTrnz().set(hv02201Movdiaant().movdiaant().iTipoOrigTrnz());
                wsVgh02201().wsIExiAtzJourBbn().set(hv02201Movdiaant().movdiaant().iExiAtzJourBbn());
                wsVgh02201().wsCTipoCanlAces().set(hv02201Movdiaant().movdiaant().cTipoCanlAces());
                wsVgh02201().wsAAplicacao().set(hv02201Movdiaant().movdiaant().aAplicacao());
                wsVgh02201().wsCOpczMenu().set(hv02201Movdiaant().movdiaant().cOpczMenu());
                wsVgh02201().wsCFamiProd().set(hv02201Movdiaant().movdiaant().cFamiProd());
                wsVgh02201().wsCProduto().set(hv02201Movdiaant().movdiaant().cProduto());
                wsVgh02201().wsCSectIttlBpor().set(hv02201Movdiaant().movdiaant().cSectIttlBpor());
                wsVgh02201().wsCPaisIsoaGerx().set(hv02201Movdiaant().movdiaant().cPaisIsoaGerx());
                wsVgh02201().wsCBancGcxGerx().set(hv02201Movdiaant().movdiaant().cBancGcxGerx());
                wsVgh02201().wsCOeEgcGerx().set(hv02201Movdiaant().movdiaant().cOeEgcGerx());
                wsVgh02201().wsIMovActzVsld().set(hv02201Movdiaant().movdiaant().iMovActzVsld());
                wsVgh02201().wsZProcessamento().set(hv02201Movdiaant().movdiaant().zProcessamento());
                wsVgh02201().wsCMnemEgcOpex().set(hv02201Movdiaant().movdiaant().cMnemEgcOpex());
                wsVgh02201().wsCPaisIsoaOeOpx().set(hv02201Movdiaant().movdiaant().cPaisIsoaOeOpx());
                wsVgh02201().wsCOeEgcOpex().set(hv02201Movdiaant().movdiaant().cOeEgcOpex());
                wsVgh02201().wsCUserid().set(hv02201Movdiaant().movdiaant().cUserid());
                wsVgh02201().wsNJourBbn().set(hv02201Movdiaant().movdiaant().nJourBbn());
                wsVgh02201().wsNsJourBbn().set(hv02201Movdiaant().movdiaant().nsJourBbn());
                wsVgh02201().wsNsJourBbnDtlh().set(hv02201Movdiaant().movdiaant().nsJourBbnDtlh());
                wsVgh02201().wsMSldoRetd().set(hv02201Movdiaant().movdiaant().mSldoRetd());
                wsVgh02201().wsMSldoVcob().set(hv02201Movdiaant().movdiaant().mSldoVcob());
                wsVgh02201().wsMSldoVcobUtid().set(hv02201Movdiaant().movdiaant().mSldoVcobUtid());
                wsVgh02201().wsMDcboNgcdUtid().set(hv02201Movdiaant().movdiaant().mDcboNgcdUtid());
                wsVgh02201().wsMDcboNgcdAtrd().set(hv02201Movdiaant().movdiaant().mDcboNgcdAtrd());
                wsVgh02201().wsMCmrgLim().set(hv02201Movdiaant().movdiaant().mCmrgLim());
                wsVgh02201().wsMCmrgUtid().set(hv02201Movdiaant().movdiaant().mCmrgUtid());
                wsVgh02201().wsQDiaCalcJuro().set(hv02201Movdiaant().movdiaant().qDiaCalcJuro());
                wsVgh02201().wsCTipoJuro().set(hv02201Movdiaant().movdiaant().cTipoJuro());
                wsVgh02201().wsITipoCalcJuro().set(hv02201Movdiaant().movdiaant().iTipoCalcJuro());
                wsVgh02201().wsIPenalizacao().set(hv02201Movdiaant().movdiaant().iPenalizacao());
                wsVgh02201().wsQRenovacao().set(hv02201Movdiaant().movdiaant().qRenovacao());
                wsVgh02201().wsNsUtizCmrg().set(hv02201Movdiaant().movdiaant().nsUtizCmrg());
                wsVgh02201().wsCEvenOpel().set(hv02201Movdiaant().movdiaant().cEvenOpel());
                wsVgh02201().wsTsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
                wsVgh02201().wsCUsidActzUlt().set(hv02201Movdiaant().movdiaant().cUsidActzUlt());
                bghl022a().tabela().lista().get(wsInd).item().set(wsVgh02201());
                bghl022a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02201Movdiaant().fetchMghs093a402() ;
                if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02201Movdiaant().closeMghs093a419() ;
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl022a().cRetorno().set(progStatus);
        bghl022a().cSqlcode().set(getPersistenceCode());
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s1000Iniciar() ;
        if (progOk.isTrue()) {
            s3000Processar() ;
        }
        s5000Responder() ;
        exit() ;
    }
    
    public interface WsVgh02201 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimento() ;
        
        @Data(size=10)
        IString wsZContabilizacao() ;
        
        @Data(size=10)
        IString wsZMovimento() ;
        
        @Data(size=10)
        IString wsZValor() ;
        
        @Data(size=1)
        IString wsIDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovimento() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoDpnl() ;
        
        @Data(size=3)
        IString wsCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovMoeOrigMov() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal wsTCambio() ;
        
        @Data(size=5)
        IString wsCOpeBbn() ;
        
        @Data(size=21)
        IString wsXRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong wsNCheque() ;
        
        @Data(size=1)
        IString wsIEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovEtnd() ;
        
        @Data(size=1)
        IString wsITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString wsITipoOrigTrnz() ;
        
        @Data(size=1)
        IString wsIExiAtzJourBbn() ;
        
        @Data(size=4)
        IString wsCTipoCanlAces() ;
        
        @Data(size=2)
        IString wsAAplicacao() ;
        
        @Data(size=3)
        IString wsCOpczMenu() ;
        
        @Data(size=3)
        IString wsCFamiProd() ;
        
        @Data(size=3)
        IString wsCProduto() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsCSectIttlBpor() ;
        
        @Data(size=3)
        IString wsCPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcGerx() ;
        
        @Data(size=1)
        IString wsIMovActzVsld() ;
        
        @Data(size=10)
        IString wsZProcessamento() ;
        
        @Data(size=3)
        IString wsCMnemEgcOpex() ;
        
        @Data(size=3)
        IString wsCPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcOpex() ;
        
        @Data(size=8)
        IString wsCUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong wsNJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt wsNsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt wsNsJourBbnDtlh() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoVcobUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMDcboNgcdUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMCmrgUtid() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt wsQDiaCalcJuro() ;
        
        @Data(size=2)
        IString wsCTipoJuro() ;
        
        @Data(size=1)
        IString wsITipoCalcJuro() ;
        
        @Data(size=1)
        IString wsIPenalizacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsQRenovacao() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsNsUtizCmrg() ;
        
        @Data(size=4)
        IString wsCEvenOpel() ;
        
        @Data(size=26)
        IString wsTsActzUlt() ;
        
        @Data(size=8)
        IString wsCUsidActzUlt() ;
        
    }
}
