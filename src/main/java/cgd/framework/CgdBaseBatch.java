package cgd.framework;

import cgd.gh.persistence.files.* ;
import cgd.ho.structures.work.Bhow0013 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.routines.Mhtq111a ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtr0112 ;
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.work.Bhtw0007 ;
import cgd.ht.structures.work.Bhtw0011 ;
import cgd.ht.structures.work.Bhtw0015 ;
import cgd.ht.structures.work.Bhtw0030 ;
import cgd.ht.structures.work.Bhtw0033 ;
import cgd.hy.structures.work.Bhyr0031 ;
import morphis.framework.batch.BaseBatch ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.reflection.DataFactory ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * migrated from copybook [BHTP0030]
 * 
 * @version 2.0
 * 
 */
public abstract class CgdBaseBatch extends BaseBatch {
    
    
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    
    
    /**
     * @return instancia da classe Bhow0013
     */
    @Data
    protected abstract Bhow0013 bhow0013() ;
    
    /**
     * @return instancia da classe Bhtk0001
     */
    @Data
    protected abstract Bhtk0001 bhtk0001() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtr0112
     */
    @Data
    protected abstract Bhtr0112 bhtr0112() ;
    
    /**
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
    /**
     * @return instancia da classe Bhtw0007
     */
    @Data
    protected abstract Bhtw0007 bhtw0007() ;
    
    /**
     * @return instancia da classe Bhtw0011
     */
    @Data
    protected abstract Bhtw0011 bhtw0011() ;
    
    /**
     * @return instancia da classe Bhtw0015
     */
    @Data
    protected abstract Bhtw0015 bhtw0015() ;
    /**
     * @return instancia da classe Bhtw0030
     */
    @Data
    protected abstract Bhtw0030 bhtw0030() ;
    
    /**
     * @return instancia da classe Bhtw0033
     */
    @Data
    protected abstract Bhtw0033 bhtw0033() ;
    
    /**
     * @return instancia da classe Bhyr0031
     */
    @Data
    protected abstract Bhyr0031 bhyr0031() ;
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011", record="regFht01137")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    @Data
    protected abstract Mhtq111a getMhtq111a() ;
    /**
     * Copybooks
     */
    
    /**
     * 
     * BHOP0013-CRIA-REGISTO
     * 
     */
    protected void bhop0013CriaRegisto() {
        bhow0013().dadosAuxiliares().tiAcesso().getCurrent().initialize() ;
        bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().set(bhow0013().dadosAuxiliares().qAces());
        if (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_FICHEIRO)) {
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().set(bhow0013().dadosInput().tabFichRot());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhow0013().dadosInput().xCteuAlig());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
        }
        if (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_TABELA)) {
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().set(bhow0013().dadosInput().tabFichRot());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhow0013().dadosInput().xCteuAlig());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
        }
        if (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_ROTINA)) {
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().set(bhow0013().dadosInput().tabFichRot());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhow0013().dadosInput().xCteuAlig());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina().set(bhow0013().dadosInput().dadosRotinas().nmRotina());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao().set(bhow0013().dadosInput().dadosRotinas().iOperacao());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal().set(bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr().set(bhow0013().dadosInput().dadosRotinas().aAplErr());
        }
        if (!bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_TABELA) && 
            !bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_FICHEIRO) && 
            !bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_ROTINA)) {
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().get(1, 22).set("ESTAT. MAL FORMATADA : ") ;
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().get(24, 1).set(bhow0013().dadosInput().tabFichRot()) ;
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig().set(bhow0013().dadosInput().xCteuAlig());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().set(1);
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao().set(bhow0013().dadosInput().dadosRotinas().iOperacao());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal().set(bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal());
            bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr().set(bhow0013().dadosInput().dadosRotinas().aAplErr());
        }
    }
    
    /**
     * 
     * BHOP0013-DETALHE-ESTAT
     * 
     */
    protected void bhop0013DetalheEstat() {
        if (bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhow0013().BHOW0013_CON_FICHEIRO)) {
            bhtw0033().dadosFicheiros().nmFicheiro().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro());
            bhtw0033().dadosFicheiros().cTipoOpeFich().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich());
            bhtw0033().dadosFicheiros().cFsttCobl().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl());
            bhtw0033().dadosFicheiros().qAcesFich().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosGerais().xCteuAlig().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtp0033WriteEstatF() ;
        }
        if (bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhow0013().BHOW0013_CON_TABELA)) {
            bhtw0033().dadosDb2().nmTabela().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela());
            bhtw0033().dadosDb2().cTipoOpeObjDb2().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2());
            bhtw0033().dadosDb2().cSqlcode().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode());
            bhtw0033().dadosDb2().qAcesTab().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosGerais().xCteuAlig().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtp0033WriteEstat() ;
        }
        if (bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhow0013().BHOW0013_CON_ROTINA)) {
            bhtw0033().dadosRotina().nmRtnaAces().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina());
            bhtw0033().dadosRotina().iOperacao().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn());
            bhtw0033().dadosRotina().cRtnoEvenSwal().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal());
            bhtw0033().dadosRotina().aAplErr().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr());
            bhtw0033().dadosRotina().qAcesRtna().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosGerais().xCteuAlig().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtp0033WriteEstatR() ;
        }
        if (!bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhow0013().BHOW0013_CON_TABELA) && 
            !bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhow0013().BHOW0013_CON_FICHEIRO) && 
            !bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEqual(bhow0013().BHOW0013_CON_ROTINA)) {
            bhtw0033().dadosGerais().xCteuAlig().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiXCteuAlig());
            bhtw0033().dadosDb2().nmTabela().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela());
            bhtw0033().dadosFicheiros().qAcesFich().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces());
            bhtw0033().dadosDb2().cTipoOpeObjDb2().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2());
            bhtw0033().dadosDb2().cSqlcode().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode());
            bhtw0033().dadosFicheiros().cTipoOpeFich().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich());
            bhtw0033().dadosFicheiros().cFsttCobl().set(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl());
        }
        bhow0013().dadosAuxiliares().tiAcesso().incIndex() ;
    }
    
    /**
     * 
     * BHOP0013-FIM-ESTATISTICA
     * 
     */
    protected void bhop0013FimEstatistica() {
        bhow0013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhow0013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhow0013().dadosAuxiliares().dataAux().dataAuxAno());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhow0013().dadosAuxiliares().dataAux().dataAuxMes());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhow0013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zFimPrct().set(bhow0013().dadosAuxiliares().dataAux2());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2H().set(bhow0013().dadosAuxiliares().horaAux().horaAuxH());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2M().set(bhow0013().dadosAuxiliares().horaAux().horaAuxM());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2S().set(bhow0013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hFimPrct().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0033WriteEstatCab() ;
        bhow0013().dadosAuxiliares().tiAcesso().resetIndex() ;
        while (!bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEmpty()) {
            bhop0013DetalheEstat() ;
        }
        bhtp0033FechaEstat() ;
    }
    
    /**
     * 
     * BHOP0013-FORMATA-ACESSO
     * 
     */
    protected void bhop0013FormataAcesso() {
        bhow0013().dadosAuxiliares().tiAcesso().resetIndex() ;
        while (bhow0013().dadosAuxiliares().tiAcesso().index().isLessOrEqual(99)) {
            if ((bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_FICHEIRO) && 
                bhow0013().dadosInput().dadosFicheiro().nmFicheiro().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro()) && 
                bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich()) && 
                bhow0013().dadosInput().dadosFicheiro().cFsttCobl().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl())) || 
                (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_TABELA) && 
                bhow0013().dadosInput().dadosTabela().nmTabela().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela()) && 
                bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2()) && 
                bhow0013().dadosInput().dadosTabela().cSqlcode().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode())) || 
                (bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhow0013().dadosInput().tabFichRot().isEqual(bhow0013().BHOW0013_CON_ROTINA) && 
                bhow0013().dadosInput().dadosRotinas().nmRotina().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina()) && 
                bhow0013().dadosInput().dadosRotinas().iOperacao().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao()) && 
                bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn()) && 
                bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal()) && 
                bhow0013().dadosInput().dadosRotinas().aAplErr().isEqual(bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr()))) {
                bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().add(bhow0013().dadosAuxiliares().qAces());
                break;
            }
            if (bhow0013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEmpty()) {
                bhop0013CriaRegisto() ;
                break;
            }
            bhow0013().dadosAuxiliares().tiAcesso().incIndex() ;
        }
    }
    
    /**
     * 
     * CONTAS
     * PROCEDURE: BHOP0013.
     * -CONTEM CODIGO NECESSARIO PARA GESTAO DE INFORMACAO A
     * ESCREVER NO FICH. DE ESTAT. BATCH.
     * 
     */
    protected void bhop0013InicioEstat() {
        bhtp0033AbreEstat() ;
        bhow0013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhow0013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhow0013().dadosAuxiliares().dataAux().dataAuxAno());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhow0013().dadosAuxiliares().dataAux().dataAuxMes());
        bhow0013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhow0013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zInicPrct().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0033().dadosGerais().nmPrograma().set(bhow0013().dadosInput().nmPrograma());
        bhtw0033().dadosGerais().dFunlPrg().set(bhow0013().dadosInput().dFunlPrg());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2H().set(bhow0013().dadosAuxiliares().horaAux().horaAuxH());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2M().set(bhow0013().dadosAuxiliares().horaAux().horaAuxM());
        bhow0013().dadosAuxiliares().horaAux2().horaAux2S().set(bhow0013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hInicPrct().set(bhow0013().dadosAuxiliares().horaAux2());
        bhow0013().dadosAuxiliares().qAces().set(1);
    }
    
    /**
     * 
     * BHTP0011-ABEND
     * 
     */
    protected void bhtp0011Abend() {
        log(TraceLevel.Trace, "VAI AH ROTINA MHTQ111A FAZER ROLLBACK");
        getMhtq111a().run() ;
        bhtw0011().erro().setTrue() ;
        setReturnCode(bhtw0011().returnCode()) ;
        exit() ;
    }
    
    /**
     * 
     * ABRE FICHEIRO
     * 
     */
    protected void bhtp0011AbreFicheiro() {
        ficheiroFht011().open() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set("OB");
            bhtp0011Comum() ;
            bhtp0030DisplayErro() ;
            bhtp0011Abend() ;
        }
    }
    
    /**
     * 
     * AREA COMUM
     * 
     */
    protected void bhtp0011Comum() {
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhtw0030().dadosEntrada().nmFicheiro().set("FHT011");
        bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
    }
    
    /**
     * 
     * FECHA FICHEIRO
     * 
     */
    protected void bhtp0011FechaFicheiro() {
        ficheiroFht011().close() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set("CL");
            bhtp0011Comum() ;
            bhtp0030DisplayErro() ;
            bhtp0011Abend() ;
        }
    }
    
    /**
     * 
     * BHTP0011
     * DADOS DEFAULT PARA PROCESSAMENTO BATCH
     * 
     */
    protected void bhtp0011ObtemDados() {
        bhtp0011AbreFicheiro() ;
        if (bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            ficheiroFht011().read() ;
            if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
                bhtw0030().dadosEntrada().cTipoOpeObjDb2().set("RR");
                bhtp0011Comum() ;
                bhtp0030DisplayErro() ;
                bhtp0011Abend() ;
            }
            if (bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
                bhtr0111().fht011Registo().set((String)ficheiroFht011().getRecord()) ;
                bhtw0011().commarea().dadosSaida().cPaisIsoAlfn().set(bhtr0111().fht011Registo().fht011CPaisIsoAlfn());
                bhtw0011().commarea().dadosSaida().cIdioIso().set(bhtr0111().fht011Registo().fht011CIdioIso());
                bhtw0011().commarea().dadosSaida().cMnemEgcRefFerLx().set(bhtw0011().areaDados().CON_C_MNEM_EGC_REF_FER_LX);
                bhtw0011().commarea().dadosSaida().cPaisOeRefFerLx().set(bhtw0011().areaDados().CON_C_PAIS_OE_REF_FER_LX);
                bhtw0011().commarea().dadosSaida().cOeEgcRefFerLx().set(bhtw0011().areaDados().CON_C_OE_EGC_REF_FER_LX);
                bhtw0011().commarea().dadosSaida().cMnemEmpCpd().set(bhtw0011().areaDados().CON_C_MNEM_EMP_CPD);
                bhtw0011().commarea().dadosSaida().cPaisIsoaCpd().set(bhtw0011().areaDados().CON_C_PAIS_ISOA_CPD);
                bhtw0011().commarea().dadosSaida().cOeCpd().set(bhtw0011().areaDados().CON_C_OE_CPD);
                bhtw0011().commarea().dadosSaida().cMnemEmpGcx().set(bhtw0011().areaDados().CON_C_MNEM_EMP_GCX);
                bhtw0011().commarea().dadosSaida().cBanco().set(bhtw0011().areaDados().CON_C_BANCO);
                bhtw0011().commarea().dadosSaida().cTipoCanlAces().set(bhtw0011().areaDados().CON_C_TIPO_CANL_ACES);
            }
        }
        bhtp0011FechaFicheiro() ;
    }
    
    /**
     * 
     * COPY DE FORMATACAO E OBTENCAO DE DATAS DE SISTEMA.
     * OBTEM A DATA DE SISTEMA COM SECULO E DISPONIBILIZA-A COM E SEM
     * FORMATACAO.
     * INSTRUCOES DE UTILIZACAO.
     * PERFORM BHTP0015-CURRENT-DATE
     * THRU BHTP0015-CURRENT-DATE-EXIT.
     * FINALMENTE, MOVER AS VARIAVEIS DE OUTPUT PARA A AREA QUE SE
     * PRETENDE. POR EXEMPLO A WS-DATA-INI.
     * MOVE BHTW0015-DATE-FRM         TO WS-DATA-INI.
     * (FORMATO DATE YYYY-MM-DD)
     * MOVE BHTW0015-TIME-FRM         TO WS-HORA-INI.
     * (FORMATO TIME HH:MM:SS)
     * OU
     * MOVE BHTW0015-TMST-FRM         TO WS-CURRENT-TIMESTAMP.
     * (FORMATO TIMESTAMP 26 YYYY-MM-DD-HH.MM.SS.SSSSSS)
     * 
     */
    protected void bhtp0015CurrentDate() {
        bhtw0015().area().current().set(getTimeAsLong());
        bhtw0015().area().currentFrm().dateFrm().dateYearFrm().set(bhtw0015().area().current().currentDate().dateYear());
        bhtw0015().area().currentFrm().tmstFrm().tmstYearFrm().set(bhtw0015().area().current().currentDate().dateYear());
        bhtw0015().area().currentFrm().dateFrm().dateMonthFrm().set(bhtw0015().area().current().currentDate().dateMonth());
        bhtw0015().area().currentFrm().tmstFrm().tmstMonthFrm().set(bhtw0015().area().current().currentDate().dateMonth());
        bhtw0015().area().currentFrm().dateFrm().dateDayFrm().set(bhtw0015().area().current().currentDate().dateDay());
        bhtw0015().area().currentFrm().tmstFrm().tmstDayFrm().set(bhtw0015().area().current().currentDate().dateDay());
        bhtw0015().area().currentFrm().timeFrm().timeHhFrm().set(bhtw0015().area().current().currentTime().timeHour());
        bhtw0015().area().currentFrm().tmstFrm().tmstHhFrm().set(bhtw0015().area().current().currentTime().timeHour());
        bhtw0015().area().currentFrm().timeFrm().timeMmFrm().set(bhtw0015().area().current().currentTime().timeMin());
        bhtw0015().area().currentFrm().tmstFrm().tmstMmFrm().set(bhtw0015().area().current().currentTime().timeMin());
        bhtw0015().area().currentFrm().timeFrm().timeSsFrm().set(bhtw0015().area().current().currentTime().timeSec());
        bhtw0015().area().currentFrm().tmstFrm().tmstSsFrm().set(bhtw0015().area().current().currentTime().timeSec());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs1Frm().set(bhtw0015().area().current().currentTmst().tmstSs1());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs2Frm().set(bhtw0015().area().current().currentTmst().tmstSs2());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs3Frm().set(bhtw0015().area().current().currentTmst().tmstSs3());
    }
    
    /**
     * 
     * 
     */
    protected void bhtp0030DisplayErro() {
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "*       INFORMACAO SOBRE O ERRO OCORRIDO       *");
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "NOME PROGRAMA:", bhtw0030().dadosEntrada().nmPrograma());
        log(TraceLevel.Trace, "NOME PROGRAMA:", bhtw0030().dadosEntrada().nmPrograma());
        log(TraceLevel.Trace, "DATA INICIO:", bhtw0030().dadosEntrada().zInicExePrg());
        log(TraceLevel.Trace, "DATA FIM:", bhtw0030().dadosEntrada().zErro());
        log(TraceLevel.Trace, "HORA INICIO:", bhtw0030().dadosEntrada().hInicExePrg());
        log(TraceLevel.Trace, "HORA FIM:", bhtw0030().dadosEntrada().hErro());
        log(TraceLevel.Trace, "OBSERVACOES:", bhtw0030().dadosEntrada().xSugRtnoSwal());
        log(TraceLevel.Trace, "TIPO ERRO:", bhtw0030().dadosEntrada().cTipoErroBbn());
        if (bhtw0030().dadosEntrada().abendDb2().isTrue()) {
            log(TraceLevel.Trace, "SQLCODE:", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Trace, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Trace, "NOME TABELA:", bhtw0030().dadosEntrada().nmTabela());
            log(TraceLevel.Trace, "ACESSO TABELA:", bhtw0030().dadosEntrada().xCteuChavTab());
        } else if (bhtw0030().dadosEntrada().abend().isTrue()) {
            log(TraceLevel.Trace, "NOME ROTINA:", bhtw0030().dadosEntrada().nmPrgChmd());
            log(TraceLevel.Trace, "CODIGO RETORNO ROTINA:", bhtw0030().dadosEntrada().cTipoErrPrgChmd());
            log(TraceLevel.Trace, "AREA INPUT ROTINA:", bhtw0030().dadosEntrada().xCteuAlig());
            log(TraceLevel.Trace, "SQLCODE:", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Trace, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Trace, "NOME TABELA:", bhtw0030().dadosEntrada().nmTabela());
            log(TraceLevel.Trace, "ACESSO TABELA:", bhtw0030().dadosEntrada().xCteuChavTab());
        } else if (bhtw0030().dadosEntrada().abendFicheiro().isTrue()) {
            log(TraceLevel.Trace, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Trace, "NOME FICHEIRO:", bhtw0030().dadosEntrada().nmFicheiro());
            log(TraceLevel.Trace, "FILE STATUS:", bhtw0030().dadosEntrada().cFsttCobl());
        } else if (bhtw0030().dadosEntrada().cFsttCobl().isNumeric()) {
            log(TraceLevel.Error, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Error, "NOME FICHEIRO:", bhtw0030().dadosEntrada().nmFicheiro());
            log(TraceLevel.Error, "FILE STATUS:", bhtw0030().dadosEntrada().cFsttCobl());
        } else {
            log(TraceLevel.Error, "NOME ROTINA:", bhtw0030().dadosEntrada().nmPrgChmd());
            log(TraceLevel.Error, "CODIGO RETORNO ROTINA:", bhtw0030().dadosEntrada().cTipoErrPrgChmd());
            log(TraceLevel.Error, "AREA INPUT ROTINA:", bhtw0030().dadosEntrada().xCteuAlig());
            log(TraceLevel.Error, "SQLCODE:", bhtw0030().dadosEntrada().cSqlcode());
            log(TraceLevel.Error, "ACCAO:", bhtw0030().dadosEntrada().cTipoOpeObjDb2());
            log(TraceLevel.Error, "NOME TABELA:", bhtw0030().dadosEntrada().nmTabela());
            log(TraceLevel.Error, "ACESSO TABELA:", bhtw0030().dadosEntrada().xCteuChavTab());
        }
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "*    FIM DA INFORMACAO SOBRE O ERRO OCORRIDO   *");
        log(TraceLevel.Trace, "************************************************");
    }
    
    /**
     * 
     * BHTP0033 - ESCRITA DE ESTATISTICAS
     * ABRE FICHEIRO DE ESTATISTICA
     * 
     */
    protected void bhtp0033AbreEstat() {
    }
    
    /**
     * 
     * FECHA FICHEIRO DE ESTATISTICA
     * 
     */
    protected void bhtp0033FechaEstat() {
    }
    
    /**
     * 
     * ESCREVE FICHEIRO DE ESTATISTICA - DB2
     * 
     */
    protected void bhtp0033WriteEstat() {
        bhyr0031().fhy003Area().initialize() ;
        bhyr0031().fhy003AreaDb2().fhy003NmTabela().set(bhtw0033().dadosDb2().nmTabela());
        bhyr0031().fhy003AreaDb2().fhy003CSqlcode().set(bhtw0033().dadosDb2().cSqlcode());
        bhyr0031().fhy003AreaDb2().fhy003CTipoOpeObjDb2().set(bhtw0033().dadosDb2().cTipoOpeObjDb2());
        bhyr0031().fhy003AreaDb2().fhy003QAcesTab().set(bhtw0033().dadosDb2().qAcesTab());
        bhyr0031().fhy003AreaCabc().fhy003ZFimPrct().set(bhtw0033().dadosGerais().zFimPrct());
        bhyr0031().fhy003AreaCabc().fhy003HFimPrct().set(bhtw0033().dadosGerais().hFimPrct());
        /**
         * WRITE REG-FHY003            FROM FHY003-AREA.
         * IF NOT SW-FHY003-OK
         * MOVE 'WR'                TO BHTW0030-C-TIPO-OPE-OBJ-DB2
         * PERFORM BHTP0033-COMUM
         * THRU BHTP0033-COMUM-EXIT
         * PERFORM BHTP0030-DISPLAY-ERRO
         * THRU BHTP0030-DISPLAY-ERRO-EXIT
         * ELSE
         * INITIALIZE FHY003-AREA REPLACING ALPHANUMERIC BY SPACES
         * NUMERIC BY ZEROS
         * END-IF.
         */
        log(TraceLevel.Trace, "******************ACESSOS DB2*******************");
        log(TraceLevel.Trace, "TABELA: ", bhyr0031().fhy003AreaDb2().fhy003NmTabela());
        log(TraceLevel.Trace, "SQLCODE: ", bhtw0033().dadosDb2().cSqlcode());
        log(TraceLevel.Trace, "TIPO DE ACESSO: ", bhyr0031().fhy003AreaDb2().fhy003CTipoOpeObjDb2());
        log(TraceLevel.Trace, "QUANTIDADE DE ACESSOS: ", bhyr0031().fhy003AreaDb2().fhy003QAcesTab());
        log(TraceLevel.Trace, "DATA FIM DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003ZFimPrct());
        log(TraceLevel.Trace, "HORA FIM DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003HFimPrct());
    }
    
    /**
     * 
     * ESCREVE CABECALHO DO FICHEIRO DE ESTATISTICA
     * 
     */
    protected void bhtp0033WriteEstatCab() {
        bhyr0031().fhy003Area().initialize() ;
        bhyr0031().fhy003AreaCabc().fhy003NmPrograma().set(bhtw0033().dadosGerais().nmPrograma());
        bhyr0031().fhy003AreaCabc().fhy003DFunlPrg().set(bhtw0033().dadosGerais().dFunlPrg());
        bhyr0031().fhy003AreaCabc().fhy003ZInicPrct().set(bhtw0033().dadosGerais().zInicPrct());
        bhyr0031().fhy003AreaCabc().fhy003HInicPrct().set(bhtw0033().dadosGerais().hInicPrct());
        bhyr0031().fhy003AreaCabc().fhy003ZFimPrct().set(bhtw0033().dadosGerais().zFimPrct());
        bhyr0031().fhy003AreaCabc().fhy003HFimPrct().set(bhtw0033().dadosGerais().hFimPrct());
        /**
         * WRITE REG-FHY003            FROM FHY003-AREA.
         * IF NOT SW-FHY003-OK
         * MOVE 'WR'                TO BHTW0030-C-TIPO-OPE-OBJ-DB2
         * PERFORM BHTP0033-COMUM
         * THRU BHTP0033-COMUM-EXIT
         * PERFORM BHTP0030-DISPLAY-ERRO
         * THRU BHTP0030-DISPLAY-ERRO-EXIT
         * ELSE
         * INITIALIZE FHY003-AREA REPLACING ALPHANUMERIC BY SPACES
         * NUMERIC BY ZEROS
         * END-IF.
         */
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "*     ESTATISTICAS DE PROCESSAMENTO BATCH      *");
        log(TraceLevel.Trace, "************************************************");
        log(TraceLevel.Trace, "NOME DO PROGRAMA: ", bhyr0031().fhy003AreaCabc().fhy003NmPrograma());
        log(TraceLevel.Trace, "DESCRICAO DA FUNCAO DO PROGRAMA:                ");
        log(TraceLevel.Trace, bhyr0031().fhy003AreaCabc().fhy003DFunlPrg());
        log(TraceLevel.Trace, "DATA INICIO DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003ZInicPrct());
        log(TraceLevel.Trace, "HORA INICIO DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003HInicPrct());
    }
    
    /**
     * 
     * ESCREVE FICHEIRO DE ESTATISTICA - FICHEIRO
     * 
     */
    protected void bhtp0033WriteEstatF() {
        bhyr0031().fhy003Area().initialize() ;
        bhyr0031().fhy003AreaFich().fhy003NmFicheiro().set(bhtw0033().dadosFicheiros().nmFicheiro());
        bhyr0031().fhy003AreaFich().fhy003CTipoOpeFich().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
        bhyr0031().fhy003AreaFich().fhy003CFsttCobl().set(bhtw0033().dadosFicheiros().cFsttCobl());
        bhyr0031().fhy003AreaFich().fhy003QAcesFich().set(bhtw0033().dadosFicheiros().qAcesFich());
        bhyr0031().fhy003AreaCabc().fhy003ZFimPrct().set(bhtw0033().dadosGerais().zFimPrct());
        bhyr0031().fhy003AreaCabc().fhy003HFimPrct().set(bhtw0033().dadosGerais().hFimPrct());
        /**
         * WRITE REG-FHY003            FROM FHY003-AREA.
         * IF NOT SW-FHY003-OK
         * MOVE 'WR'                TO BHTW0030-C-TIPO-OPE-OBJ-DB2
         * PERFORM BHTP0033-COMUM
         * THRU BHTP0033-COMUM-EXIT
         * PERFORM BHTP0030-DISPLAY-ERRO
         * THRU BHTP0030-DISPLAY-ERRO-EXIT
         * ELSE
         * INITIALIZE FHY003-AREA REPLACING ALPHANUMERIC BY SPACES
         * NUMERIC BY ZEROS
         * END-IF.
         */
        log(TraceLevel.Trace, "*************ACESSOS A FICHEIROS****************");
        log(TraceLevel.Trace, "FICHEIRO: ", bhyr0031().fhy003AreaFich().fhy003NmFicheiro());
        log(TraceLevel.Trace, "TIPO DE OPERACAO: ", bhyr0031().fhy003AreaFich().fhy003CTipoOpeFich());
        log(TraceLevel.Trace, "FILE STATUS: ", bhyr0031().fhy003AreaFich().fhy003CFsttCobl());
        log(TraceLevel.Trace, "QUANTIDADE DE ACESSOS: ", bhyr0031().fhy003AreaFich().fhy003QAcesFich());
        log(TraceLevel.Trace, "DATA FIM DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003ZFimPrct());
        log(TraceLevel.Trace, "HORA FIM DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003HFimPrct());
    }
    
    /**
     * 
     * ESCREVE FICHEIRO DE ESTATISTICA - ERRO FUNCIONAL
     * 
     */
    protected void bhtp0033WriteEstatFunc() {
        bhyr0031().fhy003Area().initialize() ;
        bhyr0031().fhy003Area().set(bhtw0033().dadosFuncionais());
        /**
         * WRITE REG-FHY003            FROM FHY003-AREA.
         * IF NOT SW-FHY003-OK
         * MOVE 'WR'                TO BHTW0030-C-TIPO-OPE-OBJ-DB2
         * PERFORM BHTP0033-COMUM
         * THRU BHTP0033-COMUM-EXIT
         * PERFORM BHTP0030-DISPLAY-ERRO
         * THRU BHTP0030-DISPLAY-ERRO-EXIT
         * ELSE
         * INITIALIZE FHY003-AREA REPLACING ALPHANUMERIC BY SPACES
         * NUMERIC BY ZEROS
         * END-IF.
         */
        log(TraceLevel.Trace, "*************DADOS FUNCIONAIS*******************");
        log(TraceLevel.Trace, bhyr0031().fhy003Area());
    }
    
    /**
     * 
     * ESCREVE FICHEIRO DE ESTATISTICA - ROTINA
     * 
     */
    protected void bhtp0033WriteEstatR() {
        bhyr0031().fhy003Area().initialize() ;
        bhyr0031().fhy003AreaRoti().fhy003NmRtnaAces().set(bhtw0033().dadosRotina().nmRtnaAces());
        bhyr0031().fhy003AreaRoti().fhy003IOperacao().set(bhtw0033().dadosRotina().iOperacao());
        bhyr0031().fhy003AreaRoti().fhy003CTipoErroBbn().set(bhtw0033().dadosRotina().cTipoErroBbn());
        bhyr0031().fhy003AreaRoti().fhy003CRtnoEvenSwal().set(bhtw0033().dadosRotina().cRtnoEvenSwal());
        bhyr0031().fhy003AreaRoti().fhy003AAplErr().set(bhtw0033().dadosRotina().aAplErr());
        bhyr0031().fhy003AreaRoti().fhy003QAcesRtna().set(bhtw0033().dadosRotina().qAcesRtna());
        bhyr0031().fhy003AreaCabc().fhy003ZFimPrct().set(bhtw0033().dadosGerais().zFimPrct());
        bhyr0031().fhy003AreaCabc().fhy003HFimPrct().set(bhtw0033().dadosGerais().hFimPrct());
        /**
         * WRITE REG-FHY003            FROM FHY003-AREA.
         * IF NOT SW-FHY003-OK
         * MOVE 'WR'                TO BHTW0030-C-TIPO-OPE-OBJ-DB2
         * PERFORM BHTP0033-COMUM
         * THRU BHTP0033-COMUM-EXIT
         * PERFORM BHTP0030-DISPLAY-ERRO
         * THRU BHTP0030-DISPLAY-ERRO-EXIT
         * ELSE
         * INITIALIZE FHY003-AREA REPLACING ALPHANUMERIC BY SPACES
         * NUMERIC BY ZEROS
         * END-IF.
         */
        log(TraceLevel.Trace, "**************ACESSOS A ROTINAS*****************");
        log(TraceLevel.Trace, "ROTINA: ", bhyr0031().fhy003AreaRoti().fhy003NmRtnaAces());
        log(TraceLevel.Trace, "TIPO DE ACESSO: ", bhyr0031().fhy003AreaRoti().fhy003IOperacao());
        log(TraceLevel.Trace, "TIPO DE ERRO DEVOLVIDO: ", bhyr0031().fhy003AreaRoti().fhy003CTipoErroBbn());
        log(TraceLevel.Trace, "CODIGO DO ERRO DEVOLVIDO: ", bhtw0033().dadosRotina().cRtnoEvenSwal());
        log(TraceLevel.Trace, "APLICACAO PARA DESCODIFICACAO DO ERRO: ", bhyr0031().fhy003AreaRoti().fhy003AAplErr());
        log(TraceLevel.Trace, "QUANTIDADE DE ACESSOS: ", bhyr0031().fhy003AreaRoti().fhy003QAcesRtna());
        log(TraceLevel.Trace, "DATA FIM DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003ZFimPrct());
        log(TraceLevel.Trace, "HORA FIM DE PROCESSAMENTO: ", bhyr0031().fhy003AreaCabc().fhy003HFimPrct());
    }
    
    /**
     * 
     * 9020-DB2CHECK  (TRANSACCIONAL)
     * VARIANTE PARA PROGRAMAS COM COMMAREAS ESPECIFICAS
     * 
     */
    protected void m9020Db2check() {
        bhtw0007().indicadoresErro().cTipoErroBbn().set(" ");
        bhtw0007().indicadoresErro().aAplErr().set(" ");
        bhtw0007().indicadoresErro().cRtnoEvenSwal().set(0);
        bhtw0005().cSqlcode().set(getPersistenceCode());
        if (!getSqlMessage().isEmpty()) {
            bhtw0007().indicadoresErro().cRtnoEvenSwal().set(bhtk0001().erros().warningDb2());
            bhtw0007().indicadoresErro().cTipoErroBbn().set(bhtk0002().indErros().abend());
            bhtw0007().indicadoresErro().aAplErr().set(bhtk0002().siglaArquit());
        } else if (!bhtw0005().notfnd().isTrue() && !bhtw0005().ok().isTrue() && 
            !bhtw0005().duprec().isTrue()) {
            bhtw0007().indicadoresErro().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            bhtw0007().indicadoresErro().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            bhtw0007().indicadoresErro().aAplErr().set(bhtk0002().siglaArquit());
        }
    }
}
