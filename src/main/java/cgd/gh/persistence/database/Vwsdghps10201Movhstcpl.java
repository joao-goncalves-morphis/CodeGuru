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
import cgd.gh.persistence.database.Vwsdghps00201Movhst.Movhst ;
import cgd.gh.persistence.files.Fgh801.RegFgh801Pghq800a ;
import cgd.gh.structures.link.Bghl204a.Commarea.DadosOutput ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps10201Movhstcpl extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhstcpl
     */
    @Data
    public abstract Movhstcpl movhstcpl() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH10201_MOVHSTCPL
     * 
     * @version 2.0
     * 
     */
    public interface Movhstcpl extends IDataStruct {
        
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
         * C_TRANSACCAO
         */
        @Column(name="C_TRANSACCAO")
        @Data(size=4)
        IString cTransaccao() ;
        
        /**
         * A_APLICACAO
         */
        @Column(name="A_APLICACAO")
        @Data(size=2)
        IString aAplicacao() ;
        
        /**
         * C_OPCZ_MENU
         */
        @Column(name="C_OPCZ_MENU")
        @Data(size=3)
        IString cOpczMenu() ;
        
        /**
         * C_OPE_BBN
         */
        @Column(name="C_OPE_BBN")
        @Data(size=5)
        IString cOpeBbn() ;
        
        /**
         * C_EVEN_OPEL
         */
        @Column(name="C_EVEN_OPEL")
        @Data(size=4)
        IString cEvenOpel() ;
        
        /**
         * C_TERMINAL
         */
        @Column(name="C_TERMINAL")
        @Data(size=4)
        IString cTerminal() ;
        
        /**
         * C_OPERADOR
         */
        @Column(name="C_OPERADOR")
        @Data(size=6, signed=true, compression=COMP3)
        IInt cOperador() ;
        
        /**
         * C_OPEX_ATRX
         */
        @Column(name="C_OPEX_ATRX")
        @Data(size=6, signed=true, compression=COMP3)
        IInt cOpexAtrx() ;
        
        /**
         * C_USERID
         */
        @Column(name="C_USERID")
        @Data(size=8)
        IString cUserid() ;
        
        /**
         * C_TIPO_CANL_ACES
         */
        @Column(name="C_TIPO_CANL_ACES")
        @Data(size=4)
        IString cTipoCanlAces() ;
        
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
         * C_PROD_SGOP
         */
        @Column(name="C_PROD_SGOP")
        @Data(size=9, signed=true, compression=COMP3)
        ILong cProdSgop() ;
        
        /**
         * C_FAMI_PROD
         */
        @Column(name="C_FAMI_PROD")
        @Data(size=3)
        IString cFamiProd() ;
        
        /**
         * C_PRODUTO
         */
        @Column(name="C_PRODUTO")
        @Data(size=3)
        IString cProduto() ;
        
        /**
         * C_CNDZ_MOVZ_CONT
         */
        @Column(name="C_CNDZ_MOVZ_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cCndzMovzCont() ;
        
        /**
         * C_GRUP_CONT
         */
        @Column(name="C_GRUP_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cGrupCont() ;
        
        /**
         * C_TIPO_ITTZ
         */
        @Column(name="C_TIPO_ITTZ")
        @Data(size=7, signed=true, compression=COMP3)
        IInt cTipoIttz() ;
        
        /**
         * T_CAMBIO
         */
        @Column(name="T_CAMBIO")
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambio() ;
        
        /**
         * M_SLDO_RETD
         */
        @Column(name="M_SLDO_RETD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetd() ;
        
        /**
         * M_SLDO_VCOB
         */
        @Column(name="M_SLDO_VCOB")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcob() ;
        
        /**
         * M_CMRG_LIM
         */
        @Column(name="M_CMRG_LIM")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        /**
         * M_CMRG_UTID
         */
        @Column(name="M_CMRG_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtid() ;
        
        /**
         * M_DCBO_NGCD_ATRD
         */
        @Column(name="M_DCBO_NGCD_ATRD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdAtrd() ;
        
        /**
         * M_DCBO_NGCD_UTID
         */
        @Column(name="M_DCBO_NGCD_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdUtid() ;
        
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
         * NM_ARQV_ORIG
         */
        @Column(name="NM_ARQV_ORIG")
        @Data(size=8)
        IString nmArqvOrig() ;
        
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
        
        /**
         * C_CATG_MOV
         */
        @Column(name="C_CATG_MOV")
        @Data(size=3)
        IString cCatgMov() ;
        
    }
    
    /**
     * BatchQ1
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Pghq206a.A35600CloseC3A35600CloseC3
     * 
     */
    public void closePghq206a1055() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Pghq206a.A35200FetchC3A35200FetchC3
     * 
     */
    public void fetchPghq206a796() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhstcpl().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhstcpl().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhstcpl().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhstcpl().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhstcpl().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhstcpl().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhstcpl().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhstcpl().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movhstcpl().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH10201_MOVHSTCPL
     * called from Pghq002a.A30002InsVgh10201MovhstcplA30002InsVgh10201Movhstcpl
     * 
     */
    public void insertPghq002a1240() {
        sqlSttmt = "INSERT INTO VWSDGHPS10201_MOVHSTCPL ( " +
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
        	"C_TRANSACCAO, " +
        	"A_APLICACAO, " +
        	"C_OPCZ_MENU, " +
        	"C_OPE_BBN, " +
        	"C_EVEN_OPEL, " +
        	"C_TERMINAL, " +
        	"C_OPERADOR, " +
        	"C_OPEX_ATRX, " +
        	"C_USERID, " +
        	"C_TIPO_CANL_ACES, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"C_PROD_SGOP, " +
        	"C_FAMI_PROD, " +
        	"C_PRODUTO, " +
        	"C_CNDZ_MOVZ_CONT, " +
        	"C_GRUP_CONT, " +
        	"C_TIPO_ITTZ, " +
        	"T_CAMBIO, " +
        	"M_SLDO_RETD, " +
        	"M_SLDO_VCOB, " +
        	"M_CMRG_LIM, " +
        	"M_CMRG_UTID, " +
        	"M_DCBO_NGCD_ATRD, " +
        	"M_DCBO_NGCD_UTID, " +
        	"N_JOUR_BBN, " +
        	"NS_JOUR_BBN, " +
        	"NS_JOUR_BBN_DTLH, " +
        	"NM_ARQV_ORIG, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT, " +
        	"C_CATG_MOV" +
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
        	":cTransaccao, " +
        	":aAplicacao, " +
        	":cOpczMenu, " +
        	":cOpeBbn, " +
        	":cEvenOpel, " +
        	":cTerminal, " +
        	":cOperador, " +
        	":cOpexAtrx, " +
        	":cUserid, " +
        	":cTipoCanlAces, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":cProdSgop, " +
        	":cFamiProd, " +
        	":cProduto, " +
        	":cCndzMovzCont, " +
        	":cGrupCont, " +
        	":cTipoIttz, " +
        	":tCambio, " +
        	":mSldoRetd, " +
        	":mSldoVcob, " +
        	":mCmrgLim, " +
        	":mCmrgUtid, " +
        	":mDcboNgcdAtrd, " +
        	":mDcboNgcdUtid, " +
        	":nJourBbn, " +
        	":nsJourBbn, " +
        	":nsJourBbnDtlh, " +
        	":nmArqvOrig, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt, " +
        	":cCatgMov" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", movhstcpl().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", movhstcpl().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", movhstcpl().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", movhstcpl().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", movhstcpl().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", movhstcpl().cTerminal() ) ;
        setQueryArgument( "cOperador", movhstcpl().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", movhstcpl().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", movhstcpl().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", movhstcpl().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcpl().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcpl().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcpl().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", movhstcpl().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", movhstcpl().cFamiProd() ) ;
        setQueryArgument( "cProduto", movhstcpl().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", movhstcpl().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", movhstcpl().cGrupCont() ) ;
        setQueryArgument( "cTipoIttz", movhstcpl().cTipoIttz() ) ;
        setQueryArgument( "tCambio", movhstcpl().tCambio() ) ;
        setQueryArgument( "mSldoRetd", movhstcpl().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", movhstcpl().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", movhstcpl().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", movhstcpl().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", movhstcpl().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", movhstcpl().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcpl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcpl().nsJourBbnDtlh() ) ;
        setQueryArgument( "nmArqvOrig", movhstcpl().nmArqvOrig() ) ;
        setQueryArgument( "tsActzUlt", movhstcpl().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhstcpl().cUsidActzUlt() ) ;
        setQueryArgument( "cCatgMov", movhstcpl().cCatgMov() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Pghq206a.A35100AbrirC3A35100AbrirC3
     * 
     * @param pWsTsMovimentoMax
     * @param pWsTsMovimentoMin
     */
    public void openPghq206a770(IString pWsTsMovimentoMax, IString pWsTsMovimentoMin) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "NS_DEPOSITO," +
                "C_MOED_ISO_SCTA," +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "C_OPE_BBN," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_MNEM_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "TS_MOVIMENTO <= :wsTsMovimentoMax AND " +
                "TS_MOVIMENTO >= :wsTsMovimentoMin AND " +
                "C_USERID = :cUserid" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcOpex", movhstcpl().cOeEgcOpex() ) ;
        c.setArgument( "wsTsMovimentoMax", pWsTsMovimentoMax, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovimentoMin", pWsTsMovimentoMin, java.sql.Timestamp.class ) ;
        c.setArgument( "cUserid", movhstcpl().cUserid() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq207a.A31310AcederMovHstCmplA31310AcederMovHstCmpl
     * 
     * @param pMovhst
     */
    public void selectPghq207a867(Movhst pMovhst) {
        sqlSttmt = "SELECT  " +
                "C_OPE_BBN," +
                "C_OPERADOR," +
                "C_USERID," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq300a.M2300SelVgh10201M2300SelVgh10201
     * 
     * @param pConAplic
     */
    public void selectPghq300a633(String pConAplic) {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "A_APLICACAO = :conAplic AND " +
                "N_JOUR_BBN = :nJourBbn" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "conAplic", pConAplic ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq300a.M2400SelVgh10201DstM2400SelVgh10201Dst
     * 
     * @param pConAplic
     */
    public void selectPghq300a718(String pConAplic) {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "A_APLICACAO = :conAplic AND " +
                "N_JOUR_BBN = :nJourBbn" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "conAplic", pConAplic ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH10201_MOVHSTCPL
     * called from Pghq003a.M2200TrataThg102M2200TrataThg102
     * 
     * @param pConTsAlterar
     */
    public void updatePghq003a589(IString pConTsAlterar) {
        sqlSttmt = "UPDATE VWSDGHPS10201_MOVHSTCPL " +
            "SET TS_MOVIMENTO = :conTsAlterar" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        setQueryArgument( "conTsAlterar", pConTsAlterar ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq504a.A31400CloseCursorC1A31400CloseCursorC1
     * 
     */
    public void closePghq504a1051() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq505a.A31400CloseCursorC1A31400CloseCursorC1
     * 
     */
    public void closePghq505a972() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq523a.A31400CloseCursorC1A31400CloseCursorC1
     * 
     */
    public void closePghq523a1312() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Pghq523a.A31400CloseCursorC3A31400CloseCursorC3
     * 
     */
    public void closePghq523a1338() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq524a.A31400CloseCursorC1A31400CloseCursorC1
     * 
     */
    public void closePghq524a947() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq504a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq504a789() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhstcpl().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhstcpl().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhstcpl().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhstcpl().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhstcpl().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhstcpl().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhstcpl().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhstcpl().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movhstcpl().cUserid().set(c.getValue("C_USERID")) ;
            movhstcpl().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movhstcpl().cProduto().set(c.getValue("C_PRODUTO")) ;
            movhstcpl().cTipoIttz().set(c.getValue("C_TIPO_ITTZ")) ;
            movhstcpl().tCambio().set(c.getValue("T_CAMBIO")) ;
            movhstcpl().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movhstcpl().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movhstcpl().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movhstcpl().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movhstcpl().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movhstcpl().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movhstcpl().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movhstcpl().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movhstcpl().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhstcpl().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq505a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq505a745() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movhstcpl().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq523a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq523a878() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhstcpl().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhstcpl().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhstcpl().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhstcpl().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhstcpl().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhstcpl().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhstcpl().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhstcpl().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movhstcpl().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Pghq523a.A31200FetchCursorC3A31200FetchCursorC3
     * 
     */
    public void fetchPghq523a988() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhstcpl().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhstcpl().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhstcpl().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhstcpl().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhstcpl().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhstcpl().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhstcpl().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhstcpl().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movhstcpl().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq524a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq524a743() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movhstcpl().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq504a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsTsMovFim
     * @param pWsTsMovInicio
     */
    public void openPghq504a760(IString pWsTsMovFim, IString pWsTsMovInicio) {
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
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_USERID," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_TIPO_ITTZ," +
                "T_CAMBIO," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsMovFim AND " +
                "TS_MOVIMENTO >= :wsTsMovInicio" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        c.setArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovInicio", pWsTsMovInicio, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq505a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsTsMovInicio
     * @param pWsTsMovFim
     */
    public void openPghq505a716(IString pWsTsMovInicio, IString pWsTsMovFim) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "C_OPE_BBN," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsMovInicio AND " +
                "TS_MOVIMENTO <= :wsTsMovFim" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        c.setArgument( "wsTsMovInicio", pWsTsMovInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq523a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openPghq523a849(IString pWsTsInicio, IString pWsTsFim) {
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
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "TS_MOVIMENTO <= :wsTsFim" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Pghq523a.A31100OpenCursorC3A31100OpenCursorC3
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openPghq523a959(IString pWsTsInicio, IString pWsTsFim) {
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
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "TS_MOVIMENTO <= :wsTsFim AND " +
                "C_OPE_BBN = :cOpeBbn" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "cOpeBbn", movhstcpl().cOpeBbn() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq524a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsTsMovFim
     * @param pWsTsMovInicio
     */
    public void openPghq524a714(IString pWsTsMovFim, IString pWsTsMovInicio) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsMovFim AND " +
                "TS_MOVIMENTO >= :wsTsMovInicio" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        c.setArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovInicio", pWsTsMovInicio, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq310a.M2310ObtemMovhstcplM2310ObtemMovhstcpl
     * 
     */
    public void selectPghq310a829() {
        sqlSttmt = "SELECT  " +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_USERID," +
                "C_TIPO_CANL_ACES" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq500a.A31310AcedeInfComplementarA31310AcedeInfComplementar
     * 
     * @param pMovhst
     */
    public void selectPghq500a979(Movhst pMovhst) {
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
                "C_TRANSACCAO," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_TERMINAL," +
                "C_OPERADOR," +
                "C_OPEX_ATRX," +
                "C_USERID," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_PROD_SGOP," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_CNDZ_MOVZ_CONT," +
                "C_GRUP_CONT," +
                "C_TIPO_ITTZ," +
                "T_CAMBIO," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "NM_ARQV_ORIG," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
            movhstcpl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhstcpl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhstcpl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhstcpl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhstcpl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhstcpl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhstcpl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhstcpl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcpl().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcpl().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcpl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq502a.A31310AcederMovHstCmplA31310AcederMovHstCmpl
     * 
     * @param pMovhst
     */
    public void selectPghq502a741(Movhst pMovhst) {
        sqlSttmt = "SELECT  " +
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "T_CAMBIO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
        }
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH10201_MOVHSTCPL
     * called from Pghqz06a.A30008EscreverHist102A30008EscreverHist102
     * 
     */
    public void insertPghqz06a1331() {
        sqlSttmt = "INSERT INTO VWSDGHPS10201_MOVHSTCPL ( " +
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
        	"C_TRANSACCAO, " +
        	"A_APLICACAO, " +
        	"C_OPCZ_MENU, " +
        	"C_OPE_BBN, " +
        	"C_EVEN_OPEL, " +
        	"C_TERMINAL, " +
        	"C_OPERADOR, " +
        	"C_OPEX_ATRX, " +
        	"C_USERID, " +
        	"C_TIPO_CANL_ACES, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"C_PROD_SGOP, " +
        	"C_FAMI_PROD, " +
        	"C_PRODUTO, " +
        	"C_CNDZ_MOVZ_CONT, " +
        	"C_GRUP_CONT, " +
        	"C_TIPO_ITTZ, " +
        	"T_CAMBIO, " +
        	"M_SLDO_RETD, " +
        	"M_SLDO_VCOB, " +
        	"M_CMRG_LIM, " +
        	"M_CMRG_UTID, " +
        	"M_DCBO_NGCD_ATRD, " +
        	"M_DCBO_NGCD_UTID, " +
        	"N_JOUR_BBN, " +
        	"NS_JOUR_BBN, " +
        	"NS_JOUR_BBN_DTLH, " +
        	"NM_ARQV_ORIG, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT, " +
        	"C_CATG_MOV" +
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
        	":cTransaccao, " +
        	":aAplicacao, " +
        	":cOpczMenu, " +
        	":cOpeBbn, " +
        	":cEvenOpel, " +
        	":cTerminal, " +
        	":cOperador, " +
        	":cOpexAtrx, " +
        	":cUserid, " +
        	":cTipoCanlAces, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":cProdSgop, " +
        	":cFamiProd, " +
        	":cProduto, " +
        	":cCndzMovzCont, " +
        	":cGrupCont, " +
        	":cTipoIttz, " +
        	":tCambio, " +
        	":mSldoRetd, " +
        	":mSldoVcob, " +
        	":mCmrgLim, " +
        	":mCmrgUtid, " +
        	":mDcboNgcdAtrd, " +
        	":mDcboNgcdUtid, " +
        	":nJourBbn, " +
        	":nsJourBbn, " +
        	":nsJourBbnDtlh, " +
        	":nmArqvOrig, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt, " +
        	":cCatgMov" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", movhstcpl().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", movhstcpl().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", movhstcpl().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", movhstcpl().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", movhstcpl().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", movhstcpl().cTerminal() ) ;
        setQueryArgument( "cOperador", movhstcpl().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", movhstcpl().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", movhstcpl().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", movhstcpl().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcpl().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcpl().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcpl().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", movhstcpl().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", movhstcpl().cFamiProd() ) ;
        setQueryArgument( "cProduto", movhstcpl().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", movhstcpl().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", movhstcpl().cGrupCont() ) ;
        setQueryArgument( "cTipoIttz", movhstcpl().cTipoIttz() ) ;
        setQueryArgument( "tCambio", movhstcpl().tCambio() ) ;
        setQueryArgument( "mSldoRetd", movhstcpl().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", movhstcpl().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", movhstcpl().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", movhstcpl().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", movhstcpl().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", movhstcpl().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcpl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcpl().nsJourBbnDtlh() ) ;
        setQueryArgument( "nmArqvOrig", movhstcpl().nmArqvOrig() ) ;
        setQueryArgument( "tsActzUlt", movhstcpl().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhstcpl().cUsidActzUlt() ) ;
        setQueryArgument( "cCatgMov", movhstcpl().cCatgMov() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghq802a.M2310ObtemNsMovM2310ObtemNsMov
     * 
     */
    public void selectPghq802a478() {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "C_USERID = :cUserid" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "cUserid", movhstcpl().cUserid() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghqz40a.M2100ObtUltMovM2100ObtUltMov
     * 
     * @param pWsDataIni
     * @param pWsDataFim
     */
    public void selectPghqz40a740(IString pWsDataIni, IString pWsDataFim) {
        sqlSttmt = "SELECT  " +
                "MAX(NS_MOVIMENTO)" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "date(TS_MOVIMENTO) >= :wsDataIni AND " +
                "date(TS_MOVIMENTO) <= :wsDataFim" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "wsDataIni", pWsDataIni ) ;
        setQueryArgument( "wsDataFim", pWsDataFim ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghqz40a.M2150ObtUltMovM2150ObtUltMov
     * 
     * @param pWsDataIni
     */
    public void selectPghqz40a811(IString pWsDataIni) {
        sqlSttmt = "SELECT  " +
                "MAX(NS_MOVIMENTO)" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "date(TS_MOVIMENTO) < :wsDataIni" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "wsDataIni", pWsDataIni ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Pghqz40a.M2200ObtMontUtilM2200ObtMontUtil
     * 
     */
    public void selectPghqz40a940() {
        sqlSttmt = "SELECT  " +
                "M_CMRG_LIM," +
                "M_CMRG_UTID" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH10201_MOVHSTCPL
     * called from Pghq800a.M2330ActzUseridM2330ActzUserid
     * 
     * @param pFgh801CPaisIsoaCont
     * @param pFgh801CBancCont
     * @param pFgh801COeEgcCont
     * @param pFgh801NsRdclCont
     * @param pFgh801VChkdCont
     * @param pFgh801CTipoCont
     * @param pFgh801CMoedIsoScta
     * @param pFgh801NsDeposito
     * @param pFgh801TsMovimento
     * @param pFgh801NsMovimento
     */
    public void updatePghq800a703(IString pFgh801CPaisIsoaCont, IInt pFgh801CBancCont, IInt pFgh801COeEgcCont, IInt pFgh801NsRdclCont, IInt pFgh801VChkdCont, IInt pFgh801CTipoCont, IString pFgh801CMoedIsoScta, IInt pFgh801NsDeposito, IString pFgh801TsMovimento, ILong pFgh801NsMovimento) {
        sqlSttmt = "UPDATE VWSDGHPS10201_MOVHSTCPL " +
            "SET C_USERID = :cUserid" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :fgh801CPaisIsoaCont AND " +
                "C_BANC_CONT = :fgh801CBancCont AND " +
                "C_OE_EGC_CONT = :fgh801COeEgcCont AND " +
                "NS_RDCL_CONT = :fgh801NsRdclCont AND " +
                "V_CHKD_CONT = :fgh801VChkdCont AND " +
                "C_TIPO_CONT = :fgh801CTipoCont AND " +
                "C_MOED_ISO_SCTA = :fgh801CMoedIsoScta AND " +
                "NS_DEPOSITO = :fgh801NsDeposito AND " +
                "TS_MOVIMENTO = :fgh801TsMovimento AND " +
                "NS_MOVIMENTO = :fgh801NsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "fgh801CPaisIsoaCont", pFgh801CPaisIsoaCont ) ;
        setQueryArgument( "fgh801CBancCont", pFgh801CBancCont ) ;
        setQueryArgument( "fgh801COeEgcCont", pFgh801COeEgcCont ) ;
        setQueryArgument( "fgh801NsRdclCont", pFgh801NsRdclCont ) ;
        setQueryArgument( "fgh801VChkdCont", pFgh801VChkdCont ) ;
        setQueryArgument( "fgh801CTipoCont", pFgh801CTipoCont ) ;
        setQueryArgument( "fgh801CMoedIsoScta", pFgh801CMoedIsoScta ) ;
        setQueryArgument( "fgh801NsDeposito", pFgh801NsDeposito ) ;
        setQueryArgument( "fgh801TsMovimento", pFgh801TsMovimento, java.sql.Timestamp.class ) ;
        setQueryArgument( "fgh801NsMovimento", pFgh801NsMovimento ) ;
        setQueryArgument( "cUserid", movhstcpl().cUserid() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH10201_MOVHSTCPL
     * called from Pghq900a.M2200ActzZMovTgh102M2200ActzZMovTgh102
     * 
     */
    public void updatePghq900a445() {
        sqlSttmt = "UPDATE VWSDGHPS10201_MOVHSTCPL " +
            "SET TS_MOVIMENTO = '2012-02-22-00.00.00.000000'" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeUpdate() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs111a.A5300AcedeTabGhA5300AcedeTabGh
     * 
     */
    public void closeMghs111a622() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs111a.A5300AcedeTabGhA5300AcedeTabGh
     * 
     */
    public void fetchMghs111a566() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcpl().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs111a.A5300AcedeTabGhA5300AcedeTabGh
     * 
     */
    public void fetchMghs111a602() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcpl().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcpl().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs111a.A5300AcedeTabGhA5300AcedeTabGh
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs111a554(IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "A_APLICACAO," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "TS_MOVIMENTO <= :wsTsFim AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 10" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "cMnemEgcOpex", movhstcpl().cMnemEgcOpex() ) ;
        c.setArgument( "cPaisIsoaOeOpx", movhstcpl().cPaisIsoaOeOpx() ) ;
        c.setArgument( "cOeEgcOpex", movhstcpl().cOeEgcOpex() ) ;
        c.setArgument( "cUserid", movhstcpl().cUserid() ) ;
        c.setArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghj008a.A5001AcedeTgh102JornalA5001AcedeTgh102Jornal
     * 
     */
    public void selectMghj008a648() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcpl().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcpl().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcpl().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movhstcpl().cUserid() ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcpl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcpl().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghj008a.A5002AcedeTgh102MovA5002AcedeTgh102Mov
     * 
     */
    public void selectMghj008a692() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", movhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghj204a.A31300Select102A31300Select102
     * 
     * @param pWsTimestampMin
     * @param pWsTimestampMax
     */
    public void selectMghj204a301(IString pWsTimestampMin, IString pWsTimestampMax) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "TS_MOVIMENTO >= :wsTimestampMin AND " +
                "TS_MOVIMENTO <= :wsTimestampMax AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh AND " +
                "(A_APLICACAO = 'NA' OR A_APLICACAO = 'NH' OR A_APLICACAO = 'NI' OR " +
                "A_APLICACAO = 'NG' OR " +
                "A_APLICACAO = 'NB' OR " +
                "A_APLICACAO = 'HB' OR " +
                "A_APLICACAO = 'NJ')" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "wsTimestampMin", pWsTimestampMin, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTimestampMax", pWsTimestampMax, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsJourBbn", movhstcpl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcpl().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghj204a.A31301Select102SdtlA31301Select102Sdtl
     * 
     * @param pWsTimestampMin
     * @param pWsTimestampMax
     */
    public void selectMghj204a389(IString pWsTimestampMin, IString pWsTimestampMax) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "TS_MOVIMENTO >= :wsTimestampMin AND " +
                "TS_MOVIMENTO <= :wsTimestampMax AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "(A_APLICACAO = 'NA' OR A_APLICACAO = 'NH' OR A_APLICACAO = 'NI' OR " +
                "A_APLICACAO = 'NG' OR " +
                "A_APLICACAO = 'NB' OR " +
                "A_APLICACAO = 'HB' OR " +
                "A_APLICACAO = 'NJ')" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "wsTimestampMin", pWsTimestampMin, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTimestampMax", pWsTimestampMax, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsJourBbn", movhstcpl().nsJourBbn() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghj204a.A32600Select102A32600Select102
     * 
     * @param pMovhst
     * @param pDadosOutput
     */
    public void selectMghj204a574(Movhst pMovhst, DadosOutput pDadosOutput) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
                "(A_APLICACAO = 'NA' OR A_APLICACAO = 'NH' OR A_APLICACAO = 'NI' OR " +
                "A_APLICACAO = 'NG' OR " +
                "A_APLICACAO = 'NB' OR " +
                "A_APLICACAO = 'HB' OR " +
                "A_APLICACAO = 'NJ')" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            pDadosOutput.cMnemEgcOpexO().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            pDadosOutput.cPaisIsoaOeOpxO().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            pDadosOutput.cUseridO().set(getQueryReturnedValue("C_USERID")) ;
            pDadosOutput.nJourBbnO().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            pDadosOutput.nsJourBbnO().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            pDadosOutput.nsJourBbnDtlhO().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs102a.A5610AcedeTgh102PA5610AcedeTgh102P
     * 
     */
    public void selectMghs102a1032() {
        sqlSttmt = "SELECT  " +
                "C_PROD_SGOP," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_CNDZ_MOVZ_CONT," +
                "C_GRUP_CONT," +
                "C_TIPO_ITTZ" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcpl().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs102a.A5710AcedeTgh102JA5710AcedeTgh102J
     * 
     */
    public void selectMghs102a1150() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs102a.A5210AcedeTgh102TA5210AcedeTgh102T
     * 
     */
    public void selectMghs102a261() {
        sqlSttmt = "SELECT  " +
                "C_TRANSACCAO," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_TERMINAL," +
                "C_OPERADOR," +
                "C_OPEX_ATRX," +
                "C_USERID," +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_PROD_SGOP," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_CNDZ_MOVZ_CONT," +
                "C_GRUP_CONT," +
                "C_TIPO_ITTZ," +
                "T_CAMBIO," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "NM_ARQV_ORIG," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcpl().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcpl().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcpl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs102a.A5310AcedeTgh102OA5310AcedeTgh102O
     * 
     */
    public void selectMghs102a568() {
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_CATG_MOV," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cCatgMov().set(getQueryReturnedValue("C_CATG_MOV")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs102a.A5410AcedeTgh102QA5410AcedeTgh102Q
     * 
     */
    public void selectMghs102a701() {
        sqlSttmt = "SELECT  " +
                "C_TRANSACCAO," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_OPERADOR," +
                "C_OPEX_ATRX," +
                "C_USERID," +
                "T_CAMBIO," +
                "NM_ARQV_ORIG," +
                "C_CATG_MOV," +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcpl().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcpl().cCatgMov().set(getQueryReturnedValue("C_CATG_MOV")) ;
            movhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs102a.A5510AcedeTgh102SA5510AcedeTgh102S
     * 
     */
    public void selectMghs102a893() {
        sqlSttmt = "SELECT  " +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "C_CATG_MOV," +
                "M_DCBO_NGCD_UTID" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcpl().cCatgMov().set(getQueryReturnedValue("C_CATG_MOV")) ;
            movhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs112a.A3300AcedeTabelaA3300AcedeTabela
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs112a428(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS10201_MOVHSTCPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "TS_MOVIMENTO <= :wsTsFim AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcpl().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcpl().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcpl().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movhstcpl().cUserid() ) ;
        setQueryArgument( "nJourBbn", movhstcpl().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcpl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcpl().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH10201_MOVHSTCPL
     * called from Mghs122a.M2100AcedeHist102M2100AcedeHist102
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pZMovLocl
     */
    public void selectMghs122a331(IString pWsTsInicio, IString pWsTsFim, IString pZMovLocl) {
        sqlSttmt = "SELECT  " +
                "A.C_TRANSACCAO," +
                "A.A_APLICACAO," +
                "A.C_OPCZ_MENU," +
                "A.C_OPE_BBN," +
                "A.C_EVEN_OPEL," +
                "A.C_TERMINAL," +
                "A.C_OPERADOR," +
                "A.C_OPEX_ATRX," +
                "A.C_USERID," +
                "A.C_TIPO_CANL_ACES," +
                "A.C_PAIS_ISOA_OE_OPX," +
                "A.C_MNEM_EGC_OPEX," +
                "A.C_OE_EGC_OPEX," +
                "A.C_PROD_SGOP," +
                "A.C_FAMI_PROD," +
                "A.C_PRODUTO," +
                "A.C_CNDZ_MOVZ_CONT," +
                "A.C_GRUP_CONT," +
                "A.C_TIPO_ITTZ," +
                "A.T_CAMBIO," +
                "A.M_SLDO_RETD," +
                "A.M_SLDO_VCOB," +
                "A.M_CMRG_LIM," +
                "A.M_CMRG_UTID," +
                "A.M_DCBO_NGCD_ATRD," +
                "A.M_DCBO_NGCD_UTID," +
                "A.N_JOUR_BBN," +
                "A.NS_JOUR_BBN," +
                "A.NS_JOUR_BBN_DTLH," +
                "A.NM_ARQV_ORIG," +
                "A.TS_ACTZ_ULT," +
                "A.C_USID_ACTZ_ULT," +
                "B.Z_MOV_LOCL" +
            " FROM VWSDGHPS10201_MOVHSTCPL AS A, VWSDGHPS00201_MOVHST AS B" +
            " WHERE " +
                "A.C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "A.C_BANC_CONT = :cBancCont AND " +
                "A.C_OE_EGC_CONT = :cOeEgcCont AND " +
                "A.NS_RDCL_CONT = :nsRdclCont AND " +
                "A.V_CHKD_CONT = :vChkdCont AND " +
                "A.C_TIPO_CONT = :cTipoCont AND " +
                "A.C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "A.NS_DEPOSITO = :nsDeposito AND " +
                "A.TS_MOVIMENTO >= :wsTsInicio AND " +
                "A.TS_MOVIMENTO <= :wsTsFim AND " +
                "A.NS_MOVIMENTO = :nsMovimento AND " +
                "A.C_PAIS_ISOA_CONT = B.C_PAIS_ISOA_CONT AND " +
                "A.C_BANC_CONT = B.C_BANC_CONT AND " +
                "A.C_OE_EGC_CONT = B.C_OE_EGC_CONT AND " +
                "A.NS_RDCL_CONT = B.NS_RDCL_CONT AND " +
                "A.V_CHKD_CONT = B.V_CHKD_CONT AND " +
                "A.C_TIPO_CONT = B.C_TIPO_CONT AND " +
                "A.C_MOED_ISO_SCTA = B.C_MOED_ISO_SCTA AND " +
                "A.NS_DEPOSITO = B.NS_DEPOSITO AND " +
                "A.NS_MOVIMENTO = B.NS_MOVIMENTO" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcpl().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcpl().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcpl().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcpl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
            pZMovLocl.set(getQueryReturnedValue("Z_MOV_LOCL", String.class)) ;
        }
    }
}
