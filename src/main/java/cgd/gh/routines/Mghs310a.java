package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl310a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00010_CONTIPHST
 * DESCRICAO     : LISTA  AS SUBCONTAS COM OS RESPECTIVOS TIPOS
 * DE HISTORICOS ASSOCIADAS A CONTA
 * ALTERACOES :
 * 
 * migrated from program [MGHS310A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs310a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl310a
     */
    @Data
    public abstract Bghl310a bghl310a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    
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
    @Condition("098")
    protected ICondition progNaoExisteConta ;
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
    
    /**
     * @return instancia da classe local WsVgh01001
     */
    @Data
    protected abstract WsVgh01001 wsVgh01001() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl310a().cRetorno().initialize() ;
        bghl310a().cSqlcode().initialize() ;
        if (bghl310a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl310a().argumento().cBancCont().isEqual(0) || 
            bghl310a().argumento().cOeEgcCont().isEqual(0) || 
            bghl310a().argumento().nsRdclCont().isEqual(0)) {
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
        a5200ListaTabela() ;
    }
    
    /**
     * 
     * 
     */
    public void a5100FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         */
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(bghl310a().argumento().cPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(bghl310a().argumento().cBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(bghl310a().argumento().cOeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(bghl310a().argumento().nsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(bghl310a().argumento().vChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(bghl310a().argumento().cTipoCont());
        hv01001Contiphst().contiphst().nsDeposito().set(bghl310a().argumento().nsDeposito());
        hv01001Contiphst().contiphst().zaInicio().set(bghl310a().argumento().zaInicio());
    }
    
    /**
     * 
     * 
     */
    public void a5200ListaTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01001Contiphst().openMghs310a212() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv01001Contiphst().fetchMghs310a224() ;
            if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteConta.setTrue() ;
            }
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01001().wsCPaisIsoaCont().set(hv01001Contiphst().contiphst().cPaisIsoaCont());
                wsVgh01001().wsCBancCont().set(hv01001Contiphst().contiphst().cBancCont());
                wsVgh01001().wsCOeEgcCont().set(hv01001Contiphst().contiphst().cOeEgcCont());
                wsVgh01001().wsNsRdclCont().set(hv01001Contiphst().contiphst().nsRdclCont());
                wsVgh01001().wsVChkdCont().set(hv01001Contiphst().contiphst().vChkdCont());
                wsVgh01001().wsCTipoCont().set(hv01001Contiphst().contiphst().cTipoCont());
                wsVgh01001().wsCMoedIsoScta().set(hv01001Contiphst().contiphst().cMoedIsoScta());
                wsVgh01001().wsNsDeposito().set(hv01001Contiphst().contiphst().nsDeposito());
                wsVgh01001().wsNmRecurso().set(hv01001Contiphst().contiphst().nmRecurso());
                wsVgh01001().wsCTipoInfHist().set(hv01001Contiphst().contiphst().cTipoInfHist());
                wsVgh01001().wsZaInicio().set(hv01001Contiphst().contiphst().zaInicio());
                wsVgh01001().wsZaFim().set(hv01001Contiphst().contiphst().zaFim());
                bghl310a().tabela().lista().get(wsInd).item().set(wsVgh01001());
                bghl310a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv01001Contiphst().fetchMghs310a277() ;
                if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv01001Contiphst().closeMghs310a305() ;
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl310a().cRetorno().set(progStatus);
        bghl310a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh01001 extends IDataStruct {
        
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
        
        @Data(size=8)
        IString wsNmRecurso() ;
        
        @Data(size=1)
        IString wsCTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsZaFim() ;
        
    }
}
