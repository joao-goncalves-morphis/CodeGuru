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
import cgd.gh.persistence.database.Vwsdghps02601Movhist6.Movhist6 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps12601Movhstcp6 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhstcp6
     */
    @Data
    public abstract Movhstcp6 movhstcp6() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH12601_MOVHSTCP6
     * 
     * @version 2.0
     * 
     */
    public interface Movhstcp6 extends IDataStruct {
        
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
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Pghq026a.A31310AcedeInfComplementarA31310AcedeInfComplementar
     * 
     * @param pMovhist6
     */
    public void selectPghq026a927(Movhist6 pMovhist6) {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
            movhstcp6().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhstcp6().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhstcp6().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhstcp6().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhstcp6().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhstcp6().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhstcp6().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhstcp6().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhstcp6().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp6().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhstcp6().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp6().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp6().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp6().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp6().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp6().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp6().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp6().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp6().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp6().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp6().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp6().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp6().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp6().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp6().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp6().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp6().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp6().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp6().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp6().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp6().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp6().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp6().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp6().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp6().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp6().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH12601_MOVHSTCP6
     * called from Pghqz06a.A30013EscreverHist126A30013EscreverHist126
     * 
     */
    public void insertPghqz06a2190() {
        sqlSttmt = "INSERT INTO VWSDGHPS12601_MOVHSTCP6 ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", movhstcp6().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", movhstcp6().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", movhstcp6().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", movhstcp6().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", movhstcp6().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", movhstcp6().cTerminal() ) ;
        setQueryArgument( "cOperador", movhstcp6().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", movhstcp6().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", movhstcp6().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", movhstcp6().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp6().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp6().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp6().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", movhstcp6().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", movhstcp6().cFamiProd() ) ;
        setQueryArgument( "cProduto", movhstcp6().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", movhstcp6().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", movhstcp6().cGrupCont() ) ;
        setQueryArgument( "cTipoIttz", movhstcp6().cTipoIttz() ) ;
        setQueryArgument( "tCambio", movhstcp6().tCambio() ) ;
        setQueryArgument( "mSldoRetd", movhstcp6().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", movhstcp6().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", movhstcp6().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", movhstcp6().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", movhstcp6().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", movhstcp6().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", movhstcp6().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp6().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp6().nsJourBbnDtlh() ) ;
        setQueryArgument( "nmArqvOrig", movhstcp6().nmArqvOrig() ) ;
        setQueryArgument( "tsActzUlt", movhstcp6().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhstcp6().cUsidActzUlt() ) ;
        setQueryArgument( "cCatgMov", movhstcp6().cCatgMov() ) ;
        executeInsert() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs114a.A5400AcederTgh00126A5400AcederTgh00126
     * 
     */
    public void closeMghs114a963() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs114a.A5400AcederTgh00126A5400AcederTgh00126
     * 
     */
    public void fetchMghs114a907() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp6().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp6().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs114a.A5400AcederTgh00126A5400AcederTgh00126
     * 
     */
    public void fetchMghs114a943() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp6().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp6().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs114a.A5400AcederTgh00126A5400AcederTgh00126
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs114a895(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "A_APLICACAO," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "cMnemEgcOpex", movhstcp6().cMnemEgcOpex() ) ;
        c.setArgument( "cPaisIsoaOeOpx", movhstcp6().cPaisIsoaOeOpx() ) ;
        c.setArgument( "cOeEgcOpex", movhstcp6().cOeEgcOpex() ) ;
        c.setArgument( "cUserid", movhstcp6().cUserid() ) ;
        c.setArgument( "nJourBbn", movhstcp6().nJourBbn() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs113a.A5400AcederTgh00126A5400AcederTgh00126
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs113a623(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp6().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp6().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp6().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movhstcp6().cUserid() ) ;
        setQueryArgument( "nJourBbn", movhstcp6().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp6().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp6().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp6().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs126a.A5200CriterioCompletoA5200CriterioCompleto
     * 
     */
    public void selectMghs126a186() {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp6().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp6().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp6().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp6().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp6().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp6().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp6().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp6().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp6().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp6().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp6().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp6().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp6().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp6().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp6().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp6().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp6().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp6().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp6().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp6().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp6().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp6().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp6().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp6().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp6().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs126a.A5300CriterioOndeA5300CriterioOnde
     * 
     */
    public void selectMghs126a324() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp6().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs126a.A5400CriterioQuemA5400CriterioQuem
     * 
     */
    public void selectMghs126a375() {
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
                "NM_ARQV_ORIG" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp6().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp6().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp6().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp6().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp6().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp6().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp6().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs126a.A5500CriterioSaldosA5500CriterioSaldos
     * 
     */
    public void selectMghs126a439() {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp6().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp6().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp6().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp6().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp6().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs126a.A5600CriterioPosicaoA5600CriterioPosicao
     * 
     */
    public void selectMghs126a493() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PROD_SGOP," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_CNDZ_MOVZ_CONT," +
                "C_GRUP_CONT," +
                "C_TIPO_ITTZ" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp6().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp6().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp6().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp6().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp6().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs126a.A5700CriterioJourA5700CriterioJour
     * 
     */
    public void selectMghs126a545() {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp6().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp6().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs203a.A5410CriterioCompletoA5410CriterioCompleto
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1901(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp6().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp6().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp6().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp6().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp6().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp6().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp6().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp6().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp6().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp6().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp6().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp6().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp6().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp6().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp6().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp6().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp6().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp6().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp6().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp6().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp6().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp6().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp6().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp6().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp6().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs203a.A5420CriterioOndeA5420CriterioOnde
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2040(IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp6().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs203a.A5430CriterioQuemA5430CriterioQuem
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2093(IString pWsTsInicio, IString pWsTsFim) {
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
                "NM_ARQV_ORIG," +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp6().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp6().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp6().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp6().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp6().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp6().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp6().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp6().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs203a.A5440CriterioSaldosA5440CriterioSaldos
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2196(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp6().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp6().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp6().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp6().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp6().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs203a.A5450CriterioPosicaoA5450CriterioPosicao
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2251(IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PROD_SGOP," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_CNDZ_MOVZ_CONT," +
                "C_GRUP_CONT," +
                "C_TIPO_ITTZ" +
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp6().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp6().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp6().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp6().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp6().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12601_MOVHSTCP6
     * called from Mghs203a.A5460CriterioJourA5460CriterioJour
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2305(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12601_MOVHSTCP6" +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhstcp6().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp6().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp6().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp6().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp6().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp6().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp6().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp6().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp6().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp6().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp6().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp6().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp6().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp6().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp6().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp6().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
}
