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
import cgd.gh.structures.link.Bghl110a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00010_CONTIPHST
 * DESCRICAO     : LISTA NOME DAS TABELAS QUE TEM MOVIMENTOS  DA
 * SUBCONTA - HISTORICO EM DISCO
 * ALTERAÇÕES : 2019-12-16 - GH 2292: AUMENTO DE OCORRENCIAS
 * DA AREA DE LIGACAO E DESCOMENTAR A
 * CONDICAO DA MOEDA NOS CURSORES
 * 
 * migrated from program [MGHS110A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs110a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl110a
     */
    @Data
    public abstract Bghl110a bghl110a() ;
    
    
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
        bghl110a().cRetorno().initialize() ;
        bghl110a().cSqlcode().initialize() ;
        if (bghl110a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl110a().argumento().cBancCont().isEqual(0) || 
            bghl110a().argumento().cOeEgcCont().isEqual(0) || 
            bghl110a().argumento().nsRdclCont().isEqual(0)) {
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
        if (bghl110a().tape().isTrue()) {
            a5200ListaTape() ;
        } else {
            a5300ListaTabela() ;
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
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(bghl110a().argumento().cPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(bghl110a().argumento().cBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(bghl110a().argumento().cOeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(bghl110a().argumento().nsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(bghl110a().argumento().vChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(bghl110a().argumento().cTipoCont());
        hv01001Contiphst().contiphst().nsDeposito().set(bghl110a().argumento().nsDeposito());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(bghl110a().argumento().cMoedIsoScta());
        hv01001Contiphst().contiphst().cTipoInfHist().set("P");
    }
    
    /**
     * 
     * 
     */
    public void a5200ListaTape() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01001Contiphst().openMghs110a230() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv01001Contiphst().fetchMghs110a242() ;
            if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteConta.setTrue() ;
            }
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(30); wsInd.add(1)) {
                /**
                 * GH 2292 - FIM
                 */
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
                bghl110a().tab().lista().get(wsInd).item().set(wsVgh01001());
                bghl110a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv01001Contiphst().fetchMghs110a289() ;
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
            hv01001Contiphst().closeMghs110a308() ;
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300ListaTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv01001Contiphst().openMghs110a321() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv01001Contiphst().fetchMghs110a333() ;
            if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteConta.setTrue() ;
            }
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(30); wsInd.add(1)) {
                /**
                 * GH 2292 - FIM
                 */
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
                bghl110a().tab().lista().get(wsInd).item().set(wsVgh01001());
                bghl110a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv01001Contiphst().fetchMghs110a380() ;
                if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv01001Contiphst().closeMghs110a399() ;
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
        bghl110a().cRetorno().set(progStatus);
        bghl110a().cSqlcode().set(getPersistenceCode());
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
