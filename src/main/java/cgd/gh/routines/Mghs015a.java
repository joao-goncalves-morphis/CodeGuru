package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl015a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * NAO MOSTRAR PEDIDOS DA DAI(9200 A 9299)
 * *GH805--> INICIO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00015_PEDMOVHST
 * DESCRICAO     : ACESSO A TABELA
 * ALTERAÇÕES :   2011-03-14 - OS PEDIDOS DA TAPE GHSA1999 SO
 * ADMITEM UM PEDIDO POR CONTA
 * :   2011-12-15 - GH805 - ALTERACAO DAS VALIDACOES
 * PARA O PEDIDO GH00005
 * :   2019-10-09 - PREÇÁRIO 2019 - INCLUSÃO DO NUMERO
 * DE CLIENTE NA TGH015
 * 
 * migrated from program [MGHS015A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs015a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl015a
     */
    @Data
    public abstract Bghl015a bghl015a() ;
    
    
    /**
     * Handled Tables
     */
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
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlTape ;
    @Data
    @Condition("A")
    protected ICondition tapeGrande ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlOeDai ;
    @Data
    @Condition("1")
    protected ICondition oeDai ;
    
    
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
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=15, signed=true, compression=COMP3)
    protected ILong waTsPedido ;
    
    @Data(size=4, signed=true, compression=COMP3)
    protected IInt wsZaInicMov ;
    
    @Data(size=15)
    protected ILong wTsPedido ;
    
    /**
     * @return instancia da classe local WTsPedidoMask
     */
    @Data
    @Mask
    protected abstract WTsPedidoMask wTsPedidoMask() ;
    
    /**
     * @return instancia da classe local WsVgh01501
     */
    @Data
    protected abstract WsVgh01501 wsVgh01501() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl015a().cRetorno().initialize() ;
        bghl015a().cSqlcode().initialize() ;
        wsCrtlOeDai.initialize() ;
        if (!bghl015a().acessoValido().isTrue()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl015a().consultar().isTrue()) {
                if (bghl015a().argumento().cPaisIsoaCont().isEmpty() || 
                    bghl015a().argumento().cBancCont().isEqual(0) || 
                    bghl015a().argumento().cOeEgcCont().isEqual(0) || 
                    bghl015a().argumento().nsRdclCont().isEqual(0) || 
                    bghl015a().argumento().cPedInfOpps().isEmpty() || 
                    bghl015a().argumento().zInicMov().isEmpty() || 
                    bghl015a().argumento().zFimMov().isEmpty()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (bghl015a().listarSubconta().isTrue()) {
                if (bghl015a().argumento().cPaisIsoaCont().isEmpty() || 
                    bghl015a().argumento().cBancCont().isEqual(0) || 
                    bghl015a().argumento().cOeEgcCont().isEqual(0) || 
                    bghl015a().argumento().nsRdclCont().isEqual(0)) {
                    progDadosInvalidos.setTrue() ;
                } else if (bghl015a().detalhe().cOeEgcOpex().isGreater(0)) {
                    oeDai.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (bghl015a().listarPedido().isTrue() || bghl015a().eliminar().isTrue()) {
                if (bghl015a().detalhe().tsPedido().isEqual(0)) {
                    progDadosInvalidos.setTrue() ;
                } else if (bghl015a().detalhe().cOeEgcOpex().isGreater(0)) {
                    oeDai.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (bghl015a().inserir().isTrue()) {
                if (bghl015a().argumento().cPaisIsoaCont().isEmpty() || 
                    bghl015a().argumento().cBancCont().isEqual(0) || 
                    bghl015a().argumento().cOeEgcCont().isEqual(0) || 
                    bghl015a().argumento().nsRdclCont().isEqual(0) || 
                    bghl015a().argumento().cPedInfOpps().isEmpty() || 
                    bghl015a().argumento().zInicMov().isEmpty() || 
                    bghl015a().argumento().zFimMov().isEmpty() || 
                    bghl015a().detalhe().zPedido().isEmpty() || 
                    bghl015a().detalhe().cEstPedHist().isEmpty() || 
                    bghl015a().detalhe().cTipoRpte().isEmpty() || 
                    bghl015a().detalhe().nmFichOutpRtno().isEmpty() || 
                    bghl015a().detalhe().cFrmtInf().isEmpty() || 
                    bghl015a().detalhe().qDiaDpnzInf().isEqual(0) || 
                    bghl015a().detalhe().cUsidCrix().isEmpty() || 
                    bghl015a().detalhe().cPaisIsoaOeOpx().isEmpty() || 
                    bghl015a().detalhe().cMnemEgcOpex().isEmpty() || 
                    bghl015a().detalhe().cOeEgcOpex().isEqual(0) || 
                    bghl015a().detalhe().cUsidActzUlt().isEmpty()) {
                    progDadosInvalidos.setTrue() ;
                }
                if (progOk.isTrue()) {
                    if (bghl015a().detalhe().tsPedido().isEqual(0)) {
                        wsTimestamp.set( getDBTimestamp() ) ;
                        wTimestamp().set(wsTimestamp);
                        wTsPedidoMask().wAnoPedido().set(wTimestamp().wDataTimestamp().wAnoAa());
                        wTsPedidoMask().wMesPedido().set(wTimestamp().wDataTimestamp().wMesMm());
                        wTsPedidoMask().wDiaPedido().set(wTimestamp().wDataTimestamp().wDiaDd());
                        wTsPedidoMask().wHhPedido().set(wTimestamp().wTimerTimestamp().wHh());
                        wTsPedidoMask().wMmPedido().set(wTimestamp().wTimerTimestamp().wMm());
                        wTsPedidoMask().wSsPedido().set(wTimestamp().wTimerTimestamp().wSs());
                        wTsPedidoMask().wDdPedido().set(wTimestamp().wTimerTimestamp().wDd().get(1, 1));
                        waTsPedido.set(wTsPedido);
                        bghl015a().detalhe().tsPedido().set(waTsPedido);
                    }
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
        /**
         * *GH805--> FIM
         */
        if (bghl015a().consultar().isTrue()) {
            a5200Consulta() ;
        } else if (bghl015a().listarSubconta().isTrue()) {
            if (oeDai.isTrue()) {
                a5300ListaSubconta() ;
            } else {
                a5310ListaSubcontaOutros() ;
            }
        } else if (bghl015a().listarPedido().isTrue()) {
            if (oeDai.isTrue()) {
                a5400ListaPedido() ;
            } else {
                a5410ListaPedidoOutros() ;
            }
        } else if (bghl015a().inserir().isTrue()) {
            a5500Insere() ;
        } else if (bghl015a().eliminar().isTrue()) {
            a5600Elimina() ;
        } else if (bghl015a().cnslPed().isTrue()) {
            a5700ConsultaPedido() ;
        } else if (bghl015a().cnslCntPed().isTrue()) {
            a5800ConsultaConta() ;
        } else if (bghl015a().cnslPedAct().isTrue()) {
            a5900CnsltPedidoAct() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5100FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         * *GH805--> FIM
         */
        hv01501Pedmovhst().pedmovhst().initialize() ;
        if (bghl015a().consultar().isTrue()) {
            hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl015a().argumento().cPaisIsoaCont());
            hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl015a().argumento().cBancCont());
            hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl015a().argumento().cOeEgcCont());
            hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl015a().argumento().nsRdclCont());
            hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl015a().argumento().vChkdCont());
            hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl015a().argumento().cTipoCont());
            hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl015a().argumento().cMoedIsoScta());
            hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl015a().argumento().nsDeposito());
            hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl015a().argumento().cPedInfOpps());
            hv01501Pedmovhst().pedmovhst().zInicMov().set(bghl015a().argumento().zInicMov());
            hv01501Pedmovhst().pedmovhst().zFimMov().set(bghl015a().argumento().zFimMov());
        }
        if (bghl015a().listarSubconta().isTrue()) {
            hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl015a().argumento().cPaisIsoaCont());
            hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl015a().argumento().cBancCont());
            hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl015a().argumento().cOeEgcCont());
            hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl015a().argumento().nsRdclCont());
            hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl015a().argumento().vChkdCont());
            hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl015a().argumento().cTipoCont());
            hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl015a().argumento().cMoedIsoScta());
            hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl015a().argumento().nsDeposito());
            hv01501Pedmovhst().pedmovhst().tsPedido().set(bghl015a().detalhe().tsPedido());
        }
        if (bghl015a().cnslPed().isTrue()) {
            hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl015a().argumento().cPedInfOpps());
            hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl015a().argumento().cPaisIsoaCont());
            hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl015a().argumento().cBancCont());
            hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl015a().argumento().cOeEgcCont());
            hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl015a().argumento().nsRdclCont());
            hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl015a().argumento().vChkdCont());
            hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl015a().argumento().cTipoCont());
            hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl015a().argumento().cMoedIsoScta());
            hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl015a().argumento().nsDeposito());
            hv01501Pedmovhst().pedmovhst().tsPedido().set(bghl015a().detalhe().tsPedido());
        }
        if (bghl015a().cnslCntPed().isTrue()) {
            hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl015a().argumento().cPedInfOpps());
            hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl015a().argumento().cPaisIsoaCont());
            hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl015a().argumento().cBancCont());
            hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl015a().argumento().cOeEgcCont());
            hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl015a().argumento().nsRdclCont());
            hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl015a().argumento().vChkdCont());
            hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl015a().argumento().cTipoCont());
            hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl015a().argumento().cMoedIsoScta());
            hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl015a().argumento().nsDeposito());
            wsZaInicMov.set(bghl015a().argumento().zInicMov().get(1, 4));
            if (wsZaInicMov.isEqual(1989)) {
                tapeGrande.setTrue() ;
            }
        }
        if (bghl015a().listarPedido().isTrue() || bghl015a().eliminar().isTrue()) {
            hv01501Pedmovhst().pedmovhst().tsPedido().set(bghl015a().detalhe().tsPedido());
        }
        if (bghl015a().inserir().isTrue()) {
            hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl015a().argumento().cPaisIsoaCont());
            hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl015a().argumento().cBancCont());
            hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl015a().argumento().cOeEgcCont());
            hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl015a().argumento().nsRdclCont());
            hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl015a().argumento().vChkdCont());
            hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl015a().argumento().cTipoCont());
            hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl015a().argumento().cMoedIsoScta());
            hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl015a().argumento().nsDeposito());
            hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl015a().argumento().cPedInfOpps());
            hv01501Pedmovhst().pedmovhst().zInicMov().set(bghl015a().argumento().zInicMov());
            hv01501Pedmovhst().pedmovhst().zFimMov().set(bghl015a().argumento().zFimMov());
            hv01501Pedmovhst().pedmovhst().tsPedido().set(bghl015a().detalhe().tsPedido());
            hv01501Pedmovhst().pedmovhst().zPedido().set(bghl015a().detalhe().zPedido());
            hv01501Pedmovhst().pedmovhst().cEstPedHist().set(bghl015a().detalhe().cEstPedHist());
            hv01501Pedmovhst().pedmovhst().cTipoRpte().set(bghl015a().detalhe().cTipoRpte());
            hv01501Pedmovhst().pedmovhst().nmFichOutpRtno().set(bghl015a().detalhe().nmFichOutpRtno());
            hv01501Pedmovhst().pedmovhst().aAplDest().set(bghl015a().detalhe().aAplDest());
            hv01501Pedmovhst().pedmovhst().cFrmtInf().set(bghl015a().detalhe().cFrmtInf());
            hv01501Pedmovhst().pedmovhst().cCanlTrmzInf().set(bghl015a().detalhe().cCanlTrmzInf());
            hv01501Pedmovhst().pedmovhst().cEndcFtpDest().set(bghl015a().detalhe().cEndcFtpDest());
            hv01501Pedmovhst().pedmovhst().zCluzPed().set(bghl015a().detalhe().zCluzPed());
            hv01501Pedmovhst().pedmovhst().qDiaDpnzInf().set(bghl015a().detalhe().qDiaDpnzInf());
            hv01501Pedmovhst().pedmovhst().mParmPedHstMax().set(bghl015a().detalhe().mParmPedHstMax());
            hv01501Pedmovhst().pedmovhst().mParmPedHstMin().set(bghl015a().detalhe().mParmPedHstMin());
            hv01501Pedmovhst().pedmovhst().cParmPedHstMax().set(bghl015a().detalhe().cParmPedHstMax());
            hv01501Pedmovhst().pedmovhst().cParmPedHstMin().set(bghl015a().detalhe().cParmPedHstMin());
            hv01501Pedmovhst().pedmovhst().xMtvoDvlzPed().set(bghl015a().detalhe().xMtvoDvlzPed());
            hv01501Pedmovhst().pedmovhst().zEliminacao().set(bghl015a().detalhe().zEliminacao());
            hv01501Pedmovhst().pedmovhst().cUsidCrix().set(bghl015a().detalhe().cUsidCrix());
            hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set(bghl015a().detalhe().cPaisIsoaOeOpx());
            hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set(bghl015a().detalhe().cMnemEgcOpex());
            hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(bghl015a().detalhe().cOeEgcOpex());
            hv01501Pedmovhst().pedmovhst().qDdbtPed().set(0);
            hv01501Pedmovhst().pedmovhst().tsActzUlt().set(bghl015a().detalhe().tsActzUlt());
            hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghl015a().detalhe().cUsidActzUlt());
            hv01501Pedmovhst().pedmovhst().nCliPed().set(bghl015a().nClientePed());
            hv01501Pedmovhst().pedmovhst().nsAbraCliPed().set(bghl015a().nsAbraCliPed());
        }
        /**
         * *GH805--> INICIO
         */
        if (bghl015a().cnslPedAct().isTrue()) {
            hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl015a().argumento().cPedInfOpps());
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
         * call to extracted method to access (SELECT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().selectMghs015a888() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteInf.setTrue() ;
        }
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl015a().argumento().cPaisIsoaCont().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
            bghl015a().argumento().cBancCont().set(hv01501Pedmovhst().pedmovhst().cBancCont());
            bghl015a().argumento().cOeEgcCont().set(hv01501Pedmovhst().pedmovhst().cOeEgcCont());
            bghl015a().argumento().nsRdclCont().set(hv01501Pedmovhst().pedmovhst().nsRdclCont());
            bghl015a().argumento().vChkdCont().set(hv01501Pedmovhst().pedmovhst().vChkdCont());
            bghl015a().argumento().cTipoCont().set(hv01501Pedmovhst().pedmovhst().cTipoCont());
            bghl015a().argumento().cMoedIsoScta().set(hv01501Pedmovhst().pedmovhst().cMoedIsoScta());
            bghl015a().argumento().nsDeposito().set(hv01501Pedmovhst().pedmovhst().nsDeposito());
            bghl015a().argumento().cPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
            bghl015a().argumento().zInicMov().set(hv01501Pedmovhst().pedmovhst().zInicMov());
            bghl015a().argumento().zFimMov().set(hv01501Pedmovhst().pedmovhst().zFimMov());
            bghl015a().detalhe().tsPedido().set(hv01501Pedmovhst().pedmovhst().tsPedido());
            bghl015a().detalhe().zPedido().set(hv01501Pedmovhst().pedmovhst().zPedido());
            bghl015a().detalhe().cEstPedHist().set(hv01501Pedmovhst().pedmovhst().cEstPedHist());
            bghl015a().detalhe().cTipoRpte().set(hv01501Pedmovhst().pedmovhst().cTipoRpte());
            bghl015a().detalhe().nmFichOutpRtno().set(hv01501Pedmovhst().pedmovhst().nmFichOutpRtno());
            bghl015a().detalhe().aAplDest().set(hv01501Pedmovhst().pedmovhst().aAplDest());
            bghl015a().detalhe().cFrmtInf().set(hv01501Pedmovhst().pedmovhst().cFrmtInf());
            bghl015a().detalhe().cCanlTrmzInf().set(hv01501Pedmovhst().pedmovhst().cCanlTrmzInf());
            bghl015a().detalhe().cEndcFtpDest().set(hv01501Pedmovhst().pedmovhst().cEndcFtpDest());
            bghl015a().detalhe().zCluzPed().set(hv01501Pedmovhst().pedmovhst().zCluzPed());
            bghl015a().detalhe().qDiaDpnzInf().set(hv01501Pedmovhst().pedmovhst().qDiaDpnzInf());
            bghl015a().detalhe().mParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMax());
            bghl015a().detalhe().mParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMin());
            bghl015a().detalhe().cParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMax());
            bghl015a().detalhe().cParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMin());
            bghl015a().detalhe().xMtvoDvlzPed().set(hv01501Pedmovhst().pedmovhst().xMtvoDvlzPed());
            bghl015a().detalhe().zEliminacao().set(hv01501Pedmovhst().pedmovhst().zEliminacao());
            bghl015a().detalhe().cUsidCrix().set(hv01501Pedmovhst().pedmovhst().cUsidCrix());
            bghl015a().detalhe().cPaisIsoaOeOpx().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx());
            bghl015a().detalhe().cMnemEgcOpex().set(hv01501Pedmovhst().pedmovhst().cMnemEgcOpex());
            bghl015a().detalhe().cOeEgcOpex().set(hv01501Pedmovhst().pedmovhst().cOeEgcOpex());
            bghl015a().detalhe().qDdbtPed().set(hv01501Pedmovhst().pedmovhst().qDdbtPed());
            bghl015a().nClientePed().set(hv01501Pedmovhst().pedmovhst().nCliPed());
            bghl015a().nsAbraCliPed().set(hv01501Pedmovhst().pedmovhst().nsAbraCliPed());
            bghl015a().detalhe().tsActzUlt().set(hv01501Pedmovhst().pedmovhst().tsActzUlt());
            bghl015a().detalhe().cUsidActzUlt().set(hv01501Pedmovhst().pedmovhst().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300ListaSubconta() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01501Pedmovhst().openMghs015a1008() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv01501Pedmovhst().fetchMghs015a1020() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01501().wsCPaisIsoaCont().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
                wsVgh01501().wsCBancCont().set(hv01501Pedmovhst().pedmovhst().cBancCont());
                wsVgh01501().wsCOeEgcCont().set(hv01501Pedmovhst().pedmovhst().cOeEgcCont());
                wsVgh01501().wsNsRdclCont().set(hv01501Pedmovhst().pedmovhst().nsRdclCont());
                wsVgh01501().wsVChkdCont().set(hv01501Pedmovhst().pedmovhst().vChkdCont());
                wsVgh01501().wsCTipoCont().set(hv01501Pedmovhst().pedmovhst().cTipoCont());
                wsVgh01501().wsCMoedIsoScta().set(hv01501Pedmovhst().pedmovhst().cMoedIsoScta());
                wsVgh01501().wsNsDeposito().set(hv01501Pedmovhst().pedmovhst().nsDeposito());
                wsVgh01501().wsCPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
                wsVgh01501().wsZInicMov().set(hv01501Pedmovhst().pedmovhst().zInicMov());
                wsVgh01501().wsZFimMov().set(hv01501Pedmovhst().pedmovhst().zFimMov());
                wsVgh01501().wsTsPedido().set(hv01501Pedmovhst().pedmovhst().tsPedido());
                wsVgh01501().wsZPedido().set(hv01501Pedmovhst().pedmovhst().zPedido());
                wsVgh01501().wsCEstPedHist().set(hv01501Pedmovhst().pedmovhst().cEstPedHist());
                wsVgh01501().wsCTipoRpte().set(hv01501Pedmovhst().pedmovhst().cTipoRpte());
                wsVgh01501().wsNmFichOutpRtno().set(hv01501Pedmovhst().pedmovhst().nmFichOutpRtno());
                wsVgh01501().wsAAplDest().set(hv01501Pedmovhst().pedmovhst().aAplDest());
                wsVgh01501().wsCFrmtInf().set(hv01501Pedmovhst().pedmovhst().cFrmtInf());
                wsVgh01501().wsCCanlTrmzInf().set(hv01501Pedmovhst().pedmovhst().cCanlTrmzInf());
                wsVgh01501().wsCEndcFtpDest().set(hv01501Pedmovhst().pedmovhst().cEndcFtpDest());
                wsVgh01501().wsZCluzPed().set(hv01501Pedmovhst().pedmovhst().zCluzPed());
                wsVgh01501().wsQDiaDpnzInf().set(hv01501Pedmovhst().pedmovhst().qDiaDpnzInf());
                wsVgh01501().wsMParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMax());
                wsVgh01501().wsMParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMin());
                wsVgh01501().wsCParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMax());
                wsVgh01501().wsCParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMin());
                wsVgh01501().wsXMtvoDvlzPed().set(hv01501Pedmovhst().pedmovhst().xMtvoDvlzPed());
                wsVgh01501().wsZEliminacao().set(hv01501Pedmovhst().pedmovhst().zEliminacao());
                wsVgh01501().wsCUsidCrix().set(hv01501Pedmovhst().pedmovhst().cUsidCrix());
                wsVgh01501().wsCPaisIsoaOeOpx().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx());
                wsVgh01501().wsCMnemEgcOpex().set(hv01501Pedmovhst().pedmovhst().cMnemEgcOpex());
                wsVgh01501().wsCOeEgcOpex().set(hv01501Pedmovhst().pedmovhst().cOeEgcOpex());
                wsVgh01501().wsQDdbtPed().set(hv01501Pedmovhst().pedmovhst().qDdbtPed());
                wsVgh01501().wsTsActzUlt().set(hv01501Pedmovhst().pedmovhst().tsActzUlt());
                wsVgh01501().wsCUsidActzUlt().set(hv01501Pedmovhst().pedmovhst().cUsidActzUlt());
                bghl015a().tabela().lista().get(wsInd).item().set(wsVgh01501());
                bghl015a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv01501Pedmovhst().fetchMghs015a1091() ;
                if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv01501Pedmovhst().closeMghs015a1109() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5310ListaSubcontaOutros() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C6
         */
        hv01501Pedmovhst().openMghs015a1121() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C6
             */
            hv01501Pedmovhst().fetchMghs015a1133() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01501().wsCPaisIsoaCont().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
                wsVgh01501().wsCBancCont().set(hv01501Pedmovhst().pedmovhst().cBancCont());
                wsVgh01501().wsCOeEgcCont().set(hv01501Pedmovhst().pedmovhst().cOeEgcCont());
                wsVgh01501().wsNsRdclCont().set(hv01501Pedmovhst().pedmovhst().nsRdclCont());
                wsVgh01501().wsVChkdCont().set(hv01501Pedmovhst().pedmovhst().vChkdCont());
                wsVgh01501().wsCTipoCont().set(hv01501Pedmovhst().pedmovhst().cTipoCont());
                wsVgh01501().wsCMoedIsoScta().set(hv01501Pedmovhst().pedmovhst().cMoedIsoScta());
                wsVgh01501().wsNsDeposito().set(hv01501Pedmovhst().pedmovhst().nsDeposito());
                wsVgh01501().wsCPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
                wsVgh01501().wsZInicMov().set(hv01501Pedmovhst().pedmovhst().zInicMov());
                wsVgh01501().wsZFimMov().set(hv01501Pedmovhst().pedmovhst().zFimMov());
                wsVgh01501().wsTsPedido().set(hv01501Pedmovhst().pedmovhst().tsPedido());
                wsVgh01501().wsZPedido().set(hv01501Pedmovhst().pedmovhst().zPedido());
                wsVgh01501().wsCEstPedHist().set(hv01501Pedmovhst().pedmovhst().cEstPedHist());
                wsVgh01501().wsCTipoRpte().set(hv01501Pedmovhst().pedmovhst().cTipoRpte());
                wsVgh01501().wsNmFichOutpRtno().set(hv01501Pedmovhst().pedmovhst().nmFichOutpRtno());
                wsVgh01501().wsAAplDest().set(hv01501Pedmovhst().pedmovhst().aAplDest());
                wsVgh01501().wsCFrmtInf().set(hv01501Pedmovhst().pedmovhst().cFrmtInf());
                wsVgh01501().wsCCanlTrmzInf().set(hv01501Pedmovhst().pedmovhst().cCanlTrmzInf());
                wsVgh01501().wsCEndcFtpDest().set(hv01501Pedmovhst().pedmovhst().cEndcFtpDest());
                wsVgh01501().wsZCluzPed().set(hv01501Pedmovhst().pedmovhst().zCluzPed());
                wsVgh01501().wsQDiaDpnzInf().set(hv01501Pedmovhst().pedmovhst().qDiaDpnzInf());
                wsVgh01501().wsMParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMax());
                wsVgh01501().wsMParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMin());
                wsVgh01501().wsCParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMax());
                wsVgh01501().wsCParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMin());
                wsVgh01501().wsXMtvoDvlzPed().set(hv01501Pedmovhst().pedmovhst().xMtvoDvlzPed());
                wsVgh01501().wsZEliminacao().set(hv01501Pedmovhst().pedmovhst().zEliminacao());
                wsVgh01501().wsCUsidCrix().set(hv01501Pedmovhst().pedmovhst().cUsidCrix());
                wsVgh01501().wsCPaisIsoaOeOpx().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx());
                wsVgh01501().wsCMnemEgcOpex().set(hv01501Pedmovhst().pedmovhst().cMnemEgcOpex());
                wsVgh01501().wsCOeEgcOpex().set(hv01501Pedmovhst().pedmovhst().cOeEgcOpex());
                wsVgh01501().wsQDdbtPed().set(hv01501Pedmovhst().pedmovhst().qDdbtPed());
                wsVgh01501().wsTsActzUlt().set(hv01501Pedmovhst().pedmovhst().tsActzUlt());
                wsVgh01501().wsCUsidActzUlt().set(hv01501Pedmovhst().pedmovhst().cUsidActzUlt());
                bghl015a().tabela().lista().get(wsInd).item().set(wsVgh01501());
                bghl015a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C6
                 */
                hv01501Pedmovhst().fetchMghs015a1204() ;
                if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C6
             */
            hv01501Pedmovhst().closeMghs015a1222() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400ListaPedido() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv01501Pedmovhst().openMghs015a1235() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv01501Pedmovhst().fetchMghs015a1247() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01501().wsCPaisIsoaCont().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
                wsVgh01501().wsCBancCont().set(hv01501Pedmovhst().pedmovhst().cBancCont());
                wsVgh01501().wsCOeEgcCont().set(hv01501Pedmovhst().pedmovhst().cOeEgcCont());
                wsVgh01501().wsNsRdclCont().set(hv01501Pedmovhst().pedmovhst().nsRdclCont());
                wsVgh01501().wsVChkdCont().set(hv01501Pedmovhst().pedmovhst().vChkdCont());
                wsVgh01501().wsCTipoCont().set(hv01501Pedmovhst().pedmovhst().cTipoCont());
                wsVgh01501().wsCMoedIsoScta().set(hv01501Pedmovhst().pedmovhst().cMoedIsoScta());
                wsVgh01501().wsNsDeposito().set(hv01501Pedmovhst().pedmovhst().nsDeposito());
                wsVgh01501().wsCPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
                wsVgh01501().wsZInicMov().set(hv01501Pedmovhst().pedmovhst().zInicMov());
                wsVgh01501().wsZFimMov().set(hv01501Pedmovhst().pedmovhst().zFimMov());
                wsVgh01501().wsTsPedido().set(hv01501Pedmovhst().pedmovhst().tsPedido());
                wsVgh01501().wsZPedido().set(hv01501Pedmovhst().pedmovhst().zPedido());
                wsVgh01501().wsCEstPedHist().set(hv01501Pedmovhst().pedmovhst().cEstPedHist());
                wsVgh01501().wsCTipoRpte().set(hv01501Pedmovhst().pedmovhst().cTipoRpte());
                wsVgh01501().wsNmFichOutpRtno().set(hv01501Pedmovhst().pedmovhst().nmFichOutpRtno());
                wsVgh01501().wsAAplDest().set(hv01501Pedmovhst().pedmovhst().aAplDest());
                wsVgh01501().wsCFrmtInf().set(hv01501Pedmovhst().pedmovhst().cFrmtInf());
                wsVgh01501().wsCCanlTrmzInf().set(hv01501Pedmovhst().pedmovhst().cCanlTrmzInf());
                wsVgh01501().wsCEndcFtpDest().set(hv01501Pedmovhst().pedmovhst().cEndcFtpDest());
                wsVgh01501().wsZCluzPed().set(hv01501Pedmovhst().pedmovhst().zCluzPed());
                wsVgh01501().wsQDiaDpnzInf().set(hv01501Pedmovhst().pedmovhst().qDiaDpnzInf());
                wsVgh01501().wsMParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMax());
                wsVgh01501().wsMParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMin());
                wsVgh01501().wsCParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMax());
                wsVgh01501().wsCParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMin());
                wsVgh01501().wsXMtvoDvlzPed().set(hv01501Pedmovhst().pedmovhst().xMtvoDvlzPed());
                wsVgh01501().wsZEliminacao().set(hv01501Pedmovhst().pedmovhst().zEliminacao());
                wsVgh01501().wsCUsidCrix().set(hv01501Pedmovhst().pedmovhst().cUsidCrix());
                wsVgh01501().wsCPaisIsoaOeOpx().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx());
                wsVgh01501().wsCMnemEgcOpex().set(hv01501Pedmovhst().pedmovhst().cMnemEgcOpex());
                wsVgh01501().wsCOeEgcOpex().set(hv01501Pedmovhst().pedmovhst().cOeEgcOpex());
                wsVgh01501().wsQDdbtPed().set(hv01501Pedmovhst().pedmovhst().qDdbtPed());
                wsVgh01501().wsTsActzUlt().set(hv01501Pedmovhst().pedmovhst().tsActzUlt());
                wsVgh01501().wsCUsidActzUlt().set(hv01501Pedmovhst().pedmovhst().cUsidActzUlt());
                bghl015a().tabela().lista().get(wsInd).item().set(wsVgh01501());
                bghl015a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv01501Pedmovhst().fetchMghs015a1318() ;
                if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv01501Pedmovhst().closeMghs015a1336() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5410ListaPedidoOutros() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C7
         */
        hv01501Pedmovhst().openMghs015a1348() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C7
             */
            hv01501Pedmovhst().fetchMghs015a1360() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(11); wsInd.add(1)) {
                wsVgh01501().wsCPaisIsoaCont().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
                wsVgh01501().wsCBancCont().set(hv01501Pedmovhst().pedmovhst().cBancCont());
                wsVgh01501().wsCOeEgcCont().set(hv01501Pedmovhst().pedmovhst().cOeEgcCont());
                wsVgh01501().wsNsRdclCont().set(hv01501Pedmovhst().pedmovhst().nsRdclCont());
                wsVgh01501().wsVChkdCont().set(hv01501Pedmovhst().pedmovhst().vChkdCont());
                wsVgh01501().wsCTipoCont().set(hv01501Pedmovhst().pedmovhst().cTipoCont());
                wsVgh01501().wsCMoedIsoScta().set(hv01501Pedmovhst().pedmovhst().cMoedIsoScta());
                wsVgh01501().wsNsDeposito().set(hv01501Pedmovhst().pedmovhst().nsDeposito());
                wsVgh01501().wsCPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
                wsVgh01501().wsZInicMov().set(hv01501Pedmovhst().pedmovhst().zInicMov());
                wsVgh01501().wsZFimMov().set(hv01501Pedmovhst().pedmovhst().zFimMov());
                wsVgh01501().wsTsPedido().set(hv01501Pedmovhst().pedmovhst().tsPedido());
                wsVgh01501().wsZPedido().set(hv01501Pedmovhst().pedmovhst().zPedido());
                wsVgh01501().wsCEstPedHist().set(hv01501Pedmovhst().pedmovhst().cEstPedHist());
                wsVgh01501().wsCTipoRpte().set(hv01501Pedmovhst().pedmovhst().cTipoRpte());
                wsVgh01501().wsNmFichOutpRtno().set(hv01501Pedmovhst().pedmovhst().nmFichOutpRtno());
                wsVgh01501().wsAAplDest().set(hv01501Pedmovhst().pedmovhst().aAplDest());
                wsVgh01501().wsCFrmtInf().set(hv01501Pedmovhst().pedmovhst().cFrmtInf());
                wsVgh01501().wsCCanlTrmzInf().set(hv01501Pedmovhst().pedmovhst().cCanlTrmzInf());
                wsVgh01501().wsCEndcFtpDest().set(hv01501Pedmovhst().pedmovhst().cEndcFtpDest());
                wsVgh01501().wsZCluzPed().set(hv01501Pedmovhst().pedmovhst().zCluzPed());
                wsVgh01501().wsQDiaDpnzInf().set(hv01501Pedmovhst().pedmovhst().qDiaDpnzInf());
                wsVgh01501().wsMParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMax());
                wsVgh01501().wsMParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().mParmPedHstMin());
                wsVgh01501().wsCParmPedHstMax().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMax());
                wsVgh01501().wsCParmPedHstMin().set(hv01501Pedmovhst().pedmovhst().cParmPedHstMin());
                wsVgh01501().wsXMtvoDvlzPed().set(hv01501Pedmovhst().pedmovhst().xMtvoDvlzPed());
                wsVgh01501().wsZEliminacao().set(hv01501Pedmovhst().pedmovhst().zEliminacao());
                wsVgh01501().wsCUsidCrix().set(hv01501Pedmovhst().pedmovhst().cUsidCrix());
                wsVgh01501().wsCPaisIsoaOeOpx().set(hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx());
                wsVgh01501().wsCMnemEgcOpex().set(hv01501Pedmovhst().pedmovhst().cMnemEgcOpex());
                wsVgh01501().wsCOeEgcOpex().set(hv01501Pedmovhst().pedmovhst().cOeEgcOpex());
                wsVgh01501().wsQDdbtPed().set(hv01501Pedmovhst().pedmovhst().qDdbtPed());
                wsVgh01501().wsTsActzUlt().set(hv01501Pedmovhst().pedmovhst().tsActzUlt());
                wsVgh01501().wsCUsidActzUlt().set(hv01501Pedmovhst().pedmovhst().cUsidActzUlt());
                bghl015a().tabela().lista().get(wsInd).item().set(wsVgh01501());
                bghl015a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C7
                 */
                hv01501Pedmovhst().fetchMghs015a1431() ;
                if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C7
             */
            hv01501Pedmovhst().closeMghs015a1449() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
         * call to extracted method to access (INSERT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().insertMghs015a1461() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.DUPLICATED) {
            progJaExiste.setTrue() ;
        }
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.DUPLICATED && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().deleteMghs015a1558(bghl015a().detalhe().tsPedido()) ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteInf.setTrue() ;
        }
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5700ConsultaPedido() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv01501Pedmovhst().openMghs015a1579() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv01501Pedmovhst().fetchMghs015a1591() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
                progExistePedido.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv01501Pedmovhst().closeMghs015a1608() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5800ConsultaConta() {
        /**
         * *----------------------------------------------------------------*
         */
        if (tapeGrande.isTrue()) {
            a5810ConsContaEsp() ;
        } else {
            a5820ConsContaNormal() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5810ConsContaEsp() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C8
         */
        hv01501Pedmovhst().openMghs015a1630(wsZaInicMov) ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C8
             */
            hv01501Pedmovhst().fetchMghs015a1642() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C8
             */
            hv01501Pedmovhst().closeMghs015a1659() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5820ConsContaNormal() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C5
         */
        hv01501Pedmovhst().openMghs015a1671(wsZaInicMov) ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C5
             */
            hv01501Pedmovhst().fetchMghs015a1683() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteInf.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C5
             */
            hv01501Pedmovhst().closeMghs015a1700() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * *GH805--> INICIO
     * 
     */
    public void a5900CnsltPedidoAct() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C9
         */
        hv01501Pedmovhst().openMghs015a1712() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C9
             */
            hv01501Pedmovhst().fetchMghs015a1724() ;
            if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
                progExistePedido.setTrue() ;
            }
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C9
             */
            hv01501Pedmovhst().closeMghs015a1741() ;
            if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * *GH805--> FIM
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl015a().cRetorno().set(progStatus);
        bghl015a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHh() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSs() ;
            
            @Data(size=6, lpadding=1, lpaddingValue=".")
            IInt wDd() ;
            
        }
    }
    
    public interface WTsPedidoMask extends IDataMask {
        
        @Data(size=4)
        IInt wAnoPedido() ;
        
        @Data(size=2)
        IInt wMesPedido() ;
        
        @Data(size=2)
        IInt wDiaPedido() ;
        
        @Data(size=2)
        IInt wHhPedido() ;
        
        @Data(size=2)
        IInt wMmPedido() ;
        
        @Data(size=2)
        IInt wSsPedido() ;
        
        @Data(size=1)
        IInt wDdPedido() ;
        
    }
    
    public interface WsVgh01501 extends IDataStruct {
        
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
        
        @Data(size=7)
        IString wsCPedInfOpps() ;
        
        @Data(size=10)
        IString wsZInicMov() ;
        
        @Data(size=10)
        IString wsZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsTsPedido() ;
        
        @Data(size=10)
        IString wsZPedido() ;
        
        @Data(size=1)
        IString wsCEstPedHist() ;
        
        @Data(size=1)
        IString wsCTipoRpte() ;
        
        @Data(size=20)
        IString wsNmFichOutpRtno() ;
        
        @Data(size=2)
        IString wsAAplDest() ;
        
        @Data(size=1)
        IString wsCFrmtInf() ;
        
        @Data(size=2)
        IString wsCCanlTrmzInf() ;
        
        @Data(size=15)
        IString wsCEndcFtpDest() ;
        
        @Data(size=10)
        IString wsZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt wsQDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMParmPedHstMin() ;
        
        @Data(size=15)
        IString wsCParmPedHstMax() ;
        
        @Data(size=15)
        IString wsCParmPedHstMin() ;
        
        @Data(size=40)
        IString wsXMtvoDvlzPed() ;
        
        @Data(size=10)
        IString wsZEliminacao() ;
        
        @Data(size=8)
        IString wsCUsidCrix() ;
        
        @Data(size=3)
        IString wsCPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString wsCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt wsQDdbtPed() ;
        
        @Data(size=26)
        IString wsTsActzUlt() ;
        
        @Data(size=8)
        IString wsCUsidActzUlt() ;
        
    }
}
