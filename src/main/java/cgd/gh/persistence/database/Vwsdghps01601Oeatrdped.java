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
public abstract class Vwsdghps01601Oeatrdped extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Oeatrdped
     */
    @Data
    public abstract Oeatrdped oeatrdped() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH01601_OEATRDPED
     * 
     * @version 2.0
     * 
     */
    public interface Oeatrdped extends IDataStruct {
        
        /**
         * TS_PEDIDO
         */
        @Column(name="TS_PEDIDO")
        @Key
        @Data(size=15, signed=true, compression=COMP3)
        ILong tsPedido() ;
        
        /**
         * C_PAIS_ISOA_DEST
         */
        @Column(name="C_PAIS_ISOA_DEST")
        @Key
        @Data(size=3)
        IString cPaisIsoaDest() ;
        
        /**
         * C_MNEM_EGC_DEST
         */
        @Column(name="C_MNEM_EGC_DEST")
        @Key
        @Data(size=3)
        IString cMnemEgcDest() ;
        
        /**
         * C_OE_EGC_DEST
         */
        @Column(name="C_OE_EGC_DEST")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcDest() ;
        
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
         * extracted method to encapsulate CLOSE access to cursor C1
         * called from Pghq016a.A33400CloseCursorC1A33400CloseCursorC1
         * 
         */
        public void closePghq016a707() {
            BaseCursorHandler c = getCursor("C1") ;
            c.close() ;
        }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate CLOSE access to cursor C1
         * called from Pghq206a.A32600CloseC1A32600CloseC1
         * 
         */
        public void closePghq206a681() {
            BaseCursorHandler c = getCursor("C1") ;
            c.close() ;
        }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate CLOSE access to cursor C1
         * called from Pghq207a.A31400CloseCursorC1A31400CloseCursorC1
         * 
         */
        public void closePghq207a943() {
            BaseCursorHandler c = getCursor("C1") ;
            c.close() ;
        }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH01601_OEATRDPED
     * called from Pghq016a.A31000DelTgh016A31000DelTgh016
     * 
     */
    public void deletePghq016a591() {
        sqlSttmt = "DELETE FROM VWSDGHPS01601_OEATRDPED " +
            " WHERE " +
                "TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_DEST = :cPaisIsoaDest AND " +
                "C_MNEM_EGC_DEST = :cMnemEgcDest AND " +
                "C_OE_EGC_DEST = :cOeEgcDest" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        setQueryArgument( "cPaisIsoaDest", oeatrdped().cPaisIsoaDest() ) ;
        setQueryArgument( "cMnemEgcDest", oeatrdped().cMnemEgcDest() ) ;
        setQueryArgument( "cOeEgcDest", oeatrdped().cOeEgcDest() ) ;
        executeUpdate() ;
    }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate FETCH access to cursor C1
         * called from Pghq016a.A33200FetchCursorC1A33200FetchCursorC1
         * 
         */
        public void fetchPghq016a672() {
            BaseCursorHandler c = getCursor("C1") ;
            c.fetch() ;
            if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
                oeatrdped().tsPedido().set(c.getValue("TS_PEDIDO")) ;
                oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
                oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
                oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
            }
        }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate FETCH access to cursor C1
         * called from Pghq206a.A32200FetchC1A32200FetchC1
         * 
         */
        public void fetchPghq206a650() {
            BaseCursorHandler c = getCursor("C1") ;
            c.fetch() ;
            if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
                oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
                oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
                oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
            }
        }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate FETCH access to cursor C1
         * called from Pghq207a.A31200FetchCursorC1A31200FetchCursorC1
         * 
         */
        public void fetchPghq207a791() {
            BaseCursorHandler c = getCursor("C1") ;
            c.fetch() ;
            if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
                oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
                oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
                oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
            }
        }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq016a.A33100OpenCursorC1A33100OpenCursorC1
     * 
     * @param pWsDataCorrente
     */
    public void openPghq016a645(IString pWsDataCorrente) {
        sqlSttmt = "SELECT  " +
                "A.TS_PEDIDO," +
                "A.C_PAIS_ISOA_DEST," +
                "A.C_MNEM_EGC_DEST," +
                "A.C_OE_EGC_DEST" +
            " FROM VWSDGHPS01601_OEATRDPED AS A, VWSDGHPS01501_PEDMOVHST AS B" +
            " WHERE " +
                "B.Z_ELIMINACAO, :wsDataCorrente AND " +
                "B.Z_ELIMINACAO <> '0001-01-01' AND " +
                "B.TS_PEDIDO = A.TS_PEDIDO" +
            " GROUP BY " +
                "A.TS_PEDIDO," +
                "A.C_PAIS_ISOA_DEST," +
                "A.C_MNEM_EGC_DEST," +
                "A.C_OE_EGC_DEST" ;
            BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
            c.setArgument( "wsDataCorrente", pWsDataCorrente ) ;
            c.open() ;
        }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate OPEN access to cursor C1
         * called from Pghq206a.A32100AbrirC1A32100AbrirC1
         * 
         */
        public void openPghq206a624() {
            sqlSttmt = "SELECT  " +
                    "C_PAIS_ISOA_DEST," +
                    "C_MNEM_EGC_DEST," +
                    "C_OE_EGC_DEST" +
                " FROM VWSDGHPS01601_OEATRDPED" +
                " WHERE " +
                    "TS_PEDIDO = :tsPedido"  +
                " ORDER BY " +
                    "C_PAIS_ISOA_DEST ASC," +
                    "C_MNEM_EGC_DEST ASC," +
                    "C_OE_EGC_DEST ASC" ;
            BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
            c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
            c.open() ;
        }
        
        /**
         * 
         * Migration Note:
         * extracted method to encapsulate OPEN access to cursor C1
         * called from Pghq207a.A31100OpenCursorC1A31100OpenCursorC1
         * 
         */
        public void openPghq207a762() {
            sqlSttmt = "SELECT  " +
                    "C_PAIS_ISOA_DEST," +
                    "C_MNEM_EGC_DEST," +
                    "C_OE_EGC_DEST" +
                " FROM VWSDGHPS01601_OEATRDPED" +
                " WHERE " +
                    "TS_PEDIDO = :tsPedido"  +
                " ORDER BY " +
                    "C_PAIS_ISOA_DEST ASC," +
                    "C_MNEM_EGC_DEST ASC," +
                    "C_OE_EGC_DEST ASC" ;
            BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
            c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
            c.open() ;
        }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq480a.A31370CloseC1A31370CloseC1
     * 
     */
    public void closePghq480a680() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq580a.A31370CloseC1A31370CloseC1
     * 
     */
    public void closePghq580a618() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq680a.A31370CloseC1A31370CloseC1
     * 
     */
    public void closePghq680a615() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq780a.A31370CloseC1A31370CloseC1
     * 
     */
    public void closePghq780a615() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq480a.A31350FetchC1A31350FetchC1
     * 
     */
    public void fetchPghq480a649() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq580a.A31350FetchC1A31350FetchC1
     * 
     */
    public void fetchPghq580a587() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq680a.A31350FetchC1A31350FetchC1
     * 
     */
    public void fetchPghq680a584() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq780a.A31350FetchC1A31350FetchC1
     * 
     */
    public void fetchPghq780a584() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01601_OEATRDPED
     * called from Pghq520a.A32300InsTgh00016A32300InsTgh00016
     * 
     */
    public void insertPghq520a867() {
        sqlSttmt = "INSERT INTO VWSDGHPS01601_OEATRDPED ( " +
        	"TS_PEDIDO, " +
        	"C_PAIS_ISOA_DEST, " +
        	"C_MNEM_EGC_DEST, " +
        	"C_OE_EGC_DEST, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":tsPedido, " +
        	":cPaisIsoaDest, " +
        	":cMnemEgcDest, " +
        	":cOeEgcDest, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        setQueryArgument( "cPaisIsoaDest", oeatrdped().cPaisIsoaDest() ) ;
        setQueryArgument( "cMnemEgcDest", oeatrdped().cMnemEgcDest() ) ;
        setQueryArgument( "cOeEgcDest", oeatrdped().cOeEgcDest() ) ;
        setQueryArgument( "cUsidActzUlt", oeatrdped().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq480a.A31330AbrirC1A31330AbrirC1
     * 
     */
    public void openPghq480a623() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_DEST," +
                "C_MNEM_EGC_DEST," +
                "C_OE_EGC_DEST" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido"  +
            " ORDER BY " +
                "C_PAIS_ISOA_DEST ASC," +
                "C_MNEM_EGC_DEST ASC," +
                "C_OE_EGC_DEST ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq580a.A31330AbrirC1A31330AbrirC1
     * 
     */
    public void openPghq580a561() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_DEST," +
                "C_MNEM_EGC_DEST," +
                "C_OE_EGC_DEST" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido"  +
            " ORDER BY " +
                "C_PAIS_ISOA_DEST ASC," +
                "C_MNEM_EGC_DEST ASC," +
                "C_OE_EGC_DEST ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq680a.A31330AbrirC1A31330AbrirC1
     * 
     */
    public void openPghq680a558() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_DEST," +
                "C_MNEM_EGC_DEST," +
                "C_OE_EGC_DEST" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido"  +
            " ORDER BY " +
                "C_PAIS_ISOA_DEST ASC," +
                "C_MNEM_EGC_DEST ASC," +
                "C_OE_EGC_DEST ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq780a.A31330AbrirC1A31330AbrirC1
     * 
     */
    public void openPghq780a558() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_DEST," +
                "C_MNEM_EGC_DEST," +
                "C_OE_EGC_DEST" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido"  +
            " ORDER BY " +
                "C_PAIS_ISOA_DEST ASC," +
                "C_MNEM_EGC_DEST ASC," +
                "C_OE_EGC_DEST ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        c.open() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs016a.A5300ListaA5300Lista
     * 
     */
    public void closeMghs016a407() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH01601_OEATRDPED
     * called from Mghs016a.A5600EliminaA5600Elimina
     * 
     */
    public void deleteMghs016a458() {
        sqlSttmt = "DELETE FROM VWSDGHPS01601_OEATRDPED " +
            " WHERE " +
                "TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_DEST = :cPaisIsoaDest AND " +
                "C_MNEM_EGC_DEST = :cMnemEgcDest AND " +
                "C_OE_EGC_DEST = :cOeEgcDest" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        setQueryArgument( "cPaisIsoaDest", oeatrdped().cPaisIsoaDest() ) ;
        setQueryArgument( "cMnemEgcDest", oeatrdped().cMnemEgcDest() ) ;
        setQueryArgument( "cOeEgcDest", oeatrdped().cOeEgcDest() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs016a.A5300ListaA5300Lista
     * 
     */
    public void fetchMghs016a357() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
            oeatrdped().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            oeatrdped().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs016a.A5300ListaA5300Lista
     * 
     */
    public void fetchMghs016a389() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            oeatrdped().cPaisIsoaDest().set(c.getValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(c.getValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(c.getValue("C_OE_EGC_DEST")) ;
            oeatrdped().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            oeatrdped().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01601_OEATRDPED
     * called from Mghs016a.A5500InsereA5500Insere
     * 
     */
    public void insertMghs016a420() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "INSERT INTO VWSDGHPS01601_OEATRDPED ( " +
        	"TS_PEDIDO, " +
        	"C_PAIS_ISOA_DEST, " +
        	"C_MNEM_EGC_DEST, " +
        	"C_OE_EGC_DEST, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":tsPedido, " +
        	":cPaisIsoaDest, " +
        	":cMnemEgcDest, " +
        	":cOeEgcDest, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        setQueryArgument( "cPaisIsoaDest", oeatrdped().cPaisIsoaDest() ) ;
        setQueryArgument( "cMnemEgcDest", oeatrdped().cMnemEgcDest() ) ;
        setQueryArgument( "cOeEgcDest", oeatrdped().cOeEgcDest() ) ;
        setQueryArgument( "cUsidActzUlt", oeatrdped().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs016a.A5300ListaA5300Lista
     * 
     */
    public void openMghs016a345() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO," +
                "C_PAIS_ISOA_DEST," +
                "C_MNEM_EGC_DEST," +
                "C_OE_EGC_DEST," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido AND C_OE_EGC_DEST > :cOeEgcDest"  +
            " ORDER BY " +
                "C_OE_EGC_DEST ASC" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        c.setArgument( "cOeEgcDest", oeatrdped().cOeEgcDest() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01601_OEATRDPED
     * called from Mghs016a.A5200ConsultaA5200Consulta
     * 
     */
    public void selectMghs016a243() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO," +
                "C_PAIS_ISOA_DEST," +
                "C_MNEM_EGC_DEST," +
                "C_OE_EGC_DEST," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido AND C_MNEM_EGC_DEST = :cMnemEgcDest AND " +
                "C_OE_EGC_DEST = :cOeEgcDest" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        setQueryArgument( "cMnemEgcDest", oeatrdped().cMnemEgcDest() ) ;
        setQueryArgument( "cOeEgcDest", oeatrdped().cOeEgcDest() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            oeatrdped().tsPedido().set(getQueryReturnedValue("TS_PEDIDO")) ;
            oeatrdped().cPaisIsoaDest().set(getQueryReturnedValue("C_PAIS_ISOA_DEST")) ;
            oeatrdped().cMnemEgcDest().set(getQueryReturnedValue("C_MNEM_EGC_DEST")) ;
            oeatrdped().cOeEgcDest().set(getQueryReturnedValue("C_OE_EGC_DEST")) ;
            oeatrdped().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            oeatrdped().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01601_OEATRDPED
     * called from Mghs016a.A5610VerificaPedidosA5610VerificaPedidos
     * 
     * @param pWsCount
     */
    public void selectMghs016a489(ILong pWsCount) {
        sqlSttmt = "SELECT  " +
                "COUNT(*)" +
            " FROM VWSDGHPS01601_OEATRDPED" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", oeatrdped().tsPedido() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsCount.set(getQueryReturnedInteger(1)) ;
        }
    }
}
