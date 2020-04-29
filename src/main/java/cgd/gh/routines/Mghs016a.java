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
import cgd.gh.structures.link.Bghl016a ;


/**
 * 
 * ***     SQL INCLUDE STATEMENTS    ***
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00016_OEATRDPED
 * DESCRICAO     : ACESSO A TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS016A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs016a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl016a
     */
    @Data
    public abstract Bghl016a bghl016a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01601Oeatrdped
     */
    @Data
    protected abstract Vwsdghps01601Oeatrdped hv01601Oeatrdped() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    
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
    @Condition("099")
    protected ICondition progNaoExisteInf ;
    @Data
    @Condition("077")
    protected ICondition progExistePedido ;
    @Data
    @Condition("089")
    protected ICondition progJaExiste ;
    @Data
    @Condition("094")
    protected ICondition progEstadoPdInv ;
    @Data
    @Condition("095")
    protected ICondition progPedidoInv ;
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
    
    @Data(size=8, signed=true, compression=COMP)
    protected ILong wsCount ;
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WsVgh01601
     */
    @Data
    protected abstract WsVgh01601 wsVgh01601() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl016a().cRetorno().initialize() ;
        bghl016a().cSqlcode().initialize() ;
        if (!bghl016a().acessoValido().isTrue()) {
            progDadosInvalidos.setTrue() ;
        }
        if (bghl016a().argumento().tsPedido().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl016a().consultar().isTrue()) {
                if (bghl016a().argumento().cPaisIsoaDest().isEmpty() || 
                    bghl016a().argumento().cMnemEgcDest().isEmpty() || 
                    bghl016a().argumento().cOeEgcDest().isEqual(0)) {
                    progDadosInvalidos.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (bghl016a().inserir().isTrue()) {
                if (bghl016a().argumento().tsPedido().isEqual(0) || 
                    bghl016a().argumento().cMnemEgcDest().isEmpty() || 
                    bghl016a().argumento().cOeEgcDest().isEqual(0) || 
                    bghl016a().detalhe().cUsidActzUlt().isZeros()) {
                    progDadosInvalidos.setTrue() ;
                }
            } else if (bghl016a().eliminar().isTrue()) {
                if (bghl016a().argumento().tsPedido().isEqual(0)) {
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
        if (bghl016a().consultar().isTrue()) {
            a5200Consulta() ;
        } else if (bghl016a().listar().isTrue()) {
            a5300Lista() ;
        } else if (bghl016a().inserir().isTrue()) {
            a5200Consulta() ;
        } else if (bghl016a().eliminar().isTrue()) {
            a5600Elimina() ;
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
        hv01601Oeatrdped().oeatrdped().initialize() ;
        hv01601Oeatrdped().oeatrdped().tsPedido().set(bghl016a().argumento().tsPedido());
        hv01601Oeatrdped().oeatrdped().cPaisIsoaDest().set(bghl016a().argumento().cPaisIsoaDest());
        hv01601Oeatrdped().oeatrdped().cMnemEgcDest().set(bghl016a().argumento().cMnemEgcDest());
        hv01601Oeatrdped().oeatrdped().cOeEgcDest().set(bghl016a().argumento().cOeEgcDest());
        if (bghl016a().inserir().isTrue()) {
            hv01601Oeatrdped().oeatrdped().cUsidActzUlt().set(bghl016a().detalhe().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200Consulta() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01601_OEATRDPED
         */
        hv01601Oeatrdped().selectMghs016a243() ;
        switch (hv01601Oeatrdped().getPersistenceCode()) {
            case NORMAL:
                if (bghl016a().inserir().isTrue()) {
                    progJaExiste.setTrue() ;
                }
                break;
            case NOTFND:
                if (bghl016a().inserir().isTrue()) {
                    a5510VerEstPedido() ;
                    if (progOk.isTrue()) {
                        a5500Insere() ;
                    }
                } else {
                    progNaoExisteInf.setTrue() ;
                }
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (bghl016a().consultar().isTrue()) {
                bghl016a().argumento().cPaisIsoaDest().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
                bghl016a().argumento().cMnemEgcDest().set(hv01601Oeatrdped().oeatrdped().cMnemEgcDest());
                bghl016a().argumento().cOeEgcDest().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
                bghl016a().detalhe().tsActzUlt().set(hv01601Oeatrdped().oeatrdped().tsActzUlt());
                bghl016a().detalhe().cUsidActzUlt().set(hv01601Oeatrdped().oeatrdped().cUsidActzUlt());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5510VerEstPedido() {
        /**
         * *----------------------------------------------------------------*
         */
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().tsPedido().set(bghl016a().argumento().tsPedido());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv01501Pedmovhst().openMghs016a304() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv01501Pedmovhst().fetchMghs016a316() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progEstadoPdInv.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv01501Pedmovhst().closeMghs016a333() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300Lista() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01601Oeatrdped().openMghs016a345() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv01601Oeatrdped().fetchMghs016a357() ;
            if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01601().wsCPaisIsoaDest().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
                wsVgh01601().wsCMnemEgcDest().set(hv01601Oeatrdped().oeatrdped().cMnemEgcDest());
                wsVgh01601().wsCOeEgcDest().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
                wsVgh01601().wsTsActzUlt().set(hv01601Oeatrdped().oeatrdped().tsActzUlt());
                wsVgh01601().wsCUsidActzUlt().set(hv01601Oeatrdped().oeatrdped().cUsidActzUlt());
                bghl016a().tabela().lista().get(wsInd).item().set(wsVgh01601());
                bghl016a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv01601Oeatrdped().fetchMghs016a389() ;
                if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv01601Oeatrdped().closeMghs016a407() ;
            if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500Insere() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01601_OEATRDPED
         */
        hv01601Oeatrdped().insertMghs016a420() ;
        if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.DUPLICATED) {
            progJaExiste.setTrue() ;
        }
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.DUPLICATED && 
            hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5600Elimina() {
        /**
         * *----------------------------------------------------------------*
         */
        a5610VerificaPedidos() ;
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (DELETE) table VGH01601_OEATRDPED
             */
            hv01601Oeatrdped().deleteMghs016a458() ;
            if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5610VerificaPedidos() {
        /**
         * *----------------------------------------------------------------*
         */
        wsCount.initialize() ;
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01601Oeatrdped().oeatrdped().tsPedido().set(bghl016a().argumento().tsPedido());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01601_OEATRDPED
         */
        hv01601Oeatrdped().selectMghs016a489(wsCount) ;
        switch (hv01601Oeatrdped().getPersistenceCode()) {
            case NORMAL:
                if (wsCount.isLessOrEqual(1)) {
                    progExistePedido.setTrue() ;
                }
                break;
            case NOTFND:
                progPedidoInv.setTrue() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
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
        bghl016a().cRetorno().set(progStatus);
        bghl016a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh01601 extends IDataStruct {
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsTsPedido() ;
        
        @Data(size=3)
        IString wsCPaisIsoaDest() ;
        
        @Data(size=3)
        IString wsCMnemEgcDest() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcDest() ;
        
        @Data(size=26)
        IString wsTsActzUlt() ;
        
        @Data(size=8)
        IString wsCUsidActzUlt() ;
        
    }
}
