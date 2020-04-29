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
public abstract class Vwsdghps20001Movexgdep extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movexgdep
     */
    @Data
    public abstract Movexgdep movexgdep() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH20001_MOVEXGDEP
     * 
     * @version 2.0
     * 
     */
    public interface Movexgdep extends IDataStruct {
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Key
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Key
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Key
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Key
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * C_MOED_ISO_SCTA
         */
        @Column(name="C_MOED_ISO_SCTA")
        @Key
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        /**
         * NS_DEPOSITO
         */
        @Column(name="NS_DEPOSITO")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        /**
         * NS_MOVIMENTO
         */
        @Column(name="NS_MOVIMENTO")
        @Key
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        /**
         * C_EST_EXTS_GAR_DEP
         */
        @Column(name="C_EST_EXTS_GAR_DEP")
        @Key
        @Data(size=1)
        IString cEstExtsGarDep() ;
        
        /**
         * C_CRTZ_MOV_EXS_GAR
         */
        @Column(name="C_CRTZ_MOV_EXS_GAR")
        @Data(size=3)
        IString cCrtzMovExsGar() ;
        
        /**
         * M_MOVIMENTO
         */
        @Column(name="M_MOVIMENTO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        /**
         * Z_INI_EXTS_GAR_DEP
         */
        @Column(name="Z_INI_EXTS_GAR_DEP", type=java.sql.Date.class)
        @Data(size=10)
        IString zIniExtsGarDep() ;
        
        /**
         * Z_FIM_EXTS_GAR_DEP
         */
        @Column(name="Z_FIM_EXTS_GAR_DEP", type=java.sql.Date.class)
        @Data(size=10)
        IString zFimExtsGarDep() ;
        
        /**
         * I_TIP_ITVT_EXS_GAR
         */
        @Column(name="I_TIP_ITVT_EXS_GAR")
        @Data(size=3, signed=true, compression=COMP3)
        IInt iTipItvtExsGar() ;
        
        /**
         * NS_TITC_EXTS_GART
         */
        @Column(name="NS_TITC_EXTS_GART")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsTitcExtsGart() ;
        
        /**
         * TS_CRIACAO
         */
        @Column(name="TS_CRIACAO", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsCriacao() ;
        
        /**
         * C_USID_CRIX
         */
        @Column(name="C_USID_CRIX")
        @Data(size=8)
        IString cUsidCrix() ;
        
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
     * extracted method to encapsulate SELECT access to table VGH20001_MOVEXGDEP
     * called from Pghq902a.M2400ProcuraDataEventoM2400ProcuraDataEvento
     * 
     */
    public void selectPghq902a960() {
        sqlSttmt = "SELECT  " +
                "TS_CRIACAO" +
            " FROM VWSDGHPS20001_MOVEXGDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento" +
            " ORDER BY " +
                "C_EST_EXTS_GAR_DEP ASC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movexgdep().tsCriacao().set(getQueryReturnedValue("TS_CRIACAO", String.class)) ;
        }
    }
    /**
     * Online
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH20001_MOVEXGDEP
     * called from Pghs194a.M2100DeleteThg200M2100DeleteThg200
     * 
     */
    public void deletePghs194a300() {
        sqlSttmt = "DELETE FROM VWSDGHPS20001_MOVEXGDEP " +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "C_EST_EXTS_GAR_DEP = :cEstExtsGarDep" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "cEstExtsGarDep", movexgdep().cEstExtsGarDep() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH20001_MOVEXGDEP
     * called from Pghs193a.M2250InsereTgh200M2250InsereTgh200
     * 
     */
    public void insertPghs193a1013() {
        sqlSttmt = "INSERT INTO VWSDGHPS20001_MOVEXGDEP ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NS_MOVIMENTO, " +
        	"C_EST_EXTS_GAR_DEP, " +
        	"C_CRTZ_MOV_EXS_GAR, " +
        	"M_MOVIMENTO, " +
        	"Z_INI_EXTS_GAR_DEP, " +
        	"Z_FIM_EXTS_GAR_DEP, " +
        	"I_TIP_ITVT_EXS_GAR, " +
        	"NS_TITC_EXTS_GART, " +
        	"TS_CRIACAO, " +
        	"C_USID_CRIX, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":cPaisIsoaCont, " +
        	":cBancCont, " +
        	":cOeEgcCont, " +
        	":nsRdclCont, " +
        	":vChkdCont, " +
        	":cTipoCont, " +
        	":cMoedIsoScta, " +
        	":nsDeposito, " +
        	":nsMovimento, " +
        	":cEstExtsGarDep, " +
        	":cCrtzMovExsGar, " +
        	":mMovimento, " +
        	":zIniExtsGarDep, " +
        	":zFimExtsGarDep, " +
        	":iTipItvtExsGar, " +
        	":nsTitcExtsGart, " +
        	"NOW(), " +
        	":cUsidCrix, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "cEstExtsGarDep", movexgdep().cEstExtsGarDep() ) ;
        setQueryArgument( "cCrtzMovExsGar", movexgdep().cCrtzMovExsGar() ) ;
        setQueryArgument( "mMovimento", movexgdep().mMovimento() ) ;
        setQueryArgument( "zIniExtsGarDep", movexgdep().zIniExtsGarDep(), java.sql.Date.class ) ;
        setQueryArgument( "zFimExtsGarDep", movexgdep().zFimExtsGarDep(), java.sql.Date.class ) ;
        setQueryArgument( "iTipItvtExsGar", movexgdep().iTipItvtExsGar() ) ;
        setQueryArgument( "nsTitcExtsGart", movexgdep().nsTitcExtsGart() ) ;
        setQueryArgument( "cUsidCrix", movexgdep().cUsidCrix() ) ;
        setQueryArgument( "cUsidActzUlt", movexgdep().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH20001_MOVEXGDEP
     * called from Pghs181a.M3510ObtemCCarMovM3510ObtemCCarMov
     * 
     */
    public void selectPghs181a2153() {
        sqlSttmt = "SELECT  " +
                "C_CRTZ_MOV_EXS_GAR" +
            " FROM VWSDGHPS20001_MOVEXGDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "C_EST_EXTS_GAR_DEP = :cEstExtsGarDep" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "cEstExtsGarDep", movexgdep().cEstExtsGarDep() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movexgdep().cCrtzMovExsGar().set(getQueryReturnedValue("C_CRTZ_MOV_EXS_GAR")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH20001_MOVEXGDEP
     * called from Pghs191a.M2100SelecionarExtensaoM2100SelecionarExtensao
     * 
     */
    public void selectPghs191a628() {
        sqlSttmt = "SELECT  " +
                "C_CRTZ_MOV_EXS_GAR," +
                "M_MOVIMENTO," +
                "Z_INI_EXTS_GAR_DEP," +
                "Z_FIM_EXTS_GAR_DEP," +
                "I_TIP_ITVT_EXS_GAR," +
                "NS_TITC_EXTS_GART," +
                "TS_CRIACAO," +
                "C_USID_CRIX," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS20001_MOVEXGDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "C_EST_EXTS_GAR_DEP = :cEstExtsGarDep" +
            " ORDER BY " +
                "C_PAIS_ISOA_CONT ASC," +
                "C_BANC_CONT ASC," +
                "C_OE_EGC_CONT ASC," +
                "NS_RDCL_CONT ASC," +
                "NS_DEPOSITO ASC," +
                "C_TIPO_CONT ASC," +
                "C_MOED_ISO_SCTA ASC," +
                "NS_DEPOSITO ASC," +
                "NS_MOVIMENTO ASC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "cEstExtsGarDep", movexgdep().cEstExtsGarDep() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movexgdep().cCrtzMovExsGar().set(getQueryReturnedValue("C_CRTZ_MOV_EXS_GAR")) ;
            movexgdep().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movexgdep().zIniExtsGarDep().set(getQueryReturnedValue("Z_INI_EXTS_GAR_DEP", String.class)) ;
            movexgdep().zFimExtsGarDep().set(getQueryReturnedValue("Z_FIM_EXTS_GAR_DEP", String.class)) ;
            movexgdep().iTipItvtExsGar().set(getQueryReturnedValue("I_TIP_ITVT_EXS_GAR")) ;
            movexgdep().nsTitcExtsGart().set(getQueryReturnedValue("NS_TITC_EXTS_GART")) ;
            movexgdep().tsCriacao().set(getQueryReturnedValue("TS_CRIACAO", String.class)) ;
            movexgdep().cUsidCrix().set(getQueryReturnedValue("C_USID_CRIX")) ;
            movexgdep().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movexgdep().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH20001_MOVEXGDEP
     * called from Pghs193a.M2201TrataAtzExtGarM2201TrataAtzExtGar
     * 
     * @param pConAtivo
     */
    public void selectPghs193a748(String pConAtivo) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "C_EST_EXTS_GAR_DEP," +
                "C_CRTZ_MOV_EXS_GAR," +
                "M_MOVIMENTO," +
                "Z_INI_EXTS_GAR_DEP," +
                "Z_FIM_EXTS_GAR_DEP," +
                "I_TIP_ITVT_EXS_GAR," +
                "NS_TITC_EXTS_GART," +
                "TS_CRIACAO," +
                "C_USID_CRIX," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS20001_MOVEXGDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "C_EST_EXTS_GAR_DEP = :conAtivo" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "conAtivo", pConAtivo ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movexgdep().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movexgdep().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movexgdep().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movexgdep().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movexgdep().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movexgdep().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movexgdep().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movexgdep().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movexgdep().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movexgdep().cEstExtsGarDep().set(getQueryReturnedValue("C_EST_EXTS_GAR_DEP")) ;
            movexgdep().cCrtzMovExsGar().set(getQueryReturnedValue("C_CRTZ_MOV_EXS_GAR")) ;
            movexgdep().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movexgdep().zIniExtsGarDep().set(getQueryReturnedValue("Z_INI_EXTS_GAR_DEP", String.class)) ;
            movexgdep().zFimExtsGarDep().set(getQueryReturnedValue("Z_FIM_EXTS_GAR_DEP", String.class)) ;
            movexgdep().iTipItvtExsGar().set(getQueryReturnedValue("I_TIP_ITVT_EXS_GAR")) ;
            movexgdep().nsTitcExtsGart().set(getQueryReturnedValue("NS_TITC_EXTS_GART")) ;
            movexgdep().tsCriacao().set(getQueryReturnedValue("TS_CRIACAO", String.class)) ;
            movexgdep().cUsidCrix().set(getQueryReturnedValue("C_USID_CRIX")) ;
            movexgdep().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movexgdep().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH20001_MOVEXGDEP
     * called from Pghs193a.M2230AtualizaTgh200M2230AtualizaTgh200
     * 
     * @param pConAtivo
     */
    public void updatePghs193a879(String pConAtivo) {
        sqlSttmt = "UPDATE VWSDGHPS20001_MOVEXGDEP " +
            "SET M_MOVIMENTO = :mMovimento, " +
                "C_CRTZ_MOV_EXS_GAR = :cCrtzMovExsGar, " +
                "Z_INI_EXTS_GAR_DEP = :zIniExtsGarDep, " +
                "Z_FIM_EXTS_GAR_DEP = :zFimExtsGarDep, " +
                "I_TIP_ITVT_EXS_GAR = :iTipItvtExsGar, " +
                "NS_TITC_EXTS_GART = :nsTitcExtsGart, " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt, " +
                "TS_ACTZ_ULT = NOW()" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "C_EST_EXTS_GAR_DEP = :conAtivo" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "conAtivo", pConAtivo ) ;
        setQueryArgument( "mMovimento", movexgdep().mMovimento() ) ;
        setQueryArgument( "cCrtzMovExsGar", movexgdep().cCrtzMovExsGar() ) ;
        setQueryArgument( "zIniExtsGarDep", movexgdep().zIniExtsGarDep(), java.sql.Date.class ) ;
        setQueryArgument( "zFimExtsGarDep", movexgdep().zFimExtsGarDep(), java.sql.Date.class ) ;
        setQueryArgument( "iTipItvtExsGar", movexgdep().iTipItvtExsGar() ) ;
        setQueryArgument( "nsTitcExtsGart", movexgdep().nsTitcExtsGart() ) ;
        setQueryArgument( "cUsidActzUlt", movexgdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH20001_MOVEXGDEP
     * called from Pghs194a.M2200UpdateThg200M2200UpdateThg200
     * 
     */
    public void updatePghs194a356() {
        sqlSttmt = "UPDATE VWSDGHPS20001_MOVEXGDEP " +
            "SET C_EST_EXTS_GAR_DEP = :cEstExtsGarDep" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movexgdep().nsMovimento() ) ;
        setQueryArgument( "cEstExtsGarDep", movexgdep().cEstExtsGarDep() ) ;
        executeUpdate() ;
    }
}
