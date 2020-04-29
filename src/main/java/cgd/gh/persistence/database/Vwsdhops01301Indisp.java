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
public abstract class Vwsdhops01301Indisp extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Indisp
     */
    @Data
    public abstract Indisp indisp() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO01301_INDISP
     * 
     * @version 2.0
     * 
     */
    public interface Indisp extends IDataStruct {
        
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
         * TS_VCOB
         */
        @Column(name="TS_VCOB", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsVcob() ;
        
        /**
         * NS_VCOB
         */
        @Column(name="NS_VCOB")
        @Data(size=6, signed=true, compression=COMP3)
        IInt nsVcob() ;
        
        /**
         * Z_INICIO
         */
        @Column(name="Z_INICIO", type=java.sql.Date.class)
        @Data(size=10)
        IString zInicio() ;
        
        /**
         * Z_LIBERTACAO
         */
        @Column(name="Z_LIBERTACAO", type=java.sql.Date.class)
        @Data(size=10)
        IString zLibertacao() ;
        
        /**
         * I_EST_VCOB
         */
        @Column(name="I_EST_VCOB")
        @Data(size=1)
        IString iEstVcob() ;
        
        /**
         * I_ORIG_LOTE_VCOB
         */
        @Column(name="I_ORIG_LOTE_VCOB")
        @Data(size=1)
        IString iOrigLoteVcob() ;
        
        /**
         * C_TERM_ATM_CGD
         */
        @Column(name="C_TERM_ATM_CGD")
        @Data(size=4)
        IString cTermAtmCgd() ;
        
        /**
         * X_JSTZ_VCOB
         */
        @Column(name="X_JSTZ_VCOB")
        @Data(size=30)
        IString xJstzVcob() ;
        
        /**
         * DU_PRAZ_CBRC
         */
        @Column(name="DU_PRAZ_CBRC")
        @Data(size=3, signed=true, compression=COMP3)
        IInt duPrazCbrc() ;
        
        /**
         * M_VCOB_INI
         */
        @Column(name="M_VCOB_INI")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mVcobIni() ;
        
        /**
         * M_VCOB
         */
        @Column(name="M_VCOB")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mVcob() ;
        
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
         * C_MOED_ISO_CHEQ
         */
        @Column(name="C_MOED_ISO_CHEQ")
        @Data(size=3)
        IString cMoedIsoCheq() ;
        
        /**
         * M_VCOB_INI_MOE_CHQ
         */
        @Column(name="M_VCOB_INI_MOE_CHQ")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mVcobIniMoeChq() ;
        
        /**
         * M_VCOB_MOED_CHEQ
         */
        @Column(name="M_VCOB_MOED_CHEQ")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mVcobMoedCheq() ;
        
        /**
         * Q_VCOB
         */
        @Column(name="Q_VCOB")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qVcob() ;
        
        /**
         * C_PAIS_ISOA_APOI
         */
        @Column(name="C_PAIS_ISOA_APOI")
        @Data(size=3)
        IString cPaisIsoaApoi() ;
        
        /**
         * C_BANC_APOI
         */
        @Column(name="C_BANC_APOI")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancApoi() ;
        
        /**
         * C_OE_EGC_APOI
         */
        @Column(name="C_OE_EGC_APOI")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcApoi() ;
        
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
     * extracted method to encapsulate SELECT access to table VHO01301_INDISP
     * called from Pghq170a.M2320AcedeTho13M2320AcedeTho13
     * 
     */
    public void selectPghq170a1109() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT" +
            " FROM VWSDHOPS01301_INDISP" +
            " WHERE " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zProcessamento", indisp().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", indisp().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", indisp().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", indisp().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", indisp().cUserid() ) ;
        setQueryArgument( "nJourBbn", indisp().nJourBbn() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            indisp().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
        }
    }
}
