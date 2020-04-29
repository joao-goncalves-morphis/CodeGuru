package cgd.gh.batch;

import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.gh.structures.work.Bghw8701 ;
import cgd.ht.structures.work.Bhtw1013 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hy.common.constants.Bhyk0002 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc082a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fhy003
     */
    @Handler(name="FHY003")
    @Data
    protected abstract Fhy003 ficheiroFhy003() ;
    
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk700
     */
    @Handler(name="FWK700", record="rjd07001")
    @Data
    protected abstract Fwk700 fjd070() ;
    
    /**
     * @return instancia da classe Fwk70102
     */
    @Handler(name="FWK701", record="regFwk701113")
    @Data
    protected abstract Fwk70102 ficheiroFwk701() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bghw8701
     */
    @Data
    protected abstract Bghw8701 bghw8701() ;
    
    /**
     * @return instancia da classe Bhtw1013
     */
    @Data
    protected abstract Bhtw1013 bhtw1013() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    protected static final String CON_PROGRAMA = "PGHC082A" ;
    
    protected static final String CON_DESCRICAO = "CONV. MOVS DO FJD070 PARA SEQUENCIAIS            " ;
    
    protected static final String CON_FWK700 = "FWK700" ;
    
    protected static final String CON_FWK701 = "FWK701" ;
    
    /**
     * SWITCHES
     * @return instancia da classe local WsSwitch
     */
    @Data
    protected abstract WsSwitch wsSwitch() ;
    
    /**
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local WsFjd070XInfPends
     */
    @Data
    protected abstract WsFjd070XInfPends wsFjd070XInfPends() ;
    
    
    
    /**
     * 
     * ARQUITECTURA
     * PROCEDURE: BHTP0013.
     * -CONTEM CODIGO NECESSARIO PARA GESTAO DE INFORMACAO A
     * ESCREVER NO FICH. DE ESTAT. BATCH.
     * 
     */
    protected void bhtp0013InicioEstat() {
        bhtp0033AbreEstat() ;
        bhtw1013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhtw1013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxAno());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxMes());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zInicPrct().set(bhtw1013().dadosAuxiliares().dataAux2());
        bhtw0033().dadosGerais().nmPrograma().set(bhtw1013().dadosInput().nmPrograma());
        bhtw0033().dadosGerais().dFunlPrg().set(bhtw1013().dadosInput().dFunlPrg());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2H().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxH());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2M().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxM());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2S().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hInicPrct().set(bhtw1013().dadosAuxiliares().horaAux2());
        bhtw1013().dadosAuxiliares().qAces().set(1);
    }
    
    /**
     * 
     * BHTP0013-FORMATA-ACESSO
     * 
     */
    protected void bhtp0013FormataAcesso() {
        bhtw1013().dadosAuxiliares().tiAcesso().resetIndex() ;
        while (bhtw1013().dadosAuxiliares().tiAcesso().index().isLessOrEqual(99)) {
            if ((bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_FICHEIRO) && 
                bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro()) && 
                bhtw1013().dadosInput().dadosFicheiro().cTipoOpeFich().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich()) && 
                bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl())) || 
                (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_TABELA) && 
                bhtw1013().dadosInput().dadosTabela().nmTabela().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela()) && 
                bhtw1013().dadosInput().dadosTabela().cTipoOpeObjDb2().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2()) && 
                bhtw1013().dadosInput().dadosTabela().cSqlcode().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode())) || 
                (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_ROTINA) && 
                bhtw1013().dadosInput().dadosRotinas().nmRotina().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina()) && 
                bhtw1013().dadosInput().dadosRotinas().iOperacao().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao()) && 
                bhtw1013().dadosInput().dadosRotinas().cTipoErroBbn().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn()) && 
                bhtw1013().dadosInput().dadosRotinas().cRtnoEvenSwal().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal()) && 
                bhtw1013().dadosInput().dadosRotinas().aAplErr().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr()))) {
                bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().add(bhtw1013().dadosAuxiliares().qAces());
                break;
            }
            if (bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEmpty()) {
                bhtp0013CriaRegisto() ;
                break;
            }
            bhtw1013().dadosAuxiliares().tiAcesso().incIndex() ;
        }
    }
    
    /**
     * 
     * BHTP0013-CRIA-REGISTO
     * 
     */
    protected void bhtp0013CriaRegisto() {
        bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().initialize() ;
        bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().set(bhtw1013().dadosAuxiliares().qAces());
        if (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_FICHEIRO)) {
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().set(bhtw1013().dadosInput().tabFichRot());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhtw1013().dadosInput().xCteuAlig());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro().set(bhtw1013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich().set(bhtw1013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl().set(bhtw1013().dadosInput().dadosFicheiro().cFsttCobl());
        }
        if (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_TABELA)) {
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().set(bhtw1013().dadosInput().tabFichRot());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhtw1013().dadosInput().xCteuAlig());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela().set(bhtw1013().dadosInput().dadosTabela().nmTabela());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2().set(bhtw1013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode().set(bhtw1013().dadosInput().dadosTabela().cSqlcode());
        }
        if (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_ROTINA)) {
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().set(bhtw1013().dadosInput().tabFichRot());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhtw1013().dadosInput().xCteuAlig());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina().set(bhtw1013().dadosInput().dadosRotinas().nmRotina());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao().set(bhtw1013().dadosInput().dadosRotinas().iOperacao());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn().set(bhtw1013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal().set(bhtw1013().dadosInput().dadosRotinas().cRtnoEvenSwal());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr().set(bhtw1013().dadosInput().dadosRotinas().aAplErr());
        }
        if (!bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_TABELA) && 
            !bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_FICHEIRO) && 
            !bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_ROTINA)) {
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().get(1, 22).set("ESTAT. MAL FORMATADA : ") ;
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().get(24, 1).set(bhtw1013().dadosInput().tabFichRot()) ;
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhtw1013().dadosInput().xCteuAlig());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela().set(bhtw1013().dadosInput().dadosTabela().nmTabela());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro().set(bhtw1013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().set(1);
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2().set(bhtw1013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode().set(bhtw1013().dadosInput().dadosTabela().cSqlcode());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich().set(bhtw1013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl().set(bhtw1013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao().set(bhtw1013().dadosInput().dadosRotinas().iOperacao());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn().set(bhtw1013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal().set(bhtw1013().dadosInput().dadosRotinas().cRtnoEvenSwal());
            bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr().set(bhtw1013().dadosInput().dadosRotinas().aAplErr());
        }
    }
    
    /**
     * 
     * BHTP0013-FIM-ESTATISTICA
     * 
     */
    protected void bhtp0013FimEstatistica() {
        bhtw1013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhtw1013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxAno());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxMes());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zFimPrct().set(bhtw1013().dadosAuxiliares().dataAux2());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2H().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxH());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2M().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxM());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2S().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hFimPrct().set(bhtw1013().dadosAuxiliares().horaAux2());
        bhtp0033WriteEstatCab() ;
        bhtw1013().dadosAuxiliares().tiAcesso().resetIndex() ;
        while (!bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEmpty()) {
            bhtp0013DetalheEstat() ;
        }
        bhtp0033FechaEstat() ;
    }
    
    /**
     * 
     * BHTP0013-DETALHE-ESTAT
     * 
     */
    protected void bhtp0013DetalheEstat() {
        if (bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhtw1013().BHTW1013_CON_FICHEIRO)) {
            bhtw0033().dadosFicheiros().nmFicheiro().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro());
            bhtw0033().dadosFicheiros().cTipoOpeFich().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich());
            bhtw0033().dadosFicheiros().cFsttCobl().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl());
            bhtw0033().dadosFicheiros().qAcesFich().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosGerais().xCteuAlig().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtp0033WriteEstatF() ;
        }
        if (bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhtw1013().BHTW1013_CON_TABELA)) {
            bhtw0033().dadosDb2().nmTabela().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela());
            bhtw0033().dadosDb2().cTipoOpeObjDb2().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2());
            bhtw0033().dadosDb2().cSqlcode().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode());
            bhtw0033().dadosDb2().qAcesTab().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosGerais().xCteuAlig().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtp0033WriteEstat() ;
        }
        if (bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhtw1013().BHTW1013_CON_ROTINA)) {
            bhtw0033().dadosRotina().nmRtnaAces().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina());
            bhtw0033().dadosRotina().iOperacao().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn());
            bhtw0033().dadosRotina().cRtnoEvenSwal().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal());
            bhtw0033().dadosRotina().aAplErr().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr());
            bhtw0033().dadosRotina().qAcesRtna().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosGerais().xCteuAlig().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtp0033WriteEstatR() ;
        }
        if (!bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhtw1013().BHTW1013_CON_TABELA) && 
            !bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhtw1013().BHTW1013_CON_FICHEIRO) && 
            !bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhtw1013().BHTW1013_CON_ROTINA)) {
            bhtw0033().dadosGerais().xCteuAlig().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtw0033().dadosDb2().nmTabela().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela());
            bhtw0033().dadosFicheiros().qAcesFich().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosDb2().cTipoOpeObjDb2().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2());
            bhtw0033().dadosDb2().cSqlcode().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode());
            bhtw0033().dadosFicheiros().cTipoOpeFich().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich());
            bhtw0033().dadosFicheiros().cFsttCobl().set(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl());
        }
        bhtw1013().dadosAuxiliares().tiAcesso().incIndex() ;
    }
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "********** INICIO **********");
        log(TraceLevel.Debug, CON_PROGRAMA, " - ", CON_DESCRICAO);
        m1000InicioPrograma() ;
        while (!fjd070().getStatusOk()) {
            m2000ProcPrograma() ;
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100IniciaVars() ;
        bhtp0011ObtemDados() ;
        m1200TrataEstatIni() ;
        m1400OpenFicheiros() ;
        m1500ReadFwk700() ;
    }
    
    /**
     * 
     * 1100-INICIA-VARS
     * 
     */
    protected void m1100IniciaVars() {
        log(TraceLevel.Debug, "1100-INICIA-VARS");
        wsVariaveis().initialize() ;
        wsFjd070XInfPends().initialize() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhtw1013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtw1013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhtp0013InicioEstat() ;
    }
    
    /**
     * 
     * 1400-OPEN-FICHEIROS
     * 
     */
    protected void m1400OpenFicheiros() {
        log(TraceLevel.Debug, "1400-OPEN-FICHEIROS");
        fjd070().open() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK700);
        bhtw1013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(fjd070().getStatus());
        bhtp0013FormataAcesso() ;
        if (!fjd070().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK700);
            bhtw0030().dadosEntrada().cFsttCobl().set(fjd070().getStatus());
            m9100TrataErroFich() ;
        }
        ficheiroFwk701().open(CREATE ) ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK701);
        bhtw1013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk701().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFwk701().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK701);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk701().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1500-READ-FWK700
     * 
     */
    protected void m1500ReadFwk700() {
        log(TraceLevel.Debug, "1500-READ-FWK700");
        fjd070().read() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK700);
        bhtw1013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(fjd070().getStatus());
        bhtp0013FormataAcesso() ;
        if (!fjd070().getStatusOk() && !fjd070().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-READ-FWK700");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK700);
            bhtw0030().dadosEntrada().cFsttCobl().set(fjd070().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        wsFjd070XInfPends().set(fjd070().rjd07001().fjd070XInfPends());
        m2100TrataRegisto() ;
        m1500ReadFwk700() ;
    }
    
    /**
     * 
     * 2100-TRATA-REGISTO
     * 
     */
    protected void m2100TrataRegisto() {
        log(TraceLevel.Debug, "2100-TRATA-REGISTO");
        wsFjd070XInfPends().wsFjd070XInfPend().resetIndex() ;
        while (!wsFjd070XInfPends().wsFjd070XInfPend().getCurrent().tsPndeX().isEmpty() && wsFjd070XInfPends().wsFjd070XInfPend().index().isLessOrEqual(20)) {
            m2200TrataDescritivo() ;
            m2300WriteFwk701() ;
            wsFjd070XInfPends().wsFjd070XInfPend().incIndex() ;
        }
    }
    
    /**
     * 
     * 2200-TRATA-DESCRITIVO
     * 
     */
    protected void m2200TrataDescritivo() {
        log(TraceLevel.Debug, "2200-TRATA-DESCRITIVO");
        wsVariaveis().wsValidarLetras().set(wsFjd070XInfPends().wsFjd070XInfPend().getCurrent().dPnde());
        for (wsVariaveis().wsIChar().set(1); wsVariaveis().wsIChar().isLessOrEqual(12); wsVariaveis().wsIChar().add(1)) {
            if (!wsVariaveis().wsValidarLetras().letraValida().get(wsVariaveis().wsIChar()).isTrue()) {
                wsVariaveis().wsValidarLetras().letra().get(wsVariaveis().wsIChar()).set(" ");
            }
        }
        wsFjd070XInfPends().wsFjd070XInfPend().getCurrent().dPnde().set(wsVariaveis().wsValidarLetras());
    }
    
    /**
     * 
     * 2300-WRITE-FWK701
     * 
     */
    protected void m2300WriteFwk701() {
        log(TraceLevel.Debug, "2300-WRITE-FWK701");
        bghw8701().registo().conta().nConta().set(fjd070().rjd07001().fjd070Chave().fjd070NConta());
        bghw8701().registo().conta().cBanco().set(fjd070().rjd07001().fjd070Chave().fjd070CBanco());
        bghw8701().registo().conta().cMoedIso().set(fjd070().rjd07001().fjd070Chave().fjd070CMoedIso());
        bghw8701().registo().conta().nsDeposito().set(fjd070().rjd07001().fjd070Chave().fjd070NsDeposito());
        bghw8701().registo().xInfPend().set(wsFjd070XInfPends().wsFjd070XInfPend().getCurrent());
        ficheiroFwk701().setRecord(bghw8701().registo()) ;
        ficheiroFwk701().write(ficheiroFwk701().regFwk701113) ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK701);
        bhtw1013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk701().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFwk701().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-WRITE-FWK701");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK701);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk701().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, "3000-FIM-PROGRAMA");
        m3100FechaFicheiros() ;
        bhtp0013FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIROS
     * 
     */
    protected void m3100FechaFicheiros() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIROS");
        fjd070().close() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK700);
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(fjd070().getStatus());
        bhtp0013FormataAcesso() ;
        if (!fjd070().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK700);
            bhtw0030().dadosEntrada().cFsttCobl().set(fjd070().getStatus());
            m9100TrataErroFich() ;
        }
        ficheiroFwk701().close() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK701);
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk701().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFwk701().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK701);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk701().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 9100-TRATA-ERRO-FICH
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADAS AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-NM-FICHEIRO : NOME FICHEIRO
     * BHTW0030-C-FSTT-COBL: FILE STATUS
     * BHTW0030-X-SUG-RTNO-SWAL: DESCRICAO DO ERRO
     * 
     */
    protected void m9100TrataErroFich() {
        log(TraceLevel.Debug, "9100-TRATA-ERRO-FICH");
        bhtp0013FimEstatistica() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhtw0033().dadosGerais().zInicPrct());
        bhtw0030().dadosEntrada().zErro().set(bhtw0033().dadosGerais().zFimPrct());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhtw0033().dadosGerais().hInicPrct());
        bhtw0030().dadosEntrada().hErro().set(bhtw0033().dadosGerais().hFimPrct());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw1013().dadosInput().dadosFicheiro().cTipoOpeFich());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        fjd070().close() ;
        ficheiroFwk701().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhtw1013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhtw1013().dadosAuxiliares().horaAux2());
        bhtp0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhtw1013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhtw1013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        exit() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        m0000Mainline() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface WsSwitch extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk700() ;
        @Data
        @Condition("00")
        ICondition swFwk700Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk700Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk701() ;
        @Data
        @Condition("00")
        ICondition swFwk701Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk701Eof() ;
        
        
    }
    
    /**
     * 
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=2, signed=true, compression=COMP)
        IInt wsIChar() ;
        
        /**
         * @return instancia da classe local WsValidarLetras
         */
        @Data
        WsValidarLetras wsValidarLetras() ;
        
        
        public interface WsValidarLetras extends IDataStruct {
            
            @Data(length=12, size=1)
            IArray<IString> letra() ;
            @Data
            @Condition({ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" })
            IConditions letraValida() ;
            
            
        }
    }
    public interface WsFjd070XInfPends extends IDataStruct {
        
        /**
         * @return instancia da classe local WsFjd070XInfPend
         */
        @Data(length=20)
        IArray<WsFjd070XInfPend> wsFjd070XInfPend() ;
        
        
        public interface WsFjd070XInfPend extends IDataStruct {
            
            
            /**
             * @return instancia da classe local TsPndeX
             */
            @Data
            TsPndeX tsPndeX() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cCcmz() ;
            
            @Data(size=4)
            IString cTerminal() ;
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=3)
            IString cMoedIsoMov() ;
            
            @Data(size=12)
            IString dPnde() ;
            
            /**
             * @return instancia da classe local DTransaccao
             */
            @Data
            DTransaccao dTransaccao() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovCtrv() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloCtrv() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mPnde() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoDpnlApos() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nDocOppsMov() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong zValMov() ;
            
            
            public interface TsPndeX extends IDataStruct {
                
                @Data(size=14, signed=true, compression=COMP3)
                ILong tsPnde() ;
                
            }
            
            public interface DTransaccao extends IDataStruct {
                
                @Data(size=3, rpadding=3)
                IString dTransTip() ;
                
            }
        }
    }
    
}
