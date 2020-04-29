package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.persistence.relational.annotations.Key ;
import morphis.framework.persistence.relational.annotations.Column ;
import morphis.framework.persistence.relational.BaseTableHandler ;
import morphis.framework.persistence.relational.BaseCursorHandler ;
import morphis.framework.exceptions.* ;
/**
 * External
 */
//import cgd.gh.online.Pghs141a.WsTabelasInternas.WsDocCliLinha ;
//import cgd.gh.structures.messages.Bghm1140.Msg.Ade ;
import cgd.gh.structures.work.Bghr1301.Registo ;
import cgd.gh.structures.work.Bghwk141.Ade;
import cgd.gh.structures.work.Bghwk141.WsDocCliLinha;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps13001Movdep extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movdep
     */
    @Data
    public abstract Movdep movdep() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH13001_MOVDEP
     * 
     * @version 2.0
     * 
     */
    public interface Movdep extends IDataStruct {
        
        /**
         * Z_PROCESSAMENTO
         */
        @Column(name="Z_PROCESSAMENTO", type=java.sql.Date.class)
        @Key
        @Data(size=10)
        IString zProcessamento() ;
        
        /**
         * C_MNEM_EGC_OPEX
         */
        @Column(name="C_MNEM_EGC_OPEX")
        @Key
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        /**
         * C_PAIS_ISOA_OE_OPX
         */
        @Column(name="C_PAIS_ISOA_OE_OPX")
        @Key
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        /**
         * C_OE_EGC_OPEX
         */
        @Column(name="C_OE_EGC_OPEX")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        /**
         * C_USERID
         */
        @Column(name="C_USERID")
        @Key
        @Data(size=8)
        IString cUserid() ;
        
        /**
         * N_JOUR_BBN
         */
        @Column(name="N_JOUR_BBN")
        @Key
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * C_MOED_ISO_SCTA
         */
        @Column(name="C_MOED_ISO_SCTA")
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        /**
         * NS_DEPOSITO
         */
        @Column(name="NS_DEPOSITO")
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        /**
         * C_PAIS_ISO_ALFN
         */
        @Column(name="C_PAIS_ISO_ALFN")
        @Data(size=3)
        IString cPaisIsoAlfn() ;
        
        /**
         * C_MNEM_EMP_GCX
         */
        @Column(name="C_MNEM_EMP_GCX")
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        /**
         * C_REF_MSG_SWIF
         */
        @Column(name="C_REF_MSG_SWIF")
        @Data(size=16)
        IString cRefMsgSwif() ;
        
        /**
         * C_EST_MSG_SWIF
         */
        @Column(name="C_EST_MSG_SWIF")
        @Data(size=2, signed=true, compression=COMP3)
        IInt cEstMsgSwif() ;
        
        /**
         * N_CHEQUE
         */
        @Column(name="N_CHEQUE")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        /**
         * C_PAIS_ISA_EMS_DOC
         */
        @Column(name="C_PAIS_ISA_EMS_DOC")
        @Data(size=3)
        IString cPaisIsaEmsDoc() ;
        
        /**
         * C_TIPO_DOC_ID
         */
        @Column(name="C_TIPO_DOC_ID")
        @Data(size=3)
        IString cTipoDocId() ;
        
        /**
         * N_DOC_ID
         */
        @Column(name="N_DOC_ID")
        @Data(size=20)
        IString nDocId() ;
        
        /**
         * Z_VLDE_DOC_ID
         */
        @Column(name="Z_VLDE_DOC_ID", type=java.sql.Date.class)
        @Data(size=10)
        IString zVldeDocId() ;
        
        /**
         * C_ENT_EMIX_DOC_ID
         */
        @Column(name="C_ENT_EMIX_DOC_ID")
        @Data(size=10)
        IString cEntEmixDocId() ;
        
        /**
         * C_PAIS_EMS_DOC_APT
         */
        @Column(name="C_PAIS_EMS_DOC_APT")
        @Data(size=3)
        IString cPaisEmsDocApt() ;
        
        /**
         * C_TIPO_DOC_ID_APTD
         */
        @Column(name="C_TIPO_DOC_ID_APTD")
        @Data(size=3)
        IString cTipoDocIdAptd() ;
        
        /**
         * N_DOC_ID_APTD
         */
        @Column(name="N_DOC_ID_APTD")
        @Data(size=20)
        IString nDocIdAptd() ;
        
        /**
         * Z_VLDE_DOC_ID_APTD
         */
        @Column(name="Z_VLDE_DOC_ID_APTD", type=java.sql.Date.class)
        @Data(size=10)
        IString zVldeDocIdAptd() ;
        
        /**
         * C_ENT_EMI_DID_APTD
         */
        @Column(name="C_ENT_EMI_DID_APTD")
        @Data(size=10)
        IString cEntEmiDidAptd() ;
        
        /**
         * C_PAIS_EMS_DOC_RPT
         */
        @Column(name="C_PAIS_EMS_DOC_RPT")
        @Data(size=3)
        IString cPaisEmsDocRpt() ;
        
        /**
         * C_TIPO_DOC_ID_RPRT
         */
        @Column(name="C_TIPO_DOC_ID_RPRT")
        @Data(size=3)
        IString cTipoDocIdRprt() ;
        
        /**
         * N_DOC_ID_RPRT
         */
        @Column(name="N_DOC_ID_RPRT")
        @Data(size=20)
        IString nDocIdRprt() ;
        
        /**
         * Z_VLDE_DOC_ID_RPRT
         */
        @Column(name="Z_VLDE_DOC_ID_RPRT", type=java.sql.Date.class)
        @Data(size=10)
        IString zVldeDocIdRprt() ;
        
        /**
         * C_ENT_EMIX_DID_RPT
         */
        @Column(name="C_ENT_EMIX_DID_RPT")
        @Data(size=10)
        IString cEntEmixDidRpt() ;
        
        /**
         * NM_CLIENTE
         */
        @Column(name="NM_CLIENTE")
        @Data(size=135)
        IString nmCliente() ;
        
        /**
         * I_CLI_CGD
         */
        @Column(name="I_CLI_CGD")
        @Data(size=1)
        IString iCliCgd() ;
        
        /**
         * I_RPRT_CLI_CGD
         */
        @Column(name="I_RPRT_CLI_CGD")
        @Data(size=1)
        IString iRprtCliCgd() ;
        
        /**
         * C_TIPO_ITVT_DEP
         */
        @Column(name="C_TIPO_ITVT_DEP")
        @Data(size=1)
        IString cTipoItvtDep() ;
        
        /**
         * C_TIPO_MDTI
         */
        @Column(name="C_TIPO_MDTI")
        @Data(size=1)
        IString cTipoMdti() ;
        
        /**
         * Z_MOVIMENTO
         */
        @Column(name="Z_MOVIMENTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovimento() ;
        
        /**
         * I_DBCR
         */
        @Column(name="I_DBCR")
        @Data(size=1)
        IString iDbcr() ;
        
        /**
         * M_MOV_EURO
         */
        @Column(name="M_MOV_EURO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovEuro() ;
        
        /**
         * C_TIPO_CANL_ACES
         */
        @Column(name="C_TIPO_CANL_ACES")
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        /**
         * C_TIPO_OPE_CONT
         */
        @Column(name="C_TIPO_OPE_CONT")
        @Data(size=1)
        IString cTipoOpeCont() ;
        
        /**
         * I_TRNZ_EFCD_ONLN
         */
        @Column(name="I_TRNZ_EFCD_ONLN")
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        /**
         * I_PED_JSTZ_ORM_FND
         */
        @Column(name="I_PED_JSTZ_ORM_FND")
        @Data(size=1)
        IString iPedJstzOrmFnd() ;
        
        /**
         * C_MTVO_PED_JSTZ
         */
        @Column(name="C_MTVO_PED_JSTZ")
        @Data(size=1)
        IString cMtvoPedJstz() ;
        
        /**
         * I_RCS_JSTZ_ORM_FND
         */
        @Column(name="I_RCS_JSTZ_ORM_FND")
        @Data(size=1)
        IString iRcsJstzOrmFnd() ;
        
        /**
         * I_ESTORNO
         */
        @Column(name="I_ESTORNO")
        @Data(size=1)
        IString iEstorno() ;
        
        /**
         * Q_MOEDA
         */
        @Column(name="Q_MOEDA")
        @Data(size=6, signed=true, compression=COMP3)
        IInt qMoeda() ;
        
        /**
         * C_TIPO_REL_DPST
         */
        @Column(name="C_TIPO_REL_DPST")
        @Data(size=1)
        IString cTipoRelDpst() ;
        
        /**
         * X_INF_JSTZ_DEP
         */
        @Column(name="X_INF_JSTZ_DEP", type=byte[].class)
        @Data(size=50)
        IString xInfJstzDep() ;
        
        /**
         * TS_INSERCAO
         */
        @Column(name="TS_INSERCAO", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsInsercao() ;
        
        /**
         * TS_ACTZ_ULT
         */
        @Column(name="TS_ACTZ_ULT", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsActzUlt() ;
        
        /**
         * C_USID_ACTZ_ULT
         */
        @Column(name="C_USID_ACTZ_ULT")
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    
    /**
     * BatchQ1
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH13001_MOVDEP
     * called from Pghq130a.M2100UpdateTgh00130M2100UpdateTgh00130
     * 
     * @param pRegisto
     * @param pConCredito
     * @param pConTsMin
     * @param pConCTipoOpeEntrega
     */
    public void updatePghq130a425(Registo pRegisto, String pConCredito, String pConTsMin, String pConCTipoOpeEntrega) {
        sqlSttmt = "UPDATE VWSDGHPS13001_MOVDEP " +
            "SET TS_INSERCAO = :tsActzUlt, " +
                "C_TIPO_OPE_CONT = :conCTipoOpeEntrega" +
            " WHERE " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "I_DBCR = :conCredito AND " +
                "TS_INSERCAO = :conTsMin" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", pRegisto.zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", pRegisto.cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pRegisto.cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", pRegisto.cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", pRegisto.cUserid() ) ;
        setQueryArgument( "nJourBbn", pRegisto.nJourBbn() ) ;
        setQueryArgument( "conCredito", pConCredito ) ;
        setQueryArgument( "conTsMin", pConTsMin, java.sql.Timestamp.class ) ;
        setQueryArgument( "tsActzUlt", pRegisto.tsActzUlt() ) ;
        setQueryArgument( "conCTipoOpeEntrega", pConCTipoOpeEntrega ) ;
        executeUpdate() ;
    }
    /**
     * Online
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_CONTA_2_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6848() {
        BaseCursorHandler c = getCursor("CRS_CONTA_2_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_CONTA_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6852() {
        BaseCursorHandler c = getCursor("CRS_CONTA_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_CONTA_2_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6859() {
        BaseCursorHandler c = getCursor("CRS_CONTA_2_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_CONTA_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6863() {
        BaseCursorHandler c = getCursor("CRS_CONTA_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_CLIENTE_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6869() {
        BaseCursorHandler c = getCursor("CRS_CLIENTE_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_CLIENTE_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6874() {
        BaseCursorHandler c = getCursor("CRS_CLIENTE_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_DOC_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6879() {
        BaseCursorHandler c = getCursor("CRS_DOC_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_DOC_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6884() {
        BaseCursorHandler c = getCursor("CRS_DOC_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_NOME_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6889() {
        BaseCursorHandler c = getCursor("CRS_NOME_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_NOME_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6894() {
        BaseCursorHandler c = getCursor("CRS_NOME_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_ORDEM_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6899() {
        BaseCursorHandler c = getCursor("CRS_ORDEM_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_ORDEM_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6904() {
        BaseCursorHandler c = getCursor("CRS_ORDEM_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_MONT_ASC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6909() {
        BaseCursorHandler c = getCursor("CRS_MONT_ASC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_MONT_DESC
     * called from Pghs141a.M2400FecharCursorM2400FecharCursor
     * 
     */
    public void closePghs141a6914() {
        BaseCursorHandler c = getCursor("CRS_MONT_DESC") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_CONTA_2_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a4983() {
        BaseCursorHandler c = getCursor("CRS_CONTA_2_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_CONTA_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5044() {
        BaseCursorHandler c = getCursor("CRS_CONTA_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_CONTA_2_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5109() {
        BaseCursorHandler c = getCursor("CRS_CONTA_2_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_CONTA_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5170() {
        BaseCursorHandler c = getCursor("CRS_CONTA_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_CLIENTE_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5234() {
        BaseCursorHandler c = getCursor("CRS_CLIENTE_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_CLIENTE_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5297() {
        BaseCursorHandler c = getCursor("CRS_CLIENTE_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_DOC_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5360() {
        BaseCursorHandler c = getCursor("CRS_DOC_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_DOC_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5423() {
        BaseCursorHandler c = getCursor("CRS_DOC_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_NOME_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5486() {
        BaseCursorHandler c = getCursor("CRS_NOME_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_NOME_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5549() {
        BaseCursorHandler c = getCursor("CRS_NOME_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_ORDEM_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5613() {
        BaseCursorHandler c = getCursor("CRS_ORDEM_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_ORDEM_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5676() {
        BaseCursorHandler c = getCursor("CRS_ORDEM_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_MONT_ASC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5739() {
        BaseCursorHandler c = getCursor("CRS_MONT_ASC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_MONT_DESC
     * called from Pghs141a.M2200LerCursorM2200LerCursor
     * 
     */
    public void fetchPghs141a5802() {
        BaseCursorHandler c = getCursor("CRS_MONT_DESC") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(c.getValue("C_USERID")) ;
            movdep().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(c.getValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(c.getValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(c.getValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(c.getValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(c.getValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(c.getValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(c.getValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(c.getValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(c.getValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(c.getValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(c.getValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(c.getValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(c.getValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(c.getValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(c.getValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(c.getValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(c.getValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(c.getValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(c.getValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(c.getValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(c.getValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(c.getValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(c.getValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(c.getValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(c.getValue("I_DBCR")) ;
            movdep().mMovEuro().set(c.getValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(c.getValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(c.getValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(c.getValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(c.getValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdep().qMoeda().set(c.getValue("Q_MOEDA")) ;
            movdep().cTipoRelDpst().set(c.getValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(c.getValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(c.getValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH13001_MOVDEP
     * called from Pghs133a.M2420InsertTgh130M2420InsertTgh130
     * 
     */
    public void insertPghs133a5224() {
        sqlSttmt = "INSERT INTO VWSDGHPS13001_MOVDEP ( " +
        	"Z_PROCESSAMENTO, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_OE_EGC_OPEX, " +
        	"C_USERID, " +
        	"N_JOUR_BBN, " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PAIS_ISO_ALFN, " +
        	"C_MNEM_EMP_GCX, " +
        	"C_REF_MSG_SWIF, " +
        	"C_EST_MSG_SWIF, " +
        	"N_CHEQUE, " +
        	"C_PAIS_ISA_EMS_DOC, " +
        	"C_TIPO_DOC_ID, " +
        	"N_DOC_ID, " +
        	"Z_VLDE_DOC_ID, " +
        	"C_ENT_EMIX_DOC_ID, " +
        	"C_PAIS_EMS_DOC_APT, " +
        	"C_TIPO_DOC_ID_APTD, " +
        	"N_DOC_ID_APTD, " +
        	"Z_VLDE_DOC_ID_APTD, " +
        	"C_ENT_EMI_DID_APTD, " +
        	"NM_CLIENTE, " +
        	"I_CLI_CGD, " +
        	"C_TIPO_ITVT_DEP, " +
        	"C_TIPO_MDTI, " +
        	"Z_MOVIMENTO, " +
        	"I_DBCR, " +
        	"M_MOV_EURO, " +
        	"C_TIPO_CANL_ACES, " +
        	"C_TIPO_OPE_CONT, " +
        	"I_TRNZ_EFCD_ONLN, " +
        	"I_PED_JSTZ_ORM_FND, " +
        	"C_MTVO_PED_JSTZ, " +
        	"I_RCS_JSTZ_ORM_FND, " +
        	"I_ESTORNO, " +
        	"Q_MOEDA, " +
        	"C_TIPO_REL_DPST, " +
        	"X_INF_JSTZ_DEP, " +
        	"TS_INSERCAO, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":zProcessamento, " +
        	":cMnemEgcOpex, " +
        	":cPaisIsoaOeOpx, " +
        	":cOeEgcOpex, " +
        	":cUserid, " +
        	":nJourBbn, " +
        	":cPaisIsoaCont, " +
        	":cBancCont, " +
        	":cOeEgcCont, " +
        	":nsRdclCont, " +
        	":vChkdCont, " +
        	":cTipoCont, " +
        	":cMoedIsoScta, " +
        	":nsDeposito, " +
        	":cPaisIsoAlfn, " +
        	":cMnemEmpGcx, " +
        	":cRefMsgSwif, " +
        	":cEstMsgSwif, " +
        	":nCheque, " +
        	":cPaisIsaEmsDoc, " +
        	":cTipoDocId, " +
        	":nDocId, " +
        	":zVldeDocId, " +
        	":cEntEmixDocId, " +
        	":cPaisEmsDocApt, " +
        	":cTipoDocIdAptd, " +
        	":nDocIdAptd, " +
        	":zVldeDocIdAptd, " +
        	":cEntEmiDidAptd, " +
        	":nmCliente, " +
        	":iCliCgd, " +
        	":cTipoItvtDep, " +
        	":cTipoMdti, " +
        	":zMovimento, " +
        	":iDbcr, " +
        	":mMovEuro, " +
        	":cTipoCanlAces, " +
        	":cTipoOpeCont, " +
        	":iTrnzEfcdOnln, " +
        	":iPedJstzOrmFnd, " +
        	":cMtvoPedJstz, " +
        	":iRcsJstzOrmFnd, " +
        	":iEstorno, " +
        	":qMoeda, " +
        	":cTipoRelDpst, " +
        	":xInfJstzDep, " +
        	"NOW(), " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", movdep().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdep().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdep().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdep().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdep().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdep().nJourBbn() ) ;
        setQueryArgument( "cPaisIsoaCont", movdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdep().nsDeposito() ) ;
        setQueryArgument( "cPaisIsoAlfn", movdep().cPaisIsoAlfn() ) ;
        setQueryArgument( "cMnemEmpGcx", movdep().cMnemEmpGcx() ) ;
        setQueryArgument( "cRefMsgSwif", movdep().cRefMsgSwif() ) ;
        setQueryArgument( "cEstMsgSwif", movdep().cEstMsgSwif() ) ;
        setQueryArgument( "nCheque", movdep().nCheque() ) ;
        setQueryArgument( "cPaisIsaEmsDoc", movdep().cPaisIsaEmsDoc() ) ;
        setQueryArgument( "cTipoDocId", movdep().cTipoDocId() ) ;
        setQueryArgument( "nDocId", movdep().nDocId() ) ;
        setQueryArgument( "zVldeDocId", movdep().zVldeDocId(), java.sql.Date.class ) ;
        setQueryArgument( "cEntEmixDocId", movdep().cEntEmixDocId() ) ;
        setQueryArgument( "cPaisEmsDocApt", movdep().cPaisEmsDocApt() ) ;
        setQueryArgument( "cTipoDocIdAptd", movdep().cTipoDocIdAptd() ) ;
        setQueryArgument( "nDocIdAptd", movdep().nDocIdAptd() ) ;
        setQueryArgument( "zVldeDocIdAptd", movdep().zVldeDocIdAptd(), java.sql.Date.class ) ;
        setQueryArgument( "cEntEmiDidAptd", movdep().cEntEmiDidAptd() ) ;
        setQueryArgument( "nmCliente", movdep().nmCliente() ) ;
        setQueryArgument( "iCliCgd", movdep().iCliCgd() ) ;
        setQueryArgument( "cTipoItvtDep", movdep().cTipoItvtDep() ) ;
        setQueryArgument( "cTipoMdti", movdep().cTipoMdti() ) ;
        setQueryArgument( "zMovimento", movdep().zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "mMovEuro", movdep().mMovEuro() ) ;
        setQueryArgument( "cTipoCanlAces", movdep().cTipoCanlAces() ) ;
        setQueryArgument( "cTipoOpeCont", movdep().cTipoOpeCont() ) ;
        setQueryArgument( "iTrnzEfcdOnln", movdep().iTrnzEfcdOnln() ) ;
        setQueryArgument( "iPedJstzOrmFnd", movdep().iPedJstzOrmFnd() ) ;
        setQueryArgument( "cMtvoPedJstz", movdep().cMtvoPedJstz() ) ;
        setQueryArgument( "iRcsJstzOrmFnd", movdep().iRcsJstzOrmFnd() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        setQueryArgument( "qMoeda", movdep().qMoeda() ) ;
        setQueryArgument( "cTipoRelDpst", movdep().cTipoRelDpst() ) ;
        setQueryArgument( "xInfJstzDep", movdep().xInfJstzDep() ) ;
        setQueryArgument( "cUsidActzUlt", movdep().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH13001_MOVDEP
     * called from Pghs163a.M2240InsertTgh130M2240InsertTgh130
     * 
     */
    public void insertPghs163a4659() {
        sqlSttmt = "INSERT INTO VWSDGHPS13001_MOVDEP ( " +
        	"Z_PROCESSAMENTO, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_OE_EGC_OPEX, " +
        	"C_USERID, " +
        	"N_JOUR_BBN, " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PAIS_ISO_ALFN, " +
        	"C_MNEM_EMP_GCX, " +
        	"C_REF_MSG_SWIF, " +
        	"C_EST_MSG_SWIF, " +
        	"N_CHEQUE, " +
        	"C_PAIS_ISA_EMS_DOC, " +
        	"C_TIPO_DOC_ID, " +
        	"N_DOC_ID, " +
        	"Z_VLDE_DOC_ID, " +
        	"C_ENT_EMIX_DOC_ID, " +
        	"C_PAIS_EMS_DOC_APT, " +
        	"C_TIPO_DOC_ID_APTD, " +
        	"N_DOC_ID_APTD, " +
        	"Z_VLDE_DOC_ID_APTD, " +
        	"C_ENT_EMI_DID_APTD, " +
        	"C_PAIS_EMS_DOC_RPT, " +
        	"C_TIPO_DOC_ID_RPRT, " +
        	"N_DOC_ID_RPRT, " +
        	"Z_VLDE_DOC_ID_RPRT, " +
        	"C_ENT_EMIX_DID_RPT, " +
        	"NM_CLIENTE, " +
        	"I_CLI_CGD, " +
        	"I_RPRT_CLI_CGD, " +
        	"C_TIPO_ITVT_DEP, " +
        	"C_TIPO_MDTI, " +
        	"Z_MOVIMENTO, " +
        	"I_DBCR, " +
        	"M_MOV_EURO, " +
        	"C_TIPO_CANL_ACES, " +
        	"C_TIPO_OPE_CONT, " +
        	"I_TRNZ_EFCD_ONLN, " +
        	"I_PED_JSTZ_ORM_FND, " +
        	"C_MTVO_PED_JSTZ, " +
        	"I_RCS_JSTZ_ORM_FND, " +
        	"I_ESTORNO, " +
        	"Q_MOEDA, " +
        	"C_TIPO_REL_DPST, " +
        	"X_INF_JSTZ_DEP, " +
        	"TS_INSERCAO, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":zProcessamento, " +
        	":cMnemEgcOpex, " +
        	":cPaisIsoaOeOpx, " +
        	":cOeEgcOpex, " +
        	":cUserid, " +
        	":nJourBbn, " +
        	":cPaisIsoaCont, " +
        	":cBancCont, " +
        	":cOeEgcCont, " +
        	":nsRdclCont, " +
        	":vChkdCont, " +
        	":cTipoCont, " +
        	":cMoedIsoScta, " +
        	":nsDeposito, " +
        	":cPaisIsoAlfn, " +
        	":cMnemEmpGcx, " +
        	":cRefMsgSwif, " +
        	":cEstMsgSwif, " +
        	":nCheque, " +
        	":cPaisIsaEmsDoc, " +
        	":cTipoDocId, " +
        	":nDocId, " +
        	":zVldeDocId, " +
        	":cEntEmixDocId, " +
        	":cPaisEmsDocApt, " +
        	":cTipoDocIdAptd, " +
        	":nDocIdAptd, " +
        	":zVldeDocIdAptd, " +
        	":cEntEmiDidAptd, " +
        	":cPaisEmsDocRpt, " +
        	":cTipoDocIdRprt, " +
        	":nDocIdRprt, " +
        	":zVldeDocIdRprt, " +
        	":cEntEmixDidRpt, " +
        	":nmCliente, " +
        	":iCliCgd, " +
        	":iRprtCliCgd, " +
        	":cTipoItvtDep, " +
        	":cTipoMdti, " +
        	":zMovimento, " +
        	":iDbcr, " +
        	":mMovEuro, " +
        	":cTipoCanlAces, " +
        	":cTipoOpeCont, " +
        	":iTrnzEfcdOnln, " +
        	":iPedJstzOrmFnd, " +
        	":cMtvoPedJstz, " +
        	":iRcsJstzOrmFnd, " +
        	":iEstorno, " +
        	":qMoeda, " +
        	":cTipoRelDpst, " +
        	":xInfJstzDep, " +
        	"NOW(), " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", movdep().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdep().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdep().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdep().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdep().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdep().nJourBbn() ) ;
        setQueryArgument( "cPaisIsoaCont", movdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdep().nsDeposito() ) ;
        setQueryArgument( "cPaisIsoAlfn", movdep().cPaisIsoAlfn() ) ;
        setQueryArgument( "cMnemEmpGcx", movdep().cMnemEmpGcx() ) ;
        setQueryArgument( "cRefMsgSwif", movdep().cRefMsgSwif() ) ;
        setQueryArgument( "cEstMsgSwif", movdep().cEstMsgSwif() ) ;
        setQueryArgument( "nCheque", movdep().nCheque() ) ;
        setQueryArgument( "cPaisIsaEmsDoc", movdep().cPaisIsaEmsDoc() ) ;
        setQueryArgument( "cTipoDocId", movdep().cTipoDocId() ) ;
        setQueryArgument( "nDocId", movdep().nDocId() ) ;
        setQueryArgument( "zVldeDocId", movdep().zVldeDocId(), java.sql.Date.class ) ;
        setQueryArgument( "cEntEmixDocId", movdep().cEntEmixDocId() ) ;
        setQueryArgument( "cPaisEmsDocApt", movdep().cPaisEmsDocApt() ) ;
        setQueryArgument( "cTipoDocIdAptd", movdep().cTipoDocIdAptd() ) ;
        setQueryArgument( "nDocIdAptd", movdep().nDocIdAptd() ) ;
        setQueryArgument( "zVldeDocIdAptd", movdep().zVldeDocIdAptd(), java.sql.Date.class ) ;
        setQueryArgument( "cEntEmiDidAptd", movdep().cEntEmiDidAptd() ) ;
        setQueryArgument( "cPaisEmsDocRpt", movdep().cPaisEmsDocRpt() ) ;
        setQueryArgument( "cTipoDocIdRprt", movdep().cTipoDocIdRprt() ) ;
        setQueryArgument( "nDocIdRprt", movdep().nDocIdRprt() ) ;
        setQueryArgument( "zVldeDocIdRprt", movdep().zVldeDocIdRprt(), java.sql.Date.class ) ;
        setQueryArgument( "cEntEmixDidRpt", movdep().cEntEmixDidRpt() ) ;
        setQueryArgument( "nmCliente", movdep().nmCliente() ) ;
        setQueryArgument( "iCliCgd", movdep().iCliCgd() ) ;
        setQueryArgument( "iRprtCliCgd", movdep().iRprtCliCgd() ) ;
        setQueryArgument( "cTipoItvtDep", movdep().cTipoItvtDep() ) ;
        setQueryArgument( "cTipoMdti", movdep().cTipoMdti() ) ;
        setQueryArgument( "zMovimento", movdep().zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "mMovEuro", movdep().mMovEuro() ) ;
        setQueryArgument( "cTipoCanlAces", movdep().cTipoCanlAces() ) ;
        setQueryArgument( "cTipoOpeCont", movdep().cTipoOpeCont() ) ;
        setQueryArgument( "iTrnzEfcdOnln", movdep().iTrnzEfcdOnln() ) ;
        setQueryArgument( "iPedJstzOrmFnd", movdep().iPedJstzOrmFnd() ) ;
        setQueryArgument( "cMtvoPedJstz", movdep().cMtvoPedJstz() ) ;
        setQueryArgument( "iRcsJstzOrmFnd", movdep().iRcsJstzOrmFnd() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        setQueryArgument( "qMoeda", movdep().qMoeda() ) ;
        setQueryArgument( "cTipoRelDpst", movdep().cTipoRelDpst() ) ;
        setQueryArgument( "xInfJstzDep", movdep().xInfJstzDep() ) ;
        setQueryArgument( "cUsidActzUlt", movdep().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_CONTA_2_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4808(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PAIS_ISO_ALFN = ' ' AND " +
                "C_MNEM_EMP_GCX = ' ' AND " +
                "C_REF_MSG_SWIF = ' ' AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_CONTA_2_ASC", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pAde.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pAde.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pAde.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pAde.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pAde.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pAde.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pAde.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pAde.nsDeposito() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_CONTA_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4812(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "N_CHEQUE = :nCheque AND " +
                "C_PAIS_ISO_ALFN = ' ' AND " +
                "C_MNEM_EMP_GCX = ' ' AND " +
                "C_REF_MSG_SWIF = ' ' AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_CONTA_ASC", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pAde.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pAde.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pAde.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pAde.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pAde.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pAde.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pAde.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pAde.nsDeposito() ) ;
        c.setArgument( "nCheque", pAde.nCheque() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_CONTA_2_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4820(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PAIS_ISO_ALFN = ' ' AND " +
                "C_MNEM_EMP_GCX = ' ' AND " +
                "C_REF_MSG_SWIF = ' ' AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_CONTA_2_DESC", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pAde.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pAde.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pAde.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pAde.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pAde.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pAde.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pAde.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pAde.nsDeposito() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_CONTA_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4824(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "N_CHEQUE = :nCheque AND " +
                "C_PAIS_ISO_ALFN = ' ' AND " +
                "C_MNEM_EMP_GCX = ' ' AND " +
                "C_REF_MSG_SWIF = ' ' AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_CONTA_DESC", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pAde.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pAde.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pAde.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pAde.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pAde.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pAde.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pAde.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pAde.nsDeposito() ) ;
        c.setArgument( "nCheque", pAde.nCheque() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_CLIENTE_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pWsDocCliLinha
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4882(WsDocCliLinha pWsDocCliLinha, Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "((C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc1 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId1 AND " +
                "N_DOC_ID = :wsNDocId1) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc2 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId2 AND " +
                "N_DOC_ID = :wsNDocId2) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc3 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId3 AND " +
                "N_DOC_ID = :wsNDocId3) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc4 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId4 AND " +
                "N_DOC_ID = :wsNDocId4) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc5 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId5 AND " +
                "N_DOC_ID = :wsNDocId5) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc6 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId6 AND " +
                "N_DOC_ID = :wsNDocId6) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc7 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId7 AND " +
                "N_DOC_ID = :wsNDocId7) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc8 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId8 AND " +
                "N_DOC_ID = :wsNDocId8) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc9 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId9 AND " +
                "N_DOC_ID = :wsNDocId9) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc10 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId10 AND " +
                "N_DOC_ID = :wsNDocId10) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc11 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId11 AND " +
                "N_DOC_ID = :wsNDocId11) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc12 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId12 AND " +
                "N_DOC_ID = :wsNDocId12) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc13 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId13 AND " +
                "N_DOC_ID = :wsNDocId13) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc14 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId14 AND " +
                "N_DOC_ID = :wsNDocId14)) AND " +
                "C_PAIS_ISA_EMS_DOC <> ' ' AND " +
                "C_TIPO_DOC_ID <> ' ' AND " +
                "N_DOC_ID <> ' ' AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_CLIENTE_ASC", sqlSttmt) ;
        c.setArgument( "wsCPaisIsaEmsDoc1", pWsDocCliLinha.wsCPaisIsaEmsDoc1() ) ;
        c.setArgument( "wsCTipoDocId1", pWsDocCliLinha.wsCTipoDocId1() ) ;
        c.setArgument( "wsNDocId1", pWsDocCliLinha.wsNDocId1() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc2", pWsDocCliLinha.wsCPaisIsaEmsDoc2() ) ;
        c.setArgument( "wsCTipoDocId2", pWsDocCliLinha.wsCTipoDocId2() ) ;
        c.setArgument( "wsNDocId2", pWsDocCliLinha.wsNDocId2() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc3", pWsDocCliLinha.wsCPaisIsaEmsDoc3() ) ;
        c.setArgument( "wsCTipoDocId3", pWsDocCliLinha.wsCTipoDocId3() ) ;
        c.setArgument( "wsNDocId3", pWsDocCliLinha.wsNDocId3() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc4", pWsDocCliLinha.wsCPaisIsaEmsDoc4() ) ;
        c.setArgument( "wsCTipoDocId4", pWsDocCliLinha.wsCTipoDocId4() ) ;
        c.setArgument( "wsNDocId4", pWsDocCliLinha.wsNDocId4() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc5", pWsDocCliLinha.wsCPaisIsaEmsDoc5() ) ;
        c.setArgument( "wsCTipoDocId5", pWsDocCliLinha.wsCTipoDocId5() ) ;
        c.setArgument( "wsNDocId5", pWsDocCliLinha.wsNDocId5() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc6", pWsDocCliLinha.wsCPaisIsaEmsDoc6() ) ;
        c.setArgument( "wsCTipoDocId6", pWsDocCliLinha.wsCTipoDocId6() ) ;
        c.setArgument( "wsNDocId6", pWsDocCliLinha.wsNDocId6() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc7", pWsDocCliLinha.wsCPaisIsaEmsDoc7() ) ;
        c.setArgument( "wsCTipoDocId7", pWsDocCliLinha.wsCTipoDocId7() ) ;
        c.setArgument( "wsNDocId7", pWsDocCliLinha.wsNDocId7() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc8", pWsDocCliLinha.wsCPaisIsaEmsDoc8() ) ;
        c.setArgument( "wsCTipoDocId8", pWsDocCliLinha.wsCTipoDocId8() ) ;
        c.setArgument( "wsNDocId8", pWsDocCliLinha.wsNDocId8() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc9", pWsDocCliLinha.wsCPaisIsaEmsDoc9() ) ;
        c.setArgument( "wsCTipoDocId9", pWsDocCliLinha.wsCTipoDocId9() ) ;
        c.setArgument( "wsNDocId9", pWsDocCliLinha.wsNDocId9() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc10", pWsDocCliLinha.wsCPaisIsaEmsDoc10() ) ;
        c.setArgument( "wsCTipoDocId10", pWsDocCliLinha.wsCTipoDocId10() ) ;
        c.setArgument( "wsNDocId10", pWsDocCliLinha.wsNDocId10() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc11", pWsDocCliLinha.wsCPaisIsaEmsDoc11() ) ;
        c.setArgument( "wsCTipoDocId11", pWsDocCliLinha.wsCTipoDocId11() ) ;
        c.setArgument( "wsNDocId11", pWsDocCliLinha.wsNDocId11() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc12", pWsDocCliLinha.wsCPaisIsaEmsDoc12() ) ;
        c.setArgument( "wsCTipoDocId12", pWsDocCliLinha.wsCTipoDocId12() ) ;
        c.setArgument( "wsNDocId12", pWsDocCliLinha.wsNDocId12() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc13", pWsDocCliLinha.wsCPaisIsaEmsDoc13() ) ;
        c.setArgument( "wsCTipoDocId13", pWsDocCliLinha.wsCTipoDocId13() ) ;
        c.setArgument( "wsNDocId13", pWsDocCliLinha.wsNDocId13() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc14", pWsDocCliLinha.wsCPaisIsaEmsDoc14() ) ;
        c.setArgument( "wsCTipoDocId14", pWsDocCliLinha.wsCTipoDocId14() ) ;
        c.setArgument( "wsNDocId14", pWsDocCliLinha.wsNDocId14() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_CLIENTE_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pWsDocCliLinha
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4888(WsDocCliLinha pWsDocCliLinha, Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "((C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc1 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId1 AND " +
                "N_DOC_ID = :wsNDocId1) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc2 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId2 AND " +
                "N_DOC_ID = :wsNDocId2) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc3 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId3 AND " +
                "N_DOC_ID = :wsNDocId3) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc4 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId4 AND " +
                "N_DOC_ID = :wsNDocId4) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc5 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId5 AND " +
                "N_DOC_ID = :wsNDocId5) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc6 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId6 AND " +
                "N_DOC_ID = :wsNDocId6) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc7 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId7 AND " +
                "N_DOC_ID = :wsNDocId7) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc8 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId8 AND " +
                "N_DOC_ID = :wsNDocId8) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc9 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId9 AND " +
                "N_DOC_ID = :wsNDocId9) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc10 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId10 AND " +
                "N_DOC_ID = :wsNDocId10) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc11 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId11 AND " +
                "N_DOC_ID = :wsNDocId11) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc12 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId12 AND " +
                "N_DOC_ID = :wsNDocId12) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc13 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId13 AND " +
                "N_DOC_ID = :wsNDocId13) OR " +
                "(C_PAIS_ISA_EMS_DOC = :wsCPaisIsaEmsDoc14 AND " +
                "C_TIPO_DOC_ID = :wsCTipoDocId14 AND " +
                "N_DOC_ID = :wsNDocId14)) AND " +
                "C_PAIS_ISA_EMS_DOC <> ' ' AND " +
                "C_TIPO_DOC_ID <> ' ' AND " +
                "N_DOC_ID <> ' ' AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_CLIENTE_DESC", sqlSttmt) ;
        c.setArgument( "wsCPaisIsaEmsDoc1", pWsDocCliLinha.wsCPaisIsaEmsDoc1() ) ;
        c.setArgument( "wsCTipoDocId1", pWsDocCliLinha.wsCTipoDocId1() ) ;
        c.setArgument( "wsNDocId1", pWsDocCliLinha.wsNDocId1() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc2", pWsDocCliLinha.wsCPaisIsaEmsDoc2() ) ;
        c.setArgument( "wsCTipoDocId2", pWsDocCliLinha.wsCTipoDocId2() ) ;
        c.setArgument( "wsNDocId2", pWsDocCliLinha.wsNDocId2() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc3", pWsDocCliLinha.wsCPaisIsaEmsDoc3() ) ;
        c.setArgument( "wsCTipoDocId3", pWsDocCliLinha.wsCTipoDocId3() ) ;
        c.setArgument( "wsNDocId3", pWsDocCliLinha.wsNDocId3() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc4", pWsDocCliLinha.wsCPaisIsaEmsDoc4() ) ;
        c.setArgument( "wsCTipoDocId4", pWsDocCliLinha.wsCTipoDocId4() ) ;
        c.setArgument( "wsNDocId4", pWsDocCliLinha.wsNDocId4() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc5", pWsDocCliLinha.wsCPaisIsaEmsDoc5() ) ;
        c.setArgument( "wsCTipoDocId5", pWsDocCliLinha.wsCTipoDocId5() ) ;
        c.setArgument( "wsNDocId5", pWsDocCliLinha.wsNDocId5() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc6", pWsDocCliLinha.wsCPaisIsaEmsDoc6() ) ;
        c.setArgument( "wsCTipoDocId6", pWsDocCliLinha.wsCTipoDocId6() ) ;
        c.setArgument( "wsNDocId6", pWsDocCliLinha.wsNDocId6() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc7", pWsDocCliLinha.wsCPaisIsaEmsDoc7() ) ;
        c.setArgument( "wsCTipoDocId7", pWsDocCliLinha.wsCTipoDocId7() ) ;
        c.setArgument( "wsNDocId7", pWsDocCliLinha.wsNDocId7() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc8", pWsDocCliLinha.wsCPaisIsaEmsDoc8() ) ;
        c.setArgument( "wsCTipoDocId8", pWsDocCliLinha.wsCTipoDocId8() ) ;
        c.setArgument( "wsNDocId8", pWsDocCliLinha.wsNDocId8() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc9", pWsDocCliLinha.wsCPaisIsaEmsDoc9() ) ;
        c.setArgument( "wsCTipoDocId9", pWsDocCliLinha.wsCTipoDocId9() ) ;
        c.setArgument( "wsNDocId9", pWsDocCliLinha.wsNDocId9() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc10", pWsDocCliLinha.wsCPaisIsaEmsDoc10() ) ;
        c.setArgument( "wsCTipoDocId10", pWsDocCliLinha.wsCTipoDocId10() ) ;
        c.setArgument( "wsNDocId10", pWsDocCliLinha.wsNDocId10() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc11", pWsDocCliLinha.wsCPaisIsaEmsDoc11() ) ;
        c.setArgument( "wsCTipoDocId11", pWsDocCliLinha.wsCTipoDocId11() ) ;
        c.setArgument( "wsNDocId11", pWsDocCliLinha.wsNDocId11() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc12", pWsDocCliLinha.wsCPaisIsaEmsDoc12() ) ;
        c.setArgument( "wsCTipoDocId12", pWsDocCliLinha.wsCTipoDocId12() ) ;
        c.setArgument( "wsNDocId12", pWsDocCliLinha.wsNDocId12() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc13", pWsDocCliLinha.wsCPaisIsaEmsDoc13() ) ;
        c.setArgument( "wsCTipoDocId13", pWsDocCliLinha.wsCTipoDocId13() ) ;
        c.setArgument( "wsNDocId13", pWsDocCliLinha.wsNDocId13() ) ;
        c.setArgument( "wsCPaisIsaEmsDoc14", pWsDocCliLinha.wsCPaisIsaEmsDoc14() ) ;
        c.setArgument( "wsCTipoDocId14", pWsDocCliLinha.wsCTipoDocId14() ) ;
        c.setArgument( "wsNDocId14", pWsDocCliLinha.wsNDocId14() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_DOC_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4896(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISA_EMS_DOC = :cPaisIsaEmsDoc AND " +
                "C_TIPO_DOC_ID = :cTipoDocId AND " +
                "N_DOC_ID = :nDocId AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_DOC_ASC", sqlSttmt) ;
        c.setArgument( "cPaisIsaEmsDoc", pAde.cPaisIsaEmsDoc() ) ;
        c.setArgument( "cTipoDocId", pAde.cTipoDocId() ) ;
        c.setArgument( "nDocId", pAde.nDocId() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_DOC_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4902(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISA_EMS_DOC = :cPaisIsaEmsDoc AND " +
                "C_TIPO_DOC_ID = :cTipoDocId AND " +
                "N_DOC_ID = :nDocId AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_DOC_DESC", sqlSttmt) ;
        c.setArgument( "cPaisIsaEmsDoc", pAde.cPaisIsaEmsDoc() ) ;
        c.setArgument( "cTipoDocId", pAde.cTipoDocId() ) ;
        c.setArgument( "nDocId", pAde.nDocId() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_NOME_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4909(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "NM_CLIENTE = :nmCliCompl AND Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_NOME_ASC", sqlSttmt) ;
        c.setArgument( "nmCliCompl", pAde.nmCliCompl() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_NOME_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4915(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "NM_CLIENTE = :nmCliCompl AND Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_NOME_DESC", sqlSttmt) ;
        c.setArgument( "nmCliCompl", pAde.nmCliCompl() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_ORDEM_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4922(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISO_ALFN = :cPaisIsoAlfn AND " +
                "C_MNEM_EMP_GCX = :cMnemEmpGcx AND " +
                "C_REF_MSG_SWIF = :cRefMsgSwif AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_ORDEM_ASC", sqlSttmt) ;
        c.setArgument( "cPaisIsoAlfn", pAde.cPaisIsoAlfn() ) ;
        c.setArgument( "cMnemEmpGcx", pAde.cMnemEmpGcx() ) ;
        c.setArgument( "cRefMsgSwif", pAde.cRefMsgSwif() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_ORDEM_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4928(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISO_ALFN = :cPaisIsoAlfn AND " +
                "C_MNEM_EMP_GCX = :cMnemEmpGcx AND " +
                "C_REF_MSG_SWIF = :cRefMsgSwif AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "M_MOV_EURO >= :mMovNmriMin AND " +
                "M_MOV_EURO <= :mMovNmriMax AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_ORDEM_DESC", sqlSttmt) ;
        c.setArgument( "cPaisIsoAlfn", pAde.cPaisIsoAlfn() ) ;
        c.setArgument( "cMnemEmpGcx", pAde.cMnemEmpGcx() ) ;
        c.setArgument( "cRefMsgSwif", pAde.cRefMsgSwif() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_MONT_ASC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4935(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "M_MOV_EURO >= :mMovNmriMin AND M_MOV_EURO <= :mMovNmriMax AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "TS_INSERCAO >= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO ASC" ;
        BaseCursorHandler c = addCursor("CRS_MONT_ASC", sqlSttmt) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_MONT_DESC
     * called from Pghs141a.M2100AbrirCursorM2100AbrirCursor
     * 
     * @param pAde
     * @param pWsCTipoOpeCont1
     * @param pWsCTipoOpeCont2
     * @param pWsCTipoOpeCont3
     * @param pWsCTipoOpeCont4
     * @param pWsCTipoOpeCont5
     * @param pWsCTipoOpeCont6
     * @param pWsCTipoOpeCont7
     * @param pWsICliCgd1
     * @param pWsICliCgd2
     * @param pWsCTipoItvtDep1
     * @param pWsCTipoItvtDep2
     * @param pWsCTipoItvtDep3
     * @param pWsCTipoItvtDep4
     * @param pWsCTipoItvtDep5
     * @param pWsCTipoItvtDep6
     * @param pWsCTipoItvtDep7
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsCrit3
     */
    public void openPghs141a4941(Ade pAde, IString pWsCTipoOpeCont1, IString pWsCTipoOpeCont2, IString pWsCTipoOpeCont3, IString pWsCTipoOpeCont4, IString pWsCTipoOpeCont5, IString pWsCTipoOpeCont6, IString pWsCTipoOpeCont7, IString pWsICliCgd1, IString pWsICliCgd2, IString pWsCTipoItvtDep1, IString pWsCTipoItvtDep2, IString pWsCTipoItvtDep3, IString pWsCTipoItvtDep4, IString pWsCTipoItvtDep5, IString pWsCTipoItvtDep6, IString pWsCTipoItvtDep7, IString pWsCrit1, IString pWsCrit2, IString pWsCrit3) {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "Q_MOEDA," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "M_MOV_EURO >= :mMovNmriMin AND M_MOV_EURO <= :mMovNmriMax AND " +
                "Z_MOVIMENTO >= :zMovimentoMin AND " +
                "Z_MOVIMENTO <= :zMovimentoMax AND " +
                "(C_TIPO_OPE_CONT = :wsCTipoOpeCont1 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont2 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont3 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont4 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont5 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont6 OR " +
                "C_TIPO_OPE_CONT = :wsCTipoOpeCont7) AND " +
                "(I_CLI_CGD = :wsICliCgd1 OR I_CLI_CGD = :wsICliCgd2) AND " +
                "(C_TIPO_ITVT_DEP = :wsCTipoItvtDep1 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep2 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep3 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep4 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep5 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep6 OR " +
                "C_TIPO_ITVT_DEP = :wsCTipoItvtDep7) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2 OR I_DBCR = :wsCrit3) AND " +
                "TS_INSERCAO <= :tsInsercao" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        BaseCursorHandler c = addCursor("CRS_MONT_DESC", sqlSttmt) ;
        c.setArgument( "mMovNmriMin", pAde.mMovNmriMin() ) ;
        c.setArgument( "mMovNmriMax", pAde.mMovNmriMax() ) ;
        c.setArgument( "zMovimentoMin", pAde.zMovimentoMin(), java.sql.Date.class ) ;
        c.setArgument( "zMovimentoMax", pAde.zMovimentoMax(), java.sql.Date.class ) ;
        c.setArgument( "wsCTipoOpeCont1", pWsCTipoOpeCont1 ) ;
        c.setArgument( "wsCTipoOpeCont2", pWsCTipoOpeCont2 ) ;
        c.setArgument( "wsCTipoOpeCont3", pWsCTipoOpeCont3 ) ;
        c.setArgument( "wsCTipoOpeCont4", pWsCTipoOpeCont4 ) ;
        c.setArgument( "wsCTipoOpeCont5", pWsCTipoOpeCont5 ) ;
        c.setArgument( "wsCTipoOpeCont6", pWsCTipoOpeCont6 ) ;
        c.setArgument( "wsCTipoOpeCont7", pWsCTipoOpeCont7 ) ;
        c.setArgument( "wsICliCgd1", pWsICliCgd1 ) ;
        c.setArgument( "wsICliCgd2", pWsICliCgd2 ) ;
        c.setArgument( "wsCTipoItvtDep1", pWsCTipoItvtDep1 ) ;
        c.setArgument( "wsCTipoItvtDep2", pWsCTipoItvtDep2 ) ;
        c.setArgument( "wsCTipoItvtDep3", pWsCTipoItvtDep3 ) ;
        c.setArgument( "wsCTipoItvtDep4", pWsCTipoItvtDep4 ) ;
        c.setArgument( "wsCTipoItvtDep5", pWsCTipoItvtDep5 ) ;
        c.setArgument( "wsCTipoItvtDep6", pWsCTipoItvtDep6 ) ;
        c.setArgument( "wsCTipoItvtDep7", pWsCTipoItvtDep7 ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsCrit3", pWsCrit3 ) ;
        c.setArgument( "tsInsercao", movdep().tsInsercao(), java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs121a.M2200ValidaMovDepM2200ValidaMovDep
     * 
     */
    public void selectPghs121a689() {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "C_TIPO_REL_DPST," +
                "X_INF_JSTZ_DEP," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", movdep().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdep().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdep().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdep().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdep().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdep().nJourBbn() ) ;
        setQueryArgument( "cPaisIsoaCont", movdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdep().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdep().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(getQueryReturnedValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(getQueryReturnedValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(getQueryReturnedValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(getQueryReturnedValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(getQueryReturnedValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(getQueryReturnedValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(getQueryReturnedValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(getQueryReturnedValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(getQueryReturnedValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(getQueryReturnedValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(getQueryReturnedValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(getQueryReturnedValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(getQueryReturnedValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(getQueryReturnedValue("C_ENT_EMI_DID_APTD")) ;
            movdep().nmCliente().set(getQueryReturnedValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(getQueryReturnedValue("I_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(getQueryReturnedValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(getQueryReturnedValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movdep().mMovEuro().set(getQueryReturnedValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(getQueryReturnedValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(getQueryReturnedValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(getQueryReturnedValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(getQueryReturnedValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(getQueryReturnedValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movdep().cTipoRelDpst().set(getQueryReturnedValue("C_TIPO_REL_DPST")) ;
            movdep().xInfJstzDep().set(getQueryReturnedValue("X_INF_JSTZ_DEP", String.class)) ;
            movdep().tsInsercao().set(getQueryReturnedValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs133a.M2110AcumItvtOpeM2110AcumItvtOpe
     * 
     * @param pWsMtItvtOpe
     */
    public void selectPghs133a3622(IDecimal pWsMtItvtOpe) {
        sqlSttmt = "SELECT  " +
                "SUM(M_MOV_EURO)" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISA_EMS_DOC = :cPaisIsaEmsDoc AND " +
                "C_TIPO_DOC_ID = :cTipoDocId AND " +
                "N_DOC_ID = :nDocId AND " +
                "Z_MOVIMENTO = :zMovimento AND " +
                "I_DBCR = :iDbcr AND " +
                "I_ESTORNO = :iEstorno" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsaEmsDoc", movdep().cPaisIsaEmsDoc() ) ;
        setQueryArgument( "cTipoDocId", movdep().cTipoDocId() ) ;
        setQueryArgument( "nDocId", movdep().nDocId() ) ;
        setQueryArgument( "zMovimento", movdep().zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsMtItvtOpe.set(getQueryReturnedDecimal(1)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs133a.M2120AcumContaM2120AcumConta
     * 
     * @param pWsMtConta
     */
    public void selectPghs133a3701(IDecimal pWsMtConta) {
        sqlSttmt = "SELECT  " +
                "SUM(M_MOV_EURO)" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_MOVIMENTO = :zMovimento AND " +
                "I_DBCR = :iDbcr AND " +
                "I_ESTORNO = :iEstorno" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdep().nsDeposito() ) ;
        setQueryArgument( "zMovimento", movdep().zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsMtConta.set(getQueryReturnedDecimal(1)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs151a.M2100ValidaMovDepM2100ValidaMovDep
     * 
     */
    public void selectPghs151a470() {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PAIS_ISO_ALFN," +
                "C_MNEM_EMP_GCX," +
                "C_REF_MSG_SWIF," +
                "C_EST_MSG_SWIF," +
                "N_CHEQUE," +
                "C_PAIS_ISA_EMS_DOC," +
                "C_TIPO_DOC_ID," +
                "N_DOC_ID," +
                "Z_VLDE_DOC_ID," +
                "C_ENT_EMIX_DOC_ID," +
                "C_PAIS_EMS_DOC_APT," +
                "C_TIPO_DOC_ID_APTD," +
                "N_DOC_ID_APTD," +
                "Z_VLDE_DOC_ID_APTD," +
                "C_ENT_EMI_DID_APTD," +
                "C_PAIS_EMS_DOC_RPT," +
                "C_TIPO_DOC_ID_RPRT," +
                "N_DOC_ID_RPRT," +
                "Z_VLDE_DOC_ID_RPRT," +
                "C_ENT_EMIX_DID_RPT," +
                "NM_CLIENTE," +
                "I_CLI_CGD," +
                "I_RPRT_CLI_CGD," +
                "C_TIPO_ITVT_DEP," +
                "C_TIPO_MDTI," +
                "Z_MOVIMENTO," +
                "I_DBCR," +
                "M_MOV_EURO," +
                "C_TIPO_CANL_ACES," +
                "C_TIPO_OPE_CONT," +
                "I_TRNZ_EFCD_ONLN," +
                "I_PED_JSTZ_ORM_FND," +
                "C_MTVO_PED_JSTZ," +
                "I_RCS_JSTZ_ORM_FND," +
                "I_ESTORNO," +
                "TS_INSERCAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISO_ALFN = :cPaisIsoAlfn AND " +
                "C_MNEM_EMP_GCX = :cMnemEmpGcx AND " +
                "C_REF_MSG_SWIF = :cRefMsgSwif AND " +
                "C_TIPO_OPE_CONT = :cTipoOpeCont" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoAlfn", movdep().cPaisIsoAlfn() ) ;
        setQueryArgument( "cMnemEmpGcx", movdep().cMnemEmpGcx() ) ;
        setQueryArgument( "cRefMsgSwif", movdep().cRefMsgSwif() ) ;
        setQueryArgument( "cTipoOpeCont", movdep().cTipoOpeCont() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            movdep().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdep().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdep().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdep().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdep().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdep().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movdep().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movdep().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movdep().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movdep().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movdep().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movdep().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movdep().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movdep().cPaisIsoAlfn().set(getQueryReturnedValue("C_PAIS_ISO_ALFN")) ;
            movdep().cMnemEmpGcx().set(getQueryReturnedValue("C_MNEM_EMP_GCX")) ;
            movdep().cRefMsgSwif().set(getQueryReturnedValue("C_REF_MSG_SWIF")) ;
            movdep().cEstMsgSwif().set(getQueryReturnedValue("C_EST_MSG_SWIF")) ;
            movdep().nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            movdep().cPaisIsaEmsDoc().set(getQueryReturnedValue("C_PAIS_ISA_EMS_DOC")) ;
            movdep().cTipoDocId().set(getQueryReturnedValue("C_TIPO_DOC_ID")) ;
            movdep().nDocId().set(getQueryReturnedValue("N_DOC_ID")) ;
            movdep().zVldeDocId().set(getQueryReturnedValue("Z_VLDE_DOC_ID", String.class)) ;
            movdep().cEntEmixDocId().set(getQueryReturnedValue("C_ENT_EMIX_DOC_ID")) ;
            movdep().cPaisEmsDocApt().set(getQueryReturnedValue("C_PAIS_EMS_DOC_APT")) ;
            movdep().cTipoDocIdAptd().set(getQueryReturnedValue("C_TIPO_DOC_ID_APTD")) ;
            movdep().nDocIdAptd().set(getQueryReturnedValue("N_DOC_ID_APTD")) ;
            movdep().zVldeDocIdAptd().set(getQueryReturnedValue("Z_VLDE_DOC_ID_APTD", String.class)) ;
            movdep().cEntEmiDidAptd().set(getQueryReturnedValue("C_ENT_EMI_DID_APTD")) ;
            movdep().cPaisEmsDocRpt().set(getQueryReturnedValue("C_PAIS_EMS_DOC_RPT")) ;
            movdep().cTipoDocIdRprt().set(getQueryReturnedValue("C_TIPO_DOC_ID_RPRT")) ;
            movdep().nDocIdRprt().set(getQueryReturnedValue("N_DOC_ID_RPRT")) ;
            movdep().zVldeDocIdRprt().set(getQueryReturnedValue("Z_VLDE_DOC_ID_RPRT", String.class)) ;
            movdep().cEntEmixDidRpt().set(getQueryReturnedValue("C_ENT_EMIX_DID_RPT")) ;
            movdep().nmCliente().set(getQueryReturnedValue("NM_CLIENTE")) ;
            movdep().iCliCgd().set(getQueryReturnedValue("I_CLI_CGD")) ;
            movdep().iRprtCliCgd().set(getQueryReturnedValue("I_RPRT_CLI_CGD")) ;
            movdep().cTipoItvtDep().set(getQueryReturnedValue("C_TIPO_ITVT_DEP")) ;
            movdep().cTipoMdti().set(getQueryReturnedValue("C_TIPO_MDTI")) ;
            movdep().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            movdep().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movdep().mMovEuro().set(getQueryReturnedValue("M_MOV_EURO")) ;
            movdep().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movdep().cTipoOpeCont().set(getQueryReturnedValue("C_TIPO_OPE_CONT")) ;
            movdep().iTrnzEfcdOnln().set(getQueryReturnedValue("I_TRNZ_EFCD_ONLN")) ;
            movdep().iPedJstzOrmFnd().set(getQueryReturnedValue("I_PED_JSTZ_ORM_FND")) ;
            movdep().cMtvoPedJstz().set(getQueryReturnedValue("C_MTVO_PED_JSTZ")) ;
            movdep().iRcsJstzOrmFnd().set(getQueryReturnedValue("I_RCS_JSTZ_ORM_FND")) ;
            movdep().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movdep().tsInsercao().set(getQueryReturnedValue("TS_INSERCAO", String.class)) ;
            movdep().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movdep().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs163a.M2121ApuraUltMovM2121ApuraUltMov
     * 
     */
    public void selectPghs163a3547() {
        sqlSttmt = "SELECT  " +
                "Z_MOVIMENTO" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISA_EMS_DOC = :cPaisIsaEmsDoc AND " +
                "C_TIPO_DOC_ID = :cTipoDocId AND " +
                "N_DOC_ID = :nDocId AND " +
                "I_DBCR = :iDbcr AND " +
                "I_ESTORNO = :iEstorno" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsaEmsDoc", movdep().cPaisIsaEmsDoc() ) ;
        setQueryArgument( "cTipoDocId", movdep().cTipoDocId() ) ;
        setQueryArgument( "nDocId", movdep().nDocId() ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs163a.M2123UltMovJustifM2123UltMovJustif
     * 
     * @param pWsZMovimentoUlt
     * @param pWsZMovimento30
     */
    public void selectPghs163a3650(IString pWsZMovimentoUlt, IString pWsZMovimento30) {
        sqlSttmt = "SELECT  " +
                "Z_MOVIMENTO," +
                "TS_INSERCAO" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISA_EMS_DOC = :cPaisIsaEmsDoc AND " +
                "C_TIPO_DOC_ID = :cTipoDocId AND " +
                "N_DOC_ID = :nDocId AND " +
                "Z_MOVIMENTO <= :wsZMovimentoUlt AND " +
                "Z_MOVIMENTO >= :wsZMovimento30 AND " +
                "I_DBCR = :iDbcr AND " +
                "I_ESTORNO = :iEstorno AND " +
                "I_PED_JSTZ_ORM_FND = :iPedJstzOrmFnd AND " +
                "I_RCS_JSTZ_ORM_FND = :iRcsJstzOrmFnd" +
            " ORDER BY " +
                "TS_INSERCAO DESC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsaEmsDoc", movdep().cPaisIsaEmsDoc() ) ;
        setQueryArgument( "cTipoDocId", movdep().cTipoDocId() ) ;
        setQueryArgument( "nDocId", movdep().nDocId() ) ;
        setQueryArgument( "wsZMovimentoUlt", pWsZMovimentoUlt, java.sql.Date.class ) ;
        setQueryArgument( "wsZMovimento30", pWsZMovimento30, java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        setQueryArgument( "iPedJstzOrmFnd", movdep().iPedJstzOrmFnd() ) ;
        setQueryArgument( "iRcsJstzOrmFnd", movdep().iRcsJstzOrmFnd() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdep().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            movdep().tsInsercao().set(getQueryReturnedValue("TS_INSERCAO", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH13001_MOVDEP
     * called from Pghs163a.M2124SomaMontantesM2124SomaMontantes
     * 
     * @param pWsZMovimentoUlt
     * @param pWsZMovUltJustf
     * @param pWsTsInsUltJustf
     * @param pWsMtItvtOpe
     */
    public void selectPghs163a3737(IString pWsZMovimentoUlt, IString pWsZMovUltJustf, IString pWsTsInsUltJustf, IDecimal pWsMtItvtOpe) {
        sqlSttmt = "SELECT  " +
                "SUM(M_MOV_EURO)" +
            " FROM VWSDGHPS13001_MOVDEP" +
            " WHERE " +
                "C_PAIS_ISA_EMS_DOC = :cPaisIsaEmsDoc AND " +
                "C_TIPO_DOC_ID = :cTipoDocId AND " +
                "N_DOC_ID = :nDocId AND " +
                "Z_MOVIMENTO <= :wsZMovimentoUlt AND " +
                "Z_MOVIMENTO >= :wsZMovUltJustf AND " +
                "TS_INSERCAO > :wsTsInsUltJustf AND " +
                "I_DBCR = :iDbcr AND " +
                "I_ESTORNO = :iEstorno" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsaEmsDoc", movdep().cPaisIsaEmsDoc() ) ;
        setQueryArgument( "cTipoDocId", movdep().cTipoDocId() ) ;
        setQueryArgument( "nDocId", movdep().nDocId() ) ;
        setQueryArgument( "wsZMovimentoUlt", pWsZMovimentoUlt, java.sql.Date.class ) ;
        setQueryArgument( "wsZMovUltJustf", pWsZMovUltJustf, java.sql.Date.class ) ;
        setQueryArgument( "wsTsInsUltJustf", pWsTsInsUltJustf, java.sql.Timestamp.class ) ;
        setQueryArgument( "iDbcr", movdep().iDbcr() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsMtItvtOpe.set(getQueryReturnedDecimal(1)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH13001_MOVDEP
     * called from Pghs133a.M2500EstornoM2500Estorno
     * 
     */
    public void updatePghs133a5438() {
        sqlSttmt = "UPDATE VWSDGHPS13001_MOVDEP " +
            "SET I_ESTORNO = :iEstorno, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", movdep().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdep().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdep().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdep().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdep().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdep().nJourBbn() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        setQueryArgument( "cUsidActzUlt", movdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH13001_MOVDEP
     * called from Pghs163a.M2300EstornoJournalM2300EstornoJournal
     * 
     */
    public void updatePghs163a4886() {
        sqlSttmt = "UPDATE VWSDGHPS13001_MOVDEP " +
            "SET I_ESTORNO = :iEstorno, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", movdep().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdep().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdep().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdep().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdep().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdep().nJourBbn() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        setQueryArgument( "cUsidActzUlt", movdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH13001_MOVDEP
     * called from Pghs163a.M2400EstorAnulRefM2400EstorAnulRef
     * 
     */
    public void updatePghs163a4973() {
        sqlSttmt = "UPDATE VWSDGHPS13001_MOVDEP " +
            "SET C_EST_MSG_SWIF = :cEstMsgSwif, " +
                "I_ESTORNO = :iEstorno, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISO_ALFN = :cPaisIsoAlfn AND " +
                "C_MNEM_EMP_GCX = :cMnemEmpGcx AND " +
                "C_REF_MSG_SWIF = :cRefMsgSwif" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoAlfn", movdep().cPaisIsoAlfn() ) ;
        setQueryArgument( "cMnemEmpGcx", movdep().cMnemEmpGcx() ) ;
        setQueryArgument( "cRefMsgSwif", movdep().cRefMsgSwif() ) ;
        setQueryArgument( "cEstMsgSwif", movdep().cEstMsgSwif() ) ;
        setQueryArgument( "iEstorno", movdep().iEstorno() ) ;
        setQueryArgument( "cUsidActzUlt", movdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH13001_MOVDEP
     * called from Mghj300a.M2300UpdEstOrdem130M2300UpdEstOrdem130
     * 
     */
    public void updateMghj300a446() {
        sqlSttmt = "UPDATE VWSDGHPS13001_MOVDEP " +
            "SET C_EST_MSG_SWIF = :cEstMsgSwif, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISO_ALFN = :cPaisIsoAlfn AND " +
                "C_MNEM_EMP_GCX = :cMnemEmpGcx AND " +
                "C_REF_MSG_SWIF = :cRefMsgSwif AND " +
                "C_TIPO_OPE_CONT = :cTipoOpeCont" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoAlfn", movdep().cPaisIsoAlfn() ) ;
        setQueryArgument( "cMnemEmpGcx", movdep().cMnemEmpGcx() ) ;
        setQueryArgument( "cRefMsgSwif", movdep().cRefMsgSwif() ) ;
        setQueryArgument( "cTipoOpeCont", movdep().cTipoOpeCont() ) ;
        setQueryArgument( "cEstMsgSwif", movdep().cEstMsgSwif() ) ;
        setQueryArgument( "cUsidActzUlt", movdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
}
