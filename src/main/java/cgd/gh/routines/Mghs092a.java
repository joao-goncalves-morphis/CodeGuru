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
import cgd.gh.structures.link.Bghl092a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00002_MOVHST
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * ------->     CANAIS NAO  PRESENCIAIS  <--------
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS092A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs092a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl092a
     */
    @Data
    public abstract Bghl092a bghl092a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WsVgh00201
     */
    @Data
    protected abstract WsVgh00201 wsVgh00201() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl092a().cRetorno().initialize() ;
        bghl092a().cSqlcode().initialize() ;
        if (bghl092a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl092a().argumento().cBancCont().isEqual(0) || 
            bghl092a().argumento().cOeEgcCont().isEqual(0) || 
            bghl092a().argumento().nsRdclCont().isEqual(0) || 
            bghl092a().argumento().cMoedIsoScta().isEmpty()) {
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
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghl092a().argumento().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(bghl092a().argumento().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(bghl092a().argumento().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(bghl092a().argumento().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(bghl092a().argumento().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(bghl092a().argumento().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghl092a().argumento().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(bghl092a().argumento().nsDeposito());
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
        hv00201Movhst().openMghs092a262() ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv00201Movhst().fetchMghs092a274() ;
            if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(30); wsInd.add(1)) {
                wsVgh00201().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
                wsVgh00201().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
                wsVgh00201().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
                wsVgh00201().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
                wsVgh00201().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
                wsVgh00201().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
                wsVgh00201().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
                wsVgh00201().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
                wsVgh00201().wsTsMovimento().set(hv00201Movhst().movhst().tsMovimento());
                wsVgh00201().wsNsMovimento().set(hv00201Movhst().movhst().nsMovimento());
                wsVgh00201().wsZValMov().set(hv00201Movhst().movhst().zValMov());
                wsVgh00201().wsZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
                wsVgh00201().wsIDbcr().set(hv00201Movhst().movhst().iDbcr());
                wsVgh00201().wsMMovimento().set(hv00201Movhst().movhst().mMovimento());
                wsVgh00201().wsIEstorno().set(hv00201Movhst().movhst().iEstorno());
                wsVgh00201().wsCMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
                wsVgh00201().wsMSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
                wsVgh00201().wsMSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
                wsVgh00201().wsMMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
                wsVgh00201().wsXRefMov().set(hv00201Movhst().movhst().xRefMov());
                wsVgh00201().wsNDocOpps().set(hv00201Movhst().movhst().nDocOpps());
                wsVgh00201().wsTJuro().set(hv00201Movhst().movhst().tJuro());
                wsVgh00201().wsAAplOrig().set(hv00201Movhst().movhst().aAplOrig());
                wsVgh00201().wsIExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
                wsVgh00201().wsXChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
                wsVgh00201().wsTsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
                wsVgh00201().wsCUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
                bghl092a().tabela().lista().get(wsInd).item().set(wsVgh00201());
                bghl092a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv00201Movhst().fetchMghs092a337() ;
                if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv00201Movhst().closeMghs092a354() ;
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl092a().cRetorno().set(progStatus);
        bghl092a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh00201 extends IDataStruct {
        
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
        
        @Data(size=26)
        IString wsTsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimento() ;
        
        @Data(size=10)
        IString wsZValMov() ;
        
        @Data(size=10)
        IString wsZMovLocl() ;
        
        @Data(size=1)
        IString wsIDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovimento() ;
        
        @Data(size=1)
        IString wsIEstorno() ;
        
        @Data(size=3)
        IString wsCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovMoeOrigMov() ;
        
        @Data(size=21)
        IString wsXRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong wsNDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal wsTJuro() ;
        
        @Data(size=2)
        IString wsAAplOrig() ;
        
        @Data(size=1)
        IString wsIExisInfAdi() ;
        
        @Data(size=40)
        IString wsXChavAcsInfAdi() ;
        
        @Data(size=26)
        IString wsTsActzUlt() ;
        
        @Data(size=8)
        IString wsCUsidActzUlt() ;
        
    }
}
