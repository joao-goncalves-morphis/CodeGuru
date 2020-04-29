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
import cgd.gh.structures.link.Bghl018a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00018-PEDINF
 * DESCRICAO     : ACESSO A TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS018A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs018a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl018a
     */
    @Data
    public abstract Bghl018a bghl018a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01801Pedinf
     */
    @Data
    protected abstract Vwsdghps01801Pedinf hv01801Pedinf() ;
    
    
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
    @Condition("095")
    protected ICondition progPedidoInvalido ;
    @Data
    @Condition("099")
    protected ICondition progNaoExisteInf ;
    @Data
    @Condition("089")
    protected ICondition progJaExiste ;
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
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WsVgh01801
     */
    @Data
    protected abstract WsVgh01801 wsVgh01801() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl018a().cRetorno().initialize() ;
        bghl018a().cSqlcode().initialize() ;
        if (!bghl018a().acessoValido().isTrue()) {
            progDadosInvalidos.setTrue() ;
        }
        /**
         * IF PROG-OK
         * IF MGH018A-C-PED-INF-OPPS = SPACES
         * SET PROG-DADOS-INVALIDOS TO TRUE
         * END-IF
         */
        if (progOk.isTrue()) {
            if (bghl018a().inserir().isTrue()) {
                if (bghl018a().detalhe().dPedInfOpps().isEmpty() || 
                    bghl018a().detalhe().cFrmtInf().isEmpty() || 
                    bghl018a().detalhe().cTipoRpte().isEmpty() || 
                    bghl018a().detalhe().nmFichOutpRtno().isEmpty() || 
                    bghl018a().detalhe().qDiaDpnzInf().isEqual(0) || 
                    bghl018a().detalhe().cUsidActzUlt().isEmpty() || 
                    bghl018a().detalhe().tsActzUlt().isZeros()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
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
        if (bghl018a().consultar().isTrue()) {
            a5200ConsultaTabela() ;
        } else if (bghl018a().listar().isTrue()) {
            a5300ListaTabela() ;
        } else if (bghl018a().inserir().isTrue()) {
            a5400InserirTabela() ;
        } else if (bghl018a().eliminar().isTrue()) {
            a5500EliminarTabela() ;
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
        hv01801Pedinf().pedinf().initialize() ;
        hv01801Pedinf().pedinf().cPedInfOpps().set(bghl018a().argumento().cPedInfOpps());
        if (bghl018a().inserir().isTrue()) {
            hv01801Pedinf().pedinf().dPedInfOpps().set(bghl018a().detalhe().dPedInfOpps());
            hv01801Pedinf().pedinf().cFrmtInf().set(bghl018a().detalhe().cFrmtInf());
            hv01801Pedinf().pedinf().cTipoRpte().set(bghl018a().detalhe().cTipoRpte());
            hv01801Pedinf().pedinf().nmFichOutpRtno().set(bghl018a().detalhe().nmFichOutpRtno());
            hv01801Pedinf().pedinf().qDiaDpnzInf().set(bghl018a().detalhe().qDiaDpnzInf());
            hv01801Pedinf().pedinf().cUsidActzUlt().set(bghl018a().detalhe().cUsidActzUlt());
            hv01801Pedinf().pedinf().tsActzUlt().set(bghl018a().detalhe().tsActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200ConsultaTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01801_PEDINF
         */
        hv01801Pedinf().selectMghs018a211() ;
        if (hv01801Pedinf().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteInf.setTrue() ;
        }
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl018a().argumento().cPedInfOpps().set(hv01801Pedinf().pedinf().cPedInfOpps());
            bghl018a().detalhe().dPedInfOpps().set(hv01801Pedinf().pedinf().dPedInfOpps());
            bghl018a().detalhe().cFrmtInf().set(hv01801Pedinf().pedinf().cFrmtInf());
            bghl018a().detalhe().cTipoRpte().set(hv01801Pedinf().pedinf().cTipoRpte());
            bghl018a().detalhe().nmFichOutpRtno().set(hv01801Pedinf().pedinf().nmFichOutpRtno());
            bghl018a().detalhe().qDiaDpnzInf().set(hv01801Pedinf().pedinf().qDiaDpnzInf());
            bghl018a().detalhe().cUsidActzUlt().set(hv01801Pedinf().pedinf().cUsidActzUlt());
            bghl018a().detalhe().tsActzUlt().set(hv01801Pedinf().pedinf().tsActzUlt());
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
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01801Pedinf().openMghs018a259() ;
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv01801Pedinf().fetchMghs018a271() ;
            if (hv01801Pedinf().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01801Pedinf().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01801().wsCPedInfOpps().set(hv01801Pedinf().pedinf().cPedInfOpps());
                wsVgh01801().wsDPedInfOpps().set(hv01801Pedinf().pedinf().dPedInfOpps());
                wsVgh01801().wsCFrmtInf().set(hv01801Pedinf().pedinf().cFrmtInf());
                wsVgh01801().wsCTipoRpte().set(hv01801Pedinf().pedinf().cTipoRpte());
                wsVgh01801().wsNmFichOutpRtno().set(hv01801Pedinf().pedinf().nmFichOutpRtno());
                wsVgh01801().wsQDiaDpnzInf().set(hv01801Pedinf().pedinf().qDiaDpnzInf());
                wsVgh01801().wsCUsidActzUlt().set(hv01801Pedinf().pedinf().cUsidActzUlt());
                wsVgh01801().wsTsActzUlt().set(hv01801Pedinf().pedinf().tsActzUlt());
                bghl018a().tabela().lista().get(wsInd).item().set(wsVgh01801());
                bghl018a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv01801Pedinf().fetchMghs018a311() ;
                if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01801Pedinf().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv01801Pedinf().closeMghs018a329() ;
            if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400InserirTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01801_PEDINF
         */
        hv01801Pedinf().insertMghs018a341(bghl018a().argumento(), bghl018a().detalhe()) ;
        if (hv01801Pedinf().getPersistenceCode() == PersistenceCode.DUPLICATED) {
            progJaExiste.setTrue() ;
        }
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.DUPLICATED && 
            hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500EliminarTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH01801_PEDINF
         */
        hv01801Pedinf().deleteMghs018a381(bghl018a().argumento().cPedInfOpps()) ;
        if (hv01801Pedinf().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteInf.setTrue() ;
        }
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
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
        bghl018a().cRetorno().set(progStatus);
        bghl018a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh01801 extends IDataStruct {
        
        @Data(size=7)
        IString wsCPedInfOpps() ;
        
        @Data(size=50)
        IString wsDPedInfOpps() ;
        
        @Data(size=1)
        IString wsCFrmtInf() ;
        
        @Data(size=1)
        IString wsCTipoRpte() ;
        
        @Data(size=20)
        IString wsNmFichOutpRtno() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt wsQDiaDpnzInf() ;
        
        @Data(size=8)
        IString wsCUsidActzUlt() ;
        
        @Data(size=26)
        IString wsTsActzUlt() ;
        
    }
}
