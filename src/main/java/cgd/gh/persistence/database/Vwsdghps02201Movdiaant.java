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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps02201Movdiaant extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movdiaant
     */
    @Data
    public abstract Movdiaant movdiaant() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH02201_MOVDIAANT
     * 
     * @version 2.0
     * 
     */
    public interface Movdiaant extends IDataStruct {
        
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
         * Z_CONTABILIZACAO
         */
        @Column(name="Z_CONTABILIZACAO", type=java.sql.Date.class)
        @Data(size=10)
        IString zContabilizacao() ;
        
        /**
         * Z_MOVIMENTO
         */
        @Column(name="Z_MOVIMENTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovimento() ;
        
        /**
         * Z_VALOR
         */
        @Column(name="Z_VALOR", type=java.sql.Date.class)
        @Data(size=10)
        IString zValor() ;
        
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
         * M_SLDO_CBLO
         */
        @Column(name="M_SLDO_CBLO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        /**
         * M_SLDO_DPNL
         */
        @Column(name="M_SLDO_DPNL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnl() ;
        
        /**
         * C_MOED_ISO_ORI_MOV
         */
        @Column(name="C_MOED_ISO_ORI_MOV")
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        /**
         * M_MOV_MOE_ORIG_MOV
         */
        @Column(name="M_MOV_MOE_ORIG_MOV")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        /**
         * T_CAMBIO
         */
        @Column(name="T_CAMBIO")
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambio() ;
        
        /**
         * C_OPE_BBN
         */
        @Column(name="C_OPE_BBN")
        @Data(size=5)
        IString cOpeBbn() ;
        
        /**
         * X_REF_MOV
         */
        @Column(name="X_REF_MOV")
        @Data(size=21)
        IString xRefMov() ;
        
        /**
         * N_CHEQUE
         */
        @Column(name="N_CHEQUE")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        /**
         * I_ESTORNO
         */
        @Column(name="I_ESTORNO")
        @Data(size=1)
        IString iEstorno() ;
        
        /**
         * NS_MOV_ETND
         */
        @Column(name="NS_MOV_ETND")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovEtnd() ;
        
        /**
         * I_TRNZ_EFCD_ONLN
         */
        @Column(name="I_TRNZ_EFCD_ONLN")
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        /**
         * I_TIPO_ORIG_TRNZ
         */
        @Column(name="I_TIPO_ORIG_TRNZ")
        @Data(size=1)
        IString iTipoOrigTrnz() ;
        
        /**
         * I_EXI_ATZ_JOUR_BBN
         */
        @Column(name="I_EXI_ATZ_JOUR_BBN")
        @Data(size=1)
        IString iExiAtzJourBbn() ;
        
        /**
         * C_TIPO_CANL_ACES
         */
        @Column(name="C_TIPO_CANL_ACES")
        @Data(size=4)
        IString cTipoCanlAces() ;
        
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
         * C_SECT_ITTL_BPOR
         */
        @Column(name="C_SECT_ITTL_BPOR")
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        /**
         * C_PAIS_ISOA_GERX
         */
        @Column(name="C_PAIS_ISOA_GERX")
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        /**
         * C_BANC_GCX_GERX
         */
        @Column(name="C_BANC_GCX_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        /**
         * C_OE_EGC_GERX
         */
        @Column(name="C_OE_EGC_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        /**
         * I_MOV_ACTZ_VSLD
         */
        @Column(name="I_MOV_ACTZ_VSLD")
        @Data(size=1)
        IString iMovActzVsld() ;
        
        /**
         * Z_PROCESSAMENTO
         */
        @Column(name="Z_PROCESSAMENTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zProcessamento() ;
        
        /**
         * C_MNEM_EGC_OPEX
         */
        @Column(name="C_MNEM_EGC_OPEX")
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        /**
         * C_PAIS_ISOA_OE_OPX
         */
        @Column(name="C_PAIS_ISOA_OE_OPX")
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
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
         * M_SLDO_VCOB_UTID
         */
        @Column(name="M_SLDO_VCOB_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcobUtid() ;
        
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
         * Q_DIA_CALC_JURO
         */
        @Column(name="Q_DIA_CALC_JURO")
        @Data(size=5, signed=true, compression=COMP3)
        IInt qDiaCalcJuro() ;
        
        /**
         * C_TIPO_JURO
         */
        @Column(name="C_TIPO_JURO")
        @Data(size=2)
        IString cTipoJuro() ;
        
        /**
         * I_TIPO_CALC_JURO
         */
        @Column(name="I_TIPO_CALC_JURO")
        @Data(size=1)
        IString iTipoCalcJuro() ;
        
        /**
         * I_PENALIZACAO
         */
        @Column(name="I_PENALIZACAO")
        @Data(size=1)
        IString iPenalizacao() ;
        
        /**
         * Q_RENOVACAO
         */
        @Column(name="Q_RENOVACAO")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qRenovacao() ;
        
        /**
         * NS_UTIZ_CMRG
         */
        @Column(name="NS_UTIZ_CMRG")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsUtizCmrg() ;
        
        /**
         * C_EVEN_OPEL
         */
        @Column(name="C_EVEN_OPEL")
        @Data(size=4)
        IString cEvenOpel() ;
        
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
     * extracted method to encapsulate DELETE access to table VGH02201_MOVDIAANT
     * called from Pghq002a.A31000DelDiaAnteriorA31000DelDiaAnterior
     * 
     * @param pMovhst
     */
    public void deletePghq002a1359(Movhst pMovhst) {
        sqlSttmt = "DELETE FROM VWSDGHPS02201_MOVDIAANT " +
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
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        executeUpdate() ;
    }
    /**
     * Online
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Pghs109a.M2310ObtemMovDiaAntGhM2310ObtemMovDiaAntGh
     * 
     * @param pWsTsMovIni
     * @param pWsTsMovFim
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsQMovTgh22
     */
    public void selectPghs109a506(IString pWsTsMovIni, IString pWsTsMovFim, IString pWsCrit1, IString pWsCrit2, IDecimal pWsMMovMin, IDecimal pWsMMovMax, ILong pWsQMovTgh22) {
        sqlSttmt = "SELECT  " +
                "COALESCE(COUNT(*), '0')" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_MOVIMENTO >= :wsTsMovIni AND " +
                "Z_MOVIMENTO <= :wsTsMovFim AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "wsTsMovIni", pWsTsMovIni, java.sql.Date.class ) ;
        setQueryArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Date.class ) ;
        setQueryArgument( "wsCrit1", pWsCrit1 ) ;
        setQueryArgument( "wsCrit2", pWsCrit2 ) ;
        setQueryArgument( "wsMMovMin", pWsMMovMin ) ;
        setQueryArgument( "wsMMovMax", pWsMMovMax ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsQMovTgh22.set(getQueryReturnedInteger(1)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Pghs111a.M2293ObtemMovDiaAntGhM2293ObtemMovDiaAntGh
     * 
     * @param pWsTsMovIni
     * @param pWsTsMovFim
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsQMovTgh22
     */
    public void selectPghs111a1541(IString pWsTsMovIni, IString pWsTsMovFim, IString pWsCrit1, IString pWsCrit2, IDecimal pWsMMovMin, IDecimal pWsMMovMax, ILong pWsQMovTgh22) {
        sqlSttmt = "SELECT  " +
                "COALESCE(COUNT(*), '0')" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_MOVIMENTO >= :wsTsMovIni AND " +
                "Z_MOVIMENTO <= :wsTsMovFim AND " +
                "I_DBCR IN  (:wsCrit1, :wsCrit2) AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "wsTsMovIni", pWsTsMovIni, java.sql.Date.class ) ;
        setQueryArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Date.class ) ;
        setQueryArgument( "wsCrit1", pWsCrit1 ) ;
        setQueryArgument( "wsCrit2", pWsCrit2 ) ;
        setQueryArgument( "wsMMovMin", pWsMMovMin ) ;
        setQueryArgument( "wsMMovMax", pWsMMovMax ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsQMovTgh22.set(getQueryReturnedInteger(1)) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Mghs022a.A5400ListaDscMontA5400ListaDscMont
     * 
     */
    public void closeMghs022a1016() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs022a.A5500ListaDscA5500ListaDsc
     * 
     */
    public void closeMghs022a1135() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs022a.A5200ListaAscMontA5200ListaAscMont
     * 
     */
    public void closeMghs022a778() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs022a.A5300ListaAscA5300ListaAsc
     * 
     */
    public void closeMghs022a897() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs093a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void closeMghs093a419() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs022a.A5500ListaDscA5500ListaDsc
     * 
     */
    public void fetchMghs022a1042() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs022a.A5500ListaDscA5500ListaDsc
     * 
     */
    public void fetchMghs022a1116() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs022a.A5200ListaAscMontA5200ListaAscMont
     * 
     */
    public void fetchMghs022a683() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs022a.A5200ListaAscMontA5200ListaAscMont
     * 
     */
    public void fetchMghs022a759() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs022a.A5300ListaAscA5300ListaAsc
     * 
     */
    public void fetchMghs022a804() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs022a.A5300ListaAscA5300ListaAsc
     * 
     */
    public void fetchMghs022a878() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs022a.A5400ListaDscMontA5400ListaDscMont
     * 
     */
    public void fetchMghs022a923() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs022a.A5400ListaDscMontA5400ListaDscMont
     * 
     */
    public void fetchMghs022a997() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs093a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void fetchMghs093a311() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs093a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void fetchMghs093a402() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdiaant().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdiaant().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdiaant().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdiaant().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdiaant().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdiaant().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdiaant().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdiaant().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdiaant().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdiaant().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdiaant().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdiaant().iDbcr().set(c.getValue("I_DBCR")) ;
            movdiaant().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdiaant().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdiaant().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdiaant().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdiaant().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdiaant().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdiaant().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdiaant().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdiaant().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdiaant().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdiaant().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdiaant().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdiaant().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdiaant().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdiaant().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdiaant().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdiaant().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdiaant().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(c.getValue("C_USERID")) ;
            movdiaant().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdiaant().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdiaant().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdiaant().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdiaant().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdiaant().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdiaant().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdiaant().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdiaant().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs022a.A5500ListaDscA5500ListaDsc
     * 
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs022a1029(IString pWsCrit1, IString pWsCrit2) {
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
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO <= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdiaant().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs022a.A5200ListaAscMontA5200ListaAscMont
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs022a670(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
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
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO >= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdiaant().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs022a.A5300ListaAscA5300ListaAsc
     * 
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs022a791(IString pWsCrit1, IString pWsCrit2) {
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
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO >= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdiaant().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Mghs022a.A5400ListaDscMontA5400ListaDscMont
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs022a910(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
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
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO <= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdiaant().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs093a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void openMghs093a299() {
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
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 30" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdiaant().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs102a.A5620AcedeTgh022PA5620AcedeTgh022P
     * 
     */
    public void selectMghs102a1096() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs102a.A5720AcedeTgh022JA5720AcedeTgh022J
     * 
     */
    public void selectMghs102a1224() {
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
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdiaant().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs102a.A5220AcedeTgh022TA5220AcedeTgh022T
     * 
     */
    public void selectMghs102a443() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_DCBO_NGCD_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movdiaant().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movdiaant().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movdiaant().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movdiaant().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movdiaant().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movdiaant().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            movdiaant().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdiaant().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movdiaant().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movdiaant().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movdiaant().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movdiaant().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movdiaant().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs102a.A5320AcedeTgh022OA5320AcedeTgh022O
     * 
     */
    public void selectMghs102a642() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_TIPO_CANL_ACES," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movdiaant().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs102a.A5420AcedeTgh022QA5420AcedeTgh022Q
     * 
     */
    public void selectMghs102a827() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_OPE_BBN," +
                "C_EVEN_OPEL," +
                "C_USERID," +
                "T_CAMBIO" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movdiaant().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movdiaant().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movdiaant().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movdiaant().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdiaant().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs102a.A5520AcedeTgh022SA5520AcedeTgh022S
     * 
     */
    public void selectMghs102a968() {
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
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movdiaant().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movdiaant().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movdiaant().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movdiaant().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movdiaant().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02201_MOVDIAANT
     * called from Mghs122a.M2200AcedeHist022M2200AcedeHist022
     * 
     */
    public void selectMghs122a562() {
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDGHPS02201_MOVDIAANT" +
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
        setQueryArgument( "cPaisIsoaCont", movdiaant().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdiaant().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdiaant().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdiaant().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdiaant().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdiaant().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdiaant().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdiaant().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdiaant().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdiaant().zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            movdiaant().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdiaant().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdiaant().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdiaant().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdiaant().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdiaant().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdiaant().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
}
