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
public abstract class Vwsdghps20101Titexgdep extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Titexgdep
     */
    @Data
    public abstract Titexgdep titexgdep() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH20101_TITEXGDEP
     * 
     * @version 2.0
     * 
     */
    public interface Titexgdep extends IDataStruct {
        
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
         * I_TIPO_ITVT
         */
        @Column(name="I_TIPO_ITVT")
        @Key
        @Data(size=3, signed=true, compression=COMP3)
        IInt iTipoItvt() ;
        
        /**
         * NS_TITC
         */
        @Column(name="NS_TITC")
        @Key
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsTitc() ;
        
        /**
         * I_TITC_EXS_GAR_DEP
         */
        @Column(name="I_TITC_EXS_GAR_DEP")
        @Data(size=1)
        IString iTitcExsGarDep() ;
        
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
     * Online
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS-TGH201
     * called from Pghs191a.M2216CloseCrsTgh201M2216CloseCrsTgh201
     * 
     */
    public void closePghs191a1279() {
        BaseCursorHandler c = getCursor("CRS-TGH201") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH20101_TITEXGDEP
     * called from Pghs193a.M2250EliminaTitularesM2250EliminaTitulares
     * 
     */
    public void deletePghs193a1284() {
        sqlSttmt = "DELETE FROM VWSDGHPS20101_TITEXGDEP " +
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
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH20101_TITEXGDEP
     * called from Pghs194a.M2300DeleteThg201M2300DeleteThg201
     * 
     */
    public void deletePghs194a411() {
        sqlSttmt = "DELETE FROM VWSDGHPS20101_TITEXGDEP " +
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
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS-TGH201
     * called from Pghs191a.M2212FetchCrsTgh201M2212FetchCrsTgh201
     * 
     */
    public void fetchPghs191a849() {
        BaseCursorHandler c = getCursor("CRS-TGH201") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            titexgdep().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            titexgdep().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            titexgdep().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            titexgdep().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            titexgdep().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            titexgdep().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            titexgdep().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            titexgdep().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            titexgdep().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            titexgdep().iTipoItvt().set(c.getValue("I_TIPO_ITVT")) ;
            titexgdep().nsTitc().set(c.getValue("NS_TITC")) ;
            titexgdep().iTitcExsGarDep().set(c.getValue("I_TITC_EXS_GAR_DEP")) ;
            titexgdep().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            titexgdep().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH20101_TITEXGDEP
     * called from Pghs193a.M2351AcedeMhjj051aM2351AcedeMhjj051a
     * 
     */
    public void insertPghs193a1461() {
        sqlSttmt = "INSERT INTO VWSDGHPS20101_TITEXGDEP ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"NS_MOVIMENTO, " +
        	"I_TIPO_ITVT, " +
        	"NS_TITC, " +
        	"I_TITC_EXS_GAR_DEP, " +
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
        	":iTipoItvt, " +
        	":nsTitc, " +
        	":iTitcExsGarDep, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        setQueryArgument( "iTipoItvt", titexgdep().iTipoItvt() ) ;
        setQueryArgument( "nsTitc", titexgdep().nsTitc() ) ;
        setQueryArgument( "iTitcExsGarDep", titexgdep().iTitcExsGarDep() ) ;
        setQueryArgument( "cUsidActzUlt", titexgdep().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS-TGH201
     * called from Pghs191a.M2211AbreCrsTgh201M2211AbreCrsTgh201
     * 
     */
    public void openPghs191a820() {
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
                "I_TIPO_ITVT," +
                "NS_TITC," +
                "I_TITC_EXS_GAR_DEP," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS20101_TITEXGDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "(I_TIPO_ITVT > :iTipoItvt OR " +
                "(I_TIPO_ITVT = :iTipoItvt AND NS_TITC >= :nsTitc))" +
            " ORDER BY " +
                "I_TIPO_ITVT ASC," +
                "NS_TITC ASC" ;
        BaseCursorHandler c = addCursor("CRS-TGH201", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", titexgdep().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        c.setArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        c.setArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        c.setArgument( "iTipoItvt", titexgdep().iTipoItvt() ) ;
        c.setArgument( "nsTitc", titexgdep().nsTitc() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH20101_TITEXGDEP
     * called from Pghs193a.M2910ObtemTitAbrangM2910ObtemTitAbrang
     * 
     * @param pWsITitcExsGarDep
     * @param pWsCountTitAbrgd
     */
    public void selectPghs193a1627(IString pWsITitcExsGarDep, IInt pWsCountTitAbrgd) {
        sqlSttmt = "SELECT  " +
                "COUNT(*)" +
            " FROM VWSDGHPS20101_TITEXGDEP" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "I_TITC_EXS_GAR_DEP = :wsITitcExsGarDep" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        setQueryArgument( "wsITitcExsGarDep", pWsITitcExsGarDep ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsCountTitAbrgd.set(getQueryReturnedInteger(1)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH20101_TITEXGDEP
     * called from Pghs191a.M2213AtlzTitAbgdM2213AtlzTitAbgd
     * 
     * @param pConNaoAbrangido
     */
    public void updatePghs191a1016(String pConNaoAbrangido) {
        sqlSttmt = "UPDATE VWSDGHPS20101_TITEXGDEP " +
            "SET I_TITC_EXS_GAR_DEP = :conNaoAbrangido, " +
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
                "I_TIPO_ITVT = :iTipoItvt AND " +
                "NS_TITC = :nsTitc" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        setQueryArgument( "iTipoItvt", titexgdep().iTipoItvt() ) ;
        setQueryArgument( "nsTitc", titexgdep().nsTitc() ) ;
        setQueryArgument( "conNaoAbrangido", pConNaoAbrangido ) ;
        setQueryArgument( "cUsidActzUlt", titexgdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH20101_TITEXGDEP
     * called from Pghs193a.M2222AtlzTitAbrangdsM2222AtlzTitAbrangds
     * 
     */
    public void updatePghs193a1116() {
        sqlSttmt = "UPDATE VWSDGHPS20101_TITEXGDEP " +
            "SET I_TITC_EXS_GAR_DEP = :iTitcExsGarDep, " +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        setQueryArgument( "iTitcExsGarDep", titexgdep().iTitcExsGarDep() ) ;
        setQueryArgument( "cUsidActzUlt", titexgdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH20101_TITEXGDEP
     * called from Pghs193a.M2310AtualizaTgh201M2310AtualizaTgh201
     * 
     */
    public void updatePghs193a1201() {
        sqlSttmt = "UPDATE VWSDGHPS20101_TITEXGDEP " +
            "SET I_TITC_EXS_GAR_DEP = :iTitcExsGarDep, " +
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
                "I_TIPO_ITVT = :iTipoItvt AND " +
                "NS_TITC = :nsTitc" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", titexgdep().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", titexgdep().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", titexgdep().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", titexgdep().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", titexgdep().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", titexgdep().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", titexgdep().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", titexgdep().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", titexgdep().nsMovimento() ) ;
        setQueryArgument( "iTipoItvt", titexgdep().iTipoItvt() ) ;
        setQueryArgument( "nsTitc", titexgdep().nsTitc() ) ;
        setQueryArgument( "iTitcExsGarDep", titexgdep().iTitcExsGarDep() ) ;
        setQueryArgument( "cUsidActzUlt", titexgdep().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
}
