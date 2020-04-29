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
public abstract class Vwsdghps50001Infhst extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Infhst
     */
    @Data
    public abstract Infhst infhst() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH50001_INFHST
     * 
     * @version 2.0
     * 
     */
    public interface Infhst extends IDataStruct {
        
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
         * TS_MOVIMENTO
         */
        @Column(name="TS_MOVIMENTO", type=java.sql.Timestamp.class)
        @Key
        @Data(size=26)
        IString tsMovimento() ;
        
        /**
         * NS_MOVIMENTO
         */
        @Column(name="NS_MOVIMENTO")
        @Key
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        /**
         * Z_VAL_MOV
         */
        @Column(name="Z_VAL_MOV", type=java.sql.Date.class)
        @Data(size=10)
        IString zValMov() ;
        
        /**
         * Z_MOV_LOCL
         */
        @Column(name="Z_MOV_LOCL", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovLocl() ;
        
        /**
         * I_DBCR
         */
        @Column(name="I_DBCR")
        @Data(size=1)
        IString iDbcr() ;
        
        /**
         * M_MOVIMENTO
         */
        @Column(name="M_MOVIMENTO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        /**
         * I_ESTORNO
         */
        @Column(name="I_ESTORNO")
        @Data(size=1)
        IString iEstorno() ;
        
        /**
         * C_MOED_ISO_ORI_MOV
         */
        @Column(name="C_MOED_ISO_ORI_MOV")
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        /**
         * M_SLDO_CBLO_APOS
         */
        @Column(name="M_SLDO_CBLO_APOS")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloApos() ;
        
        /**
         * M_SLDO_DPNL_APOS
         */
        @Column(name="M_SLDO_DPNL_APOS")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnlApos() ;
        
        /**
         * M_MOV_MOE_ORIG_MOV
         */
        @Column(name="M_MOV_MOE_ORIG_MOV")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        /**
         * X_REF_MOV
         */
        @Column(name="X_REF_MOV")
        @Data(size=21)
        IString xRefMov() ;
        
        /**
         * N_DOC_OPPS
         */
        @Column(name="N_DOC_OPPS")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nDocOpps() ;
        
        /**
         * T_JURO
         */
        @Column(name="T_JURO")
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tJuro() ;
        
        /**
         * A_APL_ORIG
         */
        @Column(name="A_APL_ORIG")
        @Data(size=2)
        IString aAplOrig() ;
        
        /**
         * I_EXIS_INF_ADI
         */
        @Column(name="I_EXIS_INF_ADI")
        @Data(size=1)
        IString iExisInfAdi() ;
        
        /**
         * X_CHAV_ACS_INF_ADI
         */
        @Column(name="X_CHAV_ACS_INF_ADI")
        @Data(size=40)
        IString xChavAcsInfAdi() ;
        
        /**
         * Z_ELIMINACAO
         */
        @Column(name="Z_ELIMINACAO", type=java.sql.Date.class)
        @Data(size=10)
        IString zEliminacao() ;
        
        /**
         * TS_PEDIDO
         */
        @Column(name="TS_PEDIDO")
        @Data(size=15, signed=true, compression=COMP3)
        ILong tsPedido() ;
        
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
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq550a.A33400CloseCursorC1A33400CloseCursorC1
     * 
     */
    public void closePghq550a1036() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH50001_INFHST
     * called from Pghq550a.A31000DelInfHstPrincA31000DelInfHstPrinc
     * 
     */
    public void deletePghq550a702() {
        sqlSttmt = "DELETE FROM VWSDGHPS50001_INFHST " +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento AND " +
                "Z_ELIMINACAO = :zEliminacao" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhst().nsMovimento() ) ;
        setQueryArgument( "zEliminacao", infhst().zEliminacao(), java.sql.Date.class ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq550a.A33200FetchCursorC1A33200FetchCursorC1
     * 
     */
    public void fetchPghq550a976() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            infhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH50001_INFHST
     * called from Pghq390a.A32000InserirVgh50001A32000InserirVgh50001
     * 
     */
    public void insertPghq390a613() {
        sqlSttmt = "INSERT INTO VWSDGHPS50001_INFHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"TS_MOVIMENTO, " +
        	"NS_MOVIMENTO, " +
        	"Z_VAL_MOV, " +
        	"Z_MOV_LOCL, " +
        	"I_DBCR, " +
        	"M_MOVIMENTO, " +
        	"I_ESTORNO, " +
        	"C_MOED_ISO_ORI_MOV, " +
        	"M_SLDO_CBLO_APOS, " +
        	"M_SLDO_DPNL_APOS, " +
        	"M_MOV_MOE_ORIG_MOV, " +
        	"X_REF_MOV, " +
        	"N_DOC_OPPS, " +
        	"T_JURO, " +
        	"A_APL_ORIG, " +
        	"I_EXIS_INF_ADI, " +
        	"X_CHAV_ACS_INF_ADI, " +
        	"Z_ELIMINACAO, " +
        	"TS_PEDIDO, " +
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
        	":tsMovimento, " +
        	":nsMovimento, " +
        	":zValMov, " +
        	":zMovLocl, " +
        	":iDbcr, " +
        	":mMovimento, " +
        	":iEstorno, " +
        	":cMoedIsoOriMov, " +
        	":mSldoCbloApos, " +
        	":mSldoDpnlApos, " +
        	":mMovMoeOrigMov, " +
        	":xRefMov, " +
        	":nDocOpps, " +
        	":tJuro, " +
        	":aAplOrig, " +
        	":iExisInfAdi, " +
        	":xChavAcsInfAdi, " +
        	":zEliminacao, " +
        	":tsPedido, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhst().nsMovimento() ) ;
        setQueryArgument( "zValMov", infhst().zValMov(), java.sql.Date.class ) ;
        setQueryArgument( "zMovLocl", infhst().zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", infhst().iDbcr() ) ;
        setQueryArgument( "mMovimento", infhst().mMovimento() ) ;
        setQueryArgument( "iEstorno", infhst().iEstorno() ) ;
        setQueryArgument( "cMoedIsoOriMov", infhst().cMoedIsoOriMov() ) ;
        setQueryArgument( "mSldoCbloApos", infhst().mSldoCbloApos() ) ;
        setQueryArgument( "mSldoDpnlApos", infhst().mSldoDpnlApos() ) ;
        setQueryArgument( "mMovMoeOrigMov", infhst().mMovMoeOrigMov() ) ;
        setQueryArgument( "xRefMov", infhst().xRefMov() ) ;
        setQueryArgument( "nDocOpps", infhst().nDocOpps() ) ;
        setQueryArgument( "tJuro", infhst().tJuro() ) ;
        setQueryArgument( "aAplOrig", infhst().aAplOrig() ) ;
        setQueryArgument( "iExisInfAdi", infhst().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", infhst().xChavAcsInfAdi() ) ;
        setQueryArgument( "zEliminacao", infhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", infhst().tsPedido() ) ;
        setQueryArgument( "tsActzUlt", infhst().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", infhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq550a.A33100OpenCursorC1A33100OpenCursorC1
     * 
     * @param pWsDataCorrente
     */
    public void openPghq550a949(IString pWsDataCorrente) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "Z_ELIMINACAO," +
                "TS_PEDIDO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS50001_INFHST" +
            " WHERE " +
                "Z_ELIMINACAO < :wsDataCorrente"  +
            " ORDER BY " +
                "C_PAIS_ISOA_CONT ASC," +
                "C_BANC_CONT ASC," +
                "C_OE_EGC_CONT ASC," +
                "NS_RDCL_CONT ASC," +
                "V_CHKD_CONT ASC," +
                "C_TIPO_CONT ASC," +
                "C_MOED_ISO_SCTA ASC," +
                "NS_DEPOSITO ASC," +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "wsDataCorrente", pWsDataCorrente, java.sql.Date.class ) ;
        c.open() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs500a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void closeMghs500a1083() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs500a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void closeMghs500a615() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Mghs500a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void closeMghs500a771() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs500a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void closeMghs500a927() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs500a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs500a1040() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs500a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs500a483() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs500a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs500a572() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs500a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs500a639() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs500a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs500a728() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs500a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs500a795() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs500a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs500a884() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs500a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs500a951() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            infhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            infhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            infhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            infhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            infhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            infhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            infhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            infhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            infhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            infhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            infhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            infhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            infhst().iDbcr().set(c.getValue("I_DBCR")) ;
            infhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            infhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            infhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            infhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            infhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            infhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            infhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            infhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            infhst().tJuro().set(c.getValue("T_JURO")) ;
            infhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            infhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            infhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI")) ;
            infhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            infhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs500a.A5200ListaAscDataA5200ListaAscData
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs500a471(IString pWsTsInicio, IString pWsTsFim) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS50001_INFHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "NS_MOVIMENTO > :nsMovimento AND " +
                "TS_MOVIMENTO <= :wsTsFim" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", infhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", infhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", infhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", infhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", infhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", infhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", infhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", infhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", infhst().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Mghs500a.A5300ListaAscMovA5300ListaAscMov
     * 
     * @param pWsNsMovMin
     * @param pWsNsMovMax
     */
    public void openMghs500a627(ILong pWsNsMovMin, ILong pWsNsMovMax) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS50001_INFHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO >= :wsNsMovMin AND " +
                "NS_MOVIMENTO <= :wsNsMovMax" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", infhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", infhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", infhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", infhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", infhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", infhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", infhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", infhst().nsDeposito() ) ;
        c.setArgument( "wsNsMovMin", pWsNsMovMin ) ;
        c.setArgument( "wsNsMovMax", pWsNsMovMax ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs500a.A5400ListaDscDataA5400ListaDscData
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs500a783(IString pWsTsInicio, IString pWsTsFim) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS50001_INFHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsInicio AND " +
                "NS_MOVIMENTO < :nsMovimento AND " +
                "TS_MOVIMENTO >= :wsTsFim" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", infhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", infhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", infhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", infhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", infhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", infhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", infhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", infhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", infhst().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs500a.A5500ListaDscMovA5500ListaDscMov
     * 
     * @param pWsNsMovMax
     * @param pWsNsMovMin
     */
    public void openMghs500a939(ILong pWsNsMovMax, ILong pWsNsMovMin) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS50001_INFHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO <= :wsNsMovMax AND " +
                "NS_MOVIMENTO >= :wsNsMovMin" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", infhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", infhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", infhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", infhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", infhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", infhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", infhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", infhst().nsDeposito() ) ;
        c.setArgument( "wsNsMovMax", pWsNsMovMax ) ;
        c.setArgument( "wsNsMovMin", pWsNsMovMin ) ;
        c.open() ;
    }
}
