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
import cgd.gh.persistence.database.Vwsdghps02801Movhist8.Movhist8 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps12801Movhstcp8 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhstcp8
     */
    @Data
    public abstract Movhstcp8 movhstcp8() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH12801_MOVHSTCP8
     * 
     * @version 2.0
     * 
     */
    public interface Movhstcp8 extends IDataStruct {
        
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
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Pghq028a.A31310AcedeInfComplementarA31310AcedeInfComplementar
     * 
     * @param pMovhist8
     */
    public void selectPghq028a930(Movhist8 pMovhist8) {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
            movhstcp8().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhstcp8().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhstcp8().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhstcp8().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhstcp8().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhstcp8().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhstcp8().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhstcp8().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhstcp8().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp8().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhstcp8().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp8().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp8().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp8().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp8().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp8().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp8().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp8().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp8().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp8().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp8().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp8().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp8().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp8().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp8().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp8().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp8().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp8().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp8().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp8().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp8().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp8().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp8().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp8().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp8().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp8().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH12801_MOVHSTCP8
     * called from Pghqz06a.A30009EscreverHist128A30009EscreverHist128
     * 
     */
    public void insertPghqz06a1503() {
        sqlSttmt = "INSERT INTO VWSDGHPS12801_MOVHSTCP8 ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", movhstcp8().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", movhstcp8().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", movhstcp8().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", movhstcp8().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", movhstcp8().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", movhstcp8().cTerminal() ) ;
        setQueryArgument( "cOperador", movhstcp8().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", movhstcp8().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", movhstcp8().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", movhstcp8().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp8().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp8().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp8().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", movhstcp8().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", movhstcp8().cFamiProd() ) ;
        setQueryArgument( "cProduto", movhstcp8().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", movhstcp8().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", movhstcp8().cGrupCont() ) ;
        setQueryArgument( "cTipoIttz", movhstcp8().cTipoIttz() ) ;
        setQueryArgument( "tCambio", movhstcp8().tCambio() ) ;
        setQueryArgument( "mSldoRetd", movhstcp8().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", movhstcp8().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", movhstcp8().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", movhstcp8().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", movhstcp8().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", movhstcp8().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", movhstcp8().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp8().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp8().nsJourBbnDtlh() ) ;
        setQueryArgument( "nmArqvOrig", movhstcp8().nmArqvOrig() ) ;
        setQueryArgument( "tsActzUlt", movhstcp8().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhstcp8().cUsidActzUlt() ) ;
        setQueryArgument( "cCatgMov", movhstcp8().cCatgMov() ) ;
        executeInsert() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C6
     * called from Mghs114a.A5600AcederTgh00128A5600AcederTgh00128
     * 
     */
    public void closeMghs114a1175() {
        BaseCursorHandler c = getCursor("C6") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Mghs114a.A5600AcederTgh00128A5600AcederTgh00128
     * 
     */
    public void fetchMghs114a1119() {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp8().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp8().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Mghs114a.A5600AcederTgh00128A5600AcederTgh00128
     * 
     */
    public void fetchMghs114a1155() {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp8().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp8().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C6
     * called from Mghs114a.A5600AcederTgh00128A5600AcederTgh00128
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs114a1107(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "A_APLICACAO," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        BaseCursorHandler c = addCursor("C6", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "cMnemEgcOpex", movhstcp8().cMnemEgcOpex() ) ;
        c.setArgument( "cPaisIsoaOeOpx", movhstcp8().cPaisIsoaOeOpx() ) ;
        c.setArgument( "cOeEgcOpex", movhstcp8().cOeEgcOpex() ) ;
        c.setArgument( "cUserid", movhstcp8().cUserid() ) ;
        c.setArgument( "nJourBbn", movhstcp8().nJourBbn() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs113a.A5600AcederTgh00128A5600AcederTgh00128
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs113a776(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp8().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp8().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp8().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movhstcp8().cUserid() ) ;
        setQueryArgument( "nJourBbn", movhstcp8().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp8().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp8().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp8().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs128a.A5200CriterioCompletoA5200CriterioCompleto
     * 
     */
    public void selectMghs128a186() {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp8().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp8().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp8().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp8().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp8().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp8().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp8().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp8().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp8().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp8().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp8().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp8().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp8().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp8().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp8().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp8().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp8().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp8().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp8().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp8().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp8().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp8().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp8().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp8().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp8().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs128a.A5300CriterioOndeA5300CriterioOnde
     * 
     */
    public void selectMghs128a324() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp8().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs128a.A5400CriterioQuemA5400CriterioQuem
     * 
     */
    public void selectMghs128a375() {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp8().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp8().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp8().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp8().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp8().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp8().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp8().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs128a.A5500CriterioSaldosA5500CriterioSaldos
     * 
     */
    public void selectMghs128a439() {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp8().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp8().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp8().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp8().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp8().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs128a.A5600CriterioPosicaoA5600CriterioPosicao
     * 
     */
    public void selectMghs128a493() {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp8().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp8().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp8().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp8().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp8().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs128a.A5700CriterioJourA5700CriterioJour
     * 
     */
    public void selectMghs128a545() {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp8().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs203a.A5610CriterioCompletoA5610CriterioCompleto
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2893(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp8().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp8().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp8().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp8().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp8().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp8().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp8().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp8().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp8().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp8().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp8().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp8().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp8().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp8().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp8().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp8().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp8().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp8().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp8().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp8().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp8().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp8().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp8().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp8().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp8().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs203a.A5620CriterioOndeA5620CriterioOnde
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a3032(IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp8().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs203a.A5630CriterioQuemA5630CriterioQuem
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a3085(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp8().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp8().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp8().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp8().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp8().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp8().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp8().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp8().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs203a.A5640CriterioSaldosA5640CriterioSaldos
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a3188(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp8().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp8().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp8().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp8().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp8().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs203a.A5650CriterioPosicaoA5650CriterioPosicao
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a3243(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp8().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp8().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp8().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp8().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp8().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12801_MOVHSTCP8
     * called from Mghs203a.A5660CriterioJourA5660CriterioJour
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a3297(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12801_MOVHSTCP8" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp8().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp8().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp8().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp8().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp8().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp8().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp8().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp8().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp8().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
}
