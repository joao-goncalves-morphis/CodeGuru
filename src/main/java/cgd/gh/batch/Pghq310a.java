package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
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
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtw0011 ;
import cgd.ho.structures.work.Bhow0013 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.na.structures.work.Bnar4901 ;
import cgd.gh.structures.work.Bghr3101 ;
import cgd.ht.routines.Mhtq111a ;
import cgd.ht.routines.Mhtq250a ;
import cgd.hy.routines.Mhyj230a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE INPUT
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE OUTPUT
 * WORKING STORAGE SECTION
 * CURSORES
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq310a extends CgdGhBaseBatch {
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
     * Handled Files
     */
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011", record="regFht01137")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk301
     */
    @Handler(name="FWK301", record="statusFwk301")
    @Data
    protected abstract Fwk301 ficheiroFwk301() ;
    
    /**
     * @return instancia da classe Fgh310
     */
    @Handler(name="FGH310", record="regFgh310200")
    @Data
    protected abstract Fgh310 ficheiroFgh310() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq111a
     */
    @Data
    protected abstract Mhtq111a hrMhtq111a() ;
    
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtw0011
     */
    @Data
    protected abstract Bhtw0011 bhtw0011() ;
    
    /**
     * @return instancia da classe Bhow0013
     */
    @Data
    protected abstract Bhow0013 bhow0013() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bnar4901
     */
    @Data
    protected abstract Bnar4901 bnar4901() ;
    
    /**
     * @return instancia da classe Bghr3101
     */
    @Data
    protected abstract Bghr3101 bghr3101() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHQ310A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK301 = "FWK301" ;
    
    protected static final String CON_FGH310 = "FGH310" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ310A" ;
    
    protected static final int CON_ANOS = 9 ;
    
    protected static final int CON_MESES = 4 ;
    
    protected static final int CON_1 = 1 ;
    
    protected static final String CON_SUBT_PRAZO = "23" ;
    
    protected static final String CON_PROGRAM_DESC = "OBTENCAO DE DADOS DE HISTORICO" ;
    
    /**
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * GH2185 - FIM
     * SWITCHES
     * @return instancia da classe local WsSwitches
     */
    @Data
    protected abstract WsSwitches wsSwitches() ;
    
    
    
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
     * BHTP0011-ABEND
     * 
     */
    protected void bhtp0011Abend() {
        log(TraceLevel.Trace, "VAI AH ROTINA MHTQ111A FAZER ROLLBACK");
        hrMhtq111a().run() ;
        bhtw0011().erro().setTrue() ;
        setReturnCode(bhtw0011().returnCode()) ;
        exit() ;
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
     * ACESSO A ROTINA QUE OBTEM AS DATAS D POR APLICACAO
     * MHTQ250A
     * 
     */
    protected void bhtp0250DatasDAplic() {
        hrMhtq250a().run() ;
    }
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
        hrMhyj230a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "*********** - INICIO - *************");
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFwk301().getStatusOk()) {
            m2000ProcPrograma() ;
        }
        m3000FinalPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100InicializaVar() ;
        m1200TrataEstatIni() ;
        m1300ObterDadosBatch() ;
        m1400ObtemDatasApl() ;
        m1450ObtemZ1Ano() ;
        m1500TrataFicheiros() ;
        m1600ReadFwk301() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        /**
         * GH2185 - INI
         * GH2185 - FIM
         */
        bnar4901().registo().initialize() ;
        wsVariaveis().wsContAnt().initialize() ;
        wsVariaveis().wsContAct().initialize() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_PROGRAM_DESC);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OBTER-DADOS-BATCH
     * 
     */
    protected void m1300ObterDadosBatch() {
        log(TraceLevel.Debug, "1300-OBTER-DADOS-BATCH");
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set("FHT011");
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
        bhop0013FormataAcesso() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1300-OBTER-DADOS-BATCH");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set("FHT011");
            bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1400-OBTEM-DATAS-APL
     * 
     */
    protected void m1400ObtemDatasApl() {
        log(TraceLevel.Debug, "1400-OBTEM-DATAS-APL");
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasDAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        } else {
            wsVariaveis().wsTsZInicMes().wsZInicMes().set(bhtl250a().commarea().dadosSaida().zProcessamento());
            wsVariaveis().wsTsZInicMes().wsZInicMes().wsDiaZInicMes().set(1);
        }
    }
    
    /**
     * 
     * 1450-OBTEM-Z-1-ANO
     * 
     */
    protected void m1450ObtemZ1Ano() {
        log(TraceLevel.Debug, "1450-OBTEM-Z-1-ANO");
        hrMhyj230a().bhyl230a().commarea().initialize() ;
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().cOeEgc().set(bhtw0011().commarea().dadosSaida().cBanco());
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().reduzido().setTrue() ;
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(CON_SUBT_PRAZO);
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().datInput1().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().prazo().cTipoPraz().set(CON_ANOS);
        /**
         * PROCESSO INICIAL COM 2 ANOS...
         * MOVE CON-1                      TO BHYL230A-DU-TIPO-PRAZ
         * *GH1284-I
         * MOVE 2                          TO BHYL230A-DU-TIPO-PRAZ
         */
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().prazo().duTipoPraz().set(CON_1);
        /**
         * *GH1284-F
         */
        bhyp0200RotinaDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(hrMhyj230a().bhyl230a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        } else {
            wsVariaveis().wsTs1Ano().wsZ1Ano().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().zOutput());
            wsVariaveis().wsTs1Ano().wsZ1Ano().wsDiaZ1Ano().set(1);
        }
    }
    
    /**
     * 
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500TrataFicheiros() {
        log(TraceLevel.Debug, "1500-TRATA-FICHEIROS");
        m1510OpenFwk301() ;
        m1520OpenFgh310() ;
    }
    
    /**
     * 
     * 1510-OPEN-FWK301
     * 
     */
    protected void m1510OpenFwk301() {
        log(TraceLevel.Debug, "1510-OPEN-FWK301");
        ficheiroFwk301().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK301);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk301().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk301().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK301);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk301().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-OPEN-FWK301");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-OPEN-FGH310
     * 
     */
    protected void m1520OpenFgh310() {
        log(TraceLevel.Debug, "1520-OPEN-FGH310");
        ficheiroFgh310().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH310);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh310().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh310().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH310);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh310().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FGH310");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FWK301
     * 
     */
    protected void m1600ReadFwk301() {
        log(TraceLevel.Debug, "1600-READ-FWK301");
        ficheiroFwk301().read(bnar4901().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK301);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk301().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk301().getStatusOk() && !ficheiroFwk301().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK301);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk301().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FWK301");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        /**
         * GH2185 - INI
         */
        wsVariaveis().wsContAct().set(bnar4901().registo().contaDoCred());
        log(TraceLevel.Debug, "WS-CONT-ACT 1: ", wsVariaveis().wsContAct().wsCPaisIsoaOpcrAct(), "/", wsVariaveis().wsContAct().wsCBancOpcrAct(), "/", wsVariaveis().wsContAct().wsCOeEgcOpcrAct(), "/", wsVariaveis().wsContAct().wsNsRdclOpcrAct(), "/", wsVariaveis().wsContAct().wsVChkdOpcrAct(), "/", wsVariaveis().wsContAct().wsCTipoContOpcrAct());
        log(TraceLevel.Debug, "WS-CONT-ANT 1: ", wsVariaveis().wsContAnt().wsCPaisIsoaOpcrAnt(), "/", wsVariaveis().wsContAnt().wsCBancOpcrAnt(), "/", wsVariaveis().wsContAnt().wsCOeEgcOpcrAnt(), "/", wsVariaveis().wsContAnt().wsNsRdclOpcrAnt(), "/", wsVariaveis().wsContAnt().wsVChkdOpcrAnt(), "/", wsVariaveis().wsContAnt().wsCTipoContOpcrAnt());
        if (!wsVariaveis().wsContAct().isEqual(wsVariaveis().wsContAnt())) {
            log(TraceLevel.Debug, "CONTAS DIFERENTES ");
            /**
             * GH2185 - FIM
             */
            m2100OpenCrsHistmov() ;
            m2200FetchCrsHistmov() ;
            while (!wsSwitches().swVgh00201Notfnd().isTrue()) {
                m2300TrataMov() ;
            }
            m2400CloseCrsHistmov() ;
            wsVariaveis().wsContAnt().initialize() ;
            wsVariaveis().wsContAnt().set(wsVariaveis().wsContAct());
            wsVariaveis().wsContAct().initialize() ;
            /**
             * GH2185 - FIM
             */
            m1600ReadFwk301() ;
        } else if (wsVariaveis().wsContAct().isEqual(wsVariaveis().wsContAnt())) {
            log(TraceLevel.Debug, "CONTAS IGUAIS ");
            wsVariaveis().wsContAnt().initialize() ;
            wsVariaveis().wsContAnt().set(wsVariaveis().wsContAct());
            wsVariaveis().wsContAct().initialize() ;
            m1600ReadFwk301() ;
        }
        log(TraceLevel.Debug, "WS-CONT-ACT 2: ", wsVariaveis().wsContAct().wsCPaisIsoaOpcrAct(), "/", wsVariaveis().wsContAct().wsCBancOpcrAct(), "/", wsVariaveis().wsContAct().wsCOeEgcOpcrAct(), "/", wsVariaveis().wsContAct().wsNsRdclOpcrAct(), "/", wsVariaveis().wsContAct().wsVChkdOpcrAct(), "/", wsVariaveis().wsContAct().wsCTipoContOpcrAct());
        log(TraceLevel.Debug, "WS-CONT-ANT 2: ", wsVariaveis().wsContAnt().wsCPaisIsoaOpcrAnt(), "/", wsVariaveis().wsContAnt().wsCBancOpcrAnt(), "/", wsVariaveis().wsContAnt().wsCOeEgcOpcrAnt(), "/", wsVariaveis().wsContAnt().wsNsRdclOpcrAnt(), "/", wsVariaveis().wsContAnt().wsVChkdOpcrAnt(), "/", wsVariaveis().wsContAnt().wsCTipoContOpcrAnt());
    }
    
    /**
     * 
     * 2100-OPEN-CRS-HISTMOV
     * 
     */
    protected void m2100OpenCrsHistmov() {
        log(TraceLevel.Debug, "2100-OPEN-CRS-HISTMOV");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(bnar4901().registo().contaDoCred().cPaisIsaCtaCre());
        hv00201Movhst().movhst().cBancCont().set(bnar4901().registo().contaDoCred().cBancContCred());
        hv00201Movhst().movhst().cOeEgcCont().set(bnar4901().registo().contaDoCred().cOeEgcContCred());
        hv00201Movhst().movhst().nsRdclCont().set(bnar4901().registo().contaDoCred().nsRdclContCred());
        hv00201Movhst().movhst().vChkdCont().set(bnar4901().registo().contaDoCred().vChkdContCred());
        hv00201Movhst().movhst().cTipoCont().set(bnar4901().registo().contaDoCred().cTipoContCred());
        wsVariaveis().wsTsMov1Ano().set(wsVariaveis().wsTs1Ano());
        wsVariaveis().wsTsMovInicMes().set(wsVariaveis().wsTsZInicMes());
        log(TraceLevel.Debug, "> WS-TS-MOV-1-ANO   :", wsVariaveis().wsTsMov1Ano());
        log(TraceLevel.Debug, "> WS-TS-MOV-INIC-MES:", wsVariaveis().wsTsMovInicMes());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS-HISTMOV
         */
        hv00201Movhst().openPghq310a706(wsVariaveis().wsTsMov1Ano(), wsVariaveis().wsTsMovInicMes()) ;
        wsSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swOpenCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!wsSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2210-OPEN-CRS-HISTMOV");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2100-FETCH-CRS-HISTMOV
     * 
     */
    protected void m2200FetchCrsHistmov() {
        log(TraceLevel.Debug, "2100-FETCH-CRS-HISTMOV");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS-HISTMOV
         */
        hv00201Movhst().fetchPghq310a742() ;
        wsSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!wsSwitches().swVgh00201Ok().isTrue() && !wsSwitches().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2210-FETCH-CRS-HISTMOV");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-TRATA-MOV
     * 
     */
    protected void m2300TrataMov() {
        log(TraceLevel.Debug, "2300-TRATA-MOV");
        m2310ObtemMovhstcpl() ;
        m2320EscreveFgh310() ;
        m2200FetchCrsHistmov() ;
    }
    
    /**
     * 
     * 2310-OBTEM-MOVHSTCPL
     * 
     */
    protected void m2310ObtemMovhstcpl() {
        log(TraceLevel.Debug, "2310-OBTEM-MOVHSTCPL");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bnar4901().registo().contaDoCred().cPaisIsaCtaCre());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bnar4901().registo().contaDoCred().cBancContCred());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bnar4901().registo().contaDoCred().cOeEgcContCred());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bnar4901().registo().contaDoCred().nsRdclContCred());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bnar4901().registo().contaDoCred().vChkdContCred());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bnar4901().registo().contaDoCred().cTipoContCred());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        hv10201Movhstcpl().movhstcpl().nsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq310a829() ;
        wsSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH10201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!wsSwitches().swVgh10201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2310-OBTEM-MOVHSTCPL");
            bhtw0030().dadosEntrada().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH10201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv10201Movhstcpl().movhstcpl());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2320-ESCREVE-FGH310
     * 
     */
    protected void m2320EscreveFgh310() {
        log(TraceLevel.Debug, "2320-ESCREVE-FGH310");
        bghr3101().registo().cPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
        bghr3101().registo().cBancCont().set(hv00201Movhst().movhst().cBancCont());
        bghr3101().registo().cOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
        bghr3101().registo().nsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
        bghr3101().registo().vChkdCont().set(hv00201Movhst().movhst().vChkdCont());
        bghr3101().registo().cTipoCont().set(hv00201Movhst().movhst().cTipoCont());
        bghr3101().registo().cMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
        bghr3101().registo().nsDeposito().set(hv00201Movhst().movhst().nsDeposito());
        bghr3101().registo().tsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        bghr3101().registo().nsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        bghr3101().registo().zValMov().set(hv00201Movhst().movhst().zValMov());
        bghr3101().registo().iDbcr().set(hv00201Movhst().movhst().iDbcr());
        bghr3101().registo().mMovimento().set(hv00201Movhst().movhst().mMovimento());
        bghr3101().registo().iEstorno().set(hv00201Movhst().movhst().iEstorno());
        bghr3101().registo().mSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        bghr3101().registo().mSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        bghr3101().registo().xRefMov().set(hv00201Movhst().movhst().xRefMov());
        bghr3101().registo().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
        bghr3101().registo().cEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
        bghr3101().registo().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
        bghr3101().registo().cTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
        bghr3101().registo().zExtracao().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        bghr3101().registo().filler().set(" ");
        ficheiroFgh310().write(ficheiroFgh310().regFgh310200) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH310);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh310().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh310().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH310);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh310().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-ESCREVE-FGH310");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2400-CLOSE-CRS-HISTMOV
     * 
     */
    protected void m2400CloseCrsHistmov() {
        log(TraceLevel.Debug, "2400-CLOSE-CRS-HISTMOV");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS-HISTMOV
         */
        hv00201Movhst().closePghq310a946() ;
        wsSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!wsSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2400-CLOSE-CRS-HISTMOV");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(" ");
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        m3100FecharFicheiros() ;
        m3200EscreveEstat() ;
    }
    
    /**
     * 
     * 3100-FECHAR-FICHEIROS
     * 
     */
    protected void m3100FecharFicheiros() {
        log(TraceLevel.Debug, " --3100-FECHAR-FICHEIROS");
        m3110CloseFwk301() ;
        m3120CloseFgh310() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FWK001
     * 
     */
    protected void m3110CloseFwk301() {
        log(TraceLevel.Debug, "3110-CLOSE-FWK301");
        ficheiroFwk301().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK301);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk301().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk301().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK301);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk301().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FWK301");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-CLOSE-FGH310
     * 
     */
    protected void m3120CloseFgh310() {
        log(TraceLevel.Debug, "3120-CLOSE-FGH310");
        ficheiroFgh310().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH310);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh310().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh310().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH310);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh310().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FGH310");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3200-ESCREVE-ESTAT
     * 
     */
    protected void m3200EscreveEstat() {
        log(TraceLevel.Debug, "3200-ESCREVE-ESTAT");
        bhop0013FimEstatistica() ;
        log(TraceLevel.Trace, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Trace, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFwk301().close() ;
        ficheiroFgh310().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
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
     * STATUS
     * 
     * @version 2.0
     * 
     */
    public interface SwStatus extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition fhy003Ok() ;
        @Data
        @Condition("10")
        ICondition fhy003Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk301() ;
        @Data
        @Condition("00")
        ICondition swFwk301Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk301Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh310() ;
        @Data
        @Condition("00")
        ICondition swFgh310Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh310Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=26)
        IString wsTsMov1Ano() ;
        
        @Data(size=26)
        IString wsTsMovInicMes() ;
        
        /**
         * @return instancia da classe local WsTs1Ano
         */
        @Data
        WsTs1Ano wsTs1Ano() ;
        
        /**
         * @return instancia da classe local WsTsZInicMes
         */
        @Data
        WsTsZInicMes wsTsZInicMes() ;
        
        /**
         * GH2185 - INI
         * @return instancia da classe local WsContAct
         */
        @Data
        WsContAct wsContAct() ;
        
        /**
         * @return instancia da classe local WsContAnt
         */
        @Data
        WsContAnt wsContAnt() ;
        
        
        public interface WsTs1Ano extends IDataStruct {
            
            /**
             * @return instancia da classe local WsZ1Ano
             */
            @Data
            WsZ1Ano wsZ1Ano() ;
            
            @Data(size=16, value="-00.00.00.000000")
            IString wsHora1Ano() ;
            
            
            public interface WsZ1Ano extends IDataStruct {
                
                @Data(size=4)
                IInt wsAnoZ1Ano() ;
                
                @Data(size=2, lpadding=1)
                IInt wsMesZ1Ano() ;
                
                @Data(size=2, lpadding=1)
                IInt wsDiaZ1Ano() ;
                
            }
        }
        
        public interface WsTsZInicMes extends IDataStruct {
            
            /**
             * @return instancia da classe local WsZInicMes
             */
            @Data
            WsZInicMes wsZInicMes() ;
            
            @Data(size=16, value="-00.00.00.000000")
            IString wsHoraInicMes() ;
            
            
            public interface WsZInicMes extends IDataStruct {
                
                @Data(size=4)
                IInt wsAnoZInicMes() ;
                
                @Data(size=2, lpadding=1)
                IInt wsMesZInicMes() ;
                
                @Data(size=2, lpadding=1)
                IInt wsDiaZInicMes() ;
                
            }
        }
        
        
        /**
         * 
         * GH2185 - INI
         * 
         * @version 2.0
         * 
         */
        public interface WsContAct extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaOpcrAct() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancOpcrAct() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCOeEgcOpcrAct() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRdclOpcrAct() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsVChkdOpcrAct() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsCTipoContOpcrAct() ;
            
        }
        
        public interface WsContAnt extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaOpcrAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancOpcrAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCOeEgcOpcrAnt() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRdclOpcrAnt() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsVChkdOpcrAnt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsCTipoContOpcrAnt() ;
            
        }
    }
    
    /**
     * 
     * GH2185 - FIM
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface WsSwitches extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        
        
    }
    
}
