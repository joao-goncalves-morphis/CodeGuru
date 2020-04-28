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
import cgd.gh.persistence.database.Vwsdghps02401Movhist4.Movhist4 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps12401Movhstcp4 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhstcp4
     */
    @Data
    public abstract Movhstcp4 movhstcp4() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH12401_MOVHSTCP4
     * 
     * @version 2.0
     * 
     */
    public interface Movhstcp4 extends IDataStruct {
        
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
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Pghq024a.A31310AcedeInfComplementarA31310AcedeInfComplementar
     * 
     * @param pMovhist4
     */
    public void selectPghq024a928(Movhist4 pMovhist4) {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
            movhstcp4().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhstcp4().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhstcp4().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhstcp4().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhstcp4().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhstcp4().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhstcp4().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhstcp4().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhstcp4().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp4().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhstcp4().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp4().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp4().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp4().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp4().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp4().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp4().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp4().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp4().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp4().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp4().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp4().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp4().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp4().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp4().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp4().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp4().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp4().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp4().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp4().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp4().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp4().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp4().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp4().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp4().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp4().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH12401_MOVHSTCP4
     * called from Pghqz06a.A30011EscreverHist124A30011EscreverHist124
     * 
     */
    public void insertPghqz06a1847() {
        sqlSttmt = "INSERT INTO VWSDGHPS12401_MOVHSTCP4 ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        setQueryArgument( "cTransaccao", movhstcp4().cTransaccao() ) ;
        setQueryArgument( "aAplicacao", movhstcp4().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", movhstcp4().cOpczMenu() ) ;
        setQueryArgument( "cOpeBbn", movhstcp4().cOpeBbn() ) ;
        setQueryArgument( "cEvenOpel", movhstcp4().cEvenOpel() ) ;
        setQueryArgument( "cTerminal", movhstcp4().cTerminal() ) ;
        setQueryArgument( "cOperador", movhstcp4().cOperador() ) ;
        setQueryArgument( "cOpexAtrx", movhstcp4().cOpexAtrx() ) ;
        setQueryArgument( "cUserid", movhstcp4().cUserid() ) ;
        setQueryArgument( "cTipoCanlAces", movhstcp4().cTipoCanlAces() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp4().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp4().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp4().cOeEgcOpex() ) ;
        setQueryArgument( "cProdSgop", movhstcp4().cProdSgop() ) ;
        setQueryArgument( "cFamiProd", movhstcp4().cFamiProd() ) ;
        setQueryArgument( "cProduto", movhstcp4().cProduto() ) ;
        setQueryArgument( "cCndzMovzCont", movhstcp4().cCndzMovzCont() ) ;
        setQueryArgument( "cGrupCont", movhstcp4().cGrupCont() ) ;
        setQueryArgument( "cTipoIttz", movhstcp4().cTipoIttz() ) ;
        setQueryArgument( "tCambio", movhstcp4().tCambio() ) ;
        setQueryArgument( "mSldoRetd", movhstcp4().mSldoRetd() ) ;
        setQueryArgument( "mSldoVcob", movhstcp4().mSldoVcob() ) ;
        setQueryArgument( "mCmrgLim", movhstcp4().mCmrgLim() ) ;
        setQueryArgument( "mCmrgUtid", movhstcp4().mCmrgUtid() ) ;
        setQueryArgument( "mDcboNgcdAtrd", movhstcp4().mDcboNgcdAtrd() ) ;
        setQueryArgument( "mDcboNgcdUtid", movhstcp4().mDcboNgcdUtid() ) ;
        setQueryArgument( "nJourBbn", movhstcp4().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp4().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp4().nsJourBbnDtlh() ) ;
        setQueryArgument( "nmArqvOrig", movhstcp4().nmArqvOrig() ) ;
        setQueryArgument( "tsActzUlt", movhstcp4().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhstcp4().cUsidActzUlt() ) ;
        setQueryArgument( "cCatgMov", movhstcp4().cCatgMov() ) ;
        executeInsert() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs114a.A5200AcederTgh00124A5200AcederTgh00124
     * 
     */
    public void closeMghs114a751() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs114a.A5200AcederTgh00124A5200AcederTgh00124
     * 
     */
    public void fetchMghs114a695() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp4().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp4().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs114a.A5200AcederTgh00124A5200AcederTgh00124
     * 
     */
    public void fetchMghs114a731() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhstcp4().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movhstcp4().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs114a.A5200AcederTgh00124A5200AcederTgh00124
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs114a683(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "A_APLICACAO," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "cMnemEgcOpex", movhstcp4().cMnemEgcOpex() ) ;
        c.setArgument( "cPaisIsoaOeOpx", movhstcp4().cPaisIsoaOeOpx() ) ;
        c.setArgument( "cOeEgcOpex", movhstcp4().cOeEgcOpex() ) ;
        c.setArgument( "cUserid", movhstcp4().cUserid() ) ;
        c.setArgument( "nJourBbn", movhstcp4().nJourBbn() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs113a.A5200AcederTgh00124A5200AcederTgh00124
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs113a472(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "cMnemEgcOpex", movhstcp4().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movhstcp4().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movhstcp4().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movhstcp4().cUserid() ) ;
        setQueryArgument( "nJourBbn", movhstcp4().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movhstcp4().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movhstcp4().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhstcp4().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs124a.A5200CriterioCompletoA5200CriterioCompleto
     * 
     */
    public void selectMghs124a186() {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp4().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp4().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp4().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp4().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp4().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp4().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp4().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp4().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp4().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp4().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp4().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp4().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp4().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp4().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp4().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp4().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp4().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp4().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp4().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp4().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp4().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp4().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp4().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp4().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp4().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs124a.A5300CriterioOndeA5300CriterioOnde
     * 
     */
    public void selectMghs124a324() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp4().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs124a.A5400CriterioQuemA5400CriterioQuem
     * 
     */
    public void selectMghs124a375() {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp4().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp4().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp4().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp4().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp4().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp4().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp4().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs124a.A5500CriterioSaldosA5500CriterioSaldos
     * 
     */
    public void selectMghs124a439() {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp4().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp4().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp4().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp4().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp4().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs124a.A5600CriterioPosicaoA5600CriterioPosicao
     * 
     */
    public void selectMghs124a493() {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp4().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp4().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp4().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp4().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp4().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs124a.A5700CriterioJourA5700CriterioJour
     * 
     */
    public void selectMghs124a545() {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhstcp4().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp4().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs203a.A5220CriterioOndeA5220CriterioOnde
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1047(IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_TERMINAL," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp4().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs203a.A5230CriterioQuemA5230CriterioQuem
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1100(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp4().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp4().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp4().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp4().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp4().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp4().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp4().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp4().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs203a.A5240CriterioSaldosA5240CriterioSaldos
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1203(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp4().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp4().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp4().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp4().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp4().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs203a.A5250CriterioPosicaoA5250CriterioPosicao
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1258(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp4().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp4().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp4().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp4().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp4().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs203a.A5260CriterioJourA5260CriterioJour
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1312(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp4().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH12401_MOVHSTCP4
     * called from Mghs203a.A5210CriterioCompletoA5210CriterioCompleto
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a908(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS12401_MOVHSTCP4" +
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
        setQueryArgument( "cPaisIsoaCont", movhstcp4().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhstcp4().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhstcp4().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhstcp4().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhstcp4().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhstcp4().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhstcp4().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhstcp4().nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhstcp4().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhstcp4().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
            movhstcp4().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movhstcp4().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movhstcp4().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movhstcp4().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movhstcp4().cTerminal().set(getQueryReturnedValue("C_TERMINAL")) ;
            movhstcp4().cOperador().set(getQueryReturnedValue("C_OPERADOR")) ;
            movhstcp4().cOpexAtrx().set(getQueryReturnedValue("C_OPEX_ATRX")) ;
            movhstcp4().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movhstcp4().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movhstcp4().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movhstcp4().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movhstcp4().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movhstcp4().cProdSgop().set(getQueryReturnedValue("C_PROD_SGOP")) ;
            movhstcp4().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movhstcp4().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movhstcp4().cCndzMovzCont().set(getQueryReturnedValue("C_CNDZ_MOVZ_CONT")) ;
            movhstcp4().cGrupCont().set(getQueryReturnedValue("C_GRUP_CONT")) ;
            movhstcp4().cTipoIttz().set(getQueryReturnedValue("C_TIPO_ITTZ")) ;
            movhstcp4().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movhstcp4().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movhstcp4().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movhstcp4().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movhstcp4().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movhstcp4().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movhstcp4().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movhstcp4().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movhstcp4().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movhstcp4().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movhstcp4().nmArqvOrig().set(getQueryReturnedValue("NM_ARQV_ORIG")) ;
            movhstcp4().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhstcp4().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
}
