package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.persistence.relational.annotations.Key ;
import morphis.framework.persistence.relational.annotations.Table;
import morphis.framework.persistence.relational.annotations.Column ;
import morphis.framework.persistence.relational.BaseTableHandler ;
import morphis.framework.exceptions.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
@Table("pgowndb.tbgh_webservice_messages")
public class TbghWebserviceMessages extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    @Data
    public WebserviceMessages webserviceMessages ;
    
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE tbgh_webservice_messages
     * 
     * @version 2.0
     * 
     */
    public interface WebserviceMessages extends IDataStruct {
        
        /**
         * trans
         */
        @Column(name="trans")
        @Data(size=4)
        String getTrans() ;
        void setTrans(String value) ;
        void setTrans(Object value) ;
        
        /**
         * prog_name
         */
        @Column(name="prog_name")
        @Key
        @Data(size=8)
        String getProgName() ;
        void setProgName(String value) ;
        void setProgName(Object value) ;
        
        /**
         * env_version
         */
        @Column(name="env_version")
        @Data(size=2)
        String getEnvVersion() ;
        void setEnvVersion(String value) ;
        void setEnvVersion(Object value) ;
        
        /**
         * z_processamento
         */
        @Column(name="z_processamento")
        @Key
        @Data(size=10)
        String getZProcessamento() ;
        void setZProcessamento(String value) ;
        void setZProcessamento(Object value) ;
        
        /**
         * c_mnem_egc_opex
         */
        @Column(name="c_mnem_egc_opex")
        @Key
        @Data(size=3)
        String getCMnemEgcOpex() ;
        void setCMnemEgcOpex(String value) ;
        void setCMnemEgcOpex(Object value) ;
        
        
        /**
         * c_pais_isoa_oe_opx
         */
        @Column(name="c_pais_isoa_oe_opx")
        @Key
        @Data(size=3)
        String getCPaisIsoaOeOpx() ;
        void setCPaisIsoaOeOpx(String value) ;
        void setCPaisIsoaOeOpx(Object value) ;
        
        /**
         * c_oe_egc_opex
         */
        @Column(name="c_oe_egc_opex")
        @Key
        @Data(size=4, signed=true)
        int getCOeEgcOpex() ;
        void setCOeEgcOpex(int value) ;
        void setCOeEgcOpex(Object value) ;
        
        /**
         * c_userid
         */
        @Column(name="c_userid")
        @Key
        @Data(size=8)
        String getCUserid() ;
        void setCUserid(String value) ;
        void setCUserid(Object value) ;
        
        /**
         * n_jour_bbn
         */
        @Column(name="n_jour_bbn")
        @Key
        @Data(size=9, signed=true)
        long getNJourBbn() ;
        void setNJourBbn(long value) ;
        void setNJourBbn(Object value) ;        
        
        /**
         * a_aplicacao       
         */
        @Column(name="a_aplicacao")
        @Key
        @Data(size=2)
        String getAAplicacao() ;
        void setAAplicacao(String value) ;
        void setAAplicacao(Object value) ;
        
        /**
         * c_ope_pcnp
         */
        @Column(name="c_ope_pcnp")
        @Key
        @Data(size=5)
        String getCOpePcnp() ;
        void setCOpePcnp(String value) ;
        void setCOpePcnp(Object value) ;
        
        /**
         * c_usex_chav_ope_pcnprid
         */
        @Column(name="x_chav_ope_pcnp")
        @Key
        @Data(size=15)
        String getXChavPpePcnp() ;
        void setXChavPpePcnp(String value) ;
        void setXChavPpePcnp(Object value) ;
        
        /**
         * msg_inp
         */
        @Column(name="msg_inp",type=byte[].class)
        @Data(size=8500)
        String getMsgInp() ;
        void setMsgInp(String value) ;
        void setMsgInp(Object value) ;
        
        /**
         * msg_out
         */
        @Column(name="msg_out",type=byte[].class)
        @Data(size=8500)
        String getMsgOut() ;
        void setMsgOut(String value) ;
        void setMsgOut(Object value) ;
        
        /**
         * to_test
         */
        @Column(name="to_test")
        @Data(size=1)
        String getToTest() ;
        void setToTest(String value) ;
        void setToTest(Object value) ;
    }
    
}
