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
import cgd.gh.persistence.database.Vwsdhops02001Movdia1 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Tbsdhop00021Movdia2 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movdia1
     */
    @Data
    public abstract Movdia1 movdia1() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO02001_MOVDIA1
     * 
     * @version 2.0
     * 
     */
    public interface Movdia1 extends IDataStruct {
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * C_MOED_ISO_SCTA
         */
        @Column(name="C_MOED_ISO_SCTA")
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        /**
         * NS_DEPOSITO
         */
        @Column(name="NS_DEPOSITO")
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        /**
         * NS_MOVIMENTO
         */
        @Column(name="NS_MOVIMENTO")
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
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Mghs111a.A3122AcedeTho21A3122AcedeTho21
     * 
     */
    public void closeMghs111a516() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs111a.A3122AcedeTho21A3122AcedeTho21
     * 
     * @param pNsMovimento
     * @param pAAplicacao
     * @param pNsJourBbn
     * @param pNsJourBbnDtlh
     */
    public void fetchMghs111a460(ILong pNsMovimento, IString pAAplicacao, IInt pNsJourBbn, IInt pNsJourBbnDtlh) {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pNsMovimento.set(c.getValue("NS_MOVIMENTO")) ;
            pAAplicacao.set(c.getValue("A_APLICACAO")) ;
            pNsJourBbn.set(c.getValue("NS_JOUR_BBN")) ;
            pNsJourBbnDtlh.set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs111a.A3122AcedeTho21A3122AcedeTho21
     * 
     * @param pNsMovimento
     * @param pAAplicacao
     * @param pNsJourBbn
     * @param pNsJourBbnDtlh
     */
    public void fetchMghs111a496(ILong pNsMovimento, IString pAAplicacao, IInt pNsJourBbn, IInt pNsJourBbnDtlh) {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pNsMovimento.set(c.getValue("NS_MOVIMENTO")) ;
            pAAplicacao.set(c.getValue("A_APLICACAO")) ;
            pNsJourBbn.set(c.getValue("NS_JOUR_BBN")) ;
            pNsJourBbnDtlh.set(c.getValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Mghs111a.A3122AcedeTho21A3122AcedeTho21
     * 
     * @param pMovdia1
     */
    public void openMghs111a448(Vwsdhops02001Movdia1.Movdia1 pMovdia1) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "A_APLICACAO," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM TBSDHOP00021_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 10" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        c.setArgument( "zProcessamento", pMovdia1.zProcessamento(), java.sql.Date.class ) ;
        c.setArgument( "cMnemEgcOpex", pMovdia1.cMnemEgcOpex() ) ;
        c.setArgument( "cPaisIsoaOeOpx", pMovdia1.cPaisIsoaOeOpx() ) ;
        c.setArgument( "cOeEgcOpex", pMovdia1.cOeEgcOpex() ) ;
        c.setArgument( "cUserid", pMovdia1.cUserid() ) ;
        c.setArgument( "nJourBbn", pMovdia1.nJourBbn() ) ;
        c.open() ;
    }
}
