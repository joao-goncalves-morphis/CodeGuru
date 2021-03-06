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
import cgd.gh.persistence.database.Vwsdghps02301Movhist3.Movhist3 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps12301Movhstcp3 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhstcp3
     */
    @Data
    public abstract Movhstcp3 movhstcp3() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH12301_MOVHSTCP3
     * 
     * @version 2.0
     * 
     */
    public interface Movhstcp3 extends IDataStruct {
        
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
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Pghq023a.A31310AcedeInfComplementarA31310AcedeInfComplementar
     * 
     * @param pMovhist3
     */
    public void selectPghq023a931(Movhist3 pMovhist3) {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
            movhstcp3().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhstcp3().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhstcp3().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhstcp3().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhstcp3().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhstcp3().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhstcp3().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhstcp3().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhstcp3().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp3().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhstcp3().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp3().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp3().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp3().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp3().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp3().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp3().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp3().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp3().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp3().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp3().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp3().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp3().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp3().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp3().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp3().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp3().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp3().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp3().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp3().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp3().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp3().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp3().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp3().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp3().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp3().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH12301_MOVHSTCP3
     * called from Pghqz06a.A30010EscreverHist123A30010EscreverHist123
     * 
     */
    public void insertPghqz06a1675() {
        sqlSttmt = "INSERT INTO VWSDGHPS12301_MOVHSTCP3 ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", movhstcp3().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", movhstcp3().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", movhstcp3().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", movhstcp3().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", movhstcp3().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", movhstcp3().cTerminal() ) ;
        setQueryArgument( "cOperador", movhstcp3().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", movhstcp3().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", movhstcp3().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", movhstcp3().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp3().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp3().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp3().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", movhstcp3().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", movhstcp3().cFamiProd() ) ;
        setQueryArgument( "cProduto", movhstcp3().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", movhstcp3().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", movhstcp3().cGrupCont() ) ;
        setQueryArgument( "cTipoIttz", movhstcp3().cTipoIttz() ) ;
        setQueryArgument( "tCambio", movhstcp3().tCambio() ) ;
        setQueryArgument( "mSldoRetd", movhstcp3().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", movhstcp3().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", movhstcp3().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", movhstcp3().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", movhstcp3().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", movhstcp3().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", movhstcp3().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp3().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp3().nsJourBbnDtlh() ) ;
        setQueryArgument( "nmArqvOrig", movhstcp3().nmArqvOrig() ) ;
        setQueryArgument( "tsActzUlt", movhstcp3().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhstcp3().cUsidActzUlt() ) ;
        setQueryArgument( "cCatgMov", movhstcp3().cCatgMov() ) ;
        executeInsert() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs114a.A5100AcederTgh00123A5100AcederTgh00123
     * 
     */
    public void closeMghs114a646() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs114a.A5100AcederTgh00123A5100AcederTgh00123
     * 
     */
    public void fetchMghs114a590() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp3().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp3().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs114a.A5100AcederTgh00123A5100AcederTgh00123
     * 
     */
    public void fetchMghs114a626() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp3().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp3().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs114a.A5100AcederTgh00123A5100AcederTgh00123
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs114a578(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "A_APLICACAO," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        c.setArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "cMnemEgcOpex", movhstcp3().cMnemEgcOpex() ) ;
        c.setArgument( "cPaisIsoaOeOpx", movhstcp3().cPaisIsoaOeOpx() ) ;
        c.setArgument( "cOeEgcOpex", movhstcp3().cOeEgcOpex() ) ;
        c.setArgument( "cUserid", movhstcp3().cUserid() ) ;
        c.setArgument( "nJourBbn", movhstcp3().nJourBbn() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs113a.A5100AcederTgh00123A5100AcederTgh00123
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs113a393(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp3().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp3().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp3().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movhstcp3().cUserid() ) ;
        setQueryArgument( "nJourBbn", movhstcp3().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp3().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp3().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp3().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs123a.A5200CriterioCompletoA5200CriterioCompleto
     * 
     */
    public void selectMghs123a186() {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp3().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp3().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp3().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp3().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp3().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp3().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp3().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp3().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp3().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp3().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp3().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp3().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp3().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp3().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp3().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp3().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp3().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp3().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp3().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp3().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp3().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp3().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp3().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp3().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp3().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs123a.A5300CriterioOndeA5300CriterioOnde
     * 
     */
    public void selectMghs123a324() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp3().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs123a.A5400CriterioQuemA5400CriterioQuem
     * 
     */
    public void selectMghs123a375() {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp3().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp3().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp3().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp3().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp3().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp3().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp3().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs123a.A5500CriterioSaldosA5500CriterioSaldos
     * 
     */
    public void selectMghs123a439() {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp3().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp3().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp3().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp3().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp3().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs123a.A5600CriterioPosicaoA5600CriterioPosicao
     * 
     */
    public void selectMghs123a493() {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp3().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp3().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp3().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp3().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp3().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs123a.A5700CriterioJourA5700CriterioJour
     * 
     */
    public void selectMghs123a545() {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp3().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp3().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs203a.A5110CriterioCompletoA5110CriterioCompleto
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a412(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp3().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp3().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp3().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp3().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp3().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp3().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp3().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp3().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp3().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp3().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp3().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp3().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp3().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp3().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp3().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp3().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp3().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp3().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp3().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp3().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp3().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp3().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp3().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp3().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp3().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs203a.A5120CriterioOndeA5120CriterioOnde
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a551(IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp3().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs203a.A5130CriterioQuemA5130CriterioQuem
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a604(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp3().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp3().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp3().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp3().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp3().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp3().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp3().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp3().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs203a.A5140CriterioSaldosA5140CriterioSaldos
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a706(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp3().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp3().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp3().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp3().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp3().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs203a.A5150CriterioPosicaoA5150CriterioPosicao
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a761(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp3().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp3().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp3().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp3().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp3().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12301_MOVHSTCP3
     * called from Mghs203a.A5160CriterioJourA5160CriterioJour
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a815(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12301_MOVHSTCP3" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp3().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp3().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp3().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp3().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp3().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp3().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp3().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp3().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp3().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp3().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp3().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp3().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp3().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp3().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp3().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp3().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
}
