package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.persistence.relational.annotations.Key ;
import morphis.framework.persistence.relational.annotations.Column ;
import morphis.framework.persistence.relational.BaseTableHandler ;
import morphis.framework.persistence.relational.BaseCursorHandler ;
import morphis.framework.exceptions.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdhops00101Contas extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Contas
     */
    @Data
    public abstract Contas contas() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO00101_CONTAS
     * 
     * @version 2.0
     * 
     */
    public interface Contas extends IDataStruct {
        
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
         * C_FAMI_PROD
         */
        @Column(name="C_FAMI_PROD")
        @Data(size=3)
        IString cFamiProd() ;
        
        /**
         * C_TIPO_TRTT_CONT
         */
        @Column(name="C_TIPO_TRTT_CONT")
        @Data(size=2)
        IString cTipoTrttCont() ;
        
        /**
         * C_PAIS_ISOA_GERX
         */
        @Column(name="C_PAIS_ISOA_GERX")
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        /**
         * C_BANC_GCX_GERX
         */
        @Column(name="C_BANC_GCX_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        /**
         * C_OE_EGC_GERX
         */
        @Column(name="C_OE_EGC_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        /**
         * C_PAIS_ISOA_ABRA
         */
        @Column(name="C_PAIS_ISOA_ABRA")
        @Data(size=3)
        IString cPaisIsoaAbra() ;
        
        /**
         * C_BANC_ABRA_CONT
         */
        @Column(name="C_BANC_ABRA_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancAbraCont() ;
        
        /**
         * C_OE_EGC_ABRA
         */
        @Column(name="C_OE_EGC_ABRA")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcAbra() ;
        
        /**
         * C_MOED_ISO
         */
        @Column(name="C_MOED_ISO")
        @Data(size=3)
        IString cMoedIso() ;
        
        /**
         * I_EST_CONT
         */
        @Column(name="I_EST_CONT")
        @Data(size=2)
        IString iEstCont() ;
        
        /**
         * C_CNDZ_MOVZ_CONT
         */
        @Column(name="C_CNDZ_MOVZ_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cCndzMovzCont() ;
        
        /**
         * C_SECT_ITTL_BPOR
         */
        @Column(name="C_SECT_ITTL_BPOR")
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        /**
         * Z_ABRA_CONT
         */
        @Column(name="Z_ABRA_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zAbraCont() ;
        
        /**
         * Z_VAL_ABRA_CONT
         */
        @Column(name="Z_VAL_ABRA_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zValAbraCont() ;
        
        /**
         * Z_RABT_CONT_ULT
         */
        @Column(name="Z_RABT_CONT_ULT", type=java.sql.Date.class)
        @Data(size=10)
        IString zRabtContUlt() ;
        
        /**
         * Z_CCLT_CONT
         */
        @Column(name="Z_CCLT_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zCcltCont() ;
        
        /**
         * Z_MGRZ_CONT
         */
        @Column(name="Z_MGRZ_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zMgrzCont() ;
        
        /**
         * I_TIPO_SPTE
         */
        @Column(name="I_TIPO_SPTE")
        @Data(size=1)
        IString iTipoSpte() ;
        
        /**
         * Q_TITC
         */
        @Column(name="Q_TITC")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qTitc() ;
        
        /**
         * Q_TITC_ATIV
         */
        @Column(name="Q_TITC_ATIV")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qTitcAtiv() ;
        
        /**
         * Q_ATRD_ATIV
         */
        @Column(name="Q_ATRD_ATIV")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qAtrdAtiv() ;
        
        /**
         * N_FAX_CTCO
         */
        @Column(name="N_FAX_CTCO")
        @Data(size=15)
        IString nFaxCtco() ;
        
        /**
         * I_ATRZ_ASST_FAX
         */
        @Column(name="I_ATRZ_ASST_FAX")
        @Data(size=1)
        IString iAtrzAsstFax() ;
        
        /**
         * I_INBZ_CHEQ
         */
        @Column(name="I_INBZ_CHEQ")
        @Data(size=1)
        IString iInbzCheq() ;
        
        /**
         * I_EXIS_OBS_CONT
         */
        @Column(name="I_EXIS_OBS_CONT")
        @Data(size=1)
        IString iExisObsCont() ;
        
        /**
         * I_EXIS_CONT_SPTE
         */
        @Column(name="I_EXIS_CONT_SPTE")
        @Data(size=1)
        IString iExisContSpte() ;
        
        /**
         * I_EXIS_CTTO_FISI
         */
        @Column(name="I_EXIS_CTTO_FISI")
        @Data(size=1)
        IString iExisCttoFisi() ;
        
        /**
         * I_EMPS_NOME_IDVL
         */
        @Column(name="I_EMPS_NOME_IDVL")
        @Data(size=1)
        IString iEmpsNomeIdvl() ;
        
        /**
         * I_EXIS_RSTZ_CONT
         */
        @Column(name="I_EXIS_RSTZ_CONT")
        @Data(size=1)
        IString iExisRstzCont() ;
        
        /**
         * I_EXIS_GERX_CONT
         */
        @Column(name="I_EXIS_GERX_CONT")
        @Data(size=1)
        IString iExisGerxCont() ;
        
        /**
         * I_EMS_AVSO_ABR_CTA
         */
        @Column(name="I_EMS_AVSO_ABR_CTA")
        @Data(size=1)
        IString iEmsAvsoAbrCta() ;
        
        /**
         * I_CLSZ_TTR1_CONT
         */
        @Column(name="I_CLSZ_TTR1_CONT")
        @Data(size=1)
        IString iClszTtr1Cont() ;
        
        /**
         * I_OBRG_EXIS_SCTA
         */
        @Column(name="I_OBRG_EXIS_SCTA")
        @Data(size=1)
        IString iObrgExisScta() ;
        
        /**
         * I_OBRG_ETG_JUR_EST
         */
        @Column(name="I_OBRG_ETG_JUR_EST")
        @Data(size=1)
        IString iObrgEtgJurEst() ;
        
        /**
         * Q_ATRZ_DOMZ
         */
        @Column(name="Q_ATRZ_DOMZ")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qAtrzDomz() ;
        
        /**
         * C_PROD_DFLT
         */
        @Column(name="C_PROD_DFLT")
        @Data(size=3)
        IString cProdDflt() ;
        
        /**
         * C_MNEM_EMP_GCX
         */
        @Column(name="C_MNEM_EMP_GCX")
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        /**
         * C_TIPO_CANL_ACES
         */
        @Column(name="C_TIPO_CANL_ACES")
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        /**
         * NS_AVSO_CONT_ULT
         */
        @Column(name="NS_AVSO_CONT_ULT")
        @Data(size=6, signed=true, compression=COMP3)
        IInt nsAvsoContUlt() ;
        
        /**
         * I_ALT_OE_EGC_GERX
         */
        @Column(name="I_ALT_OE_EGC_GERX")
        @Data(size=1)
        IString iAltOeEgcGerx() ;
        
        /**
         * I_ALT_USID_GRX_CTA
         */
        @Column(name="I_ALT_USID_GRX_CTA")
        @Data(size=1)
        IString iAltUsidGrxCta() ;
        
        /**
         * I_IGDE_IR_TITC
         */
        @Column(name="I_IGDE_IR_TITC")
        @Data(size=1)
        IString iIgdeIrTitc() ;
        
        /**
         * I_DCVO_ESPL
         */
        @Column(name="I_DCVO_ESPL")
        @Data(size=1)
        IString iDcvoEspl() ;
        
        /**
         * I_GRAZ_COE
         */
        @Column(name="I_GRAZ_COE")
        @Data(size=1)
        IString iGrazCoe() ;
        
        /**
         * I_EXRT_SWIF
         */
        @Column(name="I_EXRT_SWIF")
        @Data(size=1)
        IString iExrtSwif() ;
        
        /**
         * C_BLQO_CONT
         */
        @Column(name="C_BLQO_CONT")
        @Data(size=1)
        IString cBlqoCont() ;
        
        /**
         * I_EST_CONT_ANT
         */
        @Column(name="I_EST_CONT_ANT")
        @Data(size=2)
        IString iEstContAnt() ;
        
        /**
         * C_SECT_ITTL_BP_ANT
         */
        @Column(name="C_SECT_ITTL_BP_ANT")
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpAnt() ;
        
        /**
         * Z_CTL_SECT_ITTL_BP
         */
        @Column(name="Z_CTL_SECT_ITTL_BP", type=java.sql.Date.class)
        @Data(size=10)
        IString zCtlSectIttlBp() ;
        
        /**
         * Z_ALT_SECT_ITTL_BP
         */
        @Column(name="Z_ALT_SECT_ITTL_BP", type=java.sql.Date.class)
        @Data(size=10)
        IString zAltSectIttlBp() ;
        
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
     * Copybooks
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00101_CONTAS
     * called from Bhop0002SelectRegisto
     * 
     */
    public void selectBhop000255() {
        sqlSttmt = "SELECT  " +
                "C_FAMI_PROD," +
                "C_TIPO_TRTT_CONT," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "C_PAIS_ISOA_ABRA," +
                "C_BANC_ABRA_CONT," +
                "C_OE_EGC_ABRA," +
                "C_MOED_ISO," +
                "I_EST_CONT," +
                "C_CNDZ_MOVZ_CONT," +
                "C_SECT_ITTL_BPOR," +
                "Z_ABRA_CONT," +
                "Z_VAL_ABRA_CONT," +
                "Z_RABT_CONT_ULT," +
                "Z_CCLT_CONT," +
                "Z_MGRZ_CONT," +
                "I_TIPO_SPTE," +
                "Q_TITC," +
                "Q_TITC_ATIV," +
                "Q_ATRD_ATIV," +
                "N_FAX_CTCO," +
                "I_ATRZ_ASST_FAX," +
                "I_INBZ_CHEQ," +
                "I_EXIS_OBS_CONT," +
                "I_EXIS_CONT_SPTE," +
                "I_EXIS_CTTO_FISI," +
                "I_EMPS_NOME_IDVL," +
                "I_EXIS_RSTZ_CONT," +
                "I_EXIS_GERX_CONT," +
                "I_EMS_AVSO_ABR_CTA," +
                "I_CLSZ_TTR1_CONT," +
                "I_OBRG_EXIS_SCTA," +
                "I_OBRG_ETG_JUR_EST," +
                "Q_ATRZ_DOMZ," +
                "C_PROD_DFLT," +
                "C_MNEM_EMP_GCX," +
                "C_TIPO_CANL_ACES," +
                "NS_AVSO_CONT_ULT," +
                "I_ALT_OE_EGC_GERX," +
                "I_ALT_USID_GRX_CTA," +
                "I_IGDE_IR_TITC," +
                "I_DCVO_ESPL," +
                "I_GRAZ_COE," +
                "I_EXRT_SWIF," +
                "C_BLQO_CONT," +
                "I_EST_CONT_ANT," +
                "C_SECT_ITTL_BP_ANT," +
                "Z_CTL_SECT_ITTL_BP," +
                "Z_ALT_SECT_ITTL_BP," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS00101_CONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contas().cTipoCont() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contas().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            contas().cTipoTrttCont().set(getQueryReturnedValue("C_TIPO_TRTT_CONT")) ;
            contas().cPaisIsoaGerx().set(getQueryReturnedValue("C_PAIS_ISOA_GERX")) ;
            contas().cBancGcxGerx().set(getQueryReturnedValue("C_BANC_GCX_GERX")) ;
            contas().cOeEgcGerx().set(getQueryReturnedValue("C_OE_EGC_GERX")) ;
            contas().cPaisIsoaAbra().set(getQueryReturnedValue("C_PAIS_ISOA_ABRA")) ;
            contas().cBancAbraCont().set(getQueryReturnedValue("C_BANC_ABRA_CONT")) ;
            contas().cOeEgcAbra().set(getQueryReturnedValue("C_OE_EGC_ABRA")) ;
            contas().cMoedIso().set(getQueryReturnedValue("C_MOED_ISO")) ;
            contas().iEstCont().set(getQueryReturnedValue("I_EST_CONT")) ;
            contas().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            contas().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            contas().zAbraCont().set(getQueryReturnedValue("Z_ABRA_CONT", String.class)) ;
            contas().zValAbraCont().set(getQueryReturnedValue("Z_VAL_ABRA_CONT", String.class)) ;
            contas().zRabtContUlt().set(getQueryReturnedValue("Z_RABT_CONT_ULT", String.class)) ;
            contas().zCcltCont().set(getQueryReturnedValue("Z_CCLT_CONT", String.class)) ;
            contas().zMgrzCont().set(getQueryReturnedValue("Z_MGRZ_CONT", String.class)) ;
            contas().iTipoSpte().set(getQueryReturnedValue("I_TIPO_SPTE")) ;
            contas().qTitc().set(getQueryReturnedValue("Q_TITC")) ;
            contas().qTitcAtiv().set(getQueryReturnedValue("Q_TITC_ATIV")) ;
            contas().qAtrdAtiv().set(getQueryReturnedValue("Q_ATRD_ATIV")) ;
            contas().nFaxCtco().set(getQueryReturnedValue("N_FAX_CTCO")) ;
            contas().iAtrzAsstFax().set(getQueryReturnedValue("I_ATRZ_ASST_FAX")) ;
            contas().iInbzCheq().set(getQueryReturnedValue("I_INBZ_CHEQ")) ;
            contas().iExisObsCont().set(getQueryReturnedValue("I_EXIS_OBS_CONT")) ;
            contas().iExisContSpte().set(getQueryReturnedValue("I_EXIS_CONT_SPTE")) ;
            contas().iExisCttoFisi().set(getQueryReturnedValue("I_EXIS_CTTO_FISI")) ;
            contas().iEmpsNomeIdvl().set(getQueryReturnedValue("I_EMPS_NOME_IDVL")) ;
            contas().iExisRstzCont().set(getQueryReturnedValue("I_EXIS_RSTZ_CONT")) ;
            contas().iExisGerxCont().set(getQueryReturnedValue("I_EXIS_GERX_CONT")) ;
            contas().iEmsAvsoAbrCta().set(getQueryReturnedValue("I_EMS_AVSO_ABR_CTA")) ;
            contas().iClszTtr1Cont().set(getQueryReturnedValue("I_CLSZ_TTR1_CONT")) ;
            contas().iObrgExisScta().set(getQueryReturnedValue("I_OBRG_EXIS_SCTA")) ;
            contas().iObrgEtgJurEst().set(getQueryReturnedValue("I_OBRG_ETG_JUR_EST")) ;
            contas().qAtrzDomz().set(getQueryReturnedValue("Q_ATRZ_DOMZ")) ;
            contas().cProdDflt().set(getQueryReturnedValue("C_PROD_DFLT")) ;
            contas().cMnemEmpGcx().set(getQueryReturnedValue("C_MNEM_EMP_GCX")) ;
            contas().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            contas().nsAvsoContUlt().set(getQueryReturnedValue("NS_AVSO_CONT_ULT")) ;
            contas().iAltOeEgcGerx().set(getQueryReturnedValue("I_ALT_OE_EGC_GERX")) ;
            contas().iAltUsidGrxCta().set(getQueryReturnedValue("I_ALT_USID_GRX_CTA")) ;
            contas().iIgdeIrTitc().set(getQueryReturnedValue("I_IGDE_IR_TITC")) ;
            contas().iDcvoEspl().set(getQueryReturnedValue("I_DCVO_ESPL")) ;
            contas().iGrazCoe().set(getQueryReturnedValue("I_GRAZ_COE")) ;
            contas().iExrtSwif().set(getQueryReturnedValue("I_EXRT_SWIF")) ;
            contas().cBlqoCont().set(getQueryReturnedValue("C_BLQO_CONT")) ;
            contas().iEstContAnt().set(getQueryReturnedValue("I_EST_CONT_ANT")) ;
            contas().cSectIttlBpAnt().set(getQueryReturnedValue("C_SECT_ITTL_BP_ANT")) ;
            contas().zCtlSectIttlBp().set(getQueryReturnedValue("Z_CTL_SECT_ITTL_BP", String.class)) ;
            contas().zAltSectIttlBp().set(getQueryReturnedValue("Z_ALT_SECT_ITTL_BP", String.class)) ;
            contas().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            contas().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00101_CONTAS
     * called from Mghj801a.A5200AcederContaA5200AcederConta
     * 
     */
    public void selectMghj801a187() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_FAMI_PROD," +
                "C_TIPO_TRTT_CONT," +
                "C_CNDZ_MOVZ_CONT," +
                "C_SECT_ITTL_BPOR," +
                "I_TIPO_SPTE," +
                "I_DCVO_ESPL" +
            " FROM VWSDHOPS00101_CONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contas().cTipoCont() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contas().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            contas().cTipoTrttCont().set(getQueryReturnedValue("C_TIPO_TRTT_CONT")) ;
            contas().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            contas().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            contas().iTipoSpte().set(getQueryReturnedValue("I_TIPO_SPTE")) ;
            contas().iDcvoEspl().set(getQueryReturnedValue("I_DCVO_ESPL")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00101_CONTAS
     * called from Mghs801a.A5200AcederContaA5200AcederConta
     * 
     */
    public void selectMghs801a212() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_FAMI_PROD," +
                "C_TIPO_TRTT_CONT," +
                "C_CNDZ_MOVZ_CONT," +
                "C_SECT_ITTL_BPOR," +
                "I_TIPO_SPTE," +
                "I_DCVO_ESPL" +
            " FROM VWSDHOPS00101_CONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contas().cTipoCont() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contas().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            contas().cTipoTrttCont().set(getQueryReturnedValue("C_TIPO_TRTT_CONT")) ;
            contas().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            contas().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            contas().iTipoSpte().set(getQueryReturnedValue("I_TIPO_SPTE")) ;
            contas().iDcvoEspl().set(getQueryReturnedValue("I_DCVO_ESPL")) ;
        }
    }
}
