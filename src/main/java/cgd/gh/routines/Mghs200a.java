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
import cgd.gh.structures.link.Bghl200a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00002_MOVHST
 * DESCRICAO     : OBTEM DADOS DA  TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS200A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs200a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl200a
     */
    @Data
    public abstract Bghl200a bghl200a() ;
    
    
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
        bghl200a().cRetorno().initialize() ;
        bghl200a().cSqlcode().initialize() ;
        if (bghl200a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl200a().argumento().cBancCont().isEqual(0) || 
            bghl200a().argumento().cOeEgcCont().isEqual(0) || 
            bghl200a().argumento().nsRdclCont().isEqual(0) || 
            bghl200a().argumento().cMoedIsoScta().isEmpty() || 
            bghl200a().argumento().tsMovimento().isEmpty() || 
            bghl200a().argumento().nsMovimento().isEqual(0)) {
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
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghl200a().argumento().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(bghl200a().argumento().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(bghl200a().argumento().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(bghl200a().argumento().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(bghl200a().argumento().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(bghl200a().argumento().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghl200a().argumento().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(bghl200a().argumento().nsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(bghl200a().argumento().tsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(bghl200a().argumento().nsMovimento());
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
        hv00201Movhst().selectMghs200a157() ;
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
        bghl200a().detalhe().zValMov().set(hv00201Movhst().movhst().zValMov());
        bghl200a().detalhe().zMovLocl().set(hv00201Movhst().movhst().zMovLocl());
        bghl200a().detalhe().iDbcr().set(hv00201Movhst().movhst().iDbcr());
        bghl200a().detalhe().mMovimento().set(hv00201Movhst().movhst().mMovimento());
        bghl200a().detalhe().iEstorno().set(hv00201Movhst().movhst().iEstorno());
        bghl200a().detalhe().cMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        bghl200a().detalhe().mSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        bghl200a().detalhe().mSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        bghl200a().detalhe().mMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        bghl200a().detalhe().xRefMov().set(hv00201Movhst().movhst().xRefMov());
        bghl200a().detalhe().nDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        bghl200a().detalhe().tJuro().set(hv00201Movhst().movhst().tJuro());
        bghl200a().detalhe().aAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        bghl200a().detalhe().iExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
        bghl200a().detalhe().xChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
        bghl200a().detalhe().tsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
        bghl200a().detalhe().cUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
    }
    
    /**
     * 
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl200a().cRetorno().set(progStatus);
        bghl200a().cSqlcode().set(getPersistenceCode());
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
