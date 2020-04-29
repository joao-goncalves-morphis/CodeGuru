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
public abstract class Vwsdghps01501Pedmovhst extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Pedmovhst
     */
    @Data
    public abstract Pedmovhst pedmovhst() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH01501_PEDMOVHST
     * 
     * @version 2.0
     * 
     */
    public interface Pedmovhst extends IDataStruct {
        
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
         * C_PED_INF_OPPS
         */
        @Column(name="C_PED_INF_OPPS")
        @Key
        @Data(size=7)
        IString cPedInfOpps() ;
        
        /**
         * Z_INIC_MOV
         */
        @Column(name="Z_INIC_MOV", type=java.sql.Date.class)
        @Key
        @Data(size=10)
        IString zInicMov() ;
        
        /**
         * Z_FIM_MOV
         */
        @Column(name="Z_FIM_MOV", type=java.sql.Date.class)
        @Key
        @Data(size=10)
        IString zFimMov() ;
        
        /**
         * TS_PEDIDO
         */
        @Column(name="TS_PEDIDO")
        @Data(size=15, signed=true, compression=COMP3)
        ILong tsPedido() ;
        
        /**
         * Z_PEDIDO
         */
        @Column(name="Z_PEDIDO", type=java.sql.Date.class)
        @Data(size=10)
        IString zPedido() ;
        
        /**
         * C_EST_PED_HIST
         */
        @Column(name="C_EST_PED_HIST")
        @Data(size=1)
        IString cEstPedHist() ;
        
        /**
         * C_TIPO_RPTE
         */
        @Column(name="C_TIPO_RPTE")
        @Data(size=1)
        IString cTipoRpte() ;
        
        /**
         * NM_FICH_OUTP_RTNO
         */
        @Column(name="NM_FICH_OUTP_RTNO")
        @Data(size=20)
        IString nmFichOutpRtno() ;
        
        /**
         * A_APL_DEST
         */
        @Column(name="A_APL_DEST")
        @Data(size=2)
        IString aAplDest() ;
        
        /**
         * C_FRMT_INF
         */
        @Column(name="C_FRMT_INF")
        @Data(size=1)
        IString cFrmtInf() ;
        
        /**
         * C_CANL_TRMZ_INF
         */
        @Column(name="C_CANL_TRMZ_INF")
        @Data(size=2)
        IString cCanlTrmzInf() ;
        
        /**
         * C_ENDC_FTP_DEST
         */
        @Column(name="C_ENDC_FTP_DEST")
        @Data(size=15)
        IString cEndcFtpDest() ;
        
        /**
         * Z_CLUZ_PED
         */
        @Column(name="Z_CLUZ_PED", type=java.sql.Date.class)
        @Data(size=10)
        IString zCluzPed() ;
        
        /**
         * Q_DIA_DPNZ_INF
         */
        @Column(name="Q_DIA_DPNZ_INF")
        @Data(size=2, signed=true, compression=COMP3)
        IInt qDiaDpnzInf() ;
        
        /**
         * M_PARM_PED_HST_MAX
         */
        @Column(name="M_PARM_PED_HST_MAX")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mParmPedHstMax() ;
        
        /**
         * M_PARM_PED_HST_MIN
         */
        @Column(name="M_PARM_PED_HST_MIN")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mParmPedHstMin() ;
        
        /**
         * C_PARM_PED_HST_MAX
         */
        @Column(name="C_PARM_PED_HST_MAX")
        @Data(size=15)
        IString cParmPedHstMax() ;
        
        /**
         * C_PARM_PED_HST_MIN
         */
        @Column(name="C_PARM_PED_HST_MIN")
        @Data(size=15)
        IString cParmPedHstMin() ;
        
        /**
         * X_MTVO_DVLZ_PED
         */
        @Column(name="X_MTVO_DVLZ_PED")
        @Data(size=40)
        IString xMtvoDvlzPed() ;
        
        /**
         * Z_ELIMINACAO
         */
        @Column(name="Z_ELIMINACAO", type=java.sql.Date.class)
        @Data(size=10)
        IString zEliminacao() ;
        
        /**
         * C_USID_CRIX
         */
        @Column(name="C_USID_CRIX")
        @Data(size=8)
        IString cUsidCrix() ;
        
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
         * Q_DDBT_PED
         */
        @Column(name="Q_DDBT_PED")
        @Data(size=2, signed=true, compression=COMP3)
        IInt qDdbtPed() ;
        
        /**
         * N_CLI_PED
         */
        @Column(name="N_CLI_PED")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliPed() ;
        
        /**
         * NS_ABRA_CLI_PED
         */
        @Column(name="NS_ABRA_CLI_PED")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCliPed() ;
        
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
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq206a.A35800ActualizaPedidoA35800ActualizaPedido
     * 
     */
    public void updatePghq206a1108() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov() ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq207a.A32000ActPedidoA32000ActPedido
     * 
     */
    public void updatePghq207a1172() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov() ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq290a.A31200ActPedidoA31200ActPedido
     * 
     */
    public void updatePghq290a1034() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov() ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq291a.A31200ActPedidoA31200ActPedido
     * 
     */
    public void updatePghq291a812() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov() ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq292a.A31200ActPedidoA31200ActPedido
     * 
     */
    public void updatePghq292a485() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov() ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Pghq503a.A32000CarregarPedidoA32000CarregarPedido
     * 
     */
    public void insertPghq503a581() {
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"M_PARM_PED_HST_MAX, " +
        	"M_PARM_PED_HST_MIN, " +
        	"C_PARM_PED_HST_MAX, " +
        	"C_PARM_PED_HST_MIN, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":mParmPedHstMax, " +
        	":mParmPedHstMin, " +
        	":cParmPedHstMax, " +
        	":cParmPedHstMin, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "mParmPedHstMax", pedmovhst().mParmPedHstMax() ) ;
        setQueryArgument( "mParmPedHstMin", pedmovhst().mParmPedHstMin() ) ;
        setQueryArgument( "cParmPedHstMax", pedmovhst().cParmPedHstMax() ) ;
        setQueryArgument( "cParmPedHstMin", pedmovhst().cParmPedHstMin() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Pghq506a.A32200InsTabelaPedidosA32200InsTabelaPedidos
     * 
     */
    public void insertPghq506a723() {
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Pghq507a.A32000CarregarPedidoA32000CarregarPedido
     * 
     */
    public void insertPghq507a638() {
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"M_PARM_PED_HST_MAX, " +
        	"M_PARM_PED_HST_MIN, " +
        	"C_PARM_PED_HST_MAX, " +
        	"C_PARM_PED_HST_MIN, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":mParmPedHstMax, " +
        	":mParmPedHstMin, " +
        	":cParmPedHstMax, " +
        	":cParmPedHstMin, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "mParmPedHstMax", pedmovhst().mParmPedHstMax() ) ;
        setQueryArgument( "mParmPedHstMin", pedmovhst().mParmPedHstMin() ) ;
        setQueryArgument( "cParmPedHstMax", pedmovhst().cParmPedHstMax() ) ;
        setQueryArgument( "cParmPedHstMin", pedmovhst().cParmPedHstMin() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Pghq509a.A32200InsTabelaPedidosA32200InsTabelaPedidos
     * 
     */
    public void insertPghq509a750() {
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Pghq520a.A32200InsTabelaPedidosA32200InsTabelaPedidos
     * 
     */
    public void insertPghq520a737() {
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01501_PEDMOVHST
     * called from Pghq480a.A31340ObtemOeOpexA31340ObtemOeOpex
     * 
     */
    public void selectPghq480a519() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01501_PEDMOVHST
     * called from Pghq490a.A32500ObtemClienteA32500ObtemCliente
     * 
     */
    public void selectPghq490a962() {
        sqlSttmt = "SELECT  " +
                "N_CLI_PED," +
                "NS_ABRA_CLI_PED" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().nCliPed().set(getQueryReturnedValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(getQueryReturnedValue("NS_ABRA_CLI_PED")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01501_PEDMOVHST
     * called from Pghq590a.A31730SelectTgh0015A31730SelectTgh0015
     * 
     */
    public void selectPghq590a585() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PARM_PED_HST_MAX," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            pedmovhst().cParmPedHstMax().set(getQueryReturnedValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().zInicMov().set(getQueryReturnedValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(getQueryReturnedValue("Z_FIM_MOV", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq390a.A34000ActPedidoA34000ActPedido
     * 
     */
    public void updatePghq390a830() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq490a.A31500ActPedidoA31500ActPedido
     * 
     */
    public void updatePghq490a921() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq505a.A32000ActPedidoA32000ActPedido
     * 
     */
    public void updatePghq505a1015() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq508a.A32200ActPedidoA32200ActPedido
     * 
     */
    public void updatePghq508a860() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq510a.A31200ActPedidoA31200ActPedido
     * 
     */
    public void updatePghq510a667() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq517a.A32200ActPedidoA32200ActPedido
     * 
     */
    public void updatePghq517a860() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq523a.A32000ActPedidoA32000ActPedido
     * 
     */
    public void updatePghq523a1393() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq524a.A32000ActPedidoA32000ActPedido
     * 
     */
    public void updatePghq524a1003() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq590a.A31500ActPedidoA31500ActPedido
     * 
     */
    public void updatePghq590a688() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq690a.A31500ActPedidoA31500ActPedido
     * 
     */
    public void updatePghq690a639() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Pghq790a.A31500ActPedidoA31500ActPedido
     * 
     */
    public void updatePghq790a628() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov AND " +
                "TS_PEDIDO = :tsPedido" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * Copybooks
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01501_PEDMOVHST
     * called from A32100AcedePedido
     * 
     */
    public void selectBghp001541() {
        sqlSttmt = "SELECT  " +
                "C_EST_PED_HIST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "Z_ELIMINACAO," +
                "Q_DDBT_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cEstPedHist().set(getQueryReturnedValue("C_EST_PED_HIST")) ;
            pedmovhst().zCluzPed().set(getQueryReturnedValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().zEliminacao().set(getQueryReturnedValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().qDdbtPed().set(getQueryReturnedValue("Q_DDBT_PED")) ;
            pedmovhst().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from A32200ActualizaPedido
     * 
     */
    public void updateBghp0015121() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_CLUZ_PED = :zCluzPed, " +
                "Z_ELIMINACAO = :zEliminacao, " +
                "Q_DDBT_PED = :qDdbtPed, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghj202a.A35400CloseCursorC1A35400CloseCursorC1
     * 
     */
    public void closeMghj202a803() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghj202a.A36400CloseCursorC2A36400CloseCursorC2
     * 
     */
    public void closeMghj202a987() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs015a.A5300ListaSubcontaA5300ListaSubconta
     * 
     */
    public void closeMghs015a1109() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C6
     * called from Mghs015a.A5310ListaSubcontaOutrosA5310ListaSubcontaOutros
     * 
     */
    public void closeMghs015a1222() {
        BaseCursorHandler c = getCursor("C6") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs015a.A5400ListaPedidoA5400ListaPedido
     * 
     */
    public void closeMghs015a1336() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C7
     * called from Mghs015a.A5410ListaPedidoOutrosA5410ListaPedidoOutros
     * 
     */
    public void closeMghs015a1449() {
        BaseCursorHandler c = getCursor("C7") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs015a.A5700ConsultaPedidoA5700ConsultaPedido
     * 
     */
    public void closeMghs015a1608() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C8
     * called from Mghs015a.A5810ConsContaEspA5810ConsContaEsp
     * 
     */
    public void closeMghs015a1659() {
        BaseCursorHandler c = getCursor("C8") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C5
     * called from Mghs015a.A5820ConsContaNormalA5820ConsContaNormal
     * 
     */
    public void closeMghs015a1700() {
        BaseCursorHandler c = getCursor("C5") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C9
     * called from Mghs015a.A5900CnsltPedidoActA5900CnsltPedidoAct
     * 
     */
    public void closeMghs015a1741() {
        BaseCursorHandler c = getCursor("C9") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs016a.A5510VerEstPedidoA5510VerEstPedido
     * 
     */
    public void closeMghs016a333() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH01501_PEDMOVHST
     * called from Mghs015a.A5600EliminaA5600Elimina
     * 
     * @param pTsPedido
     */
    public void deleteMghs015a1558(ILong pTsPedido) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "DELETE FROM VWSDGHPS01501_PEDMOVHST " +
            " WHERE " +
                "TS_PEDIDO = :tsPedido AND C_EST_PED_HIST = 'A'"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "tsPedido", pTsPedido ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghj202a.A35200FetchCursorC1A35200FetchCursorC1
     * 
     */
    public void fetchMghj202a710() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghj202a.A36200FetchCursorC2A36200FetchCursorC2
     * 
     */
    public void fetchMghj202a888() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs015a.A5300ListaSubcontaA5300ListaSubconta
     * 
     */
    public void fetchMghs015a1020() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs015a.A5300ListaSubcontaA5300ListaSubconta
     * 
     */
    public void fetchMghs015a1091() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Mghs015a.A5310ListaSubcontaOutrosA5310ListaSubcontaOutros
     * 
     */
    public void fetchMghs015a1133() {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Mghs015a.A5310ListaSubcontaOutrosA5310ListaSubcontaOutros
     * 
     */
    public void fetchMghs015a1204() {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs015a.A5400ListaPedidoA5400ListaPedido
     * 
     */
    public void fetchMghs015a1247() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs015a.A5400ListaPedidoA5400ListaPedido
     * 
     */
    public void fetchMghs015a1318() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C7
     * called from Mghs015a.A5410ListaPedidoOutrosA5410ListaPedidoOutros
     * 
     */
    public void fetchMghs015a1360() {
        BaseCursorHandler c = getCursor("C7") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C7
     * called from Mghs015a.A5410ListaPedidoOutrosA5410ListaPedidoOutros
     * 
     */
    public void fetchMghs015a1431() {
        BaseCursorHandler c = getCursor("C7") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(c.getValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(c.getValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(c.getValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(c.getValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(c.getValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(c.getValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(c.getValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(c.getValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(c.getValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(c.getValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(c.getValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(c.getValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(c.getValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(c.getValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(c.getValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(c.getValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(c.getValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs015a.A5700ConsultaPedidoA5700ConsultaPedido
     * 
     */
    public void fetchMghs015a1591() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C8
     * called from Mghs015a.A5810ConsContaEspA5810ConsContaEsp
     * 
     */
    public void fetchMghs015a1642() {
        BaseCursorHandler c = getCursor("C8") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C5
     * called from Mghs015a.A5820ConsContaNormalA5820ConsContaNormal
     * 
     */
    public void fetchMghs015a1683() {
        BaseCursorHandler c = getCursor("C5") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C9
     * called from Mghs015a.A5900CnsltPedidoActA5900CnsltPedidoAct
     * 
     */
    public void fetchMghs015a1724() {
        BaseCursorHandler c = getCursor("C9") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().tsPedido().set(c.getValue("TS_PEDIDO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs016a.A5510VerEstPedidoA5510VerEstPedido
     * 
     */
    public void fetchMghs016a316() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cEstPedHist().set(c.getValue("C_EST_PED_HIST")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Mghj202a.A34000InsTabelaPedidosA34000InsTabelaPedidos
     * 
     */
    public void insertMghj202a580() {
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01501_PEDMOVHST
     * called from Mghs015a.A5500InsereA5500Insere
     * 
     */
    public void insertMghs015a1461() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "INSERT INTO VWSDGHPS01501_PEDMOVHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"C_PED_INF_OPPS, " +
        	"Z_INIC_MOV, " +
        	"Z_FIM_MOV, " +
        	"TS_PEDIDO, " +
        	"Z_PEDIDO, " +
        	"C_EST_PED_HIST, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"A_APL_DEST, " +
        	"C_FRMT_INF, " +
        	"C_CANL_TRMZ_INF, " +
        	"C_ENDC_FTP_DEST, " +
        	"Z_CLUZ_PED, " +
        	"Q_DIA_DPNZ_INF, " +
        	"M_PARM_PED_HST_MAX, " +
        	"M_PARM_PED_HST_MIN, " +
        	"C_PARM_PED_HST_MAX, " +
        	"C_PARM_PED_HST_MIN, " +
        	"X_MTVO_DVLZ_PED, " +
        	"Z_ELIMINACAO, " +
        	"C_USID_CRIX, " +
        	"C_PAIS_ISOA_OE_OPX, " +
        	"C_MNEM_EGC_OPEX, " +
        	"C_OE_EGC_OPEX, " +
        	"Q_DDBT_PED, " +
        	"N_CLI_PED, " +
        	"NS_ABRA_CLI_PED, " +
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
        	":cPedInfOpps, " +
        	":zInicMov, " +
        	":zFimMov, " +
        	":tsPedido, " +
        	":zPedido, " +
        	":cEstPedHist, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":aAplDest, " +
        	":cFrmtInf, " +
        	":cCanlTrmzInf, " +
        	":cEndcFtpDest, " +
        	":zCluzPed, " +
        	":qDiaDpnzInf, " +
        	":mParmPedHstMax, " +
        	":mParmPedHstMin, " +
        	":cParmPedHstMax, " +
        	":cParmPedHstMin, " +
        	":xMtvoDvlzPed, " +
        	":zEliminacao, " +
        	":cUsidCrix, " +
        	":cPaisIsoaOeOpx, " +
        	":cMnemEgcOpex, " +
        	":cOeEgcOpex, " +
        	":qDdbtPed, " +
        	":nCliPed, " +
        	":nsAbraCliPed, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        setQueryArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        setQueryArgument( "zPedido", pedmovhst().zPedido(), java.sql.Date.class ) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "cTipoRpte", pedmovhst().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedmovhst().nmFichOutpRtno() ) ;
        setQueryArgument( "aAplDest", pedmovhst().aAplDest() ) ;
        setQueryArgument( "cFrmtInf", pedmovhst().cFrmtInf() ) ;
        setQueryArgument( "cCanlTrmzInf", pedmovhst().cCanlTrmzInf() ) ;
        setQueryArgument( "cEndcFtpDest", pedmovhst().cEndcFtpDest() ) ;
        setQueryArgument( "zCluzPed", pedmovhst().zCluzPed(), java.sql.Date.class ) ;
        setQueryArgument( "qDiaDpnzInf", pedmovhst().qDiaDpnzInf() ) ;
        setQueryArgument( "mParmPedHstMax", pedmovhst().mParmPedHstMax() ) ;
        setQueryArgument( "mParmPedHstMin", pedmovhst().mParmPedHstMin() ) ;
        setQueryArgument( "cParmPedHstMax", pedmovhst().cParmPedHstMax() ) ;
        setQueryArgument( "cParmPedHstMin", pedmovhst().cParmPedHstMin() ) ;
        setQueryArgument( "xMtvoDvlzPed", pedmovhst().xMtvoDvlzPed() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidCrix", pedmovhst().cUsidCrix() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "qDdbtPed", pedmovhst().qDdbtPed() ) ;
        setQueryArgument( "nCliPed", pedmovhst().nCliPed() ) ;
        setQueryArgument( "nsAbraCliPed", pedmovhst().nsAbraCliPed() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghj202a.A35100OpenCursorC1A35100OpenCursorC1
     * 
     */
    public void openMghj202a695() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "C_PED_INF_OPPS," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV," +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "A_APL_DEST," +
                "C_FRMT_INF," +
                "C_CANL_TRMZ_INF," +
                "C_ENDC_FTP_DEST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "M_PARM_PED_HST_MAX," +
                "M_PARM_PED_HST_MIN," +
                "C_PARM_PED_HST_MAX," +
                "C_PARM_PED_HST_MIN," +
                "X_MTVO_DVLZ_PED," +
                "Z_ELIMINACAO," +
                "C_USID_CRIX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "Q_DDBT_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND TS_PEDIDO = :tsPedido"  ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        c.setArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghj202a.A36100OpenCursorC2A36100OpenCursorC2
     * 
     */
    public void openMghj202a872() {
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "Z_ELIMINACAO," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.setArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        c.setArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        c.setArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs015a.A5300ListaSubcontaA5300ListaSubconta
     * 
     */
    public void openMghs015a1008() {
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
                "C_PED_INF_OPPS," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV," +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "A_APL_DEST," +
                "C_FRMT_INF," +
                "C_CANL_TRMZ_INF," +
                "C_ENDC_FTP_DEST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "M_PARM_PED_HST_MAX," +
                "M_PARM_PED_HST_MIN," +
                "C_PARM_PED_HST_MAX," +
                "C_PARM_PED_HST_MIN," +
                "X_MTVO_DVLZ_PED," +
                "Z_ELIMINACAO," +
                "C_USID_CRIX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "Q_DDBT_PED," +
                "N_CLI_PED," +
                "NS_ABRA_CLI_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_PEDIDO > :tsPedido" +
            " ORDER BY " +
                "TS_PEDIDO ASC" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.setArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C6
     * called from Mghs015a.A5310ListaSubcontaOutrosA5310ListaSubcontaOutros
     * 
     */
    public void openMghs015a1121() {
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
                "C_PED_INF_OPPS," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV," +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "A_APL_DEST," +
                "C_FRMT_INF," +
                "C_CANL_TRMZ_INF," +
                "C_ENDC_FTP_DEST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "M_PARM_PED_HST_MAX," +
                "M_PARM_PED_HST_MIN," +
                "C_PARM_PED_HST_MAX," +
                "C_PARM_PED_HST_MIN," +
                "X_MTVO_DVLZ_PED," +
                "Z_ELIMINACAO," +
                "C_USID_CRIX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "Q_DDBT_PED," +
                "N_CLI_PED," +
                "NS_ABRA_CLI_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "(C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO > :tsPedido" +
            " ORDER BY " +
                "TS_PEDIDO ASC" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C6", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.setArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs015a.A5400ListaPedidoA5400ListaPedido
     * 
     */
    public void openMghs015a1235() {
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
                "C_PED_INF_OPPS," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV," +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "A_APL_DEST," +
                "C_FRMT_INF," +
                "C_CANL_TRMZ_INF," +
                "C_ENDC_FTP_DEST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "M_PARM_PED_HST_MAX," +
                "M_PARM_PED_HST_MIN," +
                "C_PARM_PED_HST_MAX," +
                "C_PARM_PED_HST_MIN," +
                "X_MTVO_DVLZ_PED," +
                "Z_ELIMINACAO," +
                "C_USID_CRIX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "Q_DDBT_PED," +
                "N_CLI_PED," +
                "NS_ABRA_CLI_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT > :cPaisIsoaCont) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT > :cBancCont) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT > :cOeEgcCont) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT > :nsRdclCont) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT > :vChkdCont) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT > :cTipoCont) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA > :cMoedIsoScta) OR " +
                "(TS_PEDIDO = :tsPedido AND C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO > :nsDeposito)" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C7
     * called from Mghs015a.A5410ListaPedidoOutrosA5410ListaPedidoOutros
     * 
     */
    public void openMghs015a1348() {
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
                "C_PED_INF_OPPS," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV," +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "A_APL_DEST," +
                "C_FRMT_INF," +
                "C_CANL_TRMZ_INF," +
                "C_ENDC_FTP_DEST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "M_PARM_PED_HST_MAX," +
                "M_PARM_PED_HST_MIN," +
                "C_PARM_PED_HST_MAX," +
                "C_PARM_PED_HST_MIN," +
                "X_MTVO_DVLZ_PED," +
                "Z_ELIMINACAO," +
                "C_USID_CRIX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "Q_DDBT_PED," +
                "N_CLI_PED," +
                "NS_ABRA_CLI_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT > :cPaisIsoaCont) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT > :cBancCont) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT > :cOeEgcCont) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT > :nsRdclCont) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT > :vChkdCont) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT > :cTipoCont) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA > :cMoedIsoScta) OR " +
                "((C_OE_EGC_OPEX < '9200' OR C_OE_EGC_OPEX > '9299') AND " +
                "TS_PEDIDO = :tsPedido AND " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO > :nsDeposito)" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C7", sqlSttmt) ;
        c.setArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs015a.A5700ConsultaPedidoA5700ConsultaPedido
     * 
     */
    public void openMghs015a1579() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C8
     * called from Mghs015a.A5810ConsContaEspA5810ConsContaEsp
     * 
     * @param pWsZaInicMov
     */
    public void openMghs015a1630(IInt pWsZaInicMov) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "date_part('year', Z_INIC_MOV) <= :wsZaInicMov AND " +
                "(C_EST_PED_HIST = 'A' OR C_EST_PED_HIST = 'E')" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C8", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.setArgument( "wsZaInicMov", pWsZaInicMov ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C5
     * called from Mghs015a.A5820ConsContaNormalA5820ConsContaNormal
     * 
     * @param pWsZaInicMov
     */
    public void openMghs015a1671(IInt pWsZaInicMov) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "date_part('year', Z_INIC_MOV) = :wsZaInicMov AND " +
                "(C_EST_PED_HIST = 'A' OR C_EST_PED_HIST = 'E')" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C5", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        c.setArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        c.setArgument( "wsZaInicMov", pWsZaInicMov ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C9
     * called from Mghs015a.A5900CnsltPedidoActA5900CnsltPedidoAct
     * 
     */
    public void openMghs015a1712() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_PEDIDO" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps AND C_EST_PED_HIST = 'A'"  +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C9", sqlSttmt) ;
        c.setArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs016a.A5510VerEstPedidoA5510VerEstPedido
     * 
     */
    public void openMghs016a304() {
        sqlSttmt = "SELECT  " +
                "C_EST_PED_HIST" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "TS_PEDIDO = :tsPedido AND C_EST_PED_HIST = 'A' AND " +
                "(C_TIPO_RPTE = 'M' OR C_FRMT_INF = 'X')" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "tsPedido", pedmovhst().tsPedido() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01501_PEDMOVHST
     * called from Mghs015a.A5200ConsultaA5200Consulta
     * 
     */
    public void selectMghs015a888() {
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
                "C_PED_INF_OPPS," +
                "Z_INIC_MOV," +
                "Z_FIM_MOV," +
                "TS_PEDIDO," +
                "Z_PEDIDO," +
                "C_EST_PED_HIST," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "A_APL_DEST," +
                "C_FRMT_INF," +
                "C_CANL_TRMZ_INF," +
                "C_ENDC_FTP_DEST," +
                "Z_CLUZ_PED," +
                "Q_DIA_DPNZ_INF," +
                "M_PARM_PED_HST_MAX," +
                "M_PARM_PED_HST_MIN," +
                "C_PARM_PED_HST_MAX," +
                "C_PARM_PED_HST_MIN," +
                "X_MTVO_DVLZ_PED," +
                "Z_ELIMINACAO," +
                "C_USID_CRIX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_MNEM_EGC_OPEX," +
                "C_OE_EGC_OPEX," +
                "Q_DDBT_PED," +
                "N_CLI_PED," +
                "NS_ABRA_CLI_PED," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS01501_PEDMOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_PED_INF_OPPS = :cPedInfOpps AND " +
                "Z_INIC_MOV = :zInicMov AND " +
                "Z_FIM_MOV = :zFimMov" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pedmovhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pedmovhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pedmovhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pedmovhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pedmovhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pedmovhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pedmovhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pedmovhst().nsDeposito() ) ;
        setQueryArgument( "cPedInfOpps", pedmovhst().cPedInfOpps() ) ;
        setQueryArgument( "zInicMov", pedmovhst().zInicMov(), java.sql.Date.class ) ;
        setQueryArgument( "zFimMov", pedmovhst().zFimMov(), java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedmovhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            pedmovhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            pedmovhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            pedmovhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            pedmovhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            pedmovhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            pedmovhst().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            pedmovhst().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            pedmovhst().cPedInfOpps().set(getQueryReturnedValue("C_PED_INF_OPPS")) ;
            pedmovhst().zInicMov().set(getQueryReturnedValue("Z_INIC_MOV", String.class)) ;
            pedmovhst().zFimMov().set(getQueryReturnedValue("Z_FIM_MOV", String.class)) ;
            pedmovhst().tsPedido().set(getQueryReturnedValue("TS_PEDIDO")) ;
            pedmovhst().zPedido().set(getQueryReturnedValue("Z_PEDIDO", String.class)) ;
            pedmovhst().cEstPedHist().set(getQueryReturnedValue("C_EST_PED_HIST")) ;
            pedmovhst().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedmovhst().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedmovhst().aAplDest().set(getQueryReturnedValue("A_APL_DEST")) ;
            pedmovhst().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedmovhst().cCanlTrmzInf().set(getQueryReturnedValue("C_CANL_TRMZ_INF")) ;
            pedmovhst().cEndcFtpDest().set(getQueryReturnedValue("C_ENDC_FTP_DEST")) ;
            pedmovhst().zCluzPed().set(getQueryReturnedValue("Z_CLUZ_PED", String.class)) ;
            pedmovhst().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
            pedmovhst().mParmPedHstMax().set(getQueryReturnedValue("M_PARM_PED_HST_MAX")) ;
            pedmovhst().mParmPedHstMin().set(getQueryReturnedValue("M_PARM_PED_HST_MIN")) ;
            pedmovhst().cParmPedHstMax().set(getQueryReturnedValue("C_PARM_PED_HST_MAX")) ;
            pedmovhst().cParmPedHstMin().set(getQueryReturnedValue("C_PARM_PED_HST_MIN")) ;
            pedmovhst().xMtvoDvlzPed().set(getQueryReturnedValue("X_MTVO_DVLZ_PED")) ;
            pedmovhst().zEliminacao().set(getQueryReturnedValue("Z_ELIMINACAO", String.class)) ;
            pedmovhst().cUsidCrix().set(getQueryReturnedValue("C_USID_CRIX")) ;
            pedmovhst().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            pedmovhst().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            pedmovhst().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            pedmovhst().qDdbtPed().set(getQueryReturnedValue("Q_DDBT_PED")) ;
            pedmovhst().nCliPed().set(getQueryReturnedValue("N_CLI_PED")) ;
            pedmovhst().nsAbraCliPed().set(getQueryReturnedValue("NS_ABRA_CLI_PED")) ;
            pedmovhst().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            pedmovhst().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Mghj202a.A35300AnulaPedidoTgh15A35300AnulaPedidoTgh15
     * 
     */
    public void updateMghj202a778() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_ELIMINACAO = :zEliminacao, " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx, " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex, " +
                "C_OE_EGC_OPEX = :cOeEgcOpex, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "CURRENT OF MGHJ202A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Mghj202a.A36300AnulaPedidoTgh15A36300AnulaPedidoTgh15
     * 
     */
    public void updateMghj202a926() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_ELIMINACAO = :zEliminacao, " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx, " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex, " +
                "C_OE_EGC_OPEX = :cOeEgcOpex, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "CURRENT OF MGHJ202A_C2"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH01501_PEDMOVHST
     * called from Mghj202a.A36500ActPedidoTgh15A36500ActPedidoTgh15
     * 
     */
    public void updateMghj202a962() {
        sqlSttmt = "UPDATE VWSDGHPS01501_PEDMOVHST " +
            "SET C_EST_PED_HIST = :cEstPedHist, " +
                "Z_ELIMINACAO = :zEliminacao, " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx, " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex, " +
                "C_OE_EGC_OPEX = :cOeEgcOpex, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "CURRENT OF MGHJ202A_C2"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cEstPedHist", pedmovhst().cEstPedHist() ) ;
        setQueryArgument( "zEliminacao", pedmovhst().zEliminacao(), java.sql.Date.class ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pedmovhst().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cMnemEgcOpex", pedmovhst().cMnemEgcOpex() ) ;
        setQueryArgument( "cOeEgcOpex", pedmovhst().cOeEgcOpex() ) ;
        setQueryArgument( "cUsidActzUlt", pedmovhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
}
