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
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdhops00201Subcontas extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Subcontas
     */
    @Data
    public abstract Subcontas subcontas() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO00201_SUBCONTAS
     * 
     * @version 2.0
     * 
     */
    public interface Subcontas extends IDataStruct {
        
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
         * C_PRODUTO
         */
        @Column(name="C_PRODUTO")
        @Data(size=3)
        IString cProduto() ;
        
        /**
         * C_BLQO_SCTA
         */
        @Column(name="C_BLQO_SCTA")
        @Data(size=1)
        IString cBlqoScta() ;
        
        /**
         * I_EST_SCTA
         */
        @Column(name="I_EST_SCTA")
        @Data(size=2)
        IString iEstScta() ;
        
        /**
         * I_EST_SCTA_ANT
         */
        @Column(name="I_EST_SCTA_ANT")
        @Data(size=2)
        IString iEstSctaAnt() ;
        
        /**
         * C_BAS_ICDC_CAL_JUR
         */
        @Column(name="C_BAS_ICDC_CAL_JUR")
        @Data(size=2)
        IString cBasIcdcCalJur() ;
        
        /**
         * I_TIP_PRZ_JSTZ_MOV
         */
        @Column(name="I_TIP_PRZ_JSTZ_MOV")
        @Data(size=4, signed=true, compression=COMP3)
        IInt iTipPrzJstzMov() ;
        
        /**
         * DU_TIPO_PRAZ_JSTZ
         */
        @Column(name="DU_TIPO_PRAZ_JSTZ")
        @Data(size=5, signed=true, compression=COMP3)
        IInt duTipoPrazJstz() ;
        
        /**
         * Q_DIA_PAVS
         */
        @Column(name="Q_DIA_PAVS")
        @Data(size=5, signed=true, compression=COMP3)
        IInt qDiaPavs() ;
        
        /**
         * C_SIT_ICPT
         */
        @Column(name="C_SIT_ICPT")
        @Data(size=2)
        IString cSitIcpt() ;
        
        /**
         * Z_PABT_SCTA
         */
        @Column(name="Z_PABT_SCTA", type=java.sql.Date.class)
        @Data(size=10)
        IString zPabtScta() ;
        
        /**
         * Z_ABRA_SCTA
         */
        @Column(name="Z_ABRA_SCTA", type=java.sql.Date.class)
        @Data(size=10)
        IString zAbraScta() ;
        
        /**
         * Z_VAL_ABRA_SCTA
         */
        @Column(name="Z_VAL_ABRA_SCTA", type=java.sql.Date.class)
        @Data(size=10)
        IString zValAbraScta() ;
        
        /**
         * Z_RABT_SCTA
         */
        @Column(name="Z_RABT_SCTA", type=java.sql.Date.class)
        @Data(size=10)
        IString zRabtScta() ;
        
        /**
         * Z_MGRZ_SCTA
         */
        @Column(name="Z_MGRZ_SCTA", type=java.sql.Date.class)
        @Data(size=10)
        IString zMgrzScta() ;
        
        /**
         * NS_MOV_MGRD_ULT
         */
        @Column(name="NS_MOV_MGRD_ULT")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovMgrdUlt() ;
        
        /**
         * Z_VAL_MOV_DIA_MIN
         */
        @Column(name="Z_VAL_MOV_DIA_MIN", type=java.sql.Date.class)
        @Data(size=10)
        IString zValMovDiaMin() ;
        
        /**
         * Z_MOV_ULT
         */
        @Column(name="Z_MOV_ULT", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovUlt() ;
        
        /**
         * Z_VAL_MOV_MAX
         */
        @Column(name="Z_VAL_MOV_MAX", type=java.sql.Date.class)
        @Data(size=10)
        IString zValMovMax() ;
        
        /**
         * Z_ENTD_CAP_DIV
         */
        @Column(name="Z_ENTD_CAP_DIV", type=java.sql.Date.class)
        @Data(size=10)
        IString zEntdCapDiv() ;
        
        /**
         * Z_SIT_ICPT
         */
        @Column(name="Z_SIT_ICPT", type=java.sql.Date.class)
        @Data(size=10)
        IString zSitIcpt() ;
        
        /**
         * Z_CNTL_SLDO
         */
        @Column(name="Z_CNTL_SLDO", type=java.sql.Date.class)
        @Data(size=10)
        IString zCntlSldo() ;
        
        /**
         * Z_CNTL_DAT_VAL_MOV
         */
        @Column(name="Z_CNTL_DAT_VAL_MOV", type=java.sql.Date.class)
        @Data(size=10)
        IString zCntlDatValMov() ;
        
        /**
         * Z_ENTD_CAP_DIV_ULT
         */
        @Column(name="Z_ENTD_CAP_DIV_ULT", type=java.sql.Date.class)
        @Data(size=10)
        IString zEntdCapDivUlt() ;
        
        /**
         * NS_MOV_ULT
         */
        @Column(name="NS_MOV_ULT")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovUlt() ;
        
        /**
         * NS_MOV_ABRA_SCTA
         */
        @Column(name="NS_MOV_ABRA_SCTA")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovAbraScta() ;
        
        /**
         * I_RFRO_PSVL
         */
        @Column(name="I_RFRO_PSVL")
        @Data(size=1)
        IString iRfroPsvl() ;
        
        /**
         * I_MOBA_PSVL
         */
        @Column(name="I_MOBA_PSVL")
        @Data(size=1)
        IString iMobaPsvl() ;
        
        /**
         * I_JSTZ_MOV_DEB
         */
        @Column(name="I_JSTZ_MOV_DEB")
        @Data(size=1)
        IString iJstzMovDeb() ;
        
        /**
         * I_NTZA_PROD
         */
        @Column(name="I_NTZA_PROD")
        @Data(size=1)
        IString iNtzaProd() ;
        
        /**
         * I_SLDO_CNAT
         */
        @Column(name="I_SLDO_CNAT")
        @Data(size=1)
        IString iSldoCnat() ;
        
        /**
         * I_EXIS_PLNO_ETGA
         */
        @Column(name="I_EXIS_PLNO_ETGA")
        @Data(size=1)
        IString iExisPlnoEtga() ;
        
        /**
         * I_LEVT_SLDO_IDNL
         */
        @Column(name="I_LEVT_SLDO_IDNL")
        @Data(size=1)
        IString iLevtSldoIdnl() ;
        
        /**
         * I_DCBO_NGCD_ISDP
         */
        @Column(name="I_DCBO_NGCD_ISDP")
        @Data(size=1)
        IString iDcboNgcdIsdp() ;
        
        /**
         * I_SLDO_CMRG_ISDP
         */
        @Column(name="I_SLDO_CMRG_ISDP")
        @Data(size=1)
        IString iSldoCmrgIsdp() ;
        
        /**
         * I_NDEB_DSPA
         */
        @Column(name="I_NDEB_DSPA")
        @Data(size=1)
        IString iNdebDspa() ;
        
        /**
         * I_CONT_CRRT_ASSD
         */
        @Column(name="I_CONT_CRRT_ASSD")
        @Data(size=1)
        IString iContCrrtAssd() ;
        
        /**
         * I_EXIS_RSTZ_SCTA
         */
        @Column(name="I_EXIS_RSTZ_SCTA")
        @Data(size=1)
        IString iExisRstzScta() ;
        
        /**
         * I_AVSO_DBCR_SWIF
         */
        @Column(name="I_AVSO_DBCR_SWIF")
        @Data(size=1)
        IString iAvsoDbcrSwif() ;
        
        /**
         * I_ORIG_FNDO
         */
        @Column(name="I_ORIG_FNDO")
        @Data(size=1)
        IString iOrigFndo() ;
        
        /**
         * I_TIPO_RSTZ_MOVZ
         */
        @Column(name="I_TIPO_RSTZ_MOVZ")
        @Data(size=1)
        IString iTipoRstzMovz() ;
        
        /**
         * I_EXIS_SEGM_PROT
         */
        @Column(name="I_EXIS_SEGM_PROT")
        @Data(size=1)
        IString iExisSegmProt() ;
        
        /**
         * M_ABRA_SCTA_MIN
         */
        @Column(name="M_ABRA_SCTA_MIN")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mAbraSctaMin() ;
        
        /**
         * M_ABRA_SCTA
         */
        @Column(name="M_ABRA_SCTA")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mAbraScta() ;
        
        /**
         * M_SLDO_CBLO
         */
        @Column(name="M_SLDO_CBLO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        /**
         * M_SLDO_CBLO_CNTL
         */
        @Column(name="M_SLDO_CBLO_CNTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloCntl() ;
        
        /**
         * M_SLDO_CBLO_MAX
         */
        @Column(name="M_SLDO_CBLO_MAX")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloMax() ;
        
        /**
         * M_SLDO_CBLO_MIN
         */
        @Column(name="M_SLDO_CBLO_MIN")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloMin() ;
        
        /**
         * M_SLDO_RETD
         */
        @Column(name="M_SLDO_RETD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetd() ;
        
        /**
         * M_SLDO_RETD_CNTL
         */
        @Column(name="M_SLDO_RETD_CNTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetdCntl() ;
        
        /**
         * M_SLDO_VCOB
         */
        @Column(name="M_SLDO_VCOB")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcob() ;
        
        /**
         * M_SLDO_VCOB_CNTL
         */
        @Column(name="M_SLDO_VCOB_CNTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcobCntl() ;
        
        /**
         * M_SLDO_VCOB_UTID
         */
        @Column(name="M_SLDO_VCOB_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcobUtid() ;
        
        /**
         * M_SLD_VCOB_UTD_CTL
         */
        @Column(name="M_SLD_VCOB_UTD_CTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldVcobUtdCtl() ;
        
        /**
         * M_SLDO_NAO_MOBL
         */
        @Column(name="M_SLDO_NAO_MOBL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoNaoMobl() ;
        
        /**
         * M_DCBO_NGCD_ATRD
         */
        @Column(name="M_DCBO_NGCD_ATRD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdAtrd() ;
        
        /**
         * M_DCB_NGCD_ATD_CTL
         */
        @Column(name="M_DCB_NGCD_ATD_CTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcbNgcdAtdCtl() ;
        
        /**
         * M_DCBO_NGCD_UTID
         */
        @Column(name="M_DCBO_NGCD_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdUtid() ;
        
        /**
         * M_DCB_NGCD_UTD_CTL
         */
        @Column(name="M_DCB_NGCD_UTD_CTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcbNgcdUtdCtl() ;
        
        /**
         * M_CMRG_LIM
         */
        @Column(name="M_CMRG_LIM")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        /**
         * M_CMRG_LIM_CNTL
         */
        @Column(name="M_CMRG_LIM_CNTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLimCntl() ;
        
        /**
         * M_CMRG_UTID
         */
        @Column(name="M_CMRG_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtid() ;
        
        /**
         * M_CMRG_UTID_CNTL
         */
        @Column(name="M_CMRG_UTID_CNTL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtidCntl() ;
        
        /**
         * M_DCBO_MOV_SIBS
         */
        @Column(name="M_DCBO_MOV_SIBS")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboMovSibs() ;
        
        /**
         * M_DCBO_DOMZ
         */
        @Column(name="M_DCBO_DOMZ")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboDomz() ;
        
        /**
         * M_DCBO_VCOB
         */
        @Column(name="M_DCBO_VCOB")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboVcob() ;
        
        /**
         * M_DCBO_ACTF
         */
        @Column(name="M_DCBO_ACTF")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboActf() ;
        
        /**
         * M_DNGD_ATD_CTL_ANT
         */
        @Column(name="M_DNGD_ATD_CTL_ANT")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDngdAtdCtlAnt() ;
        
        /**
         * M_DNGD_UTD_CTL_ANT
         */
        @Column(name="M_DNGD_UTD_CTL_ANT")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDngdUtdCtlAnt() ;
        
        /**
         * M_CMRG_LIM_CTL_ANT
         */
        @Column(name="M_CMRG_LIM_CTL_ANT")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLimCtlAnt() ;
        
        /**
         * M_CMRG_UTD_CTL_ANT
         */
        @Column(name="M_CMRG_UTD_CTL_ANT")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtdCtlAnt() ;
        
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
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00201_SUBCONTAS
     * called from Pghqz40a.M2170ObtTho002M2170ObtTho002
     * 
     */
    public void selectPghqz40a884() {
        sqlSttmt = "SELECT  " +
                "M_CMRG_LIM," +
                "M_CMRG_UTID" +
            " FROM VWSDHOPS00201_SUBCONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", subcontas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", subcontas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", subcontas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", subcontas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", subcontas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", subcontas().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", subcontas().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", subcontas().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            subcontas().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            subcontas().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
        }
    }
    /**
     * Copybooks
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00201_SUBCONTAS
     * called from Bhop0004SelectRegisto
     * 
     */
    public void selectBhop000458() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PRODUTO," +
                "C_BLQO_SCTA," +
                "I_EST_SCTA," +
                "I_EST_SCTA_ANT," +
                "C_BAS_ICDC_CAL_JUR," +
                "I_TIP_PRZ_JSTZ_MOV," +
                "DU_TIPO_PRAZ_JSTZ," +
                "Q_DIA_PAVS," +
                "C_SIT_ICPT," +
                "Z_PABT_SCTA," +
                "Z_ABRA_SCTA," +
                "Z_VAL_ABRA_SCTA," +
                "Z_RABT_SCTA," +
                "Z_MGRZ_SCTA," +
                "NS_MOV_MGRD_ULT," +
                "Z_VAL_MOV_DIA_MIN," +
                "Z_MOV_ULT," +
                "Z_VAL_MOV_MAX," +
                "Z_ENTD_CAP_DIV," +
                "Z_SIT_ICPT," +
                "Z_CNTL_SLDO," +
                "Z_CNTL_DAT_VAL_MOV," +
                "Z_ENTD_CAP_DIV_ULT," +
                "NS_MOV_ULT," +
                "NS_MOV_ABRA_SCTA," +
                "I_RFRO_PSVL," +
                "I_MOBA_PSVL," +
                "I_JSTZ_MOV_DEB," +
                "I_NTZA_PROD," +
                "I_SLDO_CNAT," +
                "I_EXIS_PLNO_ETGA," +
                "I_LEVT_SLDO_IDNL," +
                "I_DCBO_NGCD_ISDP," +
                "I_SLDO_CMRG_ISDP," +
                "I_NDEB_DSPA," +
                "I_CONT_CRRT_ASSD," +
                "I_EXIS_RSTZ_SCTA," +
                "I_AVSO_DBCR_SWIF," +
                "I_ORIG_FNDO," +
                "I_TIPO_RSTZ_MOVZ," +
                "M_ABRA_SCTA_MIN," +
                "M_ABRA_SCTA," +
                "M_SLDO_CBLO," +
                "M_SLDO_CBLO_CNTL," +
                "M_SLDO_CBLO_MAX," +
                "M_SLDO_CBLO_MIN," +
                "M_SLDO_RETD," +
                "M_SLDO_RETD_CNTL," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_CNTL," +
                "M_SLDO_VCOB_UTID," +
                "M_SLD_VCOB_UTD_CTL," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCB_NGCD_ATD_CTL," +
                "M_DCBO_NGCD_UTID," +
                "M_DCB_NGCD_UTD_CTL," +
                "M_CMRG_LIM," +
                "M_CMRG_LIM_CNTL," +
                "M_CMRG_UTID," +
                "M_CMRG_UTID_CNTL," +
                "M_DCBO_MOV_SIBS," +
                "M_DCBO_DOMZ," +
                "M_DCBO_VCOB," +
                "M_DCBO_ACTF," +
                "M_DNGD_ATD_CTL_ANT," +
                "M_DNGD_UTD_CTL_ANT," +
                "M_CMRG_LIM_CTL_ANT," +
                "M_CMRG_UTD_CTL_ANT," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS00201_SUBCONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", subcontas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", subcontas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", subcontas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", subcontas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", subcontas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", subcontas().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", subcontas().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", subcontas().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            subcontas().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            subcontas().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            subcontas().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            subcontas().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            subcontas().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            subcontas().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            subcontas().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            subcontas().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            subcontas().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            subcontas().cBlqoScta().set(getQueryReturnedValue("C_BLQO_SCTA")) ;
            subcontas().iEstScta().set(getQueryReturnedValue("I_EST_SCTA")) ;
            subcontas().iEstSctaAnt().set(getQueryReturnedValue("I_EST_SCTA_ANT")) ;
            subcontas().cBasIcdcCalJur().set(getQueryReturnedValue("C_BAS_ICDC_CAL_JUR")) ;
            subcontas().iTipPrzJstzMov().set(getQueryReturnedValue("I_TIP_PRZ_JSTZ_MOV")) ;
            subcontas().duTipoPrazJstz().set(getQueryReturnedValue("DU_TIPO_PRAZ_JSTZ")) ;
            subcontas().qDiaPavs().set(getQueryReturnedValue("Q_DIA_PAVS")) ;
            subcontas().cSitIcpt().set(getQueryReturnedValue("C_SIT_ICPT")) ;
            subcontas().zPabtScta().set(getQueryReturnedValue("Z_PABT_SCTA", String.class)) ;
            subcontas().zAbraScta().set(getQueryReturnedValue("Z_ABRA_SCTA", String.class)) ;
            subcontas().zValAbraScta().set(getQueryReturnedValue("Z_VAL_ABRA_SCTA", String.class)) ;
            subcontas().zRabtScta().set(getQueryReturnedValue("Z_RABT_SCTA", String.class)) ;
            subcontas().zMgrzScta().set(getQueryReturnedValue("Z_MGRZ_SCTA", String.class)) ;
            subcontas().nsMovMgrdUlt().set(getQueryReturnedValue("NS_MOV_MGRD_ULT")) ;
            subcontas().zValMovDiaMin().set(getQueryReturnedValue("Z_VAL_MOV_DIA_MIN", String.class)) ;
            subcontas().zMovUlt().set(getQueryReturnedValue("Z_MOV_ULT", String.class)) ;
            subcontas().zValMovMax().set(getQueryReturnedValue("Z_VAL_MOV_MAX", String.class)) ;
            subcontas().zEntdCapDiv().set(getQueryReturnedValue("Z_ENTD_CAP_DIV", String.class)) ;
            subcontas().zSitIcpt().set(getQueryReturnedValue("Z_SIT_ICPT", String.class)) ;
            subcontas().zCntlSldo().set(getQueryReturnedValue("Z_CNTL_SLDO", String.class)) ;
            subcontas().zCntlDatValMov().set(getQueryReturnedValue("Z_CNTL_DAT_VAL_MOV", String.class)) ;
            subcontas().zEntdCapDivUlt().set(getQueryReturnedValue("Z_ENTD_CAP_DIV_ULT", String.class)) ;
            subcontas().nsMovUlt().set(getQueryReturnedValue("NS_MOV_ULT")) ;
            subcontas().nsMovAbraScta().set(getQueryReturnedValue("NS_MOV_ABRA_SCTA")) ;
            subcontas().iRfroPsvl().set(getQueryReturnedValue("I_RFRO_PSVL")) ;
            subcontas().iMobaPsvl().set(getQueryReturnedValue("I_MOBA_PSVL")) ;
            subcontas().iJstzMovDeb().set(getQueryReturnedValue("I_JSTZ_MOV_DEB")) ;
            subcontas().iNtzaProd().set(getQueryReturnedValue("I_NTZA_PROD")) ;
            subcontas().iSldoCnat().set(getQueryReturnedValue("I_SLDO_CNAT")) ;
            subcontas().iExisPlnoEtga().set(getQueryReturnedValue("I_EXIS_PLNO_ETGA")) ;
            subcontas().iLevtSldoIdnl().set(getQueryReturnedValue("I_LEVT_SLDO_IDNL")) ;
            subcontas().iDcboNgcdIsdp().set(getQueryReturnedValue("I_DCBO_NGCD_ISDP")) ;
            subcontas().iSldoCmrgIsdp().set(getQueryReturnedValue("I_SLDO_CMRG_ISDP")) ;
            subcontas().iNdebDspa().set(getQueryReturnedValue("I_NDEB_DSPA")) ;
            subcontas().iContCrrtAssd().set(getQueryReturnedValue("I_CONT_CRRT_ASSD")) ;
            subcontas().iExisRstzScta().set(getQueryReturnedValue("I_EXIS_RSTZ_SCTA")) ;
            subcontas().iAvsoDbcrSwif().set(getQueryReturnedValue("I_AVSO_DBCR_SWIF")) ;
            subcontas().iOrigFndo().set(getQueryReturnedValue("I_ORIG_FNDO")) ;
            subcontas().iTipoRstzMovz().set(getQueryReturnedValue("I_TIPO_RSTZ_MOVZ")) ;
            subcontas().mAbraSctaMin().set(getQueryReturnedValue("M_ABRA_SCTA_MIN")) ;
            subcontas().mAbraScta().set(getQueryReturnedValue("M_ABRA_SCTA")) ;
            subcontas().mSldoCblo().set(getQueryReturnedValue("M_SLDO_CBLO")) ;
            subcontas().mSldoCbloCntl().set(getQueryReturnedValue("M_SLDO_CBLO_CNTL")) ;
            subcontas().mSldoCbloMax().set(getQueryReturnedValue("M_SLDO_CBLO_MAX")) ;
            subcontas().mSldoCbloMin().set(getQueryReturnedValue("M_SLDO_CBLO_MIN")) ;
            subcontas().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            subcontas().mSldoRetdCntl().set(getQueryReturnedValue("M_SLDO_RETD_CNTL")) ;
            subcontas().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            subcontas().mSldoVcobCntl().set(getQueryReturnedValue("M_SLDO_VCOB_CNTL")) ;
            subcontas().mSldoVcobUtid().set(getQueryReturnedValue("M_SLDO_VCOB_UTID")) ;
            subcontas().mSldVcobUtdCtl().set(getQueryReturnedValue("M_SLD_VCOB_UTD_CTL")) ;
            subcontas().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            subcontas().mDcbNgcdAtdCtl().set(getQueryReturnedValue("M_DCB_NGCD_ATD_CTL")) ;
            subcontas().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            subcontas().mDcbNgcdUtdCtl().set(getQueryReturnedValue("M_DCB_NGCD_UTD_CTL")) ;
            subcontas().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            subcontas().mCmrgLimCntl().set(getQueryReturnedValue("M_CMRG_LIM_CNTL")) ;
            subcontas().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            subcontas().mCmrgUtidCntl().set(getQueryReturnedValue("M_CMRG_UTID_CNTL")) ;
            subcontas().mDcboMovSibs().set(getQueryReturnedValue("M_DCBO_MOV_SIBS")) ;
            subcontas().mDcboDomz().set(getQueryReturnedValue("M_DCBO_DOMZ")) ;
            subcontas().mDcboVcob().set(getQueryReturnedValue("M_DCBO_VCOB")) ;
            subcontas().mDcboActf().set(getQueryReturnedValue("M_DCBO_ACTF")) ;
            subcontas().mDngdAtdCtlAnt().set(getQueryReturnedValue("M_DNGD_ATD_CTL_ANT")) ;
            subcontas().mDngdUtdCtlAnt().set(getQueryReturnedValue("M_DNGD_UTD_CTL_ANT")) ;
            subcontas().mCmrgLimCtlAnt().set(getQueryReturnedValue("M_CMRG_LIM_CTL_ANT")) ;
            subcontas().mCmrgUtdCtlAnt().set(getQueryReturnedValue("M_CMRG_UTD_CTL_ANT")) ;
            subcontas().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            subcontas().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00201_SUBCONTAS
     * called from Mghj801a.A5400AcederSubcontaA5400AcederSubconta
     * 
     */
    public void selectMghj801a272() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PRODUTO" +
            " FROM VWSDHOPS00201_SUBCONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", subcontas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", subcontas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", subcontas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", subcontas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", subcontas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", subcontas().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", subcontas().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", subcontas().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            subcontas().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO00201_SUBCONTAS
     * called from Mghs801a.A5400AcederSubcontaA5400AcederSubconta
     * 
     */
    public void selectMghs801a361() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PRODUTO" +
            " FROM VWSDHOPS00201_SUBCONTAS" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", subcontas().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", subcontas().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", subcontas().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", subcontas().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", subcontas().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", subcontas().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", subcontas().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", subcontas().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            subcontas().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
        }
    }
}
