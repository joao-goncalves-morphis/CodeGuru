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
 * External
 */
import cgd.gh.persistence.database.Vwsdghps00201Movhst.Movhst ;
import cgd.gh.persistence.database.Vwsdghps02301Movhist3.Movhist3 ;
import cgd.gh.persistence.database.Vwsdghps02401Movhist4.Movhist4 ;
import cgd.gh.persistence.database.Vwsdghps02501Movhist5.Movhist5 ;
import cgd.gh.persistence.database.Vwsdghps02601Movhist6.Movhist6 ;
import cgd.gh.persistence.database.Vwsdghps02701Movhist7.Movhist7 ;
import cgd.gh.persistence.database.Vwsdghps02801Movhist8.Movhist8 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps00801Refmcbl extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Refmcbl
     */
    @Data
    public abstract Refmcbl refmcbl() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH00801_REFMCBL
     * 
     * @version 2.0
     * 
     */
    public interface Refmcbl extends IDataStruct {
        
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
         * X_RCNZ_MCBL_PRIM
         */
        @Column(name="X_RCNZ_MCBL_PRIM", type=byte[].class)
        @Data(size=16)
        IString xRcnzMcblPrim() ;
        
        /**
         * X_RCNZ_MCBL_SEGN
         */
        @Column(name="X_RCNZ_MCBL_SEGN", type=byte[].class)
        @Data(size=16)
        IString xRcnzMcblSegn() ;
        
        /**
         * X_RCNZ_MCBL_TERC
         */
        @Column(name="X_RCNZ_MCBL_TERC", type=byte[].class)
        @Data(size=35)
        IString xRcnzMcblTerc() ;
        
        /**
         * Z_MOVIMENTO
         */
        @Column(name="Z_MOVIMENTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovimento() ;
        
        /**
         * C_PAIS_ISOA_OE_OPX
         */
        @Column(name="C_PAIS_ISOA_OE_OPX")
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        /**
         * C_MNEM_EGC_OPEX
         */
        @Column(name="C_MNEM_EGC_OPEX")
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        /**
         * C_OE_EGC_OPEX
         */
        @Column(name="C_OE_EGC_OPEX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        /**
         * C_USERID
         */
        @Column(name="C_USERID")
        @Data(size=8)
        IString cUserid() ;
        
        /**
         * N_JOUR_BBN
         */
        @Column(name="N_JOUR_BBN")
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        /**
         * NS_JOUR_BBN
         */
        @Column(name="NS_JOUR_BBN")
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        /**
         * NS_JOUR_BBN_DTLH
         */
        @Column(name="NS_JOUR_BBN_DTLH")
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
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
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq023a.A31327AcedeTgh00008A31327AcedeTgh00008
     * 
     * @param pMovhist3
     */
    public void selectPghq023a1720(Movhist3 pMovhist3) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhist3.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhist3.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhist3.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhist3.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhist3.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhist3.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhist3.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhist3.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhist3.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhist3.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq024a.A31327AcedeTgh00008A31327AcedeTgh00008
     * 
     * @param pMovhist4
     */
    public void selectPghq024a1717(Movhist4 pMovhist4) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhist4.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhist4.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhist4.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhist4.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhist4.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhist4.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhist4.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhist4.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhist4.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhist4.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq025a.A31327AcedeTgh00008A31327AcedeTgh00008
     * 
     * @param pMovhist5
     */
    public void selectPghq025a1717(Movhist5 pMovhist5) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhist5.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhist5.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhist5.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhist5.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhist5.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhist5.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhist5.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhist5.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhist5.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhist5.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq026a.A31327AcedeTgh00008A31327AcedeTgh00008
     * 
     * @param pMovhist6
     */
    public void selectPghq026a1713(Movhist6 pMovhist6) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhist6.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhist6.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhist6.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhist6.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhist6.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhist6.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhist6.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhist6.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhist6.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhist6.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq027a.A31327AcedeTgh00008A31327AcedeTgh00008
     * 
     * @param pMovhist7
     */
    public void selectPghq027a1715(Movhist7 pMovhist7) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhist7.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhist7.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhist7.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhist7.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhist7.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhist7.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhist7.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhist7.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhist7.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhist7.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq028a.A31327AcedeTgh00008A31327AcedeTgh00008
     * 
     * @param pMovhist8
     */
    public void selectPghq028a1719(Movhist8 pMovhist8) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhist8.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhist8.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhist8.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhist8.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhist8.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhist8.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhist8.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhist8.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhist8.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhist8.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq202a.A34100AcedeTgh00008A34100AcedeTgh00008
     * 
     */
    public void selectPghq202a1800() {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "nsDeposito", refmcbl().nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Pghq500a.A31329AcedeTgh00008A31329AcedeTgh00008
     * 
     * @param pMovhst
     */
    public void selectPghq500a1898(Movhst pMovhst) {
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
                "X_RCNZ_MCBL_PRIM," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH00801_REFMCBL
     * called from Mghj008a.A5500EliminacaoA5500Eliminacao
     * 
     */
    public void deleteMghj008a1079() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "DELETE FROM VWSDGHPS00801_REFMCBL " +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", refmcbl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00801_REFMCBL
     * called from Mghj008a.A5410InsercaoA5410Insercao
     * 
     */
    public void insertMghj008a1007() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "INSERT INTO VWSDGHPS00801_REFMCBL ( " +
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
        	"X_RCNZ_MCBL_PRIM, " +
        	"X_RCNZ_MCBL_SEGN, " +
        	"X_RCNZ_MCBL_TERC, " +
        	"Z_MOVIMENTO, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"C_USERID, " +
        	"N_JOUR_BBN, " +
        	"NS_JOUR_BBN, " +
        	"NS_JOUR_BBN_DTLH, " +
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
        	":xRcnzMcblPrim, " +
        	":xRcnzMcblSegn, " +
        	":xRcnzMcblTerc, " +
        	":zMovimento, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":cUserid, " +
        	":nJourBbn, " +
        	":nsJourBbn, " +
        	":nsJourBbnDtlh, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", refmcbl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        setQueryArgument( "xRcnzMcblPrim", refmcbl().xRcnzMcblPrim() ) ;
        setQueryArgument( "xRcnzMcblSegn", refmcbl().xRcnzMcblSegn() ) ;
        setQueryArgument( "xRcnzMcblTerc", refmcbl().xRcnzMcblTerc() ) ;
        setQueryArgument( "zMovimento", refmcbl().zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "cPaisIsoaOeOpx", refmcbl().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", refmcbl().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", refmcbl().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", refmcbl().cUserid() ) ;
        setQueryArgument( "nJourBbn", refmcbl().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", refmcbl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", refmcbl().nsJourBbnDtlh() ) ;
        setQueryArgument( "cUsidActzUlt", refmcbl().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Mghj008a.A5200LeituraA5200Leitura
     * 
     */
    public void selectMghj008a801() {
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
                "X_RCNZ_MCBL_PRIM," +
                "X_RCNZ_MCBL_SEGN," +
                "X_RCNZ_MCBL_TERC," +
                "Z_MOVIMENTO," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().xRcnzMcblSegn().set(getQueryReturnedValue("X_RCNZ_MCBL_SEGN", String.class)) ;
            refmcbl().xRcnzMcblTerc().set(getQueryReturnedValue("X_RCNZ_MCBL_TERC", String.class)) ;
            refmcbl().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            refmcbl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            refmcbl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            refmcbl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            refmcbl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            refmcbl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            refmcbl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            refmcbl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00801_REFMCBL
     * called from Mghj008a.A5200LeituraA5200Leitura
     * 
     */
    public void selectMghj008a839() {
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
                "X_RCNZ_MCBL_PRIM," +
                "X_RCNZ_MCBL_SEGN," +
                "X_RCNZ_MCBL_TERC," +
                "Z_MOVIMENTO," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00801_REFMCBL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            refmcbl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            refmcbl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            refmcbl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            refmcbl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            refmcbl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            refmcbl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            refmcbl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            refmcbl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            refmcbl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            refmcbl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            refmcbl().xRcnzMcblPrim().set(getQueryReturnedValue("X_RCNZ_MCBL_PRIM", String.class)) ;
            refmcbl().xRcnzMcblSegn().set(getQueryReturnedValue("X_RCNZ_MCBL_SEGN", String.class)) ;
            refmcbl().xRcnzMcblTerc().set(getQueryReturnedValue("X_RCNZ_MCBL_TERC", String.class)) ;
            refmcbl().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            refmcbl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            refmcbl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            refmcbl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            refmcbl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            refmcbl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            refmcbl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            refmcbl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            refmcbl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00801_REFMCBL
     * called from Mghj008a.A5300ActualizacaoA5300Actualizacao
     * 
     */
    public void updateMghj008a906() {
        sqlSttmt = "UPDATE VWSDGHPS00801_REFMCBL " +
            "SET X_RCNZ_MCBL_PRIM = :xRcnzMcblPrim" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        setQueryArgument( "xRcnzMcblPrim", refmcbl().xRcnzMcblPrim() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00801_REFMCBL
     * called from Mghj008a.A5300ActualizacaoA5300Actualizacao
     * 
     */
    public void updateMghj008a938() {
        sqlSttmt = "UPDATE VWSDGHPS00801_REFMCBL " +
            "SET X_RCNZ_MCBL_SEGN = :xRcnzMcblSegn" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        setQueryArgument( "xRcnzMcblSegn", refmcbl().xRcnzMcblSegn() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00801_REFMCBL
     * called from Mghj008a.A5300ActualizacaoA5300Actualizacao
     * 
     */
    public void updateMghj008a971() {
        sqlSttmt = "UPDATE VWSDGHPS00801_REFMCBL " +
            "SET X_RCNZ_MCBL_TERC = :xRcnzMcblTerc" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", refmcbl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", refmcbl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", refmcbl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", refmcbl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", refmcbl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", refmcbl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", refmcbl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", refmcbl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", refmcbl().nsMovimento() ) ;
        setQueryArgument( "xRcnzMcblTerc", refmcbl().xRcnzMcblTerc() ) ;
        executeUpdate() ;
    }
}
