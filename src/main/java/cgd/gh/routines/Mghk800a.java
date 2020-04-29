package cgd.gh.routines;

import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.link.Bghl800a ;
import cgd.hj.structures.link.Bhjl011a ;
import cgd.hj.routines.Mhjj011a ;
import cgd.gh.routines.Mghj801a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.ho.routines.Mhok501a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * DESCRICAO     : OBTEM DESCRICAO DO MOVIMENTO
 * ALTERAÇÕES :
 * MOSL - RETIRAR O IDIOMA 'POR'. PASSA A BUSCAR O IDIOMA DO
 * CLIENTE
 * 
 * migrated from program [MGHK800A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghk800a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl800a
     */
    @Data
    public abstract Bghl800a bghl800a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhjj011a
     */
    @Data
    protected abstract Mhjj011a hrMhjj011a() ;
    
    /**
     * @return instancia da classe Mghj801a
     */
    @Data
    protected abstract Mghj801a hrMghj801a() ;
    
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Mhok501a
     */
    @Data
    protected abstract Mhok501a hrMhok501a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bhjl011a
     */
    @Data
    protected abstract Bhjl011a bhjl011a() ;
    
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
    @Condition("80")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    @Data
    @Condition("097")
    protected ICondition progNaoExisteConta ;
    
    
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
    
    
    @Data(size=21, value=" ")
    protected IString wsXRefMov ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString mghj801aCRotina ;
    
    @Data(size=8, value="MHGJ030A")
    protected IString wsRotTabGerais ;
    
    
    
    /**
     * 
     * ACEDE A IDIOMA DE BALCAO - EMPRESA - CLIENTE - CONTRATO
     * 
     */
    public void bhjp5011AcedeMhjj011a() {
        hrMhjj011a().run() ;
    }
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        log(TraceLevel.Debug, "--- MGHK800A S1000-INICIAR ---");
        progOk.setTrue() ;
        bghl800a().cRetorno().initialize() ;
        bghl800a().cSqlcode().initialize() ;
        if (bghl800a().input().cPaisIsoaCont().isEmpty() || 
            bghl800a().input().cBancCont().isEqual(0) || 
            bghl800a().input().cOeEgcCont().isEqual(0) || 
            bghl800a().input().nsRdclCont().isEqual(0) || 
            bghl800a().input().zValMov().isEmpty() || 
            bghl800a().input().cPaisIsoaOeOpx().isEmpty() || 
            bghl800a().input().cMnemEgcOpex().isEmpty() || 
            bghl800a().input().cOeEgcOpex().isEqual(0) || 
            bghl800a().input().cOpeBbn().isEmpty() || 
            bghl800a().input().iDbcr().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void s3000Processar() {
        log(TraceLevel.Debug, "--- MGHK800A S3000-PROCESSAR ---");
        a31000VerificaContaHo() ;
        if (progOk.isTrue()) {
            a35000ObtemIdioma() ;
        }
        if (progOk.isTrue()) {
            if (hrMghj801a().bghl801a().detalhe().iDcvoEsplS().isTrue()) {
                /**
                 * DISPLAY 'MGH801A-I-DCVO-ESPL-'
                 * MGH801A-I-DCVO-ESPL
                 */
                a32000AcedeMhgj030a() ;
                if (progOk.isTrue()) {
                    a33000CalDescEspecial() ;
                }
            } else {
                a34000ObtemDescStd() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a31000VerificaContaHo() {
        log(TraceLevel.Debug, "--- MGHK800A A31000-VERIFICA-CONTA-HO ---");
        hrMghj801a().bghl801a().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(bghl800a().input().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(bghl800a().input().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(bghl800a().input().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(bghl800a().input().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(bghl800a().input().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(bghl800a().input().cTipoCont());
        hrMghj801a().bghl801a().argumento().cMoedIsoScta().set(bghl800a().input().cMoedIsoScta());
        hrMghj801a().bghl801a().argumento().nsDeposito().set(bghl800a().input().nsDeposito());
        if (bghl800a().input().iEstorno().isEqual("E")) {
            if (bghl800a().input().iDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(bghl800a().input().iDbcr());
        }
        hrMghj801a().run() ;
        if (hrMghj801a().bghl801a().ok().isTrue()) {
            bghl800a().output().cTipoTrttCont().set(hrMghj801a().bghl801a().detalhe().cTipoTrttCont());
        } else {
            bghl800a().nmPrograma().set("MGHJ801A");
            if (hrMghj801a().bghl801a().naoExisteConta().isTrue()) {
                progNaoExisteConta.setTrue() ;
                bghl800a().cSqlcode().set(hrMghj801a().bghl801a().cSqlcode());
            } else {
                progStatus.set(hrMghj801a().bghl801a().cRetorno());
                bghl800a().cSqlcode().set(hrMghj801a().bghl801a().cSqlcode());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a32000AcedeMhgj030a() {
        log(TraceLevel.Debug, "--- MGHK800A A32000-ACEDE-MHGJ030A ---");
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().cTabBbn().set("625");
        hrMhgj030a().bhgl030a().commarea().dadosInput().cCodigo().set(hrMghj801a().bghl801a().detalhe().cDcvoEspl());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cIdioIso().set(bhjl011a().commarea().dadosSaida().cIdioIso());
        hrMhgj030a().bhgl030a().commarea().dadosInput().iAccaoTabBbn().set("V");
        hrMhgj030a().bhgl030a().commarea().dadosInput().iDadosObtr().set("C");
        hrMhgj030a().run() ;
        if (!hrMhgj030a().bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            bghl800a().cSqlcode().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cSqlcode());
            progStatus.set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cRtnoEvenSwal());
            bghl800a().nmPrograma().set("MHGJ030A");
        }
    }
    
    /**
     * 
     * 
     */
    public void a33000CalDescEspecial() {
        log(TraceLevel.Debug, "--- MGHK800A A33000-CAL-DESC-ESPECIAL ---");
        hrMhok501a().bhol500a().commarea().initialize() ;
        hrMhok501a().bhol500a().commarea().dadosInput().zValor().set(bghl800a().input().zValMov());
        hrMhok501a().bhol500a().commarea().dadosInput().xRefMov().set(" ");
        hrMhok501a().bhol500a().commarea().dadosInput().iDbcr().set(bghl800a().input().iDbcr());
        hrMhok501a().bhol500a().commarea().dadosInput().cOeEgc().set(bghl800a().input().cOeEgcOpex());
        hrMhok501a().bhol500a().cRotina().set(hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo01());
        /**
         * DISPLAY 'BHGL030A-X-CTEU-CO01-'
         * BHGL030A-X-CTEU-CO01
         */
        hrMhok501a().run() ;
        if (hrMhok501a().bhol500a().commarea().dadosErro().semErros().isTrue()) {
            bghl800a().output().xRefMov().set(hrMhok501a().bhol500a().commarea().dadosOutput().dMovimento());
        } else {
            bghl800a().cSqlcode().set(hrMhok501a().bhol500a().commarea().dadosErro().cSqlcode());
            progStatus.set(hrMhok501a().bhol500a().commarea().dadosErro().cRtnoEvenSwal());
            bghl800a().nmPrograma().set("MHOK501A");
        }
    }
    
    /**
     * 
     * 
     */
    public void a34000ObtemDescStd() {
        log(TraceLevel.Debug, "--- MGHK800A A34000-OBTEM-DESC-STD ---");
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().cTabBbn().set("764");
        hrMhgj030a().bhgl030a().commarea().dadosInput().cCodigo().set(bghl800a().input().cOpeBbn());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cIdioIso().set(bhjl011a().commarea().dadosSaida().cIdioIso());
        hrMhgj030a().run() ;
        if (hrMhgj030a().bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            bghl800a().output().xRefMov().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().dCodLong().get(1, 21));
        } else {
            bghl800a().cSqlcode().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cSqlcode());
            progStatus.set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cRtnoEvenSwal());
            bghl800a().nmPrograma().set("MHGJ030A");
        }
    }
    
    /**
     * 
     * 
     */
    public void a35000ObtemIdioma() {
        log(TraceLevel.Debug, "--- MGHK800A A35000-OBTEM-IDIOMA ---");
        bhjl011a().commarea().initialize() ;
        bhjl011a().commarea().dadosEntrada().cPaisIsoAlfn().set(bghl800a().input().cPaisIsoaOeOpx());
        bhjl011a().commarea().dadosEntrada().cMnemEmpGcx().set(bghl800a().input().cMnemEgcOpex());
        bhjl011a().commarea().dadosEntrada().cOeEgc().set(bghl800a().input().cOeEgcOpex());
        bhjp5011AcedeMhjj011a() ;
        if (!bhjl011a().commarea().erros().semErros().isTrue()) {
            bghl800a().nmPrograma().set("MHJJ011A");
            progStatus.set(bhjl011a().commarea().erros().cRtnoEvenSwal());
            bghl800a().cSqlcode().set(bhjl011a().commarea().erros().cSqlcode());
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        log(TraceLevel.Debug, "*** INICIO DO PROGRAMA MGHK800A ***");
        s1000Iniciar() ;
        if (progOk.isTrue()) {
            s3000Processar() ;
        }
        bghl800a().cRetorno().set(progStatus);
        exit() ;
    }
}
