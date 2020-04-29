package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl600a ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.common.constants.Bghk0001 ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA  : MGHJ600A
 * APLICACAO : GH
 * PROCESSO  : GH1942
 * FUNCAO    : ROTINA PARA OBTER MOVIMENTO DE COBRANÇA NA CONTA DO*
 * TIPO       : ROTINA MISTA C/ DB2
 * OBSERVACOES:
 * AREA DE LIGACAO: BGHL600A
 * LOG DE ALTERACOES
 * PROCESSO SBM !   DATA   ! UTILIZADOR ! OBSERVACOES
 * GH1942        18-05-2016   E001879     CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * migrated from program [MGHJ600A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj600a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl600a
     */
    @Data
    public abstract Bghl600a bghl600a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH10201 = "VGH10201" ;
    
    protected static final String CON_MGHJ600A = "MGHJ600A" ;
    
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_GH = "GH" ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    
    
    /**
     * 
     * MAINLINE
     * 
     */
    public void m0000Mainline() {
        log(TraceLevel.Debug, "MGHJ600A-MAINLINE");
        m1000InicioPrograma() ;
        if (bghl600a().commarea().dadosErro().semErros().isTrue()) {
            m2000ProcPrograma() ;
        }
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    public void m1000InicioPrograma() {
        log(TraceLevel.Debug, "MGHJ600A-INICIO-PROGRAMA");
        bghl600a().commarea().camposSaida().initialize() ;
        bghl600a().commarea().dadosErro().initialize() ;
        m1100ValidaInput() ;
    }
    
    /**
     * 
     * 1100-VALIDA-INPUT
     * 
     */
    public void m1100ValidaInput() {
        log(TraceLevel.Debug, "MGHJ600A-VALIDA-INPUT");
        if (bghl600a().commarea().camposEntrada().cPaisIsoaCont().isEmpty() || 
            bghl600a().commarea().camposEntrada().cBancCont().isEqual(0) || 
            bghl600a().commarea().camposEntrada().cOeEgcCont().isEqual(0) || 
            bghl600a().commarea().camposEntrada().nsRdclCont().isEqual(0) || 
            !bghl600a().commarea().camposEntrada().vChkdCont().isNumeric() || 
            !bghl600a().commarea().camposEntrada().cTipoCont().isNumeric() || 
            bghl600a().commarea().camposEntrada().cMoedIsoScta().isEmpty() || 
            bghl600a().commarea().camposEntrada().zMovLocl().isEmpty() || 
            !bghl600a().commarea().camposEntrada().nJourBbn().isNumeric() || 
            !bghl600a().commarea().camposEntrada().nsJourBbn().isNumeric()) {
            bghl600a().commarea().dadosErro().erroFuncao().setTrue() ;
            bghl600a().commarea().dadosErro().aAplErr().set(CON_GH);
            bghl600a().commarea().dadosErro().cRtnoEvenSwal().set(bghk0001().erros().inputInvalido());
            bghl600a().commarea().dadosErro().msgErrob().set("ERRO NA VALICACAO DE INPUT");
            bghl600a().commarea().dadosErro().modOrigemErro().set(bghl600a().nomeRotina());
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    public void m2000ProcPrograma() {
        log(TraceLevel.Debug, "MGHJ600A-PROC-PROGRAMA");
        m2100SelectAb() ;
        if (bghl600a().commarea().dadosErro().semErros().isTrue()) {
            m2200FormataOutput() ;
        }
    }
    
    /**
     * 
     * 2100-SELECT-AB
     * 
     */
    public void m2100SelectAb() {
        log(TraceLevel.Debug, "MGHJ600A-SELECT-AB");
        hv00201Movhst().movhst().initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectMghj600a195(bghl600a().commarea().camposEntrada(), hv10201Movhstcpl().movhstcpl()) ;
        swStatus().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bghl600a().commarea().dadosErro().nmTabela().set(CON_VGH00201);
        if (!swStatus().swVgh00201Ok().isTrue()) {
            bghl600a().commarea().dadosErro().cSqlcode().set(swStatus().swSqlcodeVgh00201());
            bghl600a().commarea().dadosErro().aAplErr().set(CON_GH);
            bghl600a().commarea().dadosErro().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            bghl600a().commarea().dadosErro().msgErrob().set("ERRO NO SELECT DAS TABELAS");
            bghl600a().commarea().dadosErro().nmTabela().set(CON_VGH00201);
            bghl600a().commarea().dadosErro().modOrigemErro().set(bghl600a().nomeRotina());
            bghl600a().commarea().dadosErro().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
        }
    }
    
    /**
     * 
     * 2200-FORMATA-OUTPUT
     * 
     */
    public void m2200FormataOutput() {
        log(TraceLevel.Debug, "MGHJ600A-FORMATA-OUTPUT");
        bghl600a().commarea().camposSaida().zValMov().set(hv00201Movhst().movhst().zValMov());
        bghl600a().commarea().camposSaida().mMovimento().set(hv00201Movhst().movhst().mMovimento());
        bghl600a().commarea().camposSaida().mMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        bghl600a().commarea().camposSaida().tCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        m0000Mainline() ;
    }
    
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwStatus extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        
        
    }
}
