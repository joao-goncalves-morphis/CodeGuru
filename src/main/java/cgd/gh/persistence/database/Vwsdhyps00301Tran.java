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
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdhyps00301Tran extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Tran
     */
    @Data
    public abstract Tran tran() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHY00301_TRAN
     * 
     * @version 2.0
     * 
     */
    public interface Tran extends IDataStruct {
        
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
         * C_TRANSACCAO
         */
        @Column(name="C_TRANSACCAO")
        @Data(size=4)
        IString cTransaccao() ;
        
        /**
         * I_EXE_BANC_TEL
         */
        @Column(name="I_EXE_BANC_TEL")
        @Data(size=1)
        IString iExeBancTel() ;
        
        /**
         * I_ACTIVO
         */
        @Column(name="I_ACTIVO")
        @Data(size=1)
        IString iActivo() ;
        
        /**
         * I_TIPO_ORIG_TRNZ
         */
        @Column(name="I_TIPO_ORIG_TRNZ")
        @Data(size=1)
        IString iTipoOrigTrnz() ;
        
        /**
         * I_EXE_TERM_DISC
         */
        @Column(name="I_EXE_TERM_DISC")
        @Data(size=1)
        IString iExeTermDisc() ;
        
        /**
         * I_TIPO_ENTD_TRNZ
         */
        @Column(name="I_TIPO_ENTD_TRNZ")
        @Data(size=1)
        IString iTipoEntdTrnz() ;
        
        /**
         * I_TIPO_PRCT_TRNZ
         */
        @Column(name="I_TIPO_PRCT_TRNZ")
        @Data(size=1)
        IString iTipoPrctTrnz() ;
        
        /**
         * I_TIPO_FLUX_TRNZ
         */
        @Column(name="I_TIPO_FLUX_TRNZ")
        @Data(size=1)
        IString iTipoFluxTrnz() ;
        
        /**
         * NM_PRG_CNSL
         */
        @Column(name="NM_PRG_CNSL")
        @Data(size=8)
        IString nmPrgCnsl() ;
        
        /**
         * NM_PRG_INSZ
         */
        @Column(name="NM_PRG_INSZ")
        @Data(size=8)
        IString nmPrgInsz() ;
        
        /**
         * NM_PRG_MDFZ
         */
        @Column(name="NM_PRG_MDFZ")
        @Data(size=8)
        IString nmPrgMdfz() ;
        
        /**
         * NM_PRG_ELIZ
         */
        @Column(name="NM_PRG_ELIZ")
        @Data(size=8)
        IString nmPrgEliz() ;
        
        /**
         * NM_PRG_VLDZ
         */
        @Column(name="NM_PRG_VLDZ")
        @Data(size=8)
        IString nmPrgVldz() ;
        
        /**
         * I_TRNZ_CBLO
         */
        @Column(name="I_TRNZ_CBLO")
        @Data(size=1)
        IString iTrnzCblo() ;
        
        /**
         * I_ACES_CONT_STFF
         */
        @Column(name="I_ACES_CONT_STFF")
        @Data(size=1)
        IString iAcesContStff() ;
        
        /**
         * I_ESCI_LOG_CNSL
         */
        @Column(name="I_ESCI_LOG_CNSL")
        @Data(size=1)
        IString iEsciLogCnsl() ;
        
        /**
         * I_LPEZ_ECRA_PF13
         */
        @Column(name="I_LPEZ_ECRA_PF13")
        @Data(size=1)
        IString iLpezEcraPf13() ;
        
        /**
         * Q_PGN_CNSL_LST_MAX
         */
        @Column(name="Q_PGN_CNSL_LST_MAX")
        @Data(size=2, signed=true, compression=COMP3)
        IInt qPgnCnslLstMax() ;
        
        /**
         * Q_CTER_CMPT
         */
        @Column(name="Q_CTER_CMPT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qCterCmpt() ;
        
        /**
         * I_RSTZ_ACES_CONT
         */
        @Column(name="I_RSTZ_ACES_CONT")
        @Data(size=1)
        IString iRstzAcesCont() ;
        
        /**
         * I_RSTZ_ACES_CLI
         */
        @Column(name="I_RSTZ_ACES_CLI")
        @Data(size=1)
        IString iRstzAcesCli() ;
        
        /**
         * I_TRNZ_IDPL
         */
        @Column(name="I_TRNZ_IDPL")
        @Data(size=1)
        IString iTrnzIdpl() ;
        
        /**
         * I_TRNZ_ATIV_IDPB
         */
        @Column(name="I_TRNZ_ATIV_IDPB")
        @Data(size=1)
        IString iTrnzAtivIdpb() ;
        
        /**
         * I_DEBUG
         */
        @Column(name="I_DEBUG")
        @Data(size=1)
        IString iDebug() ;
        
        /**
         * I_TRCG_MSG
         */
        @Column(name="I_TRCG_MSG")
        @Data(size=1)
        IString iTrcgMsg() ;
        
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
     * extracted method to encapsulate SELECT access to table VHY00301_TRAN
     * called from Mghs803a.S3000ProcessarS3000Processar
     * 
     */
    public void selectMghs803a120() {
        sqlSttmt = "SELECT  " +
                "C_TRANSACCAO" +
            " FROM VWSDHYPS00301_TRAN" +
            " WHERE " +
                "A_APLICACAO = :aAplicacao AND C_OPCZ_MENU = :cOpczMenu"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "aAplicacao", tran().aAplicacao() ) ;
        setQueryArgument( "cOpczMenu", tran().cOpczMenu() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            tran().cTransaccao().set(getQueryReturnedValue("C_TRANSACCAO")) ;
        }
    }
}
