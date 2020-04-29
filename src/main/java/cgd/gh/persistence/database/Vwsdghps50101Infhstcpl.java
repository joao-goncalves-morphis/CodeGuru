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
import cgd.gh.persistence.database.Vwsdghps50001Infhst.Infhst ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps50101Infhstcpl extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Infhstcpl
     */
    @Data
    public abstract Infhstcpl infhstcpl() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH50101_INFHSTCPL
     * 
     * @version 2.0
     * 
     */
    public interface Infhstcpl extends IDataStruct {
        
        @Column(name="C_PAIS_ISOA_CONT")
        @Key
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        @Column(name="C_BANC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        @Column(name="C_OE_EGC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        @Column(name="NS_RDCL_CONT")
        @Key
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        @Column(name="V_CHKD_CONT")
        @Key
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        @Column(name="C_TIPO_CONT")
        @Key
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        @Column(name="C_MOED_ISO_SCTA")
        @Key
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        @Column(name="NS_DEPOSITO")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        @Column(name="TS_MOVIMENTO", type=java.sql.Timestamp.class)
        @Key
        @Data(size=26)
        IString tsMovimento() ;
        
        @Column(name="NS_MOVIMENTO")
        @Key
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        @Column(name="C_TRANSACCAO")
        @Data(size=4)
        IString cTransaccao() ;
        
        @Column(name="A_APLICACAO")
        @Data(size=2)
        IString aAplicacao() ;
        
        @Column(name="C_OPCZ_MENU")
        @Data(size=3)
        IString cOpczMenu() ;
        
        @Column(name="C_OPE_BBN")
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Column(name="C_EVEN_OPEL")
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Column(name="C_TERMINAL")
        @Data(size=4)
        IString cTerminal() ;
        
        @Column(name="C_OPERADOR")
        @Data(size=6, signed=true, compression=COMP3)
        IInt cOperador() ;
        
        @Column(name="C_OPEX_ATRX")
        @Data(size=6, signed=true, compression=COMP3)
        IInt cOpexAtrx() ;
        
        @Column(name="C_USERID")
        @Data(size=8)
        IString cUserid() ;
        
        @Column(name="C_TIPO_CANL_ACES")
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Column(name="C_PAIS_ISOA_OE_OPX")
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Column(name="C_MNEM_EGC_OPEX")
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Column(name="C_OE_EGC_OPEX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        @Column(name="C_PROD_SGOP")
        @Data(size=9, signed=true, compression=COMP3)
        ILong cProdSgop() ;
        
        @Column(name="C_FAMI_PROD")
        @Data(size=3)
        IString cFamiProd() ;
        
        @Column(name="C_PRODUTO")
        @Data(size=3)
        IString cProduto() ;
        
        @Column(name="C_CNDZ_MOVZ_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cCndzMovzCont() ;
        
        @Column(name="C_GRUP_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cGrupCont() ;
        
        @Column(name="C_SECT_ITTL_BPOR")
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        @Column(name="T_CAMBIO")
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambio() ;
        
        @Column(name="M_SLDO_RETD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetd() ;
        
        @Column(name="M_SLDO_VCOB")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcob() ;
        
        @Column(name="M_CMRG_LIM")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        @Column(name="M_CMRG_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtid() ;
        
        @Column(name="M_DCBO_NGCD_ATRD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdAtrd() ;
        
        @Column(name="M_DCBO_NGCD_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdUtid() ;
        
        @Column(name="N_JOUR_BBN")
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Column(name="NS_JOUR_BBN")
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Column(name="NS_JOUR_BBN_DTLH")
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
        @Column(name="Z_ELIMINACAO", type=java.sql.Date.class)
        @Data(size=10)
        IString zEliminacao() ;
        
        @Column(name="TS_ACTZ_ULT", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsActzUlt() ;
        
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
     * extracted method to encapsulate DELETE access to table VGH50101_INFHSTCPL
     * called from Pghq550a.A31200DelInfHstComplA31200DelInfHstCompl
     * 
     */
    public void deletePghq550a739() {
        sqlSttmt = "DELETE FROM VWSDGHPS50101_INFHSTCPL " +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        setQueryArgument( "zEliminacao", infhstcpl().zEliminacao(), java.sql.Date.class ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH50101_INFHSTCPL
     * called from Pghq390a.A33000InserirVgh50101A33000InserirVgh50101
     * 
     */
    public void insertPghq390a700() {
        sqlSttmt = "INSERT INTO VWSDGHPS50101_INFHSTCPL ( " +
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
        	"C_SECT_ITTL_BPOR, " +
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
        	"Z_ELIMINACAO, " +
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
        	":cSectIttlBpor, " +
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
        	":zEliminacao, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", infhstcpl().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", infhstcpl().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", infhstcpl().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", infhstcpl().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", infhstcpl().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", infhstcpl().cTerminal() ) ;
        setQueryArgument( "cOperador", infhstcpl().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", infhstcpl().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", infhstcpl().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", infhstcpl().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", infhstcpl().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", infhstcpl().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", infhstcpl().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", infhstcpl().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", infhstcpl().cFamiProd() ) ;
        setQueryArgument( "cProduto", infhstcpl().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", infhstcpl().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", infhstcpl().cGrupCont() ) ;
        setQueryArgument( "cSectIttlBpor", infhstcpl().cSectIttlBpor() ) ;
        setQueryArgument( "tCambio", infhstcpl().tCambio() ) ;
        setQueryArgument( "mSldoRetd", infhstcpl().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", infhstcpl().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", infhstcpl().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", infhstcpl().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", infhstcpl().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", infhstcpl().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", infhstcpl().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", infhstcpl().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", infhstcpl().nsJourBbnDtlh() ) ;
        setQueryArgument( "zEliminacao", infhstcpl().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "tsActzUlt", infhstcpl().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", infhstcpl().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Pghq550a.A31300SelInfHstComplA31300SelInfHstCompl
     * 
     * @param pInfhst
     */
    public void selectPghq550a777(Infhst pInfhst) {
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
                "C_SECT_ITTL_BPOR," +
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
                "Z_ELIMINACAO," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", pInfhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pInfhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pInfhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pInfhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pInfhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pInfhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pInfhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pInfhst.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pInfhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pInfhst.nsMovimento() ) ;
        setQueryArgument( "zEliminacao", pInfhst.zEliminacao(), java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            infhstcpl().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            infhstcpl().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            infhstcpl().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            infhstcpl().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            infhstcpl().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            infhstcpl().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            infhstcpl().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            infhstcpl().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            infhstcpl().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            infhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            infhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            infhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            infhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            infhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            infhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            infhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            infhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            infhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            infhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            infhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            infhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            infhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            infhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            infhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            infhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            infhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            infhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            infhstcpl().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            infhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            infhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            infhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            infhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            infhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            infhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            infhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            infhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            infhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            infhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            infhstcpl().zEliminacao().set(getQueryReturnedValue("Z_ELIMINACAO", String.class)) ;
            infhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            infhstcpl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Mghs501a.A5200CriterioCompletoA5200CriterioCompleto
     * 
     */
    public void selectMghs501a189() {
        /**
         * *----------------------------------------------------------------*
         */
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
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            infhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            infhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            infhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            infhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            infhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            infhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            infhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            infhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            infhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            infhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            infhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            infhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            infhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            infhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            infhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            infhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            infhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            infhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            infhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            infhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            infhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            infhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            infhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            infhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            infhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            infhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            infhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            infhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            infhstcpl().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Mghs501a.A5300CriterioOndeA5300CriterioOnde
     * 
     */
    public void selectMghs501a321() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            infhstcpl().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            infhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            infhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            infhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Mghs501a.A5400CriterioQuemA5400CriterioQuem
     * 
     */
    public void selectMghs501a372() {
        /**
         * *----------------------------------------------------------------*
         */
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
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            infhstcpl().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            infhstcpl().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            infhstcpl().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            infhstcpl().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            infhstcpl().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            infhstcpl().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            infhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            infhstcpl().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            infhstcpl().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Mghs501a.A5500CriterioSaldosA5500CriterioSaldos
     * 
     */
    public void selectMghs501a436() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID" +
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            infhstcpl().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            infhstcpl().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            infhstcpl().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            infhstcpl().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            infhstcpl().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Mghs501a.A5600CriterioPosicaoA5600CriterioPosicao
     * 
     */
    public void selectMghs501a490() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PROD_SGOP," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_CNDZ_MOVZ_CONT," +
                "C_GRUP_CONT" +
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            infhstcpl().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            infhstcpl().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            infhstcpl().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            infhstcpl().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH50101_INFHSTCPL
     * called from Mghs501a.A5700CriterioJourA5700CriterioJour
     * 
     */
    public void selectMghs501a540() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS50101_INFHSTCPL" +
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
        setQueryArgument( "cPaisIsoaCont", infhstcpl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infhstcpl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infhstcpl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infhstcpl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infhstcpl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infhstcpl().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infhstcpl().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infhstcpl().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infhstcpl().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infhstcpl().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infhstcpl().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            infhstcpl().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            infhstcpl().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            infhstcpl().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            infhstcpl().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            infhstcpl().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            infhstcpl().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
}
