package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl207a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00002_MOVHST
 * DESCRICAO     : OBTEM DADOS DA  TABELA
 * PROCESSO      : GH1174
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHJ207A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj207a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl207a
     */
    @Data
    public abstract Bghl207a bghl207a() ;
    
    
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
    
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl207a().commarea().cRetorno().initialize() ;
        bghl207a().commarea().cSqlcode().initialize() ;
        if (bghl207a().commarea().argumento().cPaisIsoaCont().isEmpty() || 
            bghl207a().commarea().argumento().cBancCont().isEqual(0) || 
            bghl207a().commarea().argumento().cOeEgcCont().isEqual(0) || 
            bghl207a().commarea().argumento().nsRdclCont().isEqual(0) || 
            bghl207a().commarea().argumento().cMoedIsoScta().isEmpty() || 
            bghl207a().commarea().argumento().tsMovimento().isEmpty() || 
            bghl207a().commarea().argumento().nsMovimento().isEqual(0)) {
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
        a5200AcederTabela() ;
        if (progOk.isTrue()) {
            a5300PreencheOutput() ;
        }
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
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghl207a().commarea().argumento().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(bghl207a().commarea().argumento().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(bghl207a().commarea().argumento().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(bghl207a().commarea().argumento().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(bghl207a().commarea().argumento().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(bghl207a().commarea().argumento().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghl207a().commarea().argumento().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(bghl207a().commarea().argumento().nsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(bghl207a().commarea().argumento().tsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(bghl207a().commarea().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200AcederTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectMghj207a156() ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300PreencheOutput() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl207a().commarea().detalhe().zValMov().set(hv00201Movhst().movhst().zValMov());
        bghl207a().commarea().detalhe().zMovLocl().set(hv00201Movhst().movhst().zMovLocl());
        bghl207a().commarea().detalhe().iDbcr().set(hv00201Movhst().movhst().iDbcr());
        bghl207a().commarea().detalhe().mMovimento().set(hv00201Movhst().movhst().mMovimento());
        bghl207a().commarea().detalhe().iEstorno().set(hv00201Movhst().movhst().iEstorno());
        bghl207a().commarea().detalhe().cMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        bghl207a().commarea().detalhe().mSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        bghl207a().commarea().detalhe().mSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        bghl207a().commarea().detalhe().mMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        bghl207a().commarea().detalhe().xRefMov().set(hv00201Movhst().movhst().xRefMov());
        bghl207a().commarea().detalhe().nDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        bghl207a().commarea().detalhe().tJuro().set(hv00201Movhst().movhst().tJuro());
        bghl207a().commarea().detalhe().aAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        bghl207a().commarea().detalhe().iExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
        bghl207a().commarea().detalhe().xChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
        bghl207a().commarea().detalhe().tsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
        bghl207a().commarea().detalhe().cUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
    }
    
    /**
     * 
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl207a().commarea().cRetorno().set(progStatus);
        bghl207a().commarea().cSqlcode().set(getPersistenceCode());
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
}
