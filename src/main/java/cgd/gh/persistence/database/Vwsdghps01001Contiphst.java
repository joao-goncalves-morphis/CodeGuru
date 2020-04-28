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
public abstract class Vwsdghps01001Contiphst extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Contiphst
     */
    @Data
    public abstract Contiphst contiphst() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH01001_CONTIPHST
     * 
     * @version 2.0
     * 
     */
    public interface Contiphst extends IDataStruct {
        
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
         * NM_RECURSO
         */
        @Column(name="NM_RECURSO")
        @Key
        @Data(size=8)
        IString nmRecurso() ;
        
        /**
         * C_TIPO_INF_HIST
         */
        @Column(name="C_TIPO_INF_HIST")
        @Data(size=1)
        IString cTipoInfHist() ;
        
        /**
         * ZA_INICIO
         */
        @Column(name="ZA_INICIO")
        @Data(size=4, signed=true, compression=COMP3)
        IInt zaInicio() ;
        
        /**
         * ZA_FIM
         */
        @Column(name="ZA_FIM")
        @Data(size=4, signed=true, compression=COMP3)
        IInt zaFim() ;
        
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
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Pghq015a.A32500CloseCursorC2A32500CloseCursorC2
     * 
     */
    public void closePghq015a1246() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_VGH01001
     * called from Pghq101a.M2240CloseCrsVgh01001M2240CloseCrsVgh01001
     * 
     */
    public void closePghq101a1600() {
        BaseCursorHandler c = getCursor("CRS_VGH01001") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq200a.A33400CloseCursorC1A33400CloseCursorC1
     * 
     */
    public void closePghq200a2593() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH01001_CONTIPHST
     * called from Pghq112a.M2200EliminaTgh010M2200EliminaTgh010
     * 
     */
    public void deletePghq112a706() {
        sqlSttmt = "DELETE FROM VWSDGHPS01001_CONTIPHST " +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO = :nmRecurso AND " +
                "ZA_INICIO = :zaInicio AND " +
                "ZA_FIM = :zaFim" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Pghq015a.A32200FetchCursorC2A32200FetchCursorC2
     * 
     */
    public void fetchPghq015a1098() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            contiphst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            contiphst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            contiphst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            contiphst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            contiphst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            contiphst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            contiphst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().cTipoInfHist().set(c.getValue("C_TIPO_INF_HIST")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
            contiphst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            contiphst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_VGH01001
     * called from Pghq101a.M2220FetchCrsVgh01001M2220FetchCrsVgh01001
     * 
     */
    public void fetchPghq101a1494() {
        BaseCursorHandler c = getCursor("CRS_VGH01001") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq200a.A33200FetchCursorC1A33200FetchCursorC1
     * 
     */
    public void fetchPghq200a1755() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghq015a.A32400InsRegTgh10A32400InsRegTgh10
     * 
     */
    public void insertPghq015a1185() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghq112a.M2100InsereTgh010M2100InsereTgh010
     * 
     */
    public void insertPghq112a622() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Pghq015a.A32100OpenCursorC2A32100OpenCursorC2
     * 
     */
    public void openPghq015a1070() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NM_RECURSO," +
                "C_TIPO_INF_HIST," +
                "ZA_INICIO," +
                "ZA_FIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO = :nmRecurso" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        c.setArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_VGH01001
     * called from Pghq101a.M2210OpenCrsVgh01001M2210OpenCrsVgh01001
     * 
     */
    public void openPghq101a1450() {
        sqlSttmt = "SELECT  " +
                "NM_RECURSO," +
                "ZA_INICIO" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "ZA_INICIO <= :zaInicio" +
            " ORDER BY " +
                "ZA_INICIO DESC" ;
        BaseCursorHandler c = addCursor("CRS_VGH01001", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "zaInicio", contiphst().zaInicio() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq200a.A33100OpenCursorC1A33100OpenCursorC1
     * 
     */
    public void openPghq200a1727() {
        sqlSttmt = "SELECT  " +
                "NM_RECURSO," +
                "ZA_INICIO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_TIPO_INF_HIST = :cTipoInfHist" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        c.setArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01001_CONTIPHST
     * called from Pghq015a.A32001VerificarTgh10A32001VerificarTgh10
     * 
     */
    public void selectPghq015a983() {
        sqlSttmt = "SELECT  " +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO = :nmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().zaFim().set(getQueryReturnedValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghq015a.A32300ActRegTgh10A32300ActRegTgh10
     * 
     */
    public void updatePghq015a1137() {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :zaFim" +
            " WHERE " +
                "CURRENT OF PGHQ015A_C2"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghq668a.A32000TrataInsertA32000TrataInsert
     * 
     */
    public void insertPghq668a645() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghq667a.A31000TrataActualA31000TrataActual
     * 
     * @param pWsFwk910CPaisIsoaCont
     * @param pWsFwk910CBancCont
     * @param pWsFwk910COeEgcCont
     * @param pWsFwk910NsRdclCont
     * @param pWsFwk910VChkdCont
     * @param pWsFwk910CTipoCont
     * @param pWsFwk910CMoedIsoScta
     * @param pWsFwk910NsDeposito
     * @param pWsFwk910NmRecurso
     * @param pWsFwk910ZaInicio
     */
    public void updatePghq667a642(IString pWsFwk910CPaisIsoaCont, IInt pWsFwk910CBancCont, IInt pWsFwk910COeEgcCont, IInt pWsFwk910NsRdclCont, IInt pWsFwk910VChkdCont, IInt pWsFwk910CTipoCont, IString pWsFwk910CMoedIsoScta, IInt pWsFwk910NsDeposito, IString pWsFwk910NmRecurso, IInt pWsFwk910ZaInicio) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_INICIO = :zaInicio, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsFwk910CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsFwk910CBancCont AND " +
                "C_OE_EGC_CONT = :wsFwk910COeEgcCont AND " +
                "NS_RDCL_CONT = :wsFwk910NsRdclCont AND " +
                "V_CHKD_CONT = :wsFwk910VChkdCont AND " +
                "C_TIPO_CONT = :wsFwk910CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsFwk910CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsFwk910NsDeposito AND " +
                "NM_RECURSO = :wsFwk910NmRecurso AND " +
                "ZA_INICIO = :wsFwk910ZaInicio" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsFwk910CPaisIsoaCont", pWsFwk910CPaisIsoaCont ) ;
        setQueryArgument( "wsFwk910CBancCont", pWsFwk910CBancCont ) ;
        setQueryArgument( "wsFwk910COeEgcCont", pWsFwk910COeEgcCont ) ;
        setQueryArgument( "wsFwk910NsRdclCont", pWsFwk910NsRdclCont ) ;
        setQueryArgument( "wsFwk910VChkdCont", pWsFwk910VChkdCont ) ;
        setQueryArgument( "wsFwk910CTipoCont", pWsFwk910CTipoCont ) ;
        setQueryArgument( "wsFwk910CMoedIsoScta", pWsFwk910CMoedIsoScta ) ;
        setQueryArgument( "wsFwk910NsDeposito", pWsFwk910NsDeposito ) ;
        setQueryArgument( "wsFwk910NmRecurso", pWsFwk910NmRecurso ) ;
        setQueryArgument( "wsFwk910ZaInicio", pWsFwk910ZaInicio ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghq667a.A31100TrataSo2009A31100TrataSo2009
     * 
     * @param pWsFwk910CPaisIsoaCont
     * @param pWsFwk910CBancCont
     * @param pWsFwk910COeEgcCont
     * @param pWsFwk910NsRdclCont
     * @param pWsFwk910VChkdCont
     * @param pWsFwk910CTipoCont
     * @param pWsFwk910CMoedIsoScta
     * @param pWsFwk910NsDeposito
     * @param pWsFwk910NmRecurso
     * @param pWsFwk910ZaInicio
     * @param pWsFwk910ZaFim
     */
    public void updatePghq667a719(IString pWsFwk910CPaisIsoaCont, IInt pWsFwk910CBancCont, IInt pWsFwk910COeEgcCont, IInt pWsFwk910NsRdclCont, IInt pWsFwk910VChkdCont, IInt pWsFwk910CTipoCont, IString pWsFwk910CMoedIsoScta, IInt pWsFwk910NsDeposito, IString pWsFwk910NmRecurso, IInt pWsFwk910ZaInicio, IInt pWsFwk910ZaFim) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET NM_RECURSO = :nmRecurso, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsFwk910CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsFwk910CBancCont AND " +
                "C_OE_EGC_CONT = :wsFwk910COeEgcCont AND " +
                "NS_RDCL_CONT = :wsFwk910NsRdclCont AND " +
                "V_CHKD_CONT = :wsFwk910VChkdCont AND " +
                "C_TIPO_CONT = :wsFwk910CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsFwk910CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsFwk910NsDeposito AND " +
                "NM_RECURSO = :wsFwk910NmRecurso AND " +
                "ZA_INICIO = :wsFwk910ZaInicio AND " +
                "ZA_FIM = :wsFwk910ZaFim" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsFwk910CPaisIsoaCont", pWsFwk910CPaisIsoaCont ) ;
        setQueryArgument( "wsFwk910CBancCont", pWsFwk910CBancCont ) ;
        setQueryArgument( "wsFwk910COeEgcCont", pWsFwk910COeEgcCont ) ;
        setQueryArgument( "wsFwk910NsRdclCont", pWsFwk910NsRdclCont ) ;
        setQueryArgument( "wsFwk910VChkdCont", pWsFwk910VChkdCont ) ;
        setQueryArgument( "wsFwk910CTipoCont", pWsFwk910CTipoCont ) ;
        setQueryArgument( "wsFwk910CMoedIsoScta", pWsFwk910CMoedIsoScta ) ;
        setQueryArgument( "wsFwk910NsDeposito", pWsFwk910NsDeposito ) ;
        setQueryArgument( "wsFwk910NmRecurso", pWsFwk910NmRecurso ) ;
        setQueryArgument( "wsFwk910ZaInicio", pWsFwk910ZaInicio ) ;
        setQueryArgument( "wsFwk910ZaFim", pWsFwk910ZaFim ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghq667a.A32000TrataHistoricoA32000TrataHistorico
     * 
     * @param pWsFwk910CPaisIsoaCont
     * @param pWsFwk910CBancCont
     * @param pWsFwk910COeEgcCont
     * @param pWsFwk910NsRdclCont
     * @param pWsFwk910VChkdCont
     * @param pWsFwk910CTipoCont
     * @param pWsFwk910CMoedIsoScta
     * @param pWsFwk910NsDeposito
     * @param pWsFwk910NmRecurso
     * @param pWsFwk910ZaInicio
     * @param pWsFwk910ZaFim
     */
    public void updatePghq667a800(IString pWsFwk910CPaisIsoaCont, IInt pWsFwk910CBancCont, IInt pWsFwk910COeEgcCont, IInt pWsFwk910NsRdclCont, IInt pWsFwk910VChkdCont, IInt pWsFwk910CTipoCont, IString pWsFwk910CMoedIsoScta, IInt pWsFwk910NsDeposito, IString pWsFwk910NmRecurso, IInt pWsFwk910ZaInicio, IInt pWsFwk910ZaFim) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET NM_RECURSO = :nmRecurso, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsFwk910CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsFwk910CBancCont AND " +
                "C_OE_EGC_CONT = :wsFwk910COeEgcCont AND " +
                "NS_RDCL_CONT = :wsFwk910NsRdclCont AND " +
                "V_CHKD_CONT = :wsFwk910VChkdCont AND " +
                "C_TIPO_CONT = :wsFwk910CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsFwk910CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsFwk910NsDeposito AND " +
                "NM_RECURSO = :wsFwk910NmRecurso AND " +
                "ZA_INICIO = :wsFwk910ZaInicio AND " +
                "ZA_FIM = :wsFwk910ZaFim" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsFwk910CPaisIsoaCont", pWsFwk910CPaisIsoaCont ) ;
        setQueryArgument( "wsFwk910CBancCont", pWsFwk910CBancCont ) ;
        setQueryArgument( "wsFwk910COeEgcCont", pWsFwk910COeEgcCont ) ;
        setQueryArgument( "wsFwk910NsRdclCont", pWsFwk910NsRdclCont ) ;
        setQueryArgument( "wsFwk910VChkdCont", pWsFwk910VChkdCont ) ;
        setQueryArgument( "wsFwk910CTipoCont", pWsFwk910CTipoCont ) ;
        setQueryArgument( "wsFwk910CMoedIsoScta", pWsFwk910CMoedIsoScta ) ;
        setQueryArgument( "wsFwk910NsDeposito", pWsFwk910NsDeposito ) ;
        setQueryArgument( "wsFwk910NmRecurso", pWsFwk910NmRecurso ) ;
        setQueryArgument( "wsFwk910ZaInicio", pWsFwk910ZaInicio ) ;
        setQueryArgument( "wsFwk910ZaFim", pWsFwk910ZaFim ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz01a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz01a1081() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz03a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz03a960() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz05a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz05a966() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz07a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz07a966() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz09a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz09a966() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz11a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz11a966() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz13a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz13a966() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz15a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz15a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz17a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz17a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz19a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz19a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz21a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz21a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz23a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz23a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz25a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz25a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz27a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz27a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz29a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz29a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz31a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz31a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz33a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz33a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz35a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz35a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz37a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz37a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01001_CONTIPHST
     * called from Pghqz39a.A31400InsRegContiphstA31400InsRegContiphst
     * 
     */
    public void insertPghqz39a964() {
        sqlSttmt = "INSERT INTO VWSDGHPS01001_CONTIPHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NM_RECURSO, " +
        	"C_TIPO_INF_HIST, " +
        	"ZA_INICIO, " +
        	"ZA_FIM, " +
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
        	":nmRecurso, " +
        	":cTipoInfHist, " +
        	":zaInicio, " +
        	":zaFim, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "zaFim", contiphst().zaFim() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01001_CONTIPHST
     * called from Pghq998a.M2200AcedeTgh10M2200AcedeTgh10
     * 
     */
    public void selectPghq998a1342() {
        sqlSttmt = "SELECT  " +
                "NM_RECURSO" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "ZA_INICIO <= :zaInicio" +
            " ORDER BY " +
                "ZA_INICIO DESC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(getQueryReturnedValue("NM_RECURSO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghq930a.M2200ActualizaTgh0010M2200ActualizaTgh0010
     * 
     */
    public void updatePghq930a678() {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_INICIO = :zaInicio, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO = :nmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        setQueryArgument( "cUsidActzUlt", contiphst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz01a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaInicio
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz01a1013(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaInicio, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_INICIO = :wsVgh01001ZaInicio, " +
                "ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaInicio", pWsVgh01001ZaInicio ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz03a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz03a896(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz05a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz05a901(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz07a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz07a901(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz09a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz09a901(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz11a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz11a901(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz13a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz13a901(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz15a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz15a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz17a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz17a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz19a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz19a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz21a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz21a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz23a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz23a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz25a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz25a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz27a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz27a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz29a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz29a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz31a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz31a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz33a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz33a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz35a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz35a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz37a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz37a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01001_CONTIPHST
     * called from Pghqz39a.A31300ActRegContiphstA31300ActRegContiphst
     * 
     * @param pWsVgh01001CPaisIsoaCont
     * @param pWsVgh01001CBancCont
     * @param pWsVgh01001COeEgcCont
     * @param pWsVgh01001NsRdclCont
     * @param pWsVgh01001VChkdCont
     * @param pWsVgh01001CTipoCont
     * @param pWsVgh01001CMoedIsoScta
     * @param pWsVgh01001NsDeposito
     * @param pWsVgh01001NmRecurso
     * @param pWsVgh01001ZaFim
     * @param pWsVgh01001CUsidActzUlt
     */
    public void updatePghqz39a899(IString pWsVgh01001CPaisIsoaCont, IInt pWsVgh01001CBancCont, IInt pWsVgh01001COeEgcCont, IInt pWsVgh01001NsRdclCont, IInt pWsVgh01001VChkdCont, IInt pWsVgh01001CTipoCont, IString pWsVgh01001CMoedIsoScta, IInt pWsVgh01001NsDeposito, IString pWsVgh01001NmRecurso, IInt pWsVgh01001ZaFim, IString pWsVgh01001CUsidActzUlt) {
        sqlSttmt = "UPDATE VWSDGHPS01001_CONTIPHST " +
            "SET ZA_FIM = :wsVgh01001ZaFim, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :wsVgh01001CUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :wsVgh01001CPaisIsoaCont AND " +
                "C_BANC_CONT = :wsVgh01001CBancCont AND " +
                "C_OE_EGC_CONT = :wsVgh01001COeEgcCont AND " +
                "NS_RDCL_CONT = :wsVgh01001NsRdclCont AND " +
                "V_CHKD_CONT = :wsVgh01001VChkdCont AND " +
                "C_TIPO_CONT = :wsVgh01001CTipoCont AND " +
                "C_MOED_ISO_SCTA = :wsVgh01001CMoedIsoScta AND " +
                "NS_DEPOSITO = :wsVgh01001NsDeposito AND " +
                "NM_RECURSO = :wsVgh01001NmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsVgh01001CPaisIsoaCont", pWsVgh01001CPaisIsoaCont ) ;
        setQueryArgument( "wsVgh01001CBancCont", pWsVgh01001CBancCont ) ;
        setQueryArgument( "wsVgh01001COeEgcCont", pWsVgh01001COeEgcCont ) ;
        setQueryArgument( "wsVgh01001NsRdclCont", pWsVgh01001NsRdclCont ) ;
        setQueryArgument( "wsVgh01001VChkdCont", pWsVgh01001VChkdCont ) ;
        setQueryArgument( "wsVgh01001CTipoCont", pWsVgh01001CTipoCont ) ;
        setQueryArgument( "wsVgh01001CMoedIsoScta", pWsVgh01001CMoedIsoScta ) ;
        setQueryArgument( "wsVgh01001NsDeposito", pWsVgh01001NsDeposito ) ;
        setQueryArgument( "wsVgh01001NmRecurso", pWsVgh01001NmRecurso ) ;
        setQueryArgument( "wsVgh01001ZaFim", pWsVgh01001ZaFim ) ;
        setQueryArgument( "wsVgh01001CUsidActzUlt", pWsVgh01001CUsidActzUlt ) ;
        executeUpdate() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs001a.A5100VerTabTgh10A5100VerTabTgh10
     * 
     */
    public void closeMghs001a452() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs110a.A5200ListaTapeA5200ListaTape
     * 
     */
    public void closeMghs110a308() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs110a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void closeMghs110a399() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs310a.A5200ListaTabelaA5200ListaTabela
     * 
     */
    public void closeMghs310a305() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs001a.A5100VerTabTgh10A5100VerTabTgh10
     * 
     */
    public void fetchMghs001a380() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs001a.A5100VerTabTgh10A5100VerTabTgh10
     * 
     */
    public void fetchMghs001a432() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs110a.A5200ListaTapeA5200ListaTape
     * 
     */
    public void fetchMghs110a242() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs110a.A5200ListaTapeA5200ListaTape
     * 
     */
    public void fetchMghs110a289() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs110a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void fetchMghs110a333() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs110a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void fetchMghs110a380() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs310a.A5200ListaTabelaA5200ListaTabela
     * 
     */
    public void fetchMghs310a224() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            contiphst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            contiphst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            contiphst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            contiphst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            contiphst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            contiphst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            contiphst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().cTipoInfHist().set(c.getValue("C_TIPO_INF_HIST")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs310a.A5200ListaTabelaA5200ListaTabela
     * 
     */
    public void fetchMghs310a277() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            contiphst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            contiphst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            contiphst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            contiphst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            contiphst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            contiphst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            contiphst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            contiphst().nmRecurso().set(c.getValue("NM_RECURSO")) ;
            contiphst().cTipoInfHist().set(c.getValue("C_TIPO_INF_HIST")) ;
            contiphst().zaInicio().set(c.getValue("ZA_INICIO")) ;
            contiphst().zaFim().set(c.getValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs001a.A5100VerTabTgh10A5100VerTabTgh10
     * 
     */
    public void openMghs001a368() {
        sqlSttmt = "SELECT  " +
                "C_MOED_ISO_SCTA," +
                "ZA_INICIO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_TIPO_INF_HIST = 'P'" +
            " ORDER BY " +
                "ZA_INICIO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs110a.A5200ListaTapeA5200ListaTape
     * 
     */
    public void openMghs110a230() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NM_RECURSO," +
                "ZA_INICIO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO LIKE 'GHSA%' AND " +
                "C_TIPO_INF_HIST = 'P'" +
            " ORDER BY " +
                "ZA_INICIO ASC" +
            " LIMIT 30" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs110a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void openMghs110a321() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NM_RECURSO," +
                "ZA_INICIO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO LIKE 'VGH0%' AND " +
                "C_TIPO_INF_HIST = 'P'" +
            " ORDER BY " +
                "ZA_INICIO ASC" +
            " LIMIT 30" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs310a.A5200ListaTabelaA5200ListaTabela
     * 
     */
    public void openMghs310a212() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NM_RECURSO," +
                "C_TIPO_INF_HIST," +
                "ZA_INICIO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "(C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO >= :nsDeposito AND " +
                "ZA_INICIO >= :zaInicio AND " +
                "C_TIPO_INF_HIST = 'P') OR " +
                "(C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO > :nsDeposito AND " +
                "C_TIPO_INF_HIST = 'P')" +
            " ORDER BY " +
                "NS_DEPOSITO ASC," +
                "ZA_INICIO ASC" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", contiphst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        c.setArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        c.setArgument( "zaInicio", contiphst().zaInicio() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01001_CONTIPHST
     * called from Mghs010a.A5200AcederTabA5200AcederTab
     * 
     */
    public void selectMghs010a152() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_INF_HIST," +
                "ZA_INICIO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NM_RECURSO = :nmRecurso" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "nmRecurso", contiphst().nmRecurso() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().cTipoInfHist().set(getQueryReturnedValue("C_TIPO_INF_HIST")) ;
            contiphst().zaInicio().set(getQueryReturnedValue("ZA_INICIO")) ;
            contiphst().zaFim().set(getQueryReturnedValue("ZA_FIM")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01001_CONTIPHST
     * called from Mghs210a.A5200AcederTabA5200AcederTab
     * 
     */
    public void selectMghs210a152() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NM_RECURSO," +
                "ZA_FIM" +
            " FROM VWSDGHPS01001_CONTIPHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_TIPO_INF_HIST = :cTipoInfHist AND " +
                "ZA_INICIO = :zaInicio" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", contiphst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", contiphst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", contiphst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", contiphst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", contiphst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", contiphst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", contiphst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", contiphst().nsDeposito() ) ;
        setQueryArgument( "cTipoInfHist", contiphst().cTipoInfHist() ) ;
        setQueryArgument( "zaInicio", contiphst().zaInicio() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            contiphst().nmRecurso().set(getQueryReturnedValue("NM_RECURSO")) ;
            contiphst().zaFim().set(getQueryReturnedValue("ZA_FIM")) ;
        }
    }
}
